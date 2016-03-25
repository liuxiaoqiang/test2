Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.InsuranceCompanyGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'insurancecompanygrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'保险公司',
                        sortable:true,
                        dataIndex:"insurancecompanyName"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'insurancecompanyName'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/insuranceCompany.html?action=getAllListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'insurancecompanygrid',
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
                                        title:"保险公司添加",
                                        modal:true,
                                        height:100,
                                        width:200,
                                        layout:"form",
                                        labelWidth:55,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"txtinsurancecompanyName",
                                            fieldLabel:"保险公司",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("txtinsurancecompanyName").getValue()==""){
                                                    Ext.ux.Toast.msg("提示","请填保险公司.");
                                                    return;
                                               }
                                               Ext.Ajax.request({
                                                    url:"main/insuranceCompany.html?action=addInsuranceCompany",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","保险公司添加成功.");
                                                        Ext.getCmp("typeAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        insurancecompanyName:Ext.getCmp("txtinsurancecompanyName").getValue()
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
                                        Ext.ux.Toast.msg("提示","请选中要删除的保险公司!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的保险公司?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/insuranceCompany.html?action=delInsuranceCompany",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的保险公司");
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
                    Ynzc.manage.InsuranceCompanyGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
 
                      this.on("rowdblclick",function(grid,index,event){
                      var record=grid.getStore().getAt(index);
                    // Ext.MessageBox.alert("title","kuangwei");
                      var win= new Ext.Window(
                      {
                       id:"typeUpdatewin",
                      title:"保险公司修改",
                      modal:true,
                       height:100,
                       width:260,
                       layout:"form",
                     labelWidth:80,
                       bodyStyle:"padding:5px 5px",
                       items:[{id:"txtUpdateInsurancecompanyName",fieldLabel:"保险公司",xtype:"textfield",anchor:'90%',value:record.data.insurancecompanyName}],
                      buttons:[
                                 {text:"修改",
                                  handler:function()
                                            {
                                             if(Ext.getCmp("txtUpdateInsurancecompanyName").getValue()==""){ Ext.ux.Toast.msg("提示","请填写保险公司.");return;}
                                              Ext.Ajax.request
                                                ({
                                                  url:"main/insuranceCompany.html?action=updateInsuranceCompany",
                                                 method:"post",
                                                  success:function(){Ext.ux.Toast.msg("提示","保险公司添加成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},
                                                 failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                                                  params:{id:record.data.id,insurancecompanyName:Ext.getCmp("txtUpdateInsurancecompanyName").getValue()}
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
Ext.reg('insurancecompanygrid',Ynzc.manage.InsuranceCompanyGrid);