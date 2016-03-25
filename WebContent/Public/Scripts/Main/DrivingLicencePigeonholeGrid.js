Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.DrivingLicencePigeonholeGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'drivingLicencePigeonholeGrid',
	initComponent:function(){
	    var sm=new Ext.grid.CheckboxSelectionModel();
	    var fm=Ext.form;
	    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
	        header:'业务名称',
	        sortable:true,
	        dataIndex:"operationNameType",
            renderer : function(value) {
                var index = Ynzc.manage.OperationTypeStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.OperationTypeStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                 }
            }
	    },{
	        header:'姓名',
	        sortable:true,
	        dataIndex:"peopleName"
	    },{
	    	header:'身份证',
	        sortable:true,
	        dataIndex:"idCard"
	    },{
	        header:'驾照类型',
	        sortable:true,
	        dataIndex:"drivingLicenceTypeId",
            renderer : function(value) {
                var index = Ynzc.manage.ApplicationTypeStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.ApplicationTypeStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
	    },{
	        header:'开始日期',
	        sortable:true,
	        dataIndex:"startDate",
            renderer:function(value){
		    	if(value != null){
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
		    	}else{
		    		return "";
		    	}
			}
	    },{
	        header:'结束日期',
	        sortable:true,
	        dataIndex:"endDate",
            renderer:function(value){
		    	if(value != null){
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
		    	}else{
		    		return "";
		    	}
			}
	    },{
	        header:'身体检查结果',
	        sortable:true,
	        dataIndex:"checkResultFlag",
            renderer:function(value){
	        	if(value > 0){
	        		return "合格";
	        	}else{
	        		return "不合格";
	        	}
	    	}
	    },{
	        header:'是否打印',
	        sortable:true,
	        dataIndex:"drivingLicenceFlag",
            renderer:function(value){
	        	if(value > 0){
	        		return "已打印";
	        	}else{
	        		return "未打印";
	        	}
	    	}
	    },{
	        header:'打印日期',
	        sortable:true,
	        dataIndex:"putOutDate",
            renderer:function(value){
		    	if(value != null){
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
		    	}else{
		    		return "";
		    	}
			}
	    },{
	        header:'使用状态',
	        sortable:true,
	        dataIndex:"userState",
            renderer : function(value) {
                var index = Ynzc.manage.UserStateStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.UserStateStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
	    },{
	        header:'状态',
	        sortable:true,
	        dataIndex:"state",
            renderer : function(value) {
                var index = Ynzc.manage.DrivingLicenceDeclareStateStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.DrivingLicenceDeclareStateStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
	    },{
	        header:'归档',
	        sortable:true,
	        dataIndex:"pigeonholeFlag",
            renderer : function(value) {
	        	if(value == 1){
	        		return "已归";
	        	}else if(value == -1){
	        		return "未归";
	        	}else{
	        		return "不归";
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
	            name : 'pigeonholeFlag'
	        },{
	            name : 'operationNameType'
	        },{
	            name : 'bodyInfoId'
	        },{
	            name : 'drivingLicenceId'
	        },{
	            name : 'causation'
	        },{
	            name : 'state'
	        },{
	            name : 'drivingLicenceNo'
	        },{
	            name : 'drivingLicenceTypeId'
	        },{
	            name : 'mark'
	        },{
	            name : 'startDate'
	        },{
	            name : 'endDate'
	        },{
	            name : 'drivingLicenceFlag'
	        },{
	            name : 'putOutDate'
	        },{
	            name : 'userState'
	        },{
	            name : 'peopleName'
	        },{
	            name : 'sex'
	        },{
	            name : 'birthday'
	        },{
	            name : 'idCard'
	        },{
	            name : 'idStay'
	        },{
	            name : 'address'
	        },{
	            name : 'linkAddress'
	        },{
	            name : 'linkTel'
	        },{
	            name : 'postalcode'
	        },{
	            name : 'nativePlace'
	        },{
	            name : 'degree'
	        },{
	            name : 'picture'
	        },{
	            name : 'hight'
	        },{
	            name : 'resolvingPowerFlag'
	        },{
	            name : 'rightEyePwoer'
	        },{
	            name : 'rightEyeRectificationFlag'
	        },{
	            name : 'leftEyePwoer'
	        },{
	            name : 'leftEyeRectificationFlag'
	        },{
	            name : 'rightEarPwoer'
	        },{
	            name : 'leftEarPwoer'
	        },{
	            name : 'rightHandFlag'
	        },{
	            name : 'leftHandFlag'
	        },{
	            name : 'rightLagFlag'
	        },{
	            name : 'leftLagFlag'
	        },{
	            name : 'bodyNeck'
	        },{
	            name : 'bodyCheckDate'
	        },{
	            name : 'checkResultFlag'
	        },{
	            name : 'checkOrganization'
	        },{
	            name : 'checkDoctor'
	        }]
	    });
        var ds=new Ext.data.Store({
            scopte:this,
            url:'main/drivingLicenceOperation.html?action=getDrivingLicenceOperation',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'drivingLicencePigeonholeGrid',
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
                id : 'operationType',
                xtype:"combo",
                displayField : 'display',
                valueField : 'value',
                typeAhead : true,
                mode : 'local',
                editable : false,
                selectOnFoucs : true,
                triggerAction : 'all',
                emptyText:"菜单分类选择",
                store:Ynzc.manage.OperationTypeStore,
                listeners:{
                    "select":function(){
            			ds.baseParams.type = this.value;
                        ds.load({
                            params:{
                                start:0,
                                limit:20
                            }
                        });
                    }
                }
            },'-',{
                id:"driverClassInfoPass",
                text:"归档",
                iconCls:"icon-Add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中需要操作的记录!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","选择驾驶员过多，请逐一归档!");
                        return;
                    }
                    Ext.Msg.show({
                    	title:'系统确认',
                        msg:'你是否确认该记录归档?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicencePigeonhole.html?action=pigeonholePass",
                                    method:"post",
                                    success:function(resp){
            							var result=Ext.util.JSON.decode(resp.responseText);
        								if(result.success==true){
        									Ext.MessageBox.alert("提示",result.reason);
        			                        ds.reload({
        			                            params:{
        			                                type:Ext.getCmp("operationType").getValue(),
        			                                start:0,
        			                                limit:20
        			                            }
        			                        });
        								}else{
        									Ext.MessageBox.alert("提示",result.reason);
        								}
                                    },
                                    faliure:function(){
                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                    },
                                    params:{
                                        id:selections[0].data.id,
                                        type:Ext.getCmp("operationType").getValue()
                                    }
                                });
                            }
                        }
                     });
                }.createDelegate(this)
            },'-',{
                id:"driverClassInfoPass",
                text:"不归档",
                iconCls:"icon-Del",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中需要操作的记录!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","选择驾驶员过多，请逐一归档!");
                        return;
                    }
                    Ext.Msg.show({
                    	title:'系统确认',
                        msg:'你是否确认该记录归档?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicencePigeonhole.html?action=pigeonholeUnPass",
                                    method:"post",
                                    success:function(resp){
            							var result=Ext.util.JSON.decode(resp.responseText);
        								if(result.success==true){
        									Ext.MessageBox.alert("提示",result.reason);
        									ds.reload();
        								}else{
        									Ext.MessageBox.alert("提示",result.reason);
        								}
                                    },
                                    faliure:function(){
                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                    },
                                    params:{
                                        id:selections[0].data.id,
                                        type:Ext.getCmp("operationType").getValue()
                                    }
                                });
                            }
                        }
                     });
                }.createDelegate(this)
            },'-',{
                id:'refresh',
                text:'刷新',
                iconCls:'icon-Add',
                handler:function(){
        			ds.reload();
            	}
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
        this.on("rowdblclick",function(grid,index,event){
        	var record=grid.getStore().getAt(index);
        	var type = Ext.getCmp("operationType").getValue();
            Ext.Ajax.request({
                url:"main/drivingLicenceOperation.html?action=findDrivingLicenceOperationInfo",
                method:"post",
                success:function(resp){
            		var result = Ext.util.JSON.decode(resp.responseText);
					if(type == 1){
						Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceChangeInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("changeName").setValue(result.data[0].changeName);
						Ext.getCmp("changeIdCard").setValue(result.data[0].changeIdCard);
						Ext.getCmp("changeBirthday").setValue(new Date(result.data[0].changeBirthday.time).format('Y-m-d'));
						Ext.getCmp("changeAddress").setValue(result.data[0].changeAddress);
						Ext.getCmp("changeLinkAddress").setValue(result.data[0].changeLinkAddress);
						Ext.getCmp("changeLinkTel").setValue(result.data[0].changeLinkTel);
						Ext.getCmp("drivingLicenceNo").setValue(result.data[0].drivingLicenceNo);
						Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(result.data[0].drivingLicenceTypeId));
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("drivingLicenceFlag").setValue(result.data[0].drivingLicenceFlag);
						Ext.getCmp("putOutDate").setValue(new Date(result.data[0].putOutDate.time).format('Y-m-d'));
						Ext.getCmp("userState").setValue(result.data[0].userState);
					}else if(type == 2){
						Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceTermInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("changeHight").setValue(result.data[0].hight);
						if(result.data[0].resolvingPowerFlag>0){Ext.getCmp("changeResolvingPowerFlag").setValue("正常");}else{Ext.getCmp("changeResolvingPowerFlag").setValue("异常");}
						Ext.getCmp("changeRightEyePwoer").setValue(result.data[0].rightEyePwoer);
						if(result.data[0].rightEyeRectificationFlag>0){Ext.getCmp("changeRightEyeRectificationFlag").setValue("是");}else{Ext.getCmp("changeRightEyeRectificationFlag").setValue("否");}
						Ext.getCmp("changeLeftEyePwoer").setValue(result.data[0].leftEyePwoer);
						if(result.data[0].leftEyeRectificationFlag>0){Ext.getCmp("changeLeftEyeRectificationFlag").setValue("是");}else{Ext.getCmp("changeLeftEyeRectificationFlag").setValue("否");}
						Ext.getCmp("changeRightEarPwoer").setValue(result.data[0].rightEarPwoer);
						Ext.getCmp("changeLeftEarPwoer").setValue(result.data[0].leftEarPwoer);
						if(result.data[0].rightHandFlag>0){Ext.getCmp("changeRightHandFlag").setValue("正常");}else{Ext.getCmp("changeRightHandFlag").setValue("异常");}
						if(result.data[0].leftHandFlag>0){Ext.getCmp("changeLeftHandFlag").setValue("正常");}else{Ext.getCmp("changeLeftHandFlag").setValue("异常");}
						if(result.data[0].rightLagFlag>0){Ext.getCmp("changeRightLagFlag").setValue("正常");}else{Ext.getCmp("changeRightLagFlag").setValue("异常");}
						if(result.data[0].leftLagFlag>0){Ext.getCmp("changeLeftLagFlag").setValue("正常");}else{Ext.getCmp("changeLeftLagFlag").setValue("异常");}
						if(result.data[0].bodyNeck>0){Ext.getCmp("changeBodyNeck").setValue("正常");}else{Ext.getCmp("changeBodyNeck").setValue("异常");}
						Ext.getCmp("changeBodyCheckDate").setValue(new Date(result.data[0].bodyCheckDate.time).format('Y-m-d'));
						if(result.data[0].checkResultFlag>0){Ext.getCmp("changeCheckResultFlag").setValue("合格");}else{Ext.getCmp("changeCheckResultFlag").setValue("不合格");}
						Ext.getCmp("changeCheckOrganization").setValue(result.data[0].checkOrganization);
						Ext.getCmp("changeCheckDoctor").setValue(result.data[0].checkDoctor);
					}else if(type == 3){
						Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceDefileInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("causation").setValue(result.data[0].causation);
						if(result.data[0].proveType == 1){
							Ext.getCmp("proveType").setValue("身份证");
						}else{
							Ext.getCmp("proveType").setValue("暂住证");
						}
						Ext.getCmp("proveId").setValue(result.data[0].proveId);
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("drivingLicenceFlag").setValue(result.data[0].drivingLicenceFlag);
						Ext.getCmp("putOutDate").setValue(new Date(result.data[0].putOutDate.time).format('Y-m-d'));
						Ext.getCmp("userState").setValue(result.data[0].userState);
						Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(result.data[0].drivingLicenceTypeId));
					}else if(type == 4){
						Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceRepairInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("causation").setValue(result.data[0].causation);
						if(result.data[0].proveType == 1){
							Ext.getCmp("proveType").setValue("身份证");
						}else{
							Ext.getCmp("proveType").setValue("暂住证");
						}
						Ext.getCmp("proveId").setValue(result.data[0].proveId);
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("drivingLicenceFlag").setValue(result.data[0].drivingLicenceFlag);
						Ext.getCmp("putOutDate").setValue(new Date(result.data[0].putOutDate.time).format('Y-m-d'));
						Ext.getCmp("userState").setValue(result.data[0].userState);
						Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(result.data[0].drivingLicenceTypeId));					
					}else if(type == 5){
						Ynzc.manage.Window = new Ynzc.manage.DrivinglicenceGotoInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("causation").setValue(result.data[0].causation);
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("mark").setValue(result.data[0].mark);
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("drivingLicenceFlag").setValue(result.data[0].drivingLicenceFlag);
						Ext.getCmp("putOutDate").setValue(new Date(result.data[0].putOutDate.time).format('Y-m-d'));
						Ext.getCmp("userState").setValue(result.data[0].userState);
						Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(result.data[0].drivingLicenceTypeId));
					}else if(type == 6){
						Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceShiftToInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("causation").setValue(result.data[0].causation);
						Ext.getCmp("shiftToAddress").setValue(result.data[0].shiftToAddress);
						if(result.data[0].proveType == 1){
							Ext.getCmp("proveType").setValue("身份证");
						}else{
							Ext.getCmp("proveType").setValue("暂住证");
						}
						Ext.getCmp("proveId").setValue(result.data[0].proveId);
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("drivingLicenceFlag").setValue(result.data[0].drivingLicenceFlag);
						Ext.getCmp("putOutDate").setValue(new Date(result.data[0].putOutDate.time).format('Y-m-d'));
						Ext.getCmp("userState").setValue(result.data[0].userState);
						Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(result.data[0].drivingLicenceTypeId));
					}else if(type == 7){
						Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceLogoutInfoWin();
						Ynzc.manage.Window.show();
						Ext.getCmp("causation").setValue(result.data[0].causation);
						if(result.data[0].proveType == 1){
							Ext.getCmp("proveType").setValue("身份证");
						}else{
							Ext.getCmp("proveType").setValue("暂住证");
						}
						Ext.getCmp("proveId").setValue(result.data[0].proveId);
						Ext.getCmp("startDate").setValue(new Date(result.data[0].startDate.time).format('Y-m-d'));
						Ext.getCmp("endDate").setValue(new Date(result.data[0].endDate.time).format('Y-m-d'));
						Ext.getCmp("drivingLicenceFlag").setValue(result.data[0].drivingLicenceFlag);
						Ext.getCmp("putOutDate").setValue(new Date(result.data[0].putOutDate.time).format('Y-m-d'));
						Ext.getCmp("userState").setValue(result.data[0].userState);
						Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(result.data[0].drivingLicenceTypeId));
					}
					Ext.getCmp("peopleName").setValue(result.data[0].peopleName);
		            Ext.getCmp("sex").setValue(result.data[0].sex);
		            Ext.getCmp("birthday").setValue(new Date(result.data[0].birthday.time).format('Y-m-d'));
		            Ext.getCmp("idCard").setValue(result.data[0].idCard);
		            Ext.getCmp("idStay").setValue(result.data[0].idStay);
		            Ext.getCmp("address").setValue(result.data[0].address);
		            Ext.getCmp("linkAddress").setValue(result.data[0].linkAddress);
		            Ext.getCmp("linkTel").setValue(result.data[0].linkTel);
		            Ext.getCmp("postalcode").setValue(result.data[0].postalcode);
		            Ext.getCmp("nativePlace").setValue(result.data[0].nativePlace);
		            Ext.getCmp("degree").setValue(result.data[0].degree);
		            Ext.getCmp("picture").autoEl.src = result.data[0].picture;
		            Ext.getCmp("hight").setValue(result.data[0].hight);
		            if(result.data[0].resolvingPowerFlag>0){Ext.getCmp("resolvingPowerFlag").setValue("正常");}else{Ext.getCmp("resolvingPowerFlag").setValue("异常");}
		            Ext.getCmp("rightEyePwoer").setValue(result.data[0].rightEyePwoer);
		            if(result.data[0].rightEyeRectificationFlag>0){Ext.getCmp("rightEyeRectificationFlag").setValue("是");}else{Ext.getCmp("rightEyeRectificationFlag").setValue("否");}
		            Ext.getCmp("leftEyePwoer").setValue(result.data[0].leftEyePwoer);
		            if(result.data[0].leftEyeRectificationFlag>0){Ext.getCmp("leftEyeRectificationFlag").setValue("是");}else{Ext.getCmp("leftEyeRectificationFlag").setValue("否");}
		            if(result.data[0].rightEarPwoer>0){Ext.getCmp("rightEarPwoer").setValue("正常");}else{Ext.getCmp("rightEarPwoer").setValue("异常");}
		            if(result.data[0].leftEarPwoer>0){Ext.getCmp("leftEarPwoer").setValue("正常");}else{Ext.getCmp("leftEarPwoer").setValue("异常");}
		            if(result.data[0].rightHandFlag>0){Ext.getCmp("rightHandFlag").setValue("正常");}else{Ext.getCmp("rightHandFlag").setValue("异常");}
		            if(result.data[0].leftHandFlag>0){Ext.getCmp("leftHandFlag").setValue("正常");}else{Ext.getCmp("leftHandFlag").setValue("异常");}
		            if(result.data[0].rightLagFlag>0){Ext.getCmp("rightLagFlag").setValue("正常");}else{Ext.getCmp("rightLagFlag").setValue("异常");}
		            if(result.data[0].leftLagFlag>0){Ext.getCmp("leftLagFlag").setValue("正常");}else{Ext.getCmp("leftLagFlag").setValue("异常");}
		            if(result.data[0].bodyNeck>0){Ext.getCmp("bodyNeck").setValue("正常");}else{Ext.getCmp("bodyNeck").setValue("异常");}
		            Ext.getCmp("bodyCheckDate").setValue(new Date(result.data[0].bodyCheckDate.time).format('Y-m-d'));
		            if(result.data[0].checkResultFlag>0){Ext.getCmp("checkResultFlag").setValue("合格");}else{Ext.getCmp("checkResultFlag").setValue("不合格");}
		            Ext.getCmp("checkOrganization").setValue(result.data[0].checkOrganization);
		            Ext.getCmp("checkDoctor").setValue(result.data[0].checkDoctor);
                },
                faliure:function(){
                    Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                },
                params:{
                    id:record.data.id,
                    type:type
                }
            });
        });
        Ynzc.manage.DrivingLicencePigeonholeGrid.superclass.initComponent.apply(this,arguments);
	}
});
Ext.reg('drivingLicencePigeonholeGrid',Ynzc.manage.DrivingLicencePigeonholeGrid);