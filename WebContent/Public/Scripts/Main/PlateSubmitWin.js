Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateSubmitWin=Ext.extend(Ext.Window,{
	id:"platesubmitwin",
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
	 	var cm=new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
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
			if(value<10){
			if(value==4){return "<font color=blue>补领</font>"};
			if(value==5){return "<font color=blue>报废</font>"};
			if(value==6){return "<font color=blue>补换</font>"};
			if(value==7){return "<font color=blue>转籍</font>"};}
			else{
				if(parseInt(value/10)==1){return "<font color=blue>市级上报编制中</font>"};
	 			if(parseInt(value/10)==2){return "<font color=blue>市级上报已完成</font>"};
	 			if(parseInt(value/10)==3){return "<font color=blue>省级制作编制中</font>"};
	 			if(parseInt(value/10)==4){return "<font color=blue>省级制作已完成</font>"};
	 			if(parseInt(value/10)==5){return "<font color=blue>省级入库编制中</font>"};
	 			if(parseInt(value/10)==6){return "<font color=blue>省级入库已完成</font>"};
	 			if(parseInt(value/10)==7){return "<font color=blue>省级分配编制中</font>"};
	 			if(parseInt(value/10)==8){return "<font color=blue>省级分配已完成</font>"};
	 			if(parseInt(value/10)==9){return "<font color=blue>市级入库编制中</font>"};
	 			if(parseInt(value/10)==10){return "<font color=blue>市级入库已完成</font>"};
			}
		}
		}])
	 	var pDs = new Ext.data.Store({
			scopte:this,
			url:'main/plate.html?action=getPlateChangeList',
			baseParams:{status:Ynzc.manage.status},
			reader:pReader,
			sortInfo:{
				field:'platenum',
				direction:'ASC'
			}
		});
