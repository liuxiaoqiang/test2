Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.cartransferreplacementwin = Ext.extend(Ext.Window,{
	 id: "typeAddwin",
	 initComponent: function() {
		Ext.apply(this,{
			title: "补领、补换牌证",
            modal: true,
            height: 580,
            width: 700,
            layout: "form",
            labelWidth: 80,
            bodyStyle: "padding:5px 5px",
            items: [{
                baseCls: "x-plain",
                height: '50',
                collapsible: false,
                layout: "column",
                items: [{
                    columnWidth: .3,
                    labelWidth: 80,
                    baseCls: "x-plain",
                    layout: "form",
                    items: [{
                        id: "One",
                        xtype: "textfield",
                        width: 100,
                        fieldLabel: "号牌号码",
//                        value: record.data.license,
                        readOnly: true

                    }]
                },
                {
                    columnWidth: .3,
                    labelWidth: 80,
                    baseCls: "x-plain",
                    layout: "form",
                    items: [{
                        id: "Two",

                        xtype: "textfield",
                        width: 100,
                        fieldLabel: "登记证书编号",
//                        value: record.data.regcerno,
                        readOnly: true

                    }]
                },
                {
                    columnWidth: .3,
                    labelWidth: 80,
                    baseCls: "x-plain",
                    layout: "form",
                    items: [{
                        id: "Three",

                        xtype: "textfield",
                        width: 100,
                        fieldLabel: "管辖地",
//                        value: record.data.region,
                        readOnly: true

                    }]
                }]
            },
            {
                id: "transferregister",
                title: "登记事项",
                xtype: "fieldset",
                height: 530,
                collapsible: false,
                layout: "form",
                items: [{

                    id: 'registerthing',
                    title: "申请事项",
                    xtype: "fieldset",
                    height: 'auto',
                    collapsible: false,
                    layout: "column",
                    items: [{
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            id: "register",
                            name: "radiogroup",
                            boxLabel: "补领拖拉机牌",
                            checked:true,
                            xtype: "radio",
                            inputValue: "补领拖拉机牌"
                        }]
                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "radiogroup",
                            boxLabel: "补领行驶证",
                            xtype: "radio",
                            inputValue: '补领行驶证'
                        }]
                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "radiogroup",
                            boxLabel: "补领登记证书",
                            xtype: "radio",
                            inputValue: '补领登记证书'
                        }]

                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "radiogroup",
                            boxLabel: "换拖拉机号牌",
                            xtype: "radio",
                            inputValue: '换拖拉机号牌'
                        }]
                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "radiogroup",
                            boxLabel: "换行驶证",
                            xtype: "radio",
                            inputValue: '换行驶证'
                        }]
                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "radiogroup",
                            boxLabel: "换登记证书",
                            xtype: "radio",
                            inputValue: '换登记证书'
                        }]
                    }],
                    anchor: '100%'
                },
                {
                    id: "voucher",
                    title: "相关凭证",
                    xtype: "fieldset",
                    height: 'auto',
                    collapsible: false,
                    layout: "column",
                    items: [{
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            id: "voucherOne",
                            boxLabel: "未得到登记证书证明",
                            xtype: "checkbox",
                            inputValue: "未得到登记证书证明"
                        }]
                    },
                    {
                        columnWidth: .15,
                        layout: "fit",
                        labelWidth: 180,
                        baseCls: "x-plain",
                        items: [{
                            id: "voucherTne",
                            boxLabel: "《协助执行通知书》",
                            checked:true,
                            xtype: "checkbox",
                            inputValue: "《协助执行通知书》"
                        }]
                    }],
                    anchor: '100%'

                },
                {

                    id: 'reasonthing',
                    title: "补换领原因",
                    xtype: "fieldset",
                    height: 'auto',
                    collapsible: false,
                    layout: "column",
                    items: [{
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            id: "reason",
                            name: "reasongroup",
                            boxLabel: "丢失",
                            checked:true,
                            xtype: "radio",
                            inputValue: "丢失"
                        }]
                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "reasongroup",
                            boxLabel: "灭失",
                            xtype: "radio",
                            inputValue: '灭失'
                        }]
                    },
                    {
                        columnWidth: .3,
                        name: "reasongroup",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "reasongroup",
                            boxLabel: "损坏",
                            xtype: "radio",
                            inputValue: '损坏'
                        }]

                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "reasongroup",
                            boxLabel: "未得到登记证书",
                            xtype: "radio",
                            inputValue: '未得到登记证书'
                        }]
                    },
                    {
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            name: "reasongroup",
                            boxLabel: "首次申领登记证书",
                            xtype: "radio",
                            inputValue: '首次申领登记证书'
                        }]
                    }],
                    anchor: '100%'
                },
                {
                    id: "replacementthing ",
                    title: "补换领机动车号牌",
                    xtype: "fieldset",
                    height: 'auto',
                    collapsible: false,
                    layout: "column",
                    items: [{
                        columnWidth: .3,
                        layout: "fit",
                        labelWidth: 30,
                        baseCls: "x-plain",
                        items: [{
                            id: "replacement",
                            name: "replacementgroup",
                            boxLabel: "1面",
                            xtype: "radio",
                            checked:true,
                            inputValue: "1面"
                        }]
                    },
                    {
                        columnWidth: .15,
                        layout: "fit",
                        labelWidth: 180,
                        baseCls: "x-plain",
                        items: [{
                            name: "replacementgroup",
                            boxLabel: "2面",
                            xtype: "radio",
                            inputValue: '2面'
                        }]
                    }],
                    anchor: '100%'
                },
                {
                    id: "handling",
                    title: "经办情况",
                    xtype: "fieldset",
                    height: '150',
                    collapsible: false,
                    layout: "form",
                    items: [{
                        baseCls: "x-plain",
                        height: '50',
                        collapsible: false,
                        layout: "column",
                        items: [{
                            columnWidth: .3,
                            labelWidth: 80,
                            baseCls: "x-plain",
                            layout: "form",
                            items: [{
                                id: "handlingpeopleOne",
                                xtype: "textfield",
                                width: 100,
                                fieldLabel: "登记审核人"

                            }]
                        },
                        {
                            columnWidth: .3,
                            labelWidth: 80,
                            baseCls: "x-plain",
                            layout: "form",
                            items: [{
                                id: "handlingpeopleTwo",
                                xtype: "datefield",
                                width: 100,
                                format: "Y-m-d",
                                value: new Date(),
                                fieldLabel: "经办时间"
                            }]
                        }]
                    },
                    {
                    	baseCls: "x-plain",
                        height: '50',
                        collapsible: false,
                        layout: "column",
                        items: [{
                            columnWidth: .3,
                            labelWidth: 80,
                            baseCls: "x-plain",
                            layout: "form",
                            items: [{
                                id: "handlingadminOne",
                                xtype: "textfield",
                                width: 100,
                                fieldLabel: "牌证管理员"

                            }]
                        },
                        {
                            columnWidth: .3,
                            labelWidth: 80,
                            baseCls: "x-plain",
                            layout: "form",
                            items: [{
                                id: "handlingadminTwo",
                                xtype: "datefield",
                                width: 100,
                                format: "Y-m-d",
                                value: new Date(),
                                fieldLabel: "经办时间"
                            }]
                        }]
                    },
                    {
                        baseCls: "x-plain",
                        height: '50',
                        collapsible: false,
                        layout: "column",
                        items: [{
                            columnWidth: .3,
                            labelWidth: 80,
                            baseCls: "x-plain",
                            layout: "form",
                            items: [{
                                id: "handlingleadOne",
                                xtype: "textfield",
                                width: 100,
                                fieldLabel: "业务领导审核"
                            }]
                        },
                        {
                            columnWidth: .3,
                            labelWidth: 80,
                            baseCls: "x-plain",
                            layout: "form",
                            items: [{
                                id: "handlingleadTwo",
                                xtype: "datefield",
                                width: 100,
                                value: new Date(),
                                format: "Y-m-d",
                                fieldLabel: "经办时间"
                            }]

                        }]
                    }]
                }
               ],
                buttons: [{
                    text: "提交",
                    handler: function() {
                        var voucher = "";

                        var register = Ext.getCmp("register").getGroupValue();
                        var reasonvalue = Ext.getCmp("reason").getGroupValue();
                        var replacementvalue = Ext.getCmp("replacement").getGroupValue();
                        var handlingpeopleOnevalue = Ext.getCmp("handlingpeopleOne").getValue();
                        var handlingadminOnevalue = Ext.getCmp("handlingadminOne").getValue();
                        var businessleadauditorvalue = Ext.getCmp("handlingleadOne").getValue();

                       

                        if (Ext.getCmp("voucherOne").checked) {
                            voucher += Ext.getCmp("voucherOne").inputValue;
                            voucher += ",";

                        }
                        if (Ext.getCmp("voucherTne").checked) {

                            voucher += Ext.getCmp("voucherTne").inputValue;
                            voucher += ",";
                        }
                                var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
                        Ext.Ajax.request({
                            url: "main/tractorReplacementInfo.html?action=addTractorReplacementInfo",
                            method: "post",

                            success: function() {
                            mask.hide();
                                Ext.MessageBox.alert("提示", "提交成功，请等待审核.");
//                                Ext.getCmp("CarTransferReplacementGridMgr").getStore().reload();
                                Ext.getCmp("typeUpdatewin").close();
                                ds.reload();
                            },
                            failure: function() {
                                Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                            },
                            params: {
//                                flappernumber: record.data.license,
//                                certregistrationnumber: record.data.regcerno,
//                                venue: record.data.region,
                                sortsofinsurance: register,
                                relevancevoucher: voucher,
                                reason: reasonvalue,
                                flapperface: replacementvalue,
                                registrantauditor: handlingpeopleOnevalue,
                                registrantauditordate: Ext.util.Format.date(Ext.getCmp("handlingpeopleTwo").getValue(), 'Y-m-d'),
                                flapperdirector: handlingadminOnevalue,
                                flapperdirectordate: Ext.util.Format.date(Ext.getCmp("handlingadminTwo").getValue(), 'Y-m-d'),
                                businessleadauditor: businessleadauditorvalue,
                                businessleadauditordate: Ext.util.Format.date(Ext.getCmp("handlingleadTwo").getValue(), 'Y-m-d'),
//                                unitid: record.data.id
                            }

                        });
                    }
                },
                {
                    text: "取消",
                    handler: function() {
                        Ext.getCmp("typeUpdatewin").close();
                    }
                }]
            }]
		});   
		Ynzc.manage.cartransferreplacementwin.superclass.initComponent.apply(this,arguments);
	}
});
