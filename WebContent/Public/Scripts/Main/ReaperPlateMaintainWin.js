Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReaperPlateMaintainWin=Ext.extend(Ext.Window,{
	id:"reaperplatemaintainwin",
	initComponent:function(){
	Ext.apply(this,{
		title:"号牌维护",
		id:"platemaintain",
		width:280,
		autoScroll:true,
		resizable:false,
		modal:true,
		items:[{
			layout:"form",
			frame:true,
			items:[{
				id:"plateNumber",
				fieldLabel:"号牌号码",
				xtype:"textfield",
				anchor:'98%'
			},{ 
				id:"plateStatus",
				fieldLabel:"选择号牌状态",
				xtype:"combo",
				displayField : 'displayvalue',
				valueField : 'value',
				typeAhead : true,
				mode : 'local',
				editable:false,
				selectOnFoucs : true,
				triggerAction : 'all',
				store:Ynzc.manage.MaintainStore,
				emptyText:"选择号牌状态",
				anchor:'98%'
			}]
		}],
		buttons:[{
			text:"提交",
			handler:function(){
			var type="2";
			if(Ext.getCmp("plateStatus").getValue()===""){
			     Ext.ux.Toast.msg("提示","请选择号牌状态！");
			     return;
			}
			Ext.Ajax.request({
			    url:"main/reaperPlate.html?action=updatePlateStutas",
			    method:"post",
			    success:function(resp){
   			 		var result = Ext.util.JSON.decode(resp.responseText);
   			 		if(result.success == true){
   			 			Ext.ux.Toast.msg("提示","状态修改成功！");  
   			 			Ynzc.manage.dataGrid.getStore().reload();
   			 			Ext.getCmp("reaperplatemaintainwin").close();
   			 		}
				},
				failure:function(){
					Ext.Msg.alert("警告","<font color=red>与服务器通讯失败！</font>");  
				},
				  params:{
					dellist:Ext.util.JSON.encode(Ynzc.manage.rds),
					status:Ext.getCmp("plateStatus").getValue(),
					type:type
				}
			});
		}
		}]
	});
	Ynzc.manage.ReaperPlateMaintainWin.superclass.initComponent.apply(this,arguments);
	}
});