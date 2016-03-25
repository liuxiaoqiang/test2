Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.UnitCombo=Ext.extend(Ext.form.ComboBox,{
			selectValue:null,
			gridWidth:370,
			gridHeight:200,
			initComponent:function(){
				
				var unReader=new Ext.data.JsonReader({
		            totalProperty:"totalCount",
		            root:"data",
		            autoLoad:true,
		            fields:[{
		                name : 'id'
		            },{
		                name : 'useunit'
		            }] 
		        });
				
				var unDs=new Ext.data.Store({
		            scopte:this,
		            baseParams:{psid:Ynzc.manage.psid},
		            url:'main/unitManage.html?action=getUnitManageComboList',
		            reader:unReader,
		            sortInfo:{
		                field:'id',
		                direction:'ASC'
		            }
		        });
		        
				var UnitGrid=new Ext.grid.GridPanel({
						 plain:true,
		                 border:false,
		                 width:this.gridWidth,
		                 height:this.gridHeight,
		                 autoScroll:true,
		                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
		                             header:'使用单位',
		                             sortable:true,
		                             dataIndex:"useunit"
		                 }]),
		                 sm:new Ext.grid.CheckboxSelectionModel(),
		                 frame:true,
		                 store:unDs,
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
		                     store:unDs,
		                     displayInfo:true,
		                     displayMsg : '共 {2} 条',
		                     emptyMsg : '无记录'
		                 }),
		                 listeners:{
		                 	"rowdblclick":function(grid,index,event){
		                 	 	var record=grid.getStore().getAt(index);
		                 	 	this.setValue(record.data.useunit);
		                 	 	this.selectValue=record.data.id;
		                 	 	this.collapse();
		                 	}.createDelegate(this)
		                 }
				});
			
				Ext.apply(this,{
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px;width:auto"><div id="'+this.id+'comboDiv"></div></div></tpl>',   
		   			selectedClass:'',
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.UnitCombo.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
					UnitGrid.render(this.id+"comboDiv");
  				}); 
  				unDs.load({
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
					url:"main/unitManage.html?action=findRecordById",
					success:function(response){
						record=Ext.util.JSON.decode(response.responseText);
						if(record!==null){
							this.setValue(record.useunit);
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
Ext.reg("uncombo",Ynzc.manage.UnitCombo)