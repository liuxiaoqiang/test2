Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.AuditCarChangeGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'auditcarchangegrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var expand= new Ext.ux.grid.RowExpander({
						tpl : new Ext.XTemplate(
								'<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">',
								'<tpl if="this.getChangeType(changeType)==1">', 
		 						'<tr><td colspan="6">变更【所有人】详情</td></tr>',
								'<tr><td>姓名</td><td>{username}</td><td>联系电话</td><td>{lintel}</td><td>证件号码</td><td>{certificatecode}</td></tr>',
								'<tr><td>单位类型</td><td>{[values.unittype=="0"?"个人":"单位"]}</td><td>居住地址</td><td>{currentaddress}</td><td>邮政编码</td><td>{zipcode}</td></tr>',
								'<tr><td>是否暂住</td><td>{[values.istemporary=="0"?"常住人口":"暂住人口"]}</td><td>暂住证明类型</td><td>{templivefileType}</td><td>暂住证明号码</td><td>{temporaycertificatecode}</td></tr>',
								'</tpl>', 
								'<tpl if="this.getChangeType(changeType)==2">', 
								'<tr><td colspan="6">变更【机身颜色】详情</td></tr>',
								'<tr><td>现机身颜色</td><td colspan="5">{cuurentcolor}</td></tr>',
								'</tpl>', 
								'<tpl if="this.getChangeType(changeType)==3">', 
								'<tr><td colspan="6">变更【发动机】详情</td></tr>',
								'<tr><td>发动机号</td><td>{newenginecode}</td><td>缸数</td><td>{newcylindernumber}</td><td>功率</td><td>{newpower}</td></tr>',
								'</tpl>', 
								'<tpl if="this.getChangeType(changeType)==4">', 
								'<tr><td colspan="6">变更【挂车】详情</td></tr>',
								'<tr><td>挂车轮胎数</td><td>{currenttires}</td><td>挂车轮距</td><td>{currenttrack}</td><td>挂车轮胎规格</td><td>{currentnorm}</td></tr>',
								'</tpl>', 
								'<tpl if="this.getChangeType(changeType)==5">', 
								'<tr><td colspan="6">变更 【更换机身(底盘)、更换整机】详情</td></tr>',
								'<tr><td>获得方式</td><td>{getway}</td><td>机械类型</td><td>{machinetype}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>',
								'<tr><td>品牌型号</td><td>{plantType}</td><td>机身（底盘）号码</td><td>{bodycode}</td></tr>',	
								'<tr><td>发动机号码</td><td>{enginecode}</td><td>挂机架号码</td><td>{rackcode}</td></tr>',	
								'<tr><td>使用性质</td><td>{usernature}</td><td>制造厂名称</td><td>{factoryname}</td></tr>',
								'<tr><td>销售单位</td><td>{saleunit}</td><td>出厂日期</td><td>{[values.releasedate==null?"":new Date(values.releasedate.time).format("Y-m-d")]}</td></tr>',
								'<tr><td>销售/交易价格</td><td>{price}</td><td>来历凭证编号</td><td>{getwayfiletypecode}</td></tr>',
								'<tr><td>进口凭证编号</td><td>{importsfiletypecode}</td><td>其他</td><td>{other}</td><td>保单号</td><td>{insurancelistno}</td></tr>',
								'<tr><td>保险日期</td><td>{[values.insurancedate==null?"":new Date(values.insurancedate.time).format("Y-m-d")]}</td><td>保险有效期</td><td>{[values.insurancevalidate==null?"":new Date(values.insurancevalidate.time).format("Y-m-d")]}</td><td>机身颜色</td><td>{bodycolor}</td></tr>',
								'<tr><td>外廓尺寸</td><td>{size}</td><td>转向形式</td><td>{directcontrol}</td><td>货箱内部尺寸</td><td>{containersize}</td></tr>',								
								'<tr><td>功率</td><td>{power}</td><td>缸数</td><td>{cylinderno}</td><td>轴数</td><td>{wheelno}</td></tr>',
								'<tr><td>轴距</td><td>{wheelbase}</td><td>轮胎数</td><td>{tiresno}</td><td>轮胎规格</td><td>{tiressize}</td></tr>',
								'<tr><td>轮距</td><td>{wheeldis}</td><td>总质量</td><td>{totalquality}</td><td>整备质量</td><td>{allquality}</td></tr>',
								'<tr><td>核定载质量</td><td>{ratifiedload}</td><td>准牵引总质量</td><td>{allowdragtotalquality}</td><td>驾驶室载人</td><td>{driverinno}</td></tr>',
								'<tr><td>钢板弹簧片数</td><td>后轴{steelspring}片</td><td>挂车轮胎数</td><td>{vicecartiresno}</td><td>挂车轮距</td><td>{outcarwheeldis}</td></tr>',
								'<tr><td>挂车轮胎规格</td><td colspan="5">{outcartiressize}</td></tr>',
								'</tpl>',
								
								'<tr><td colspan="6">【车辆信息】</td></tr>',
								'<tr><td>所有人姓名</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="6"><img src="{tractorinfophotourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>',
								'<tr><td>证件类型</td><td>{realcertificatetype}</td><td>证件号码</td><td>{realcertificateno}</td></tr>',								
								'<tr><td>单位类型</td><td>{[values.isUnion=="0"?"个人":"单位"]}</td><td>居住地址</td><td>{tempaddress}</td></tr>',
								'<tr><td>邮政编码</td><td>{tractorinfozipcode}</td><td>是否暂住</td><td>{[values.istemplived=="0"?"常住人口":"暂住人口"]}</td></tr>',
								'<tr><td>暂住证明类型</td><td>{tractorinfotemplivefileType}</td><td>暂住证明号码</td><td>{timplivefileno}</td></tr>',								
								'<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{regcerno}</td></tr>',								
								'<tr><td>获得方式</td><td>{tractorinfogetway}</td><td>机械类型</td><td>{tractorinfomachinetype}</td><td>品牌型号</td><td>{tractorinfoplantType}</td></tr>',
								'<tr><td>机身(底盘)号码</td><td>{machinebodyno}</td><td>发动机号码</td><td>{engineno}</td><td>挂机架号码</td><td>{shelfno}</td></tr>',
								'<tr><td>使用性质</td><td>{usedfor}</td><td>制造厂名称</td><td>{manufacturer}</td><td>销售单位/交易市场名称</td><td>{seller}</td></tr>',
								'<tr><td>出厂日期</td><td>{[values.manufacturedate==null?"":new Date(values.manufacturedate.time).format("Y-m-d")]}</td><td>销售交易价格</td><td>{tractorinfoprice}</td><td>来历凭证类型</td><td>{getWayFileType}</td></tr>',
								'<tr><td>来历凭证编号</td><td>{getwayfileno}</td><td>进口凭证类型</td><td>{importsFileType}</td><td>进口凭证编号</td><td>{importsfileno}</td></tr>',
								'<tr><td>其他</td><td>{tractorinfoother}</td><td>保单号</td><td>{tractorinfoinsurancelistno}</td><td>保险日期</td><td>{[values.tractorinfoinsurancedate==null?"":new Date(values.tractorinfoinsurancedate.time).format("Y-m-d")]}</td></tr>',
								'<tr><td>保险有效期</td><td>{[values.tractorinfoexpirydate==null?"":new Date(values.tractorinfoexpirydate.time).format("Y-m-d")]}</td><td>机身颜色</td><td>{machinebodycolor}</td><td>外廓尺寸</td><td>{outsize}</td></tr>',
								'<tr><td>转向形式</td><td>{tractorinfodirectcontrol}</td><td>货箱内部尺寸</td><td>{tractorinfocontainersize}</td><td>功率</td><td>{tractorinfopower}</td></tr>',
								'<tr><td>缸数</td><td>{tractorcylinderno}</td><td>轴数</td><td>{wheelno}</td><td>轴距</td><td>{tractorinfowheelbase}</td></tr>',
								'<tr><td>燃料种类</td><td>{fuelname}</td><td>发动机品牌</td><td>{tractorengineBrand}</td><td>轮胎数</td><td>{tractorinfotireson}</td></tr>',								
								'<tr><td>轮胎规格</td><td>{tractorinfotiressize}</td><td>轮距</td><td>{tractorinfowheeldis}</td><td>总质量</td><td>{tractorinfototalquality}</td></tr>',								
								'<tr><td>整备质量</td><td>{tractorinfoallquality}</td><td>核定载质量</td><td>{tractorinforatifiedload}</td><td>准牵引总质量</td><td>{tractorinfoallowdragtotalquality}</td></tr>',
								'<tr><td>驾驶室载人</td><td>{tractorinfodriverinno}</td><td>钢板弹簧片数</td><td>后轴{tractorinfosteelspring}片</td><td>挂车轮胎数</td><td>{tractorinfovicecartiresno}</td></tr>',
								'<tr><td>挂车轮距</td><td>{tractorinfooutcarwheeldis}</td><td>挂车轮胎规格</td><td colspan="3">{tractorinfooutcartiressize}</td></tr>',
								'</table>',{
									getChangeType:function(type){
										if(type=="共同所有的拖拉机变更拖拉机所有人"){
											return 1;
										}
										else if(type=="变更机身颜色"){
											return 2;
										}
										else if(type=="更换发动机"){
											return 3;
										}
										else if(type=="更换挂车"){
											return 4;
										}
										else{
											return 5;
										}
									}
								}
							  )
					});
                    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
                        header:'业务类型',
                        sortable:true,
                        dataIndex:"changeType"
                    },{
                        header:'管辖地',
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
                        dataIndex:"tractorinfomachinetype"
                    },{
                        header:'厂牌型号',
                        sortable:true,
                        dataIndex:"tractorinfoplantType"
                    },{
                        header:'检验有效期',
                        sortable:true,
                        dataIndex:"tractorinfocheckexpirydate",
                        renderer: function(value) {
                        if(value!=null){
                         value = new Date(value.time).format('Y-m-d');
                		 return value
                        }
           				 }
                    },{
                        header:'变更业务登记人',
                        sortable:true,
                        dataIndex:"applicationmen"
                    },{
                        header:'状态',
                        sortable:true,
                        dataIndex:"approvalstate",
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
                    },{
                        header:'审核人',
                        sortable:true,
                        dataIndex:"approvalmen"
                    },{
                        header:'审核时间',
                        sortable:true,
                        dataIndex:"approvaltime",
                        renderer: function(value) {
                        if(value!=null){
                         value = new Date(value.time).format('Y-m-d');
                		 return value
                        }
           				 }
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[
                                {name : 'id'},{name:'tractorinfoId'},{name:'changeType'},{name : 'applicationmen'},{name : 'applicationtime'},{name : 'applicationip'},{name:'approvalmen'},{name:'approvaltime'},{name : 'approvalstate'},{name:'approvalip'},{name:'approvacontext'},
                                {name : 'changecolorid'},{name : 'orgincolor'},{name : 'cuurentcolor'},{name : 'changecolorphotourl'},
                                {name:'changeengineid'},{name:'changeenginecode'},{name:'changeenginefueltype'},{name:'enginebrand'},{name:'cylindernumber'},{name:'changeenginepower'},{name:'newenginecode'},{name:'newfueltype'},{name:'newenginebrand'},{name:'newcylindernumber'},{name:'newpower'},
                                {name : 'engineproof'},{name:'engineproofnumber'},{name:'changetrailerid'},{name : 'orgintires'},{name : 'orgintrack'},{name : 'orginnorm'},{name:'currenttires'},{name : 'currenttrack'},{name:'currentnorm'},{name:'changeownerid'},{name:'orginusername'},
                                {name : 'orginlintel'},{name:'orgincertificateid'},{name : 'orgincertificatecode'},{name : 'orginunittype'},{name:'orginaddress'},{name : 'orginzipcode'},{name:'orginistemporary'},{name : 'orgintemporaycertificate'},{name:'orgintemporaycertificatecode'},{name:'username'}, 
                                {name : 'lintel'},{name:'certificateid'},{name : 'certificatecode'},{name : 'unittype'},{name:'currentaddress'},{name : 'zipcode'},{name:'istemporary'},{name : 'temporaycertificate'},{name:'temporaycertificatecode'},{name:'changebodyid'},{name:'orgingettypeid'},{name:'orginmachinetypeid'},
                                {name : 'orginengineid'},{name:'orginbodycode'},{name : 'orginenginecode'},{name : 'orginrackcode'},{name : 'orginusernature'},{name:'orginfactoryname'},{name : 'orginsaleunit'},{name:'orginreleasedate'},{name:'orginprice'},{name:'orginphotourl'},{name:'orgingetwayfiletypeid'},{name:'orgingetwayfiletypecode'},
                                {name : 'orginimportsfiletypeid'},{name:'orginimportsfiletypecode'},{name : 'orginother'},{name : 'orgininsurancelistno'},{name : 'orgininsurancecompany'},{name:'orgininsurancedate'},{name : 'orgininsurancevalidate'},{name:'orginbodycolor'},{name:'orginsize'},{name:'orgindirectcontrol'},
                                {name : 'orgincontainersize'},{name:'orginenginebrandid'},{name : 'orginpower'},{name : 'orgincylinderno'},{name : 'orginfueltype'},{name:'orginwheelno'},{name : 'orginwheelbase'},{name:'orgintiresno'},{name:'orgintiressize'},{name:'orginwheeldis'},{name:'orgintotalquality'},
                                {name : 'orginallquality'},{name:'orginratifiedload'},{name : 'orginallowdragtotalquality'},{name : 'orgindriverinno'},{name : 'orginsteelspring'},{name:'orginvicecartiresno'},{name : 'orginoutcarwheeldis'},{name:'orginoutcartiressize'},{name:'gettypeid'},{name:'machinetypeid'},
                                {name : 'engineid'},{name:'bodycode'},{name : 'enginecode'},{name : 'rackcode'},{name : 'usernature'},{name:'factoryname'},{name : 'saleunit'},{name:'releasedate'},{name:'price'},{name:'photourl'},{name:'getwayfiletypeid'},{name:'getwayfiletypecode'},{name:'importsfiletypeid'},
                                {name : 'importsfiletypecode'},{name:'other'},{name : 'insurancelistno'},{name : 'insurancecompany'},{name : 'insurancedate'},{name:'insurancevalidate'},{name : 'bodycolor'},{name:'size'},{name:'directcontrol'},{name:'containersize'},{name:'enginebrandid'},{name:'power'},   
                                {name : 'cylinderno'},{name:'fueltype'},{name : 'wheelno'},{name : 'wheelbase'},{name : 'tiresno'},{name:'tiressize'},{name : 'wheeldis'},{name:'totalquality'},{name:'allquality'},{name:'ratifiedload'},{name:'allowdragtotalquality'},{name:'driverinno'},{name:'steelspring'},
                                {name : 'vicecartiresno'},{name:'outcarwheeldis'},{name : 'outcartiressize'},{name : 'templivefileType'},{name : 'getway'},{name:'machinetype'},{name : 'plantType'},                        
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
                                {name : 'getWayFileType'},{name:'importsFileType'},{name : 'tractorinfoplantType'}
                        ]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/carChange.html?action=getAllCarChangeListByPage',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'Desc'
                        },
                        baseParams:{state:"1,2"}  		
                    });
                    Ext.apply(this,{
                        id:'auditcarchangegrid',
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
                            text:"审核通过",
                            iconCls:"icon-Add",
                            handler:function()
                               {
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.MessageBox.alert("提示","请选中要审核的变更信息!");
                                        return;
                                    }
                                    for (i = 0; i < n; i++) {
                                        if (selections[i].data.approvalstate != 1) {
                                            Ext.MessageBox.alert("提示", "只能对【待审】的信息进行审核！");
                                            return;
                                        }
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                      Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认对选中的变更信息进行审核?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                            	                                var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在读取数据,请稍等...',
									removeMask:true
								});
								mask.show();
                                                Ext.Ajax.request({
                                                    url:"main/carChange.html?action=auditCarChange",
                                                    method:"post",
                                                    success:function(){
                                                    mask.hide();
                                                        Ext.MessageBox.alert("提示","审核成功");
                                                        Ext.getCmp("auditcarchangeMgr").getStore().reload();
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
                        },{id:"auditpass",
                          text:"审核未通过",
                         iconCls:"icon-Del",
                          handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.MessageBox.alert("提示","请选中要审核的变更信息!");
                                        return;
                                    }
                                    for (i = 0; i < n; i++) {
                                        if (selections[i].data.approvalstate ==3) {
                                            Ext.MessageBox.alert("提示", "只能对【待审、审核通过】的信息进行审核！");
                                            return;
                                        }
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                    var auditcarchageWin=new Ext.Window({
                                    id:"auditcarchageWin",
                                    title:"审核未通过",
                                    modal:true,
			                        height:200,
			                        width:400,
			                        layout:"form",
			                        labelWidth:80,
			                        bodyStyle:"padding:5px 5px",
			                        items:[{
			                        id:"approvacontext",
			                        fieldLabel:"审核意见",
			                        xtype:"textarea",
			                        height:120,
			                        anchor:"98%"
			                        }],
			                        buttons:[
			                        {text:"提交",
			                         handler:function(){
			                         if(Ext.getCmp("approvacontext").getValue()==""){return;}
			                         		                         var mask = new Ext.LoadMask(Ext.getBody(), {
									msg : '正在读取数据,请稍等...',
									removeMask:true
								});
								mask.show();
			                         Ext.Ajax.request({
			                         url:"main/carChange.html?action=auditCarChange",
						              method:"post",
						              success:function(){mask.hide();Ext.MessageBox.alert("提示","审核成功.");Ext.getCmp("auditcarchageWin").close(); Ext.getCmp("auditcarchangeMgr").getStore().reload();},
						              failure:function(){ Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
						               params:{
						                   auditmodels:Ext.util.JSON.encode(rds),
                                           state:3,
                                           approvacontext:Ext.getCmp("approvacontext").getValue()
						               }
			                         });
			                         }
			                        },
			                        {text:"取消",
			                        handler:function()
			                        { Ext.getCmp("auditcarchageWin").close(); }
			                        }]
                                    }).show();
                                    
                          }.createDelegate(this)
                         },{
                      	     text:"查询",
                      	     iconCls:"icon-search",
                      	     handler:function(){
                      	     new Ext.Window({
                            id:"searchWin",
		                    title:"请输入查询条件",
		                    modal:true,
		                    height:310,
		                    width:320,
		                    layout:"form",
		                    labelWidth:95,
		                    bodyStyle:"padding:5px 5px",
		                    items:[
		                    {
		                    id:'txtlicense',
			                fieldLabel:"号牌号码关键字",
			                xtype:"textfield",
			                anchor:'98%'
		                    },{
		                    id:'txtowner',
			                fieldLabel:"所有人",
			                xtype:"textfield",
			                anchor:'98%'
		                    },{
		                    id:'txtmahinetype',
			                fieldLabel:"机械类型",
			                xtype:"textfield",
			                anchor:'98%'
		                    },{
		                    id:'txtplantType',
			                fieldLabel:"厂牌型号",
			                xtype:"textfield",
			                anchor:'98%'
		                    },{
		                    id:'txtcheckexiprydate',
		                    format:"Y-m-d",
			                fieldLabel:"检验有效期",
			                xtype:"datefield",
			                anchor:'98%'
		                    },{
		                    id:'txtregcerno',
			                fieldLabel:"登记证书编号",
			                xtype:"textfield",
			                anchor:'98%'
		                    },{
		                    id:'txtcardid',
			                fieldLabel:"身份证号码",
			                xtype:"textfield",
			                anchor:'98%'
		                    },{
		                    id:'txtengineno',
			                fieldLabel:"发动机号",
			                xtype:"textfield",
			                anchor:'98%'
		                    } ,{
                            id:"searchchangetype",
                    		fieldLabel:"变更类型",
                    		xtype:"combo",
                   		    displayField : 'displayvalue',
			                valueField : 'value',
			                typeAhead : true,
			                mode : 'local',
			                editable : false,
			                selectOnFoucs : true,
			                triggerAction : 'all',
			                value:'--请选择--',
			                store:Ynzc.manage.ChangeTypeStore,
                    		anchor:'98%'
                            }
		                    ],
		                    buttons:[
		                    {text:"查询",
		                    handler:function(){
		                    Ext.getCmp("auditcarchangeMgr").getStore().reload({
                            params:{
                            start:0,
                            limit:20,
                            state:"1,2,3",
                            codenum:Ext.getCmp("txtlicense").getValue(),
                            owner:Ext.getCmp("txtowner").getValue(),
                            machinetype:Ext.getCmp("txtmahinetype").getValue(),
                            plantType:Ext.getCmp("txtplantType").getValue(),
                            checkexpriydate:Ext.util.Format.date(Ext.getCmp("txtcheckexiprydate").getValue(),'Y-m-d'),
                            regcerno:Ext.getCmp("txtregcerno").getValue(),
                            cardid:Ext.getCmp("txtcardid").getValue(),
                            engineno:Ext.getCmp("txtengineno").getValue(),
                            changtype:Ext.getCmp("searchchangetype").getValue()
                            }
                            });
                            Ext.getCmp("searchWin").close();
		                    }
		                    },{text:"取消",
		                    handler:function(){Ext.getCmp("searchWin").close();}
		                    }
		                    ]
                            }).show();
                      	     }
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
                    Ynzc.manage.AuditCarChangeGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20,
                            state:"1,2"
                        }
                    });
                }
});
Ext.reg('auditcarchangegrid',Ynzc.manage.AuditCarChangeGrid);