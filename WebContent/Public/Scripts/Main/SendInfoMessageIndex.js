Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.SendInfoMessageIndex=Ext.extend(Ext.grid.GridPanel,{
	id:'sendinfoMessageindex',
	initComponent:function(){
		 var fm=Ext.form;
		 var reader=new Ext.data.JsonReader({
                       totalProperty:"InfototalCountMessage",
                       root:"sendInfoMessage",
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
           url:'main/sendInfo.html?action=getSendInfoMessageAll',
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
    	   					return "<img src='Public/Images/icon/notice4.gif' width='14px' height='14px'>&nbsp;"+xinxi+"";
                       }
                   },{
                       header:'发布时间',
                       width:100,
                       dataIndex:"sendDate",
                       renderer:function(value){
                       	value=new Date(value.time).format('Y-m-d');
                       	return value;
                       }
                   }]);
         Ext.apply(this,{
         	   id:'sendinfoMessageindex',
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
        	 Ynzc.manage.sendInfoId=record.get("id");
        	 Ext.Ajax.request({
        		 url:'main/sendInfo.html?action=getSendInfoMessageIdList',
        		 success:function(response){
        		 	var res=Ext.util.JSON.decode(response.responseText);
        		 	var div='<div style="padding:10px;" ><div><h1>主题：'+record.get('title')+'</h1></div><div id="topic_content"><hr/><p><span><font style="font-size:13px; font-weight:500; display:block; text-indent:2em;">'+record.get('sendContent')+'</font></span></p></div><div align="right"><font style="font-size:13px; font-weight:500">发布人:'+record.get("sendUserName")+'</font><font style="font-size:13px; font-weight:500">&nbsp;&nbsp;发布时间:'+updateexpirydate+'</font></br><hr/></div>';
        		 	if(res.length>0){
        		 		div=div+"<div><h3>回复</h3></div><hr/>";
        		 	}
        		 	for(i=0;i<res.length;i++){
        		 		div=div+'<div><p><span><font style="font-size:13px; font-weight:500; display:block; text-indent:2em;">'+res[i].sendContent+'</font></span></p></div><div align="right"><font style="font-size:13px; font-weight:500">发布人:'+res[i].sendUserName+'</font><font style="font-size:13px; font-weight:500">&nbsp;&nbsp;发布时间:'+new Date(res[i].sendDate.time).format('Y-m-d')+'</font></br><hr/></div>';
        		 	}
        		 	div=div+"</div>";
        		 	new Ext.Window({
               		 id:"replyWin",
               	     title : '在线交流---'+record.get("title"),
               	     width : 900,
               	     height : 500,
               	     modal : true,
               	     resizable :false,
               	     items:[{
                         id:"publishPanel",                         
       	        	     height:300,       	        	 
       	        	     border:false,
       	        	     autoScroll : true,
       	        	     items:[{
       	        	    	 id:"contentPanel",
       	        	         border:false
       	        	     }]
               	     },{
               	     id:"messageContent",
               	     border:false,
               	     xtype:"htmleditor",
               	     width:886,
               	     height:133
               	     }],
               	     buttons:[{
               	    	 text:"回复",
               	    	 handler:function(){
       		 					 if(Ext.getCmp("messageContent").getValue()==""){Ext.ux.Toast.msg("提示","回复内容不能为空哦!");return}
       							 Ext.Ajax.request({
       								 url:'main/sendInfo.html?action=addSendInfo',
       								 success:function(){
       									 	Ext.ux.Toast.msg("提示","回复成功！");
       									 	var oldHTML=Ext.getCmp("contentPanel").getEl().dom.innerHTML;
       									 	var newHTML=oldHTML.substring(0,oldHTML.length-6)+'<div ><p><span><font style="font-size:13px; font-weight:500; display:block; text-indent:2em;">'+Ext.getCmp("messageContent").getValue()+'</font></span></p></div><div align="right"><font style="font-size:13px; font-weight:500">发布人:'+loginUser+'</font><font style="font-size:13px; font-weight:500">&nbsp;&nbsp;发布时间:'+new Date().format('Y-m-d')+'</font><hr/></div></div>';
       									 	Ext.getCmp("contentPanel").getEl().dom.innerHTML=newHTML;
       								 },
       								 params:{
       									 type:'在线留言',
       									 title:record.get('title'),
       									 content:Ext.getCmp("messageContent").getValue(),
       									 replayId:record.get("id")
       								 }
       							 });
       		 				}
       		 			},{
               	    	 text:"取消",
               	    	 handler:function(){
       		 				Ext.getCmp("replyWin").close();
       		 			 } 
               	     }]
               	     }).show(); 
        		 	Ext.getCmp("contentPanel").getEl().dom.innerHTML=div;
        	 	 },
        		 failure:function(){},
        		 params:{
        			 themeId:record.get("id")
        		 }
        	 });
        	 
         });
	}
});