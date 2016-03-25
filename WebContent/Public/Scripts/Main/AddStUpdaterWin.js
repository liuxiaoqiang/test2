Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.AddStrUpdateWin=Ext.extend(Ext.Window,{
	id:"addStrUpdateWin",
	initComponent:function(){ 
		Ext.apply(this,{
			id:"addStrWin",
			title:"修改人员基本信息",
			height:500,
			width:640,
			autoScroll:true,
			resizable:true,
			modal:true,
	        layout:"column",
	        bodyStyle:{padding:'10px 10px'},
	        frame:true,
	        items:[{
	        	columnWidth:.85,
	        	layout:"column",
	        	labelWidth:60,
	        	heigth:'auto',
	        	baseCls: "x-plain",
	        	items:[{
	        		columnWidth:.5,
	        		layout:"form",
	        		labelWidth:60,
	        		height:'auto',
	        		baseCls:"x-plain",
	        		items:[{
	        			id:"peopleName",
	        			fieldLabel:"姓名",
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
	        			xtype:"combo",
	        			displayField : 'display',
	        			valueField : 'value',
	        			typeAhead : true,
	        			mode : 'local',
	        			editable:false,
	        			selectOnFoucs : true,
	        			triggerAction : 'all',
	        			store:Ynzc.manage.SexStore,
	        			emptyText:"请选择性别",
	        			anchor:'98%'
	        		}]
	        	},{
	        		columnWidth:.5,
	        		layout:"form",
	        		labelWidth:60,
	        		height:'auto',
	        		baseCls:"x-plain",
	        		items:[{
		        		id:"birthday",
		        		fieldLabel:"出生日期",
		        		xtype:"datefield",
		        		readOnly:true,
		        		format:"Y-m-d",
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
		        		id:"idStay",
		        		fieldLabel:"暂住证",
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
		        		id:"linkTel",
		        		fieldLabel:"联系电话",
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
		        		id:"postalcode",
		        		fieldLabel:"邮政编码",
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
		        		fieldLabel:"文化程度",
		        		xtype:"combo",
		        		displayField : 'display',
		        		valueField : 'value',
		        		typeAhead : true,
		        		mode : 'local',
		        		editable:false,
		        		selectOnFoucs : true,
		        		triggerAction : 'all',
		        		store:Ynzc.manage.DegreeStore,
		        		emptyText:"请选择文化程度",
		        		anchor:'98%'
	        		}]
	        	},{
	        		columnWidth:.5,
	        		layout:"form",
	        		labelWidth:60,
	        		height:'auto',
	        		baseCls:"x-plain",
	        		items:[{
	        			id:"fosterType",
		        		fieldLabel:"培养类型",
						xtype:"textfield",
						anchor:'99%',
		                readOnly:true
	        		}]
	        	},{
	        		columnWidth:.5,
	        		layout:"form",
	        		labelWidth:60,
	        		height:'auto',
	        		baseCls:"x-plain",
	        		items:[{
	        			id:"drivingLicenceType",
						fieldLabel:"已学类型",
						xtype:"textfield",
						anchor:'98%',
						readOnly:true
	        		}]
	        	},{
	        		columnWidth:.5,
	        		layout:"form",
	        		labelWidth:60,
	        		height:'auto',
	        		baseCls:"x-plain",
	        		items:[{
	        			id:"drivingLicenceTypeId",
						fieldLabel:"申请型号",
                		xtype:"combo",
                		displayField : 'display',
		                valueField : 'value',
		                typeAhead : true,
		                mode : 'local',
		                editable:false,
		                selectOnFoucs : true,
		                triggerAction : 'all',
		                store:Ynzc.manage.ApplicationTypeStore,
		                emptyText:"请选择申请类型",
		                anchor:'98%'
	        		}]
	        	},{
	        		columnWidth:.5,
	        		layout:"form",
	        		labelWidth:60,
	        		height:'auto',
	        		baseCls:"x-plain",
	        		items:[{
	        			id:"applicationAddress",
						fieldLabel:"申请地址",
						xtype:"applicationAddressCombo",
						anchor:'98%',
		                readOnly:true
	        		}]
	        	}]
	        },{
	        	columnWidth:.15,
	        	layout:"form",
	        	labelWidth:60,
	        	baseCls: "x-plain",
	        	items:[{
	        		id: "photoDir",
	        		xtype: "picpanel",
	        		defaultPicUrl: "./Public/Images/sys/noupload.gif",
	        		actionUrl: "main/tractorInfo.html?action=uploadPic",
	        		uploadWinTitle: "上传拖拉机图片",
	        		anchor:'100%',
	        		height: 160,
	        		width:90 
	        	}]
	        },{
	        	columnWidth:1,
	        	layout:"form",
	        	labelWidth:60,
	        	baseCls: "x-plain",
	        	items:[{
	        		id:"linkAddress",
	        		fieldLabel:"联系地址",
	        		xtype:"textfield",
	        		anchor:'100%'
	        	}]
	        }
//	        ,{
//	        	columnWidth:.5,
//	        	layout:"form",
//	        	labelWidth:60,
//	        	baseCls: "x-plain",
//	        	items:[{
//	        		id:"nativePlace",
//	        		fieldLabel:"籍贯",
//	        		xtype:"textfield",
//	        		anchor:'100%'   
//	        	}]
//	        }
	        ,{
	        	columnWidth:1,
	        	layout:"form",
	        	labelWidth:60,
	        	baseCls: "x-plain",
	        	items:[{	        		
	        		id:"address",
	        		fieldLabel:"家庭地址",
	        		xtype:"textfield",
	        		anchor:'100%'
	        			
	        	}]
	        },{
	        	columnWidth:1,
	        	layout:"form",
	        	labelWidth:60,
	        	baseCls: "x-plain",
	        	items:[{
					layout:"column",
					frame:true,
					width:590,
					items:[{
						columnWidth:1,
						items:[{
							xtype:'fieldset',
							title:"基本健康信息",
							autoHeight:true,
							width:575,
							layout:"form",
							items:[{								
								id:"baseHealth",
								xtype:'fieldset',
								title:"基本健康信息",
								autoHeight:true,
								width:550,
								layout:"column",
								items:[{
									columnWidth:.5,
									layout:"form",
									border:false,
									labelWidth:60,
									items:[{
										id:"hight",
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
																Ext.getCmp("hight").setValue(res);
																Ext.getCmp("heightwin").close();
															}
														}
													}
													}]
												}).show();
												if(Ext.getCmp("hight").getValue()!=""){
													var strArray=Ext.getCmp("hight").getValue().replace("CM","");
													Ext.getCmp("bodyHight").setValue(strArray);
												}
									}
									},
									anchor:'98%'
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:60,
										items:[{
											id:"resolvingPowerFlagId",
											name:"resolvingPowerFlag",
											fieldLabel:'辨色力',
											xtype: "radio",
											boxLabel:'正常',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"resolvingPowerFlag",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'异常',
											inputValue:'0'
										}]
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:70,
									items:[{								
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"bodyNeckId",
											name:"bodyNeck",
											fieldLabel:'身体和颈椎',
											xtype: "radio",
											boxLabel:'正常',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"bodyNeck",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'异常',
											inputValue:'0'
										}]								
									}]								
								}]
							},{
								id:"eyeSet",
								xtype:'fieldset',
								title:"眼睛健康信息",
								width:550,
								autoHeight:true,
								layout:"column",
								items:[{
									columnWidth:.5,
									layout:"form",
									border:false,
									labelWidth:60,
									items:[{
										id:"rightEyePwoer",
										fieldLabel:"右眼视力",
										xtype:"textfield",
										anchor:'98%'						
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{																
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"rightEyeRectificationFlagId",
											name:"rightEyeRectificationFlag",
											fieldLabel:'右眼矫正',
											xtype: "radio",
											boxLabel:'是',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"rightEyeRectificationFlag",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'否',
											inputValue:'0'
										}]										
									}]
								},{
									columnWidth:.5,
									layout:"form",
									border:false,
									labelWidth:60,
									items:[{
										id:"leftEyePwoer",
										fieldLabel:"左眼视力",
										xtype:"textfield",
										anchor:'98%'
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{																								
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"leftEyeRectificationFlagId",
											name:"leftEyeRectificationFlag",
											fieldLabel:'左眼矫正',
											xtype: "radio",
											boxLabel:'是',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"leftEyeRectificationFlag",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'否',
											inputValue:'0'
										}]												
									}]
								}]						
							},{
								id:"earHealth",
								xtype:'fieldset',
								title:"耳朵健康信息",
								autoHeight:true,
								width:550,
								layout:"column",
								items:[{							
										columnWidth:.5,
										layout:"form",
										border:false,
										labelWidth:60,
										items:[{
										id:"rightEarPwoerId",
										name:"rightEarPwoer",
										fieldLabel:'右耳听力',
										xtype:"textfield",
										readOnly:true,
										listeners:{
											"focus":function(){
												new Ext.Window({
													id:"rightEarPwoerwin",
													title:"右耳听力[单位：<font color=red>米</font>]",
													height:120,
													modal:true,
													width:210,
													resizable:false,
													layout:"form",
													bodyStyle:"padding:5px 5px",
													labelWidth:40,
													items:[{
														id:"rightEarPwoer",
														fieldLabel:"右耳听力",
														xtype:"textfield",
														anchor:'90%'
													}],
													buttons:[{
														text:"确定",
														handler:function(){
															if(Ext.getCmp("rightEarPwoer").getValue()==""){
																Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
																return;
															}else{
																var res=Ext.getCmp("rightEarPwoer").getValue()+"M";
																Ext.getCmp("rightEarPwoerId").setValue(res);
																Ext.getCmp("rightEarPwoerwin").close();	
																}
															}
														}]
													}).show();
													if(Ext.getCmp("rightEarPwoerId").getValue()!=""){
														var strArray=Ext.getCmp("rightEarPwoerId").getValue().replace("米","");
														Ext.getCmp("rightEarPwoerId").setValue(strArray);
													}
												}
											},
											anchor:'98%'
										}]
										},{							
										columnWidth:.5,
										layout:"form",
										border:false,
										labelWidth:60,
										items:[{
										id:"leftEarPwoerId",
										name:"leftEarPwoer",
										fieldLabel:'左耳听力',
										xtype:"textfield",
										readOnly:true,
										listeners:{
											"focus":function(){
												new Ext.Window({
													id:"leftEarPwoerwin",
													title:"左耳听力[单位：<font color=red>米</font>]",
													height:120,
													modal:true,
													width:210,
													resizable:false,
													layout:"form",
													bodyStyle:"padding:5px 5px",
													labelWidth:40,
													items:[{
														id:"leftEarPwoer",
														fieldLabel:"左耳听力",
														xtype:"textfield",
														anchor:'90%'
													}],
													buttons:[{
														text:"确定",
														handler:function(){
															if(Ext.getCmp("leftEarPwoer").getValue()==""){
																Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
																return;
															}else{
																var res=Ext.getCmp("leftEarPwoer").getValue()+"M";
																Ext.getCmp("leftEarPwoerId").setValue(res);
																Ext.getCmp("leftEarPwoerwin").close();	
																}
															}
														}]
													}).show();
													if(Ext.getCmp("leftEarPwoerId").getValue()!=""){
														var strArray=Ext.getCmp("leftEarPwoerId").getValue().replace("米","");
														Ext.getCmp("leftEarPwoerId").setValue(strArray);
													}
												}
											},
											anchor:'98%'
										}]
										}]
							},{
								id:"legsHealth",
								xtype:'fieldset',
								title:"四肢健康信息",
								autoHeight:true,
								width:550,
								layout:"column",
								items:[{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{																																
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"rightHandFlagId",
											name:"rightHandFlag",
											fieldLabel:'右上肢',
											xtype: "radio",
											boxLabel:'正常',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"rightHandFlag",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'异常',
											inputValue:'0'
										}]														
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{																																
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"leftHandFlagId",
											name:"leftHandFlag",
											fieldLabel:'左上肢',
											xtype: "radio",
											boxLabel:'正常',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"leftHandFlag",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'异常',
											inputValue:'0'
										}]														
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{																																
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"rightLagFlagId",
											name:"rightLagFlag",
											fieldLabel:'右下肢',
											xtype: "radio",
											boxLabel:'正常',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"rightLagFlag",
											xtype: "radio",
											hideLabel:true,
											boxLabel:'异常',
											inputValue:'0'
										}]														
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:60,
									items:[{																																
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"leftLagFlagId",
											name:"leftLagFlag",
											fieldLabel:'左下肢',
											xtype: "radio",
											boxLabel:'正常',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"leftLagFlag",
											xtype: "radio",
											hideLabel:true,
											boxLabel:'异常',
											inputValue:'0'
										}]														
									}]
								}]
							},{
								id:"checkInfo",
								xtype:'fieldset',
								title:"检查情况信息",
								autoHeight:true,
								layout:"column",
								width:550,
								items:[{
									columnWidth:.5,
									layout:"form",
									labelWidth:80,
									items:[{
										id:"bodyCheckDate",
										fieldLabel:"身体检查时间",
										xtype:"datefield",
										readOnly:true,
										format:"Y-m-d",
										anchor:'98%'
									}]
								},{
									columnWidth:.5,
									layout:"column",
									border:false,
									labelWidth:80,
									items:[{																																
										columnWidth:.7,
										layout:"form",
										border:false,
										labelWidth:70,
										items:[{
											id:"checkResultFlagId",
											name:"checkResultFlag",
											fieldLabel:'检查结果',
											xtype: "radio",
											boxLabel:'合格',
											inputValue:'1'
										}]
									},{
										columnWidth:.3,
										layout:"form",
										border:false,
										labelWidth:40,
										items:[{
											name:"checkResultFlag",
											hideLabel:true,
											xtype: "radio",
											boxLabel:'不合格',
											inputValue:'0'
										}]														
									}]
								},{
									columnWidth:.5,
									layout:"form",
									border:false,
									labelWidth:80,
									items:[{
										id:"checkOrganization",
										fieldLabel:"检查机构",
										xtype:"textfield",
										anchor:'98%'
									}]
								},{
									columnWidth:.5,
									layout:"form",
									border:false,
									labelWidth:80,
									items:[{
										id:"checkDoctor",
										fieldLabel:"检查医生",
										xtype:"textfield",
										anchor:'98%'
									}]
								}]
							}]
						}]
					}]
	        	}]
	        }] 
		},{
			buttons:[{
				id:"savaBtn",
				text:"保存",
				handler:function(){
					if(checkLen(Ext.getCmp("peopleName").getValue())){
						Ext.MessageBox.alert("提示","姓名填写有误!");
						initFocus("peopleName");
						return;
					}
					if(Ext.getCmp("sex").getValue()==""){
						Ext.MessageBox.alert("提示","请填写性别!");
						return;
					}
					if(Ext.getCmp("birthday").getValue()==""){
						Ext.MessageBox.alert("提示","请填写出生日期!");
						return;
					}
					if(Ext.getCmp("idCard").getValue()==""){
						Ext.MessageBox.alert("提示","身份证号填写有误!");
						initFocus("idCard");
						return;
					}else{
						if(checkIdCard(Ext.getCmp("idCard").getValue()) != true){
							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("idCard").getValue()));
							initFocus("idCard");
							return;
						}
					}
//					if(Ext.getCmp("idStay").getValue()==""){
//						Ext.MessageBox.alert("提示","暂住证号填写有误!");
//						initFocus("idStay");
//						return;
//					}
					if(checkLen(Ext.getCmp("address").getValue())){
						Ext.MessageBox.alert("提示","家庭住址填写有误!");
						initFocus("address");
						return;
					}
					if(checkLen(Ext.getCmp("linkAddress").getValue())){
						Ext.MessageBox.alert("提示","联系地址填写有误!");
						initFocus("linkAddress");
						return;
					}
					if(checkNum(Ext.getCmp("linkTel").getValue())){
						Ext.MessageBox.alert("提示","联系电话填写有误!");
						initFocus("linkTel");
						return;
					}
					if(!checkMobile(Ext.getCmp("linkTel").getValue())){
						Ext.MessageBox.alert("提示","联系电话填写有误!");
						initFocus("linkTel");
						return;
					}
					if(checkPost(Ext.getCmp("postalcode").getValue())){
						Ext.MessageBox.alert("提示","邮编填写有误!");
						initFocus("postalcode");
						return;
					}
//					if(checkLen(Ext.getCmp("nativePlace").getValue())){
//						Ext.MessageBox.alert("提示","籍贯填写有误!");
//						initFocus("nativePlace");
//						return;
//					}
					if(Ext.getCmp("degree").getValue()===""){
						Ext.MessageBox.alert("提示","请填写文化程度!");
						return;
					}
					if(Ext.getCmp("photoDir").getValue()==""){
						Ext.MessageBox.alert("提示","请填上传人员照片!");
						return;
					}
					if(Ext.getCmp("hight").getValue() == ""){
						Ext.MessageBox.alert("提示","身高填写有误!");
						initFocus("hight");
						return;
					}
					if(checkNum(Ext.getCmp("rightEyePwoer").getValue())){
						Ext.MessageBox.alert("提示","右眼视力填写有误!");
						initFocus("rightEyePwoer");
						return;
					}
					if(checkNum(Ext.getCmp("leftEyePwoer").getValue())){
						Ext.MessageBox.alert("提示","左眼视力填写有误!");
						initFocus("leftEyePwoer");
						return;
					}
					if(Ext.getCmp("bodyCheckDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写身体检查时间!");
						return;
					}
					if(checkLen(Ext.getCmp("checkOrganization").getValue())){
						Ext.MessageBox.alert("提示","检查机构填写有误!");
						initFocus("checkOrganization");
						return;
					}
					if(checkLen(Ext.getCmp("checkDoctor").getValue())){
						Ext.MessageBox.alert("提示","检查医生填写有误!");
						initFocus("checkDoctor");
						return;
					}
					if(Ext.getCmp("idStay").getValue()!="" || Ext.getCmp("idStay").getValue() !== "无"){
						if(Ext.getCmp("address").getValue().indexOf("(外地)")<0){
							Ext.getCmp("address").setValue(Ext.getCmp("address").getValue()+"(外地)");
						}
					}
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在录入数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
					Ext.Ajax.request({
						url:"main/peopleInfo.html?action=updatePeopleInfo",
						success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								if(result.success==true){
									Ext.MessageBox.alert("提示",result.reason);
									Ext.getCmp("dirverClassStrGrid").getStore().reload();
									Ext.getCmp("driverClassInfoMgr").getStore().reload();
									Ext.getCmp("addStrUpdateWin").close();
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
							id:Ynzc.manage.Id,
							peopleInfoId:Ynzc.manage.PeopleInfoId,
							peopleName:trim(Ext.getCmp("peopleName").getValue()),
							sex:Ext.getCmp("sex").getValue(),
							birthday:Ext.util.Format.date(Ext.getCmp("birthday").getValue(),'Y-m-d'),
							idCard:trim(Ext.getCmp("idCard").getValue()),
							idStay:trim(Ext.getCmp("idStay").getValue()),
							address:trim(Ext.getCmp("address").getValue()),
							linkAddress:trim(Ext.getCmp("linkAddress").getValue()),
							linkTel:trim(Ext.getCmp("linkTel").getValue()),
							postalcode:trim(Ext.getCmp("postalcode").getValue()),
							degree:trim(Ext.getCmp("degree").getValue()),
							photoDir:Ext.getCmp("photoDir").getValue(),
							hight:Ext.getCmp("hight").getValue(),
							resolvingPowerFlag:Ext.getCmp("resolvingPowerFlagId").getGroupValue(),
							rightEyePwoer:Ext.getCmp("rightEyePwoer").getValue(),
							rightEyeRectificationFlag:Ext.getCmp("rightEyeRectificationFlagId").getGroupValue(),
							leftEyePwoer:Ext.getCmp("leftEyePwoer").getValue(),
							leftEyeRectificationFlag:Ext.getCmp("leftEyeRectificationFlagId").getGroupValue(),
							rightEarPwoer:Ext.getCmp("rightEarPwoerId").getValue(),
							leftEarPwoer:Ext.getCmp("leftEarPwoerId").getValue(),
							rightHandFlag:Ext.getCmp("rightHandFlagId").getGroupValue(),
							degreeleftHandFlag:Ext.getCmp("leftHandFlagId").getGroupValue(),
							rightLagFlag:Ext.getCmp("rightLagFlagId").getGroupValue(),
							leftLagFlag:Ext.getCmp("leftLagFlagId").getGroupValue(),
							bodyNeck:Ext.getCmp("bodyNeckId").getGroupValue(),
							bodyCheckDate:Ext.util.Format.date(Ext.getCmp("bodyCheckDate").getValue(),'Y-m-d'),							
							checkResultFlag:Ext.getCmp("checkResultFlagId").getGroupValue(),
							checkOrganization:Ext.getCmp("checkOrganization").getValue(),
							checkDoctor:Ext.getCmp("checkDoctor").getValue(),
							fosterType:Ext.getCmp("fosterType").getValue(),
							drivingLicenceTypeId:Ext.getCmp("drivingLicenceTypeId").getValue(),
							applicationAddress:Ext.getCmp("applicationAddress").getValue()
						}
					});
				}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("addStrUpdateWin").close();
				}
			}]
		});
		Ynzc.manage.AddStrUpdateWin.superclass.initComponent.apply(this,arguments);
	}
});
