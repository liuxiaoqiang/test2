Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.TractorRegisterWin = Ext.extend(Ext.Window, {
    id: 'tractorregisterwin',
    initComponent: function() {
		var date=new Date();
		var year=date.getFullYear()+1;
		var month=date.getMonth();
		var day=date.getDate()-1;
		var effectivedate=new Date();
		effectivedate.setFullYear(year, month, day);
        Ext.apply(this, {
            id: 'tractorregisterwin',
            title: " 请填写注册登记信息",
            iconCls: 'icon-Add',
            resizable: false,
            modal: true,
            height: 530,
            width: 700,
            items: [{
                xtype: 'tabpanel',
                border: false,
                frame: true, 
                activeTab: 0,
                items: [{
                    title: '所有人信息',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    height: 500,
                    layout: "column",
                    items: [{
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "owner",
                            fieldLabel: "姓名/名称",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "telephone",
                            fieldLabel: "联系电话",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "realcertificatetype",
                            fieldLabel: "有效证件类型",
                            xtype: "combo",
                            displayField: 'realcertificatetype',
                            valueField: 'id',
                            value:8,
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.Certificate,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "realcertificateno",
                            fieldLabel: "有效证件编号",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: 1,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "address",
                            fieldLabel: "家庭联系地址",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "zipcode",
                            fieldLabel: "邮政编码",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .25,
                        layout: "form",
                        labelWidth: 70,
                        items: [{
                            id: "isunion",
                            fieldLabel: "单位/个人",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            value: 0,
                            store: Ynzc.manage.UOrPStore,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .25,
                        layout: "form",
                        labelWidth: 70,
                        items: [{
                            id: "istemplived",
                            fieldLabel: "是否暂住",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.YesOrNoStore,
                            value: 0,
                            listeners: {
                                'select': function(combo, record, index) {
                                    if (record.data.value == 1) {
                                        Ext.getCmp('tempaddress').setValue(null);
                                        Ext.getCmp('timplivefileno').setValue(null);
                                        Ext.getCmp('templivefiletype').setValue(null);
                                        Ext.getCmp('tempaddress').setDisabled(false);
                                        Ext.getCmp('timplivefileno').setDisabled(false);
                                        Ext.getCmp('templivefiletype').setDisabled(false);
                                    } else {
                                        Ext.getCmp('tempaddress').setValue("无");
                                        Ext.getCmp('timplivefileno').setValue("无");
                                        Ext.getCmp('templivefiletype').setValue("无");
                                        Ext.getCmp('tempaddress').setDisabled(true);
                                        Ext.getCmp('templivefiletype').setDisabled(true);
                                        Ext.getCmp('timplivefileno').setDisabled(true);
                                    }
                                }
                            },
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "templivefiletype",
                            fieldLabel: "暂住证明类别",
                            xtype: "combo",
                            displayField: 'templivefileType',
                            disabled: true,
                            valueField: 'id',
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.TempliveFile,
                            value: "0",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "timplivefileno",
                            fieldLabel: "暂住证明号码",
                            disabled: true,
                            xtype: "textfield",
                            value: "无",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: 1,
                        layout: "form",
                        labelWidth: 80,
                        items: [{
                            id: "tempaddress",
                            fieldLabel: "现居住地址",
                            disabled: true,
                            value: "无",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    }]
                },
                {
                    title: '拖拉机基本信息',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    layout: "column",
                    height: 500,
                    items: [{
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 90,
                        items: [{
                            id: "getwayid",
                            fieldLabel: "获取方式",
                            xtype: "combo",
                            displayField: 'getway',
                            valueField: 'id',
                            value:5,
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.GetWay,
                            anchor: '98%'
                        },
                        {
                            id: 'machinetypeid',
                            fieldLabel: "机械类型",
                            xtype: "combo",
                            displayField: 'machinetype',
                            valueField: 'id',
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.MachineType,
                            anchor: '98%'
                        },
                        {
                            id: "usedfor",
                            fieldLabel: "使用性质",
                            xtype: "combo",
                            displayField: 'display',
                            valueField: 'value',
                            value:'农兼营',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.UsedFor,
                            anchor: '98%'
                        },
                        {
                            id: "machinebodyno",
                            fieldLabel: "机身(底盘)号码",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: "engineno",
                            fieldLabel: "发动机号码",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: "shelfno",
                            fieldLabel: "挂机架号码",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: "manufacturer",
                            fieldLabel: "制造厂名称",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        labelWidth: 85,
                        layout: "form",
                        items: [{
                            id: "photourl",
                            xtype: "picpanel",
                            defaultPicUrl: "./Public/Images/sys/noupload.gif",
                            actionUrl: "main/tractorInfo.html?action=uploadPic",
                            uploadWinTitle: "拖拉机照片",
                            height: 180,
                            width: 320
                        }]
                    },
                    {
                        columnWidth: 1,
                        labelWidth: 90,
                        layout: "form",
                        items: [{
                            id: "machinebrandtypeid",
                            fieldLabel: "品牌型号",
                            xtype: "vcombo",
                            anchor: "100%"
                        }]
                    },
                    {
                        columnWidth: 1,
                        labelWidth: 130,
                        layout: "form",
                        items: [{
                            id: "seller",
                            fieldLabel: "销售(交易市场)名称",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        labelWidth: 90,
                        layout: "form",
                        items: [{
                            id: "manufacturedate",
                            fieldLabel: "出厂日期",
                            readOnly: true,
                            xtype: "datefield",
                            format: "Y-m-d",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        labelWidth: 90,
                        layout: "form",
                        items: [{
                            id: "price",
                            fieldLabel: "销售/交易价格",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    }]
                },
                {
                    title: '相关资料',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    layout: "column",
                    height: 500,
                    items: [{
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 90,
                        items: [{
                            id: "getwayfiletypeid",
                            fieldLabel: "来历凭证类型",
                            xtype: "combo",
                            displayField: 'getWayFileType',
                            valueField: 'id',
                            value:1,
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.WayFile,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        labelWidth: 90,
                        layout: "form",
                        items: [{
                            id: "getwayfileno",
                            fieldLabel: "来历凭证编号",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 90,
                        items: [{
                            id: "importsfiletypeid",
                            fieldLabel: "进口凭证类型",
                            xtype: "combo",
                            displayField: 'importsFileType',
                            valueField: 'id',
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.ImportsFile,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .5,
                        labelWidth: 90,
                        layout: "form",
                        items: [{
                            id: "importsfileno",
                            fieldLabel: "进口凭证编号",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: 1,
                        labelWidth: 90,
                        layout: "form",
                        items: [{
                            id: "other",
                            title: "其他资料",
                            xtype: "fieldset",
                            height: 'auto',
                            collapsible: false,
                            layout: "column",
                            items: [{
                                columnWidth: .3,
                                layout: "fit",
                                labelWidth: 160,
                                items: [{
                                    id: "otherOne",
                                    boxLabel: "国产拖拉机整车出厂合格证明",
                                    xtype: "checkbox",
                                    checked:true,
                                    value: "国产拖拉机整车出厂合格证明"
                                }]
                            },
                            {
                                columnWidth: .15,
                                layout: "fit",
                                labelWidth: 160,
                                items: [{
                                    id: "otherTwo",
                                    boxLabel: "拖拉机档案",
                                    xtype: "checkbox",
                                    checked:true,
                                    value: '拖拉机档案'
                                }]
                            },
                            {
                                columnWidth: .12,
                                layout: "fit",
                                labelWidth: 160,
                                items: [{
                                    id: "otherThree",
                                    boxLabel: "身份证明",
                                    xtype: "checkbox",
                                    checked:true,
                                    value: "身份证明"
                                }]
                            },
                            {
                                columnWidth: .25,
                                layout: "fit",
                                labelWidth: 160,
                                items: [{
                                    id: "otherFour",
                                    boxLabel: "《协助执行通知书》",
                                    xtype: "checkbox",
                                    value: "《协助执行通知书》"
                                }]
                            },
                            {
                                columnWidth: .15,
                                layout: "fit",
                                labelWidth: 160,
                                items: [{
                                    id: "otherFive",
                                    boxLabel: "《公证书》",
                                    xtype: "checkbox",
                                    value: "《公证书》"
                                }]
                            }],
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: 1,
                        layout: "fit",
                        items: [{
                            id: "insurance",
                            title: "交强险",
                            xtype: "fieldset",
                            height: 100,
                            collapsible: false,
                            layout: "column",
                            items: [{
                                columnWidth: .4,
                                layout: "form",
                                labelWidth: 70,
                                items: [{
                                    id: 'insurancelistno',
                                    fieldLabel: "保单号",
                                    xtype: "textfield",
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .6,
                                layout: "form",
                                labelWidth: 70,
                                items: [{
                                    id: "insurancecompanyname",
                                    shadowOffset: 0,
                                    fieldLabel: "保险公司",
                                    xtype: "icombo",
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .4,
                                layout: "form",
                                labelWidth: 70,
                                items: [{
                                    id: "insurancedate",
                                    fieldLabel: "保险日期",
                                    readOnly: true,
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(),
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .6,
                                layout: "form",
                                labelWidth: 70,
                                items: [{
                                    id: "expirydate",
                                    fieldLabel: "保险有效期",
                                    readOnly: true,
                                    value:effectivedate,
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    anchor: '98%'
                                }]
                            }]
                        }]
                    }]
                },
                {
                    title: '注册信息',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    height: 500,
                    layout: "column",
                    items: [{
                    	columnWidth: .5,
                    	layout: "form",
                    	labelWidth: 90,
                    	items: [{
                    		id: "license",
                    		fieldLabel: "号牌号码",
                    		xtype: "textfield",
                    		readOnly: true,
                    		anchor: '98%'
                    	}]
                    },
                    {
                    	columnWidth: .5,
                    	layout: "form",
                    	labelWidth: 90,
                    	items: [{
                    		id: "regcerno",
                    		fieldLabel: "登记证书编号",
                    		xtype: "textfield",
                    		anchor: '98%'
                    	}]
                    },{
                    	columnWidth: .5,
                    	layout: "form",
                    	labelWidth: 90,
                    	items: [{
                    		id: "registerdate",
                    		fieldLabel: "注册日期",
                            readOnly: true,
                            xtype: "datefield",
                            format: "Y-m-d",
                            value: new Date(),
                            anchor: '98%'
                    	}]
                    },{
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 90,
                        items: [{
                            id: "issuedate",
                            fieldLabel: "发牌证日期",
                            readOnly: true,
                            xtype: "datefield",
                            format: "Y-m-d",
                            value: new Date(),
                            anchor: '98%'
                        }]
                    },
//                    {
//                    	columnWidth: .5,
//                        layout: "form",
//                        labelWidth: 90,
//                        items: [{
//                            id: "turnindate",
//                            fieldLabel: "转入日期",
//                            readOnly: true,
//                            xtype: "datefield",
//                            format: "Y-m-d",
//                            anchor: '98%'
//                        }]
//                    },{
//                        columnWidth: .5,
//                        layout: "form",
//                        labelWidth: 90,
//                        items: [{
//                        	id: "beforeregionStr",
//                            fieldLabel: "转入前管辖地",
//                            readOnly: true,
//                            xtype: "rrcombo",
//                            value: "无",
//                            anchor: '98%'
//                        }]
//                    },{
//                    	columnWidth: .5,
//                    	layout: "form",
//                        labelWidth: 90,
//                        hidden: true,
//                        items: [{
//                            id: "beforeregion",
//                            fieldLabel: "转入前管辖地id",
//                            value: "无",
//                            xtype: "textfield",
//                            anchor: '98%'
//                        }]
//                    },
                    {
                        columnWidth: .5,
                        layout: "form",
                        labelWidth: 90,
                        items: [{
                        	id: "unitid",
                            fieldLabel: "所属管辖单位",
                            xtype: "combo",
                            displayField: 'useunit',
                            valueField: 'id',
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            disabled: true,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.UnitStore,
                            value: UnitID,
                            anchor: '98%'
                        }]
                    },{
                    	columnWidth:.5,
                    	layout:"form",
                    	labelWidth:90,
                    	items:[{
                    		 id: "regionStr",
                             fieldLabel: "现管辖地",
                             readOnly: true,
                             xtype: "rccombo",
                             value: "请选择现管辖地",
                             anchor: '98%'
                    	}]
                    },{
                    	columnWidth: .5,
                    	layout: "form",
                        labelWidth: 90,
                        hidden: true,
                        items: [{
                            id: "regionvalue",
                            fieldLabel: "现管辖地id",
                            value: "请选择现管辖地",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    }]
                },
                {
                    title: '技术参数',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    height: 500,
                    layout: "column",
                    items: [{
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "machinebodycolor",
                            fieldLabel: "机身颜色",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "outsize",
                            fieldLabel: "外廓尺寸",
                            xtype: "textfield",
                            readOnly: true,
                            listeners: {
                                'focus': function() {
                                    new Ext.Window({
                                        id: "outwin",
                                        title: "外廓尺寸[单位：<font color=red>MM</font>]",
                                        height: 160,
                                        modal: true,
                                        width: 200,
                                        resizable: false,
                                        layout: "form",
                                        bodyStyle: "padding:5px 5px",
                                        labelWidth: 20,
                                        items: [{
                                            id: "outLength",
                                            fieldLabel: "长",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        },
                                        {
                                            id: "outWidth",
                                            fieldLabel: "宽",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        },
                                        {
                                            id: "outHeight",
                                            fieldLabel: "高",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        }],
                                        buttons: [{
                                            text: "确定",
                                            handler: function() {
                                                if (Ext.getCmp("outLength").getValue() == "" || Ext.getCmp("outWidth").getValue() == "" || Ext.getCmp("outHeight").getValue() == "") {
                                                    Ext.MessageBox.alert("提示", "录入的数据不完整，请检查!");
                                                    return;
                                                } else {
                                                    var res = Ext.getCmp("outLength").getValue() + "," + Ext.getCmp("outWidth").getValue() + "," + Ext.getCmp("outHeight").getValue();
                                                    Ext.getCmp("outsize").setValue(res);
                                                    Ext.getCmp("outwin").close();
                                                }
                                            }
                                        }]
                                    }).show(Ext.getCmp("outsize").getEl());
                                    if (Ext.getCmp("outsize").getValue() != "") {
                                        var strArray = Ext.getCmp("outsize").getValue().split(",");
                                        Ext.getCmp("outLength").setValue(strArray[0]);
                                        Ext.getCmp("outWidth").setValue(strArray[1]);
                                        Ext.getCmp("outHeight").setValue(strArray[2]);
                                    }
                                }
                            },
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "containersize",
                            fieldLabel: "货箱内部尺寸",
                            xtype: "textfield",
                            readOnly: true,
                            listeners: {
                                "focus": function() {
                                    new Ext.Window({
                                        id: "containerwin",
                                        title: "货箱内部尺寸[单位：<font color=red>MM</font>]",
                                        height: 160,
                                        modal: true,
                                        width: 200,
                                        resizable: false,
                                        layout: "form",
                                        bodyStyle: "padding:5px 5px",
                                        labelWidth: 20,
                                        items: [{
                                            id: "containerLength",
                                            fieldLabel: "长",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        },
                                        {
                                            id: "containerWidth",
                                            fieldLabel: "宽",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        },
                                        {
                                            id: "containerHeight",
                                            fieldLabel: "高",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        }],
                                        buttons: [{
                                            text: "确定",
                                            handler: function() {
                                                if (Ext.getCmp("containerLength").getValue() == "" || Ext.getCmp("containerWidth").getValue() == "" || Ext.getCmp("containerHeight").getValue() == "") {
                                                    Ext.MessageBox.alert("提示", "录入的数据不完整，请检查!");
                                                    return;
                                                } else {
                                                    var res = Ext.getCmp("containerLength").getValue() + "," + Ext.getCmp("containerWidth").getValue() + "," + Ext.getCmp("containerHeight").getValue();
                                                    Ext.getCmp("containersize").setValue(res);
                                                    Ext.getCmp("containerwin").close();
                                                }
                                            }
                                        }]
                                    }).show(Ext.getCmp("containersize").getEl());
                                    if (Ext.getCmp("containersize").getValue() != "") {
                                        var strArray = Ext.getCmp("containersize").getValue().split(",");
                                        Ext.getCmp("containerLength").setValue(strArray[0]);
                                        Ext.getCmp("containerWidth").setValue(strArray[1]);
                                        Ext.getCmp("containerHeight").setValue(strArray[2]);
                                    }
                                }
                            },
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "directcontrol",
                            fieldLabel: "转向形式",
                            xtype: "combo",
                            displayField: 'display',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.DirectStore,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "steelspring",
                            //isNaN()
                            fieldLabel: "钢板弹簧片数",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "power",
                            fieldLabel: "功率",
                            xtype: "textfield",
                            readOnly: true,
                            listeners: {
                                "focus": function() {
                                    new Ext.Window({
                                        id: "powerwin",
                                        title: "功率",
                                        height: 115,
                                        modal: true,
                                        width: 200,
                                        resizable: false,
                                        bodyStyle: "padding:5px 5px",
                                        labelWidth: 20,
                                        layout: "fit",
                                        items: [{
                                            layout: "column",
                                            frame: true,
                                            border: false,
                                            items: [{
                                                columnWidth: .35,
                                                items: [{
                                                    id: "v",
                                                    xtype: "textfield",
                                                    anchor: "98%"
                                                }]
                                            },
                                            {
                                                columnWidth: .15,
                                                items: [{
                                                    id: "Vunit",
                                                    xtype: "label",
                                                    html: "CM³"
                                                }]
                                            },
                                            {
                                                columnWidth: .35,
                                                items: [{
                                                    id: "k",
                                                    xtype: "textfield",
                                                    anchor: "98%"
                                                }]
                                            },
                                            {
                                                columnWidth: .15,
                                                items: [{
                                                    id: "KW",
                                                    xtype: "label",
                                                    html: "KW"
                                                }]
                                            }]
                                        }],
                                        buttons: [{
                                            text: "确定",
                                            handler: function() {
                                                if (Ext.getCmp("v").getValue() == "" || Ext.getCmp("k").getValue() == "") {
                                                    Ext.MessageBox.alert("提示", "录入的数据不完整，请检查!");
                                                    return;
                                                } else {
                                                    var res = Ext.getCmp("v").getValue() + "CM³/" + Ext.getCmp("k").getValue() + "KW";
                                                    Ext.getCmp("power").setValue(res);
                                                    Ext.getCmp("powerwin").close();
                                                }
                                            }
                                        }]
                                    }).show(Ext.getCmp("power").getEl());
                                    if (Ext.getCmp("power").getValue() != "") {
                                        var r1 = Ext.getCmp("power").getValue().split("CM³/");
                                        Ext.getCmp("v").setValue(r1[0]);
                                        Ext.getCmp("k").setValue(r1[1].substring(0, r1[1].length - 2));
                                    }
                                }
                            },
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "cylinderno",
                            fieldLabel: "缸数",
                            xtype: "combo",
                            displayField: 'display',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.CylinderStore,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "fueltypeid",
                            fieldLabel: "燃料种类",
                            xtype: "combo",
                            displayField: 'fuelname',
                            valueField: 'id',
                            typeAhead: true,
                            mode: 'remote',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            store: Ynzc.manage.FuelType,
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "wheelno",
                            //isNaN()
                            fieldLabel: "轴数",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "wheelbase",
                            //isNaN()
                            fieldLabel: "轴距",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "tiresno",
                            //isNaN()
                            fieldLabel: "轮胎数",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "tiressize",
                            //isNaN()
                            fieldLabel: "轮胎规格",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "wheeldis",
                            fieldLabel: "轮距",
                            xtype: "textfield",
                            readOnly: true,
                            listeners: {
                                "focus": function() {
                                    new Ext.Window({
                                        id: "wheelwin",
                                        title: "轮距[单位：<font color=red>MM</font>]",
                                        height: 130,
                                        modal: true,
                                        width: 200,
                                        resizable: false,
                                        layout: "form",
                                        bodyStyle: "padding:5px 5px",
                                        labelWidth: 20,
                                        items: [{
                                            id: "wheelFront",
                                            fieldLabel: "前",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        },
                                        {
                                            id: "wheelBack",
                                            fieldLabel: "后",
                                            xtype: "textfield",
                                            anchor: '100%'
                                        }],
                                        buttons: [{
                                            text: "确定",
                                            handler: function() {
                                                if (Ext.getCmp("wheelFront").getValue() == "" || Ext.getCmp("wheelBack").getValue() == "") {
                                                    Ext.MessageBox.alert("提示", "录入的数据不完整，请检查!");
                                                    return;
                                                } else {
                                                    var res = Ext.getCmp("wheelFront").getValue() + "," + Ext.getCmp("wheelBack").getValue();
                                                    Ext.getCmp("wheeldis").setValue(res);
                                                    Ext.getCmp("wheelwin").close();
                                                }
                                            }
                                        }]
                                    }).show(Ext.getCmp("wheeldis").getEl());
                                    if (Ext.getCmp("wheeldis").getValue() != "") {
                                        var strArray = Ext.getCmp("wheeldis").getValue().split(",");
                                        Ext.getCmp("wheelFront").setValue(strArray[0]);
                                        Ext.getCmp("wheelBack").setValue(strArray[1]);
                                    }
                                }
                            },
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "totalquality",
                            //isNaN()
                            fieldLabel: "总质量",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "allquality",
                            //isNaN()
                            fieldLabel: "整备质量",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "ratifiedload",
                            //isNaN()
                            fieldLabel: "核定载质量",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "allowdragtotalquality",
                            //isNaN()
                            fieldLabel: "准牵引总质量",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "driverinno",
                            //isNaN()
                            fieldLabel: "驾驶室载人数",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "vicecartiresno",
                            //isNaN()
                            fieldLabel: "挂车轮胎数",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "outcarwheeldis",
                            //isNaN()
                            fieldLabel: "挂车轮距",
                            xtype: "textfield",
                            anchor: '98%'
                        }]
                    },
                    {
                        columnWidth: .33,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "outcartiressize",
                            //isNaN()
                            fieldLabel: "挂车轮胎规格",
                            xtype: "textfield",
                            anchor: '100%'
                        }]
                    },
                    {
                        columnWidth: 1,
                        layout: "form",
                        labelWidth: 85,
                        items: [{
                            id: "enginebrandid",
                            fieldLabel: "发动机品牌",
                            xtype: "ebcombo",
                            width: 375
                        }]
                    }]
                },
                {
                    title: '技术检验',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    height: 500,
                    layout: "column",
                    items: [{
                    	columnWidth:1,
                    	layout:"form",
                    	items:[{
                    		id:"safeinspect",
                            title:"总检结果",
                            xtype:"fieldset",
                            height:'auto',
                            collapsible:false,
                            layout:"column",
                            items:[{
                            	columnWidth:.33,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{                                
                            		id: "checkresult",
                            		fieldLabel: "检验结论",
                            		xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		value:"合格",
                            		typeAhead: true,
                            		mode: 'local',
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '98%',
                            		listeners: {
                                        'select': function(combo, record, index) {
                                            if (record.data.value == "合格") {   
                                            	Ext.getCmp("disqualification").setValue("无");
                                            	Ext.getCmp("disqualification").disable();
                                            	Ext.getCmp("showdisqualification").setValue("无");
                                            	Ext.getCmp("showdisqualification").disable();
                                            	Ext.getCmp("enginedisqualification").setValue("无");
                                            	Ext.getCmp("enginedisqualification").disable();
                                            	Ext.getCmp("conveyordisqualification").setValue("无");
                                            	Ext.getCmp("conveyordisqualification").disable();
                                            	Ext.getCmp("steeringdisqualification").setValue("无");
                                            	Ext.getCmp("steeringdisqualification").disable();
                                            	Ext.getCmp("flyhostdisqualification").setValue("无");
                                            	Ext.getCmp("flyhostdisqualification").disable();
                                            	Ext.getCmp("flytrailerdisqualification").setValue("无");
                                            	Ext.getCmp("flytrailerdisqualification").disable();
                                            	Ext.getCmp("brakhostdisqualification").setValue("无");
                                            	Ext.getCmp("brakhostdisqualification").disable();
                                            	Ext.getCmp("braktrailerdisqualification").setValue("无");
                                            	Ext.getCmp("braktrailerdisqualification").disable();
                                            	Ext.getCmp("lighthostdisqualification").setValue("无");
                                            	Ext.getCmp("lighthostdisqualification").disable();
                                            	Ext.getCmp("lighttrailerdisqualification").setValue("无");
                                            	Ext.getCmp("lighttrailerdisqualification").disable();
                                            	Ext.getCmp("tractiondisqualification").setValue("无");
                                            	Ext.getCmp("tractiondisqualification").disable();
                                            	Ext.getCmp("showexaminationresult").setValue("无");
                                            	Ext.getCmp("showexaminationresult").disable();
                                            	Ext.getCmp("engineexaminationresult").setValue("无");
                                            	Ext.getCmp("engineexaminationresult").disable();
                                            	Ext.getCmp("conveyorexaminationresult").setValue("无");
                                            	Ext.getCmp("conveyorexaminationresult").disable();
                                            	Ext.getCmp("steeringexaminationresult").setValue("无");
                                            	Ext.getCmp("steeringexaminationresult").disable();
                                            	Ext.getCmp("flyhostexaminationresult").setValue("无");
                                            	Ext.getCmp("flyhostexaminationresult").disable();
                                            	Ext.getCmp("flytrailerexaminationresult").setValue("无");
                                            	Ext.getCmp("flytrailerexaminationresult").disable();
                                            	Ext.getCmp("brakhostexaminationresult").setValue("无");
                                            	Ext.getCmp("brakhostexaminationresult").disable();
                                            	Ext.getCmp("braktrailerexaminationresult").setValue("无");
                                            	Ext.getCmp("braktrailerexaminationresult").disable();
                                            	Ext.getCmp("lighthostexaminationresult").setValue("无");
                                            	Ext.getCmp("lighthostexaminationresult").disable();
                                            	Ext.getCmp("lighttrailerexaminationresult").setValue("无");
                                            	Ext.getCmp("lighttrailerexaminationresult").disable();
                                            	Ext.getCmp("tractionexaminationresult").setValue("无");
                                            	Ext.getCmp("tractionexaminationresult").disable(); 
                                            	
                                            	Ext.getCmp("showinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("showinitialinspectionresult").disable();
                                            	Ext.getCmp("engineinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("engineinitialinspectionresult").disable();
                                            	Ext.getCmp("conveyorinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("conveyorinitialinspectionresult").disable();
                                            	Ext.getCmp("steeringinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("steeringinitialinspectionresult").disable();
                                            	Ext.getCmp("flyhostinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("flyhostinitialinspectionresult").disable();
                                            	Ext.getCmp("flytrailerinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("flytrailerinitialinspectionresult").disable();
                                            	Ext.getCmp("brakhostinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("brakhostinitialinspectionresult").disable();
                                            	Ext.getCmp("braktrailerinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("braktrailerinitialinspectionresult").disable();
                                            	Ext.getCmp("lighthostinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("lighthostinitialinspectionresult").disable();
                                            	Ext.getCmp("lighttrailerinitialinspectionresult").setValue("无");
                                            	Ext.getCmp("lighttrailerinitialinspectionresult").disable();
                                            	Ext.getCmp("tractioninitialinspectionresult").setValue("无");
                                            	Ext.getCmp("tractioninitialinspectionresult").disable();
                                            	
                                            	
                                            	
                                            } else {
                                            	Ext.getCmp("showdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("showdisqualification").enable();
                                            	Ext.getCmp("disqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("disqualification").enable();
                                            	Ext.getCmp("enginedisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("enginedisqualification").enable();
                                            	Ext.getCmp("conveyordisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("conveyordisqualification").enable();
                                            	Ext.getCmp("steeringdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("steeringdisqualification").enable();
                                            	Ext.getCmp("flyhostdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("flyhostdisqualification").enable();
                                            	Ext.getCmp("flytrailerdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("flytrailerdisqualification").enable();
                                            	Ext.getCmp("brakhostdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("brakhostdisqualification").enable();
                                            	Ext.getCmp("braktrailerdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("braktrailerdisqualification").enable();
                                            	Ext.getCmp("lighthostdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("lighthostdisqualification").enable();
                                            	Ext.getCmp("lighttrailerdisqualification").setValue("请填写不合格原因");
                                            	Ext.getCmp("lighttrailerdisqualification").enable();
                                            	Ext.getCmp("tractiondisqualification").setValue("请填写不合格原因");                                            	
                                            	Ext.getCmp("tractiondisqualification").enable();
                                            	Ext.getCmp("showexaminationresult").setValue("请选择");
                                            	Ext.getCmp("showexaminationresult").enable();
                                            	Ext.getCmp("engineexaminationresult").setValue("请选择");
                                            	Ext.getCmp("engineexaminationresult").enable();
                                            	Ext.getCmp("conveyorexaminationresult").setValue("请选择");
                                            	Ext.getCmp("conveyorexaminationresult").enable();
                                            	Ext.getCmp("steeringexaminationresult").setValue("请选择");
                                            	Ext.getCmp("steeringexaminationresult").enable();
                                            	Ext.getCmp("flyhostexaminationresult").setValue("请选择");
                                            	Ext.getCmp("flyhostexaminationresult").enable();
                                            	Ext.getCmp("flytrailerexaminationresult").setValue("请选择");
                                            	Ext.getCmp("flytrailerexaminationresult").enable();
                                            	Ext.getCmp("brakhostexaminationresult").setValue("请选择");
                                            	Ext.getCmp("brakhostexaminationresult").enable();
                                            	Ext.getCmp("braktrailerexaminationresult").setValue("请选择");
                                            	Ext.getCmp("braktrailerexaminationresult").enable();
                                            	Ext.getCmp("lighthostexaminationresult").setValue("请选择");
                                            	Ext.getCmp("lighthostexaminationresult").enable();
                                            	Ext.getCmp("lighttrailerexaminationresult").setValue("请选择");
                                            	Ext.getCmp("lighttrailerexaminationresult").enable();
                                            	Ext.getCmp("tractionexaminationresult").setValue("请选择");  
                                            	Ext.getCmp("tractionexaminationresult").enable();   
                                            	
                                            	Ext.getCmp("showinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("showinitialinspectionresult").enable(); 
                                            	Ext.getCmp("engineinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("engineinitialinspectionresult").enable();
                                            	Ext.getCmp("conveyorinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("conveyorinitialinspectionresult").enable();
                                            	Ext.getCmp("steeringinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("steeringinitialinspectionresult").enable();
                                            	Ext.getCmp("flyhostinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("flyhostinitialinspectionresult").enable();
                                            	Ext.getCmp("flytrailerinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("flytrailerinitialinspectionresult").enable();
                                            	Ext.getCmp("brakhostinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("brakhostinitialinspectionresult").enable();
                                            	Ext.getCmp("braktrailerinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("braktrailerinitialinspectionresult").enable();
                                            	Ext.getCmp("lighthostinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("lighthostinitialinspectionresult").enable();
                                            	Ext.getCmp("lighttrailerinitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("lighttrailerinitialinspectionresult").enable();
                                            	Ext.getCmp("tractioninitialinspectionresult").setValue("选择结果");
                                            	Ext.getCmp("tractioninitialinspectionresult").enable();
                                            }
                                        }
                                    }
                            	}]
                            },
                            {
                            	columnWidth:.33,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                id: "checkexpirydate",
                                fieldLabel: "检验有效期",
                                value: effectivedate,
                                xtype: "datefield",
                                readOnly: true,
                                format: "Y-m-d",
                                anchor: '98%'
                            	}]
                            },      
                            {
                            	columnWidth:.33,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                id: "inspector",
                                fieldLabel: "检验人",
                                xtype: "textfield",
                                anchor: '100%'
                            	}]
                            },   
                            {
                            	columnWidth:.33,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                id: "checkdate",
                                fieldLabel: "检验时间",
                                value: new Date(),
                                xtype: "datefield",
                                format: "Y-m-d",
                                readOnly: true,
                                anchor: '98%'
                            	}]
                            },
                            {
                            	columnWidth:.67,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                id: "disqualification",
                                fieldLabel: "不合格原因",
                                value:"无",
                                disabled: true,
                                xtype: "textfield",
                                anchor: '100%'
                            	}]
                            }
                            ]
                    	}]
                    },                               
                    {
                    	columnWidth:1,
                    	layout:"form",
                    	items:[{
                    		id:"safeinspect",
                            title:"安全技术检验",
                            xtype:"fieldset",
                            height:'auto',
                            collapsible:false,
                            layout:"column",
                            items:[{
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'showinitialinspectionresult',
                                	fieldLabel:"外观初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	value:"无",
                                    disabled: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("showdisqualification").setValue("无");
                            					Ext.getCmp("showdisqualification").disable();
                            					Ext.getCmp("showexaminationresult").setValue("无");
                            					Ext.getCmp("showexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("showdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("showdisqualification").enable();
                            					Ext.getCmp("showexaminationresult").setValue("请选择");
                            					Ext.getCmp("showexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'showdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                            		id: "showexaminationresult",
                            		fieldLabel: "复检结果",
                            		xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		editable: false,
                            		value:"无",
                                    disabled: true,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'engineinitialinspectionresult',
                                	fieldLabel:"发动机初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	value:"无",
                                    disabled: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("enginedisqualification").setValue("无");
                            					Ext.getCmp("enginedisqualification").disable();
                            					Ext.getCmp("engineexaminationresult").setValue("无");
                            					Ext.getCmp("engineexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("enginedisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("enginedisqualification").enable();
                            					Ext.getCmp("engineexaminationresult").setValue("请选择");
                            					Ext.getCmp("engineexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'enginedisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:"无",
                                    disabled: true,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'engineexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		editable: false,
                            		selectOnFoucs: true,
                            		value:"无",
                                    disabled: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'conveyorinitialinspectionresult',
                                	fieldLabel:"传动机初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	mode: 'local',
                                	value:"无",
                                    disabled: true,
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("conveyordisqualification").setValue("无");
                            					Ext.getCmp("conveyordisqualification").disable();
                            					Ext.getCmp("conveyorexaminationresult").setValue("无");
                            					Ext.getCmp("conveyorexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("conveyordisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("conveyordisqualification").enable();
                            					Ext.getCmp("conveyorexaminationresult").setValue("请选择");
                            					Ext.getCmp("conveyorexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'conveyordisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'conveyorexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		value:"无",
                                    disabled: true,
                            		mode: 'local',
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'steeringinitialinspectionresult',
                                	fieldLabel:"转向系初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	mode: 'local',
                                	value:"无",
                                    disabled: true,
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("steeringdisqualification").setValue("无");
                            					Ext.getCmp("steeringdisqualification").disable();
                            					Ext.getCmp("steeringexaminationresult").setValue("无");
                            					Ext.getCmp("steeringexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("steeringdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("steeringdisqualification").enable();
                            					Ext.getCmp("steeringexaminationresult").setValue("请选择");
                            					Ext.getCmp("steeringexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'steeringdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'steeringexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		value:"无",
                                    disabled: true,
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'flyhostinitialinspectionresult',
                                	fieldLabel:"机架及行走系主机初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	value:"无",
                                    disabled: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("flyhostdisqualification").setValue("无");
                            					Ext.getCmp("flyhostdisqualification").disable();
                            					Ext.getCmp("flyhostexaminationresult").setValue("无");
                            					Ext.getCmp("flyhostexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("flyhostdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("flyhostdisqualification").enable();
                            					Ext.getCmp("flyhostexaminationresult").setValue("请选择");
                            					Ext.getCmp("flyhostexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'flyhostdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'flyhostexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		value:"无",
                                    disabled: true,
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'flytrailerinitialinspectionresult',
                                	fieldLabel:"驾机及行走系挂车初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	value:"无",
                                    disabled: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("flytrailerdisqualification").setValue("无");
                            					Ext.getCmp("flytrailerdisqualification").disable();
                            					Ext.getCmp("flytrailerexaminationresult").setValue("无");
                            					Ext.getCmp("flytrailerexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("flytrailerdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("flytrailerdisqualification").enable();
                            					Ext.getCmp("flytrailerexaminationresult").setValue("请选择");
                            					Ext.getCmp("flytrailerexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'flytrailerdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                            	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'flytrailerexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		editable: false,
                            		value:"无",
                                    disabled: true,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'brakhostinitialinspectionresult',
                                	fieldLabel:"制动系主机初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	value:"无",
                                    disabled: true,
                                	typeAhead: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("brakhostdisqualification").setValue("无");
                            					Ext.getCmp("brakhostdisqualification").disable();
                            					Ext.getCmp("brakhostexaminationresult").setValue("无");
                            					Ext.getCmp("brakhostexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("brakhostdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("brakhostdisqualification").enable();
                            					Ext.getCmp("brakhostexaminationresult").setValue("请选择");
                            					Ext.getCmp("brakhostexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'brakhostdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                    xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'brakhostexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		value:"无",
                                    disabled: true,
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'braktrailerinitialinspectionresult',
                                	fieldLabel:"制动系挂车初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	mode: 'local',
                                	editable: false,
                                	value:"无",
                                    disabled: true,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("braktrailerdisqualification").setValue("无");
                            					Ext.getCmp("braktrailerdisqualification").disable();
                            					Ext.getCmp("braktrailerexaminationresult").setValue("无");
                            					Ext.getCmp("braktrailerexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("braktrailerdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("braktrailerdisqualification").enable();
                            					Ext.getCmp("braktrailerexaminationresult").setValue("请选择");
                            					Ext.getCmp("braktrailerexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'braktrailerdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'braktrailerexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		editable: false,
                            		value:"无",
                                    disabled: true,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'lighthostinitialinspectionresult',
                                	fieldLabel:"灯光及信号装置主机初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	value:"无",
                                    disabled: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("lighthostdisqualification").setValue("无");
                            					Ext.getCmp("lighthostdisqualification").disable();
                            					Ext.getCmp("lighthostexaminationresult").setValue("无");
                            					Ext.getCmp("lighthostexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("lighthostdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("lighthostdisqualification").enable();
                            					Ext.getCmp("lighthostexaminationresult").setValue("请选择");
                            					Ext.getCmp("lighthostexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'lighthostdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'lighthostexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		value:"无",
                                    disabled: true,
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'lighttrailerinitialinspectionresult',
                                	fieldLabel:"灯光及信号装置挂车初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	value:"无",
                                    disabled: true,
                                	mode: 'local',
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("lighttrailerdisqualification").setValue("无");
                            					Ext.getCmp("lighttrailerdisqualification").disable();
                            					Ext.getCmp("lighttrailerexaminationresult").setValue("无");
                            					Ext.getCmp("lighttrailerexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("lighttrailerdisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("lighttrailerdisqualification").enable();
                            					Ext.getCmp("lighttrailerexaminationresult").setValue("请选择");
                            					Ext.getCmp("lighttrailerexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'lighttrailerdisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'lighttrailerexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		value:"无",
                                    disabled: true,
                            		editable: false,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	items:[{
                                	id:'tractioninitialinspectionresult',
                                	fieldLabel:"液压悬挂及牵引装置初检结果",
                                	value:"选择结果",                            		
                                	xtype: "combo",
                                	displayField: 'display',
                                	valueField: 'value',
                                	typeAhead: true,
                                	mode: 'local',
                                	value:"无",
                                    disabled: true,
                                	editable: false,
                                	selectOnFoucs: true,
                                	triggerAction: 'all',
                                	store: Ynzc.manage.CheckVerdictStore,
                                	anchor: '98%',
                                	listeners: {
                                        'select': function(combo, record, index) {
                            				if (record.data.value == "合格") {
                            					Ext.getCmp("tractiondisqualification").setValue("无");
                            					Ext.getCmp("tractiondisqualification").disable();
                            					Ext.getCmp("tractionexaminationresult").setValue("无");
                            					Ext.getCmp("tractionexaminationresult").disable();
                            				}else{
                            					Ext.getCmp("tractiondisqualification").setValue("请填写不合格原因");
                            					Ext.getCmp("tractiondisqualification").enable();
                            					Ext.getCmp("tractionexaminationresult").setValue("请选择");
                            					Ext.getCmp("tractionexaminationresult").enable();
                            				}
                            			}
                            		}
                            	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:85,
                            	items:[{
                                	id:'tractiondisqualification',
                                	fieldLabel:"不合格原因",
                                	value:"无",
                                    disabled: true,
                                	xtype:"textfield",
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	items:[{
                                	id:'tractionexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype: "combo",
                            		displayField: 'display',
                            		valueField: 'value',
                            		typeAhead: true,
                            		mode: 'local',
                            		editable: false,
                            		value:"无",
                                    disabled: true,
                            		selectOnFoucs: true,
                            		triggerAction: 'all',
                            		store: Ynzc.manage.CheckVerdictStore,
                            		anchor: '100%'
                                	}]
                            }
                            ]
                    	}]
                    }]
                },
                {
                    title: '经办情况',
                    frame: true,
                    bodyStyle: "padding:5px 5px",
                    autoScroll: true,
                    height: 500,
                    layout: "form",
                    labelWidth: 100,
                    items: [{
                        id: "reviewer",
                        fieldLabel: "登记审核人",
                        xtype: "textfield",
                        anchor: '100%'
                    },
                    {
                        id: "reviewerconductdate",
                        fieldLabel: "经办时间",
                        xtype: "datefield",
                        value: new Date(),
                        readOnly: true,
                        format: "Y-m-d",
                        anchor: '100%'
                    },
                    {
                        id: "issueadmin",
                        fieldLabel: "牌证管理员",
                        xtype: "textfield",
                        anchor: '100%'
                    },
                    {
                        id: "issueadmindate",
                        fieldLabel: "经办时间",
                        xtype: "datefield",
                        value: new Date(),
                        readOnly: true,
                        format: "Y-m-d",
                        anchor: '100%'
                    },
                    {
                        id: "leaderreview",
                        fieldLabel: "业务领导审核人",
                        xtype: "textfield",
                        anchor: '100%'
                    },
                    {
                        id: "leaderreviewconductdate",
                        fieldLabel: "经办时间",
                        value: new Date(),
                        xtype: "datefield",
                        readOnly: true,
                        format: "Y-m-d",
                        anchor: '100%'
                    }]
                }],
                listeners: {
                    "tabchange": function(tab, panel) {
                        panel.doLayout();
                    }
                }
            }],
            buttons: [{
                text: "提交注册",
                handler: function() {
                    if (Ext.getCmp("owner").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>姓名/名称</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("realcertificatetype").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>有效证件类型</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("realcertificateno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>有效证件编号</font>]为空，请填写。");
                        return;
                    }
                    if(Ext.getCmp("realcertificatetype").getValue() == "8")
                    {
                    	if(Ext.getCmp("realcertificateno").getValue() != "")
                    	{
                    		if(checkIdCard(Ext.getCmp("realcertificateno").getValue()) != true){
    							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("realcertificateno").getValue()));
    							return;
    						}
                    	}
                    }
                    if (Ext.getCmp("address").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>家庭联系地址</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("tempaddress").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>现居住地址</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("istemplived").getValue() === "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>是否暂住</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("templivefiletype").getValue() === "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>暂住证明类别</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("timplivefileno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>暂住证明号码</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("isunion").getValue() === "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>单位/个人</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("zipcode").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>邮政编码</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("telephone").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>联系电话</font>]为空，请填写。");
                        return
                    }
                    //所有人信息 JSONObject
                    var ownerstr = "{owner:'" + Ext.getCmp("owner").getValue() + "',realcertificatetype:" + Ext.getCmp("realcertificatetype").getValue() + ",realcertificateno:'" + Ext.getCmp("realcertificateno").getValue() + "',address:'" + Ext.getCmp("address").getValue() + "',tempaddress:'" + Ext.getCmp("tempaddress").getValue() + "',istemplived:" + Ext.getCmp("istemplived").getValue() + ",templivefiletype:" + Ext.getCmp("templivefiletype").getValue() + ",timplivefileno:'" + Ext.getCmp("timplivefileno").getValue() + "',isunion:" + Ext.getCmp("isunion").getValue() + ",zipCode:'" + Ext.getCmp("zipcode").getValue() + "',telephone:'" + Ext.getCmp("telephone").getValue() + "'}";
                    var ownerjson = Ext.util.JSON.encode(ownerstr);

                    if (Ext.getCmp("getwayid").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>获取方式</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("machinetypeid").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>机械类型</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("machinebrandtypeid").getMyValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>品牌型号</font>]未选择，请选择。。");
                        return;
                    }
                    if (Ext.getCmp("machinebodyno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>机身（底盘）号码</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("engineno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>发动机号码</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("shelfno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>挂机架号码</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("usedfor").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>使用性质</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("manufacturer").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>制造厂名称</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("seller").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>销售（交易市场）名称</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("manufacturedate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>出厂日期</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("price").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>销售（交易）价格</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("photourl").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>拖拉机基本信息</font>][<font color=red>拖拉机图片</font>]请上传拖拉机图片");
                        return;
                    }
                    //拖拉机基本信息 JSONObject
                    var tractorstr = "{getwayid:" + Ext.getCmp("getwayid").getValue() + ",machinetypeid:" + Ext.getCmp("machinetypeid").getValue() + ",machinebrandtypeid:" + Ext.getCmp("machinebrandtypeid").getMyValue() + ",machinebodyno:'" + Ext.getCmp("machinebodyno").getValue() + "',engineno:'" + Ext.getCmp("engineno").getValue() + "',shelfno:'" + Ext.getCmp("shelfno").getValue() + "',usedfor:'" + Ext.getCmp("usedfor").getValue() + "',manufacturer:'" + Ext.getCmp("manufacturer").getValue() + "',seller:'" + Ext.getCmp("seller").getValue() + "',manufacturedate:'" + Ext.util.Format.date(Ext.getCmp("manufacturedate").getValue(), 'Y-m-d') + "',price:'" + Ext.getCmp("price").getValue() + "',photourl:'" + Ext.getCmp("photourl").getValue() + "'}";
                    var tractorjson = Ext.util.JSON.encode(tractorstr);

                    if (Ext.getCmp("getwayfiletypeid").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>相关资料</font>][<font color=red>来历凭证类型</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("getwayfileno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>相关资料</font>][<font color=red>来历凭证编号</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("insurancelistno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>相关资料</font>][<font color=red>保单号</font>]为空，请填写。");
                        return;
                    }
                    if (Ext.getCmp("insurancecompanyname").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>相关资料</font>][<font color=red>保险公司</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("insurancedate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>相关资料</font>][<font color=red>保险日期</font>]未选择，请选择。");
                        return;
                    }
                    if (Ext.getCmp("expirydate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>相关资料</font>][<font color=red>保险有效期</font>]未选择，请选择。");
                        return;
                    }
                    //相关资料
                    var otherstr = "";
                    if (Ext.getCmp("otherOne").getValue() == true) {
                        otherstr = otherstr + "国产拖拉机整车出厂合格证明,";
                    };
                    if (Ext.getCmp("otherTwo").getValue() == true) {
                        otherstr = otherstr + "拖拉机档案,";
                    };
                    if (Ext.getCmp("otherThree").getValue() == true) {
                        otherstr = otherstr + "身份证明,";
                    };
                    if (Ext.getCmp("otherFour").getValue() == true) {
                        otherstr = otherstr + "《协助执行通知书》,";
                    };
                    if (Ext.getCmp("otherFive").getValue() == true) {
                        otherstr = otherstr + "《公证书》,";
                    };

                    //alert(Ext.getCmp("importsfiletypeid").getValue());
                    if (Ext.getCmp("importsfiletypeid").getValue() === "") {
                        Ext.getCmp("importsfiletypeid").setValue(0);
                    }
                    if (Ext.getCmp("importsfileno").getValue() === "") {
                        Ext.getCmp("importsfileno").setValue("无");
                    }
                    var aboutstr = "{getwayfiletypeid:" + Ext.getCmp("getwayfiletypeid").getValue() + ",getwayfileno:'" + Ext.getCmp("getwayfileno").getValue() + "',importsfiletypeid:" + Ext.getCmp("importsfiletypeid").getValue() + ",importsfileno:'" + Ext.getCmp("importsfileno").getValue() + "',insurancelistno:'" + Ext.getCmp("insurancelistno").getValue() + "',insurancecompanyname:'" + Ext.getCmp("insurancecompanyname").getValue() + "',insurancedate:'" + Ext.util.Format.date(Ext.getCmp("insurancedate").getValue(), 'Y-m-d') + "',expirydate:'" + Ext.util.Format.date(Ext.getCmp("expirydate").getValue(), 'Y-m-d') + "',other:'" + otherstr + "'}";
                    var aboutjson = Ext.util.JSON.encode(aboutstr);

                    if( Ext.getCmp("license").getValue()=="无号牌"){
                    	Ext.MessageBox.alert("提示","[<font color=red>注册信息</font>][<font color=red>无号牌分配不能信息注册</font>]");
                    	return
                    }
                    if (Ext.getCmp("registerdate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>注册信息</font>][<font color=red>注册/转入日期</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("issuedate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>注册信息</font>][<font color=red>发牌证日期</font>]未选择，请选择。");
                        return
                    }
//                    if (Ext.getCmp("beforeregion").getValue() === "") {
//                        Ext.MessageBox.alert("提示", "[<font color=red>注册信息</font>][<font color=red>转入前管辖地</font>]未选择，请选择。");
//                        return
//                    }
                    if(Ext.getCmp("regionvalue").getValue() === ""){
                    	Ext.MessageBox.alert("提示","[<font color=red>注册信息</font>][<font color=red>现管辖地</font>]未选择，请选择。");
                    	return
                    }
                    if(Ext.getCmp("regionvalue").getValue()=="请选择现管辖地" || Ext.getCmp("regionvalue").getValue()==="请选择现管辖地"){
                    	Ext.MessageBox.alert("提示","[<font color=red>注册信息</font>][<font color=red>现管辖地</font>]未选择，请选择。");
                    	return
                    }
//                    var turnindatevar=null;
//                    if(Ext.getCmp("turnindate").getValue() == ""){
//                    	issuedatevar=Ext.util.Format.date(Ext.getCmp("turnindate").getValue(), 'Y-m-d');
//                    }
                    //注册信息
                    var regstr = "{registerdate:'" + Ext.util.Format.date(Ext.getCmp("registerdate").getValue(), 'Y-m-d') + "',turnindate:'"+DateFormat.format(new Date(),'yyyy-MM-dd')+"',issuedate:'" + Ext.util.Format.date(Ext.getCmp("issuedate").getValue(), 'Y-m-d') + "',beforeregion:''}";
                    var regjson = Ext.util.JSON.encode(regstr);

                    if (Ext.getCmp("machinebodycolor").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>机身颜色</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("directcontrol").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>转向形式</font>]未选择，请选择。");
                        return
                    }                    
                    if (Ext.getCmp("enginebrandid").getMyValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>发动机品牌</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("fueltypeid").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>燃料种类</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("tiresno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>轮胎数</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("totalquality").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>总质量</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("allowdragtotalquality").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>准牵引总质量</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("vicecartiresno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>挂车轮胎数</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("outsize").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>外轮廓尺寸</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("containersize").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>货箱内尺寸</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("power").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>功率</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("cylinderno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>缸数</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("wheelno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>轴数</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("tiressize").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>轮胎规格</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("allquality").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>整备质量</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("driverinno").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>驾驶室人数</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("outcarwheeldis").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>挂车轮距</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("wheelbase").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>轴距</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("wheeldis").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>轮距</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("ratifiedload").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>核定载质量</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("steelspring").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>钢板弹簧片数</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("outcartiressize").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术参数</font>][<font color=red>挂车轮胎规格</font>]为空，请填写。");
                        return
                    }
                    //技术参数
                    var tecstr = "{machinebodycolor:'" + Ext.getCmp("machinebodycolor").getValue() + "',directcontrol:'" + Ext.getCmp("directcontrol").getValue() + "',enginebrandid:" + Ext.getCmp("enginebrandid").getMyValue() + ",fueltypeid:" + Ext.getCmp("fueltypeid").getValue() + ",tiresno:'" + Ext.getCmp("tiresno").getValue() + "',totalquality:'" + Ext.getCmp("totalquality").getValue() + "',allowdragtotalquality:'" + Ext.getCmp("allowdragtotalquality").getValue() + "',vicecartiresno:'" + Ext.getCmp("vicecartiresno").getValue() + "',outsize:'" + Ext.getCmp("outsize").getValue() + "',containersize:'" + Ext.getCmp("containersize").getValue() + "',power:'" + Ext.getCmp("power").getValue() + "',cylinderno:'" + Ext.getCmp("cylinderno").getValue() + "',wheelno:'" + Ext.getCmp("wheelno").getValue() + "',tiressize:'" + Ext.getCmp("tiressize").getValue() + "',allquality:'" + Ext.getCmp("allquality").getValue() + "',driverinno:'" + Ext.getCmp("driverinno").getValue() + "',outcarwheeldis:'" + Ext.getCmp("outcarwheeldis").getValue() + "',wheelbase:'" + Ext.getCmp("wheelbase").getValue() + "',wheeldis:'" + Ext.getCmp("wheeldis").getValue() + "',ratifiedload:'" + Ext.getCmp("ratifiedload").getValue() + "',steelspring:'" + Ext.getCmp("steelspring").getValue() + "',outcartiressize:'" + Ext.getCmp("outcartiressize").getValue() + "'}";
                    var tecjson = Ext.util.JSON.encode(tecstr);

                    if (Ext.getCmp("checkresult").getValue() == "" || Ext.getCmp("checkresult").getValue()=="请选择检验结论") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>检验结论</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("checkexpirydate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>检验有效期</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("inspector").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>检验人</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("checkdate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>检验时间</font>]未选择，请选择。");
                        return
                    }
                    if(Ext.getCmp("checkresult").getValue()=="不合格"){
                    	if (Ext.getCmp("disqualification").getValue() == "") {
                    		Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>检验不合格原因</font>]未选择，请选择。");
                    		return
                    	}
                    	if(Ext.getCmp("showdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>外观初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("showexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>外观初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("enginedisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>发动机初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("engineexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>发动机初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("conveyordisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>传动机初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("conveyorexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>传动机初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("steeringdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>转向系初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("steeringexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>转向系初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("flyhostdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>机架及行走系主机初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("flyhostexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>机架及行走系主机初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("flytrailerdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>机架及行走系挂车初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("flytrailerexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>机架及行走系挂车初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("brakhostdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>制动系主机初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("brakhostexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>制动系主机初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("braktrailerdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>制动系挂车初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("braktrailerexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>制动系挂车初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("lighthostdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>灯光及信号装置主机初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("lighthostexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>灯光及信号装置主机初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("lighttrailerdisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>灯光及信号装置挂车初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("lighttrailerexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>灯光及信号装置挂车初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    	if(Ext.getCmp("tractiondisqualification").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>液压悬挂及牵引装置初检结果-不合格原因未填写</font>]");
                    	}
                    	if(Ext.getCmp("tractionexaminationresult").getValue()==""){
                    		Ext.MessageBox.alert("提示","[<font color=red>技术检验</font>][<font color=red>液压悬挂及牵引装置初检结果-复检结果</font>]未选择，请选择。");
                    	}
                    }
                    if (Ext.getCmp("showinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>外观初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("engineinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>发动机初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("conveyorinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>传动机初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("steeringinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>转向系初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("flyhostinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>机架及行走系主机初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("flytrailerinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>机架及行走系挂车初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("brakhostinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>制动系主机初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("braktrailerinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>制动系挂车初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("lighthostinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>灯光及信号装置主机初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("lighttrailerinitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>灯光及信号装置挂车初检结果</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("tractioninitialinspectionresult").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>液压悬挂及牵引装置初检结果</font>]未选择，请选择。");
                        return
                    }
                    //技术检验
                    var checkstr = "{checkresult:'" + Ext.getCmp("checkresult").getValue() + "',disqualification:'"+Ext.getCmp("disqualification").getValue()+"',checkexpirydate:'" + Ext.util.Format.date(Ext.getCmp("checkexpirydate").getValue(), 'Y-m-d') + "',inspector:'" + Ext.getCmp("inspector").getValue() + "',checkdate:'" + Ext.util.Format.date(Ext.getCmp("checkdate").getValue(), 'Y-m-d') + "',showinitialinspectionresult:'"+Ext.getCmp("showinitialinspectionresult").getValue()+"',showdisqualification:'"+Ext.getCmp("showdisqualification").getValue()+"',showexaminationresult:'"+Ext.getCmp("showexaminationresult").getValue()+"',engineinitialinspectionresult:'"+Ext.getCmp("engineinitialinspectionresult").getValue()+"',enginedisqualification:'"+Ext.getCmp("enginedisqualification").getValue()+"',engineexaminationresult:'"+Ext.getCmp("conveyorinitialinspectionresult").getValue()+"',conveyorinitialinspectionresult:'"+Ext.getCmp("conveyorinitialinspectionresult").getValue()+"',conveyordisqualification:'"+Ext.getCmp("conveyordisqualification").getValue()+"',conveyorexaminationresult:'"+Ext.getCmp("conveyorexaminationresult").getValue()+"',steeringinitialinspectionresult:'"+Ext.getCmp("steeringinitialinspectionresult").getValue()+"',steeringdisqualification:'"+Ext.getCmp("steeringdisqualification").getValue()+"',steeringexaminationresult:'',flyhostinitialinspectionresult:'"+Ext.getCmp("flyhostinitialinspectionresult").getValue()+"',flyhostdisqualification:'"+Ext.getCmp("flyhostdisqualification").getValue()+"',flyhostexaminationresult:'"+Ext.getCmp("flyhostexaminationresult").getValue()+"',flytrailerinitialinspectionresult:'"+Ext.getCmp("flytrailerinitialinspectionresult").getValue()+"',flytrailerdisqualification:'"+Ext.getCmp("flytrailerdisqualification").getValue()+"',flytrailerexaminationresult:'"+Ext.getCmp("flytrailerexaminationresult").getValue()+"',brakhostinitialinspectionresult:'"+Ext.getCmp("brakhostinitialinspectionresult").getValue()+"',brakhostdisqualification:'"+Ext.getCmp("brakhostdisqualification").getValue()+"',brakhostexaminationresult:'"+Ext.getCmp("brakhostexaminationresult").getValue()+"',braktrailerinitialinspectionresult:'"+Ext.getCmp("braktrailerinitialinspectionresult").getValue()+"',braktrailerdisqualification:'"+Ext.getCmp("braktrailerdisqualification").getValue()+"',braktrailerexaminationresult:'"+Ext.getCmp("braktrailerexaminationresult").getValue()+"',lighthostinitialinspectionresult:'"+Ext.getCmp("lighthostinitialinspectionresult").getValue()+"',lighthostdisqualification:'"+Ext.getCmp("lighthostdisqualification").getValue()+"',lighthostexaminationresult:'"+Ext.getCmp("lighthostexaminationresult").getValue()+"',lighttrailerinitialinspectionresult:'"+Ext.getCmp("lighttrailerinitialinspectionresult").getValue()+"',lighttrailerdisqualification:'"+Ext.getCmp("lighttrailerdisqualification").getValue()+"',lighttrailerexaminationresult:'"+Ext.getCmp("lighttrailerexaminationresult").getValue()+"',tractioninitialinspectionresult:'"+Ext.getCmp("tractioninitialinspectionresult").getValue()+"',tractiondisqualification:'"+Ext.getCmp("tractiondisqualification").getValue()+"',tractionexaminationresult:'"+Ext.getCmp("tractionexaminationresult").getValue()+"'}";
                    var checkjson = Ext.util.JSON.encode(checkstr);

                    if (Ext.getCmp("reviewer").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>登记审核人</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("reviewerconductdate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>经办时间</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("issueadmin").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>牌证管理员</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("leaderreview").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>业务领导审核人</font>]为空，请填写。");
                        return
                    }
                    if (Ext.getCmp("leaderreviewconductdate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>经办时间</font>]未选择，请选择。");
                        return
                    }
                    if (Ext.getCmp("issueadmindate").getValue() == "") {
                        Ext.MessageBox.alert("提示", "[<font color=red>所有人信息</font>][<font color=red>经办时间</font>]未选择，请选择。");
                        return
                    }
                    //经办情况
                    var handstr = "{reviewer:'" + Ext.getCmp("reviewer").getValue() + "',reviewerconductdate:'" + Ext.util.Format.date(Ext.getCmp("reviewerconductdate").getValue(), 'Y-m-d') + "',issueadmin:'" + Ext.getCmp("issueadmin").getValue() + "',leaderreview:'" + Ext.getCmp("leaderreview").getValue() + "',leaderreviewconductdate:'" + Ext.util.Format.date(Ext.getCmp("leaderreviewconductdate").getValue(), 'Y-m-d') + "',issueadmindate:'" + Ext.util.Format.date(Ext.getCmp("issueadmindate").getValue(), 'Y-m-d') + "'}";
                    var handjson = Ext.util.JSON.encode(handstr);
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在處理数据,请稍等...',
			     		removeMask:true
	                });
                    Ext.Ajax.request({
                        url: "main/tractorInfo.html?action=addTractorInfo",
                        success: function(resp) {
                        var result=Ext.util.JSON.decode(resp.responseText);
                        mask.hide();
                            if(result.success==true){
                            Ext.MessageBox.alert("提示", "拖拉机注册登记成功!");
                            Ext.getCmp("traRegMgr").getStore().reload();
                            Ext.getCmp("tractorregisterwin").close();
                            }else{
                            Ext.MessageBox.alert("提示", result.errors);
                            } 
                        },
                        failure: function() {
                            Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                        },
                        params: {
                            ownerjson: ownerjson,
                            tractorjson: tractorjson,
                            aboutjson: aboutjson,
                            regjson: regjson,
                            tecjson: tecjson,
                            checkjson: checkjson,
                            handjson: handjson,
                            regionid:Ext.getCmp("regionvalue").getValue(),
                            unitid: Ext.getCmp("unitid").getValue(),
                            license: Ext.getCmp("license").getValue(),
                            regcerno: Ext.getCmp("regcerno").getValue()
                        }
                    });

                }
            },
            {
                text: "取消",
                handler: function() {
                    Ext.getCmp("tractorregisterwin").close();
                }
            }]
        });
        Ynzc.manage.TractorRegisterWin.superclass.initComponent.apply(this, arguments);
    }
});