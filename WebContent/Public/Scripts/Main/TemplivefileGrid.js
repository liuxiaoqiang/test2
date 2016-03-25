Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.TemplivefileGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'templivefilegrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'暂住证类别',
                        sortable:true,
                        dataIndex:"templivefileType"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'templivefileType'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/templiveFile.html?action=getAllListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'templivefilegrid',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                        plugins:new Ext.ux.grid.Search({
                            width:200,
                            iconCls:false
                        }),
                        tbar:[{
                            id:'typeAdd',
                            text:"添加",
                            iconCls:"icon-Add",
                            handler:function(){
                                    new Ext.Window({
                                        id:"typeAddwin",
                                        title:"暂住证类别添加",
                                        modal:true,
                                        height:100,
                                        width:250,
                                        layout:"form",
                                        labelWidth:70,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"txtTemplivefileType",
                                            fieldLabel:"暂住证类别",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("txtTemplivefileType").getValue()==""){
                                                    Ext.ux.Toast.msg("提示","请填写暂住证类别.");
                                                    return;
                                               }
                                               Ext.Ajax.request({
                                                    url:"main/templiveFile.html?action=addTempliveFile",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","暂住证类别添加成功.");
                                                        Ext.getCmp("typeAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        templivefiletype:Ext.getCmp("txtTemplivefileType").getValue()
                                                    }
                                               });
                                        }},{text:"取消",handler:function(){
                                               Ext.getCmp("typeAddwin").close();
                                        }}]
                                    }).show(Ext.getCmp("typeAdd").getEl());
                                }                            
                            },
                            '-',{
                            text:"删除",
                            iconCls:"icon-Del",
                            handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请选中要删除的暂住证类别!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的暂住证类别?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/templiveFile.html?action=delTempliveFile",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的暂住证类别");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        typelist:Ext.util.JSON.encode(rds)
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
                    Ynzc.manage.TemplivefileGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                      this.on("rowdblclick",function(grid,index,event){
                      var record=grid.getStore().getAt(index);
                      //Ext.MessageBox.alert("title","kuangwei");
                      var win= new Ext.Window(
                      {
                       id:"typeUpdatewin",
                       title:"暂住证类别修改",
                       modal:true,
                       height:100,
                       width:260,
                       layout:"form",
                       labelWidth:80,
                       bodyStyle:"padding:5px 5px",
                       items:[{id:"txtUpdateTemplivefileType",fieldLabel:"暂住证类别",xtype:"textfield",anchor:'90%',value:record.data.templivefileType}],
                       buttons:[
                                 {text:"修改",
                                  handler:function()
                                             {
                                             if(Ext.getCmp("txtUpdateTemplivefileType").getValue()==""){ Ext.ux.Toast.msg("提示","请填写暂住证类别.");return;}
                                               Ext.Ajax.request
                                                 ({
                                                  url:"main/templiveFile.html?action=updateTempliveFile",
                                                  method:"post",
                                                  success:function(){Ext.ux.Toast.msg("提示","暂住证类别添加成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},
                                                  failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                                                  params:{id:record.data.id,templivefiletype:Ext.getCmp("txtUpdateTemplivefileType").getValue()}
                                                 });
                                             }
                                 },
                                 {text:"取消",handler:function(){ Ext.getCmp("typeUpdatewin").close(); }}
                      ]
                      }
                      );
                     win.show();
                    });
                }
});
Ext.reg('templivefilegrid',Ynzc.manage.TemplivefileGrid);