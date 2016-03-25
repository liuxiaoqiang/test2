Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PlateWin=Ext.extend(Ext.Window,{
	id:'platewin',
    initComponent:function(){
	var selectlist=[];
    Ext.apply(this,{
    	id: 'platewin',
        title: " 请选择要处理的号牌",
        iconCls: 'icon-Add',
        resizable: false,
        modal: true,
        height: 530,
        width: 830,
        autoScroll:true,
        layout: "form",
        items: [{}],
        buttons: [{
        	text: "保存处理",
            handler: function() {
        	var saveStr="";
        	for(i=0;i<selectlist.length;i++){
        		if(Ext.getCmp(selectlist[i]).getValue()==true){
        			saveStr+=selectlist[i]+",";
        		};
        	}
        		                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在处理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
        	Ext.Ajax.request({
        		url:'main/plate.html?action=savePlateDoList',
        		method:'post',
        		success:function(){
        		mask.hide();
        			Ext.MessageBox.alert("提示","已成功处理该批次");
        			Ext.getCmp("platewin").close();
        			Ext.getCmp(Ynzc.manage.winid).getStore().reload();
        		},
        		faliure:function(){
        			Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
        		},
        		params:{savestr:saveStr,pid:Ynzc.manage.pid,unitid:Ynzc.manage.unitid}
        	});
        }},
        {
            text: "取消",
            handler: function() {
                Ext.getCmp("platewin").close();
            }
        }]
    });
    Ynzc.manage.PlateWin.superclass.initComponent.apply(this, arguments);
    	                var mask = new Ext.LoadMask(Ext.getBody(), {
			     		msg : '正在处理数据,请稍等...',
			     		removeMask:true
	                });
	                mask.show();
    Ext.Ajax.request({
		url:'main/plate.html?action=getPlateDoList',
		method:'post',
		success:function(resp){
		mask.hide();
			var result=Ext.util.JSON.decode(resp.responseText);
			for(i=0;i<result.length;i++){
				Ext.getCmp("platewin").add(result[i]);
				for(j=0;j<result[i].items.length;j++){
					for(n=0;n<result[i].items[j].items.length;n++){
						selectlist.push(result[i].items[j].items[n].id)
					}
				}
			}
		},
        faliure:function(){
            Ext.Msg.alert("警告","<font color=red>与服务器通信失败!</font>");
        },
        params:{
        	status:Ynzc.manage.status,
        	pid:Ynzc.manage.pid,
        	platecode:Ynzc.manage.platecode
        }
	});
    }
});
Ext.reg('platewin', Ynzc.manage.PlateWin);