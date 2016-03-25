Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.ChangeOwnerEditWin=Ext.extend(Ext.Window,{
		id:"changeownereditwin",
		initComponent:function(){
			Ext.apply(this,{
                         id:"changeownerWin",
                         title:"修改[共同所有的拖拉机变更拖拉机所有人]信息",
                         modal:true,
                         height:420,
                       	 width:500,
                         layout:"form",
                         labelWidth:80,
                         bodyStyle:"padding:5px 5px",
                         items:[
                         {id:"updateorginOwnerInfo",title:"原所有人信息",xtype:"fieldset",height:155,layout:"column",
                         items:[{columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorginusername",xtype:"textfield",fieldLabel:"姓名",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorginlintel",xtype:"textfield",fieldLabel:"联系电话",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorgincertificateid",xtype:"textfield",fieldLabel:"身份证明名称",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorgincertificatecode",xtype:"textfield",fieldLabel:"证件号码",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorginunittype",xtype:"textfield",fieldLabel:"单位/个人",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorginaddress",xtype:"textfield",fieldLabel:"住所地址",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorginzipcode",xtype:"textfield",fieldLabel:"邮政编码",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorginistemporary",xtype:"textfield",fieldLabel:"是否暂住",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorgintemporaycertificate",xtype:"textfield",fieldLabel:"暂住证明名称",anchor:"98%",readOnly:true}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateorgintemporaycertificatecode",xtype:"textfield",fieldLabel:"暂住证号码",anchor:"98%",readOnly:true}]}]},
                         {id:"updatecurrentOwnerInfo",title:"现所有人信息",xtype:"fieldset",height:155,layout:"column",
                         items:[{columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateusername",xtype:"textfield",fieldLabel:"姓名",anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatelintel",xtype:"textfield",fieldLabel:"联系电话",anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatecertificateid",fieldLabel:"身份证明名称",anchor:"98%",xtype:"combo",displayField : 'realcertificatetype',valueField : 'id',typeAhead : true,mode : 'remote',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.Certificate}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatecertificatecode",xtype:"textfield",fieldLabel:"证件号码",anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateunittype",xtype:"combo",fieldLabel:"单位/个人",displayField : 'displayvalue',valueField : 'value',typeAhead : true,mode : 'local',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.UOrPStore,anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateaddress",xtype:"textfield",fieldLabel:"住所地址",anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatezipcode",xtype:"textfield",fieldLabel:"邮政编码",anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updateistemporary",xtype:"combo",fieldLabel:"是否暂住",displayField : 'displayvalue',valueField : 'value',typeAhead : true,mode : 'local',editable : false,selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.YesOrNoStore,value:0,anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatetemporaycertificate",xtype:"combo",fieldLabel:"暂住证明名称",displayField : 'templivefileType',valueField : 'id',typeAhead : true,mode : 'remote',selectOnFoucs : true,triggerAction : 'all',store:Ynzc.manage.TempliveFile,anchor:"98%"}]},
                         {columnWidth:.5,layout:"form",baseCls:"x-plain",labelWidth:80,items:[{id:"updatetemporaycertificatecode",xtype:"textfield",fieldLabel:"暂住证号码",anchor:"98%"}]}
                         ]
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
                         if(Ext.getCmp("updateusername").getValue()==""){Ext.MessageBox.alert("提示","请填写姓名");return;}
                         if(Ext.getCmp("updatelintel").getValue()==""){Ext.MessageBox.alert("提示","请填写联系电话");return;}
                         if(Ext.getCmp("updatecertificateid").getValue()==""){Ext.MessageBox.alert("提示","请选择身份证明名称");return;}
                         if(Ext.getCmp("updatecertificatecode").getValue()==""){Ext.MessageBox.alert("提示","请填写证件号码");return;}
                         if(Ext.getCmp("updatecertificateid").getValue() == "8")
                         {
                         	if(Ext.getCmp("updatecertificatecode").getValue() != "")
                         	{
                         		if(checkIdCard(Ext.getCmp("updatecertificatecode").getValue()) != true){
         							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatecertificatecode").getValue()));
         							return;
         						}
                         	}
                         }
                         var livevar=0;
                         if(Ext.getCmp("updatetemporaycertificate").getValue()!=""){
                        	 livevar=Ext.getCmp("updatetemporaycertificate").getValue();
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
                         	 Ext.getCmp("changeownereditwin").close(); 
                             }else{
                             Ext.MessageBox.alert("提示","修改失败.");
                             }
                       		},
                         failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                         params:{
                         type:"共同所有的拖拉机变更拖拉机所有人",
                         updatechangeowner:"{id:"+Ynzc.manage.updatechangeownerid+",carchangeid:"+Ynzc.manage.updatechangeid+",orginusername:'"+Ext.getCmp("updateorginusername").getValue()+"',orginlintel:'"+Ext.getCmp("updateorginlintel").getValue()+"',orgincertificateid:'"+Ext.getCmp("updateorgincertificateid").getValue()+"',orgincertificatecode:'"+Ext.getCmp("updateorgincertificatecode").getValue()+"',orginunittype:'"+Ext.getCmp("updateorginunittype").getValue()+"',Orginaddress:'"+Ext.getCmp("updateorginaddress").getValue+"',Orginzipcode:'"+Ext.getCmp("updateorginzipcode").getValue+"',orginistemporary:'"+Ext.getCmp("updateorginistemporary").getValue()+"',orgintemporaycertificate:'"+Ext.getCmp("updateorgintemporaycertificate").getValue()+"',orgintemporaycertificatecode:'"+Ext.getCmp("updateorgintemporaycertificatecode").getValue()+"',username:'"+Ext.getCmp("updateusername").getValue()+"',lintel:'"+Ext.getCmp("updatelintel").getValue()+"',certificateid:"+Ext.getCmp("updatecertificateid").getValue()+",certificatecode:'"+Ext.getCmp("updatecertificatecode").getValue()+"',unittype:"+Ext.getCmp("updateunittype").getValue()+",address:'"+Ext.getCmp("updateaddress").getValue()+"',zipcode:'"+Ext.getCmp("updatezipcode").getValue()+"',istemporary:"+Ext.getCmp("updateistemporary").getValue()+",temporaycertificate:"+livevar+",temporaycertificatecode:'"+Ext.getCmp("updatetemporaycertificatecode").getValue()+"'}"}
                         });
                         }},
                         {text:"取消",handler:function(){Ext.getCmp("changeownerWin").close();}}
                         ]
                         });
			Ynzc.manage.ChangeOwnerEditWin.superclass.initComponent.apply(this,arguments);
		}
});