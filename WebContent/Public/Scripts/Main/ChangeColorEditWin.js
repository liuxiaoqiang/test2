Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ChangeColorEditWin=Ext.extend(Ext.Window,{
		id:"changecoloreditwin",
		initComponent:function(){
			Ext.apply(this,{
                         id:"changecoloreditwin",
                         title:"修改[变更机身颜色]信息",
                         modal:true,
                         height:380,
                       	 width:330,
                         layout:"form",
                         labelWidth:80,
                         bodyStyle:"padding:5px 5px",
                         items:[
                         {id:"updatephotourl",xtype:"picpanel",defaultPicUrl:"./Public/Images/sys/noupload.gif",
                         actionUrl:"main/tractorInfo.html?action=uploadPic",uploadWinTitle:"拖拉机照片",height:250,width:300},
                         {id:"updateorgincolor",xtype:"textfield",fieldLabel:"原机身颜色",readOnly:true,anchor:'98%'},
                         {id:"updatecuurentcolor",xtype:"textfield",fieldLabel:"现机身颜色",anchor:'98%'}
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
					},{
                         text:"提交",
                         handler:function(){
                         if(Ext.getCmp("updatephotourl").getValue()==null)
                         { Ext.MessageBox.alert("提示","请上传拖拉机图片.");return;}
                         if(Ext.getCmp("updatecuurentcolor").getValue()=="")
                         { Ext.MessageBox.alert("提示","请填写变更颜色.");return;}
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
                         	 Ext.getCmp("changecoloreditwin").close(); 
                             }else{
                             Ext.MessageBox.alert("提示","修改失败.");
                             }
                       		},
                        	 failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                         	 params:{
                         	 type:"变更机身颜色",
                         	updatechangecolor:"{id:"+Ynzc.manage.updatechangecolorid+",carchangeid:"+Ynzc.manage.updatechangeid+",orgincolor:'"+Ext.getCmp("updateorgincolor").getValue()+"',cuurentcolor:'"+Ext.getCmp("updatecuurentcolor").getValue()+"',photourl:'"+Ext.getCmp("updatephotourl").getValue()+"'}"
                         	}
                         });
                         }
                         }
                         ]
                         });
			Ynzc.manage.ChangeColorEditWin.superclass.initComponent.apply(this,arguments);
		}
});