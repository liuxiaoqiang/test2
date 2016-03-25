Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.CarChangeGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'carchangegrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{tractorinfoplantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '</table>')
        });
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '业务类型',
            sortable: true,
            dataIndex: "changeType"
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
            dataIndex: "tractorinfoplantType"
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
            header: '变更业务登记人',
            sortable: true,
            dataIndex: "applicationmen"
        },
        {
            header: '状态',
            sortable: true,
            dataIndex: "approvalstate",
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
            dataIndex: "approvalmen"
        },
        {
            header: '审核时间',
            sortable: true,
            dataIndex: "approvaltime",
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
                name: 'tractorinfoId'
            },
            {
                name: 'changeType'
            },
            {
                name: 'applicationmen'
            },
            {
                name: 'applicationtime'
            },
            {
                name: 'applicationip'
            },
            {
                name: 'approvalmen'
            },
            {
                name: 'approvaltime'
            },
            {
                name: 'approvalstate'
            },
            {
                name: 'approvalip'
            },
            {
                name: 'approvacontext'
            },
            {
                name: 'changecolorid'
            },
            {
                name: 'orgincolor'
            },
            {
                name: 'cuurentcolor'
            },
            {
                name: 'changecolorphotourl'
            },
            {
                name: 'changeengineid'
            },
            {
                name: 'changeenginecode'
            },
            {
                name: 'changeenginefueltype'
            },
            {
                name: 'enginebrand'
            },
            {
                name: 'cylindernumber'
            },
            {
                name: 'changeenginepower'
            },
            {
                name: 'newenginecode'
            },
            {
                name: 'newfueltype'
            },
            {
                name: 'newenginebrand'
            },
            {
                name: 'newcylindernumber'
            },
            {
                name: 'newpower'
            },
            {
                name: 'engineproof'
            },
            {
                name: 'engineproofnumber'
            },
            {
                name: 'changetrailerid'
            },
            {
                name: 'orgintires'
            },
            {
                name: 'orgintrack'
            },
            {
                name: 'orginnorm'
            },
            {
                name: 'currenttires'
            },
            {
                name: 'currenttrack'
            },
            {
                name: 'currentnorm'
            },
            {
                name: 'changeownerid'
            },
            {
                name: 'orginusername'
            },
            {
                name: 'orginlintel'
            },
            {
                name: 'orgincertificateid'
            },
            {
                name: 'orgincertificatecode'
            },
            {
                name: 'orginunittype'
            },
            {
                name: 'orginaddress'
            },
            {
                name: 'orginzipcode'
            },
            {
                name: 'orginistemporary'
            },
            {
                name: 'orgintemporaycertificate'
            },
            {
                name: 'orgintemporaycertificatecode'
            },
            {
                name: 'username'
            },
            {
                name: 'lintel'
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
                name: 'currentaddress'
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
                name: 'changebodyid'
            },
            {
                name: 'orgingettypeid'
            },
            {
                name: 'orginmachinetypeid'
            },
            {
                name: 'orginengineid'
            },
            {
                name: 'orginbodycode'
            },
            {
                name: 'orginenginecode'
            },
            {
                name: 'orginrackcode'
            },
            {
                name: 'orginusernature'
            },
            {
                name: 'orginfactoryname'
            },
            {
                name: 'orginsaleunit'
            },
            {
                name: 'orginreleasedate'
            },
            {
                name: 'orginprice'
            },
            {
                name: 'orginphotourl'
            },
            {
                name: 'orgingetwayfiletypeid'
            },
            {
                name: 'orgingetwayfiletypecode'
            },
            {
                name: 'orginimportsfiletypeid'
            },
            {
                name: 'orginimportsfiletypecode'
            },
            {
                name: 'orginother'
            },
            {
                name: 'orgininsurancelistno'
            },
            {
                name: 'orgininsurancecompany'
            },
            {
                name: 'orgininsurancedate'
            },
            {
                name: 'orgininsurancevalidate'
            },
            {
                name: 'orginbodycolor'
            },
            {
                name: 'orginsize'
            },
            {
                name: 'orgindirectcontrol'
            },
            {
                name: 'orgincontainersize'
            },
            {
                name: 'orginenginebrandid'
            },
            {
                name: 'orginpower'
            },
            {
                name: 'orgincylinderno'
            },
            {
                name: 'orginfueltype'
            },
            {
                name: 'orginwheelno'
            },
            {
                name: 'orginwheelbase'
            },
            {
                name: 'orgintiresno'
            },
            {
                name: 'orgintiressize'
            },
            {
                name: 'orginwheeldis'
            },
            {
                name: 'orgintotalquality'
            },
            {
                name: 'orginallquality'
            },
            {
                name: 'orginratifiedload'
            },
            {
                name: 'orginallowdragtotalquality'
            },
            {
                name: 'orgindriverinno'
            },
            {
                name: 'orginsteelspring'
            },
            {
                name: 'orginvicecartiresno'
            },
            {
                name: 'orginoutcarwheeldis'
            },
            {
                name: 'orginoutcartiressize'
            },
            {
                name: 'gettypeid'
            },
            {
                name: 'machinetypeid'
            },
            {
                name: 'engineid'
            },
            {
                name: 'bodycode'
            },
            {
                name: 'enginecode'
            },
            {
                name: 'rackcode'
            },
            {
                name: 'usernature'
            },
            {
                name: 'factoryname'
            },
            {
                name: 'saleunit'
            },
            {
                name: 'releasedate'
            },
            {
                name: 'price'
            },
            {
                name: 'photourl'
            },
            {
                name: 'getwayfiletypeid'
            },
            {
                name: 'getwayfiletypecode'
            },
            {
                name: 'importsfiletypeid'
            },
            {
                name: 'importsfiletypecode'
            },
            {
                name: 'other'
            },
            {
                name: 'insurancelistno'
            },
            {
                name: 'insurancecompany'
            },
            {
                name: 'insurancedate'
            },
            {
                name: 'insurancevalidate'
            },
            {
                name: 'bodycolor'
            },
            {
                name: 'size'
            },
            {
                name: 'directcontrol'
            },
            {
                name: 'containersize'
            },
            {
                name: 'enginebrandid'
            },
            {
                name: 'power'
            },
            {
                name: 'cylinderno'
            },
            {
                name: 'fueltypeid'
            },
            {
                name: 'wheelno'
            },
            {
                name: 'wheelbase'
            },
            {
                name: 'tiresno'
            },
            {
                name: 'tiressize'
            },
            {
                name: 'wheeldis'
            },
            {
                name: 'totalquality'
            },
            {
                name: 'allquality'
            },
            {
                name: 'ratifiedload'
            },
            {
                name: 'allowdragtotalquality'
            },
            {
                name: 'driverinno'
            },
            {
                name: 'steelspring'
            },
            {
                name: 'vicecartiresno'
            },
            {
                name: 'outcarwheeldis'
            },
            {
                name: 'outcartiressize'
            },
            {
                name: 'templivefileType'
            },
            {
                name: 'getway'
            },
            {
                name: 'machinetype'
            },
            {
                name: 'plantType'
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
            url: 'main/carChange.html?action=getAllCarChangeListByPage',
            reader: reader,
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'carchangegrid',
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
                id: "carchange",
                text: "业务处理",
                iconCls: "icon-Add",
                handler: function() {
                    var win = new Ext.Window({
                        id: "typeUpdatewin",
                        title: "车辆变更",
                        modal: true,
                        height: 150,
                        width: 315,
                        resizable : false,
                        layout: "column",
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            columnWidth: .2,
                            layout: "fit",
                            baseCls: "x-plain",
                            items: [{
                                xtype: "label",
                                html: PlateNumHead + ".&nbsp;&nbsp;"
                            }]
                        },
                        {
                            columnWidth: .8,
                            height: 30,
                            baseCls: "x-plain",
                            items: [{
                                id: 'codenum',
                                xtype: "textfield",
                                anchor: '100%'
                            }]
                        },
                        {
                            columnWidth: 1,
                            layout: "form",
                            baseCls: "x-plain",
                            labelWidth: 55,
                            items: [{
                                id: "changetype",
                                fieldLabel: "变更类型",
                                xtype: "combo",
                                displayField: 'displayvalue',
                                valueField: 'value',
                                typeAhead: true,
                                mode: 'local',
                                editable: false,
                                selectOnFoucs: true,
                                triggerAction: 'all',
                                value: '共同所有的拖拉机变更拖拉机所有人',
                                store: Ynzc.manage.ChangeTypeStore,
                                anchor: '98%'
                            }]
                        }],
                        buttons: [{
                            text: "下一步",
                            handler: function() {
                        	    var licensenum = Ext.getCmp("codenum").getValue();
                                if (Ext.getCmp("codenum").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请输入要变更的号牌号码!");
                                    return
                                }
                                Ext.Ajax.request({
                                    url: 'main/tractorInfoView.html?action=IsExits',
                                    method: "post",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            var type = Ext.getCmp("changetype").getValue();
                                            Ext.getCmp("typeUpdatewin").close();
                                            if (type == "共同所有的拖拉机变更拖拉机所有人") {
                                                var changeownerWin = new Ext.Window({
                                                    id: "changeownerWin",
                                                    title: type,
                                                    modal: true,
                                                    height: 420,
                                                    width: 500,
                                                    layout: "form",
                                                    labelWidth: 80,
                                                    bodyStyle: "padding:5px 5px",
                                                    items: [{
                                                        id: "orginOwnerInfo",
                                                        title: "原所有人信息",
                                                        xtype: "fieldset",
                                                        height: 160,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orginusername",
                                                                xtype: "textfield",
                                                                fieldLabel: "姓名",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.owner
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orginlintel",
                                                                xtype: "textfield",
                                                                fieldLabel: "联系电话",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.telephone
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orgincertificateid",
                                                                xtype: "textfield",
                                                                fieldLabel: "身份证明名称",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.realcertificatetype
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orgincertificatecode",
                                                                xtype: "textfield",
                                                                fieldLabel: "证件号码",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.realcertificateno
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orginunittype",
                                                                xtype: "textfield",
                                                                fieldLabel: "单位/个人",
                                                                anchor: "98%",
                                                                readOnly: true
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orginaddress",
                                                                xtype: "textfield",
                                                                fieldLabel: "住所地址",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.tempaddress
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orginzipcode",
                                                                xtype: "textfield",
                                                                fieldLabel: "邮政编码",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.zipCode
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orginistemporary",
                                                                xtype: "textfield",
                                                                fieldLabel: "是否暂住",
                                                                anchor: "98%",
                                                                readOnly: true
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orgintemporaycertificate",
                                                                xtype: "textfield",
                                                                fieldLabel: "暂住证明名称",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.templivefileType
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "orgintemporaycertificatecode",
                                                                xtype: "textfield",
                                                                fieldLabel: "暂住证号码",
                                                                anchor: "98%",
                                                                readOnly: true,
                                                                value: result.reson.timplivefileno
                                                            }]
                                                        }]
                                                    },
                                                    {
                                                        id: "currentOwnerInfo",
                                                        title: "现所有人信息",
                                                        xtype: "fieldset",
                                                        height: 155,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "username",
                                                                xtype: "textfield",
                                                                fieldLabel: "姓名",
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "lintel",
                                                                xtype: "textfield",
                                                                fieldLabel: "联系电话",
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "certificateid",
                                                                fieldLabel: "身份证明名称",
                                                                anchor: "98%",
                                                                xtype: "combo",
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
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "certificatecode",
                                                                xtype: "textfield",
                                                                fieldLabel: "证件号码",
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "unittype",
                                                                xtype: "combo",
                                                                fieldLabel: "单位/个人",
                                                                displayField: 'displayvalue',
                                                                valueField: 'value',
                                                                typeAhead: true,
                                                                mode: 'local',
                                                                editable: false,
                                                                selectOnFoucs: true,
                                                                triggerAction: 'all',
                                                                value: 0,
                                                                store: Ynzc.manage.UOrPStore,
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "address",
                                                                xtype: "textfield",
                                                                fieldLabel: "住所地址",
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "zipcode",
                                                                xtype: "textfield",
                                                                fieldLabel: "邮政编码",
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "istemporary",
                                                                xtype: "combo",
                                                                fieldLabel: "是否暂住",
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
                                                                },
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "temporaycertificate",
                                                                xtype: "combo",
                                                                fieldLabel: "暂住证明名称",
                                                                displayField: 'templivefileType',
                                                                valueField: 'id',
                                                                typeAhead: true,
                                                                mode: 'remote',
                                                                selectOnFoucs: true,
                                                                triggerAction: 'all',
                                                                disabled:true,
                                                                store: Ynzc.manage.TempliveFile,
                                                                anchor: "98%"
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "temporaycertificatecode",
                                                                xtype: "textfield",
                                                                fieldLabel: "暂住证号码",
                                                                disabled:true,
                                                                anchor: "98%"
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
                                                        text: "提交变更",
                                                        handler: function() {
                                                            if (Ext.getCmp("username").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "清填写姓名");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("lintel").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "清填写联系电话");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("certificateid").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "清选择身份证明名称");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("certificatecode").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "清填写证件号码");
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
                                                            var temporaycertificatevar=0;
                                                            if(Ext.getCmp("temporaycertificate").getValue()!=""){
                                                            	temporaycertificatevar=Ext.getCmp("temporaycertificate").getValue();
                                                            }
                                                            Ext.Ajax.request({
                                                                url: "main/carChange.html?action=addCarChange",
                                                                method: "post",
                                                                success: function() {
                                                                    Ext.MessageBox.alert("提示", "提交成功.");
                                                                    Ext.getCmp("changeownerWin").close();
                                                                    Ext.getCmp("changeMgr").getStore().reload();
                                                                },
                                                                failure: function() {
                                                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                                },
                                                                params: {
                                                                    tractorinfoId: result.reson.id,
                                                                    changeType: type,
                                                                    changeowner: "{orginusername:'" + result.reson.owner + "',orginlintel:'" + result.reson.telephone + "',orgincertificateid:'" + result.reson.realcertificatetype + "',orgincertificatecode:'" + result.reson.realcertificateno + "',orginunittype:'" + Ext.getCmp("orginunittype").getValue() + "',Orginaddress:'" + result.reson.tempaddress + "',Orginzipcode:'" + result.reson.zipCode + "',orginistemporary:'" + Ext.getCmp("orginistemporary").getValue() + "',orgintemporaycertificate:'" + result.reson.templivefileType + "',orgintemporaycertificatecode:'" + result.reson.timplivefileno + "',username:'" + Ext.getCmp("username").getValue() + "',lintel:'" + Ext.getCmp("lintel").getValue() + "',certificateid:" + Ext.getCmp("certificateid").getValue() + ",certificatecode:'" + Ext.getCmp("certificatecode").getValue() + "',unittype:" + Ext.getCmp("unittype").getValue() + ",address:'" + Ext.getCmp("address").getValue() + "',zipcode:'" + Ext.getCmp("zipcode").getValue() + "',istemporary:" + Ext.getCmp("istemporary").getValue() + ",temporaycertificate:" + temporaycertificatevar + ",temporaycertificatecode:'" + Ext.getCmp("temporaycertificatecode").getValue() + "'}"
                                                                }
                                                            });
                                                        }
                                                    },
                                                    {
                                                        text: "取消",
                                                        handler: function() {
                                                            Ext.getCmp("changeownerWin").close();
                                                        }
                                                    }]
                                                }).show();
                                                if (result.reson.isUnion == "0") {
                                                    Ext.getCmp("orginunittype").setValue("个人");
                                                } else {
                                                    Ext.getCmp("orginunittype").setValue("单位");
                                                }
                                                if (result.reson.istemplived == "0") {
                                                    Ext.getCmp("orginistemporary").setValue("常住人口");
                                                } else {
                                                    Ext.getCmp("orginistemporary").setValue("暂住人口");
                                                }
                                            } else if (type == "变更机身颜色") {
                                                var changecolorwin = new Ext.Window({
                                                    id: "changecolorwin",
                                                    title: type,
                                                    modal: true,
                                                    height: 380,
                                                    width: 330,
                                                    layout: "form",
                                                    labelWidth: 80,
                                                    bodyStyle: "padding:5px 5px",
                                                    items: [{
                                                        id: "photourl",
                                                        xtype: "picpanel",
                                                        defaultPicUrl: "./Public/Images/sys/noupload.gif",
                                                        actionUrl: "main/tractorInfo.html?action=uploadPic",
                                                        uploadWinTitle: "拖拉机照片",
                                                        height: 250,
                                                        width: 300
                                                    },
                                                    {
                                                        id: "orgincolor",
                                                        xtype: "textfield",
                                                        fieldLabel: "原机身颜色",
                                                        readOnly: true,
                                                        anchor: '98%',
                                                        value: result.reson.machinebodycolor
                                                    },
                                                    {
                                                        id: "cuurentcolor",
                                                        xtype: "textfield",
                                                        fieldLabel: "现机身颜色",
                                                        anchor: '98%'
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
                                                        text: "提交变更",
                                                        handler: function() {
                                                            if (Ext.getCmp("photourl").getValue() == null) {
                                                                Ext.MessageBox.alert("提示", "请上传拖拉机图片.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("cuurentcolor").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写变更颜色.");
                                                                return;
                                                            }
                                                            Ext.Ajax.request({
                                                                url: "main/carChange.html?action=addCarChange",
                                                                method: "post",
                                                                success: function() {
                                                                    Ext.MessageBox.alert("提示", "保存成功.");
                                                                    Ext.getCmp("changecolorwin").close();
                                                                    Ext.getCmp("changeMgr").getStore().reload();
                                                                },
                                                                failure: function() {
                                                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                                },
                                                                params: {
                                                                    tractorinfoId: result.reson.id,
                                                                    changeType: type,
                                                                    changecolor: "{orgincolor:'" + result.reson.machinebodycolor + "',cuurentcolor:'" + Ext.getCmp("cuurentcolor").getValue() + "',photourl:'" + Ext.getCmp("photourl").getValue() + "'}"
                                                                }
                                                            });
                                                        }
                                                    }]
                                                }).show();
                                                Ext.getCmp("photourl").setValue(result.reson.photourl);
                                            } else if (type == "更换发动机") {
                                                var changeEngineWin = new Ext.Window({
                                                    id: "changeEngineWin",
                                                    title: type,
                                                    modal: true,
                                                    height: 370,
                                                    width: 500,
                                                    layout: "form",
                                                    labelWidth: 80,
                                                    bodyStyle: "padding:5px 5px",
                                                    items: [{
                                                        id: "orginEngineInfo",
                                                        title: "原发动机情况",
                                                        xtype: "fieldset",
                                                        height: 100,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "enginecode",
                                                                xtype: "textfield",
                                                                fieldLabel: "发动机号",
                                                                readOnly: true,
                                                                value: result.reson.engineno,
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "fueltype",
                                                                xtype: "textfield",
                                                                fieldLabel: "燃料种类",
                                                                readOnly: true,
                                                                value: result.reson.fuelname,
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "enginebrand",
                                                                xtype: "textfield",
                                                                fieldLabel: "发动机品牌",
                                                                readOnly: true,
                                                                value: result.reson.engineBrand,
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "cylindernumber",
                                                                xtype: "textfield",
                                                                fieldLabel: "缸数",
                                                                readOnly: true,
                                                                value: result.reson.cylinderno,
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "power",
                                                                xtype: "textfield",
                                                                fieldLabel: "功率",
                                                                readOnly: true,
                                                                value: result.reson.power,
                                                                anchor: '98%'
                                                            }]
                                                        }]
                                                    },
                                                    {
                                                        id: "currentEngineInfo",
                                                        title: "现发动机情况",
                                                        xtype: "fieldset",
                                                        height: 160,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "newenginecode",
                                                                xtype: "textfield",
                                                                fieldLabel: "发动机号",
                                                                value: result.reson.engineno,
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "newfueltype",
                                                                xtype: "combo",
                                                                fieldLabel: "燃料种类",
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
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "newcylindernumber",
                                                                xtype: "combo",
                                                                fieldLabel: "缸数",
                                                                displayField: 'display',
                                                                valueField: 'value',
                                                                typeAhead: true,
                                                                mode: 'local',
                                                                editable: false,
                                                                selectOnFoucs: true,
                                                                triggerAction: 'all',
                                                                store: Ynzc.manage.CylinderStore,
                                                                value: result.reson.cylinderno,
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "newpower",
                                                                xtype: "textfield",
                                                                fieldLabel: "功率",
                                                                anchor: '98%',
                                                                listeners: {
                                                                    "focus": function() {
                                                                        new Ext.Window({
                                                                            id: "newpowerwin",
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
                                                                                        id: "newv",
                                                                                        xtype: "textfield",
                                                                                        anchor: "98%"
                                                                                    }]
                                                                                },
                                                                                {
                                                                                    columnWidth: .15,
                                                                                    items: [{
                                                                                        id: "newVunit",
                                                                                        xtype: "label",
                                                                                        html: "CM³"
                                                                                    }]
                                                                                },
                                                                                {
                                                                                    columnWidth: .35,
                                                                                    items: [{
                                                                                        id: "newk",
                                                                                        xtype: "textfield",
                                                                                        anchor: "98%"
                                                                                    }]
                                                                                },
                                                                                {
                                                                                    columnWidth: .15,
                                                                                    items: [{
                                                                                        id: "newKW",
                                                                                        xtype: "label",
                                                                                        html: "KW"
                                                                                    }]
                                                                                }]
                                                                            }],
                                                                            buttons: [{
                                                                                text: "确定",
                                                                                handler: function() {
                                                                                    if (Ext.getCmp("newv").getValue() == "" || Ext.getCmp("newk").getValue() == "") {
                                                                                        Ext.MessageBox.alert("提示", "录入的数据不完整，请检查!");
                                                                                        return;
                                                                                    } else {
                                                                                        var res = Ext.getCmp("newv").getValue() + "CM³/" + Ext.getCmp("newk").getValue() + "KW";
                                                                                        Ext.getCmp("newpower").setValue(res);
                                                                                        Ext.getCmp("newpowerwin").close();
                                                                                    }
                                                                                }
                                                                            }]
                                                                        }).show(Ext.getCmp("newpower").getEl());
                                                                        if (Ext.getCmp("newpower").getValue() != "") {
                                                                            var r1 = Ext.getCmp("newpower").getValue().split("CM³/");
                                                                            Ext.getCmp("newv").setValue(r1[0]);
                                                                            Ext.getCmp("newk").setValue(r1[1].substring(0, r1[1].length - 2));
                                                                        }
                                                                    }
                                                                }
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 120,
                                                            items: [{
                                                                id: "newenginebrand",
                                                                xtype: "textfield",
                                                                fieldLabel: "发动机品牌",
                                                                xtype: "ebcombo",
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 120,
                                                            items: [{
                                                                id: "engineproof",
                                                                xtype: "textfield",
                                                                fieldLabel: "发动机来历证明",
                                                                anchor: '98%'
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: "form",
                                                            baseCls: "x-plain",
                                                            labelWidth: 120,
                                                            items: [{
                                                                id: "engineproofnumber",
                                                                xtype: "textfield",
                                                                fieldLabel: "发动机合格证明编号",
                                                                anchor: '98%'
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
                                                        text: "提交变更",
                                                        handler: function() {
                                                            if (Ext.getCmp("newenginecode").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写发动机号.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("newfueltype").getValue() === "") {
                                                                Ext.MessageBox.alert("提示", "请选择燃料种类.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("newenginebrand").getValue() === "") {
                                                                Ext.MessageBox.alert("提示", "请选择发动机品牌.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("newcylindernumber").getValue() === "") {
                                                                Ext.MessageBox.alert("提示", "请选择缸数.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("newpower").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写功率.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("engineproof").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写发动机来历证明.");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("engineproofnumber").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写发动机合格证明编号.");
                                                                return;
                                                            }
                                                            Ext.Ajax.request({
                                                                url: "main/carChange.html?action=addCarChange",
                                                                method: "post",
                                                                success: function() {
                                                                    Ext.MessageBox.alert("提示", "保存成功");
                                                                    Ext.getCmp("changeEngineWin").close();
                                                                    Ext.getCmp("changeMgr").getStore().reload();
                                                                },
                                                                failure: function() {
                                                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                                },
                                                                params: {
                                                                    tractorinfoId: result.reson.id,
                                                                    changeType: type,
                                                                    changeengine: "{enginecode:'" + result.reson.engineno + "',fueltype:'" + result.reson.fuelname + "',enginebrand:'" + result.reson.engineBrand + "',cylindernumber:'" + result.reson.cylinderno + "',power:'" + result.reson.power + "',newenginecode:'" + Ext.getCmp("newenginecode").getValue() + "',newfueltype:" + Ext.getCmp("newfueltype").getValue() + ",newenginebrand:" + Ext.getCmp("newenginebrand").getMyValue() + ",newcylindernumber:'" + Ext.getCmp("newcylindernumber").getValue() + "',newpower:'" + Ext.getCmp("newpower").getValue() + "',engineproof:'" + Ext.getCmp("engineproof").getValue() + "',engineproofnumber:'" + Ext.getCmp("engineproofnumber").getValue() + "'}"
                                                                }
                                                            });
                                                        }
                                                    },
                                                    {
                                                        text: "取消",
                                                        handler: function() {
                                                            Ext.getCmp("changeEngineWin").close();
                                                        }
                                                    }]
                                                }).show();
                                                if(result.reson.fueltypeid!=null && result.reson.fueltypeid!="0"){
                                                	Ext.getCmp("newfueltype").setValue(result.reson.fueltypeid);
                                                }
                                            } else if (type == "更换挂车") {
                                                var changeTrailerWin = new Ext.Window({
                                                    id: "changeTrailerWin",
                                                    title: type,
                                                    modal: true,
                                                    height: 310,
                                                    width: 500,
                                                    layout: "form",
                                                    labelWidth: 80,
                                                    bodyStyle: "padding:5px 5px",
                                                    items: [{
                                                        id: "orginTrailerInfo",
                                                        title: "原挂车情况",
                                                        xtype: "fieldset",
                                                        height: 100,
                                                        layout: "form",
                                                        items: [{
                                                            id: "orgintires",
                                                            xtype: "textfield",
                                                            fieldLabel: "挂车轮胎数",
                                                            readOnly: true,
                                                            value: result.reson.vicecartiresno,
                                                            anchor: '98%'
                                                        },
                                                        {
                                                            id: "orgintrack",
                                                            xtype: "textfield",
                                                            fieldLabel: "挂车轮距",
                                                            readOnly: true,
                                                            value: result.reson.outcarwheeldis,
                                                            anchor: '98%'
                                                        },
                                                        {
                                                            id: "orginnorm",
                                                            xtype: "textfield",
                                                            fieldLabel: "挂车轮胎规格",
                                                            readOnly: true,
                                                            value: result.reson.outcartiressize,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        id: "currentTrailerInfo",
                                                        title: "现挂车情况",
                                                        xtype: "fieldset",
                                                        height: 100,
                                                        layout: "form",
                                                        items: [{
                                                            id: "currenttires",
                                                            xtype: "textfield",
                                                            fieldLabel: "挂车轮胎数",
                                                            anchor: '98%'
                                                        },
                                                        {
                                                            id: "currenttrack",
                                                            xtype: "textfield",
                                                            fieldLabel: "挂车轮距",
                                                            anchor: '98%'
                                                        },
                                                        {
                                                            id: "currentnorm",
                                                            xtype: "textfield",
                                                            fieldLabel: "挂车轮胎规格",
                                                            anchor: '98%'
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
                                                        text: "提交变更",
                                                        handler: function() {
                                                            if (Ext.getCmp("currenttires").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写挂车轮胎数");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("currenttrack").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写挂车轮距");
                                                                return;
                                                            }
                                                            if (Ext.getCmp("currentnorm").getValue() == "") {
                                                                Ext.MessageBox.alert("提示", "请填写挂车轮轮胎规格");
                                                                return;
                                                            }
                                                            Ext.Ajax.request({
                                                                url: "main/carChange.html?action=addCarChange",
                                                                method: "post",
                                                                success: function() {
                                                                    Ext.MessageBox.alert("提示", "保存成功");
                                                                    Ext.getCmp("changeTrailerWin").close();
                                                                    Ext.getCmp("changeMgr").getStore().reload();
                                                                },
                                                                failure: function() {
                                                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                                },
                                                                params: {
                                                                    tractorinfoId: result.reson.id,
                                                                    changeType: type,
                                                                    changetrailer: "{orgintires:" + result.reson.vicecartiresno + ",orgintrack:'" + result.reson.outcarwheeldis + "',orginnorm:'" + result.reson.outcartiressize + "',currenttires:" + Ext.getCmp("currenttires").getValue() + ",currenttrack:'" + Ext.getCmp("currenttrack").getValue() + "',currentnorm:'" + Ext.getCmp("currentnorm").getValue() + "'}"
                                                                }
                                                            });
                                                        }
                                                    },
                                                    {
                                                        text: "取消",
                                                        handler: function() {
                                                            Ext.getCmp("changeTrailerWin").close();
                                                        }
                                                    }]
                                                }).show();
                                            } else {
                                                var changeBodyWin = new Ext.Window({
                                                    id: "changeBodyWin",
                                                    title: type,
                                                    iconCls: 'icon-Add',
                                                    resizable: false,
                                                    modal: true,
                                                    height: 400,
                                                    width: 700,
                                                    items: [{
                                                        xtype: 'tabpanel',
                                                        border: false,
                                                        frame: true,
                                                        activeTab: 0,
                                                        items: [{
                                                            title: '拖拉机基本信息',
                                                            frame: true,
                                                            bodyStyle: "padding:5px 5px",
                                                            autoScroll: true,
                                                            height: 375,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 90,
                                                                items: [{
                                                                    id: "getwayid",
                                                                    fieldLabel: "获取方式",
                                                                    xtype: "combo",
                                                                    mode: "remote",
                                                                    displayField: 'getway',
                                                                    valueField: 'id',
                                                                    typeAhead: true,
                                                                    editable: false,
                                                                    selectOnFoucs: true,
                                                                    triggerAction: 'all',
                                                                    store: Ynzc.manage.GetWay,
                                                                    anchor: '98%',
                                                                    value: result.reson.getwayid
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
                                                                    anchor: '98%',
                                                                    value: result.reson.machinetypeid
                                                                },
                                                                {
                                                                    id: "manufacturer",
                                                                    fieldLabel: "制造厂名称",
                                                                    xtype: "textfield",
                                                                    anchor: '98%',
                                                                    value: result.reson.manufacturer
                                                                },
                                                                {
                                                                    id: "usedfor",
                                                                    fieldLabel: "使用性质",
                                                                    xtype: "combo",
                                                                    displayField: 'display',
                                                                    valueField: 'value',
                                                                    typeAhead: true,
                                                                    mode: 'local',
                                                                    editable: false,
                                                                    selectOnFoucs: true,
                                                                    triggerAction: 'all',
                                                                    store: Ynzc.manage.UsedFor,
                                                                    anchor: '98%',
                                                                    value: result.reson.usedfor
                                                                },
                                                                {
                                                                    id: "machinebodyno",
                                                                    fieldLabel: "机身(底盘)号码",
                                                                    xtype: "textfield",
                                                                    anchor: '98%',
                                                                    value: result.reson.machinebodyno
                                                                },
                                                                {
                                                                    id: "engineno",
                                                                    fieldLabel: "发动机号码",
                                                                    xtype: "textfield",
                                                                    anchor: '98%',
                                                                    value: result.reson.engineno
                                                                },
                                                                {
                                                                    id: "shelfno",
                                                                    fieldLabel: "挂机架号码",
                                                                    xtype: "textfield",
                                                                    anchor: '98%',
                                                                    value: result.reson.shelfno
                                                                }]
                                                            },
                                                            {
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelwidth: 90,
                                                                items: [{
                                                                    id: "myphotourl",
                                                                    xtype: "picpanel",
                                                                    defaultPicUrl: "./Public/Images/sys/noupload.gif",
                                                                    actionUrl: "main/tractorInfo.html?action=uploadPic",
                                                                    uploadWinTitle: "拖拉机照片",
                                                                    height: 200,
                                                                    width: 340
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
                                                                    anchor: '100%',
                                                                    value: result.reson.price
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
                                                                    anchor: '100%',
                                                                    value: result.reson.seller
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            title: '相关资料',
                                                            frame: true,
                                                            bodyStyle: "padding:5px 5px",
                                                            autoScroll: true,
                                                            height: 375,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .5,
                                                                layout: "form",
                                                                labelWidth: 80,
                                                                items: [{
                                                                    id: "getwayfiletypeid",
                                                                    fieldLabel: "来历凭证类型",
                                                                    xtype: "combo",
                                                                    displayField: 'getWayFileType',
                                                                    valueField: 'id',
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
                                                                    anchor: '100%',
                                                                    value:result.reson.getwayfileno
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
                                                                    anchor: '100%',
                                                                    value: result.reson.importsfileno
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
                                                                            anchor: '98%',
                                                                            value: result.reson.insurancelistno
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
                                                                            anchor: '98%',
                                                                            value: result.reson.insurancecompanyname
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
                                                                            xtype: "datefield",
                                                                            format: "Y-m-d",
                                                                            anchor: '98%'
                                                                        }]
                                                                    }]
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            title: '技术参数',
                                                            frame: true,
                                                            bodyStyle: "padding:5px 5px",
                                                            autoScroll: true,
                                                            height: 375,
                                                            layout: "column",
                                                            items: [{
                                                                columnWidth: .33,
                                                                layout: "form",
                                                                labelWidth: 85,
                                                                items: [{
                                                                    id: "machinebodycolor",
                                                                    fieldLabel: "机身颜色",
                                                                    xtype: "textfield",
                                                                    anchor: '98%',
                                                                    value: result.reson.machinebodycolor
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
                                                                    value: result.reson.outsize,
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
                                                                    value: result.reson.containersize,
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
                                                                    anchor: '98%',
                                                                    value: result.reson.directcontrol
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
                                                                    anchor: '98%',
                                                                    value: result.reson.steelspring
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
                                                                    value: result.reson.power,
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
                                                                    value: result.reson.cylinderno,
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
                                                                    value: result.reson.fueltypeid,
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
                                                                    value: result.reson.wheelno,
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
                                                                    value: result.reson.wheelbase,
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
                                                                    value: result.reson.tiresno,
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
                                                                    value: result.reson.tiressize,
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
                                                                    value: result.reson.wheeldis,
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
                                                                    value: result.reson.totalquality,
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
                                                                    value: result.reson.allquality,
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
                                                                    value: result.reson.ratifiedload,
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
                                                                    value: result.reson.allowdragtotalquality,
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
                                                                    value: result.reson.driverinno,
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
                                                                    value: result.reson.vicecartiresno,
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
                                                                    value: result.reson.outcarwheeldis,
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
                                                                    value: result.reson.outcartiressize,
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
                                                        text: "提交变更",
                                                        handler: function() {
                                                        	 if (Ext.getCmp("getwayid").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请选择获取方式.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("machinetypeid").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请选择机械类型.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("manufacturer").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写制造厂名称.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("usedfor").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请选择使用性质.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("machinebodyno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请选择机身(底盘)号码.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("engineno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写发动机号码.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("shelfno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写挂机架号码.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("myphotourl").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请上传拖拉机图片.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("manufacturedate").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写出厂日期.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("price").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写销售/交易价格.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("machinebrandtypeid").getMyValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请选择品牌型号.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("seller").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写销售(交易市场)名称.");
                                                                 return;
                                                             }
                                                        	 if (Ext.getCmp("insurancelistno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写保单号.");
                                                                 return;
                                                             }
                                                        	 
                                                        	 if (Ext.getCmp("insurancecompanyname").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请选择保险公司.");
                                                                 return;
                                                             } if (Ext.getCmp("insurancedate").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写保险日期.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("expirydate").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写保险有效期.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("machinebodycolor").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写机身颜色.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("outsize").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写外廓尺寸.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("containersize").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写货箱内部尺寸.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("directcontrol").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写转向形式.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("steelspring").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写钢板弹簧片数.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("power").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写功率.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("cylinderno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写缸数.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("fueltypeid").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写燃料种类.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("wheelno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写轴数.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("wheelbase").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写轴距.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("tiresno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写轮胎数.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("tiressize").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写轮胎规格.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("wheeldis").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写轮距.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("totalquality").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写总质量.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("allquality").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写整备质量.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("ratifiedload").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写核定载质量.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("allowdragtotalquality").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写准牵引总质量.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("driverinno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写驾驶室载人数.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("vicecartiresno").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写挂车轮胎数.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("outcarwheeldis").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写挂车轮距.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("outcartiressize").getValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写挂车轮胎规格.");
                                                                 return;
                                                             }
                                                             if (Ext.getCmp("enginebrandid").getMyValue() == "") {
                                                                 Ext.MessageBox.alert("提示", "请填写发动机品牌.");
                                                                 return;
                                                             }
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
                                                            var getwayfiletypeidvar=0;
                                                            var importsfiletypeidvar=0;
                                                            if(Ext.getCmp("getwayfiletypeid").getValue()!=""){
                                                            	getwayfiletypeidvar=Ext.getCmp("getwayfiletypeid").getValue();
                                                            }
                                                            if(Ext.getCmp("importsfiletypeid").getValue()!=""){
                                                            	importsfiletypeidvar=Ext.getCmp("importsfiletypeid").getValue();
                                                            }
                                                            Ext.Ajax.request({
                                                                url: "main/carChange.html?action=addCarChange",
                                                                method: "post",
                                                                success: function() {
                                                                    Ext.MessageBox.alert("提示", "保存成功");
                                                                    Ext.getCmp("changeBodyWin").close();
                                                                    Ext.getCmp("changeMgr").getStore().reload();
                                                                },
                                                                failure: function() {
                                                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                                },
                                                                params: {
                                                                    tractorinfoId: result.reson.id,
                                                                    changeType: type,
                                                                    changebody: "{orgingettypeid:'" + result.reson.getway + "',orginmachinetypeid:'" + result.reson.machinetype + "',orginengineid:'" + result.reson.machinebrandtypeid + "',orginbodycode:'" + result.reson.machinebodyno + "',orginenginecode:'" + result.reson.engineno + "',orginrackcode:'" + result.reson.shelfno + "',orginusernature:'" + result.reson.usedfor + "',orginfactoryname:'" + result.reson.manufacturer + "',orginsaleunit:'" + result.reson.seller + "',orginreleasedate:'" + result.reson.manufacturedate + "',orginprice:'" + result.reson.price + "',orginphotourl:'" + result.reson.photourl + "',orgingetwayfiletypeid:'" + result.reson.getWayFileType + "',orgingetwayfiletypecode:'" + result.reson.getwayfileno + "',orginimportsfiletypeid:'" + result.reson.importsFileType + "',orginimportsfiletypecode:'" + result.reson.importsfileno + "',orginother:'" + result.reson.other + "',orgininsurancelistno:'" + result.reson.insurancelistno + "',orgininsurancecompany:'" + result.reson.insurancecompanyname + "',orgininsurancedate:'" + result.reson.insurancedate + "',orgininsurancevalidate:'" + result.reson.expirydate + "',orginbodycolor:'" + result.reson.machinebodycolor + "',orginsize:'" + result.reson.outsize + "',orgindirectcontrol:'" + result.reson.directcontrol + "',orgincontainersize:'" + result.reson.containersize + "',orginenginebrandid:'" + result.reson.engineBrand + "',orginpower:'" + result.reson.power + "',orgincylinderno:'" + result.reson.cylinderno + "',orginfueltypeid:'" + result.reson.fuelname + "',orginwheelno:'" + result.reson.wheelno + "',orginwheelbase:'" + result.reson.wheelbase + "',orgintiresno:" + result.reson.tiresno + ",orgintiressize:'" + result.reson.tiressize + "',orginwheeldis:'" + result.reson.wheeldis + "',orgintotalquality:'" + result.reson.totalquality + "',orginallquality:'" + result.reson.allquality + "',orginratifiedload:'" + result.reson.ratifiedload + "',orginallowdragtotalquality:'" + result.reson.allowdragtotalquality + "',orgindriverinno:" + result.reson.driverinno + ",orginsteelspring:'" + result.reson.steelspring + "',orginvicecartiresno:" + result.reson.vicecartiresno + ",orginoutcarwheeldis:'" + result.reson.outcarwheeldis + "',orginoutcartiressize:'" + result.reson.outcartiressize + "',gettypeid:" + Ext.getCmp("getwayid").getValue() + ",machinetypeid:" + Ext.getCmp("machinetypeid").getValue() + ",engineid:" + Ext.getCmp("machinebrandtypeid").getMyValue() + ",bodycode:'" + Ext.getCmp("machinebodyno").getValue() + "',enginecode:'" + Ext.getCmp("engineno").getValue() + "',rackcode:'" + Ext.getCmp("shelfno").getValue() + "',usernature:'" + Ext.getCmp("usedfor").getValue() + "',factoryname:'" + Ext.getCmp("manufacturer").getValue() + "',saleunit:'" + Ext.getCmp("seller").getValue() + "',releasedate:'" + Ext.util.Format.date(Ext.getCmp("manufacturedate").getValue(), 'Y-m-d') + "',price:'" + Ext.getCmp("price").getValue() + "',photourl:'" + Ext.getCmp("myphotourl").getValue() + "',getwayfiletypeid:" + getwayfiletypeidvar + ",getwayfiletypecode:'" + Ext.getCmp("getwayfileno").getValue() + "',importsfiletypeid:" +importsfiletypeidvar + ",importsfiletypecode:'" + Ext.getCmp("importsfileno").getValue() + "',other:'" + otherstr + "',insurancelistno:'" + Ext.getCmp("insurancelistno").getValue() + "',insurancecompany:'" + Ext.getCmp("insurancecompanyname").getValue() + "',insurancedate:'" + Ext.util.Format.date(Ext.getCmp("insurancedate").getValue(), 'Y-m-d') + "',insurancevalidate:'" + Ext.util.Format.date(Ext.getCmp("expirydate").getValue(), 'Y-m-d') + "',bodycolor:'" + Ext.getCmp("machinebodycolor").getValue() + "',size:'" + Ext.getCmp("outsize").getValue() + "',directcontrol:'" + Ext.getCmp("directcontrol").getValue() + "',containersize:'" + Ext.getCmp("containersize").getValue() + "',enginebrandid:" + Ext.getCmp("enginebrandid").getMyValue() + ",power:'" + Ext.getCmp("power").getValue() + "',cylinderno:'" + Ext.getCmp("cylinderno").getValue() + "',fueltypeid:" + Ext.getCmp("fueltypeid").getValue() + ",wheelno:'" + Ext.getCmp("wheelno").getValue() + "',wheelbase:'" + Ext.getCmp("wheelbase").getValue() + "',tiresno:" + Ext.getCmp("tiresno").getValue() + ",tiressize:'" + Ext.getCmp("tiressize").getValue() + "',wheeldis:'" + Ext.getCmp("wheeldis").getValue() + "',totalquality:'" + Ext.getCmp("totalquality").getValue() + "',allquality:'" + Ext.getCmp("allquality").getValue() + "',ratifiedload:'" + Ext.getCmp("ratifiedload").getValue() + "',allowdragtotalquality:'" + Ext.getCmp("allowdragtotalquality").getValue() + "',driverinno:" + Ext.getCmp("driverinno").getValue() + ",steelspring:'" + Ext.getCmp("steelspring").getValue() + "',vicecartiresno:" + Ext.getCmp("vicecartiresno").getValue() + ",outcarwheeldis:'" + Ext.getCmp("outcarwheeldis").getValue() + "',outcartiressize:'" + Ext.getCmp("outcartiressize").getValue() + "'}"
                                                                }
                                                            });
                                                        }
                                                    },
                                                    {
                                                        text: "取消",
                                                        handler: function() {
                                                            Ext.getCmp("changeBodyWin").close();
                                                        }
                                                    }]
                                                }).show();
                                                //变更整机完成
                                                Ext.getCmp("myphotourl").setValue(result.reson.photourl);
                                                Ext.getCmp("machinebrandtypeid").setMyValue(result.reson.machinebrandtypeid);
                                                var str = result.reson.other.split(",");
                                                for (i = 0; i < str.length; i++) {
                                                    if (str[i] == "国产拖拉机整车出厂合格证明") {
                                                        Ext.getCmp("otherOne").setValue(true);
                                                        continue;
                                                    };
                                                    if (str[i] == "拖拉机档案") {
                                                        Ext.getCmp("otherTwo").setValue(true);
                                                        continue;
                                                    };
                                                    if (str[i] == "身份证明") {
                                                        Ext.getCmp("otherThree").setValue(true);
                                                        continue;
                                                    };
                                                    if (str[i] == "《协助执行通知书》") {
                                                        Ext.getCmp("otherFour").setValue(true);
                                                        continue;
                                                    };
                                                    if (str[i] == "《公证书》") {
                                                        Ext.getCmp("otherFive").setValue(true);
                                                        continue;
                                                    };
                                                }
                                                
                                                if(result.reson.getwayfiletypeid!=null && result.reson.getwayfiletypeid!="0"){
                                                	Ext.getCmp("getwayfiletypeid").setValue(result.reson.getwayfiletypeid);
                                                }
                                                if(result.reson.importsfiletypeid!=null && result.reson.importsfiletypeid!="0"){
                                                	Ext.getCmp("importsfiletypeid").setValue(result.reson.importsfiletypeid);
                                                }
                                                if (result.reson.manufacturedate != null && result.reson.manufacturedate != "") {
                                                    Ext.getCmp("manufacturedate").setValue(new Date(result.reson.manufacturedate.time).format("Y-m-d"));
                                                }
                                                if (result.reson.insurancedate != null && result.reson.insurancedate != "") {
                                                    Ext.getCmp("insurancedate").setValue(new Date(result.reson.insurancedate.time).format('Y-m-d'));
                                                }
                                                if (result.reson.expirydate != null && result.reson.expirydate != "") {
                                                    Ext.getCmp("expirydate").setValue(new Date(result.reson.expirydate.time).format("Y-m-d"));
                                                }
                                                Ext.getCmp("enginebrandid").setMyValue(result.reson.enginebrandid); //发动机品牌 
                                            }
                                            //Ext.Msg.alert("提示",result.reson.address);
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
                    }).show(Ext.getCmp("carchange").getEl());
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
                        if (selections[i].data.approvalstate != 0 && selections[i].data.approvalstate != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过审核】的信息进行上报！");
                            return;
                        }
                    }
                    var carchangeIds = "";
                    for (i = 0; i < n; i++) {
                        if (carchangeIds.length == 0) {
                            carchangeIds = carchangeIds + selections[i].data.id;
                        } else {
                            carchangeIds = carchangeIds + "," + selections[i].data.id;
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
                                    url: "main/carChange.html?action=ReportedCarChange",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("changeMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reportcarchangeids: carchangeIds
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
                    if (selections[0].data.approvalstate != 0 && selections[0].data.approvalstate != 3) {
                        Ext.MessageBox.alert("提示", "只能对【待报、未通过】的数据进行编辑！");
                        return
                    }
                    Ynzc.manage.updatechangeid = selections[0].data.id;
                    if (selections[0].data.changeType == "变更机身颜色") {
                        new Ynzc.manage.ChangeColorEditWin().show();
                        Ynzc.manage.updatechangecolorid = selections[0].data.changecolorid;
                        Ynzc.manage.DetalisLicensenum = selections[0].data.license;
                        Ext.getCmp("updateorgincolor").setValue(selections[0].data.orgincolor);
                        Ext.getCmp("updatecuurentcolor").setValue(selections[0].data.cuurentcolor);
                        Ext.getCmp("updatephotourl").setValue(selections[0].data.changecolorphotourl);
                    } else if (selections[0].data.changeType == "共同所有的拖拉机变更拖拉机所有人") {
                        new Ynzc.manage.ChangeOwnerEditWin().show();
                        Ynzc.manage.updatechangeownerid = selections[0].data.changeownerid;
                        Ynzc.manage.DetalisLicensenum = selections[0].data.license;
                        Ext.getCmp("updateorginusername").setValue(selections[0].data.orginusername);
                        Ext.getCmp("updateorginlintel").setValue(selections[0].data.orginlintel);
                        Ext.getCmp("updateorgincertificateid").setValue(selections[0].data.orgincertificateid);
                        Ext.getCmp("updateorgincertificatecode").setValue(selections[0].data.orgincertificatecode);
                        Ext.getCmp("updateorginunittype").setValue(selections[0].data.orginunittype);
                        Ext.getCmp("updateorginaddress").setValue(selections[0].data.orginaddress);
                        Ext.getCmp("updateorginzipcode").setValue(selections[0].data.orginzipcode);
                        Ext.getCmp("updateorginistemporary").setValue(selections[0].data.orginistemporary);
                        Ext.getCmp("updateorgintemporaycertificate").setValue(selections[0].data.orgintemporaycertificate);
                        Ext.getCmp("updateorgintemporaycertificatecode").setValue(selections[0].data.orgintemporaycertificatecode);
                        Ext.getCmp("updateusername").setValue(selections[0].data.username);
                        Ext.getCmp("updatelintel").setValue(selections[0].data.lintel);
                        if(selections[0].data.certificateid!=null && selections[0].data.certificateid!="0"){
                        	Ext.getCmp("updatecertificateid").setValue(selections[0].data.certificateid);
                        }                        
                        Ext.getCmp("updatecertificatecode").setValue(selections[0].data.certificatecode);
                        Ext.getCmp("updateunittype").setValue(selections[0].data.unittype);
                        Ext.getCmp("updateaddress").setValue(selections[0].data.currentaddress);
                        Ext.getCmp("updatezipcode").setValue(selections[0].data.zipcode);
                        Ext.getCmp("updateistemporary").setValue(selections[0].data.istemporary);
                        if(selections[0].data.temporaycertificate!=null && selections[0].data.temporaycertificate!="0"){
                        	Ext.getCmp("updatetemporaycertificate").setValue(selections[0].data.temporaycertificate);
                        }
                        
                        Ext.getCmp("updatetemporaycertificatecode").setValue(selections[0].data.temporaycertificatecode);
                    } else if (selections[0].data.changeType == "更换发动机") {
                        new Ynzc.manage.ChangeEngineEditWin().show();
                        Ynzc.manage.updatechangeengineid = selections[0].data.changeengineid;
                        Ynzc.manage.DetalisLicensenum = selections[0].data.license;
                        Ext.getCmp("updateenginecode").setValue(selections[0].data.changeenginecode);
                        Ext.getCmp("updadtefueltype").setValue(selections[0].data.changeenginefueltype);
                        Ext.getCmp("updateenginebrand").setValue(selections[0].data.enginebrand);
                        Ext.getCmp("updatecylindernumber").setValue(selections[0].data.cylindernumber);
                        Ext.getCmp("updatepower").setValue(selections[0].data.changeenginepower);
                        Ext.getCmp("updatenewenginecode").setValue(selections[0].data.newenginecode);
                        Ext.getCmp("updatenewfueltype").setValue(selections[0].data.newfueltype);
                        Ext.getCmp("updatenewenginebrand").setMyValue(selections[0].data.newenginebrand);
                        Ext.getCmp("updatenewcylindernumber").setValue(selections[0].data.newcylindernumber);
                        Ext.getCmp("updatenewpower").setValue(selections[0].data.newpower);
                        Ext.getCmp("updateengineproof").setValue(selections[0].data.engineproof);
                        Ext.getCmp("updateengineproofnumber").setValue(selections[0].data.engineproofnumber);
                    } else if (selections[0].data.changeType == "更换挂车") {
                        new Ynzc.manage.ChangeTrailerEditWin().show();
                        Ynzc.manage.updatechangetrailerid = selections[0].data.changetrailerid;
                        Ynzc.manage.DetalisLicensenum = selections[0].data.license;
                        Ext.getCmp("updateorgintires").setValue(selections[0].data.orgintires);
                        Ext.getCmp("updateorgintrack").setValue(selections[0].data.orgintrack);
                        Ext.getCmp("updateorginnorm").setValue(selections[0].data.orginnorm);
                        Ext.getCmp("updatecurrenttires").setValue(selections[0].data.currenttires);
                        Ext.getCmp("updatecurrenttrack").setValue(selections[0].data.currenttrack);
                        Ext.getCmp("updatecurrentnorm").setValue(selections[0].data.currentnorm);
                    } else {
                        new Ynzc.manage.ChangeBodyEditWin().show();
                        Ynzc.manage.updatechangebodyid = selections[0].data.changebodyid;
                        Ynzc.manage.DetalisLicensenum = selections[0].data.license;
                        Ext.getCmp("updategetwayid").setValue(selections[0].data.gettypeid);
                        Ext.getCmp("updatemachinetypeid").setValue(selections[0].data.machinetypeid);
                        Ext.getCmp("updatemachinebrandtypeid").setMyValue(selections[0].data.engineid);
                        Ext.getCmp("updatemachinebodyno").setValue(selections[0].data.bodycode);
                        Ext.getCmp("updateengineno").setValue(selections[0].data.enginecode);
                        Ext.getCmp("updateshelfno").setValue(selections[0].data.rackcode);
                        Ext.getCmp("updateusedfor").setValue(selections[0].data.usernature);
                        Ext.getCmp("updatemanufacturer").setValue(selections[0].data.factoryname);
                        Ext.getCmp("updateseller").setValue(selections[0].data.saleunit);
                        if(selections[0].data.releasedate!=null && selections[0].data.releasedate!=""){
                            Ext.getCmp("updatemanufacturedate").setValue(new Date(selections[0].data.releasedate.time).format('Y-m-d'));	
                        }
                        Ext.getCmp("updateprice").setValue(selections[0].data.price);
                        Ext.getCmp("updatemyphotourl").setValue(selections[0].data.photourl);
                        if(selections[0].data.getwayfiletypeid!=null && selections[0].data.getwayfiletypeid!="0"){
                        	Ext.getCmp("updategetwayfiletypeid").setValue(selections[0].data.getwayfiletypeid);
                        }
                        
                        Ext.getCmp("updategetwayfileno").setValue(selections[0].data.getwayfiletypecode);
                        if(selections[0].data.importsfiletypeid!=null && selections[0].data.importsfiletypeid!="0"){
                        	 Ext.getCmp("updateimportsfiletypeid").setValue(selections[0].data.importsfiletypeid);
                        }
                       
                        Ext.getCmp("updateimportsfileno").setValue(selections[0].data.importsfiletypecode);
                        var updatestr = selections[0].data.other.split(",");
                        for (i = 0; i < updatestr.length; i++) {
                            if (updatestr[i] == "国产拖拉机整车出厂合格证明") {
                                Ext.getCmp("updateotherOne").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "拖拉机档案") {
                                Ext.getCmp("updateotherTwo").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "身份证明") {
                                Ext.getCmp("updateotherThree").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "《协助执行通知书》") {
                                Ext.getCmp("updateotherFour").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "《公证书》") {
                                Ext.getCmp("updateotherFive").setValue(true);
                                continue;
                            };
                        }
                        Ext.getCmp("updateinsurancelistno").setValue(selections[0].data.insurancelistno);
                        Ext.getCmp("updateinsurancecompanyname").setValue(selections[0].data.insurancecompany);
                        if(selections[0].data.insurancedate!=null && selections[0].data.insurancedate!=""){
                        	Ext.getCmp("updateinsurancedate").setValue(new Date(selections[0].data.insurancedate.time).format('Y-m-d'));
                        }
                        if(selections[0].data.insurancevalidate!=null && selections[0].data.insurancevalidate!=""){
                        	Ext.getCmp("updateexpirydate").setValue(new Date(selections[0].data.insurancevalidate.time).format('Y-m-d'));
                        }                       
                        Ext.getCmp("updatemachinebodycolor").setValue(selections[0].data.bodycolor);
                        Ext.getCmp("updateoutsize").setValue(selections[0].data.size);
                        Ext.getCmp("updatedirectcontrol").setValue(selections[0].data.directcontrol);
                        Ext.getCmp("updatecontainersize").setValue(selections[0].data.containersize);
                        Ext.getCmp("updateenginebrandid").setMyValue(selections[0].data.enginebrandid);
                        Ext.getCmp("updatebodypower").setValue(selections[0].data.power);
                        Ext.getCmp("updatecylinderno").setValue(selections[0].data.cylinderno);
                        if(selections[0].data.fueltypeid!=null && selections[0].data.fueltypeid!="0"){
                        	  Ext.getCmp("updatefueltypeid").setValue(selections[0].data.fueltypeid);
                        }
                      
                        Ext.getCmp("updatewheelno").setValue(selections[0].data.wheelno);
                        Ext.getCmp("updatewheelbase").setValue(selections[0].data.wheelbase);
                        Ext.getCmp("updatetiresno").setValue(selections[0].data.tiresno);
                        Ext.getCmp("updatetiressize").setValue(selections[0].data.tiressize);
                        Ext.getCmp("updatewheeldis").setValue(selections[0].data.wheeldis);
                        Ext.getCmp("updatetotalquality").setValue(selections[0].data.totalquality);
                        Ext.getCmp("updateallquality").setValue(selections[0].data.allquality);
                        Ext.getCmp("updateratifiedload").setValue(selections[0].data.ratifiedload);
                        Ext.getCmp("updateallowdragtotalquality").setValue(selections[0].data.allowdragtotalquality);
                        Ext.getCmp("updatedriverinno").setValue(selections[0].data.driverinno);
                        Ext.getCmp("updatesteelspring").setValue(selections[0].data.steelspring);
                        Ext.getCmp("updatevicecartiresno").setValue(selections[0].data.vicecartiresno);
                        Ext.getCmp("updateoutcarwheeldis").setValue(selections[0].data.outcarwheeldis);
                        Ext.getCmp("updateoutcartiressize").setValue(selections[0].data.outcartiressize);
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
                        if (selections[i].data.approvalstate == 1 || selections[i].data.approvalstate == 2) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、审核未通过】的信息进行删除！");
                            return;
                        }
                    }
                    var delcarchangeids = "";
                    var delchangecolorids = "";
                    var delchangeengineids = "";
                    var delchangetrailerids = "";
                    var delchangeownerids = "";
                    var delchangebodyids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.approvalstate != 2) {
                            updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
                        }
                        delcarchangeids = delcarchangeids + selections[i].data.id + ",";
                        if (selections[i].data.changeType == "变更机身颜色") {
                            delchangecolorids = delchangecolorids + selections[i].data.changecolorid + ",";
                        } else if (selections[i].data.changeType == "共同所有的拖拉机变更拖拉机所有人") {
                            delchangeownerids = delchangeownerids + selections[i].data.changeownerid + ",";
                        } else if (selections[i].data.changeType == "更换发动机") {
                            delchangeengineids = delchangeengineids + selections[i].data.changeengineid + ",";
                        } else if (selections[i].data.changeType == "更换挂车") {
                            delchangetrailerids = delchangetrailerids + selections[i].data.changetrailerid + ",";
                        } else {
                            delchangebodyids = delchangebodyids + selections[i].data.changebodyid + ",";
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
                                    url: "main/carChange.html?action=DeleteCarChange",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("changeMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        mydelcarchangeids: delcarchangeids,
                                        mydelchangecolorids: delchangecolorids,
                                        mydelchangeengineids: delchangeengineids,
                                        mydelchangetrailerids: delchangetrailerids,
                                        mydelchangeownerids: delchangeownerids,
                                        mydelchangebodyids: delchangebodyids,
                                        tractorids: updatetractorids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
                text: "查询已上报数据",
                iconCls: "icon-checkininfo",
                handler: function() {
            	Ext.getCmp("changeMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 1
                        }
                    });
                }
            },
            {
                text: "查询通过审核数据",
                iconCls: "icon-AddPermissions",
                handler: function() {
            	Ext.getCmp("changeMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 2
                        }
                    });
                }
            },
            {
                text: "查询未通过数据",
                iconCls: "icon-Del",
                handler: function() {
            	Ext.getCmp("changeMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 3
                        }
                    });
                }
            },
            {
                text: "查询",
                iconCls: "icon-search",
                handler: function() {
                    new Ext.Window({
                        id: "searchWin",
                        title: "请输入查询条件",
                        modal: true,
                        height: 310,
                        width: 320,
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
                            id: "searchchangetype",
                            fieldLabel: "变更类型",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            value: '--请选择--',
                            store: Ynzc.manage.ChangeTypeStore,
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                        	Ext.getCmp("changeMgr").getStore().reload({
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
                                        changtype: Ext.getCmp("searchchangetype").getValue()
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
	        					sourceURL:'main/carChange.html?action=carChangeInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            },{
            text: "打印拖拉机变更登记申请表",
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
	                        wordType:"tractorAlterApplication",
                        	cnWord:"拖拉机变更登记申请表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'拖拉机变更登记申请表',
	        					sourceURL:'main/carChange.html?action=PrintCarChangeReport',
	        					params:{id:selections[0].data.tractorinfoId,wordType:'tractorAlterApplication'}
	        			}).show();
            		}.createDelegate(this)
            }
            ],
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
        Ynzc.manage.CarChangeGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });

    }
});
Ext.reg('carchangegrid', Ynzc.manage.CarChangeGrid);