Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.CarCheckWin=Ext.extend(Ext.Window,{
		id:"carcheckwin",
		initComponent:function(){
			Ext.apply(this,{
				id:"carcheckwin",
				title:"车辆年检",
				height:450,
				width:500,
				resizable:false,
				modal:true,
				items:[{
					xtype:"fieldset",
					title:"技术检验",
					layout:"column",
					items:[{
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'inspectorresult',
                    	            fieldLabel:"检验结论",
                    	            xtype:"textfield",
                    	            anchor:'100%'
                           		}]
                           },{
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:"checkexpirydate",
                           			fieldLabel:"检验有效期",
                           			format:"Y-m-d",
                           			xtype:"datefield",
		                    		anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'inspector',
                    	            fieldLabel:"检验人",
                    	            xtype:"textfield",
                    	            anchor:'100%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:'inspectordate',
                    	            fieldLabel:"检验日期",
                    	            format:"Y-m-d",
                    	            xtype:"datefield",
                    	            anchor:'100%'
                           		}]
                           },
                             {
                           		columnWidth:1,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'checkcompanyname',
                    	            fieldLabel:"检验机构名称",
                    	            xtype:"textfield",
                    	            anchor:'100%'
                           		}]
                           }]
				},
				{
					xtype:"fieldset",
					title:"交强险",
					layout:"column",
					items:[{
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'insurancelistno',
                           			fieldLabel:"保单号",
                           			xtype:"textfield",
                           			anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:'insurancedate',
                    	            fieldLabel:"检验日期",
                    	            xtype:"datefield",
                    	            format:"Y-m-d",
                    	            anchor:'100%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:"insurancecompanyname",
                           			shadowOffset:0,
                           			fieldLabel:"保险公司",
                           			xtype:"icombo",
		                    		anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:'expirydate',
                    	            fieldLabel:"保险有效期",
                    	            xtype:"datefield",
                    	            format:"Y-m-d",
                    	            anchor:'100%'
                           		}]
                           }]
				},
				{
					xtype:"fieldset",
					title:"经办情况",
					layout:"column",
					items:[{
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'reviewer',
                           			fieldLabel:"登记审核人",
                           			xtype:"textfield",
                           			anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:'reviewerconductdate',
                           			fieldLabel:"经办时间",
                           			xtype:"datefield",
                           			format:"Y-m-d",
                           			anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'issueadmin',
                           			fieldLabel:"牌证管理员",
                           			xtype:"textfield",
                           			anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:'issueadmindate',
                           			fieldLabel:"经办时间",
                           			xtype:"datefield",
                           			format:"Y-m-d",
                           			anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:90,
                           		items:[{
                           			id:'leaderreview',
                           			fieldLabel:"业务领导审核",
                           			xtype:"textfield",
                           			anchor:'98%'
                           		}]
                           },
                           {
                           		columnWidth:.5,
                           		layout:"form",
                           		labelWidth:70,
                           		items:[{
                           			id:'leaderreviewdate',
                           			fieldLabel:"经办时间",
                           			xtype:"datefield",
                           			format:"Y-m-d",
                           			anchor:'98%'
                           		}]
                           }]
				}],
				buttons:[{
					id:"savaBtn",
					text:"提交",
					handler:function(){
						if(Ext.getCmp("inspectorresult").getValue()==""){Ext.MessageBox.alert("提示","请填写年检结论!");return}
						if(Ext.getCmp("checkexpirydate").getValue()==""){Ext.MessageBox.alert("提示","请填写年检有效期!");return}
						if(Ext.getCmp("inspector").getValue()==""){Ext.MessageBox.alert("提示","请填写检验人!");return}
						if(Ext.getCmp("inspectordate").getValue()==""){Ext.MessageBox.alert("提示","请填写检验日期!");return}
						if(Ext.getCmp("checkcompanyname").getValue()==""){Ext.MessageBox.alert("提示","请填写检验机构名称!");return}
						if(Ext.getCmp("insurancelistno").getValue()==""){Ext.MessageBox.alert("提示","请填写检保单号!");return}
						if(Ext.getCmp("insurancedate").getValue()==""){Ext.MessageBox.alert("提示","请填写保险日期!");return}
						if(Ext.getCmp("insurancecompanyname").getValue()==""){Ext.MessageBox.alert("提示","请选择保险公司名称!");return}
						if(Ext.getCmp("expirydate").getValue()==""){Ext.MessageBox.alert("提示","请填写保单有效期!");return}
						if(Ext.getCmp("reviewer").getValue()==""){Ext.MessageBox.alert("提示","请填写登记审核人!");return}
						if(Ext.getCmp("reviewerconductdate").getValue()==""){Ext.MessageBox.alert("提示","请填写经办时间!");return}
						if(Ext.getCmp("issueadmin").getValue()==""){Ext.MessageBox.alert("提示","请填写牌证管理员!");return}
						if(Ext.getCmp("issueadmindate").getValue()==""){Ext.MessageBox.alert("提示","请填写经办时间!");return}
						if(Ext.getCmp("leaderreview").getValue()==""){Ext.MessageBox.alert("提示","请填写业务领导审核!");return}
						if(Ext.getCmp("leaderreviewdate").getValue()==""){Ext.MessageBox.alert("提示","请填写经办时间!");return}
						                                var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
						Ext.Ajax.request({
							url:"main/carCheck.html?action=addCarCheck",
							success:function(resp){
							mask.hide();
								var result=Ext.util.JSON.decode(resp.responseText);
								if(result.success==true){
									Ext.MessageBox.alert("提示","操作成功!");
									Ext.getCmp("carcheckwin").close();
								}else{
									Ext.Msg.alert("提示","操作失败!");
								}
							},
							failure:function(){
								Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
							},
							params:{
								tractorinfoId:Ynzc.manage.carchecktractorinfoid,
								inspectorresult:Ext.getCmp("inspectorresult").getValue(),
								checkexpirydate:Ext.util.Format.date(Ext.getCmp("checkexpirydate").getValue(),'Y-m-d'),
								inspector:Ext.getCmp("inspector").getValue(),
								inspectordate:Ext.util.Format.date(Ext.getCmp("inspectordate").getValue(),'Y-m-d'),
								checkcompanyname:Ext.getCmp("checkcompanyname").getValue(),
								insurancelistno:Ext.getCmp("insurancelistno").getValue(),
								insurancedate:Ext.util.Format.date(Ext.getCmp("insurancedate").getValue(),'Y-m-d'),
								insurancecompanyname:Ext.getCmp("insurancecompanyname").getValue(),
								expirydate:Ext.util.Format.date(Ext.getCmp("expirydate").getValue(),'Y-m-d'),
								reviewer:Ext.getCmp("reviewer").getValue(),
								reviewerconductdate:Ext.util.Format.date(Ext.getCmp("reviewerconductdate").getValue(),'Y-m-d'),
								issueadmin:Ext.getCmp("issueadmin").getValue(),
								issueadmindate:Ext.util.Format.date(Ext.getCmp("issueadmindate").getValue(),'Y-m-d'),
								leaderreview:Ext.getCmp("leaderreview").getValue(),
								leaderreviewdate:Ext.util.Format.date(Ext.getCmp("leaderreviewdate").getValue(),'Y-m-d')
							}
						});
					}
				},{
					id:"cancelBtn",
					text:"取消",
					handler:function(){
						Ext.getCmp("carcheckwin").close();
					}
				}]
			});
			Ynzc.manage.CarCheckWin.superclass.initComponent.apply(this,arguments);
		}
});