Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.AuditCarCheckGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'auditcarcheckgrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">年检业务</td></tr>', '<tr><td>检验结论</td><td>{inspectorresult}</td><td>检验有效期</td><td>{[values.checkexpirydate==null?"":new Date(values.checkexpirydate.time).format("Y-m-d")]}</td><td>检验人</td><td>{inspector}</td></tr>', '<tr><td>检验时间</td><td>{[values.inspectordate==null?"":new Date(values.inspectordate.time).format("Y-m-d")]}</td><td>检验机构名称</td><td>{checkcompanyname}</td><td>保单号</td><td>{insurancelistno}</td></tr>', '<tr><td>保险公司名称</td><td>{insurancecompanyname}</td><td>保险日期</td><td>{[values.insurancedate==null?"":new Date(values.insurancedate.time).format("Y-m-d")]}</td><td>保险有效期</td><td>{[values.expirydate==null?"":new Date(values.expirydate.time).format("Y-m-d")]}</td></tr>', '<tr><td colspan="6">车辆信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '<tr><td>检验结论</td><td>{tractorinfocheckresult}</td><td>检验有效期</td><td>{[new Date(values.tractorinfocheckexpirydate.time).format("Y-m-d")]}</td><td>检验人</td><td>{tractorinfoinspector}</td></tr>', '<tr><td>检验时间</td><td>{[new Date(values.tractorinfocheckdate.time).format("Y-m-d")]}</td><td>保单号</td><td>{tractorinfoinsurancelistno}</td><td>保险公司名称</td><td>{tractorinfoinsurancecompanyname}</td></tr>', '<tr><td>保险日期</td><td>{[new Date(values.tractorinfoinsurancedate.time).format("Y-m-d")]}</td><td>保险有效期</td><td colspan="3">{[new Date(values.tractorinfoexpirydate.time).format("Y-m-d")]}</td></tr>', '</table>')
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
            dataIndex: "plantType"
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
            header: '检验有效期',
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
                    return '<font color=red>待审</font>';
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
                name: 'plantType'
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
            id: 'auditcarcheckgrid',
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
                text: "通过审核",
                iconCls: "icon-Add",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要审核的年检信息!");
                        return;
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkresult != 1) {
                            Ext.MessageBox.alert("提示", "只能对【待审】的信息进行审核！");
                            return;
                        }
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                    	rds.push(selections[i].data);
                    }
                    Ext.Msg.show({
                        title: '系统确认',
                        msg: '你是否确认对选中的年检信息进行审核?',
                        buttons: Ext.Msg.YESNO,
                        scope: this,
                        icon: Ext.MessageBox.QUESTION,
                        fn: function(btn) {
                            if (btn == "yes") {
                                                            var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在读取数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                Ext.Ajax.request({
                                    url: "main/carCheck.html?action=AuditCarCheck",
                                    method: "post",
                                    success: function() {
                                    mask.hide();
                                        Ext.MessageBox.alert("提示", "审核成功");
                                        Ext.getCmp("auditcarMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        auditcarcheckinfo: Ext.util.JSON.encode(rds),
                                        state: 2
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
                text: "审核未通过",
                iconCls: "icon-Del",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要审核的年检信息!");
                        return;
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkresult == 3) {
                            Ext.MessageBox.alert("提示", "只能对【待审、审核通过】的信息进行审核！");
                            return;
                        }
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                    	rds.push(selections[i].data);
                    }
                    new Ext.Window({
                        id: "auditWin",
                        title: "请填写审核意见",
                        modal: true,
                        height: 220,
                        width: 400,
                        layout: "form",
                        labelWidth: 80,
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            id: "context",
                            fieldLabel: "审核意见",
                            xtype: "textarea",
                            height: 120,
                            anchor: "98%"
                        }],
                        buttons: [{
                            text: "提交",
                            handler: function() {
                                if (Ext.getCmp("context").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写审核意见！");
                                    return;
                                }
                                                                var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在读取数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                Ext.Ajax.request({
                                    url: "main/carCheck.html?action=AuditCarCheck",
                                    method: "post",
                                    success: function() {
                                    mask.hide();
                                        Ext.MessageBox.alert("提示", "审核成功.");
                                        Ext.getCmp("auditWin").close();
                                        Ext.getCmp("auditcarMgr").getStore().reload();
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                    	auditcarcheckinfo: Ext.util.JSON.encode(rds),
                                        checkcontext: Ext.getCmp("context").getValue(),
                                        state: 3
                                    }
                                });
                            }
                        }]
                    }).show();

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
                        	Ext.getCmp("auditcarMgr").getStore().reload({
                                    params: {
                                        start: 0,
                                        limit: 20,
                                        state: "1,2,3",
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
                state: "1,2,3"
            }
        });
    }
});
Ext.reg('auditcarcheckgrid', Ynzc.manage.AuditCarCheckGrid);