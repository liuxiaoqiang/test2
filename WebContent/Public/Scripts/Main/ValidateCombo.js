Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ValidateCombo=Ext.extend(Ext.form.ComboBox,{
			id:'validatecombo',
			selectValue:null,
			initComponent:function(){
				
				var vReader=new Ext.data.JsonReader({
		            totalProperty:"totalCount",
		            root:"data",
		            autoLoad:true,
		            fields:[{
		                name : 'id'
		            },{
		                name : 'dirNo'
		            },{
		                name : 'registerDate'
		            },{
		                name : 'machineType'
	 	            },{
		                name : 'machineNo'
		            },{
		                name : 'productor'
		            },{
		                name : 'carColor'
		            },{
		                name : 'license'
		            },{
		                name : 'productorAddress'
		            },{
		                name : 'productorPost'
		            },{
		                name : 'productorSeller'
		            },{
		                name : 'productorTel'
		            },{
		                name : 'sellerTelephone'
		            },{
		                name : 'photoDir'
		            },{
		                name : 'setRow'
		            },{
		                name : 'isAuto'
		            },{
		                name : 'shapeSize'
		            },{
		                name : 'containerSize'
		            },{
		                name : 'axisSize'
		            },{
		                name : 'power'
		            },{
		                name : 'wheelSize'
		            },{
		                name : 'drivers'
		            },{
		                name : 'directControl'
		            },{
		                name : 'topSpeed'
		            },{
		                name : 'fuelTypeId'
		            },{
		                name : 'fuelCost'
		            },{
		                name : 'wheelNo'
		            },{
		                name : 'allQuality'
		            },{
		                name : 'tiresSize'
		            },{
		                name : 'totalQuality'
		            },{
		                name : 'loadQuality'
		            },{
		                name : 'driverInNo'
		            },{
		                name : 'tilt'
		            },{
		                name : 'engineBrandId'
		            },{
		                name : 'steelSpring'
		            }]
		        });
				
				var vDs=new Ext.data.Store({
		            scopte:this,
		            url:'main/validateList.html?action=getValidateList',
		            reader:vReader,
		            sortInfo:{
		                field:'id',
		                direction:'ASC'
		            }
		        });
		        
				var ValidateGrid=new Ext.grid.GridPanel({
						 id:"vdgrid",
						 plain:true,
		                 border:false,
		                 width:564,
		                 height:200,
		                 autoScroll:true,
		                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
								header:'厂牌型号',
								sortable:true,
								dataIndex:"machineType"
						 },{
								header:'厂牌识别号',
								sortable:true,
								hidden:false,
								dataIndex:"machineNo"
						 }]),
		                 sm:new Ext.grid.CheckboxSelectionModel(),
		                 frame:true,
		                 store:vDs,
		                 loadMask:true,
		                 viewConfig:{
		                     forceFit:true
		                 },
		                 plugins:new Ext.ux.grid.Search({
		                            width:200,
		                            iconCls:false
		                        }),
		                 tbar:[],
		                 bbar:new Ext.PagingToolbar({
		                     pageSize:5,
		                     store:vDs,
		                     displayInfo:false,
		                     displayMsg : '共 {2} 条',
		                     emptyMsg : '无记录'
		                 }),
		                 listeners:{
		                 	"rowdblclick":function(grid,index,event){
		                 	 	var record=grid.getStore().getAt(index);
		                 	 	this.setMyValue(record.data.id);
		                 	 	
		                 	 	Ext.getCmp("machinebodycolor").setValue(record.data.carColor);
	                            Ext.getCmp("outsize").setValue(record.data.shapeSize);
	                            Ext.getCmp("containersize").setValue(record.data.containerSize);
	                            Ext.getCmp("wheelbase").setValue(record.data.axisSize);
	                            Ext.getCmp("power").setValue(record.data.power);
	                            Ext.getCmp("wheeldis").setValue(record.data.wheelSize);
	                            Ext.getCmp("directcontrol").setValue(record.data.directControl);
	                            Ext.getCmp("fueltypeid").setValue(record.data.fuelTypeId);
	                            Ext.getCmp("tiresno").setValue(record.data.wheelNo);
	                            Ext.getCmp("allquality").setValue(record.data.allQuality);
	                            Ext.getCmp("tiressize").setValue(record.data.tiresSize);
	                            Ext.getCmp("totalquality").setValue(record.data.totalQuality);
	                            Ext.getCmp("ratifiedload").setValue(record.data.loadQuality);
	                            Ext.getCmp("driverinno").setValue(record.data.driverInNo);
	                            Ext.getCmp("enginebrandid").setMyValue(record.data.engineBrandId);
	                            Ext.getCmp("steelspring").setValue(record.data.steelSpring);
	                            
		                 	 	this.selectValue=record.data.id;
		                 	 	this.collapse();
		                 	}.createDelegate(this)
		                 }
				});
			
				Ext.apply(this,{
					id:'validatecombo',
					store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	 				editable:false,   
  					shadow:false,   
		 			mode: 'local',   
		    		triggerAction:'all',   
		   			maxHeight: 200,   
			   		tpl: '<tpl for="."><div style="height:200px"><div id="vcombogrid"></div></div></tpl>',   
		   			selectedClass:'',   
			   		onSelect:Ext.emptyFn
				});
				Ynzc.manage.ValidateCombo.superclass.initComponent.apply(this,arguments);
				this.on('expand',function(){   
   					ValidateGrid.render('vcombogrid');
  				}); 
  				vDs.load({
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
					url:"main/validateList.html?action=findRecordById",
					success:function(response){
						record=Ext.util.JSON.decode(response.responseText);
						if(record!==null){
							this.setValue(record.machineType);
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
Ext.reg("vcombo",Ynzc.manage.ValidateCombo)