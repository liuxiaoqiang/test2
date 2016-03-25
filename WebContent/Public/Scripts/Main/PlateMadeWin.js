Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateMadeWin=Ext.extend(Ext.Window,{
	id:"platemadewin",
	initComponent:function(){    
		
		var wtReader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'platenum'
            },{
                name : 'platenumhead'
            },{
                name : 'psid'
            },{
            	name : 'madestatus'
            }]
        });
	 	
		var wtDs=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.psid,status:Ynzc.manage.status},
            url:'main/plate.html?action=getNewPlateListHandle',
            reader:wtReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
		
		var mdReader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'platenum'
            },{
                name : 'platenumhead'
            },{
                name : 'psid'
            },{
            	name : 'madestatus'
            }]
        });
		
		var mdDs=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.psid},
            url:'main/plate.html?action=getMadePlateList',
            reader:mdReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
		
		var madeGrid=new Ext.grid.GridPanel({
				 plain:true,
				 height:200,
				 width:686,
                 border:false,
                 autoScroll:true,
                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                             header:'号牌号码',
                             sortable:true,
                             dataIndex:"platenum",
                             renderer:function(value){
                             	value=PlateNumHead+"."+value;
                             	return value;
                             }
                 },{
                 			 header:'状态',
                             sortable:true,
                             dataIndex:"madestatus",
                             renderer:function(value){
                             	if(value==1){return "<font color=blue>进行制作中....</font>"};
                             }
                 }]),
                 sm:new Ext.grid.CheckboxSelectionModel(),
                 frame:true,
                 store:mdDs,
                 loadMask:true,
                 viewConfig:{
                     forceFit:true
                 },
                 plugins:new Ext.ux.grid.Search({
                            width:120,
                            iconCls:false,
                            position:"bottom"
                        }),
                 bbar:new Ext.PagingToolbar({
                     pageSize:6,
                     store:mdDs,
                     displayInfo:true,
                     displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                     emptyMsg : '无记录'
                 })
		})
		
		
		var waitGrid=new Ext.grid.GridPanel({
				 plain:true,
				 height:200,
				 width:686,
                 border:false,
                 autoScroll:true,
                 cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                             header:'号牌号码',
                             sortable:true,
                             dataIndex:"platenum",
                             renderer:function(value){
                             	value=PlateNumHead+"."+value;
                             	return value;
                             }
                 },{
                 			 header:'状态',
                             sortable:true,
                             dataIndex:"madestatus",
                             renderer:function(value){
                             	if(value==0){return "<font color=blue>待制作</font>"};
                             	if(value==2){return "<font color=red>不制作</font>"};
                             	if(value==3){return "<font color=blue>已入库</font>"};
                             	if(value==4){return "<font color=darkred>该号牌已经存在，不能重复制作.</font>"};
                             	if(value==7){return "<font color = blue>待补牌</font>"};
                             }
                 }]),
                 sm:new Ext.grid.CheckboxSelectionModel(),
                 frame:true,
                 store:wtDs,
                 loadMask:true,
                 viewConfig:{
                     forceFit:true
                 },
                 plugins:new Ext.ux.grid.Search({
                            width:120,
                            iconCls:false,
                            position:"bottom"
                        }),
                 bbar:new Ext.PagingToolbar({
                     pageSize:6,
                     store:wtDs,
                     displayInfo:true,
                     displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                     emptyMsg : '无记录'
                 })
		});
	
		Ext.apply(this,{
			title:"查看详细号牌需求",
			iconCls:"icon-Search",
			width:700,
			height:487,
			modal:true,
			resizable:false,
			bodyStyle:"padding 10px 10px",			
			items:[{
				xtype:"label",
				html:"待制作的号牌:"
			},waitGrid,{
				xtype:"label",
				html:"进行制作的号牌:"
			},madeGrid,{
				xtype:"toolbar",
				items:[{
					text:"标记为制作",
					iconCls:"icon-add",
					handler:function(){
						var selections=waitGrid.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要制作的号牌!");
                            return;
                        }
                        var rds=[];
                        for(i=0;i<n;i++){
                        	if(selections[i].data.madestatus==3){
                        		Ext.MessageBox.alert("提示","部分号牌已入库，不能标记");
                        	}else{
                        		rds.push(selections[i].data);
                        	}
                        }
                        Ext.Ajax.request({
                        	url:"main/plate.html?action=flagMade",
                        	success:function(){
                        		Ext.MessageBox.alert("提示","标记成功!");
                        		waitGrid.getStore().reload();
                        		madeGrid.getStore().reload();
                        	},
                        	failure:function(){
                        		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                        	},
                        	params:{
                        		flaglist:Ext.util.JSON.encode(rds)
                        	}
                        });
					}
				},{
					text:"标记为不制作",
					iconCls:"icon-del",
					handler:function(){
						var selections=waitGrid.selModel.getSelections();
						var tselections=madeGrid.selModel.getSelections();
                        var n=selections.length;
                        var tn=tselections.length;
                        if(n==0&&tn==0){
                            Ext.MessageBox.alert("提示","请选中不制作的号牌!");
                            return;
                        }
                        var rds=[];
                        for(i=0;i<n;i++){
                        	if(selections[i].data.madestatus==3){
                        		Ext.MessageBox.alert("提示","部分号牌已入库，不能标记");
                        	}else{
                        		rds.push(selections[i].data);
                        	}
                        }
                        for(i=0;i<tn;i++){
                        	if(tselections[i].data.madestatus==3){
                        		Ext.MessageBox.alert("提示","部分号牌已入库，不能标记");
                        	}else{
                        		rds.push(tselections[i].data);
                        	}
                        }
                        Ext.Ajax.request({
                        	url:"main/plate.html?action=flagNotMade",
                        	success:function(){
                        		Ext.MessageBox.alert("提示","标记成功!");
                        		waitGrid.getStore().reload();
                        		madeGrid.getStore().reload();
                        	},
                        	failure:function(){
                        		Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                        	},
                        	params:{
                        		flaglist:Ext.util.JSON.encode(rds)
                        	}
                        });
					}
				},{
					text:"全部标记为制作",
					iconCls:"icon-add",
					handler:function(){
						Ext.Msg.show({
	                            title:'系统确认',
	                            msg:'你是否确认将所有待制作号牌标记为制作？',
	                            buttons:Ext.Msg.YESNO,
	                            scope:this,
	                            icon : Ext.MessageBox.QUESTION,
	                            fn:function(btn){
	                                if(btn=="yes"){
	                                    Ext.Ajax.request({
	                                        url:"main/plate.html?action=flagAll",
	                                        method:"post",
	                                        success:function(){
	                                            Ext.MessageBox.alert("提示","标记成功");
	                                            waitGrid.getStore().reload();
                        						madeGrid.getStore().reload();
	                                        },
	                                        faliure:function(){
	                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
	                                        },
	                                        params:{
	                                        	psid:Ynzc.manage.psid
	                                        }
	                                    });
	                                }
	                            }
	                    });   
					}
				},{
					text:"入库",
					iconCls:"icon-submit",
					handler:function(){
							Ext.Msg.show({
		                        title:'系统确认',
		                        msg:'正在制作的号牌已经制作完成，确认入库？',
		                        buttons:Ext.Msg.YESNO,
		                        scope:this,
		                        icon : Ext.MessageBox.QUESTION,
		                        fn:function(btn){
		                            if(btn=="yes"){
		                            	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在处理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
		                                Ext.Ajax.request({
		                                    url:"main/plate.html?action=InputLib",
		                                    method:"post",
		                                    success:function(){
		                                    mask.hide();
		                                        Ext.MessageBox.alert("提示","标记成功");
		                                        waitGrid.getStore().reload();
		                						madeGrid.getStore().reload();
		                						Ext.getCmp("proPlateMgr").getStore().reload();
		                                    },
		                                    faliure:function(){
		                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
		                                    },
		                                    params:{
		                                    	psid:Ynzc.manage.psid,
		                                    	unitid:Ynzc.manage.unitid
		                                    }
		                                });
		                            }
		                        }
		                });   
					}
				}]
			}]
		})
		Ynzc.manage.PlateMadeWin.superclass.initComponent.apply(this,arguments);
		wtDs.load({
			params:{
				start:0,
				limit:6
			}
		});
		mdDs.load({
			params:{
				start:0,
				limit:6
			}
		});
	}
});