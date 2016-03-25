Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivertrainingUniteHarvestInfoAdd=Ext.extend(Ext.Window,{
                id:'drivertrainingUniteHarvestInfoAdd',
                initComponent:function(){
                    Ext.apply(this,{
                    	id:'drivertrainingUniteHarvestInfoAdd',
			            title:"教练车注册登记(联合收割机)",
			            iconCls:'icon-Add',
			            resizable:false,
			            modal:true,
			            height:230,
			            width:650,
			            items:[{
			            	xtype:'tabpanel',
			                border:false,
			                frame:true,
			                activeTab:0,
			                items:[{
			                	title:'申请人信息',
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
			                    		id:'unitname',
			                    		xtype:"textfield",
			                    		fieldLabel:'单位名称',
			                    		anchor:'98%'
			                    	},{
			                    		id:'address',
			                    		xtype:"textfield",
			                    		fieldLabel:'单位地址',
			                    		anchor:'98%'
			                    	},{
			                    		id:'unitCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'机构代码',
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
			                    		anchor:'98%'
			                    	},{
			                    		id:'postCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'邮政编码',
			                    		anchor:'98%'
			                    	},{
			                    		id:'driverCode',
			                    		xtype:"textfield",
			                    		fieldLabel:'教练机号码',
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
			                    		id:'letterAddCode',
			                    		xtype:'textfield',
			                    		fieldLabel:'居住地',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'tractorNum',
			                    		xtype:'textfield',
			                    		fieldLabel:'车辆号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:1,
			                    	layout:'form',
			                    	labelWidth:90,
			                    	items:[{
			                    		id:'tractorDiPanNum',
			                    		xtype:'textfield',
			                    		fieldLabel:'机身号码',
			                    		readOnly:true,
			                    		anchor:'99%'
			                    	}]
			                    },{
		                    		columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:90,
			                    	items:[{
			                    		id:'fadongjiNum',
			                    		xtype:'textfield',
			                    		fieldLabel:'发动机号码',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'changpaiType',
			                    		xtype:'textfield',
			                    		fieldLabel:'厂牌型号',
			                    		forceSelection:false,
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    },{
		                    		columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:90,
			                    	items:[{
			                    		id:'huacheNum',
			                    		xtype:'textfield',
			                    		fieldLabel:'机身颜色',
			                    		readOnly:true,
			                    		anchor:'98%'
			                    	}]
			                    },{
			                    	columnWidth:.5,
			                    	layout:'form',
			                    	labelWidth:75,
			                    	items:[{
			                    		id:'carType',
			                    		xtype:"combo",
			                    		fieldLabel:'车辆类型',
			                    		readOnly:true,
			                    		displayField : 'display',
						                valueField : 'id',
						                typeAhead : true,
						                mode : 'local',
						                editable : false,
						                selectOnFoucs : true,
						                triggerAction : 'all',
						                value:0,
			                    		store:Ynzc.manage.uniteHarvestType,
			                    		anchor:'98%'
			                    	}]
			                    }]
			                },{
			                	title:'审核处理信息',
			                	frame:true,
			                    bodyStyle:"padding:5px 5px",
			                    autoScroll:true,
			                    height:375,
			                	layout:'column',
			                	items:[{
			                		columnWidth:.6,
			                		layout:'form',
			                		labelWidth:135,
			                		items:[{
			                			id:'jizhuqianzhang',
			                			xtype:'textfield',
			                			fieldLabel:'教练机机主签章',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.4,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'jizhuqianzhangDate',
			                			xtype:'datefield',
			                			fieldLabel:'办理日期',
			                			value:new Date(),
			                			format:"Y-m-d",
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.6,
			                		layout:'form',
			                		labelWidth:135,
			                		items:[{
			                			id:'nongjishenhe',
			                			xtype:'textfield',
			                			fieldLabel:'农机监理机构审核意见',
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.4,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'nongjishenheDate',
			                			xtype:'datefield',
			                			fieldLabel:'办理日期',
			                			value:new Date(),
			                			format:"Y-m-d",
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.6,
			                		layout:'form',
			                		labelWidth:135,
			                		items:[{
			                			id:'jingbanren',
			                			xtype:'textfield',
			                			fieldLabel:'经办人',
			                			readOnly:true,
			                			anchor:'98%'
			                		}]
			                	},{
			                		columnWidth:.4,
			                		layout:'form',
			                		labelWidth:75,
			                		items:[{
			                			id:'jingbanDate',
			                			xtype:'datefield',
			                			fieldLabel:'办理日期',
			                			value:new Date(),
			                			format:"Y-m-d",
			                			readOnly:true,
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
			            		if(Ext.getCmp("unitname").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>申请人信息</font>][<font color=red>单位名称</font>]为空，请填写。");return}
			            		if(Ext.getCmp("address").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>申请人信息</font>][<font color=red>单位地址</font>]为空，请填写。");return}
			            		if(Ext.getCmp("unitCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>申请人信息</font>][<font color=red>机构代码</font>]为空，请填写。");return}
			            		if(Ext.getCmp("telephone").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>申请人信息</font>][<font color=red>联系电话</font>]为空，请填写。");return}
			            		if(checkPost(Ext.getCmp("postCode").getValue())){Ext.ux.Toast.msg("操作提示","[<font color=red>申请人信息</font>][<font color=red>邮政编码</font>]输入有误，请填写。");return}
			            		if(Ext.getCmp("driverCode").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>申请人信息</font>][<font color=red>教练机号码</font>]为空，请填写。");return}
			            		if(Ext.getCmp("jizhuqianzhang").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>审核处理信息</font>][<font color=red>教练机机主签章</font>]为空，请填写。");return}
			            		if(Ext.getCmp("jizhuqianzhangDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>审核处理信息</font>][<font color=red>教练机机主签章日期</font>]为空，请填写。");return}
			            		if(Ext.getCmp("nongjishenhe").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>审核处理信息</font>][<font color=red>农机监理机构审核意见</font>]为空，请填写。");return}
			            		if(Ext.getCmp("nongjishenheDate").getValue()==""){Ext.ux.Toast.msg("操作提示","[<font color=red>审核处理信息</font>][<font color=red>农机监理机构审核日期</font>]为空，请填写。");return}
			            		Ext.Ajax.request({
			            			url:'main/drivertrainingInfo.html?action=addDrivertrainingInfo',
			            			success:function(res){
			            				var result=Ext.util.JSON.decode(res.responseText);
			            				if(result.success==true){
			            					Ext.ux.Toast.msg("操作提示",result.reason);
				            				Ext.getCmp("drivertrainingInfoMgr").getStore().reload();
				            				Ext.getCmp("drivertrainingUniteHarvestInfoAdd").close();
			            				}else{
			            					Ext.ux.Toast.msg("操作提示",result.reason);
			            				}
			            			},
			            			params:{
			            				unitname:Ext.getCmp("unitname").getValue(),
			            				UnitAddress:Ext.getCmp("address").getValue(),
			            				unitCode:Ext.getCmp("unitCode").getValue(),
			            				telephone:Ext.getCmp("telephone").getValue(),
			            				postCode:Ext.getCmp("postCode").getValue(),
			            				CardCode:Ext.getCmp("driverCode").getValue(),
			            				Owner:Ext.getCmp("jizhuqianzhang").getValue(),
			            				ApplicationTime:Ext.util.Format.date(Ext.getCmp("jizhuqianzhangDate").getValue(),'Y-m-d'),
			            				AuditOption:Ext.getCmp("nongjishenhe").getValue(),
			            				auditDate:Ext.util.Format.date(Ext.getCmp("nongjishenheDate").getValue(),'Y-m-d'),
			            				tractorinfoId:Ynzc.manage.uniteharvestid,
			            				tractorinfoIdCode:Ynzc.manage.uniteharvestCode,
			            				LetterCode:Ext.getCmp("letterAddCode").getValue(),
			            				agentMan:Ext.getCmp("jingbanren").getValue(),
			            				agentDate:Ext.util.Format.date(Ext.getCmp("jingbanDate").getValue(),'Y-m-d'),
			            				carType:Ynzc.manage.carTypes,
			            				unitid:Ynzc.manage.unitidTractorid
			            			}
			            		});
			            	}
			            },{
			            	id:'cancle',
			            	text:'取消',
			            	handler:function(){
			            		Ext.getCmp("drivertrainingUniteHarvestInfoAdd").close();
			            	}
			            }]
                });
                 Ynzc.manage.DrivertrainingUniteHarvestInfoAdd.superclass.initComponent.apply(this,arguments);
                }
});