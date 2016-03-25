Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.PeopleInfoCombo=Ext.extend(Ext.form.ComboBox,{
	id:'peopleinfocombo',
	selectValue:null,
	initComponent:function(){
		var ebReader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'peopleName'
            },{
                name : 'bodyInfoId'
            }]
        });
		
		var ebDs=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.psid},
            url:'main/peopleInfo.html?action=getPeopleInfoToSelect',
            reader:ebReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
        
		var PeopleInfoGrid=new Ext.grid.GridPanel({
			 id:"ebgrid",
			 plain:true,
             border:false,
             width:470,
             height:200,
             autoScroll:true,
             cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                 header:'人员名称',
                 sortable:true,
                 dataIndex:"peopleName"
             },{
                 header:'录入状态',
                 sortable:true,
                 dataIndex:"bodyInfoId",
                 renderer:function(value){
	 	        	if(value > 0){
	 	        		return "已录入";
	 	        	}else{
	 	        		return "未录入";
	 	        	}
         		}
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
             listeners:{"rowdblclick":function(grid,index,event){
         	 	var record=grid.getStore().getAt(index);
         	 	this.setValue(record.data.peopleName);
         	 	this.selectValue = record.data.id;
         	 	this.collapse();
             }.createDelegate(this)
             }});
	
		Ext.apply(this,{
			id:'peopleinfocombo',
			store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
			editable:false,   
			shadow:false,   
 			mode: 'local',   
    		triggerAction:'all',   
   			maxHeight: 200,   
	   		tpl: '<tpl for="."><div style="height:200px"><div id="peopleinfogrid"></div></div></tpl>',   
   			selectedClass:'',   
	   		onSelect:Ext.emptyFn
		});
		Ynzc.manage.PeopleInfoCombo.superclass.initComponent.apply(this,arguments);
		this.on('expand',function(){   
			PeopleInfoGrid.render('peopleinfogrid');
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
			url:"main/peopleInfo.html?action=findPeopleInfoById",
			success:function(response){
				record=Ext.util.JSON.decode(response.responseText);
				if(record!==null){
					this.setValue(record.peopleName);
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
Ext.reg("peopleinfocombo",Ynzc.manage.PeopleInfoCombo)