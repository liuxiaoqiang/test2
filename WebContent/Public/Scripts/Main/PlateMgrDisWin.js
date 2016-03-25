Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateMgrDisWin=Ext.extend(Ext.grid.GridPanel,{
                id:'platemgrdiswin',
                initComponent:function(){

                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'所在市',
                        sortable:true,
                        dataIndex:"region"
                    },{ 
                        header:'未用号牌',
                        sortable:true,
                        dataIndex:"notuseplate"
                    },{
                        header:'已用号牌',
                        sortable:true,
                        dataIndex:"usedplate"
                    },{
                        header:'报废号牌',
                        sortable:true,
                        dataIndex:"bfplate"
                    },{
                        header:'补牌号牌',
                        sortable:true,
                        dataIndex:"bpplate"
                    },{
                        header:'转籍号牌',
                        sortable:true,
                        dataIndex:"zjplate"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'region'
                        },{
                            name : 'platecode'
                        },{
                            name : 'notuseplate'
                        },{
                            name : 'usedplate'
                        },{
                            name : 'bfplate'
                        },{
                            name : 'bpplate'
                        },{
                            name : 'zjplate'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/plate.html?action=getUnitPlate',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'platemgrdiswin',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                        tbar:[{
                        	text:"分配",
                        	iconCls:"icon-complate",
                        	handler:function(){
                        		var selections=this.selModel.getSelections();
                        		var n=selections.length;
                        		if(n==0){
                        			Ext.MessageBox.alert("提示","请选中要分配的市级单位!");
                        			return;
                        		}
                        		if(n>1){
				                	Ext.MessageBox.alert("提示","每次只能处理一个批次!");
				                    return;
				                }
                        		var record=selections[0].data;
                        		Ynzc.manage.pid="省分";
			                	Ynzc.manage.status=3;
			                	Ynzc.manage.unitid=record.id;
			                	Ynzc.manage.platecode=record.platecode;
			                	Ynzc.manage.winid='platemgrdiswin';
			                	new Ynzc.manage.PlateWin().show(Ext.getCmp("addPlateBtn").getEl());
                        	}.createDelegate(this)
                        }],
                        bbar:new Ext.PagingToolbar({
                            pageSize:20,
                            store:ds,
                            displayInfo:true,
                            displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                            emptyMsg : '无记录'
                        }),
                        viewConfig:{
                            forceFit:true
                        }
                    });
                    Ynzc.manage.PlateMgrDisWin.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                }
});
Ext.reg('platemgrdiswin',Ynzc.manage.PlateMgrDisWin);