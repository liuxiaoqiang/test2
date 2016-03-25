Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.UniteHarvesterCheckInfoGridUpdateWin=Ext.extend(Ext.Window,{
                id:'uniteHarvesterCheckInfoGridUpdateWin',
                initComponent:function(){
                    Ext.apply(this,{
                    	id:'uniteHarvesterCheckInfoGridUpdateWin',
			            title:"联合收割机年检信息修改",
			            iconCls:'icon-Add',
			            resizable:false,
			            modal:true,
		 	            height:380,
			            width:750,
			            items:[{
			            	xtype:'tabpanel',
			                border:false,
			                frame:true,
			                activeTab:0,
			                items:[{
			                	title:'所有人信息',
			                    frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:345,
			                    layout:'column',
			                    items:[{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'harvesterOwner',
			                    		xtype:"textfield",
			                    		fieldLabel:'姓名/名称',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'liveAddress',
			                    		xtype:"textfield",
			                    		fieldLabel:'住所地址',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'tempAddress',
			                    		xtype:"textfield",
			                    		fieldLabel:'暂住地址',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'certitype',
			                    		xtype:"combo",
			                    		fieldLabel:'证件类型',          		
			                   		    displayField : 'realcertificatetype',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'remote',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                store:Ynzc.manage.Certificate,
			                    		anchor:'98%'
			                    	},{
			                    		id:'liveType',
			                    		xtype:"combo",
			                    		readOnly:true,
			                    		fieldLabel:'居住类型',
			                   		    displayField : 'display',
						                valueField : 'value',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                store:Ynzc.manage.IsTempLiveData,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'telephoneNum',
			                    		xtype:"textfield",
			                    		fieldLabel:'联系电话',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'livePostCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'邮政编码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'tempPostCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'邮政编码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'certiCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'证件号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'liveCode',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'居住号码',
			                    		anchor:'98%'
			                    	}]
			                    }]
			                },{
			                	title:'联合收割机',
			                    frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                    layout:'column',
			                    items:[{
                            		columnWidth:1,
                            		layout:'fit',
                            		items:[{
                            			xtype:'fieldset',
                            			title:'获得方式',
                            			layout:'column',
                            			collapsible:true,
                    					autoHeight:true,
                    					items:[{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'goumai',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'购买'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zhongjiang',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'中奖'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'jicheng',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'继承'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zengyu',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'赠予'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'xieyidichang',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'协议抵偿债务'
                    						}]
                    					},{
                    						columnWidth:1
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zichanchongzu',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'资产重组'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zhengtimaimai',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'资产整体买卖'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'diaobo',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'调拨'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'fayuan',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'法院调解/裁定/判决'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zhongcai',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'仲裁裁决'
                    						}]
                    					},{
                    						columnWidth:1
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'qita',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'其他'
                    						}]
                    					}]
                            		}]
                            	},{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:105,
			                    	items:[{
			                    		id:'harvesterCode',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'收割机车牌号码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterQuality',
			                    		xtype:"textfield",
			                    		fieldLabel:'总质量',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterBodyCode',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'机身号码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterEngineCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'发动机号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterType',
			                    		fieldLabel:'收割机类型',
			                    		xtype:"combo",
			                   		    displayField : 'display',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                store:Ynzc.manage.uniteHarvestType,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'unitRegion',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'管辖地',
			                    		anchor:'98%'
			                    	},{
			                    		id:'caraddress',
			                    		xtype:"uncombo",
			                    		readOnly:true,
			                    		fieldLabel:'车辆地址',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterChangPaiType',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'厂牌型号',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterSitNum',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'驾驶室人数',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterBodyColor',
			                    		xtype:"textfield",
			                    		readOnly:true,
			                    		fieldLabel:'机身颜色',
			                    		anchor:'98%'
			                    	}]
			                    },{
                            		columnWidth:1,
                            		layout:'form',
                            		labelWidth:60,
                            		hidden:true,
                            		items:[{
                            			id:'txtRegionid',
                                		fieldLabel:"行政区划ID",
                                		xtype:'textfield',
                                		anchor:'98%'
                            		}]
                            	}]
			                },{
			                	title:'相关资料',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	items:[{
                            		columnWidth:1,
                            		layout:'fit',
                            		items:[{
                            			xtype:'fieldset',
                            			title:'来历证明',
                            			layout:'column',
                            			collapsible:true,
                    					autoHeight:true,
                    					items:[{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'xiaoshoujiaoyi',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'销售/交易发票'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'tiaojieshu',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'调解书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'caidingshu',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'裁定书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'panjueshi',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'判决书'
                    						}]
                    					},{
                    						columnWidth:1
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'xiangguanwenshu',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'相关文书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'pizhunwenjian',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'批准文件'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'diaobozhengming',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'调拨证明'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                    							disabled:true,
                        						disabledClass:"checkCss",
                        						id:'zhongcaicaijueshu',
                        						boxLabel:'仲裁裁决书'
                    						}]
                    					}]
                            		},{
                            			xtype:'fieldset',
                            			title:'进口凭证',
                            			layout:'column',
                            			collapsible:true,
                    					autoHeight:true,
                    					items:[{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'huowujinkou',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'货物进口证明书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'moshouzousi',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'没收走私农机证明书'
                    						}]
                    					},{
                    						columnWidth:.6,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'china',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'中华人民共和国海关监管农机进（出）境领（销）牌证通知书'
                    						}]
                    					}]
                            		},{
                            			xtype:'fieldset',
                            			title:'其他',
                            			layout:'column',
                            			collapsible:true,
                    					autoHeight:true,
                    					items:[{
                    						columnWidth:.3,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'guochannongji',
                        						disabled:true,
                        						disabledClass:"checkCss",
                        						boxLabel:'国产农机的整车出厂合格证'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                    							disabled:true,
                        						disabledClass:"checkCss",
                        						id:'nongjidangan',
                        						boxLabel:'农机档案'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                    							disabled:true,
                        						disabledClass:"checkCss",
                        						id:'shenfenzhengming',
                        						boxLabel:'身份证明'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                    							disabled:true,
                        						disabledClass:"checkCss",
                        						id:'xieyizhixing',
                        						boxLabel:'协助执行通知书'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                    							disabled:true,
                        						disabledClass:"checkCss",
                        						id:'gongzhengshu',
                        						boxLabel:'公证书'
                    						}]
                    					},{
                    						columnWidth:1
                    					}]
                            		}]
			                	}]
			                },{
			                	title:'上次检验',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	labelWidth:75,
			                	items:[{
			                		columnWidth:.5,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'checkResult',
			                			xtype:'textfield',
			                			fieldLabel:'检验结论',
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'checkLiveDate',
			                			xtype:"textfield",
			                			fieldLabel:'检验有效期',
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'checkMan',
			                			xtype:'textfield',
			                			fieldLabel:'检验人',
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'checkDate',
			                			xtype:"textfield",
			                			fieldLabel:'检验时间',
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	}]
			                },{
			                	title:'检验登记事项',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	labelWidth:75,
			                	items:[{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'checkNowResult',
			                			xtype:'textfield',
			                			fieldLabel:'检验结论',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'checknowLiveDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'检验有效期',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'checkNowMan',
			                			xtype:'textfield',
			                			fieldLabel:'检验人',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'checkNowDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'检验时间',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'baodanCode',
			                			xtype:'textfield',
			                			fieldLabel:'保单号',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'baoxianDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'保险日期',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'baoxianName',
			                			xtype:'icombo',
			                			fieldLabel:'保险公司名称',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'baoxianLiveDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'保险有效期',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'baoxianType',
			                			xtype:'combo',
			                			format:"Y-m-d",
			                			readOnly:true,
			                    		displayField : 'display',
						                valueField : 'value',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                value:0,
			                			fieldLabel:'保险类型',
			                			store:Ynzc.manage.BaoXianType,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'checkUnitName',
			                			xtype:'textfield',
			                			fieldLabel:'检验机构名称',
			                			anchor:'99%'
			                		}]
			                	}]
			                },{
			                	title:'经办情况',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	labelWidth:75,
			                	items:[{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'dengjiMan',
			                			xtype:'textfield',
			                			fieldLabel:'登记审核人',	
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'dengjiDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'经办时间',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'paizhengMan',
			                			xtype:'textfield',
			                			fieldLabel:'牌证管理员',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'paizhengDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'经办时间',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'lingdaoMan',
			                			xtype:'textfield',
			                			fieldLabel:'业务领导审核',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'lingdaoDate',
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			readOnly:true,
			                			fieldLabel:'经办时间',
			                			anchor:'98%'
			                		}]
			                	}]
			                }],
			                 listeners:{
		            	     "tabchange":function(tab,panel){
		            			  panel.doLayout();
		            		  }
			                }
			            }],
			            buttons:[{
			            	id:'save',
			            	text:'保存',
			            	handler:function(){
			            		if(Ynzc.manage.UniteHarvestState==1){
    								{Ext.ux.Toast.msg("操作提示","该车已经被注销了，不能进行保存本次操作！");return};
    							}
			            		if(checkLen(Ext.getCmp("checkNowResult").getValue())){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>检验结论</font>]为空，请填写。");return}
			            		if(Ext.getCmp("checknowLiveDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>检验有效期</font>]为空，请选择。");return}
			            		if(Ext.getCmp("checkNowMan").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>检验人</font>]为空，请填写。");return}
			            		if(Ext.getCmp("checkNowDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>检验时间</font>]为空，请选择。");return}
			            		if(Ext.getCmp("baodanCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>保单号</font>]为空，请填写。");return}
			            		if(Ext.getCmp("baoxianDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>保险日期</font>]为空，请填写。");return}
			            		if(Ext.getCmp("baoxianName").getValue()=="请选择保险公司名称"){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>保险公司名称</font>]未选择，请选择。");return}
			            		if(Ext.getCmp("baoxianLiveDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>保险有效期</font>]为空，请选择。");return}
			            		if(Ext.getCmp("baoxianType").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>保险类型</font>]为空，请选择。");return}
			            		if(Ext.getCmp("checkUnitName").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>检验登记事项</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("dengjiMan").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("dengjiDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("paizhengMan").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("paizhengDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("lingdaoMan").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("lingdaoDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>检验机构名称</font>]为空，请填写。");return}
			            		Ext.Ajax.request({
			            			url:'main/uniteharvesterCheckInfo.html?action=updateUniteharvesterCheck',
			            			success:function(res){
			            				var result=Ext.util.JSON.decode(res.responseText);
			            				if(result.success==true){
			            					Ext.ux.Toast.msg("操作提示",result.reason);
				            				Ext.getCmp("uiteHarvesterCheck").getStore().reload();
				            				Ext.getCmp("uniteHarvesterCheckInfoGridUpdateWin").close();
			            				}else{
			            					Ext.ux.Toast.msg("操作提示",result.reason);
			            				}
			            			},
			            			params:{
			            				checkResult:Ext.getCmp("checkNowResult").getValue(),
			            				checkman:Ext.getCmp("checkNowMan").getValue(),
			            				checkDate:Ext.util.Format.date(Ext.getCmp("checkNowDate").getValue(),'Y-m-d'),
			            				insuranceType:Ext.getCmp("baoxianType").getValue(),
			            				checkUnitName:Ext.getCmp("checkUnitName").getValue(),
			            				insuranceCode:Ext.getCmp("baodanCode").getValue(),
			            				insuranceName:Ext.getCmp("baoxianName").getValue(),
			            				insurancedate:Ext.util.Format.date(Ext.getCmp("baoxianDate").getValue(),'Y-m-d'),
			            				insurceActiveDate:Ext.util.Format.date(Ext.getCmp("baoxianLiveDate").getValue(),'Y-m-d'),
			            				checkLiveDate:Ext.util.Format.date(Ext.getCmp("checknowLiveDate").getValue(),'Y-m-d'),
			            				checkRegisterMan:Ext.getCmp("dengjiMan").getValue(),
			            				checkRegisterdate:Ext.util.Format.date(Ext.getCmp("dengjiDate").getValue(),'Y-m-d'),
			            				checkPaizhengMan:Ext.getCmp("paizhengMan").getValue(),
			            				checkPaizhengDate:Ext.util.Format.date(Ext.getCmp("paizhengDate").getValue(),'Y-m-d'),
			            				checkLingDaoMan:Ext.getCmp("lingdaoMan").getValue(),
			            				checkLingDaodate:Ext.util.Format.date(Ext.getCmp("lingdaoDate").getValue(),'Y-m-d'),
			            				EnteyMan:loginUser,
			            				harvesterId:Ynzc.manage.checkuniteHarvestId,
			            				id:Ynzc.manage.uniteHarvestcheckId
			            			}
			            		});
			            	}
			            },{
			            	id:'cancle',
			            	text:'取消',
			            	handler:function(){
			            		Ext.getCmp("uniteHarvesterCheckInfoGridUpdateWin").close();
			            	}
			            }]
                });
                 Ynzc.manage.UniteHarvesterCheckInfoGridUpdateWin.superclass.initComponent.apply(this,arguments);
                }
});