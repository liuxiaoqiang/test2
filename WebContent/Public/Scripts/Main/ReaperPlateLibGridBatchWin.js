Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReaperPlateLibGridBatchWin=Ext.extend(Ext.Window,{
	id:"reaperplatelibgridbatchwin",
	initComponent:function(){
	Ext.apply(this,{
		title:"填写号牌分配信息",
		id:"checknumberinfo",
		width:400,
		autoScroll:true,
		resizable:false,
		modal:true,
		items:[{
			layout:"form",
			frame:true,
			items:[{
				id:"platehead",
				fieldLabel:"号牌前缀",
	 			xtype:"textfield",
//				readOnly:true,
				anchor:'98%'
			},{
				id:"startnumber",
				fieldLabel:"起始号码",
				xtype:"textfield",
				anchor:'98%'
			},{
				id:"overnumber",
				fieldLabel:"结束号码",
				xtype:"textfield",
				anchor:'98%'
			},{
				id:"checknumberinfo",
				fieldLabel:"分配地区",
				xtype:"plcombo",
				anchor:'98%'
			}]
		}],
		buttons:[{
			text:"提交",
			handler:function(){
			var type="1";
			if(Ext.getCmp("checknumberinfo").getMyValue()==null){
			     Ext.ux.Toast.msg("提示","请选择分配地区！");
			     return;
			}
			Ext.Ajax.request({
			    url:"main/reaperPlate.html?action=updatePlateStutas",
			    method:"post",
			    success:function(resp){
   			 		var result = Ext.util.JSON.decode(resp.responseText);
   			 		if(result.success == true){
   			 			Ext.ux.Toast.msg("提示","分配成功！");  
   			 			Ynzc.manage.dataGrid.getStore().reload();
   			 			Ext.getCmp("reaperplatelibgridbatchwin").close();
   			 		}
				},
				failure:function(){
					Ext.Msg.alert("警告","<font color=red>与服务器通讯失败！</font>");  
				},
				  params:{
					unitid:Ext.getCmp("checknumberinfo").getMyValue(),
					startNumber:Ext.getCmp("startnumber").getValue(),
					overNumber:Ext.getCmp("overnumber").getValue(),
					numberHead:Ext.getCmp("platehead").getValue(),
					type:type
				}
			});
		}
		}]
	});
	Ynzc.manage.ReaperPlateLibGridBatchWin.superclass.initComponent.apply(this,arguments);
	}
});