Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ImportsFileGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'importsfilegrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'进口凭证',
                        sortable:true,
                        dataIndex:"importsFileType"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'importsFileType'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/importsFile.html?action=getAllListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'importsfilegrid',
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
                                        title:"进口凭证添加",
                                        modal:true,
                                        height:100,
                                        width:200,
                                        layout:"form",
                                        labelWidth:55,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"txtImportsFile",
                                            fieldLabel:"进口凭证",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("txtImportsFile").getValue()==""){
                                                    Ext.ux.Toast.msg("提示","请填进口凭证.");
                                                    return;
                                               }
                                               Ext.Ajax.request({
                                                    url:"main/importsFile.html?action=addImportsFile",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","进口凭证添加成功.");
                                                        Ext.getCmp("typeAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        importsFileType:Ext.getCmp("txtImportsFile").getValue()
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
                                        Ext.ux.Toast.msg("提示","请选中要删除的进口凭证!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的进口凭证?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/importsFile.html?action=delImportsFile",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的进口凭证");
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
                    Ynzc.manage.ImportsFileGrid.superclass.initComponent.apply(this,arguments);
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
                      title:"进口凭证修改",
                       modal:true,
                      height:100,
                       width:260,
                      layout:"form",
                       labelWidth:80,
                      bodyStyle:"padding:5px 5px",
                       items:[{id:"txtUpdateImportsFileType",fieldLabel:"进口凭证",xtype:"textfield",anchor:'90%',value:record.data.importsFileType}],
                       buttons:[
                                 {text:"修改",
                                 handler:function()
                                             {
                                              if(Ext.getCmp("txtUpdateImportsFileType").getValue()==""){ Ext.ux.Toast.msg("提示","请填写进口凭证.");return;}
                                               Ext.Ajax.request
                                                 ({
                                                 url:"main/importsFile.html?action=updateImportsFile",
                                                 method:"post",
                                                  success:function(){Ext.ux.Toast.msg("提示","进口凭证添加成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},
                                                  failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                                                 params:{id:record.data.id,importsFileType:Ext.getCmp("txtUpdateImportsFileType").getValue()}
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
Ext.reg('importsfilegrid',Ynzc.manage.ImportsFileGrid);