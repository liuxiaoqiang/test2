Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.CTReplacementExamineGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'ctreplacementexaminegrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), sm, {
            header: '编号',
            sortable: true,
            dataIndex: "id"
        },
        {
            header: '号牌号码',
            sortable: true,
            dataIndex: "flapperNumber"
        },
        {
            header: '登记证书编号',
            sortable: true,
            dataIndex: "certregistrationNumber"
        },
        {
            header: '管辖地',
            sortable: true,
            dataIndex: "venue"
        },
        {
            header: '申请事项',
            sortable: true,
            dataIndex: "sortsofinsurance"
        },
        {
            header: '相关凭证',
            sortable: true,
            dataIndex: "selevanceVoucher"
        },
        {
            header: '补换领原因',
            sortable: true,
            dataIndex: "reason"
        },
        {
            header: '补换领机动车号牌',
            sortable: true,
            dataIndex: "flapperFace"
        },
        {
            header: '登记人审核',
            sortable: true,
            dataIndex: "registrantAuditor"
        },
        {
            header: '登记人审核时间',
            sortable: true,
            dataIndex: "registrantAuditorDate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '牌证管理员',
            sortable: true,
            dataIndex: "flapperDirector"
        },
        {
            header: '牌证经办时间',
            sortable: true,
            dataIndex: "flapperDirectorDate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '业务领导审核',
            sortable: true,
            dataIndex: "businessLeadAuditor"
        },
        {
            header: '领导审核时间',
            sortable: true,
            dataIndex: "businessLeadAuditorDate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '审核状态',
            sortable: true,
            dataIndex: "examineStatus"
        }
        ]);
        var reader = new Ext.data.JsonReader({
            totalProperty: "totalCount",
            root: "data",
            autoLoad: true,
            fields: [{
                name: 'id'
            },
            {
                name: 'flapperNumber'
            },
            {
                name: 'certregistrationNumber'
            },
            {
                name: 'venue'
            },
            {
                name: 'sortsofinsurance'
            },
            {
                name: 'selevanceVoucher'
            },
            {
                name: 'reason'
            },
            {
                name: 'flapperFace'
            },
            {
                name: 'registrantAuditor'
            },
            {
                name: 'registrantAuditorDate'
            },
            {
                name: 'flapperDirector'
            },
            {
                name: 'flapperDirectorDate'
            },
            {
                name: 'businessLeadAuditor'
            },
            {
                name: 'businessLeadAuditorDate'
            },
            {
                name: 'examineStatus'
            },
            {
                name: 'operator'
            },
            {
                name: 'operatorDate'
            },
            {
                name: 'untilid'
            }]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/tractorReplacementInfo.html?action=getTractorReplacementInfo',
            reader: reader,
            sortInfo: {
                field: 'id',
                direction: 'ASC'
            }
        });
        Ext.apply(this, {
            id: 'ctreplacementexaminegrid',
            plain: true,
            layout: 'fit',
            border: false,
            cm: cm,
            sm: sm,
            frame: true,
            store: ds,
            loadMask: true,
            plugins: new Ext.ux.grid.Search({
                width: 200,
                iconCls: false
            }),
            tbar: [{
                text: "通过审核",
                handler: function() {

                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    var replacementtype = "1";
                    //                                    alert(Ext.util.Format.date(selections[0].data.registrantAuditorDate,'Y-m-d'));
                    if (n == 0) {
                        Ext.ux.Toast.msg("提示", "请选中要审核的补领补换牌证信息!");
                        return;
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                        rds.push(selections[i].data);
                    }
                    //                                    Ynzc.manage.ctreplacementId=selections[0].data.id;
                    //                                    Ynzc.manage.flapperNumber=selections[0].data.flapperNumber;
                    //                                    Ynzc.manage.certregistrationNumber=selections[0].data.certregistrationNumber;
                    //                                    Ynzc.manage.venue=selections[0].data.venue;
                    //                                    Ynzc.manage.sortsofinsurance=selections[0].data.sortsofinsurance;
                    //                                    Ynzc.manage.selevanceVoucher=selections[0].data.selevanceVoucher;
                    //                                    Ynzc.manage.reason=selections[0].data.reason;
                    //                                    Ynzc.manage.flapperFace=selections[0].data.flapperFace;
                    //                                    Ynzc.manage.registrantAuditor=selections[0].data.registrantAuditor;
                    //                                    Ynzc.manage.registrantAuditorDate=selections[0].data.registrantAuditorDate;
                    //                                    Ynzc.manage.flapperDirector=selections[0].data.flapperDirector;
                    //                                    Ynzc.manage.flapperDirectorDate=selections[0].data.flapperDirectorDate;
                    //                                    Ynzc.manage.businessLeadAuditor=selections[0].data.businessLeadAuditor;
                    //                                    Ynzc.manage.businessLeadAuditorDate=selections[0].data.businessLeadAuditorDate;
                    //                                    Ynzc.manage.examineStatus=selections[0].data.examineStatus;
                    //                                    Ynzc.manage.operator=selections[0].data.operator;
                    //                                    Ynzc.manage.operatorDate=selections[0].data.operatorDate;
                    //                                    Ynzc.manage.untilid = selections[0].data.untilid;

                    Ynzc.manage.CTReplacementWin = Ext.extend(Ext.Window, {
                        id: "ctreplacementwin",
                        initComponent: function() {
                            Ext.apply(this, {
                                id: "userwin",
                                title: "审核补领补换牌证",
                                height: 310,
                                width: 500,
                                resizable: false,
                                modal: true,
                                items: [{
                                    layout: "column",
                                    frame: true,
                                    items: [
                                    //                                					       {
                                    //                                						columnWidth:1,
                                    //                                						layout:"form",
                                    //                                						labelWidth:60,
                                    //                                						items:[{
                                    //                                							id:"username",
                                    //                                							fieldLabel:"审核人",
                                    //                                							xtype:"textfield",
                                    //                                							anchor:'98%'
                                    //                                						}]
                                    //                                					},
                                    {
                                        columnWidth: 1,
                                        layout: "form",
                                        labelWidth: 60,
                                        items: [{
                                            id: "realname",
                                            fieldLabel: "审核意见",
                                            height: 200,
                                            xtype: "textarea",
                                            anchor: '98%'
                                        }]
                                    }]
                                }],
                                buttons: [{
                                    id: "savaBtn",
                                    text: "提交",
                                    handler: function() {
                                        //                                						if(Ext.getCmp("username").getValue()==""){Ext.ux.Toast.msg("提示","请填写审核人姓名!");return}
                                        if (Ext.getCmp("realname").getValue() == "") {
                                            Ext.ux.Toast.msg("提示", "请填写审核意见!");
                                            return;
                                        }
                                        //                                						alert(Ynzc.manage.ctreplacementId);
                                        Ext.Ajax.request({
                                            url: "main/tractorReplacementInfo.html?action=referReplacement",
                                            success: function(resp) {
                                                var result = Ext.util.JSON.decode(resp.responseText);
                                                if (result.success == true) {
                                                    Ext.ux.Toast.msg("提示", "审核成功!");
                                                    Ext.getCmp("CTReplacementExamineMgr").getStore().reload();
                                                    Ext.getCmp("ctreplacementwin").close();
                                                }
                                            },
                                            failure: function() {
                                                Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                            },
                                            params: {
                                                //                                								ctreplacementId:Ynzc.manage.ctreplacementId,
                                                //                                								flapperNumber:Ynzc.manage.flapperNumber,
                                                //                                								certregistrationNumber:Ynzc.manage.certregistrationNumber,
                                                //                                								venue:Ynzc.manage.venue,
                                                //                                								sortsofinsurance:Ynzc.manage.sortsofinsurance,
                                                //                                								selevanceVoucher: Ynzc.manage.selevanceVoucher,
                                                //                                								reason:Ynzc.manage.reason,
                                                //                                								flapperFace:Ynzc.manage.flapperFace,
                                                //                                								registrantAuditor:Ynzc.manage.registrantAuditor,
                                                //                                								registrantAuditorDate:Ynzc.manage.registrantAuditorDate,
                                                //                                								flapperDirector: Ynzc.manage.flapperDirector,
                                                //                                								flapperDirectorDate:Ext.util.Format.date(Ynzc.manage.flapperDirectorDate, 'Y-m-d'),
                                                //                                								businessLeadAuditor:Ynzc.manage.businessLeadAuditor,
                                                //                                								businessLeadAuditorDate:Ext.util.Format.date(Ynzc.manage.businessLeadAuditorDate, 'Y-m-d'),
                                                //                                								examineStatus:Ynzc.manage.examineStatus,
                                                //                                								operator:Ynzc.manage.operator,
                                                //                                								operatorDate: Ext.util.Format.date(Ynzc.manage.operatorDate, 'Y-m-d'),
                                                //                                								username:Ext.getCmp("username").getValue(),
                                                //                                								realname:Ext.getCmp("realname").getValue(),
                                                //                                								untilid:Ynzc.manage.untilid,
                                                dellist: Ext.util.JSON.encode(rds),
                                                //                                								username:Ext.getCmp("username").getValue(),
                                                realname: Ext.getCmp("realname").getValue(),
                                                replacementtype: replacementtype
                                            }
                                        });
                                    }
                                },
                                {
                                    id: "cancelBtn",
                                    text: "取消",
                                    handler: function() {
                                        Ext.getCmp("ctreplacementwin").close();
                                    }
                                }]
                            });
                            Ynzc.manage.CTReplacementWin.superclass.initComponent.apply(this, arguments);
                        }
                    });

                    var addwin = new Ynzc.manage.CTReplacementWin();
                    addwin.show();
                }.createDelegate(this)
            },
            {
                text: "审核未通过",
                iconCls: "icon-Del",
                handler: function()
                //                            {
                //                                    var selections=this.selModel.getSelections();
                //                                    var n=selections.length;
                //                                    if(n==0){
                //                                        Ext.ux.Toast.msg("提示","请选中要审核的年检信息!");
                //                                        return;
                //                                    }
                ////                                    var rds=[];
                ////                                    for(i=0;i<n;i++){
                ////                                        var carcheckjson="{id:"+selections[i].data.id+",tractorinfoId:"+selections[i].data.tractorinfoId+",inspectorresult:'"+selections[i].data.inspectorresult+"',checkexpirydate:'"+selections[i].data.checkexpirydate.time+"',inspector:'"+selections[i].data.inspector+"',inspectordate:"+selections[i].data.inspectordate.time+",checkcompanyname:'"+selections[i].data.checkcompanyname+"',insurancelistno:'"+selections[i].data.insurancelistno+"',insurancedate:'"+selections[i].data.insurancedate.time+"',insurancecompanyname:'"+selections[i].data.insurancecompanyname+"',expirydate:'"+selections[i].data.expirydate.time+"',reviewer:'"+selections[i].data.reviewer+"',reviewerconductdate:'"+selections[i].data.reviewerconductdate.time+"',issueadmin:'"+selections[i].data.issueadmin+"',issueadmindate:'"+selections[i].data.issueadmindate.time+"',leaderreview:'"+selections[i].data.leaderreview+"',leaderreviewdate:'"+selections[i].data.leaderreviewdate.time+"',operateuser:'"+selections[i].data.operateuser+"',operatedate:'"+selections[i].data.operatedate.time+"',checkuser:'"+selections[i].data.checkuser+"',checkdate:'"+selections[i].data.checkdate+"',checkip:'"+selections[i].data.checkip+"',checkresult:'"+selections[i].data.checkresult+"'}";
                ////                                        rds.push(carcheckjson);
                ////                                    }
                ////                                     Ext.Msg.show({
                ////                                        title:'系统确认',
                ////                                        msg:'你是否确认对选中的年检信息进行审核?',
                ////                                        buttons:Ext.Msg.YESNO,
                ////                                        scope:this,
                ////                                        icon : Ext.MessageBox.QUESTION,
                ////                                        fn:function(btn){
                ////                                            if(btn=="yes"){
                ////                                                Ext.Ajax.request({
                ////                                                    url:"main/carCheck.html?action=updateCarCheck",
                ////                                                    method:"post",
                ////                                                    success:function(){
                ////                                                        Ext.ux.Toast.msg("提示","审核成功");
                ////                                                        ds.reload();
                ////                                                    },
                ////                                                    faliure:function(){
                ////                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                ////                                                    },
                ////                                                    params:{
                ////                                                        checkIds:Ext.util.JSON.encode(rds),
                ////                                                        state:"审核未通过"
                ////                                                    }
                ////                                                });
                ////                                            }
                ////                                        }
                ////                                     });  
                //                                    
                //                                    var addwin=new Ynzc.manage.CTReplacementFailureWin();
                //                                    addwin.show();
                //                            }
                {

                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    var replacementtype = "0";
                    //                                alert(Ext.util.Format.date(selections[0].data.registrantAuditorDate,'Y-m-d'));
                    if (n == 0) {
                        Ext.ux.Toast.msg("提示", "请选中要审核的补领补换牌证信息!");
                        return;
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                        rds.push(selections[i].data);
                    }
                    //                                Ynzc.manage.ctreplacementId=selections[0].data.id;
                    //                                Ynzc.manage.flapperNumber=selections[0].data.flapperNumber;
                    //                                Ynzc.manage.certregistrationNumber=selections[0].data.certregistrationNumber;
                    //                                Ynzc.manage.venue=selections[0].data.venue;
                    //                                Ynzc.manage.sortsofinsurance=selections[0].data.sortsofinsurance;
                    //                                Ynzc.manage.selevanceVoucher=selections[0].data.selevanceVoucher;
                    //                                Ynzc.manage.reason=selections[0].data.reason;
                    //                                Ynzc.manage.flapperFace=selections[0].data.flapperFace;
                    //                                Ynzc.manage.registrantAuditor=selections[0].data.registrantAuditor;
                    //                                Ynzc.manage.registrantAuditorDate=selections[0].data.registrantAuditorDate;
                    //                                Ynzc.manage.flapperDirector=selections[0].data.flapperDirector;
                    //                                Ynzc.manage.flapperDirectorDate=selections[0].data.flapperDirectorDate;
                    //                                Ynzc.manage.businessLeadAuditor=selections[0].data.businessLeadAuditor;
                    //                                Ynzc.manage.businessLeadAuditorDate=selections[0].data.businessLeadAuditorDate;
                    //                                Ynzc.manage.examineStatus=selections[0].data.examineStatus;
                    //                                Ynzc.manage.operator=selections[0].data.operator;
                    //                                Ynzc.manage.operatorDate=selections[0].data.operatorDate;
                    //                                Ynzc.manage.untilid = selections[0].data.untilid;

                    Ynzc.manage.CTReplacementWin = Ext.extend(Ext.Window, {
                        id: "ctreplacementwin",
                        initComponent: function() {
                            Ext.apply(this, {
                                id: "userwin",
                                title: "审核补领补换牌证",
                                height: 310,
                                width: 500,
                                resizable: false,
                                modal: true,
                                items: [{
                                    layout: "column",
                                    frame: true,
                                    items: [
                                    //                            					       {
                                    //                            						columnWidth:1,
                                    //                            						layout:"form",
                                    //                            						labelWidth:60,
                                    //                            						items:[{
                                    //                            							id:"username",
                                    //                            							fieldLabel:"审核人",
                                    //                            							xtype:"textfield",
                                    //                            							anchor:'98%'
                                    //                            						}]
                                    //                            					},
                                    {
                                        columnWidth: 1,
                                        layout: "form",
                                        labelWidth: 60,
                                        items: [{
                                            id: "realname",
                                            fieldLabel: "未审核意见",
                                            height: 200,
                                            xtype: "textarea",
                                            anchor: '98%'
                                        }]
                                    }]
                                }],
                                buttons: [{
                                    id: "savaBtn",
                                    text: "提交",
                                    handler: function() {
                                        //                            						if(Ext.getCmp("username").getValue()==""){Ext.ux.Toast.msg("提示","请填写审核人姓名!");return}
                                        if (Ext.getCmp("realname").getValue() == "") {
                                            Ext.ux.Toast.msg("提示", "请填写审核意见!");
                                            return;
                                        }
                                        //                            						alert(Ynzc.manage.ctreplacementId);
                                                                        var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                        Ext.Ajax.request({
                                            url: "main/tractorReplacementInfo.html?action=referReplacement",
                                            success: function(resp) {
                                            mask.hide();
                                                var result = Ext.util.JSON.decode(resp.responseText);
                                                if (result.success == true) {
                                                    Ext.ux.Toast.msg("提示", "审核成功!");
                                                    Ext.getCmp("CTReplacementExamineMgr").getStore().reload();
                                                    Ext.getCmp("ctreplacementwin").close();
                                                }
                                            },
                                            failure: function() {
                                                Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                            },
                                            params: {
                                                //                            								ctreplacementId:Ynzc.manage.ctreplacementId,
                                                //                            								flapperNumber:Ynzc.manage.flapperNumber,
                                                //                            								certregistrationNumber:Ynzc.manage.certregistrationNumber,
                                                //                            								venue:Ynzc.manage.venue,
                                                //                            								sortsofinsurance:Ynzc.manage.sortsofinsurance,
                                                //                            								selevanceVoucher: Ynzc.manage.selevanceVoucher,
                                                //                            								reason:Ynzc.manage.reason,
                                                //                            								flapperFace:Ynzc.manage.flapperFace,
                                                //                            								registrantAuditor:Ynzc.manage.registrantAuditor,
                                                //                            								registrantAuditorDate:Ynzc.manage.registrantAuditorDate,
                                                //                            								flapperDirector: Ynzc.manage.flapperDirector,
                                                //                            								flapperDirectorDate:Ext.util.Format.date(Ynzc.manage.flapperDirectorDate, 'Y-m-d'),
                                                //                            								businessLeadAuditor:Ynzc.manage.businessLeadAuditor,
                                                //                            								businessLeadAuditorDate:Ext.util.Format.date(Ynzc.manage.businessLeadAuditorDate, 'Y-m-d'),
                                                //                            								examineStatus:Ynzc.manage.examineStatus,
                                                //                            								operator:Ynzc.manage.operator,
                                                //                            								operatorDate: Ext.util.Format.date(Ynzc.manage.operatorDate, 'Y-m-d'),
                                                //                            								username:Ext.getCmp("username").getValue(),
                                                //                            								realname:Ext.getCmp("realname").getValue(),
                                                //                            								untilid:Ynzc.manage.untilid,
                                                dellist: Ext.util.JSON.encode(rds),
                                                //                            								username:Ext.getCmp("username").getValue(),
                                                realname: Ext.getCmp("realname").getValue(),
                                                replacementtype: replacementtype
                                            }
                                        });
                                    }
                                },
                                {
                                    id: "cancelBtn",
                                    text: "取消",
                                    handler: function() {
                                        Ext.getCmp("ctreplacementwin").close();
                                    }
                                }]
                            });
                            Ynzc.manage.CTReplacementWin.superclass.initComponent.apply(this, arguments);
                        }
                    });

                    var addwin = new Ynzc.manage.CTReplacementWin();
                    addwin.show();
                }.createDelegate(this)
            }],
            bbar: new Ext.PagingToolbar({
                pageSize: 20,
                store: ds,
                displayInfo: true,
                displayMsg: '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                emptyMsg: '无记录'
            }),
            viewConfig: {
                forceFit: true
            }
        });
        Ynzc.manage.CertificateGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20,
                state: ""
            }
        });
    }
});
Ext.reg('ctreplacementexaminegrid', Ynzc.manage.CTReplacementExamineGrid);