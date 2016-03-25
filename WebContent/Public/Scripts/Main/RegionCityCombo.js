Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.RegionCityCombo=Ext.extend(Ext.form.ComboBox,{
			id:'regioncitycombo',
			initComponent:function(){
				var comboTree=new Ext.tree.TreePanel({
						border : false,
				 		loader : new Ext.tree.TreeLoader({
							dataUrl : 'main/region.html?action=getCityRegion'
						}),
						root : new Ext.tree.AsyncTreeNode( {
							id:'comcitybroot',
							text : '云南省[<font color=green>双击选择节点</font>]',
							expanded : true
						}),
						listeners:{
							'click':function(node){
								if(node.isLeaf()){
						 			Ext.ux.Toast.msg("提示","该级别节点已经是最底层行政区划节点！");
						 			return;
						 		}
						 		if(node.id!="comcitybroot"&&node.childNodes.length<=0){
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
							},
							'dblclick':function(node){
								if(node.id=="comcitybroot"||node.firstChild!=null){
//									Ext.getCmp("str").setValue("云南省");
//									Ext.getCmp("value").setValue("0,");
									Ext.ux.Toast.msg("提示","此地区不能选择！");
								}else{
									Ext.Ajax.request({
										url:"main/region.html?action=getRegionStr",
										success:function(resp){
											var result=Ext.util.JSON.decode(resp.responseText);
											Ext.getCmp("regionStr").setValue(result.str);
											Ext.getCmp("regionvalue").setValue(result.idstr);
										},
										failure:function(){
											Ext.Msg.alert("提示","<font color=red>与服务器通讯失败!</font>")
										},
										params:{
											nodeid:node.id
										}
									});
								}
								Ext.getCmp("regionStr").collapse();
							}
						}
				})
				Ext.apply(this,{
					id:'regioncitycombo',
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px"><div id="combocitytree"></div></div></tpl>',   
		   			selectedClass:'',   
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.RegionCityCombo.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
   					comboTree.render('combocitytree'); 
   					comboTree.expandAll();
  				}); 
 			}
});
Ext.reg("rccombo",Ynzc.manage.RegionCityCombo)