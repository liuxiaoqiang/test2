Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.DrivingLicenceInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'drivingLicenceInfoGrid',
	initComponent:function(){
		var sm=new Ext.grid.CheckboxSelectionModel();
		var fm=Ext.form;
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
				'<table width="600" height="420" border="1" class="ynzcTableBlue">',
				'<tr><td colspan="5" align="center">驾驶员基本信息</td></tr>',
				'<tr><td>姓名</td><td>{[values.peopleName != null ? values.peopleName : ""]}</td><td>性别</td><td>{[values.sex != null ? values.sex : ""]}</td><td rowspan="7"><img src="{[values.picture != null ? values.picture : ""]}" width="100%" height="100%"/></td></tr>',
				'<tr><td>出生日期</td><td>{[values.birthday != null ? new Date(values.birthday.time).format("Y-m-d") : ""]}</td><td>身份证号</td><td>{[values.idCard != null ? values.idCard : ""]}</td></tr>',
				'<tr><td>暂住证</td><td>{[values.idStay != null ? values.idStay : ""]}</td><td>联系电话</td><td>{[values.linkTel != null ? values.linkTel : ""]}</td></tr>',
				'<tr><td>邮政编码</td><td>{[values.postalcode != null ? values.postalcode : ""]}</td><td>文化程度</td><td>{[values.degree != null ? values.degree : ""]}</td></tr>',
				'<tr><td>家庭地址</td><td colspan="3">{[values.address != null ? values.address : ""]}</td></tr>',
				'<tr><td>联系地址</td><td colspan="3">{[values.linkAddress != null ? values.linkAddress : ""]}</td></tr>',
				'<tr><td colspan="5" align="center">驾照信息</td></tr>',
				'<tr><td>驾驶证编号</td><td>{[values.drivingLicenceNo != null ? values.drivingLicenceNo : ""]}</td><td>驾驶型号</td><td colspan="2">{[values.drivingLicenceTypeId != null ? Ynzc.manage.ApplicationTypeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.drivingLicenceTypeId)).data.display : ""]}</td></tr>',
				'<tr><td>开始日期</td><td>{[values.startDate != null ? new Date(values.startDate.time).format("Y-m-d") : ""]}</td><td>结束日期</td><td colspan="2">{[values.endDate != null ? new Date(values.endDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td>驾照积分</td><td>{[values.mark != null ? values.mark : ""]}</td><td>驾照打印日期</td><td colspan="2">{[values.putOutDate != null ? new Date(values.putOutDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td colspan="5" align="center">驾照员健康状况</td></tr>',
				'<tr><td>身高</td><td>{[values.hight != null ? values.hight : ""]}</td><td>辨色力</td><td colspan="2">{[values.resolvingPowerFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.resolvingPowerFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体和颈椎</td><td>{[values.bodyNeck != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.bodyNeck)).data.display : ""]}</td><td>&nbsp;</td><td colspan="2">&nbsp;</td></tr>',
				'<tr><td>右眼视力</td><td>{[values.rightEyePwoer != null ? values.rightEyePwoer : ""]}</td><td>右眼矫正</td><td colspan="2">{[values.rightEyeRectificationFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.rightEyeRectificationFlag)).data.display : ""]}</td></tr>',
				'<tr><td>左眼视力</td><td>{[values.leftEyePwoer != null ? values.leftEyePwoer : ""]}</td><td>左眼矫正</td><td colspan="2">{[values.leftEyeRectificationFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.leftEyeRectificationFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右耳听力</td><td>{[values.rightEarPwoer != null ? values.rightEarPwoer : ""]}</td><td>左耳听力</td><td colspan="2">{[values.leftEarPwoer != null ? values.leftEarPwoer : ""]}</td></tr>',
				'<tr><td>右手</td><td>{[values.rightHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightHandFlag)).data.display : ""]}</td><td>左手</td><td colspan="2">{[values.leftHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftHandFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右脚</td><td>{[values.rightLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightLagFlag)).data.display : ""]}</td><td>左脚</td><td colspan="2">{[values.leftLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftLagFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体检查时间</td><td>{[values.bodyCheckDate != null ? new Date(values.bodyCheckDate.time).format("Y-m-d") : ""]}</td><td>检查机构</td><td colspan="2">{[values.checkOrganization != null ? values.checkOrganization : ""]}</td></tr>',
				'<tr><td>检查医生</td><td>{[values.checkDoctor != null ? values.checkDoctor : ""]}</td><td>检查结果</td><td colspan="2">{[values.checkResultFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.checkResultFlag)).data.display : ""]}</td></tr>',
				'</table>'
			)
		});
	    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
	        header:'姓名',
	        sortable:true,
	        dataIndex:"peopleName"
	    },{
	        header:'性别',
	        sortable:true,
	        dataIndex:"sex"
	    },{
	    	header:'驾驶号',
	        sortable:true,
	        dataIndex:"drivingLicenceNo"
	    },{
	        header:'驾照类型',
	        sortable:true,
	        dataIndex:"drivingLicenceTypeId",
            renderer : function(value) {
                var index = Ynzc.manage.ApplicationTypeStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.ApplicationTypeStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
	    },{
	        header:'开始日期',
	        sortable:true,
	        dataIndex:"startDate",
            renderer:function(value){
		    	if(value != null){
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
		    	}else{
		    		return "";
		    	}
			}
	    },{
	        header:'结束日期',
	        sortable:true,
	        dataIndex:"endDate",
            renderer:function(value){
		    	if(value != null){
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
		    	}else{
		    		return "";
		    	}
			}
	    },{
	        header:'身份证',
	        sortable:true,
	        dataIndex:"idCard"
	    },{
	        header:'身体检查结果',
	        sortable:true,
	        dataIndex:"checkResultFlag",
            renderer:function(value){
	        	if(value > 0){
	        		return "合格";
	        	}else{
	        		return "不合格";
	        	}
	    	}
	    },{
	        header:'是否打印',
	        sortable:true,
	        dataIndex:"drivingLicenceFlag",
            renderer:function(value){
	        	if(value > 0){
	        		return "已打印";
	        	}else{
	        		return "未打印";
	        	}
	    	}
	    },{
	        header:'打印日期',
	        sortable:true,
	        dataIndex:"putOutDate",
            renderer:function(value){
		    	if(value != null){
		        	value=new Date(value.time).format('Y-m-d');
		        	return value;
		    	}else{
		    		return "";
		    	}
			}
	    },{
	        header:'使用状态',
	        sortable:true,
	        dataIndex:"userState",
            renderer : function(value) {
                var index = Ynzc.manage.UserStateStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.UserStateStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
	    }]);
	    var reader=new Ext.data.JsonReader({
	        totalProperty:"totalCount",
	        root:"data",
	        autoLoad:true,
	        fields:[{
	            name : 'id'
	        },{
	            name : 'peopleInfoId'
	        },{
	            name : 'bodyInfoId'
	        },{
	            name : 'drivingLicenceNo'
	        },{
	            name : 'drivingLicenceTypeId'
	        },{
	            name : 'mark'
	        },{
	            name : 'startDate'
	        },{
	            name : 'endDate'
	        },{
	            name : 'drivingLicenceFlag'
	        },{
	            name : 'putOutDate'
	        },{
	            name : 'userState'
	        },{
	            name : 'peopleName'
	        },{
	            name : 'sex'
	        },{
	            name : 'birthday'
	        },{
	            name : 'idCard'
	        },{
	            name : 'idStay'
	        },{
	            name : 'address'
	        },{
	            name : 'linkAddress'
	        },{
	            name : 'linkTel'
	        },{
	            name : 'postalcode'
	        },{
	            name : 'nativePlace'
	        },{
	            name : 'degree'
	        },{
	            name : 'picture'
	        },{
	            name : 'hight'
	        },{
	            name : 'resolvingPowerFlag'
	        },{
	            name : 'rightEyePwoer'
	        },{
	            name : 'rightEyeRectificationFlag'
	        },{
	            name : 'leftEyePwoer'
	        },{
	            name : 'leftEyeRectificationFlag'
	        },{
	            name : 'rightEarPwoer'
	        },{
	            name : 'leftEarPwoer'
	        },{
	            name : 'rightHandFlag'
	        },{
	            name : 'leftHandFlag'
	        },{
	            name : 'rightLagFlag'
	        },{
	            name : 'leftLagFlag'
	        },{
	            name : 'bodyNeck'
	        },{
	            name : 'bodyCheckDate'
	        },{
	            name : 'checkResultFlag'
	        },{
	            name : 'checkOrganization'
	        },{
	            name : 'checkDoctor'
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
            url:'main/driverMark.html?action=getDrivingLicence',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
        	id:'drivingLicenceInfoGrid',
        	plain:true,
        	layout:'fit',
        	border:false,
        	cm:cm,
        	sm:sm,
        	frame:true,
        	store:ds,
        	loadMask:true,
        	plugins:[expand,new Ext.ux.grid.Search({
        		width:200,
        		iconCls:false
        	})],
        	tbar:[{
        		text:"积分管理",
        		iconCls:"icon-Add",
        		handler:function(){
	        		var selections=this.selModel.getSelections();
	        		var n=selections.length;
	        		if(n == 0){
	        			Ext.MessageBox.alert("提示","请选中驾驶员!");
	        			return;
	        		}
	        		if(n > 1){
	        			Ext.MessageBox.alert("提示","驾驶员选择过多!");
	        			return;
	        		}
	        		if(selections[0].data.drivingLicenceFlag < 1){
	        			Ext.MessageBox.alert("提示","驾照还未打印!");
	        			return;
	        		}
	        		if(selections[0].data.userState == 3){
	        			Ext.MessageBox.alert("提示","驾照已转出!");
	        			return;
	        		}
	        		if(selections[0].data.userState == 4){
	        			Ext.MessageBox.alert("提示","驾照已注销!");
	        			return;
	        		}
                	var addWin = new Ynzc.manage.DrivingLicenceMakeWin();
                	addWin.show();
                    Ynzc.manage.DrivingLicenceId=selections[0].data.id;
                    Ext.getCmp("peopleName").setValue(selections[0].data.peopleName);
                    Ext.getCmp("sex").setValue(selections[0].data.sex);
                    Ext.getCmp("address").setValue(selections[0].data.address);
                    Ext.getCmp("linkTel").setValue(selections[0].data.linkTel);
                    Ext.getCmp("degree").setValue(selections[0].data.degree);
                    Ext.getCmp("drivingLicenceNo").setValue(selections[0].data.drivingLicenceNo);
                    Ext.getCmp("drivingLicenceTypeId").setValue(selections[0].data.drivingLicenceTypeId);
                    Ext.getCmp("startDate").setValue(new Date(selections[0].data.startDate.time).format('Y-m-d'));
                    Ext.getCmp("endDate").setValue(new Date(selections[0].data.endDate.time).format('Y-m-d'));
                    Ext.getCmp("idCard").setValue(selections[0].data.idCard);
                    Ext.getCmp("mark").setValue(selections[0].data.mark);
                    if(selections[0].data.checkResultFlag == 1){
                    	Ext.getCmp("checkResultFlag").setValue("合格");
                    }else{
                    	Ext.getCmp("checkResultFlag").setValue("不合格");
                    }
                    if(selections[0].data.drivingLicenceFlag == 1){
                    	Ext.getCmp("drivingLicenceFlag").setValue("已打印");
                    }else{
                    	Ext.getCmp("drivingLicenceFlag").setValue("未打印");
                    }
                    Ext.getCmp("putOutDate").setValue(new Date(selections[0].data.putOutDate.time).format('Y-m-d'));
                    if(selections[0].data.userState == 1){
                    	Ext.getCmp("userState").setValue("可用");
                    }else{
                    	Ext.getCmp("userState").setValue("不可用");
                    }
                    Ext.getCmp("picture").getEl().dom.src=selections[0].data.picture;
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
        Ynzc.manage.DrivingLicenceInfoGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
        	params:{
	        	start:0,
	        	limit:20
        	}
        });
        this.on("rowdblclick",function(grid,index,event){
            var record=grid.getStore().getAt(index);
    		if(record.data.drivingLicenceFlag < 1){
    			Ext.MessageBox.alert("提示","驾照还未打印!");
    			return;
    		}
    		if(record.data.userState > 2){
    			Ext.MessageBox.alert("提示","驾照已转出!");
    			return;
    		}
            new Ynzc.manage.DrivingLicenceMakeWin().show();
            Ynzc.manage.DrivingLicenceId=record.data.id;
            Ext.getCmp("peopleName").setValue(record.data.peopleName);
            Ext.getCmp("sex").setValue(record.data.sex);
            Ext.getCmp("address").setValue(record.data.address);
            Ext.getCmp("linkTel").setValue(record.data.linkTel);
            Ext.getCmp("degree").setValue(record.data.degree);
            Ext.getCmp("drivingLicenceNo").setValue(record.data.drivingLicenceNo);
            Ext.getCmp("drivingLicenceTypeId").setValue(record.data.drivingLicenceTypeId);
            Ext.getCmp("startDate").setValue(new Date(record.data.startDate.time).format('Y-m-d'));
            Ext.getCmp("endDate").setValue(new Date(record.data.endDate.time).format('Y-m-d'));
            Ext.getCmp("idCard").setValue(record.data.idCard);mark
            Ext.getCmp("mark").setValue(record.data.mark);
            if(record.data.checkResultFlag == 1){
            	Ext.getCmp("checkResultFlag").setValue("合格");
            }else{
            	Ext.getCmp("checkResultFlag").setValue("不合格");
            }
            if(record.data.drivingLicenceFlag == 1){
            	Ext.getCmp("drivingLicenceFlag").setValue("已打印");
            }else{
            	Ext.getCmp("drivingLicenceFlag").setValue("未打印");
            }
            Ext.getCmp("putOutDate").setValue(new Date(record.data.putOutDate.time).format('Y-m-d'));
            if(record.data.userState == 1){
            	Ext.getCmp("userState").setValue("可用");
            }else{
            	Ext.getCmp("userState").setValue("不可用");
            }
            Ext.getCmp("picture").getEl().dom.src=record.data.picture;
        });
	}
});
Ext.reg('drivingLicenceInfoGrid',Ynzc.manage.DrivingLicenceInfoGrid);