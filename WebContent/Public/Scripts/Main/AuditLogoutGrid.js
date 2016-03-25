Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.AuditLogoutGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'auditlogoutgrid',
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
        var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(), sm, {
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
                    return '<font color=red>待审</font>';
                } else if (value == 2) {
                    return '通过审核';
                } else if (value == 3) {
                    return '未通过';
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
        }
        ]);
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
            baseParams:{state:"1,2"},
            sortInfo: {
                field: 'id',
                direction: 'Desc'
            }
        });
        Ext.apply(this, {
            id: 'auditlogoutgrid',
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
                        Ext.MessageBox.alert("提示", "请选中要审核的注销登记信息!");
                        return;
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkstate !=1) {
                        	Ext.MessageBox.alert("提示", "只能对【待审】的信息进行审核！");
                            return;
                        }
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                        rds.push(selections[i].data);
                    }
//                    Ext.Msg.show("提示",selections[0].data.tractorinfoId);
                    Ext.Msg.show({
                        title:'系统确认',
                        msg:'你是否确认对选中的注销信息进行审核?',
                        buttons:Ext.Msg.YESNO,
                        scope:this,
                        icon : Ext.MessageBox.QUESTION,
                        fn:function(btn){
                            if(btn=="yes"){
                                                            var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                Ext.Ajax.request({
                                	url: 'main/logout.html?action=auditLogout',
                                    method:"post",
                                    success:function(){
                                    mask.hide();
                                        Ext.MessageBox.alert("提示","审核成功");
                                        Ext.getCmp("auditlogoutMgr").getStore().reload();
                                    },
                                    faliure:function(){
                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                    },
                                    params:{
                                    	auditmodels:Ext.util.JSON.encode(rds),
                                    	state:2,
                                    	approvacontext:"审核通过"
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
                    var replacementtype = "0";
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要审核的注销登记信息!");
                        return;
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.checkstate ==3) {
                        	Ext.MessageBox.alert("提示", "只能对【待审、审核通过】的信息进行审核！");
                            return;
                        }
                    }
                    var rds = [];
                    for (i = 0; i < n; i++) {
                        rds.push(selections[i].data);
                    }
                    new Ext.Window({
                        id:"auditWin",
                        title:"请填写审核意见",
                        modal:true,
                        height:220,
                        width:400,
                        layout:"form",
                        labelWidth:80,
                        bodyStyle:"padding:5px 5px",
                        items:[{
                        id:"context",
                        fieldLabel:"审核意见",
                        xtype:"textarea",
                        height:120,
                        anchor:"98%"
                        }],
                        buttons:[
                        {text:"提交",
                         handler:function(){
                         if(Ext.getCmp("context").getValue()==""){
                        	 Ext.MessageBox.alert("提示", "请填写审核意见！");
                        	 return;
                        	 }
                        	                                 var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在处理数据,请稍等...',
									removeMask:true
								});
								mask.show();
                         Ext.Ajax.request({
                          url: 'main/logout.html?action=auditLogout',
			              method:"post",
			              success:function(){mask.hide();Ext.MessageBox.alert("提示","审核成功.");Ext.getCmp("auditWin").close(); Ext.getCmp("auditlogoutMgr").getStore().reload();},
			              failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
			               params:{
			            	   auditmodels:Ext.util.JSON.encode(rds),
			            	   state:3,
                           	   approvacontext:Ext.getCmp("context").getValue()
			               }
                         });
                         }
                        }]
                        }).show();

                }.createDelegate(this)
            },            {
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
                        	Ext.getCmp("auditlogoutMgr").getStore().reload({
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
        Ynzc.manage.AuditLogoutGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20,
                state: "1,2"
            }
        });
    }
});
Ext.reg('auditlogoutgrid', Ynzc.manage.AuditLogoutGrid);