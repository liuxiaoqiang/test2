Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.ChangeTrailerEditWin=Ext.extend(Ext.Window,{
		id:"changetrailereditwin",
		initComponent:function(){
			Ext.apply(this,{
                         id:"changetrailereditwin",
                         title:"修改[更换挂车]信息",
                         modal:true,
                         height:310,
                       	 width:500,
                         layout:"form",
                         labelWidth:80,
                         bodyStyle:"padding:5px 5px",
                         items:[
                         {id:"updateorginTrailerInfo",title:"原挂车情况",xtype:"fieldset",height:100,layout:"form",
                         items:[
                         {id:"updateorgintires",xtype:"textfield",fieldLabel:"挂车轮胎数",readOnly:true,anchor:'98%'},
                         {id:"updateorgintrack",xtype:"textfield",fieldLabel:"挂车轮距",readOnly:true,anchor:'98%'},
                         {id:"updateorginnorm",xtype:"textfield",fieldLabel:"挂车轮胎规格",readOnly:true,anchor:'98%'}
                         ]},
                         {id:"updatecurrentTrailerInfo",title:"现挂车情况",xtype:"fieldset",height:100,layout:"form",
                         items:[
                         {id:"updatecurrenttires",xtype:"textfield",fieldLabel:"挂车轮胎数",anchor:'98%'},
                         {id:"updatecurrenttrack",xtype:"textfield",fieldLabel:"挂车轮距",anchor:'98%'},
                         {id:"updatecurrentnorm",xtype:"textfield",fieldLabel:"挂车轮胎规格",anchor:'98%'}
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
                          if(Ext.getCmp("updatecurrenttires").getValue()==""){Ext.MessageBox.alert("提示","请填写挂车轮胎数");return;}
                          if(Ext.getCmp("updatecurrenttrack").getValue()==""){Ext.MessageBox.alert("提示","请填写挂车轮距");return;}
                          if(Ext.getCmp("updatecurrentnorm").getValue()==""){Ext.MessageBox.alert("提示","请填写挂车轮轮胎规格");return;}
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
                         	 Ext.getCmp("changetrailereditwin").close(); 
                             }else{
                             Ext.MessageBox.alert("提示","修改失败.");
                             }
                       		},
                         	failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                          params:{
                          type:"更换挂车",
                          updatechangetrailer:"{id:"+Ynzc.manage.updatechangetrailerid+",carchangeid:"+Ynzc.manage.updatechangeid+",orgintires:"+Ext.getCmp("updateorgintires").getValue()+",orgintrack:'"+Ext.getCmp("updateorgintrack").getValue()+"',orginnorm:'"+Ext.getCmp("updateorginnorm").getValue()+"',currenttires:"+Ext.getCmp("updatecurrenttires").getValue()+",currenttrack:'"+Ext.getCmp("updatecurrenttrack").getValue()+"',currentnorm:'"+Ext.getCmp("updatecurrentnorm").getValue()+"'}"
                          }
                          }
                          );
                          }},
                         {text:"取消",handler:function(){ Ext.getCmp("changeTrailerWin").close(); }}
                          ]
                         });
			Ynzc.manage.ChangeTrailerEditWin.superclass.initComponent.apply(this,arguments);
		}
});