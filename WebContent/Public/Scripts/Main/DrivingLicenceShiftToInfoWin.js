Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivingLicenceShiftToInfoWin = Ext.extend(Ext.Window, {
    id: 'drivingLicenceShiftToInfoWin',
    initComponent: function() {
		Ext.apply(this,{
			title:"驾照转出信息查看",
			id:"drivingLicenceShiftToInfoWin",
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
								id:"proveType",
	                    		fieldLabel:"证件种类",
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
								id:"proveId",
								fieldLabel:"证件号",
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
								id:"shiftToAddress",
								fieldLabel:"转出地",
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
								id:"goToAddress",
								fieldLabel:"转入地",
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
								id:"causation",
								fieldLabel:"原因",
								xtype:"textfield",
								readOnly:true,
								anchor:'98%'
							}]
						}]
					},{
						xtype:'fieldset',
						title:"驾驶员个人信息",						
						autoHeight:true,						
						titleCollapse:true,
						listeners:{'collapse':function(obj){                            
								if(Ext.get('drivingLicenceShiftToInfoWin') && clickType1 ==="0" && clickTyep2 ==="0"){
									Ynzc.manage.Window.setHeight(265);							         
								}
								if(Ext.get('drivingLicenceShiftToInfoWin') && clickType1 ==="1" && clickTyep2 ==="0"){
									Ynzc.manage.Window.setHeight(265);
									clickType1 = "0";
								}
								if(Ext.get('drivingLicenceShiftToInfoWin') && clickType1 ==="1" && clickTyep2 ==="1"){
									Ynzc.manage.Window.setHeight(510);
									clickType1 ="0";
								}
							},
							'expand':function(obj){					
								Ynzc.manage.Window.setHeight(590);
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
								if(Ext.get('drivingLicenceShiftToInfoWin') && clickTyep2 ==="0" && clickType1==="0"){
									Ynzc.manage.Window.setHeight(265);   					         
									}
								if(Ext.get('drivingLicenceShiftToInfoWin') && clickType1 ==="0"  && clickTyep2 ==="1"){
									Ynzc.manage.Window.setHeight(265);
									clickTyep2 ="0";
									}
								if(Ext.get('drivingLicenceShiftToInfoWin') && clickType1 ==="1"  && clickTyep2 ==="1"){
									Ynzc.manage.Window.setHeight(590);
									clickTyep2 ="0";
									}
							},
							'expand':function(obj){
								Ynzc.manage.Window.setHeight(510);
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
					id:"cancelBtn",
					text:"取消",
					handler:function(){
					Ext.getCmp("drivingLicenceShiftToInfoWin").close();
				}
			}]
		});
		Ynzc.manage.DrivingLicenceShiftToInfoWin.superclass.initComponent.apply(this,arguments);
	}
});