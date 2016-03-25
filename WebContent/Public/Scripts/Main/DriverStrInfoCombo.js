Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DriverStrInfoCombo=Ext.extend(Ext.form.ComboBox,{
	id:'driverStrInfoCombo',
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
		
		var ebDs=new Ext.data.Store({
            scopte:this,
            baseParams:{psid:Ynzc.manage.psid},
            url:'main/peopleInfo.html?action=getDriverStrInfoToSelect',
            reader:ebReader,
            sortInfo:{
                field:'id',
                direction:'ASC'
            }
        });
        
		var PeopleInfoGrid=new Ext.grid.GridPanel({
			 id:"ebgrid",
			 plain:true,
             border:false,
             width:462,
             height:200,
             autoScroll:true,
             cm:new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
                 header:'姓名',
                 sortable:true,
                 dataIndex:"peopleName"
             },{
                 header:'身份证',
                 sortable:true,
                 dataIndex:"idCard"
             }]),
             sm:new Ext.grid.CheckboxSelectionModel(),
             frame:true,
             store:ebDs,
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
                 store:ebDs,
                 displayInfo:true,
                 displayMsg : '共 {2} 条',
                 emptyMsg : '无记录'
             }),
             listeners:{"rowdblclick":function(grid,index,event){
         	 	var record=grid.getStore().getAt(index);
         	 	this.setValue(record.data.peopleName);
         	 	this.selectValue = record.data.id;
         	 	this.collapse();
                var mask = new Ext.LoadMask(Ext.getBody(), {
		     		msg : '正在登录,请稍等...',
		     		removeMask:true
                });
                mask.show();
                Ext.Ajax.request({
                    url:"main/peopleInfo.html?action=findPeopleInfoById",
                    method:"post",
                    success:function(response){
                		var record = Ext.util.JSON.decode(response.responseText);
                		if(record != null){
                			if(record.model != null){
	                    		Ext.getCmp("peopleName").setValue(record.model.peopleName);
	                            Ext.getCmp("sex").setValue(record.model.sex);
	                            Ext.getCmp("birthday").setValue(new Date(record.model.birthday.time).format('Y-m-d'));
	                            Ext.getCmp("idCard").setValue(record.model.idCard);
	                            Ext.getCmp("idStay").setValue(record.model.idStay);
	                            Ext.getCmp("address").setValue(record.model.address);
	                            Ext.getCmp("linkAddress").setValue(record.model.linkAddress);
	                            Ext.getCmp("linkTel").setValue(record.model.linkTel);
	                            Ext.getCmp("postalcode").setValue(record.model.postalcode);
	                            Ext.getCmp("degree").setValue(record.model.degree);
	                            Ext.getCmp("picture").getEl().dom.src = record.model.picture;
	                            Ext.getCmp("hight").setValue(record.model.hight);
	                            if(record.model.resolvingPowerFlag>0){
	                            	Ext.getCmp("resolvingPowerFlag").setValue("正常");
	                            }else{
	                            	Ext.getCmp("resolvingPowerFlag").setValue("异常");
	                            }
	                            Ext.getCmp("rightEyePwoer").setValue(record.model.rightEyePwoer);
	                            if(record.model.rightEyeRectificationFlag>0){
	                            	Ext.getCmp("rightEyeRectificationFlag").setValue("是");
	                            }else{
	                            	Ext.getCmp("rightEyeRectificationFlag").setValue("否");
	                            }
	                            Ext.getCmp("leftEyePwoer").setValue(record.model.leftEyePwoer);
	                            if(record.model.rightEyeRectificationFlag>0){
	                            	Ext.getCmp("leftEyeRectificationFlag").setValue("是");
	                            }else{
	                            	Ext.getCmp("leftEyeRectificationFlag").setValue("否");
	                            }
	                            if(record.model.rightEarPwoer>0){
	                            	Ext.getCmp("rightEarPwoer").setValue("正常");
	                            }else{
	                            	Ext.getCmp("rightEarPwoer").setValue("异常");
	                            }
	                            if(record.model.leftEarPwoer>0){
	                            	Ext.getCmp("leftEarPwoer").setValue("正常");
	                            }else{
	                            	Ext.getCmp("leftEarPwoer").setValue("异常");
	                            }
	                            if(record.model.rightHandFlag>0){
	                            	Ext.getCmp("rightHandFlag").setValue("正常");
	                            }else{
	                            	Ext.getCmp("rightHandFlag").setValue("异常");
	                            }
	                            if(record.model.leftHandFlag>0){
	                            	Ext.getCmp("leftHandFlag").setValue("正常");
	                            }else{
	                            	Ext.getCmp("leftHandFlag").setValue("异常");
	                            }
	                            if(record.model.rightLagFlag>0){
	                            	Ext.getCmp("rightLagFlag").setValue("正常");
	                            }else{
	                            	Ext.getCmp("rightLagFlag").setValue("异常");
	                            }
	                            if(record.model.leftLagFlag>0){
	                            	Ext.getCmp("leftLagFlag").setValue("正常");
	                            }else{
	                            	Ext.getCmp("leftLagFlag").setValue("异常");
	                            }
	                            if(record.model.bodyNeck>0){
	                            	Ext.getCmp("bodyNeck").setValue("正常");
	                            }else{
	                            	Ext.getCmp("bodyNeck").setValue("异常");
	                            }
	                            Ext.getCmp("bodyCheckDate").setValue(new Date(record.model.bodyCheckDate.time).format('Y-m-d'));
	                            if(record.model.checkResultFlag>0){
	                            	Ext.getCmp("checkResultFlag").setValue("合格");
	                            }else{
	                            	Ext.getCmp("checkResultFlag").setValue("不合格");
	                            }
	                            Ext.getCmp("checkOrganization").setValue(record.model.checkOrganization);
	                            Ext.getCmp("checkDoctor").setValue(record.model.checkDoctor);
                			}
                			Ext.getCmp("fosterType").setValue("增训");
                			Ext.getCmp("drivingLicenceType").setValue(getOldDrivingLicenceType(record.driverStrModel.drivingLicenceTypeId.split("/")));
                    		mask.hide();
                		}
                    },
                    faliure:function(){
                    	Ext.MessageBox.alert("警告","<font color=red>与服务器通信失败!</font>");
                    },
                    params:{
                        id:Ext.getCmp("peopleInfoId").getMyValue()
                    }
            	});
             }.createDelegate(this)
             }});
	
		Ext.apply(this,{
			id:'driverStrInfoCombo',
			store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
			editable:false,   
			shadow:false,   
 			mode: 'local',   
    		triggerAction:'all',   
   			maxHeight: 200,   
	   		tpl: '<tpl for="."><div style="height:200px"><div id="peopleinfogrid"></div></div></tpl>',   
   			selectedClass:'',   
	   		onSelect:Ext.emptyFn
		});
		Ynzc.manage.DriverStrInfoCombo.superclass.initComponent.apply(this,arguments);
		this.on('expand',function(){   
			PeopleInfoGrid.render('peopleinfogrid');
		}); 
		ebDs.load({
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
			url:"main/peopleInfo.html?action=findPeopleInfoById",
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
Ext.reg("driverStrInfoCombo",Ynzc.manage.DriverStrInfoCombo)