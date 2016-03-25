Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.UserGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'userinfo',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'用户名',
                        sortable:true,
                        dataIndex:"username"
                    },{
                        header:'真实姓名',
                        sortable:true,
                        dataIndex:"realname"
                    },{
                        header:'联系电话',
                        sortable:true,
                        dataIndex:"telephone"
                    },{
                        header:'所属单位',
                        sortable:true,
                        dataIndex:"useunit"
                    },{
                        header:'角色',
                        sortable:true,
                        dataIndex:'roleid',
                        renderer:function(value){
                    			var roleArray=value.split(",");
                    			var resultStr="";                    			
                    			for(i=0;i<roleArray.length;i++){
                    				var index=Ynzc.manage.RoleStore.find("id",roleArray[i]);
                    				if(index>=0){
                    					resultStr=resultStr+Ynzc.manage.RoleStore.getAt(index).data.rolename+",";
                    				}else{
                    					resultStr=resultStr+roleArray[i]+",";
                    				}
                    			}
                    			return resultStr;
                    		}
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'username'
                        },{
                            name : 'telephone'
                        },{
                            name : 'useunit'
                        },{
                            name : 'realname'
                        },{
                            name : 'unitid'
                        },{
                            name : 'roleid'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/user.html?action=getUserList',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'userinfo',
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
                            id:'userAdd',
                            text:'添加',
                            iconCls:'icon-UserAdd',
                            handler:function(){
                                var addwin=new Ynzc.manage.UserWin();
                                addwin.show(Ext.getCmp("userAdd").getEl());
                            	}},'-',{
                                id:"userDel",
                                text:"删除",
                                iconCls:"icon-UserDel",
                                handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请选中要删除的用户!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的用户?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/user.html?action=delUser",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的用户");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        userlist:Ext.util.JSON.encode(rds)
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
                    Ynzc.manage.UserGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                    this.on("rowdblclick",function(grid,index,event){
                        var record=grid.getStore().getAt(index);
                        new Ynzc.manage.UserUpdateWin().show(grid.getEl());
                        Ynzc.manage.userid=record.data.id;
                        Ext.getCmp("username").setValue(record.data.username);
                        Ext.getCmp("realname").setValue(record.data.realname);
                        Ext.getCmp("telephone").setValue(record.data.telephone);
                        Ext.getCmp("unitid").setMyValue(record.data.unitid);
                        Ext.getCmp("roleid").setValue(record.data.roleid);                        
                    });
                }
});
Ext.reg('usergrid',Ynzc.manage.UserGrid);