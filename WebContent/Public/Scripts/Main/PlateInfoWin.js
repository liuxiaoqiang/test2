Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateInfoWin=Ext.extend(Ext.Window,{
	id:"plateinfowin",
	initComponent:function(){   
		var pReader = new Ext.data.JsonReader({
			totalProperty:"totalCount",
			root:"data",
			autoLoad:true,
			fields:[{
				name:'id'
			},{
				name:'platenum'
			},{
				name:'platehead'
			},{
				name:'status'
			},{
				name:'unitid'
			}]
		});
	 	var cm=new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
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
			dataIndex:"status",
			renderer:function(value){
			if(value<10){
			if(value==5){return "<font color=blue>报废</font>"};
			if(value==6){return "<font color=blue>补牌</font>"};
			if(value==7){return "<font color=blue>转籍</font>"};}
			else{
				if(parseInt(value/10)==1){return "<font color=blue>市级上报编制中</font>"};
	 			if(parseInt(value/10)==2){return "<font color=blue>市级上报已完成</font>"};
	 			if(parseInt(value/10)==3){return "<font color=blue>省级制作编制中</font>"};
	 			if(parseInt(value/10)==4){return "<font color=blue>省级制作已完成</font>"};
	 			if(parseInt(value/10)==5){return "<font color=blue>省级入库编制中</font>"};
	 			if(parseInt(value/10)==6){return "<font color=blue>省级入库已完成</font>"};
	 			if(parseInt(value/10)==7){return "<font color=blue>市级入库编制中</font>"};
	 			if(parseInt(value/10)==8){return "<font color=blue>市级入库已完成</font>"};
			}
		}
		}])
	 	var pDs = new Ext.data.Store({
			scopte:this,
			url:'main/plate.html?action=getNewPlateList',
			baseParams:{pid:Ynzc.manage.pid},
			reader:pReader,
			sortInfo:{
				field:'platenum',
				direction:'ASC'
			}
		});
	 	
		var plateGrid = new Ext.grid.GridPanel({
			plain:true,
			height:440,
			width:680,
			border:false,
			autoScroll:true,
			cm:cm,
			sm:new Ext.grid.CheckboxSelectionModel(),
			frame:true,
			store:pDs,
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
	             store:pDs,
	             displayInfo:true,
	             displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
	             emptyMsg : '无记录'
	         })
		})

		Ext.apply(this,{
			title:"查看号牌需求",
			iconCls:"icon-Add",
			width:700,
			height:480,
			modal:true,
			resizable:false,
			bodyStyle:"padding 10px 10px",			
			items:[
			       {
			    	   id:"platelabel",
			    	   xtype:"label",
			    	   html:"报废\补领\转籍号牌"
			       },
			plateGrid]
		})
		Ynzc.manage.PlateInfoWin.superclass.initComponent.apply(this,arguments);
		pDs.load({
			params:{
				start:0,
				limit:6,
				pid:Ynzc.manage.pid
			}
		});
	}
});