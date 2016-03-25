Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.DrivingLicenceDefileGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'drivingLicenceDefileGrid',
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
				'<tr><td>驾照积分</td><td>{mark}</td><td>驾照打印日期</td><td colspan="2">{[values.putOutDate != null ? new Date(values.putOutDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td colspan="5" align="center">驾照污损信息</td></tr>',
				'<tr><td>办理证件类型</td><td>{[values.proveType != null ? values.proveType : ""]}</td><td>办理证件号</td><td colspan="2">{[values.proveId != null ? values.proveId : ""]}</td></tr>',
				'<tr><td>原因</td><td colspan="4">{[values.causation != null ? values.causation : ""]}</td></tr>',
				'<tr><td>登记经办人</td><td>{[values.registerTransactor != null ? values.registerTransactor : ""]}</td><td>登记经办日期</td><td colspan="2">{[values.registerTransactorDate != null ? new Date(values.registerTransactorDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td>审核经办人</td><td>{[values.auditingTransactor != null ? values.auditingTransactor : ""]}</td><td>审核经办日期</td><td colspan="2">{[values.auditingTransactorDate != null ? new Date(values.auditingTransactorDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td>打印经办人</td><td>{[values.putOutTransactor != null ? values.putOutTransactor : ""]}</td><td>打印经办日期</td><td colspan="2">{[values.putOutTransactorDate != null ? new Date(values.putOutTransactorDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td>归档经办人</td><td>{[values.pigeonholeTransactor != null ? values.pigeonholeTransactor : ""]}</td><td>归档经办日期</td><td colspan="2">{[values.pigeonholeTransactorDate != null ? new Date(values.pigeonholeTransactorDate.time).format("Y-m-d") : ""]}</td></tr>',
				'<tr><td colspan="5" align="center">驾照员健康状况</td></tr>',
				'<tr><td>身高</td><td>{hight}</td><td>辨色力</td><td colspan="2">{[values.resolvingPowerFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.resolvingPowerFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体和颈椎</td><td>{[values.bodyNeck != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.bodyNeck)).data.display : ""]}</td><td>&nbsp;</td><td colspan="2">&nbsp;</td></tr>',
				'<tr><td>右眼视力</td><td>{[values.rightEyePwoer != null ? values.rightEyePwoer : ""]}</td><td>右眼矫正</td><td colspan="2">{[values.rightEyeRectificationFlag != null ? Ynzc.manage.YesOrNoStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.rightEyeRectificationFlag)).data.displayvalue : ""]}</td></tr>',
				'<tr><td>左眼视力</td><td>{[values.leftEyePwoer != null ? values.leftEyePwoer : ""]}</td><td>左眼矫正</td><td colspan="2">{[values.leftEyeRectificationFlag != null ? Ynzc.manage.YesOrNoStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.leftEyeRectificationFlag)).data.displayvalue : ""]}</td></tr>',
				'<tr><td>右耳听力</td><td>{[values.rightEarPwoer != null ? values.rightEarPwoer : ""]}</td><td>左耳听力</td><td colspan="2">{[values.leftEarPwoer != null ? values.leftEarPwoer : ""]}</td></tr>',
				'<tr><td>右手</td><td>{[values.rightHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightHandFlag)).data.display : ""]}</td><td>左手</td><td colspan="2">{[values.leftHandFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftHandFlag)).data.display : ""]}</td></tr>',
				'<tr><td>右脚</td><td>{[values.rightLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightLagFlag)).data.display : ""]}</td><td>左脚</td><td colspan="2">{[values.leftLagFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftLagFlag)).data.display : ""]}</td></tr>',
				'<tr><td>身体检查时间</td><td>{[values.bodyCheckDate != null ? new Date(values.bodyCheckDate.time).format("Y-m-d") : ""]}</td><td>检查机构</td><td colspan="2">{[values.checkOrganization != null ? values.checkOrganization : ""]}</td></tr>',
				'<tr><td>检查医生</td><td>{[values.checkDoctor != null ? values.checkDoctor : ""]}</td><td>检查结果</td><td colspan="2">{[values.checkResultFlag != null ? Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.checkResultFlag)).data.display : ""]}</td></tr>',
				'</table>'
			)
		});
	    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
	        header:'业务名称',
	        sortable:true,
	        dataIndex:"operationNameType",
            renderer : function(value) {
                var index = Ynzc.manage.OperationTypeStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.OperationTypeStore.getAt(index);
                    return record.data.display;
                } else {
                    return '未知类型';
                }
            }
	    },{
	        header:'姓名',
	        sortable:true,
	        dataIndex:"peopleName"
	    },{
	    	header:'身份证',
	        sortable:true,
	        dataIndex:"idCard"
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
	    },{
	        header:'状态',
	        sortable:true,
	        dataIndex:"state",
            renderer : function(value) {
                var index = Ynzc.manage.DrivingLicenceDeclareStateStore.find("value", value);
                if (index>=0) {
                    var record = Ynzc.manage.DrivingLicenceDeclareStateStore.getAt(index);
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
	            name : 'operationNameType'
	        },{
	            name : 'drivingLicenceId'
	        },{
	            name : 'peopleInfoId'
	        },{
	            name : 'bodyInfoId'
	        },{
	            name : 'proveType'
	        },{
	            name : 'proveId'
	        },{
	            name : 'causation'
	        },{
	            name : 'auditingDefileFlag'
	        },{
	            name : 'auditingDefileDate'
	        },{
	            name : 'registerTransactor'
	        },{
	            name : 'registerTransactorDate'
	        },{
	            name : 'auditingTransactor'
	        },{
	            name : 'auditingTransactorDate'
	        },{
	            name : 'putOutTransactor'
	        },{
	            name : 'putOutTransactorDate'
	        },{
	            name : 'pigeonholeTransactor'
	        },{
	            name : 'pigeonholeTransactorDate'
	        },{
	            name : 'year'
	        },{
	            name : 'state'
	        },{
	            name : 'pigeonholeFlag'
	        },{
	            name : 'pigeonholeDate'
	        },{
	            name : 'writeUserId'
	        },{
	            name : 'writeDate'
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
	        }]
	    });
        var ds=new Ext.data.Store({
            scopte:this,
            url:'main/drivingLicenceDefile.html?action=getAllDrivingLicenceDefile',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
        	id:'drivingLicenceDefileGrid',
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
        		text:"业务办理",
        		iconCls:"icon-Add",
        		handler:function(){
        		Ynzc.manage.addLicenceDefilewin=new Ynzc.manage.DrivingLicenceDefileWin();
        		Ynzc.manage.addLicenceDefilewin.show();
        		Ynzc.manage.winName = "drivingLicenceDefileWin";
        		}
        	},'-',{
                text:"业务上报",
                iconCls:"icon-Add",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要上报的信息!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(selections[i].data.state >= 1){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]已经上报审核!");
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
                        msg:'你是否确认上报选中的驾驶员信息?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicenceDefile.html?action=changeState",
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
        		text:"打印驾驶证",
        		iconCls:"icon-Add",
        		handler:function(){
	        		var selections=this.selModel.getSelections();
	        		var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要打印的驾驶证!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","请逐一打证!");
                        return;
                    }
                    if(selections[0].data.state < 2){
                        Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]还未通过审核不能打印驾驶证!");
                        return;
                    }
                    if(selections[0].data.drivingLicenceFlag == 1){
                        Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]该驾驶证不可重新打印!");
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
                        	wordType:"drivingLicence",
                        	ChWord:"拖拉机驾驶证",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
                        	}
                    });
            		new Ynzc.manage.ReportWin(
        				{
        					title:'打印',
        					sourceURL:'main/drivingLicenceReport.html?action=getDrivingLicenceOperation',
        					params:{id:selections[0].data.drivingLicenceId,peopleInfoId:selections[0].data.peopleInfoId,drivingLicenceTypeId:selections[0].data.drivingLicenceTypeId,operationNameType:selections[0].data.operationNameType,operationId:selections[0].data.id,wordType:'drivingLicence',reloadType:'drivingLicenceDefileMgr',functionType:'putOut'}
        				}
        			).show();
            	}.createDelegate(this)
        	},'-',{
        		text:"业务表格打印",
        		iconCls:"icon-Add",
        		handler:function(){
	        		var selections=this.selModel.getSelections();
	        		var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要打印业务表格的驾驶员!");
                        return;
                    }
                    if(n>1){
                        Ext.MessageBox.alert("提示","请逐一打印业务表格!");
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
                        	wordType:"licenseApplicationReport",
                        	ChWord:"拖拉机驾驶证申请表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
                        	}
                    });
            		new Ynzc.manage.ReportWin(
        				{
        					title:'打印',
        					sourceURL:'main/reportPeopleInfo.html?action=getPeopleInfoReport',
        					params:{id:selections[0].data.drivingLicenceId,functionType:'',wordType:'licenseApplicationReport'}
        				}
        			).show();

            	}.createDelegate(this)
        	},'-',{
                text:"删除",
                iconCls:"icon-Del",
                handler:function(){
                    var selections=this.selModel.getSelections();
                    var n=selections.length;
                    if(n==0){
                        Ext.MessageBox.alert("提示","请选中要删除的信息!");
                        return;
                    }
                    var rds="";
                    for(i=0;i<n;i++){
                    	if(selections[i].data.state >= 1){
                            Ext.MessageBox.alert("提示","[<font color=blue>"+selections[i].data.peopleName+"</font>]已经上报审核!");
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
                        msg:'你是否确认删除选中的驾驶员信息?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                Ext.Ajax.request({
                                    url:"main/drivingLicenceDefile.html?action=delDrivingLicenceDefile",
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
        Ynzc.manage.DrivingLicenceDefileGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
        	params:{
	        	start:0,
	        	limit:20
        	}
        });
        this.on("rowdblclick",function(grid,index,event){
            var record=grid.getStore().getAt(index);
        	if(record.data.state >= 1){
                Ext.MessageBox.alert("提示","[<font color=blue>"+record.data.peopleName+"</font>]已经上报审核不能修改!");
                return;
        	}
        	Ynzc.manage.updateLicenceDefilewin =new Ynzc.manage.DrivingLicenceDefileUpdateWin();
        	Ynzc.manage.updateLicenceDefilewin.show();
            Ynzc.manage.DrivingLicenceDefileId=record.data.id;
			Ext.getCmp("causation").setValue(record.data.causation);
			Ext.getCmp("proveType").setValue(record.data.proveType);
			Ext.getCmp("proveId").setValue(record.data.proveId);
			Ext.getCmp("drivingLicenceNo").setValue(record.data.drivingLicenceNo);
			Ext.getCmp("drivingLicenceTypeId").setValue(record.data.drivingLicenceTypeId);
			Ext.getCmp("startDate").setValue(new Date(record.data.startDate.time).format('Y-m-d'));
			Ext.getCmp("endDate").setValue(new Date(record.data.endDate.time).format('Y-m-d'));
			Ext.getCmp("drivingLicenceFlag").setValue(record.data.drivingLicenceFlag);
			Ext.getCmp("putOutDate").setValue(new Date(record.data.putOutDate.time).format('Y-m-d'));
			Ext.getCmp("userState").setValue(record.data.userState);
    		Ext.getCmp("peopleName").setValue(record.data.peopleName);
            Ext.getCmp("sex").setValue(record.data.sex);
            Ext.getCmp("birthday").setValue(new Date(record.data.birthday.time).format('Y-m-d'));
            Ext.getCmp("idCard").setValue(record.data.idCard);
            Ext.getCmp("idStay").setValue(record.data.idStay);
            Ext.getCmp("address").setValue(record.data.address);
            Ext.getCmp("linkAddress").setValue(record.data.linkAddress);
            Ext.getCmp("linkTel").setValue(record.data.linkTel);
            Ext.getCmp("postalcode").setValue(record.data.postalcode);
            Ext.getCmp("nativePlace").setValue(record.data.nativePlace);
            Ext.getCmp("degree").setValue(record.data.degree);
            Ext.getCmp("picture").getEl().dom.src = record.data.picture;
            Ext.getCmp("hight").setValue(record.data.hight);
            if(record.data.resolvingPowerFlag>0){
            	Ext.getCmp("resolvingPowerFlag").setValue("正常");
            }else{
            	Ext.getCmp("resolvingPowerFlag").setValue("异常");
            }
            Ext.getCmp("rightEyePwoer").setValue(record.data.rightEyePwoer);
            if(record.data.rightEyeRectificationFlag>0){
            	Ext.getCmp("rightEyeRectificationFlag").setValue("是");
            }else{
            	Ext.getCmp("rightEyeRectificationFlag").setValue("否");
            }
            Ext.getCmp("leftEyePwoer").setValue(record.data.leftEyePwoer);
            if(record.data.rightEyeRectificationFlag>0){
            	Ext.getCmp("leftEyeRectificationFlag").setValue("是");
            }else{
            	Ext.getCmp("leftEyeRectificationFlag").setValue("否");
            }
            if(record.data.rightEarPwoer>0){
            	Ext.getCmp("rightEarPwoer").setValue("正常");
            }else{
            	Ext.getCmp("rightEarPwoer").setValue("异常");
            }
            if(record.data.leftEarPwoer>0){
            	Ext.getCmp("leftEarPwoer").setValue("正常");
            }else{
            	Ext.getCmp("leftEarPwoer").setValue("异常");
            }
            if(record.data.rightHandFlag>0){
            	Ext.getCmp("rightHandFlag").setValue("正常");
            }else{
            	Ext.getCmp("rightHandFlag").setValue("异常");
            }
            if(record.data.leftHandFlag>0){
            	Ext.getCmp("leftHandFlag").setValue("正常");
            }else{
            	Ext.getCmp("leftHandFlag").setValue("异常");
            }
            if(record.data.rightLagFlag>0){
            	Ext.getCmp("rightLagFlag").setValue("正常");
            }else{
            	Ext.getCmp("rightLagFlag").setValue("异常");
            }
            if(record.data.leftLagFlag>0){
            	Ext.getCmp("leftLagFlag").setValue("正常");
            }else{
            	Ext.getCmp("leftLagFlag").setValue("异常");
            }
            if(record.data.bodyNeck>0){
            	Ext.getCmp("bodyNeck").setValue("正常");
            }else{
            	Ext.getCmp("bodyNeck").setValue("异常");
            }
            Ext.getCmp("bodyCheckDate").setValue(new Date(record.data.bodyCheckDate.time).format('Y-m-d'));
            if(record.data.checkResultFlag>0){
            	Ext.getCmp("checkResultFlag").setValue("合格");
            }else{
            	Ext.getCmp("checkResultFlag").setValue("不合格");
            }
            Ext.getCmp("checkOrganization").setValue(record.data.checkOrganization);
            Ext.getCmp("checkDoctor").setValue(record.data.checkDoctor);
        });
	}
});
Ext.reg('drivingLicenceDefileGrid',Ynzc.manage.DrivingLicenceDefileGrid);