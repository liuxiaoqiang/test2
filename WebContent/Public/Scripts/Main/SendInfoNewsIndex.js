Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.SendInfoNewsIndex=Ext.extend(Ext.grid.GridPanel,{
	id:'sendinfonewsindex',
	initComponent:function(){
		 var fm=Ext.form;
		 var reco=null;
		 var reader=new Ext.data.JsonReader({
                       totalProperty:"InfototalCountNews",
                       root:"sendInfoNews",
                       autoLoad:true,
                       fields:[{
                           name : 'id'
                       },{
                           name : 'replyId'
                       },{
                           name : 'sendContent'
                       },{
                           name : 'sendDate'
                       },{
                           name : 'sendUserId'
                       },{
                           name : 'sendUserName'
                       },{
                           name : 'title'
                       },{
                           name : 'type'
                       }]
       });
		var store=new Ext.data.Store({
           scopte:this,
           url:'main/sendInfo.html?action=getSendInfoNewsAll',
           reader:reader,
           sortInfo:{
               field:'sendDate',
               direction:'ASC'
           }
       });
       var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer({hidden:true}),{
                       header:'标题',
                       width:400,
                       dataIndex:"title",
                       renderer:function(value){
    	   					var xinxi=value.length>23?value.substring(0,23)+"...":value;
    	   					return "<img src='Public/Images/icon/news6.gif' width='14px' height='14px'>"+xinxi+"";
                       }
                   },{
                       header:'发布时间',
                       sortable:true,
                       width:100,
                       dataIndex:"sendDate",
                       renderer:function(value){
                       	value=new Date(value.time).format('Y-m-d');
                       	return value;
                       }
                   }]);
         Ext.apply(this,{
         		id:'sendinfonewsindex',
         		plain:true,
              border:false,
              hideHeaders:true,
              cm:cm,
              store:store,
              loadMask:true,
              border : false,
              height:443,
	          bbar:new Ext.PagingToolbar({
                  pageSize:20,
                  store:store
                })
         });
         Ynzc.manage.SendInfoNewsIndex.superclass.initComponent.apply(this,arguments);
         store.load({
                       params:{
                           start:0,
                           limit:20
                     }
         });
         this.on("rowclick",function(grid,index,event){
        	 var record=grid.getStore().getAt(index);
        	 var updateexpirydate=new Date(record.get("sendDate").time).format('Y-m-d');
        	 new Ext.Window({
        		 title:'最新公告---'+record.get("title"),
        		 bodyStyle : 'background-color:#FFFFFF',
        		 height:500,
        		 width:750,
        		 autoScroll:true,
        		 resizable:true,
        		 modal : true,
        		 maximizable:true,
        		 minimizable:true,
        		 autoDestory:true,
        		 html:"<table  border='0' width='88%' height='90%' align='center'><tr><td width='20%' height='15' valign='bottom'><font style='font-size:13px; font-weight:800'>【公告标题】：</font></td><td width='90%' id='tdTitle' valign='bottom'><font style='font-size:13px'>"+record.get('title')+"</font></td></tr><tr><td height='32' colspan='2' valign='top' id='tdContent'><hr />&nbsp;&nbsp; <font style='font-size:13px'> "+record.get('sendContent')+"</font></td></tr><tr><td height='46' colspan='2' align='right'><font style='font-size:13px; font-weight:500'>发布人:</font><font style='font-size:13px'>"+record.get("sendUserName")+"</font> <font style='font-size:13px; font-weight:500'>发布时间:</font><font style='font-size:13px'>"+updateexpirydate+"</font><hr /></td></tr></table>"
        	 }).show();
         });
	}
});