Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.TractorInfoGrid = Ext.extend(Ext.grid.GridPanel, {
    id: 'tractorinfogrid',
    initComponent: function() {
        var sm = new Ext.grid.CheckboxSelectionModel();
        var fm = Ext.form;
        var expand = new Ext.ux.grid.RowExpander({
            tpl: new Ext.XTemplate('<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">', '<tr><td colspan="6">所有人信息</td></tr>', '<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{photourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>', '<tr><td>联系地址</td><td colspan="3">{address}</td></tr>', '<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>', '<tr><td>获得方式</td><td>{getway}</td><td>机械类型</td><td>{machinetype}</td></tr>', '<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>', '<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>', '<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>', '<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{price}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>', '<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{directcontrol}</td><td>货箱内部尺寸</td><td>{containersize}</td></tr>', '<tr><td>发动机品牌</td><td>{engineBrand}</td><td>功率</td><td>{power}</td><td>缸数</td><td>{cylinderno}</td></tr>', '<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{wheelbase}</td></tr>', '<tr><td>轮胎数</td><td>{tiresno}</td><td>轮胎规格</td><td>{tiressize}</td><td>轮距</td><td>{wheeldis}</td></tr>', '<tr><td>总质量</td><td>{totalquality}</td><td>整备质量</td><td>{allquality}</td><td>核定载质量</td><td>{ratifiedload}</td></tr>', '<tr><td>准牵引总质量</td><td>{allowdragtotalquality}</td><td>驾驶室载人</td><td>{driverinno}</td><td>钢板弹簧片数</td><td>后轴{steelspring}片</td></tr>', '<tr><td>挂车轮胎数</td><td>{vicecartiresno}</td><td>挂车轮距</td><td>{outcarwheeldis}</td><td>挂车轮胎规格</td><td>{outcartiressize}</td></tr>', '</table>')
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
            dataIndex: "machinetype"
        },
        {
            header: '厂牌型号',
            sortable: true,
            dataIndex: "plantType"
        },
//        {
//            header: '检验有效期',
//            sortable: true,
//            dataIndex: "checkexpirydate",
//            renderer: function(value) {
//        	if (value != null) {
//				value = new Date(value.time)
//						.format('Y-m-d');
//				return value;
//			} else {
//				return value;
//			}
//            }
//        },
          {
            header: '注册时间',
            sortable: true,
            dataIndex: "registerdate",
            renderer: function(value) {
        	  if (value != null) {
  				value = new Date(value.time)
  						.format('Y-m-d');
  				return value;
  			} else {
  				return value;
  			}
            }
          },{
          header: '审核通过时间',
          sortable: true,
          dataIndex: "checkeddate",
          renderer: function(value) {
      	  if (value != null) {
				value = new Date(value.time)
						.format('Y-m-d');
				return value;
			} else {
				return value;
			}
          }
        },
        {
            header: '登记人',
            sortable: true,
            dataIndex: "recorder"
        },
        {
            header: '审核人',
            sortable: true,
            dataIndex: "reviewer"
        },
        {
            header: '状态',
            sortable: true,
            dataIndex: "status",
            renderer: function(value) {
                if (value == 0) {
                    return '待报';
                } else if (value == 1) {
                    return '待审';
                } else if (value == 2) {
                    return '通过审核';
                } else if (value == 3) {
                    return '未通过审核';
                } else if (value == 5) {
                    return '脱检';
                } else if (value == 13) {
                    return '归档';
                } else {
                    return '业务办理中 ';
                }
            }
        }]);
        var reader = new Ext.data.JsonReader({
            totalProperty: "totalCount",
            root: "data",
            autoLoad: true,
            fields: [{
                name: 'id'
            },{
                name: 'unitid'
            },{
                name: 'license'
            },{
                name: 'checkeddate'
            },{
                name: 'recorder'
            },{
                name: 'status'
            },{
                name: 'regcerno'
            },{
                name: 'ownerinfoid'
            },{
                name: 'owner'
            },{
                name: 'realcertificatetypeid'
            },{
                name: 'realcertificateno'
            },{
                name: 'address'
            },{
                name: 'tempaddress'
            },{
                name: 'istemplived'
            },{
                name: 'templivefiletypeid'
            },{
                name: 'timplivefileno'
            },{
                name: 'telephone'
            },{
                name: 'isUnion'
            },{
                name: 'zipCode'
            },{
                name: 'technicalinspectid'
            },{
                name: 'checkresult'
            },{
                name: 'checkexpirydate'
            },{
                name: 'inspector'
            },{
                name: 'checkdate'
            },{
                name: 'handlingsituationid'
            },{
                name: 'reviewer'
            },{
                name: 'reviewerconductdate'
            },{
                name: 'issueadmin'
            },{
                name: 'leaderreview'
            },{
                name: 'leaderreviewconductdate'
            },{
                name: 'issueadmindate'
            },{
                name: 'tractorbasicinfoid'
            },{
                name: 'getwayid'
            },{
                name: 'machinetypeid'
            },{
                name: 'machinebrandtypeid'
            },{
                name: 'machinebodyno'
            },{
                name: 'engineno'
            },{
                name: 'shelfno'
            },{
                name: 'usedfor'
            },{
                name: 'manufacturer'
            },{
                name: 'seller'
            },{
                name: 'manufacturedate'
            },{
                name: 'price'
            },{
                name: 'photourl'
            },{
                name: 'relationinfoid'
            },{
                name: 'getwayfiletypeid'
            },{
                name: 'getwayfileno'
            },{
                name: 'importsfiletypeid'
            },{
                name: 'importsfileno'
            },{
                name: 'other'
            },{
                name: 'insurancelistno'
            },{
                name: 'insurancecompanyname'
            },{
                name: 'insurancedate'
            },{
                name: 'expirydate'
            },{
                name: 'registerinfoid'
            },{
                name: 'registerdate'
            },{
                name: 'issuedate'
            },{
                name: 'beforeregion'
            },{
                name: 'technicalparametersid'
            },{
                name: 'machinebodycolor'
            },{
                name: 'directcontrol'
            },{
                name: 'enginebrandid'
            },{
                name: 'fueltypeid'
            },{
                name: 'tiresno'
            },{
                name: 'totalquality'
            },{
                name: 'allowdragtotalquality'
            },{
                name: 'vicecartiresno'
            },{
                name: 'outsize'
            },{
                name: 'containersize'
            },{
                name: 'power'
            },{
                name: 'cylinderno'
            },{
                name: 'wheelno'
            },{
                name: 'tiressize'
            },{
                name: 'allquality'
            },{
                name: 'driverinno'
            },{
                name: 'outcarwheeldis'
            },{
                name: 'wheelbase'
            },{
                name: 'wheeldis'
            },{
                name: 'ratifiedload'
            },{
                name: 'steelspring'
            },{
                name: 'outcartiressize'
            },{
                name: 'region'
            },{
                name: 'regionid'
            },{
                name: 'useunit'
            },{
                name: 'responsiblemen'
            },{
                name: 'linktel'
            },{
                name: 'unitaddress'
            },{
                name: 'unitzipcode'
            },{
                name: 'chaptercode'
            },{
                name: 'platecode'
            },{
                name: 'userid'
            },{
                name: 'machinetype'
            },{
                name: 'engineBrand'
            },{
                name: 'fuelname'
            },{
                name: 'realcertificatetype'
            },{
                name: 'templivefileType'
            },{
                name: 'getway'
            },{
                name: 'getWayFileType'
            },{
                name: 'importsFileType'
            },{
                name: 'plantType'
            },{
            	name: 'turnindate'
            },{
            	name:'disqualification'
            },{
            	name:'showinitialinspectionresult'
            },{
            	name:'showdisqualification'
            },{
            	name:'showexaminationresult'
            },{
            	name:'engineinitialinspectionresult'
            },{
            	name:'enginedisqualification'
            },{
            	name:'engineexaminationresult'
            },{
            	name:'conveyorinitialinspectionresult'
            },{
            	name:'conveyordisqualification'
            },{
            	name:'conveyorexaminationresult'
            },{
            	name:'steeringinitialinspectionresult'
            },{
            	name:'steeringdisqualification'
            },{
            	name:'steeringexaminationresult'
            },{
            	name:'flyhostinitialinspectionresult'
            },{
            	name:'flyhostdisqualification'
            },{
            	name:'flyhostexaminationresult'
            },{
            	name:'flytrailerinitialinspectionresult'
            },{
            	name:'flytrailerdisqualification'
            },{
            	name:'flytrailerexaminationresult'
            },{
            	name:'brakhostinitialinspectionresult'
            },{
            	name:'brakhostdisqualification'
            },{
            	name:'brakhostexaminationresult'
            },{
            	name:'braktrailerinitialinspectionresult'
            },{
            	name:'braktrailerdisqualification'
            },{
            	name:'braktrailerexaminationresult'
            },{
            	name:'lighthostinitialinspectionresult'
            },{
            	name:'lighthostdisqualification'
            },{
            	name:'lighthostexaminationresult'
            },{
            	name:'lighttrailerinitialinspectionresult'
            },{
            	name:'lighttrailerdisqualification'
            },{
            	name:'lighttrailerexaminationresult'
            },{
            	name:'tractioninitialinspectionresult'
            },{
            	name:'tractiondisqualification'
            },{
            	name:'tractionexaminationresult'
            }]
            	
        });
        var ds = new Ext.data.Store({
            scopte: this,
            url: 'main/tractorInfoView.html?action=getTractorInfoView',
            reader: reader,
            sortInfo: {
                field: 'id',
                direction: 'DESC'
            }
        });
        Ext.apply(this, {
            id: 'tractorinfogrid',
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
                id: 'tractorAddBtn',
                text: "登记",
                iconCls: "icon-Add",
                handler: function() {
            	Ext.Ajax.request({
               	 url:'main/plate.html?action=getMinPlateCode',
       			 success:function(resp){
       				var result=Ext.util.JSON.decode(resp.responseText);
       				if(result.code=="无号牌"){
//       					alert("提示:号牌库里暂时没有号牌！");
       					Ext.MessageBox.alert('系统提示','对不起！号牌库里暂时没有号牌！');
       					return
       				}
       				new Ynzc.manage.TractorRegisterWin().show(Ext.getCmp("tractorAddBtn").getEl());
       				Ext.getCmp("license").setValue(result.code);
       				Ext.getCmp("regcerno").setValue(result.regcerno);
       				Ext.getCmp("reviewer").setValue(result.registman);
       				Ext.getCmp("issueadmin").setValue(result.paizhengman);
       				Ext.getCmp("leaderreview").setValue(result.leaderman);
       			}
       		});                    
                }
            },
            {
                text: "删除",
                iconCls: "icon-Del",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要删除的注册信息!");
                        return;
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.status != 0 && selections[i].data.status != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过】的信息进行删除！");
                            return;
                        }
                    }
                    var tractorids = "";
                    var ownerinfoids = "";
                    var technicalinspectids = "";
                    var handlingsituationids = "";
                    var tractorbasicinfoids = "";
                    var relationinfoids = "";
                    var registerinfoids = "";
                    var technicalparametersids = "";
                    var licenselist="";
                    for (i = 0; i < n; i++) {
                        if (tractorids.length == 0) {
                            tractorids = tractorids + selections[i].data.id;
                            ownerinfoids = ownerinfoids + selections[i].data.ownerinfoid;
                            technicalinspectids = technicalinspectids + selections[i].data.technicalinspectid;
                            handlingsituationids = handlingsituationids + selections[i].data.handlingsituationid;
                            tractorbasicinfoids = tractorbasicinfoids + selections[i].data.tractorbasicinfoid;
                            relationinfoids = relationinfoids + selections[i].data.relationinfoid;
                            registerinfoids = registerinfoids + selections[i].data.registerinfoid;
                            technicalparametersids = technicalparametersids + selections[i].data.technicalparametersid;
                            licenselist=licenselist+selections[i].data.platecode+"."+selections[i].data.license;
                            varf

                        } else {
                            tractorids = tractorids + "," + selections[i].data.id;
                            ownerinfoids = ownerinfoids + "," + selections[i].data.ownerinfoid;
                            technicalinspectids = technicalinspectids + "," + selections[i].data.technicalinspectid;
                            handlingsituationids = handlingsituationids + "," + selections[i].data.handlingsituationid;
                            tractorbasicinfoids = tractorbasicinfoids + "," + selections[i].data.tractorbasicinfoid;
                            relationinfoids = relationinfoids + "," + selections[i].data.relationinfoid;
                            registerinfoids = registerinfoids + "," + selections[i].data.registerinfoid;
                            technicalparametersids = technicalparametersids + "," + selections[i].data.technicalparametersid;
                            licenselist=licenselist+ ","+selections[i].data.platecode+"."+selections[i].data.license;
                        }
                    }
                    Ext.Msg.show({
                        title: '系统确认',
                        msg: '你是否确认删除选中的注册信息?',
                        buttons: Ext.Msg.YESNO,
                        scope: this,
                        icon: Ext.MessageBox.QUESTION,
                        fn: function(btn) {
                            if (btn == "yes") {
                                Ext.Ajax.request({
                                    url: "main/tractorInfo.html?action=checkTractorInfoBusiness",
                                    method: "post",
                                    success: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        if (result.success == true) {
                                            Ext.Ajax.request({
                                                url: "main/tractorInfo.html?action=delTractorInfo",
                                                method: "post",
                                                success: function() {
                                                    Ext.MessageBox.alert("提示", "删除成功选中的注册信息");
                                                    Ext.getCmp("traRegMgr").getStore().reload();
                                                },
                                                faliure: function() {
                                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                                },
                                                params: {
                                                    deltractorids: tractorids,
                                                    delownerinfoids: ownerinfoids,
                                                    deltechnicalinspectids: technicalinspectids,
                                                    delhandlingsituationids: handlingsituationids,
                                                    deltractorbasicinfoids: tractorbasicinfoids,
                                                    delrelationinfoids: relationinfoids,
                                                    delregisterinfoids: registerinfoids,
                                                    deltechnicalparametersids: technicalparametersids
                                                }
                                            });
                                        } else {
                                            Ext.Msg.alert("提示", result.reson);
                                        }

                                    },
                                    faliure: function(resp) {
                                        var result = Ext.util.JSON.decode(resp.responseText);
                                        Ext.Msg.alert("警告", "<font color=red>" + result + "</font>");
                                    },
                                    params: {
                                        deltractorids: tractorids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },
            {
                text: "上报",
                iconCls: "icon-Region",
                handler: function() {
                    var selections = this.selModel.getSelections();
                    var n = selections.length;
                    if (n == 0) {
                        Ext.MessageBox.alert("提示", "请选中要进行上报的注册信息!");
                        return;
                    }
                    for (i = 0; i < n; i++) {
                        if (selections[i].data.status != 0 && selections[i].data.status != 3) {
                            Ext.MessageBox.alert("提示", "请选中状态为【待报、未通过】的信息进行上报！");
                            return;
                        }
                    }
                    var tractorinfoids = "";
                    for (i = 0; i < n; i++) {
                        if (tractorinfoids.length == 0) {
                            tractorinfoids = tractorinfoids + selections[i].data.id;
                        } else {
                            tractorinfoids = tractorinfoids + "," + selections[i].data.id;
                        }
                    }
                    Ext.Msg.show({
                        title: '系统确认',
                        msg: '你是否确认上报选中的注册信息?',
                        buttons: Ext.Msg.YESNO,
                        scope: this,
                        icon: Ext.MessageBox.QUESTION,
                        fn: function(btn) {
                            if (btn == "yes") {
                                Ext.Ajax.request({
                                    url: "main/tractorInfo.html?action=ReportedTractorInfo",
                                    method: "post",
                                    success: function() {
                                        Ext.MessageBox.alert("提示", "上报成功选中的注册信息");
                                        Ext.getCmp("traRegMgr").getStore().reload();
                                    },
                                    faliure: function() {
                                        Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!</font>");
                                    },
                                    params: {
                                        reporttractorinfoids: tractorinfoids
                                    }
                                });
                            }
                        }
                    });
                }.createDelegate(this)
            },{
                text: "查询",
                iconCls: "icon-search",
                handler: function() {
                    new Ynzc.manage.SearchWin({
                        searchGrid: this,
                        title: "请输入条件进行查询"
                    });
                }.createDelegate(this)
            },{
                text: "所有待报数据",
                iconCls: "icon-search",
                handler: function() {
            	Ext.getCmp("traRegMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 0
                        }
                    });
                }
            },{
                text: "所有待审数据",
                iconCls: "icon-search",
                handler: function() {
            	Ext.getCmp("traRegMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 1
                        }
                    });
                }
            },{
                text: "查询通过审核数据",
                iconCls: "icon-AddPermissions",
                handler: function() {
            	Ext.getCmp("traRegMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 2
                        }
                    });
                }
            },{
                text: "查询未通过数据",
                iconCls: "icon-Del",
                handler: function() {
            	Ext.getCmp("traRegMgr").getStore().reload({
                        params: {
                            start: 0,
                            limit: 20,
                            state: 3
                        }
                    });
                }
            },{
            	text:"打印",
            	iconCls:"icon-print",
            	menu:[{
            		text:"打印信息采集表",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
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
	                    			wordType:"carInfomation",
	                    			ChWord:"打印信息采集表",
	                        		topMargin:"",
	                        		bottomMargin:"",
	                        		leftMargin:"",
	                        		rightMargin:""
	                        	}
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'打印信息采集表',
	        					sourceURL:'main/tractorInfo.html?action=tractorInfoReport',
	        					params:{id:selections[0].data.id,wordType:'carInfomation'}
	        			}).show();
            		}.createDelegate(this)
            	},{
            		text:"打印注册登记表",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
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
	                    			wordType:"tractorRegistrationAndTurnIn",
	                    			ChWord:"打印注册登记表",
	                        		topMargin:"",
	                        		bottomMargin:"",
	                        		leftMargin:"",
	                        		rightMargin:""
	                        	}
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'打印注册登记表',
	        					sourceURL:'main/tractorInfo.html?action=tractorInfoRegisterReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationAndTurnIn'}
	        			}).show();
            		}.createDelegate(this)
            	},{
            		text:"打印技术参数表",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
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
	                    			wordType:"technicalData",
	                    			ChWord:"打印技术参数表",
	                        		topMargin:"",
	                        		bottomMargin:"",
	                        		leftMargin:"",
	                        		rightMargin:""
	                        	}
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'打印技术参数表',
	        					sourceURL:'main/tractorInfo.html?action=tractorInfoTechnicReport',
	        					params:{id:selections[0].data.id,wordType:'technicalData'}
	        			}).show();
            		}.createDelegate(this)
            	},{
            		text:"打印检验报告",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
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
	                    			wordType:"carSafetyReport",
	                    			ChWord:"打印检验报告",
	                        		topMargin:"",
	                        		bottomMargin:"",
	                        		leftMargin:"",
	                        		rightMargin:""
	                        }
	                    });
            			new Ynzc.manage.TracReportWin({
	        					title:'打印检验报告',
	        					sourceURL:'main/tractorInfo.html?action=tractorInfoCheckReport',
	        					params:{id:selections[0].data.id,wordType:'carSafetyReport'}
	        			}).show();
            		}.createDelegate(this)
            	},{
            		text:"打印流程表",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
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
	        					title:'打印流程表',
	        					sourceURL:'main/tractorInfo.html?action=tractorInfoFlowReport',
	        					params:{id:selections[0].data.id,wordType:'tractorRegistrationRecordProcess1'}
	        			}).show();
            		}.createDelegate(this)
            	},{
            		text:"打印行驶证",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
	                        return;
	                    }
	                    if(n>1){
	                        Ext.MessageBox.alert("提示","请逐一选择!");
	                        return;
	                    }
	                    if(selections[0].data.status!=2){
	                    	Ext.MessageBox.alert("提示","选中要打印的拖拉机未经过审核，无法打印!");
	                        return;
	                    }
	                    Ext.Ajax.request({
	                    	url:"main/printFlag.html?action=GetPrintFlag",
	                        method:"post",
	                        success:function(response){
	                    		var result=Ext.util.JSON.decode(response.responseText);
	                    		if (result.success == true){
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
	                    				Ynzc.manage.cnWord=result.data.cnWord;
	                    				},
	                        			failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
	                        			params:{
	                        			wordType:"carMoveLicence",
	                        			ChWord:"打印行驶证",
		                        		topMargin:"",
		                        		bottomMargin:"",
		                        		leftMargin:"",
		                        		rightMargin:""
	                        			}
	                    			});
            						new Ynzc.manage.TracReportWin({
	        						title:'打印检验报告',
	        						sourceURL:'main/tractorInfo.html?action=tractorSteerReport',
	        						params:{
            							id:selections[0].data.id,printType:0,
            							wordType:"carMoveLicence"
            							}
	        						}).show();
	                    		}
	                    		else
	                    		{
	                    		Ext.Msg.alert("警告","<font color=red>"+result.reson+"!</font>");
	                    		}
	                    		},
	                        failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
	                        params:{
	                        	tractorinfoid:selections[0].data.id,
	                        	printType:0,wordType:'carMoveLicence'
	                        	}
	                    });
            		}.createDelegate(this)
            	},{
            		text:"打印登记书",
            		iconCls:"icon-print",
            		handler:function(){
            			var selections=this.selModel.getSelections();
		        		var n=selections.length;
	                    if(n==0){
	                        Ext.MessageBox.alert("提示","请选中要打印的拖拉机!");
	                        return;
	                    }
	                    if(n>1){
	                        Ext.MessageBox.alert("提示","请逐一选择!");
	                        return;
	                    }
	                    Ext.Ajax.request({
	                    	url:"main/printFlag.html?action=GetPrintFlag",
	                        method:"post",
	                        success:function(response){
	                    		var result=Ext.util.JSON.decode(response.responseText);
	                    		if (result.success == true){
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
	                    					Ynzc.manage.cnWord=result.data.cnWord;
	                    					},
	                        				failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
	                        				params:{
	                        					wordType:"RegistrationInformation",
	                        					ChWord:"打印登记书",
	                        					topMargin:"",
	                        					bottomMargin:"",
	                        					leftMargin:"",
	                        					rightMargin:""
	                        				}
	                    			});
            						new Ynzc.manage.TracReportWin({
	        							title:'打印检验报告',
	        							sourceURL:'main/tractorInfo.html?action=tractorEnregisterCertificate',
	        							params:{id:selections[0].data.id,wordType:'RegistrationInformation'}
	        						}).show();
	                    		}
	                    		else
	                    		{
	                    		Ext.Msg.alert("警告","<font color=red>"+result.reson+"!</font>");
	                    		}
	                    		},
	                        failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
	                        params:{
	                        	tractorinfoid:selections[0].data.id,
	                        	printType:1
	                        	}
	                    });
            		}.createDelegate(this)
            	}]
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
        Ynzc.manage.TractorInfoGrid.superclass.initComponent.apply(this, arguments);
        ds.load({
            params: {
                start: 0,
                limit: 20
            }
        });
        this.on("rowdblclick",
        function(grid, index, event) {
            var record = grid.getStore().getAt(index);
            if (record.data.status != 0 && record.data.status != 3) {
                Ext.MessageBox.alert("提示", "只能对待报或者未通过审核的信息进行编辑");
                return;
            }
            new Ynzc.manage.TractorUpdateWin().show(grid.getEl());
            var v = Ext.getCmp("picpanel");

            Ynzc.manage.tractorinfoid = record.data.id;
            Ynzc.manage.ownerinfoid = record.data.ownerinfoid;
            Ynzc.manage.technicalinspectid = record.data.technicalinspectid;
            Ynzc.manage.handlingsituationid = record.data.handlingsituationid;
            Ynzc.manage.tractorbasicinfoid = record.data.tractorbasicinfoid;
            Ynzc.manage.relationinfoid = record.data.relationinfoid;
            Ynzc.manage.registerinfoid = record.data.registerinfoid;
            Ynzc.manage.technicalparametersid = record.data.technicalparametersid;
        
            Ext.getCmp("owner").setValue(record.data.owner);
            Ext.getCmp("telephone").setValue(record.data.telephone);
            Ext.getCmp("realcertificatetype").setValue(record.data.realcertificatetypeid);
            Ext.getCmp("realcertificateno").setValue(record.data.realcertificateno);
            Ext.getCmp("address").setValue(record.data.address);
            Ext.getCmp("zipcode").setValue(record.data.zipCode);
            Ext.getCmp("regionStr").setValue(record.data.region);
            //Ext.getCmp("turnindate").setValue(record.data.turnindate);
            Ext.getCmp("registerdate").setValue(record.data.registerdate);
            
            Ext.getCmp("showinitialinspectionresult").setValue();

            Ext.getCmp("isunion").setValue(record.data.isUnion);
            Ext.getCmp("istemplived").setValue(record.data.istemplived);
            Ext.getCmp("templivefiletype").setValue(record.data.templivefiletypeid);
            Ext.getCmp("timplivefileno").setValue(record.data.timplivefileno);
            Ext.getCmp("tempaddress").setValue(record.data.tempaddress);
            Ext.getCmp("getwayid").setValue(record.data.getwayid);
            Ext.getCmp("machinetypeid").setValue(record.data.machinetypeid);
            Ext.getCmp("machinebrandtypeid").setMyValue(record.data.machinebrandtypeid); // 品牌型号
            Ext.getCmp("usedfor").setValue(record.data.usedfor);
            Ext.getCmp("machinebodyno").setValue(record.data.machinebodyno);
            Ext.getCmp("engineno").setValue(record.data.engineno);
            Ext.getCmp("shelfno").setValue(record.data.shelfno);
//            Ext.getCmp("picpanel").autoEl.src = record.data.photourl;
            Ext.getCmp("manufacturer").setValue(record.data.manufacturer);
            Ext.getCmp("seller").setValue(record.data.seller);

            var updatemanufacturedate = new Date(record.data.manufacturedate.time).format('Y-m-d');
            Ext.getCmp("manufacturedate").setValue(updatemanufacturedate);

            Ext.getCmp("price").setValue(record.data.price);
            if(record.data.photourl!=null)
            {
            Ext.getCmp("photourl").setValue(record.data.photourl);
            }
            Ext.getCmp("getwayfiletypeid").setValue(record.data.getwayfiletypeid);
            Ext.getCmp("getwayfileno").setValue(record.data.getwayfileno);
            if (record.data.importsfiletypeid != 0) {
                Ext.getCmp("importsfiletypeid").setValue(record.data.importsfiletypeid);
            }
            Ext.getCmp("importsfileno").setValue(record.data.importsfileno);
            var str = record.data.other.split(",");
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

            Ext.getCmp("insurancelistno").setValue(record.data.insurancelistno);
            //alert(record.data.insurancecompanyname);
            Ext.getCmp("insurancecompanyname").setValue(record.data.insurancecompanyname);

            var updateinsurancedate = new Date(record.data.insurancedate.time).format('Y-m-d');
            Ext.getCmp("insurancedate").setValue(updateinsurancedate);

            var updateexpirydate = new Date(record.data.expirydate.time).format('Y-m-d');
            Ext.getCmp("expirydate").setValue(updateexpirydate);

            var updateregisterdate = new Date(record.data.registerdate.time).format('Y-m-d');
            Ext.getCmp("registerdate").setValue(updateregisterdate);

            var updateissuedate = new Date(record.data.issuedate.time).format('Y-m-d');
            Ext.getCmp("issuedate").setValue(updateissuedate);
            var regionids = record.data.beforeregion.split(",");
            if (regionids.length>0) {
                // alert("==无");
            } else {
                Ext.Ajax.request({
                    url: "main/region.html?action=getRegionStr",
                    success: function(resp) {
                        var result = Ext.util.JSON.decode(resp.responseText);
                        Ext.getCmp("beforeregionStr").setValue(result.str);
                    },
                    failure: function() {
                        Ext.Msg.alert("提示", "<font color=red>与服务器通讯失败!</font>");
                    },
                    params: {
                        nodeid: regionids[regionids.length - 1]
                    }
                });
            }

            Ext.getCmp("beforeregion").setValue(record.data.beforeregion);
            Ext.getCmp("unitid").setValue(record.data.unitid);
            Ext.getCmp("license").setValue(record.data.license);
            Ext.getCmp("regcerno").setValue(record.data.regcerno);
            Ext.getCmp("machinebodycolor").setValue(record.data.machinebodycolor);
            Ext.getCmp("outsize").setValue(record.data.outsize);
            Ext.getCmp("containersize").setValue(record.data.containersize);
            Ext.getCmp("directcontrol").setValue(record.data.directcontrol);
            Ext.getCmp("enginebrandid").setMyValue(record.data.enginebrandid); //发动机品牌 
            Ext.getCmp("power").setValue(record.data.power);
            Ext.getCmp("cylinderno").setValue(record.data.cylinderno);
            Ext.getCmp("fueltypeid").setValue(record.data.fueltypeid);
            Ext.getCmp("wheelno").setValue(record.data.wheelno);
            Ext.getCmp("wheelbase").setValue(record.data.wheelbase);
            Ext.getCmp("tiresno").setValue(record.data.tiresno);
            Ext.getCmp("tiressize").setValue(record.data.tiressize);
            Ext.getCmp("wheeldis").setValue(record.data.wheeldis);
            Ext.getCmp("totalquality").setValue(record.data.totalquality);
            Ext.getCmp("allquality").setValue(record.data.allquality);
            Ext.getCmp("ratifiedload").setValue(record.data.ratifiedload);
            Ext.getCmp("allowdragtotalquality").setValue(record.data.allowdragtotalquality);
            Ext.getCmp("driverinno").setValue(record.data.driverinno);
            Ext.getCmp("steelspring").setValue(record.data.steelspring);
            Ext.getCmp("vicecartiresno").setValue(record.data.vicecartiresno);
            Ext.getCmp("outcarwheeldis").setValue(record.data.outcarwheeldis);
            Ext.getCmp("outcartiressize").setValue(record.data.outcartiressize);
            Ext.getCmp("checkresult").setValue(record.data.checkresult);
            if(record.data.checkresult=="合格" || record.data.checkresult=="检验合格"){
            	Ext.getCmp("disqualification").setValue("无");
              	Ext.getCmp("disqualification").disable();
              	Ext.getCmp("showdisqualification").setValue("无");
              	Ext.getCmp("showdisqualification").disable();
              	Ext.getCmp("enginedisqualification").setValue("无");
              	Ext.getCmp("enginedisqualification").disable();
              	Ext.getCmp("conveyordisqualification").setValue("无");
              	Ext.getCmp("conveyordisqualification").disable();
              	Ext.getCmp("steeringdisqualification").setValue("无");
              	Ext.getCmp("steeringdisqualification").disable();
              	Ext.getCmp("flyhostdisqualification").setValue("无");
              	Ext.getCmp("flyhostdisqualification").disable();
              	Ext.getCmp("flytrailerdisqualification").setValue("无");
              	Ext.getCmp("flytrailerdisqualification").disable();
              	Ext.getCmp("brakhostdisqualification").setValue("无");
              	Ext.getCmp("brakhostdisqualification").disable();
              	Ext.getCmp("braktrailerdisqualification").setValue("无");
              	Ext.getCmp("braktrailerdisqualification").disable();
              	Ext.getCmp("lighthostdisqualification").setValue("无");
              	Ext.getCmp("lighthostdisqualification").disable();
              	Ext.getCmp("lighttrailerdisqualification").setValue("无");
              	Ext.getCmp("lighttrailerdisqualification").disable();
              	Ext.getCmp("tractiondisqualification").setValue("无");
              	Ext.getCmp("tractiondisqualification").disable();
              	Ext.getCmp("showexaminationresult").setValue("无");
              	Ext.getCmp("showexaminationresult").disable();
              	Ext.getCmp("engineexaminationresult").setValue("无");
              	Ext.getCmp("engineexaminationresult").disable();
              	Ext.getCmp("conveyorexaminationresult").setValue("无");
              	Ext.getCmp("conveyorexaminationresult").disable();
              	Ext.getCmp("steeringexaminationresult").setValue("无");
              	Ext.getCmp("steeringexaminationresult").disable();
              	Ext.getCmp("flyhostexaminationresult").setValue("无");
              	Ext.getCmp("flyhostexaminationresult").disable();
              	Ext.getCmp("flytrailerexaminationresult").setValue("无");
              	Ext.getCmp("flytrailerexaminationresult").disable();
              	Ext.getCmp("brakhostexaminationresult").setValue("无");
              	Ext.getCmp("brakhostexaminationresult").disable();
              	Ext.getCmp("braktrailerexaminationresult").setValue("无");
              	Ext.getCmp("braktrailerexaminationresult").disable();
              	Ext.getCmp("lighthostexaminationresult").setValue("无");
              	Ext.getCmp("lighthostexaminationresult").disable();
              	Ext.getCmp("lighttrailerexaminationresult").setValue("无");
              	Ext.getCmp("lighttrailerexaminationresult").disable();
              	Ext.getCmp("tractionexaminationresult").setValue("无");
              	Ext.getCmp("tractionexaminationresult").disable(); 
              	
              	Ext.getCmp("showinitialinspectionresult").setValue("无");
              	Ext.getCmp("showinitialinspectionresult").disable();
              	Ext.getCmp("engineinitialinspectionresult").setValue("无");
              	Ext.getCmp("engineinitialinspectionresult").disable();
              	Ext.getCmp("conveyorinitialinspectionresult").setValue("无");
              	Ext.getCmp("conveyorinitialinspectionresult").disable();
              	Ext.getCmp("steeringinitialinspectionresult").setValue("无");
              	Ext.getCmp("steeringinitialinspectionresult").disable();
              	Ext.getCmp("flyhostinitialinspectionresult").setValue("无");
              	Ext.getCmp("flyhostinitialinspectionresult").disable();
              	Ext.getCmp("flytrailerinitialinspectionresult").setValue("无");
              	Ext.getCmp("flytrailerinitialinspectionresult").disable();
              	Ext.getCmp("brakhostinitialinspectionresult").setValue("无");
              	Ext.getCmp("brakhostinitialinspectionresult").disable();
              	Ext.getCmp("braktrailerinitialinspectionresult").setValue("无");
              	Ext.getCmp("braktrailerinitialinspectionresult").disable();
              	Ext.getCmp("lighthostinitialinspectionresult").setValue("无");
              	Ext.getCmp("lighthostinitialinspectionresult").disable();
              	Ext.getCmp("lighttrailerinitialinspectionresult").setValue("无");
              	Ext.getCmp("lighttrailerinitialinspectionresult").disable();
              	Ext.getCmp("tractioninitialinspectionresult").setValue("无");
              	Ext.getCmp("tractioninitialinspectionresult").disable();
            }else{
            	Ext.getCmp("disqualification").setValue(record.data.disqualification);
            	
            	Ext.getCmp("showinitialinspectionresult").setValue(record.data.showinitialinspectionresult);
                Ext.getCmp("showdisqualification").setValue(record.data.showdisqualification);
                Ext.getCmp("showexaminationresult").setValue(record.data.showexaminationresult);
                
                Ext.getCmp("engineinitialinspectionresult").setValue(record.data.engineinitialinspectionresult);
                Ext.getCmp("enginedisqualification").setValue(record.data.enginedisqualification);
                Ext.getCmp("engineexaminationresult").setValue(record.data.engineexaminationresult);
                
                Ext.getCmp("conveyorinitialinspectionresult").setValue(record.data.conveyorinitialinspectionresult);
                Ext.getCmp("conveyordisqualification").setValue(record.data.conveyordisqualification);
                Ext.getCmp("conveyorexaminationresult").setValue(record.data.conveyorexaminationresult);
                
                Ext.getCmp("steeringinitialinspectionresult").setValue(record.data.steeringinitialinspectionresult);
                Ext.getCmp("steeringdisqualification").setValue(record.data.steeringdisqualification);
                Ext.getCmp("steeringexaminationresult").setValue(record.data.steeringexaminationresult);
                
                Ext.getCmp("flyhostinitialinspectionresult").setValue(record.data.flyhostinitialinspectionresult);
                Ext.getCmp("flyhostdisqualification").setValue(record.data.flyhostdisqualification);
                Ext.getCmp("flyhostexaminationresult").setValue(record.data.flyhostexaminationresult);
                
                Ext.getCmp("flytrailerinitialinspectionresult").setValue(record.data.flytrailerinitialinspectionresult);
                Ext.getCmp("flytrailerdisqualification").setValue(record.data.flytrailerdisqualification);
                Ext.getCmp("flytrailerexaminationresult").setValue(record.data.flytrailerexaminationresult);
                
                Ext.getCmp("brakhostinitialinspectionresult").setValue(record.data.brakhostinitialinspectionresult);
                Ext.getCmp("brakhostdisqualification").setValue(record.data.brakhostdisqualification);
                Ext.getCmp("brakhostexaminationresult").setValue(record.data.brakhostexaminationresult);
                
                Ext.getCmp("braktrailerinitialinspectionresult").setValue(record.data.braktrailerinitialinspectionresult);
                Ext.getCmp("braktrailerdisqualification").setValue(record.data.braktrailerdisqualification);
                Ext.getCmp("braktrailerexaminationresult").setValue(record.data.braktrailerexaminationresult);
                
                Ext.getCmp("lighthostinitialinspectionresult").setValue(record.data.lighthostinitialinspectionresult);
                Ext.getCmp("lighthostdisqualification").setValue(record.data.lighthostdisqualification);
                Ext.getCmp("lighthostexaminationresult").setValue(record.data.lighthostexaminationresult);
                
                Ext.getCmp("lighttrailerinitialinspectionresult").setValue(record.data.lighttrailerinitialinspectionresult);
                Ext.getCmp("lighttrailerdisqualification").setValue(record.data.lighttrailerdisqualification);
                Ext.getCmp("lighttrailerexaminationresult").setValue(record.data.lighttrailerexaminationresult);
                
                Ext.getCmp("tractioninitialinspectionresult").setValue(record.data.tractioninitialinspectionresult);
                Ext.getCmp("tractiondisqualification").setValue(record.data.tractiondisqualification);
                Ext.getCmp("tractionexaminationresult").setValue(record.data.tractionexaminationresult);
            }

            var updatecheckexpirydate = new Date(record.data.checkexpirydate.time).format('Y-m-d');
            Ext.getCmp("checkexpirydate").setValue(updatecheckexpirydate);

            Ext.getCmp("inspector").setValue(record.data.inspector);

            var updatecheckdate = new Date(record.data.checkdate.time).format('Y-m-d');
            Ext.getCmp("checkdate").setValue(updatecheckdate);

            Ext.getCmp("reviewer").setValue(record.data.reviewer);

            var updatereviewerconductdate = new Date(record.data.reviewerconductdate.time).format('Y-m-d');
            Ext.getCmp("reviewerconductdate").setValue(updatereviewerconductdate);

            Ext.getCmp("issueadmin").setValue(record.data.issueadmin);

            var updateissueadmindate = new Date(record.data.issueadmindate.time).format('Y-m-d');
            Ext.getCmp("issueadmindate").setValue(updateissueadmindate);

            Ext.getCmp("leaderreview").setValue(record.data.leaderreview);

            var updateleaderreviewconductdate = new Date(record.data.leaderreviewconductdate.time).format('Y-m-d');
            Ext.getCmp("leaderreviewconductdate").setValue(updateleaderreviewconductdate);

        });
    }
});
Ext.reg('tractorinfogrid', Ynzc.manage.TractorInfoGrid);