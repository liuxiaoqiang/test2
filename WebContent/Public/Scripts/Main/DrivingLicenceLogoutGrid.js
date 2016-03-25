Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.DrivingLicenceLogoutGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'drivingLicenceLogoutGrid',
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
	            name : 'drivingLicenceId'
	        },{
	            name : 'peopleInfoId'
	        },{
	            name : 'bodyInfoId'
	        },{
	            name : 'proveType'
	        },{
	            name : 'proveId'
	        },{
	            name : 'causation'
	        },{
	            name : 'shiftToAddress'
	        },{
	            name : 'auditingShiftToFlag'
	        },{
	            name : 'auditingShiftToDate'
	        },{
	            name : 'registerTransactor'
	        },{
	            name : 'registerTransactorDate'
	        },{
	            name : 'auditingTransactor'
	        },{
	            name : 'auditingTransactorDate'
	        },{
	            name : 'putOutTransactor'
	        },{
	            name : 'putOutTransactorDate'
	        },{
	            name : 'pigeonholeTransactor'
	        },{
	            name : 'pigeonholeTransactorDate'
	        },{
	            name : 'year'
	        },{
	            name : 'state'
	        },{
	            name : 'pigeonholeFlag'
	        },{
	            name : 'pigeonholeDate'
	        },{
	            name : 'writeUserId'
	        },{
	            name : 'writeDate'
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
            url:'main/drivingLicenceLogout.html?action=getDrivingLicenceLogout',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
        	id:'drivingLicenceLogoutGrid',
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
        		text:"业务办理",
        		iconCls:"icon-Add",
        		handler:function(){
	        		Ynzc.manage.addLicenceLogoutwin=new Ynzc.manage.DrivingLicenceLogoutWin();
	        		Ynzc.manage.addLicenceLogoutwin.show();
	        		Ynzc.manage.winName = "drivingLicenceLogoutWin";
        		}
        	},'-',{
                text:"业务上报",
                iconCls:"icon-Add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要上报的信息!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(selections[i].data.state >= 1){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]已经上报审核!");
                            return;
                    	}else{
	                    	if(rds.length == 0){
	                    		rds = rds + selections[i].data.id;
	                    	}else{
	                    		rds = rds + "," + selections[i].data.id;
	                    	}
                    	}
                    }
                     Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认上报选中的驾驶员信息?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicenceLogout.html?action=changeState",
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
                                        id:rds
                                    }
                                });
                            }
                        }
                     });
                }.createDelegate(this)
            },'-',{
        		text:"业务表格打印",
        		iconCls:"icon-Add",
        		handler:function(){
	        		var selections=this.selModel.getSelections();
	        		var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要打印业务表格的驾驶员!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","请逐一打印业务表格!");
                        return;
                    }
                    Ext.Ajax.request({
                    	url:"main/word.html?action=findWordSet",
                        method:"post",
                        success:function(response){
                    		var result=Ext.util.JSON.decode(response.responseText);
                    		Ynzc.manage.topMargin=result.data.topMargin;
                    		Ynzc.manage.bottomMargin=result.data.bottomMargin;
                    		Ynzc.manage.leftMargin=result.data.leftMargin;
                    		Ynzc.manage.rightMargin=result.data.rightMargin;
                    		Ynzc.manage.id=result.data.id;
                    		Ynzc.manage.unitid=result.data.unitid;
                    		Ynzc.manage.wordtype=result.data.wordtype;
                    		Ynzc.manage.cnWord=result.data.cnWord;
                    				},
                        failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                        params:{
                        	wordType:"licenseApplicationReport",
                        	ChWord:"拖拉机驾驶证申请表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
                        	}
                    });
            		new Ynzc.manage.ReportWin(
        				{
        					title:'打印',
        					sourceURL:'main/reportPeopleInfo.html?action=getPeopleInfoReport',
        					params:{id:selections[0].data.drivingLicenceId,functionType:'',wordType:'licenseApplicationReport'}
        				}
        			).show();

            	}.createDelegate(this)
        	},'-',{
                text:"删除",
                iconCls:"icon-Del",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要删除的信息!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(selections[i].data.state >= 1){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]已经上报审核!");
                            return;
                    	}else{
	                    	if(rds.length == 0){
	                    		rds = rds + selections[i].data.id;
	                    	}else{
	                    		rds = rds + "," + selections[i].data.id;
	                    	}
                    	}
                    }
                     Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认删除选中的驾驶员信息?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicenceLogout.html?action=delDrivingLicenceLogout",
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
                                        id:rds
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
        Ynzc.manage.DrivingLicenceLogoutGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
        	params:{
	        	start:0,
	        	limit:20
        	}
        });
        this.on("rowdblclick",function(grid,index,event){
            var record=grid.getStore().getAt(index);
        	if(record.data.state >= 1){
                Ext.MessageBox.alert("提示","[<font color=blue>"+record.data.peopleName+"</font>]已经上报审核不能修改!");
                return;
        	}
        	Ynzc.manage.updateLicenceLogoutwin= new Ynzc.manage.DrivingLicenceLogoutUpdateWin();
        	Ynzc.manage.updateLicenceLogoutwin.show();
            Ynzc.manage.DrivingLicenceLogoutId=record.data.id;
			Ext.getCmp("causation").setValue(record.data.causation);
			Ext.getCmp("proveType").setValue(record.data.proveType);
			Ext.getCmp("proveId").setValue(record.data.proveId);
			Ext.getCmp("drivingLicenceNo").setValue(record.data.drivingLicenceNo);
			Ext.getCmp("drivingLicenceTypeId").setValue(record.data.drivingLicenceTypeId);
			Ext.getCmp("startDate").setValue(new Date(record.data.startDate.time).format('Y-m-d'));
			Ext.getCmp("endDate").setValue(new Date(record.data.endDate.time).format('Y-m-d'));
			Ext.getCmp("drivingLicenceFlag").setValue(record.data.drivingLicenceFlag);
			Ext.getCmp("putOutDate").setValue(new Date(record.data.putOutDate.time).format('Y-m-d'));
			Ext.getCmp("userState").setValue(record.data.userState);
    		Ext.getCmp("peopleName").setValue(record.data.peopleName);
            Ext.getCmp("sex").setValue(record.data.sex);
            Ext.getCmp("birthday").setValue(new Date(record.data.birthday.time).format('Y-m-d'));
            Ext.getCmp("idCard").setValue(record.data.idCard);
            Ext.getCmp("idStay").setValue(record.data.idStay);
            Ext.getCmp("address").setValue(record.data.address);
            Ext.getCmp("linkAddress").setValue(record.data.linkAddress);
            Ext.getCmp("linkTel").setValue(record.data.linkTel);
            Ext.getCmp("postalcode").setValue(record.data.postalcode);
            Ext.getCmp("nativePlace").setValue(record.data.nativePlace);
            Ext.getCmp("degree").setValue(record.data.degree);
            Ext.getCmp("picture").getEl().dom.src = record.data.picture;
            Ext.getCmp("hight").setValue(record.data.hight);
            if(record.data.resolvingPowerFlag>0){
            	Ext.getCmp("resolvingPowerFlag").setValue("正常");
            }else{
            	Ext.getCmp("resolvingPowerFlag").setValue("异常");
            }
            Ext.getCmp("rightEyePwoer").setValue(record.data.rightEyePwoer);
            if(record.data.rightEyeRectificationFlag>0){
            	Ext.getCmp("rightEyeRectificationFlag").setValue("是");
            }else{
            	Ext.getCmp("rightEyeRectificationFlag").setValue("否");
            }
            Ext.getCmp("leftEyePwoer").setValue(record.data.leftEyePwoer);
            if(record.data.rightEyeRectificationFlag>0){
            	Ext.getCmp("leftEyeRectificationFlag").setValue("是");
            }else{
            	Ext.getCmp("leftEyeRectificationFlag").setValue("否");
            }
            if(record.data.rightEarPwoer>0){
            	Ext.getCmp("rightEarPwoer").setValue("正常");
            }else{
            	Ext.getCmp("rightEarPwoer").setValue("异常");
            }
            if(record.data.leftEarPwoer>0){
            	Ext.getCmp("leftEarPwoer").setValue("正常");
            }else{
            	Ext.getCmp("leftEarPwoer").setValue("异常");
            }
            if(record.data.rightHandFlag>0){
            	Ext.getCmp("rightHandFlag").setValue("正常");
            }else{
            	Ext.getCmp("rightHandFlag").setValue("异常");
            }
            if(record.data.leftHandFlag>0){
            	Ext.getCmp("leftHandFlag").setValue("正常");
            }else{
            	Ext.getCmp("leftHandFlag").setValue("异常");
            }
            if(record.data.rightLagFlag>0){
            	Ext.getCmp("rightLagFlag").setValue("正常");
            }else{
            	Ext.getCmp("rightLagFlag").setValue("异常");
            }
            if(record.data.leftLagFlag>0){
            	Ext.getCmp("leftLagFlag").setValue("正常");
            }else{
            	Ext.getCmp("leftLagFlag").setValue("异常");
            }
            if(record.data.bodyNeck>0){
            	Ext.getCmp("bodyNeck").setValue("正常");
            }else{
            	Ext.getCmp("bodyNeck").setValue("异常");
            }
            Ext.getCmp("bodyCheckDate").setValue(new Date(record.data.bodyCheckDate.time).format('Y-m-d'));
            if(record.data.checkResultFlag>0){
            	Ext.getCmp("checkResultFlag").setValue("合格");
            }else{
            	Ext.getCmp("checkResultFlag").setValue("不合格");
            }
            Ext.getCmp("checkOrganization").setValue(record.data.checkOrganization);
            Ext.getCmp("checkDoctor").setValue(record.data.checkDoctor);
        });
	}
});
Ext.reg('drivingLicenceLogoutGrid',Ynzc.manage.DrivingLicenceLogoutGrid);