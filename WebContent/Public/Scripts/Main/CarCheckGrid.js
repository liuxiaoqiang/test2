Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.CarCheckGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'carcheckgrid',
    initComponent: function() {
        var pgtoolbar = Ext.extend(Ext.PagingToolbar, {
            doLoad: function() {
                // Ext.getCmp("delBtn").setVisible(false);
                pgtoolbar.superclass.doLoad.apply(this, arguments);
            }
        });
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{tractorinfoplantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '</table>')
        });
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '类型',
            sortable: true,
            dataIndex: "checktype",
            renderer: function(value) {
                if (value == 0) {
                    return '年检';
                } else if (value == 1) {
                    return '逾期年检';
                }else if(value==2){
                	return '补检';
                }
            }
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
            dataIndex: "orgincheckexpirydate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '检验时间',
            sortable: true,
            dataIndex: "inspectordate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '下次检验有效期',
            sortable: true,
            dataIndex: "checkexpirydate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '业务状态',
            sortable: true,
            dataIndex: "checkresult",
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
            dataIndex: "checkuser"
        },
        {
            header: '审核时间',
            sortable: true,
            dataIndex: "checkdate",
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
            	name:'orgintractorstate'
            },
            {
                name: 'orgincheckresult'
            },
            {
                name: 'orgindisqualification'
            },
            {
                name: 'orgincheckexpirydate'
            },
            {
                name: 'orgininspector'
            },
            {
                name: 'orgincheckdate'
            },
            {
                name: 'orginshowinitialinspectionresult'
            },
            {
                name: 'orginshowdisqualification'
            },
            {
                name: 'orginshowexaminationresult'
            },
            {
                name: 'orginengineinitialinspectionresult'
            },
            {
                name: 'orginenginedisqualification'
            },
            {
                name: 'orginengineexaminationresult'
            },
            {
                name: 'orginconveyorinitialinspectionresult'
            },
            {
                name: 'orginconveyordisqualification'
            },
            {
                name: 'orginconveyorexaminationresult'
            },
            {
                name: 'orginsteeringinitialinspectionresult'
            },
            {
                name: 'orginsteeringdisqualification'
            },
            {
                name: 'orginsteeringexaminationresult'
            },
            {
                name: 'orginflyhostinitialinspectionresult'
            },
            {
                name: 'orginflyhostdisqualification'
            },
            {
                name: 'orginflyhostexaminationresult'
            },
            {
                name: 'orginflytrailerinitialinspectionresult'
            },
            {
                name: 'orginflytrailerdisqualification'
            },
            {
                name: 'orginflytrailerexaminationresult'
            },
            {
                name: 'orginbrakhostinitialinspectionresult'
            },
            {
                name: 'orginbrakhostdisqualification'
            },
            {
                name: 'orginbrakhostexaminationresult'
            },
            {
                name: 'orginbraktrailerinitialinspectionresult'
            },
            {
                name: 'orginbraktrailerdisqualification'
            },
            {
                name: 'orginbraktrailerexaminationresult'
            },
            {
                name: 'orginlighthostinitialinspectionresult'
            },
            {
                name: 'orginlighthostdisqualification'
            },
            {
                name: 'orginlighthostexaminationresult'
            },
            {
                name: 'orginlighttrailerinitialinspectionresult'
            },
            {
                name: 'orginlighttrailerdisqualification'
            },
            {
                name: 'orginlighttrailerexaminationresult'
            },
            {
                name: 'orgintractioninitialinspectionresult'
            },
            {
                name: 'orgintractiondisqualification'
            },
            {
                name: 'orgintractionexaminationresult'
            },
            {
                name: 'orgininsurancelistno'
            },
            {
                name: 'orgininsurancedate'
            },
            {
                name: 'orgininsurancecompanyname'
            },
            {
                name: 'orginexpirydate'
            },
            {
                name: 'inspectorresult'
            },
            {
                name: 'checkexpirydate'
            },
            {
                name: 'inspector'
            },
            {
                name: 'inspectordate'
            },
            {
                name: 'checkcompanyname'
            },
            {
                name: 'currentdisqualification'
            },
            {
                name: 'currentshowinitialinspectionresult'
            },
            {
                name: 'currentshowdisqualification'
            },
            {
                name: 'currentshowexaminationresult'
            },
            {
                name: 'currentengineinitialinspectionresult'
            },
            {
                name: 'currentenginedisqualification'
            },
            {
                name: 'currentengineexaminationresult'
            },
            {
                name: 'currentconveyorinitialinspectionresult'
            },
            {
                name: 'currentconveyordisqualification'
            },
            {
                name: 'currentconveyorexaminationresult'
            },
            {
                name: 'currentsteeringinitialinspectionresult'
            },
            {
                name: 'currentsteeringdisqualification'
            },
            {
                name: 'currentsteeringexaminationresult'
            },
            {
                name: 'currentflyhostinitialinspectionresult'
            },
            {
                name: 'currentflyhostdisqualification'
            },
            {
                name: 'currentflyhostexaminationresult'
            },
            {
                name: 'currentflytrailerinitialinspectionresult'
            },
            {
                name: 'currentflytrailerdisqualification'
            },
            {
                name: 'currentflytrailerexaminationresult'
            },
            {
                name: 'currentbrakhostinitialinspectionresult'
            },
            {
                name: 'currentbrakhostdisqualification'
            },
            {
                name: 'currentbrakhostexaminationresult'
            },
            {
                name: 'currentbraktrailerinitialinspectionresult'
            },
            {
                name: 'currentbraktrailerdisqualification'
            },
            {
                name: 'currentbraktrailerexaminationresult'
            },
            {
                name: 'currentlighthostinitialinspectionresult'
            },
            {
                name: 'currentlighthostdisqualification'
            },
            {
                name: 'currentlighthostexaminationresult'
            },
            {
                name: 'currentlighttrailerinitialinspectionresult'
            },
            {
                name: 'currentlighttrailerdisqualification'
            },
            {
                name: 'currentlighttrailerexaminationresult'
            },
            {
                name: 'currenttractioninitialinspectionresult'
            },
            {
                name: 'currenttractiondisqualification'
            },
            {
                name: 'currenttractionexaminationresult'
            },            
            {
                name: 'insurancelistno'
            },
            {
                name: 'insurancedate'
            },
            {
                name: 'insurancecompanyname'
            },
            {
                name: 'expirydate'
            },
            {
                name: 'reviewer'
            },
            {
                name: 'reviewerconductdate'
            },
            {
                name: 'issueadmin'
            },
            {
                name: 'issueadmindate'
            },
            {
                name: 'leaderreview'
            },
            {
                name: 'leaderreviewdate'
            },
            {
                name: 'operateuser'
            },
            {
                name: 'operatedate'
            },
            {
                name: 'checkuser'
            },
            {
                name: 'checkdate'
            },
            {
                name: 'checkip'
            },
            {
                name: 'checkresult'
            },
            {
                name: 'checkcontext'
            },
            {
                name: 'checktype'
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
            },
            {
                name: 'filing'
            }]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: "main/carCheck.html?action=getAllCarCheckListByPage",
            reader: reader,
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });

        Ext.apply(this, {
            id: 'carcheckgrid',
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
                id: 'carcheckBtn',
                text: "车辆年检",
                iconCls: "icon-signMgr",
                handler: function() {
                    new Ext.Window({
                        id: "inputCodeNumWin",
                        title: "请输入要年检的号牌号码",
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
                        	    var license = Ext.getCmp("codenum").getValue();
                        	    var licensenum = Ext.getCmp("codenum").getValue();
                                if (Ext.getCmp("codenum").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请输入要年检的号牌号码!");
                                    return
                                }
                                Ynzc.manage.codenum = Ext.getCmp("codenum").getValue();
                                Ext.Ajax.request({
                                    url: 'main/tractorInfoView.html?action=IsExitsCarCheckCode',
                                    method: "post",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            Ext.getCmp("inputCodeNumWin").close();
                                            var carcheckWin = new Ext.Window({
                                                id: "carcheckWin",
                                                title: "请填写车辆年检信息",
                                                modal: true,
                                                height: 554,
                                                width: 700,
                                                layout: "form",
                                                labelWidth: 80,
                                                autoScroll: true,
                                                bodyStyle: "padding:2px 2px",
                                                items: [{
                                                    xtype: "fieldset",
                                                    title: "车辆信息",
                                                    layout: "column",
                                                    height:'auto',
                                                    bodyStyle: "padding:2px 2px",
                                                    width: 660,
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code',
                                                            fieldLabel: "号牌号码",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.platecode + "." + result.reson.license
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'code1',
                                                            fieldLabel: "登记证书编号",
                                                            xtype: "textfield",
                                                            anchor: '98%',
                                                            readOnly: true,
                                                            value: result.reson.regcerno
                                                        }]
                                                    }
                                                   ]
                                                },
                                                {
                                                    xtype: "fieldset",
                                                    title: "技术检验",
                                                    layout: "column",
                                                    height:'auto',
                                                    width: 660,
                                                    bodyStyle: "padding:2px 2px",
                                                    items: [{
                                                        columnWidth: .4,
                                                        layout: "form",
                                                        labelWidth: 100,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: "orgincheckexpirydate",
                                                            fieldLabel: "当前检验有效期",
                                                            format: "Y-m-d",
                                                            xtype: "datefield",
                                                            anchor: '98%',
                                                            value:new Date(result.reson.checkexpirydate.time).format("Y-m-d"),
                                                            readOnly: true
                                                        }]
                                                    },{
                                                        columnWidth: .4,
                                                        layout: "form",
                                                        labelWidth: 100,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: "checkexpirydate",
                                                            fieldLabel: "下次检验有效期",
                                                            format: "Y-m-d",
                                                            xtype: "datefield",
                                                            anchor: '98%',
                                                            readOnly: true
                                                        }]
                                                    },
                                                   
                                                    {
                                                        columnWidth: .2,
                                                        layout: "form",
                                                        labelWidth: 55,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'inspectorresult',
                                                            fieldLabel: "检验结论",
                                                            xtype: "textfield",
                                                            value: "检验合格",
                                                            anchor: '100%'
                                                        }]
                                                    },
                                                   
                                                    {
                                                        columnWidth: .4,
                                                        layout: "form",
                                                        labelWidth:100,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'inspectordate',
                                                            fieldLabel: "检验日期",
                                                            format: "Y-m-d",
                                                            value: new Date(),
                                                            xtype: "datefield",
                                                            readOnly: true,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth:.4,
                                                        layout: "form",
                                                        labelWidth: 100,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'checkcompanyname',
                                                            fieldLabel: "检验机构名称",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .2,
                                                        layout: "form",
                                                        labelWidth: 55,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'inspector',
                                                            fieldLabel: "检验人",
                                                            xtype: "textfield",
                                                            anchor: '100%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        labelWidth: 100,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'currentdisqualification',
                                                            fieldLabel: "不合格原因",
                                                            xtype: "textfield",
                                                            anchor: '100%'
                                                        }]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentshowinitialinspectionresult',
                                                        	fieldLabel:"外观初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentshowdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentshowexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentengineinitialinspectionresult',
                                                        	fieldLabel:"发动机初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentenginedisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentengineexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentconveyorinitialinspectionresult',
                                                        	fieldLabel:"传动机初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentconveyordisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentconveyorexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentsteeringinitialinspectionresult',
                                                        	fieldLabel:"转向系初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentsteeringdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentsteeringexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentflyhostinitialinspectionresult',
                                                        	fieldLabel:"机架及行走系主机初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentflyhostdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentflyhostexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentflytrailerinitialinspectionresult',
                                                        	fieldLabel:"驾机及行走系挂车初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentflytrailerdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentflytrailerexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentbrakhostinitialinspectionresult',
                                                        	fieldLabel:"制动系主机初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentbrakhostdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentbrakhostexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentbraktrailerinitialinspectionresult',
                                                        	fieldLabel:"制动系挂车初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentbraktrailerdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentbraktrailerexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentlighthostinitialinspectionresult',
                                                        	fieldLabel:"灯光及信号装置主机初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentlighthostdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentlighthostexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentlighttrailerinitialinspectionresult',
                                                        	fieldLabel:"灯光及信号装置挂车初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentlighttrailerdisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currentlighttrailerexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:165,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currenttractioninitialinspectionresult',
                                                        	fieldLabel:"液压悬挂及牵引装置初检结果",
                                                        	xtype:"textfield",
                                                        	value:"检验合格",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.4,
                                                      	layout:"form",
                                                    	labelWidth:70,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currenttractiondisqualification',
                                                        	fieldLabel:"不合格原因",
                                                        	xtype:"textfield",
                                                        	anchor:'98%'
                                                        	}]
                                                    },
                                                    {
                                                    	columnWidth:.2,
                                                      	layout:"form",
                                                    	labelWidth:55,
                                                    	baseCls: "x-plain",
                                                    	items:[{
                                                        	id:'currenttractionexaminationresult',
                                                        	fieldLabel:"复检结果",
                                                        	xtype:"textfield",
                                                        	anchor:'100%'
                                                        	}]
                                                    }
                                                    ]
                                                },
                                                {
                                                    xtype: "fieldset",
                                                    title: "交强险",
                                                    layout: "column",
                                                    height:'auto',
                                                    width: 660,
                                                    bodyStyle: "padding:2px 2px",
                                                    items: [{
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'insurancelistno',
                                                            fieldLabel: "保单号",
                                                            xtype: "textfield",
                                                            anchor: '100%',
                                                            value: result.reson.insurancelistno
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'insurancedate',
                                                            fieldLabel: "检验日期",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            readOnly: true,
                                                            anchor: '100%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: "insurancecompanyname",
                                                            shadowOffset: 0,
                                                            fieldLabel: "保险公司",
                                                            xtype: "icombo",
                                                            anchor: '100%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'expirydate',
                                                            fieldLabel: "保险有效期",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            readOnly: true,
                                                            anchor: '100%'
                                                        }]
                                                    }]
                                                },
                                                {
                                                    xtype: "fieldset",
                                                    title: "经办情况",
                                                    layout: "column",
                                                    height:'auto',
                                                    width: 660,
                                                    bodyStyle: "padding:2px 2px",
                                                    items: [{
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 90,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'reviewer',
                                                            fieldLabel: "登记审核人",
                                                            xtype: "textfield",
                                                            value: result.reson.reviewer,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 70,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'reviewerconductdate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            value: new Date(result.reson.reviewerconductdate.time).format("Y-m-d"),
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
                                                            id: 'issueadmin',
                                                            fieldLabel: "牌证管理员",
                                                            //                                                         xtype: "combo",
                                                            //                                                         displayField: 'realname',
                                                            //                                                         valueField: 'id',
                                                            //                                                         typeAhead: true,
                                                            //                                                         mode: 'remote',
                                                            //                                                         editable: false,
                                                            //                                                         selectOnFoucs: true,
                                                            //                                                         triggerAction: 'all',
                                                            //                                                         store: Ynzc.manage.PaleCodeUser,
                                                            //                                                         anchor: '98%'
                                                            value: result.reson.issueadmin,
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 70,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'issueadmindate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            value: new Date(result.reson.issueadmindate.time).format("Y-m-d"),
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
                                                            id: 'leaderreview',
                                                            fieldLabel: "业务领导审核",
                                                            //                                                         xtype: "combo",
                                                            //                                                         displayField: 'realname',
                                                            //                                                         valueField: 'id',
                                                            //                                                         typeAhead: true,
                                                            //                                                         mode: 'remote',
                                                            //                                                         editable: false,
                                                            //                                                         selectOnFoucs: true,
                                                            //                                                         triggerAction: 'all',
                                                            //                                                         store: Ynzc.manage.BusinessUser,
                                                            //                                                         anchor: '98%'
                                                            xtype: "textfield",
                                                            value: result.reson.leaderreview,
                                                            readOnly: true,
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: .5,
                                                        layout: "form",
                                                        labelWidth: 70,
                                                        baseCls: "x-plain",
                                                        items: [{
                                                            id: 'leaderreviewdate',
                                                            fieldLabel: "经办时间",
                                                            xtype: "datefield",
                                                            format: "Y-m-d",
                                                            value: new Date(result.reson.leaderreviewconductdate.time).format("Y-m-d"),
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
                                                    text: "提交",
                                                    handler: function() {
                                                        if (Ext.getCmp("checkexpirydate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写年检有效期!");
                                                            return
                                                        } else {
                                                            if (Ext.util.Format.date(Ext.getCmp("checkexpirydate").getValue(), 'Y-m-d') <= new Date()) {
                                                                Ext.MessageBox.alert("提示", "请正确填写年检有效期!");
                                                                return
                                                            }
                                                        }
                                                        if (Ext.getCmp("inspector").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写检验人!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("inspectordate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写检验日期!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("checkcompanyname").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写检验机构名称!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("inspectorresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写年检结论!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("insurancelistno").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写检保单号!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("insurancedate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写保险日期!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("insurancecompanyname").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请选择保险公司名称!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("expirydate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写保单有效期!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("reviewer").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写登记审核人!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("reviewerconductdate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办时间!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("issueadmin").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写牌证管理员!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("issueadmindate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办时间!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("leaderreview").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写业务领导审核!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("leaderreviewdate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写经办时间!");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentshowinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>外观初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentengineinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>发动机初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentconveyorinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>传动机初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentsteeringinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>转向系初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentflyhostinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>机架及行走系主机初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentflytrailerinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>机架及行走系挂车初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentbrakhostinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>制动系主机初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentbraktrailerinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>制动系挂车初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentlighthostinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>灯光及信号装置主机初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currentlighttrailerinitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>灯光及信号装置挂车初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        if (Ext.getCmp("currenttractioninitialinspectionresult").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "[<font color=red>技术检验</font>][<font color=red>液压悬挂及牵引装置初检结果</font>]未选择，请选择。");
                                                            return
                                                        }
                                                        Ext.Ajax.request({
                                                            url: "main/carCheck.html?action=addCarCheck",
                                                            success: function(resp) {
                                                                var result = Ext.util.JSON.decode(resp.responseText);
                                                                if (result.success == true) {
                                                                    Ext.MessageBox.alert("提示", "提交成功,请等待审核!");
                                                                    Ext.getCmp("carcheckWin").close();
                                                                    Ext.getCmp("carcheckMgr").getStore().reload();
                                                                } else {
                                                                    Ext.Msg.alert("提示", "操作失败!");
                                                                }
                                                            },
                                                            failure: function() {
                                                                Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                                            },
                                                            params: {
                                                                tractorinfoId: result.reson.id,
                                                                orgintractorstate:result.reson.status,
                                                                orgincheckresult:result.reson.checkresult,              
                                                                orgindisqualification:result.reson.disqualification,
                                                                orgincheckexpirydate:new Date(result.reson.checkexpirydate.time).format('Y-m-d'),
                                                                orgininspector:result.reson.inspector,
                                                                orgincheckdate:new Date(result.reson.checkdate.time).format('Y-m-d'),
                                                                orginshowinitialinspectionresult:result.reson.showinitialinspectionresult,
                                                                orginshowdisqualification:result.reson.showdisqualification,
                                                                orginshowexaminationresult:result.reson.showexaminationresult,
                                                                orginengineinitialinspectionresult:result.reson.engineinitialinspectionresult,
                                                                orginenginedisqualification:result.reson.enginedisqualification,
                                                                orginengineexaminationresult:result.reson.engineexaminationresult,
                                                                orginconveyorinitialinspectionresult:result.reson.conveyorinitialinspectionresul,
                                                                orginconveyordisqualification:result.reson.conveyordisqualification,
                                                                orginconveyorexaminationresult:result.reson.conveyorexaminationresult,
                                                                orginsteeringinitialinspectionresult:result.reson.steeringinitialinspectionresult,
                                                                orginsteeringdisqualification:result.reson.steeringdisqualification,
                                                                orginsteeringexaminationresult:result.reson.steeringexaminationresult,
                                                                orginflyhostinitialinspectionresult:result.reson.flyhostinitialinspectionresult,
                                                                orginflyhostdisqualification:result.reson.flyhostdisqualification,
                                                                orginflyhostexaminationresult:result.reson.flyhostexaminationresult,
                                                                orginflytrailerinitialinspectionresult:result.reson.flytrailerinitialinspectionresult,
                                                                orginflytrailerdisqualification:result.reson.flytrailerdisqualification,
                                                                orginflytrailerexaminationresult:result.reson.flytrailerexaminationresult,
                                                                orginbrakhostinitialinspectionresul:result.reson.brakhostinitialinspectionresult,
                                                                orginbrakhostdisqualification:result.reson.brakhostdisqualification,
                                                                orginbrakhostexaminationresult:result.reson.brakhostexaminationresult,
                                                                orginbraktrailerinitialinspectionresult:result.reson.braktrailerinitialinspectionresult,
                                                                orginbraktrailerdisqualification:result.reson.braktrailerdisqualification,
                                                                orginbraktrailerexaminationresult:result.reson.braktrailerexaminationresult,
                                                                orginlighthostinitialinspectionresult:result.reson.lighthostinitialinspectionresult,
                                                                orginlighthostdisqualification:result.reson.lighthostdisqualification,
                                                                orginlighthostexaminationresult:result.reson.lighthostexaminationresult,
                                                                orginlighttrailerinitialinspectionresult:result.reson.lighttrailerinitialinspectionresult,
                                                                orginlighttrailerdisqualification:result.reson.lighttrailerdisqualification,                                                               
                                                                orginlighttrailerexaminationresult:result.reson.lighttrailerexaminationresult,
                                                                orgintractioninitialinspectionresult:result.reson.tractioninitialinspectionresult,
                                                                orgintractiondisqualification:result.reson.tractiondisqualification,
                                                                orgintractionexaminationresult:result.reson.tractionexaminationresult,
                                                                orgininsurancelistno:result.reson.insurancelistno,
                                                                orgininsurancedate:new Date(result.reson.insurancedate.time).format('Y-m-d'),
                                                                orgininsurancecompanyname:result.reson.insurancecompanyname,
                                                                orginexpirydate:new Date(result.reson.expirydate.time).format('Y-m-d'),
                                                                inspectorresult: Ext.getCmp("inspectorresult").getValue(),
                                                                checkexpirydate: Ext.util.Format.date(Ext.getCmp("checkexpirydate").getValue(), 'Y-m-d'),
                                                                inspector: Ext.getCmp("inspector").getValue(),
                                                                inspectordate: Ext.util.Format.date(Ext.getCmp("inspectordate").getValue(), 'Y-m-d'),
                                                                checkcompanyname: Ext.getCmp("checkcompanyname").getValue(),                          
                                                                currentdisqualification:Ext.getCmp("currentdisqualification").getValue(),
                                                                currentshowinitialinspectionresult:Ext.getCmp("currentshowinitialinspectionresult").getValue(),
                                                                currentshowdisqualification:Ext.getCmp("currentshowdisqualification").getValue(),
                                                                currentshowexaminationresult:Ext.getCmp("currentshowexaminationresult").getValue(),
                                                                currentengineinitialinspectionresult:Ext.getCmp("currentengineinitialinspectionresult").getValue(),
                                                                currentenginedisqualification:Ext.getCmp("currentenginedisqualification").getValue(),
                                                                currentengineexaminationresult:Ext.getCmp("currentengineexaminationresult").getValue(),
                                                                currentconveyorinitialinspectionresult:Ext.getCmp("currentconveyorinitialinspectionresult").getValue(),
                                                                currentconveyordisqualification:Ext.getCmp("currentconveyordisqualification").getValue(),
                                                                currentconveyorexaminationresult:Ext.getCmp("currentconveyorexaminationresult").getValue(),
                                                                currentsteeringinitialinspectionresult:Ext.getCmp("currentsteeringinitialinspectionresult").getValue(),
                                                                currentsteeringdisqualification:Ext.getCmp("currentsteeringdisqualification").getValue(),
                                                                currentsteeringexaminationresult:Ext.getCmp("currentsteeringexaminationresult").getValue(),
                                                                currentflyhostinitialinspectionresult:Ext.getCmp("currentflyhostinitialinspectionresult").getValue(),
                                                                currentflyhostdisqualification:Ext.getCmp("currentflyhostdisqualification").getValue(),
                                                                currentflyhostexaminationresult:Ext.getCmp("currentflyhostexaminationresult").getValue(),
                                                                currentflytrailerinitialinspectionresult:Ext.getCmp("currentflytrailerinitialinspectionresult").getValue(),
                                                                currentflytrailerdisqualification:Ext.getCmp("currentflytrailerdisqualification").getValue(),
                                                                currentflytrailerexaminationresult:Ext.getCmp("currentflytrailerexaminationresult").getValue(),
                                                                currentbrakhostinitialinspectionresult:Ext.getCmp("currentbrakhostinitialinspectionresult").getValue(),
                                                                currentbrakhostdisqualification:Ext.getCmp("currentbrakhostdisqualification").getValue(),
                                                                currentbrakhostexaminationresult:Ext.getCmp("currentbrakhostexaminationresult").getValue(),
                                                                currentbraktrailerinitialinspectionresult:Ext.getCmp("currentbraktrailerinitialinspectionresult").getValue(),
                                                                currentbraktrailerdisqualification:Ext.getCmp("currentbraktrailerdisqualification").getValue(),
                                                                currentbraktrailerexaminationresult:Ext.getCmp("currentbraktrailerexaminationresult").getValue(),
                                                                currentlighthostinitialinspectionresult:Ext.getCmp("currentlighthostinitialinspectionresult").getValue(),
                                                                currentlighthostdisqualification:Ext.getCmp("currentlighthostdisqualification").getValue(),
                                                                currentlighthostexaminationresult:Ext.getCmp("currentlighthostexaminationresult").getValue(),
                                                                currentlighttrailerinitialinspectionresult:Ext.getCmp("currentlighttrailerinitialinspectionresult").getValue(),
                                                                currentlighttrailerdisqualification:Ext.getCmp("currentlighttrailerdisqualification").getValue(),
                                                                currentlighttrailerexaminationresult:Ext.getCmp("currentlighttrailerexaminationresult").getValue(),
                                                                currenttractioninitialinspectionresult:Ext.getCmp("currenttractioninitialinspectionresult").getValue(),
                                                                currenttractiondisqualification:Ext.getCmp("currenttractiondisqualification").getValue(),
                                                                currenttractionexaminationresult:Ext.getCmp("currenttractionexaminationresult").getValue(), 
                                                                insurancelistno: Ext.getCmp("insurancelistno").getValue(),
                                                                insurancedate: Ext.util.Format.date(Ext.getCmp("insurancedate").getValue(), 'Y-m-d'),
                                                                insurancecompanyname: Ext.getCmp("insurancecompanyname").getValue(),
                                                                expirydate: Ext.util.Format.date(Ext.getCmp("expirydate").getValue(), 'Y-m-d'),
                                                                reviewer: Ext.getCmp("reviewer").getValue(),
                                                                reviewerconductdate: Ext.util.Format.date(Ext.getCmp("reviewerconductdate").getValue(), 'Y-m-d'),
                                                                issueadmin: Ext.getCmp("issueadmin").getValue(),
                                                                issueadmindate: Ext.util.Format.date(Ext.getCmp("issueadmindate").getValue(), 'Y-m-d'),
                                                                leaderreview: Ext.getCmp("leaderreview").getValue(),
                                                                leaderreviewdate: Ext.util.Format.date(Ext.getCmp("leaderreviewdate").getValue(), 'Y-m-d')
                                                            }
                                                        });
                                                    }
                                                },
                                                {
                                                    text: "取消",
                                                    handler: function() {
                                                        Ext.getCmp("carcheckWin").close();
                                                    }
                                                }]
                                            }).show();
                                            if (result.reson.insurancedate != null && result.reson.insurancedate != "") {
                                                Ext.getCmp("insurancedate").setValue(new Date(result.reson.insurancedate.time).format("Y-m-d"));
                                            }
                                            if (result.reson.insurancecompanyname != null && result.reson.insurancecompanyname != "") {
                                                Ext.getCmp("insurancecompanyname").setValue(result.reson.insurancecompanyname);
                                            }
                                            if (result.reson.expirydate != null && result.reson.expirydate != "") {
                                                Ext.getCmp("expirydate").setValue(new Date(result.reson.expirydate.time).format("Y-m-d"));
                                            }
                                            if(result.reson.checkexpirydate!=null && result.reson.checkexpirydate!=""){
                                            	var v=new Date(result.reson.checkexpirydate.time).format("Y-m-d");
                                            	var arraylist=v.split('-');
                                            	var lastyear=arraylist[0]*1+1;
                                            	Ext.getCmp("checkexpirydate").setValue(lastyear+"-"+arraylist[1]+"-"+arraylist[2]);
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
                    }).show(Ext.getCmp("carcheckBtn").getEl());
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
                        if (selections[i].data.checkresult != 0 && selections[i].data.checkresult != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过审核】的信息进行上报！");
                            return;
                        }
                    }
                    var carcheckids = "";
                    for (i = 0; i < n; i++) {
                        if (carcheckids.length == 0) {
                            carcheckids = carcheckids + selections[i].data.id;
                        } else {
                            carcheckids = carcheckids + "," + selections[i].data.id;
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
                                    url: "main/carCheck.html?action=ReportedCarCheck",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("carcheckMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reportcarcheckids: carcheckids
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
                    if (selections[0].data.checkresult != 0 && selections[0].data.checkresult != 3) {
                        Ext.MessageBox.alert("提示", "只能对【待报、未通过】的数据进行编辑！");
                        return
                    }
                    new Ext.Window({
                        id: "updatecarcheckWin",
                        title: "修改车辆年检信息",
                        modal: true,
                        height: 554,
                        width: 700,
                        layout: "form",
                        labelWidth: 80,
                        autoScroll: true,
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            xtype: "fieldset",
                            title: "车辆信息",
                            layout: "column",
                            height:'auto',
                            bodyStyle: "padding:2px 2px",
                            width: 660,
                            items: [{
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode',
                                    fieldLabel: "号牌号码",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.platecode + "." + selections[0].data.license
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecode1',
                                    fieldLabel: "登记证书编号",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    readOnly: true,
                                    value: selections[0].data.regcerno
                                }]
                            }]
                        },
                        {
                            xtype: "fieldset",
                            title: "技术检验",
                            layout: "column",
                            height:'auto',
                            width: 660,
                            bodyStyle: "padding:2px 2px",
                            items: [ {
                                columnWidth: .4,
                                layout: "form",
                                labelWidth: 100,
                                baseCls: "x-plain",
                                items: [{
                                    id: "uporgincheckexpirydate",
                                    fieldLabel: "上次检验有效期",
                                    format: "Y-m-d",
                                    xtype: "datefield",
                                    value: new Date(selections[0].data.orgincheckexpirydate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            },
                             {
                                columnWidth: .4,
                                layout: "form",
                                labelWidth: 100,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updatecheckexpirydate",
                                    fieldLabel: "检验有效期",
                                    format: "Y-m-d",
                                    xtype: "datefield",
                                    value: new Date(selections[0].data.checkexpirydate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            }
                            ,
                            {
                                columnWidth:.2,
                                layout: "form",
                                labelWidth: 55,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateinspectorresult',
                                    fieldLabel: "检验结论",
                                    xtype: "textfield",
                                    value: selections[0].data.inspectorresult,
                                    anchor: '100%'
                                }]
                            },
                            {
                                columnWidth: .4,
                                layout: "form",
                                labelWidth: 100,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateinspectordate',
                                    fieldLabel: "检验日期",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.inspectordate.time).format("Y-m-d"),
                                    xtype: "datefield",
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .4,
                                layout: "form",
                                labelWidth: 100,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatecheckcompanyname',
                                    fieldLabel: "检验机构名称",
                                    xtype: "textfield",
                                    anchor: '98%',
                                    value: selections[0].data.checkcompanyname
                                }]
                            },
                            {
                                columnWidth: .2,
                                layout: "form",
                                labelWidth: 55,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateinspector',
                                    fieldLabel: "检验人",
                                    xtype: "textfield",
                                    anchor: '100%',
                                    value: selections[0].data.inspector
                                }]
                            },
                            {
                                columnWidth: 1,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'upcurrentdisqualification',
                                    fieldLabel: "不合格原因",
                                    xtype: "textfield",
                                    value:selections[0].data.currentdisqualification,
                                    anchor: '100%'
                                }]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentshowinitialinspectionresult',
                                	fieldLabel:"外观初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentshowinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentshowdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentshowdisqualification,
                                	anchor:'98%'
                                	}]
                            }, {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentshowexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentshowexaminationresult,
                                	anchor:'100%'
                                	}]
                            },{
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentengineinitialinspectionresult',
                                	fieldLabel:"发动机初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentengineinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentenginedisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentenginedisqualification,
                                	anchor:'98%'
                                	}]
                            }, {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentengineexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentengineexaminationresult,
                                	anchor:'100%'
                                	}]
                            }, {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentconveyorinitialinspectionresult',
                                	fieldLabel:"传动机初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentconveyorinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentconveyordisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentconveyordisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentconveyorexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentconveyorexaminationresult,
                                	anchor:'100%'
                                	}]
                            },{
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentsteeringinitialinspectionresult',
                                	fieldLabel:"转向系初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentsteeringinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentsteeringdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentsteeringdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentsteeringexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentsteeringexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentflyhostinitialinspectionresult',
                                	fieldLabel:"机架及行走系主机初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentflyhostinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentflyhostdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentflyhostdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentflyhostexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentflyhostexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentflytrailerinitialinspectionresult',
                                	fieldLabel:"驾机及行走系挂车初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentflytrailerinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentflytrailerdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentflytrailerdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentflytrailerexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentflytrailerexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentbrakhostinitialinspectionresult',
                                	fieldLabel:"制动系主机初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentbrakhostinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentbrakhostdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentbrakhostdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentbrakhostexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentbrakhostexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentbraktrailerinitialinspectionresult',
                                	fieldLabel:"制动系挂车初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentbraktrailerinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentbraktrailerdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentbraktrailerdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentbraktrailerexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentbraktrailerexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentlighthostinitialinspectionresult',
                                	fieldLabel:"灯光及信号装置主机初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentlighthostinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentlighthostdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentlighthostdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentlighthostexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentlighthostexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentlighttrailerinitialinspectionresult',
                                	fieldLabel:"灯光及信号装置挂车初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentlighttrailerinitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentlighttrailerdisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currentlighttrailerdisqualification,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrentlighttrailerexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currentlighttrailerexaminationresult,
                                	anchor:'100%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:165,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrenttractioninitialinspectionresult',
                                	fieldLabel:"液压悬挂及牵引装置初检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currenttractioninitialinspectionresult,
                                	anchor:'98%'
                                	}]
                            },
                            {
                            	columnWidth:.4,
                              	layout:"form",
                            	labelWidth:70,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrenttractiondisqualification',
                                	fieldLabel:"不合格原因",
                                	xtype:"textfield",
                                	value:selections[0].data.currenttractiondisqualification,
                                	anchor:'98%'
                                	}]
                            }, {
                            	columnWidth:.2,
                              	layout:"form",
                            	labelWidth:55,
                            	baseCls: "x-plain",
                            	items:[{
                                	id:'upcurrenttractionexaminationresult',
                                	fieldLabel:"复检结果",
                                	xtype:"textfield",
                                	value:selections[0].data.currenttractionexaminationresult,
                                	anchor:'100%'
                                	}]
                            }]
                        },
                        {
                            xtype: "fieldset",
                            title: "交强险",
                            layout: "column",
                            height:'auto',
                            width: 660,
                            bodyStyle: "padding:2px 2px",
                            items: [{
                                columnWidth: 1,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateinsurancelistno',
                                    fieldLabel: "保单号",
                                    xtype: "textfield",
                                    value: selections[0].data.insurancelistno,
                                    anchor: '100%'
                                }]
                            },
                            {
                                columnWidth: 1,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateinsurancedate',
                                    fieldLabel: "检验日期",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.insurancedate.time).format("Y-m-d"),
                                    anchor: '100%'
                                }]
                            },
                            {
                                columnWidth: 1,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: "updateinsurancecompanyname",
                                    shadowOffset: 0,
                                    fieldLabel: "保险公司",
                                    xtype: "icombo",
                                    value: selections[0].data.insurancecompanyname,
                                    anchor: '100%'
                                }]
                            },
                            {
                                columnWidth: 1,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateexpirydate',
                                    fieldLabel: "保险有效期",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.expirydate.time).format("Y-m-d"),
                                    anchor: '100%'
                                }]
                            }]
                        },
                        {
                            xtype: "fieldset",
                            title: "经办情况",
                            layout: "column",
                            height:'auto',
                            width: 660,
                            bodyStyle: "padding:2px 2px",
                            items: [{
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatereviewer',
                                    fieldLabel: "登记审核人",
                                    xtype: "textfield",
                                    value: selections[0].data.reviewer,
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 70,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updatereviewerconductdate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.reviewerconductdate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateissueadmin',
                                    fieldLabel: "牌证管理员",
                                    //                                    xtype: "combo",
                                    //                                    displayField: 'realname',
                                    //                                    valueField: 'id',
                                    //                                    typeAhead: true,
                                    //                                    mode: 'remote',
                                    //                                    editable: false,
                                    //                                    selectOnFoucs: true,
                                    //                                    triggerAction: 'all',
                                    //                                    store: Ynzc.manage.PaleCodeUser,
                                    xtype: "textfield",
                                    value: selections[0].data.issueadmin,
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 70,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateissueadmindate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.issueadmindate.time).format("Y-m-d"),
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 90,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateleaderreview',
                                    fieldLabel: "业务领导审核",
                                    //                                    xtype: "combo",
                                    //                                    displayField: 'realname',
                                    //                                    valueField: 'id',
                                    //                                    typeAhead: true,
                                    //                                    mode: 'remote',
                                    //                                    editable: false,
                                    //                                    selectOnFoucs: true,
                                    //                                    triggerAction: 'all',
                                    //                                    store: Ynzc.manage.BusinessUser,
                                    xtype: "textfield",
                                    value: selections[0].data.leaderreview,
                                    anchor: '98%'
                                }]
                            },
                            {
                                columnWidth: .5,
                                layout: "form",
                                labelWidth: 70,
                                baseCls: "x-plain",
                                items: [{
                                    id: 'updateleaderreviewdate',
                                    fieldLabel: "经办时间",
                                    xtype: "datefield",
                                    format: "Y-m-d",
                                    value: new Date(selections[0].data.leaderreviewdate.time).format("Y-m-d"),
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
                                        license : PlateNumHead+"."+selections[0].data.license
                                    }
                            	  });
                            }.createDelegate(this)
                        },{
                            text: "提交",
                            handler: function() {
                                if (Ext.getCmp("updatecheckexpirydate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写年检有效期!");
                                    return
                                } else {
                                    if (Ext.util.Format.date(Ext.getCmp("updatecheckexpirydate").getValue(), 'Y-m-d') <= new Date()) {
                                        Ext.MessageBox.alert("提示", "请正确填写年检有效期!");
                                        return
                                    }
                                }
                                if (Ext.getCmp("updateinspector").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写检验人!");
                                    return
                                }
                                if (Ext.getCmp("updateinspectordate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写检验日期!");
                                    return
                                }
                                if (Ext.getCmp("updatecheckcompanyname").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写检验机构名称!");
                                    return
                                }
                                if (Ext.getCmp("updateinspectorresult").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写年检结论!");
                                    return
                                }
                                if (Ext.getCmp("updateinsurancelistno").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写检保单号!");
                                    return
                                }
                                if (Ext.getCmp("updateinsurancedate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写保险日期!");
                                    return
                                }
                                if (Ext.getCmp("updateinsurancecompanyname").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请选择保险公司名称!");
                                    return
                                }
                                if (Ext.getCmp("updateexpirydate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写保单有效期!");
                                    return
                                }
                                if (Ext.getCmp("updatereviewer").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写登记审核人!");
                                    return
                                }
                                if (Ext.getCmp("updatereviewerconductdate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办时间!");
                                    return
                                }
                                if (Ext.getCmp("updateissueadmin").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写牌证管理员!");
                                    return
                                }
                                if (Ext.getCmp("updateissueadmindate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办时间!");
                                    return
                                }
                                if (Ext.getCmp("updateleaderreview").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写业务领导审核!");
                                    return
                                }
                                if (Ext.getCmp("updateleaderreviewdate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写经办时间!");
                                    return
                                }
                                var checkdatevar = null;
                                if (selections[0].data.checkdate != null && selections[0].data.checkdate != "") {
                                    checkdatevar = new Date(selections[0].data.checkdate.time).format('Y-m-d');
                                }
                                Ext.Ajax.request({
                                    url: "main/carCheck.html?action=updateCarCheck",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            Ext.MessageBox.alert("提示", "修改成功!");
                                            Ext.getCmp("updatecarcheckWin").close();
                                            Ext.getCmp("carcheckMgr").getStore().reload();
                                        } else {
                                            Ext.Msg.alert("提示", "操作失败!");
                                        }
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>");
                                    },
                                    params: {
                                        id: selections[0].data.id,
                                        tractorinfoId: selections[0].data.tractorinfoId,
                                        orgintractorstate:selections[0].data.orgintractorstate,
                                        orgincheckresult:selections[0].data.orgincheckresult,              
                                        orgindisqualification:selections[0].data.orgindisqualification,
                                        orgincheckexpirydate:new Date(selections[0].data.orgincheckexpirydate.time).format('Y-m-d'),
                                        orgininspector:selections[0].data.orgincheckexpirydate,
                                        orgincheckdate:new Date(selections[0].data.orgincheckdate.time).format('Y-m-d'),
                                        orginshowinitialinspectionresult:selections[0].data.orginshowinitialinspectionresult,
                                        orginshowdisqualification:selections[0].data.orginshowdisqualification,
                                        orginshowexaminationresult:selections[0].data.orginshowexaminationresult,
                                        orginengineinitialinspectionresult:selections[0].data.orginengineinitialinspectionresult,
                                        orginenginedisqualification:selections[0].data.orginenginedisqualification,
                                        orginengineexaminationresult:selections[0].data.orginengineexaminationresult,
                                        orginconveyorinitialinspectionresult:selections[0].data.orginconveyorinitialinspectionresult,
                                        orginconveyordisqualification:selections[0].data.orginconveyordisqualification,
                                        orginconveyorexaminationresult:selections[0].data.orginconveyorexaminationresult,
                                        orginsteeringinitialinspectionresult:selections[0].data.orginsteeringinitialinspectionresult,
                                        orginsteeringdisqualification:selections[0].data.orginsteeringdisqualification,
                                        orginsteeringexaminationresult:selections[0].data.orginsteeringexaminationresult,
                                        orginflyhostinitialinspectionresult:selections[0].data.orginflyhostinitialinspectionresult,
                                        orginflyhostdisqualification:selections[0].data.orginflyhostdisqualification,
                                        orginflyhostexaminationresult:selections[0].data.orginflyhostexaminationresult,
                                        orginflytrailerinitialinspectionresult:selections[0].data.orginflytrailerinitialinspectionresult,
                                        orginflytrailerdisqualification:selections[0].data.orginflytrailerdisqualification,
                                        orginflytrailerexaminationresult:selections[0].data.orginflytrailerexaminationresult,
                                        orginbrakhostinitialinspectionresul:selections[0].data.orginbrakhostinitialinspectionresul,
                                        orginbrakhostdisqualification:selections[0].data.orginbrakhostdisqualification,
                                        orginbrakhostexaminationresult:selections[0].data.orginbraktrailerexaminationresult,
                                        orginbraktrailerinitialinspectionresult:selections[0].data.orginbraktrailerinitialinspectionresult,
                                        orginbraktrailerdisqualification:selections[0].data.orginbraktrailerdisqualification,
                                        orginbraktrailerexaminationresult:selections[0].data.orginbraktrailerexaminationresult,
                                        orginlighthostinitialinspectionresult:selections[0].data.orginlighthostinitialinspectionresult,
                                        orginlighthostdisqualification:selections[0].data.orginlighthostdisqualification,
                                        orginlighthostexaminationresult:selections[0].data.orginlighthostexaminationresult,
                                        orginlighttrailerinitialinspectionresult:selections[0].data.orginlighttrailerinitialinspectionresult,
                                        orginlighttrailerdisqualification:selections[0].data.orginlighttrailerdisqualification, 
                                        orginlighttrailerexaminationresult:selections[0].data.orginlighttrailerexaminationresult,
                                        orgintractioninitialinspectionresult:selections[0].data.orgintractioninitialinspectionresult,
                                        orgintractiondisqualification:selections[0].data.orgintractiondisqualification,
                                        orgintractionexaminationresult:selections[0].data.orgintractionexaminationresult,
                                        orgininsurancelistno:selections[0].data.orgininsurancelistno,
                                        orgininsurancedate: new Date(selections[0].data.orgininsurancedate.time).format('Y-m-d'),
                                        orgininsurancecompanyname:selections[0].data.insurancecompanyname,
                                        orginexpirydate:new Date(selections[0].data.orginexpirydate.time).format('Y-m-d'),
                                        
                                        inspectorresult: Ext.getCmp("updateinspectorresult").getValue(),
                                        checkexpirydate: Ext.util.Format.date(Ext.getCmp("updatecheckexpirydate").getValue(), 'Y-m-d'),
                                        inspector: Ext.getCmp("updateinspector").getValue(),
                                        inspectordate: Ext.util.Format.date(Ext.getCmp("updateinspectordate").getValue(), 'Y-m-d'),
                                        checkcompanyname: Ext.getCmp("updatecheckcompanyname").getValue(),
                                        
                                        currentdisqualification:Ext.getCmp("upcurrentdisqualification").getValue(),
                                        currentshowinitialinspectionresult:Ext.getCmp("upcurrentshowinitialinspectionresult").getValue(),
                                        currentshowdisqualification:Ext.getCmp("upcurrentshowdisqualification").getValue(),
                                        currentshowexaminationresult:Ext.getCmp("upcurrentshowexaminationresult").getValue(),
                                        currentengineinitialinspectionresult:Ext.getCmp("upcurrentengineinitialinspectionresult").getValue(),
                                        currentenginedisqualification:Ext.getCmp("upcurrentenginedisqualification").getValue(),
                                        currentengineexaminationresult:Ext.getCmp("upcurrentengineexaminationresult").getValue(),
                                        currentconveyorinitialinspectionresult:Ext.getCmp("upcurrentconveyorinitialinspectionresult").getValue(),
                                        currentconveyordisqualification:Ext.getCmp("upcurrentconveyordisqualification").getValue(),
                                        currentconveyorexaminationresult:Ext.getCmp("upcurrentconveyorexaminationresult").getValue(),
                                        currentsteeringinitialinspectionresult:Ext.getCmp("upcurrentsteeringinitialinspectionresult").getValue(),
                                        currentsteeringdisqualification:Ext.getCmp("upcurrentsteeringdisqualification").getValue(),
                                        currentsteeringexaminationresult:Ext.getCmp("upcurrentsteeringexaminationresult").getValue(),
                                        currentflyhostinitialinspectionresult:Ext.getCmp("upcurrentflyhostinitialinspectionresult").getValue(),
                                        currentflyhostdisqualification:Ext.getCmp("upcurrentflyhostdisqualification").getValue(),
                                        currentflyhostexaminationresult:Ext.getCmp("upcurrentflyhostexaminationresult").getValue(),
                                        currentflytrailerinitialinspectionresult:Ext.getCmp("upcurrentflytrailerinitialinspectionresult").getValue(),
                                        currentflytrailerdisqualification:Ext.getCmp("upcurrentflytrailerdisqualification").getValue(),
                                        currentflytrailerexaminationresult:Ext.getCmp("upcurrentflytrailerexaminationresult").getValue(),
                                        currentbrakhostinitialinspectionresult:Ext.getCmp("upcurrentbrakhostinitialinspectionresult").getValue(),
                                        currentbrakhostdisqualification:Ext.getCmp("upcurrentbrakhostdisqualification").getValue(),
                                        currentbrakhostexaminationresult:Ext.getCmp("upcurrentbrakhostexaminationresult").getValue(),
                                        currentbraktrailerinitialinspectionresult:Ext.getCmp("upcurrentbraktrailerinitialinspectionresult").getValue(),
                                        currentbraktrailerdisqualification:Ext.getCmp("upcurrentbraktrailerdisqualification").getValue(),
                                        currentbraktrailerexaminationresult:Ext.getCmp("upcurrentbraktrailerexaminationresult").getValue(),
                                        currentlighthostinitialinspectionresult:Ext.getCmp("upcurrentlighthostinitialinspectionresult").getValue(),
                                        currentlighthostdisqualification:Ext.getCmp("upcurrentlighthostdisqualification").getValue(),
                                        currentlighthostexaminationresult:Ext.getCmp("upcurrentlighthostexaminationresult").getValue(),
                                        currentlighttrailerinitialinspectionresult:Ext.getCmp("upcurrentlighttrailerinitialinspectionresult").getValue(),
                                        currentlighttrailerdisqualification:Ext.getCmp("upcurrentlighttrailerdisqualification").getValue(),
                                        currentlighttrailerexaminationresult:Ext.getCmp("upcurrentlighttrailerexaminationresult").getValue(),
                                        currenttractioninitialinspectionresult:Ext.getCmp("upcurrenttractioninitialinspectionresult").getValue(),
                                        currenttractiondisqualification:Ext.getCmp("upcurrenttractiondisqualification").getValue(),
                                        currenttractionexaminationresult:Ext.getCmp("upcurrenttractionexaminationresult").getValue(),                                         
                                        insurancelistno: Ext.getCmp("updateinsurancelistno").getValue(),
                                        insurancedate: Ext.util.Format.date(Ext.getCmp("updateinsurancedate").getValue(), 'Y-m-d'),
                                        insurancecompanyname: Ext.getCmp("updateinsurancecompanyname").getValue(),
                                        expirydate: Ext.util.Format.date(Ext.getCmp("updateexpirydate").getValue(), 'Y-m-d'),
                                        reviewer: Ext.getCmp("updatereviewer").getValue(),
                                        reviewerconductdate: Ext.util.Format.date(Ext.getCmp("updatereviewerconductdate").getValue(), 'Y-m-d'),
                                        issueadmin: Ext.getCmp("updateissueadmin").getValue(),
                                        issueadmindate: Ext.util.Format.date(Ext.getCmp("updateissueadmindate").getValue(), 'Y-m-d'),
                                        leaderreview: Ext.getCmp("updateleaderreview").getValue(),
                                        leaderreviewdate: Ext.util.Format.date(Ext.getCmp("updateleaderreviewdate").getValue(), 'Y-m-d'),
                                        operateuser: selections[0].data.operateuser,
                                        operatedate: new Date(selections[0].data.operatedate.time).format('Y-m-d'),
                                        checkuser: selections[0].data.checkuser,
                                        checkdate: checkdatevar,
                                        checkip: selections[0].data.checkip,
                                        checkresult: selections[0].data.checkresult,
                                        checkcontext: selections[0].data.checkcontext,
                                        checktype: selections[0].data.checktype
                                    }
                                });
                            }
                        },
                        {
                            text: "取消",
                            handler: function() {
                                Ext.getCmp("updatecarcheckWin").close();
                            }
                        }]
                    }).show();

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
                        if (selections[i].data.checkresult == 1 || selections[i].data.checkresult == 2) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、审核未通过】的信息进行删除！");
                            return;
                        }
                    }
                    var delcarcheckids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkresult != 2) {
//                            if (selections[i].data.checktype == 0) {
//                                updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
//                            }
									updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
                        }
                        if (delcarcheckids.length == 0) {
                            delcarcheckids = delcarcheckids + selections[i].data.id;
                        } else {
                            delcarcheckids = delcarcheckids + "," + selections[i].data.id;
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
                                    url: "main/carCheck.html?action=delCarCheck",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("carcheckMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        mydelcarcheckids: delcarcheckids,
                                        tractorids: updatetractorids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },{
            	id : 'registeryear',
                xtype:"combo",
                displayField : 'myyear',
                valueField : 'myyear',
                typeAhead : true,
                mode : 'local',
                editable : false,
                selectOnFoucs : true,
                triggerAction : 'all',
                emptyText:"根据拖拉机注册日期选择",
                store:Ynzc.manage.RegisterYearStroe,
                listeners:{
                    "select":function(){
            			ds.baseParams.registeryear = this.value;
                        ds.load({
                            params:{
                                start:0,
                                limit:20
                            }
                        });
                    }
                }
            },{
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
                            id: "searchcarchecktype",
                            fieldLabel: "年检类型",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            value: '--请选择--',
                            store: Ynzc.manage.CarCheckTypeData,
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                            ds.baseParams.registeryear = Ext.getCmp("registeryear").value;
                        	ds.reload({
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
                                        checktype: Ext.getCmp("searchcarchecktype").getValue()
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
            },{
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
	        					title:'打印业务流程记录单',
	        					sourceURL:'main/carCheck.html?action=carCheckInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            }],
            bbar: new pgtoolbar({
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
        Ynzc.manage.CarCheckGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });
    }
});
Ext.reg('carcheckgrid', Ynzc.manage.CarCheckGrid);