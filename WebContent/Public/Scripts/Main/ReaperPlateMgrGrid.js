Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReaperPlateMgrGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'reaperplatemgrgrid',
                initComponent:function(){

                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'上报时间',
                        sortable:true,
                        dataIndex:"submitdate",
                        renderer:function(value){
                        	value=new Date(value.time).format('Y-m-d');
                        	return value;
                        }
                    },{ 
                        header:'上报人',
                        sortable:true,
                        dataIndex:"submitman"
                    },{
                        header:'制作经手人',
                        sortable:true,
                        dataIndex:"provinceinputman",
                        renderer:function(value){
                    		if(value===null||value===""){
                    			return "<font color=blue>还未记录</font>"
                    		}else{
                    			return value;
                    		}
                    	}
                    },{
                        header:'入库时间',
                        sortable:true,
                        dataIndex:"provinputtime",
                        renderer:function(value){
	                		if(value===null||value===""){
	                			return "<font color=blue>还未入库</font>"
	                		}else{
                    			return new Date(value.time).format('Y-m-d');
                    		}
                		}
                    },{
                        header:'状态',
                        sortable:true,
                        dataIndex:"status",
                        renderer:function(value){
                        	if(value==1){return "<font color=blue>待制作</font>"}
                        	if(value==2){return "<font color=green>已完成</font>"}
                        }
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'submitdate'
                        },{
                            name : 'cityinputman'
                        },{
                            name : 'cityinputtime'
                        },{
                            name : 'provinceinputman'
                        },{
                            name : 'provinputtime'
                        },{
                            name : 'submitman'
                        },{
                            name : 'status'
                        },{
                        	name : 'unitid'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/reaperPlate.html?action=getSubmitListWaitMade',
                        reader:reader,
                        sortInfo:{
                            field:'status',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'reaperplatemgrgrid',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                        tbar:[{
                        	id:"CheckMadeBtn",
                        	text:"查看制作需求",
                        	iconCls:"icon-Search",
                        	handler:function(){
                        		var selections=this.selModel.getSelections();
                                var n=selections.length;
                                if(n==0){
                                    Ext.ux.Toast.msg("提示","请选中要查看或添加的批次!");
                                    return;
                                }
                                if(n>1){
                                	Ext.ux.Toast.msg("提示","每次只能处理一个批次!");
                                    return;
                                }
                                var record=selections[0].data;
                                Ynzc.manage.psid=record.id;
                                Ynzc.manage.status=record.status;
                                Ynzc.manage.unitid=record.unitid;
                        		new Ynzc.manage.ReaperPlateMadeWin().show(Ext.getCmp("CheckMadeBtn").getEl());
                        	}.createDelegate(this)
                        },{
                        	text:"删除有误的批次",
                        	iconCls:"icon-del",
                        	handler:function(){
                        		var selections=this.selModel.getSelections();
                                var n=selections.length;
                                if(n==0){
                                    Ext.ux.Toast.msg("提示","请选中要删除的批次!");
                                    return;
                                }
                                var rds=[];
                                for(i=0;i<n;i++){
                                	if(selections[i].data.status==1){
                                      rds.push(selections[i].data);
                                    }else{
                                      Ext.ux.Toast.msg("提示","部分记录已处理完成，不能删除");
                                    }
                                }
                            	Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的批次?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/reaperPlate.html?action=delBat",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除可以删除的批次");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                    	dellist:Ext.util.JSON.encode(rds)
                                                    }
                                                });
                                            }
                                        }
                                });   
                        	}.createDelegate(this)
                        },{
                        	text:"分配",
                        	iconCls:"icon-complate",
                        	handler:function(){
                        		var selections=this.selModel.getSelections();
                        		var n=selections.length;
                        		if(n==0){
                        			Ext.ux.Toast.msg("提示","请选中要分配的批次!");
                        			return;
                        		}
                        		var rds=[];
                        		for(i=0;i<n;i++){
                        			if(selections[i].data.status==1){
                        				rds.push(selections[i].data);
                        			}else{
                        				Ext.ux.Toast.msg("提示","部分记录已处理完成，不能分配");
                        			}
                        		}
                        		Ext.Msg.show({
                                    title:'系统确认',
                                    msg:'你是否确认分配选中的批次?',
                                    buttons:Ext.Msg.YESNO,
                                    scope:this,
                                    icon : Ext.MessageBox.QUESTION,
                                    fn:function(btn){
                                        if(btn=="yes"){
                                            Ext.Ajax.request({
                                                url:"main/reaperPlate.html?action=allotPlate",
                                                method:"post",
                                                success:function(){
                                                    Ext.ux.Toast.msg("提示","已成功分配选中的批次！");
                                                    ds.reload();
                                                },
                                                faliure:function(){
                                                    Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                },
                                                params:{
                                                	dellist:Ext.util.JSON.encode(rds)
                                                }
                                            });
                                        }
                                    }
                            });  
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
                    Ynzc.manage.ReaperPlateMgrGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                }
});
Ext.reg('reaperplatemgrgrid',Ynzc.manage.ReaperPlateMgrGrid);