Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ChangeEngineEditWin=Ext.extend(Ext.Window,{
		id:"changeengineeditwin",
		initComponent:function(){
			Ext.apply(this,{
                         id:"changeengineeditwin",
                         title:"修改[更换发动机]信息",
                         modal:true,
                         height:400,
                       	 width:500,
                         layout:"form",
                         labelWidth:80,
                         bodyStyle:"padding:5px 5px",
                         items:[
                         {id:"updateorginEngineInfo",title:"原发动机情况",xtype:"fieldset",height:100,layout:"column",
                         items:[{columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateenginecode",xtype:"textfield",fieldLabel:"发动机号",readOnly:true,anchor:'98%'}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updadtefueltype",xtype:"textfield",fieldLabel:"燃料种类",readOnly:true,anchor:'98%'}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateenginebrand",xtype:"textfield",fieldLabel:"发动机品牌",readOnly:true,anchor:'98%'}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatecylindernumber",xtype:"textfield",fieldLabel:"缸数",readOnly:true,anchor:'98%'}]},
                         {columnWidth:1,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatepower",xtype:"textfield",fieldLabel:"功率",readOnly:true,anchor:'98%'}]}
                         ]
                         },
                         {id:"updatecurrentEngineInfo",title:"现发动机情况",xtype:"fieldset",height:200,layout:"column",
                         items:[
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatenewenginecode",xtype:"textfield",fieldLabel:"发动机号",anchor:'98%'}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatenewfueltype",xtype:"combo",fieldLabel:"燃料种类",displayField : 'fuelname',valueField : 'id',typeAhead : true,mode : 'remote', editable:false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.FuelType,anchor:'98%'}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatenewcylindernumber",xtype:"combo",fieldLabel:"缸数",displayField : 'display',valueField : 'value', typeAhead : true,mode : 'local',editable:false, selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.CylinderStore,anchor:'98%'}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatenewpower",xtype:"textfield",fieldLabel:"功率",anchor:'98%',readOnly:true,
                          listeners:{
                    	"focus":function(){
                    	new Ext.Window({
                    	id:"updatepowerwin",
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
	                    	id:"updatev",
	                    	xtype:"textfield",
	                    	anchor:"98%"
	                    	}]
	                    },{
	                    	columnWidth:.15,
	                    	items:[{
	                    	id:"updateVunit",
	                    	xtype:"label",
	                    	html:"CM³"
	                    	}]
	                   },{
		                    columnWidth:.35,
	                    	items:[{
	                    	id:"updatek",
	                    	xtype:"textfield",
	                    	anchor:"98%"
	                    	}]
	                   },{
	                    	columnWidth:.15,
	                    	items:[{
	                    	id:"updateKW",
	                    	xtype:"label",
	                    	html:"KW"
	                    	}]
	                   }]
                       }],
                       buttons:[{
                    		text:"确定",
                    		handler:function(){
                    		if(Ext.getCmp("updatev").getValue()==""||Ext.getCmp("updatek").getValue()==""){
	                    	Ext.MessageBox.alert("提示","录入的数据不完整，请检查!");
	                    	return;
                    		}else{
                    		var res=Ext.getCmp("updatev").getValue()+"CM³/"+Ext.getCmp("updatek").getValue()+"KW";
                    		Ext.getCmp("updatenewpower").setValue(res);
                    		Ext.getCmp("updatepowerwin").close();
                    		}
                    		}
                    		}]
                      }).show(Ext.getCmp("updatenewpower").getEl());
                      if(Ext.getCmp("updatenewpower").getValue()!=""){
           			  var r1=Ext.getCmp("updatenewpower").getValue().split("CM³/");
           			  Ext.getCmp("updatev").setValue(r1[0]);
           			  Ext.getCmp("updatek").setValue(r1[1].substring(0,r1[1].length-2));
                      }
                      }
                      }
                         }]},
                         {columnWidth:1,layout:"form",baseCls:"x-plain",labelWidth:120,items:[{id:"updatenewenginebrand",xtype:"textfield",fieldLabel:"发动机品牌",xtype:"ebcombo",anchor:'98%'}]},
                         {columnWidth:1,layout:"form",baseCls:"x-plain",labelWidth:120,items:[{id:"updateengineproof",xtype:"textfield",fieldLabel:"发动机来历证明",anchor:'98%'}]},
                         {columnWidth:1,layout:"form",baseCls:"x-plain",labelWidth:120,items:[{id:"updateengineproofnumber",xtype:"textfield",fieldLabel:"发动机合格证明编号",anchor:'98%'}]}
                         ]}
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
                         if(Ext.getCmp("updatenewenginecode").getValue()==""){Ext.MessageBox.alert("提示","请填写发动机号.");return;}
                         if(Ext.getCmp("updatenewfueltype").getValue()===""){Ext.MessageBox.alert("提示","请选择燃料种类.");return;}
                         if(Ext.getCmp("updatenewenginebrand").getValue()===""){Ext.MessageBox.alert("提示","请选择发动机品牌.");return;}
                         if(Ext.getCmp("updatenewcylindernumber").getValue()===""){Ext.MessageBox.alert("提示","请选择缸数.");return;}
                         if(Ext.getCmp("updatenewpower").getValue()==""){Ext.MessageBox.alert("提示","请填写功率.");return;}
                         if(Ext.getCmp("updateengineproof").getValue()==""){Ext.MessageBox.alert("提示","请填写发动机来历证明.");return;}
                         if(Ext.getCmp("updateengineproofnumber").getValue()==""){Ext.MessageBox.alert("提示","请填写发动机合格证明编号.");return;}
                                                         var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
                         Ext.Ajax.request({
                         url:"main/carChange.html?action=UpdateCarChange",
                         method:"post",
                         success:function(resp){
                         mask.hide();
                             var result = Ext.util.JSON.decode(resp.responseText);
                             if (result.success == true) {
                             Ext.MessageBox.alert("提示","修改成功.");
                         	 Ext.getCmp("changeMgr").getStore().reload();
                         	 Ext.getCmp("changeengineeditwin").close(); 
                             }else{
                             Ext.MessageBox.alert("提示","修改失败.");
                             }

                       		},
                         failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                         params:{
                         type:"更换发动机",
                         updatechangeengine:"{id:"+Ynzc.manage.updatechangeengineid+",carchangeid:"+Ynzc.manage.updatechangeid+",enginecode:'"+Ext.getCmp("updateenginecode").getValue()+"',fueltype:'"+Ext.getCmp("updadtefueltype").getValue()+"',enginebrand:'"+Ext.getCmp("updateenginebrand").getValue()+"',cylindernumber:'"+Ext.getCmp("updatecylindernumber").getValue()+"',power:'"+Ext.getCmp("updatepower").getValue()+"',newenginecode:'"+Ext.getCmp("updatenewenginecode").getValue()+"',newfueltype:"+Ext.getCmp("updatenewfueltype").getValue()+",newenginebrand:"+Ext.getCmp("updatenewenginebrand").getMyValue()+",newcylindernumber:'"+Ext.getCmp("updatenewcylindernumber").getValue()+"',newpower:'"+Ext.getCmp("updatenewpower").getValue()+"',engineproof:'"+Ext.getCmp("updateengineproof").getValue()+"',engineproofnumber:'"+Ext.getCmp("updateengineproofnumber").getValue()+"'}"}
                         });
                         }}                                                  
                         ]
                         });
			Ynzc.manage.ChangeEngineEditWin.superclass.initComponent.apply(this,arguments);
		}
});