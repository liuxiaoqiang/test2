Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.EngineBrandCombo=Ext.extend(Ext.form.ComboBox,{
			id:'enginecombo',
			selectValue:null,
			initComponent:function(){
				
				var ebReader=new Ext.data.JsonReader({
		            totalProperty:"totalCount",
		            root:"data",
		            autoLoad:true,
		            fields:[{
		                name : 'id'
		            },{
		                name : 'engineBrand'
		            }]
		        });
				
				var ebDs=new Ext.data.Store({
		            scopte:this,
		            baseParams:{psid:Ynzc.manage.psid},
		            url:'main/engineBrand.html?action=getAllListByPage',
		            reader:ebReader,
		            sortInfo:{
		                field:'id',
		                direction:'ASC'
		            }
		        });
		        
				var EngineBrandGrid=new Ext.grid.GridPanel({
						 id:"ebgrid",
						 plain:true,
		                 border:false,
		                 width:370,
		                 height:200,
		                 autoScroll:true,
		                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
		                             header:'发动机品牌',
		                             sortable:true,
		                             dataIndex:"engineBrand"
		                 }]),
		                 sm:new Ext.grid.CheckboxSelectionModel(),
		                 frame:true,
		                 store:ebDs,
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
		                     store:ebDs,
		                     displayInfo:true,
		                     displayMsg : '共 {2} 条',
		                     emptyMsg : '无记录'
		                 }),
		                 listeners:{
		                 	"rowdblclick":function(grid,index,event){
		                 	 	var record=grid.getStore().getAt(index);
		                 	 	this.setValue(record.data.engineBrand);
		                 	 	this.selectValue=record.data.id;
		                 	 	this.collapse();
		                 	}.createDelegate(this)
		                 }
				});
			
				Ext.apply(this,{
					id:'enginecombo',
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px"><div id="ebcombogrid"></div></div></tpl>',   
		   			selectedClass:'',   
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.EngineBrandCombo.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
   					EngineBrandGrid.render('ebcombogrid');
  				}); 
  				ebDs.load({
					params:{
						start:0,
						limit:5
					}
				});
			},
			setMyValue:function(v){
				if(this.emptyText && this.el && v !== undefined && v !== null && v !== ''){
					this.el.removeClass(this.emptyClass);
				}
				var record=null;
				Ext.Ajax.request({
					url:"main/engineBrand.html?action=findRecordById",
					success:function(response){
						record=Ext.util.JSON.decode(response.responseText);
						if(record!==null){
							this.setValue(record.engineBrand);
							this.selectValue=v;
						}
					}.createDelegate(this),
					failure:function(){
						return null;
					},
					params:{
						id:v
					}
				});
			},
			getMyValue:function(){
				return this.selectValue;
			}
});
Ext.reg("ebcombo",Ynzc.manage.EngineBrandCombo)