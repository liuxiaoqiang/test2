Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.CarTransferReplacementGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'cartransferreplacementgrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '</table>')
        });
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '业务种类',
            sortable: true,
            dataIndex: "sortsofinsurance"
        },
        {
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
            dataIndex: "owner",
            renderer: function(value, meta, record) {
                value = "<font color=red>" + value + "</font>";
                return value;
            }
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
            header: '检验有效期',
            sortable: true,
            dataIndex: "tractorinfocheckexpirydate",
            renderer: function(value) {
                if (value != null) {
                    value = new Date(value.time).format('Y-m-d');
                    return value;
                }

            }
        },
        {
            header: '登记人',
            sortable: true,
            dataIndex: "operator"
        },
        {
            header: '业务状态',
            sortable: true,
            dataIndex: "examineStatus",
            renderer: function(value) {
                if (value == 0) {
                    return '待报';
                } else if (value == 1) {
                    return '待审';
                } else if (value == 2) {
                    return '通过审核';
                } else if (value == 3) {
                    return '未通过审核';
                }
            }
        },
        {
            header: '审核人',
            sortable: true,
            dataIndex: "examineAuditor"
        },
        {
            header: '审核时间',
            sortable: true,
            dataIndex: "examineDate",
            renderer: function(value) {
                if (value != null) {
                    value = new Date(value.time).format('Y-m-d');
                    return value;
                }

            }
        }]);
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
                name: 'examineAuditor'
            },
            {
                name: 'examineStatusIdea'
            },
            {
                name: 'examineDate'
            },
            {
                name: 'operator'
            },
            {
                name: 'operatorDate'
            },
            {
                name: 'tractorinfoId'
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
                name: 'tractorinfoplantType'
            }]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/tractorReplacementInfo.html?action=getAllReplacementInfoListByPage',
            reader: reader,
            baseParams:{state:"0,1,2"},
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'cartransferreplacementgrid',
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
                id: 'typeAdd',
                text: "业务办理",
                iconCls: "icon-Add",
                handler: function() {
                    var win = new Ext.Window({
                        id: "inputCodeNumWin",
                        title: "请输入号牌号码",
                        modal: true,
                        height: 120,
                        width: 180,
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
                                    Ext.MessageBox.alert("提示", "请输入号牌号码!");
                                    return
                                }
                                Ext.Ajax.request({
                                    url: 'main/tractorInfoView.html?action=IsExits',
                                    method: "post",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            Ext.getCmp("inputCodeNumWin").close();
                                            new Ext.Window({
                                                id: "replaceWin",
                                                title: "补领、补换牌证",
                                                modal: true,
                                                height: 530,
                                                width: 570,
                                                layout: "form",
                                                autoScroll: true,
                                                bodyStyle: "padding:5px 5px",
                                                items: [{
                                                    baseCls: "x-plain",
                                                    collapsible: false,
                                                    layout: "column",
                                                    width: 522,
                                                    items: [{
                                                        columnWidth: .5,
                                                        labelWidth: 55,
                                                        baseCls: "x-plain",
                                                        layout: "form",
                                                        items: [{
                                                            id: "One",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            fieldLabel: "号牌号码",
                                                            readOnly: true,
                                                            value: result.reson.platecode + "." + result.reson.license

                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        labelWidth: 80,
                                                        baseCls: "x-plain",
                                                        layout: "form",
                                                        items: [{
                                                            id: "Two",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            fieldLabel: "登记证书编号",
                                                            readOnly: true,
                                                            value: result.reson.regcerno

                                                        }]
                                                    }]
                                                },
                                                {
                                                    xtype: "fieldset",
                                                    title: "车辆信息",
                                                    layout: "column",
                                                    height: 310,
                                                    titleCollapse: true,
                                                    collapsed: true,
                                                    collapsible: true,
                                                    width: 522,
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code2',
                                                            fieldLabel: "姓名",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.owner

                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code3',
                                                            fieldLabel: "联系电话",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.telephone
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code4',
                                                            fieldLabel: "身份证明名称",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.realcertificatetype
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code5',
                                                            fieldLabel: "身份证明号码",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.realcertificateno
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'isunit',
                                                            fieldLabel: "单位/个人",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code7',
                                                            fieldLabel: "住所地址",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.tempaddress
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code8',
                                                            fieldLabel: "邮政编码",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.zipCode
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'istemplive',
                                                            fieldLabel: "是否暂住",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code10',
                                                            fieldLabel: "品牌型号",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.plantType
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code11',
                                                            fieldLabel: "机械类型",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.machinetype
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'machinebodyno',
                                                            fieldLabel: "机身底盘号",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.machinebodyno
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'engineno',
                                                            fieldLabel: "发动机号",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.engineno
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'registerdate',
                                                            fieldLabel: "注册日期",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true
                                                        },
                                                        {
                                                            id: 'turnindate',
                                                            fieldLabel: "转入日期",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true
                                                        },
                                                        {
                                                            id: 'issuedate1',
                                                            fieldLabel: "发牌证日期",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: new Date(result.reson.issuedate.time).format("Y-m-d")
                                                        },
                                                        {
                                                            id: 'checkexpirydate1',
                                                            fieldLabel: "检验有效期",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: new Date(result.reson.checkexpirydate.time).format("Y-m-d")
                                                        },
                                                        {
                                                            id: 'expirydate1',
                                                            fieldLabel: "保险有效期",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: new Date(result.reson.expirydate.time).format("Y-m-d")
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            xtype: "box",
                                                            height: 123,
                                                            width: 240,
                                                            autoEl: {
                                                                tag: 'img',
                                                                src: result.reson.photourl
                                                            }
                                                        }]
                                                    }]
                                                },
                                                {
                                                    id: 'registerthing',
                                                    title: "申请事项",
                                                    xtype: "fieldset",
                                                    width: 522,
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
                                                            boxLabel: "换领登记证书",
                                                            xtype: "radio",
                                                            inputValue: '换领登记证书'
                                                        }]
                                                    }]

                                                },
                                                {
                                                    id: "voucher",
                                                    title: "相关凭证",
                                                    xtype: "fieldset",
                                                    width: 522,
                                                    collapsible: false,
                                                    layout: "column",
                                                    items: [{
                                                        columnWidth: .5,
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
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        labelWidth: 30,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: "voucherTwo",
                                                            boxLabel: "《协助执行通知书》",
                                                            checked:true,
                                                            xtype: "checkbox",
                                                            inputValue: "《协助执行通知书》"
                                                        }]
                                                    }]
                                                },
                                                {
                                                    id: 'reasonthing',
                                                    title: "补换领原因",
                                                    xtype: "fieldset",
                                                    width: 522,
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
                                                    }]
                                                },
                                                {

                                                    id: "replacementthing ",
                                                    title: "补换领机动车号牌",
                                                    xtype: "fieldset",
                                                    width: 522,
                                                    collapsible: false,
                                                    layout: "column",
                                                    items: [{
                                                        columnWidth: .5,
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
                                                        columnWidth: .5,
                                                        layout: "fit",
                                                        labelWidth: 180,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            name: "replacementgroup",
                                                            boxLabel: "2面",
                                                            xtype: "radio",
                                                            inputValue: '2面'
                                                        }]
                                                    }]
                                                },
                                                {
                                                    xtype: "fieldset",
                                                    title: "经办情况",
                                                    layout: "column",
                                                    height: 100,
                                                    width: 522,
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'registrantAuditor',
                                                            fieldLabel: "登记审核人",
                                                            xtype: "textfield",
                                                            value:result.reson.reviewer,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 70,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'registrantAuditorDate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            value: new Date(),
                                                            readOnly: true,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'flapperDirector',
                                                            fieldLabel: "牌证管理员",
                                                            xtype: "textfield",
                                                            value:result.reson.issueadmin,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 70,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'flapperDirectorDate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            value: new Date(),
                                                            readOnly: true,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'businessLeadAuditor',
                                                            fieldLabel: "业务领导审核",
                                                            xtype: "textfield",
                                                            value:result.reson.leaderreview,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 70,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'businessLeadAuditorDate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            value: new Date(),
                                                            format: "Y-m-d",
                                                            readOnly: true,
                                                            anchor: '98%'
                                                        }]
                                                    }]
                                                }

                                                ],
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
                                                    text: "提交",
                                                    handler: function() {
                                                        if (Ext.getCmp("register").getGroupValue() == null) {
                                                            Ext.MessageBox.alert("提示", "请选择登记事项!");
                                                            return
                                                        }
                                                        var str = "";
                                                        if (Ext.getCmp("voucherOne").checked) {
                                                            str = str + Ext.getCmp("voucherOne").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("voucherTwo").checked) {
                                                            str = str + Ext.getCmp("voucherTwo").inputValue + ",";
                                                        }
                                                        if (str == "") {
                                                            Ext.MessageBox.alert("提示", "请选择相关凭证!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("reason").getGroupValue() == null) {
                                                            Ext.MessageBox.alert("提示", "请选择补换领原因!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("replacement").getGroupValue() == null) {
                                                            Ext.MessageBox.alert("提示", "请选择补换领机动车号牌!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("registrantAuditor").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写登记审核人!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("registrantAuditorDate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写登记审核人经办时间!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("flapperDirector").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写牌证管理员!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("flapperDirectorDate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写牌证管理员经办时间!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("businessLeadAuditor").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写业务领导审核!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("businessLeadAuditorDate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写业务领导审核经办时间!");
                                                            return
                                                        }
                                                        Ext.Ajax.request({
                                                            url: 'main/tractorReplacementInfo.html?action=addTractorReplacementInfo',
                                                            success: function(resp) {
                                                                var result = Ext.util.JSON.decode(resp.responseText);
                                                                if (result.success == true) {
                                                                    Ext.MessageBox.alert("提示", "提交成功,请等待审核!");
                                                                    Ext.getCmp("replaceWin").close();
                                                                    Ext.getCmp("transferreplaceMgr").getStore().reload();
                                                                } else {
                                                                    Ext.Msg.alert("提示", "操作失败!");
                                                                }
                                                            },
                                                            failure: function() {
                                                                Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                                            },
                                                            params: {
                                                                flapperNumber: Ext.getCmp("One").getValue(),
                                                                certregistrationNumber: Ext.getCmp("Two").getValue(),
                                                                venue: result.reson.region,
                                                                sortsofinsurance: Ext.getCmp("register").getGroupValue(),
                                                                selevanceVoucher: str,
                                                                reason: Ext.getCmp("reason").getGroupValue(),
                                                                flapperFace: Ext.getCmp("replacement").getGroupValue(),
                                                                registrantAuditor: Ext.getCmp("registrantAuditor").getValue(),
                                                                registrantAuditorDate: Ext.util.Format.date(Ext.getCmp("registrantAuditorDate").getValue(), 'Y-m-d'),
                                                                flapperDirector: Ext.getCmp("flapperDirector").getValue(),
                                                                flapperDirectorDate: Ext.util.Format.date(Ext.getCmp("flapperDirectorDate").getValue(), 'Y-m-d'),
                                                                businessLeadAuditor: Ext.getCmp("businessLeadAuditor").getValue(),
                                                                businessLeadAuditorDate: Ext.util.Format.date(Ext.getCmp("businessLeadAuditorDate").getValue(), 'Y-m-d'),
                                                                tractorinfoId: result.reson.id
                                                            }
                                                        });
                                                    }
                                                }]

                                            }).show();
                                            if (result.reson.isUnion == 0) {
                                                Ext.getCmp("isunit").setValue("个人");
                                            } else {
                                                Ext.getCmp("isunit").setValue("单位");
                                            }
                                            if (result.reson.istemplived == 0) {
                                                Ext.getCmp("istemplive").setValue("常住人口");
                                            } else {
                                                Ext.getCmp("istemplive").setValue("暂住人口");
                                            }
                                            if (result.reson.registerdate != null && result.reson.registerdate != "") {
                                                Ext.getCmp("registerdate").setValue(new Date(result.reson.registerdate.time).format("Y-m-d"));
                                            }
                                            if (result.reson.turnindate != null && result.reson.turnindate != "") {
                                                Ext.getCmp("turnindate").setValue(new Date(result.reson.turnindate.time).format("Y-m-d"));
                                            }
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
                    }).show();

                }
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
                        if (selections[i].data.examineStatus != 0 && selections[i].data.examineStatus != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过审核】的信息进行上报！");
                            return;
                        }
                    }
                    var replaceids = "";
                    for (i = 0; i < n; i++) {
                        if (replaceids.length == 0) {
                            replaceids = replaceids + selections[i].data.id;
                        } else {
                            replaceids = replaceids + "," + selections[i].data.id;
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
                                    url: 'main/tractorReplacementInfo.html?action=ReportedTractorReplacementInfo',
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("transferreplaceMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        replacementInfoIds: replaceids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
                id: 'typeEdit',
                text: "编辑",
                iconCls: "icon-bookedit",
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
                    if (selections[0].data.examineStatus != 0 && selections[0].data.examineStatus != 3) {
                        Ext.MessageBox.alert("提示", "只能对【待报、审核未通过】的数据进行编辑！");
                        return
                    }
                    new Ext.Window({
                        id: "updatereplaceWin",
                        title: "补领、补换牌证",
                        modal: true,
                        height: 530,
                        width: 570,
                        layout: "form",
                        autoScroll: true,
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            baseCls: "x-plain",
                            collapsible: false,
                            layout: "column",
                            width: 522,
                            items: [{
                                columnWidth: .5,
                                labelWidth: 55,
                                baseCls: "x-plain",
                                layout: "form",
                                items: [{
                                    id: "updateOne",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    fieldLabel: "号牌号码",
                                    readOnly: true,
                                    value: selections[0].data.platecode + "." + selections[0].data.license

                                }]
                            },
                            {
                                columnWidth: .5,
                                labelWidth: 80,
                                baseCls: "x-plain",
                                layout: "form",
                                items: [{
                                    id: "updateTwo",

                                    xtype: "textfield",
                                    anchor: '98%',
                                    fieldLabel: "登记证书编号",
                                    readOnly: true,
                                    value: selections[0].data.regcerno

                                }]
                            }]
                        },
                        {
                            xtype: "fieldset",
                            title: "车辆信息",
                            layout: "column",
                            height: 310,
                            titleCollapse: true,
                            collapsed: true,
                            collapsible: true,
                            width: 522,
                            items: [{
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode2',
                                    fieldLabel: "姓名",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.owner

                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode3',
                                    fieldLabel: "联系电话",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.telephone
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode4',
                                    fieldLabel: "身份证明名称",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.realcertificatetype
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode5',
                                    fieldLabel: "身份证明号码",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.realcertificateno
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateisunit',
                                    fieldLabel: "单位/个人",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode7',
                                    fieldLabel: "住所地址",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.tempaddress
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode8',
                                    fieldLabel: "邮政编码",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.tractorinfozipcode
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateistemplive',
                                    fieldLabel: "是否暂住",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode10',
                                    fieldLabel: "品牌型号",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.tractorinfoplantType
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode11',
                                    fieldLabel: "机械类型",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.tractorinfomachinetype
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatemachinebodyno',
                                    fieldLabel: "机身底盘号",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.machinebodyno
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateengineno',
                                    fieldLabel: "发动机号",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.engineno
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateregisterdate',
                                    fieldLabel: "注册日期",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true
                                },
                                {
                                    id: 'updateturnindate',
                                    fieldLabel: "转入日期",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true
                                },
                                {
                                    id: 'updateissuedate1',
                                    fieldLabel: "发牌证日期",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: new Date(selections[0].data.issuedate.time).format("Y-m-d")
                                },
                                {
                                    id: 'updatecheckexpirydate1',
                                    fieldLabel: "检验有效期",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: new Date(selections[0].data.tractorinfocheckexpirydate.time).format("Y-m-d")
                                },
                                {
                                    id: 'updateexpirydate1',
                                    fieldLabel: "保险有效期",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: new Date(selections[0].data.tractorinfoexpirydate.time).format("Y-m-d")
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    xtype: "box",
                                    height: 123,
                                    width: 240,
                                    autoEl: {
                                        tag: 'img',
                                        src: selections[0].data.tractorinfophotourl
                                    }
                                }]
                            }]
                        },
                        {
                            id: 'updateregisterthing',
                            title: "申请事项",
                            xtype: "fieldset",
                            width: 522,
                            collapsible: false,
                            layout: "column",

                            items: [{
                                columnWidth: .3,
                                layout: "fit",
                                labelWidth: 30,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updateregister",
                                    name: "updateradiogroup",
                                    boxLabel: "补领拖拉机牌",
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
                                    name: "updateradiogroup",
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
                                    name: "updateradiogroup",
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
                                    name: "updateradiogroup",
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
                                    name: "updateradiogroup",
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
                                    name: "updateradiogroup",
                                    boxLabel: "换领登记证书",
                                    xtype: "radio",
                                    inputValue: '换领登记证书'
                                }]
                            }]

                        },
                        {
                            id: "updatevoucher",
                            title: "相关凭证",
                            xtype: "fieldset",
                            width: 522,
                            collapsible: false,
                            layout: "column",
                            items: [{
                                columnWidth: .5,
                                layout: "fit",
                                labelWidth: 30,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updatevoucherOne",
                                    boxLabel: "未得到登记证书证明",
                                    xtype: "checkbox",
                                    inputValue: "未得到登记证书证明"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                labelWidth: 30,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updatevoucherTwo",
                                    boxLabel: "《协助执行通知书》",
                                    xtype: "checkbox",
                                    inputValue: "《协助执行通知书》"
                                }]
                            }]
                        },
                        {
                            id: 'updatereasonthing',
                            title: "补换领原因",
                            xtype: "fieldset",
                            width: 522,
                            collapsible: false,
                            layout: "column",
                            items: [{
                                columnWidth: .3,
                                layout: "fit",
                                labelWidth: 30,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updatereason",
                                    name: "updatereasongroup",
                                    boxLabel: "丢失",
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
                                    name: "updatereasongroup",
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
                                    name: "updatereasongroup",
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
                                    name: "updatereasongroup",
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
                                    name: "updatereasongroup",
                                    boxLabel: "首次申领登记证书",
                                    xtype: "radio",
                                    inputValue: '首次申领登记证书'
                                }]
                            }]
                        },
                        {

                            id: "updatereplacementthing",
                            title: "补换领机动车号牌",
                            xtype: "fieldset",
                            width: 522,
                            collapsible: false,
                            layout: "column",
                            items: [{
                                columnWidth: .5,
                                layout: "fit",
                                labelWidth: 30,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updatereplacement",
                                    name: "updatereplacementgroup",
                                    boxLabel: "1面",
                                    xtype: "radio",
                                    inputValue: "1面"
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "fit",
                                labelWidth: 180,
                                baseCls: "x-plain",
                                items: [{
                                    name: "updatereplacementgroup",
                                    boxLabel: "2面",
                                    xtype: "radio",
                                    inputValue: '2面'
                                }]
                            }]
                        },
                        {
                            xtype: "fieldset",
                            title: "经办情况",
                            layout: "column",
                            height: 100,
                            width: 522,
                            items: [{
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateregistrantAuditor',
                                    fieldLabel: "登记审核人",
                                    xtype: "textfield",
                                    value: selections[0].data.registrantAuditor,
                                    anchor: '98%'

                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 70,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateregistrantAuditorDate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.registrantAuditorDate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateflapperDirector',
                                    fieldLabel: "牌证管理员",
                                    xtype: "textfield",
                                    value: selections[0].data.flapperDirector,
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 70,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateflapperDirectorDate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.flapperDirectorDate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatebusinessLeadAuditor',
                                    fieldLabel: "业务领导审核",
                                    xtype: "textfield",
                                    value: selections[0].data.businessLeadAuditor,
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 70,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatebusinessLeadAuditorDate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.businessLeadAuditorDate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            }]
                        }

                        ],
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
                            text: "提交",
                            handler: function() {
                                if (Ext.getCmp("updateregister").getGroupValue() == null) {
                                    Ext.MessageBox.alert("提示", "请选择登记事项!");
                                    return
                                }
                                var str = "";
                                if (Ext.getCmp("updatevoucherOne").checked) {
                                    str = str + Ext.getCmp("updatevoucherOne").inputValue + ",";
                                }
                                if (Ext.getCmp("updatevoucherTwo").checked) {
                                    str = str + Ext.getCmp("updatevoucherTwo").inputValue + ",";
                                }
                                if (str == "") {
                                    Ext.MessageBox.alert("提示", "请选择相关凭证!");
                                    return
                                }
                                if (Ext.getCmp("updatereason").getGroupValue() == null) {
                                    Ext.MessageBox.alert("提示", "请选择补换领原因!");
                                    return
                                }
                                if (Ext.getCmp("updatereplacement").getGroupValue() == null) {
                                    Ext.MessageBox.alert("提示", "请选择补换领机动车号牌!");
                                    return
                                }
                                if (Ext.getCmp("updateregistrantAuditor").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写登记审核人!");
                                    return
                                }
                                if (Ext.getCmp("updateregistrantAuditorDate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写登记审核人经办时间!");
                                    return
                                }
                                if (Ext.getCmp("updateflapperDirector").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写牌证管理员!");
                                    return
                                }
                                if (Ext.getCmp("updateflapperDirectorDate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写牌证管理员经办时间!");
                                    return
                                }
                                if (Ext.getCmp("updatebusinessLeadAuditor").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写业务领导审核!");
                                    return
                                }
                                if (Ext.getCmp("updatebusinessLeadAuditorDate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写业务领导审核经办时间!");
                                    return
                                }
                                var examineDatevar = null;
                                if (selections[0].data.examineDate != null && selections[0].data.examineDate != "") {
                                    examineDatevar = new Date(selections[0].data.examineDate.time).format('Y-m-d');
                                }
                                Ext.Ajax.request({
                                    url: 'main/tractorReplacementInfo.html?action=updateTractorReplacementInfo',
                                    success: function(resp) {
                                        var updateresult = Ext.util.JSON.decode(resp.responseText);
                                        if (updateresult.success == true) {
                                            Ext.MessageBox.alert("提示", "修改成功!");
                                            Ext.getCmp("updatereplaceWin").close();
                                            Ext.getCmp("transferreplaceMgr").getStore().reload();
                                        } else {
                                            Ext.Msg.alert("提示", "操作失败!");
                                        }
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                    },
                                    params: {
                                        id: selections[0].data.id,
                                        flapperNumber: Ext.getCmp("updateOne").getValue(),
                                        certregistrationNumber: Ext.getCmp("updateTwo").getValue(),
                                        venue: selections[0].data.region,
                                        sortsofinsurance: Ext.getCmp("updateregister").getGroupValue(),
                                        selevanceVoucher: str,
                                        reason: Ext.getCmp("updatereason").getGroupValue(),
                                        flapperFace: Ext.getCmp("updatereplacement").getGroupValue(),
                                        registrantAuditor: Ext.getCmp("updateregistrantAuditor").getValue(),
                                        registrantAuditorDate: Ext.util.Format.date(Ext.getCmp("updateregistrantAuditorDate").getValue(), 'Y-m-d'),
                                        flapperDirector: Ext.getCmp("updateflapperDirector").getValue(),
                                        flapperDirectorDate: Ext.util.Format.date(Ext.getCmp("updateflapperDirectorDate").getValue(), 'Y-m-d'),
                                        businessLeadAuditor: Ext.getCmp("updatebusinessLeadAuditor").getValue(),
                                        businessLeadAuditorDate: Ext.util.Format.date(Ext.getCmp("updatebusinessLeadAuditorDate").getValue(), 'Y-m-d'),
                                        examineStatus: selections[0].data.examineStatus,
                                        examineAuditor: selections[0].data.examineAuditor,
                                        examineStatusIdea: selections[0].data.examineStatusIdea,
                                        examineDate: examineDatevar,
                                        operator: selections[0].data.operator,
                                        operatorDate: new Date(selections[0].data.operatorDate.time).format('Y-m-d'),
                                        tractorinfoId: selections[0].data.tractorinfoId
                                    }
                                });
                            }
                        }]

                    }).show();
                    if (selections[0].data.isUnion == 0) {
                        Ext.getCmp("updateisunit").setValue("个人");
                    } else {
                        Ext.getCmp("updateisunit").setValue("单位");
                    }
                    if (selections[0].data.istemplived == 0) {
                        Ext.getCmp("updateistemplive").setValue("常住人口");
                    } else {
                        Ext.getCmp("updateistemplive").setValue("暂住人口");
                    }
                    if (selections[0].data.registerdate != null && selections[0].data.registerdate != "") {
                        Ext.getCmp("updateregisterdate").setValue(new Date(selections[0].data.registerdate.time).format("Y-m-d"));
                    }
                    if (selections[0].data.turnindate != null && selections[0].data.turnindate != "") {
                        Ext.getCmp("updateturnindate").setValue(new Date(selections[0].data.turnindate.time).format("Y-m-d"));
                    }
                    if (selections[0].data.sortsofinsurance != null && selections[0].data.sortsofinsurance == "补领拖拉机牌") {
                        Ext.getCmp("updateregisterthing").items.items[0].items.items[0].setValue(true);
                    } else if (selections[0].data.sortsofinsurance == "补领行驶证") {
                        Ext.getCmp("updateregisterthing").items.items[1].items.items[0].setValue(true);
                    } else if (selections[0].data.sortsofinsurance == "补领登记证书") {
                        Ext.getCmp("updateregisterthing").items.items[2].items.items[0].setValue(true);
                    } else if (selections[0].data.sortsofinsurance == "换拖拉机号牌") {
                        Ext.getCmp("updateregisterthing").items.items[3].items.items[0].setValue(true);
                    } else if (selections[0].data.sortsofinsurance == "换行驶证") {
                        Ext.getCmp("updateregisterthing").items.items[4].items.items[0].setValue(true);
                    } else if (selections[0].data.sortsofinsurance == "换领登记证书") {
                        Ext.getCmp("updateregisterthing").items.items[5].items.items[0].setValue(true);
                    }
                    var str = selections[0].data.selevanceVoucher.split(",");
                    for (i = 0; i < str.length; i++) {
                        if (str[i] == "未得到登记证书证明") {
                            Ext.getCmp("updatevoucherOne").setValue(true);
                            continue;
                        };
                        if (str[i] == "《协助执行通知书》") {
                            Ext.getCmp("updatevoucherTwo").setValue(true);
                            continue;
                        };
                    }
                    if (selections[0].data.reason == "丢失") {
                        Ext.getCmp("updatereasonthing").items.items[0].items.items[0].setValue(true);
                    } else if (selections[0].data.reason == "灭失") {
                        Ext.getCmp("updatereasonthing").items.items[1].items.items[0].setValue(true);
                    } else if (selections[0].data.reason == "损坏") {
                        Ext.getCmp("updatereasonthing").items.items[2].items.items[0].setValue(true);
                    } else if (selections[0].data.reason == "未得到登记证书") {
                        Ext.getCmp("updatereasonthing").items.items[3].items.items[0].setValue(true);
                    } else if (selections[0].data.reason == "首次申领登记证书") {
                        Ext.getCmp("updatereasonthing").items.items[4].items.items[0].setValue(true);
                    }
                    if (selections[0].data.flapperFace == "1面") {
                        Ext.getCmp("updatereplacementthing").items.items[0].items.items[0].setValue(true);
                    } else if (selections[0].data.flapperFace == "2面") {
                        Ext.getCmp("updatereplacementthing").items.items[1].items.items[0].setValue(true);
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
                        if (selections[i].data.examineStatus == 1 || selections[i].data.examineStatus == 2) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、审核未通过】的信息进行删除！");
                            return;
                        }
                    }
                    var replaceids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkresult != 2) {
                            updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
                        }
                        if (replaceids.length == 0) {
                            replaceids = replaceids + selections[i].data.id;
                        } else {
                            replaceids = replaceids + "," + selections[i].data.id;
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
                                    url: 'main/tractorReplacementInfo.html?action=delTractorReplacementInfo',
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("transferreplaceMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        replacementInfoIds: replaceids,
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
                        height: 330,
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
                        },
                        {
                            id: "replacetype",
                            fieldLabel: "业务类型",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            value: '--请选择--',
                            store: Ynzc.manage.ReplaceTypeData,
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                        	Ext.getCmp("transferreplaceMgr").getStore().reload({
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
                                        engineno: Ext.getCmp("txtengineno").getValue(),
                                        recplacementinfotype: Ext.getCmp("replacetype").getValue()
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
	        					sourceURL:'main/tractorReplacementInfo.html?action=tractorReplacementInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            },{
            text: "打印补领、换领拖拉机牌证申请表",
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
	                    var mask = new Ext.LoadMask(Ext.getBody(), {
							msg : '正在读取数据,请稍等...',
							removeMask:true
						});
						mask.show();
	                    Ext.Ajax.request({
	                    	url:"main/word.html?action=findWordSet",
	                        method:"post",
	                        success:function(response){
	                        	mask.hide();
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
	                        wordType:"tractorReplacementApplication",
                        	cnWord:"补领、换领拖拉机牌证申请表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'补领、换领拖拉机牌证申请表',
	        					sourceURL:'main/tractorReplacementInfo.html?action=PrintReplacementReport',
	        					params:{id:selections[0].data.tractorinfoId,wordType:'tractorReplacementApplication'}
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
        Ynzc.manage.CarTransferReplacementGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });

    }
});
Ext.reg('cartransferreplacementgrid', Ynzc.manage.CarTransferReplacementGrid);