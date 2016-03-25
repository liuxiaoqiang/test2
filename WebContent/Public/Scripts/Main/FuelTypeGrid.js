Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.FuelTypeGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'fueltypegrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'燃料种类',
                        sortable:true,
                        dataIndex:"fuelname"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'fuelname'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/fuelType.html?action=getAllListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'fueltypegrid',
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
                                        title:"燃料种类添加",
                                        modal:true,
                                        height:100,
                                        width:200,
                                        layout:"form",
                                        labelWidth:80,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"certificatetype",
                                            fieldLabel:"燃料种类名称",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("certificatetype").getValue()==""){
                                                    Ext.ux.Toast.msg("提示","请填写燃料种类.");
                                                    return;
                                               }
                                               Ext.Ajax.request({
                                                    url:"main/fuelType.html?action=addFuelType",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","燃料种类添加成功.");
                                                        Ext.getCmp("typeAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        fuelname:Ext.getCmp("certificatetype").getValue()
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
                                        Ext.ux.Toast.msg("提示","请选中要删除的证件类型!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的燃料种类?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/fuelType.html?action=delFuelType",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的燃料种类");
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
                    Ynzc.manage.CertificateGrid.superclass.initComponent.apply(this,arguments);
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
                       title:"燃料种类修改",
                       modal:true,
                       height:100,
                       width:200,
                       layout:"form",
                       labelWidth:80,
                       bodyStyle:"padding:5px 5px",
                       items:[{id:"updateCertificate",fieldLabel:"燃料种类名称",xtype:"textfield",anchor:'98%',value:record.data.realcertificatetype}],
                       buttons:[
                                 {text:"修改",
                                  handler:function()
                                             {
                                              if(Ext.getCmp("updateCertificate").getValue()==""){ Ext.ux.Toast.msg("提示","请填写燃料种类.");return;}
                                               Ext.Ajax.request
                                                 ({
                                                  url:"main/fuelType.html?action=updateFuelType",
                                                  method:"post",

                                                  success:function(){Ext.ux.Toast.msg("提示","燃料种类名称修改成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},

                                                  success:function(){Ext.ux.Toast.msg("提示","燃料种类修改成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},

                                                  failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                                                  params:{id:record.data.id,fuelname:Ext.getCmp("updateCertificate").getValue()}
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
Ext.reg('fueltypegrid',Ynzc.manage.FuelTypeGrid);