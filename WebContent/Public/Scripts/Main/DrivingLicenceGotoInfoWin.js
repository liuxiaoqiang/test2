Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivinglicenceGotoInfoWin = Ext.extend(Ext.Window, {
    id: 'drivinglicenceGotoInfoWin',
    initComponent: function() {
		Ext.apply(this,{
			title:"驾照转入信息查看",
			height:530,
			width:600,
			autoScroll:true,
			resizable:false,
			modal:true,
			frame:true,
			layout:"column",
			items:[{
				columnWidth:1,
				frame:true,
				width:'auto',
				items:[{
					xtype:'fieldset',
					title:"驾驶员个人信息",						
					autoHeight:true,
					maskDisabled:false,
					layout:"column",
					width:555,
					items:[{
						columnWidth:.8,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"peopleName",
							fieldLabel:"姓名",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						},{
							id:"sex",
							fieldLabel:"性别",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						},{
							id:"birthday",
							fieldLabel:"出生日期",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						},{
							id:"idCard",
							fieldLabel:"身份证",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						},{
							id:"linkTel",
							fieldLabel:"联系电话",
							readOnly:true,
							xtype:"textfield",
							anchor:'98%'
						},{
							id:"idStay",
							fieldLabel:"暂住证",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						},{
							id:"degree",
							fieldLabel:"文化程度",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]						
					},{
						columnWidth:.2,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id: "photoDir",
							xtype: "picpanel",
							defaultPicUrl: "./Public/Images/sys/noupload.gif",
							actionUrl: "main/tractorInfo.html?action=uploadPic",
							uploadWinTitle: "上传拖拉机图片",
							height: 180,
							width: 90,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"address",
							fieldLabel:"家庭地址",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"linkAddress",
							fieldLabel:"联系地址",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"postalcode",
							fieldLabel:"邮政编码",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"causation",
							fieldLabel:"原因",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"mark",
							fieldLabel:"驾照分数",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"startDate",
							fieldLabel:"开始日期",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"endDate",
							fieldLabel:"结束日期",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					}]					
				},{
					xtype:'fieldset',
					title:"驾驶员健康信息",						
					autoHeight:true,
					maskDisabled:false,
					layout:"column",
					width:555,
					items:[{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
                    		id:"hight",
                    		fieldLabel:"身高",
                    		xtype:"textfield",
                    		readOnly:true,
                    		anchor:'98%'
                    	}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"resolvingPowerFlag",
							fieldLabel:"辨色力",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightEyePwoer",
							fieldLabel:"右眼视力",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightEyeRectificationFlag",
							fieldLabel:"右眼矫正",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftEyePwoer",
							fieldLabel:"左眼视力",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftEyeRectificationFlag",
							fieldLabel:"左眼矫正",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightEarPwoer",
							fieldLabel:"右耳听力",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftEarPwoer",
							fieldLabel:"左耳听力",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightHandFlag",
							fieldLabel:"右上肢",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftHandFlag",
							fieldLabel:"左上肢",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightLagFlag",
							fieldLabel:"右下肢",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftLagFlag",
							fieldLabel:"左下肢",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"bodyCheckDate",
							fieldLabel:"检查时间",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"checkResultFlag",
							fieldLabel:"检查结果",
							xtype:"textfield",
							readOnly:true,
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
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
						labelWidth:60,
						height:'auto',
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
			}],
			buttons:[{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("drivinglicenceGotoInfoWin").close();
				}
			}]
		});
		Ynzc.manage.DrivinglicenceGotoInfoWin.superclass.initComponent.apply(this,arguments);
	}
});