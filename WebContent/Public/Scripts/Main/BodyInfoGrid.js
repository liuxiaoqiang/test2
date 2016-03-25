Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.BodyInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'bodyInfo',
	initComponent:function(){
	    var sm=new Ext.grid.CheckboxSelectionModel();
	    var fm=Ext.form;
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
				'<table width="600" border="1" class="ynzcTableBlue">',
				'<tr><td>姓名</td><td>{peopleName}</td><td>性别</td><td>{sex}</td><td rowspan="7"><img src="{picture}" width="100%" height="155px"/></td></tr>',
				'<tr><td>出生日期</td><td>{[new Date(values.birthday.time).format("Y-m-d")]}</td><td>身份证号</td><td>{idCard}</td></tr>',
				'<tr><td>暂住证</td><td>{idStay}</td> <td>联系电话</td><td>{linkTel}</td></tr>',
				'<tr><td>邮政编码</td><td>{postalcode}</td><td>文化程度</td><td>{degree}</td></tr>',
				'<tr><td>籍贯</td><td>{nativePlace}</td><td colspan="2">&nbsp;</td></tr>',
				'<tr><td>家庭地址</td><td colspan="3">{address}</td></tr>',
				'<tr><td>联系地址</td><td colspan="3">{linkAddress}</td></tr>',
				'<tr><td>身高</td><td>{hight}</td><td>辨色力</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.resolvingPowerFlag)).data.display]}</td></tr>',
				'<tr><td>身体和颈椎</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.bodyNeck)).data.display]}</td><td colspan="3">&nbsp;</td></tr>',
				'<tr><td>右眼视力</td><td>{rightEyePwoer}</td><td>右眼矫正</td><td colspan="2">{[Ynzc.manage.YesOrNoStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.rightEyeRectificationFlag)).data.displayvalue]}</td></tr>',
				'<tr><td>左眼视力</td><td>{leftEyePwoer}</td><td>左眼矫正</td><td colspan="2">{[Ynzc.manage.YesOrNoStore.getAt(Ynzc.manage.YesOrNoStore.find("value", values.leftEyeRectificationFlag)).data.displayvalue]}</td></tr>',
				'<tr><td>右耳听力</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightEarPwoer)).data.display]}</td><td>左耳听力</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftEarPwoer)).data.display]}</td></tr>',
				'<tr><td>右手</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightHandFlag)).data.display]}</td><td>左手</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftHandFlag)).data.display]}</td></tr>',
				'<tr><td>右脚</td><td>{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.rightLagFlag)).data.display]}</td><td>左脚</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.ApplicationTypeStore.find("value", values.leftLagFlag)).data.display]}</td></tr>',
				'<tr><td>身体检查时间</td><td>{[new Date(values.bodyCheckDate.time).format("Y-m-d")]}</td><td>检查机构</td><td colspan="2">{checkOrganization}</td></tr>',
				'<tr><td>检查医生</td><td>{checkDoctor}</td><td>检查结果</td><td colspan="2">{[Ynzc.manage.ExactitudeOrUnExactitudeStore.getAt(Ynzc.manage.EligibilityOrUnEligibilityStore.find("value", values.checkResultFlag)).data.display]}</td></tr>',
				'</table>'
			)
		});
	    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
            header:'人员名称',
            sortable:true,
            dataIndex:"peopleName"
        },{
            header:'身份证',
            sortable:true,
            dataIndex:"idCard"
        },{
            header:'身体检查时间',
            sortable:true,
            dataIndex:"bodyCheckDate",
            renderer:function(value){
	        	value=new Date(value.time).format('Y-m-d');
	        	return value;
    		}
        },{
            header:'检查结果',
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
            header:'检查机构',
            sortable:true,
            dataIndex:"checkOrganization"
        },{
            header:'检查医生',
            sortable:true,
            dataIndex:"checkDoctor"
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
            url:'main/bodyInfo.html?action=getBodyInfo',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'bodyInfo',
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
                id:'bodyInfoAdd',
                text:'添加',
                iconCls:'icon-Add',
                handler:function(){
                    var addwin=new Ynzc.manage.BodyInfoWin();
                    addwin.show(Ext.getCmp("bodyInfoAdd").getEl());
                	}
            	},'-',{
                    id:'refresh',
                    text:'刷新',
                    iconCls:'icon-Add',
                    handler:function(){
            			ds.reload();
                	}
            	}
