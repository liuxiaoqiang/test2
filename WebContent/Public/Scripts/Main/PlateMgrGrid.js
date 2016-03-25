Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.PlateMgrGrid = Ext.extend(Ext.TabPanel, {
	id:'platemgrgrid',
	initComponent: function() {
		Ext.apply(this,{
			id:'platemgrgrid',
			activeTab: 0,
			items: [{
				title:'号牌制作',
				frame:true,
				xtype:'platemgrmadewin'
			},{
				title:'号牌入库',
				frame:true,
				xtype:'platemgrinwin'
			},{
				title:'号牌分配',
				frame:true,
				xtype:'platemgrdiswin'
			}]
		});
		Ynzc.manage.PlateMgrGrid.superclass.initComponent.apply(this,arguments);
	}
});
Ext.reg('platemgrgrid', Ynzc.manage.PlateMgrGrid);