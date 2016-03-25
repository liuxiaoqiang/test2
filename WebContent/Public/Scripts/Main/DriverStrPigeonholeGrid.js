Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DriverStrPigeonholeGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'driverStrPigeonholeGrid',
	initComponent:function(){
	    var sm=new Ext.grid.CheckboxSelectionModel();
	    var fm=Ext.form;
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
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
					'<tr><td colspan="5" align="center">理论考试信息</td></tr>',
					'<tr><td>主考人</td><td>{[values.examinerOne != null ? values.examinerOne : ""]}</td><td>监考人</td><td colspan="2">{[values.examinerTwo != null ? values.examinerTwo : ""]}</td></tr>',
					'<tr><td>成绩</td><td>{[values.theoryResult != null ? values.theoryResult : ""]}</td><td>时间</td><td colspan="2">{[values.theoryDate != null ? new Date(values.theoryDate.time).format("Y-m-d") : ""]}</td></tr>',
					'<tr><td>核发驾驶员意见</td><td>{[values.auditingTheoryIdeaFlag != null ? Ynzc.manage.PassStore.getAt(Ynzc.manage.PassStore.find("value", values.auditingTheoryIdeaFlag)).data.display : ""]}</td><td>经办人</td><td colspan="2">{[values.transactor != null ? values.transactor : ""]}</td></tr>',
					'<tr><td>农机监理部门意见</td><td>{[values.unitTheoryAuditingIdeaFlag != null ? Ynzc.manage.PassStore.getAt(Ynzc.manage.PassStore.find("value", values.unitTheoryAuditingIdeaFlag)).data.display : ""]}</td><td>填写时间</td><td colspan="2">{[values.unitTheoryAuditingIdeaDate != null ? new Date(values.unitTheoryAuditingIdeaDate.time).format("Y-m-d") : ""]}</td></tr>',
					'<tr><td>结论</td><td>{[values.auditingTheoryResultFlag != null ? Ynzc.manage.EligibilityOrUnEligibilityStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.auditingTheoryResultFlag)).data.display : ""]}</td></tr>',
					'<tr><td colspan="5" align="center">技术考试信息</td></tr>',
					'<tr><td>教练</td><td>{[values.drillMasterId != null ? values.drillMasterId : ""]}</td><td>教练编号</td><td colspan="2">{[values.drillMasterCode != null ? values.drillMasterCode : ""]}</td></tr>',
					'<tr><td>培训时间</td><td>{[values.drillMasterDate != null ? values.drillMasterDate : ""]}</td><td>教练机</td><td colspan="2">{[values.drillMasterMachine != null ? values.drillMasterMachine : ""]}</td></tr>',
					'<tr><td>审核意见</td><td>{[values.drillMasterAuditingIdeaFlag != null ? Ynzc.manage.PassStore.getAt(Ynzc.manage.PassStore.find("value", values.drillMasterAuditingIdeaFlag)).data.display : ""]}</td></tr>',
					'<tr><td>场地主考人</td><td>{[values.examinerFieldOne != null ? values.examinerFieldOne : ""]}</td><td>场地监考人</td><td colspan="2">{[values.examinerFieldTwo != null ? values.examinerFieldTwo : ""]}</td></tr>',
					'<tr><td>场地考试成绩</td><td>{[values.fieldResult != null ? values.fieldResult : ""]}</td><td>场地考试时间</td><td colspan="2">{[values.fieldDate != null ? new Date(values.fieldDate.time).format("Y-m-d") : ""]}</td></tr>',
					'<tr><td>作业主考人</td><td>{[values.examinerMachineOne != null ? values.examinerMachineOne : ""]}</td><td>作业监考人</td><td colspan="2">{[values.examinerMachineTwo != null ? values.examinerMachineTwo : ""]}</td></tr>',
					'<tr><td>作业考试成绩</td><td>{[values.machineResult != null ? values.machineResult : ""]}</td><td>作业考试时间</td><td colspan="2">{[values.machineDate != null ? new Date(values.machineDate.time).format("Y-m-d") : ""]}</td></tr>',
					'<tr><td>公路主考人</td><td>{[values.examinerRoadOne != null ? values.examinerRoadOne : ""]}</td><td>公路监考人</td><td colspan="2">{[values.examinerRoadTwo != null ? values.examinerRoadTwo : ""]}</td></tr>',
					'<tr><td>公路考试成绩</td><td>{[values.roadResult != null ? values.roadResult : ""]}</td><td>公路考试时间</td><td colspan="2">{[values.roadDate != null ? new Date(values.roadDate.time).format("Y-m-d") : ""]}</td></tr>',
					'<tr><td>部门审核意见</td><td>{[values.unitAuditingPracticeIdeaFlag != null ? Ynzc.manage.PassStore.getAt(Ynzc.manage.PassStore.find("value", values.unitAuditingPracticeIdeaFlag)).data.display : ""]}</td><td>是否发放意见</td><td colspan="2">{[values.drivingLicenceAuditingIdeaFlag != null ? Ynzc.manage.YesOrNoStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.drivingLicenceAuditingIdeaFlag)).data.displayvalue : ""]}</td></tr>',
					'<tr><td>省级审核意见</td><td>{[values.orgAuditingIdeaFlag != null ? Ynzc.manage.PassStore.getAt(Ynzc.manage.PassStore.find("value", values.orgAuditingIdeaFlag)).data.display : ""]}</td><td>结论</td><td colspan="2">{[values.auditingPracticeResultFlag != null ? Ynzc.manage.EligibilityOrUnEligibilityStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.auditingPracticeResultFlag)).data.display : ""]}</td></tr>',
					'</table>'
			)
		});
	    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
	            header:'档案号',
	            sortable:true,
	            dataIndex:"archivesNo"
	        },{
	            header:'报考号',
	            sortable:true,
	            dataIndex:"examinationCode"
	        },{
	            header:'姓名',
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
	                } else {
	                    return '未知类型';
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
	        },{
	            header:'是否归档',
	            sortable:true,
	            dataIndex:"pigeonholeFlag",
	            renderer:function(value){
	        	if(value == 1){
	        		return "已归";
	        	}else if(value == 0){
	        		return "不归档";
	        	}else{
	        		return "未归";
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
                name : 'theoryResult'
            },{
                name : 'examinerOne'
            },{
                name : 'examinerTwo'
            },{
                name : 'theoryDate'
            },{
                name : 'makeupResult'
            },{
                name : 'examinerMakeupOne'
            },{
                name : 'examinerMakeupTwo'
            },{
                name : 'makeupDate'
            },{
                name : 'auditingTheoryIdeaFlag'
            },{
                name : 'transactor'
            },{
                name : 'unitTheoryAuditingIdeaFlag'
            },{
                name : 'unitTheoryAuditingIdeaDate'
            },{
                name : 'auditingTheoryResultFlag'
            },{
                name : 'drivingLicenceNo'
            },{
                name : 'drillMasterId'
            },{
                name : 'drillMasterCode'
            },{
                name : 'drillMasterDate'
            },{
                name : 'drillMasterMachine'
            },{
                name : 'drillMasterAuditingIdeaFlag'
            },{
                name : 'unitAuditingPracticeIdeaFlag'
            },{
                name : 'drivingLicenceAuditingIdeaFlag'
            },{
                name : 'orgAuditingIdeaFlag'
            },{
                name : 'fieldResult'
            },{
                name : 'examinerFieldOne'
            },{
                name : 'examinerFieldTwo'
            },{
                name : 'fieldDate'
            },{
                name : 'makeupFieldResult'
            },{
                name : 'examinerMakeupFieldOne'
            },{
                name : 'examinerMakeupFieldTwo'
            },{
                name : 'makeupFieldDate'
            },{
                name : 'machineResult'
            },{
                name : 'examinerMachineOne'
            },{
                name : 'examinerMachineTwo'
            },{
                name : 'machineDate'
            },{
                name : 'makeupMachineResult'
            },{
                name : 'examinerMakeupMachineOne'
            },{
                name : 'examinerMakeupMachineTwo'
            },{
                name : 'makeupMachineDate'
            },{
                name : 'roadResult'
            },{
                name : 'examinerRoadOne'
            },{
                name : 'examinerRoadTwo'
            },{
                name : 'roadDate'
            },{
                name : 'makeupRoadResult'
            },{
                name : 'examinerMakeupRoadOne'
            },{
                name : 'examinerMakeupRoadTwo'
            },{
                name : 'makeupRoadDate'
            },{
                name : 'auditingPracticeResultFlag'
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
            url:'main/driverStrInfo.html?action=getDriverStrParticular',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'driverStrPigeonholeGrid',
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
                    id:"driverStrInfoPigeonhole",
                    text:"归档",
                    iconCls:"icon-Add",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要归档的学员!");
                            return;
                        }
                        if(selections[0].data.archivesNo === null){
                            Ext.MessageBox.alert("提示","请先建档!");
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
                            msg:'你是否确认归档选中的学员信息?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/driverStrInfo.html?action=driverClassStrPigeonhole",
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
                                        	driverStrId:rds
                                        }
                                    });
                                }
                            }
                         });
                    }.createDelegate(this)
                },'-',{
                    id:"driverStrInfoPigeonhole",
                    text:"不归档",
                    iconCls:"icon-Del",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中不归档的学员!");
                            return;
                        }
                        var rds="";
                        for(i=0;i<n;i++){
                        	if(rds.length == 0){
                        		rds = rds + selections[i].data.id;
                        	}else{
                        		rds = rds + "," + selections[i].data.id;
                        	}
                        }
                         Ext.Msg.show({
                            title:'系统确认',
                            msg:'你是否确认归档选中的学员信息?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/driverStrInfo.html?action=driverClassStrUnPigeonhole",
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
                                        	driverStrId:rds
                                        }
                                    });
                                }
                            }
                         });
                    }.createDelegate(this)
                },'-',{
        	    	text:"打印学员流程单",
            		iconCls:"icon-Add",
            		handler:function(){
    	        		var selections=this.selModel.getSelections();
    	        		var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要打印的学员信息!");
                            return;
                        }
                        if(n>1){
                            Ext.MessageBox.alert("提示","请逐一打证!");
                            return;
                        }
	                    Ext.Ajax.request({
	                    	url:"main/word.html?action=findWordSet",
	                        method:"post",
	                        success:function(response){
	                    		var result=Ext.util.JSON.decode(response.responseText);
	                    		Ynzc.manage.topMargin=result.data.topMargin;
	                    		Ynzc.manage.bottomMargin=result.data.bottomMargin;
	                    		Ynzc.manage.leftMargin=result.data.leftMargin;
	                    		Ynzc.manage.rightMargin=result.data.rightMargin;
	                    		Ynzc.manage.id=result.data.id;
	                    		Ynzc.manage.unitid=result.data.unitid;
	                    		Ynzc.manage.wordtype=result.data.wordtype;
	                    		Ynzc.manage.cnWord=result.data.cnWord;
	                    				},
	                        failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
	                        params:{
	                        	wordType:"tractorLicenseProcess",
	                        	ChWord:"拖拉机驾驶证业务流程记录单",
		                        topMargin:"",
		                        bottomMargin:"",
		                        leftMargin:"",
		                        rightMargin:""
	                        	}
	                    });
                		new Ynzc.manage.ReportWin({
        					title:'打印',
        					sourceURL:'main/reportDriverStrInfo.html?action=tractorLicenseProcess',
        					params:{id:selections[0].data.id,peopleInfoId:selections[0].data.peopleInfoId,functionType:'',wordType:'tractorLicenseProcess'}
    	    				}
    	    			).show();
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
        Ynzc.manage.DriverStrPigeonholeGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});
Ext.reg('driverStrPigeonholeGrid',Ynzc.manage.DriverStrPigeonholeGrid);