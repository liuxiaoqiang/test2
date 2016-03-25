Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivertrainingInfoGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'drivertrainingInfoGrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'教练机号牌',
                        sortable:true,
                        dataIndex:"cardCode",
                        renderer:function(value,res,record){
                        	return record.data.platecode+"."+value+"学";
                        }
                    },{
                        header:'申请单位',
                        sortable:true,
                        dataIndex:"unitName"
                    },{
                        header:'机构代码',
                        sortable:true,
                        dataIndex:"unitCode"
                    },{
                        header:'住所',
                        sortable:true,
                        dataIndex:"unitAddress"
                    },{
                        header:'联系电话',
                        sortable:true,
                        dataIndex:'telephone'
                    },{
                        header:'车辆号牌',
                        sortable:true,
                        dataIndex:'tractorinfoIdCode',
                        renderer:function(value,res,record){
                        	return record.data.platecode+"."+value;
                        }
                    },{
                        header:'登记证书号',
                        sortable:true,
                        dataIndex:'letterCode'
                    },{
                        header:'车辆类型',
                        sortable:true,
                        dataIndex:'carType',
                        renderer:function(v){
                        	if(v==1){
                        		return "拖拉机"
                        	}else{
                        		return "联合收割机"
                        	}
                        }
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'tractorinfoId'
                        },{
                            name : 'unitName'
                        },{
                            name : 'unitAddress'
                        },{
                            name : 'unitCode'
                        },{
                            name : 'telephone'
                        },{
                            name : 'postCode'
                        },{
                            name : 'cardCode'
                        },{
                            name : 'tractorinfoIdCode'
                        },{
                            name : 'letterCode'
                        },{
                            name : 'auditOption'
                        },{
                            name : 'auditDate'
                        },{
                            name : 'agentMan'
                        },{
                            name : 'agentDate'
                        },{
                            name : 'owner'
                        },{
                            name : 'applicationTime'
                        },{
                        	name : 'carType'
                        },{
                            name : 'unitid'
                        },{
                            name : 'platecode'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/drivertrainingInfo.html?action=getDrivertrainingInfoAll',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'drivertrainingInfoGrid',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                        plugins:new Ext.ux.grid.Search({
                            width:200,
                            iconCls:false
                        }),
                        tbar:[{
                            id:'userAdd',
                            text:'业务办理',
                            iconCls:'icon-UserAdd',
                            handler:function(){
                            	var dengji=new Ext.Window({
                            		id:'enteyNum',
                            		title:'请输入要[注册登记]的号牌号码',
                            		width:300,
                            		height:150,
                            		layout:'form',
                            		bodyStyle:'padding:10px,5px,5px,3px',
                            		resizable:false,
			           			    modal:true,
                            		items:[{
                            			id:'cartype',
                            			xtype:'combo',
                            			fieldLabel:'请选择车辆类型',
			                   		    displayField : 'display',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                store:Ynzc.manage.drivingType,
                            			anchor:'98%'
                            		},{
                            			id:'carnum',
                            			xtype:'textfield',
                            			fieldLabel:'请输入车辆号码',
                            			anchor:'98%'
                            		}],
                            		buttons:[{
                            			id:'addInfo',
                            			text:'确定',
                            			handler:function(){
                            				if(Ext.getCmp("cartype").getValue()==""){Ext.ux.Toast.msg("操作提示","请选择需要注册的车辆类型");return};
                            				if(checkNum(Ext.getCmp("carnum").getValue())){Ext.ux.Toast.msg("操作提示","需要登记注册的车辆号码不能为空或只能是数字");return};
                            				Ext.getCmp("addInfo").disable();
                            				Ynzc.manage.carTypes=Ext.getCmp("cartype").getValue();
                            				if(Ext.getCmp("cartype").getValue()==1){
                            					Ext.Ajax.request({
                                					url:'main/drivertrainingInfo.html?action=getDrivertraingTractorinfoView',
                                					success:function(data){
                                						var result=Ext.util.JSON.decode(data.responseText);
                                						if(result!=null&&result.drivertrainingInfoData[0]!=null){
                                							var addwin=new Ynzc.manage.DrivertrainingInfoAdd();
    	                           					    	addwin.show();
    	                           					    	Ext.getCmp("letterAddCode").setValue(result.drivertrainingInfoData[0].regcerno);
    	                           					    	Ext.getCmp("tractorNum").setValue(result.drivertrainingInfoData[0].platecode+"."+result.drivertrainingInfoData[0].license);
    	                           					    	Ynzc.manage.tractorinfoId=result.drivertrainingInfoData[0].id;
    	                           					    	Ynzc.manage.unitidTractorid=result.drivertrainingInfoData[0].unitid;
    					           					    	Ynzc.manage.tractorinfoIdCode=result.drivertrainingInfoData[0].license;
    	                           					    	Ext.getCmp("tractorDiPanNum").setValue(result.drivertrainingInfoData[0].machinebodyno);
    	                           					    	Ext.getCmp("fadongjiNum").setValue(result.drivertrainingInfoData[0].engineno);
    	                           					    	Ext.getCmp("changpaiType").setMyValue(result.drivertrainingInfoData[0].machinebrandtypeid);
    	                           					    	Ext.getCmp("huacheNum").setValue(result.drivertrainingInfoData[0].shelfno);
    	                           					    	Ext.getCmp("carType").setValue(result.drivertrainingInfoData[0].machinetypeid);
    	                           					    	Ext.getCmp("jizhuqianzhang").setValue(result.drivertrainingInfoData[0].owner);
    	                           					    	Ext.getCmp("nongjishenhe").setValue("同意申请");
    	                           					    	Ext.getCmp("jingbanren").setValue(loginUser);
    	                           					    	Ext.getCmp("enteyNum").close();
                                						}else{
                                							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
                                							Ext.getCmp("addInfo").enable();
                                						}
                                					},
                                					failure:function(){
                                							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
                                							Ext.getCmp("addInfo").enable();
                                					},
                                					params:{
                                						carCode:Ext.getCmp("carnum").getValue(),
                                						unitid:UnitID
                                					}
                                				});
                            				}else{
                            					Ext.Ajax.request({
                                					url:'main/uniteharvesterInfo.html?action=findUniteharvesterByCarNum',
                                					success:function(data){
                                						var result=Ext.util.JSON.decode(data.responseText);
                                						if(result!=null&&result.UniteHarvester[0]!=null){
                                							var addwin=new Ynzc.manage.DrivertrainingUniteHarvestInfoAdd();
    	                           					    	addwin.show();
    	                           					    	Ext.getCmp("letterAddCode").setValue(result.UniteHarvester[0].liveAddress);
    	                           					    	Ext.getCmp("tractorNum").setValue(result.UniteHarvester[0].platecode+"."+result.UniteHarvester[0].harvesterCode);
    	                           					    	Ynzc.manage.uniteharvestid=result.UniteHarvester[0].id;
    	                           					    	Ynzc.manage.unitidTractorid=result.UniteHarvester[0].unitid;
    					           					    	Ynzc.manage.uniteharvestCode=result.UniteHarvester[0].harvesterCode;
    	                           					    	Ext.getCmp("tractorDiPanNum").setValue(result.UniteHarvester[0].harvesterBodyCode);
    	                           					    	Ext.getCmp("fadongjiNum").setValue(result.UniteHarvester[0].harvesterEngineCode);
    	                           					    	Ext.getCmp("changpaiType").setValue(result.UniteHarvester[0].harvesterChangPaiType);
    	                           					    	Ext.getCmp("huacheNum").setValue(result.UniteHarvester[0].harvesterBodyColor);
    	                           					    	Ext.getCmp("carType").setValue(result.UniteHarvester[0].harvesterType);
    	                           					    	Ext.getCmp("jizhuqianzhang").setValue(result.UniteHarvester[0].harvesterOwner);
    	                           					    	Ext.getCmp("nongjishenhe").setValue("同意申请");
    	                           					    	Ext.getCmp("jingbanren").setValue(loginUser);
    	                           					    	Ext.getCmp("enteyNum").close();
                                						}else{
                                							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
                                							Ext.getCmp("addInfo").enable();
                                						}
                                					},
                                					failure:function(){
                                							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
                                							Ext.getCmp("addInfo").enable();
                                					},
                                					params:{
                                						carCode:Ext.getCmp("carnum").getValue(),
                                						unitid:UnitID
                                					}
                                				});
                            				}
                            			}
                            		},{
                            			text:'取消',
                            			handler:function(){
                            				Ext.getCmp("enteyNum").close();
                            			}
                            		}]
                            	});
                            	dengji.show();
                            	}},'-',{
                                id:"userDel",
                                text:"删除",
                                iconCls:"icon-UserDel",
                                handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请选中要删除的注册登记信息!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的注册登记信息?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/drivertrainingInfo.html?action=deleteDrivertrainingInfo",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的注册登记信息");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        drivertraininglist:Ext.util.JSON.encode(rds)
                                                    }
                                                });
                                            }
                                        }
                                     });
                                }.createDelegate(this)
                            }],
                        bbar:new Ext.PagingToolbar({
                            pageSize:20,
                            store:ds,
                            displayInfo:true,
                            displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                            emptyMsg : '无记录'
                        }),
                        viewConfig:{
                            forceFit:true
                        }
                    });
                    Ynzc.manage.DrivertrainingInfoGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                    var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在查询该条记录,请稍等...',
			     		removeMask:true
	                });
                    this.on("rowdblclick",function(grid,index,event){
		                mask.show();
                        var record=grid.getStore().getAt(index);
                        if(record.data.carType==1){
                        	Ext.Ajax.request({
            					url:'main/drivertrainingInfo.html?action=findDrivertraingTractorinfoViewByid',
            					success:function(data){
            						var result=Ext.util.JSON.decode(data.responseText);
            						if(result!=null&&result.drivertrainingInfoData!=null){
            							var addwin=new Ynzc.manage.DrivertrainingInfoGridUpdate();
               					    	addwin.show();
               					    	Ext.getCmp("letterAddCode").setValue(result.drivertrainingInfoData[0].regcerno);
               					    	Ext.getCmp("tractorNum").setValue(result.drivertrainingInfoData[0].platecode+"."+result.drivertrainingInfoData[0].license);
               					    	Ext.getCmp("tractorDiPanNum").setValue(result.drivertrainingInfoData[0].machinebodyno);
               					    	Ext.getCmp("fadongjiNum").setValue(result.drivertrainingInfoData[0].engineno);
               					    	Ext.getCmp("changpaiType").setMyValue(result.drivertrainingInfoData[0].machinebrandtypeid);
               					    	Ext.getCmp("huacheNum").setValue(result.drivertrainingInfoData[0].shelfno);
               					    	Ext.getCmp("carType").setValue(result.drivertrainingInfoData[0].machinetypeid);
               					    	Ynzc.manage.carType=record.data.carType;
               					    	Ynzc.manage.tractorinfoId=result.drivertrainingInfoData[0].id;
    					           		Ynzc.manage.tractorinfoIdCode=result.drivertrainingInfoData[0].license;
    					           		Ynzc.manage.unitidTractorid=result.drivertrainingInfoData[0].unitid;
    					           		Ynzc.manage.drivertraininfId=record.data.id;
    					           		Ynzc.manage.carcode=record.data.cardCode;//教练车号牌（一旦注册，不允许修改）
    			                        Ext.getCmp("unitname").setValue(record.data.unitName);
    			                        Ext.getCmp("address").setValue(record.data.unitAddress);
    			                        Ext.getCmp("unitCode").setValue(record.data.unitCode);
    			                        Ext.getCmp("telephone").setValue(record.data.telephone);
    			                        Ext.getCmp("postCode").setValue(record.data.postCode);
    			                        Ext.getCmp("driverCode").setValue(record.data.platecode+"."+record.data.cardCode+"学");
    			                        Ext.getCmp("jizhuqianzhang").setValue(record.data.owner);
    			                        Ext.getCmp("jizhuqianzhangDate").setValue(new Date(record.get("applicationTime").time).format('Y-m-d'));
    			                        Ext.getCmp("nongjishenhe").setValue(record.data.auditOption);
    			                        Ext.getCmp("nongjishenheDate").setValue(new Date(record.get("auditDate").time).format('Y-m-d'));
    			                        Ext.getCmp("jingbanren").setValue(record.data.agentMan);
    			                        Ext.getCmp("jingbanDate").setValue(new Date(record.get("agentDate").time).format('Y-m-d'));
    			                        mask.hide();
            						}else{
            							mask.hide();
            							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
            						}
            					},
            					params:{
            						id:record.data.tractorinfoId,
            						carType:record.data.carType
            					}
            				});
                        }else{
                        	Ext.Ajax.request({
                        		url:'main/uniteharvesterInfo.html?action=findUniteharvesterViewByid',
            					success:function(data){
            						var result=Ext.util.JSON.decode(data.responseText);
            						if(result!=null&&result.uniteharvesterData!=null){
            							var addwin=new Ynzc.manage.DrivertrainingUniteHarvestInfoGridUpdate();
               					    	addwin.show();
               					    	Ext.getCmp("letterAddCode").setValue(result.uniteharvesterData[0].liveAddress);
               					    	Ext.getCmp("tractorNum").setValue(result.uniteharvesterData[0].platecode+"."+result.uniteharvesterData[0].harvesterCode);
               					    	Ext.getCmp("tractorDiPanNum").setValue(result.uniteharvesterData[0].harvesterBodyCode);
               					    	Ext.getCmp("fadongjiNum").setValue(result.uniteharvesterData[0].harvesterEngineCode);
               					    	Ext.getCmp("changpaiType").setValue(result.uniteharvesterData[0].harvesterChangPaiType);
               					    	Ext.getCmp("huacheNum").setValue(result.uniteharvesterData[0].harvesterBodyColor);
               					    	Ext.getCmp("carType").setValue(result.uniteharvesterData[0].harvesterType);
               					    	Ynzc.manage.carType=record.data.carType;
               					    	Ynzc.manage.uniteharvestId=result.uniteharvesterData[0].id;
    					           		Ynzc.manage.uniteHarvestCode=result.uniteharvesterData[0].harvesterCode;
    					           		Ynzc.manage.unitidTractorid=result.uniteharvesterData[0].unitid;
    					           		Ynzc.manage.drivertraininfId=record.data.id;
    					           		Ynzc.manage.carcode=record.data.cardCode;//教练车号牌（一旦注册，不允许修改）
    			                        Ext.getCmp("unitname").setValue(record.data.unitName);
    			                        Ext.getCmp("address").setValue(record.data.unitAddress);
    			                        Ext.getCmp("unitCode").setValue(record.data.unitCode);
    			                        Ext.getCmp("telephone").setValue(record.data.telephone);
    			                        Ext.getCmp("postCode").setValue(record.data.postCode);
    			                        Ext.getCmp("driverCode").setValue(record.data.platecode+"."+record.data.cardCode+"学");
    			                        Ext.getCmp("jizhuqianzhang").setValue(record.data.owner);
    			                        Ext.getCmp("jizhuqianzhangDate").setValue(new Date(record.get("applicationTime").time).format('Y-m-d'));
    			                        Ext.getCmp("nongjishenhe").setValue(record.data.auditOption);
    			                        Ext.getCmp("nongjishenheDate").setValue(new Date(record.get("auditDate").time).format('Y-m-d'));
    			                        Ext.getCmp("jingbanren").setValue(record.data.agentMan);
    			                        Ext.getCmp("jingbanDate").setValue(new Date(record.get("agentDate").time).format('Y-m-d'));
    			                        mask.hide();
            						}else{
            							mask.hide();
            							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
            						}
            					},
            					params:{
            						id:record.data.tractorinfoId
            					}
            				});
                        }
                    });
                }
});
Ext.reg('drivertrainingInfoGrid',Ynzc.manage.DrivertrainingInfoGrid);