//目前不开放身体健康信息的删除方法
//            	,'-',{
//                    id:"bodyInfoDel",
//                    text:"删除",
//                    iconCls:"icon-Del",
//                    handler:function(){
//                        var selections=this.selModel.getSelections();
//                        var n=selections.length;
//                        if(n==0){
//                            Ext.ux.Toast.msg("提示","请选中要删除的人员!");
//                            return;
//                        }
//                        var rds="";
//                        for(i=0;i<n;i++){
//                        	if(rds.length == 0){
//                        		rds = rds + selections[i].data.bodyInfoId;
//                        	}else{
//                        		rds = rds + "," + selections[i].data.bodyInfoId;
//                        	}
//                        }
//                         Ext.Msg.show({
//                            title:'系统确认',
//                            msg:'你是否确认删除选中的人员健康信息?',
//                            buttons:Ext.Msg.YESNO,
//                            scope:this,
//                            icon : Ext.MessageBox.QUESTION,
//                            fn:function(btn){
//                                if(btn=="yes"){
//                                    Ext.Ajax.request({
//                                        url:"main/bodyInfo.html?action=delBodyInfo",
//                                        method:"post",
//                                        success:function(resp){
//                							var result=Ext.util.JSON.decode(resp.responseText);
//            								if(result.success==true){
//            									Ext.ux.Toast.msg("提示",result.reason);
//            									ds.reload();
//            								}else{
//            									Ext.ux.Toast.msg("提示",result.reason);
//            								}
//                                        },
//                                        faliure:function(){
//                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
//                                        },
//                                        params:{
//                                            id:rds
//                                        }
//                                    });
//                                }
//                            }
//                         });
//                    }.createDelegate(this)
//                }
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
        Ynzc.manage.PeopleInfoGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
        this.on("rowdblclick",function(grid,index,event){
            var record=grid.getStore().getAt(index);
            Ynzc.manage.updateBodyInfo =new Ynzc.manage.BodyInfoUpdateWin();
            Ynzc.manage.updateBodyInfo.show(grid.getEl());
            if(record.data.resolvingPowerFlag ==="1"){
            	Ext.getCmp("baseHealth").items.items[1].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("baseHealth").items.items[1].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.bodyNeck ==="1"){
            	Ext.getCmp("baseHealth").items.items[2].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("baseHealth").items.items[2].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.rightEyeRectificationFlag =="1"){
            	Ext.getCmp("eyeSet").items.items[1].items.items[0].items.items[0].setValue(true);            	
            }else{
            	Ext.getCmp("eyeSet").items.items[1].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.leftEyeRectificationFlag ==="1"){
            	Ext.getCmp("eyeSet").items.items[3].items.items[0].items.items[0].setValue(true); 
            }else{
            	Ext.getCmp("eyeSet").items.items[3].items.items[1].items.items[0].setValue(true); 
            }
            if(record.data.rightEarPwoer ==="1"){
            	Ext.getCmp("earHealth").items.items[0].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("earHealth").items.items[0].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.leftEarPwoer ==="1"){
            	Ext.getCmp("earHealth").items.items[1].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("earHealth").items.items[1].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.rightHandFlag ==="1"){
            	Ext.getCmp("legsHealth").items.items[0].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("legsHealth").items.items[0].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.leftHandFlag === "1"){
            	Ext.getCmp("legsHealth").items.items[1].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("legsHealth").items.items[1].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.rightLagFlag ==="1"){
            	Ext.getCmp("legsHealth").items.items[2].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("legsHealth").items.items[2].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.leftLagFlag ==="1"){
            	Ext.getCmp("legsHealth").items.items[3].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("legsHealth").items.items[3].items.items[1].items.items[0].setValue(true);
            }
            if(record.data.checkResultFlag ==="1"){
            	Ext.getCmp("checkInfo").items.items[1].items.items[0].items.items[0].setValue(true);
            }else{
            	Ext.getCmp("checkInfo").items.items[1].items.items[1].items.items[0].setValue(true);
            }
            Ynzc.manage.bodyInfoId=record.data.bodyInfoId;
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
            Ext.getCmp("photoDir").getEl().dom.src=record.data.picture;
            Ext.getCmp("hight").setValue(record.data.hight);
            Ext.getCmp("rightEyePwoer").setValue(record.data.rightEyePwoer);
            Ext.getCmp("leftEyePwoer").setValue(record.data.leftEyePwoer);
            Ext.getCmp("bodyCheckDate").setValue(new Date(record.data.bodyCheckDate.time).format('Y-m-d'));
            Ext.getCmp("checkOrganization").setValue(record.data.checkOrganization);
            Ext.getCmp("checkDoctor").setValue(record.data.checkDoctor);
        });
	}
});
Ext.reg('bodyInfoGrid',Ynzc.manage.BodyInfoGrid);