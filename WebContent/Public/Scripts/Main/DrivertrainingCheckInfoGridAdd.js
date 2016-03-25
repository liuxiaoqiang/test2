Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivertrainingCheckInfoGridAdd=Ext.extend(Ext.Window,{
                id:'drivertrainingcheckinfoadd',
                initComponent:function(){
                    Ext.apply(this,{
                    	id:'drivertrainingcheckinfoadd',
			            title:"教练车年度检验(拖拉机)",
			            iconCls:'icon-Add',
			            resizable:false,
			            modal:true,
			            height:260,
			            width:710,
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
			                    		id:'username',
			                    		xtype:"textfield",
			                    		fieldLabel:'姓名/名称',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'isunitOrPeople',
			                    		xtype:"combo",
			                    		fieldLabel:'单位/个人',
			                    		readOnly:true,
			                    		displayField : 'displayvalue',
						                valueField : 'value',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                value:0,
						                store:Ynzc.manage.UOrPStore,
			                    		anchor:'98%'
			                    	},{
			                    		id:'address',
			                    		xtype:"textfield",
			                    		fieldLabel:'住所地址',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'certificatename',
			                    		xtype:"combo",
			                    		fieldLabel:'证件名称',
			                    		readOnly:true,
			                    		displayField : 'realcertificatetype',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                value:0,
			                    		store:Ynzc.manage.Certificate,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'telephone',
			                    		xtype:"textfield",
			                    		fieldLabel:'联系电话',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'isTempLive',
			                    		xtype:"combo",
			                    		fieldLabel:'是否暂住',
			                    		readOnly:true,
			                    		displayField : 'display',
						                valueField : 'value',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                value:0,
			                    		store:Ynzc.manage.IsTempLiveData,
			                    		anchor:'98%'
			                    	},{
			                    		id:'postCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'邮政编码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'certificateCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'证件号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    }]
			                },{
			                	title:'教练机信息',
			                    frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                    layout:'column',
			                    items:[{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:90,
			                    	items:[{
			                    		id:'pinpaiType',
			                    		xtype:"brandcombo",
			                    		fieldLabel:'品牌型号',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'jixieType',
			                    		xtype:"combo",
			                    		fieldLabel:'机械类型',
			                    		readOnly:true,
			                    		displayField : 'machinetype',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                value:0,
			                    		store:Ynzc.manage.MachineType,
			                    		anchor:'98%'
			                    	},{
			                    		id:'jishenCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'机身(底盘)号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'fadongjiCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'发动机号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'registDate',
			                    		xtype:"textfield",
			                    		fieldLabel:'注册日期',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'turninDate',
			                    		xtype:"textfield",
			                    		fieldLabel:'转入日期',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'fapaiDate',
			                    		xtype:"textfield",
			                    		fieldLabel:'发牌证日期',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	},{
			                    		id:'shengchanDate',
			                    		xtype:"textfield",
			                    		fieldLabel:'生产日期',
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
						                valueField : 'display',
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
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'dengjiDate',
			                			xtype:'textfield',
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
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'paizhengDate',
			                			xtype:'textfield',
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
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.5,
			                		layout:'form',
			                		items:[{
			                			id:'lingdaoDate',
			                			xtype:'textfield',
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
			            		Ext.getCmp("save").disable();
			            		Ext.Ajax.request({
			            			url:'main/drivertrainingCheckInfo.html?action=addDrivertrainingCheckInfo',
			            			success:function(data){
			            					var result=Ext.util.JSON.decode(data.responseText);
			            					Ext.ux.Toast.msg("操作提示",result.reason);
			            					Ext.getCmp("save").enable();
			            					Ext.getCmp("drivertrainingcheckinfoadd").close();
			            					Ext.getCmp("drivertrainingcheckinfoMgr").getStore().reload();
			            			},
			            			params:{
			            				checkResult:Ext.getCmp("checkNowResult").getValue(),
			            				CheckMan:Ext.getCmp("checkNowMan").getValue(),
			            				checkDate:Ext.util.Format.date(Ext.getCmp("checkNowDate").getValue(),'Y-m-d'),
			            				insurceType:Ext.getCmp("baoxianType").getValue(),
			            				checkUnitName:Ext.getCmp("checkUnitName").getValue(),
			            				insurceCode:Ext.getCmp("baodanCode").getValue(),
			            				InsurceNameid:Ext.getCmp("baoxianName").getValue(),
			            				InsurceDate:Ext.util.Format.date(Ext.getCmp("baoxianDate").getValue(),'Y-m-d'),
			            				InsurceActiveDate:Ext.util.Format.date(Ext.getCmp("baoxianDate").getValue(),'Y-m-d'),
			            				checkLiveDate:Ext.util.Format.date(Ext.getCmp("checknowLiveDate").getValue(),'Y-m-d'),
			            				EnteyMan:loginUser
			            			}
			            		});
			            	}
			            },{
			            	id:'cancle',
			            	text:'取消',
			            	handler:function(){
			            		Ext.getCmp("drivertrainingcheckinfoadd").close();
			            	}
			            }]
                });
                 Ynzc.manage.DrivertrainingCheckInfoGridAdd.superclass.initComponent.apply(this,arguments);
                }
});