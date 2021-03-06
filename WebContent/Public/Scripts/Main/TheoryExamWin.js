Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.TheoryExamWin=Ext.extend(Ext.Window,{
	id:"theoryExamWin",
	initComponent:function(){
		Ext.apply(this,{
			id:"theoryExamWin",
			title:"理论成绩录入",
			height:615,
			width:550,
			autoScroll:true,
			resizable:false,
			modal:true,
			items:[{
				columnWidth:1,
				frame:true,
				width:'auto',
				items:[{
					title:"学员基本信息",
					xtype:"fieldset",
					layout:"column",
					height:'auto',
					width:500,
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
						baseCls:"x-plain",
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
						baseCls:"x-plain",
						items:[{
							id:"sex",
							fieldLabel:"性别",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
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
						baseCls:"x-plain",
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
						baseCls:"x-plain",
						items:[{
							id:"drivingLicenceTypeId",
							readOnly:true,
							fieldLabel:"驾驶机型",
							xtype:"textfield",
							anchor:'98%'
						}]
					}]
				},{
					title:"学员考试信息",
					xtype:"fieldset",
					layout:"form",
					height:'auto',
					width:500,
					items:[{
						title:"初考信息",
						xtype:"fieldset",
						layout:"column",
						height:'auto',
						width:'auto',
						bodyStyle:{padding:'5px 5px 5px 5px'},
						items:[{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"examinerOne",
								fieldLabel:"初考主考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"examinerTwo",
								fieldLabel:"初考监考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"theoryResult",
								fieldLabel:"初考成绩",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"theoryDate",
								fieldLabel:"初考时间",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					},{
						title:"二考信息",
						xtype:"fieldset",
						layout:"column",
						height:'auto',
						width:'auto',
						bodyStyle:{padding:'5px 5px 5px 5px'},
						items:[{
							columnWidth:.5,
							layout:"form",
							labelWidth:70,
							heigth:'auto',
							baseCls:"x-plain",
							items:[{
								id:"examinerMakeupOne",
								fieldLabel:"二考主考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:70,
							heigth:'auto',
							baseCls:"x-plain",
							items:[{
								id:"examinerMakeupTwo",
								fieldLabel:"二考监考人",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:70,
							heigth:'auto',
							baseCls:"x-plain",
							items:[{
								id:"theoryMakeupResult",
								fieldLabel:"二考成绩",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:70,
							heigth:'auto',
							baseCls:"x-plain",
							items:[{
								id:"theoryMakeupDate",
								fieldLabel:"二考时间",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						}]
					}]
				},{
					title:"评价信息",
					xtype:"fieldset",
					height:'auto',
					width:500,
					layout:"column",
					bodyStyle:{padding:'5px 5px 5px 5px'},
					items:[{
						columnWidth:.6,
						layout:"form",
						labelWidth:120,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"auditingTheoryIdeaFlag",
							fieldLabel:"核发学习驾驶证意见",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.PassStore,
							emptyText:"请选择核发驾驶证意见",
							anchor:'98%'
						}]
					},{
						columnWidth:.4,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"transactor",
							fieldLabel:"经办人",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.6,
						layout:"form",
						labelWidth:120,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"unitTheoryAuditingIdeaFlag",
							fieldLabel:"农机监理部门意见",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.PassStore,
							emptyText:"请选择意见",
							anchor:'98%'
						}]
					},{
						columnWidth:.4,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"unitTheoryAuditingIdeaDate",
							fieldLabel:"填写时间",
							xtype:"datefield",
							readOnly:true,
							format:"Y-m-d",
							anchor:'98%'
						}]
					},{
						columnWidth:.6,
						layout:"form",
						labelWidth:120,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"auditingTheoryResultFlag",
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
							anchor:'98%'
						}]
					}]
				}]				
			}],
			buttons:[{
				id:"savaBtn",
				text:"保存",
				handler:function(){
					if(checkNum(Ext.getCmp("theoryResult").getValue())){
						Ext.MessageBox.alert("提示","初考成绩填写有误!");
						initFocus('theoryResult');
						return;
					}
					if(checkLen(Ext.getCmp("examinerOne").getValue())){
						Ext.MessageBox.alert("提示","初考主考人填写有误!");
						initFocus('examinerOne');
						return;
					}
					if(checkLen(Ext.getCmp("examinerTwo").getValue())){
						Ext.MessageBox.alert("提示","初考监考人填写有误!");
						initFocus('examinerTwo');
						return;
					}
					if(Ext.getCmp("theoryDate").getValue()==""){
						Ext.MessageBox.alert("提示","初考请填写时间!");
						return;
					}
					if(Ext.getCmp("auditingTheoryIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请填选择核发学习驾驶证意见!");
						return;
					}
					if(Ext.getCmp("unitTheoryAuditingIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请填选择地、（州、市）农机监理部门意见!");
						return;
					}
					if(Ext.getCmp("unitTheoryAuditingIdeaDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写地、（州、市）农机监理部门意见填写时间!");
						return;
					}
					if(Ext.getCmp("auditingTheoryResultFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请填选择结论!");
						return;
					}
					if(Ext.getCmp("theoryResult").getValue()<0 || Ext.getCmp("theoryResult").getValue()>100){
						Ext.MessageBox.alert("提示","填写成绩有误不予通过保存!");
						initFocus('theoryResult');
						return;
					}
					if(Ext.getCmp("makeupResult").getValue()<0 || Ext.getCmp("makeupResult").getValue()>100){
						Ext.MessageBox.alert("提示","填写成绩有误不予通过保存!");
						initFocus('makeupResult');
						return;
					}
					if(!checkNum(Ext.getCmp("theoryResult").getValue())){
						if(Ext.getCmp("theoryResult").getValue() < 80){
							if(!checkNum(Ext.getCmp("makeupResult").getValue())){
								if(Ext.getCmp("makeupResult").getValue() < 80 && Ext.getCmp("auditingTheoryResultFlag").getValue() === 1){
									Ext.MessageBox.alert("提示","该学员成绩没有达到合格要求不予选择通过!");
									initFocus('auditingTheoryResultFlag');
									return;
								}
							}else{
								Ext.MessageBox.alert("提示","填写二考成绩有误不予通过保存!");
								initFocus('makeupResult');
								return;
							}
						}
					}else{
						Ext.MessageBox.alert("提示","填写成绩有误不予通过保存!");
						initFocus('theoryResult');
						return;
					}
					if(Ext.getCmp("auditingTheoryResultFlag").getValue() === 1){
						if(Ext.getCmp("auditingTheoryIdeaFlag").getValue() === 0){
							Ext.MessageBox.alert("提示","核发学习驾驶证意见选择有误不予通过保存!");
							initFocus('auditingTheoryIdeaFlag');
							return;
						}
						if(Ext.getCmp("unitTheoryAuditingIdeaFlag").getValue() === 0){
							Ext.MessageBox.alert("提示","地、（州、市）农机监理部门意见选择有误不予通过保存!");
							initFocus('unitTheoryAuditingIdeaFlag');
							return;
						}
					}
					Ext.Ajax.request({
						url:"main/theoryExam.html?action=addTheoryExam",
						success:function(resp){
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								Ext.MessageBox.alert("提示",result.reason);
								Ext.getCmp("dirverClassStrExamGrid").getStore().reload();
								Ext.getCmp("theoryExamWin").close();
							}else{
								Ext.Msg.alert("提示",result.reason);
							}
						},
						failure:function(){
							Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							driverStrInfoId:Ynzc.manage.driverStrInfoId,
							theoryResult:Ext.getCmp("theoryResult").getValue(),
							examinerOne:Ext.getCmp("examinerOne").getValue(),
							examinerTwo:Ext.getCmp("examinerTwo").getValue(),
							theoryDate:Ext.util.Format.date(Ext.getCmp("theoryDate").getValue(),'Y-m-d'),
							theoryMakeupResult:Ext.getCmp("theoryMakeupResult").getValue(),
							examinerMakeupOne:Ext.getCmp("examinerMakeupOne").getValue(),
							examinerMakeupTwo:Ext.getCmp("examinerMakeupTwo").getValue(),
							theoryMakeupDate:Ext.util.Format.date(Ext.getCmp("theoryMakeupDate").getValue(),'Y-m-d'),
							auditingTheoryIdeaFlag:Ext.getCmp("auditingTheoryIdeaFlag").getValue(),
							transactor:Ext.getCmp("transactor").getValue(),
							unitTheoryAuditingIdeaFlag:Ext.getCmp("unitTheoryAuditingIdeaFlag").getValue(),
							unitTheoryAuditingIdeaDate:Ext.util.Format.date(Ext.getCmp("unitTheoryAuditingIdeaDate").getValue(),'Y-m-d'),
							auditingTheoryResultFlag:Ext.getCmp("auditingTheoryResultFlag").getValue()
						}
					});
				}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("theoryExamWin").close();
				}
			}]
		});
		Ynzc.manage.TheoryExamWin.superclass.initComponent.apply(this,arguments);
	}
});