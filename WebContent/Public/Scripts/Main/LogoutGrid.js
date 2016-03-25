Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.LogoutGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'logoutgrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
					'<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">',
					'<tr><td colspan="6">所有人信息</td></tr>',
					'<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>',
					'<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>',
					'<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>',
					'<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>',
					'<tr><td>品牌型号</td><td>{tractorinfoplantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>',
					'<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>',
					'<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>',
					'<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>',
					'<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>',
					'<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>',
					'<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>',
					'<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>',
					'<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>',
					'<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>',
					'<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>',
					'</table>'
				  )
		});
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '申请事项',
            sortable: true,
            dataIndex: "logtouttype",
            renderer: function(value) {
                if (value == 0) {
                    return '注销';
                } else if (value == 1) {
                    return '停驶';
                } else if (value == 2) {
                    return '复驶';
                }
            }
        },
        {
            header: '管辖区',
            sortable: true,
            dataIndex: "region"
        },
        {
            header: '报废编号',
            sortable: true,
            dataIndex: "logoutnum"
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
            header: '车主',
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
            header: '发动机号',
            sortable: true,
            dataIndex: "engineno"
        },
        {
            header: '机驾号码',
            sortable: true,
            dataIndex: "shelfno"
        },
        {
            header: '申请理由',
            sortable: true,
            dataIndex: "logoutreasons",
            renderer: function(value) {
                if (value == 0) {
                    return '报废';
                } else if (value == 1) {
                    return '丢失';
                } else if (value == 2) {
                    return '其他';
                }
            }
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
                name: 'logtouttype'
            },
            {
                name: 'logoutnum'
            },
            {
                name: 'relationinfo'
            },
            {
                name: 'logoutreasons'
            },
            {
                name: 'stopdate'
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
            {name : 'unitid'},{name:'license'},{name : 'checkeddate'},{name : 'recorder'},{name : 'status'},{name:'regcerno'},{name : 'tractorinforegisterdate'},
            {name : 'ownerinfoid'},{name:'owner'},{name : 'realcertificatetypeid'},{name : 'realcertificateno'},{name : 'tractorinfoaddress'},{name:'tempaddress'},{name : 'istemplived'},
            {name : 'templivefiletypeid'},{name:'timplivefileno'},{name : 'telephone'},{name : 'isUnion'},{name : 'tractorinfozipcode'},{name:'technicalinspectid'},{name : 'tractorinfocheckresult'},
            {name : 'tractorinfocheckexpirydate'},{name:'tractorinfoinspector'},{name : 'tractorinfocheckdate'},{name : 'handlingsituationid'},{name : 'tractorinforeviewer'},{name:'tractorinforeviewerconductdate'},{name : 'tractorinfoissueadmin'},
            {name : 'tractorinfoleaderreview'},{name:'leaderreviewconductdate'},{name : 'tractorinfoissueadmindate'},{name : 'getwayid'},{name : 'tractorinfomachinetypeid'},{name:'machinebrandtypeid'},{name : 'machinebodyno'},
            {name : 'engineno'},{name:'shelfno'},{name : 'usedfor'},{name : 'manufacturer'},{name : 'seller'},{name:'manufacturedate'},{name : 'tractorinfoprice'},
            {name : 'tractorinfophotourl'},{name:'tractorinfogetwayfiletypeid'},{name : 'getwayfileno'},{name : 'tractorinfoimportsfiletypeid'},{name : 'importsfileno'},{name:'tractorinfoother'},{name : 'tractorinfoinsurancelistno'},
            {name : 'tractorinfoinsurancecompanyname'},{name:'tractorinfoinsurancedate'},{name : 'tractorinfoexpirydate'},{name : 'registerdate'},{name : 'turnindate'},{name:'issuedate'},{name : 'beforeregion'},
            {name : 'machinebodycolor'},{name:'tractorinfodirectcontrol'},{name : 'tractorinfoenginebrandid'},{name : 'tractorinfofueltypeid'},{name : 'tractorinfotireson'},{name:'tractorinfototalquality'},{name : 'tractorinfoallowdragtotalquality'},
            {name : 'tractorinfovicecartiresno'},{name:'outsize'},{name : 'tractorinfocontainersize'},{name : 'tractorinfopower'},{name : 'tractorcylinderno'},{name:'tractorinfowheelo'},{name : 'tractorinfotiressize'},
            {name : 'tractorinfoallquality'},{name:'tractorinfodriverinno'},{name : 'tractorinfooutcarwheeldis'},{name : 'tractorinfowheelbase'},{name : 'tractorinfowheeldis'},{name:'tractorinforatifiedload'},{name : 'tractorinfosteelspring'},
            {name : 'tractorinfooutcartiressize'},{name:'region'},{name : 'regionid'},{name : 'useunit'},{name : 'responsiblemen'},{name:'tractorinfolinktel'},{name : 'unitaddress'},
            {name : 'platecode'},{name:'tractorinfomachinetype'},{name : 'tractorengineBrand'},{name : 'fuelname'},{name : 'realcertificatetype'},{name:'tractorinfotemplivefileType'},{name : 'tractorinfogetway'},
            {name : 'getWayFileType'},{name:'importsFileType'},{name : 'tractorinfoplantType'}]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/logout.html?action=getLogoutViewListByPage',
            reader: reader,
            baseParams:{state:"0,1,2"},
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'logoutgrid',
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
                text: "注销登记",
                iconCls: "icon-Add",
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
                         buttonAlign:"center",
                         items: [{
                         xtype:"label",
                         html:PlateNumHead+".&nbsp;&nbsp;"
                         },{
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
                                var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在读取数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                Ext.Ajax.request({
                                    url: 'main/tractorInfoView.html?action=IsExits',
                                    method: "post",
                                    success: function(resp) {
                                    	mask.hide();
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            Ext.getCmp("inputCodeNumWin").close();
                                            new Ext.Window({
                                                id: "logoutWin",
                                                title: "注销登记",
                                                iconCls: 'icon-Add',
                                                resizable: false,
                                                modal: true,
                                                height: 450,
                                                width: 700,
                                                items: [{
                                                	id:'logouttabpanel',
                                                    xtype: 'tabpanel',
                                                    border: false,
                                                    frame: true,
                                                    activeTab: 0,
                                                    items: [{
                                                        title: '车辆信息',
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
                                                                id: "ownername",
                                                                fieldLabel: "姓名",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.owner
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "lintel",
                                                                fieldLabel: "联系电话",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.telephone
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "cardidtype",
                                                                fieldLabel: "身份证明名称",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.realcertificatetype
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "carid",
                                                                fieldLabel: "身份证明号码",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.realcertificateno
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "isunit",
                                                                fieldLabel: "单位/个人",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "address",
                                                                fieldLabel: "住所地址",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.tempaddress
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
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.zipCode
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "istemplive",
                                                                fieldLabel: "是否暂住",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "plantType",
                                                                fieldLabel: "品牌型号",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.plantType
                                                            },
                                                            {
                                                                id: "machinetype",
                                                                fieldLabel: "机械类型",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.machinetype
                                                            },
                                                            {
                                                                id: "machinebodyno",
                                                                fieldLabel: "机身底盘号",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.machinebodyno
                                                            },
                                                            {
                                                                id: "engineno",
                                                                fieldLabel: "发动机号",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                value: result.reson.engineno
                                                            },
                                                            {
                                                                id: "registerdate",
                                                                fieldLabel: "注册日期",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                format: "Y-m-d"
                                                            },
                                                            {
                                                                id: "turnindate",
                                                                fieldLabel: "转入日期",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                format: "Y-m-d"
                                                            },
                                                            {
                                                                id: "issuedate",
                                                                fieldLabel: "发牌证日期",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                format: "Y-m-d",
                                                                value: new Date(result.reson.issuedate.time).format("Y-m-d")
                                                            },
                                                            {
                                                                id: "checkexpirydate",
                                                                fieldLabel: "检验有效期",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                format: "Y-m-d",
                                                                value: new Date(result.reson.checkexpirydate.time).format("Y-m-d")
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                xtype: "box",
                                                                height: 180,
                                                                width: 300,
                                                                autoEl: {
                                                                    tag: 'img',
                                                                    src: result.reson.photourl
                                                                }
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: .5,
                                                            layout: "form",
                                                            labelWidth: 80,
                                                            items: [{
                                                                id: "expirydate",
                                                                fieldLabel: "保险有效期",
                                                                xtype: "textfield",
                                                                anchor: '90%',
                                                                readOnly: true,
                                                                format: "Y-m-d",
                                                                value: new Date(result.reson.expirydate.time).format("Y-m-d")
                                                            }]
                                                        }]
                                                    },
                                                    {
                                                        title: '注销登记',
                                                        frame: true,
                                                        bodyStyle: "padding:5px 5px",
                                                        autoScroll: true,
                                                        height: 375,
                                                        layout: "column",
                                                        items: [{
                                                            columnWidth: 1,
                                                            layout: 'fit',
                                                            items: [{
                                                                id: "logtouttypefield",
                                                                title: "申请事项",
                                                                xtype: "fieldset",
                                                                height: 30,
                                                                layout: "column",
                                                                items: [{
                                                                    columnWidth: .3,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        id: "logtouttype",
                                                                        name: "logtouttypegroup",
                                                                        xtype: "radio",
                                                                        boxLabel: "注销",
                                                                        checked:true,
                                                                        anchor: '98%',
                                                                        inputValue: "0"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .3,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        name: "logtouttypegroup",
                                                                        xtype: "radio",
                                                                        boxLabel: "停驶",
                                                                        anchor: '98%',
                                                                        inputValue: "1"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .3,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        name: "logtouttypegroup",
                                                                        xtype: "radio",
                                                                        boxLabel: "复驶",
                                                                        anchor: '98%',
                                                                        inputValue: "2"
                                                                    }]
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: 'fit',
                                                            items: [{
                                                                id: "requestinfo",
                                                                title: "申请明细",
                                                                xtype: "fieldset",
                                                                height: 100,
                                                                layout: "column",
                                                                items: [{
                                                                    columnWidth: .4,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "relationinfoOne",
                                                                        fieldLabel: "相关资料",
                                                                        boxLabel: "拖拉机登记证书",
                                                                        xtype: "checkbox",
                                                                        inputValue: "拖拉机登记证书"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .2,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        id: "relationinfoSecond",
                                                                        boxLabel: "拖拉机号牌",
                                                                        xtype: "checkbox",
                                                                        inputValue: "拖拉机号牌"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .15,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        id: "relationinfoThree",
                                                                        boxLabel: "行驶证",
                                                                        xtype: "checkbox",
                                                                        inputValue: "行驶证"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .25,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        id: "relationinfoFour",
                                                                        boxLabel: "报废拖拉机回收证明副本",
                                                                        xtype: "checkbox",
                                                                        inputValue: "报废拖拉机回收证明副本"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .4,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "logoutreasons",
                                                                        name: "logoutreasonsgroup",
                                                                        xtype: "radio",
                                                                        fieldLabel: "注销原因",
                                                                        checked:true,
                                                                        boxLabel: "报废",
                                                                        anchor: '98%',
                                                                        inputValue: "0"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .3,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        name: "logoutreasonsgroup",
                                                                        xtype: "radio",
                                                                        boxLabel: "丢失",
                                                                        anchor: '98%',
                                                                        inputValue: "1"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .3,
                                                                    layout: "fit",
                                                                    items: [{
                                                                        name: "logoutreasonsgroup",
                                                                        xtype: "radio",
                                                                        boxLabel: "其他",
                                                                        anchor: '98%',
                                                                        inputValue: "2"
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: 1,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "stopdate",
                                                                        fieldLabel: "停驶期限",
                                                                        xtype: "datefield",
                                                                        format: "Y-m-d",
                                                                        anchor: '90%'
                                                                    }]
                                                                }]
                                                            }]
                                                        },
                                                        {
                                                            columnWidth: 1,
                                                            layout: 'fit',
                                                            items: [{
                                                                id: "handinfo",
                                                                title: "经办情况",
                                                                xtype: "fieldset",
                                                                height: 80,
                                                                layout: "column",
                                                                items: [{
                                                                    columnWidth: .5,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "checkinmen",
                                                                        fieldLabel: "登记审核人",
                                                                        xtype: "textfield",
                                                                        value:result.reson.reviewer,
                                                                        anchor: '90%'
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .5,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "checkindate",
                                                                        fieldLabel: "经办时间",
                                                                        value:new Date(),
                                                                        xtype: "datefield",
                                                                        format: "Y-m-d",
                                                                        anchor: '90%'
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .5,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "licensemen",
                                                                        fieldLabel: "牌证管理员",
                                                                        xtype: "textfield",
                                                                        value:result.reson.issueadmin,
                                                                        anchor: '90%'
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .5,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "licensedate",
                                                                        fieldLabel: "经办时间",
                                                                        value:new Date(),
                                                                        xtype: "datefield",
                                                                        format: "Y-m-d",
                                                                        anchor: '90%'
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .5,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "businessmen",
                                                                        fieldLabel: "业务领导审核",
                                                                        xtype: "textfield",
                                                                        value:result.reson.leaderreview,
                                                                        anchor: '90%'
                                                                    }]
                                                                },
                                                                {
                                                                    columnWidth: .5,
                                                                    layout: "form",
                                                                    border: false,
                                                                    labelWidth: 80,
                                                                    items: [{
                                                                        id: "businessdate",
                                                                        fieldLabel: "经办时间",
                                                                        value:new Date(),
                                                                        xtype: "datefield",
                                                                        format: "Y-m-d",
                                                                        anchor: '90%'
                                                                    }]
                                                                }]
                                                            }]
                                                        }]
                                                    }]
                                                }],
                                                buttons: [{
                                                    text: "详细信息",
                                                    handler: function() {
                                                        var mask = new Ext.LoadMask(Ext.getBody(), {
															msg : '正在读取数据,请稍等...',
															removeMask:true
														});
														mask.show();
                                                        	Ext.Ajax.request({
                                                           	 url:'main/tractorInfo.html?action=GetAllTractorInfo',
                                                           	 method:'post',
                                                   			 success:function(resp){
                                                   			 	mask.hide();
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
	                                                	if(Ext.getCmp("logouttabpanel").getActiveTab().title === '车辆信息'){
	                                                    	Ext.MessageBox.alert("提示", "请选择申请事项.");
	                                                        return;
	                                                    }
                                                        var logtouttypeStr = "";
                                                        if (Ext.getCmp("relationinfoOne").checked) {
                                                            logtouttypeStr = logtouttypeStr + Ext.getCmp("relationinfoOne").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("relationinfoSecond").checked) {
                                                            logtouttypeStr = logtouttypeStr + Ext.getCmp("relationinfoSecond").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("relationinfoThree").checked) {
                                                            logtouttypeStr = logtouttypeStr + Ext.getCmp("relationinfoThree").inputValue + ",";
                                                        }
                                                        if (Ext.getCmp("relationinfoFour").checked) {
                                                            logtouttypeStr = logtouttypeStr + Ext.getCmp("relationinfoFour").inputValue + ",";
                                                        }
                                                        var stopdatevar = null;
                                                        if (Ext.getCmp("stopdate").getValue() != "") {
                                                            stopdatevar = Ext.util.Format.date(Ext.getCmp("stopdate").getValue(), 'Y-m-d');
                                                        }
                                                        if (Ext.getCmp("logtouttype").getGroupValue() == "0") {
                                                            if (Ext.getCmp("logoutreasons").getGroupValue() == null) {
                                                                Ext.MessageBox.alert("提示", "请选择注销原因.");
                                                                return;
                                                            }
                                                        }
                                                        if (Ext.getCmp("checkinmen").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写登记审核人.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("checkindate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写登记审核人经办时间.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("licensemen").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写牌证管理员.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("licensedate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写牌证管理员经办时间.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("businessmen").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写业务领导审核.");
                                                            return;
                                                        }
                                                        if (Ext.getCmp("businessdate").getValue() == "") {
                                                            Ext.MessageBox.alert("提示", "请填写业务领导审核经办时间.");
                                                            return;
                                                        }
                                                        var mask = new Ext.LoadMask(Ext.getBody(), {
															msg : '正在录入数据,请稍等...',
															removeMask:true
														});
														mask.show();
                                                        Ext.Ajax.request({
                                                            url: 'main/logout.html?action=addLogout',
                                                            method: "post",
                                                            success: function() {
                                                            	mask.hide();
                                                                Ext.MessageBox.alert("提示", "注销登记成功.");
                                                                Ext.getCmp("logoutWin").close();
                                                                Ext.getCmp("logoutMgr").getStore().reload();
                                                            },
                                                            failure: function() {
                                                                Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                            },
                                                            params: {
                                                                tractorinfoid: result.reson.id,
                                                                logtouttype: Ext.getCmp("logtouttype").getGroupValue(),
                                                                relationinfo: logtouttypeStr,
                                                                logoutreasons: Ext.getCmp("logoutreasons").getGroupValue(),
                                                                stopdate: stopdatevar,
                                                                checkinmen: Ext.getCmp("checkinmen").getValue(),
                                                                checkindate: Ext.util.Format.date(Ext.getCmp("checkindate").getValue(), 'Y-m-d'),
                                                                licensemen: Ext.getCmp("licensemen").getValue(),
                                                                licensedate: Ext.util.Format.date(Ext.getCmp("licensedate").getValue(), 'Y-m-d'),
                                                                businessmen: Ext.getCmp("businessmen").getValue(),
                                                                businessdate: Ext.util.Format.date(Ext.getCmp("businessdate").getValue(), 'Y-m-d')
                                                            }
                                                        });
                                                    }

                                                }]

                                            }).show();
                                            if (result.reson.istemplived == 0) {
                                                Ext.getCmp("istemplive").setValue("常住人口");
                                            } else {
                                                Ext.getCmp("istemplive").setValue("暂住人口");
                                            }
                                            if (result.reson.isUnion == 0) {
                                                Ext.getCmp("isunit").setValue("个人");
                                            } else {
                                                Ext.getCmp("isunit").setValue("单位");
                                            }
                                        } else {
                                            Ext.Msg.alert("提示", result.reson)
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
                    var logoutids = "";
                    for (i = 0; i < n; i++) {
                        if (logoutids.length == 0) {
                            logoutids = logoutids + selections[i].data.id;
                        } else {
                            logoutids = logoutids + "," + selections[i].data.id;
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
								var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在录入数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                Ext.Ajax.request({
                                    url: 'main/logout.html?action=ReportedLogOut',
                                    method: "post",
                                    success: function() {
                                    	mask.hide();
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("logoutMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reportlogoutids: logoutids
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
                        id: "updatelogoutWin",
                        title: "修改注销登记",
                        iconCls: 'icon-Add',
                        resizable: false,
                        modal: true,
                        height: 450,
                        width: 700,
                        items: [{
                        	id:'logoutupdatetabpanel',
                            xtype: 'tabpanel',
                            border: false,
                            frame: true,
                            activeTab: 0,
                            items: [{
                                title: '车辆信息',
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
                                        id: "updateownername",
                                        fieldLabel: "姓名",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.owner
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updatelintel",
                                        fieldLabel: "联系电话",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.telephone
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updatecardidtype",
                                        fieldLabel: "身份证明名称",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.realcertificatetype
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updatecarid",
                                        fieldLabel: "身份证明号码",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.realcertificateno
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updateisunit",
                                        fieldLabel: "单位/个人",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updateaddress",
                                        fieldLabel: "住所地址",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.tempaddress
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updatezipcode",
                                        fieldLabel: "邮政编码",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.tractorinfozipcode
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updateistemplive",
                                        fieldLabel: "是否暂住",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updateplantType",
                                        fieldLabel: "品牌型号",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.tractorinfoplantType
                                    },
                                    {
                                        id: "updatemachinetype",
                                        fieldLabel: "机械类型",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.tractorinfomachinetype
                                    },
                                    {
                                        id: "updatemachinebodyno",
                                        fieldLabel: "机身底盘号",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.machinebodyno
                                    },
                                    {
                                        id: "updateengineno",
                                        fieldLabel: "发动机号",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        value: selections[0].data.engineno
                                    },
                                    {
                                        id: "updateregisterdate",
                                        fieldLabel: "注册日期",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        format: "Y-m-d",
                                        value: new Date(selections[0].data.registerdate.time).format("Y-m-d")
                                    },
                                    {
                                        id: "updateturnindate",
                                        fieldLabel: "转入日期",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        format: "Y-m-d",
                                        value: new Date(selections[0].data.turnindate.time).format("Y-m-d")
                                    },
                                    {
                                        id: "updateissuedate",
                                        fieldLabel: "发牌证日期",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        format: "Y-m-d",
                                        value: new Date(selections[0].data.issuedate.time).format("Y-m-d")
                                    },
                                    {
                                        id: "updatecheckexpirydate",
                                        fieldLabel: "检验有效期",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        format: "Y-m-d",
                                        value: new Date(selections[0].data.tractorinfocheckexpirydate.time).format("Y-m-d")
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updatephoturl",
                                        xtype: "box",
                                        height: 180,
                                        width: 300,
                                        autoEl: {
                                            tag: 'img',
                                            src: selections[0].data.tractorinfophotourl
                                        }
                                    }]
                                },
                                {
                                    columnWidth: .5,
                                    layout: "form",
                                    labelWidth: 80,
                                    items: [{
                                        id: "updateexpirydate",
                                        fieldLabel: "保险有效期",
                                        xtype: "textfield",
                                        anchor: '90%',
                                        readOnly: true,
                                        format: "Y-m-d",
                                        value: new Date(selections[0].data.tractorinfoexpirydate.time).format("Y-m-d")
                                    }]
                                }]
                            },
                            {
                                title: '注销登记',
                                frame: true,
                                bodyStyle: "padding:5px 5px",
                                autoScroll: true,
                                height: 375,
                                layout: "column",
                                items: [{
                                    columnWidth: 1,
                                    layout: 'fit',
                                    items: [{
                                        id: "updatelogtouttypefield",
                                        title: "申请事项",
                                        xtype: "fieldset",
                                        height: 30,
                                        layout: "column",
                                        items: [{
                                            columnWidth: .3,
                                            layout: "fit",
                                            items: [{
                                                id: "updatelogtouttype",
                                                name: "updatelogtouttypegroup",
                                                xtype: "radio",
                                                boxLabel: "注销",
                                                anchor: '98%',
                                                inputValue: "0"
                                            }]
                                        },
                                        {
                                            columnWidth: .3,
                                            layout: "fit",
                                            items: [{
                                                name: "updatelogtouttypegroup",
                                                xtype: "radio",
                                                boxLabel: "停驶",
                                                anchor: '98%',
                                                inputValue: "1"
                                            }]
                                        },
                                        {
                                            columnWidth: .3,
                                            layout: "fit",
                                            items: [{
                                                name: "updatelogtouttypegroup",
                                                xtype: "radio",
                                                boxLabel: "复驶",
                                                anchor: '98%',
                                                inputValue: "2"
                                            }]
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    layout: 'fit',
                                    items: [{
                                        id: "updaterequestinfo",
                                        title: "申请明细",
                                        xtype: "fieldset",
                                        height: 100,
                                        layout: "column",
                                        items: [{
                                            columnWidth: .4,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updaterelationinfoOne",
                                                fieldLabel: "相关资料",
                                                boxLabel: "拖拉机登记证书",
                                                xtype: "checkbox",
                                                inputValue: "拖拉机登记证书"
                                            }]
                                        },
                                        {
                                            columnWidth: .2,
                                            layout: "fit",
                                            items: [{
                                                id: "updaterelationinfoSecond",
                                                boxLabel: "拖拉机号牌",
                                                xtype: "checkbox",
                                                inputValue: "拖拉机号牌"
                                            }]
                                        },
                                        {
                                            columnWidth: .15,
                                            layout: "fit",
                                            items: [{
                                                id: "updaterelationinfoThree",
                                                boxLabel: "行驶证",
                                                xtype: "checkbox",
                                                inputValue: "行驶证"
                                            }]
                                        },
                                        {
                                            columnWidth: .25,
                                            layout: "fit",
                                            items: [{
                                                id: "updaterelationinfoFour",
                                                boxLabel: "报废拖拉机回收证明副本",
                                                xtype: "checkbox",
                                                inputValue: "报废拖拉机回收证明副本"
                                            }]
                                        },
                                        {
                                            columnWidth: .4,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatelogoutreasons",
                                                name: "updatelogoutreasonsgroup",
                                                xtype: "radio",
                                                fieldLabel: "注销原因",
                                                boxLabel: "报废",
                                                anchor: '98%',
                                                inputValue: "0"
                                            }]
                                        },
                                        {
                                            columnWidth: .3,
                                            layout: "fit",
                                            items: [{
                                                name: "updatelogoutreasonsgroup",
                                                xtype: "radio",
                                                boxLabel: "丢失",
                                                anchor: '98%',
                                                inputValue: "1"
                                            }]
                                        },
                                        {
                                            columnWidth: .3,
                                            layout: "fit",
                                            items: [{
                                                name: "updatelogoutreasonsgroup",
                                                xtype: "radio",
                                                boxLabel: "其他",
                                                anchor: '98%',
                                                inputValue: "2"
                                            }]
                                        },
                                        {
                                            columnWidth: 1,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatestopdate",
                                                fieldLabel: "停驶期限",
                                                xtype: "datefield",
                                                format: "Y-m-d",
                                                anchor: '90%'
                                            }]
                                        }]
                                    }]
                                },
                                {
                                    columnWidth: 1,
                                    layout: 'fit',
                                    items: [{
                                        id: "updatehandinfo",
                                        title: "经办情况",
                                        xtype: "fieldset",
                                        height: 80,
                                        layout: "column",
                                        items: [{
                                            columnWidth: .5,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatecheckinmen",
                                                fieldLabel: "登记审核人",
                                                xtype: "textfield",
                                                anchor: '90%',
                                                value: selections[0].data.checkinmen
                                            }]
                                        },
                                        {
                                            columnWidth: .5,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatecheckindate",
                                                fieldLabel: "经办时间",
                                                xtype: "datefield",
                                                format: "Y-m-d",
                                                anchor: '90%',
                                                value: new Date(selections[0].data.checkindate.time).format("Y-m-d")
                                            }]
                                        },
                                        {
                                            columnWidth: .5,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatelicensemen",
                                                fieldLabel: "牌证管理员",
                                                xtype: "textfield",
                                                anchor: '90%',
                                                value: selections[0].data.licensemen
                                            }]
                                        },
                                        {
                                            columnWidth: .5,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatelicensedate",
                                                fieldLabel: "经办时间",
                                                xtype: "datefield",
                                                format: "Y-m-d",
                                                anchor: '90%',
                                                value: new Date(selections[0].data.licensedate.time).format("Y-m-d")
                                            }]
                                        },
                                        {
                                            columnWidth: .5,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatebusinessmen",
                                                fieldLabel: "业务领导审核",
                                                xtype: "textfield",
                                                anchor: '90%',
                                                value: selections[0].data.businessmen
                                            }]
                                        },
                                        {
                                            columnWidth: .5,
                                            layout: "form",
                                            border: false,
                                            labelWidth: 80,
                                            items: [{
                                                id: "updatebusinessdate",
                                                fieldLabel: "经办时间",
                                                xtype: "datefield",
                                                format: "Y-m-d",
                                                anchor: '90%',
                                                value: new Date(selections[0].data.businessdate.time).format("Y-m-d")
                                            }]
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
                            text: "提交",
                            handler: function() {
                            	if(Ext.getCmp("logoutupdatetabpanel").getActiveTab().title === '车辆信息'){
                                	Ext.MessageBox.alert("提示", "请选择申请事项.");
                                    return;
                                }
                                var logtouttypeStr = "";
                                if (Ext.getCmp("updaterelationinfoOne").checked) {
                                    logtouttypeStr = logtouttypeStr + Ext.getCmp("updaterelationinfoOne").inputValue + ",";
                                }
                                if (Ext.getCmp("updaterelationinfoSecond").checked) {
                                    logtouttypeStr = logtouttypeStr + Ext.getCmp("updaterelationinfoSecond").inputValue + ",";
                                }
                                if (Ext.getCmp("updaterelationinfoThree").checked) {
                                    logtouttypeStr = logtouttypeStr + Ext.getCmp("updaterelationinfoThree").inputValue + ",";
                                }
                                if (Ext.getCmp("updaterelationinfoFour").checked) {
                                    logtouttypeStr = logtouttypeStr + Ext.getCmp("updaterelationinfoFour").inputValue + ",";
                                }
                                var stopdatevar = null;
                                if (Ext.getCmp("updatestopdate").getValue() != "") {
                                    stopdatevar = Ext.util.Format.date(Ext.getCmp("stopdate").getValue(), 'Y-m-d');
                                }
                                var checkdatevar = null;
                                if (selections[0].data.checkdate != null) {
                                    checkdatevar = new Date(selections[0].data.checkdate.time).format('Y-m-d');
                                }
                                if (Ext.getCmp("updatelogtouttype").getGroupValue() == "0") {
                                    if (Ext.getCmp("updatelogoutreasons").getGroupValue() == null) {
                                        Ext.MessageBox.alert("提示", "请选择注销原因.");
                                        return;
                                    }
                                }
                                if (Ext.getCmp("updatecheckinmen").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写登记审核人.");
                                    return;
                                }
                                if (Ext.getCmp("updatecheckindate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写登记审核人经办时间.");
                                    return;
                                }
                                if (Ext.getCmp("updatelicensemen").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写牌证管理员.");
                                    return;
                                }
                                if (Ext.getCmp("updatelicensedate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写牌证管理员经办时间.");
                                    return;
                                }
                                if (Ext.getCmp("updatebusinessmen").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写业务领导审核.");
                                    return;
                                }
                                if (Ext.getCmp("updatebusinessdate").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请填写业务领导审核经办时间.");
                                    return;
                                }
                                var mask = new Ext.LoadMask(Ext.getBody(), {
						     		msg : '正在录入数据,请稍等...',
						     		removeMask:true
				                });
				                mask.show();
                                Ext.Ajax.request({
                                    url: 'main/logout.html?action=updateLogout',
                                    method: "post",
                                    success: function() {
                                    	mask.hide();
                                        Ext.MessageBox.alert("提示", "修改注销登记成功.");
                                        Ext.getCmp("updatelogoutWin").close();
                                        Ext.getCmp("logoutMgr").getStore().reload();
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        id: selections[0].data.id,
                                        tractorinfoid: selections[0].data.tractorinfoId,
                                        logtouttype: Ext.getCmp("updatelogtouttype").getGroupValue(),
                                        logoutnum: selections[0].data.logoutnum,
                                        relationinfo: logtouttypeStr,
                                        logoutreasons: Ext.getCmp("updatelogoutreasons").getGroupValue(),
                                        stopdate: stopdatevar,
                                        checkinmen: Ext.getCmp("updatecheckinmen").getValue(),
                                        checkindate: Ext.util.Format.date(Ext.getCmp("updatecheckindate").getValue(), 'Y-m-d'),
                                        licensemen: Ext.getCmp("updatelicensemen").getValue(),
                                        licensedate: Ext.util.Format.date(Ext.getCmp("updatelicensedate").getValue(), 'Y-m-d'),
                                        businessmen: Ext.getCmp("updatebusinessmen").getValue(),
                                        businessdate: Ext.util.Format.date(Ext.getCmp("updatebusinessdate").getValue(), 'Y-m-d'),
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
                    if (selections[0].data.istemplived == "0") {
                        Ext.getCmp("updateistemplive").setValue("常住人口");
                    }
                    if (selections[0].data.istemplived == "1") {
                        Ext.getCmp("updateistemplive").setValue("暂住人口");
                    }
                    if (selections[0].data.isUnion == 0) {
                        Ext.getCmp("updateisunit").setValue("个人");
                    }
                    if (selections[0].data.isUnion == 1) {
                        Ext.getCmp("updateisunit").setValue("单位");
                    }
                    if (selections[0].data.logtouttype == 0) {
                        Ext.getCmp("updatelogtouttypefield").items.items[0].items.items[0].setValue(true);
                    } else if (selections[0].data.logtouttype == 1) {
                        Ext.getCmp("updatelogtouttypefield").items.items[1].items.items[0].setValue(true);
                    }
                    if (selections[0].data.logtouttype == 2) {
                        Ext.getCmp("updatelogtouttypefield").items.items[2].items.items[0].setValue(true);
                    }
                    if (selections[0].data.logoutreasons != null) {
                        if (selections[0].data.logoutreasons == 0) {
                            Ext.getCmp("updaterequestinfo").items.items[4].items.items[0].setValue(true);
                        } else if (selections[0].data.logoutreasons == 1) {
                            Ext.getCmp("updaterequestinfo").items.items[5].items.items[0].setValue(true);
                        }
                        if (selections[0].data.logoutreasons == 2) {
                            Ext.getCmp("updaterequestinfo").items.items[6].items.items[0].setValue(true);
                        }
                    }
                    if (selections[0].data.relationinfo != null) {
                        var updatestr = selections[0].data.relationinfo.split(",");
                        for (i = 0; i < updatestr.length; i++) {
                            if (updatestr[i] == "拖拉机登记证书") {
                                Ext.getCmp("updaterelationinfoOne").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "拖拉机号牌") {
                                Ext.getCmp("updaterelationinfoSecond").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "行驶证") {
                                Ext.getCmp("updaterelationinfoThree").setValue(true);
                                continue;
                            };
                            if (updatestr[i] == "报废拖拉机回收证明副本") {
                                Ext.getCmp("updaterelationinfoFour").setValue(true);
                                continue;
                            };
                        }
                    }
                    if (selections[0].data.stopdate != null) {
                        Ext.getCmp("updatestopdate").setValue(new Date(selections[0].data.stopdate.time).format("Y-m-d"));
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
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、审核通过、审核未通过】的信息进行删除！");
                            return;
                        }
                    }
                    var dellogoutids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkstate != 2) {
                            updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
                        }
                        if (dellogoutids.length == 0) {
                            dellogoutids = dellogoutids + selections[i].data.id;
                        } else {
                            dellogoutids = dellogoutids + "," + selections[i].data.id;
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
		                         var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在读取数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                Ext.Ajax.request({
                                    url: "main/logout.html?action=delLogout",
                                    method: "post",
                                    success: function() {
                                    	mask.hide();
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("logoutMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        mydellogoutids: dellogoutids,
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
                            id: "searchlogouttype",
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
                            store: Ynzc.manage.LogouttypeData,
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                        	Ext.getCmp("logoutMgr").getStore().reload({
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
                                        logouttype: Ext.getCmp("searchlogouttype").getValue()
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
	        					sourceURL:'main/logout.html?action=logOutInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            },{
            text: "打印拖拉机延缓报废申请、审批表",
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
	                        wordType:"tractorScrapApplication",
                        	cnWord:"云南省拖拉机延缓报废申请、审批表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'云南省拖拉机延缓报废申请、审批表',
	        					sourceURL:'main/logout.html?action=PrintLogoutReport',
	        					params:{id:selections[0].data.tractorinfoId,wordType:'tractorScrapApplication'}
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
        Ynzc.manage.LogoutGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });
    }
});
Ext.reg('logoutgrid', Ynzc.manage.LogoutGrid);