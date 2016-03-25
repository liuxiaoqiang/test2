Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DirverClassAddStrWin=Ext.extend(Ext.Window,{
	id:"dirverClassAddStrWin",
	initComponent:function(){
		var driverStrDate=new Ext.data.JsonReader({
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
		
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
				'<table width="600" height="420" border="1" class="ynzcTableBlue">',
				'<tr><td>姓名</td><td>{[values.peopleName != null ? values.peopleName : ""]}</td><td>性别</td><td>{[values.sex != null ? values.sex : ""]}</td><td rowspan="7"><img src="{[values.picture != null ? values.picture : ""]}" width="100%" height="100%"/></td></tr>',
				'<tr><td>出生日期</td><td>{[values.birthday != null ? new Date(values.birthday.time).format("Y-m-d") : ""]}</td><td>身份证号</td><td>{[values.idCard != null ? values.idCard : ""]}</td></tr>',
				'<tr><td>暂住证</td><td>{[values.idStay != null ? values.idStay : ""]}</td><td>联系电话</td><td>{[values.linkTel != null ? values.linkTel : ""]}</td></tr>',
				'<tr><td>邮政编码</td><td>{[values.postalcode != null ? values.postalcode : ""]}</td><td>文化程度</td><td>{[values.degree != null ? values.degree : ""]}</td></tr>',
				'<tr><td>家庭地址</td><td colspan="3">{[values.address != null ? values.address : ""]}</td></tr>',
				'<tr><td>联系地址</td><td colspan="3">{[values.linkAddress != null ? values.linkAddress : ""]}</td></tr>',
				'<tr><td>报考号</td><td>{[values.examinationCode != null ? values.examinationCode : ""]}</td><td>培养类型</td><td colspan="2">{[values.fosterType != null ? Ynzc.manage.FosterTypeStore.getAt(Ynzc.manage.FosterTypeStore.find("value", values.fosterType)).data.display : ""]}</td></tr>',
				'<tr><td>申请地址</td><td>{[values.applicationAddress != null ? values.applicationAddress : ""]}</td><td>申请型号</td><td colspan="2">{[values.drivingLicenceTypeId != null ? Ynzc.manage.ApplicationTypeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.drivingLicenceTypeId)).data.display : ""]}</td></tr>',
				'<tr><td>身高</td><td>{[values.hight != null ? values.hight : ""]}</td><td>辨色力</td><td colspan="2">{[values.resolvingPowerFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.resolvingPowerFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体和颈椎</td><td>{[values.bodyNeck != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.bodyNeck)).data.display : ""]}</td><td>&nbsp;</td><td colspan="2">&nbsp;</td></tr>',
				'<tr><td>右眼视力</td><td>{[values.rightEyePwoer != null ? values.rightEyePwoer : ""]}</td><td>右眼矫正</td><td colspan="2">{[values.rightEyeRectificationFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.rightEyeRectificationFlag)).data.display : ""]}</td></tr>',
				'<tr><td>左眼视力</td><td>{[values.leftEyePwoer != null ? values.leftEyePwoer : ""]}</td><td>左眼矫正</td><td colspan="2">{[values.leftEyeRectificationFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.leftEyeRectificationFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右耳听力</td><td>{[values.rightEarPwoer != null ? values.rightEarPwoer : ""]}</td><td>左耳听力</td><td colspan="2">{[values.leftEarPwoer != null ? values.leftEarPwoer : ""]}</td></tr>',
				'<tr><td>右手</td><td>{[values.rightHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightHandFlag)).data.display : ""]}</td><td>左手</td><td colspan="2">{[values.leftHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftHandFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右脚</td><td>{[values.rightLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightLagFlag)).data.display : ""]}</td><td>左脚</td><td colspan="2">{[values.leftLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftLagFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体检查时间</td><td>{[values.bodyCheckDate != null ? new Date(values.bodyCheckDate.time).format("Y-m-d") : ""]}</td><td>检查机构</td><td colspan="2">{[values.checkOrganization != null ? values.checkOrganization : ""]}</td></tr>',
				'<tr><td>检查医生</td><td>{[values.checkDoctor != null ? values.checkDoctor : ""]}</td><td>检查结果</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.checkResultFlag)).data.display]}</td></tr>',
				'</table>'
			)
		});
		
		var StrDs=new Ext.data.Store({
	        scopte:this,
	        url:'main/driverStrInfo.html?action=getAllDriverStrInfoInTeam',
	        reader:driverStrDate,
	        sortInfo:{
	            field:'id',
	            direction:'DESC'
	        }
	    });
		var DirverClassStrGrid = new Ext.grid.GridPanel({
			id:"dirverClassStrGrid",
			plain:true,
            border:false,
            autoScroll:true,
            width:.5,
            cm:new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
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
		                } else if(value.indexOf("9")>0){
		                    return '退回修改';
		                } else if(value.indexOf("10")>0){
		                    return '修改上报';
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
		        }
	        ]),
            sm:new Ext.grid.CheckboxSelectionModel(),
            frame:true,
            store:StrDs,
            loadMask:true,
            viewConfig:{
                forceFit:true
            },
            plugins:[expand,new Ext.ux.grid.Search({
            	width:200,
            	iconCls:false
            })],
            tbar:[{
                id:"addStr",
                text:"新增",
                iconCls:"icon-Add",
                handler:function(){
	                if(Ynzc.manage.ClassState >= 1){
	                    Ext.MessageBox.alert("提示","班级录入学员阶段已经结束!");
	                    return;
	                }
	                var addStr=new Ynzc.manage.AddStrWin();
	                addStr.show();
	                Ext.getCmp("fosterType").setValue("新训");
        			Ext.getCmp("drivingLicenceType").setValue("无");
        			Ext.getCmp("applicationAddress").setValue(UnitAddress);
            	}
            },'-',{
                id:"addStrAgain",
                text:"增驾",
                iconCls:"icon-Add",
                handler:function(){
		            if(Ynzc.manage.ClassState >= 1){
		                Ext.MessageBox.alert("提示","班级录入学员阶段已经结束!");
		                return;
		            }
	            	Ynzc.manage.addwin=new Ynzc.manage.DriverStrInfoWin();
	            	Ynzc.manage.addwin.show();
	            	Ext.getCmp("applicationAddress").setValue(UnitAddress);
	            	Ynzc.manage.winName = "driverStrInfoWin";
            	}
            },'-',{
                id:"updateStr",
                text:"学员信息修改",
                iconCls:"icon-Add",
                handler:function(){
	                var selections = DirverClassStrGrid.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中要修改信息的学员!");
	                    return;
	                }
	                if(n>1){
	                    Ext.MessageBox.alert("提示","请逐一修改信息的学员!");
	                    return;
	                }
	                if(Ynzc.manage.ClassState >= 1){
	                	if (selections[0].data.strState.indexOf("@9")<0){
		                    Ext.MessageBox.alert("提示","班级录入学员阶段已经结束!");
		                    return;

		                }
	                }
	                if(selections[0].data.fosterType == 1){
	                	var addStr=new Ynzc.manage.AddStrUpdateWin();
		                addStr.show();
		                Ynzc.manage.Id = selections[0].data.id;
		                Ynzc.manage.PeopleInfoId =  selections[0].data.peopleInfoId;
			            Ext.getCmp("peopleName").setValue(selections[0].data.peopleName);
			            Ext.getCmp("sex").setValue(selections[0].data.sex);
			            Ext.getCmp("birthday").setValue(new Date(selections[0].data.birthday.time).format('Y-m-d'));
			            Ext.getCmp("idCard").setValue(selections[0].data.idCard);
			            Ext.getCmp("idStay").setValue(selections[0].data.idStay);
			            Ext.getCmp("address").setValue(selections[0].data.address);
			            Ext.getCmp("linkAddress").setValue(selections[0].data.linkAddress);
			            Ext.getCmp("linkTel").setValue(selections[0].data.linkTel);
			            Ext.getCmp("postalcode").setValue(selections[0].data.postalcode);
//			            Ext.getCmp("nativePlace").setValue(selections[0].data.nativePlace);
			            Ext.getCmp("degree").setValue(selections[0].data.degree);
			            Ext.getCmp("photoDir").setValue(selections[0].data.picture);
			            if(selections[0].data.fosterType == 1){
			            	Ext.getCmp("fosterType").setValue("新训");
			            }else{
			            	Ext.getCmp("fosterType").setValue("增训");
			            }
			            Ext.getCmp("drivingLicenceType").setValue("无");
			            Ext.getCmp("drivingLicenceTypeId").setValue(selections[0].data.drivingLicenceTypeId);
			            Ext.getCmp("applicationAddress").setValue(selections[0].data.applicationAddress);
			            Ext.getCmp("hight").setValue(selections[0].data.hight);
			            Ext.getCmp("rightEyePwoer").setValue(selections[0].data.rightEyePwoer);
			            Ext.getCmp("leftEyePwoer").setValue(selections[0].data.leftEyePwoer);
		                if(selections[0].data.resolvingPowerFlag === 1){
		                	Ext.getCmp("baseHealth").items.items[1].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("baseHealth").items.items[1].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.bodyNeck === 1){
		                	Ext.getCmp("baseHealth").items.items[2].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("baseHealth").items.items[2].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.rightEyeRectificationFlag === 1){
		                	Ext.getCmp("eyeSet").items.items[1].items.items[0].items.items[0].setValue(true);            	
		                }else{
		                	Ext.getCmp("eyeSet").items.items[1].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.leftEyeRectificationFlag === 1){
		                	Ext.getCmp("eyeSet").items.items[3].items.items[0].items.items[0].setValue(true); 
		                }else{
		                	Ext.getCmp("eyeSet").items.items[3].items.items[1].items.items[0].setValue(true); 
		                }
		                Ext.getCmp("rightEarPwoerId").setValue(selections[0].data.rightEarPwoer);;
		                Ext.getCmp("leftEarPwoerId").setValue(selections[0].data.leftEarPwoer);;
//		                if(selections[0].data.rightEarPwoer === 1){
//		                	Ext.getCmp("earHealth").items.items[0].items.items[0].items.items[0].setValue(true);
//		                }else{
//		                	Ext.getCmp("earHealth").items.items[0].items.items[1].items.items[0].setValue(true);
//		                }
//		                if(selections[0].data.leftEarPwoer === 1){
//		                	Ext.getCmp("earHealth").items.items[1].items.items[0].items.items[0].setValue(true);
//		                }else{
//		                	Ext.getCmp("earHealth").items.items[1].items.items[1].items.items[0].setValue(true);
//		                }
		                if(selections[0].data.rightHandFlag === 1){
		                	Ext.getCmp("legsHealth").items.items[0].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("legsHealth").items.items[0].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.leftHandFlag === 1){
		                	Ext.getCmp("legsHealth").items.items[1].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("legsHealth").items.items[1].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.rightLagFlag === 1){
		                	Ext.getCmp("legsHealth").items.items[2].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("legsHealth").items.items[2].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.leftLagFlag === 1){
		                	Ext.getCmp("legsHealth").items.items[3].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("legsHealth").items.items[3].items.items[1].items.items[0].setValue(true);
		                }
		                if(selections[0].data.checkResultFlag === 1){
		                	Ext.getCmp("checkInfo").items.items[1].items.items[0].items.items[0].setValue(true);
		                }else{
		                	Ext.getCmp("checkInfo").items.items[1].items.items[1].items.items[0].setValue(true);
		                }
		                Ext.getCmp("bodyCheckDate").setValue(new Date(selections[0].data.bodyCheckDate.time).format('Y-m-d'));
		                Ext.getCmp("checkOrganization").setValue(selections[0].data.checkOrganization);
		                Ext.getCmp("checkDoctor").setValue(selections[0].data.checkDoctor);
	                }else{
	                	Ynzc.manage.updateDriver=new Ynzc.manage.DriverStrInfoUpdateWin();
	                	Ynzc.manage.updateDriver.show();
		            	Ext.getCmp("applicationAddress").setValue(UnitAddress);
		            	Ynzc.manage.driverStrInfoId=selections[0].data.id;
			            if(selections[0].data.fosterType == 1){
			            	Ext.getCmp("fosterType").setValue("新训");
			            }else{
			            	Ext.getCmp("fosterType").setValue("增训");
			            }
		            	Ext.getCmp("driverStrName").setValue(selections[0].data.peopleName);
		                Ext.getCmp("drivingLicenceTypeId").setValue(selections[0].data.drivingLicenceTypeId);
		                Ext.getCmp("applicationAddress").setValue(selections[0].data.applicationAddress);
		                Ext.getCmp("examinationCode").setValue(selections[0].data.examinationCode);
		                Ext.getCmp("peopleName").setValue(selections[0].data.peopleName);
		                Ext.getCmp("sex").setValue(selections[0].data.sex);
		                Ext.getCmp("birthday").setValue(new Date(selections[0].data.birthday.time).format('Y-m-d'));
		                Ext.getCmp("idCard").setValue(selections[0].data.idCard);
		                Ext.getCmp("idStay").setValue(selections[0].data.idStay);
		                Ext.getCmp("address").setValue(selections[0].data.address);
		                Ext.getCmp("linkAddress").setValue(selections[0].data.linkAddress);
		                Ext.getCmp("linkTel").setValue(selections[0].data.linkTel);
		                Ext.getCmp("postalcode").setValue(selections[0].data.postalcode);
		                Ext.getCmp("degree").setValue(selections[0].data.degree);
		                Ext.getCmp("picture").getEl().dom.src=selections[0].data.picture;
		                Ext.getCmp("hight").setValue(selections[0].data.hight);
		                if(selections[0].data.resolvingPowerFlag>0){
		                	Ext.getCmp("resolvingPowerFlag").setValue("正常");
		                }else{
		                	Ext.getCmp("resolvingPowerFlag").setValue("异常");
		                }
		                Ext.getCmp("rightEyePwoer").setValue(selections[0].data.rightEyePwoer);
		                if(selections[0].data.rightEyeRectificationFlag>0){
		                	Ext.getCmp("rightEyeRectificationFlag").setValue("是");
		                }else{
		                	Ext.getCmp("rightEyeRectificationFlag").setValue("否");
		                }
		                Ext.getCmp("leftEyePwoer").setValue(selections[0].data.leftEyePwoer);
		                if(selections[0].data.rightEyeRectificationFlag>0){
		                	Ext.getCmp("leftEyeRectificationFlag").setValue("是");
		                }else{
		                	Ext.getCmp("leftEyeRectificationFlag").setValue("否");
		                }
		                if(selections[0].data.rightEarPwoer>0){
		                	Ext.getCmp("rightEarPwoer").setValue("正常");
		                }else{
		                	Ext.getCmp("rightEarPwoer").setValue("异常");
		                }
		                if(selections[0].data.leftEarPwoer>0){
		                	Ext.getCmp("leftEarPwoer").setValue("正常");
		                }else{
		                	Ext.getCmp("leftEarPwoer").setValue("异常");
		                }
		                if(selections[0].data.rightHandFlag>0){
		                	Ext.getCmp("rightHandFlag").setValue("正常");
		                }else{
		                	Ext.getCmp("rightHandFlag").setValue("异常");
		                }
		                if(selections[0].data.leftHandFlag>0){
		                	Ext.getCmp("leftHandFlag").setValue("正常");
		                }else{
		                	Ext.getCmp("leftHandFlag").setValue("异常");
		                }
		                if(selections[0].data.rightLagFlag>0){
		                	Ext.getCmp("rightLagFlag").setValue("正常");
		                }else{
		                	Ext.getCmp("rightLagFlag").setValue("异常");
		                }
		                if(selections[0].data.leftLagFlag>0){
		                	Ext.getCmp("leftLagFlag").setValue("正常");
		                }else{
		                	Ext.getCmp("leftLagFlag").setValue("异常");
		                }
		                if(selections[0].data.bodyNeck>0){
		                	Ext.getCmp("bodyNeck").setValue("正常");
		                }else{
		                	Ext.getCmp("bodyNeck").setValue("异常");
		                }
		                Ext.getCmp("bodyCheckDate").setValue(new Date(selections[0].data.bodyCheckDate.time).format('Y-m-d'));
		                if(selections[0].data.checkResultFlag>0){
		                	Ext.getCmp("checkResultFlag").setValue("合格");
		                }else{
		                	Ext.getCmp("checkResultFlag").setValue("不合格");
		                }
		                Ext.getCmp("checkOrganization").setValue(selections[0].data.checkOrganization);
		                Ext.getCmp("checkDoctor").setValue(selections[0].data.checkDoctor);
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
		    					Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
		    				},
		    				params:{
		    					id:selections[0].data.peopleInfoId
		    				}
		    			});
	                }
            	}
            },'-',{
            	id:"driverStrInfoUpdate",
                text:"修改上报",
                iconCls:"icon-add",
                handler:function(){
	                var selections = DirverClassStrGrid.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中学员!");
	                    return;
	                }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(rds.length == 0){
                    		rds = rds + selections[i].data.id;
                    	}else{
                    		rds = rds + "@" + selections[i].data.id;
                    	}
                    }
                    Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认选中的学员给予修改上报?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverStrInfo.html?action=driverStrExaminationUpdate",
                                    method:"post",
                                    success:function(resp){
            							var result=Ext.util.JSON.decode(resp.responseText);
        								if(result.success==true){
        									Ext.MessageBox.alert("提示",result.reason);
        									DirverClassStrGrid.getStore().reload();
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
                }
            },'-',{
            	text:"打印",
            	iconCls:"icon-print",
            	menu:[{
        	    	text:"打印学员申请表",
            		iconCls:"icon-Add",
            		handler:function(){
    	        		var selections=DirverClassStrGrid.selModel.getSelections();
    	        		var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要打印的学员信息!");
                            return;
                        }
                        if(n>1){
                            Ext.MessageBox.alert("提示","请逐一打证!");
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
                		new Ynzc.manage.ReportWin({
        					title:'打印',
        					sourceURL:'main/reportPeopleInfo.html?action=getPeopleInfoReport',
        					params:{id:selections[0].data.id,functionType:'',wordType:'licenseApplicationReport'}
    	    				}
    	    			).show();
                	}
            	},{
            		text:"打印学员健康信息",
            		iconCls:"icon-Add",
            		handler:function(){
    	        		var selections=DirverClassStrGrid.selModel.getSelections();
    	        		var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要打印的学员信息!");
                            return;
                        }
                        if(n>1){
                            Ext.MessageBox.alert("提示","请逐一打证!");
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
	                        	wordType:"peoplePhysicalProve2",
	                        	ChWord:"拖拉机驾驶人身体条件证明",
		                        topMargin:"",
		                        bottomMargin:"",
		                        leftMargin:"",
		                        rightMargin:""
	                        	}
	                    });
                		new Ynzc.manage.ReportWin({
        					title:'打印',
        					sourceURL:'main/reportPeopleInfo.html?action=getPeopleHealthReport',
        					params:{id:selections[0].data.id,functionType:'',wordType:'peoplePhysicalProve2'}
    	    				}
    	    			).show();
                	}
            	},{
            		text:"打印学员健康表",
            		iconCls:"icon-Add",
            		handler:function(){
    	        		var selections=DirverClassStrGrid.selModel.getSelections();
    	        		var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要打印的学员信息!");
                            return;
                        }
                        if(n>1){
                            Ext.MessageBox.alert("提示","请逐一打证!");
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
	                        	wordType:"peoplePhysicalProve",
	                        	ChWord:"拖拉机驾驶人身体条件证明",
		                        topMargin:"",
		                        bottomMargin:"",
		                        leftMargin:"",
		                        rightMargin:""
	                        	}
	                    });
                		new Ynzc.manage.ReportWin({
        					title:'打印',
        					sourceURL:'main/reportPeopleInfo.html?action=getPeopleHealthInfoReport',
        					params:{id:selections[0].data.id,functionType:'',wordType:'peoplePhysicalProve'}
    	    				}
    	    			).show();
                	}
            	}]
            },'-',{
                id:"moveStr",
                text:"移除",
                iconCls:"icon-Del",
                handler:function(){
	                if(Ynzc.manage.ClassState >= 1){
	                    Ext.MessageBox.alert("提示","班级录入学员阶段已经结束!");
	                    return;
	                }
	                var selections = DirverClassStrGrid.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中要删除的学员!");
	                    return;
	                }
	                if(n>1){
	                    Ext.MessageBox.alert("提示","请逐一删除学员!");
	                    return;
	                }
	                Ext.Msg.show({
	                	title:'系统确认',
	                	msg:'你是否确认删除选中的人员健康信息?',
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
	                						Ext.MessageBox.alert("提示",result.reason);
	                						Ext.getCmp("dirverClassStrGrid").getStore().reload();
	                						Ext.getCmp("driverClassInfoMgr").getStore().reload();
	                					}else{
	                						Ext.MessageBox.alert("提示",result.reason);
	                					}
	                				},
	                				faliure:function(){
	                					Ext.MessageBox.alert("警告","<font color=red>与服务器通信失败!</font>");
	                				},
	                				params:{
	                					driverClassInfoId:Ynzc.manage.DriverClassInfoId,
	                					driverStrInfoId:selections[0].data.id,
	                					peopleInfoId:selections[0].data.peopleInfoId,
	                					bodyInfoId:selections[0].data.bodyInfoId
	                				}
	                          });
	                      }
	                  }
	               });
            	}
            }],
            bbar:new Ext.PagingToolbar({
                pageSize:5,
                store:StrDs,
                displayInfo:true,
                displayMsg : '共 {2} 条',
                emptyMsg : '无记录'
            }),
            viewConfig:{
                forceFit:true
            }
		});
		Ext.apply(this,{
			id:"dirverClassAddStrWin",
			title:"班级学员",
			height:500,
			width:1000,
			autoScroll:true,
			resizable:false,
			modal:true,
			layout:'fit',
			items:DirverClassStrGrid
		});
		Ynzc.manage.DirverClassAddStrWin.superclass.initComponent.apply(this,arguments);
		StrDs.baseParams.driverClassInfoId = Ynzc.manage.DriverClassInfoId;
		StrDs.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});