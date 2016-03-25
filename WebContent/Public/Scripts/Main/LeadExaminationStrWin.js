Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.LeadExaminationStrWin=Ext.extend(Ext.Window,{
	id:"leadExaminationStrWin",
	initComponent:function(){
		var driverStrDate=new Ext.data.JsonReader({
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
                name : 'archivesNo'
             },{
                name : 'fosterType'
            },{
                name : 'applicationFlag'
            },{
                name : 'drivingLicenceTypeId'
            },{
                name : 'applicationAddress'
            },{
                name : 'examinationCode'
            },{
                name : 'pigeonholeFlag'
            },{
                name : 'pigeonholeDate'
            },{
                name : 'strState'
            },{
                name : 'theoryId'
            },{
                name : 'theoryFlag'
            },{
                name : 'practiceId'
            },{
                name : 'practiceFlag'
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
		
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
				'<table width="600" height="420" border="1" class="ynzcTableBlue">',
				'<table width="600" height="420" border="1" class="ynzcTableBlue">',
				'<tr><td>姓名</td><td>{[values.peopleName != null ? values.peopleName : ""]}</td><td>性别</td><td>{[values.sex != null ? values.sex : ""]}</td><td rowspan="7"><img src="{[values.picture != null ? values.picture : ""]}" width="100%" height="100%"/></td></tr>',
				'<tr><td>出生日期</td><td>{[values.birthday != null ? new Date(values.birthday.time).format("Y-m-d") : ""]}</td><td>身份证号</td><td>{[values.idCard != null ? values.idCard : ""]}</td></tr>',
				'<tr><td>暂住证</td><td>{[values.idStay != null ? values.idStay : ""]}</td><td>联系电话</td><td>{[values.linkTel != null ? values.linkTel : ""]}</td></tr>',
				'<tr><td>邮政编码</td><td>{[values.postalcode != null ? values.postalcode : ""]}</td><td>文化程度</td><td>{[values.degree != null ? values.degree : ""]}</td></tr>',
				'<tr><td>家庭地址</td><td colspan="3">{[values.address != null ? values.address : ""]}</td></tr>',
				'<tr><td>联系地址</td><td colspan="3">{[values.linkAddress != null ? values.linkAddress : ""]}</td></tr>',
				'<tr><td>报考号</td><td>{[values.examinationCode != null ? values.examinationCode : ""]}</td><td>培养类型</td><td colspan="2">{[values.fosterType != null ? Ynzc.manage.FosterTypeStore.getAt(Ynzc.manage.FosterTypeStore.find("value", values.fosterType)).data.display : ""]}</td></tr>',
				'<tr><td>申请地址</td><td>{[values.applicationAddress != null ? values.applicationAddress : ""]}</td><td>申请型号</td><td colspan="2">{[values.drivingLicenceTypeId != null ? Ynzc.manage.ApplicationTypeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.drivingLicenceTypeId)).data.display : ""]}</td></tr>',
				'<tr><td>身高</td><td>{[values.hight != null ? values.hight : ""]}</td><td>辨色力</td><td colspan="2">{[values.resolvingPowerFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.resolvingPowerFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体和颈椎</td><td>{[values.bodyNeck != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.bodyNeck)).data.display : ""]}</td><td>&nbsp;</td><td colspan="2">&nbsp;</td></tr>',
				'<tr><td>右眼视力</td><td>{[values.rightEyePwoer != null ? values.rightEyePwoer : ""]}</td><td>右眼矫正</td><td colspan="2">{[values.rightEyeRectificationFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.rightEyeRectificationFlag)).data.display : ""]}</td></tr>',
				'<tr><td>左眼视力</td><td>{[values.leftEyePwoer != null ? values.leftEyePwoer : ""]}</td><td>左眼矫正</td><td colspan="2">{[values.leftEyeRectificationFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.leftEyeRectificationFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右耳听力</td><td>{[values.rightEarPwoer != null ? values.rightEarPwoer : ""]}</td><td>左耳听力</td><td colspan="2">{[values.leftEarPwoer != null ? values.leftEarPwoer : ""]}</td></tr>',
				'<tr><td>右手</td><td>{[values.rightHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightHandFlag)).data.display : ""]}</td><td>左手</td><td colspan="2">{[values.leftHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftHandFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右脚</td><td>{[values.rightLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightLagFlag)).data.display : ""]}</td><td>左脚</td><td colspan="2">{[values.leftLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftLagFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体检查时间</td><td>{[values.bodyCheckDate != null ? new Date(values.bodyCheckDate.time).format("Y-m-d") : ""]}</td><td>检查机构</td><td colspan="2">{[values.checkOrganization != null ? values.checkOrganization : ""]}</td></tr>',
				'<tr><td>检查医生</td><td>{[values.checkDoctor != null ? values.checkDoctor : ""]}</td><td>检查结果</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.checkResultFlag)).data.display]}</td></tr>',
				'</table>'
			)
		});
		
		var StrDs=new Ext.data.Store({
	        scopte:this,
	        url:'main/driverStrInfo.html?action=getAllDriverStrInfoInTeam',
	        reader:driverStrDate,
	        sortInfo:{
	            field:'id',
	            direction:'DESC'
	        }
	    });
		var DirverClassStrPassGrid=new Ext.grid.GridPanel({
			id:"dirverClassStrPass",
			plain:true,
            border:false,
            autoScroll:true,
            width:.5,
            cm:new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
		            header:'报考号',
		            sortable:true,
		            dataIndex:"archivesNo"
		        },{
		            header:'名称',
		            sortable:true,
		            dataIndex:"peopleName"
		        },{
		            header:'准驾机型',
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
		            header:'培训类别',
		            sortable:true,
		            dataIndex:"fosterType",
		            renderer : function(value) {
		                var index = Ynzc.manage.FosterTypeStore.find("value", value);
		                if (index>=0) {
		                    var record = Ynzc.manage.FosterTypeStore.getAt(index);
		                    return record.data.display;
		                } else {
		                    return '未知类型';
		                }
		            }
		        },{
		            header:'性别',
		            sortable:true,
		            dataIndex:"sex"
		        },{
		            header:'身份证号',
		            sortable:true,
		            dataIndex:"idCard"
		        },{
		            header:'住址',
		            sortable:true,
		            dataIndex:"address"
		        },{
		            header:'学员状态',
		            sortable:true,
		            dataIndex:"strState",
		            renderer : function(value) {
		                var index = Ynzc.manage.StrStateStore.find("value", value);
		                if (index>=0) {
		                    var record = Ynzc.manage.StrStateStore.getAt(index);
		                    return record.data.display;
		                } else if(value.indexOf("9")>0){
		                    return '退回修改';
		                } else if(value.indexOf("10")>0){
		                    return '修改上报';
		                }
		            }
		        },{
		            header:'是否审查通过',
		            sortable:true,
		            dataIndex:"applicationFlag",
		            renderer:function(value){
			        	if(value > 0){
			        		return "通过";
			        	}else{
			        		return "未通过";
			        	}
		    		}
		        }
	        ]),
            sm:new Ext.grid.CheckboxSelectionModel(),
            frame:true,
            store:StrDs,
            loadMask:true,
            viewConfig:{
                forceFit:true
            },
            plugins:[expand,new Ext.ux.grid.Search({
            	width:120,
            	iconCls:false
            })],
            tbar:[{
            	id:"driverStrInfoExaminationPass",
                text:"审查通过",
                iconCls:"icon-add",
                handler:function(){
	                var selections=DirverClassStrPassGrid.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中给予通过的学员!");
	                    return;
	                }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(rds.length == 0){
                    		rds = rds + selections[i].data.id;
                    	}else{
                    		rds = rds + "@" + selections[i].data.id;
                    	}
                    }
                    Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认选中的学员给予通过?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverStrInfo.html?action=driverStrExaminationPass",
                                    method:"post",
                                    success:function(resp){
            							var result=Ext.util.JSON.decode(resp.responseText);
        								if(result.success==true){
        									Ext.MessageBox.alert("提示",result.reason);
        									DirverClassStrPassGrid.getStore().reload();
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
                }
            },'-',{
            	id:"driverStrInfoExaminationUnPass",
                text:"审查不通过",
                iconCls:"icon-add",
                handler:function(){
	                var selections=DirverClassStrPassGrid.selModel.getSelections();
	                var n=selections.length;
	                if(n==0){
	                    Ext.MessageBox.alert("提示","请选中给予通过的学员!");
	                    return;
	                }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(rds.length == 0){
                    		rds = rds + selections[i].data.id;
                    	}else{
                    		rds = rds + "@" + selections[i].data.id;
                    	}
                    }
                    Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认选中的学员给予通过?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/driverStrInfo.html?action=driverStrExaminationUnPass",
                                    method:"post",
                                    success:function(resp){
            							var result=Ext.util.JSON.decode(resp.responseText);
        								if(result.success==true){
        									Ext.MessageBox.alert("提示",result.reason);
        									DirverClassStrPassGrid.getStore().reload();
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
                }
            }],
            bbar:new Ext.PagingToolbar({
                pageSize:5,
                store:StrDs,
                displayInfo:true,
                displayMsg : '共 {2} 条',
                emptyMsg : '无记录'
            }),
            viewConfig:{
                forceFit:true
            }
		});
		Ext.apply(this,{
			id:"dirverClassInfoWin",
			title:"班级学员审核",
			height:500,
			width:900,
			autoScroll:true,
			resizable:false,
			modal:true,
			layout:'fit',
			items:DirverClassStrPassGrid
		});
		Ynzc.manage.LeadExaminationStrWin.superclass.initComponent.apply(this,arguments);
		StrDs.baseParams.driverClassInfoId = Ynzc.manage.DriverClassInfoId;
		StrDs.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});