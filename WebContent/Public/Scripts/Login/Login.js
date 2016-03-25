Ext.onReady(function(){
    var loginWin=new Ext.Window({
        id:'loginwin',
        resizable:false,
        title:'登录',
        height:170,
        width:260,
        modal:true,
        layout:'form',
        labelWidth:50,
        buttonAlign:'center',        
        bodyStyle:"padding:20px 30px",
        items:[{
            id:'username',
            xtype:'textfield',
            fieldLabel:'用户名',
            anchor:'99%'
        },{
            id:'password',
            xtype:'textfield',
            fieldLabel:"密码",
            inputType:'password',
            anchor:'99%'
        }],
        buttons:[{
            text:'登录',
            handler:function(){
                if(Ext.getCmp("username").getValue()==""){
                    Ext.ux.Toast.msg("提示","请输入用户名");
                    return;
                }
                if(Ext.getCmp("password").getValue()==""){
                    Ext.ux.Toast.msg("提示","请输入密码");
                    return;
                }
                var mask = new Ext.LoadMask(Ext.getBody(), {
		     		msg : '正在登录,请稍等...',
		     		removeMask:true
                });
                mask.show();
                Ext.Ajax.request({
                    url:'login.html?action=Login',
                    method:'post',
                    success:function(res){
                		mask.hide();
                        var result=Ext.util.JSON.decode(res.responseText);
                        if(result.success==true){
                        	window.location="login.html?action=Jump";
                        }
                        if(result.success==false){
                            Ext.Msg.alert("提示",result.errors);
                        }
                    },
                    failure:function(){
                        Ext.Msg.alert("<font color=red>登录失败<font>","与服务器通讯失败！");
                    },
                    params:{
                        username:Ext.getCmp("username").getValue(),
                        password:Ext.getCmp("password").getValue()
                    }
                });
            }
        },{
            text:'取消',
            handler:function(){
                window.close();
            }
        }],
        keys:{
            key:[13],
            fn:function(){
                if(Ext.getCmp("username").getValue()==""){
                    Ext.ux.Toast.msg("提示","请输入用户名");
                    return;
                }
                if(Ext.getCmp("password").getValue()==""){
                    Ext.ux.Toast.msg("提示","请输入密码");
                    return;
                }
                var mask = new Ext.LoadMask(Ext.getBody(), {
		     		msg : '正在登录,请稍等...',
		     		removeMask:true
                });
                mask.show();
                Ext.Ajax.request({
                    url:'login.html?action=Login',
                    method:'post',
                    success:function(res){
                		mask.hide();
                        var result=Ext.util.JSON.decode(res.responseText);
						if(result.success==true){
                        	window.location="login.html?action=Jump";
                        }
                        if(result.success==false){
                            Ext.Msg.alert("提示","密码错误");
                        }
                        if(result.success=="error"){
                            Ext.Msg.alert("提示","您所登录的用户不存在");
                        }
                    },
                    failure:function(){
                        Ext.Msg.alert("<font color=red>登录失败<font>","与服务器通讯失败！");
                    },
                    params:{
                        username:Ext.getCmp("username").getValue(),
                        password:Ext.getCmp("password").getValue()
                    }
                });
            }
        },
      listeners: {
        'show': function() {
                    this.findByType('textfield')[0].focus(true, true);
                }
        } 
    }).show("body");
});