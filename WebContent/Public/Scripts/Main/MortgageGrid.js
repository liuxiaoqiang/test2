Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.MortgageGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'mortgagegrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '</table>')
        });
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '申请登记种类',
            sortable: true,
            dataIndex: "mortgagetype"
        },
        {
            header: '管辖地',
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
            header: '发动机号',
            sortable: true,
            dataIndex: "engineno"
        },
        {
            header: '机架号码',
            sortable: true,
            dataIndex: "shelfno"
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
            header: '审批时间',
            sortable: true,
            dataIndex: "checkdate",
            renderer: function(value) {
                if (value != null) {
                    value = new Date(value.time).format('Y-m-d');
                    return value;
                } else {
                    return null;
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
                name: 'tractorinfoId'
            },
            {
                name: 'tractorcode'
            },
            {
                name: 'tractorno'
            },
            {
                name: 'tractoraddress'
            },
            {
                name: 'mortgagetype'
            },
            {
                name: 'mortgagementype'
            },
            {
                name: 'mortgageownermentype'
            },
            {
                name: 'mortgageusername'
            },
            {
                name: 'mortgageaddress'
            },
            {
                name: 'mortgageistemplive'
            },
            {
                name: 'mortgagecaridtype'
            },
            {
                name: 'mortgagecarid'
            },
            {
                name: 'mortgagelinktel'
            },
            {
                name: 'mortgagezipcode'
            },
            {
                name: 'mortgagehandledate'
            },
            {
                name: 'mortgageownerusername'
            },
            {
                name: 'mortgageowneraddress'
            },
            {
                name: 'mortgageisownertemplive'
            },
            {
                name: 'mortgageownercaridtype'
            },
            {
                name: 'mortgageownercarid'
            },
            {
                name: 'mortgageownerlinktel'
            },
            {
                name: 'mortgageownerzipcode'
            },
            {
                name: 'mortgageownerhandledate'
            },
            {
                name: 'mortgageinformation'
            },
            {
                name: 'mortgageproxyusername'
            },
            {
                name: 'mortgageproxylinktel'
            },
            {
                name: 'mortgageproxyaddress'
            },
            {
                name: 'mortgageproxyidtype'
            },
            {
                name: 'mortgageproxyid'
            },
            {
                name: 'mortgageproxyhandlename'
            },
            {
                name: 'mortgageproxyhandleidtype'
            },
            {
                name: 'mortgageproxyhandleid'
            },
            {
                name: 'mortgageproxyhandleaddress'
            },
            {
                name: 'mortgageproxyhandledate'
            },
            {
                name: 'mortgageownerproxyusername'
            },
            {
                name: 'mortgageownerproxylinktel'
            },
            {
                name: 'mortgageownerproxyaddress'
            },
            {
                name: 'mortgageownerproxyidtype'
            },
            {
                name: 'mortgageownerproxyid'
            },
            {
                name: 'mortgageownerproxyhandlename'
            },
            {
                name: 'mortgageownerproxyhandleidtype'
            },
            {
                name: 'mortgageownerproxyhandleid'
            },
            {
                name: 'mortgageownerproxyhandleaddress'
            },
            {
                name: 'mortgageownerproxyhandledate'
            },
            {
                name: 'checkmen'
            },
            {
                name: 'checkstate'
            },
            {
                name: 'checkcontent'
            },
            {
                name: 'checkdate'
            },
            {
                name: 'checkip'
            },
            {
                name: 'opertator'
            },
            {
                name: 'operatedate'
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
            url: "main/mortgage.html?action=getMortgageListByPage",
            reader: reader,
            baseParams:{state:"0,1,2"},
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'mortgagegrid',
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
                text: "抵押登记",
                iconCls: "icon-Add",
                handler: function() {
                    new Ext.Window({
                        id: "inputCodeNumWin",
                        title: "请输入要[抵押登记]的号牌号码",
                        modal: true,
                        height: 100,
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
                                    Ext.MessageBox.alert("提示", "请输入要抵押登记的号牌号码!");
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
                                            //创建添加框
                                            new Ext.Window({
                                                id: "mortgageWin",
                                                title: "请填写抵押登记事项",
                                                iconCls: 'icon-Add',
                                                resizable: false,
                                                modal: true,
                                                height: 550,
                                                width: 700,
                                                items: [{
                                                    xtype: 'tabpanel',
                                                    border: false,
                                                    frame: true,
                                                    activeTab: 0,
                                                    items: [{
                                                        title: '抵押人/抵押权人信息',
                                                        frame: true,
                                                        bodyStyle: "padding:5px 5px",
                                                        autoScroll: true,
                                                        height: 520,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: .33,
                                                            layout: "form",
                                                            labelWidth: 60,
                                                            baseCls: "x-plain",
                                                            items: [{
                                                                id: "tractorcode",
                                                                xtype: "textfield",
                                                                fieldLabel: "号牌号码",
                                                                anchor: '98%',
                                                                readOnly: true,
                                                                value: result.reson.platecode + "." + result.reson.license
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .33,
                                                            layout: "form",
                                                            labelWidth: 85,
                                                            baseCls: "x-plain",
                                                            items: [{
                                                                id: "tractorno",
                                                                xtype: "textfield",
                                                                fieldLabel: "登记证书编号",
                                                                anchor: '98%',
                                                                readOnly: true,
                                                                value: result.reson.regcerno
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .33,
                                                            layout: "form",
                                                            labelWidth: 60,
                                                            baseCls: "x-plain",
                                                            items: [{
                                                                id: "tractoraddress",
                                                                xtype: "textfield",
                                                                fieldLabel: "管辖地",
                                                                anchor: '98%',
                                                                readOnly: true,
                                                                value: result.reson.region
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: "column",
                                                            baseCls: "x-plain",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                items: [{
                                                                    id: "mortgagetype",
                                                                    name: "mortgagetypegroup",
                                                                    xtype: "radio",
                                                                    fieldLabel: "申请登记种类",
                                                                    boxLabel: "抵押登记",
                                                                    anchor: '98%',
                                                                    checked: true,
                                                                    inputValue: "抵押登记"
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "fit",
                                                                items: [{
                                                                    name: "mortgagetypegroup",
                                                                    xtype: "radio",
                                                                    boxLabel: "注销抵押登记",
                                                                    anchor: '98%',
                                                                    inputValue: "注销抵押登记"
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            id: "mortgageinfo",
                                                            title: "抵押人",
                                                            xtype: "fieldset",
                                                            height: 130,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageusername",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "姓名",
                                                                    anchor: '98%',
                                                                    value: result.reson.owner
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageaddress",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "住所地址",
                                                                    anchor: '98%',
                                                                    value: result.reson.address
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageistemplive",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "暂住地址",
                                                                    anchor: '98%',
                                                                    value: result.reson.tempaddress
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgagelinktel",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "联系电话",
                                                                    anchor: '98%',
                                                                    value: result.reson.telephone
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgagecaridtype",
                                                                    xtype: "combo",
                                                                    fieldLabel: "身份证明类型",
                                                                    anchor: '98%',
                                                                    displayField: 'realcertificatetype',
                                                                    valueField: 'id',
                                                                    typeAhead: true,
                                                                    mode: 'remote',
                                                                    editable: false,
                                                                    selectOnFoucs: true,
                                                                    triggerAction: 'all',
                                                                    store: Ynzc.manage.Certificate,
                                                                    value: result.reson.realcertificatetypeid
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgagecarid",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "身份证明号码",
                                                                    anchor: '98%',
                                                                    value: result.reson.realcertificateno
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgagezipcode",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "邮政编码",
                                                                    anchor: '98%',
                                                                    value: result.reson.zipCode
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgagehandledate",
                                                                    xtype: "datefield",
                                                                    fieldLabel: "经手时间",
                                                                    format: "Y-m-d",
                                                                    anchor: '98%',
                                                                    value: new Date(result.reson.registerdate.time).format("Y-m-d")
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            id: "mortgageownerinfo",
                                                            title: "抵押权人",
                                                            xtype: "fieldset",
                                                            height: 130,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerusername",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "姓名",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageowneraddress",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "住所地址",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageisownertemplive",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "暂住地址",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerlinktel",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "联系电话",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownercaridtype",
                                                                    xtype: "combo",
                                                                    fieldLabel: "身份证明类型",
                                                                    anchor: '98%',
                                                                    displayField: 'realcertificatetype',
                                                                    valueField: 'id',
                                                                    value: 8,
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
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownercarid",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "身份证明号码",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerzipcode",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "邮政编码",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerhandledate",
                                                                    xtype: "datefield",
                                                                    fieldLabel: "经手时间",
                                                                    value:new Date(),
                                                                    format: "Y-m-d",
                                                                    anchor: '98%'
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: "form",
                                                            labelWidth: 60,
                                                            baseCls: "x-plain",
                                                            items: [{
                                                                id: "mortgageinformation",
                                                                xtype: "textfield",
                                                                fieldLabel: "相关资料",
                                                                anchor: '98%'
                                                            }]
                                                        }]
                                                    },
                                                    {
                                                        title: '抵押人/抵押权人代理人信息',
                                                        frame: true,
                                                        bodyStyle: "padding:5px 5px",
                                                        autoScroll: true,
                                                        height: 520,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: 1,
                                                            id: "typeinfo",
                                                            title: "申请方式",
                                                            xtype: "fieldset",
                                                            height: 50,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .25,
                                                                layout: "form",
                                                                labelWidth: 50,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgagementype",
                                                                    name: "mortgagementypegroup",
                                                                    xtype: "radio",
                                                                    boxLabel: "本人申请",
                                                                    fieldLabel: "抵押人",
                                                                    inputValue: "本人申请",
                                                                    checked: true
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .25,
                                                                layout: "fit",
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    name: "mortgagementypegroup",
                                                                    xtype: "radio",
                                                                    boxLabel: "委托代理人申请",
                                                                    inputValue: "委托代理人申请"
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .25,
                                                                layout: "form",
                                                                labelWidth: 60,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownermentype",
                                                                    name: "mortgageownermentypegroup",
                                                                    xtype: "radio",
                                                                    boxLabel: "本人申请",
                                                                    fieldLabel: "抵押权人",
                                                                    inputValue: "本人申请",
                                                                    checked: true
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .25,
                                                                layout: "fit",
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    name: "mortgageownermentypegroup",
                                                                    xtype: "radio",
                                                                    boxLabel: "委托代理人申请",
                                                                    inputValue: "委托代理人申请"
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            id: "mortgageproxyinfo",
                                                            title: "抵押人的代理人",
                                                            xtype: "fieldset",
                                                            height: 180,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyusername",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "姓名",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxylinktel",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "联系电话",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyidtype",
                                                                    xtype: "combo",
                                                                    fieldLabel: "身份证明类型",
                                                                    anchor: '98%',
                                                                    displayField: 'realcertificatetype',
                                                                    valueField: 'id',
                                                                    value:8,
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
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyid",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "身份证明号码",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyaddress",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "暂住地址",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyhandlename",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "经办人姓名",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyhandleidtype",
                                                                    xtype: "combo",
                                                                    fieldLabel: "经办人身份证明名称",
                                                                    anchor: '98%',
                                                                    displayField: 'realcertificatetype',
                                                                    valueField: 'id',
                                                                    value:8,
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
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyhandleid",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "经办人身份证明号码",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyhandleaddress",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "经办人住所地址",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageproxyhandledate",
                                                                    xtype: "datefield",
                                                                    fieldLabel: "经办人签字时间",
                                                                    value:new Date(),
                                                                    format: "Y-m-d",
                                                                    anchor: '98%'
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            id: "mortgageownerproxyinfo",
                                                            title: "抵押权人的代理人",
                                                            xtype: "fieldset",
                                                            height: 180,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyusername",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "姓名",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxylinktel",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "联系电话",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyidtype",
                                                                    xtype: "combo",
                                                                    fieldLabel: "身份证明类型",
                                                                    anchor: '98%',
                                                                    displayField: 'realcertificatetype',
                                                                    valueField: 'id',
                                                                    typeAhead: true,
                                                                    value:8,
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
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyid",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "身份证明号码",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyaddress",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "暂住地址",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyhandlename",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "经办人姓名",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyhandleidtype",
                                                                    xtype: "combo",
                                                                    fieldLabel: "经办人身份证明名称",
                                                                    anchor: '98%',
                                                                    displayField: 'realcertificatetype',
                                                                    valueField: 'id',
                                                                    value:8,
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
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyhandleid",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "经办人身份证明号码",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyhandleaddress",
                                                                    xtype: "textfield",
                                                                    fieldLabel: "经办人住所地址",
                                                                    anchor: '98%'
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                baseCls: "x-plain",
                                                                items: [{
                                                                    id: "mortgageownerproxyhandledate",
                                                                    xtype: "datefield",
                                                                    fieldLabel: "经办人签字时间",
                                                                    value:new Date(),
                                                                    format: "Y-m-d",
                                                                    anchor: '98%'
                                                                }]
                                                            }]
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
                                                        if (Ext.getCmp("mortgagetype").getGroupValue() == null) {
                                                            Ext.MessageBox.alert("提示", "请选择登记种类.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("mortgageusername").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写抵押人信息[姓名/名称].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("mortgageaddress").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写抵押人信息[住所地址].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("mortgagecaridtype").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写抵押人信息[身份证明类型].");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("mortgagecarid").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写抵押人信息[身份证明号码].");
                                                            return;
                                                        }
                                                        if(Ext.getCmp("mortgagecaridtype").getValue() == "8")
                                                        {
                                                        	if(Ext.getCmp("mortgagecarid").getValue() != "")
                                                        	{
                                                        		if(checkIdCard(Ext.getCmp("mortgagecarid").getValue()) != true){
                                        							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("mortgagecarid").getValue()));
                                        							return;
                                        						}
                                                        	}
                                                        }
                                                        if(Ext.getCmp("mortgageownercaridtype").getValue() == "8")
                                                        {
                                                        	if(Ext.getCmp("mortgageownercarid").getValue() != "")
                                                        	{
                                                        		if(checkIdCard(Ext.getCmp("mortgageownercarid").getValue()) != true){
                                        							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("mortgageownercarid").getValue()));
                                        							return;
                                        						}
                                                        	}
                                                        }
                                                        if (Ext.getCmp("mortgagementype").getGroupValue() == null) {
                                                            Ext.MessageBox.alert("提示", "请选择抵押 人 申请方式");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("mortgageownermentype").getGroupValue() == null) {
                                                            Ext.MessageBox.alert("提示", "请选择抵押 权人 申请方式");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("mortgagementype").getGroupValue() == "委托代理人申请") {
                                                            if (Ext.getCmp("mortgageproxyusername").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][姓名].");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("mortgageproxylinktel").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][联系电话].");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("mortgageproxyidtype").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][身份证明类型].");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("mortgageproxyid").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][身份证明号码].");
                                                                return;
                                                            }
                                                            if(Ext.getCmp("mortgageproxyidtype").getValue() == "8")
                                                            {
                                                            	if(Ext.getCmp("mortgageproxyid").getValue() != "")
                                                            	{
                                                            		if(checkIdCard(Ext.getCmp("mortgageproxyid").getValue()) != true){
                                            							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("mortgageproxyid").getValue()));
                                            							return;
                                            						}
                                                            	}
                                                            }
                                                            if(Ext.getCmp("mortgageproxyhandleidtype").getValue() == "8")
                                                            {
                                                            	if(Ext.getCmp("mortgageproxyhandleid").getValue() != "")
                                                            	{
                                                            		if(checkIdCard(Ext.getCmp("mortgageproxyhandleid").getValue()) != true){
                                            							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("mortgageproxyhandleid").getValue()));
                                            							return;
                                            						}
                                                            	}
                                                            }
                                                        }
                                                        if (Ext.getCmp("mortgageownermentype").getGroupValue() == "委托代理人申请") {
                                                            if (Ext.getCmp("mortgageownerproxyusername").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][姓名].");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("mortgageownerproxylinktel").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][联系电话].");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("mortgageownerproxyidtype").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][身份证明类型].");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("mortgageownerproxyid").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][身份证明号码].");
                                                                return;
                                                            }
                                                            if(Ext.getCmp("mortgageownerproxyidtype").getValue() == "8")
                                                            {
                                                            	if(Ext.getCmp("mortgageownerproxyid").getValue() != "")
                                                            	{
                                                            		if(checkIdCard(Ext.getCmp("mortgageownerproxyid").getValue()) != true){
                                            							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("mortgageownerproxyid").getValue()));
                                            							return;
                                            						}
                                                            	}
                                                            }
                                                            if(Ext.getCmp("mortgageownerproxyhandleidtype").getValue() == "8")
                                                            {
                                                            	if(Ext.getCmp("mortgageownerproxyhandleid").getValue() != "")
                                                            	{
                                                            		if(checkIdCard(Ext.getCmp("mortgageownerproxyhandleid").getValue()) != true){
                                            							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("mortgageownerproxyhandleid").getValue()));
                                            							return;
                                            						}
                                                            	}
                                                            }
                                                            
                                                        }
                                                        var mortgagehandledatevar = null;
                                                        if (Ext.getCmp("mortgagehandledate").getValue() != null && Ext.getCmp("mortgagehandledate").getValue() != "") {
                                                            mortgagehandledatevar = Ext.util.Format.date(Ext.getCmp("mortgagehandledate").getValue(), 'Y-m-d');
                                                        }
                                                        var mortgageownerhandledatevar = null;
                                                        if (Ext.getCmp("mortgageownerhandledate").getValue() != null && Ext.getCmp("mortgageownerhandledate").getValue() != "") {
                                                            mortgageownerhandledatevar = Ext.util.Format.date(Ext.getCmp("mortgageownerhandledate").getValue(), 'Y-m-d');
                                                        }
                                                        var mortgageproxyhandledatevar = null;
                                                        if (Ext.getCmp("mortgageproxyhandledate").getValue() != null && Ext.getCmp("mortgageproxyhandledate").getValue() != "") {
                                                            mortgageproxyhandledatevar = Ext.util.Format.date(Ext.getCmp("mortgageproxyhandledate").getValue(), 'Y-m-d');
                                                        }
                                                        var mortgageownerproxyhandledatevar = null;
                                                        if (Ext.getCmp("mortgageownerproxyhandledate").getValue() != null && Ext.getCmp("mortgageownerproxyhandledate").getValue() != "") {
                                                            mortgageownerproxyhandledatevar = Ext.util.Format.date(Ext.getCmp("mortgageownerproxyhandledate").getValue(), 'Y-m-d');
                                                        }
                                                        Ext.Ajax.request({
                                                            url: "main/mortgage.html?action=addMortgage",
                                                            method: "post",
                                                            success: function() {
                                                                Ext.MessageBox.alert("提示", "抵押登记成功.");
                                                                Ext.getCmp("mortgageWin").close();
                                                                Ext.getCmp("mortgageMgr").getStore().reload();
                                                            },
                                                            failure: function() {
                                                                Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                            },
                                                            params: {
                                                                tractorinfoid: result.reson.id,
                                                                tractorcode: Ext.getCmp("tractorcode").getValue(),
                                                                tractorno: Ext.getCmp("tractorno").getValue(),
                                                                tractoraddress: Ext.getCmp("tractoraddress").getValue(),
                                                                mortgagetype: Ext.getCmp("mortgagetype").getGroupValue(),
                                                                mortgagementype: Ext.getCmp("mortgagementype").getGroupValue(),
                                                                mortgageownermentype: Ext.getCmp("mortgageownermentype").getGroupValue(),
                                                                mortgageusername: Ext.getCmp("mortgageusername").getValue(),
                                                                mortgageaddress: Ext.getCmp("mortgageaddress").getValue(),
                                                                mortgageistemplive: Ext.getCmp("mortgageistemplive").getValue(),
                                                                mortgagecaridtype: Ext.getCmp("mortgagecaridtype").getValue(),
                                                                mortgagecarid: Ext.getCmp("mortgagecarid").getValue(),
                                                                mortgagelinktel: Ext.getCmp("mortgagelinktel").getValue(),
                                                                mortgagezipcode: Ext.getCmp("mortgagezipcode").getValue(),
                                                                mortgagehandledate: mortgagehandledatevar,
                                                                mortgageownerusername: Ext.getCmp("mortgageownerusername").getValue(),
                                                                mortgageowneraddress: Ext.getCmp("mortgageowneraddress").getValue(),
                                                                mortgageisownertemplive: Ext.getCmp("mortgageisownertemplive").getValue(),
                                                                mortgageownercaridtype: Ext.getCmp("mortgageownercaridtype").getValue(),
                                                                mortgageownercarid: Ext.getCmp("mortgageownercarid").getValue(),
                                                                mortgageownerlinktel: Ext.getCmp("mortgageownerlinktel").getValue(),
                                                                mortgageownerzipcode: Ext.getCmp("mortgageownerzipcode").getValue(),
                                                                mortgageownerhandledate: mortgageownerhandledatevar,
                                                                mortgageinformation: Ext.getCmp("mortgageinformation").getValue(),
                                                                mortgageproxyusername: Ext.getCmp("mortgageproxyusername").getValue(),
                                                                mortgageproxylinktel: Ext.getCmp("mortgageproxylinktel").getValue(),
                                                                mortgageproxyaddress: Ext.getCmp("mortgageproxyaddress").getValue(),
                                                                mortgageproxyidtype: Ext.getCmp("mortgageproxyidtype").getValue(),
                                                                mortgageproxyid: Ext.getCmp("mortgageproxyid").getValue(),
                                                                mortgageproxyhandlename: Ext.getCmp("mortgageproxyhandlename").getValue(),
                                                                mortgageproxyhandleidtype: Ext.getCmp("mortgageproxyhandleidtype").getValue(),
                                                                mortgageproxyhandleid: Ext.getCmp("mortgageproxyhandleid").getValue(),
                                                                mortgageproxyhandleaddress: Ext.getCmp("mortgageproxyhandleaddress").getValue(),
                                                                mortgageproxyhandledate: mortgageproxyhandledatevar,
                                                                mortgageownerproxyusername: Ext.getCmp("mortgageownerproxyusername").getValue(),
                                                                mortgageownerproxylinktel: Ext.getCmp("mortgageownerproxylinktel").getValue(),
                                                                mortgageownerproxyaddress: Ext.getCmp("mortgageownerproxyaddress").getValue(),
                                                                mortgageownerproxyidtype: Ext.getCmp("mortgageownerproxyidtype").getValue(),
                                                                mortgageownerproxyid: Ext.getCmp("mortgageownerproxyid").getValue(),
                                                                mortgageownerproxyhandlename: Ext.getCmp("mortgageownerproxyhandlename").getValue(),
                                                                mortgageownerproxyhandleidtype: Ext.getCmp("mortgageownerproxyhandleidtype").getValue(),
                                                                mortgageownerproxyhandleid: Ext.getCmp("mortgageownerproxyhandleid").getValue(),
                                                                mortgageownerproxyhandleaddress: Ext.getCmp("mortgageownerproxyhandleaddress").getValue(),
                                                                mortgageownerproxyhandledate: mortgageownerproxyhandledatevar
                                                            }
                                                        });
                                                    }
                                                },
                                                {
                                                    text: "取消",
                                                    handler: function() {
                                                        Ext.getCmp("mortgageWin").close();
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
                        if (selections[i].data.checkstate != 0 && selections[i].data.checkstate != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过审核】的信息进行上报！");
                            return;
                        }
                    }
                    var mortgageids = "";
                    for (i = 0; i < n; i++) {
                        if (mortgageids.length == 0) {
                            mortgageids = mortgageids + selections[i].data.id;
                        } else {
                            mortgageids = mortgageids + "," + selections[i].data.id;
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
                                    url: "main/mortgage.html?action=ReportedMortgage",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("mortgageMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reportmortgageids: mortgageids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
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
                    if (selections[0].data.checkstate != 0 && selections[0].data.checkstate != 3) {
                        Ext.MessageBox.alert("提示", "只能对【待报、审核未通过】的数据进行编辑！");
                        return
                    }
                    new Ext.Window({
                        id: "updatemortgageWin",
                        title: "修改抵押登记事项",
                        iconCls: 'icon-Add',
                        resizable: false,
                        modal: true,
                        height: 550,
                        width: 700,
                        items: [{
                            xtype: 'tabpanel',
                            border: false,
                            frame: true,
                            activeTab: 0,
                            items: [{
                                id: "mortgagepanel",
                                title: '抵押人/抵押权人信息',
                                frame: true,
                                bodyStyle: "padding:5px 5px",
                                autoScroll: true,
                                height: 520,
                                layout: "column",
                                items: [{
                                    columnWidth: .33,
                                    layout: "form",
                                    labelWidth: 60,
                                    baseCls: "x-plain",
                                    items: [{
                                        id: "updatetractorcode",
                                        xtype: "textfield",
                                        fieldLabel: "号牌号码",
                                        anchor: '98%',
                                        readOnly: true,
                                        value: selections[0].data.platecode + "." + selections[0].data.license
                                    }]
                                },
                                {
                                    columnWidth: .33,
                                    layout: "form",
                                    labelWidth: 85,
                                    baseCls: "x-plain",
                                    items: [{
                                        id: "updatetractorno",
                                        xtype: "textfield",
                                        fieldLabel: "登记证书编号",
                                        anchor: '98%',
                                        readOnly: true,
                                        value: selections[0].data.regcerno
                                    }]
                                },
                                {
                                    columnWidth: .33,
                                    layout: "form",
                                    labelWidth: 60,
                                    baseCls: "x-plain",
                                    items: [{
                                        id: "updatetractoraddress",
                                        xtype: "textfield",
                                        fieldLabel: "管辖地",
                                        anchor: '98%',
                                        readOnly: true,
                                        value: selections[0].data.region
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    layout: "column",
                                    baseCls: "x-plain",
                                    items: [{
                                        columnWidth: .5,
                                        layout: "form",
                                        items: [{
                                            id: "updatemortgagetype",
                                            name: "updatemortgagetypegroup",
                                            xtype: "radio",
                                            fieldLabel: "申请登记种类",
                                            boxLabel: "抵押登记",
                                            anchor: '98%',
                                            inputValue: "抵押登记"
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "fit",
                                        items: [{
                                            name: "updatemortgagetypegroup",
                                            xtype: "radio",
                                            boxLabel: "注销抵押登记",
                                            anchor: '98%',
                                            inputValue: "注销抵押登记"
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    id: "updatemortgageinfo",
                                    title: "抵押人",
                                    xtype: "fieldset",
                                    height: 130,
                                    layout: "column",
                                    items: [{
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageusername",
                                            xtype: "textfield",
                                            fieldLabel: "姓名",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageusername
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageaddress",
                                            xtype: "textfield",
                                            fieldLabel: "住所地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageaddress
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageistemplive",
                                            xtype: "textfield",
                                            fieldLabel: "暂住地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageistemplive
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgagelinktel",
                                            xtype: "textfield",
                                            fieldLabel: "联系电话",
                                            anchor: '98%',
                                            value: selections[0].data.mortgagelinktel
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgagecaridtype",
                                            xtype: "combo",
                                            fieldLabel: "身份证明类型",
                                            anchor: '98%',
                                            displayField: 'realcertificatetype',
                                            valueField: 'id',
                                            typeAhead: true,
                                            mode: 'remote',
                                            editable: false,
                                            selectOnFoucs: true,
                                            triggerAction: 'all',
                                            store: Ynzc.manage.Certificate,
                                            value: selections[0].data.mortgagecaridtype
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgagecarid",
                                            xtype: "textfield",
                                            fieldLabel: "身份证明号码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgagecarid
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgagezipcode",
                                            xtype: "textfield",
                                            fieldLabel: "邮政编码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgagezipcode
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgagehandledate",
                                            xtype: "datefield",
                                            fieldLabel: "经手时间",
                                            format: "Y-m-d",
                                            anchor: '98%',
                                            value: new Date(selections[0].data.mortgagehandledate.time).format("Y-m-d")
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    id: "mortgageownerinfo",
                                    title: "抵押权人",
                                    xtype: "fieldset",
                                    height: 130,
                                    layout: "column",
                                    items: [{
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerusername",
                                            xtype: "textfield",
                                            fieldLabel: "姓名",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerusername
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageowneraddress",
                                            xtype: "textfield",
                                            fieldLabel: "住所地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageowneraddress
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageisownertemplive",
                                            xtype: "textfield",
                                            fieldLabel: "暂住地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageisownertemplive
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerlinktel",
                                            xtype: "textfield",
                                            fieldLabel: "联系电话",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerlinktel
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownercaridtype",
                                            xtype: "combo",
                                            fieldLabel: "身份证明类型",
                                            anchor: '98%',
                                            displayField: 'realcertificatetype',
                                            valueField: 'id',
                                            typeAhead: true,
                                            mode: 'remote',
                                            editable: false,
                                            selectOnFoucs: true,
                                            triggerAction: 'all',
                                            store: Ynzc.manage.Certificate,
                                            value: selections[0].data.mortgageownercaridtype
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownercarid",
                                            xtype: "textfield",
                                            fieldLabel: "身份证明号码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownercarid
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerzipcode",
                                            xtype: "textfield",
                                            fieldLabel: "邮政编码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerzipcode
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerhandledate",
                                            xtype: "datefield",
                                            fieldLabel: "经手时间",
                                            format: "Y-m-d",
                                            anchor: '98%',
                                            value: new Date(selections[0].data.mortgageownerhandledate.time).format("Y-m-d")
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    layout: "form",
                                    labelWidth: 60,
                                    baseCls: "x-plain",
                                    items: [{
                                        id: "updatemortgageinformation",
                                        xtype: "textfield",
                                        fieldLabel: "相关资料",
                                        anchor: '98%',
                                        value: selections[0].data.mortgageinformation
                                    }]
                                }]
                            },
                            {
                                title: '抵押人/抵押权人代理人信息',
                                frame: true,
                                bodyStyle: "padding:5px 5px",
                                autoScroll: true,
                                height: 520,
                                layout: "column",
                                items: [{
                                    columnWidth: 1,
                                    id: "updatetypeinfo",
                                    title: "申请方式",
                                    xtype: "fieldset",
                                    height: 50,
                                    layout: "column",
                                    items: [{
                                        columnWidth: .25,
                                        layout: "form",
                                        labelWidth: 50,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgagementype",
                                            name: "updatemortgagementypegroup",
                                            xtype: "radio",
                                            boxLabel: "本人申请",
                                            fieldLabel: "抵押人",
                                            inputValue: "本人申请"
                                        }]
                                    },
                                    {
                                        columnWidth: .25,
                                        layout: "fit",
                                        baseCls: "x-plain",
                                        items: [{
                                            name: "updatemortgagementypegroup",
                                            xtype: "radio",
                                            boxLabel: "委托代理人申请",
                                            inputValue: "委托代理人申请"
                                        }]
                                    },
                                    {
                                        columnWidth: .25,
                                        layout: "form",
                                        labelWidth: 60,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownermentype",
                                            name: "updatemortgageownermentypegroup",
                                            xtype: "radio",
                                            boxLabel: "本人申请",
                                            fieldLabel: "抵押权人",
                                            inputValue: "本人申请"
                                        }]
                                    },
                                    {
                                        columnWidth: .25,
                                        layout: "fit",
                                        baseCls: "x-plain",
                                        items: [{
                                            name: "updatemortgageownermentypegroup",
                                            xtype: "radio",
                                            boxLabel: "委托代理人申请",
                                            inputValue: "委托代理人申请"
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    id: "updatemortgageproxyinfo",
                                    title: "抵押人的代理人",
                                    xtype: "fieldset",
                                    height: 180,
                                    layout: "column",
                                    items: [{
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyusername",
                                            xtype: "textfield",
                                            fieldLabel: "姓名",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxyusername
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxylinktel",
                                            xtype: "textfield",
                                            fieldLabel: "联系电话",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxylinktel
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyidtype",
                                            xtype: "combo",
                                            fieldLabel: "身份证明类型",
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
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyid",
                                            xtype: "textfield",
                                            fieldLabel: "身份证明号码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxyid
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyaddress",
                                            xtype: "textfield",
                                            fieldLabel: "暂住地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxyaddress
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyhandlename",
                                            xtype: "textfield",
                                            fieldLabel: "经办人姓名",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxyhandlename
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyhandleidtype",
                                            xtype: "combo",
                                            fieldLabel: "经办人身份证明名称",
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
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyhandleid",
                                            xtype: "textfield",
                                            fieldLabel: "经办人身份证明号码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxyhandleid
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyhandleaddress",
                                            xtype: "textfield",
                                            fieldLabel: "经办人住所地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageproxyhandleaddress
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageproxyhandledate",
                                            xtype: "datefield",
                                            fieldLabel: "经办人签字时间",
                                            format: "Y-m-d",
                                            anchor: '98%'
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    id: "updatemortgageownerproxyinfo",
                                    title: "抵押权人的代理人",
                                    xtype: "fieldset",
                                    height: 180,
                                    layout: "column",
                                    items: [{
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyusername",
                                            xtype: "textfield",
                                            fieldLabel: "姓名",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxyusername
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxylinktel",
                                            xtype: "textfield",
                                            fieldLabel: "联系电话",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxylinktel
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyidtype",
                                            xtype: "combo",
                                            fieldLabel: "身份证明类型",
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
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyid",
                                            xtype: "textfield",
                                            fieldLabel: "身份证明号码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxyid
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyaddress",
                                            xtype: "textfield",
                                            fieldLabel: "暂住地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxyaddress
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyhandlename",
                                            xtype: "textfield",
                                            fieldLabel: "经办人姓名",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxyhandlename
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyhandleidtype",
                                            xtype: "combo",
                                            fieldLabel: "经办人身份证明名称",
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
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyhandleid",
                                            xtype: "textfield",
                                            fieldLabel: "经办人身份证明号码",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxyhandleid
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyhandleaddress",
                                            xtype: "textfield",
                                            fieldLabel: "经办人住所地址",
                                            anchor: '98%',
                                            value: selections[0].data.mortgageownerproxyhandleaddress
                                        }]
                                    },
                                    {
                                        columnWidth: .5,
                                        layout: "form",
                                        labelWidth: 90,
                                        baseCls: "x-plain",
                                        items: [{
                                            id: "updatemortgageownerproxyhandledate",
                                            xtype: "datefield",
                                            fieldLabel: "经办人签字时间",
                                            format: "Y-m-d",
                                            anchor: '98%'
                                        }]
                                    }]
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
                                if (Ext.getCmp("updatemortgagetype").getGroupValue() == null) {
                                    Ext.MessageBox.alert("提示", "请选择登记种类.");
                                    return;
                                }
                                if (Ext.getCmp("updatemortgageusername").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写抵押人信息[姓名/名称].");
                                    return;
                                }
                                if (Ext.getCmp("updatemortgageaddress").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写抵押人信息[住所地址].");
                                    return;
                                }
                                if (Ext.getCmp("updatemortgagecaridtype").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写抵押人信息[身份证明类型].");
                                    return;
                                }
                                if (Ext.getCmp("updatemortgagecarid").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写抵押人信息[身份证明号码].");
                                    return;
                                }
                                if(Ext.getCmp("updatemortgagecaridtype").getValue() == "8")
                                {
                                	if(Ext.getCmp("updatemortgagecarid").getValue() != "")
                                	{
                                		if(checkIdCard(Ext.getCmp("updatemortgagecarid").getValue()) != true){
                							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatemortgagecarid").getValue()));
                							return;
                						}
                                	}
                                }
                                if(Ext.getCmp("updatemortgageownercaridtype").getValue() == "8")
                                {
                                	if(Ext.getCmp("updatemortgageownercarid").getValue() != "")
                                	{
                                		if(checkIdCard(Ext.getCmp("updatemortgageownercarid").getValue()) != true){
                							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatemortgageownercarid").getValue()));
                							return;
                						}
                                	}
                                }
                                if (Ext.getCmp("updatemortgagementype").getGroupValue() == null) {
                                    Ext.MessageBox.alert("提示", "请选择抵押 人 申请方式");
                                    return;
                                }
                                if (Ext.getCmp("updatemortgageownermentype").getGroupValue() == null) {
                                    Ext.MessageBox.alert("提示", "请选择抵押 权人 申请方式");
                                    return;
                                }
                                if (Ext.getCmp("updatemortgagementype").getGroupValue() == "委托代理人申请") {
                                    if (Ext.getCmp("updatemortgageproxyusername").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][姓名].");
                                        return;
                                    }
                                    if (Ext.getCmp("updatemortgageproxylinktel").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][联系电话].");
                                        return;
                                    }
                                    if (Ext.getCmp("updatemortgageproxyidtype").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][身份证明类型].");
                                        return;
                                    }
                                    if (Ext.getCmp("updatemortgageproxyid").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押人[委托代理人][身份证明号码].");
                                        return;
                                    }
                                    if(Ext.getCmp("updatemortgageproxyidtype").getValue() == "8")
                                    {
                                    	if(Ext.getCmp("updatemortgageproxyid").getValue() != "")
                                    	{
                                    		if(checkIdCard(Ext.getCmp("updatemortgageproxyid").getValue()) != true){
                    							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatemortgageproxyid").getValue()));
                    							return;
                    						}
                                    	}
                                    }
                                    if(Ext.getCmp("updatemortgageproxyhandleidtype").getValue() == "8")
                                    {
                                    	if(Ext.getCmp("updatemortgageproxyhandleid").getValue() != "")
                                    	{
                                    		if(checkIdCard(Ext.getCmp("updatemortgageproxyhandleid").getValue()) != true){
                    							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatemortgageproxyhandleid").getValue()));
                    							return;
                    						}
                                    	}
                                    }
                                }
                                if (Ext.getCmp("updatemortgageownermentype").getGroupValue() == "委托代理人申请") {
                                    if (Ext.getCmp("updatemortgageownerproxyusername").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][姓名].");
                                        return;
                                    }
                                    if (Ext.getCmp("updatemortgageownerproxylinktel").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][联系电话].");
                                        return;
                                    }
                                    if (Ext.getCmp("updatemortgageownerproxyidtype").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][身份证明类型].");
                                        return;
                                    }
                                    if (Ext.getCmp("updatemortgageownerproxyid").getValue() == "") {
                                        Ext.MessageBox.alert("提示", "请填写抵押权人[委托代理人][身份证明号码].");
                                        return;
                                    }
                                    if(Ext.getCmp("updatemortgageownerproxyidtype").getValue() == "8")
                                    {
                                    	if(Ext.getCmp("updatemortgageownerproxyid").getValue() != "")
                                    	{
                                    		if(checkIdCard(Ext.getCmp("updatemortgageownerproxyid").getValue()) != true){
                    							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatemortgageownerproxyid").getValue()));
                    							return;
                    						}
                                    	}
                                    }
                                    if(Ext.getCmp("updatemortgageownerproxyhandleidtype").getValue() == "8")
                                    {
                                    	if(Ext.getCmp("updatemortgageownerproxyhandleid").getValue() != "")
                                    	{
                                    		if(checkIdCard(Ext.getCmp("updatemortgageownerproxyhandleid").getValue()) != true){
                    							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("updatemortgageownerproxyhandleid").getValue()));
                    							return;
                    						}
                                    	}
                                    }
                                }
                                var updatemortgagehandledatevar = null;
                                if (Ext.getCmp("updatemortgagehandledate").getValue() != null && Ext.getCmp("updatemortgagehandledate").getValue() != "") {
                                    updatemortgagehandledatevar = Ext.util.Format.date(Ext.getCmp("updatemortgagehandledate").getValue(), 'Y-m-d');
                                }
                                var updatemortgageownerhandledatevar = null;
                                if (Ext.getCmp("updatemortgageownerhandledate").getValue() != null && Ext.getCmp("updatemortgageownerhandledate").getValue() != "") {
                                    updatemortgageownerhandledatevar = Ext.util.Format.date(Ext.getCmp("updatemortgageownerhandledate").getValue(), 'Y-m-d');
                                }
                                var updatemortgageproxyhandledatevar = null;
                                if (Ext.getCmp("updatemortgageproxyhandledate").getValue() != null && Ext.getCmp("updatemortgageproxyhandledate").getValue() != "") {
                                    updatemortgageproxyhandledatevar = Ext.util.Format.date(Ext.getCmp("updatemortgageproxyhandledate").getValue(), 'Y-m-d');
                                }
                                var updatemortgageownerproxyhandledatevar = null;
                                if (Ext.getCmp("updatemortgageownerproxyhandledate").getValue() != null && Ext.getCmp("updatemortgageownerproxyhandledate").getValue() != "") {
                                    updatemortgageownerproxyhandledatevar = Ext.util.Format.date(Ext.getCmp("updatemortgageownerproxyhandledate").getValue(), 'Y-m-d');
                                }
                                var checkdatevar = null;
                                if (selections[0].data.checkdate != null && selections[0].data.checkdate != "") {
                                    checkdatevar = new Date(selections[0].data.checkdate.time).format('Y-m-d');
                                }
                                Ext.Ajax.request({
                                    url: "main/mortgage.html?action=updateMortgage",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "修改成功.");
                                        Ext.getCmp("updatemortgageWin").close();
                                        Ext.getCmp("mortgageMgr").getStore().reload();
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        id: selections[0].data.id,
                                        tractorinfoid: selections[0].data.tractorinfoId,
                                        tractorcode: Ext.getCmp("updatetractorcode").getValue(),
                                        tractorno: Ext.getCmp("updatetractorno").getValue(),
                                        tractoraddress: Ext.getCmp("updatetractoraddress").getValue(),
                                        mortgagetype: Ext.getCmp("updatemortgagetype").getGroupValue(),
                                        mortgagementype: Ext.getCmp("updatemortgagementype").getGroupValue(),
                                        mortgageownermentype: Ext.getCmp("updatemortgageownermentype").getGroupValue(),
                                        mortgageusername: Ext.getCmp("updatemortgageusername").getValue(),
                                        mortgageaddress: Ext.getCmp("updatemortgageaddress").getValue(),
                                        mortgageistemplive: Ext.getCmp("updatemortgageistemplive").getValue(),
                                        mortgagecaridtype: Ext.getCmp("updatemortgagecaridtype").getValue(),
                                        mortgagecarid: Ext.getCmp("updatemortgagecarid").getValue(),
                                        mortgagelinktel: Ext.getCmp("updatemortgagelinktel").getValue(),
                                        mortgagezipcode: Ext.getCmp("updatemortgagezipcode").getValue(),
                                        mortgagehandledate: updatemortgagehandledatevar,
                                        mortgageownerusername: Ext.getCmp("updatemortgageownerusername").getValue(),
                                        mortgageowneraddress: Ext.getCmp("updatemortgageowneraddress").getValue(),
                                        mortgageisownertemplive: Ext.getCmp("updatemortgageisownertemplive").getValue(),
                                        mortgageownercaridtype: Ext.getCmp("updatemortgageownercaridtype").getValue(),
                                        mortgageownercarid: Ext.getCmp("updatemortgageownercarid").getValue(),
                                        mortgageownerlinktel: Ext.getCmp("updatemortgageownerlinktel").getValue(),
                                        mortgageownerzipcode: Ext.getCmp("updatemortgageownerzipcode").getValue(),
                                        mortgageownerhandledate: updatemortgageownerhandledatevar,
                                        mortgageinformation: Ext.getCmp("updatemortgageinformation").getValue(),
                                        mortgageproxyusername: Ext.getCmp("updatemortgageproxyusername").getValue(),
                                        mortgageproxylinktel: Ext.getCmp("updatemortgageproxylinktel").getValue(),
                                        mortgageproxyaddress: Ext.getCmp("updatemortgageproxyaddress").getValue(),
                                        mortgageproxyidtype: Ext.getCmp("updatemortgageproxyidtype").getValue(),
                                        mortgageproxyid: Ext.getCmp("updatemortgageproxyid").getValue(),
                                        mortgageproxyhandlename: Ext.getCmp("updatemortgageproxyhandlename").getValue(),
                                        mortgageproxyhandleidtype: Ext.getCmp("updatemortgageproxyhandleidtype").getValue(),
                                        mortgageproxyhandleid: Ext.getCmp("updatemortgageproxyhandleid").getValue(),
                                        mortgageproxyhandleaddress: Ext.getCmp("updatemortgageproxyhandleaddress").getValue(),
                                        mortgageproxyhandledate: updatemortgageproxyhandledatevar,
                                        mortgageownerproxyusername: Ext.getCmp("updatemortgageownerproxyusername").getValue(),
                                        mortgageownerproxylinktel: Ext.getCmp("updatemortgageownerproxylinktel").getValue(),
                                        mortgageownerproxyaddress: Ext.getCmp("updatemortgageownerproxyaddress").getValue(),
                                        mortgageownerproxyidtype: Ext.getCmp("updatemortgageownerproxyidtype").getValue(),
                                        mortgageownerproxyid: Ext.getCmp("updatemortgageownerproxyid").getValue(),
                                        mortgageownerproxyhandlename: Ext.getCmp("updatemortgageownerproxyhandlename").getValue(),
                                        mortgageownerproxyhandleidtype: Ext.getCmp("updatemortgageownerproxyhandleidtype").getValue(),
                                        mortgageownerproxyhandleid: Ext.getCmp("updatemortgageownerproxyhandleid").getValue(),
                                        mortgageownerproxyhandleaddress: Ext.getCmp("updatemortgageownerproxyhandleaddress").getValue(),
                                        mortgageownerproxyhandledate: updatemortgageownerproxyhandledatevar,
                                        checkmen: selections[0].data.checkmen,
                                        checkstate: selections[0].data.checkstate,
                                        checkcontent: selections[0].data.checkcontent,
                                        checkdate: checkdatevar,
                                        checkip: selections[0].data.checkip,
                                        opertator: selections[0].data.opertator,
                                        operatedate: new Date(selections[0].data.operatedate.time).format('Y-m-d')
                                    }
                                });
                            }
                        }]
                    }).show();
                    if (selections[0].data.mortgagetype != null && selections[0].data.mortgagetype == "抵押登记") {
                        Ext.getCmp("mortgagepanel").items.items[3].items.items[0].items.items[0].setValue(true);
                    } else {
                        Ext.getCmp("mortgagepanel").items.items[3].items.items[1].items.items[0].setValue(true);
                    }
                    if (selections[0].data.mortgagementype != null && selections[0].data.mortgagementype == "本人申请") {
                        Ext.getCmp("updatetypeinfo").items.items[0].items.items[0].setValue(true);
                    } else {
                        Ext.getCmp("updatetypeinfo").items.items[1].items.items[0].setValue(true);
                    }
                    if (selections[0].data.mortgageownermentype != null && selections[0].data.mortgageownermentype == "本人申请") {
                        Ext.getCmp("updatetypeinfo").items.items[2].items.items[0].setValue(true);
                    } else {
                        Ext.getCmp("updatetypeinfo").items.items[3].items.items[0].setValue(true);
                    }
                    if (selections[0].data.mortgageproxyhandledate != null && selections[0].data.mortgageproxyhandledate != "") {
                        Ext.getCmp("updatemortgageproxyhandledate").setValue(new Date(selections[0].data.mortgageproxyhandledate.time).format("Y-m-d"));
                    }
                    if (selections[0].data.mortgageownerproxyhandledate != null && selections[0].data.mortgageownerproxyhandledate != "") {
                        Ext.getCmp("updatemortgageownerproxyhandledate").setValue(new Date(selections[0].data.mortgageownerproxyhandledate.time).format("Y-m-d"));
                    }
                    if (selections[0].data.mortgageproxyidtype != null && selections[0].data.mortgageproxyidtype != "0") {
                        Ext.getCmp("updatemortgageproxyidtype").setValue(selections[0].data.mortgageproxyidtype);
                    }
                    if (selections[0].data.mortgageproxyhandleidtype != null && selections[0].data.mortgageproxyhandleidtype != "0") {
                        Ext.getCmp("updatemortgageproxyhandleidtype").setValue(selections[0].data.mortgageproxyhandleidtype);
                    }
                    if (selections[0].data.mortgageownerproxyidtype != null && selections[0].data.mortgageownerproxyidtype != "0") {
                        Ext.getCmp("updatemortgageownerproxyidtype").setValue(selections[0].data.mortgageownerproxyidtype);
                    }
                    if (selections[0].data.mortgageownerproxyhandleidtype != null && selections[0].data.mortgageownerproxyhandleidtype != "0") {
                        Ext.getCmp("updatemortgageownerproxyhandleidtype").setValue(selections[0].data.mortgageownerproxyhandleidtype);
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
                    var delmortgageids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkresult != 2) {
                            updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
                        }
                        if (delmortgageids.length == 0) {
                            delmortgageids = delmortgageids + selections[i].data.id;
                        } else {
                            delmortgageids = delmortgageids + "," + selections[i].data.id;
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
                                    url: "main/mortgage.html?action=delMortgage",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("mortgageMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        mydelmortgageids: delmortgageids,
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
                            id: "searchMortgageData",
                            fieldLabel: "申请方式",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            value: '--请选择--',
                            store: Ynzc.manage.MortgageData,
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                        	Ext.getCmp("mortgageMgr").getStore().reload({
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
                                        mortgagetype: Ext.getCmp("searchMortgageData").getValue()
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
	        					sourceURL:'main/mortgage.html?action=mortgageInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            },{
            text: "打印拖拉机抵押/注销抵押登记申请表",
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
	                        wordType:"tractorMortgageApplication",
                        	cnWord:"拖拉机抵押/注销抵押登记申请表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'拖拉机抵押/注销抵押登记申请表',
	        					sourceURL:'main/mortgage.html?action=PrintMortgageReport',
	        					params:{id:selections[0].data.id,wordType:'tractorMortgageApplication'}
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
        Ynzc.manage.MortgageGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });
    }
});
Ext.reg('mortgagegrid', Ynzc.manage.MortgageGrid);