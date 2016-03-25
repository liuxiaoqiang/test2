Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.PeopleInfoGrid=Ext.extend(Ext.grid.GridPanel,{
	id:'peopleInfo',
	initComponent:function(){
	    var sm=new Ext.grid.CheckboxSelectionModel();
	    var fm=Ext.form;
        var expand= new Ext.ux.grid.RowExpander({
			tpl : new Ext.XTemplate(
				'<table width="600px" class="ynzcTableBlue">',
				'<tr><td>姓名</td><td colspan="2">{peopleName}</td><td rowspan="7"><img src="{picture}" width="140" height="180px"/></td></tr>',
				'<tr><td>性别</td><td colspan="2">{sex}</td></tr>',
				'<tr><td>出生日期</td><td colspan="2">{[new Date(values.birthday.time).format("Y-m-d")]}</td></tr>',
				'<tr><td>身份证</td><td colspan="2">{idCard}</td></tr>',
				'<tr><td>暂住证</td><td colspan="2">{idStay}</td></tr>',
				'<tr><td>联系电话</td><td colspan="2">{linkTel}</td></tr>',
				'<tr><td>邮政编码</td><td colspan="2">{postalcode}</td></tr>',
				'<tr><td>家庭地址</td><td colspan="3">{address}</td></tr>',
				'<tr><td>联系地址</td><td colspan="3">{linkAddress}</td></tr>',
				'<tr><td>籍贯</td><td colspan="3">{nativePlace}</td></tr>',
				'<tr><td>文化程度</td><td colspan="3">{degree}</td></tr>',
				'</table>'
			)
		});
	    var cm = new Ext.grid.ColumnModel([expand,new Ext.grid.RowNumberer(),sm,{
            header:'姓名',
            sortable:true,
            dataIndex:"peopleName"
        },{
            header:'性别',
            sortable:true,
            dataIndex:"sex"
        },{
            header:'出生日期',
            sortable:true,
            dataIndex:"birthday",
            renderer:function(value){
	        	value=new Date(value.time).format('Y-m-d');
	        	return value;
        	}
        },{
            header:'身份证编号',
            sortable:true,
            dataIndex:"idCard"
        },{
            header:'暂住证编号',
            sortable:true,
            dataIndex:"idStay"
        },{
            header:'家庭地址',
            sortable:true,
            dataIndex:"address"
        },{
            header:'联系电话',
            sortable:true,
            dataIndex:"linkTel"
        },{
            header:'健康状态录入',
            sortable:true,
            dataIndex:"bodyInfoId",
            renderer:function(value){
	        	if(value > 0){
	        		return "已录入";
	        	}else{
	        		return "未录入";
	        	}
        	}
        }]);
	    var reader=new Ext.data.JsonReader({
            totalProperty:"totalCount",
            root:"data",
            autoLoad:true,
            fields:[{
                name : 'id'
            },{
                name : 'peopleName'
            },{
                name : 'sex'
            },{
                name : 'birthday'
            },{
                name : 'idCard'
            },{
                name : 'idStay'
            },{
                name : 'address'
            },{
                name : 'linkAddress'
            },{
                name : 'linkTel'
            },{
                name : 'postalcode'
            },{
                name : 'nativePlace'
            },{
                name : 'degree'
            },{
                name : 'picture'
            },{
                name : 'bodyInfoId'
            },{
                name : 'year'
            },{
                name : 'writeUserId'
            },{
                name : 'writeDate'
            }]
	    });
        var ds=new Ext.data.Store({
            scopte:this,
            url:'main/peopleInfo.html?action=getPeopleInfo',
            reader:reader,
            sortInfo:{
                field:'id',
                direction:'DESC'
            }
        });
        Ext.apply(this,{
            id:'peopleInfo',
            plain:true,
            layout:'fit',
            border:false,
            cm:cm,
            sm:sm,
            frame:true,
            store:ds,
            loadMask:true,
            plugins:[expand,new Ext.ux.grid.Search({
                width:200,
                iconCls:false
            })],
            tbar:[{
                id:'peopleInfoAdd',
                text:'添加',
                iconCls:'icon-Add',
                handler:function(){
                    var addwin=new Ynzc.manage.PeopleInfoWin();
                    addwin.show(Ext.getCmp("peopleInfoAdd").getEl());
                	}
            	},'-',{
                    id:'refresh',
                    text:'打印详细信息',
                    iconCls:'icon-Add',
                    handler:function(){
                   		var selections=this.selModel.getSelections();
	        			Ext.Ajax.request({
		    				url:"main/reportPeopleInfo.html?action=getPeopleInfoReport",
		    				method:'post',
		    				success:function(resp){
//	        					var result=Ext.util.JSON.decode(resp.responseText);
//	        					var url = result.url;
//	        					var pdf = document.createElement("div");
//	        					pdf.innerHTML = "<object id='any' height=0% width=0% type='application/pdf' data=' " + url + "'></object>"; 
//	        					var d = pdf.childNodes.item(0);
//	        					d.click(); 
//	        					d.setActive(); 
//	        					d.focus(); 
//	        					d.pirnt();
		    				},
	                        faliure:function(){
	                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
	                        },
	                        params:{
	                            id:selections[0].data.id
	                        }
	    				});
                	}.createDelegate(this)
            	},'-',{
                    id:"peopleInfoDel",
                    text:"删除",
                    iconCls:"icon-Del",
                    handler:function(){
                        var selections=this.selModel.getSelections();
                        var n=selections.length;
                        if(n==0){
                            Ext.MessageBox.alert("提示","请选中要删除的人员!");
                            return;
                        }
                        var rds=[];
                        for(i=0;i<n;i++){
                            rds.push(selections[i].data);
                        }
                         Ext.Msg.show({
                            title:'系统确认',
                            msg:'你是否确认删除选中的人员?',
                            buttons:Ext.Msg.YESNO,
                            scope:this,
                            icon : Ext.MessageBox.QUESTION,
                            fn:function(btn){
                                if(btn=="yes"){
                                    Ext.Ajax.request({
                                        url:"main/peopleInfo.html?action=delPeopleInfo",
                                        method:"post",
                                        success:function(resp){
                							var result=Ext.util.JSON.decode(resp.responseText);
            								if(result.success==true){
            									Ext.MessageBox.alert("提示",result.reason);
            									ds.reload();
            								}else{
            									Ext.MessageBox.alert("提示",result.reason);
            								}
                                        },
                                        faliure:function(){
                                            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                                        },
                                        params:{
                                            id:Ext.util.JSON.encode(rds)
                                        }
                                    });
                                }
                            }
                         });
                    }.createDelegate(this)
                },'-',{
                    id:'refresh',
                    text:'刷新',
                    iconCls:'icon-Add',
                    handler:function(){
            			ds.reload();
                	}
            	}
            ],
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
        Ynzc.manage.PeopleInfoGrid.superclass.initComponent.apply(this,arguments);
        ds.load({
            params:{
                start:0,
                limit:20
            }
        });
        this.on("rowdblclick",function(grid,index,event){
            var record=grid.getStore().getAt(index);
            Ynzc.manage.peopleInfoId=record.data.id;
            Ext.Ajax.request({
                url:"main/peopleInfo.html?action=updatePeopleCheck",
                method:"post",
                success:function(resp){
					var result=Ext.util.JSON.decode(resp.responseText);
					if(result.success==true){
						new Ynzc.manage.PeopleInfoUpdateWin().show(grid.getEl());
			            Ext.getCmp("peopleName").setValue(record.data.peopleName);
			            Ext.getCmp("sex").setValue(record.data.sex);
			            Ext.getCmp("birthday").setValue(new Date(record.data.birthday.time).format('Y-m-d'));
			            Ext.getCmp("idCard").setValue(record.data.idCard);
			            Ext.getCmp("idStay").setValue(record.data.idStay);
			            Ext.getCmp("address").setValue(record.data.address);
			            Ext.getCmp("linkAddress").setValue(record.data.linkAddress);
			            Ext.getCmp("linkTel").setValue(record.data.linkTel);
			            Ext.getCmp("postalcode").setValue(record.data.postalcode);
			            Ext.getCmp("nativePlace").setValue(record.data.nativePlace);
			            Ext.getCmp("degree").setValue(record.data.degree);
			            Ext.getCmp("photoDir").setValue(record.data.picture);
					}else{
						Ext.MessageBox.alert("提示",result.reason);
					}
                },
                faliure:function(){
                    Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
                },
                params:{
                    id:Ext.util.JSON.encode(record.data)
                }
            });
        });
	}
});
Ext.reg('peopleInfoGrid',Ynzc.manage.PeopleInfoGrid);
