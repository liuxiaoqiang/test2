Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.PlateGrid = Ext.extend(Ext.TabPanel, {
	id:'plategrid',
	initComponent: function() {
		Ext.apply(this,{
			id:'plategrid',
			activeTab: 0,
			items: [{
				title: '上报号牌',
				frame: true,
				xtype:'plateupwin'
			},{
				title:'号牌入库',
				frame:true,
				xtype:'plateinwin'
			},{
				title:'号牌分配',
				frame:true,
				xtype:'platediswin'
			}]
		});
		Ynzc.manage.PlateGrid.superclass.initComponent.apply(this,arguments);
	}
});
Ext.reg('plategrid', Ynzc.manage.PlateGrid);