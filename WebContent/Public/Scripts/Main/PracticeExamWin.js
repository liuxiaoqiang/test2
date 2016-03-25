Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PracticeExamWin=Ext.extend(Ext.Window,{
	id:"practiceExamWin",
	initComponent:function(){
		Ext.apply(this,{
			id:"practiceExamWin",
			title:"技术成绩录入",
			height:600,
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
							id:"examinationCode",
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
						title:"场地初考信息",
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
								id:"fieldResult",
								fieldLabel:"场地考试成绩",
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
								id:"examinerFieldOne",
								fieldLabel:"场地主考人",
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
								id:"examinerFieldTwo",
								fieldLabel:"场地监考人",
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
								id:"fieldDate",
								fieldLabel:"场地考试日期",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					},{
						columnWidth:1,
						title:"场地二考信息",
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
								fieldLabel:"场地二考成绩",
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
								fieldLabel:"场地二考主考人",
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
								fieldLabel:"场地二考监考人",
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
								fieldLabel:"场地二考日期",
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
						title:"作业初考信息",
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
								id:"machineResult",
								fieldLabel:"作业考试成绩",
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
								id:"examinerMachineOne",
								fieldLabel:"作业主考人",
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
								id:"examinerMachineTwo",
								fieldLabel:"作业监考人",
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
								id:"machineDate",
								fieldLabel:"作业考试日期",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					},{
						columnWidth:1,
						title:"作业二考信息",
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
								fieldLabel:"作业二考成绩",
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
								fieldLabel:"作业二考主考人",
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
								fieldLabel:"作业二考监考人",
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
								fieldLabel:"作业二考日期",
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
						title:"公路初考信息",
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
								id:"roadResult",
								fieldLabel:"公路考试成绩",
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
								id:"examinerRoadOne",
								fieldLabel:"公路主考人",
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
								id:"examinerRoadTwo",
								fieldLabel:"公路监考人",
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
								id:"roadDate",
								fieldLabel:"公路考试日期",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					},{
						columnWidth:1,
						title:"公路二考信息",
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
								fieldLabel:"公路二考成绩",
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
								fieldLabel:"公路二考主考人",
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
								fieldLabel:"公路二考监考人",
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
								fieldLabel:"公路二考日期",
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
										Ext.getCmp("drillMasterAuditingIdeaFlag").setValue(0);
										Ext.getCmp("unitAuditingPracticeIdeaFlag").setValue(0);
										Ext.getCmp("drivingLicenceAuditingIdeaFlag").setValue(0);
										Ext.getCmp("orgAuditingIdeaFlag").setValue(0);
									}
									if(this.value === 1){
										Ext.getCmp("drillMasterAuditingIdeaFlag").setValue(1);
										Ext.getCmp("unitAuditingPracticeIdeaFlag").setValue(1);
										Ext.getCmp("drivingLicenceAuditingIdeaFlag").setValue(1);
										Ext.getCmp("orgAuditingIdeaFlag").setValue(1);
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
					if(checkNum(Ext.getCmp("fieldResult").getValue())){
						Ext.MessageBox.alert("提示","地考初考成绩填写有误!");
						initFocus('fieldResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerFieldOne").getValue())){
						Ext.MessageBox.alert("提示","场地初考主考人填写有误!");
						initFocus('examinerFieldOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerFieldTwo").getValue())){
						Ext.MessageBox.alert("提示","场地初考监考人填写有误!");
						initFocus('examinerFieldTwo');
						return;
					}
					if(Ext.getCmp("fieldDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写场地初考时间!");
						return;
					}
					if(checkNum(Ext.getCmp("machineResult").getValue())){
						Ext.MessageBox.alert("提示","作业初考成绩填写有误!");
						initFocus('machineResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMachineOne").getValue())){
						Ext.MessageBox.alert("提示","作业初考主考人填写有误!");
						initFocus('examinerMachineOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerMachineTwo").getValue())){
						Ext.MessageBox.alert("提示","作业初考监考人填写有误!");
						initFocus('examinerMachineTwo');
						return;
					}
					if(Ext.getCmp("machineDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写作业初考时间!");
						return;
					}
					if(checkNum(Ext.getCmp("roadResult").getValue())){
						Ext.MessageBox.alert("提示","公路初考成绩填写有误!");
						initFocus('roadResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerRoadOne").getValue())){
						Ext.MessageBox.alert("提示","公路初考主考人填写有误!");
						initFocus('examinerRoadOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerRoadTwo").getValue())){
						Ext.MessageBox.alert("提示","公路初考监考人填写有误!");
						initFocus('examinerRoadTwo');
						return;
					}
					if(Ext.getCmp("roadDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写公路初考时间!");
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
					if(Ext.getCmp("fieldResult").getValue()<0 || !Ext.getCmp("fieldResult").getValue()>100){
						Ext.MessageBox.alert("提示","地考初考成绩填写有误!");
						initFocus('fieldResult');
						return;
					}
					if(Ext.getCmp("makeupFieldResult").getValue()<0 || !Ext.getCmp("makeupFieldResult").getValue()>100){
						Ext.MessageBox.alert("提示","地考初考成绩填写有误!");
						initFocus('makeupFieldResult');
						return;
					}
					if(Ext.getCmp("machineResult").getValue()<0 || !Ext.getCmp("machineResult").getValue()>100){
						Ext.MessageBox.alert("提示","作业初考成绩填写有误!");
						initFocus('machineResult');
						return;
					}
					if(Ext.getCmp("makeupMachineResult").getValue()<0 || !Ext.getCmp("makeupMachineResult").getValue()>100){
						Ext.MessageBox.alert("提示","作业初考成绩填写有误!");
						initFocus('makeupMachineResult');
						return;
					}
					if(Ext.getCmp("roadResult").getValue()<0 || !Ext.getCmp("roadResult").getValue()>100){
						Ext.MessageBox.alert("提示","公路初考成绩填写有误!");
						initFocus('roadResult');
						return;
					}
					if(Ext.getCmp("makeupMachineResult").getValue()<0 || !Ext.getCmp("makeupMachineResult").getValue()>100){
						Ext.MessageBox.alert("提示","公路初考成绩填写有误!");
						initFocus('makeupMachineResult');
						return;
					}
					if(!checkNum(Ext.getCmp("fieldResult").getValue())){
						if(Ext.getCmp("fieldResult").getValue() < 70){
							if(!checkNum(Ext.getCmp("makeupFieldResult").getValue())){
								if(Ext.getCmp("makeupFieldResult").getValue() < 70 && Ext.getCmp("auditingPracticeResultFlag").getValue() === 1){
									Ext.MessageBox.alert("提示","该学员成绩没有达到合格要求不予选择通过!");
									initFocus('makeupFieldResult');
									return;
								}
							}else{
								Ext.MessageBox.alert("提示","填写场地二考成绩有误不予通过保存!");
								initFocus('makeupFieldResult');
								return;
							}
						}
					}else{
						Ext.MessageBox.alert("提示","填写场地成绩有误不予通过保存!");
						initFocus('fieldResult');
						return;
					}
					if(!checkNum(Ext.getCmp("machineResult").getValue())){
						if(Ext.getCmp("machineResult").getValue() < 70){
							if(!checkNum(Ext.getCmp("makeupMachineResult").getValue())){
								if(Ext.getCmp("makeupMachineResult").getValue() < 70 && Ext.getCmp("auditingPracticeResultFlag").getValue() === 1){
									Ext.MessageBox.alert("提示","该学员成绩没有达到合格要求不予选择通过!");
									initFocus('makeupMachineResult');
									return;
								}
							}else{
								Ext.MessageBox.alert("提示","填写作业二考成绩有误不予通过保存!");
								initFocus('makeupMachineResult');
								return;
							}
						}
					}else{
						Ext.MessageBox.alert("提示","填写作业成绩有误不予通过保存!");
						initFocus('machineResult');
						return;
					}
					if(!checkNum(Ext.getCmp("roadResult").getValue())){
						if(Ext.getCmp("roadResult").getValue() < 70){
							if(!checkNum(Ext.getCmp("makeupRoadResult").getValue())){
								if(Ext.getCmp("makeupRoadResult").getValue() < 70 && Ext.getCmp("auditingPracticeResultFlag").getValue() === 1){
									Ext.MessageBox.alert("提示","该学员成绩没有达到合格要求不予选择通过!");
									initFocus('makeupMachineResult');
									return;
								}
							}else{
								Ext.MessageBox.alert("提示","填写公路二考成绩有误不予通过保存!");
								initFocus('makeupRoadResult');
								return;
							}
						}
					}else{
						Ext.MessageBox.alert("提示","填写公路成绩有误不予通过保存!");
						initFocus('roadResult');
						return;
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
					Ext.Ajax.request({
						url:"main/practiceExam.html?action=addPracticeExam",
						success:function(resp){
						mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								Ext.MessageBox.alert("提示",result.reason);
								Ext.getCmp("dirverClassStrExamGrid").getStore().reload();
								Ext.getCmp("practiceExamWin").close();
							}else{
								Ext.Msg.alert("提示",result.reason);
							}
						},
						failure:function(){
							Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							classInfoId:Ynzc.manage.DriverClassInfoId,
							driverStrInfoId:Ynzc.manage.DriverStrInfoId,
							drivingLicenceNo:Ext.getCmp("drivingLicenceNo").getValue(),
							drillMasterId:Ext.getCmp("drillMasterId").getValue(),
							drillMasterCode:Ext.getCmp("drillMasterCode").getValue(),
							drillMasterDate:Ext.getCmp("drillMasterDate").getValue(),
							drillMasterMachine:Ext.getCmp("drillMasterMachine").getValue(),
							drillMasterAuditingIdeaFlag:Ext.getCmp("drillMasterAuditingIdeaFlag").getValue(),
							unitAuditingPracticeIdeaFlag:Ext.getCmp("unitAuditingPracticeIdeaFlag").getValue(),
							drivingLicenceAuditingIdeaFlag:Ext.getCmp("drivingLicenceAuditingIdeaFlag").getValue(),
							orgAuditingIdeaFlag:Ext.getCmp("orgAuditingIdeaFlag").getValue(),
							fieldResult:Ext.getCmp("fieldResult").getValue(),
							examinerFieldOne:Ext.getCmp("examinerFieldOne").getValue(),
							examinerFieldTwo:Ext.getCmp("examinerFieldTwo").getValue(),
							fieldDate:Ext.util.Format.date(Ext.getCmp("fieldDate").getValue(),'Y-m-d'),
							makeupFieldResult:Ext.getCmp("makeupFieldResult").getValue(),
							examinerMakeupFieldOne:Ext.getCmp("makeupFieldResult").getValue(),
							examinerMakeupFieldTwo:Ext.getCmp("examinerMakeupFieldTwo").getValue(),
							makeupFieldDate:Ext.util.Format.date(Ext.getCmp("makeupFieldDate").getValue(),'Y-m-d'),
							machineResult:Ext.getCmp("machineResult").getValue(),
							examinerMachineOne:Ext.getCmp("examinerMachineOne").getValue(),
							examinerMachineTwo:Ext.getCmp("examinerMachineTwo").getValue(),
							machineDate:Ext.util.Format.date(Ext.getCmp("machineDate").getValue(),'Y-m-d'),
							makeupMachineResult:Ext.getCmp("makeupMachineResult").getValue(),
							examinerMakeupMachineOne:Ext.getCmp("examinerMakeupMachineOne").getValue(),
							examinerMakeupMachineTwo:Ext.getCmp("examinerMakeupMachineTwo").getValue(),
							makeupMachineDate:Ext.util.Format.date(Ext.getCmp("makeupMachineDate").getValue(),'Y-m-d'),
							roadResult:Ext.getCmp("roadResult").getValue(),
							examinerRoadOne:Ext.getCmp("examinerRoadOne").getValue(),
							examinerRoadTwo:Ext.getCmp("examinerRoadTwo").getValue(),
							roadDate:Ext.util.Format.date(Ext.getCmp("roadDate").getValue(),'Y-m-d'),
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
					Ext.getCmp("practiceExamWin").close();
				}
			}]
		});
		Ynzc.manage.PracticeExamWin.superclass.initComponent.apply(this,arguments);
	}
});