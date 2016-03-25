Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.UniteHarvesterInfoGridAddWin=Ext.extend(Ext.Window,{
                id:'uniteHarvesterInfoGridAddWin',
                initComponent:function(){
                    Ext.apply(this,{
                    	id:'uniteHarvesterInfoGridAddWin',
			            title:"联合收割机注册登记",
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
			                    		anchor:'98%'
			                    	},{
			                    		id:'liveAddress',
			                    		xtype:"textfield",
			                    		fieldLabel:'住所地址',
			                    		anchor:'98%'
			                    	},{
			                    		id:'tempAddress',
			                    		xtype:"textfield",
			                    		fieldLabel:'暂住地址',
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
			                    		anchor:'98%'
			                    	},{
			                    		id:'livePostCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'邮政编码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'tempPostCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'邮政编码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'certiCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'证件号码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'liveCode',
			                    		xtype:"textfield",
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
                        						boxLabel:'购买'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zhongjiang',
                        						boxLabel:'中奖'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'jicheng',
                        						boxLabel:'继承'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zengyu',
                        						boxLabel:'赠予'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'xieyidichang',
                        						boxLabel:'协议抵偿债务'
                    						}]
                    					},{
                    						columnWidth:1
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zichanchongzu',
                        						boxLabel:'资产重组'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zhengtimaimai',
                        						boxLabel:'资产整体买卖'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'diaobo',
                        						boxLabel:'调拨'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'fayuan',
                        						boxLabel:'法院调解/裁定/判决'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'zhongcai',
                        						boxLabel:'仲裁裁决'
                    						}]
                    					},{
                    						columnWidth:1
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'qita',
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
			                    		 fieldLabel:'收割机车牌号码',
			                    		 xtype: "combo",
			                             displayField:'platenum',
			                             valueField: 'platenum',
			                             typeAhead: true,
			                             mode: 'remote',
			                             editable: false,
			                             selectOnFoucs: true,
			                             triggerAction: 'all',
			                             store: new Ext.data.Store({
			                            		url:"main/reaperPlate.html?action=getLowReaperPlate",
			                            		autoLoad:true,
			                            		reader : new Ext.data.JsonReader({
			                            				root : 'data',
			                            				id : 'id',
			                            				fields : ["id","platenum","platehead","status","unitid"]
			                            			}),
			                            		listeners:{
			                            	   	 	load: function (store, record, opts) {
			                            	            var firstValue = record[0].data.platehead+"."+record[0].data.platenum;
			                            	            Ynzc.manage.NewHarvestNum=record[0].data.platenum;
			                            	            Ext.getCmp("harvesterCode").setValue(firstValue);
			                            	            store.removeAll();
			                            	        }   
			                            	    }
			                            }),            
			                             anchor: '98%'
			                    	},{
			                    		id:'harvesterQuality',
			                    		xtype:"textfield",
			                    		fieldLabel:'总质量',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterBodyCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'机身号码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterEngineCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'发动机号码',
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
			                    		id:'combRegion',
			                    		xtype:"regcombo",
			                    		fieldLabel:'管辖地',
			                    		anchor:'98%'
			                    	},{
			                    		id:'caraddress',
			                    		xtype:"uncombo",
			                    		fieldLabel:'车辆地址',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterChangPaiType',
			                    		xtype:"textfield",
			                    		fieldLabel:'厂牌型号',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterSitNum',
			                    		xtype:"textfield",
			                    		fieldLabel:'驾驶室人数',
			                    		anchor:'98%'
			                    	},{
			                    		id:'harvesterBodyColor',
			                    		xtype:"textfield",
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
                        						boxLabel:'销售/交易发票'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'tiaojieshu',
                        						boxLabel:'调解书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'caidingshu',
                        						boxLabel:'裁定书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'panjueshi',
                        						boxLabel:'判决书'
                    						}]
                    					},{
                    						columnWidth:1
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'xiangguanwenshu',
                        						boxLabel:'相关文书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'pizhunwenjian',
                        						boxLabel:'批准文件'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'diaobozhengming',
                        						boxLabel:'调拨证明'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
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
                        						boxLabel:'货物进口证明书'
                    						}]
                    					},{
                    						columnWidth:.2,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'moshouzousi',
                        						boxLabel:'没收走私农机证明书'
                    						}]
                    					},{
                    						columnWidth:.6,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'china',
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
                        						boxLabel:'国产农机的整车出厂合格证'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'nongjidangan',
                        						boxLabel:'农机档案'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'shenfenzhengming',
                        						boxLabel:'身份证明'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'xieyizhixing',
                        						boxLabel:'协助执行通知书'
                    						}]
                    					},{
                    						columnWidth:.175,
                    						items:[{
                    							xtype:'checkbox',
                        						id:'gongzhengshu',
                        						boxLabel:'公证书'
                    						}]
                    					},{
                    						columnWidth:1
                    					}]
                            		}]
			                	}]
			                },{
			                	title:'收割机图片',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	items:[{
			                		columnWidth:.26
			                	},{
			                		columnWidth:.6,
			                		labelWidth:85,
			                    	layout:"form",
				                   	items:[{
				                   		id:"photoDir",
				                   		xtype:"picpanel",
				                   		defaultPicUrl:"./Public/Images/sys/noupload.gif",
				                   		actionUrl:"main/tractorInfo.html?action=uploadPic",
				                   		uploadWinTitle:"拖拉机照片",
				                   		height:280,
				                   		width:320
			                        }]
			                	},{
			                		columnWidth:.14
			                	}]
			                },{
			                	title:'经办情况',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	items:[{
			                		columnWidth:.22
			                	},{
			                		columnWidth:.6,
			                		layout:'form',
			                		labelWidth:65,
			                		items:[{
			                			id:'applicationType',
			                    		fieldLabel:'申请方式',
			                    		xtype:"combo",
			                   		    displayField : 'display',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                store:Ynzc.manage.ApplicationDataType,
			                    		anchor:'98%'
			                		},{
			                			id:'jinbandate',
			                			readOnly:true,
			                			xtype:'datefield',
			                			format:"Y-m-d",
			                			fieldLabel:'经办时间',
			                			anchor:'98%'
			                		},{
			                			id:'jinbanMan',
			                			xtype:'textfield',
			                			fieldLabel:'经办人',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.18
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
			            		if(Ext.getCmp("harvesterOwner").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>姓名/名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("liveAddress").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>住所地址</font>]为空，请填写。");return}
			            		if(Ext.getCmp("tempAddress").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>暂住地址</font>]为空，请填写。");return}
			            		if(Ext.getCmp("certitype").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>证件类型</font>]为空，请填写。");return}
			            		if(Ext.getCmp("liveType").getValue()===""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>居住类型</font>]为空，请填写。");return}
			            		if(Ext.getCmp("telephoneNum").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>联系电话</font>]为空，请填写。");return}
			            		if(checkPost(Ext.getCmp("livePostCode").getValue())){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>居住邮编</font>]输入有误，请填写。");return}
			            		if(checkPost(Ext.getCmp("tempPostCode").getValue())){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>暂住邮编</font>]输入有误，请填写。");return}
			            		if(Ext.getCmp("certiCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>证件号码</font>]为空，请填写。");return}
			            		if(Ext.getCmp("liveCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>所有人信息</font>][<font color=red>居住号码</font>]为空，请填写。");return}
			            		if(checkNum(Ext.getCmp("harvesterQuality").getValue())){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>总质量</font>]为空，请填写。");return}
			            		if(Ext.getCmp("harvesterBodyCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>机身号码</font>]为空，请填写。");return}
			            		if(Ext.getCmp("harvesterEngineCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>发动机号码</font>]为空，请填写。");return}
			            		if(Ext.getCmp("harvesterType").getValue()===""){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>收割机类型</font>]为空，请填写。");return}
			            		if(Ext.getCmp("combRegion").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>管辖地</font>]为空，请填写。");return}
			            		if(Ext.getCmp("harvesterChangPaiType").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>厂牌型号</font>]为空，请填写。");return}
			            		if(checkNum(Ext.getCmp("harvesterSitNum").getValue())){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>驾驶室人数</font>]输入有误，请填写。");return}
			            		if(Ext.getCmp("harvesterBodyColor").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>机身颜色</font>]为空，请填写。");return}
			            		if(Ext.getCmp("photoDir").picbox.autoEl.src=="./Public/Images/sys/noupload.gif"&&Ext.getCmp("photoDir").getValue()==null){Ext.ux.Toast.msg("操作提示","[<font color=red>收割机图片</font>][<font color=red>收割机图片</font>]没有上传，请上传。");return}
			            		if(Ext.getCmp("applicationType").getValue()===""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>申请方式</font>]为空，请填写。");return}
			            		if(Ext.getCmp("jinbandate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>经办时间</font>]为空，请填写。");return}
			            		if(Ext.getCmp("jinbanMan").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>经办情况</font>][<font color=red>经办人</font>]为空，请填写。");return}
			            		var getWay="";
			            		if(Ext.getCmp("goumai").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("zhongjiang").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("jicheng").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("zengyu").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("xieyidichang").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("zichanchongzu").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("zhengtimaimai").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("diaobo").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("fayuan").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("zhongcai").checked){getWay+="1,"}else{getWay+="0,"}
			            		if(Ext.getCmp("qita").checked){getWay+="1,"}else{getWay+="0,"}
			            		var comeProve="";
			            		if(Ext.getCmp("xiaoshoujiaoyi").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("tiaojieshu").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("caidingshu").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("panjueshi").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("xiangguanwenshu").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("pizhunwenjian").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("diaobozhengming").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		if(Ext.getCmp("zhongcaicaijueshu").checked){comeProve+="1,"}else{comeProve+="0,"}
			            		var imports="";
			            		if(Ext.getCmp("huowujinkou").checked){imports+="1,"}else{imports+="0,"}
			            		if(Ext.getCmp("moshouzousi").checked){imports+="1,"}else{imports+="0,"}
			            		if(Ext.getCmp("china").checked){imports+="1,"}else{imports+="0,"}
			            		var others="";
			            		if(Ext.getCmp("guochannongji").checked){others+="1,"}else{others+="0,"}
			            		if(Ext.getCmp("nongjidangan").checked){others+="1,"}else{others+="0,"}
			            		if(Ext.getCmp("shenfenzhengming").checked){others+="1,"}else{others+="0,"}
			            		if(Ext.getCmp("xieyizhixing").checked){others+="1,"}else{others+="0,"}
			            		if(Ext.getCmp("gongzhengshu").checked){others+="1,"}else{others+="0,"}
			            		if(getWay=="0,0,0,0,0,0,0,0,0,0,0,"){Ext.ux.Toast.msg("操作提示","[<font color=red>联合收割机</font>][<font color=red>获得方式</font>]未选择，请选择。");return}
			            		Ext.Ajax.request({
			            			url:'main/uniteharvesterInfo.html?action=addUniteharvester',
			            			success:function(res){
			            				var result=Ext.util.JSON.decode(res.responseText);
			            				if(result.success==true){
			            					Ext.ux.Toast.msg("操作提示",result.reason);
				            				Ext.getCmp("uiteHarvesterRegist").getStore().reload();
				            				Ext.getCmp("uniteHarvesterInfoGridAddWin").close();
			            				}else{
			            					Ext.ux.Toast.msg("操作提示",result.reason);
			            				}
			            			},
			            			params:{
			            				harvesterCode:Ynzc.manage.NewHarvestNum,
			            				harvesterOwner:Ext.getCmp("harvesterOwner").getValue(),
			            				harvesterGuanXiaDi:Ext.getCmp("combRegion").getValue(),
			            				telephoneNum:Ext.getCmp("telephoneNum").getValue(),
			            				liveAddress:Ext.getCmp("liveAddress").getValue(),
			            				livePostCode:Ext.getCmp("livePostCode").getValue(),
			            				tempAddress:Ext.getCmp("tempAddress").getValue(),
			            				tempPostCode:Ext.getCmp("tempPostCode").getValue(),
			            				certitype:Ext.getCmp("certitype").getValue(),
			            				certiCode:Ext.getCmp("certiCode").getValue(),
			            				liveType:Ext.getCmp("liveType").getValue(),
			            				liveCode:Ext.getCmp("liveCode").getValue(),
			            				harvesterType:Ext.getCmp("harvesterType").getValue(),
			            				harvesterChangPaiType:Ext.getCmp("harvesterChangPaiType").getValue(),
			            				harvesterQuality:Ext.getCmp("harvesterQuality").getValue(),
			            				harvesterSitNum:Ext.getCmp("harvesterSitNum").getValue(),
			            				harvesterEngineCode:Ext.getCmp("harvesterEngineCode").getValue(),
			            				harvesterBodyColor:Ext.getCmp("harvesterBodyColor").getValue(),
			            				harvesterBodyCode:Ext.getCmp("harvesterBodyCode").getValue(),
			            				applicationType:Ext.getCmp("applicationType").getValue(),
			            				registerDate:Ext.util.Format.date(Ext.getCmp("jinbandate").getValue(),'Y-m-d'),
			            				registerMan:Ext.getCmp("jinbanMan").getValue(),
			            				unitid:Ext.getCmp("caraddress").getMyValue(),
			            				harvesterPhotoUrl:Ext.getCmp("photoDir").getValue(),
			            				harvesterState:0,
			            				comeProofType:comeProve,
			            				importType:imports,
			            				otherType:others,
			            				harvesterGetWay:getWay,
			            				id:Ynzc.manage.uniteHarvestId
			            			}
			            		});
			            	}
			            },{
			            	id:'cancle',
			            	text:'取消',
			            	handler:function(){
			            		Ext.getCmp("uniteHarvesterInfoGridAddWin").close();
			            	}
			            }]
                });
                 Ynzc.manage.UniteHarvesterInfoGridAddWin.superclass.initComponent.apply(this,arguments);
                }
});