//		var pDsbf = new Ext.data.Store({
//			scopte:this,
//			url:'main/plate.html?action=getPlateChangeList',
//			reader:pReader,
//			sortInfo:{
//				field:'platenum',
//				direction:'ASC'
//			}
//		});
//		var pDsbp = new Ext.data.Store({
//			scopte:this,
//			url:'main/plate.html?action=getPlateChangeList',
//			reader:pReader,
//			sortInfo:{
//				field:'platenum',
//				direction:'ASC'
//			}
//		});
//		var pDszy = new Ext.data.Store({
//			scopte:this,
//			url:'main/plate.html?action=getPlateChangeList',
//			reader:pReader,
//			sortInfo:{
//				field:'platenum',
//				direction:'ASC'
//			}
//		});
		var plateGrid = new Ext.grid.GridPanel({
			plain:true,
			height:200,
			width:686,
			border:false,
			autoScroll:true,
			cm:cm,
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
		
		var npDs=new Ext.data.Store({
            scopte:this,
            baseParams:{pid:Ynzc.manage.pid
//			,status:Ynzc.manage.status
			},
            url:'main/plate.html?action=getNewPlateList',
            reader:npReader,
            sortInfo:{
                field:'platenum',
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
		                     dataIndex:"status",
		                     renderer:function(value){
                	 			if(parseInt(value/10)==1){return "<font color=blue>市级上报编制中</font>"};
                	 			if(parseInt(value/10)==2){return "<font color=blue>市级上报已完成</font>"};
                	 			if(parseInt(value/10)==3){return "<font color=blue>省级制作编制中</font>"};
                	 			if(parseInt(value/10)==4){return "<font color=blue>省级制作已完成</font>"};
                	 			if(parseInt(value/10)==5){return "<font color=blue>省级入库编制中</font>"};
                	 			if(parseInt(value/10)==6){return "<font color=blue>省级入库已完成</font>"};
                	 			if(parseInt(value/10)==7){return "<font color=blue>市级入库编制中</font>"};
                	 			if(parseInt(value/10)==8){return "<font color=blue>市级入库已完成</font>"};
//		                     	if(value==0){return "<font color=blue>待制作</font>"};
//		                     	if(value==1){return "<font color=blue>正在制作中..</font>"};
//		                     	if(value==2){return "<font color=red>不制作</font>"};
//		                     	if(value==3){return "<font color=blue>省级已入库待分配</font>"};
//		                     	if(value==4){return "<font color=darkred>该号牌已经存在，不能重复制作.</font>"};
//		                     	if(value==5){return "<font color=blue>省级已分配待入库</font>"};
//		                    	if(value==6){return "<font color=green>已入库</font>"};
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

//    	if(Ynzc.manage.status==10)Ext.getCmp("platelabel").setHtml("报废\补领\转籍号牌");
    	
		Ext.apply(this,{
			title:"添加新的号牌需求",
			iconCls:"icon-Add",
			width:700,
			height:480,
			modal:true,
			resizable:false,
			bodyStyle:"padding 10px 10px",			
			items:[
			       {
			    	   id:"platelabel",
			    	   xtype:"label",
			    	   html:"报废\补领\转籍号牌"
			       },
//			    {
//				xtype:"toolbar",
//				height:"auto",
//				items:[{
//				    id:"pDsBtn",
//				    text:"报废\补领\转移号牌",
//				    handler:function(){
//						plateGrid.reconfigure(pDs,cm);
//				      }
//				    },{
//				    id:"pDsbfBtn",
//				    text:"报废号牌",
//				    handler:function(){
//						plateGrid.reconfigure(pDsbf,cm);
//				      }
//				    },{
//					id:"pDsbpBtn",
//					text:"补领号牌",
//					handler:function(){
//				    	plateGrid.reconfigure(pDsbp,cm);  
//					   }
//				    },{
//					id:"pDszyBtn",
//					text:"转移号牌",
//					handler:function(){
//				    	plateGrid.reconfigure(pDszy,cm);  
//					   }
//				    }
//				]
//			},
			plateGrid,{
			    id:"nplatelabel",
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
					  if(Ynzc.manage.istrue!=0){
					  	Ext.ux.Toast.msg("提示","该批次号牌不可修改！");
					  	return;
					  }
					  if(plateGrid.getStore().getCount()>0){
						var rds = [];
						rds.push(plateGrid.getStore().getAt(0).data);
							                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在处理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
						Ext.Ajax.request({
							url:"main/plate.html?action=addANewPlate",
							success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								Ext.ux.Toast.msg("提示","添加成功.");
								npDs.reload();
								pDs.reload();
//								pDsbf.reload();
//								pDsbp.reload();
//								pDszy.reload();
							}else{
								Ext.ux.Toast.msg("提示",result.result.reason);
								npDs.reload();
								pDs.reload();
							}
							},
							failure:function(){
                         		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                         	},
                         	params:{
                         		platenum:plateGrid.getStore().getAt(0).data.platenum,
                         		platehead:plateGrid.getStore().getAt(0).data.platehead,
                         		pid:Ynzc.manage.pid,
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
                                 	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在处理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
                                 Ext.Ajax.request({
                                 	url:"main/plate.html?action=addANewPlate",
                                 	success:function(resp){
                                 	mask.hide();
                                 	var result=Ext.util.JSON.decode(resp.responseText);
                                 		if(result.success==true){
                                 			Ext.ux.Toast.msg("提示","添加成功.");
                                 			npDs.reload();
                                 			Ext.getCmp("plateAddWin").close();
                                 		}else{
                                 			Ext.ux.Toast.msg("提示",result.reason);
                                 			npDs.reload();
                                 			Ext.getCmp("plateAddWin").close();
                                 		}
                                 	},
                                 	failure:function(){
                                 		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                 	},
                                 	params:{
                                 		platenum:Ext.getCmp("platenum").getValue(),
                                 		pid:Ynzc.manage.pid,
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
						if(Ynzc.manage.istrue!=0){
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
                                 var size=Ext.getCmp("end").getValue()-Ext.getCmp("start").getValue()+1;
                                 if(plateGrid.getStore().getCount()==0){
                                	 Ext.Ajax.request({
                                		 url:"main/plate.html?action=AddPlateBat",
                                		 timeout:600000,
                                		 success:function(resp){
                                		 	mask.hide();
                                		 	var result=Ext.util.JSON.decode(resp.responseText);
                                     		if(result.success==true){
                                     			Ext.ux.Toast.msg("提示","批量添加成功.");
                                    		 	npDs.reload();
                                     		}else{
                                     			Ext.ux.Toast.msg("提示",result.reason);
                                     			npDs.reload();
                                     		}
                                	 	},
                                	 	failure:function(){
                                	 		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                	 	},
                                	 	params:{
                                	 		start:Ext.getCmp("start").getValue(),
                                	 		end:Ext.getCmp("end").getValue(),
                                	 		pid:Ynzc.manage.pid,
                                	 		type:0
                                	 	}
                                	 }); 
                                 }
                               	 if(plateGrid.getStore().getCount()>0){
                               		if(plateGrid.getStore().getCount()>=size){
                               			var rds =[];
                               			for(i=0;i<size;i++){
                               				rds.push(plateGrid.getStore().getAt(i).data);
                               			}
                               			Ext.Ajax.request({
                               				url:"main/plate.html?action=AddPlateBat",
                               				timeout:600000,
                               				success:function(){
                               					mask.hide();
                               					Ext.ux.Toast.msg("提示","批量添加成功.");
                               					npDs.reload();
                               					pDs.reload();
//                               				pDsbf.reload();
//                								pDsbp.reload();
//                								pDszy.reload();
                               				},
                               				failure:function(){
                               					Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                               				},
                               				params:{
                               					pid:Ynzc.manage.pid,
                               					dellist: Ext.util.JSON.encode(rds),
                                         		type:1
                               				}
                               			})
                               		}
                               		if(plateGrid.getStore().getCount()<size){
                               			var rds =[];
                               			for(i=0;i<plateGrid.getStore().getCount();i++){
                               				rds.push(plateGrid.getStore().getAt(i).data);
                               			}
                               			Ext.Ajax.request({
                               				url:"main/plate.html?action=AddPlateBat",
                               				timeout:600000,
                               				success:function(){
                               					mask.hide();
                               					Ext.ux.Toast.msg("提示","批量添加成功.");
                               					npDs.reload();
                               					pDs.reload();
//                               				Dsbf.reload();
//                								pDsbp.reload();
//                								pDszy.reload();
                               				},
                               				failure:function(){
                               					Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                               				},
                               				params:{
                                    	 		start:Ext.getCmp("start").getValue(),
                                    	 		end:Ext.getCmp("end").getValue(),
                               					pid:Ynzc.manage.pid,
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
						if(Ynzc.manage.istrue!=0){
						  	Ext.ux.Toast.msg("提示","该批次号牌不可删除！");
						  	return;
					  	}
						var selections=newPlateGrid.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                        	Ext.ux.Toast.msg("提示","请选中要删除的号牌!");
							return;
                        }
                         Ext.Msg.show({
                            title:'系统确认',
                            msg:'你是否确认删除选中的号牌?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                	var rds=[];
                                    for(i=0;i<n;i++){
                                    	rds.push(selections[i].data);
                                    }
                                    if(rds.length!=0){
                                    Ext.Ajax.request({
                                        url:"main/plate.html?action=delNewPlate",
                                        method:"post",
                                        success:function(){
                                            Ext.ux.Toast.msg("提示","已成功删除选中的号牌");
                                            newPlateGrid.getStore().reload();
                                            plateGrid.getStore().reload();
                                        },
                                        faliure:function(){
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                           dellist:Ext.util.JSON.encode(rds)
                                        }
                                    });}
                                }
                            }
                         });                     
					}
				},{
					text:"删除全部新建号牌",
					iconCls:"icon-plateremove",
					handler:function(){
						if(Ynzc.manage.istrue!=0){
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
                                        url:"main/plate.html?action=delAllNewPlate",
                                        method:"post",
                                        success:function(){
                                            Ext.ux.Toast.msg("提示","已成功删除选中的号牌");
                                            newPlateGrid.getStore().reload();
                                            plateGrid.getStore().reload();
                                        },
                                        faliure:function(){
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                          	pid:Ynzc.manage.pid
                                        }
                                    });
                                }
                            }
                         });           
					}
				}]
			}]
		})
		Ynzc.manage.PlateSubmitWin.superclass.initComponent.apply(this,arguments);
		npDs.load({
			params:{
				start:0,
				limit:6
			}
		});
		pDs.load({
			params:{
				start:0,
				limit:6,
				status:Ynzc.manage.status
			}
		});
//		pDsbf.load({
//			params:{
//				start:0,
//				limit:6,
//				status:5
//			}
//		});
//		pDsbp.load({
//			params:{
//				start:0,
//				limit:6,
//				status:6
//			}
//		});
//		pDszy.load({
//			params:{
//				start:0,
//				limit:6,
//				status:7
//			}
//		});
	}
});