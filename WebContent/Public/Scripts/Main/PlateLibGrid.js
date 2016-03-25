Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateLibGrid=Ext.extend(Ext.Panel,{
		id:"platelibgrid",
		initComponent:function(){
			var plateReader=new Ext.data.JsonReader({
		        totalProperty:"totalCount",
		        root:"data",
		        autoLoad:true,
		        fields:[{
		            name : 'id'
		        },{
		            name : 'platenum'
		        },{
		            name : 'platehead'
		        },{
		            name : 'status'
		        },{
		            name : 'regionid'
		        }]
		    });
	 		
			var plateDs=new Ext.data.Store({
		        scopte:this,
		        url:'main/plate.html?action=getPlateLibListInfo',
		        reader:plateReader,
		        sortInfo:{
		            field:'id',
		            direction:'ASC'
		        }
		    });
			var cm=new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
				header:'号牌号码',
				sortable:true,
				dataIndex:"platenum"
			},{
				header:'号牌前缀',
				sortable:true,
				dataIndex:"platehead"
			},{
				header:'号牌状态',
				sortable:true,
				dataIndex:"status",
				renderer:function(value){
				if(value==0){return "<font color=blue>未使用</font>"};
				if(value ==3){return "<font color=green>已使用</font>"};
				if(value ==4){return "<font color=blue>补牌</font>"};
				if(value ==5){return "<font color=red>报废</font>"};
				if(value ==6){return "<font color=blue>补换</font>"};
				if(value ==7){return "<font color=blue>已转移</font>"};
				if(value >=10){return "<font color=blue>制作中</font>"};
			}
			}]);
			Ynzc.manage.dataGrid=new Ext.grid.GridPanel({
				id:"dataGrid",
				plain:true,
				border:false,
				width:370,
				height:200,
				autoScroll:true,
				cm:cm,
                 sm:new Ext.grid.CheckboxSelectionModel(),
                 frame:true,
                 store:plateDs,
                 loadMask:true,
                 viewConfig:{
                     forceFit:true
                 	},
                 plugins:new Ext.ux.grid.Search({
                            width:200,
                            iconCls:false
                        }),
                 tbar:[
//                    {
//                	 text:"分配",
//                	 iconCls:"icon-complate",
//                	 handler:function(){
//                	 var selections=Ynzc.manage.dataGrid.selModel.getSelections();
//                     var n=selections.length;
//                     if(n==0){
//                    	
//                         var platebatchwin = new Ynzc.manage.PlateLibGridBatchWin();
////                         Ext.getCmp("platehead").setValue(selections[0].data.platehead);
//                         platebatchwin.show();
//                         
//                         return;
//                     }
//                     Ynzc.manage.rds =[];
//                     for (i = 0; i < n; i++) {
//                         var carcheckjson = "{id:" + selections[i].data.id + ",platenum:'" + selections[i].data.platenum + "',platehead:'" + selections[i].data.platehead + "',status:" + selections[i].data.status+",unitid:"+selections[i].data.unitid+"}";
//                         Ynzc.manage.rds.push(carcheckjson);
//                     }
//                     var plateWin = new Ynzc.manage.PlateLibGridWin();
//                     plateWin.show();
//                 	}
//                 },
					{
					 id:"findPlateBtn",
                	 text:"查询",
                	 iconCls:"icon-complate",
                	 handler:function(){
						new Ext.Window({
							id:"plateFindWin",
							title:"查找一批号牌",
							iconCls:"icon-plateadd",
							modal:true,
							height:125,
							width:200,
							layout:"form",
							labelWidth:55,
							bodyStyle:"padding:5px 5px",
							items:[{
                              id:"start",
                              fieldLabel:"起始号码",
                              xtype:"textfield",
                              anchor:'98%'
                            },{
                              id:"end",
                              fieldLabel:"结束号码",
                              xtype:"textfield",
                              anchor:'98%'
                          }],
                          buttons:[{text:"开始查找",handler:function(){
                                 if(checkFlapper(Ext.getCmp("start").getValue())==false){
                                      Ext.MessageBox.alert("提示","填写起始号码有误.");
                                      return;
                                 }  
                                 if(checkFlapper(Ext.getCmp("end").getValue())==false){
                                      Ext.MessageBox.alert("提示","填写结束号码有误.");
                                      return;
                                 }      
                                 if(isNaN(Ext.getCmp("start").getValue())){
                                      Ext.MessageBox.alert("提示","填写数字型数值.");
                                      return;
                                 }  
                                 if(isNaN(Ext.getCmp("end").getValue())){
                                      Ext.MessageBox.alert("提示","填写数字型数值.");
                                      return;
                                 }  
                                 if(Ext.getCmp("start").getValue()>Ext.getCmp("end").getValue()){
                                 	  Ext.MessageBox.alert("提示","起始号不能大于结束号.");
                                      return;
                                 }
                                 if(parseInt(Ext.getCmp("end").getValue())-parseInt(Ext.getCmp("start").getValue())>=20){
                                	  Ext.MessageBox.alert("提示","一次只能查询20个以内的号牌。");
                                     return;
                                }
                                 var mask = new Ext.LoadMask(Ext.getBody(), {
							     		msg : '正在生成,请稍等...',
							     		removeMask:true
							     });
                                 mask.show();
//                                 Ext.Ajax.request({
//                                	 url:"main/plate.html?action=findPlateBat",
//                                	 timeout:600000,
//                                	 success:function(){                              	 
                                	 var newStore=new Ext.data.Store({
                         		        scopte:this,
                         		        url:'main/plate.html?action=findPlateBat',
                         		        reader:plateReader,
                         		        sortInfo:{
                         		            field:'id',
                         		            direction:'ASC'
                         		        }
                         		    });
                                	 mask.hide();
                                	 Ynzc.manage.dataGrid.reconfigure(newStore,cm);
                                	 newStore.load({
                                		 params:{
                                    	 startnum:Ext.getCmp("start").getValue(),
                                    	 endnum:Ext.getCmp("end").getValue(),
                                    	 start:0,
                         				 limit:20
                                     }
                                	 });
//                                 },
//                                 failure:function(){
//                                	 Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
//                                 },
//                                 params:{
//                                	 startnum:Ext.getCmp("start").getValue(),
//                                	 endnum:Ext.getCmp("end").getValue(),
//                                	 start:0,
//                     				 limit:20
//                                 }
//                                 }); 
                               	 Ext.getCmp('plateFindWin').close();  
                          }},{text:"取消",handler:function(){
                                 Ext.getCmp("plateFindWin").close();
                          }}]
						}).show(Ext.getCmp("findPlateBtn").getEl());			
						}
					},
                 	{
                	 text:"号牌维护",
                	 iconCls:"icon-Permissions",
                	 handler:function(){
                	 	var selections = Ynzc.manage.dataGrid.selModel.getSelections();
                	 	var n = selections.length;
                	 	if(n==0){
                	 		 Ext.MessageBox.alert("提示","请选中要维护的号牌!");
                             return;
                	 	}
                	 	Ynzc.manage.rds =[];
                	 	for(i = 0;i<n;i++){
                	 		var carcheckjson = "{id:" + selections[i].data.id + ",platenum:'" + selections[i].data.platenum + "',platehead:'" + selections[i].data.platehead + "',status:" + selections[i].data.status+",regionid:'"+selections[i].data.regionid+"'}";
                	 		Ynzc.manage.rds.push(carcheckjson);
                	 	}
                	 	
                	 	var plateMaintainWin = new Ynzc.manage.PlateMaintainWin();
                	 	plateMaintainWin.show();
                	 	Ext.getCmp("plateNumber").setValue(selections[0].data.platehead+"."+selections[0].data.platenum);
                 	}
                 }],
                 bbar:new Ext.PagingToolbar({
                     pageSize:20,
                     store:plateDs,
                     displayInfo:true,
                     displayMsg : '共 {2} 条',
                     emptyMsg : '无记录'
                 })
			});
	
			Ext.apply(this,{
				layout:'border',
				items:[{
					region:"west",
					xtype:"treepanel",
					autoScroll:true,
					collapsible :true,
					collapseMode:'mini',
					split:true,
					border : false,
					lines : false,
					loader : new Ext.tree.TreeLoader(
							{
								dataUrl : 'main/unitManage.html?action=getUnitTree',
								listeners : {
									"beforeload" : function(treeLoader,node) {
										treeLoader.baseParams.id = (node.id != "root" ? node.id: "");
									}
								}
							}),
					root : new Ext.tree.AsyncTreeNode( {
						id : 'root',
						text : '云南省农机安全监理总站',
						expanded : true
					}),
					listeners:{
						"click":function(node){
						   plateDs.baseParams.untilid = node.id;
							plateDs.load({
								params:{
								start:0,
								limit:20
								}	
							})
						}
					},
					width:250
				},{
					region:"center",
					layout:"fit",
					border:false,
					items:Ynzc.manage.dataGrid
				}]
				
			});
			
			Ynzc.manage.PlateLibGrid.superclass.initComponent.apply(this,arguments);
			plateDs.load({
				params:{
				untilid:-1,
				start:0,
				limit:20
			}
			});
		}
});
Ext.reg("platelibgrid",Ynzc.manage.PlateLibGrid);