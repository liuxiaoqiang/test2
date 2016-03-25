Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.UniteHarvesterInfoGrid=Ext.extend(Ext.grid.GridPanel,{
                id:'uniteHarvesterInfoGrid',
                initComponent:function(){
                    var sm=new Ext.grid.CheckboxSelectionModel();
                    var fm=Ext.form;
                    var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),sm,{
                        header:'业务类型',
                        sortable:true,
                        renderer:function(value,res,record){
                        	return "注册";
                         }
                    },{
                        header:'管辖地',
                        sortable:true,
                        dataIndex:"harvesterGuanXiaDi"
                    },{
                        header:'号牌号码',
                        sortable:true,
                        dataIndex:"harvesterCode",
                        renderer:function(value,res,record){
                        	return record.data.platecode+"."+value;
                        }
                    },{
                        header:'所有人',
                        sortable:true,
                        dataIndex:"harvesterOwner"
                    },{
                        header:'厂牌型号',
                        sortable:true,
                        dataIndex:'harvesterChangPaiType'
                    },{
                        header:'发动机号',
                        sortable:true,
                        dataIndex:'harvesterEngineCode'
                    },{
                        header:'登记人',
                        sortable:true,
                        dataIndex:'registerMan'
                    },{
                        header:'登记日期',
                        sortable:true,
                        dataIndex:'registerDate',
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
                            name : 'harvesterState'
                        },{
                        	name : 'platecode'
                        },{
                        	name : 'registman'
                        },{
                        	name : 'paizhengman'
                        },{
                        	name : 'leaderman'
                        }]
                    });
                    var ds=new Ext.data.Store({
                        scopte:this,
                        url:'main/uniteharvesterInfo.html?action=getUniteharvesterViewAll',
                        reader:reader,
                        sortInfo:{
                            field:'id',
                            direction:'ASC'
                        }
                    });
                    Ext.apply(this,{
                        id:'uniteHarvesterInfoGrid',
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
                            	var addwin=new Ynzc.manage.UniteHarvesterInfoGridAddWin();
       					    	addwin.show();
                            }},'-',{
                                id:"userDel",
                                text:"删除",
                                iconCls:"icon-UserDel",
                                handler:function(){
                                    var selections=this.selModel.getSelections();
                                    var n=selections.length;
                                    if(n==0){
                                        Ext.ux.Toast.msg("提示","请选中要删除的注册登记信息!");
                                        return;
                                    }
                                    var rds=[];
                                    for(i=0;i<n;i++){
                                        rds.push(selections[i].data);
                                    }
                                     Ext.Msg.show({
                                        title:'系统确认',
                                        msg:'你是否确认删除选中的注册登记信息?',
                                        buttons:Ext.Msg.YESNO,
                                        scope:this,
                                        icon : Ext.MessageBox.QUESTION,
                                        fn:function(btn){
                                            if(btn=="yes"){
                                                Ext.Ajax.request({
                                                	url:'main/uniteharvesterInfo.html?action=deleteUniteharvester',
                                                    method:"post",
                                                    success:function(){
                                                        Ext.ux.Toast.msg("提示","已成功删除选中的注册登记信息");
                                                        ds.reload();
                                                    },
                                                    faliure:function(){
                                                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                                    },
                                                    params:{
                                                    	uniteharvesterlist:Ext.util.JSON.encode(rds)
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
                    Ynzc.manage.UniteHarvesterInfoGrid.superclass.initComponent.apply(this,arguments);
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
                        var addwin=new Ynzc.manage.UniteHarvesterInfoGridUpdateWin();
					    	addwin.show(grid.getEl());
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
					    Ext.getCmp("applicationType").setValue(record.data.applicationType);
					    Ext.getCmp("jinbandate").setValue(new Date(record.data.registerDate.time).format('Y-m-d'));
					    Ext.getCmp("jinbanMan").setValue(record.data.registerMan);
					    Ext.getCmp("caraddress").setMyValue(record.data.unitid);
					    Ext.getCmp("combRegion").setValue(record.data.harvesterGuanXiaDi);
					    if(record.data.harvesterPhotoUrl!=null&&record.data.harvesterPhotoUrl!=""){
					    	Ext.getCmp("photoDir").setValue(record.data.harvesterPhotoUrl);
					    }
					    Ynzc.manage.uniteHarvestId=record.data.id;
					    Ynzc.manage.uniteHarvestCode=record.data.harvesterCode;
					    var comeProofType=record.data.comeProofType.split(",");
					    if(comeProofType[0]==1){Ext.getCmp("xiaoshoujiaoyi").setValue(true);}
					    if(comeProofType[1]==1){Ext.getCmp("tiaojieshu").setValue(true);}
					    if(comeProofType[2]==1){Ext.getCmp("caidingshu").setValue(true);}
					    if(comeProofType[3]==1){Ext.getCmp("panjueshi").setValue(true);}
					    if(comeProofType[4]==1){Ext.getCmp("xiangguanwenshu").setValue(true);}
					    if(comeProofType[5]==1){Ext.getCmp("pizhunwenjian").setValue(true);}
					    if(comeProofType[6]==1){Ext.getCmp("diaobozhengming").setValue(true);}
					    if(comeProofType[7]==1){Ext.getCmp("zhongcaicaijueshu").setValue(true);}
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
Ext.reg('uniteHarvesterInfoGrid',Ynzc.manage.UniteHarvesterInfoGrid);