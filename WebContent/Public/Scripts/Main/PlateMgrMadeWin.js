Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateMgrMadeWin=Ext.extend(Ext.grid.GridPanel,{
                id:'platemgrmadewin',
                initComponent:function(){
						var sm=new Ext.grid.CheckboxSelectionModel();
					    var fm=Ext.form;
					    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
					        header:'上报时间',
					        sortable:true,
					        dataIndex:"submitdate",
					        renderer:function(value){
					        	value=new Date(value.time).format('Y-m-d');
					        	return value;
					        }
					    },{ 
					        header:'上报人',
					        sortable:true,
					        dataIndex:"submitman"
					    },{
					        header:'状态',
					        sortable:true,
					        dataIndex:"status",
					        renderer:function(value){
					        	if(value==0){return "<font color=blue>市级上报</font>"};
					        	if(value==1){return "<font color=blue>省级制作</font>"};
					        	if(value==2){return "<font color=blue>省级入库</font>"};
					        	if(value==3){return "<font color=blue>市级入库</font>"};
					//        	if(value==0){return "<font color=red>待上报</font>"};
					//        	if(value==1){return "<font color=blue>待省级分配</font>"};
					//        	if(value==2){return "<font color=blue>省级已分配待入库</font>"};
					//        	if(value==3){return "<font color=green>已入库</font>"};
					//        	if(value==4){return "<font color=red>补牌批次待上报</font>"};
					        }
					    },{
					        header:'确认时间',
					        sortable:true,
					        dataIndex:"truetime",
					        renderer:function(value){
					    		if(value!=null)
					        	value=new Date(value.time).format('Y-m-d');
					        	return value;
					        }
					    },{ 
					        header:'确认人',
					        sortable:true,
					        dataIndex:"trueman"
					    },{
					        header:'状态',
					        sortable:true,
					        dataIndex:"istrue",
					        renderer:function(value){
					        	if(value==0){return "<font color=red>未确认</font>"};
					        	if(value==1){return "<font color=blue>已确认</font>"};
					        }
					    }]);
					    var reader=new Ext.data.JsonReader({
					        totalProperty:"totalCount",
					        root:"data",
					        autoLoad:true,
					        fields:[{
					            name : 'id'
					        },{
					            name : 'submitdate'
					        },{
					            name : 'submitman'
					        },{
					            name : 'status'
					        },{
					        	name : 'unitid'
					        },{
					        	name : 'trueman'
					        },{
					        	name : 'truetime'
					        },{
					        	name : 'istrue'
					        }]
					    });
					    var ds=new Ext.data.Store({
					        scopte:this,
					        url:'main/plate.html?action=getSubmitList',
					        baseParams:{status:1},
					        reader:reader,
					        sortInfo:{
					            field:'id',
					            direction:'DESC'
					        }
					    });
					    Ext.apply(this,{
					        id:'plateMgrMadewin',
					        plain:true,
					        layout:'fit',
					        border:false,
					        cm:cm,
					        sm:sm,
					        frame:true,
					        store:ds,
					        loadMask:true,
					        tbar:[
				//          {
				//        	id:"addChangeBatBtn",
				//        	text:"提取补牌的批次",
				//        	iconCls:"icon-Add",
				//        	handler:function(){
				//        		Ext.Msg.show({
				//        			title:'系统确认',
				//        			msg:'你是否确认提取补牌的一批号牌需求?',
				//        			buttons:Ext.Msg.YESNO,
				//        			scope:this,
				//        			icon:Ext.MessageBox.QUESTION,
				//        			fn:function(btn){
				//        			   if(btn=="yes"){
				//        				   Ext.Ajax.request({
				//        					  url:"main/plate.html?action=addChangeNewBat",
				//        					  method:"post",
				//        					  success:function(resp){//显示的时候还有问题
				//        					   	var result = Ext.util.JSON.decode(resp.responseText);
				//        					   	if(result.success == true){
				//        					   		Ext.MessageBox.alert("提示","已成功添加补牌号牌的批次");
				//        					   		ds.reload(); 
				//        					   	}
				//        					   	if(result.failure==true){
				//        				   			Ext.Msg.alert("警告","<font color=red>"+result.reason+"</font>");  
				//        				   		}
				//        				   	  }                       				   	  
				//        				   });
				//        			   }
				//        			}
				//        		});
				//        	}
				//        },
				        {
				        	id:"addNewBatBtn",
				        	text:"添加新的批次",
				        	iconCls:"icon-Add",
				        	handler:function(){
				        	Ext.Msg.show({
				                        title:'系统确认',
				                        msg:'你是否确认添加新的一批号牌需求?',
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
				                                    url:"main/plate.html?action=addNewBat",
				                                    method:"post",
				                                    success:function(){
				                                    mask.hide();
				                                        Ext.MessageBox.alert("提示","已成功添加新的批次");
				                                        ds.reload();
				//                                        var dsnew=new Ext.data.Store({
				//                                            scopte:this,
				//                                            url:'main/plate.html?action=getSubmitList',
				//                                            reader:reader,
				//                                            sortInfo:{
				//                                                field:'id',
				//                                                direction:'DESC'
				//                                            }
				//                                        });
				//                                        dsnew.load();
				//                                        var record=dsnew.getAt(0).data;
				//                                        Ext.Msg.alert("提示",record.id+":"+record.status+record.submitman);
				//                                        Ynzc.manage.psid=record.id;
				//                                        Ynzc.manage.status=record.status;
				//                                        new Ynzc.manage.PlateSubmitWin().show(Ext.getCmp("addPlateBtn").getEl());
				                                    },
				                                    faliure:function(){
				                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
				                                    },
				                                    params:{
				                                        status:1
				                                    }
				                             });
				                            }
				                        }
				                });            
				        	}
				        },{
				        	id:"addPlateBtn",
				        	text:"批次制作号牌",
							iconCls:"icon-search",
				        	handler:function(){
				        		var selections=this.selModel.getSelections();
				                var n=selections.length;
				                if(n==0){
				                    Ext.MessageBox.alert("提示","请选中要查看或修改的批次!");
				                    return;
				                }
				                if(n>1){
				                	Ext.MessageBox.alert("提示","每次只能处理一个批次!");
				                    return;
				                }
				                for(i=0;i<n;i++){
				                    if(selections[i].data.istrue!=0){
				                      Ext.MessageBox.alert("提示","该批次已制作无法再次制作!");
				                      return;
				                    }
				                }
				                var record=selections[0].data;
//				                if(record.status ==4){
//				                	Ynzc.manage.cpsid= record.id;
//				                	Ynzc.manage.cstatus = record.status;
//				                	new Ynzc.manage.PlateSubmitChangeWin().show(Ext.getCmp("addPlateBtn").getEl());
//				                }else{
				                	Ynzc.manage.pid=record.id;
				                	Ynzc.manage.status=record.status;
				                	Ynzc.manage.istrue=record.istrue;
				                	Ynzc.manage.winid='platemgrmadewin';
				                	new Ynzc.manage.PlateWin().show(Ext.getCmp("addPlateBtn").getEl());
//				                }
				        	}.createDelegate(this)
				        },{
				        	text:"删除批次",
				        	iconCls:"icon-del",
				        	handler:function(){
				        		var selections=this.selModel.getSelections();
				                var n=selections.length;
				                if(n==0){
				                    Ext.MessageBox.alert("提示","请选中要删除的批次!");
				                    return;
				                }
				                var rds=[];
				                for(i=0;i<n;i++){
				                	if(selections[i].data.status==0){
				                      rds.push(selections[i].data);
				                    }else{
				                      Ext.MessageBox.alert("提示","部分记录不能删除!");
				                      return;  
				                    }
				                }
				            	Ext.Msg.show({
				                        title:'系统确认',
				                        msg:'你是否确认删除选中的批次?',
				                        buttons:Ext.Msg.YESNO,
				                        scope:this,
				                        icon : Ext.MessageBox.QUESTION,
				                        fn:function(btn){
				                            if(btn=="yes"){
				                            	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在录入数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
				                                Ext.Ajax.request({
				                                    url:"main/plate.html?action=delBat",
				                                    method:"post",
				                                    success:function(){
				                                    mask.hide();
				                                        Ext.MessageBox.alert("提示","已成功删除可以删除的批次");
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
				        }
				        ,{
				        	text:"查看制作号牌",
				        	iconCls:"icon-submit",
				        	handler:function(){
				        		var selections=this.selModel.getSelections();
				                var n=selections.length;
				                if(n==0){
				                    Ext.MessageBox.alert("提示","请选中提交的批次!");
				                    return;
				                }
				                if(n>1){
				                	Ext.MessageBox.alert("提示","每次只能处理一个批次!");
				                    return;
				                }
				                for(i=0;i<n;i++){
				                    if(selections[i].data.istrue!=1){
				                      Ext.MessageBox.alert("提示","该批次尚未制作无法查看!");
				                      return;
				                    }
				                }
				                var record=selections[0].data;
				                Ynzc.manage.pid=record.id;
			                	Ynzc.manage.status=record.status;
			                	Ynzc.manage.istrue=record.istrue;
			                	new Ynzc.manage.PlateInfoWin().show(Ext.getCmp("addPlateBtn").getEl());
				        	}.createDelegate(this)
				        }
				//        ,{
				//        	text:"入库",
				//        	iconCls:"icon-submit",
				//        	handler:function(){
				//        		var selections=this.selModel.getSelections();
				//                var n=selections.length;
				//                if(n==0){
				//                    Ext.MessageBox.alert("提示","请选中入库的批次!");
				//                    return;
				//                }
				//                var rds=[];
				//                for(i=0;i<n;i++){
				//                    if(selections[i].data.status==2){
				//                      rds.push(selections[i].data);
				//                    }else{
				//                      Ext.MessageBox.alert("提示","部分记录已入库,不会重复入库!");
				//                    }
				//                }
				//                Ext.Msg.show({
				//                    title:'系统确认',
				//                    msg:'你是否确认分配?分配后不可再编辑。',
				//                    buttons:Ext.Msg.YESNO,
				//                    scope:this,
				//                    icon : Ext.MessageBox.QUESTION,
				//                    fn:function(btn){
				//                        if(btn=="yes"){
				//                            Ext.Ajax.request({
				//                                url:"main/plate.html?action=congressLaid",
				//                                method:"post",
				//                                success:function(){
				//                                    Ext.MessageBox.alert("提示","已成功分配选中的批次");
				//                                    ds.reload();
				//                                },
				//                                faliure:function(){
				//                                    Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
				//                                },
				//                                params:{
				//                                	dellist:Ext.util.JSON.encode(rds)
				//                                }
				//                            });
				//                        }
				//                    }
				//            }); 
				//        }.createDelegate(this)
				//        }
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
                    Ynzc.manage.PlateMgrMadeWin.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20,
                            status:1
                        }
                    });
                }
});
Ext.reg('platemgrmadewin',Ynzc.manage.PlateMgrMadeWin);