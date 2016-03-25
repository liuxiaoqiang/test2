Ext.ns("Ynzc");
Ext.ns("Ynzc.manage"); 
Ynzc.manage.DriverStrExamWrite = Ext.extend(Ext.Window, {
	id:'driverStrExamWrite',
	initComponent:function(){
		Ext.apply(this,{
			id:'driverStrExamWrite',
			title:"考试成绩批量录入",
			height:600,
			width:1200,
			autoScroll:'true',
			layout:"form",
			bodyStyle:"padding:5px 5px",
			items:[{
				id:"examFields",
				xtype:"fieldset",
				height:'auto',
				title:"考试信息录入",
				layout:"column",
				items:[{
					columnWidth:1,
					height:'auto',
					labelWidth:50,
					baseCls:"x-plain",
					layout:"column",
					items:[{
						columnWidth:.1,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							xtype: 'label',
							html: '<div align=center style="padding-top:6px;"><font color=blue>科目一</font></div>'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'theoryExaminerOne',
							fieldLabel: '主考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'theoryExaminerTwo',
							fieldLabel: '监考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"theoryDate",
							fieldLabel:"时间",
							xtype:"datefield",
							format:"Y-m-d",
							anchor:'98%'
						}]
					}]
				},{
					columnWidth:1,
					labelWidth:50,
					height:'auto',
					baseCls:"x-plain",
					autoScroll:'true',
					layout:"column",
					items:[{		  
						columnWidth:.1,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							xtype: 'label',
							html: '<div align=center style="padding-top:6px;"><font color=blue>科目二</font></div>'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'fieldExaminerOne',
							fieldLabel: '主考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'fieldExaminerTwo',
							fieldLabel: '监考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"fieldDate",
							fieldLabel:"时间",
							xtype:"datefield",
							format:"Y-m-d",
							anchor:'98%'	
						}]
					}]
				},{
					columnWidth:1,
					labelWidth:50,
					height:'auto',
					baseCls:"x-plain",
					autoScroll:'true',
					layout:"column",
					items:[{
						columnWidth:.1,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							xtype: 'label',
							html: '<div align=center style="padding-top:6px;"><font color=blue>科目三</font></div>'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'machineExaminerOne',
							fieldLabel: '主考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'machineExaminerTwo',
							fieldLabel: '监考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"machineDate",
							fieldLabel:"时间",
							xtype:"datefield",
							format:"Y-m-d",
							anchor:'98%'
						}]
					}]
				},{
					columnWidth:1,
					labelWidth:50,
					baseCls:"x-plain",
					height:'auto',
					autoScroll:'true',
					layout:"column",
					items:[{
						columnWidth:.1,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							xtype: 'label',
							html: '<div align=center style="padding-top:6px;"><font color=blue>科目四</font></div>'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'roadExaminerOne',
							fieldLabel: '主考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'roadExaminerTwo',
							fieldLabel: '监考人',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.3,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"roadDate",
							fieldLabel:"时间",
							xtype:"datefield",
							format:"Y-m-d",
							anchor:'98%'
						}]
					}]
				}]
			},{
				id:"drillMaster",
				xtype:"fieldset",
				height:'auto',
				title:"术课培训教练信息",
				layout:"column",
				items:[{
					columnWidth:1,
					labelWidth:50,
					baseCls:"x-plain",
					height:'auto',
					autoScroll:'true',
					layout:"column",
					items:[{
						columnWidth:.1,
						height:'auto',
						labelWidth:30,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							xtype: 'label',
							html: '<div align=center style="padding-top:6px;"><font color=blue>术考培训信息</font></div>'
						}]
					},{
						columnWidth:.17,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'drillMasterId',
							fieldLabel: '教练',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.18,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:'drillMasterCode',
							fieldLabel: '教练编号',
							xtype: 'textfield',
							anchor: '98%'
						}]
					},{
						columnWidth:.18,
						height:'auto',
						labelWidth:50,
						baseCls:"x-plain",
						layout:"form",
						items:[{
							id:"drillMasterDate",
							fieldLabel:"培训天数",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.17,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterMachine",
							fieldLabel:"教练机",
							xtype:"textfield",
							anchor:'98%'
						}]
					},{
						columnWidth:.2,
						layout:"form",
						labelWidth:60,
						height:'auto',				        	
						baseCls: "x-plain",
						items:[{
							id:"drillMasterAuditingIdeaFlag",
							fieldLabel:"审核意见",
							xtype:"combo",
							displayField : 'display',
							valueField : 'value',
							typeAhead : true,
							mode : 'local',
							editable:false,
							selectOnFoucs : true,
							triggerAction : 'all',
							store:Ynzc.manage.PassStore,
							emptyText:"请选择审核意见",
							anchor:'98%'
						}]
					}]
				}]
			},{
				id:"studentFields",
				xtype:"fieldset",
				height:'auto',
				title:"学员成绩录入",
				layout:"column",
				items:[{
					columnWidth:1,
					labelWidth:60,
					height:'auto',
					baseCls:"x-plain",
					layout:"column",
					items:[{
						columnWidth:.33,
						layout:'form',
						defaultType:'textfield',
						baseCls:"x-plain",
						height:'auto',
						items: [{
							fieldLabel: '输入考生编号',
							id:'serch',
							name: 'serch'
						}]
					},{
						columnWidth:.33,
						layout:'form',
						baseCls:"x-plain",
						height:'auto',
						items:[{
							xtype:"button",
							text:'搜索',
							handler:function(){
								var newTextId = "";
								newTextId = Ext.getDom('serch').value;
								Ext.getCmp(newTextId).focus();
								var text =Ext.getCmp(newTextId).getEl().dom.innerHTML;
								if(text.indexOf("red")>0 || text.indexOf("black")>0){
									Ext.getCmp(newTextId).getEl().dom.innerHTML=text.replace("black","red");
								}else{
									Ext.getCmp(newTextId).getEl().dom.innerHTML="<font color=red>"+text+"</font>";
								}
								if(Ynzc.manage.oldTextId === undefined){
									Ynzc.manage.oldTextId = newTextId;
								}else if(Ynzc.manage.oldTextId !== newTextId){
									Ext.getCmp(Ynzc.manage.oldTextId).focus();
									var text =Ext.getCmp(Ynzc.manage.oldTextId).getEl().dom.innerHTML;
									Ext.getCmp(Ynzc.manage.oldTextId).getEl().dom.innerHTML=text.replace("red","black");
									Ynzc.manage.oldTextId = newTextId;
								}
							}	
						}]  
					}]
				},{
					columnWidth:1,
					labelWidth:60,
					height:'auto',
					baseCls:"x-plain",
                    layout:"column",
                    items:[{
                    	columnWidth:.05,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"类型"
                    	}]		
                    },{
                    	columnWidth:.09,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"报考号"
                    	}]		
                    },{                
                    	columnWidth:.05,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"姓名"
                    	}]			          
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                		align: 'center',
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>理论正考</div>"
                    	}]
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>场地一考</div>"
                    	}] 
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>场地二考</div>"
                    	}] 
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>作业一考</div>"
                    	}] 
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>作业二考</div>"
                    	}] 
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>公路一考</div>"
                    	}]
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
						height:'auto',
						baseCls:"x-plain",
						layout:"form",
						items:[{
							xtype:"label",
							html:"<div align=center>公路二考</div>"
						}]
                    },{
                    	columnWidth:.1,
                    	labelWidth:50,
                    	height:'auto',
                    	baseCls:"x-plain",
                    	layout:"form",
                    	items:[{
                    		xtype:"label",
                    		html:"<div align=center>考试结论</div>"
                    	}]
                    }]
				}]
			}],
			buttons:[{
				text:"提交",
				handler:function(){
					var theorys = "";
					var fields = "";
					var machines = "";
					var roads = "";
					var fieldsMakeup = "";
					var machinesMakeup = "";
					var roadsMakeup = "";
					var results = "";
					var id = Ynzc.manage.ids;
					var ids = id.split("#");
					for(var i = 0; i < ids.length; i++){
						if(theorys == ""){
							theorys += ids[i].split("@")[0]+"@"+Ext.getCmp("theory@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue(); 
						}else{
							theorys += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("theory@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue(); 
						}
						if(fields == ""){
							fields += ids[i].split("@")[0]+"@"+Ext.getCmp("field@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}else{
							fields += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("field@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}
						if(machines == ""){
							machines += ids[i].split("@")[0]+"@"+Ext.getCmp("machine@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}else{
							machines += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("machine@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}
						if(roads == ""){
							roads += ids[i].split("@")[0]+"@"+Ext.getCmp("road@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}else{
							roads += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("road@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}
						if(fieldsMakeup == ""){
							if(Ext.getCmp("fieldMakeup@"+ids[i].split("@")[0]).getValue() === ""){
								Ext.getCmp("fieldMakeup@"+ids[i].split("@")[0]).setValue("无");
							}
							fieldsMakeup += ids[i].split("@")[0]+"@"+Ext.getCmp("fieldMakeup@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}else{
							if(Ext.getCmp("fieldMakeup@"+ids[i].split("@")[0]).getValue() === ""){
								Ext.getCmp("fieldMakeup@"+ids[i].split("@")[0]).setValue("无");
							}
							fieldsMakeup += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("fieldMakeup@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}
						if(machinesMakeup == ""){
							if(Ext.getCmp("machineMakeup@"+ids[i].split("@")[0]).getValue() === ""){
								Ext.getCmp("machineMakeup@"+ids[i].split("@")[0]).setValue("无");
							}
							machinesMakeup += ids[i].split("@")[0]+"@"+Ext.getCmp("machineMakeup@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}else{
							if(Ext.getCmp("machineMakeup@"+ids[i].split("@")[0]).getValue() === ""){
								Ext.getCmp("machineMakeup@"+ids[i].split("@")[0]).setValue("无");
							}
							machinesMakeup += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("machineMakeup@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}
						if(roadsMakeup == ""){
							if(Ext.getCmp("roadMakeup@"+ids[i].split("@")[0]).getValue() === ""){
								Ext.getCmp("roadMakeup@"+ids[i].split("@")[0]).setValue("无");
							}
							roadsMakeup += ids[i].split("@")[0]+"@"+Ext.getCmp("roadMakeup@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}else{
							if(Ext.getCmp("roadMakeup@"+ids[i].split("@")[0]).getValue() === ""){
								Ext.getCmp("roadMakeup@"+ids[i].split("@")[0]).setValue("无");
							}
							roadsMakeup += "#"+ids[i].split("@")[0]+"@"+Ext.getCmp("roadMakeup@"+ids[i].split("@")[0]).getValue()+"@"+Ext.getCmp("result@"+ids[i].split("@")[0]).getValue();
						}
					}
					for(var i = 0; i < ids.length; i++){
						if(checkNum(Ext.getCmp("theory@"+ids[i].split("@")[0]).getValue())){
							Ext.MessageBox.alert("提示","[<font color=blue>"+ids[i].split("@")[1]+"</font>]理论考试成绩还未填写!");
							initFocus("theory@"+ids[i].split("@")[0]);
							return;
						}
						if(Ext.getCmp("field@"+ids[i].split("@")[0]).getValue() === ""){
							Ext.MessageBox.alert("提示","[<font color=blue>"+ids[i].split("@")[1]+"</font>]场地考试成绩还未填写!");
							initFocus("field@"+ids[i].split("@")[0]);
							return;
						}
						if(Ext.getCmp("machine@"+ids[i].split("@")[0]).getValue() === ""){
							Ext.MessageBox.alert("提示","[<font color=blue>"+ids[i].split("@")[1]+"</font>]技术考试成绩还未填写!");
							initFocus("machine@"+ids[i].split("@")[0]);
							return;
						}
						if(checkNum(Ext.getCmp("road@"+ids[i].split("@")[0]).getValue())){
							Ext.MessageBox.alert("提示","[<font color=blue>"+ids[i].split("@")[1]+"</font>]公路考试成绩还未填写!");
							initFocus("road@"+ids[i].split("@")[0]);
							return;
						}
					}
					if(checkLen(Ext.getCmp("theoryExaminerOne").getValue())){
						Ext.MessageBox.alert("提示","科目一主考人填写有误!");
						initFocus('theoryExaminerOne');
						return;
					}
					if(checkLen(Ext.getCmp("theoryExaminerTwo").getValue())){
						Ext.MessageBox.alert("提示","科目一考监考人填写有误!");
						initFocus('theoryExaminerTwo');
						return;
					}
					if(checkLen(Ext.getCmp("fieldExaminerOne").getValue())){
						Ext.MessageBox.alert("提示","科目二主考人填写有误!");
						initFocus('fieldExaminerOne');
						return;
					}
					if(checkLen(Ext.getCmp("fieldExaminerTwo").getValue())){
						Ext.MessageBox.alert("提示","科目二考监考人填写有误!");
						initFocus('fieldExaminerTwo');
						return;
					}
					if(checkLen(Ext.getCmp("machineExaminerOne").getValue())){
						Ext.MessageBox.alert("提示","科目三主考人填写有误!");
						initFocus('machineExaminerOne');
						return;
					}
					if(checkLen(Ext.getCmp("machineExaminerTwo").getValue())){
						Ext.MessageBox.alert("提示","科目三考监考人填写有误!");
						initFocus('machineExaminerTwo');
						return;
					}
					if(checkLen(Ext.getCmp("roadExaminerOne").getValue())){
						Ext.MessageBox.alert("提示","科目四主考人填写有误!");
						initFocus('roadExaminerOne');
						return;
					}
					if(checkLen(Ext.getCmp("roadExaminerTwo").getValue())){
						Ext.MessageBox.alert("提示","科目四考监考人填写有误!");
						initFocus('roadExaminerTwo');
						return;
					}
					if(Ext.getCmp("theoryDate").getValue() == ""){
						Ext.MessageBox.alert("提示","科目一考试时间填写有误");
						initFocus("fieldDate");
						return;
					}
					if(Ext.getCmp("fieldDate").getValue() == ""){
						Ext.MessageBox.alert("提示","科目二考试时间填写有误");
						initFocus("fieldDate");
						return;
					}
					if(Ext.getCmp("machineDate").getValue() == ""){
						Ext.MessageBox.alert("提示","科目三考试时间填写有误");
						initFocus("machineDate");
						return;
					}
					if(Ext.getCmp("roadDate").getValue() == ""){
						Ext.MessageBox.alert("提示","科目四考试时间填写有误");
						initFocus("roadDate");
						return;
					}
					if(checkLen(Ext.getCmp("drillMasterId").getValue())){
						Ext.MessageBox.alert("提示","教练填写有误!");
						initFocus('drillMasterId');
						return;
					}
					if(checkLen(Ext.getCmp("drillMasterCode").getValue())){
						Ext.MessageBox.alert("提示","教练编号填写有误!");
						initFocus('drillMasterCode');
						return;
					}
					if(Ext.getCmp("drillMasterDate").getValue()==""){
						Ext.MessageBox.alert("提示","请填写培训时间!");
						return;
					}
					if(checkLen(Ext.getCmp("drillMasterMachine").getValue())){
						Ext.MessageBox.alert("提示","教练编号填写有误!");
						initFocus('drillMasterMachine');
						return;
					}
					if(Ext.getCmp("drillMasterAuditingIdeaFlag").getValue()===""){
						Ext.MessageBox.alert("提示","请选择审核意见!");
						return;
					}
					if(daysBetween(Ext.util.Format.date(Ext.getCmp("theoryDate").getValue(),'Y-m-d'),Ext.util.Format.date(Ext.getCmp("fieldDate").getValue(),'Y-m-d'))<10){
						Ext.MessageBox.alert("提示","场地考试时间填写有误");
						initFocus("fieldDate");
						return;
					}
					if(daysBetween(Ext.util.Format.date(Ext.getCmp("theoryDate").getValue(),'Y-m-d'),Ext.util.Format.date(Ext.getCmp("machineDate").getValue(),'Y-m-d'))<10){
						Ext.MessageBox.alert("提示","技术考试时间填写有误");
						initFocus("machineDate");
						return;
					}
					if(daysBetween(Ext.util.Format.date(Ext.getCmp("theoryDate").getValue(),'Y-m-d'),Ext.util.Format.date(Ext.getCmp("roadDate").getValue(),'Y-m-d'))<10){
						Ext.MessageBox.alert("提示","公路考试时间填写有误");
						initFocus("roadDate");
						return;
					}
	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在录入数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
					Ext.Ajax.request({
						url:"main/driverStrInfo.html?action=writeResult",
						success:function(resp){
							mask.hide();
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								Ext.MessageBox.alert("提示",result.reason);
								Ext.getCmp("examInfoMgr").getStore().reload();
								Ext.getCmp("driverStrExamWrite").close();
							}else{
								Ext.MessageBox.alert("提示",result.reason);
							}
						},
						failure:function(){
							Ext.MessageBox.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							classInfoId:Ynzc.manage.ClassInfoId,
							theoryExaminerOne:Ext.getCmp("theoryExaminerOne").getValue(),
							theoryExaminerTwo:Ext.getCmp("theoryExaminerTwo").getValue(),
							theoryDate:Ext.util.Format.date(Ext.getCmp("theoryDate").getValue(),'Y-m-d'),
							fieldExaminerOne:Ext.getCmp("fieldExaminerOne").getValue(),
							fieldExaminerTwo:Ext.getCmp("fieldExaminerTwo").getValue(),
							fieldDate:Ext.util.Format.date(Ext.getCmp("fieldDate").getValue(),'Y-m-d'),
							machineExaminerOne:Ext.getCmp("machineExaminerOne").getValue(),
							machineExaminerTwo:Ext.getCmp("machineExaminerTwo").getValue(),
							machineDate:Ext.util.Format.date(Ext.getCmp("machineDate").getValue(),'Y-m-d'),
							roadExaminerOne:Ext.getCmp("roadExaminerOne").getValue(),
							roadExaminerTwo:Ext.getCmp("roadExaminerTwo").getValue(),
							roadDate:Ext.util.Format.date(Ext.getCmp("roadDate").getValue(),'Y-m-d'),
							drillMasterId:Ext.getCmp("drillMasterId").getValue(),
							drillMasterCode:Ext.getCmp("drillMasterCode").getValue(),
							drillMasterDate:Ext.getCmp("drillMasterDate").getValue(),
							drillMasterMachine:Ext.getCmp("drillMasterMachine").getValue(),
							drillMasterAuditingIdeaFlag:Ext.getCmp("drillMasterAuditingIdeaFlag").getValue(),
							theorys:theorys,
							fields:fields,
							machines:machines,
							roads:roads,
							fieldsMakeup:fieldsMakeup,
							machinesMakeup:machinesMakeup,
							roadsMakeup:roadsMakeup
						}
					});
				}.createDelegate(this)
			},{
				id:"cancelBtn",
				text:"取消",
				handler:function(){
					this.close();
				}.createDelegate(this)
			}]
		});
		Ynzc.manage.DriverStrExamWrite.superclass.initComponent.apply(this,arguments);
		Ext.Ajax.request({
			url:'main/driverStrInfo.html?action=getAllDriverStrInfo',
			success:function(resp){
				var result=Ext.util.JSON.decode(resp.responseText);
				Ynzc.manage.ids = result.id;
				for(i=0;i<result.fieldSet.length;i++){
					Ext.getCmp("studentFields").add(result.fieldSet[i]);
				}
				Ext.getCmp("studentFields").doLayout();
			},
            faliure:function(){
                Ext.MessageBox.alert("警告","<font color=red>与服务器通信失败!</font>");
            },
            params:{
            	driverClassId:Ynzc.manage.ClassInfoId
            }
		})
	}
});