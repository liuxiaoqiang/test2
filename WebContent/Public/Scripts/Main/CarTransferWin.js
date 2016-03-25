Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.CarTransferWin = Ext.extend(Ext.grid.GridPanel, {
    id: 'cartransferwin',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{tractorinfoaddress}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td></tr>', '<tr><td>品牌型号</td><td>{tractorinfodirNo}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td></tr>', '<tr><td>发动机品牌</td><td>{tractorengineBrand}</td><td>功率</td><td>{tractorinfopower}</td><td>缸数</td><td>{tractorcylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tractorinfotireson}</td><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td></tr>', '<tr><td>总质量</td><td>{tractorinfototalquality}</td><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td>{tractorinfooutcartiressize}</td></tr>', '</table>')
        });
        var cm = new Ext.grid.ColumnModel([expand, new Ext.grid.RowNumberer(), sm, {
            header: '业务种类',
            sortable: true,
            dataIndex: "transfertype"
        },
        {
            header: '原管辖地',
            sortable: true,
            dataIndex: "orginregionname"
        },
        {
            header: '现管辖地',
            sortable: true,
            dataIndex: "regionname"
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
            dataIndex: "tractorinfodirNo"
        },
        {
            header: '检验有效期',
            sortable: true,
            dataIndex: "tractorinfocheckexpirydate",
            renderer: function(value) {
                value = new Date(value.time).format('Y-m-d');
                return value;
            }
        },
        {
            header: '登记人',
            sortable: true,
            dataIndex: "applymen"
        },
        {
            header: '状态',
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
                name: 'transfertype'
            },
            {
                name: 'orginregionid'
            },
            {
                name: 'orginregionname'
            },
            {
                name: 'orginunitid'
            },
            {
                name: 'orginunitname'
            },
            {
                name: 'currentregionid'
            },
            {
                name: 'regionname'
            },
            {
                name: 'currentunitid'
            },
            {
                name: 'unitname'
            },
            {
                name: 'applydate'
            },
            {
                name: 'applymen'
            },
            {
                name: 'applyip'
            },
            {
                name: 'checkmen'
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
            	name:'oldlicense'
            },
            {
            	name:'applytype'
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
                name: 'tractorinfodirNo'
            }]
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/carTransfer.html?action=getOutCarTransferListByPage',
            reader: reader,
            baseParams:{state:"0,1,2"},
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'cartransferwin',
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
                text: "转移登记",
                iconCls: "icon-Add",
                handler: function() {
                    var win = new Ext.Window({
                        id: "inputCodeNumWin",
                        title: "车辆转移",
                        modal: true,
                        height: 150,
                        width: 350,
                        resizable : false,
                        layout: "column",
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            columnWidth: .2,
                            layout: "fit",
                            baseCls: "x-plain",
                            items: [{
                                xtype: "label",
                                html: PlateNumHead + "&nbsp;&nbsp;"
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
                                id: "transfertype",
                                fieldLabel: "转移类型",
                                xtype: "combo",
                                displayField: 'displayvalue',
                                valueField: 'value',
                                typeAhead: true,
                                mode: 'local',
                                editable: false,
                                selectOnFoucs: true,
                                triggerAction: 'all',
                                value: '管辖区的转移登记',
                                store: Ynzc.manage.TransferTypeStore,
                                anchor: '98%'
                            }]
                        }],
                        buttons: [{
                            text: "下一步",
                            handler: function() {
                        	    var licensenum = Ext.getCmp("codenum").getValue();
                                if (Ext.getCmp("codenum").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请输入要转移的号牌号码!");
                                    return
                                }
                                Ext.Ajax.request({
                                    url: 'main/tractorInfoView.html?action=IsExits',
                                    method: "post",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            var type = Ext.getCmp("transfertype").getValue();
                                            Ext.getCmp("inputCodeNumWin").close();
                                            //显示框框
                                            new Ext.Window({
                                                id: "transferWin",
                                                title: "请填写转移登记信息",
                                                modal: true,
                                                height: 300,
                                                width: 500,
                                                layout: "form",
                                                labelWidth: 80,
                                                bodyStyle: "padding:5px 5px",
                                                items: [{
                                                    id: "beforetransfer",
                                                    title: "转移前",
                                                    xtype: "fieldset",
                                                    height: 80,
                                                    collapsible: false,
                                                    layout: "form",
                                                    labelWidth: 120,
                                                    items: [{
                                                        id: 'orginregionname',
                                                        fieldLabel: "原管辖地",
                                                        xtype: "field",
                                                        readOnly: true,
                                                        value: result.reson.region,
                                                        anchor: '98%'
                                                    },
                                                    {
                                                        id: 'orginunitname',
                                                        fieldLabel: "原农机监理机构名称",
                                                        xtype: "field",
                                                        readOnly: true,
                                                        value: result.reson.useunit,
                                                        anchor: '98%'
                                                    }]

                                                },
                                                {
                                                    id: "currenttransfer",
                                                    title: "转移情况",
                                                    xtype: "fieldset",
                                                    height: 100,
                                                    collapsible: false,
                                                    labelWidth: 150,
                                                    layout: "column",
                                                    items: [{
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: 'beforeregionStr',
                                                            fieldLabel: "现管辖地",
                                                            readOnly: true,
                                                            xtype: "rrcombo",
                                                            value: "无",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: 1,
                                                        layout: "fit",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        hidden: true,
                                                        items: [{
                                                            id: "beforeregion",
                                                            fieldLabel: "现管辖地id",
                                                            xtype: "textfield",
                                                            anchor: '98%'
                                                        }]
                                                    },
                                                    {
                                                        columnWidth: 1,
                                                        layout: "form",
                                                        baseCls: "x-plain",
                                                        labelWidth: 160,
                                                        items: [{
                                                            id: 'unitid',
                                                            fieldLabel: "转入的农机监理机构名称",
                                                            xtype: "combo",
                                                            displayField: 'useunit',
                                                            valueField: 'id',
                                                            typeAhead: true,
                                                            mode: 'local',
                                                            editable: false,
                                                            selectOnFoucs: true,
                                                            triggerAction: 'all',
                                                            store: Ynzc.manage.UnitStore,
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
                                                    	if (Ext.getCmp("unitid").getValue() == "") {
                                    						Ext.MessageBox.alert("提示", "请输入需要转入的农机监理机构名称!");
                                    						return;
                                						}
                                						if (Ext.getCmp("unitid").getValue() == "在数据库中未找到对应的农监机构，请手动选择。") {
                                    						Ext.MessageBox.alert("提示", "请输入需要转入的农机监理机构名称!");
                                    						return;
                                						}
                                                        Ext.Ajax.request({
                                                            url: "main/carTransfer.html?action=addCarTransfer",
                                                            method: "post",

                                                            success: function() {
                                                                Ext.MessageBox.alert("提示", "提交成功，请等待审核.");
                                                                Ext.getCmp("transferWin").close();
                                                                Ext.getCmp("cartransferwin").getStore().reload();
                                                            },
                                                            failure: function() {
                                                                Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                            },
                                                            params: {
                                                                tractorinfoId: result.reson.id,
                                                                transfertype: type,
                                                                orginregionid: result.reson.regionid,
                                                                orginregionname: result.reson.region,
                                                                orginunitid: result.reson.unitid,
                                                                orginunitname: result.reson.useunit,
                                                                regionid: Ext.getCmp("beforeregion").getValue(),
                                                                regionname: Ext.getCmp("beforeregionStr").getValue(),
                                                                unitid: Ext.getCmp("unitid").getValue()
                                                            }
                                                        });
                                                    }
                                                },
                                                {
                                                    text: "取消",
                                                    handler: function() {
                                                        Ext.getCmp("transferWin").close();
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
                        if (selections[i].data.checkresult != 0 && selections[i].data.checkresult != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过审核】的信息进行上报！");
                            return;
                        }
                    }
                    var cartransferids = "";
                    for (i = 0; i < n; i++) {
                        if (cartransferids.length == 0) {
                            cartransferids = cartransferids + selections[i].data.id;
                        } else {
                            cartransferids = cartransferids + "," + selections[i].data.id;
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
                                    url: "main/carTransfer.html?action=ReportedCarTransfer",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功上报选中的信息,请等待审核");
                                        Ext.getCmp("cartransferwin").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reportcartransferids: cartransferids
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
                        Ext.MessageBox.alert("提示", "只能对【待报、未通过审核】的数据进行编辑！");
                        return
                    }
                    new Ext.Window({
                        id: "updatetransferWin",
                        title: "更新转移登记信息",
                        modal: true,
                        height: 300,
                        width: 500,
                        layout: "form",
                        labelWidth: 80,
                        bodyStyle: "padding:5px 5px",
                        items: [{
                            id: "updatebeforetransfer",
                            title: "转移前",
                            xtype: "fieldset",
                            height: 80,
                            collapsible: false,
                            layout: "form",
                            labelWidth: 120,
                            items: [{
                                id: 'updateorginregionname',
                                fieldLabel: "原管辖地",
                                xtype: "field",
                                readOnly: true,
                                value: selections[0].data.orginregionname,
                                anchor: '98%'
                            },
                            {
                                id: 'updateorginunitname',
                                fieldLabel: "原农机监理机构名称",
                                xtype: "field",
                                readOnly: true,
                                value: selections[0].data.orginunitname,
                                anchor: '98%'
                            }]

                        },
                        {
                            id: "updatecurrenttransfer",
                            title: "转移情况",
                            xtype: "fieldset",
                            height: 100,
                            collapsible: false,
                            labelWidth: 150,
                            layout: "column",
                            items: [{
                                   columnWidth: 1,
                                   layout: "form",
                                   baseCls: "x-plain",
                                   labelWidth: 160,
                                   items: [{
                                          id: 'beforeregionStr',
                                          fieldLabel: "现管辖地",
                                          readOnly: true,
                                          xtype: "rrcombo",
                                          value: selections[0].data.regionname,
                                          anchor: '98%'
                                          }]
                                    },{
                                    columnWidth: 1,
                                    layout: "fit",
                                    baseCls: "x-plain",
                                    labelWidth: 160,
                                    hidden: true,
                                    items: [{
                                            id: "beforeregion",
                                            fieldLabel: "现管辖地id",
                                            xtype: "textfield",
                                            value: selections[0].data.regionid,
                                            anchor: '98%'
                                           }]
                                  },{
                                    columnWidth: 1,
                                    layout: "form",
                                    baseCls: "x-plain",
                                    labelWidth: 160,
                                    items: [{
                                            id: 'unitid',
                                            fieldLabel: "转入的农机监理机构名称",
                                            xtype: "combo",
                                            displayField: 'useunit',
                                            valueField: 'id',
                                            typeAhead: true,
                                            mode: 'local',
                                            editable: false,
                                            selectOnFoucs: true,
                                            triggerAction: 'all',
                                            store: Ynzc.manage.UnitStore,
                                            anchor: '98%',
                                            value: selections[0].data.currentunitid
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
                            if (Ext.getCmp("unitid").getValue() == "") {
                                    Ext.MessageBox.alert("提示", "请输入需要转入的农机监理机构名称!");
                                    return;
                                }
                            if (Ext.getCmp("unitid").getValue() == "在数据库中未找到对应的农监机构，请手动选择。") {
                                    Ext.MessageBox.alert("提示", "请输入需要转入的农机监理机构名称!");
                                    return;
                               }
                                var checkdatevar = null;
                                if (selections[0].data.checkdate != null) {
                                    checkdatevar = new Date(selections[0].data.checkdate.time).format('Y-m-d');
                                }
                                Ext.Ajax.request({
                                    url: "main/carTransfer.html?action=updateCarTransfer",
                                    method: "post",

                                    success: function() {
                                        Ext.MessageBox.alert("提示", "修改成功.");
                                        Ext.getCmp("updatetransferWin").close();
                                        Ext.getCmp("cartransferwin").getStore().reload();
                                    },
                                    failure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        id: selections[0].data.id,
                                        tractorinfoId: selections[0].data.tractorinfoId,
                                        transfertype: selections[0].data.transfertype,
                                        orginregionid: selections[0].data.orginregionid,
                                        orginregionname: selections[0].data.orginregionname,
                                        orginunitid: selections[0].data.orginunitid,
                                        orginunitname: selections[0].data.orginunitname,
                                        regionid: Ext.getCmp("beforeregion").getValue(),
                                        regionname: Ext.getCmp("beforeregionStr").getValue(),
                                        unitid: Ext.getCmp("unitid").getValue(),
                                        applydate: new Date(selections[0].data.applydate.time).format('Y-m-d'),
                                        applymen: selections[0].data.applymen,
                                        applyip: selections[0].data.applyip,
                                        checkmen: selections[0].data.checkmen,
                                        checkdate: checkdatevar,
                                        checkip: selections[0].data.checkip,
                                        checkresult: selections[0].data.checkresult,
                                        checkcontext: selections[0].data.checkcontext
                                    }
                                });
                            }
                        },
                        {
                            text: "取消",
                            handler: function() {
                                Ext.getCmp("updatetransferWin").close();
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
                    var delcartransferids = "";
                    var updatetractorids = "";
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkresult != 2) {
                            updatetractorids = updatetractorids + selections[i].data.tractorinfoId + ",";
                        }
                        if (delcartransferids.length == 0) {
                            delcartransferids = delcartransferids + selections[i].data.id;
                        } else {
                            delcartransferids = delcartransferids + "," + selections[i].data.id;
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
                                    url: "main/carTransfer.html?action=delCarTransfer",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "已成功删除选中的信息");
                                        Ext.getCmp("cartransferwin").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        mydelcartransferids: delcartransferids,
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
                            id: "searchtransfertype",
                            fieldLabel: "转移类型",
                            xtype: "combo",
                            displayField: 'displayvalue',
                            valueField: 'value',
                            typeAhead: true,
                            mode: 'local',
                            editable: false,
                            selectOnFoucs: true,
                            triggerAction: 'all',
                            value: '--请选择--',
                            store: Ynzc.manage.TransferTypeStore,
                            anchor: '98%'
                        }],
                        buttons: [{
                            text: "查询",
                            handler: function() {
                        	Ext.getCmp("cartransferwin").getStore().reload({
                                    params: {
                                        start: 0,
                                        limit: 20,
                                        state: "0,1",
                                       	codenum: Ext.getCmp("txtlicense").getValue(),
                                        owner: Ext.getCmp("txtowner").getValue(),
                                        machinetype: Ext.getCmp("txtmahinetype").getValue(),
                                        plantType: Ext.getCmp("txtplantType").getValue(),
                                        checkexpriydate: Ext.util.Format.date(Ext.getCmp("txtcheckexiprydate").getValue(), 'Y-m-d'),
                                        regcerno: Ext.getCmp("txtregcerno").getValue(),
                                        cardid: Ext.getCmp("txtcardid").getValue(),
                                        engineno: Ext.getCmp("txtengineno").getValue(),
                                        transfertype: Ext.getCmp("searchtransfertype").getValue()
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
	        					sourceURL:'main/carTransfer.html?action=carTransferInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            },{
            text: "打印拖拉机转移登记申请表",
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
	                        wordType:"tractorTransferApplication",
                        	cnWord:"拖拉机转移登记申请表",
	                        topMargin:"",
	                        bottomMargin:"",
	                        leftMargin:"",
	                        rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'拖拉机转移登记申请表',
	        					sourceURL:'main/carTransfer.html?action=PrintCarTransferReport',
	        					params:{id:selections[0].data.tractorinfoId,wordType:'tractorTransferApplication'}
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
        Ynzc.manage.CarTransferWin.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20,
                state: "0,1,2"
            }
        });
        this.on("rowdblclick",
        function(grid, index, event) {
            var record = grid.getStore().getAt(index);
            win.show();
        });
    }
});
Ext.reg('cartransferwin', Ynzc.manage.CarTransferWin);