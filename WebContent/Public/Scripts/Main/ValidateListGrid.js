Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ValidateListGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'validateListInfo',
	initComponent:function(){
		var sm=new Ext.grid.CheckboxSelectionModel();
		var fm=Ext.form;
		var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
			header:'目录编号',
			sortable:true,
			hidden:false,
			dataIndex:"dirNo"
		},{
            header:'注册日期',
            sortable:true,
            hidden:false,
            dataIndex:"registerDate",
            renderer:function(value){
            	value=new Date(value.time).format('Y-m-d');
             	return value;
            }
		},{
			header:'厂牌型号',
			sortable:true,
			hidden:false,
			dataIndex:"machineType"
		},{
			header:'许可证号',
			sortable:true,
			hidden:false,
			dataIndex:"license"
		},{
			header:'生产企业',
			sortable:true,
			hidden:false,
			dataIndex:"productor"
		},{
			header:'企业电话',
			sortable:true,
			hidden:false,
			dataIndex:"productorTel"
		},{
			header:'发动机品牌',
			sortable:true,
			hidden:false,
			dataIndex:"engineBrandId"
		}]);
		var reader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'dirNo'
            },{
                name : 'registerDate'
            },{
                name : 'machineType'
            },{
                name : 'machineNo'
            },{
                name : 'productor'
            },{
                name : 'carColor'
            },{
                name : 'license'
            },{
                name : 'productorAddress'
            },{
                name : 'productorPost'
            },{
                name : 'productorSeller'
            },{
                name : 'productorTel'
            },{
                name : 'sellerTelephone'
            },{
                name : 'photoDir'
            },{
                name : 'setRow'
            },{
                name : 'isAuto'
            },{
                name : 'shapeSize'
            },{
                name : 'containerSize'
            },{
                name : 'axisSize'
            },{
                name : 'power'
            },{
                name : 'wheelSize'
            },{
                name : 'drivers'
            },{
                name : 'directControl'
            },{
                name : 'topSpeed'
            },{
                name : 'fuelTypeId'
            },{
                name : 'fuelCost'
            },{
                name : 'wheelNo'
            },{
                name : 'allQuality'
            },{
                name : 'tiresSize'
            },{
                name : 'totalQuality'
            },{
                name : 'loadQuality'
            },{
                name : 'driverInNo'
            },{
                name : 'tilt'
            },{
                name : 'engineBrandId'
            },{
                name : 'steelSpring'
            }]
		});
		var ds=new Ext.data.Store({
            scopte:this,
            url:'main/validateList.html?action=getValidateList',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
		});
		Ext.apply(this,{
            id:'validateListInfo',
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
                id:'validateListAdd',
                text:'添加',
                iconCls:'icon-Add',
                handler:function(){
            		var addwin=new Ynzc.manage.ValidateListWin();
            		addwin.show(Ext.getCmp("validateListAdd").getEl());
            	}
            },'-',{
                id:"userDel",
                text:"删除",
                iconCls:"icon-Del",
                handler:function(){
	                var selections=this.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.ux.Toast.msg("提示","请选中要删除的验证目录!");
	                    return;
	                }
	                var rds=[];
                    for(i=0;i<n;i++){
                        rds.push(selections[i].data);
                    }
                    Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认删除选中的验证目录?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                    	if(btn=="yes"){
                            Ext.Ajax.request({
	                                url:"main/validateList.html?action=delValidateList",
	                                method:"post",
	                                success:function(){
	                                    Ext.ux.Toast.msg("提示","已成功删除选中的验证目录");
	                                    ds.reload();
	                                },
	                                faliure:function(){
	                                    Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
	                                },
	                                params:{
	                                    id:Ext.util.JSON.encode(rds)
	                                }
                            	});
                        	}
                    	}
                    });
            	}.createDelegate(this)
            },{
            	text:"打印测试",
            	handler:function(){
    			Ext.Ajax.request({
    				url:"main/report.html?action=getValidateListReportDataSource",
    				success:function(){
            			new Ext.Window({
            				title:"报表测试",
            				height:600,
            				width:700,
            				html:'<iframe src="./Pages/showReport.jsp" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>'
            			}).show();
    					}
    				});
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
        Ynzc.manage.ValidateListGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
    	this.on("rowdblclick",function(grid,index,event){
    		var record=grid.getStore().getAt(index);
    	    new Ynzc.manage.ValidateListUpdateWin().show(grid.getEl());
    	    Ynzc.manage.validateListId=record.data.id;
            Ext.getCmp("dirNo").setValue(record.data.dirNo);
            Ext.getCmp("registerDate").setValue(new Date(record.data.registerDate.time).format('Y-m-d'));
            Ext.getCmp("machineType").setValue(record.data.machineType);
            Ext.getCmp("machineNo").setValue(record.data.machineNo);
            Ext.getCmp("productor").setValue(record.data.productor);
            Ext.getCmp("carColor").setValue(record.data.carColor);
            Ext.getCmp("license").setValue(record.data.license);
            Ext.getCmp("productorAddress").setValue(record.data.productorAddress);
            Ext.getCmp("productorPost").setValue(record.data.productorPost);
            Ext.getCmp("productorSeller").setValue(record.data.productorSeller);
            Ext.getCmp("productorTel").setValue(record.data.productorTel);
            Ext.getCmp("sellerTelephone").setValue(record.data.sellerTelephone);
            Ext.getCmp("photoDir").setValue(record.data.photoDir);
            Ext.getCmp("setRow").setValue(record.data.setRow);
            Ext.getCmp("isAuto").setValue(record.data.isAuto);
            Ext.getCmp("shapeSize").setValue(record.data.shapeSize);
            Ext.getCmp("containerSize").setValue(record.data.containerSize);
            Ext.getCmp("axisSize").setValue(record.data.axisSize);
            Ext.getCmp("power").setValue(record.data.power);
            Ext.getCmp("wheelSize").setValue(record.data.wheelSize);
            Ext.getCmp("drivers").setValue(record.data.drivers);
            Ext.getCmp("directControl").setValue(record.data.directControl);
            Ext.getCmp("topSpeed").setValue(record.data.topSpeed);
            Ext.getCmp("fuelTypeId").setValue(record.data.fuelTypeId);
            Ext.getCmp("fuelCost").setValue(record.data.fuelCost);
            Ext.getCmp("wheelNo").setValue(record.data.wheelNo);
            Ext.getCmp("allQuality").setValue(record.data.allQuality);
            Ext.getCmp("tiresSize").setValue(record.data.tiresSize);
            Ext.getCmp("totalQuality").setValue(record.data.totalQuality);
            Ext.getCmp("loadQuality").setValue(record.data.loadQuality);
            Ext.getCmp("driverInNo").setValue(record.data.driverInNo);
            Ext.getCmp("tilt").setValue(record.data.tilt);
            Ext.getCmp("engineBrandId").setValue(record.data.engineBrandId);
            Ext.getCmp("steelSpring").setValue(record.data.steelSpring);
    	});
	}
});
Ext.reg('validateListGrid',Ynzc.manage.ValidateListGrid);