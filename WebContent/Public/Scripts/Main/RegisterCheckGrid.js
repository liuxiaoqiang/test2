Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.RegisterCheckGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'registercheckgrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var expand= new Ext.ux.grid.RowExpander({
						tpl : new Ext.XTemplate(
								'<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">',
								'<tr><td colspan="6">所有人信息</td></tr>',
								'<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{photourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>',
								'<tr><td>联系地址</td><td colspan="3">{address}</td></tr>',
								'<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>',
								'<tr><td>获得方式</td><td>{getway}</td><td>机械类型</td><td>{machinetype}</td></tr>',
								'<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td></tr>',
								'<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td></tr>',
				 				'<tr><td>发动机号码</td><td>{engineno}</td><td>制造厂名称</td><td>{manufacturer}</td><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td></tr>',
								'<tr><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{price}</td><td>机身颜色</td><td>{machinebodycolor}</td></tr>',
								'<tr><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{directcontrol}</td><td>货箱内部尺寸</td><td>{containersize}</td></tr>',
								'<tr><td>发动机品牌</td><td>{engineBrand}</td><td>功率</td><td>{power}</td><td>缸数</td><td>{cylinderno}</td></tr>',
								'<tr><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{wheelbase}</td></tr>',
								'<tr><td>轮胎数</td><td>{tiresno}</td><td>轮胎规格</td><td>{tiressize}</td><td>轮距</td><td>{wheeldis}</td></tr>',
								'<tr><td>总质量</td><td>{totalquality}</td><td>整备质量</td><td>{allquality}</td><td>核定载质量</td><td>{ratifiedload}</td></tr>',
								'<tr><td>准牵引总质量</td><td>{allowdragtotalquality}</td><td>驾驶室载人</td><td>{driverinno}</td><td>钢板弹簧片数</td><td>后轴{steelspring}片</td></tr>',
								'<tr><td>挂车轮胎数</td><td>{vicecartiresno}</td><td>挂车轮距</td><td>{outcarwheeldis}</td><td>挂车轮胎规格</td><td>{outcartiressize}</td></tr>',
								'</table>'
							  )
					});
                    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
                        header:'管辖区',
                        sortable:true,
                        dataIndex:"region"
                    },{
                        header:'号牌号码',
                        sortable:true,
                        dataIndex:"license",
                        renderer:function(value,meta,record){
                        	value="<font color=red>"+record.data.platecode+"."+value+"</font>";
                        	return value;
                        }
                    },{
                        header:'所有人',
                        sortable:true,
                        dataIndex:"owner"
                    },{
                        header:'机械类型',
                        sortable:true,
                        dataIndex:"machinetype"
                    },{
                        header:'厂牌型号',
                        sortable:true,
                        dataIndex:"plantType"
                    },{
                        header:'检验有效期',
                        sortable:true,
                        dataIndex:"checkexpirydate",
                        renderer:function(value){
                        	value=new Date(value.time).format('Y-m-d');
                        	return value;
                        }
                    },{
                        header:'登记人',
                        sortable:true,
                        dataIndex:"recorder"
                    },{
                        header:'审核人',
                        sortable:true,
                        dataIndex:"reviewer"
                    },{
                        header:'状态',
                        sortable:true,
                        dataIndex:"status",
                        renderer : function(value) {
                        if(value==1){
                        	return '待审';
                        }
                        else if(value==3){
                           return '未通过审核';
                        }
                        else{
                        return '通过审核';
                        }
                      }
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[
                        {name : 'id'},{name:'unitid'},{name:'license'},{name : 'checkeddate'},{name : 'recorder'},{name : 'status'},{name:'regcerno'},{name:'ownerinfoid'},{name : 'owner'},{name:'realcertificatetypeid'},{name:'realcertificateno'},
                        {name:'address'},{name:'tempaddress'},{name : 'istemplived'},{name : 'templivefiletypeid'},{name : 'timplivefileno'}, {name : 'telephone'},{name : 'isUnion'},{name : 'zipCode'},
                        {name:'technicalinspectid'},{name:'checkresult'},{name:'checkexpirydate'},{name:'inspector'},{name:'checkdate'},{name:'handlingsituationid'},{name:'reviewer'},{name:'reviewerconductdate'},{name:'issueadmin'},{name:'leaderreview'},{name:'leaderreviewconductdate'},
                        {name : 'issueadmindate'},{name:'tractorbasicinfoid'},{name:'getwayid'},{name : 'machinetypeid'},{name : 'machinebrandtypeid'},{name : 'machinebodyno'},{name:'engineno'},{name : 'shelfno'},{name:'usedfor'},{name:'manufacturer'},
                        {name : 'seller'},{name:'manufacturedate'},{name : 'price'},{name : 'photourl'},{name:'relationinfoid'},{name : 'getwayfiletypeid'},{name:'getwayfileno'},{name : 'importsfiletypeid'},{name:'importsfileno'},{name:'other'}, 
                        {name : 'insurancelistno'},{name:'insurancecompanyname'},{name : 'insurancedate'},{name : 'expirydate'},{name:'registerinfoid'},{name : 'registerdate'},{name:'issuedate'},{name : 'beforeregion'},{name:'technicalparametersid'},{name:'machinebodycolor'},{name:'directcontrol'},
                        {name : 'enginebrandid'},{name:'fueltypeid'},{name : 'tiresno'},{name : 'totalquality'},{name : 'allowdragtotalquality'},{name:'vicecartiresno'},{name : 'outsize'},{name:'containersize'},{name:'power'},
                        {name : 'cylinderno'},{name:'wheelno'},{name : 'tiressize'},{name : 'allquality'},{name : 'driverinno'},{name:'outcarwheeldis'},{name : 'wheelbase'},{name:'wheeldis'},{name:'ratifiedload'},{name:'steelspring'},
                        {name : 'outcartiressize'},{name:'region'},{name : 'regionid'},{name : 'useunit'},{name : 'responsiblemen'},{name:'linktel'},{name : 'unitaddress'},{name:'unitzipcode'},{name:'chaptercode'},{name:'platecode'},{name:'userid'},
                        {name : 'machinetype'},{name:'engineBrand'},{name : 'fuelname'},{name : 'realcertificatetype'},{name : 'templivefileType'},{name:'getway'},{name : 'getWayFileType'},{name:'importsFileType'},{name:'plantType'}
                        ]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/tractorInfoView.html?action=getAuditTractorInfoView',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'registercheckgrid',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                      	plugins:expand,
                        tbar:[{
                            id:'tractorAddBtn',
                            text:"审核通过",
                            iconCls:"icon-Add",
                             handler:function()
                               {
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.MessageBox.alert("提示","请选中要进行审核的注册信息!");
                                        return;
                                    }
                                    for (i = 0; i < n; i++) {
                                        if (selections[i].data.status != 1) {
                                            Ext.MessageBox.alert("提示", "只能对待审的信息进行审核！");
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
                                        title:'系统确认',
                                        msg:'你是否确认审核选中的注册信息?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                    url:"main/tractorInfo.html?action=checkTractorInfo",
                                                    method:"post",
                                                    success:function(){
                                                        Ext.MessageBox.alert("提示","审核成功选中的注册信息");
                                                        Ext.getCmp("ltraRegMgr").getStore().reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                    	audittractorinfoids:tractorinfoids,
                                                        state:2
                                                    }
                                                });
                                            }
                                        }
                                     });
                             }.createDelegate(this)
                        },{
                            text:"审核不通过",
                            iconCls:"icon-Del",
                            handler:function()
                               {
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.MessageBox.alert("提示","请选中要进行审核的注册信息!");
                                        return;
                                    }
                                    for (i = 0; i < n; i++) {
                                        if (selections[i].data.status != 1) {
                                            Ext.MessageBox.alert("提示", "只能对待审的信息进行审核！");
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
    			                         Ext.Ajax.request({
    			                          url:"main/tractorInfo.html?action=checkTractorInfo",
    						              method:"post",
    						              success:function(){Ext.MessageBox.alert("提示","审核成功.");Ext.getCmp("auditWin").close(); Ext.getCmp("ltraRegMgr").getStore().reload();},
    						              failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
    						               params:{
    						            	   audittractorinfoids:tractorinfoids,
                                               state:3
    						               }
    			                         });
    			                         }
    			                        }]
                                        }).show();
                             }.createDelegate(this)
                        },{
                            text:"查询",
                            iconCls:"icon-search",
                            handler:function(){
                            new Ynzc.manage.SearchWin({searchGrid:this,title:"请输入条件进行查询"});
                            }.createDelegate(this)
                            }],
                        bbar:new Ext.PagingToolbar({
                            pageSize:20,
                            store:ds,
                            displayInfo:true,
                            displayMsg : '显示第 {0} 条到 {1} 条记录，共 {2} 条',
                            emptyMsg : '无记录'
                        }),
                        viewConfig:{
                            forceFit:true
                        }
                    });
                    Ynzc.manage.TractorInfoGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                }
});
Ext.reg('registercheckgrid',Ynzc.manage.RegisterCheckGrid);