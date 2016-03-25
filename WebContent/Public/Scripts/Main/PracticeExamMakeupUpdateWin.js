Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PracticeExamMakeupUpdateWin=Ext.extend(Ext.Window,{
	id:"practiceExamMakeupUpdateWin",
	initComponent:function(){
		Ext.apply(this,{ 
			id:"practiceExamMakeupUpdateWin",
			title:"技术成绩录入",
			height:550,
			width:720,
			autoScroll:true,
			resizable:false,
			modal:true,
			bodyStyle:{padding:'5px 5px 5px 5px'},
			items:[{
				columnWidth:1,
				frame:true,
				items:[{
					title:"学员基本信息",
					xtype:"fieldset",
					layout:"column",
					height:'auto',
					width:'auto',
					items:[{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"archivesNo",
							fieldLabel:"报考号",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"peopleName",
							fieldLabel:"姓名",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"idCard",
							fieldLabel:"身份证",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"address",
							fieldLabel:"地址",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drivingLicenceNo",
							fieldLabel:"驾驶证号",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drivingLicenceTypeId",
							readOnly:true,
							fieldLabel:"申请型号",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drivingLicenceType",
							fieldLabel:"原驾机型",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						}]
					}]
				},{
					title:"教练信息",
					xtype:"fieldset",
					layout:"column",
					height:'auto',
					width:'auto',
					items:[{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterId",
							fieldLabel:"教练",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterCode",
							fieldLabel:"教练编号",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterDate",
							fieldLabel:"培训时间",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterMachine",
							fieldLabel:"教练机",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterAuditingIdeaFlag",
							fieldLabel:"审核意见",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.PassStore,
							emptyText:"请选择审核意见",
							anchor:'98%'
						}]
					}]
				},{
					columnWidth:1,
					title:"场地考试信息",
					xtype:"fieldset",
					layout:"form",
					items:[{
						columnWidth:1,
						title:"场地补考信息",
						xtype:"fieldset",
						layout:"column",
						height:'auto',
						bodyStyle:{padding:'5px 5px 5px 5px'},
						items:[{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"makeupFieldResult",
								fieldLabel:"场地补考成绩",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"examinerMakeupFieldOne",
								fieldLabel:"场地补考主考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"examinerMakeupFieldTwo",
								fieldLabel:"场地补考监考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"makeupFieldDate",
								fieldLabel:"场地补考日期",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					}]
				},{
					columnWidth:1,
					title:"作业考试信息",
					xtype:"fieldset",
					layout:"form",
					height:'auto',
					items:[{
						columnWidth:1,
						title:"作业补考信息",
						xtype:"fieldset",
						layout:"column",
						height:'auto',
						bodyStyle:{padding:'5px 5px 5px 5px'},
						items:[{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"makeupMachineResult",
								fieldLabel:"作业补考成绩",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"examinerMakeupMachineOne",
								fieldLabel:"作业补考主考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"examinerMakeupMachineTwo",
								fieldLabel:"作业补考监考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"makeupMachineDate",
								fieldLabel:"作业补考日期",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					}]
				},{
					columnWidth:1,
					title:"公路考试信息",
					xtype:"fieldset",
					layout:"form",
					height:'auto',
					items:[{
						columnWidth:1,
						title:"公路补考信息",
						xtype:"fieldset",
						layout:"column",
						height:'auto',
						bodyStyle:{padding:'5px 5px 5px 5px'},
						items:[{								
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"makeupRoadResult",
								fieldLabel:"公路补考成绩",
								xtype:"textfield",
								anchor:'98%'
							}]								
						},{								
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"examinerMakeupRoadOne",
								fieldLabel:"公路补考主考人",
								xtype:"textfield",
								anchor:'98%'
							}]								
						},{								
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"examinerMakeupRoadTwo",
								fieldLabel:"公路补考监考人",
								xtype:"textfield",
								anchor:'98%'
							}]								
						},{								
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',				        	
							baseCls: "x-plain",
							items:[{
								id:"makeupRoadDate",
								fieldLabel:"公路补考日期",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]								
						}]
					}]
				},{
					columnWidth:1,
					title:"评价信息",
					xtype:"fieldset",
					layout:"column",
					height:'auto',
					items:[{
						columnWidth:.5,
						layout:"form",
						labelWidth:90,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"unitAuditingPracticeIdeaFlag",
							fieldLabel:"部门审核意见",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.PassStore,
							emptyText:"请选择审核意见",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:90,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"drivingLicenceAuditingIdeaFlag",
							fieldLabel:"是否发放证件",
							xtype:"combo",
							displayField : 'displayvalue',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.YesOrNoStore,
							emptyText:"请选择是否发放证件",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:90,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"orgAuditingIdeaFlag",
							fieldLabel:"省级审核意见",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.PassStore,
							emptyText:"请选择省级审核意见",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:90,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"auditingPracticeResultFlag",
							fieldLabel:"结论",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.EligibilityOrUnEligibilityStore,
							emptyText:"请选择结论",
							anchor:'98%',
							listeners:{
								"select":function(){
									if(this.value === 0){
										Ext.getCmp("drillMasterAuditingIdeaMakeupFlag").setValue(0);
										Ext.getCmp("unitAuditingPracticeIdeaMakeupFlag").setValue(0);
										Ext.getCmp("drivingLicenceAuditingIdeaMakeupFlag").setValue(0);
										Ext.getCmp("orgAuditingIdeaMakeupFlag").setValue(0);
									}
									if(this.value === 1){
										Ext.getCmp("drillMasterAuditingIdeaMakeupFlag").setValue(1);
										Ext.getCmp("unitAuditingPracticeIdeaMakeupFlag").setValue(1);
										Ext.getCmp("drivingLicenceAuditingIdeaMakeupFlag").setValue(1);
										Ext.getCmp("orgAuditingIdeaMakeupFlag").setValue(1);
									}
								}
							}
						}]
					}]
				}]
			}],
			buttons:[{
				id:"savaBtn",
				text:"保存",
				handler:function(){
					if(checkLen(Ext.getCmp("drillMasterId").getValue())){
						Ext.MessageBox.alert("提示","教练填写有误!");
						initFocus('drillMasterId');
						return;
					}
					if(checkLen(Ext.getCmp("drillMasterCode").getValue())){
						Ext.MessageBox.alert("提示","教练编号填写有误!");
						initFocus('drillMasterCode');
						return;
					}
					if(Ext.getCmp("drillMasterDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写培训时间!");
						return;
					}
					if(checkLen(Ext.getCmp("drillMasterMachine").getValue())){
						Ext.MessageBox.alert("提示","教练编号填写有误!");
						initFocus('drillMasterMachine');
						return;
					}
					if(Ext.getCmp("drillMasterAuditingIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请选择审核意见!");
						return;
					}
					if(checkNum(Ext.getCmp("makeupFieldResult").getValue())){
						Ext.MessageBox.alert("提示","地考试成绩填写有误!");
						initFocus('makeupFieldResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMakeupFieldOne").getValue())){
						Ext.MessageBox.alert("提示","场地主考人填写有误!");
						initFocus('examinerMakeupFieldOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMakeupFieldTwo").getValue())){
						Ext.MessageBox.alert("提示","场地监考人填写有误!");
						initFocus('examinerMakeupFieldTwo');
						return;
					}
					if(Ext.getCmp("makeupFieldDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写场地考试时间!");
						initFocus('makeupFieldDate');
						return;
					}
					if(checkNum(Ext.getCmp("makeupMachineResult").getValue())){
						Ext.MessageBox.alert("提示","作业考试成绩填写有误!");
						initFocus('makeupMachineResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMakeupMachineOne").getValue())){
						Ext.MessageBox.alert("提示","作业主考人填写有误!");
						initFocus('examinerMakeupMachineOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMakeupMachineTwo").getValue())){
						Ext.MessageBox.alert("提示","作业监考人填写有误!");
						initFocus('examinerMakeupMachineTwo');
						return;
					}
					if(Ext.getCmp("makeupMachineDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写作业考试时间!");
						initFocus('makeupMachineDate');
						return;
					}
					if(checkNum(Ext.getCmp("makeupMachineResult").getValue())){
						Ext.MessageBox.alert("提示","公路考试成绩填写有误!");
						initFocus('makeupMachineResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMakeupRoadOne").getValue())){
						Ext.MessageBox.alert("提示","公路主考人填写有误!");
						initFocus('examinerMakeupRoadOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMakeupRoadTwo").getValue())){
						Ext.MessageBox.alert("提示","公路监考人填写有误!");
						initFocus('examinerMakeupRoadTwo');
						return;
					}
					if(Ext.getCmp("makeupRoadDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写公路考试时间!");
						initFocus('makeupRoadDate');
						return;
					}
					if(Ext.getCmp("unitAuditingPracticeIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请选择部门审核意见!");
						return;
					}
					if(Ext.getCmp("drivingLicenceAuditingIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请选择是否发放证件!");
						return;
					}
					if(Ext.getCmp("orgAuditingIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请选择省级审核意见!");
						return;
					}
					if(Ext.getCmp("auditingPracticeResultFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请选择结论!");
						return;
					}
					if(Ext.getCmp("roadMakeupResult").getValue()<0 || Ext.getCmp("roadMakeupResult").getValue()>=100){
						Ext.MessageBox.alert("提示","填入成绩有误，请修正!");
						initFocus('roadMakeupResult');
						return;
					}
					if(Ext.getCmp("fieldMakeupResult").getValue()<0 || Ext.getCmp("fieldMakeupResult").getValue()>=100){
						Ext.MessageBox.alert("提示","填入成绩有误，请修正!");
						initFocus('fieldMakeupResult');
						return;
					}
					if(Ext.getCmp("machineMakeupResult").getValue()<0 || Ext.getCmp("machineMakeupResult").getValue()>=100){
						Ext.MessageBox.alert("提示","填入成绩有误，请修正!");
						initFocus('machineMakeupResult');
						return;
					}
					if(Ext.getCmp("auditingPracticeResultMakeupFlag").getValue() === 1){
						if(Ext.getCmp("roadMakeupResult").getValue()<75){
							Ext.MessageBox.alert("提示","填入成绩有不合格记录，请修正!");
							initFocus('roadMakeupResult');
							return;
						}
						if(Ext.getCmp("fieldMakeupResult").getValue()<75){
							Ext.MessageBox.alert("提示","填入成绩有不合格记录，请修正!");
							initFocus('fieldMakeupResult');
							return;
						}
						if(Ext.getCmp("machineMakeupResult").getValue()<75){
							Ext.MessageBox.alert("提示","填入成绩有不合格记录，请修正!");
							initFocus('machineMakeupResult');
							return;
						}
					}
					if(Ext.getCmp("auditingPracticeResultFlag").getValue() === 1){
						if(Ext.getCmp("drillMasterAuditingIdeaFlag").getValue() === 0){
							Ext.MessageBox.alert("提示","教练意见选择有误不予通过保存!");
							initFocus('drillMasterAuditingIdeaFlag');
							return;
						}
						if(Ext.getCmp("unitAuditingPracticeIdeaFlag").getValue() === 0){
							Ext.MessageBox.alert("提示","省级意见选择有误不予通过保存!");
							initFocus('unitAuditingPracticeIdeaFlag');
							return;
						}
						if(Ext.getCmp("drivingLicenceAuditingIdeaFlag").getValue() === 0){
							Ext.MessageBox.alert("提示","单位意见选择有误不予通过保存!");
							initFocus('drivingLicenceAuditingIdeaFlag');
							return;
						}
						if(Ext.getCmp("orgAuditingIdeaFlag").getValue() === 0){
							Ext.MessageBox.alert("提示","发证选择有误不予通过保存!");
							initFocus('orgAuditingIdeaFlag');
							return;
						}
					}
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在處理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
					Ext.Ajax.request({
						url:"main/practiceExam.html?action=addPracticeExam",
						success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								Ext.MessageBox.alert("提示",result.reason);
								Ext.getCmp("dirverClassStrExamGrid").getStore().reload();
								Ext.getCmp("practiceExamMakeupUpdateWin").close();
							}else{
								Ext.Msg.alert("提示",result.reason);
							}
						},
						failure:function(){
							Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							driverStrInfoId:Ynzc.manage.driverStrInfoId,
							drivingLicenceNo:Ext.getCmp("drivingLicenceNo").getValue(),
							drillMasterId:Ext.getCmp("drillMasterId").getValue(),
							drillMasterCode:Ext.getCmp("drillMasterCode").getValue(),
							drillMasterDate:Ext.getCmp("drillMasterDate").getValue(),
							drillMasterMachine:Ext.getCmp("drillMasterMachine").getValue(),
							drillMasterAuditingIdeaFlag:Ext.getCmp("drillMasterAuditingIdeaFlag").getValue(),
							unitAuditingPracticeIdeaFlag:Ext.getCmp("unitAuditingPracticeIdeaFlag").getValue(),
							drivingLicenceAuditingIdeaFlag:Ext.getCmp("drivingLicenceAuditingIdeaFlag").getValue(),
							orgAuditingIdeaFlag:Ext.getCmp("orgAuditingIdeaFlag").getValue(),
							makeupFieldResult:Ext.getCmp("makeupFieldResult").getValue(),
							examinerMakeupFieldOne:Ext.getCmp("makeupFieldResult").getValue(),
							examinerMakeupFieldTwo:Ext.getCmp("examinerMakeupFieldTwo").getValue(),
							makeupFieldDate:Ext.util.Format.date(Ext.getCmp("makeupFieldDate").getValue(),'Y-m-d'),
							makeupMachineResult:Ext.getCmp("makeupMachineResult").getValue(),
							examinerMakeupMachineOne:Ext.getCmp("examinerMakeupMachineOne").getValue(),
							examinerMakeupMachineTwo:Ext.getCmp("examinerMakeupMachineTwo").getValue(),
							makeupMachineDate:Ext.util.Format.date(Ext.getCmp("makeupMachineDate").getValue(),'Y-m-d'),
							makeupRoadResult:Ext.getCmp("makeupRoadResult").getValue(),
							examinerMakeupRoadOne:Ext.getCmp("examinerMakeupRoadOne").getValue(),
							examinerMakeupRoadTwo:Ext.getCmp("examinerMakeupRoadTwo").getValue(),
							makeupRoadDate:Ext.util.Format.date(Ext.getCmp("makeupRoadDate").getValue(),'Y-m-d'),
							auditingPracticeResultFlag:Ext.getCmp("auditingPracticeResultFlag").getValue()
						}
					});
				}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("practiceExamMakeupUpdateWin").close();
				}
			}]
		});
		Ynzc.manage.PracticeExamMakeupUpdateWin.superclass.initComponent.apply(this,arguments);
	}
});