Ext.ns("Ynzc"); 
Ext.ns("Ynzc.manage");
Ynzc.manage.PeopleInfoUpdateWin=Ext.extend(Ext.Window,{
	id:"peopleInfoUpdateWin",
	initComponent:function(){
		Ext.apply(this,{
			id:"peopleInfoUpdateWin",
			title:"修改人员基本信息",
			height:378,
			width:500,
			autoScroll:true,
			resizable:true,
			modal:true,
			layout:"column",
			bodyStyle:{padding:'10px 10px'},
			frame:true,
			items:[{
			 	columnWidth:.8,
			  	layout:"form",
		 	   	labelWidth:60,
		 	   	height:185,
		 	  	width:470,
		 	 	baseCls: "x-plain",
			 	items:[{
		 			id:"peopleName",
		  			fieldLabel:"姓名",
		 	 		xtype:"textfield",
			  		anchor:'98%'
		  		},{
		 	  		id:"sex",
			   		fieldLabel:"性别",
		   			xtype:"combo",
		   			displayField : 'display',
		 			valueField : 'value',
			   		typeAhead : true,
					mode : 'local',
		 	 		editable:false,
		 	  		selectOnFoucs : true,
		  	 		triggerAction : 'all',
					store:Ynzc.manage.SexStore,
			  		emptyText:"请选择性别",
			  		anchor:'98%'
		 		},{
		    		id:"sex",
			 		fieldLabel:"性别",
			 		xtype:"combo",
			 		displayField : 'display',
			 		valueField : 'value',
			 		typeAhead : true,
			 		mode : 'local',
			 		editable:false,
			 		selectOnFoucs : true,
		  			triggerAction : 'all',
					store:Ynzc.manage.SexStore,
					emptyText:"请选择性别",
					anchor:'98%'
				},{
					id:"birthday",
		    		fieldLabel:"出生日期",
		   			xtype:"datefield",
			 		readOnly:true,
		     		format:"Y-m-d",
		     		anchor:'98%'
		 	  	},{
		 	  		id:"idCard",
		 	  		fieldLabel:"身份证",
		  			xtype:"textfield",
			 		anchor:'98%'
			 	},{
		   	 		id:"idStay",
		  	 		fieldLabel:"暂住证",
			  		xtype:"textfield",
			  		anchor:'98%'
			  	},{
		 			id:"linkTel",
		 	   		fieldLabel:"联系电话",
			   		xtype:"textfield",
			  		anchor:'98%'
		 	   	},{	        	
		  	 		id:"postalcode",
			   		fieldLabel:"邮政编码",
					xtype:"textfield",
			 		anchor:'98%'
		  	 	}]
			},{
		     	columnWidth:.2,
				layout:"form",
			  	labelWidth:60,
			  	height:185,
			   	baseCls: "x-plain",
		    	items:[{
		  	 		id: "photoDir",
			 		xtype: "picpanel",
			 		defaultPicUrl: "./Public/Images/sys/noupload.gif",
		  	 		actionUrl: "main/tractorInfo.html?action=uploadPic",
		 			uploadWinTitle: "上传拖拉机图片",
		 	 		height: 170,
			  		width:90 
			  	}]
			},{
				columnWidth:1,
				layout:"form",
				labelWidth:60,
				baseCls: "x-plain",
				items:[{	        		
					id:"address",
					fieldLabel:"家庭地址",
					xtype:"textfield",
					anchor:'98%'
		        			
				}]
			},{
				columnWidth:1,
				layout:"form",
				labelWidth:60,
			  	baseCls: "x-plain",
			 	items:[{
		     		id:"linkAddress",
		  	   		fieldLabel:"联系地址",
		  	 		xtype:"textfield",
		  			anchor:'98%'
			 	}]
			},{
				columnWidth:1,
				layout:"form",
				labelWidth:60,
				baseCls: "x-plain",
		     	items:[{
		   			id:"nativePlace",
		      		fieldLabel:"籍贯",
		 			xtype:"textfield",
		 			anchor:'98%'   
		      	}]
			},{
		    	columnWidth:1,
		  		layout:"form",
		  		labelWidth:60,
		  		baseCls: "x-plain",
				items:[{
		   			id:"degree",
		 			fieldLabel:"文化程度",
		 			xtype:"combo",
			 		displayField : 'display',
			  		valueField : 'value',
			   		typeAhead : true,
		  	 		mode : 'local',
			  		editable:false,
			   		selectOnFoucs : true,
		  			triggerAction : 'all',
					store:Ynzc.manage.DegreeStore,
			 		emptyText:"请选择文化程度",
		 	 		anchor:'98%'
				}]
			}]
		},{
			buttons:[{
				id:"savaBtn",
				text:"保存",
				handler:function(){
					if(checkLen(Ext.getCmp("peopleName").getValue())){
						Ext.MessageBox.alert("提示","姓名填写有误!");
						initFocus("peopleName");
						return;
					}
					if(Ext.getCmp("sex").getValue()==""){
						Ext.MessageBox.alert("提示","请填写性别!");
						return;
					}
					if(Ext.getCmp("birthday").getValue()==""){
						Ext.MessageBox.alert("提示","请填写出生日期!");
						return;
					}
					if(Ext.getCmp("idCard").getValue()==""){
						Ext.MessageBox.alert("提示","请填写身份证号!");
						return;
					}else{
						if(checkIdCard(Ext.getCmp("idCard").getValue()) != true){
							Ext.MessageBox.alert("提示",checkIdCard(Ext.getCmp("idCard").getValue()));
							initFocus("idCard");
							return;
						}
					}
					if(Ext.getCmp("idStay").getValue()==""){
						Ext.MessageBox.alert("提示","暂住证号填写有误!");
						initFocus("idStay");
						return;
					}
					if(checkLen(Ext.getCmp("address").getValue())){
						Ext.MessageBox.alert("提示","家庭住址填写有误!");
						initFocus("address");
						return;
					}
					if(checkLen(Ext.getCmp("linkAddress").getValue())){
						Ext.MessageBox.alert("提示","联系地址填写有误!");
						initFocus("linkAddress");
						return;
					}
					if(checkNum(Ext.getCmp("linkTel").getValue())){
						Ext.MessageBox.alert("提示","联系电话填写有误!");
						initFocus("linkTel");
						return;
					}else{
						if(!checkMobile(Ext.getCmp("linkTel").getValue())){
							Ext.MessageBox.alert("提示","联系电话填写有误!");
							initFocus("linkTel");
							return;
						}
					}
					if(checkPost(Ext.getCmp("postalcode").getValue())){
						Ext.MessageBox.alert("提示","邮编填写有误!");
						initFocus("postalcode");
						return;
					}
					if(checkLen(Ext.getCmp("nativePlace").getValue())){
						Ext.MessageBox.alert("提示","籍贯填写有误!");
						initFocus("nativePlace");
						return;
					}
					if(Ext.getCmp("degree").getValue()===""){
						Ext.MessageBox.alert("提示","请填写文化程度!");
						return;
					}
					if(Ext.getCmp("photoDir").getValue()==""){
						Ext.MessageBox.alert("提示","请填上传人员照片!");
						return;
					}
					Ext.Ajax.request({
						url:"main/peopleInfo.html?action=updatePeopleInfo",
						success:function(resp){
							var result=Ext.util.JSON.decode(resp.responseText);
							if(result.success==true){
								Ext.MessageBox.alert("提示",result.reason);
								Ext.getCmp("peopleInfoMgr").getStore().reload();
								Ext.getCmp("peopleInfoUpdateWin").close();
							}else{
								Ext.MessageBox.alert("提示",result.reason);
							}
						},
						failure:function(){
							Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
						},
						params:{
							id:Ynzc.manage.peopleInfoId,
							peopleName:Ext.getCmp("peopleName").getValue(),
							sex:Ext.getCmp("sex").getValue(),
							birthday:Ext.util.Format.date(Ext.getCmp("birthday").getValue(),'Y-m-d'),
							idCard:Ext.getCmp("idCard").getValue(),
							idStay:Ext.getCmp("idStay").getValue(),
							address:Ext.getCmp("address").getValue(),
							linkAddress:Ext.getCmp("linkAddress").getValue(),
							linkTel:Ext.getCmp("linkTel").getValue(),
							postalcode:Ext.getCmp("postalcode").getValue(),
							nativePlace:Ext.getCmp("nativePlace").getValue(),
							degree:Ext.getCmp("degree").getValue(),
							photoDir:Ext.getCmp("photoDir").getValue()
						}
					});
					}
				},{
					id:"cancelBtn",
					text:"取消",
					handler:function(){
					Ext.getCmp("peopleInfoUpdateWin").close();
				}
			}]
		});
		Ynzc.manage.PeopleInfoUpdateWin.superclass.initComponent.apply(this,arguments);
	}
});

