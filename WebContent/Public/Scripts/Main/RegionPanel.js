Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.RegionPanel=Ext.extend(Ext.tree.TreePanel,{
		id:'regionpanel',
		 initComponent:function(){
		 	Ext.apply(this,{
		 		autoScroll:true,
		 		loader : new Ext.tree.TreeLoader({
										dataUrl : 'main/region.html?action=getRegion'
									}),
				root : new Ext.tree.AsyncTreeNode( {
					id:'root',
					text : '云南省',
					expanded : true
				}) 
		 	});
		 	Ynzc.manage.RegionPanel.superclass.initComponent.apply(this,arguments);
		 	this.on("click",function(node){
		 		if(node.isLeaf()){
		 			Ext.ux.Toast.msg("提示","该级别节点已经是最底层行政区划节点！");
		 			return;
		 		}
		 		if(node.id!="root"&&node.childNodes.length<=0){
		 			Ext.Ajax.request({
		 				url:"main/region.html?action=getChild",
		 				success:function(resp){
		 					if(resp.responseText=="{[]}"){
		 						return;
		 					}
		 					var child=Ext.util.JSON.decode(resp.responseText);
		 					for(i=0;i<child.data.length;i++){		 
		 						node.appendChild(new Ext.tree.TreeNode({id:child.data[i].id,text:child.data[i].text,leaf:child.data[i].leaf}));		 						
		 					}
		 				},
		 				failure:function(){
		 					Ext.Msg.alert("提示","<font color=red>加载子节点失败!</font>")
		 				},
		 				params:{
		 					fatherid:node.id
		 				}
		 			});
		 		}
		 	});
		 	this.on("contextmenu",function(node,event){
		 	   node.select();    event.preventDefault(); if(Ext.getCmp('rightmenu')!=null){
                     Ext.getCmp('rightmenu').destroy();                                   
               }
               var rightMenu=new Ext.menu.Menu({
                         id:'rightmenu',
                         items:[{
                             id:'addFun',
                             iconCls:'icon-Add',
                             text:'在<font color=red>'+node.text+'</font>下建立新行政区域节点',
                             handler:function(){
                                 if(node.isLeaf()){
                                     Ext.ux.Toast.msg("提示","该级别下不可以建立行政区域节点！");
                                     return;
                                 }
                                 if(Ext.getCmp("addRegion")!=null){
                                     Ext.getCmp("addRegion").destroy();
                                 }
                                 new Ext.Window({
                                     id:'addRegion',
                                     title:"添加行政区域节点",
                                     iconCls:"icon-Add",
                                     width:200,
                                     height:177,
                                     resizable:false,
                                     modal:true,
                                     layout:'form',
                                     labelWidth:55,
                   					 bodyStyle:'padding：2px 2px',
                                     items:[{
                                         id:"cityname",
                                         fieldLabel:"区域名称",
                                         xtype:'textfield',
                                         anchor:'98%'
                                     },{
                                         id:'citycode',
                                         fieldLabel:"行政代码",
                                         xtype:"textfield",
                                         anchor:'98%'
                                     },{
                                         id:'cityno',
                                         fieldLabel:'电话区号',
                                         xtype:"textfield",
                                         anchor:'98%'
                                     },{
                                         id:'citypost',
                                         fieldLabel:'邮政编码',
                                         xtype:"textfield",
                                         anchor:'98%'
                                     }],
                                     buttons:[{text:"保存",handler:function(){
                                         if(Ext.getCmp("cityname").getValue()==""){
                                             Ext.ux.Toast.msg("提示","未填写区域名称");
                                             return;
                                         }
                                         if(Ext.getCmp("citycode").getValue()==""){
                                             Ext.ux.Toast.msg("提示","未填写行政代码");
                                             return;
                                         }
                                         if(Ext.getCmp("cityno").getValue()==""){
                                             Ext.ux.Toast.msg("提示","未填写电话区号");
                                             return;
                                         }
                                         if(Ext.getCmp("citypost").getValue()==""){
                                             Ext.ux.Toast.msg("提示","未填写邮政编码");
                                             return;
                                         }
                                         Ext.Ajax.request({               
                                             url:"main/region.html?action=addRegionNode",
                                             method:'post',
                                             success:function(resp){
                                                 var back=Ext.util.JSON.decode(resp.responseText);
                                                 Ext.ux.Toast.msg("提示","添加成功。");
                                                 node.appendChild(new Ext.tree.TreeNode({id:back.newID,text:Ext.getCmp("cityname").getValue(),leaf:back.isleaf}));
                                                 Ext.getCmp('addRegion').close();
                                             },
                                             failure:function(){
                                                 Ext.Msg.alert("提示","<font color=red>与服务器通讯失败!</font>");
                                             },
                                             params:{
                                                 cityname:Ext.getCmp("cityname").getValue(),
                                                 citycode:Ext.getCmp("citycode").getValue(),
                                                 cityno:Ext.getCmp("cityno").getValue(),
                                                 citypost:Ext.getCmp("citypost").getValue(),
                                                 nodeid:node.id
                                             }
                                         });
                                     }},{text:"取消",handler:function(){
                                         Ext.getCmp('addRegion').close();
                                     }}]
                                 }).show(Ext.getCmp('addFun').getEl());
                             }
                         },{
                             id:'delFun',
                             iconCls:'icon-Del',
                             text:'删除<font color=red>'+node.text+'</font>及其所有下属节点',
                             handler:function(){
                                 if(node.id=="root"){
                                     Ext.ux.Toast.msg("提示","根节点不允许删除！");
                                     return;
                                 }
                                 Ext.Msg.show({
                                     title:'系统确认',
                                     msg:'你是否确认删除此节点，删除后将无法恢复！',
                                     buttons:Ext.Msg.YESNO,
                                     scope:this,
                                     icon : Ext.MessageBox.QUESTION,
                                     fn:function(btn){
                                         if(btn=="yes"){
                                             if(node.isLeaf()){
                                                 Ext.Ajax.request({
                                                     url:'main/region.html?action=delRegionNode',
                                                     method:"post",
                                                     success:function(){
                                                         Ext.ux.Toast.msg("提示","删除成功。");
                                                         this.getRootNode().removeChild(node);
                                                     },
                                                     failure:function(){
                                                         Ext.Msg.alert("提示","<font color=red>与服务器通讯失败!</font>");
                                                     },
                                                     params:{
                                                         nodeid : node.id,
                                                         isleaf : node.isLeaf()
                                                     }
                                                 });
                                             }else{
                                                 Ext.Msg.show({
                                                     title:'系统确认',
                                                     msg:"检测到该节点下还有子节点，是否删除该节点下的所有节点？",
                                                     buttons:Ext.Msg.YESNO,
                                                     scope:this,
                                                     icon : Ext.MessageBox.QUESTION,
                                                     fn:function(btn){
                                                         if(btn=="yes"){
                                                             Ext.Ajax.request({
                                                                 url:'main/region.html?action=delRegionNode',
                                                                 method:"post",
                                                                 success:function(){
                                                                     Ext.ux.Toast.msg("提示","删除成功。");
                                                                     Ext.getCmp("regionMgr").getRootNode().removeChild(node);
                                                                 },
                                                                 failure:function(){
                                                                     Ext.Msg.alert("提示","<font color=red>与服务器通讯失败!</font>");
                                                                 },
                                                                 params:{
                                                                     nodeid : node.id,
                                                                     isleaf : node.isLeaf()
                                                                 }
                                                             });
                                                         }
                                                     }
                                                 });
                                             }
                                         }
                                     }
                                 })
                             }
                         }]
               });
               rightMenu.showAt(event.getPoint());
		 	});
		 }
});
Ext.reg("regionpanel",Ynzc.manage.RegionPanel);