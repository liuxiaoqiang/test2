Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.DrivinglicenceGotoUpdateWin = Ext.extend(Ext.Window, {
    id: 'drivinglicenceGotoUpdateWin',
    initComponent: function() {
		Ext.apply(this,{
			title:"修改驾照转入信息",
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
							anchor:'98%'
						},{
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
						},{
							id:"birthday",
							fieldLabel:"出生日期",
							xtype:"datefield",
							readOnly:true,
							format:"Y-m-d",
							anchor:'98%'
						},{
							id:"idCard",
							fieldLabel:"身份证",
							xtype:"textfield",
							anchor:'98%'
						},{
							id:"linkTel",
							fieldLabel:"联系电话",
							xtype:"textfield",
							anchor:'98%'
						},{
							id:"idStay",
							fieldLabel:"暂住证",
							xtype:"textfield",
							anchor:'98%'
						},{
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
							anchor:'98%'
						}]
					},{
						columnWidth:1,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"applicationDate",
							fieldLabel:"初领驾驶证日期",
							xtype:"datefield",
							readOnly:true,
							format:"Y-m-d",
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
							xtype:"datefield",
							readOnly:true,
							format:"Y-m-d",
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
							xtype:"datefield",
							readOnly:true,
							format:"Y-m-d",
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
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"resolvingPowerFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightEyePwoer",
							fieldLabel:"右眼视力",
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
							id:"rightEyeRectificationFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftEyePwoer",
							fieldLabel:"左眼视力",
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
							id:"leftEyeRectificationFlag",
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
									labelWidth:60,
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
												var res=Ext.getCmp("rightEarPwoer").getValue()+"米";
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
									labelWidth:60,
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
												var res=Ext.getCmp("leftEarPwoer").getValue()+"米";
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
					},{
						columnWidth:.5,
						layout:"form",
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightHandFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftHandFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"rightLagFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"leftLagFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"bodyNeck",
							fieldLabel:"身体颈椎",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"bodyCheckDate",
							fieldLabel:"检查时间",
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
							id:"checkResultFlag",
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
						labelWidth:60,
						height:'auto',
						baseCls:"x-plain",
						items:[{
							id:"checkOrganization",
							fieldLabel:"检查机构",
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
							id:"checkDoctor",
							fieldLabel:"检查医生",
							xtype:"textfield",
							anchor:'98%'
						}]
					}]						
				}]
			}],
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
					if(Ext.getCmp("idStay").getValue()==""){
						Ext.MessageBox.alert("提示","暂住证号填写有误!");
						initFocus("idStay");
						return;
					}
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
					if(Ext.getCmp("degree").getValue()===""){
						Ext.MessageBox.alert("提示","请填写文化程度!");
						return;
					}
					if(Ext.getCmp("photoDir").getValue()==""){
						Ext.MessageBox.alert("提示","请填上传人员照片!");
						return;
					}
					if(Ext.getCmp("applicationDate").getValue() == ""){
						Ext.MessageBox.alert("提示","请填写身高!");
						initFocus("applicationDate");
						return;
					}
					if(Ext.getCmp("hight").getValue() == ""){
						Ext.MessageBox.alert("提示","请填写身高!");
						return;
					}
					if(Ext.getCmp("resolvingPowerFlag").getValue()=== ""){
						Ext.MessageBox.alert("提示","请填写辨色力!");
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
					if(Ext.getCmp("rightEyeRectificationFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填选择右眼矫正!");
						return;
					}
					if(Ext.getCmp("leftEyeRectificationFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请选择左眼矫正!");
						return;
					}
					if(Ext.getCmp("rightEarPwoer").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写右耳听力!");
						return;
					}
					if(Ext.getCmp("leftEarPwoer").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写左耳听力!");
						return;
					}
					if(Ext.getCmp("rightHandFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写右手!");
						return;
					}
					if(Ext.getCmp("leftHandFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写左手!");
						return;
					}
					if(Ext.getCmp("rightLagFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写右脚!");
						return;
					}
					if(Ext.getCmp("leftLagFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写左脚!");
						return;
					}
					if(Ext.getCmp("bodyNeck").getValue() === ""){
						Ext.MessageBox.alert("提示","请填写身体和颈椎!");
						return;
					}
					if(Ext.getCmp("bodyCheckDate").getValue() == ""){
						Ext.MessageBox.alert("提示","请填写身体检查时间!");
						return;
					}
					if(Ext.getCmp("checkResultFlag").getValue() === ""){
						Ext.MessageBox.alert("提示","请选择检查结果!");
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
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在录入数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
					Ext.Ajax.request({
						url:"main/drivingLicenceGoto.html?action=updateDrivingLicenceGoto",
						success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								if(result.success==true){
									Ext.MessageBox.alert("提示",result.reason);
									Ext.getCmp("drivingLicenceGotoMgr").getStore().reload();
									Ext.getCmp("drivinglicenceGotoUpdateWin").close();
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
							id:Ynzc.manage.DrivingLicenceGotoId,
							drivingLicenceNo:Ynzc.manage.GotoDrivingLincenceNo,
							drivingLicenceTypeId:Ynzc.manage.GotoDrivingLicenceId,
							gotoPeopleInfoId:Ynzc.manage.GotoPeopleInfoId,
							gotoBodyInfoId:Ynzc.manage.GotoBodyInfoId,
							causation:Ext.getCmp("causation").getValue(),
							mark:Ext.getCmp("mark").getValue(),
							startDate:Ext.util.Format.date(Ext.getCmp("startDate").getValue(),'Y-m-d'),
							endDate:Ext.util.Format.date(Ext.getCmp("endDate").getValue(),'Y-m-d'),
							peopleName:Ext.getCmp("peopleName").getValue(),
							sex:Ext.getCmp("sex").getValue(),
							applicationDate:Ext.util.Format.date(Ext.getCmp("applicationDate").getValue(),'Y-m-d'),
							birthday:Ext.util.Format.date(Ext.getCmp("birthday").getValue(),'Y-m-d'),
							idCard:Ext.getCmp("idCard").getValue(),
							idStay:Ext.getCmp("idStay").getValue(),
							address:Ext.getCmp("address").getValue(),
							linkAddress:Ext.getCmp("linkAddress").getValue(),
							linkTel:Ext.getCmp("linkTel").getValue(),
							postalcode:Ext.getCmp("postalcode").getValue(),
							degree:Ext.getCmp("degree").getValue(),
							photoDir:Ext.getCmp("photoDir").getValue(),
							hight:Ext.getCmp("hight").getValue(),
							resolvingPowerFlag:Ext.getCmp("resolvingPowerFlag").getValue(),
							rightEyePwoer:Ext.getCmp("rightEyePwoer").getValue(),
							rightEyeRectificationFlag:Ext.getCmp("rightEyeRectificationFlag").getValue(),
							leftEyePwoer:Ext.getCmp("leftEyePwoer").getValue(),
							leftEyeRectificationFlag:Ext.getCmp("leftEyeRectificationFlag").getValue(),
							rightEarPwoer:Ext.getCmp("rightEarPwoer").getValue(),
							leftEarPwoer:Ext.getCmp("leftEarPwoer").getValue(),
							rightHandFlag:Ext.getCmp("rightHandFlag").getValue(),
							degreeleftHandFlag:Ext.getCmp("leftHandFlag").getValue(),
							rightLagFlag:Ext.getCmp("rightLagFlag").getValue(),
							leftLagFlag:Ext.getCmp("leftLagFlag").getValue(),
							bodyNeck:Ext.getCmp("bodyNeck").getValue(),
							bodyCheckDate:Ext.util.Format.date(Ext.getCmp("bodyCheckDate").getValue(),'Y-m-d'),
							checkResultFlag:Ext.getCmp("checkResultFlag").getValue(),
							checkOrganization:Ext.getCmp("checkOrganization").getValue(),
							checkDoctor:Ext.getCmp("checkDoctor").getValue()
						}
					});
				}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("drivinglicenceGotoUpdateWin").close();
				}
			}]
		});
		Ynzc.manage.DrivinglicenceGotoUpdateWin.superclass.initComponent.apply(this,arguments);
	}
});