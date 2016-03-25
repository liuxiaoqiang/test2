Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReaperPlateSubmitWin=Ext.extend(Ext.Window,{
	id:"reaperplatesubmitwin",
	initComponent:function(){   
		var pReader = new Ext.data.JsonReader({
			totalProperty:"totalCount",
			root:"data",
			autoLoad:true,
			fields:[{
				name:'id'
			},{
				name:'platenum'
			},{
				name:'platehead'
			},{
				name:'status'
			},{
				name:'unitid'
			}] 
		});
		
		var pDs = new Ext.data.Store({
			scopte:this,
			url:'main/reaperPlate.html?action=getPlateChangeList',
			reader:pReader,
			sortInfo:{
				field:'id',
				direction:'ASC'
			}
		});
		var plateGrid = new Ext.grid.GridPanel({
			plain:true,
			height:200,
			width:686,
			border:false,
			autoScroll:true,
			cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
				header:'号牌号码',
				sortable:true,
				dataIndex:"platenum",
				renderer:function(value){
				value=PlateNumHead+"."+value;
				return value;
			}
			},{
				header:'状态',
				sortable:true,
				dataIndex:"status",
				renderer:function(value){
				if(value==5){return "<font color=blue>报废</font>"};
				if(value==6){return "<font color=blue>注销</font>"};
				if(value==7){return "<font color=blue>已转移</font>"};
			}
			}]),
			sm:new Ext.grid.CheckboxSelectionModel(),
			frame:true,
			store:pDs,
			loadMask:true,
			viewConfig:{
			forceFit:true
			},
			plugins:new Ext.ux.grid.Search({
				width:120,
				iconCls:false,
				position:"bottom"
			}),
			 bbar:new Ext.PagingToolbar({
	             pageSize:6,
	             store:pDs,
	             displayInfo:true,
	             displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
	             emptyMsg : '无记录'
	         })
		})
		
			
	
	
	
		
		var npReader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'platenum'
            },{
                name : 'platenumhead'
            },{
                name : 'psid'
            },{
            	name : 'madestatus'
            }]
        });
		
		var npDs=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.psid,status:Ynzc.manage.status},
            url:'main/reaperPlate.html?action=getNewPlateList',
            reader:npReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
		
		var newPlateGrid=new Ext.grid.GridPanel({
				 plain:true,
				 height:200,
				 width:686,
                 border:false,
                 autoScroll:true,
                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                             header:'号牌号码',
                             sortable:true,
                             dataIndex:"platenum",
                             renderer:function(value){
                             	value=PlateNumHead+"."+value;
                             	return value;
                             }
                 },{
		         			 header:'状态',
		                     sortable:true,
		                     dataIndex:"madestatus",
		                     renderer:function(value){
                	        
		                     	if(value==0){return "<font color=blue>待制作</font>"};
		                     	if(value==1){return "<font color=blue>正在制作中..</font>"};
		                     	if(value==2){return "<font color=red>不制作</font>"};
		                     	if(value==3){return "<font color=blue>省级已入库待分配</font>"};
		                     	if(value==4){return "<font color=darkred>该号牌已经存在，不能重复制作.</font>"};
		                     	if(value==5){return "<font color=blue>省级已分配待入库</font>"};
		                    	if(value==6){return "<font color=green>已入库</font>"};
		                     }
		         }]),
                 sm:new Ext.grid.CheckboxSelectionModel(),
                 frame:true,
                 store:npDs,
                 loadMask:true,
                 viewConfig:{
                     forceFit:true
                 },
                 plugins:new Ext.ux.grid.Search({
                            width:120,
                            iconCls:false,
                            position:"bottom"
                        }),
                 bbar:new Ext.PagingToolbar({
                     pageSize:6,
                     store:npDs,
                     displayInfo:true,
                     displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                     emptyMsg : '无记录'
                 })
		})
	
		Ext.apply(this,{
			title:"添加新的号牌需求",
			iconCls:"icon-Add",
			width:700,
			height:487,
			modal:true,
			resizable:false,
			bodyStyle:"padding 10px 10px",			
			items:[{
				xtype:"label",
				html:"报废/转籍/注销的号牌:"//还需教工的地方
			},plateGrid,{
				xtype:"label",
				html:"需要制作的号牌:"
			},newPlateGrid,{
				xtype:"toolbar",
				height:"auto",
				items:[{
					id:"addAPlateBtn",
					text:"添加单个号牌",
					iconCls:"icon-plateadd",
					handler:function(){
					  if(Ynzc.manage.status!=0){
					  	Ext.ux.Toast.msg("提示","该批次号牌不可修改！");
					  	return;
					  }
					  if(pDs.getCount()>0){
						var rds = [];
						rds.push(plateGrid.getStore().getAt(0).data);
						Ext.Ajax.request({
							url:"main/reaperPlate.html?action=addANewPlate",
							success:function(){
								Ext.ux.Toast.msg("提示","添加成功.");
								npDs.reload();
								pDs.reload();
							},
							failure:function(){
                         		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                         	},
                         	params:{
                         		platenum:plateGrid.getStore().getAt(0).data.platenum,
                         		psid:Ynzc.manage.psid,
                         		type:0,
                         		dellist: Ext.util.JSON.encode(rds)
                         	}
						})
						return;
					  }
					  
					  new Ext.Window({
                          id:"plateAddWin",
                          title:"添加单个号牌",
                          iconCls:"icon-plateadd",
                          modal:true,
                          height:100,
                          width:200,
                          layout:"form",
                          labelWidth:55,
                          bodyStyle:"padding:5px 5px",
                          items:[{
                              id:"platenum",
                              fieldLabel:"号牌号码",
                              xtype:"textfield",
                              anchor:'98%'
                          }],
                          buttons:[{text:"保存",handler:function(){
                                 if(checkFlapper(Ext.getCmp("platenum").getValue())==false){
                                	Ext.ux.Toast.msg("提示","填写的号牌号码有误");
                                	return;
                                 }
                                 Ext.Ajax.request({
                                 	url:"main/reaperPlate.html?action=addANewPlate",
                                 	success:function(){
                                 		Ext.ux.Toast.msg("提示","添加成功.");
                                 		npDs.reload();
                                 		Ext.getCmp("plateAddWin").close();
                                 	},
                                 	failure:function(){
                                 		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                 	},
                                 	params:{
                                 		platenum:Ext.getCmp("platenum").getValue(),
                                 		psid:Ynzc.manage.psid,
                                 		type:1
                                 	}
                                 });
                          }},{text:"取消",handler:function(){
                                 Ext.getCmp("plateAddWin").close();
                          }}]
                      }).show(Ext.getCmp("addAPlateBtn").getEl());
					}
				},{
					text:"添加一批号牌",
					iconCls:"icon-plateadd",
					handler:function(){
						if(Ynzc.manage.status!=0){
						  	Ext.ux.Toast.msg("提示","该批次号牌不可修改！");
						  	return;
						}
						new Ext.Window({
                          id:"plateAddWin",
                          title:"添加一批号牌",
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
                          buttons:[{text:"保存",handler:function(){
                                 if(checkFlapper(Ext.getCmp("start").getValue())==false){
                                      Ext.ux.Toast.msg("提示","填写起始号码有误.");
                                      return;
                                 }  
                                 if(checkFlapper(Ext.getCmp("end").getValue())==false){
                                      Ext.ux.Toast.msg("提示","请填写结束号码有误.");
                                      return;
                                 }      
                                 if(isNaN(Ext.getCmp("start").getValue())){
                                      Ext.ux.Toast.msg("提示","请填写数字型数值.");
                                      return;
                                 }  
                                 if(isNaN(Ext.getCmp("end").getValue())){
                                      Ext.ux.Toast.msg("提示","请填写数字型数值.");
                                      return;
                                 }  
                                 if(Ext.getCmp("start").getValue()>Ext.getCmp("end").getValue()){
                                 	  Ext.ux.Toast.msg("提示","起始号不能大于结束号.");
                                      return;
                                 }
                                 var mask = new Ext.LoadMask(Ext.getBody(), {
							     		msg : '正在生成,请稍等...',
							     		removeMask:true
							     });
                                 mask.show();  
                                 var size=Ext.getCmp("end").getValue()-Ext.getCmp("start").getValue();
                                 if(pDs.getCount()==0){
                                	 Ext.Ajax.request({
                                		 url:"main/reaperPlate.html?action=AddPlateBat",
                                		 timeout:600000,
                                		 success:function(){
                                		 	mask.hide();
                                		 	Ext.ux.Toast.msg("提示","批量添加成功.");
                                		 	npDs.reload();
                                	 	},
                                	 	failure:function(){
                                	 		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                	 	},
                                	 	params:{
                                	 		start:Ext.getCmp("start").getValue(),
                                	 		end:Ext.getCmp("end").getValue(),
                                	 		psid:Ynzc.manage.psid,
                                	 		type:0
                                	 	}
                                	 }); 
                                 }
                               	 if(pDs.getCount()>0){
                               		if(pDs.getCount()>=size){
                               			var rds =[];
                               			for(i=0;i<size;i++){
                               				rds.push(plateGrid.getStore().getAt(i).data);
                               			}
                               			Ext.Ajax.request({
                               				url:"main/reaperPlate.html?action=AddPlateBat",
                               				timeout:600000,
                               				success:function(){
                               					mask.hide();
                               					Ext.ux.Toast.msg("提示","批量添加成功.");
                               					npDs.reload();
                               					pDs.reload();
                               				},
                               				failure:function(){
                               					Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                               				},
                               				params:{
                               					psid:Ynzc.manage.psid,
                               					dellist: Ext.util.JSON.encode(rds),
                                         		type:1
                               				}
                               			})
                               		}
                               		if(pDs.getCount()<size){
                               			var rds =[];
                               			for(i=0;i<pDs.getCount();i++){
                               				rds.push(plateGrid.getStore().getAt(i).data);
                               			}
                               			Ext.Ajax.request({
                               				url:"main/reaperPlate.html?action=AddPlateBat",
                               				timeout:600000,
                               				success:function(){
                               					mask.hide();
                               					Ext.ux.Toast.msg("提示","批量添加成功.");
                               					npDs.reload();
                               					pDs.reload();
                               				},
                               				failure:function(){
                               					Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                               				},
                               				params:{
                                    	 		start:Ext.getCmp("start").getValue(),
                                    	 		end:Ext.getCmp("end").getValue(),
                               					psid:Ynzc.manage.psid,
                                         		dellist: Ext.util.JSON.encode(rds),
                                         		count:pDs.getCount(),
                                         		type:2
                               				}
                               			})
                               		}
                               	 }
                               	 Ext.getCmp('plateAddWin').close();  
                          }},{text:"取消",handler:function(){
                                 Ext.getCmp("plateAddWin").close();
                          }}]
                      }).show(Ext.getCmp("addAPlateBtn").getEl());
					}
				},{
					text:"删除号牌",
					iconCls:"icon-plateremove",
					handler:function(){
						if(Ynzc.manage.status!=0){
						  	Ext.ux.Toast.msg("提示","该批次号牌不可删除！");
						  	return;
					  	}
						var selections=newPlateGrid.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                        	Ext.ux.Toast.msg("提示","请选中要删除的号牌!");
							return;
                        }
                        var rds=[];
                        for(i=0;i<n;i++){
                            rds.push(selections[i].data);
                        }
                         Ext.Msg.show({
                            title:'系统确认',
                            msg:'你是否确认删除选中的号牌?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/reaperPlate.html?action=delNewPlate",
                                        method:"post",
                                        success:function(){
                                            Ext.ux.Toast.msg("提示","已成功删除选中的号牌");
                                            newPlateGrid.getStore().reload();
                                        },
                                        faliure:function(){
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                           dellist:Ext.util.JSON.encode(rds)
                                        }
                                    });
                                }
                            }
                         });                     
					}
				},{
					text:"删除全部新建号牌",
					iconCls:"icon-plateremove",
					handler:function(){
						if(Ynzc.manage.status!=0){
						  	Ext.ux.Toast.msg("提示","该批次号牌不可删除！");
						  	return;
						}
						Ext.Msg.show({
                            title:'系统确认',
                            msg:'你是否确认删除所有新建号牌?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/reaperPlate.html?action=delAllNewPlate",
                                        method:"post",
                                        success:function(){
                                            Ext.ux.Toast.msg("提示","已成功删除选中的号牌");
                                            newPlateGrid.getStore().reload();
                                        },
                                        faliure:function(){
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                          	psid:Ynzc.manage.psid
                                        }
                                    });
                                }
                            }
                         });           
					}
				}]
			}]
		})
		Ynzc.manage.ReaperPlateSubmitWin.superclass.initComponent.apply(this,arguments);
		npDs.load({
			params:{
				start:0,
				limit:6
			}
		});
		pDs.load({
			params:{
				start:0,
				limit:6
			}
		});
	}
});