Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.UniteHarvesterCheckInfoGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'uniteHarvesterCheckInfo',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                     var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'收割机号牌',
                        sortable:true,
                        dataIndex:"harvesterCode",
                        renderer:function(value,res,record){
                        	return record.data.platecode+"."+value;
                        }
                    },{
                        header:'检验年份',
                        sortable:true,
                        dataIndex:"checkDate",
                        renderer:function(value){
                        	return new Date(value.time).format('Y');
                        }
                    },{
                        header:'姓名/单位',
                        sortable:true,
                        dataIndex:"harvesterOwner"
                    },{
                        header:'机械类型',
                        sortable:true,
                        dataIndex:"harvesterType",
                        renderer:function(v){
                        	if(v==1){
                        		return "方向盘自走式联合收割机"
                        	}else if(v==2)
                        	{
                        		return "操纵杆自走式联合收割机"
                        	}else if(v==3)
                        	{
                        		return "悬挂式联合收割机"
                        	}else{
                        		return "未知类型"
                        	}
                        }
                    },{
                        header:'厂牌型号',
                        sortable:true,
                        dataIndex:'harvesterChangPaiType'
                    },{
                        header:'检验时间',
                        sortable:true,
                        dataIndex:'checkDate',
                        renderer:function(v){
                        	return new Date(v.time).format('Y-m-d')
                        }
                    },{
                        header:'检验有效期',
                        sortable:true,
                        dataIndex:'checkLiveDate',
                        renderer:function(v){
                        	return new Date(v.time).format('Y-m-d')
                        }
                    }]);
                    var reader=new Ext.data.JsonReader({
                        totalProperty:"totalCount",
                        root:"data",
                        autoLoad:true,
                        fields:[{
                            name : 'id'
                        },{
                            name : 'harvesterCode'
                        },{
                            name : 'harvesterOwner'
                        },{
                            name : 'harvesterGuanXiaDi'
                        },{
                            name : 'telephoneNum'
                        },{
                            name : 'liveAddress'
                        },{
                            name : 'livePostCode'
                        },{
                            name : 'tempAddress'
                        },{
                            name : 'tempPostCode'
                        },{
                            name : 'certitype'
                        },{
                            name : 'certiCode'
                        },{
                            name : 'liveType'
                        },{
                            name : 'liveCode'
                        },{
                            name : 'harvesterType'
                        },{
                            name : 'harvesterGetWay'
                        },{
                            name : 'harvesterChangPaiType'
                        },{
                            name : 'harvesterQuality'
                        },{
                            name : 'harvesterSitNum'
                        },{
                            name : 'harvesterQuality'
                        },{
                            name : 'harvesterEngineCode'
                        },{
                            name : 'harvesterBodyColor'
                        },{
                            name : 'harvesterBodyCode'
                        },{
                            name : 'comeProofType'
                        },{
                            name : 'importType'
                        },{
                            name : 'otherType'
                        },{
                            name : 'applicationType'
                        },{
                            name : 'harvesterPhotoUrl'
                        },{
                            name : 'registerDate'
                        },{
                            name : 'registerMan'
                        },{
                            name : 'unitid'
                        },{
                        	name : 'platecode'
                        },{
                            name : 'harvesterState'
                        },{
                            name : 'checkid'
                        },{
                            name : 'checkResult'
                        },{
                            name : 'checkDate'
                        },{
                            name : 'checkLiveDate'
                        },{
                            name : 'checkman'
                        },{
                            name : 'checkUnitName'
                        },{
                            name : 'insuranceCode'
                        },{
                            name : 'insurancedate'
                        },{
                            name : 'insuranceType'
                        },{
                            name : 'insuranceLivedate'
                        },{
                            name : 'insuranceName'
                        },{
                            name : 'checkRegisterMan'
                        },{
                            name : 'checkRegisterdate'
                        },{
                            name : 'checkPaizhengMan'
                        },{
                            name : 'checkPaizhengDate'
                        },{
                            name : 'checkLingDaoMan'
                        },{
                            name : 'checkLingDaodate'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/uniteharvesterCheckInfo.html?action=getUniteharvesterCheckViewAll',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'uniteHarvesterCheckInfo',
                        plain:true,
                        layout:'fit',
                        border:false,
                        cm:cm,
                        sm:sm,
                        frame:true,
                        store:ds,
                        loadMask:true,
                        plugins:new Ext.ux.grid.Search({
                            width:200,
                            iconCls:false
                        }),
                        tbar:[{
                            id:'userAdd',
                            text:'业务办理',
                            iconCls:'icon-UserAdd',
                            handler:function(){
                            	var dengji=new Ext.Window({
                            		id:'enteyNum',
                            		title:'请输入要[年检登记]的号牌号码',
                            		width:300,
                            		height:120,
                            		layout:'form',
                            		bodyStyle:'padding:10px,5px,5px,3px',
                            		resizable:false,
			           			    modal:true,
                            		items:[{
                            			id:'carnum',
                            			xtype:'textfield',
                            			fieldLabel:'请输入车辆号码',
                            			anchor:'98%'
                            		}],
                            		buttons:[{
                            			id:'addInfo',
                            			text:'确定',
                            			handler:function(){
                            				if(checkNum(Ext.getCmp("carnum").getValue())){Ext.ux.Toast.msg("操作提示","需要年检登记的车辆号码不能为空或只能是数字");return};
                            				Ext.getCmp("addInfo").disable();
                            				Ext.Ajax.request({
                            					url:'main/uniteharvesterInfo.html?action=findUniteharvesterByCarNum',
                            					success:function(data){
                            						var result=Ext.util.JSON.decode(data.responseText);
                            						if(result!=null&&result.UniteHarvester[0]!=null){
                            							if(result.UniteHarvester[0].harvesterState==1){
                            								{Ext.ux.Toast.msg("操作提示","该车已经被注销了，不能进行本次操作！");return};
                            							}
                            							var addwin=new Ynzc.manage.UniteHarvesterCheckInfoGridAddWin();
                               					    	addwin.show();
                               					    	Ext.getCmp("harvesterCode").setValue(result.UniteHarvester[0].platecode+"."+result.UniteHarvester[0].harvesterCode);
	                           					    	Ext.getCmp("harvesterOwner").setValue(result.UniteHarvester[0].harvesterOwner);
	                           					    	Ext.getCmp("telephoneNum").setValue(result.UniteHarvester[0].telephoneNum);
	                           					    	Ext.getCmp("liveAddress").setValue(result.UniteHarvester[0].liveAddress);
	                           					    	Ext.getCmp("livePostCode").setValue(result.UniteHarvester[0].livePostCode);
	                           					    	Ext.getCmp("tempAddress").setValue(result.UniteHarvester[0].tempAddress);
	                           					    	Ext.getCmp("tempPostCode").setValue(result.UniteHarvester[0].tempPostCode);
	                           					    	Ext.getCmp("certitype").setValue(result.UniteHarvester[0].certitype);
	                           					    	Ext.getCmp("certiCode").setValue(result.UniteHarvester[0].certiCode);
	                           					    	Ext.getCmp("liveType").setValue(result.UniteHarvester[0].liveType);
	                           					    	Ext.getCmp("liveCode").setValue(result.UniteHarvester[0].liveCode);
	                           					    	Ext.getCmp("harvesterType").setValue(result.UniteHarvester[0].harvesterType);
	                           					    	Ext.getCmp("harvesterChangPaiType").setValue(result.UniteHarvester[0].harvesterChangPaiType);
	                           					    	Ext.getCmp("harvesterQuality").setValue(result.UniteHarvester[0].harvesterQuality);
	                           					    	Ext.getCmp("harvesterSitNum").setValue(result.UniteHarvester[0].harvesterSitNum);
	                           					    	Ext.getCmp("harvesterEngineCode").setValue(result.UniteHarvester[0].harvesterEngineCode);
	                           					    	Ext.getCmp("harvesterBodyColor").setValue(result.UniteHarvester[0].harvesterBodyColor);
	                           					    	Ext.getCmp("harvesterBodyCode").setValue(result.UniteHarvester[0].harvesterBodyCode);
	                           					    	Ext.getCmp("caraddress").setMyValue(result.UniteHarvester[0].unitid);
	                           					    	Ext.getCmp("unitRegion").setValue(result.UniteHarvester[0].harvesterGuanXiaDi);
	                           					    	var comeProofType=result.UniteHarvester[0].comeProofType.split(",");
	                           						    if(comeProofType[0]==1){Ext.getCmp("xiaoshoujiaoyi").setValue(true);}
	                           						    if(comeProofType[1]==1){Ext.getCmp("tiaojieshu").setValue(true);}
	                           						    if(comeProofType[2]==1){Ext.getCmp("caidingshu").setValue(true);}
	                           						    if(comeProofType[3]==1){Ext.getCmp("panjueshi").setValue(true);}
	                           						    if(comeProofType[4]==1){Ext.getCmp("xiangguanwenshu").setValue(true);}
	                           						    if(comeProofType[5]==1){Ext.getCmp("pizhunwenjian").setValue(true);}
	                           						    if(comeProofType[5]==1){Ext.getCmp("diaobozhengming").setValue(true);}
	                           						    if(comeProofType[5]==1){Ext.getCmp("zhongcaicaijueshu").setValue(true);}
	                           						    var getWay=result.UniteHarvester[0].harvesterGetWay.split(",");
	                           						    if(getWay[0]==1){Ext.getCmp("goumai").setValue(true);}
	                           						    if(getWay[1]==1){Ext.getCmp("zhongjiang").setValue(true);}
	                           						    if(getWay[2]==1){Ext.getCmp("jicheng").setValue(true);}
	                           						    if(getWay[3]==1){Ext.getCmp("zengyu").setValue(true);}
	                           						    if(getWay[4]==1){Ext.getCmp("xieyidichang").setValue(true);}
	                           						    if(getWay[5]==1){Ext.getCmp("zichanchongzu").setValue(true);}
	                           						    if(getWay[6]==1){Ext.getCmp("zhengtimaimai").setValue(true);}
	                           						    if(getWay[7]==1){Ext.getCmp("diaobo").setValue(true);}
	                           						    if(getWay[8]==1){Ext.getCmp("fayuan").setValue(true);}
	                           						    if(getWay[9]==1){Ext.getCmp("zhongcai").setValue(true);}
	                           						    if(getWay[10]==1){Ext.getCmp("qita").setValue(true);}
	                           						    var imports=result.UniteHarvester[0].importType.split(",");
	                           						    if(imports[0]==1){Ext.getCmp("huowujinkou").setValue(true);}
	                           						    if(imports[1]==1){Ext.getCmp("moshouzousi").setValue(true);}
	                           						    if(imports[2]==1){Ext.getCmp("china").setValue(true);}
	                           						    var others=result.UniteHarvester[0].otherType.split(",");
	                           						    if(others[0]==1){Ext.getCmp("guochannongji").setValue(true);}
	                           						    if(others[1]==1){Ext.getCmp("nongjidangan").setValue(true);}
	                           						    if(others[2]==1){Ext.getCmp("shenfenzhengming").setValue(true);}
	                           						    if(others[3]==1){Ext.getCmp("xieyizhixing").setValue(true);}
	                           						    if(others[4]==1){Ext.getCmp("gongzhengshu").setValue(true);}
                            						}else{
                            							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
                            							Ext.getCmp("addInfo").enable();
                            						}
                            					},
                            					failure:function(){
                            							Ext.ux.Toast.msg("操作提示","本地区暂无该车辆信息");
                            							Ext.getCmp("addInfo").enable();
                            					},
                            					params:{
                            						carCode:Ext.getCmp("carnum").getValue(),
                            						unitid:UnitID
                            					}
                            				});
                            				Ext.getCmp("enteyNum").close();
                            			}
                            		},{
                            			text:'取消',
                            			handler:function(){
                            				Ext.getCmp("enteyNum").close();
                            			}
                            		}]
                            	});
                            	dengji.show();
                            	}},'-',{
                                id:"userDel",
                                text:"删除",
                                iconCls:"icon-UserDel",
                                handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请选中要删除的年检登记信息!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的年检登记信息?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                	url:'main/uniteharvesterCheckInfo.html?action=deleteUniteharvesterCheck',
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的年检登记信息");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                    	uniteharvesterchecklist:Ext.util.JSON.encode(rds)
                                                    }
                                                });
                                            }
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
                    Ynzc.manage.UniteHarvesterCheckInfoGrid.superclass.initComponent.apply(this,arguments);
                    ds.load({
                        params:{
                            start:0,
                            limit:20
                        }
                    });
                    var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在查询该条记录,请稍等...',
			     		removeMask:true
	                });
                    this.on("rowdblclick",function(grid,index,event){
		                mask.show();
                        var record=grid.getStore().getAt(index);
                        var addwin=new Ynzc.manage.UniteHarvesterCheckInfoGridUpdateWin();
					    	addwin.show();
					    	Ext.getCmp("harvesterCode").setValue(record.data.platecode+"."+record.data.harvesterCode);		
						    Ext.getCmp("harvesterOwner").setValue(record.data.harvesterOwner);
						    Ext.getCmp("telephoneNum").setValue(record.data.telephoneNum);
						    Ext.getCmp("liveAddress").setValue(record.data.liveAddress);
						    Ext.getCmp("livePostCode").setValue(record.data.livePostCode);
						    Ext.getCmp("tempAddress").setValue(record.data.tempAddress);
						    Ext.getCmp("tempPostCode").setValue(record.data.tempPostCode);
						    Ext.getCmp("certitype").setValue(record.data.certitype);
						    Ext.getCmp("certiCode").setValue(record.data.certiCode);
						    Ext.getCmp("liveType").setValue(record.data.liveType);
						    Ext.getCmp("liveCode").setValue(record.data.liveCode);
						    Ext.getCmp("harvesterType").setValue(record.data.harvesterType);
						    Ext.getCmp("harvesterChangPaiType").setValue(record.data.harvesterChangPaiType);
						    Ext.getCmp("harvesterQuality").setValue(record.data.harvesterQuality);
						    Ext.getCmp("harvesterSitNum").setValue(record.data.harvesterSitNum);
						    Ext.getCmp("harvesterEngineCode").setValue(record.data.harvesterEngineCode);
						    Ext.getCmp("harvesterBodyColor").setValue(record.data.harvesterBodyColor);
						    Ext.getCmp("harvesterBodyCode").setValue(record.data.harvesterBodyCode);
						    Ext.getCmp("caraddress").setMyValue(record.data.unitid);
						    Ext.getCmp("unitRegion").setValue(record.data.harvesterGuanXiaDi);
						    
						    Ext.getCmp("checkNowResult").setValue(record.data.checkResult);
						    Ext.getCmp("checkResult").setValue(record.data.checkResult);
					    	Ext.getCmp("checkNowMan").setValue(record.data.checkman);
					    	Ext.getCmp("checkMan").setValue(record.data.checkman);
					    	if(record.data.checkDate!=null){
					    		Ext.getCmp("checkNowDate").setValue(new Date(record.data.checkDate.time).format('Y-m-d'));
					    		Ext.getCmp("checkDate").setValue(new Date(record.data.checkDate.time).format('Y-m-d'));
					    	}
					    	Ext.getCmp("baoxianType").setValue(record.data.insuranceType);
					    	Ext.getCmp("checkUnitName").setValue(record.data.checkUnitName);
					    	Ext.getCmp("baodanCode").setValue(record.data.insuranceCode);
					    	Ext.getCmp("baoxianName").setValue(record.data.insuranceName);
					    	if(record.data.insurancedate!=null){
					    		Ext.getCmp("baoxianDate").setValue(new Date(record.data.insurancedate.time).format('Y-m-d'));
					    	}
					    	if(record.data.insuranceLivedate!=null){
					    		Ext.getCmp("baoxianLiveDate").setValue(new Date(record.data.insuranceLivedate.time).format('Y-m-d'));
					    	}
					    	if(record.data.checkLiveDate!=null){
					    		Ext.getCmp("checknowLiveDate").setValue(new Date(record.data.checkLiveDate.time).format('Y-m-d'));
					    		Ext.getCmp("checkLiveDate").setValue(new Date(record.data.checkLiveDate.time).format('Y-m-d'));
					    	}
					    	Ext.getCmp("dengjiMan").setValue(record.data.checkRegisterMan);
					    	if(record.data.checkRegisterdate!=null){
					    		Ext.getCmp("dengjiDate").setValue(new Date(record.data.checkRegisterdate.time).format('Y-m-d'));
					    	}
					    	Ext.getCmp("paizhengMan").setValue(record.data.checkPaizhengMan);
					    	if(record.data.checkPaizhengDate!=null){
					    		Ext.getCmp("paizhengDate").setValue(new Date(record.data.checkPaizhengDate.time).format('Y-m-d'));
					    	}
					    	Ext.getCmp("lingdaoMan").setValue(record.data.checkLingDaoMan);
					    	if(record.data.checkLingDaodate!=null){
					    		Ext.getCmp("lingdaoDate").setValue(new Date(record.data.checkLingDaodate.time).format('Y-m-d'));
					    	}
					    	Ynzc.manage.uniteHarvestcheckId=record.data.checkid;
					    	Ynzc.manage.checkuniteHarvestId=record.data.id;
						    var comeProofType=record.data.comeProofType.split(",");
						    if(comeProofType[0]==1){Ext.getCmp("xiaoshoujiaoyi").setValue(true);}
						    if(comeProofType[1]==1){Ext.getCmp("tiaojieshu").setValue(true);}
						    if(comeProofType[2]==1){Ext.getCmp("caidingshu").setValue(true);}
						    if(comeProofType[3]==1){Ext.getCmp("panjueshi").setValue(true);}
						    if(comeProofType[4]==1){Ext.getCmp("xiangguanwenshu").setValue(true);}
						    if(comeProofType[5]==1){Ext.getCmp("pizhunwenjian").setValue(true);}
						    if(comeProofType[5]==1){Ext.getCmp("diaobozhengming").setValue(true);}
						    if(comeProofType[5]==1){Ext.getCmp("zhongcaicaijueshu").setValue(true);}
						    var getWay=record.data.harvesterGetWay.split(",");
						    if(getWay[0]==1){Ext.getCmp("goumai").setValue(true);}
						    if(getWay[1]==1){Ext.getCmp("zhongjiang").setValue(true);}
						    if(getWay[2]==1){Ext.getCmp("jicheng").setValue(true);}
						    if(getWay[3]==1){Ext.getCmp("zengyu").setValue(true);}
						    if(getWay[4]==1){Ext.getCmp("xieyidichang").setValue(true);}
						    if(getWay[5]==1){Ext.getCmp("zichanchongzu").setValue(true);}
						    if(getWay[6]==1){Ext.getCmp("zhengtimaimai").setValue(true);}
						    if(getWay[7]==1){Ext.getCmp("diaobo").setValue(true);}
						    if(getWay[8]==1){Ext.getCmp("fayuan").setValue(true);}
						    if(getWay[9]==1){Ext.getCmp("zhongcai").setValue(true);}
						    if(getWay[10]==1){Ext.getCmp("qita").setValue(true);}
						    var imports=record.data.importType.split(",");
						    if(imports[0]==1){Ext.getCmp("huowujinkou").setValue(true);}
						    if(imports[1]==1){Ext.getCmp("moshouzousi").setValue(true);}
						    if(imports[2]==1){Ext.getCmp("china").setValue(true);}
						    var others=record.data.otherType.split(",");
						    if(others[0]==1){Ext.getCmp("guochannongji").setValue(true);}
						    if(others[1]==1){Ext.getCmp("nongjidangan").setValue(true);}
						    if(others[2]==1){Ext.getCmp("shenfenzhengming").setValue(true);}
						    if(others[3]==1){Ext.getCmp("xieyizhixing").setValue(true);}
						    if(others[4]==1){Ext.getCmp("gongzhengshu").setValue(true);}
						    Ynzc.manage.UniteHarvestState=record.data.harvesterState;
						    mask.hide();
                    });
                }
});
Ext.reg('uniteHarvesterCheckInfoGrid',Ynzc.manage.UniteHarvesterCheckInfoGrid);