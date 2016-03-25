Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ChangeRecordViewGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'changerecordviewgrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), sm, {
            header: '编号',
            sortable: true,
            dataIndex: "id"
        },
        {
            header: '变更备案事项',
            sortable: true,
            dataIndex: "changerecordtype"
        },
        {
            header: '变更后姓名',
            sortable: true,
            dataIndex: "changerecordname"
        },
        {
            header: '联系电话',
            sortable: true,
            dataIndex: "linktel"
        },
        {
            header: '身份证证明类型',
            sortable: true,
            dataIndex: "realcertificatetype"
        },
        {
            header: '证件号码',
            sortable: true,
            dataIndex: "certificatecode"
        },
        {
            header: '单位/个人',
            sortable: true,
            dataIndex: "unittype"
        },
        {
            header: '住所地址',
            sortable: true,
            dataIndex: "address"
        },
        {
            header: '邮政编号',
            sortable: true,
            dataIndex: "zipcode"
        },
        {
            header: '是否暂住',
            sortable: true,
            dataIndex: "istemporary"          
        },
        {
            header: '暂住证明类型',
            sortable: true,
            dataIndex: "templivefileType"
        },
        {
            header: '暂住证号码',
            sortable: true,
            dataIndex: "temporaycertificatecode"
        },
        {
            header: '登记审核人',
            sortable: true,
            dataIndex: "checkinmen"
        },
        {
            header: '登记审核人经办时间',
            sortable: true,
            dataIndex: "checkindate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '牌证管理员',
            sortable: true,
            dataIndex: "licensemen"
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
                name: 'tractorinfoid'
            },
            {
                name: 'changerecordtype'
            },
            {
                name: 'changerecordname'
            },
            {
                name: 'linktel'
            },
            {
                name: 'certificateid'
            },
            {
                name: 'certificatecode'
            },
            {
                name: 'unittype'
            },
            {
                name: 'address'
            },
            {
                name: 'zipcode'
            },
            {
                name: 'istemporary'
            },
            {
                name: 'temporaycertificate'
            },
            {
                name: 'temporaycertificatecode'
            },
            {
                name: 'checkinmen'
            },
            {
                name: 'checkindate'
            },
            {
                name: 'licensemen'
            },
            {
                name: 'licensedate'
            },
            {
                name: 'businessmen'
            },
            {
                name: 'businessdate'
            },
            {
                name: 'checkmen'
            },
            {
                name: 'checkstate'
            },
            {
                name: 'checkdate'
            },
            {
                name: 'checkcontent'
            },
            {
                name: 'checkip'
            },
            {
                name: 'opertator'
            },
            {
                name: 'opertatedate'
            },
            {
                name: 'realcertificatetype'
            },
            {
                name: 'templivefileType'
            }]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/changeRecord.html?action=getChangeRecordInfo',
            reader: reader,
            sortInfo: {
                field: 'id',
                direction: 'ASC'
            }
        });
        Ext.apply(this, {
            id: 'changeRecordviewgrid',
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
                    
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要审核的变更档案信息!");
                        return;
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                        var carcheckjson = "{id:" + selections[i].data.id + ",tractorinfoid:" + selections[i].data.tractorinfoid + ",changerecordtype:'" + selections[i].data.changerecordtype + "',changerecordname:'" + selections[i].data.changerecordname + "',linktel:'" + selections[i].data.linktel + "',certificateid:'" + selections[i].data.certificateid + "',certificatecode:'" + selections[i].data.certificatecode + "',unittype:'" + selections[i].data.unittype + "',address:'" + selections[i].data.address + "',zipcode:'" + selections[i].data.zipcode + "',istemporary:'" + selections[i].data.istemporary + "',temporaycertificate:'" + selections[i].data.temporaycertificate + "',temporaycertificatecode:'" + selections[i].data.temporaycertificatecode + "',checkinmen:'" + selections[i].data.checkinmen + "',checkindate:'" + new Date(selections[i].data.checkindate.time).format('Y-m-d') + "',licensemen:'" + selections[i].data.licensemen + "',licensedate:'" + new Date(selections[i].data.licensedate.time).format('Y-m-d') + "',businessmen:'" + selections[i].data.businessmen + "',businessdate:'" + new Date(selections[i].data.businessdate.time).format('Y-m-d') + "',opertator:'" + selections[i].data.opertator + "',opertatedate:'" + new Date(selections[i].data.opertatedate.time).format('Y-m-d') + "'}";
                        rds.push(carcheckjson);
                    }

                    Ynzc.manage.ChangeRecordViewGridWin = Ext.extend(Ext.Window, {
                        id: "changerecordtwin",
                        initComponent: function() {
                            Ext.apply(this, {
                                id: "userwin",
                                title: "审核变更档案信息",
                                height: 310,
                                width: 500,
                                resizable: false,
                                modal: true,
                                items: [{
                                    layout: "column",
                                    frame: true,
                                    items: [{
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
                                            if (Ext.getCmp("realname").getValue() == "") {
                                            Ext.MessageBox.alert("提示", "请填写审核意见!");
                                            return;
                                        }
                                        Ext.Ajax.request({
                                            url: "main/changeRecord.html?action=changeRecordHandle",
                                            success: function(resp) {
                                                var result = Ext.util.JSON.decode(resp.responseText);
                                                if (result.success == true) {
                                                    Ext.MessageBox.alert("提示", "审核成功!");
                                                    Ext.getCmp("ChangeRecordViewGridMgr").getStore().reload();
                                                    Ext.getCmp("changerecordtwin").close();
                                                }
                                            },
                                            failure: function() {
                                                Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                            },
                                            params: {
                                                dellist: Ext.util.JSON.encode(rds),
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
                                        Ext.getCmp("changerecordtwin").close();
                                    }
                                }]
                            });
                            Ynzc.manage.ChangeRecordViewGridWin.superclass.initComponent.apply(this, arguments);
                        }
                    });

                    var addwin = new Ynzc.manage.ChangeRecordViewGridWin();
                    addwin.show();
                }.createDelegate(this)
            },
            {
                text: "审核未通过",
                iconCls: "icon-Del",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    var replacementtype = "0";
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要审核的变更档案信息信息!");
                        return;
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                        var carcheckjson = "{id:" + selections[i].data.id + ",tractorinfoid:" + selections[i].data.tractorinfoid + ",changerecordtype:'" + selections[i].data.changerecordtype + "',changerecordname:'" + selections[i].data.changerecordname + "',linktel:'" + selections[i].data.linktel + "',certificateid:'" + selections[i].data.certificateid + "',certificatecode:'" + selections[i].data.certificatecode + "',unittype:'" + selections[i].data.unittype + "',address:'" + selections[i].data.address + "',zipcode:'" + selections[i].data.zipcode + "',istemporary:'" + selections[i].data.istemporary + "',temporaycertificate:'" + selections[i].data.temporaycertificate + "',temporaycertificatecode:'" + selections[i].data.temporaycertificatecode + "',checkinmen:'" + selections[i].data.checkinmen + "',checkindate:'" + new Date(selections[i].data.checkindate.time).format('Y-m-d') + "',licensemen:'" + selections[i].data.licensemen + "',licensedate:'" + new Date(selections[i].data.licensedate.time).format('Y-m-d') + "',businessmen:'" + selections[i].data.businessmen + "',businessdate:'" + new Date(selections[i].data.businessdate.time).format('Y-m-d') + "',opertator:'" + selections[i].data.opertator + "',opertatedate:'" + new Date(selections[i].data.opertatedate.time).format('Y-m-d') + "'}";
                        rds.push(carcheckjson);
                    }

                    Ynzc.manage.ChangeRecordViewWin = Ext.extend(Ext.Window, {
                        id: "changerecordtnowin",
                        initComponent: function() {
                            Ext.apply(this, {
                                id: "userwin",
                                title: "审核变更档案信息",
                                height: 310,
                                width: 500,
                                resizable: false,
                                modal: true,
                                items: [{
                                    layout: "column",
                                    frame: true,
                                    items: [{
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
                                        if (Ext.getCmp("realname").getValue() == "") {
                                            Ext.MessageBox.alert("提示", "请填写审核意见!");
                                            return;
                                        }
                                        Ext.Ajax.request({
                                            url: "main/changeRecord.html?action=changeRecordHandle",
                                            success: function(resp) {
                                                var result = Ext.util.JSON.decode(resp.responseText);
                                                if (result.success == true) {
                                                    Ext.MessageBox.alert("提示", "审核成功!");
                                                    Ext.getCmp("ChangeRecordViewGridMgr").getStore().reload();
                                                    Ext.getCmp("changerecordtnowin").close();
                                                }
                                            },
                                            failure: function() {
                                                Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                            },
                                            params: {                                                                            								
                                                dellist: Ext.util.JSON.encode(rds),
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
                                        Ext.getCmp("changerecordtnowin").close();
                                    }
                                }]
                            });
                            Ynzc.manage.ChangeRecordViewWin.superclass.initComponent.apply(this, arguments);
                        }
                    });

                    var addwin = new Ynzc.manage.ChangeRecordViewWin();
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
Ext.reg('changerecordviewgrid', Ynzc.manage.ChangeRecordViewGrid);