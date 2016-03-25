Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.RegionComboRegister=Ext.extend(Ext.form.ComboBox,{
			id:'regioncomboregister',
			initComponent:function(){
				var comboTree=new Ext.tree.TreePanel({
						border : false,
				 		loader : new Ext.tree.TreeLoader({
							dataUrl : 'main/region.html?action=getRegionForRegister'
						}),
						root : new Ext.tree.AsyncTreeNode( {
							id:'combroot',
							text : '云南省[<font color=green>双击选择节点</font>]',
							expanded : true
						}),
						listeners:{
							'click':function(node){
								if(node.isLeaf()){
						 			Ext.ux.Toast.msg("提示","该级别节点已经是最底层行政区划节点！");
						 			return;
						 		}
						 		if(node.id!="combroot"&&node.childNodes.length<=0){
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
								if(node.id=="combroot"||node.firstChild!=null){
//									Ext.getCmp("reregionStr").setValue("云南省");
//									Ext.getCmp("region").setValue("0,");
									Ext.ux.Toast.msg("提示","此地区不能选择！");
								}else{
									Ext.Ajax.request({
										url:"main/region.html?action=getRegionStr",
										success:function(resp){
											var result=Ext.util.JSON.decode(resp.responseText);
											Ext.getCmp("beforeregionStr").setValue(result.str);
											Ext.getCmp("beforeregion").setValue(result.idstr);
											Ext.getCmp("unitid").setValue(result.regionstr);
										},
										failure:function(){
											Ext.Msg.alert("提示","<font color=red>与服务器通讯失败!</font>")
										},
										params:{
											nodeid:node.id
										}
									});
								}
								Ext.getCmp("beforeregionStr").collapse();
							}
						}
				})
				Ext.apply(this,{
					id:'regioncomboregister',
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px"><div id="combotree"></div></div></tpl>',   
		   			selectedClass:'',   
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.RegionComboRegister.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
   					comboTree.render('combotree'); 
   					comboTree.expandAll();
  				}); 
 			}
});
Ext.reg("rrcombo",Ynzc.manage.RegionComboRegister)