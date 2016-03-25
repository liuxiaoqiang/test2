Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.EngineBrandGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'enginebrandgrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'发动机品牌',
                        sortable:true,
                        dataIndex:"engineBrand"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'engineBrand'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/engineBrand.html?action=getAllListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'enginebrandgrid',
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
                                        title:"发动机品牌添加",
                                        modal:true,
                                        height:100,
                                        width:200,
                                        layout:"form",
                                        labelWidth:70,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"txtEngineBrand",
                                            fieldLabel:"发动机品牌",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("txtEngineBrand").getValue()==""){
                                                    Ext.ux.Toast.msg("提示","请填发动机品牌.");
                                                    return;
                                               }
                                               Ext.Ajax.request({
                                                    url:"main/engineBrand.html?action=addEngineBrand",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","发动机品牌添加成功.");
                                                        Ext.getCmp("typeAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        engineBrand:Ext.getCmp("txtEngineBrand").getValue()
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
                                        Ext.ux.Toast.msg("提示","请选中要删除的发动机品牌!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的发动机品牌?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/engineBrand.html?action=delEngineBrand",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的发动机品牌");
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
                    Ynzc.manage.EngineBrandGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                   //  this.on("afteredit",function(obj){
                    // var currentValue=obj.value;
                    //  Ext.MessageBox.alert("提示","能获取到ID的值吗："+obj.record.get("id")) ;
                    // if(currentValue==""){Ext.ux.Toast.msg("提示","请填写发动机品牌.");return;}
                    // Ext.Ajax.request(
                    // {url:"main/engineBrand.html?action=updateEngineBrand",
                    // method:"post",
                    // success:function(){Ext.ux.Toast.msg("提示","发动机品牌修改成功."); ds.reload();},
                    // failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                    // params:{id:obj.record.get("id"),engineBrand:currentValue}
                    // }
                    // )
                     
                    // });
                      this.on("rowdblclick",function(grid,index,event){
                      var record=grid.getStore().getAt(index);
                      var win= new Ext.Window(
                      {
                       id:"typeUpdatewin",
                       title:"发动机品牌修改",
                      modal:true,
                      height:100,
                      width:260,
                      layout:"form",
                      labelWidth:80,
                      bodyStyle:"padding:5px 5px",
                      items:[{id:"txtUpdateEngineBrand",fieldLabel:"发动机品牌",xtype:"textfield",anchor:'90%',value:record.data.engineBrand}],
                       buttons:[
                                 {text:"修改",
                                  handler:function()
                                             {
                                              if(Ext.getCmp("txtUpdateEngineBrand").getValue()==""){ Ext.ux.Toast.msg("提示","请填写发动机品牌.");return;}
                                               Ext.Ajax.request
                                                 ({
                                                  url:"main/engineBrand.html?action=updateEngineBrand",
                                                  method:"post",
                                                 success:function(){Ext.ux.Toast.msg("提示","发动机品牌修改成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},
                                                  failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                                                  params:{id:record.data.id,engineBrand:Ext.getCmp("txtUpdateEngineBrand").getValue()}
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
Ext.reg('enginebrandgrid',Ynzc.manage.EngineBrandGrid);