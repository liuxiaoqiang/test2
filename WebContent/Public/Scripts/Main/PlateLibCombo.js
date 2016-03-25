Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateLibCombo = Ext.extend(Ext.form.ComboBox,{
	selectValue:null,
	initComponent:function(){
	var comboTree=new Ext.tree.TreePanel({
		border : false,
 		loader : new Ext.tree.TreeLoader({
			dataUrl : 'main/unitManage.html?action=getUnitTree'
		}),
		root : new Ext.tree.AsyncTreeNode({
			id:'combroot',
			text : '云南省农机安全监理总站,[<font color=green>双击选择节点</font>]',
			expanded : true
		}),
		listeners:{
			'dblclick':function(node){
				if(node.id=="combroot"){
//					Ext.getCmp("combRegion").setValue("云南省");
//					Ext.getCmp("txtRegionid").setValue("0,");
					Ext.MessageBox.alert("提示","此地区不能选择！");
				}else{
					Ext.getCmp("checknumberinfo").setValue(node.text);
					Ext.getCmp("checknumberinfo").selectValue=node.id;
				}
				Ext.getCmp("checknumberinfo").collapse();
			}
		}
})
		Ext.apply(this,{
			id:"plateunitcombo",
			store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
			editable:false,   
			shadow:false,   
 			mode: 'local',   
    		triggerAction:'all',   
   			maxHeight: 200,   
	   		tpl: '<tpl for="."><div style="height:200px"><div id="combotree"></div></div></tpl>',   
   			selectedClass:'',   
	   		onSelect:Ext.emptyFn
		});
		Ynzc.manage.PlateLibCombo.superclass.initComponent.apply(this,arguments);
		this.on('expand',function(){   
				comboTree.render('combotree'); 
			}); 
	},
	getMyValue:function(){
		return this.selectValue;
	}
});
Ext.reg("plcombo",Ynzc.manage.PlateLibCombo)