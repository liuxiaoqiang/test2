Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.ChangeRecordGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'changerecordgrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '</table>')
        });
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '管辖区',
            sortable: true,
            dataIndex: "region"
        },
        {
            header: '号牌号码',
            sortable: true,
            dataIndex: "license",
            renderer: function(value, meta, record) {
                value = "<font color=red>" + record.data.platecode + "." + value + "</font>";
                return value;
            }
        },
        {
            header: '所有人',
            sortable: true,
            dataIndex: "owner"
        },
        {
            header: '机械类型',
            sortable: true,
            dataIndex: "tractorinfomachinetype"
        },
        {
            header: '厂牌型号',
            sortable: true,
            dataIndex: "plantType"
        },
        {
            header: '机驾号',
            sortable: true,
            dataIndex: "shelfno"
        },
        {
            header: '申请人',
            sortable: true,
            dataIndex: "opertator"
        },
        {
            header: '状态',
            sortable: true,
            dataIndex: "checkstate",
            renderer: function(value) {
                if (value == 0) {
                    return '待报';
                } else if (value == 1) {
                    return '待审';
                } else if (value == 2) {
                    return '通过审核';
                } else if (value == 3) {
                    return '<font color=red>未通过</font>';
                }
            }
        },
        {
            header: '审核人',
            sortable: true,
            dataIndex: "checkmen"
        }]);
        var reader = new Ext.data.JsonReader({
            totalProperty: "totalCount",
            root: "data",
            autoLoad: true,
            fields: [{
                name: 'id'
            },
            {
                name: 'tractorinfoId'
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
                name: 'unitid'
            },
            {
                name: 'license'
            },
            {
                name: 'checkeddate'
            },
            {
                name: 'recorder'
            },
            {
                name: 'status'
            },
            {
                name: 'regcerno'
            },
            {
                name: 'tractorinforegisterdate'
            },
            {
                name: 'ownerinfoid'
            },
            {
                name: 'owner'
            },
            {
                name: 'realcertificatetypeid'
            },
            {
                name: 'realcertificateno'
            },
            {
                name: 'tractorinfoaddress'
            },
            {
                name: 'tempaddress'
            },
            {
                name: 'istemplived'
            },
            {
                name: 'templivefiletypeid'
            },
            {
                name: 'timplivefileno'
            },
            {
                name: 'telephone'
            },
            {
                name: 'isUnion'
            },
            {
                name: 'tractorinfozipcode'
            },
            {
                name: 'technicalinspectid'
            },
            {
                name: 'tractorinfocheckresult'
            },
            {
                name: 'tractorinfocheckexpirydate'
            },
            {
                name: 'tractorinfoinspector'
            },
            {
                name: 'tractorinfocheckdate'
            },
            {
                name: 'handlingsituationid'
            },
            {
                name: 'tractorinforeviewer'
            },
            {
                name: 'tractorinforeviewerconductdate'
            },
            {
                name: 'tractorinfoissueadmin'
            },
            {
                name: 'tractorinfoleaderreview'
            },
            {
                name: 'leaderreviewconductdate'
            },
            {
                name: 'tractorinfoissueadmindate'
            },
            {
                name: 'getwayid'
            },
            {
                name: 'tractorinfomachinetypeid'
            },
            {
                name: 'machinebrandtypeid'
            },
            {
                name: 'machinebodyno'
            },
            {
                name: 'engineno'
            },
            {
                name: 'shelfno'
            },
            {
                name: 'usedfor'
            },
            {
                name: 'manufacturer'
            },
            {
                name: 'seller'
            },
            {
                name: 'manufacturedate'
            },
            {
                name: 'tractorinfoprice'
            },
            {
                name: 'tractorinfophotourl'
            },
            {
                name: 'tractorinfogetwayfiletypeid'
            },
            {
                name: 'getwayfileno'
            },
            {
                name: 'tractorinfoimportsfiletypeid'
            },
            {
                name: 'importsfileno'
            },
            {
                name: 'tractorinfoother'
            },
            {
                name: 'tractorinfoinsurancelistno'
            },
            {
                name: 'tractorinfoinsurancecompanyname'
            },
            {
                name: 'tractorinfoinsurancedate'
            },
            {
                name: 'tractorinfoexpirydate'
            },
            {
                name: 'registerdate'
            },
            {
                name: 'turnindate'
            },
            {
                name: 'issuedate'
            },
            {
                name: 'beforeregion'
            },
            {
                name: 'machinebodycolor'
            },
            {
                name: 'tractorinfodirectcontrol'
            },
            {
                name: 'tractorinfoenginebrandid'
            },
            {
                name: 'tractorinfofueltypeid'
            },
            {
                name: 'tractorinfotireson'
            },
            {
                name: 'tractorinfototalquality'
            },
            {
                name: 'tractorinfoallowdragtotalquality'
            },
            {
                name: 'tractorinfovicecartiresno'
            },
            {
                name: 'outsize'
            },
            {
                name: 'tractorinfocontainersize'
            },
            {
                name: 'tractorinfopower'
            },
            {
                name: 'tractorcylinderno'
            },
            {
                name: 'tractorinfowheelo'
            },
            {
                name: 'tractorinfotiressize'
            },
            {
                name: 'tractorinfoallquality'
            },
            {
                name: 'tractorinfodriverinno'
            },
            {
                name: 'tractorinfooutcarwheeldis'
            },
            {
                name: 'tractorinfowheelbase'
            },
            {
                name: 'tractorinfowheeldis'
            },
            {
                name: 'tractorinforatifiedload'
            },
            {
                name: 'tractorinfosteelspring'
            },
            {
                name: 'tractorinfooutcartiressize'
            },
            {
                name: 'region'
            },
            {
                name: 'regionid'
            },
            {
                name: 'useunit'
            },
            {
                name: 'responsiblemen'
            },
            {
                name: 'tractorinfolinktel'
            },
            {
                name: 'unitaddress'
            },
            {
                name: 'platecode'
            },
            {
                name: 'tractorinfomachinetype'
            },
            {
                name: 'tractorengineBrand'
            },
            {
                name: 'fuelname'
            },
            {
                name: 'realcertificatetype'
            },
            {
                name: 'tractorinfotemplivefileType'
            },
            {
                name: 'tractorinfogetway'
            },
            {
                name: 'getWayFileType'
            },
            {
                name: 'importsFileType'
            },
            {
                name: 'plantType'
            }]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/changeRecord.html?action=getAllChangeRecordListByPage',
            reader: reader,
            baseParams:{state:"0,1,2"},
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'changerecordgrid',
            plain: true,
            layout: 'fit',
            border: false,
            cm: cm,
            sm: sm,
            frame: true,
            store: ds,
            loadMask: true,
            plugins: expand,
            tbar: [{
                id: "changerecordBtn",
                text: "变更备案",
                iconCls: "icon-Add",
                handler: function() {
                    var win = new Ext.Window({
                        id: "inputCodeNumWin",
                        title: "请输入要[变更备案登记]的号牌号码",
                        modal: true,
                        height: 120,
                        width: 250,
                        resizable : false,
                        labelWidth: 80,
                        bodyStyle: "padding:5px 5px",
                        buttonAlign: "center",
                        items: [{
                            xtype: "label",
                            html: PlateNumHead + ".&nbsp;&nbsp;"
                        },
                        {
                            id: 'codenum',
                            xtype: "textfield",
                            anchor: '100%'
                        }],
                        buttons: [{
                            text: "下一步",
                            handler: function() {
                        	var licensenum = Ext.getCmp("codenum").getValue();
                                if (Ext.getCmp("codenum").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请输入要变更备案登记的号牌号码!");
                                    return
                                }
                                Ynzc.manage.codenum = Ext.getCmp("codenum").getValue();
                                Ext.Ajax.request({
                                    url: 'main/tractorInfoView.html?action=IsExits',
                                    method: "post",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            Ext.getCmp("inputCodeNumWin").close();
                                            new Ext.Window({
                                                id: "changerecordWin",
                                                title: "请填写变更备案登记事项",
                                                iconCls: 'icon-Add',
                                                resizable: false,
                                                modal: true,
                                                height: 470,
                                                width: 700,
                                                bodyStyle: "padding:5px 5px",
                                                items: [{
                                                    id: "changerecordtype",
                                                    title: "变更备案事项",
                                                    xtype: "fieldset",
                                                    height: 80,
                                                    layout: "column",
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: "otherOne",
                                                            boxLabel: "住所在农机监理机构管辖区域内迁移",
                                                            checked:true,
                                                            xtype: "checkbox",
                                                            inputValue: "住所在农机监理机构管辖区域内迁移"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: "otherSecond",
                                                            boxLabel: "变更拖拉机所有人姓名/名称",
                                                            xtype: "checkbox",
                                                            inputValue: "变更拖拉机所有人姓名/名称"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: "otherThree",
                                                            boxLabel: "变更公章样式",
                                                            xtype: "checkbox",
                                                            inputValue: "变更公章样式"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: "otherFour",
                                                            boxLabel: "变更联系方式",
                                                            xtype: "checkbox",
                                                            inputValue: "变更联系方式"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: "otherFive",
                                                            boxLabel: "变更发动机拓印膜样式",
                                                            xtype: "checkbox",
                                                            inputValue: "变更发动机拓印膜样式"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: "otherSex",
                                                            boxLabel: "变更拖拉机所有人身份证明名称/号码",
                                                            xtype: "checkbox",
                                                            inputValue: "变更拖拉机所有人身份证明名称/号码"
                                                        }]
                                                    }]
                                                },
                                                {
                                                    id: "changerecordinfo",
                                                    title: "变更后的信息",
                                                    xtype: "fieldset",
                                                    height: 160,
                                                    layout: "column",
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'changerecordname',
                                                            fieldLabel: "姓名/名称",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'linktel',
                                                            fieldLabel: "联系电话",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'certificateid',
                                                            fieldLabel: "身份证类型",
                                                            xtype: "combo",
                                                            value: 8,
                                                            anchor: '98%',
                                                            displayField: 'realcertificatetype',
                                                            valueField: 'id',
                                                            typeAhead: true,
                                                            mode: 'remote',
                                                            editable: false,
                                                            selectOnFoucs: true,
                                                            triggerAction: 'all',
                                                            store: Ynzc.manage.Certificate
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'certificatecode',
                                                            fieldLabel: "身份证号码",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'unittype',
                                                            fieldLabel: "单位/个人",
                                                            xtype: "combo",
                                                            anchor: '98%',
                                                            displayField: 'displayvalue',
                                                            valueField: 'value',
                                                            typeAhead: true,
                                                            mode: 'local',
                                                            editable: false,
                                                            selectOnFoucs: true,
                                                            triggerAction: 'all',
                                                            value: 0,
                                                            store: Ynzc.manage.UOrPStore
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'address',
                                                            fieldLabel: "住所地址",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'zipcode',
                                                            fieldLabel: "邮政编码",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'istemporary',
                                                            fieldLabel: "是否暂住",
                                                            xtype: "combo",
                                                            anchor: '98%',
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
                                                                        Ext.getCmp('temporaycertificate').setValue(null);
                                                                        Ext.getCmp('temporaycertificatecode').setValue(null);
                                                                        Ext.getCmp('temporaycertificate').setDisabled(false);
                                                                        Ext.getCmp('temporaycertificatecode').setDisabled(false);
                                                                    } else {
                                                                        Ext.getCmp('temporaycertificate').setValue(null);
                                                                        Ext.getCmp('temporaycertificatecode').setValue(null);
                                                                        Ext.getCmp('temporaycertificate').setDisabled(true);
                                                                        Ext.getCmp('temporaycertificatecode').setDisabled(true);
                                                                    }
                                                                }
                                                            }
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'temporaycertificate',
                                                            fieldLabel: "暂住证名类型",
                                                            xtype: "combo",
                                                            anchor: '98%',
                                                            displayField: 'templivefileType',
                                                            editable: false,
                                                            valueField: 'id',
                                                            typeAhead: true,
                                                            mode: 'remote',
                                                            selectOnFoucs: true,
                                                            triggerAction: 'all',
                                                            store: Ynzc.manage.TempliveFile,
                                                            disabled: true
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'temporaycertificatecode',
                                                            fieldLabel: "暂住证明号码",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            disabled: true
                                                        }]
                                                    }]
                                                },
                                                {
                                                    id: "changerecordhandler",
                                                    title: "经办情况",
                                                    xtype: "fieldset",
                                                    height: 100,
                                                    layout: "column",
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'checkinmen',
                                                            fieldLabel: "登记审核人",
                                                            xtype: "textfield",
                                                            value:result.reson.reviewer,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'checkindate',
                                                            fieldLabel: "经办时间",
                                                            value: new Date(),
                                                            xtype: "datefield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            format: "Y-m-d"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'licensemen',
                                                            fieldLabel: "牌证管理员",
                                                            xtype: "textfield",
                                                            value:result.reson.issueadmin,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'licensedate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            value: new Date(),
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            format: "Y-m-d"
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'businessmen',
                                                            fieldLabel: "业务领导审核",
                                                            xtype: "textfield",
                                                            value:result.reson.leaderreview,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 85,
                                                        items: [{
                                                            id: 'businessdate',
                                                            fieldLabel: "经办时间",
                                                            value: new Date(),
                                                            xtype: "datefield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            format: "Y-m-d"
                                                        }]
                                                    }]
                                                }],
                                                buttons: [{
                                                    text: "详细信息",
                                                    handler: function() {
                                                        	Ext.Ajax.request({
                                                           	 url:'main/tractorInfo.html?action=GetAllTractorInfo',
                                                           	 method:'post',
                                                   			 success:function(resp){
                                                        		var result=Ext.util.JSON.decode(resp.responseText);
                                                   				new Ynzc.manage.CarinfoWin({
                                                   					title : "详细信息",
                                                   					height:530,
                                                   					width:870,
                                                   					html:result.result
                                                   				}).show();
                                                   			},
                                                   			params: {
                                                                license : PlateNumHead+"."+licensenum
                                                            }
                                                    	  });
                                                    }.createDelegate(this)
                                                },{
                                                    text: "保存",
                                                    handler: function() {
                                                        var changerecordtypevalue = "";
                                                        if (Ext.getCmp("otherOne").checked) {
                                                            changerecordtypevalue = changerecordtypevalue + Ext.getCmp("otherOne").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("otherSecond").checked) {
                                                            changerecordtypevalue = changerecordtypevalue + Ext.getCmp("otherSecond").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("otherThree").checked) {
                                                            changerecordtypevalue = changerecordtypevalue + Ext.getCmp("otherThree").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("otherFour").checked) {
                                                            changerecordtypevalue = changerecordtypevalue + Ext.getCmp("otherFour").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("otherFive").checked) {
                                                            changerecordtypevalue = changerecordtypevalue + Ext.getCmp("otherFive").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("otherSex").checked) {
                                                            changerecordtypevalue = changerecordtypevalue + Ext.getCmp("otherSex").inputValue + ",";
                                                        }
                                                        if (changerecordtypevalue == "") {
                                                            Ext.MessageBox.alert("提示", "请选择变更备案事项.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("changerecordname").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写变更后的信息[姓名/名称].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("linktel").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写变更后的信息[联系电话].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("certificateid").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写变更后的信息[身份证类型].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("certificatecode").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写变更后的信息[身份证号码].");
                                                            return;
                                                        }
                                                        if(Ext.getCmp("certificateid").getValue() == "8")
                                                        {
                                                        	if(Ext.getCmp("certificatecode").getValue() != "")
                                                        	{
                                                        		if(checkIdCard(Ext.getCmp("certificatecode").getValue()) != true){
                                        							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("certificatecode").getValue()));
                                        							return;
                                        						}
                                                        	}
                                                        }
                                                        if (Ext.getCmp("istemporary").getValue() != "0") {
                                                            if (Ext.getCmp("temporaycertificate").getValue() == "" || Ext.getCmp("temporaycertificatecode").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写变更后的信息[暂住证类型和暂住证号码].");
                                                                return;
                                                            }
                                                        }
                                                        if (Ext.getCmp("checkinmen").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办情况[登记审核人].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("checkindate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办情况[登记审核人经办时间].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("licensemen").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办情况[牌证管理员].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("licensedate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办情况[牌证管理员经办时间].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("businessmen").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办情况[业务领导审核].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("businessdate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办情况[业务领导审核经办时间].");
                                                            return;
                                                        }
                                                        Ext.Ajax.request({
                                                            url: "main/changeRecord.html?action=addChangeRecord",
                                                            method: "post",
                                                            success: function() {
                                                                Ext.MessageBox.alert("提示", "变更备案成功.");
                                                                Ext.getCmp("changerecordWin").close();
                                                                Ext.getCmp("changerecordMgr").getStore().reload();
                                                            },
                                                            failure: function() {
                                                                Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                            },
                                                            params: {
                                                                tractorinfoid: result.reson.id,
                                                                changerecordtype: changerecordtypevalue,
                                                                changerecordname: Ext.getCmp("changerecordname").getValue(),
                                                                linktel: Ext.getCmp("linktel").getValue(),
                                                                certificateid: Ext.getCmp("certificateid").getValue(),
                                                                certificatecode: Ext.getCmp("certificatecode").getValue(),
                                                                unittype: Ext.getCmp("unittype").getValue(),
                                                                address: Ext.getCmp("address").getValue(),
                                                                zipcode: Ext.getCmp("zipcode").getValue(),
                                                                istemporary: Ext.getCmp("istemporary").getValue(),
                                                                temporaycertificate: Ext.getCmp("temporaycertificate").getValue(),
                                                                temporaycertificatecode: Ext.getCmp("temporaycertificatecode").getValue(),
                                                                checkinmen: Ext.getCmp("checkinmen").getValue(),
                                                                checkindate: Ext.util.Format.date(Ext.getCmp("checkindate").getValue(), 'Y-m-d'),
                                                                licensemen: Ext.getCmp("licensemen").getValue(),
                                                                licensedate: Ext.util.Format.date(Ext.getCmp("licensedate").getValue(), 'Y-m-d'),
                                                                businessmen: Ext.getCmp("businessmen").getValue(),
                                                                businessdate: Ext.util.Format.date(Ext.getCmp("businessdate").getValue(), 'Y-m-d')
                                                            }
                                                        });
                                                    }
                                                },
                                                {
                                                    text: "取消",
                                                    handler: function() {
                                                        Ext.getCmp("changerecordWin").close();
                                                    }
                                                }]
                                            }).show();
                                        } else {
                                            Ext.Msg.alert("提示", result.reson);
                                        }
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                    },
                                    params: {
                                        codeNum: Ext.getCmp("codenum").getValue()
                                    }
                                });
                            }
                        }]
                    }).show(Ext.getCmp("changerecordBtn").getEl());
                }.createDelegate(this)
            },
            {
                text: "上报",
                iconCls: "icon-Region",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中需要上报的信息！");
                        return
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkstate != 0 && selections[i].data.checkstate != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过审核】的信息进行上报！");
                            return;
                        }
                    }
                    var changerecordids = "";
                    for (i = 0; i < n; i++) {
                        if (changerecordids.length == 0) {
                            changerecordids = changerecordids + selections[i].data.id;
                        } else {
                            changerecordids = changerecordids + "," + selections[i].data.id;
                        }
                    }
                    Ext.Msg.show({
                        title: '系统确认',
                        msg: '你是否确认上报选中的信息?',
                        buttons: Ext.Msg.YESNO,
                        scope: this,
                        icon: Ext.MessageBox.QUESTION,
                        fn: function(btn) {
                            if (btn == "yes") {
                                Ext.Ajax.request({
                                    url: "main/changeRecord.html?action=ReportedChangeRecord",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("changerecordMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reportchangerecordids: changerecordids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
                text: "编辑",
                conCls: "icon-bookedit",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中需要编辑的信息！");
                        return
                    }
                    if (n > 1) {
                        Ext.MessageBox.alert("提示", "请选中一条需要编辑的信息！");
                        return
                    }
                    if (selections[0].data.checkstate != 0 && selections[0].data.checkstate != 3) {
                        Ext.MessageBox.alert("提示", "只能对【待报、审核未通过】的数据进行编辑！");
                        return
                    }
                    new Ext.Window({
                        id: "updatechangerecordWin",
                        title: "修改变更备案登记事项",
                        iconCls: 'icon-Add',
                        resizable: false,
                        modal: true,
                        height: 470,
                        width: 700,
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            id: "updadtechangerecordtype",
                            title: "变更备案事项",
                            xtype: "fieldset",
                            height: 80,
                            layout: "column",
                            items: [{
                                columnWidth: .5,
                                layout: "fit",
                                baseCls: "x-plain",
                                labelWidth: 160,
                                items: [{
                                    id: "updateotherOne",
                                    boxLabel: "住所在农机监理机构管辖区域内迁移",
                                    xtype: "checkbox",
                                    inputValue: "住所在农机监理机构管辖区域内迁移"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                baseCls: "x-plain",
                                labelWidth: 160,
                                items: [{
                                    id: "updateotherSecond",
                                    boxLabel: "变更拖拉机所有人姓名/名称",
                                    xtype: "checkbox",
                                    inputValue: "变更拖拉机所有人姓名/名称"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                baseCls: "x-plain",
                                labelWidth: 160,
                                items: [{
                                    id: "updateotherThree",
                                    boxLabel: "变更公章样式",
                                    xtype: "checkbox",
                                    inputValue: "变更公章样式"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                baseCls: "x-plain",
                                labelWidth: 160,
                                items: [{
                                    id: "updateotherFour",
                                    boxLabel: "变更联系方式",
                                    xtype: "checkbox",
                                    inputValue: "变更联系方式"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                baseCls: "x-plain",
                                labelWidth: 160,
                                items: [{
                                    id: "updateotherFive",
                                    boxLabel: "变更发动机拓印膜样式",
                                    xtype: "checkbox",
                                    inputValue: "变更发动机拓印膜样式"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                baseCls: "x-plain",
                                labelWidth: 160,
                                items: [{
                                    id: "updateotherSex",
                                    boxLabel: "变更拖拉机所有人身份证明名称/号码",
                                    xtype: "checkbox",
                                    inputValue: "变更拖拉机所有人身份证明名称/号码"
                                }]
                            }]
                        },
                        {
                            id: "updatechangerecordinfo",
                            title: "变更后的信息",
                            xtype: "fieldset",
                            height: 160,
                            layout: "column",
                            items: [{
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatechangerecordname',
                                    fieldLabel: "姓名/名称",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.changerecordname
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatelinktel',
                                    fieldLabel: "联系电话",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.linktel
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatecertificateid',
                                    fieldLabel: "身份证类型",
                                    xtype: "combo",
                                    anchor: '98%',
                                    displayField: 'realcertificatetype',
                                    valueField: 'id',
                                    typeAhead: true,
                                    mode: 'remote',
                                    editable: false,
                                    selectOnFoucs: true,
                                    triggerAction: 'all',
                                    store: Ynzc.manage.Certificate,
                                    value: selections[0].data.certificateid
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatecertificatecode',
                                    fieldLabel: "身份证号码",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.certificatecode
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updateunittype',
                                    fieldLabel: "单位/个人",
                                    xtype: "combo",
                                    anchor: '98%',
                                    displayField: 'displayvalue',
                                    valueField: 'value',
                                    typeAhead: true,
                                    mode: 'local',
                                    editable: false,
                                    selectOnFoucs: true,
                                    triggerAction: 'all',
                                    value: selections[0].data.unittype,
                                    store: Ynzc.manage.UOrPStore
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updateaddress',
                                    fieldLabel: "住所地址",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.address
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatezipcode',
                                    fieldLabel: "邮政编码",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.zipcode
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updateistemporary',
                                    fieldLabel: "是否暂住",
                                    xtype: "combo",
                                    anchor: '98%',
                                    displayField: 'displayvalue',
                                    valueField: 'value',
                                    typeAhead: true,
                                    mode: 'local',
                                    editable: false,
                                    selectOnFoucs: true,
                                    triggerAction: 'all',
                                    store: Ynzc.manage.YesOrNoStore,
                                    value: selections[0].data.istemporary,
                                    listeners: {
                                        'select': function(combo, record, index) {
                                            if (record.data.value == 1) {
                                                Ext.getCmp('updatetemporaycertificate').setValue(null);
                                                Ext.getCmp('updatetemporaycertificatecode').setValue(null);
                                                Ext.getCmp('updatetemporaycertificate').setDisabled(false);
                                                Ext.getCmp('updatetemporaycertificatecode').setDisabled(false);
                                            } else {
                                                Ext.getCmp('updatetemporaycertificate').setValue(null);
                                                Ext.getCmp('updatetemporaycertificatecode').setValue(null);
                                                Ext.getCmp('updatetemporaycertificate').setDisabled(true);
                                                Ext.getCmp('updatetemporaycertificatecode').setDisabled(true);
                                            }
                                        }
                                    }
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatetemporaycertificate',
                                    fieldLabel: "暂住证名类型",
                                    xtype: "combo",
                                    anchor: '98%',
                                    displayField: 'templivefileType',
                                    editable: false,
                                    valueField: 'id',
                                    typeAhead: true,
                                    mode: 'remote',
                                    selectOnFoucs: true,
                                    triggerAction: 'all',
                                    store: Ynzc.manage.TempliveFile,
                                    value: selections[0].data.temporaycertificate
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatetemporaycertificatecode',
                                    fieldLabel: "暂住证明号码",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.temporaycertificatecode
                                }]
                            }]
                        },
                        {
                            id: "updatechangerecordhandler",
                            title: "经办情况",
                            xtype: "fieldset",
                            height: 100,
                            layout: "column",
                            items: [{
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatecheckinmen',
                                    fieldLabel: "登记审核人",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.checkinmen
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatecheckindate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    anchor: '98%',
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.checkindate.time).format("Y-m-d")
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatelicensemen',
                                    fieldLabel: "牌证管理员",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.licensemen
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatelicensedate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    anchor: '98%',
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.licensedate.time).format("Y-m-d")
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatebusinessmen',
                                    fieldLabel: "业务领导审核",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.businessmen
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                baseCls: "x-plain",
                                labelWidth: 85,
                                items: [{
                                    id: 'updatebusinessdate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    anchor: '98%',
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.businessdate.time).format("Y-m-d")
                                }]
                            }]
                        }],
                        buttons: [{
                            text: "详细信息",
                            handler: function() {
                                	Ext.Ajax.request({
                                   	 url:'main/tractorInfo.html?action=GetAllTractorInfo',
                                   	 method:'post',
                           			 success:function(resp){
                                		var result=Ext.util.JSON.decode(resp.responseText);
                           				new Ynzc.manage.CarinfoWin({
                           					title : "详细信息",
                           					height:530,
                           					width:870,
                           					html:result.result
                           				}).show();
                           			},
                           			params: {
                                        license : PlateNumHead+"."+selections[0].data.license
                                    }
                            	  });
                            }.createDelegate(this)
                        },{
                            text: "保存",
                            handler: function() {
                                var updatechangerecordtypevalue = "";
                                if (Ext.getCmp("updateotherOne").checked) {
                                    updatechangerecordtypevalue = updatechangerecordtypevalue + Ext.getCmp("updateotherOne").inputValue + ",";
                                }
                                if (Ext.getCmp("updateotherSecond").checked) {
                                    updatechangerecordtypevalue = updatechangerecordtypevalue + Ext.getCmp("updateotherSecond").inputValue + ",";
                                }
                                if (Ext.getCmp("updateotherThree").checked) {
                                    updatechangerecordtypevalue = updatechangerecordtypevalue + Ext.getCmp("updateotherThree").inputValue + ",";
                                }
                                if (Ext.getCmp("updateotherFour").checked) {
                                    updatechangerecordtypevalue = updatechangerecordtypevalue + Ext.getCmp("updateotherFour").inputValue + ",";
                                }
                                if (Ext.getCmp("updateotherFive").checked) {
                                    updatechangerecordtypevalue = updatechangerecordtypevalue + Ext.getCmp("updateotherFive").inputValue + ",";
                                }
                                if (Ext.getCmp("updateotherSex").checked) {
                                    updatechangerecordtypevalue = updatechangerecordtypevalue + Ext.getCmp("updateotherSex").inputValue + ",";
                                }
                                if (updatechangerecordtypevalue == "") {
                                    Ext.MessageBox.alert("提示", "请选择变更备案事项.");
                                    return;
                                }
                                if (Ext.getCmp("updatechangerecordname").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写变更后的信息[姓名/名称].");
                                    return;
                                }
                                if (Ext.getCmp("updatelinktel").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写变更后的信息[联系电话].");
                                    return;
                                }
                                if (Ext.getCmp("updatecertificateid").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写变更后的信息[身份证类型].");
                                    return;
                                }
                                if (Ext.getCmp("updatecertificatecode").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写变更后的信息[身份证号码].");
                                    return;
                                }
                                if(Ext.getCmp("updatecertificateid").getValue() == "8")
                                {
                                	if(Ext.getCmp("updatecertificatecode").getValue() != "")
                                	{
                                		if(checkIdCard(Ext.getCmp("updatecertificatecode").getValue()) != true){
                							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatecertificatecode").getValue()));
                							return;
                						}
                                	}
                                }
                                if (Ext.getCmp("updateistemporary").getValue() != "0") {
                                    if (Ext.getCmp("updatetemporaycertificate").getValue() == "" || Ext.getCmp("updatetemporaycertificatecode").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写变更后的信息[暂住证类型和暂住证号码].");
                                        return;
                                    }
                                }
                                if (Ext.getCmp("updatecheckinmen").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办情况[登记审核人].");
                                    return;
                                }
                                if (Ext.getCmp("updatecheckindate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办情况[登记审核人经办时间].");
                                    return;
                                }
                                if (Ext.getCmp("updatelicensemen").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办情况[牌证管理员].");
                                    return;
                                }
                                if (Ext.getCmp("updatelicensedate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办情况[牌证管理员经办时间].");
                                    return;
                                }
                                if (Ext.getCmp("updatebusinessmen").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办情况[业务领导审核].");
                                    return;
                                }
                                if (Ext.getCmp("updatebusinessdate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办情况[业务领导审核经办时间].");
                                    return;
                                }
                                var checkdatevar = null;
                                if (selections[0].data.checkdate != null) {
                                    checkdatevar = new Date(selections[0].data.checkdate.time).format('Y-m-d');
                                }
                                Ext.Ajax.request({
                                    url: "main/changeRecord.html?action=updateChangeRecord",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "变更备案修改成功.");
                                        Ext.getCmp("updatechangerecordWin").close();
                                        Ext.getCmp("changerecordMgr").getStore().reload();
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        id: selections[0].data.id,
                                        tractorinfoid: selections[0].data.tractorinfoId,
                                        changerecordtype: updatechangerecordtypevalue,
                                        changerecordname: Ext.getCmp("updatechangerecordname").getValue(),
                                        linktel: Ext.getCmp("updatelinktel").getValue(),
                                        certificateid: Ext.getCmp("updatecertificateid").getValue(),
                                        certificatecode: Ext.getCmp("updatecertificatecode").getValue(),
                                        unittype: Ext.getCmp("updateunittype").getValue(),
                                        address: Ext.getCmp("updateaddress").getValue(),
                                        zipcode: Ext.getCmp("updatezipcode").getValue(),
                                        istemporary: Ext.getCmp("updateistemporary").getValue(),
                                        temporaycertificate: Ext.getCmp("updatetemporaycertificate").getValue(),
                                        temporaycertificatecode: Ext.getCmp("updatetemporaycertificatecode").getValue(),
                                        checkinmen: Ext.getCmp("updatecheckinmen").getValue(),
                                        checkindate: Ext.util.Format.date(Ext.getCmp("updatecheckindate").getValue(), 'Y-m-d'),
                                        licensemen: Ext.getCmp("updatelicensemen").getValue(),
                                        licensedate: Ext.util.Format.date(Ext.getCmp("updatelicensedate").getValue(), 'Y-m-d'),
                                        businessmen: Ext.getCmp("updatebusinessmen").getValue(),
                                        businessdate: Ext.util.Format.date(Ext.getCmp("updatebusinessdate").getValue(), 'Y-m-d'),
                                        checkmen: selections[0].data.checkmen,
                                        checkstate: selections[0].data.checkstate,
                                        checkdate: checkdatevar,
                                        checkcontent: selections[0].data.checkcontent,
                                        checkip: selections[0].data.checkip,
                                        opertator: selections[0].data.opertator,
                                        opertatedate: new Date(selections[0].data.opertatedate.time).format('Y-m-d')
                                    }
                                });
                            }
                        },
                        {
                            text: "取消",
                            handler: function() {
                                Ext.getCmp("changerecordWin").close();
                            }
                        }]
                    }).show();
                    var str = selections[0].data.changerecordtype.split(",");
                    for (i = 0; i < str.length; i++) {
                        if (str[i] == "住所在农机监理机构管辖区域内迁移") {
                            Ext.getCmp("updateotherOne").setValue(true);
                            continue;
                        };
                        if (str[i] == "变更拖拉机所有人姓名/名称") {
                            Ext.getCmp("updateotherSecond").setValue(true);
                            continue;
                        };
                        if (str[i] == "变更公章样式") {
                            Ext.getCmp("updateotherThree").setValue(true);
                            continue;
                        };
                        if (str[i] == "变更联系方式") {
                            Ext.getCmp("updateotherFour").setValue(true);
                            continue;
                        };
                        if (str[i] == "变更发动机拓印膜样式") {
                            Ext.getCmp("updateotherFive").setValue(true);
                            continue;
                        };
                        if (str[i] == "变更拖拉机所有人身份证明名称/号码") {
                            Ext.getCmp("updateotherSex").setValue(true);
                            continue;
                        };
                    }
                    if (selections[0].data.istemporary == 0) {
                        Ext.getCmp('updatetemporaycertificate').setValue(null);
                        Ext.getCmp('updatetemporaycertificatecode').setValue(null);
                        Ext.getCmp('updatetemporaycertificate').setDisabled(true);
                        Ext.getCmp('updatetemporaycertificatecode').setDisabled(true);
                    }
                }.createDelegate(this)
            },
            {
                text: "删除",
                iconCls: "icon-Del",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中需要删除的信息！");
                        return
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkstate == 1 || selections[i].data.checkstate == 2) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、审核未通过】的信息进行删除！");
                            return;
                        }
                    }
                    var delchangerecordids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkstate != 2) {
                            updatetractorids = updatetractorids + selections[i].data.tractorinfoid + ",";
                        }
                        if (delchangerecordids.length == 0) {
                            delchangerecordids = delchangerecordids + selections[i].data.id;
                        } else {
                            delchangerecordids = delchangerecordids + "," + selections[i].data.id;
                        }

                    }
                    Ext.Msg.show({
                        title: '系统确认',
                        msg: '你是否确认删除选中的信息?',
                        buttons: Ext.Msg.YESNO,
                        scope: this,
                        icon: Ext.MessageBox.QUESTION,
                        fn: function(btn) {
                            if (btn == "yes") {
                                Ext.Ajax.request({
                                    url: "main/changeRecord.html?action=delChangeRecord",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("changerecordMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        mydelchangerecordids: delchangerecordids,
                                        tractorids: updatetractorids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
                text: "查询",
                iconCls: "icon-search",
                handler: function() {
                    new Ext.Window({
                        id: "searchWin",
                        title: "请输入查询条件",
                        modal: true,
                        height: 300,
                        width: 400,
                        layout: "form",
                        labelWidth: 95,
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            id: 'txtlicense',
                            fieldLabel: "号牌号码关键字",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtowner',
                            fieldLabel: "所有人",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtmahinetype',
                            fieldLabel: "机械类型",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtplantType',
                            fieldLabel: "厂牌型号",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtcheckexiprydate',
                            format: "Y-m-d",
                            fieldLabel: "检验有效期",
                            xtype: "datefield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtregcerno',
                            fieldLabel: "登记证书编号",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtcardid',
                            fieldLabel: "身份证号码",
                            xtype: "textfield",
                            anchor: '98%'
                        },
                        {
                            id: 'txtengineno',
                            fieldLabel: "发动机号",
                            xtype: "textfield",
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                        	Ext.getCmp("changerecordMgr").getStore().reload({
                                    params: {
                                        start: 0,
                                        limit: 20,
                                        codenum: Ext.getCmp("txtlicense").getValue(),
                                        owner: Ext.getCmp("txtowner").getValue(),
                                        machinetype: Ext.getCmp("txtmahinetype").getValue(),
                                        plantType: Ext.getCmp("txtplantType").getValue(),
                                        checkexpriydate: Ext.util.Format.date(Ext.getCmp("txtcheckexiprydate").getValue(), 'Y-m-d'),
                                        regcerno: Ext.getCmp("txtregcerno").getValue(),
                                        cardid: Ext.getCmp("txtcardid").getValue(),
                                        engineno: Ext.getCmp("txtengineno").getValue()
                                    }
                                });
                                Ext.getCmp("searchWin").close();
                            }
                        },
                        {
                            text: "取消",
                            handler: function() {
                                Ext.getCmp("searchWin").close();
                            }
                        }]
                    }).show();
                }
            },
            {
            text: "打印登记业务流程记录单",
            iconCls:"icon-print",
            handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的业务记录!");
	                        return;
	                    }
	                    if(n>1){
	                        Ext.MessageBox.alert("提示","请逐一选择!");
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
	                    				},
	                        failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
	                        params:{
                    			wordType:"tractorRegistrationRecordProcess1",
                    			cnWord:"打印流程表",
                        		topMargin:"",
                        		bottomMargin:"",
                        		leftMargin:"",
                        		rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'打印登记业务流程记录单',
	        					sourceURL:'main/changeRecord.html?action=changeRecordInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
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
        Ynzc.manage.ChangeRecordGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });
    }
});
Ext.reg('changerecordgrid', Ynzc.manage.ChangeRecordGrid);