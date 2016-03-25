Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DriverClassInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'driverClassInfo',
	initComponent:function(){
	    var sm=new Ext.grid.CheckboxSelectionModel();
	    var fm=Ext.form;
	    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
            header:'班级名称',
            sortable:true,
            dataIndex:"className"
        },{
            header:'开班时间',
            sortable:true,
            dataIndex:"classDate",
            renderer:function(value){
        		if(value === null){
        			value = "";
        		}else{
    	        	value=new Date(value.time).format('Y-m-d');
    	        	return value;
        		}
    		}
        },{
            header:'理论考试时间',
            sortable:true,
            dataIndex:"theoryExamDate",
            renderer:function(value){
	    		if(value === null){
	    			value = "";
	    		}else{
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
	    		}
        	}
        },{
            header:'实践考试时间',
            sortable:true,
            dataIndex:"practiceExamDate",
            renderer:function(value){
	    		if(value === null){
	    			value = "";
	    		}else{
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
	    		}
			}
        },{
            header:'班级状态 ',
            sortable:true,
            dataIndex:"classState",
            renderer : function(value) {
                var index = Ynzc.manage.ClassStateStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.ClassStateStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
        },{
        	header:'班级人数',
        	sortable:true,
        	dataIndex:"classStrNum"
        },{
        	header:'理论正考通过人数',
        	sortable:true,
        	dataIndex:"theoryExamPassStrNum"
        },{
        	header:'技术正考通过人数',
        	sortable:true,
        	dataIndex:"practiceExamPassStrNum"
        },{
        	header:'理论补考通过人数',
        	sortable:true,
        	dataIndex:"theoryExamMakeUpPassStrNum"
        },{
        	header:'技术补考通过人数',
        	sortable:true,
        	dataIndex:"practiceExamMakeUpPassStrNum"
        }]);
	    var reader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'className'
            },{
                name : 'unitId'
            },{
                name : 'classDate'
            },{
                name : 'theoryExamDate'
            },{
                name : 'practiceExamDate'
            },{
                name : 'classStrNum'
            },{
                name : 'classState'
            },{
                name : 'theoryExamPassStrNum'
            },{
                name : 'theoryExamMakeUpPassStrNum'
            },{
                name : 'practiceExamPassStrNum'
            },{
                name : 'practiceExamMakeUpPassStrNum'
            },{
                name : 'regionId'
            }]
	    });
        var ds=new Ext.data.Store({
            scopte:this,
            url:'main/driverClassInfo.html?action=getDriverClassInfo',
            reader:reader,
            sortInfo:{
                field:'classDate',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'driverClassInfo',
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
	                id:'driverClassInfoAdd',
	                text:'添加班级信息',
	                iconCls:'icon-Add',
	            	handler:function(){
	                    var addwin=new Ynzc.manage.DirverClassInfoWin();
	                    addwin.show();
	            	}
            	},'-',{
	                id:'driverClassInfoUpdate',
	                text:'班级信息修改',
	                iconCls:'icon-Add',
	            	handler:function(){
	                    var selections = this.selModel.getSelections();
	                    var n = selections.length;
	                    if(n == 0){
	                        Ext.MessageBox.alert("提示","请选中需要修改的班级!");
	                        return;
	                    }
	                    if(n > 1){
	                        Ext.MessageBox.alert("提示","班级选择过多!");
	                        return;
	                    }
	                	if(selections[0].data.classState>0){
	                		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.className+"</font>]不在录入阶段所以现在不能修改班级信息!");
	                		return;
	                	}else{
	                		new Ynzc.manage.DirverClassInfoUpdateWin().show();
	        	            Ynzc.manage.DriverClassInfoId=selections[0].data.id;
	        	            Ext.getCmp("className").setValue(selections[0].data.className);
	                	}
	            	}.createDelegate(this)
            	},'-',{
            		id:'driverClassAddStr',
            		text:'进入班级',
            		iconCls:'icon-Add',
            		handler:function(){
	                    var selections = this.selModel.getSelections();
	                    var n = selections.length;
	                    if(n == 0){
                            Ext.MessageBox.alert("提示","请选中需要添加学员的班级!");
                            return;
	                    }
	                    if(n > 1){
                            Ext.MessageBox.alert("提示","班级选择过多!");
                            return;
	                    }
	                    Ynzc.manage.DriverClassInfoId = selections[0].data.id;
	                    Ynzc.manage.ClassState = selections[0].data.classState;
	            		var addStrWin=new Ynzc.manage.DirverClassAddStrWin();
	            		addStrWin.show();
            		}.createDelegate(this)
            	},'-',{
                    id:"driverStrInfoDeclare",
                    text:"班级上报",
                    iconCls:"icon-Add",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中上报班级!");
                            return;
                        }
                        var rds="";
                        for(i=0;i<n;i++){
                        	if(selections[i].data.classState>=1){
                        		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]已经上报审核!");
                        		return;
                        	}else{
	                        	if(rds.length == 0){
	                        		rds = rds + selections[i].data.id;
	                        	}else{
	                        		rds = rds + "@" + selections[i].data.id;
	                        	}
                        	}
                        }
                        Ext.Msg.show({
                        	title:'系统确认',
                            msg:'你是否确认班级申请上报?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/driverClassInfo.html?action=driverClassDeclareing",
                                        method:"post",
                                        success:function(resp){
                							var result=Ext.util.JSON.decode(resp.responseText);
            								if(result.success==true){
            									Ext.MessageBox.alert("提示",result.reason);
            									ds.reload();
            								}else{
            									Ext.MessageBox.alert("提示",result.reason);
            								}
                                        },
                                        faliure:function(){
                                        	Ext.MessageBox.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                            id:rds
                                        }
                                    });
                                }
                            }
                         });
                    }.createDelegate(this)
                },'-',{
                    id:"driverClassInfoDel",
                    text:"删除",
                    iconCls:"icon-Del",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要删除的班级!");
                            return;
                        }
                        if(n>1){
                            Ext.MessageBox.alert("提示","请逐一删除班级!");
                            return;
                        }
                        if(selections[0].data.classState>0){
                    		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.className+"</font>]不在录入阶段!");
                    		return;
                        }
                        Ext.Msg.show({
                        	title:'系统确认',
                            msg:'你是否确认删除选中的班级信息?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/driverClassInfo.html?action=delDriverClassInfo",
                                        method:"post",
                                        success:function(resp){
                							var result=Ext.util.JSON.decode(resp.responseText);
            								if(result.success==true){
            									Ext.MessageBox.alert("提示",result.reason);
            									ds.reload();
            								}else{
            									Ext.MessageBox.alert("提示",result.reason);
            								}
                                        },
                                        faliure:function(){
                                        	Ext.MessageBox.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                            id:selections[0].data.id
                                        }
                                    });
                                }
                            }
                         });
                    }.createDelegate(this)
                },'-',{
                    id:'refresh',
                    text:'刷新',
                    iconCls:'icon-Add',
                    handler:function(){
            			ds.reload();
                	}
            	}
            ],
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
        Ynzc.manage.DriverClassInfoGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});
Ext.reg('driverClassInfoGrid',Ynzc.manage.DriverClassInfoGrid);