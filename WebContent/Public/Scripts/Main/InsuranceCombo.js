Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.InsuranceCombo=Ext.extend(Ext.form.ComboBox,{
			id:'insurancecombo',
			initComponent:function(){
				
				var iReader=new Ext.data.JsonReader({
		            totalProperty:"totalCount",
		            root:"data",
		            autoLoad:true,
		            fields:[{
		                name : 'id'
		            },{
		                name : 'insurancecompanyName'
		            }]
		        });
				
				var iDs=new Ext.data.Store({
		            scopte:this,
		            url:'main/insuranceCompany.html?action=getAllListByPage',
		            reader:iReader,
		            sortInfo:{
		                field:'id',
		                direction:'ASC'
		            }
		        });
		        
				var InsuranceGrid=new Ext.grid.GridPanel({
						 plain:true,
		                 border:false,
		                 width:297,
		                 height:200,
		                 autoScroll:true,
		                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
		                             header:'保险公司',
		                             sortable:true,
		                             dataIndex:"insurancecompanyName"
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
		                 	 	/*var record=grid.getStore().getAt(index);
		                 	 	Ext.getCmp("insurancecompanyname").setValue(record.data.insurancecompanyName);
		                 	 	Ext.getCmp("insurancecompanyname").collapse();*/
		                 		var record=grid.getStore().getAt(index);
		                 	 	this.setValue(record.data.insurancecompanyName);
		                 	 	this.collapse();
		                 	}.createDelegate(this)
		                 }
				});
			
				Ext.apply(this,{
					id:'insurancecombo',
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px"><div id="icombogrid"></div></div></tpl>',   
		   			selectedClass:'',   
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.InsuranceCombo.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
   					InsuranceGrid.render('icombogrid');
  				}); 
  				iDs.load({
					params:{
						start:0,
						limit:5
					}
				});
			}
});
Ext.reg("icombo",Ynzc.manage.InsuranceCombo)