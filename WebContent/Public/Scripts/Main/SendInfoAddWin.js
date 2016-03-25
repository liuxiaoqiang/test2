Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.SendInfoAdd=Ext.extend(Ext.Window,{
	id:'sendinfoadd',
	initComponent:function(){
		Ext.apply(this,{
			title:'信息发布',
			id:'sendinfoadd',
			width:650,
			modal:true,
			height:450,
			layout:'form',
			labelWidth:60,
			bodyStyle:'padding: 10px,10px,5px,10px',
			items:[{
				xtype:'combo',
				id:'infoType',
				fieldLabel:'信息类别',
	 			emptyText:'请选择信息类别',
				displayField:'types',
				editable:false,
				mode:'local',
				triggerAction:'all',
				store:new Ext.data.SimpleStore({
					fields:['types'],
					data:[['在线交流'],['最新公告']],
					autoload:true
				})
			},{
				xtype:'textfield',
				id:'infoTitle',
				fieldLabel:'信息标题',
				emptyText:'请输入信息标题'
			},{
				xtype:'htmleditor',
				fieldLabel:'信息内容',
				id:'infoContent'
			}],
			buttons:[{
				text:'保存',
				handler:function(){
					if(Ext.getCmp("infoType").getValue()==""){Ext.ux.Toast.msg("提示","请选择信息类型！");return}
					if(Ext.getCmp("infoTitle").getValue()==""){Ext.ux.Toast.msg("提示","请填写信息标题！");return}
					if(Ext.getCmp("infoContent").getValue()==""){Ext.ux.Toast.msg("提示","消息正文不能为空哦！");return}
					Ext.Ajax.request({
						url:'main/sendInfo.html?action=addSendInfo',
						success:function(){
							Ext.ux.Toast.msg("提示","消息增加成功！");
							Ext.getCmp("sendMgr").getStore().reload();
							Ext.getCmp("sendinfoadd").close();
						},
						params:{
							type:Ext.getCmp("infoType").getValue(),
							title:Ext.getCmp("infoTitle").getValue(),
							content:Ext.getCmp("infoContent").getValue(),
							replayId:0
						}
					});
				}
			},{
				text:'取消',
				handler:function(){
					Ext.getCmp("sendinfoadd").close();
				}
			}]
		});
		Ynzc.manage.SendInfoAdd.superclass.initComponent.apply(this,arguments);
	}
});