Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.RoleGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'rolegrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'角色编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'角色名称',
                        sortable:true,
                        dataIndex:"rolename"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'rolename'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/role.html?action=getRoleList',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'rolegrid',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                        tbar:[{
                                id:"addRoleBtn",
                                text:'添加',
                                iconCls:"icon-Add",
                                handler:function(){
                                    new Ext.Window({
                                        id:"roleAddwin",
                                        title:"角色添加",
                                        modal:true,
                                        height:100,
                                        width:200,
                                        layout:"form",
                                        labelWidth:55,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"rolename",
                                            fieldLabel:"角色名",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("rolename").getValue()==""){
                                                    Ext.ux.Toast.msg("提示","请填写角色名称.");
                                                    return;
                                               }
                                               Ext.Ajax.request({
                                                    url:"main/role.html?action=addRole",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","角色添加成功.");
                                                        Ext.getCmp("roleAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        rolename:Ext.getCmp("rolename").getValue()
                                                    }
                                               });
                                        }},{text:"取消",handler:function(){
                                               Ext.getCmp("roleAddwin").close();
                                        }}]
                                    }).show(Ext.getCmp("addRoleBtn").getEl());
                                }
                            },'-',{
                                text:'删除',
                                iconCls:"icon-Del",
                                handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请选中要删除的角色!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的角色?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/role.html?action=delRole",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的角色");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        rolelist:Ext.util.JSON.encode(rds)
                                                    }
                                                });
                                            }
                                        }
                                     });
                                }.createDelegate(this)
                            },'-',{
                                id:"setPermissionsBtn",
                                text:"授权",
                                iconCls:"icon-Permissions",
                                handler:function(){
                                    var selections=this.selModel.getSelections();                                    
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请先选中一个将要授权的角色。");
                                        return;
                                    }
                                    if(n>1){
                                        Ext.ux.Toast.msg("提示","每次只能对一个角色进行授权！");
                                        return;
                                    }
                                    var select=selections[0].data;
                                    Ynzc.manage.roleid=select.id;
                                    new Ynzc.manage.PermissionsWin({
                                        title:"对 [<font color=red>"+select.rolename+"</font>] 进行授权",
                                        iconCls:"icon-Permissions",
                                        modal:true
                                    }).show(Ext.getCmp("setPermissionsBtn").getEl());
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
                    Ynzc.manage.RoleGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                    this.on("rowdblclick",function(grid,index,event){
                        var record=grid.getStore().getAt(index);
                        new Ext.Window({
                            id:"roleUpdatewin",
                            title:"角色修改",
                            modal:true,
                            height:100,
                            width:200,
                            layout:"form",
                            labelWidth:55,
                            bodyStyle:"padding:5px 5px",
                            items:[{
                                id:"rolename",
                                fieldLabel:"角色名",
                                xtype:"textfield",
                                value:record.data.rolename,
                                anchor:'98%'
                            }],
                            buttons:[{text:"保存",handler:function(){
                                   if(Ext.getCmp("rolename").getValue()==""){
                                        Ext.ux.Toast.msg("提示","请填写角色名称.");
                                        return;
                                   }
                                   Ext.Ajax.request({
                                        url:"main/role.html?action=updateRole",
                                        method:"post",
                                        success:function(){
                                            Ext.ux.Toast.msg("提示","角色修改成功.");
                                            Ext.getCmp("roleUpdatewin").close();
                                            ds.reload();
                                        },
                                        failure:function(){
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                            id:record.data.id,
                                            rolename:Ext.getCmp("rolename").getValue()
                                        }
                                   });
                            }},{text:"取消",handler:function(){
                                   Ext.getCmp("roleUpdatewin").close();
                            }}]
                        }).show(grid.getEl());
                    });
                }
});
Ext.reg('rolegrid',Ynzc.manage.RoleGrid);