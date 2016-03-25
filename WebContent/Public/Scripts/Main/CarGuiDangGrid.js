Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.CarGuiDangGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'carguidanggrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var expand= new Ext.ux.grid.RowExpander({
						tpl : new Ext.XTemplate(
								'<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="ynzcTableBlue">',
								'<tr><td colspan="6">所有人信息</td></tr>',
								'<tr><td>所有人</td><td>{owner}</td><td>联系电话</td><td>{telephone}</td><td width="" colspan="2" rowspan="4"><img src="{photourl}" alt=""name="noneimg"width="320"height="150"id="noneimg"/></td></tr>',
								'<tr><td>联系地址</td><td colspan="3">{address}</td></tr>',
								'<tr><td>号牌号码</td><td><font color=red>{platecode}.{license}</font></td><td>登记证书编号</td><td>{telephone}</td></tr>',
								'<tr><td>获得方式</td><td>{getway}</td><td>机械类型</td><td>{machinetype}</td></tr>',
								'<tr><td>品牌型号</td><td>{plantType}</td><td>机身(底盘)号码</td><td>{machinebodyno}</td><td>发动机号码</td><td>{engineno}</td></tr>',
								'<tr><td>挂机架号码</td><td>{shelfno}</td><td>使用性质</td><td>{usedfor}</td><td>制造厂名称</td><td>{manufacturer}</td></tr>',
								'<tr><td>出厂日期</td><td>{[new Date(values.manufacturedate.time).format("Y-m-d")]}</script></td><td>销售单位/交易市场名称</td><td>{seller}</td><td>销售交易价格</td><td>{price}</td></tr>',
								'<tr><td>机身颜色</td><td>{machinebodycolor}</td><td>外廓尺寸</td><td>{outsize}</td><td>转向形式</td><td>{directcontrol}</td></tr>',
								'<tr><td>货箱内部尺寸</td><td>{containersize}</td><td>发动机品牌</td><td>{engineBrand}</td><td>功率</td><td>{power}</td></tr>',
								'<tr><td>缸数</td><td>{cylinderno}</td><td>燃料种类</td><td>{fuelname}</td><td>轴数</td><td>{wheelno}</td></tr>',
								'<tr><td>轴距</td><td>{wheelbase}</td><td>轮胎数</td><td>{tiresno}</td><td>轮胎规格</td><td>{tiressize}</td></tr>',
								
								'<tr><td>轮距</td><td>{wheeldis}</td><td>总质量</td><td>{totalquality}</td><td>整备质量</td><td>{allquality}</td></tr>',
								'<tr><td>核定载质量</td><td>{ratifiedload}</td><td>准牵引总质量</td><td>{allowdragtotalquality}</td><td>驾驶室载人</td><td>{driverinno}</td></tr>',
								'<tr><td>钢板弹簧片数</td><td>后轴{steelspring}片</td><td>挂车轮胎数</td><td>{vicecartiresno}</td><td>挂车轮距</td><td>{outcarwheeldis}</td></tr>',
								'<tr><td>挂车轮胎规格</td><td colspan="5">{outcartiressize}</td></tr>',
								'</table>',{
									myDate:function(d){
										return new Date(d.time).format("Y-m-d");
									}
								}
							  )
					});
                    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
                        header:'业务类型',
                        sortable:true,
                        dataIndex:"changeType"
                    },{
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
				        	if (value != null) {
								value = new Date(value.time)
										.format('Y-m-d');
								return value;
							} else {
								return value;
							}
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
                        header:'是否归档',
                        sortable:true,
                        dataIndex:"filing",
                        renderer : function(value) {
                    		if(value==0){
                    			return '<font color=red>未归档</font>';
                    		}else{
                    			return '<font color=blue>已归档</font>';
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
                                {name : 'machinetype'},{name:'engineBrand'},{name : 'fuelname'},{name : 'realcertificatetype'},{name : 'templivefileType'},{name:'getway'},{name : 'getWayFileType'},{name:'importsFileType'},{name:'plantType'},{name:'filing'},{name:'changeType'},{name:'tractorinfoId'}
                        ]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/carChange.html?action=getFilingList',
                        reader:reader,
                        sortInfo:{
                            field:'filing',
                            direction:'DESC'
                        }
                    });
                    Ext.apply(this,{
                        id:'carguidanggrid',
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
                      		id:"filingType",
                      		xtype:"combo",
                      		emptyText:"业务分类",
	                        displayField : 'display',
			                valueField : 'value',
			                typeAhead : true,
			                mode : 'local',
			                editable : false,
			                selectOnFoucs : true,
			                triggerAction : 'all',
			                store:Ynzc.manage.filingStroe,
			                listeners:{
                      			'select':function(){
                      				   ds.baseParams.filingType=this.getValue();
                      		           ds.reload({
                      		        	   params:{
                                              start:0,
                                              limit:20
                      		           	   }
                      		           })
                      			 }
                      		},
			                width:200
                      	},{
                      	text: "查询未归档数据",
                		iconCls: "icon-Del",
                		 handler: function() {
                		 ds.baseParams.filingType=Ext.getCmp("filingType").getValue();
                		  ds.reload({
                      		    params:{
                                start:0,
                                limit:20,
                                filling:0
                      		    }
                      		})
                		 }
                      	},{
                      	text: "查询已归档数据",
                		iconCls: "icon-Del",
                		 handler: function() {
                		 ds.baseParams.filingType=Ext.getCmp("filingType").getValue();
                		  ds.reload({
                      		    params:{
                                start:0,
                                limit:20,
                                filling:1
                      		    }
                      		})
                		 }
                      	},{
                      	text: "查询",
                		iconCls: "icon-search",
                		    handler: function() {
                    		new Ext.Window({
                        	id: "searchWin",
                        	title: "请输入查询条件",
                        	modal: true,
                        	height: 100,
                        	width: 320,
                        	layout: "form",
                        	labelWidth: 95,
                        	bodyStyle: "padding:5px 5px",
                        	items: [{
                            id: 'txtlicense',
                            fieldLabel: "号牌号码关键字",
                            xtype: "textfield",
                            anchor: '98%'
                        	}],
                        	buttons: [{
                            text: "查询",
                            handler: function() {
                        	ds.baseParams.filingType=Ext.getCmp("filingType").getValue();
                		  	ds.reload({
                      		    params:{
                                start:0,
                                limit:20,
                                license:Ext.getCmp("txtlicense").getValue()
                      		    }
                      		})
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
                      		id:"GuidangBtn",
                      		text:"归档",
                      		iconCls:"icon-Add",
                      		handler:function(){
                      			var selections = this.selModel.getSelections();
                    			var n = selections.length;
                    			if(n==0){
                    				Ext.MessageBox.alert("提示", "请选中要归档的信息!");
                        			return;
                    			}
                   				var ids="";
                    			for(i=0;i<n;i++){
                    				if(selections[i].data.filing===0){
                    					if(selections[i].data.tractorinfoId===null||selections[i].data.tractorinfoId===""){                    						
                    						ids=ids+selections[i].data.id+",";
                    					}else{
                    						ids=ids+selections[i].data.tractorinfoId+",";
                    					}
                    				}else{
                    					Ext.MessageBox.alert("提示", "部分信息已归档!");	
                    				}
                    			}
                    			Ext.Ajax.request({
                    				url:"main/tractorInfo.html?action=guiDangTractorInfo",
                    				success:function(resp){
                    					Ext.MessageBox.alert("提示", "归档成功!");
                    					ds.reload();
                    				},
                    				failure:function(){
                    					Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                    				},
                    				params:{
                    					ids:ids,
                    					type:1
                    				}
                    			});
                      		}.createDelegate(this)
                      	},{
                      		id:"GuidangBtn",
                      		text:"不归档",
                      		iconCls: "icon-Del",
                      		handler:function(){
                      			var selections = this.selModel.getSelections();
                    			var n = selections.length;
                    			if(n==0){
                    				Ext.MessageBox.alert("提示", "请选中要归档的信息!");
                        			return;
                    			}
                   				var ids="";
                    			for(i=0;i<n;i++){
                    				if(selections[i].data.filing===1){
                    					if(selections[i].data.tractorinfoId===null||selections[i].data.tractorinfoId===""){                    						
                    						ids=ids+selections[i].data.id+",";
                    					}else{
                    						ids=ids+selections[i].data.tractorinfoId+",";
                    					}
                    				}else{
                    					Ext.MessageBox.alert("提示", "部分信息未归档!");	
                    				}
                    			}
                    			Ext.Ajax.request({
                    				url:"main/tractorInfo.html?action=guiDangTractorInfo",
                    				success:function(resp){
                    					Ext.MessageBox.alert("提示", "不归档成功!");
                    					ds.reload();
                    				},
                    				failure:function(){
                    					Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                    				},
                    				params:{
                    					ids:ids,
                    					type:0
                    				}
                    			});
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
                    Ynzc.manage.CarGuiDangGrid.superclass.initComponent.apply(this,arguments);
                }
});
Ext.reg('carguidanggrid',Ynzc.manage.CarGuiDangGrid);