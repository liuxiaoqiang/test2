Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.WordSetGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'wordsetgrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'编号',
                        sortable:true,
                        dataIndex:"id"
                    },{
                        header:'上边距',
                        sortable:true,
                        dataIndex:"topMargin"
                    },{
                        header:'下边距',
                        sortable:true,
                        dataIndex:"bottomMargin"
                    },{
                        header:'左边距',
                        sortable:true,
                        dataIndex:"leftMargin"
                    },{
                        header:'右边距',
                        sortable:true,
                        dataIndex:"rightMargin"
                    },{
                        header:'报表类型',
                        sortable:true,
                        dataIndex:"wordtype"
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'topMargin'
                        },{
                            name : 'bottomMargin'
                        },{
                            name : 'leftMargin'
                        },{
                            name : 'rightMargin'
                        },{
                            name : 'unitid'
                        },{
                            name : 'wordtype'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/word.html?action=getAllListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'wordsetgrid',
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
                                        title:"报表样式添加",
                                        modal:true,
                                        height:200,
                                        width:200,
                                        layout:"form",
                                        labelWidth:80,
                                        bodyStyle:"padding:5px 5px",
                                        items:[{
                                            id:"wordsettype",
                                            fieldLabel:"报表样式名称",
                                            xtype:"textfield",
                                            anchor:'98%'
                                        },{
                                     	   id:"WordSettopMargin",
                                    	   fieldLabel:"上边距",
                                    	   xtype:"textfield",
                                    	   regex:/^[1-9]\d*$/,
                                    	   regexText:"只能输入正整数",
                                    	   anchor:'98%'
                                    	 },{
                                           id:"WordSetbottomMargin",
                                           fieldLabel:"下边距",
                                           xtype:"textfield",
                                           regex:/^[1-9]\d*$/,
                                    	   regexText:"只能输入正整数",
                                           anchor:'98%'
                                         },{
                                           id:"WordSetleftMargin",
                                           fieldLabel:"左边距",
                                           xtype:"textfield",
                                           regex:/^[1-9]\d*$/,
                                    	   regexText:"只能输入正整数",
                                           anchor:'98%'
                                         },{
                                           id:"WordSetrightMargin",
                                           fieldLabel:"右边距",
                                           xtype:"textfield",
                                           regex:/^[1-9]\d*$/,
                                    	   regexText:"只能输入正整数",
                                           anchor:'98%'
                                         }],
                                        buttons:[{text:"保存",handler:function(){
                                               if(Ext.getCmp("wordsettype").getValue()==""){Ext.ux.Toast.msg("提示","请填写类型名称.");return;}
                                               if(Ext.getCmp("WordSettopMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写上边距.");return;}
                                               if(Ext.getCmp("WordSetbottomMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写下边距.");return;}
                                               if(Ext.getCmp("WordSetleftMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写左边距.");return;}
                                               if(Ext.getCmp("WordSetrightMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写右边距.");return;}
                                               Ext.Ajax.request({
                                                    url:"main/word.html?action=addWordSet",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","报表样式添加成功.");
                                                        Ext.getCmp("typeAddwin").close();
                                                        ds.reload();
                                                    },
                                                    failure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                  	  wordtype:Ext.getCmp("wordsettype").getValue(),
                                                  	  WordSettopMargin:Ext.getCmp("WordSettopMargin").getValue(),
                                                  	  WordSetbottomMargin:Ext.getCmp("WordSetbottomMargin").getValue(),
                                                  	  WordSetleftMargin:Ext.getCmp("WordSetleftMargin").getValue(),
                                                  	  WordSetrightMargin:Ext.getCmp("WordSetrightMargin").getValue()
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
                                        Ext.ux.Toast.msg("提示","请选中要删除的报表样式!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的报表样式?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/word.html?action=delWordSet",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的报表样式");
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
                    Ynzc.manage.WordSetGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                      this.on("rowdblclick",function(grid,index){
                      var record=grid.getStore().getAt(index);
                      var win= new Ext.Window(
                      {
                       id:"typeUpdatewin",
                       title:"报表样式修改",
                       modal:true,
                       height:200,
                       width:200,
                       resizable : false,
                       layout:"form",
                       labelWidth:80,
                       bodyStyle:"padding:5px 5px",
                       items:[{
                    	   id:"WordSettopMargin",
                    	   fieldLabel:"上边距",
                    	   xtype:"textfield",
                    	   regex:/^[1-9]\d*$/,
                    	   regexText:"只能输入正整数",
                    	   anchor:'98%',
                    	   value:record.data.topMargin
                    	 },{
                           id:"WordSetbottomMargin",
                           fieldLabel:"下边距",
                           regex:/^[1-9]\d*$/,
                    	   regexText:"只能输入正整数",
                           xtype:"textfield",
                           anchor:'98%',
                           value:record.data.bottomMargin
                         },{
                           id:"WordSetleftMargin",
                           fieldLabel:"左边距",
                           xtype:"textfield",
                           regex:/^[1-9]\d*$/,
                    	   regexText:"只能输入正整数",
                           anchor:'98%',
                    	   value:record.data.leftMargin
                         },{
                           id:"WordSetrightMargin",
                           fieldLabel:"右边距",
                           xtype:"textfield",
                           regex:/^[1-9]\d*$/,
                    	   regexText:"只能输入正整数",
                           anchor:'98%',
                           value:record.data.rightMargin
                         }],
                       buttons:[
                                 {text:"修改",
                                  handler:function()
                                             {
                                              if(Ext.getCmp("WordSettopMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写上边距.");return;}
                                              if(Ext.getCmp("WordSetbottomMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写下边距.");return;}
                                              if(Ext.getCmp("WordSetleftMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写左边距.");return;}
                                              if(Ext.getCmp("WordSetrightMargin").getValue()==""){ Ext.ux.Toast.msg("提示","请填写右边距.");return;}
                                               Ext.Ajax.request
                                                 ({
                                                  url:"main/word.html?action=updateWordSet",
                                                  method:"post",

                                                  success:function(){Ext.ux.Toast.msg("提示","报表样式修改成功.");Ext.getCmp("typeUpdatewin").close(); ds.reload();},
                                                  failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                                                  params:{
                                                	  id:record.data.id,
                                                	  unitid:record.data.unitid,
                                                	  wordtype:record.data.wordtype,
                                                	  WordSettopMargin:Ext.getCmp("WordSettopMargin").getValue(),
                                                	  WordSetbottomMargin:Ext.getCmp("WordSetbottomMargin").getValue(),
                                                	  WordSetleftMargin:Ext.getCmp("WordSetleftMargin").getValue(),
                                                	  WordSetrightMargin:Ext.getCmp("WordSetrightMargin").getValue()}
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
Ext.reg('wordsetgrid',Ynzc.manage.WordSetGrid);