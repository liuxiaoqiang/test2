Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DrivingLincenceCombo=Ext.extend(Ext.form.ComboBox,{
	id:'drivingLincenceCombo',
	selectValue:null,
	initComponent:function(){
		var ebReader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'peopleName'
            },{
                name : 'idCard'
            }]
        });
		
		var ds=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.psid},
            url:'main/drivingLicence.html?action=getDrivingLicence',
            reader:ebReader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        
		var DrivingLicenceGrid=new Ext.grid.GridPanel({
			id:"drivingLicenceGrid",
			plain:true,
			border:false,
			width:470,
			height:395,
			autoScroll:true,
			cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
				header:'人员姓名',
				sortable:true,
				dataIndex:"peopleName"
			},{
				header:'身份证号码',
				sortable:true,
				dataIndex:"idCard"
			}]),
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
			tbar:[],
			bbar:new Ext.PagingToolbar({
				pageSize:5,
				store:ds,
				displayInfo:true,
				displayMsg : '共 {2} 条',
				emptyMsg : '无记录'
			}),
			listeners:{"rowdblclick":function(grid,index,event){
				var record=grid.getStore().getAt(index);
				this.setValue(record.data.peopleName);
         	 	this.selectValue = record.data.id;
         	 	this.collapse();
                Ext.Ajax.request({
                    url:"main/drivingLicence.html?action=drivingLicenceOperation",
                    method:"post",
                    success:function(response){
                		var result = Ext.util.JSON.decode(response.responseText);
                		if(result.success == true){
                			Ext.MessageBox.alert("提示",result.reason);
                			Ext.getCmp(Ynzc.manage.winName).close();
                		}else{
                			Ext.Ajax.request({
                                url:"main/drivingLicence.html?action=findDrivingLicenceById",
                                method:"post",
                                success:function(response){
                            		var result = Ext.util.JSON.decode(response.responseText);
                            		if(result != null){
                            			if(result.model != null){
                            				Ext.getCmp("drivingLicenceNo").setValue(result.model.drivingLicenceNo);
                            				Ext.getCmp("drivingLicenceTypeId").setValue(result.model.drivingLicenceTypeId);
                            				Ext.getCmp("startDate").setValue(new Date(result.model.startDate.time).format('Y-m-d'));
                            				Ext.getCmp("endDate").setValue(new Date(result.model.endDate.time).format('Y-m-d'));
                            				Ext.getCmp("drivingLicenceFlag").setValue(result.model.drivingLicenceFlag);
                            				Ext.getCmp("putOutDate").setValue(new Date(result.model.putOutDate.time).format('Y-m-d'));
                            				Ext.getCmp("userState").setValue(result.model.userState);
            	                    		Ext.getCmp("peopleName").setValue(result.model.peopleName);
            	                            Ext.getCmp("sex").setValue(result.model.sex);
            	                            Ext.getCmp("birthday").setValue(new Date(result.model.birthday.time).format('Y-m-d'));
            	                            Ext.getCmp("idCard").setValue(result.model.idCard);
            	                            Ext.getCmp("idStay").setValue(result.model.idStay);
            	                            Ext.getCmp("address").setValue(result.model.address);
            	                            Ext.getCmp("linkAddress").setValue(result.model.linkAddress);
            	                            Ext.getCmp("linkTel").setValue(result.model.linkTel);
            	                            Ext.getCmp("postalcode").setValue(result.model.postalcode);
            	                            Ext.getCmp("nativePlace").setValue(result.model.nativePlace);
            	                            Ext.getCmp("degree").setValue(result.model.degree);
            	                            Ext.getCmp("picture").getEl().dom.src = result.model.picture;
            	                            Ext.getCmp("hight").setValue(result.model.hight);
            	                            if(result.model.resolvingPowerFlag>0){
            	                            	Ext.getCmp("resolvingPowerFlag").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("resolvingPowerFlag").setValue("异常");
            	                            }
            	                            Ext.getCmp("rightEyePwoer").setValue(result.model.rightEyePwoer);
            	                            if(result.model.rightEyeRectificationFlag>0){
            	                            	Ext.getCmp("rightEyeRectificationFlag").setValue("是");
            	                            }else{
            	                            	Ext.getCmp("rightEyeRectificationFlag").setValue("否");
            	                            }
            	                            Ext.getCmp("leftEyePwoer").setValue(result.model.leftEyePwoer);
            	                            if(result.model.rightEyeRectificationFlag>0){
            	                            	Ext.getCmp("leftEyeRectificationFlag").setValue("是");
            	                            }else{
            	                            	Ext.getCmp("leftEyeRectificationFlag").setValue("否");
            	                            }
            	                            if(result.model.rightEarPwoer>0){
            	                            	Ext.getCmp("rightEarPwoer").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("rightEarPwoer").setValue("异常");
            	                            }
            	                            if(result.model.leftEarPwoer>0){
            	                            	Ext.getCmp("leftEarPwoer").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("leftEarPwoer").setValue("异常");
            	                            }
            	                            if(result.model.rightHandFlag>0){
            	                            	Ext.getCmp("rightHandFlag").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("rightHandFlag").setValue("异常");
            	                            }
            	                            if(result.model.leftHandFlag>0){
            	                            	Ext.getCmp("leftHandFlag").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("leftHandFlag").setValue("异常");
            	                            }
            	                            if(result.model.rightLagFlag>0){
            	                            	Ext.getCmp("rightLagFlag").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("rightLagFlag").setValue("异常");
            	                            }
            	                            if(result.model.leftLagFlag>0){
            	                            	Ext.getCmp("leftLagFlag").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("leftLagFlag").setValue("异常");
            	                            }
            	                            if(result.model.bodyNeck>0){
            	                            	Ext.getCmp("bodyNeck").setValue("正常");
            	                            }else{
            	                            	Ext.getCmp("bodyNeck").setValue("异常");
            	                            }
            	                            Ext.getCmp("bodyCheckDate").setValue(new Date(result.model.bodyCheckDate.time).format('Y-m-d'));
            	                            if(result.model.checkResultFlag>0){
            	                            	Ext.getCmp("checkResultFlag").setValue("合格");
            	                            }else{
            	                            	Ext.getCmp("checkResultFlag").setValue("不合格");
            	                            }
            	                            Ext.getCmp("checkOrganization").setValue(result.model.checkOrganization);
            	                            Ext.getCmp("checkDoctor").setValue(result.model.checkDoctor);
                            			}
                            		}
                                },
                                faliure:function(){
                                    Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                },
                                params:{
                                	drivingLicenceId:record.data.id
                                }
                        	});
                		}
                	},
                    faliure:function(){
                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                    },
                    params:{
                    	drivingLicenceId:record.data.id
                    }
                });
			}.createDelegate(this)
		}});
		Ext.apply(this,{
			id:'drivingLincenceCombo',
			store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
			editable:false,   
			shadow:false,   
 			mode: 'local',   
    		triggerAction:'all',   
   			maxHeight: 200,   
	   		tpl: '<tpl for="."><div style="height:200px"><div id="drivingLicenceGrid"></div></div></tpl>',   
   			selectedClass:'',   
	   		onSelect:Ext.emptyFn
		});
		Ynzc.manage.DrivingLincenceCombo.superclass.initComponent.apply(this,arguments);
		this.on('expand',function(){   
			DrivingLicenceGrid.render('drivingLicenceGrid');
		}); 
		ds.load({
			params:{
				start:0,
				limit:5
			}
		});
	},
	setMyValue:function(v){
		if(this.emptyText && this.el && v !== undefined && v !== null && v !== ''){
			this.el.removeClass(this.emptyClass);
		}
		var record=null;
		Ext.Ajax.request({
			url:"main/drivingLicence.html?action=findDrivingLicenceById",
			success:function(response){
				record=Ext.util.JSON.decode(response.responseText);
				if(record!==null){
					this.setValue(record.peopleName);
					this.selectValue=v;
				}
			}.createDelegate(this),
			failure:function(){
				return null;
			},
			params:{
				id:v
			}
		});
	},
	getMyValue:function(){
		return this.selectValue;
	}
});
Ext.reg("drivingLincenceCombo",Ynzc.manage.DrivingLincenceCombo)