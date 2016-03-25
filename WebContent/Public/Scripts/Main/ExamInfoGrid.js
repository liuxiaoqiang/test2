Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ExamInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'examInfo',
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
	        	value=new Date(value.time).format('Y-m-d');
	        	return value;
    		}
        },{
            header:'理论考试时间',
            sortable:true,
            dataIndex:"theoryExamDate",
            renderer:function(value){
	        	value=new Date(value.time).format('Y-m-d');
	        	return value;
        	}
        },{
            header:'实践考试时间',
            sortable:true,
            dataIndex:"practiceExamDate",
            renderer:function(value){
	        	value=new Date(value.time).format('Y-m-d');
	        	return value;
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
            url:'main/driverClassInfo.html?action=getDriverClassInfoPass',
            reader:reader,
            sortInfo:{
                field:'classDate',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'examInfo',
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
            	id:"driverClassInfoGoto",
                text:"进入班级",
                iconCls:"icon-add",
                handler:function(){
	                var selections=this.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中班级!");
	                    return;
	                }
	                if(n>1){
	                    Ext.MessageBox.alert("提示","不可以多个班级一起进入");
	                    return;
	                }
                	Ynzc.manage.DriverClassInfoId=selections[0].data.id;
                	Ynzc.manage.classState=selections[0].data.classState;
                	new Ynzc.manage.ExamInfoWin().show();
                }.createDelegate(this)
            },'-',{
            	id:"TheoryExam",
                text:"成绩批量录入",
                iconCls:"icon-add",
                handler:function(){
	                var selections=this.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中班级!");
	                    return;
	                }
	                if(n>1){
	                    Ext.MessageBox.alert("提示","请逐一录入成绩!");
	                    return;
	                }
	                if(selections[0].data.theoryExamPassStrNum>0 || selections[0].data.theoryExamMakeUpPassStrNum>0 || selections[0].data.practiceExamPassStrNum>0 || selections[0].data.practiceExamMakeUpPassStrNum>0){
	                    Ext.MessageBox.alert("提示","不能批量录入成绩!");
	                    return;
	                }
	                Ynzc.manage.ClassInfoId = selections[0].data.id;
                    var addwin = new Ynzc.manage.DriverStrExamWrite();
                    addwin.show();
                    Ext.getCmp("theoryDate").setValue(new Date(selections[0].data.theoryExamDate.time).format('Y-m-d'));
                    Ext.getCmp("fieldDate").setValue(new Date(selections[0].data.practiceExamDate.time).format('Y-m-d'));
                    Ext.getCmp("machineDate").setValue(new Date(selections[0].data.practiceExamDate.time).format('Y-m-d'));
                    Ext.getCmp("roadDate").setValue(new Date(selections[0].data.practiceExamDate.time).format('Y-m-d'));
                }.createDelegate(this)
            },'-',{
                id:"theoryExamPass",
                text:"理论考试通过",
                iconCls:"icon-add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中班级!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                        if(selections[i].data.classState >= 3){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]理论考试成绩录入已经结束");
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
                        msg:'你是否确认变更班级状态?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverClassInfo.html?action=driverClassTheoryExam",
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
                id:"practiceExamPass",
                text:"技术考试通过",
                iconCls:"icon-add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中班级!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                        if(selections[i].data.classState >= 4){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]技术考试成绩录入已经结束");
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
                        msg:'你是否确认变更班级状态?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverClassInfo.html?action=driverClassPracticeExam",
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
                id:"putOutDrivingLicence",
                text:"发放驾驶证",
                iconCls:"icon-Add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中班级!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(selections[i].data.classState < 4){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.className+"</font>]还未通过技术考试");
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
                        msg:'你是否确认变更班级状态?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverClassInfo.html?action=driverClassPutOut",
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
        Ynzc.manage.ExamInfoGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});
Ext.reg('examInfoGrid',Ynzc.manage.ExamInfoGrid);