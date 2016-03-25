Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateSubmitChangeWin=Ext.extend(Ext.Window,{
	id:"platesubmitchangewin",
	initComponent:function(){    
		
		var npReader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'platenum'
             },{
                name : 'platenumhead'
            },{
                name : 'psid'
            },{
            	name : 'madestatus'
            }]
        });
		
		var npDs=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.cpsid,status:Ynzc.manage.cstatus},
            url:'main/plate.html?action=getNewChangePlateList',
            reader:npReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
		
		var newPlateGrid=new Ext.grid.GridPanel({
				 plain:true,
				 height:200,
				 width:686,
                 border:false,
                 autoScroll:true,
                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                             header:'号牌号码',
                             sortable:true,
                             dataIndex:"platenum",
                             renderer:function(value){
                             	value=PlateNumHead+"."+value;
                             	return value;
                             }
                 },{
		         			 header:'状态',
		                     sortable:true,
		                     dataIndex:"madestatus",
		                     renderer:function(value){                	        
		                     	if(value==0){return "<font color=blue>待制作</font>"};
		                     	if(value==1){return "<font color=blue>正在制作中..</font>"};
		                     	if(value==2){return "<font color=red>不制作</font>"};
		                     	if(value==3){return "<font color=blue>省级已入库待分配</font>"};
		                     	if(value==4){return "<font color=darkred>该号牌已经存在，不能重复制作.</font>"};
		                     	if(value==5){return "<font color=blue>省级已分配待入库</font>"};
		                    	if(value==6){return "<font color=green>已入库</font>"};
		                    	if(value==7){return "<font color=blue>待补牌</font>"};
		                     }
		         }]),
                 sm:new Ext.grid.CheckboxSelectionModel(),
                 frame:true,
                 store:npDs,
                 loadMask:true,
                 viewConfig:{
                     forceFit:true
                 },
                 plugins:new Ext.ux.grid.Search({
                            width:120,
                            iconCls:false,
                            position:"bottom"
                        }),
                 bbar:new Ext.PagingToolbar({
                     pageSize:6,
                     store:npDs,
                     displayInfo:true,
                     displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                     emptyMsg : '无记录'
                 })
		})
	
		Ext.apply(this,{
			title:"查看新的补牌号牌需求",
			iconCls:"icon-Add",
			width:700,
			height:250,
			modal:true,
			resizable:false,
			bodyStyle:"padding 10px 10px",			
			items:[{
				xtype:"label",
				html:"需要制作的补牌号牌:"
			},newPlateGrid]
		})
		Ynzc.manage.PlateSubmitChangeWin.superclass.initComponent.apply(this,arguments);
		npDs.load({
			params:{
				start:0,
				limit:6
			}
		});
	}
});