Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.SendInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'listInfo',
	initComponent:function(){
		 var sm=new Ext.grid.CheckboxSelectionModel();
		 var fm=Ext.form;
		 var reco=null;
		 var reader=new Ext.data.JsonReader({
                        totalProperty:"InfototalCount",
                        root:"sendInfo",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'replyId'
                        },{
                            name : 'sendContent'
                        },{
                            name : 'sendDate'
                        },{
                             name : 'sendUserId'
                        },{
                            name : 'sendUserName'
                        },{
                            name : 'title'
                        },{
                            name : 'type'
                        }]
        });
		var store=new Ext.data.Store({
            scopte:this,
            url:'main/sendInfo.html?action=getSendInforList',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
        var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'类别',
                        sortable:true,
                        dataIndex:"type"
                    },{
                        header:'标题',
                        sortable:true,
                        dataIndex:"title"
                    },{
                        header:'发布时间',
                        sortable:true,
                        dataIndex:"sendDate",
                        renderer:function(value){
                        	value=new Date(value.time).format('Y-m-d');
                        	return value;
                        }
                    }]);
         Ext.apply(this,{
          		id:'listInfo',
          		plain:true,
                layout:'fit',
                border:false,
                cm:cm,
                sm:sm,
                frame:true,
                store:store,
                loadMask:true,
                tbar:[{
                	text:'添加',
                	id:'sendInfomationAdd',
                	iconCls:'icon-msgadd',
                	handler:function(){
                		var sendInfoAdd=new Ynzc.manage.SendInfoAdd();
                		sendInfoAdd.show(Ext.getCmp("sendInfomationAdd").getEl());
                	}
                },'-',{
                	text:'删除',
                	id:'sendInfomationDel',
                	iconCls:'icon-msgdel',
                	handler:function(){
						var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.ux.Toast.msg("提示","请选中要删除的信息!");
                            return;
                        }
                        var rds=[];
                        for(i=0;i<n;i++){
                            rds.push(selections[i].data);
                        }
                		Ext.MessageBox.confirm("删除确认","您确定要删除该条记录么？",function(btn){
                			if(btn=="yes"){
								Ext.Ajax.request({
									url:'main/sendInfo.html?action=delSendInfo',
									success:function(){
										Ext.ux.Toast.msg("提示","记录删除成功！");
										store.load({
					                        params:{
					                            start:0,
					                            limit:20
					                        }
					                    });
					                    reco=null;
									},
									params:{
										rds:Ext.util.JSON.encode(rds)
									}
								});
                			}
                		});
                	}.createDelegate(this)
                }],
                bbar:new Ext.PagingToolbar({
                            pageSize:20,
                            store:store,
                            displayInfo:true,
                            displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                            emptyMsg : '无记录'
                        }),
                viewConfig:{
                    forceFit:true
                }
          });
          Ynzc.manage.SendInfoGrid.superclass.initComponent.apply(this,arguments);
          store.load({
                        params:{
                            start:0,
                            limit:20
                      }
          });
          this.on("rowdblclick",function(grid,index,event){
          		var record=grid.getStore().getAt(index);
          		new Ynzc.manage.SendInfoUpdate().show(grid.getEl());
          		Ynzc.manage.SendInfoGridId=record.get("id");
                Ext.getCmp("infoTypeLook").setValue(record.get("type"));
                Ext.getCmp("infoTitleLook").setValue(record.get("title"));
                Ext.getCmp("infoContentLook").setValue(record.get("sendContent"));
                Ext.getCmp("sendNameLook").setValue(record.get("sendUserName"));
                var updateexpirydate=new Date(record.get("sendDate").time).format('Y-m-d');
                Ext.getCmp("sendDateLook").setValue(updateexpirydate);
          });
          this.on("rowclick",function(grid,index,event){
          		reco=grid.getStore().getAt(index);
          });
	}
});
Ext.reg('sendinfogrid',Ynzc.manage.SendInfoGrid);