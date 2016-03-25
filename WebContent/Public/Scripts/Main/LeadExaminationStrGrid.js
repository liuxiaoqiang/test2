Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.LeadExaminationStrGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'leadExaminationStrGrid',
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
            header:'术考时间',
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
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'leadExaminationStrGrid',
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
                    id:"driverClassInfoPass",
                    text:"班级审核",
                    iconCls:"icon-Add",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中需要操作的班级!");
                            return;
                        }
                        var rds="";
                        for(i=0;i<n;i++){
                        	if(selections[i].data.classState<1){
                        		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]还没有上报!");
                        		return;
                        	}
                        	if(selections[i].data.classState>1){
                        		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]已经审核过了!");
                        		return;
                        	}else{
	                        	if(rds.length == 0){
	                        		rds = rds + selections[i].data.id;
	                        	}else{
	                        		rds = rds + "," + selections[i].data.id;
	                        	}
                        	}
                        }
                        Ext.Msg.show({
                        	title:'系统确认',
                            msg:'你是否确认该班级审核通过?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/driverClassInfo.html?action=driverClassDeclare",
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
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
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
                    id:"driverClassInfoChange",
                    text:"班级信息修改",
                    iconCls:"icon-Add",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中需要操作的班级!");
                            return;
                        }
    	                if(n>1){
    	                    Ext.MessageBox.alert("提示","请选中要修改信息的学员!");
    	                    return;
    	                }
                		new Ynzc.manage.DirverClassInfoLeadUpdateWin().show();
        	            Ynzc.manage.DriverClassInfoId=selections[0].data.id;
        	            Ext.getCmp("className").setValue(selections[0].data.className);
        	            Ext.getCmp("classDate").setValue(new Date(selections[0].data.classDate.time));
        	            Ext.getCmp("theoryExamDate").setValue(new Date(selections[0].data.theoryExamDate.time));
        	            Ext.getCmp("practiceExamDate").setValue(new Date(selections[0].data.practiceExamDate.time));
                    }.createDelegate(this)
                },'-',{
                    id:"driverClassInfoGoto",
                    text:"进入班级",
                    iconCls:"icon-Add",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中需要操作的班级!");
                            return;
                        }
    	                if(n>1){
    	                    Ext.MessageBox.alert("提示","请选中要修改信息的学员!");
    	                    return;
    	                }
    	            	Ynzc.manage.DriverClassInfoId=selections[0].data.id;
    	            	new Ynzc.manage.LeadExaminationStrWin().show();
                    }.createDelegate(this)
                },'-',{
                    id:"driverClassInfoPass",
                    text:"不通过审核",
                    iconCls:"icon-Del",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中需要操作的班级!");
                            return;
                        }
                        var rds="";
                        for(i=0;i<n;i++){
                        	if(selections[i].data.classState<1){
                        		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]还没有上报!");
                        		return;
                        	}
                        	if(selections[i].data.classState>1){
                        		Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]已经审核过了!");
                        		return;
                        	}else{
	                        	if(rds.length == 0){
	                        		rds = rds + selections[i].data.id;
	                        	}else{
	                        		rds = rds + "," + selections[i].data.id;
	                        	}
                        	}
                        }
                        Ext.Msg.show({
                        	title:'系统确认',
                            msg:'你是否确认该班级审核不通过?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/driverClassInfo.html?action=driverClassUnDeclare",
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
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
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
        Ynzc.manage.LeadExaminationStrGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});
Ext.reg('leadExaminationStrGrid',Ynzc.manage.LeadExaminationStrGrid);