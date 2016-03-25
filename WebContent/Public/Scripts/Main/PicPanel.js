Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
Ynzc.manage.PicPanel = Ext.extend(Ext.Panel, {
	defaultPicUrl:null,
	uploadWinTitle:null,
	actionUrl:null,
	serviceValue:null,
	uploadFileWin:null,
	height:null,
	width:null,
	picbox:null,
	initComponent:function(){
	
		this.picbox=new Ext.BoxComponent({
            height:this.height,
            width:this.width,
            autoEl:{
            	  tag:'img', 
            	  src:this.defaultPicUrl
            }
		});
		
		var inputfile=new Ext.form.TextField({
				fieldLabel:"请选择图片",
				xtype:"textfield",
				inputType:"file",
  				height:20,
  				anchor:'98%'
		});
		
		var fileForm=new Ext.form.FormPanel({
				url:this.actionUrl,
   				frame:true,
   				labelWidth:70,
   				fileUpload:true,
   				items:inputfile
		});
		
		this.uploadFileWin=new Ext.Window({
			title:this.uploadWinTitle,
			closeAction:'hide',
			height:110,
   			resizable:false,
   			modal:true,
   			layout:"fit",
   			width:400,
   			items:fileForm,
   			buttons:[{
   				text:"上传",
   				handler:function(){
   					var furl=inputfile.getValue();
   					var type = furl.substring(furl.length - 3).toLowerCase();
                    if (furl === "" || furl === null) { return; }
                    if (type !='gif' && type != 'jpg' && type != 'jpeg' && type != 'bmp') {
                        Ext.Msg.alert('提示','仅支持上传gif、jpg、jpeg、bmp格式的文件!');
                        return;
                    }
                    fileForm.getForm().submit({
                    	waitMsg:'正在上传....',
                    	waitTitle:'请等待',
                    	method:"post",
                    	success:function(from,action){
                    		this.uploadFileWin.hide();
                    		this.serviceValue=Ext.util.JSON.decode(action.response.responseText).url;
                    		this.picbox.getEl().dom.src=Ext.util.JSON.decode(action.response.responseText).url;
                    	}.createDelegate(this),
                    	failure:function(){
                    		Ext.Msg.alert("警告","<font color=red>与服务器通讯失败!</font>");
                    	}
                    })
   				}.createDelegate(this)
   			}]
		});
		Ext.apply(this,{
			layout:"form",
            height:this.height,
            width:this.width,
			items:this.picbox,
			buttons:[{
				text:"上传",
				handler:function(){				
					this.uploadFileWin.show();
				}.createDelegate(this)
			}]
		});
		Ynzc.manage.PicPanel.superclass.initComponent.apply(this,arguments);
	},
	getValue:function(){
		return this.serviceValue;
	},
	setValue:function(v){
		try{
		this.picbox.getEl().dom.src = v;
		}catch(e){
			this.picbox.autoEl.src=v;
		}
		this.serviceValue=v;
	}
});
Ext.reg("picpanel",Ynzc.manage.PicPanel);
