Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.SendInfoWelCome=Ext.extend(Ext.Panel,{
	initComponent:function(){
		var tools = [ {
			id :'close',
			handler : function(e, target, panel) {
				panel.ownerCt.remove(panel, true);
			}
		} ];
		var sendInfoNewsIndex=new Ynzc.manage.SendInfoNewsIndex();
		var sendInfoMessageIndex=new Ynzc.manage.SendInfoMessageIndex();
		Ext.apply(this,{
			autoScroll :false, 
			items:[{
				layout:'column',
				style : 'background-color:#FFFFFF',
				items:[{
					columnWidth:.4,
					border : false,
					items:[{
						border : false,
						draggable : true,
						layout : 'fit',
						items:[{
							title:'最新公告',
							id:'news',
				            layout:'column',
				            bodyStyle : 'background-color:#FFFFFF',
							tools :[ {id :'refresh',
								handler:function(){
									Ext.getCmp("sendinfonewsindex").getStore().reload();
								}
		                            }, {
		                                id :'close',
		                                handler : function(e, target, panel) {
		                                    panel.ownerCt.remove(panel, true);
		                                }
		                            },{
		                            	id:'down',
		                            	handler:function(){
		                            		if(Ext.getCmp("news").height!=0){
		                            			Ext.getCmp("news").height=0;
		                            		}else{
		                            			Ext.getCmp("news").height=200;
		                            		}
		                            	}
		                            } ],
							margins : '0',
							height : 220,
							frame : true,
							items : [sendInfoNewsIndex]
						}]
					}]
				},{
					columnWidth:.05,
					border : false
				},{
					columnWidth:.4,
					border : false,
					items:[{
						border : false,
						draggable : true,
						layout : 'fit',
						items:[{
							title:'在线留言',
				            layout:'column',
				            bodyStyle : 'background-color:#FFFFFF',
							tools :[ {
										 id :'refresh',
										 handler : function() {
											 Ext.getCmp("sendinfoMessageindex").getStore().reload();
		                                 }
		                            }, {
		                                id :'close',
		                                handler : function(e, target, panel) {
		                                    panel.ownerCt.remove(panel, true);
		                                }
		                            } ,{
		                            	id:'down'
		                            } ],
							margins : '0',
							height : 220,
							frame : true,
							items : [sendInfoMessageIndex]
						}]
					}]
				},{
					columnWidth:.15,
					border : false
				}]
			}]
		});
		Ynzc.manage.SendInfoWelCome.superclass.initComponent.apply(this,arguments);
	}
});