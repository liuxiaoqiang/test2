Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DriverStrInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'driverStrInfo',
	initComponent:function(){
	    var sm=new Ext.grid.CheckboxSelectionModel();
	    var fm=Ext.form;
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
				'<table width="600" height="420" border="1" class="ynzcTableBlue">',
				'<tr><td>姓名</td><td>{peopleName}</td><td>性别</td><td>{sex}</td><td rowspan="7"><img src="{picture}" width="100%" height="100%"/></td></tr>',
				'<tr><td>出生日期</td><td>{[new Date(values.birthday.time).format("Y-m-d")]}</td><td>身份证号</td><td>{idCard}</td></tr>',
				'<tr><td>暂住证</td><td>{idStay}</td><td>联系电话</td><td>{linkTel}</td></tr>',
				'<tr><td>邮政编码</td><td>{postalcode}</td><td>文化程度</td><td>{degree}</td></tr>',
				'<tr><td>籍贯</td><td>{nativePlace}</td><td>&nbsp;</td><td>&nbsp;</td></tr>',
				'<tr><td>家庭地址</td><td colspan="3">{address}</td></tr>',
				'<tr><td>联系地址</td><td colspan="3">{linkAddress}</td></tr>',
				'<tr><td>报考号</td><td>{examinationCode}</td><td>培养类型</td><td colspan="2">{[Ynzc.manage.FosterTypeStore.getAt(Ynzc.manage.FosterTypeStore.find("value", values.fosterType)).data.display]}</td></tr>',
				'<tr><td>申请地址</td><td>{applicationAddress}</td><td>申请型号</td><td colspan="2">{[Ynzc.manage.ApplicationTypeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.drivingLicenceTypeId)).data.display]}</td></tr>',
				'<tr><td>身高</td><td>{hight}</td><td>辨色力</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.resolvingPowerFlag)).data.display]}</td></tr>',
				'<tr><td>身体和颈椎</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.bodyNeck)).data.display]}</td><td>&nbsp;</td><td colspan="2">&nbsp;</td></tr>',
				'<tr><td>右眼视力</td><td>{rightEyePwoer}</td><td>右眼矫正</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.rightEyeRectificationFlag)).data.display]}</td></tr>',
				'<tr><td>左眼视力</td><td>{leftEyePwoer}</td><td>左眼矫正</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.leftEyeRectificationFlag)).data.display]}</td></tr>',
				'<tr><td>右耳听力</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightEarPwoer)).data.display]}</td><td>左耳听力</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftEarPwoer)).data.display]}</td></tr>',
				'<tr><td>右手</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightHandFlag)).data.display]}</td><td>左手</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftHandFlag)).data.display]}</td></tr>',
				'<tr><td>右脚</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightLagFlag)).data.display]}</td><td>左脚</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftLagFlag)).data.display]}</td></tr>',
				'<tr><td>身体检查时间</td><td>{[new Date(values.bodyCheckDate.time).format("Y-m-d")]}</td><td>检查机构</td><td colspan="2">{checkOrganization}</td></tr>',
				'<tr><td>检查医生</td><td>{checkDoctor}</td><td>检查结果</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.checkResultFlag)).data.display]}</td></tr>',
				'</table>'
			)
		});
	    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
	            header:'报考号',
	            sortable:true,
	            dataIndex:"examinationCode"
	        },{
	            header:'姓名',
	            sortable:true,
	            dataIndex:"peopleName"
	        },{
	            header:'准驾机型',
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
	            header:'培训类别',
	            sortable:true,
	            dataIndex:"fosterType",
	            renderer : function(value) {
	                var index = Ynzc.manage.FosterTypeStore.find("value", value);
	                if (index>=0) {
	                    var record = Ynzc.manage.FosterTypeStore.getAt(index);
	                    return record.data.display;
	                } else {
	                    return '未知类型';
	                }
	            }
	        },{
	            header:'性别',
	            sortable:true,
	            dataIndex:"sex"
	        },{
	            header:'身份证号',
	            sortable:true,
	            dataIndex:"idCard"
	        },{
	            header:'住址',
	            sortable:true,
	            dataIndex:"address"
	        },{
	            header:'学员状态',
	            sortable:true,
	            dataIndex:"strState",
	            renderer : function(value) {
	                var index = Ynzc.manage.StrStateStore.find("value", value);
	                if (index>=0) {
	                    var record = Ynzc.manage.StrStateStore.getAt(index);
	                    return record.data.display;
	                } else {
	                    return '未知类型';
	                }
	            }
	        },{
	            header:'是否审查通过',
	            sortable:true,
	            dataIndex:"applicationFlag",
	            renderer:function(value){
	        	if(value > 0){
	        		return "通过";
	        	}else{
	        		return "未通过";
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
                name : 'peopleInfoId'
            },{
                name : 'bodyInfoId'
            },{
                name : 'archivesNo'
            },{
                name : 'fosterType'
            },{
                name : 'applicationFlag'
            },{
                name : 'drivingLicenceTypeId'
            },{
                name : 'applicationAddress'
            },{
                name : 'examinationCode'
            },{
                name : 'pigeonholeFlag'
            },{
                name : 'pigeonholeDate'
            },{
                name : 'strState'
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
            },{
                name : 'year'
            },{
                name : 'writeUserId'
            },{
                name : 'writeDate'
            }]
	    });
        var ds=new Ext.data.Store({
            scopte:this,
            url:'main/driverStrInfo.html?action=getDriverStrInfo',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'driverStrInfo',
            plain:true,
            layout:'fit',
            border:false,
            cm:cm,
            sm:sm,
            frame:true,
            store:ds,
            loadMask:true,
            plugins:[expand,new Ext.ux.grid.Search({
                width:200,
                iconCls:false
            })],
            tbar:[{
                id:'driverStrInfoAdd',
                text:'添加',
                iconCls:'icon-Add',
                handler:function(){
	            	Ynzc.manage.addwin=new Ynzc.manage.DriverStrInfoWin();
	            	Ynzc.manage.addwin.show();
	            	Ext.getCmp("applicationAddress").setValue(UnitAddress);
                }
            },'-',{
                id:"driverStrInfoDel",
                text:"删除",
                iconCls:"icon-Del",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.ux.Toast.msg("提示","请选中要删除的学员!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(selections[i].data.strState >= 1){
                            Ext.ux.Toast.msg("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]已通过审核不能删除!");
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
                        msg:'你是否确认删除选中的学员信息?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverStrInfo.html?action=delDriverStrInfo",
                                    method:"post",
                                    success:function(resp){
            							var result=Ext.util.JSON.decode(resp.responseText);
        								if(result.success==true){
        									Ext.ux.Toast.msg("提示",result.reason);
        									ds.reload();
        								}else{
        									Ext.ux.Toast.msg("提示",result.reason);
        								}
                                    },
                                    faliure:function(){
                                        Ext.MessageBox.alert("警告","<font color=red>与服务器通信失败!</font>");
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
        Ynzc.manage.DriverStrInfoGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
        this.on("rowdblclick",function(grid,index,event){
            var record=grid.getStore().getAt(index);
            Ynzc.manage.updateDriver =new Ynzc.manage.DriverStrInfoUpdateWin();
            Ynzc.manage.updateDriver.show();
            Ynzc.manage.driverStrInfoId=record.data.id;
            Ynzc.manage.archivesNo=record.data.archivesNo;
            Ext.getCmp("driverStrName").setValue(record.data.peopleName);
            if(record.data.fosterType == 1){
            	Ext.getCmp("fosterType").setValue("新训");
            }else{
            	Ext.getCmp("fosterType").setValue("增训");
            }
            Ext.getCmp("drivingLicenceTypeId").setValue(record.data.drivingLicenceTypeId);
            Ext.getCmp("applicationAddress").setValue(record.data.applicationAddress);
            Ext.getCmp("examinationCode").setValue(record.data.examinationCode);
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
            Ext.getCmp("picture").getEl().dom.src=record.data.picture;
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
			Ext.Ajax.request({
				url:"main/driverStrInfo.html?action=getDriverType",
				success:function(resp){
					var result=Ext.util.JSON.decode(resp.responseText);
					if(result.reason !== undefined && result.reason !== ""){
						Ext.getCmp("drivingLicenceType").setValue(getOldDrivingLicenceType(result.reason.split("/")));
					}else{
						Ext.getCmp("drivingLicenceType").setValue("无");
					}
				},
				failure:function(){
					Ext.MessageBox.alert("警告","<font color=red>与服务器通讯失败!</font>");
				},
				params:{
					id:record.data.peopleInfoId
				}
			});
        });
	}
});
Ext.reg('driverStrInfoGrid',Ynzc.manage.DriverStrInfoGrid);