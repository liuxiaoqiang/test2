Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateCombo=Ext.extend(Ext.form.ComboBox,{
			id:'platecombo',
			initComponent:function(){
				
				var iReader=new Ext.data.JsonReader({
		            totalProperty:"totalCount",
		            root:"data",
		            autoLoad:true,
		            fields:[{
		                name : 'id'
		            },{
		                name : 'platenum'
		            },{
		            	name:  'platehead'
		            }] 
		        });
				
				var iDs=new Ext.data.Store({
		            scopte:this,
		            url:'main/plate.html?action=getPlateStatusInfo',
		            reader:iReader,
		            sortInfo:{
		                field:'id',
		                direction:'ASC'
		            }
		        });
		        
				var InsuranceGrid=new Ext.grid.GridPanel({
						 plain:true,
		                 border:false,
		                 width:226,
		                 height:199,
		                 autoScroll:true,
		                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
		                	 header:'号牌号码',
		                	 sortable:true,
		                	 dataIndex:"platenum",
		                	 renderer:function(value,meta,record){
		                	 value=record.data.platehead+"."+value;
		                	 return value;
		                 	}
		                 }]),
		                 sm:new Ext.grid.CheckboxSelectionModel(),
		                 frame:true,
		                 store:iDs,
		                 loadMask:true,
		                 viewConfig:{
		                     forceFit:true
		                 },
		                 plugins:new Ext.ux.grid.Search({
		                            width:120,
		                            iconCls:false
		                        }),
		                 tbar:[],
		                 bbar:new Ext.PagingToolbar({
		                     pageSize:5,
		                     store:iDs,
		                     displayInfo:false,
		                     displayMsg : '共 {2} 条',
		                     emptyMsg : '无记录'
		                 }),
		                 listeners:{
		                 	"rowdblclick":function(grid,index,event){
		                 	 	var record=grid.getStore().getAt(index);
		                 	 	Ext.getCmp("license").setValue(record.data.platehead+"."+record.data.platenum);
		                 	 	Ext.getCmp("license").collapse();
		                 	}
		                 }
				});
			
				Ext.apply(this,{
					id:'platecombo',
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px"><div id="pcombogrid"></div></div></tpl>',   
		   			selectedClass:'',   
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.PlateCombo.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
   					InsuranceGrid.render('pcombogrid');
  				}); 
  				iDs.load({
					params:{
						start:0,
						limit:5
					}
				});
			}
});
Ext.reg("platecombo",Ynzc.manage.PlateCombo)