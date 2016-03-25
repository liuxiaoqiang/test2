Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReportWin=Ext.extend(Ext.Window,{
	id: 'reportWin',
	sourceURL:null,
	params:{},
	initComponent:function(){
		Ext.apply(this,{
			height:600,
			width:900,
			modal:true,
        	html:'<iframe scrolling="no" width="900" height="600" frameborder="0" src="./Pages/showReport.jsp" id="reportFrame"></iframe>',
			buttons:[{
				id:'wordSetSetup',
				text:'页边距设置',
				handler:function(){
                var win= new Ext.Window({
                	id:"typeUpdatewin",
                	title:"页边距修改",
                	modal:true,
                	height:180,
                	width:200,
                	resizable : false,
                	layout:"form",
                	labelWidth:80,
                	bodyStyle:"padding:5px 5px",
                	items:[{
                		id:"WordSettopMargin",
                		fieldLabel:"上边距",
                		value:Ynzc.manage.topMargin,
                		xtype:"textfield",
                		regex:/^[0-9]\d*$/,
                		regexText:"只能输入包括0的正整数",
                		anchor:'98%'
                	},{
                		id:"WordSetbottomMargin",
                		fieldLabel:"下边距",
                		value:Ynzc.manage.bottomMargin,
                		regex:/^[0-9]\d*$/,
                		regexText:"只能输入包括0的正整数",
                		xtype:"textfield",
                		anchor:'98%'
                	},{
                		id:"WordSetleftMargin",
                		fieldLabel:"左边距",
                		value:Ynzc.manage.leftMargin,
                		xtype:"textfield",
                		regex:/^[0-9]\d*$/,
                		regexText:"只能输入包括0的正整数",
                		anchor:'98%'
                	},{
                		id:"WordSetrightMargin",
                		fieldLabel:"右边距",
                		value:Ynzc.manage.rightMargin,
                     	xtype:"textfield",
                     	regex:/^[0-9]\d*$/,
              	     	regexText:"只能输入包括0的正整数",
              	     	anchor:'98%'
                	}],
                	buttons:[{
                		text:"修改",
                		handler:function(){
                			var regExp=/^[0-9]\d*$/;
                			if(Ext.getCmp("WordSettopMargin").getValue()==""){Ext.ux.Toast.msg("提示","请填写上边距。");return;}
                			if(Ext.getCmp("WordSetbottomMargin").getValue()==""){Ext.ux.Toast.msg("提示","请填写下边距。");return;}
                			if(Ext.getCmp("WordSetleftMargin").getValue()==""){Ext.ux.Toast.msg("提示","请填写左边距。");return;}
                			if(Ext.getCmp("WordSetrightMargin").getValue()==""){Ext.ux.Toast.msg("提示","请填写右边距。");return;}
                			if(!regExp.test(Ext.getCmp("WordSettopMargin").getValue())){Ext.ux.Toast.msg("提示","请确认所填写的上边距合法。");return;}
                			if(!Ext.getCmp("WordSetbottomMargin").getValue().match(regExp)){Ext.ux.Toast.msg("提示","请确认所填写的下边距合法。");return;}
                			if(!regExp.test(Ext.getCmp("WordSetleftMargin").getValue())){Ext.ux.Toast.msg("提示","请确认所填写的左边距合法。");return;}
                			if(!regExp.test(Ext.getCmp("WordSetrightMargin").getValue())){Ext.ux.Toast.msg("提示","请确认所填写的右边距合法。");return;}
                			Ext.Ajax.request({
                				url:"main/word.html?action=updateWordSet",
                				method:"post",
                				success:function(){
                				Ext.ux.Toast.msg("提示","页边距修改成功.");
                				Ynzc.manage.topMargin=Ext.getCmp("WordSettopMargin").getValue();
                				Ynzc.manage.bottomMargin=Ext.getCmp("WordSetbottomMargin").getValue();
                				Ynzc.manage.leftMargin=Ext.getCmp("WordSetleftMargin").getValue();
                				Ynzc.manage.rightMargin=Ext.getCmp("WordSetrightMargin").getValue();
                				Ext.getCmp("typeUpdatewin").close();},
                				failure:function(){Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");},
                				params:{
                					id:Ynzc.manage.id,
                					unitid:Ynzc.manage.unitid,
                					wordtype:Ynzc.manage.wordtype,
                					WordSettopMargin:Ext.getCmp("WordSettopMargin").getValue(),
                					WordSetbottomMargin:Ext.getCmp("WordSetbottomMargin").getValue(),
                					WordSetleftMargin:Ext.getCmp("WordSetleftMargin").getValue(),
                					WordSetrightMargin:Ext.getCmp("WordSetrightMargin").getValue()}
                			});
                	}
                	},
                	{text:"取消",handler:function(){ Ext.getCmp("typeUpdatewin").close(); }}
                	]});
                	win.show();      
				}
				},{
					id:'reportSetup',
					text:'打印',
					handler:function(){
						var iframe=Ext.get("reportFrame").dom.contentWindow.document;
						iframe.getElementById("reportOBJ").PrintWithDialog();
						if(this.params.functionType === "putOut"){
						Ext.Ajax.request({
							url:"main/drivingLicence.html?action=drivingLicencePutOut",
							method:"post",
							success:function(resp){
								var result=Ext.util.JSON.decode(resp.responseText);
								if(result.success==true){
									Ext.ux.Toast.msg("提示",result.reason);
									Ext.getCmp(this.params.reloadType).getStore().reload();
									Ext.getCmp("reportWin").close();
								}else{
									Ext.ux.Toast.msg("提示",result.reason);
									Ext.getCmp(this.params.reloadType).getStore().reload();
									Ext.getCmp("reportWin").close();
								}
		                    }.createDelegate(this),
		                    faliure:function(){
		                        Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
		                    },
		                    params:this.params
						});
						}else if(this.params.functionType === "examAttest"){
							Ext.Ajax.request({
								url:"main/driverStrInfo.html?action=putOutPermitPractice",
								method:"post",
								success:function(resp){
									var result=Ext.util.JSON.decode(resp.responseText);
									if(result.success==true){
										Ext.ux.Toast.msg("提示",result.reason);
										Ext.getCmp("dirverClassStrExamGrid").getStore().reload();
										var iframe=Ext.get("reportFrame").dom.contentWindow.document;
								//		iframe.getElementById("reportOBJ")=null;
										Ext.getCmp("reportWin").close();
									}else{
										Ext.ux.Toast.msg("提示",result.reason);
										var iframe=Ext.get("reportFrame").dom.contentWindow.document;
									//	iframe.getElementById("reportOBJ")=null;
										Ext.getCmp("reportWin").close();
									}
								}.createDelegate(this),
								faliure:function(){
									Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
								},
								params:this.params
							});
						}else{
							Ext.getCmp("reportWin").close();
						}
					}.createDelegate(this)
				}]
			})
		Ynzc.manage.TracReportWin.superclass.initComponent.apply(this,arguments);
        var mask = new Ext.LoadMask(Ext.getBody(), {
     		msg : '正在生成,请稍等...',
     		removeMask:true
        });
        mask.show();
		Ext.Ajax.request({
			url:this.sourceURL,
			success:function(response){
				var res=Ext.util.JSON.decode(response.responseText);
				var iframe=Ext.get("reportFrame").dom.contentWindow.document;
				var div=iframe.getElementById("showReport");
				div.innerHTML='<object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000" width="870" height="600" border="0" id="reportOBJ"><param name="_Version"value="65539"><param name="_ExtentX"value="20108"><param name="_ExtentY"value="10866"><param name="_StockProps"value="0"><param name="SRC"value="'+res.url+'"></object>';
				iframe.getElementById("reportOBJ").SetShowToolBar(0);
				mask.hide();
			},
            faliure:function(){
                Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
            },
            params:this.params
		});
	}
});