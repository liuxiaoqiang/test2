Ext.BLANK_IMAGE_URL = './Public/ExtJS/resources/images/default/s.gif';
Ext.SSL_SECURE_URL = './Public/ExtJS/resources/images/default/s.gif';
Ext.override(Ext.menu.DateMenu, {
    render: function() {
        Ext.menu.DateMenu.superclass.render.call(this);
        if (Ext.isGecko || Ext.isSafari) {
            this.picker.el.dom.childNodes[0].style.width = '178px';
            this.picker.el.dom.style.width = '178px'
        }
    }
}); 
Ext.onReady(function() {
    Ext.QuickTips.init();
    Ext.lib.Ajax.defaultPostHeader += '; charset=utf-8';
    var MenuTree = new Ext.Panel({
        id: 'MenuTree',
        region: 'west',
        minSize: 100,
        maxSize: 300,
        collapsible: true,
        collapseMode: 'mini',
        animate:true,
        split: true,
        width: 200,
        border: false,
        lines: false,
        margins: '2 2 2 2',
        layout: 'accordion',
        layoutConfig: {
            animate: true 
        }
    });
    Ext.Ajax.request({
        url: 'main/menu.html?action=getModule',
        method: 'post',
        success: function(resp, opt) {
            var module = Ext.util.JSON.decode(resp.responseText);
            var sysTree = module.tree;
            var sysScript = module.script;
            for (j = 0; j < sysScript.length; j++) {
                var oHead = document.getElementsByTagName('HEAD').item(0);
                var oScript = document.createElement("script");
                oScript.type = "text/javascript";
                oScript.src = sysScript[j].src;
                oHead.appendChild(oScript)
            }
            for (i = 0; i < sysTree.length; i++) {
                MenuTree.add(sysTree[i])
            }
            MenuTree.doLayout()
        },
        failure: function() {
            Ext.Msg.alert("警告", "<font color=red>与服务器通讯失败!</font>")
        }
    });
    setTimeout(function() {
        Ext.get('loading').fadeOut({
            remove: true
        });
        Ext.get('loading-mask').fadeOut({
            remove: true
        })
    },
    550);
    var onlineTree = new Ext.tree.TreePanel({
        border: false,
        xtype: "treepanel",
        root: new Ext.tree.TreeNode({
            id: 'onlineRoot',
            text: '在线人员列表',
            iconCls: "icon-userMgr",
            expanded: true
        }),
        listeners:{
    		"click":function(node){
    			new Ynzc.manage.MessagesWin({
    				id:node.id,
    				title:node.text
    			}).show();
    		}
    	}
    });
    var onlineWin = new Ext.Window({
        title: "即时通讯",
        closeAction: 'hide',
        minimizable: true,
        height: 500,
        width: 230,
        layout: "fit",
        items: onlineTree,
        listeners: {
            'minimize': function() {
                onlineWin.hide()
            }
        }
    });
    var winWidth=window.innerWidth||document.body.clientWidth;
    onlineWin.setPosition(winWidth - 300, 50);
    var closeStatus = false;
    var status = new Ext.StatusBar({
        id: 'statusbar',
        height: 25,
        defaultText: '当前登陆用户:'+loginUser,
        items: [{
            id: "onlineBtn",
            text: "在线用户",
            iconCls: "icon-userMgr",
            handler: function() {
        	 	onlineWin.show(Ext.getCmp("onlineBtn").getEl());
                Ext.Ajax.request({
                    url: "login.html?action=getOlinePeople",
                    success: function(resp) {
                        var nodelist = Ext.util.JSON.decode(resp.responseText);
                        var root = onlineTree.getRootNode();
                        while (root.hasChildNodes()) {
                            root.removeChild(root.firstChild)
                        }
                        for (i = 0; i < nodelist.length; i++) {
                            root.appendChild(new Ext.tree.TreeNode(nodelist[i]))
                        }
                        onlineTree.getRootNode().expand();
                    }
                })
            }
        },
        '-', 'Copyright©2011 云南颠峰众成软件有限公司', '-', new Date().format('Y-m-d'), '-', '系统支持  颠峰众成新项目部</a>', {
            text: "退出",
            iconCls: "icon-exit",
            handler: function() {
                Ext.Msg.show({
                    title: '退出系统',
                    msg: '退出系统前请注意保存数据,确定要退出系统吗?',
                    buttons: Ext.Msg.YESNO,
                    scope: this,
                    icon: Ext.MessageBox.QUESTION,
                    fn: function(btn) {
                        if (btn == "yes") {
                            Ext.Ajax.request({
                                url: "login.html?action=LogOut",
                                method: "post",
                                success: function() {
                                    var path = window.location.pathname;
                                    path = path.substring(0, path.lastIndexOf('/') + 1);
                                    closeStatus=true;
                                    window.location = path;
                                },
                                failure: function() {
                                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!请直接关闭浏览器或选项卡。</font>")
                                }
                            })
                        }
                    }
                })
            }
        }],
        region: 'south'
    });
    new Ext.Viewport({
        enableTabScroll: true,
        layout: "border",
        renderTo: "main",
        items: [{
            id: 'header',
            title: "云南省曲靖市农机安全监理网络管理信息系统",
            collapsible: true,
            region: "north",
            height: 120,
            frame: true,
            margins: '2 2 2 2',
            html:'<img src="./Public/Images/desktop/qjlogo.png" />'
        },
        MenuTree, {
            id: 'tab',
            xtype: 'tabpanel',
            region: 'center',
            activeTab: 0,
            plugins: new Ext.ux.TabCloseMenu(),
            enableTabScroll: true,
            margins: '2 2 2 2',
            border: false,
            items: [{
                title: '首页桌面',
                iconCls: 'icon-welcome',
                layout: 'column',
                items: [{
                    columnWidth: .50,
                    style: 'padding:10 10 10 10',
                    border: false,
                    draggable: true,
                    title: '最新公告',
                    collapsible: true,
                    layout: 'column',
                    bodyStyle: 'background-color:#FFFFFF',
                    tools: [{
                        id: 'refresh',
                        handler: function() {
                            Ext.getCmp("sendinfonewsindex").getStore().reload()
                        }
                    },
                    {
                        id: 'close',
                        handler: function(e, target, panel) {
                            panel.ownerCt.remove(panel, true)
                        }
                    }],
                    height: 450,
                    frame: true,
                    items: new Ynzc.manage.SendInfoNewsIndex()
                },
                {
                    columnWidth: .50,
                    style: 'padding:10 10 10 10',
                    collapsible: true,
                    border: false,
                    draggable: true,
                    title: '在线交流',
                    layout: 'column',
                    bodyStyle: 'background-color:#FFFFFF',
                    tools: [{
                        id: 'refresh',
                        handler: function() {
                            Ext.getCmp("sendinfoMessageindex").getStore().reload()
                        }
                    },
                    {
                        id: 'close',
                        handler: function(e, target, panel) {
                            panel.ownerCt.remove(panel, true)
                        }
                    }],
                    height: 450,
                    frame: true,
                    items: new Ynzc.manage.SendInfoMessageIndex()
                }],
                bodyStyle: 'background: url(./Public/Images/sys/welcome.jpg) no-repeat;background-position: center center;'
            }]
        },
        status]
    });
    var Task = {
        run: function() {
            Ext.Ajax.request({
                url: "login.html?action=CheckSession",
                success: function(response) {
                    var result = Ext.util.JSON.decode(response.responseText);
                    if (result.sessionFailue === true) {
                        Ext.Msg.alert("警示", "<font color=blue>服务器会话已超时，或者有相同用户登录，请您重新登录</font>",
                        function() {
                        	closeStatus=true;
                            var path = window.location.pathname;
                            path = path.substring(0, path.lastIndexOf('/') + 1);
                            window.location = path;                            
                        });
                        Ext.TaskMgr.stop(Task)
                    }
                    if (result.onlineChange === true) {
                        Ext.Ajax.request({
                            url: "login.html?action=getOlinePeople",
                            success: function(resp) {
                                var nodelist = Ext.util.JSON.decode(resp.responseText);
                                var root = onlineTree.getRootNode();
                                while (root.hasChildNodes()) {
                                    root.removeChild(root.firstChild)
                                }
                                for (i = 0; i < nodelist.length; i++) {
                                    root.appendChild(new Ext.tree.TreeNode(nodelist[i]))
                                }
                                onlineTree.getRootNode().expand()
                            }
                        })
                    }
                },
                failure: function() {
                    Ext.Msg.alert("警告", "<font color=red>与服务器通信失败!请直接关闭浏览器或选项卡。</font>",
                    function() {
                        var path = window.location.pathname;
                        path = path.substring(0, path.lastIndexOf('/') + 1);
                        window.location = path
                    })
                },
                params: {
                    sessionID: SessionID
                }
            })
        },
        interval: 1000
    }
    Ext.TaskMgr.start(Task);
    window.onbeforeunload = function() {
	    	if(closeStatus===false){
	    		var warning = "浏览器收到离开或关闭请求.\n是否关闭云南省农机安全监理系统？\n请确认保存数据并提交。";
	    		return warning
	    	}
    };
    window.onunload = function() {
	        Ext.Ajax.request({
	            url: "login.html?action=LogOut"
	        })
    }
});