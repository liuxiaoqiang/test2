Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.CarTransferGrid = Ext.extend(Ext.TabPanel, {
	id:'cartransfergrid',
	initComponent: function() {
		Ext.apply(this,{
			id:'cartransfergrid',
			activeTab: 0,
			items: [{
				title: '转移登记',
				frame: true,
				xtype:'cartransferwin'
			},{
				title:'待处理转入车辆',
				frame:true,
				xtype:'certransferwaitwin'
			},{
				title:'已完成转移车辆',
				frame:true,
				xtype:'certransferhandlewin'
			}]
		});
		Ynzc.manage.CarTransferGrid.superclass.initComponent.apply(this,arguments);
	}
});
Ext.reg('cartransfergrid', Ynzc.manage.CarTransferGrid);