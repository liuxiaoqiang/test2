Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.LeadExaminationTermGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'leadExaminationTermGrid',
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
	    }]);
	    var reader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
	            name : 'id'
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
            url:'main/drivingLicenceOperation.html?action=getDrivingLicenceTermOperation',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'leadExaminationTermGrid',
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
                text:"通过审核",
                iconCls:"icon-Add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中需要操作的班级!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","选择驾驶员过多，请逐一审核!");
                        return;
                    }
                	if(selections[0].data.state<1){
                		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]该条记录还未上报!");
                		return;
                	}
                	if(selections[0].data.state>=2){
                		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]已经审核过了!");
                		return;
                	}
                    Ext.Msg.show({
                    	title:'系统确认',
                        msg:'你是否确认该班级审核通过?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicenceOperation.html?action=examinationLicenceTermPass",
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
                                        id:selections[0].data.id
                                    }
                                });
                            }
                        }
                     });
                }.createDelegate(this)
            },'-',{
                text:"不通过审核",
                iconCls:"icon-Del",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中需要操作的班级!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","选择驾驶员过多，请逐一审核!");
                        return;
                    }
                	if(selections[0].data.state<1){
                		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]该条记录还未上报!");
                		return;
                	}
                	if(selections[0].data.state>=2){
                		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]已经审核过了!");
                		return;
                	}
                    Ext.Msg.show({
                    	title:'系统确认',
                        msg:'你是否确认该班级审核通过?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicenceOperation.html?action=examinationLicenceTermUnPass",
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
                                        id:selections[0].data.id
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
            Ext.Ajax.request({
                url:"main/drivingLicenceOperation.html?action=findDrivingLicenceTermOperationInfo",
                method:"post",
                success:function(resp){
            		var result = Ext.util.JSON.decode(resp.responseText);
					Ynzc.manage.Window = new Ynzc.manage.DrivingLicenceTermInfoWin();
					Ynzc.manage.Window.show();
					Ext.getCmp("changeHight").setValue(result.data[0].hight);
					Ext.getCmp("changeResolvingPowerFlag").setValue(result.data[0].resolvingPowerFlag);
					Ext.getCmp("changeRightEyePwoer").setValue(result.data[0].rightEyePwoer);
					Ext.getCmp("changeRightEyeRectificationFlag").setValue(result.data[0].rightEyeRectificationFlag);
					Ext.getCmp("changeLeftEyePwoer").setValue(result.data[0].leftEyePwoer);
					Ext.getCmp("changeLeftEyeRectificationFlag").setValue(result.data[0].leftEyeRectificationFlag);
					Ext.getCmp("changeRightEarPwoer").setValue(result.data[0].rightEarPwoer);
					Ext.getCmp("changeLeftEarPwoer").setValue(result.data[0].leftEarPwoer);
					Ext.getCmp("changeRightHandFlag").setValue(result.data[0].rightHandFlag);
					Ext.getCmp("changeLeftHandFlag").setValue(result.data[0].leftHandFlag);
					Ext.getCmp("changeRightLagFlag").setValue(result.data[0].rightLagFlag);
					Ext.getCmp("changeLeftLagFlag").setValue(result.data[0].leftLagFlag);
					Ext.getCmp("changeBodyNeck").setValue(result.data[0].bodyNeck);
					Ext.getCmp("changeBodyCheckDate").setValue(new Date(result.data[0].bodyCheckDate.time).format('Y-m-d'));
					Ext.getCmp("changeCheckResultFlag").setValue(result.data[0].checkResultFlag);
					Ext.getCmp("changeCheckOrganization").setValue(result.data[0].checkOrganization);
					Ext.getCmp("changeCheckDoctor").setValue(result.data[0].checkDoctor);
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
		            Ext.getCmp("picture").getEl().dom.src = record.model.picture;
		            Ext.getCmp("hight").setValue(result.data[0].hight);
		            if(result.data[0].resolvingPowerFlag>0){Ext.getCmp("resolvingPowerFlag").setValue("正常");}else{Ext.getCmp("resolvingPowerFlag").setValue("异常");}
		            Ext.getCmp("rightEyePwoer").setValue(result.data[0].rightEyePwoer);
		            if(result.data[0].rightEyeRectificationFlag>0){Ext.getCmp("rightEyeRectificationFlag").setValue("是");}else{Ext.getCmp("rightEyeRectificationFlag").setValue("否");}
		            Ext.getCmp("leftEyePwoer").setValue(result.data[0].leftEyePwoer);
		            if(result.data[0].rightEyeRectificationFlag>0){Ext.getCmp("leftEyeRectificationFlag").setValue("是");}else{Ext.getCmp("leftEyeRectificationFlag").setValue("否");}
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
                    id:record.data.id
                }
            });
        });
        Ynzc.manage.LeadExaminationTermGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
        	params:{
	        	start:0,
	        	limit:20
        	}
        });
	}
});
Ext.reg('leadExaminationTermGrid',Ynzc.manage.LeadExaminationTermGrid);