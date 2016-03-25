Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivertrainingCheckInfoGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'drivertrainingcheckinfo',
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
                        header:'检验年份',
                        sortable:true,
                        dataIndex:"checkDate",
                        renderer:function(v){
                        	return new Date(v.time).format('Y')
                        }
                    },{
                        header:'检验时间',
                        sortable:true,
                        dataIndex:"checkDate",
                        renderer:function(v){
                        	return new Date(v.time).format('Y-m-d')
                        }
                    },{
                        header:'检验有效期至',
                        sortable:true,
                        dataIndex:'insurceActiveDate',
                        renderer:function(v){
                        	return new Date(v.time).format('Y-m-d')
                        }
                    },{
                        header:'车辆号牌',
                        sortable:true,
                        dataIndex:"tractorinfoIdCode",
                         renderer:function(value,res,record){
                        	return record.data.platecode+"."+value;
                        }
                    },{
                        header:'年检标志',
                        sortable:true,
                        dataIndex:"insurceMark",
                        renderer : function(value) {
			                var index = Ynzc.manage.InsurceMark.find("value", value);
			                if (index>=0) {
			                    var record = Ynzc.manage.InsurceMark.getAt(index);
			                    return record.data.display;
			                } else {
			                    return '未知标志';
			                }
			            }
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
                            name : 'uelephone'
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
                            name : 'drivingcheckid'
                        },{
                            name : 'checkResult'
                        },{
                            name : 'checkMan'
                        },{
                            name : 'checkDate'
                        },{
                        	name : 'checkLiveDate'
                        },{
                            name : 'changeRecord'
                        },{
                            name : 'insurceType'
                        },{
                            name : 'insurceMark'
                        },{
                            name : 'enteyManId'
                        },{
                            name : 'entryDate'
                        },{
                            name : 'checkUnitName'
                        },{
                            name : 'insurceCode'
                        },{
                            name : 'insurceName'
                        },{
                            name : 'insurceDate'
                        },{
                            name : 'insurceActiveDate'
                        },{
                        	name : 'platecode'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/drivertrainingInfo.html?action=getDrivertrainingInfoViewAll',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'drivertrainingcheckinfo',
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
                            		title:'请输入要[年度检验]的教练机号码',
                            		width:350,
                            		height:120,
                            		layout:'form',
                            		bodyStyle:'padding:10px,5px,5px,3px',
                            		resizable:false,
			           			    modal:true,
			           			    labelWidth:110,
                            		items:[{
                            			id:'carnum',
                            			xtype:'textfield',
                            			fieldLabel:'请输入教练机号码',
                            			anchor:'98%'
                            		}],
                            		buttons:[{
                            			text:'确定',
                            			handler:function(){
                            				 if(checkNum(Ext.getCmp("carnum").getValue())){Ext.ux.Toast.msg("操作提示","教练机号码不能为空或只能是数字");return;}else{Ynzc.manage.carnumber=Ext.getCmp("carnum").getValue();}
                            				 Ext.Ajax.request({
                            				 	url:'main/drivertrainingCheckInfo.html?action=checkDrivertrainingCardCode',
                            				 	success:function(data){
                            				 		var result=Ext.util.JSON.decode(data.responseText);
                            				 		if(result.success==false){
                            				 			 Ext.ux.Toast.msg("操作提示",result.reason);
                            				 		}else{		
			                               				 if(result.drivertrainingInfoData[0].carType==1){
			                               					 var addwin=new Ynzc.manage.DrivertrainingCheckInfoGridAdd();
				                               				 addwin.show(Ext.getCmp("userAdd").getEl());
				                               				 Ext.getCmp("username").setValue(result.drivertrainingInfoData[0].owner);
				                               				 Ext.getCmp("isunitOrPeople").setValue(result.drivertrainingInfoData[0].isUnion);
				                               				 Ext.getCmp("address").setValue(result.drivertrainingInfoData[0].address);
				                               				 Ext.getCmp("certificatename").setValue(result.drivertrainingInfoData[0].realcertificatetypeid);
				                               				 Ext.getCmp("telephone").setValue(result.drivertrainingInfoData[0].telephone);
				                               				 Ext.getCmp("isTempLive").setValue(result.drivertrainingInfoData[0].istemplived);
				                               				 Ext.getCmp("postCode").setValue(result.drivertrainingInfoData[0].zipCode);
				                               				 Ext.getCmp("certificateCode").setValue(result.drivertrainingInfoData[0].realcertificateno);
				                               				 Ext.getCmp("pinpaiType").setMyValue(result.drivertrainingInfoData[0].machinebrandtypeid);
				                               				 Ext.getCmp("jixieType").setValue(result.drivertrainingInfoData[0].machinetypeid);
				                               				 Ext.getCmp("jishenCode").setValue(result.drivertrainingInfoData[0].machinebodyno);
				                               				 Ext.getCmp("fadongjiCode").setValue(result.drivertrainingInfoData[0].engineno);
				                               				 Ext.getCmp("registDate").setValue(new Date(result.drivertrainingInfoData[0].registerdate.time).format('Y-m-d'));
				                               				 Ext.getCmp("turninDate").setValue(new Date(result.drivertrainingInfoData[0].turnindate.time).format('Y-m-d'));
				                               				 Ext.getCmp("fapaiDate").setValue(new Date(result.drivertrainingInfoData[0].issuedate.time).format('Y-m-d'));
				                               				 Ext.getCmp("shengchanDate").setValue(new Date(result.drivertrainingInfoData[0].manufacturedate.time).format('Y-m-d'));
				                               				 Ext.getCmp("baoxianType").setValue("交强险");
				                               				 Ext.getCmp("baoxianName").setValue("请选择保险公司名称");
				                               				 Ext.getCmp("dengjiMan").setValue(result.drivertrainingInfoData[0].reviewer);
				                               				 Ext.getCmp("dengjiDate").setValue(new Date(result.drivertrainingInfoData[0].reviewerconductdate.time).format('Y-m-d'));
				                               				 Ext.getCmp("paizhengMan").setValue(result.drivertrainingInfoData[0].issueadmin);
				                               				 Ext.getCmp("paizhengDate").setValue(new Date(result.drivertrainingInfoData[0].issueadmindate.time).format('Y-m-d'));
				                               				 Ext.getCmp("lingdaoMan").setValue(result.drivertrainingInfoData[0].leaderreview);
				                               				 Ext.getCmp("lingdaoDate").setValue(new Date(result.drivertrainingInfoData[0].leaderreviewconductdate.time).format('Y-m-d'));
			                               				 }else{
			                               					 var addwin=new Ynzc.manage.DrivertrainingCheckInfoGridUniteharvestAdd();
				                               				 addwin.show(Ext.getCmp("userAdd").getEl());
			                               					 Ext.getCmp("username").setValue(result.drivertrainingInfoData[0].harvesterOwner);
				                               				 Ext.getCmp("isunitOrPeople").setValue(result.drivertrainingInfoData[0].liveType);
				                               				 Ext.getCmp("address").setValue(result.drivertrainingInfoData[0].liveAddress);
				                               				 Ext.getCmp("certificatename").setValue(result.drivertrainingInfoData[0].certitype);
				                               				 Ext.getCmp("telephone").setValue(result.drivertrainingInfoData[0].telephoneNum);
				                               				 Ext.getCmp("isTempLive").setValue(result.drivertrainingInfoData[0].liveType);
				                               				 Ext.getCmp("postCode").setValue(result.drivertrainingInfoData[0].livePostCode);
				                               				 Ext.getCmp("certificateCode").setValue(result.drivertrainingInfoData[0].certiCode);
				                               				 Ext.getCmp("pinpaiType").setValue(result.drivertrainingInfoData[0].harvesterChangPaiType);
				                               				 Ext.getCmp("jixieType").setValue(result.drivertrainingInfoData[0].harvesterType);
				                               				 Ext.getCmp("jishenCode").setValue(result.drivertrainingInfoData[0].harvesterBodyCode);
				                               				 Ext.getCmp("fadongjiCode").setValue(result.drivertrainingInfoData[0].harvesterEngineCode);
				                               				 
				                               				 Ext.getCmp("jiaoLianCheNum").setValue(result.drivertrainingInfoData[0].platecode+"."+Ynzc.manage.carnumber);
				                               				 Ext.getCmp("applicationUnit").setValue(result.drivertrainingInfoData[0].harvesterGuanXiaDi);
				                               				 Ext.getCmp("shouGeJiNum").setValue(result.drivertrainingInfoData[0].platecode+"."+result.drivertrainingInfoData[0].harvesterCode);
				                               				
				                               				 Ext.getCmp("registDate").setValue(new Date(result.drivertrainingInfoData[0].registerDate.time).format('Y-m-d'));
				                               				 Ext.getCmp("baoxianType").setValue("交强险");
				                               				 Ext.getCmp("baoxianName").setValue("请选择保险公司名称");
				                               				 Ext.getCmp("dengjiMan").setValue(result.drivertrainingInfoData[0].registman);
				                               				 Ext.getCmp("paizhengMan").setValue(result.drivertrainingInfoData[0].paizhengman);
				                               				 Ext.getCmp("lingdaoMan").setValue(result.drivertrainingInfoData[0].leaderman);
			                               				 }
                            				 		}
                            				 	},
                            				 	params:{
                            				 		cardcode:Ext.getCmp("carnum").getValue()
                            				 	}
                            				 });
                            				 Ext.getCmp("enteyNum").close();
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
                                        Ext.ux.Toast.msg("提示","请选中要删除的教练机年检信息!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的教练机年检信息?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/drivertrainingCheckInfo.html?action=deleteDrivertrainingCheckInfo",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的教练机年检信息");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        drivertrainingCheckInfoList:Ext.util.JSON.encode(rds)
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
                    Ynzc.manage.DrivertrainingCheckInfoGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                    this.on("rowdblclick",function(grid,index,event){
                        var record=grid.getStore().getAt(index);
                        Ext.Ajax.request({
                        	url:'main/drivertrainingInfo.html?action=findDrivertraingTractorinfoViewByid',
                        	success:function(data){
                        		 var result=Ext.util.JSON.decode(data.responseText);
                        		 if(record.data.carType==1){
                        			 var updateWin=new Ynzc.manage.DrivertrainingCheckInfoGridUpdate(); 
                       				 updateWin.show();
                            		 Ext.getCmp("username").setValue(result.drivertrainingInfoData[0].owner);
                       				 Ext.getCmp("isunitOrPeople").setValue(result.drivertrainingInfoData[0].isUnion);
                       				 Ext.getCmp("address").setValue(result.drivertrainingInfoData[0].address);
                       				 Ext.getCmp("certificatename").setValue(result.drivertrainingInfoData[0].realcertificatetypeid);
                       				 Ext.getCmp("telephone").setValue(result.drivertrainingInfoData[0].telephone);
                       				 Ext.getCmp("isTempLive").setValue(result.drivertrainingInfoData[0].istemplived);
                       				 Ext.getCmp("postCode").setValue(result.drivertrainingInfoData[0].zipCode);
                       				 Ext.getCmp("certificateCode").setValue(result.drivertrainingInfoData[0].realcertificateno);
                       				 Ext.getCmp("pinpaiType").setMyValue(result.drivertrainingInfoData[0].machinebrandtypeid);
                       				 Ext.getCmp("jixieType").setValue(result.drivertrainingInfoData[0].machinetypeid);
                       				 Ext.getCmp("jishenCode").setValue(result.drivertrainingInfoData[0].machinebodyno);
                       				 Ext.getCmp("fadongjiCode").setValue(result.drivertrainingInfoData[0].engineno);
                       				 Ext.getCmp("registDate").setValue(new Date(result.drivertrainingInfoData[0].registerdate.time).format('Y-m-d'));
                       				 Ext.getCmp("turninDate").setValue(new Date(result.drivertrainingInfoData[0].turnindate.time).format('Y-m-d'));
                       				 Ext.getCmp("fapaiDate").setValue(new Date(result.drivertrainingInfoData[0].issuedate.time).format('Y-m-d'));
                       				 Ext.getCmp("shengchanDate").setValue(new Date(result.drivertrainingInfoData[0].manufacturedate.time).format('Y-m-d'));
                       				 Ext.getCmp("baoxianType").setValue("交强险");
                       				 Ext.getCmp("baoxianName").setValue("1");
                       				 Ext.getCmp("dengjiMan").setValue(result.drivertrainingInfoData[0].reviewer);
                       				 Ext.getCmp("dengjiDate").setValue(new Date(result.drivertrainingInfoData[0].reviewerconductdate.time).format('Y-m-d'));
                       				 Ext.getCmp("paizhengMan").setValue(result.drivertrainingInfoData[0].issueadmin);
                       				 Ext.getCmp("paizhengDate").setValue(new Date(result.drivertrainingInfoData[0].issueadmindate.time).format('Y-m-d'));
                       				 Ext.getCmp("lingdaoMan").setValue(result.drivertrainingInfoData[0].leaderreview);
                       				 Ext.getCmp("lingdaoDate").setValue(new Date(result.drivertrainingInfoData[0].leaderreviewconductdate.time).format('Y-m-d'));
                       				 Ext.getCmp("checkResult").setValue(record.data.checkResult);
                       				 Ext.getCmp("checkLiveDate").setValue(new Date(record.get("checkLiveDate").time).format('Y-m-d'));
                       				 Ext.getCmp("checkMan").setValue(record.data.checkMan);
                       				 Ext.getCmp("checkDate").setValue(new Date(record.get("checkDate").time).format('Y-m-d'));
                       				 Ext.getCmp("checkNowResult").setValue(record.data.checkResult);
                       				 Ext.getCmp("checknowLiveDate").setValue(new Date(record.get("checkLiveDate").time).format('Y-m-d'));
                       				 Ext.getCmp("checkNowMan").setValue(record.data.checkMan);
                       				 Ext.getCmp("checkNowDate").setValue(new Date(record.get("checkDate").time).format('Y-m-d'));
                       				 Ext.getCmp("baodanCode").setValue(record.data.insurceCode);
                       				 Ext.getCmp("baoxianDate").setValue(new Date(record.get("insurceDate").time).format('Y-m-d'));
                       				 Ext.getCmp("baoxianName").setValue(record.data.insurceName);
                       				 Ext.getCmp("baoxianLiveDate").setValue(new Date(record.get("insurceActiveDate").time).format('Y-m-d'));
                       				 Ext.getCmp("baoxianType").setValue(record.data.insurceType);
                       				 Ext.getCmp("checkUnitName").setValue(record.data.checkUnitName);
                       				 Ynzc.manage.drivertraininfoId=record.data.id;//教练车id
                       				 Ynzc.manage.drivertraincheckinfoId=record.data.drivingcheckid;//教练车年检id
                        		 }else{
                        			 var addwin=new Ynzc.manage.DrivertrainingCheckInfoGridUniteharvestUpdate();
                       				 addwin.show(Ext.getCmp("userAdd").getEl());
                   					 Ext.getCmp("username").setValue(result.drivertrainingInfoData[0].harvesterOwner);
                       				 Ext.getCmp("isunitOrPeople").setValue(result.drivertrainingInfoData[0].liveType);
                       				 Ext.getCmp("address").setValue(result.drivertrainingInfoData[0].liveAddress);
                       				 Ext.getCmp("certificatename").setValue(result.drivertrainingInfoData[0].certitype);
                       				 Ext.getCmp("telephone").setValue(result.drivertrainingInfoData[0].telephoneNum);
                       				 Ext.getCmp("isTempLive").setValue(result.drivertrainingInfoData[0].liveType);
                       				 Ext.getCmp("postCode").setValue(result.drivertrainingInfoData[0].livePostCode);
                       				 Ext.getCmp("certificateCode").setValue(result.drivertrainingInfoData[0].certiCode);
                       				 Ext.getCmp("pinpaiType").setValue(result.drivertrainingInfoData[0].harvesterChangPaiType);
                       				 Ext.getCmp("jixieType").setValue(result.drivertrainingInfoData[0].harvesterType);
                       				 Ext.getCmp("jishenCode").setValue(result.drivertrainingInfoData[0].harvesterBodyCode);
                       				 Ext.getCmp("fadongjiCode").setValue(result.drivertrainingInfoData[0].harvesterEngineCode);
                       				 
                       				 Ext.getCmp("jiaoLianCheNum").setValue(record.data.platecode+"."+record.data.cardCode+"学");
                      				 Ext.getCmp("applicationUnit").setValue(record.data.unitName);
                      				 Ext.getCmp("shouGeJiNum").setValue(record.data.platecode+"."+record.data.tractorinfoIdCode);
                      				 
                       				 Ext.getCmp("registDate").setValue(new Date(result.drivertrainingInfoData[0].registerDate.time).format('Y-m-d'));
                       				 Ext.getCmp("baoxianType").setValue("交强险");
                       				 Ext.getCmp("baoxianName").setValue("请选择保险公司名称");
                       				 Ext.getCmp("dengjiMan").setValue(result.drivertrainingInfoData[0].registman);
                       				 Ext.getCmp("paizhengMan").setValue(result.drivertrainingInfoData[0].paizhengman);
                       				 Ext.getCmp("lingdaoMan").setValue(result.drivertrainingInfoData[0].leaderman);
                       				 Ext.getCmp("checkResult").setValue(record.data.checkResult);
                       				 Ext.getCmp("checkLiveDate").setValue(new Date(record.get("checkLiveDate").time).format('Y-m-d'));
                       				 Ext.getCmp("checkMan").setValue(record.data.checkMan);
                       				 Ext.getCmp("checkDate").setValue(new Date(record.get("checkDate").time).format('Y-m-d'));
                       				 Ext.getCmp("checkNowResult").setValue(record.data.checkResult);
                       				 Ext.getCmp("checknowLiveDate").setValue(new Date(record.get("checkLiveDate").time).format('Y-m-d'));
                       				 Ext.getCmp("checkNowMan").setValue(record.data.checkMan);
                       				 Ext.getCmp("checkNowDate").setValue(new Date(record.get("checkDate").time).format('Y-m-d'));
                       				 Ext.getCmp("baodanCode").setValue(record.data.insurceCode);
                       				 Ext.getCmp("baoxianDate").setValue(new Date(record.get("insurceDate").time).format('Y-m-d'));
                       				 Ext.getCmp("baoxianName").setValue(record.data.insurceName);
                       				 Ext.getCmp("baoxianLiveDate").setValue(new Date(record.get("insurceActiveDate").time).format('Y-m-d'));
                       				 Ext.getCmp("baoxianType").setValue(record.data.insurceType);
                       				 Ext.getCmp("checkUnitName").setValue(record.data.checkUnitName);
                       				 Ynzc.manage.drivertraininfoId=record.data.id;//教练车id
                       				 Ynzc.manage.drivertraincheckinfoId=record.data.drivingcheckid;//教练车年检id
                        		 } 
                        	},
                        	params:{
                        		id:record.data.tractorinfoId,
                        		carType:record.data.carType
                        	}
                        }); 	
                    });
                }
});
Ext.reg('DrivertrainingCheckInfoGrid',Ynzc.manage.DrivertrainingCheckInfoGrid);