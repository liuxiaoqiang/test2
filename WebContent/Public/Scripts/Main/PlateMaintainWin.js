Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateMaintainWin=Ext.extend(Ext.Window,{
	id:"platemaintainwin",
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
			     Ext.MessageBox.alert("提示","请选择号牌状态！");
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
   			 			Ext.MessageBox.alert("提示","状态修改成功！");  
   			 			Ynzc.manage.dataGrid.getStore().reload();
   			 			Ext.getCmp("platemaintainwin").close();
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
	Ynzc.manage.PlateMaintainWin.superclass.initComponent.apply(this,arguments);
	}
});