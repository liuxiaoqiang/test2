Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.ReportWin=Ext.extend(Ext.Window,{
	sourceURL:null,
	params:{},
	initComponent:function(){
		Ext.apply(this,{
			height:600,
			width:900,
			modal:true,
            listeners:{
        		"close":function(){
					document.all.oframe.Close();
        		}
        	},
			html:'<object classid="clsid:00460182-9E5E-11d5-B7C8-B8269041DD57" codeBase="./WebActionX/dsoframer.cab#version=2,3,0,0" id="oframe" width="100%" height="100%"><param name="_ExtentX"" value="16960"><param name="_ExtentY" value="13600"><param name="BorderColor" value="-2147483632"><param name="BackColor" value="-2147483643"><param name="ForeColor" value="-2147483640"><param name="TitlebarColor" value="-2147483635"><param name="TitlebarTextColor" value="-2147483634"><param name="BorderStyle" value="1"><param name="Titlebar" value="0"><param name="Toolbars" value="1"><param name="Menubar" value="0"><param name="IsNoCopy" value="-1"></object>',
			buttons:[{
				id:'reportSetup',
				text:'打印预览',
	 			handler:function(){
					document.all.oframe.PrintPreview();
				}
			},{
				id:'reportSetup',
				text:'退出预览',
				handler:function(){
				document.all.oframe.PrintPreviewExit();
				}
			},{
				id:'reportSetup',
				text:'打印设置',
				handler:function(){
					document.all.oframe.showdialog(5);
				}
			},{
				id:'reportSetup',
				text:'打印',
				handler:function(){
					document.all.oframe.showdialog(4);
					if(this.params.functionType === "putOut"){
						Ext.Ajax.request({
							url:"main/drivingLicence.html?action=drivingLicencePutOut",
							method:"post",
							success:function(resp){
								var result=Ext.util.JSON.decode(resp.responseText);
								if(result.success==true){
									Ext.ux.Toast.msg("提示",result.reason);
									Ext.getCmp("driverlicencePutOutMgr").getStore().reload();
									this.close();
								}else{
									Ext.ux.Toast.msg("提示",result.reason);
									Ext.getCmp("driverlicencePutOutMgr").getStore().reload();
									this.close();
								}
		                    },
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
									this.close();
								}else{
									Ext.ux.Toast.msg("提示",result.reason);
									this.close();
								}
							},
							faliure:function(){
								Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
							},
							params:this.params
						});
					}else{
						document.all.oframe.showdialog(4);
					}
				}.createDelegate(this)
			}]
		})
		Ynzc.manage.ReportWin.superclass.initComponent.apply(this,arguments);
        var mask = new Ext.LoadMask(Ext.getBody(), {
     		msg : '正在生成,请稍等...',
     		removeMask:true
        });
        mask.show();
		Ext.Ajax.request({
			url:this.sourceURL,
			success:function(response){
				var res=Ext.util.JSON.decode(response.responseText);
				if(document.all.oframe===null){
					Ext.Msg.alert("提示","打印控件尚未加载或者加载失败，请重新安装打印控件！");
				}else{
					if(res.url!==null){
					    setTimeout(function() {
					    	document.all.oframe.Open(res.url,true,"Word.Document");
//					    	document.all.oframe.EnableFileCommand(1)=false;
//					    	document.all.oframe.EnableFileCommand(2)=false;
//					    	document.all.oframe.EnableFileCommand(3)=false;
					    },1000);
					    mask.hide();
					}else{
						Ext.Msg.alert("提示","数据请求失败");
					}
				}
			},
            faliure:function(){
                Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
            },
            params:this.params
		});
	}
});