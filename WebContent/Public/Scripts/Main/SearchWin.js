Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.SearchWin=Ext.extend(Ext.Window,{
	searchGrid:null,
	initComponent:function(){
			var searchForm=new Ext.form.FormPanel({
					frame:true,
					url:this.searchURL,
					border:false,
					labelWidth:80,
					bodyStyle:"padding:5px 5px",
					items:[{
						name:"platenum",
						fieldLabel:"号牌号码",
						xtype:"textfield",
						anchor:"98%"
	 				},{
						name:"owner",
						fieldLabel:"所有人姓名",
						xtype:"textfield",
						anchor:"98%"
					},{
						name:"cardnum",
						fieldLabel:"证件号码",
						xtype:"textfield",
						anchor:"98%"
					},{
						name:"nowaddress",
						fieldLabel:"现居住地",
						xtype:"textfield",
						anchor:"98%"
					}
			        ]
			})
			Ext.apply(this,{
			  	height:"auto",
			  	width:300,
				layout:"form",
				items:searchForm,
				modal:true,
				resizable:false,
				buttonAlign:"center",
				buttons:[{
					text:"查询",
					handler:function(){						
						this.searchGrid.getStore().reload({
							params:{
								platenum:searchForm.getForm().findField("platenum").getValue(),
								owner:searchForm.getForm().findField("owner").getValue(),
								cardnum:searchForm.getForm().findField("cardnum").getValue(),
								nowaddress:searchForm.getForm().findField("nowaddress").getValue(),
								start:0,
								limit:20
							}
						})
						this.close();
					}.createDelegate(this)
				}]
			});
			Ynzc.manage.SearchWin.superclass.initComponent.apply(this,arguments);
			this.show(Ext.getBody());
	}
});