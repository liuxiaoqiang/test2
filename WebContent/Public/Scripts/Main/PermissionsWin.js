Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PermissionsWin = Ext.extend(Ext.Window, {
    id: 'permissionswin',
    initComponent: function() {
        var MenuReader=new Ext.data.JsonReader({
            root:"Menu",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'menu'
            }]
        });
        var PerReader=new Ext.data.JsonReader({
            root:"Per",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'menu'
            }]
        });
        var MenuDs=new Ext.data.Store({
            id:"menuds",
            scopte:this,
            url:'main/menu.html?action=getAllMenu',
            reader:MenuReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
        var PerDs=new Ext.data.Store({
            id:'perds',
            scopte:this,
            url:'main/role.html?action=getAllRolePermissions',
            reader:PerReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
        var comboReader=new Ext.data.JsonReader({
            root:"Module",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'menu'
            }]
        });
        var comboDs=new Ext.data.Store({
            scopte:this,
            url:'main/menu.html?action=getModuleList',
            reader:comboReader
        });
        var PerGrid=new Ext.grid.GridPanel({
                            plain:true,
                            height:455,
                            width:380,
                            border:false,
                            cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                                        header:'已授权的功能菜单',
                                        dataIndex:"menu"
                            }]),
                            sm:new Ext.grid.CheckboxSelectionModel(),
                            frame:true,
                            store:PerDs,
                            loadMask:true,
                            viewConfig:{
                                forceFit:true
                            },
                            tbar:[{
                                text:"删除授权",
                                iconCls:'icon-DelPermissions',
                                handler:function(){
                                    var selections=PerGrid.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请先选中要删除的授权!");
                                        return;
                                    }
                                    Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除授权?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                var rds=[];
                                                for(i=0;i<n;i++){
                                                    rds.push(selections[i].data);
                                                }
                                                var rdsjson=Ext.util.JSON.encode(rds);
                                                Ext.Ajax.request({
                                                    url:"main/role.html?action=delPermissions",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的授权！");
                                                        ftid=Ext.getCmp("modulCombo").getValue();
                                                        if(ftid==""||ftid==null){
                                                            ftid=null;
                                                        }
                                                        PerGrid.getStore().reload({
                                                            params:{
                                                                roleid:Ynzc.manage.roleid,
                                                                fatherid:ftid
                                                            }
                                                        });
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                        dellist:rdsjson,
                                                        roleid:Ynzc.manage.roleid
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                            },'-']
                        });
        var MenuGrid=new Ext.grid.GridPanel({
                            plain:true,
                            height:455,
                            width:380,
                            border:false,
                            cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                                        header:'功能菜单',
                                        dataIndex:"menu"
                            }]),
                            sm:new Ext.grid.CheckboxSelectionModel(),
                            frame:true,
                            store:MenuDs,
                            loadMask:true,
                            viewConfig:{
                                forceFit:true
                            },
                            tbar:[{
                                id : 'modulCombo',
                                xtype:"combo",
                                displayField : 'menu',
				                valueField : 'id',
				                typeAhead : true,
				                mode : 'local',
				                editable : false,
				                selectOnFoucs : true,
				                triggerAction : 'all',
				                emptyText:"菜单分类选择",
				                store:comboDs,
				                listeners:{
				                    "select":function(){
				                        MenuDs.reload({
				                            params:{
				                                fatherid:this.value
				                            }
				                        });
				                        PerDs.reload({
				                            params:{
				                                roleid:Ynzc.manage.roleid,
				                                fatherid:this.value
				                            }
				                        });
				                    }
				                }
                            },'-',{
                                text:"授权",
                                iconCls:"icon-AddPermissions",
                                handler:function(){
                                    var selections=MenuGrid.selModel.getSelections();
									var n=selections.length;
									var PerStore=PerGrid.getStore();
									var m=PerStore.getCount();
									if(n==0){
									    Ext.ux.Toast.msg("提示","请选中至少一个要授予的功能菜单");
									    return;
									}
									var rds=[];
                                    if(m>0){
										var bool=true;
										for(var i=0;i<n;i++){
											for(var j=0;j<m;j++){
												if(selections[i].data.menu==PerStore.data.items[j].data.menu){
													Ext.ux.Toast.msg('提示',selections[i].data.menu+" 之前已经授予该角色");
													bool=false;
												}
											}
											if(bool){
												rds.push(selections[i].data);
											}else{
												bool=true;
											}
										}
									}else{
										for(var i=0;i<n;i++){
											rds.push(selections[i].data)
										}
									}
									var rdsjson=Ext.util.JSON.encode(rds);
									Ext.Ajax.request({
									    url:"main/role.html?action=setPermissions",
									    method:"post",
									    success:function(){
									        Ext.ux.Toast.msg("提示","授权成功！");
									        ftid=Ext.getCmp("modulCombo").getValue();
									        if(ftid==""||ftid==null){
                                                ftid=null;
                                            }
							                PerDs.reload({
							                    params:{
							                        roleid:Ynzc.manage.roleid,
							                        fatherid:ftid
							                    }
							                });
									    },
									    failure:function(){
									        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
									    },
									    params:{
									        addlist:rdsjson,
									        roleid:Ynzc.manage.roleid
									    }
									});
                                }
                            },'-']
                         });
        Ext.apply(this,{
            height:500,
            width:800,
            layout:"column",
            resizable:false,
            items:[{
                 columnWidth:.5,
                 border:false,
                 height:468,
                 frame:true,
                 items:MenuGrid
            },{
                columnWidth:.5,
                border:false,
                height:468,
                frame:true,
                items:PerGrid
            }],
            tools:[{
                id:"refresh",
                handler:function(){
                    MenuDs.reload({
                        params:{
                            fatherid:null
                        }
                    });
                    PerDs.reload({params:{
                        roleid:Ynzc.manage.roleid
                    }}); 
                    Ext.getCmp("modulCombo").setValue("");
                }
            }]
        });
        Ynzc.manage.PermissionsWin.superclass.initComponent.apply(this, arguments);
        MenuDs.load();
        PerDs.load({params:{
              roleid:Ynzc.manage.roleid
        }});
        comboDs.load();
    }
});
Ext.reg('permissionswin', Ynzc.manage.PermissionsWin);