Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ExamInfoWin=Ext.extend(Ext.Window,{
	id:"examInfoWin",
	initComponent:function(){
		var driverStrDate=new Ext.data.JsonReader({
	        totalProperty:"totalCount",
	        root:"data",
	        autoLoad:true,
	        fields:[{
                name : 'id'
            },{
                name : 'driverClassId'
            },{
                name : 'driverStrInfoId'
            },{
                name : 'peopleInfoId'
            },{
                name : 'bodyInfoId'
            },{
                name : 'theoryPermitFlag'
            },{
                name : 'practicePermitFlag'
            },{
                name : 'className'
            },{
                name : 'examinationCode'
            },{
                name : 'classDate'
            },{
                name : 'theoryExamDate'
            },{
                name : 'practiceExamDate'
            },{
                name : 'classState'
            },{
                name : 'declareFlag'
            },{
                name : 'declareDate'
            },{
                name : 'classStrNum'
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
                name : 'strState'
            },{
                name : 'pigeonholeFlag'
            },{
                name : 'pigeonholeDate'
            },{
                name : 'theoryId'
            },{
                name : 'theoryFlag'
            },{
                name : 'practiceId'
            },{
                name : 'practiceFlag'
            },{
                name : 'theoryMakeUpNum'
            },{
                name : 'practiceMakeUpNum'
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
	        url:'main/driverStrInfo.html?action=getAllDriverClassStr',
	        reader:driverStrDate,
	        sortInfo:{
	            field:'id',
	            direction:'DESC'
	        }
	    });
		var DirverClassStrExamGrid=new Ext.grid.GridPanel({
			id:"dirverClassStrExamGrid",
			plain:true,
            border:false,
            autoScroll:true,
            width:.5,
            cm:new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),new Ext.grid.CheckboxSelectionModel(),{
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
		            header:'身份证号',
		            sortable:true,
		            dataIndex:"idCard"
		        },{
		            header:'理论补考次数',
		            sortable:true,
		            dataIndex:"theoryMakeUpNum"
		        },{
		            header:'技术补考次数',
		            sortable:true,
		            dataIndex:"practiceMakeUpNum"
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
		        },
//		        {
//		            header:'理论准考证',
//		            sortable:true,
//		            dataIndex:"theoryPermitFlag",
//		            renderer:function(value){
//			        	if(value > 0){
//			        		return "已打印";
//			        	}else{
//			        		return "未打印";
//			        	}
//		    		}
//		        },
		        {
		            header:'理论成绩录入',
		            sortable:true,
		            dataIndex:"theoryFlag",
		            renderer:function(value){
			        	if(value == 1){
			        		return "合格";
			        	}
			        	if(value == 0){
			        		return "不合格";
			        	}
			        	if(value == -1){
			        		return "未录入";
			        	}
		    		}
		        },{
		            header:'技术准考证',
		            sortable:true,
		            dataIndex:"practicePermitFlag",
		            renderer:function(value){
			        	if(value > 0){
			        		return "已打印";
			        	}else{
			        		return "未打印";
			        	}
		    		}
		        },{
		            header:'技术成绩录入',
		            sortable:true,
		            dataIndex:"practiceFlag",
		            renderer:function(value){
			        	if(value == 1){
			        		return "合格";
			        	}
			        	if(value == 0){
			        		return "不合格";
			        	}
			        	if(value == -1){
			        		return "未录入";
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
            	width:200,
            	iconCls:false
            })],
            tbar:[{
            	text: '准考证打印',
                menu: [
                {
                	id:"putOutPracticeExam",
                    text:"打印技术准考证明",
                    iconCls:"icon-add",
                    handler:function(){
    	                var selections=DirverClassStrExamGrid.selModel.getSelections();
    	                var n=selections.length;
    	                if(n==0){
    	                    Ext.MessageBox.alert("提示","请选中发放的学员!");
    	                    return;
    	                }
    	                if(n>1){
    	                    Ext.MessageBox.alert("提示","请逐一打印准考证!");
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
	                        	wordType:"drivingSkillExamProve",
	                        	ChWord:"拖拉机驾驶技能准考证明",
		                        topMargin:"",
		                        bottomMargin:"",
		                        leftMargin:"",
		                        rightMargin:""
	                        	}
	                    });
	            		new Ynzc.manage.ReportWin(
	        				{
	        					title:'打印',
	        					sourceURL:'main/reportDriverStrInfo.html?action=getDriverStrAllowCertificateReport',
	        					params:{id:selections[0].data.driverStrInfoId,driverStrId:selections[0].data.driverStrInfoId,driverClassId:Ynzc.manage.DriverClassInfoId,functionType:'examAttest',wordType:'drivingSkillExamProve'}
	        				}
	        			).show();
                    }
                }]},'-',{
                	text: '学员成绩打印',
                	iconCls:"icon-print",
                	menu:[{
            	    	text:"打印学员成绩表",
                		iconCls:"icon-Add",
                		handler:function(){
        	        		var selections=DirverClassStrExamGrid.selModel.getSelections();
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
    	                        	wordType:"tractorExamScoreTable2",
    	                        	ChWord:"拖拉机驾驶人考试成绩表",
    		                        topMargin:"",
    		                        bottomMargin:"",
    		                        leftMargin:"",
    		                        rightMargin:""
    	                        	}
    	                    });
                    		new Ynzc.manage.ReportWin({
            					title:'打印',
            					sourceURL:'main/reportDriverStrInfo.html?action=strExam',
            					params:{id:selections[0].data.id,functionType:'',wordType:'tractorExamScoreTable2'}
        	    				}
        	    			).show();
                    	}
                	},{
                		text:"打印学员成绩单",
                		iconCls:"icon-Add",
                		handler:function(){
        	        		var selections=DirverClassStrExamGrid.selModel.getSelections();
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
    	                        	wordType:"tractorExamScoreTable",
    	                        	ChWord:"拖拉机驾驶人考试成绩表",
    		                        topMargin:"",
    		                        bottomMargin:"",
    		                        leftMargin:"",
    		                        rightMargin:""
    	                        	}
    	                    });
                    		new Ynzc.manage.ReportWin({
            					title:'打印',
            					sourceURL:'main/reportDriverStrInfo.html?action=strExamInfo',
            					params:{id:selections[0].data.id,theoryId:selections[0].data.theoryId,practiceId:selections[0].data.practiceId,functionType:'',wordType:'tractorExamScoreTable'}
        	    				}
        	    			).show();
                    	}
                	}]
                },'-',{
                	text: '正考成绩录入',
                    menu: [{
                    	id:"addTheoryExamResult",
                        text:"理论成绩录入",
                        iconCls:"icon-add",
                        handler:function(index){
        	                var selections=DirverClassStrExamGrid.selModel.getSelections();
        	                var n=selections.length;
        	                if(n == 0){
        	                    Ext.MessageBox.alert("提示","请选中需要录入的学员!");
        	                    return;
        	                }
        	                if(n>1){
        	                    Ext.MessageBox.alert("提示","你选择的学员过多!");
        	                    return;
        	                }
        	                if(selections[0].data.theoryFlag == 1){
        	                    Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]学员已经录入理论成绩");
        	                    return;
        	                }
        	        		var record=DirverClassStrExamGrid.getStore().getAt(index);
        	        	    new Ynzc.manage.TheoryExamWin().show();
        	        	    Ynzc.manage.driverStrInfoId=selections[0].data.driverStrInfoId;
        	        	    Ext.getCmp("examinationCode").setValue(selections[0].data.examinationCode);
        	        	    Ext.getCmp("peopleName").setValue(selections[0].data.peopleName);
        	        	    Ext.getCmp("sex").setValue(selections[0].data.sex);
        	        	    Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(selections[0].data.drivingLicenceTypeId));
        	        	    Ext.getCmp("idCard").setValue(selections[0].data.idCard);
        	        	    Ext.getCmp("address").setValue(selections[0].data.address);
                        }
                    },'-',{
                    	id:"addPracticeExamResult",
                        text:"技术成绩录入",
                        iconCls:"icon-add",
                        handler:function(index){
        	                var selections=DirverClassStrExamGrid.selModel.getSelections();
        	                var n=selections.length;
        	                if(n == 0){
        	                    Ext.MessageBox.alert("提示","请选中需要录入的学员!");
        	                    return;
        	                }
        	                if(n>1){
        	                    Ext.MessageBox.alert("提示","请选中一个学员录入!");
        	                    return;
        	                }
        	                if(selections[0].data.practicePermitFlag == 0){
        	                    Ext.MessageBox.alert("提示","还未打印技术准考证");
        	                    return;
        	                }
        	                if(selections[0].data.theoryFlag == 0){
        	                    Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]理论成绩还未录入");
        	                    return;
        	                }
        	                if(selections[0].data.practiceFlag == 1){
        	                    Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]学员已经录入技术成绩");
        	                    return;
        	                }
        	        		var record=DirverClassStrExamGrid.getStore().getAt(index);
        	        	    new Ynzc.manage.PracticeExamWin().show();	        	    
        	        	    Ynzc.manage.DriverStrInfoId=selections[0].data.driverStrInfoId;
        	        	    Ext.getCmp("examinationCode").setValue(selections[0].data.examinationCode);
        	        	    Ext.getCmp("peopleName").setValue(selections[0].data.peopleName);
        	        	    Ext.getCmp("drivingLicenceNo").setValue(selections[0].data.idCard);
        	        	    Ext.getCmp("drivingLicenceTypeId").setValue(findDrivingLicenceType(selections[0].data.drivingLicenceTypeId));
        	        	    Ext.getCmp("idCard").setValue(selections[0].data.idCard);
        	        	    Ext.getCmp("address").setValue(selections[0].data.address);
        	    			Ext.Ajax.request({
        	    				url:"main/driverStrInfo.html?action=getDriverType",
        	    				success:function(resp){
        	    					var result=Ext.util.JSON.decode(resp.responseText);
        	    					if(result.reason !== undefined && result.reason !== ""){
        	    						Ext.getCmp("drivingLicenceType").setValue(getOldDrivingLicenceType(result.reason.split("/")));
        	    					}else{
        	    						Ext.getCmp("drivingLicenceType").setValue("无");
        	    					}
        	    				},
        	    				failure:function(){
        	    					Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
        	    				},
        	    				params:{
        	    					id:selections[0].data.peopleInfoId
        	    				}
        	    			});
                        }
                    }]
                }
                ,'-',{
                	text: '补考成绩信息',
                    menu: [{
                    	id:"addTheoryExamResult",
                        text:"理论补考",
                        iconCls:"icon-add",
                        handler:function(index){
        	                var selections=DirverClassStrExamGrid.selModel.getSelections();
        	                var n=selections.length;
        	                if(n == 0){
        	                    Ext.MessageBox.alert("提示","请选中需要录入的学员!");
        	                    return;
        	                }
        	                if(n>1){
        	                    Ext.MessageBox.alert("提示","你选择的学员过多!");
        	                    return;
        	                }
        	                if(selections[0].data.theoryFlag == -1){
        	                    Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]学员理论成绩还未录入");
        	                    return;
        	                }
        	        		var record=DirverClassStrExamGrid.getStore().getAt(index);
        	        		Ynzc.manage.TheoryFlag=selections[0].data.theoryFlag;
        	        		Ynzc.manage.TheoryId=selections[0].data.theoryId;
        	        		Ynzc.manage.ExaminationCode=selections[0].data.examinationCode;
        	        		Ynzc.manage.PeopleName=selections[0].data.peopleName;
        	        		Ynzc.manage.Sex=selections[0].data.sex;
        	        		Ynzc.manage.DrivingLicenceTypeId=findDrivingLicenceType(selections[0].data.drivingLicenceTypeId);
        	        		Ynzc.manage.IdCard=selections[0].data.idCard;
        	        		Ynzc.manage.Address=selections[0].data.address;
        	        	    new Ynzc.manage.TheoryExamMakeupInfoWin().show();
                        }
                    },'-',{
                    	id:"addPracticeExamResult",
                        text:"技术补考",
                        iconCls:"icon-add",
                        handler:function(index){
        	                var selections=DirverClassStrExamGrid.selModel.getSelections();
        	                var n=selections.length;
        	                if(n == 0){
        	                    Ext.MessageBox.alert("提示","请选中需要录入的学员!");
        	                    return;
        	                }
        	                if(n>1){
        	                    Ext.MessageBox.alert("提示","请选中一个学员录入!");
        	                    return;
        	                }
        	                if(selections[0].data.practiceFlag == -1){
        	                    Ext.MessageBox.alert("提示","[<font color=blue>"+selections[0].data.peopleName+"</font>]学员技术成绩还未录入");
        	                    return;
        	                }
        	        		var record=DirverClassStrExamGrid.getStore().getAt(index);
        	        		Ynzc.manage.PeopleInfoId=selections[0].data.peopleInfoId;
        	        		Ynzc.manage.PracticeFlag=selections[0].data.practiceFlag;
        	        		Ynzc.manage.PracticeId=selections[0].data.practiceId;
        	        		Ynzc.manage.ExaminationCode=selections[0].data.examinationCode;
        	        		Ynzc.manage.PeopleName=selections[0].data.peopleName;
        	        		Ynzc.manage.DrivingLicenceTypeId=findDrivingLicenceType(selections[0].data.drivingLicenceTypeId);
        	        		Ynzc.manage.IdCard=selections[0].data.idCard;
        	        		Ynzc.manage.Address=selections[0].data.address;
        	        	    new Ynzc.manage.PracticeExamMakeupInfoWin().show();   
                        }
                    }]
                }
            ],
            bbar:new Ext.PagingToolbar({
                pageSize:20,
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
			width:1000,
			autoScroll:true,
			resizable:false,
			modal:true,
			layout:'fit',
			items:DirverClassStrExamGrid
		});
		Ynzc.manage.ExamInfoWin.superclass.initComponent.apply(this,arguments);
		StrDs.baseParams.driverClassInfoId = Ynzc.manage.DriverClassInfoId;
		StrDs.load({
            params:{
                start:0,
                limit:20
            }
        });
	}
});