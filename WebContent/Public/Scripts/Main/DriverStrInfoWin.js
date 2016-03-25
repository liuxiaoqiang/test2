Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DriverStrInfoWin = Ext.extend(Ext.Window, {
	id: 'driverStrInfoWin',
	initComponent: function() {
		Ext.apply(this,{
			title:"添加学员信息",
			id:"addStudentInfo",
			width:600,
			autoScroll:true,
			resizable:false,
			modal:true,			
			items:[{
				layout:"column",
				frame:true,
				items:[{
					columnWidth:1,
					frame:true,
					items:[{
						xtype:'fieldset',
						title:"添加学员信息",						
						autoHeight:true,						
						titleCollapse:true,
						maskDisabled:false,
						layout:"column",
						width:560,
						items:[{
							columnWidth:1,
				        	layout:"form",
				        	labelWidth:60,
				        	height:'auto',				        	
				        	baseCls: "x-plain",
				        	items:[{
				        		id:"peopleInfoId",
				        		fieldLabel:"人员信息",
								xtype:"driverStrInfoCombo",
								anchor:'100%'
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
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"drivingLicenceType",
								fieldLabel:"原驾驶类型",
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
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							readOnly:true,
							items:[{
								id:"applicationAddress",
								fieldLabel:"申请地址",
								xtype:"applicationAddressCombo",
								anchor:'98%'
							}]
						}]
					},{
						xtype:'fieldset',
						title:"学员个人信息",						
						autoHeight:true,						
						titleCollapse:true,
						listeners:{'collapse':function(obj){                            
								if(Ext.get('addStudentInfo') && clickType1 ==="0" && clickTyep2 ==="0"){
									Ynzc.manage.addwin.setHeight(314);							         
								}
								if(Ext.get('addStudentInfo') && clickType1 ==="1" && clickTyep2 ==="0"){
									Ynzc.manage.addwin.setHeight(314);
									clickType1 = "0";
								}
								if(Ext.get('addStudentInfo') && clickType1 ==="1" && clickTyep2 ==="1"){
									Ynzc.manage.addwin.setHeight(559);
									clickType1 ="0";
								}
							},
							'expand':function(obj){					
								Ynzc.manage.addwin.setHeight(611);
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
							columnWidth:1,
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
							columnWidth:1,
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
							columnWidth:1,
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
							columnWidth:1,
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
							columnWidth:1,
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
						}]
					},{
						xtype:'fieldset',
						title:"个人健康信息",						
						autoHeight:true,						
						titleCollapse:true,
						listeners:{'collapse':function(obj){                            
								if(Ext.get('addStudentInfo') && clickTyep2 ==="0" && clickType1==="0"){
									Ynzc.manage.addwin.setHeight(314);   					         
									}
								if(Ext.get('addStudentInfo') && clickType1 ==="0"  && clickTyep2 ==="1"){
									Ynzc.manage.addwin.setHeight(314);
									clickTyep2 ="0";
									}
								if(Ext.get('addStudentInfo') && clickType1 ==="1"  && clickTyep2 ==="1"){
									Ynzc.manage.addwin.setHeight(611);
									clickTyep2 ="0";
									}
							},
							'expand':function(obj){
								Ynzc.manage.addwin.setHeight(559);
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
						if(Ext.getCmp("fosterType").getValue()==""){
							Ext.MessageBox.alert("提示","请选择培养类型!");
							return;
						}
						if(Ext.getCmp("peopleInfoId").getValue()==""){
							Ext.MessageBox.alert("提示","请选择人员信息!");
							return;
						}
						if(Ext.getCmp("drivingLicenceTypeId").getValue()==""){
							Ext.MessageBox.alert("提示","请选择申请型号!");
							return;
						}
						if(checkDrivingLicenceType(Ext.getCmp("drivingLicenceType").getValue(),Ext.getCmp("drivingLicenceTypeId").getValue())){
							Ext.MessageBox.alert("提示","用户已经增驾该类型的拖拉机!");
							return;
						}
		                var mask = new Ext.LoadMask(Ext.getBody(), {
				     		msg : '正在录入数据,请稍等...',
				     		removeMask:true
		                });
		                mask.show();
						Ext.Ajax.request({
							url:"main/driverStrInfo.html?action=addDriverStrInfo",
							success:function(resp){
								mask.hide();
								var result=Ext.util.JSON.decode(resp.responseText);
								if(result.success==true){
									if(result.success==true){
										Ext.MessageBox.alert("提示",result.reason);
										Ext.getCmp("dirverClassStrGrid").getStore().reload();
										Ext.getCmp("driverClassInfoMgr").getStore().reload();
										Ext.getCmp("driverStrInfoWin").close();
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
								driverClassInfoId:Ynzc.manage.DriverClassInfoId,
								id:Ynzc.manage.bodyInfoId,
								fosterType:Ext.getCmp("fosterType").getValue(),
								peopleInfoId:Ext.getCmp("peopleInfoId").getMyValue(),
								drivingLicenceTypeId:Ext.getCmp("drivingLicenceTypeId").getValue(),
								applicationAddress:Ext.getCmp("applicationAddress").getValue()
							}
						});
					}
				},{
					id:"cancelBtn",
					text:"取消",
					handler:function(){
						Ext.getCmp("driverStrInfoWin").close();
					}
				}]
		});
	Ynzc.manage.DriverStrInfoWin.superclass.initComponent.apply(this,arguments);
	}
});
var clickType1 ="0";
var clickTyep2 ="0";