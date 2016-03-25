Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ChangeBodyEditWin=Ext.extend(Ext.Window,{
		id:"changebodyeditwin",
		initComponent:function(){
			Ext.apply(this,{
                         id:"changebodyeditwin",
                         title:"修改变更信息",
                         iconCls:'icon-Add',
                         resizable:false,
                         modal:true,
                         height:400,
                         width:700,
                         items:[
                         {xtype:'tabpanel',border:false,frame:true,activeTab:0,
                         items:[{title:'拖拉机基本信息',frame:true,bodyStyle:"padding:5px 5px",autoScroll:true,height:375,layout:"column",
                         items:[{columnWidth:.5,layout:"form",labelWidth:90,
                         items:[{id:"updategetwayid",fieldLabel:"获取方式",xtype:"combo",mode:"remote",displayField : 'getway',valueField : 'id',typeAhead : true,editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.GetWay,anchor:'98%'},
                         {id:'updatemachinetypeid',fieldLabel:"机械类型",xtype:"combo",displayField : 'machinetype',valueField : 'id',typeAhead : true,mode : 'remote',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.MachineType,anchor:'98%'},
                         {id:"updatemanufacturer",fieldLabel:"制造厂名称",xtype:"textfield",anchor:'98%'},
                         {id:"updateusedfor",fieldLabel:"使用性质",xtype:"combo",displayField : 'display',valueField : 'value',typeAhead : true,mode : 'local',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.UsedFor,anchor:'98%'},
                         {id:"updatemachinebodyno",fieldLabel:"机身(底盘)号码",xtype:"textfield",anchor:'98%'},
                         {id:"updateengineno",fieldLabel:"发动机号码",xtype:"textfield",anchor:'98%'},
                         {id:"updateshelfno",fieldLabel:"挂机架号码",xtype:"textfield",anchor:'98%'}
                          ]
						 },
						 {columnWidth:.5,layout:"form",labelwidth:90,
						 items:[{id:"updatemyphotourl",xtype:"picpanel",defaultPicUrl:"./Public/Images/sys/noupload.gif",actionUrl:"main/tractorInfo.html?action=uploadPic",uploadWinTitle:"拖拉机照片",height:200,width:340}] 
						 },
						 {columnWidth:.5,labelWidth:90,layout:"form",
                         items:[{id:"updatemanufacturedate",fieldLabel:"出厂日期",readOnly:true,format:"Y-m-d",xtype:"datefield",anchor:'98%'}]
                         },
                         {columnWidth:.5,labelWidth:90,layout:"form",
	                   	  items:[{id:"updateprice",fieldLabel:"销售/交易价格",xtype:"textfield",anchor:'100%'}]
                         },
						 {columnWidth:1,labelWidth:90,layout:"form",
	                   	  items:[{id:"updatemachinebrandtypeid",fieldLabel:"品牌型号",xtype:"vcombo",anchor:"100%"}]
                         },
                         {columnWidth:1,labelWidth:130,layout:"form",
	                   	  items:[{id:"updateseller",fieldLabel:"销售(交易市场)名称",xtype:"textfield",anchor:'100%'}]
                         }
						 ]
						 },
						{title:'相关资料',frame:true,bodyStyle:"padding:5px 5px",autoScroll:true,height:375,layout:"column",
                         items:[{columnWidth:.5,layout:"form",labelWidth:80,
                         items:[{id:"updategetwayfiletypeid",fieldLabel:"来历凭证类型",xtype:"combo",displayField : 'getWayFileType',valueField : 'id',typeAhead : true,mode : 'remote',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.WayFile,anchor:'98%'}]
						},
						{columnWidth:.5,labelWidth:90,layout:"form",
						items:[{id:"updategetwayfileno",fieldLabel:"来历凭证编号",xtype:"textfield",anchor:'100%'}]
                        },
                        {columnWidth:.5,layout:"form",labelWidth:90,
                    	 items:[{id:"updateimportsfiletypeid",fieldLabel:"进口凭证类型",xtype:"combo",displayField : 'importsFileType',valueField : 'id',typeAhead : true,mode : 'remote',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.ImportsFile,anchor:'98%'}]
                        },
                        {columnWidth:.5,labelWidth:90,layout:"form",
	                   	 items:[{id:"updateimportsfileno",fieldLabel:"进口凭证编号",xtype:"textfield",anchor:'100%'}]
                        },
                        {columnWidth:1,labelWidth:90,layout:"form",
	                   	 items:[{id:"updateother",title:"其他资料",xtype:"fieldset",height:'auto',collapsible:false,layout:"column",
                         items:[{columnWidth:.3,layout:"fit",labelWidth:160,
                         items:[{id:"updateotherOne",boxLabel:"国产拖拉机整车出厂合格证明",xtype:"checkbox",value:"国产拖拉机整车出厂合格证明"}]
                         },
                         {columnWidth:.15,layout:"fit",labelWidth:160,
                          items:[{id:"updateotherTwo",boxLabel:"拖拉机档案",xtype:"checkbox",value:'拖拉机档案'}]
                         },
                         {columnWidth:.12,layout:"fit",labelWidth:160,
                         items:[{id:"updateotherThree",boxLabel:"身份证明",xtype:"checkbox",value:"身份证明"}]
                         },
                         {columnWidth:.25,layout:"fit",labelWidth:160,
                         items:[{id:"updateotherFour",boxLabel:"《协助执行通知书》",xtype:"checkbox",value:"《协助执行通知书》"}]
                         },
                         {columnWidth:.15,layout:"fit",labelWidth:160,
                          items:[{id:"updateotherFive",boxLabel:"《公证书》",xtype:"checkbox",value:"《公证书》"}]
                         }],
                         anchor:'100%'
	                     }]
                         },
                         {columnWidth:1,layout:"fit",
	                   	 items:[{id:"updateinsurance",title:"交强险",xtype:"fieldset",height:100,collapsible:false,layout:"column",
                         items:[{columnWidth:.4,layout:"form",labelWidth:70,
                         items:[{id:'updateinsurancelistno',fieldLabel:"保单号",xtype:"textfield",anchor:'98%'}]
                         },
                         {columnWidth:.6,layout:"form",labelWidth:70,
                         items:[{id:"updateinsurancecompanyname",shadowOffset:0,fieldLabel:"保险公司",xtype:"icombo",anchor:'98%'}]
                         },
                         {columnWidth:.4,layout:"form",labelWidth:70,
                         items:[{id:"updateinsurancedate",fieldLabel:"保险日期",xtype:"datefield",readOnly:true,format:"Y-m-d",anchor:'98%'}]
                         },
                         {columnWidth:.6,layout:"form",labelWidth:70,
                         items:[{id:"updateexpirydate",fieldLabel:"保险有效期",xtype:"datefield",readOnly:true,format:"Y-m-d",anchor:'98%'}]
                         }]
                         }]
                         }]
						 },
						 {title:'技术参数',frame:true,bodyStyle:"padding:5px 5px",autoScroll:true,height:375,layout:"column",
                          items:[{columnWidth:.33,layout:"form",labelWidth:85,
                    	  items:[{id:"updatemachinebodycolor",fieldLabel:"机身颜色",xtype:"textfield",anchor:'98%'}]
                         },
                         {columnWidth:.33,layout:"form",labelWidth:85,
                    	 items:[{id:"updateoutsize",fieldLabel:"外廓尺寸",xtype:"textfield",readOnly:true,
                    	 listeners:{'focus':function(){
                    	 new Ext.Window({id:"updateoutwin",title:"外廓尺寸[单位：<font color=red>MM</font>]",
                    	 height:160,modal:true,width:200,resizable:false,layout:"form",bodyStyle:"padding:5px 5px",labelWidth:20,
                    	 items:[{id:"updateoutLength",fieldLabel:"长",xtype:"textfield",anchor:'100%'},{id:"updateoutWidth",fieldLabel:"宽",xtype:"textfield",anchor:'100%'},{id:"updateoutHeight",fieldLabel:"高",xtype:"textfield",anchor:'100%'}],
                    	 buttons:[{text:"确定",
                    	 handler:function(){
                    	 if(Ext.getCmp("updateoutLength").getValue()==""||Ext.getCmp("updateoutWidth").getValue()==""||Ext.getCmp("updateoutHeight").getValue()==""){
                    	 Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
                    	 return;
                    	 }else{
                    	 var res=Ext.getCmp("updateoutLength").getValue()+","+Ext.getCmp("updateoutWidth").getValue()+","+Ext.getCmp("updateoutHeight").getValue();
                    	 Ext.getCmp("updateoutsize").setValue(res);
                    	 Ext.getCmp("updateoutwin").close();
                    	 }
                    	 }
                    	 }]
                    	 }).show(Ext.getCmp("updateoutsize").getEl());
                    	 if(Ext.getCmp("updateoutsize").getValue()!=""){
                    	 var strArray=Ext.getCmp("updateoutsize").getValue().split(",");
                    	 Ext.getCmp("updateoutLength").setValue(strArray[0]);
                    	 Ext.getCmp("updateoutWidth").setValue(strArray[1]);
                    	 Ext.getCmp("updateoutHeight").setValue(strArray[2]);
                    	 }
                    	 }
                    	 },
                    	 anchor:'98%'
                    	 }]
                         },
                         {columnWidth:.33,layout:"form",labelWidth:85,
                    	 items:[{id:"updatecontainersize",fieldLabel:"货箱内部尺寸",xtype:"textfield",
						 readOnly:true,
						 listeners:{
						 "focus":function(){
						 new Ext.Window({
						 id:"updatecontainerwin",
						 title:"货箱内部尺寸[单位：<font color=red>MM</font>]",
						 height:160,
						 modal:true,
						 width:200,
						 resizable:false,
						 layout:"form",
						 bodyStyle:"padding:5px 5px",
						 labelWidth:20,
						 items:[{
						 id:"updatecontainerLength",
						 fieldLabel:"长",
						 xtype:"textfield",
						 anchor:'100%'
						 },{
						 id:"updatecontainerWidth",
						 fieldLabel:"宽",
						 xtype:"textfield",
						 anchor:'100%'
						 },{
						 id:"updatecontainerHeight",
						 fieldLabel:"高",
						 xtype:"textfield",
						 anchor:'100%'
						 }],
						buttons:[{
						text:"确定",
						handler:function(){
						if(Ext.getCmp("updatecontainerLength").getValue()==""||Ext.getCmp("updatecontainerWidth").getValue()==""||Ext.getCmp("updatecontainerHeight").getValue()==""){
						Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
						return;
						}else{
						var res=Ext.getCmp("updatecontainerLength").getValue()+","+Ext.getCmp("updatecontainerWidth").getValue()+","+Ext.getCmp("updatecontainerHeight").getValue();
						Ext.getCmp("updatecontainersize").setValue(res);
						Ext.getCmp("updatecontainerwin").close();
						}
						}
						}]
						}).show(Ext.getCmp("updatecontainersize").getEl());
						if(Ext.getCmp("updatecontainersize").getValue()!=""){
						var strArray=Ext.getCmp("updatecontainersize").getValue().split(",");
						Ext.getCmp("updatecontainerLength").setValue(strArray[0]);
						Ext.getCmp("updatecontainerWidth").setValue(strArray[1]);
						Ext.getCmp("updatecontainerHeight").setValue(strArray[2]);
						}
						}
						},
						anchor:'100%'
						}]
						},
						{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    	id:"updatedirectcontrol",
                    	fieldLabel:"转向形式",
                    	xtype:"combo",
                    	displayField : 'display',
			            valueField : 'value',
			            typeAhead : true,
			            mode : 'local',
			            editable:false,
			            selectOnFoucs : true,
			            triggerAction : 'all',
			            store:Ynzc.manage.DirectStore,
                    	anchor:'98%'
                    	}]
                        },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    	id:"updatesteelspring",    //isNaN()
                		fieldLabel:"钢板弹簧片数",
                		xtype:"textfield",
                		anchor:'98%'
                    	}]
                        },{
                   	 	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    	id:"updatebodypower",
                    	fieldLabel:"功率",
                    	xtype:"textfield",
                    	readOnly:true,
                    	listeners:{
                    	"focus":function(){
                    	new Ext.Window({
                    	id:"updatebodypowerwin",
                    	title:"功率",
                    	height:115,
                    	modal:true,
                    	width:200,
                    	resizable:false,
                    	bodyStyle:"padding:5px 5px",
                    	labelWidth:20,
                    	layout:"fit",
                    	items:[{
                    	layout:"column",
                    	frame:true,
                    	border:false,
	                    items:[{
	                    columnWidth:.35,
	                    items:[{
	                    	id:"updatebodyv",
	                    	xtype:"textfield",
	                    	anchor:"98%"
	                    	}]
	                    },{
	                    	columnWidth:.15,
	                    	items:[{
	                    	id:"updatebodyVunit",
	                    	xtype:"label",
	                    	html:"CM³"
	                    	}]
	                   },{
		                    columnWidth:.35,
	                    	items:[{
	                    	id:"updatebodyk",
	                    	xtype:"textfield",
	                    	anchor:"98%"
	                    	}]
	                   },{
	                    	columnWidth:.15,
	                    	items:[{
	                    	id:"updatebodyKW",
	                    	xtype:"label",
	                    	html:"KW"
	                    	}]
	                   }]
                       }],
                       buttons:[{
                    		text:"确定",
                    		handler:function(){
                    		if(Ext.getCmp("updatebodyv").getValue()==""||Ext.getCmp("updatebodyk").getValue()==""){
	                    	Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
	                    	return;
                    		}else{
                    		var res=Ext.getCmp("updatebodyv").getValue()+"CM³/"+Ext.getCmp("updatebodyk").getValue()+"KW";
                    		Ext.getCmp("updatebodypower").setValue(res);
                    		Ext.getCmp("updatebodypowerwin").close();
                    		}
                    		}
                    		}]
                      }).show(Ext.getCmp("updatebodypower").getEl());
                      if(Ext.getCmp("updatebodypower").getValue()!=""){
           			  var r1=Ext.getCmp("updatebodypower").getValue().split("CM³/");
           			  Ext.getCmp("updatebodyv").setValue(r1[0]);
           			  Ext.getCmp("updatebodyk").setValue(r1[1].substring(0,r1[1].length-2));
                      }
                      }
                      },
                      anchor:'100%'
                      }]
                      },
                      {
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatecylinderno",
                    		fieldLabel:"缸数",
                    		xtype:"combo",
                    		displayField : 'display',
			                valueField : 'value',
			                typeAhead : true,
			                mode : 'local',
			                editable:false,
			                selectOnFoucs : true,
			                triggerAction : 'all',
			                store:Ynzc.manage.CylinderStore,
                    		anchor:'98%'
                    	}]
                      },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatefueltypeid",
                			fieldLabel:"燃料种类",
                    		xtype:"combo",
                    		displayField : 'fuelname',
			                valueField : 'id',
			                typeAhead : true,
			                mode : 'local',
			                editable:false,
			                selectOnFoucs : true,
			                triggerAction : 'all',
			                store:Ynzc.manage.FuelType,
                			anchor:'98%'
                    	}]
                    },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatewheelno",    //isNaN()
                			fieldLabel:"轴数",
                			xtype:"textfield",
                			anchor:'100%'
                    	}]
                    },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatewheelbase",    //isNaN()
                			fieldLabel:"轴距",
                			xtype:"textfield",
                			anchor:'98%'
                    	}]
                    },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatetiresno",    //isNaN()
                			fieldLabel:"轮胎数",
                			xtype:"textfield",
                			anchor:'98%'
                    	}]
                    },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatetiressize",    //isNaN()
                			fieldLabel:"轮胎规格",
                			xtype:"textfield",
                			anchor:'100%'
                    	}]
                    },{
                    	columnWidth:.33,
                    	layout:"form",
                    	labelWidth:85,
                    	items:[{
                    		id:"updatewheeldis",
                    		fieldLabel:"轮距",
                    		xtype:"textfield",
                    		readOnly:true,
                    		listeners:{
                    			"focus":function(){
                    				new Ext.Window({
                    					id:"updatewheelwin",
                    					title:"轮距[单位：<font color=red>MM</font>]",
                    					height:130,
                    					modal:true,
                    					width:200,
                    					resizable:false,
                    					layout:"form",
                    					bodyStyle:"padding:5px 5px",
                    					labelWidth:20,
                    					items:[{
                    						id:"updatewheelFront",
                    						fieldLabel:"前",
                    						xtype:"textfield",
                    						anchor:'100%'
                    					},{
                    						id:"updatewheelBack",
                    						fieldLabel:"后",
                    						xtype:"textfield",
                    						anchor:'100%'
                    					}],
                    					buttons:[{
                    						text:"确定",
                    						handler:function(){
                    							if(Ext.getCmp("updatewheelFront").getValue()==""||Ext.getCmp("updatewheelBack").getValue()==""){
                    								Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
                    								return;
                    							}else{
                    								var res=Ext.getCmp("updatewheelFront").getValue()+","+Ext.getCmp("updatewheelBack").getValue();
                    								Ext.getCmp("updatewheeldis").setValue(res);
                    								Ext.getCmp("updatewheelwin").close();
                    							}
                    						}
                    					}]
                    				}).show(Ext.getCmp("updatewheeldis").getEl());
                    				if(Ext.getCmp("updatewheeldis").getValue()!=""){
                    					var strArray=Ext.getCmp("updatewheeldis").getValue().split(",");
                    					Ext.getCmp("updatewheelFront").setValue(strArray[0]);
                    					Ext.getCmp("updatewheelBack").setValue(strArray[1]);
                    				}
                    			}
                    		},
                    		anchor:'98%'
                    	   }]
                            },
				           {
				              columnWidth:.33,
				              layout:"form",
				              labelWidth:85,
				               items:[{
				                    id:"updatetotalquality",    //isNaN()
				                	fieldLabel:"总质量",
				                	xtype:"textfield",
				                	anchor:'98%'
				                    }]
				           },{
				              columnWidth:.33,
				              layout:"form",
				              labelWidth:85,
				              items:[{
				              id:"updateallquality",    //isNaN()
				              fieldLabel:"整备质量",
				              xtype:"textfield",
				              anchor:'100%'
				              }]
				           },{
				              columnWidth:.33,
				              layout:"form",
				              labelWidth:85,
				              items:[{
				              id:"updateratifiedload",    //isNaN()
				              fieldLabel:"核定载质量",
				              xtype:"textfield",
				              anchor:'98%'
				              }]
				           },{
				              columnWidth:.33,
				              layout:"form",
				              labelWidth:85,
				              items:[{
				                    id:"updateallowdragtotalquality",    //isNaN()
				                    fieldLabel:"准牵引总质量",
				                    xtype:"textfield",
				                    anchor:'98%'
				                    }]
				          },{
				             columnWidth:.33,
				             layout:"form",
				             labelWidth:85,
				             items:[{
				                   id:"updatedriverinno",    //isNaN()
				                   fieldLabel:"驾驶室载人数",
				                   xtype:"textfield",
				                   anchor:'100%'
				                   }]
				           },{
				             columnWidth:.33,
				             layout:"form",
				             labelWidth:85,
				             items:[{
				                    id:"updatevicecartiresno",    //isNaN()
				                	fieldLabel:"挂车轮胎数",
				                	xtype:"textfield",
				                	anchor:'98%'
				                    }]
				           },{
				              columnWidth:.33,
				              layout:"form",
				              labelWidth:85,
				              items:[{
				                    id:"updateoutcarwheeldis",    //isNaN()
				                	fieldLabel:"挂车轮距",
				                	xtype:"textfield",
				                	anchor:'98%'
				                    }]
				           },{
				              columnWidth:.33,
				              layout:"form",
				              labelWidth:85,
				              items:[{
				                    id:"updateoutcartiressize",    //isNaN()
				                	fieldLabel:"挂车轮胎规格",
				                	xtype:"textfield",
				                	anchor:'100%'
				                    }]
				            },{
				              columnWidth:1,
				              layout:"form",
				              labelWidth:85,
				              items:[{
				                    id:"updateenginebrandid",
				                    fieldLabel:"发动机品牌",
				                    xtype:"ebcombo",
				                    width:375
				                    }]
				             }
                             ]
							 }]
							 }
                             ],
                             buttons:[{
							text: "详细信息",
								handler: function() {
								Ext.Ajax.request({
								url:'main/tractorInfo.html?action=GetAllTractorInfo',
								method:'post',
								success:function(resp){
								var result=Ext.util.JSON.decode(resp.responseText);
								new Ynzc.manage.CarinfoWin({
								title : "详细信息",
								height:530,
								width:870,
								html:result.result
								}).show();
								},
								params: {
									license : PlateNumHead+"."+Ynzc.manage.DetalisLicensenum
								}
								});
								}
						},
                             {text:"提交变更",
                             handler:function(){
                            	 if (Ext.getCmp("updategetwayid").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请选择获取方式.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updatemachinetypeid").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请选择机械类型.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updatemanufacturer").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写制造厂名称.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updateusedfor").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请选择使用性质.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updatemachinebodyno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请选择机身(底盘)号码.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updateengineno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写发动机号码.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updateshelfno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写挂机架号码.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updatemyphotourl").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请上传拖拉机图片.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updatemanufacturedate").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写出厂日期.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updateprice").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写销售/交易价格.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updatemachinebrandtypeid").getMyValue() == "") {
                                     Ext.MessageBox.alert("提示", "请选择品牌型号.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updateseller").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写销售(交易市场)名称.");
                                     return;
                                 }
                            	 if (Ext.getCmp("updateinsurancelistno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写保单号.");
                                     return;
                                 }
                            	 
                            	 if (Ext.getCmp("updateinsurancecompanyname").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请选择保险公司.");
                                     return;
                                 } if (Ext.getCmp("updateinsurancedate").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写保险日期.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateexpirydate").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写保险有效期.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatemachinebodycolor").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写机身颜色.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateoutsize").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写外廓尺寸.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatecontainersize").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写货箱内部尺寸.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatedirectcontrol").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写转向形式.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatesteelspring").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写钢板弹簧片数.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatebodypower").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写功率.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatecylinderno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写缸数.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatefueltypeid").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写燃料种类.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatewheelno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写轴数.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatewheelbase").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写轴距.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatetiresno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写轮胎数.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatetiressize").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写轮胎规格.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatewheeldis").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写轮距.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatetotalquality").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写总质量.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateallquality").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写整备质量.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateratifiedload").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写核定载质量.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateallowdragtotalquality").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写准牵引总质量.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatedriverinno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写驾驶室载人数.");
                                     return;
                                 }
                                 if (Ext.getCmp("updatevicecartiresno").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写挂车轮胎数.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateoutcarwheeldis").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写挂车轮距.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateoutcartiressize").getValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写挂车轮胎规格.");
                                     return;
                                 }
                                 if (Ext.getCmp("updateenginebrandid").getMyValue() == "") {
                                     Ext.MessageBox.alert("提示", "请填写发动机品牌.");
                                     return;
                                 }
                             var otherstr="";
							 if(Ext.getCmp("updateotherOne").getValue()==true){
							 otherstr=otherstr+"国产拖拉机整车出厂合格证明,"
						     };
							 if(Ext.getCmp("updateotherTwo").getValue()==true){
							 otherstr=otherstr+"拖拉机档案,"
							 };
							 if(Ext.getCmp("updateotherThree").getValue()==true){
							 otherstr=otherstr+"身份证明,"
							 };
							 if(Ext.getCmp("updateotherFour").getValue()==true){
							 otherstr=otherstr+"《协助执行通知书》,"
							 };
							 if(Ext.getCmp("updateotherFive").getValue()==true){
							 otherstr=otherstr+"《公证书》,"
							 };
							   var updategetwayfiletypeidvar=0;
                               var updateimportsfiletypeidvar=0;
                               if(Ext.getCmp("updategetwayfiletypeid").getValue()!=""){
                            	   updategetwayfiletypeidvar=Ext.getCmp("updategetwayfiletypeid").getValue();
                               }
                               if(Ext.getCmp("updateimportsfiletypeid").getValue()!=""){
                            	   updateimportsfiletypeidvar=Ext.getCmp("updateimportsfiletypeid").getValue();
                               }
                                                               var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
                             Ext.Ajax.request({
                             url:"main/carChange.html?action=UpdateCarChange",
                             method:"post",
                             success:function(resp)
                             {
                             mask.hide();
                             var result = Ext.util.JSON.decode(resp.responseText);
                             if (result.success == true) {
                             Ext.MessageBox.alert("提示","修改成功.");
                         	 Ext.getCmp("changeMgr").getStore().reload();
                         	 Ext.getCmp("changebodyeditwin").close(); 
                             }else{
                             Ext.MessageBox.alert("提示","修改失败.");
                             }
                       		},
                             failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},          
                             params:{
                             type:"",
                             updatechangebodyid:Ynzc.manage.updatechangebodyid,
                             gettypeid:Ext.getCmp("updategetwayid").getValue(),
                             machinetypeid:Ext.getCmp("updatemachinetypeid").getValue(),
                             engineid:Ext.getCmp("updatemachinebrandtypeid").getMyValue(),
                             bodycode:Ext.getCmp("updatemachinebodyno").getValue(),
                             enginecode:Ext.getCmp("updateengineno").getValue(),
                             rackcode:Ext.getCmp("updateshelfno").getValue(),
                             usernature:Ext.getCmp("updateusedfor").getValue(),
                             factoryname:Ext.getCmp("updatemanufacturer").getValue(),
                             saleunit:Ext.getCmp("updateseller").getValue(),
                             releasedate:Ext.util.Format.date(Ext.getCmp("updatemanufacturedate").getValue(),'Y-m-d'),
                             price:Ext.getCmp("updateprice").getValue(),
                             photourl:Ext.getCmp("updatemyphotourl").getValue(),
                             getwayfiletypeid:updategetwayfiletypeidvar,
                             getwayfiletypecode:Ext.getCmp("updategetwayfileno").getValue(),
                             importsfiletypeid:updateimportsfiletypeidvar,
                             importsfiletypecode:Ext.getCmp("updateimportsfileno").getValue(),
                             other:otherstr,
                             insurancelistno:Ext.getCmp("updateinsurancelistno").getValue(),
                             insurancecompany:Ext.getCmp("updateinsurancecompanyname").getValue(),
                             insurancedate:Ext.util.Format.date(Ext.getCmp("updateinsurancedate").getValue(),'Y-m-d'),
                             insurancevalidate:Ext.util.Format.date(Ext.getCmp("updateexpirydate").getValue(),'Y-m-d'),
                             bodycolor:Ext.getCmp("updatemachinebodycolor").getValue(),
                             size:Ext.getCmp("updateoutsize").getValue(),
                             directcontrol:Ext.getCmp("updatedirectcontrol").getValue(),
                             containersize:Ext.getCmp("updatecontainersize").getValue(),
                             enginebrandid:Ext.getCmp("updateenginebrandid").getMyValue(),
                             power:Ext.getCmp("updatebodypower").getValue(),
                             cylinderno:Ext.getCmp("updatecylinderno").getValue(),
                             fueltypeid:Ext.getCmp("updatefueltypeid").getValue(),
                             wheelno:Ext.getCmp("updatewheelno").getValue(),
                             wheelbase:Ext.getCmp("updatewheelbase").getValue(),
                             tiresno:Ext.getCmp("updatetiresno").getValue(),
                             tiressize:Ext.getCmp("updatetiressize").getValue(),
                             wheeldis:Ext.getCmp("updatewheeldis").getValue(),
                             totalquality:Ext.getCmp("updatetotalquality").getValue(),
                             allquality:Ext.getCmp("updateallquality").getValue(),
                             ratifiedload:Ext.getCmp("updateratifiedload").getValue(),
                             allowdragtotalquality:Ext.getCmp("updateallowdragtotalquality").getValue(),
                             driverinno:Ext.getCmp("updatedriverinno").getValue(),
                             steelspring:Ext.getCmp("updatesteelspring").getValue(),
                             vicecartiresno:Ext.getCmp("updatevicecartiresno").getValue(),
                             outcarwheeldis:Ext.getCmp("updateoutcarwheeldis").getValue(),
                             outcartiressize:Ext.getCmp("updateoutcartiressize").getValue()
                             }
                             }
                             );
                             }}]
                             });
			Ynzc.manage.ChangeBodyEditWin.superclass.initComponent.apply(this,arguments);
		}
});