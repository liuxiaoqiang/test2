Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.BodyInfoWin=Ext.extend(Ext.Window,{
	id:"bodyInfoWin",
	initComponent:function(){
		Ext.apply(this,{
			id:"bodyInfoWin",
			title:"添加人员健康信息",
			height:500,
			width:620,
			autoScroll:true,
			resizable:false,
			modal:true,
			labelSeparator:':',
			layout:'form',
			items:[{
				layout:"column",
				frame:true,
				width:590,
				items:[{
					columnWidth:1,
					items:[{
						xtype:'fieldset',
						title:"添加人员",
						autoHeight:true,
						width:575,
						layout:"column",
						items:[{
							columnWidth:1,
							layout:"form",
							border:false,
							labelWidth:60,
							items:[{
								id:"peopleInfoId",
								fieldLabel:"人员",
								xtype:"peopleinfocombo",
								anchor:'98%'						
							}]
						}]
					},{
						xtype:'fieldset',
						title:"基本健康信息",
						autoHeight:true,
						width:575,
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
	                    								Ext.ux.Toast.msg("提示","录入的数据不完整，请检查!");
	                    								return;
	                    							}else{
	                    								if(Ext.getCmp("bodyHight").getValue().length>3 || Ext.getCmp("bodyHight").getValue().length<3 || Ext.getCmp("bodyHight").getValue().indexOf(".")>0){
		                    								Ext.ux.Toast.msg("提示","录入的数据有误，请检查!");
		                    								return;
		                    							}else{
		                    								var res=Ext.getCmp("bodyHight").getValue()+"CM";
		                    								Ext.getCmp("hight").setValue(res);
		                    								Ext.getCmp("heightwin").close();
		                    							}
	                    							}
	                    						}
	                    					}]
	                    				}).show(Ext.getCmp("hight").getEl());
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
									checked:true,
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
									checked:true,
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
						xtype:'fieldset',
						title:"眼睛健康信息",
						autoHeight:true,
						width:575,
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
									checked:true,
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
									checked:true,
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
						xtype:'fieldset',
						title:"耳朵健康信息",
						autoHeight:true,
						width:575,
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
									id:"rightEarPwoerId",
									name:"rightEarPwoer",
									fieldLabel:'右耳听力',
									xtype: "radio",
									checked:true,
									boxLabel:'正常',
									inputValue:'1'
								}]
							},{
								columnWidth:.3,
								layout:"form",
								border:false,
								labelWidth:40,
								items:[{
									name:"rightEarPwoer",
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
									id:"leftEarPwoerId",
									name:"leftEarPwoer",
									fieldLabel:'左耳听力',
									xtype: "radio",
									checked:true,
									boxLabel:'正常',
									inputValue:'1'
								}]
							},{
								columnWidth:.3,
								layout:"form",
								border:false,
								labelWidth:40,
								items:[{
									name:"leftEarPwoer",
									hideLabel:true,
									xtype: "radio",
									boxLabel:'异常',
									inputValue:'0'
								}]												
							}]							
						}]
					},{
						xtype:'fieldset',
						title:"四肢健康信息",
						autoHeight:true,
						width:575,
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
									checked:true,
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
									checked:true,
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
									checked:true,
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
									id:"leftLagFlagId",
									name:"leftLagFlag",
									fieldLabel:'左下肢',
									xtype: "radio",
									checked:true,
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
									hideLabel:true,
									xtype: "radio",
									boxLabel:'异常',
									inputValue:'0'
								}]														
							}]
						}]
					},{
						xtype:'fieldset',
						title:"检查情况信息",
						autoHeight:true,
						width:575,
						layout:"column",
						items:[{
							columnWidth:.5,
							layout:"form",
							border:false,
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
									checked:true,
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
			}],
			buttons:[{
				id:"savaBtn",
				text:"保存",
				handler:function(){
					if(Ext.getCmp("peopleInfoId").getValue()===""){
						Ext.ux.Toast.msg("提示","请填选择人员!");
						initFocus("peopleInfoId");
						return;
					}
					if(Ext.getCmp("hight").getValue() == ""){
						Ext.ux.Toast.msg("提示","身高填写有误!");
						initFocus("hight");
						return;
					}
					if(checkNum(Ext.getCmp("rightEyePwoer").getValue())){
						Ext.ux.Toast.msg("提示","右眼视力填写有误!");
						initFocus("rightEyePwoer");
						return;
					}
					if(checkNum(Ext.getCmp("leftEyePwoer").getValue())){
						Ext.ux.Toast.msg("提示","左眼视力填写有误!");
						initFocus("leftEyePwoer");
						return;
					}
					if(Ext.getCmp("bodyCheckDate").getValue()==""){
						Ext.ux.Toast.msg("提示","请填写身体检查时间!");
						return;
					}
					if(checkLen(Ext.getCmp("checkOrganization").getValue())){
						Ext.ux.Toast.msg("提示","检查机构填写有误!");
						initFocus("checkOrganization");
						return;
					}
					if(checkLen(Ext.getCmp("checkDoctor").getValue())){
						Ext.ux.Toast.msg("提示","检查医生填写有误!");
						initFocus("checkDoctor");
						return;
					}	
					Ext.Ajax.request({
						url:"main/bodyInfo.html?action=addBodyInfo",
						success:function(resp){
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								if(result.success==true){
									if(result.success==true){
										Ext.ux.Toast.msg("提示",result.reason);
										Ext.getCmp("bodyInfoMgr").getStore().reload();
										Ext.getCmp("bodyInfoWin").close();
									}else{
										Ext.ux.Toast.msg("提示",result.reason);
									}
								}else{
									Ext.ux.Toast.msg("提示",result.reason);
								}
							}
						},
						failure:function(){
							Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							peopleInfoId:Ext.getCmp("peopleInfoId").getMyValue(),
							hight:Ext.getCmp("hight").getValue(),
							resolvingPowerFlag:Ext.getCmp("resolvingPowerFlagId").getGroupValue(),
							rightEyePwoer:Ext.getCmp("rightEyePwoer").getValue(),
							rightEyeRectificationFlag:Ext.getCmp("rightEyeRectificationFlagId").getGroupValue(),
							leftEyePwoer:Ext.getCmp("leftEyePwoer").getValue(),
							leftEyeRectificationFlag:Ext.getCmp("leftEyeRectificationFlagId").getGroupValue(),
							rightEarPwoer:Ext.getCmp("rightEarPwoerId").getGroupValue(),
							leftEarPwoer:Ext.getCmp("leftEarPwoerId").getGroupValue(),
							rightHandFlag:Ext.getCmp("rightHandFlagId").getGroupValue(),
							degreeleftHandFlag:Ext.getCmp("leftHandFlagId").getGroupValue(),
							rightLagFlag:Ext.getCmp("rightLagFlagId").getGroupValue(),
							leftLagFlag:Ext.getCmp("leftLagFlagId").getGroupValue(),
							bodyNeck:Ext.getCmp("bodyNeckId").getGroupValue(),
							bodyCheckDate:Ext.util.Format.date(Ext.getCmp("bodyCheckDate").getValue(),'Y-m-d'),
							checkResultFlag:Ext.getCmp("checkResultFlagId").getGroupValue(),
							checkOrganization:Ext.getCmp("checkOrganization").getValue(),
							checkDoctor:Ext.getCmp("checkDoctor").getValue()
						}
					});
			}
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					Ext.getCmp("bodyInfoWin").close();
				}
			}]
		});
		Ynzc.manage.BodyInfoWin.superclass.initComponent.apply(this,arguments);
	}
});
