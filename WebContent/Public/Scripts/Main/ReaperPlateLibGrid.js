Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReaperPlateLibGrid=Ext.extend(Ext.Panel,{
		id:"reaperplatelibgrid",
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
		            name : 'unitid'
		        }]
		    });
			
			var plateDs=new Ext.data.Store({
		        scopte:this,
		        url:'main/reaperPlate.html?action=getPlateLibListInfo',
		        reader:plateReader,
		        sortInfo:{
		            field:'id',
		            direction:'ASC'
		        }
		    });
	
			Ynzc.manage.dataGrid=new Ext.grid.GridPanel({
				id:"dataGrid",
				 plain:true,
                 border:false,
                 width:370,
                 height:200,
                 autoScroll:true,
                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
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
                 		if(value==0){return "<font color=blue>省级已入库待分配</font>"};
                 		if(value==1){return "<font color=blue>市级已入库待分配</font>"};
                 		if(value ==2){return "<font color=blue>已分配待使用</font>"};
                 		if(value ==3){return "<font color=green>已使用</font>"};
                 		if(value ==4){return "<font color=blue>补牌</font>"};
                 		if(value ==5){return "<font color=red>报废</font>"};
                 		if(value ==6){return "<font color=blue>补换</font>"};
                 		if(value ==7){return "<font color=blue>已转移</font>"};
                 	}
                 	}]),
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
                 tbar:[{
                	 text:"分配",
                	 iconCls:"icon-complate",
                	 handler:function(){
                	 var selections=Ynzc.manage.dataGrid.selModel.getSelections();
                     var n=selections.length;
                     if(n==0){
                    	
                         var platebatchwin = new Ynzc.manage.ReaperPlateLibGridBatchWin();
//                         Ext.getCmp("platehead").setValue(selections[0].data.platehead);
                         platebatchwin.show();
                         
                         return;
                     }
                     Ynzc.manage.rds =[];
                     for (i = 0; i < n; i++) {
                         var carcheckjson = "{id:" + selections[i].data.id + ",platenum:'" + selections[i].data.platenum + "',platehead:'" + selections[i].data.platehead + "',status:" + selections[i].data.status+",unitid:"+selections[i].data.unitid+"}";
                         Ynzc.manage.rds.push(carcheckjson);
                     }
                     var plateWin = new Ynzc.manage.ReaperPlateLibGridWin();
                     plateWin.show();
                 	}
                 },{
                	 text:"号牌维护",
                	 iconCls:"icon-Permissions",
                	 handler:function(){
                	 	var selections = Ynzc.manage.dataGrid.selModel.getSelections();
                	 	var n = selections.length;
                	 	if(n==0){
                	 		 Ext.ux.Toast.msg("提示","请选中要维护的号牌!");
                             return;
                	 	}
                	 	Ynzc.manage.rds =[];
                	 	for(i = 0;i<n;i++){
                	 		var carcheckjson = "{id:" + selections[i].data.id + ",platenum:'" + selections[i].data.platenum + "',platehead:'" + selections[i].data.platehead + "',status:" + selections[i].data.status+",unitid:"+selections[i].data.unitid+"}";
                	 		Ynzc.manage.rds.push(carcheckjson);
                	 	}
                	 	
                	 	var plateMaintainWin = new Ynzc.manage.ReaperPlateMaintainWin();
                	 	plateMaintainWin.show();
                	 	Ext.getCmp("plateNumber").setValue(selections[0].data.platehead+":"+selections[0].data.platenum);
                 	}
                 }],
                 bbar:new Ext.PagingToolbar({
                     pageSize:5,
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
							plateDs.load({
								params:{
								untilid:node.id,
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
			
			Ynzc.manage.ReaperPlateLibGrid.superclass.initComponent.apply(this,arguments);
			plateDs.load({
				params:{
				untilid:-1,
				start:0,
				limit:20
			}
			});
		}
});
Ext.reg("reaperplatelibgrid",Ynzc.manage.ReaperPlateLibGrid);