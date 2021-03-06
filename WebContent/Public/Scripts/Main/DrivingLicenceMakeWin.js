Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.DrivingLicenceMakeWin=Ext.extend(Ext.Window,{
	id:"drivingLicenceMakeWin",
	initComponent:function(){
		var drivingLicence=new Ext.data.JsonReader({
	        totalProperty:"totalCount",
	        root:"data",
	        autoLoad:true,
	        fields:[{
                name : 'id'
            },{
                name : 'drivingLicenceId'
            },{
                name : 'peccancyDate'
            },{
                name : 'penaltyNo'
            },{
                name : 'mark'
            },{
                name : 'tipstaff'
            },{
                name : 'transactor'
            },{
                name : 'transactorDate'
            },{
                name : 'year'
            },{
                name : 'writeUserId'
            },{
                name : 'writeDate'
            }]
	    });
		
		var ds=new Ext.data.Store({
	        scopte:this,
	        url:'main/driverMark.html?action=getDriverMark',
	        reader:drivingLicence,
	        sortInfo:{
	            field:'id',
	            direction:'DESC'
	        }
	    });
		
		var DriverInfoPanel = new Ext.Panel({
			id:"driverInfoWin",
            border:false,
            layout:'fit',
            height:.5,
            items:[{
				layout:"column",
				frame:true,
				autoScroll:true,
				items:[{
					columnWidth:.8,
					labelWidth:60,
					baseCls:"x-plain",
					heigth:'auto',
					layout:"column",
					items:[{
						columnWidth:.5,
						labelWidth:60,
						baseCls:"x-plain",
						height:'auto',
						layout:"form",
						items:[{
							id:"peopleName",
							readOnly:true,
							fieldLabel:"姓名",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						labelWidth:60,
						baseCls:"x-plain",
						height:'auto',
						layout:"form",
						items:[{
							id:"sex",
							readOnly:true,
							fieldLabel:"性别",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						labelWidth:60,
						baseCls:"x-plain",
						height:'auto',
						layout:"form",
						items:[{
							id:"linkTel",
							readOnly:true,
							fieldLabel:"联系电话",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						labelWidth:60,
						baseCls:"x-plain",
						height:'auto',
						layout:"form",
						items:[{
							id:"degree",
							readOnly:true,
							fieldLabel:"文化程度",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						labelWidth:60,
						baseCls:"x-plain",
						height:'auto',
						layout:"form",
						items:[{
							id:"drivingLicenceNo",
							readOnly:true,
							fieldLabel:"驾驶号",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						labelWidth:60,
						baseCls:"x-plain",
						height:'auto',
						layout:"form",
						items:[{
							id:"drivingLicenceTypeId",
							readOnly:true,
							fieldLabel:"驾照类型",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						height:'auto',
						labelWidth:60,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"mark",
							readOnly:true,
							fieldLabel:"分数",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						height:'auto',
						labelWidth:60,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"userState",
							readOnly:true,
							fieldLabel:"使用状态",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						height:'auto',
						labelWidth:60,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"startDate",
							readOnly:true,
							fieldLabel:"开始日期",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						height:'auto',
						labelWidth:60,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"endDate",
							readOnly:true,
							fieldLabel:"结束日期",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						height:'auto',
						labelWidth:60,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"drivingLicenceFlag",
							readOnly:true,
							fieldLabel:"是否打印",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.5,
						height:'auto',
						labelWidth:60,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"putOutDate",
							readOnly:true,
							fieldLabel:"打印日期",
							labelWidth:60,
							xtype:"textfield",
							anchor:'98%'
						}]
					}]
				},{
					columnWidth:.2,
					height:'auto',
					labelWidth:60,
					baseCls:"x-plain",
					layout:"form",
					items:[{
						 id:"picture",
		                   xtype:'box',
		                   height:150,
		                   width:90,
		                   anchor:'92%',
		                   autoEl:{
		                   	  tag:'img',
		                   	  src:'./Public/Images/sys/noupload.gif'
							}
					}]
				},{
					columnWidth:.5,
					height:'auto',
					labelWidth:60,
					baseCls:"x-plain",
					layout:"form",
					items:[{
						id:"idCard",
						readOnly:true,
						fieldLabel:"身份证",
						labelWidth:60,
						xtype:"textfield",
						anchor:'98%'
					}]
				},{
					columnWidth:.5,
					height:'auto',
					labelWidth:60,
					baseCls:"x-plain",
					layout:"form",
					items:[{
						id:"checkResultFlag",
						readOnly:true,
						fieldLabel:"检查结果",
						labelWidth:60,
						xtype:"textfield",
						anchor:'98%'
					}]
				},{
					columnWidth:1,
					height:'auto',
					labelWidth:60,
					baseCls:"x-plain",
					layout:"form",
					items:[{
						id:"address",
						readOnly:true,
						fieldLabel:"家庭地址",
						labelWidth:60,
						xtype:"textfield",
						anchor:'99%'
					}]
				}]
			}]
		});		
		var DirvingLicenceMakeGrid = new Ext.grid.GridPanel({
			id:"dirvingLicenceMakeGrid",
			plain:true,
            border:false,
            autoScroll:true,
            width:.5,
            cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
		            header:'处罚No',
		            sortable:true,
		            dataIndex:"penaltyNo"
		        },{
		            header:'执法人员',
		            sortable:true,
		            dataIndex:"tipstaff"
		        },{
		            header:'经办人',
		            sortable:true,
		            dataIndex:"transactor"
		        },{
		            header:'经办时间',
		            sortable:true,
		            dataIndex:"transactorDate",
		            renderer:function(value){
		        		value=new Date(value.time).format('Y-m-d');
		        		return value;
	    			}
		        },{
		            header:'扣分',
		            sortable:true,
		            dataIndex:"mark"
		        },{
		            header:'违章时间',
		            sortable:true,
		            dataIndex:"peccancyDate",
		            renderer:function(value){
		        		value=new Date(value.time).format('Y-m-d');
		        		return value;
	    			}
		        }
		    ]),
            sm:new Ext.grid.CheckboxSelectionModel(),
            frame:true,
            store:ds,
            loadMask:true,
            viewConfig:{
                forceFit:true
            },
            plugins:new Ext.ux.grid.Search({
            	width:120,
            	iconCls:false
            }),
            tbar:[{
                id:'dirvingLicenceMakeWorkAdd',
                text:'违章记录添加',
                iconCls:'icon-Add',
                handler:function(){
                	var addWin = new Ynzc.manage.DrivingLicenceMakeWorkWin();
                	addWin.show(Ext.getCmp("drivingLicenceMakeWin").getEl());
                }
            }],
            bbar:new Ext.PagingToolbar({
                pageSize:5,
                store:ds,
                displayInfo:true,
                displayMsg : '共 {2} 条',
                emptyMsg : '无记录'
            }),
            viewConfig:{
                forceFit:true
            }
		});		
		Ext.apply(this,{
			id:"drivingLicenceMakeWin",
			title:"驾驶员积分管理",
			height:500,
			width:600,
			autoScroll:true,
			resizable:false,
			modal:true,
			items:[{
				height:234,
				width:'auto',
				layout:'fit',
				items:DriverInfoPanel
			},{
				height:234,
				width:'auto',
				layout:'fit',
				items:DirvingLicenceMakeGrid
			}]
		});		
		Ynzc.manage.DrivingLicenceMakeWin.superclass.initComponent.apply(this,arguments);		
		ds.baseParams.DrivingLicenceId = Ynzc.manage.DrivingLicenceId;
		ds.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});