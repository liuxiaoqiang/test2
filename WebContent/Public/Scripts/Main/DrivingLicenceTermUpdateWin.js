Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivinglicenceTermUpdateWin = Ext.extend(Ext.Window, {
    id: 'drivinglicenceTermUpdateWin',
    initComponent: function() {
		Ext.apply(this,{
			title:"修改驾照期满信息",
			id:"updateLicence",
			width:600,
			autoScroll:true,
			resizable:false,
			modal:true,
			frame:true,
			items:[{
				layout:"column",
				frame:true,
				items:[{
					columnWidth:1,
					frame:true,
					items:[{
						xtype:'fieldset',
						title:"修改驾照期满信息",						
						autoHeight:true,						
						titleCollapse:true,
						maskDisabled:false,
						layout:"column",
						width:560,
						items:[{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
	                    		id:"changeHight",
	                    		fieldLabel:"身高",
	                    		xtype:"textfield",
	                    		readOnly:true,
	                    		listeners:{
	                    			"focus":function(){
	                    				new Ext.Window({
	                    					id:"heightwin",
	                    					title:"身高[单位：<font color=red>CM</font>]",
	                    					height:100,
	                    					modal:true,
	                    					width:200,
	                    					resizable:false,
	                    					layout:"form",
	                    					bodyStyle:"padding:5px 5px",
	                    					labelWidth:40,
	                    					items:[{
	                    						id:"bodyHight",
	                    						fieldLabel:"身高",
	                    						xtype:"textfield",
	                    						anchor:'100%'
	                    					}],
	                    					buttons:[{
	                    						text:"确定",
	                    						handler:function(){
	                    							if(Ext.getCmp("bodyHight").getValue()==""){
	                    								Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
	                    								return;
	                    							}else{
	                    								if(Ext.getCmp("bodyHight").getValue().length>3 || Ext.getCmp("bodyHight").getValue().length<3 || Ext.getCmp("bodyHight").getValue().indexOf(".")>0){
		                    								Ext.MessageBox.alert("提示","录入的数据有误，请检查!");
		                    								return;
		                    							}else{
		                    								var res=Ext.getCmp("bodyHight").getValue()+"CM";
		                    								Ext.getCmp("changeHight").setValue(res);
		                    								Ext.getCmp("heightwin").close();
		                    							}
	                    							}
	                    						}
	                    					}]
	                    				}).show(Ext.getCmp("changeHight").getEl());
	                    				if(Ext.getCmp("changeHight").getValue()!=""){
	                    					var strArray=Ext.getCmp("changeHight").getValue().replace("CM","");
	                    					Ext.getCmp("bodyHight").setValue(strArray);
	                    				}
	                    			}
	                    		},
	                    		anchor:'98%'
	                    	}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeResolvingPowerFlag",
	                    		fieldLabel:"辨色力",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择辨色力情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeRightEyePwoer",
								fieldLabel:"右眼视力",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeRightEyeRectificationFlag",
	                    		fieldLabel:"右眼矫正",
	                    		xtype:"combo",
	                    		displayField : 'displayvalue',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.YesOrNoStore,
				                emptyText:"请选择是否矫正",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeLeftEyePwoer",
								fieldLabel:"左眼视力",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeLeftEyeRectificationFlag",
	                    		fieldLabel:"左眼矫正",
	                    		xtype:"combo",
	                    		displayField : 'displayvalue',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.YesOrNoStore,
				                emptyText:"请选择是否矫正",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeRightEarPwoer",
	                    		fieldLabel:"右耳听力",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择右耳听力情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeLeftEarPwoer",
	                    		fieldLabel:"左耳听力",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择左耳听力情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeRightHandFlag",
	                    		fieldLabel:"右上肢",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择右上肢情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeLeftHandFlag",
	                    		fieldLabel:"左上肢",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择左上肢情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeRightLagFlag",
	                    		fieldLabel:"右下肢",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择右下肢情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeLeftLagFlag",
	                    		fieldLabel:"左下肢",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择左下肢情况",
	                    		anchor:'98%' 
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeBodyNeck",
	                    		fieldLabel:"身体和颈椎",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.ExactitudeOrUnExactitudeStore,
				                emptyText:"请选择身体和颈椎情况",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeBodyCheckDate",
								fieldLabel:"身体检查时间",
								xtype:"datefield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeCheckResultFlag",
	                    		fieldLabel:"检查结果",
	                    		xtype:"combo",
	                    		displayField : 'display',
				                valueField : 'value',
				                typeAhead : true,
				                mode : 'local',
				                editable:false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                store:Ynzc.manage.EligibilityOrUnEligibilityStore,
				                emptyText:"请选择检查结果",
	                    		anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeCheckOrganization",
								fieldLabel:"检查机构",
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeCheckDoctor",
								fieldLabel:"检查医生",
								xtype:"textfield",
								anchor:'98%'
							}]
						}]
					},{
						xtype:'fieldset',
						title:"驾驶员个人信息",						
						autoHeight:true,						
						titleCollapse:true,
						listeners:{'collapse':function(obj){                            
								if(Ext.get('updateLicence') && clickType1 ==="0" && clickTyep2 ==="0"){
									Ynzc.manage.updateLicencewin.setHeight(480);							         
								}
								if(Ext.get('updateLicence') && clickType1 ==="1" && clickTyep2 ==="0"){
									Ynzc.manage.updateLicencewin.setHeight(480);
									clickType1 = "0";
								}
								if(Ext.get('updateLicence') && clickType1 ==="1" && clickTyep2 ==="1"){
									Ynzc.manage.updateLicencewin.setHeight(559);
									clickType1 ="0";
								}
							},
							'expand':function(obj){					
								Ynzc.manage.updateLicencewin.setHeight(611);
								clickType1 ="1";
							}
						},
						collapsed:true,
						collapsible:true,
						maskDisabled:false,
						layout:"column",
						width:560,
						items:[{
							columnWidth:.8,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"peopleName",
								readOnly:true,
								fieldLabel:"姓名",
								labelWidth:60,
								
								xtype:"textfield",
								anchor:'98%'
							},{
								id:"sex",
								readOnly:true,
								fieldLabel:"性别",
								labelWidth:60,
								xtype:"textfield",
								anchor:'98%'
							},{
								id:"birthday",
								readOnly:true,
								fieldLabel:"出生日期",
								labelWidth:60,
								xtype:"textfield",
								anchor:'98%'
							},{
								id:"idCard",
								readOnly:true,
								fieldLabel:"身份证",
								labelWidth:60,
								xtype:"textfield",
								anchor:'98%'
							},{
								id:"idStay",
								readOnly:true,
								fieldLabel:"暂住证",
								labelWidth:60,
								xtype:"textfield",
								anchor:'98%'
							}]
						},{
							columnWidth:.2,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"picture",
								xtype:'box',
								height:125,
								width:70,
								anchor:'98%',
								autoEl:{
									tag:'img',
									src:'./Public/Images/sys/noupload.gif'
								}
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"linkTel",
								readOnly:true,
								fieldLabel:"联系电话",
								labelWidth:60,
								xtype:"textfield",
								anchor:'99%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"drivingLicenceNo",
								readOnly:true,
								fieldLabel:"驾驶号",
								labelWidth:60,
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
								fieldLabel:"驾照类型",
								labelWidth:60,
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
								id:"startDate",
								readOnly:true,
								fieldLabel:"开始日期",
								labelWidth:60,
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
								id:"endDate",
								readOnly:true,
								fieldLabel:"结束日期",
								labelWidth:60,
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
								id:"drivingLicenceFlag",
								readOnly:true,
								fieldLabel:"是否打印",
								labelWidth:60,
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
								id:"putOutDate",
								readOnly:true,
								fieldLabel:"打印日期",
								labelWidth:60,
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
								id:"userState",
								readOnly:true,
								fieldLabel:"使用状态",
								labelWidth:60,
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
								id:"degree",
								readOnly:true,
								fieldLabel:"文化程度",
								labelWidth:60,
								xtype:"textfield",
								anchor:'99%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"address",
								readOnly:true,
								fieldLabel:"家庭地址",
								labelWidth:60,
								xtype:"textfield",
								anchor:'99%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"linkAddress",
								readOnly:true,
								fieldLabel:"联系地址",
								labelWidth:60,
								xtype:"textfield",
								anchor:'99%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:60,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"postalcode",
								readOnly:true,
								fieldLabel:"邮政编码",
								labelWidth:60,
								xtype:"textfield",
								anchor:'99%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							baseCls:"x-plain",
							labelWidth:60,
							items:[{
								id:"nativePlace",
								readOnly:true,
								fieldLabel:"籍贯",
								labelWidth:60,
								xtype:"textfield",
								anchor:'99%'
							}]
						}]
					},{
						xtype:'fieldset',
						title:"驾驶员健康信息",						
						autoHeight:true,						
						titleCollapse:true,
						listeners:{'collapse':function(obj){                            
								if(Ext.get('updateLicence') && clickTyep2 ==="0" && clickType1==="0"){
									Ynzc.manage.updateLicencewin.setHeight(480);   					         
									}
								if(Ext.get('updateLicence') && clickType1 ==="0"  && clickTyep2 ==="1"){
									Ynzc.manage.updateLicencewin.setHeight(480);
									clickTyep2 ="0";
									}
								if(Ext.get('updateLicence') && clickType1 ==="1"  && clickTyep2 ==="1"){
									Ynzc.manage.updateLicencewin.setHeight(611);
									clickTyep2 ="0";
									}
							},
							'expand':function(obj){
								Ynzc.manage.updateLicencewin.setHeight(559);
								clickTyep2 = "1";
							}
						},
						collapsed:true,
						collapsible:true,
						maskDisabled:false,
						layout:"column",
						width:560,
						items:[{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"hight",
								fieldLabel:"身高",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"resolvingPowerFlag",
								fieldLabel:"辨色力",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"rightEyePwoer",
								fieldLabel:"右眼视力",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plian",
							items:[{
								id:"rightEyeRectificationFlag",
								fieldLabel:"右眼矫正",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plian",
							items:[{
								id:"leftEyePwoer",
								fieldLabel:"左眼视力",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"leftEyeRectificationFlag",
								fieldLabel:"左眼矫正",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"rightEarPwoer",
								fieldLabel:"右耳听力",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"leftEarPwoer",
								fieldLabel:"左耳听力",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"rightHandFlag",
								fieldLabel:"右上肢",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"leftHandFlag",
								fieldLabel:"左上肢",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"rightLagFlag",
								fieldLabel:"右下肢",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"leftLagFlag",
								fieldLabel:"左下肢",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"bodyNeck",
								fieldLabel:"身体颈椎",
								xtype:"textfield",
								readOnly:true,
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"bodyCheckDate",
								fieldLabel:"检查时间",
								xtype:"textfield",
								readOnly:true,
								format:"Y-m-d",
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"checkResultFlag",
								fieldLabel:"检查结果",
								xtype:"textfield",
								anchor:'98%',
								readOnly:true
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"checkOrganization",
								fieldLabel:"检查机构",
								xtype:"textfield",
								readOnly:true,
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							height:'auto',
							labelWidth:60,
							baseCls:"x-plain",
							items:[{
								id:"checkDoctor",
								fieldLabel:"检查医生",
								xtype:"textfield",
								readOnly:true,
								anchor:'98%'
							}]
						}]
					}]
				}]
			}],
			buttons:[{
				id:"savaBtn",
				text:"保存",
				handler:function(){
					if(Ext.getCmp("drivingLicenceId").getValue() == ""){
						Ext.MessageBox.alert("提示","请填选择人员!");
						initFocus("drivingLicenceId");
						return;
					}
					if(Ext.getCmp("changeHight").getValue() == ""){
						Ext.MessageBox.alert("提示","请填写身高!");
						initFocus("changeHight");
						return;
					}
					if(Ext.getCmp("changeResolvingPowerFlag").getValue()=== ""){
						Ext.MessageBox.alert("提示","请填写辨色力!");
						initFocus("changeResolvingPowerFlag");
						return;
					}
					if(checkNum(Ext.getCmp("changeRightEyePwoer").getValue())){
						Ext.MessageBox.alert("提示","右眼视力填写有误!");
						initFocus("changeRightEyePwoer");
						return;
					}
					if(checkNum(Ext.getCmp("changeLeftEyePwoer").getValue())){
						Ext.MessageBox.alert("提示","左眼视力填写有误!");
						initFocus("changeLeftEyePwoer");
						return;
					}
					if(Ext.getCmp("changeRightEyeRectificationFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填选择右眼矫正!");
						initFocus("changeRightEyeRectificationFlag");
						return;
					}
					if(Ext.getCmp("changeLeftEyeRectificationFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请选择左眼矫正!");
						initFocus("changeLeftEyeRectificationFlag");
						return;
					}
					if(Ext.getCmp("changeRightEarPwoer").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写右耳听力!");
						initFocus("changeRightEarPwoer");
						return;
					}
					if(Ext.getCmp("changeLeftEarPwoer").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写左耳听力!");
						initFocus("changeLeftEarPwoer");
						return;
					}
					if(Ext.getCmp("changeRightHandFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写右手!");
						initFocus("changeRightHandFlag");
						return;
					}
					if(Ext.getCmp("changeLeftHandFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写左手!");
						initFocus("changeLeftHandFlag");
						return;
					}
					if(Ext.getCmp("changeRightLagFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写右脚!");
						initFocus("changeRightLagFlag");
						return;
					}
					if(Ext.getCmp("changeLeftLagFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写左脚!");
						initFocus("changeLeftLagFlag");
						return;
					}
					if(Ext.getCmp("changeBodyNeck").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写身体和颈椎!");
						initFocus("changeBodyNeck");
						return;
					}
					if(Ext.getCmp("changeBodyCheckDate").getValue() == ""){
						Ext.MessageBox.alert("提示","请填写身体检查时间!");
						initFocus("changeBodyCheckDate");
						return;
					}
					if(Ext.getCmp("changeCheckResultFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请选择检查结果!");
						initFocus("changeCheckResultFlag");
						return;
					}
					if(checkLen(Ext.getCmp("changeCheckOrganization").getValue())){
						Ext.MessageBox.alert("提示","请填写检查机构!");
						initFocus("changeCheckOrganization");
						return;
					}
					if(checkLen(Ext.getCmp("changeCheckDoctor").getValue())){
						Ext.MessageBox.alert("提示","请填写检查医生!");
						initFocus("changeCheckDoctor");
						return;
					}
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在录入数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
					Ext.Ajax.request({
						url:"main/drivingLicenceTerm.html?action=updateDrivingLicenceTerm",
						success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								if(result.success==true){
									Ext.MessageBox.alert("提示",result.reason);
									Ext.getCmp("drivingLicenceTermMgr").getStore().reload();
									Ext.getCmp("drivinglicenceTermUpdateWin").close();
								}else{
									Ext.MessageBox.alert("提示",result.reason);
								}
							}else{
								Ext.MessageBox.alert("提示",result.reason);
							}
						},
						failure:function(){
							Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							bodyInfoId:Ynzc.manage.bodyInfoId,
							changeHight:Ext.getCmp("changeHight").getValue(),
							changeResolvingPowerFlag:Ext.getCmp("changeResolvingPowerFlag").getValue(),
							changeRightEyePwoer:Ext.getCmp("changeRightEyePwoer").getValue(),
							changeRightEyeRectificationFlag:Ext.getCmp("changeRightEyeRectificationFlag").getValue(),
							changeLeftEyePwoer:Ext.getCmp("changeLeftEyePwoer").getValue(),
							changeLeftEyeRectificationFlag:Ext.getCmp("changeLeftEyeRectificationFlag").getValue(),
							changeRightEarPwoer:Ext.getCmp("changeRightEarPwoer").getValue(),
							changeLeftEarPwoer:Ext.getCmp("changeLeftEarPwoer").getValue(),
							changeRightHandFlag:Ext.getCmp("changeRightHandFlag").getValue(),
							changeLeftHandFlag:Ext.getCmp("changeLeftHandFlag").getValue(),
							changeRightLagFlag:Ext.getCmp("changeRightLagFlag").getValue(),
							changeLeftLagFlag:Ext.getCmp("changeLeftLagFlag").getValue(),
							changeBodyNeck:Ext.getCmp("changeBodyNeck").getValue(),
							changeBodyCheckDate:Ext.util.Format.date(Ext.getCmp("changeBodyCheckDate").getValue(),'Y-m-d'),
							changeCheckResultFlag:Ext.getCmp("changeCheckResultFlag").getValue(),
							changeCheckOrganization:Ext.getCmp("changeCheckOrganization").getValue(),
							changeCheckDoctor:Ext.getCmp("changeCheckDoctor").getValue()
						}
					});
				}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("drivinglicenceTermUpdateWin").close();
				}
			}]
		});
		Ynzc.manage.DrivinglicenceTermUpdateWin.superclass.initComponent.apply(this,arguments);
	}
});