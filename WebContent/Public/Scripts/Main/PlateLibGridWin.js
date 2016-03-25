Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateLibGridWin=Ext.extend(Ext.Window,{
	id:"platelibgridwin",
	initComponent:function(){
	Ext.apply(this,{
		title:"选择号牌分配地区",
		id:"checknumber",
		width:400,
		autoScroll:true,
		resizable:false,
		modal:true,
		items:[{
			layout:"form",
			frame:true,
			items:[{
				id:"checknumberinfo",
				fieldLabel:"分配地区",
				xtype:"plcombo",
				anchor:'98%'
			}]
		}],
		buttons:[{
	 		text:"提交",
			handler:function(){
			var type="0";
			if(Ext.getCmp("checknumberinfo").getMyValue()==null){
			     Ext.MessageBox.alert("提示","请选择分配地区！");
			     return;
			}
				                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在处理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
			Ext.Ajax.request({
			    url:"main/plate.html?action=updatePlateStutas",
			    method:"post",
			    success:function(resp){
			    mask.hide();
			 		var result = Ext.util.JSON.decode(resp.responseText);
			 		if(result.success == true){
			 			Ext.MessageBox.alert("提示","分配成功！");  
			 			Ynzc.manage.dataGrid.getStore().reload();
			 			Ext.getCmp("platelibgridwin").close();
			 		}
				},
				failure:function(){
					Ext.Msg.alert("警告","<font color=red>与服务器通讯失败！</font>");  
				},
				  params:{
					dellist:Ext.util.JSON.encode(Ynzc.manage.rds),
					unitid:Ext.getCmp("checknumberinfo").getMyValue(),
					type:type
				}
			});
		}
		}]
	});
	Ynzc.manage.PlateLibGridWin.superclass.initComponent.apply(this,arguments);
	}
});