Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivingLicenceChangeUpdateWin = Ext.extend(Ext.Window, {
    id: 'drivingLicenceChangeUpdateWin',
    initComponent: function() {
		Ext.apply(this,{
			title:"修改驾照变更信息",
			id:"updateDriverInfo",
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
						title:"修改驾照变更信息",						
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
								id:"changeName",
								fieldLabel:"姓名",
								xtype:"textfield",
								readOnly:true,
								anchor:'98%'
							}]
						},{
							columnWidth:.5,
							layout:"form",
							labelWidth:80,
							height:'auto',
							baseCls:"x-plain",
							items:[{
								id:"changeBirthday",
								fieldLabel:"出生日期",
								xtype:"datefield",
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
								id:"changeIdCard",
								fieldLabel:"身份证",
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
								id:"changeAddress",
								fieldLabel:"家庭地址",
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
								id:"changeLinkAddress",
								fieldLabel:"联系地址",
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
								id:"changeLinkTel",
								fieldLabel:"联系电话",
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
								if(Ext.get('updateDriverInfo') && clickType1 ==="0" && clickTyep2 ==="0"){
									Ynzc.manage.updateDriverwin.setHeight(300);							         
								}
								if(Ext.get('updateDriverInfo') && clickType1 ==="1" && clickTyep2 ==="0"){
									Ynzc.manage.updateDriverwin.setHeight(300);
									clickType1 = "0";
								}
								if(Ext.get('updateDriverInfo') && clickType1 ==="1" && clickTyep2 ==="1"){
									Ynzc.manage.updateDriverwin.setHeight(559);
									clickType1 ="0";
								}
							},
							'expand':function(obj){					
								Ynzc.manage.updateDriverwin.setHeight(611);
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
								if(Ext.get('updateDriverInfo') && clickTyep2 ==="0" && clickType1==="0"){
									Ynzc.manage.updateDriverwin.setHeight(300);   					         
									}
								if(Ext.get('updateDriverInfo') && clickType1 ==="0"  && clickTyep2 ==="1"){
									Ynzc.manage.updateDriverwin.setHeight(300);
									clickTyep2 ="0";
									}
								if(Ext.get('updateDriverInfo') && clickType1 ==="1"  && clickTyep2 ==="1"){
									Ynzc.manage.updateDriverwin.setHeight(611);
									clickTyep2 ="0";
									}
							},
							'expand':function(obj){
								Ynzc.manage.updateDriverwin.setHeight(559);
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
					if(Ext.getCmp("changeName").getValue()==""){
						Ext.MessageBox.alert("提示","请选择培养类型!");
						return;
					}
					if(Ext.getCmp("changeBirthday").getValue()==""){
						Ext.MessageBox.alert("提示","请选择人员信息!");
						return;
					}
					if(Ext.getCmp("changeIdCard").getValue()==""){
						Ext.MessageBox.alert("提示","请选择申请型号!");
						return;
					}
					if(Ext.getCmp("changeAddress").getValue()==""){
						Ext.MessageBox.alert("提示","请选择申请地址!");
						return;
					}
					if(Ext.getCmp("changeLinkTel").getValue()==""){
						Ext.MessageBox.alert("提示","请填写报考号!");
						return;
					}
					if(Ext.getCmp("changeLinkAddress").getValue()==""){
						Ext.MessageBox.alert("提示","请填写联系地址!");
						return;
					}
					if(Ext.getCmp("changeName").getValue() === Ext.getCmp("peopleName").getValue() && Ext.util.Format.date(Ext.getCmp("changeBirthday").getValue(),'Y-m-d') === Ext.getCmp("birthday").getValue() && Ext.getCmp("changeIdCard").getValue() === Ext.getCmp("idCard").getValue() && Ext.getCmp("changeAddress").getValue() === Ext.getCmp("address").getValue() && Ext.getCmp("changeLinkTel").getValue() === Ext.getCmp("linkTel").getValue() && Ext.getCmp("changeLinkAddress").getValue() === Ext.getCmp("linkAddress").getValue()){
						Ext.MessageBox.alert("提示","信息没有发生变更，请检查所填信息");
						return;
					}
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在录入数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
					Ext.Ajax.request({
						url:"main/drivingLicenceChange.html?action=updateDrivingLicenceChange",
						success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								if(result.success==true){
									Ext.MessageBox.alert("提示",result.reason);
									Ext.getCmp("driverLicenceChangeMgr").getStore().reload();
									Ext.getCmp("drivingLicenceChangeUpdateWin").close();
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
							id:Ynzc.manage.drivingLicenceChangeId,
							changeName:Ext.getCmp("changeName").getValue(),
							changeBirthday:Ext.util.Format.date(Ext.getCmp("changeBirthday").getValue(),'Y-m-d'),
							changeIdCard:Ext.getCmp("changeIdCard").getValue(),
							changeAddress:Ext.getCmp("changeAddress").getValue(),
							changeLinkAddress:Ext.getCmp("changeLinkAddress").getValue(),
							changeLinkTel:Ext.getCmp("changeLinkTel").getValue()
						}
					});
				}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("drivingLicenceChangeUpdateWin").close();
				}
			}]
		});
		Ynzc.manage.DrivingLicenceChangeUpdateWin.superclass.initComponent.apply(this,arguments);
	}
});