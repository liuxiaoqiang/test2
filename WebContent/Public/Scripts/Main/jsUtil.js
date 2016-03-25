Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
/** 
 * 验证是否手机号码
 * @author zhouyu
 * @date 2011-04-28
 **/
function checkMobile(src){
   if(/^13\d{9}$/g.test(src)||(/^15[0,1,2,8,9]\d{8}$/g.test(src))||(/^18[2,6,7,8,9]\d{8}$/g.test(src))){
         return true;
    }else{
        return false;
   }
}

/**
 * 验证邮政编码
 * @author zhouyu
 * @date 2011-04-28
 **/
function checkPost(str){
    if (str != "") {   //邮政编码判断
        var pattern = /^[0-9]{6}$/;
        var flag = pattern.test(str);
        if (!flag) {
            return true;
        }else{
        	return false;
        }
    }else{
    	return true;
    }
    return false;
}

/**
 * 验证是否是身份证
 * @author zhouyu
 * @date 2011-04-28
 **/
function checkIdCard(idcard){ 
	var Errors=new Array("验证通过!","身份证号码位数不对!","身份证号码出生日期超出范围或含有非法字符!","身份证号码校验错误!","身份证地区非法!"); 
	var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"xinjiang",71:"台湾",81:"香港",82:"澳门",91:"国外"} 
	var idcard,Y,JYM; 
	var S,M; 
	var idcard_array = new Array(); 
	idcard_array = idcard.split(""); 
	if(area[parseInt(idcard.substr(0,2))]==null){
		return Errors[4];
	}
	switch(idcard.length){ 
		case 15: 
			if ((parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){ 
				ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性 
			}else{ 
				ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性 
			} 
			if(ereg.test(idcard)){ 
				return true; 
			}else{
				return Errors[2];
			}
			break; 
		case 18: 
			if( parseInt(idcard.substr(6,4)) % 4 == 0 || ( parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){ 
				ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式 
			}else{ 
				ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式 
			}
			if(ereg.test(idcard)){ 
				S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 + parseInt(idcard_array[7]) * 1 + parseInt(idcard_array[8]) * 6 + parseInt(idcard_array[9]) * 3 ; 
				Y = S % 11; 
				M = "F"; 
				JYM = "10X98765432"; 
				M = JYM.substr(Y,1); 
				if(M == idcard_array[17]){
					return true;
				}else{ 
					return Errors[3];
				}
			}else{ 
				return Errors[2];
			}
			break;
		default:
			return Errors[1];
			break;
	}
}

/**
 * 字符串搜索
 * @author zhouyu
 * @date 2011-05-04
 **/
function checkDrivingLicenceType(str1,str2){
	var typeName = new Array('G','H','GK','HK','K','R','S','T','RS','RT','RK','KS','RG','ST','GS','GKR','KGS');
	var oldStr = str1.split("/");
	for(var i = 0; i < oldStr.length; i++){
		if(oldStr[i] === typeName[str2-1]){
			return true;
		}
	}
}

/**
 * 字符串搜索
 * @author zhouyu
 * @date 2011-05-04
 **/
function findDrivingLicenceType(str){
	var typeName = new Array('G','H','GK','HK','K','R','S','T','RS','RT','RK','KS','RG','ST','GS','GKR','KGS');
	return typeName[str-1];
}

/**
 * 字符串判断数字
 * @author zhouyu
 * @date 2011-05-04
 **/
function checkNum(oNum){
	if(!oNum) return true;
	var strP=/^\d+(\.\d+)?$/;
	if(!strP.test(oNum)) return true;
	try{
		if(parseFloat(oNum)!=oNum) return true;
	}catch(ex){
		return true;
	}
	return false;
}

/**
 * 字符串长度判断带中文
 * @author zhouyu
 * @date 2011-05-04
 **/
function checkLen(str){
	var reg =/[^\x00-\xff]/g;
	if(str != undefined && str != ""){
		if(str.replace(reg,"**").length >255){//遇到中文就用**替换
			return true;
		}else{
			return false;
		}
	}else{
		return true;
	}
}

/**
 * 获取焦点事件
 * @author zhouyu
 * @date 2011-05-04
 **/
function initFocus(str){//str为文本框Id
	Ext.getCmp(str).focus.defer(100, Ext.getCmp(str));
}

/**
 * 去空格
 * @author zhouyu
 * @date 2011-05-04
 **/
function trim(str){
	if(str==null) return "";
	if(str.length==0) return "";
	var i=0,j=str.length-1,c;
	for(;i<str.length;i++){
		c=str.charAt(i);
		if(c!=' ') break;
	}
	for(;j>-1;j--){
		c=str.charAt(j);
		if(c!=' ') break;
	}
	if(i>j) return "";
	return str.substring(i,j+1); 
}

function getOldDrivingLicenceType(str){
	var typeName = new Array('G','H','GK','HK','K','R','S','T','RS','RT','RK','KS','RG','ST','GS','GKR','KGS');
	var typeNames = ""
	for(var i=0; i<str.length;i++){
    	if(typeNames == ""){
    		typeNames += typeName[str[i]-1];
    	}else{
    		typeNames = typeNames + "/" + typeName[str[i]-1];
    	}
	}
	return typeNames;
}

function closeWin(str){
	if(str == 1){
		Ext.getCmp("driverLicenceChangeMgr").getStore().reload();
	}else if(str == 2){
		Ext.getCmp("drivingLicenceTermMgr").getStore().reload();
	}else if(str == 3){
		Ext.getCmp("drivingLicenceDefileMgr").getStore().reload();
	}else if(str == 4){
		Ext.getCmp("drivingLicenceRepairMgr").getStore().reload();
	}else if(str == 5){
		Ext.getCmp("drivingLicenceGotoMgr").getStore().reload();
	}else if(str == 6){
		Ext.getCmp("drivingLicenceShiftToMgr").getStore().reload();
	}else if(str == 7){
		Ext.getCmp("drivingLicenceLogoutMgr").getStore().reload();
	}
}

function daysBetween(DateOne,DateTwo){
	var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));
	var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);
 	var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));
	var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));
	var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);
	var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));
	var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);
	return Math.abs(cha);
}

function DateDemo(){
	var d, s="";
	d = new Date();
	s += d.getYear();
	s += (d.getMonth() + 1);
	s += d.getDate();
	return(s);
}

DateFormat = (function(){
	var SIGN_REGEXP = /([yMdhsm])(\1*)/g;
	var DEFAULT_PATTERN = 'yyyy-MM-dd';
	function padding(s,len){
		var len =len - (s+'').length;
		for(var i=0;i<len;i++){s = '0'+ s;}
		return s;
		};
		return({
		format: function(date,pattern){
			pattern = pattern||DEFAULT_PATTERN;
			return pattern.replace(SIGN_REGEXP,function($0){
				switch($0.charAt(0)){
					case 'y' : return padding(date.getFullYear(),$0.length);
					case 'M' : return padding(date.getMonth()+1,$0.length);
					case 'd' : return padding(date.getDate(),$0.length);
					case 'w' : return date.getDay()+1;
					case 'h' : return padding(date.getHours(),$0.length);
					case 'm' : return padding(date.getMinutes(),$0.length);
					case 's' : return padding(date.getSeconds(),$0.length);
				}
			});
		},
		parse: function(dateString,pattern){
			var matchs1=pattern.match(SIGN_REGEXP);
			var matchs2=dateString.match(/(\d)+/g);
			if(matchs1.length==matchs2.length){
				var _date = new Date(1970,0,1);
				for(var i=0;i<matchs1.length;i++){
					var _int = parseInt(matchs2[i]);
					var sign = matchs1[i];
					switch(sign.charAt(0)){
						case 'y' : _date.setFullYear(_int);break;
						case 'M' : _date.setMonth(_int-1);break;
						case 'd' : _date.setDate(_int);break;
						case 'h' : _date.setHours(_int);break;
						case 'm' : _date.setMinutes(_int);break;
						case 's' : _date.setSeconds(_int);break;
					}
				}
				return _date;
			}
			return null;
		}
	})
})()

function checkFlapper(flapper){
	if(flapper.length>5 || flapper.length==0){
		return false;
	}
	return true;
}

Ynzc.manage.TextField = Ext.extend(Ext.form.TextField, {
    tipTitle:null,
    initComponent:function(){
    	Ynzc.manage.TextField.superclass.initComponent.call(this);
        this.addEvents('mouseover');
    },
    initEvents:function(){
    	Ynzc.manage.TextField.superclass.initEvents.call(this);
    	this.el.on('mouseover',this.onMouseOver,this);
    },
    onMouseOver:function(){
    	 new Ext.ToolTip({
    		   target : this.el.dom.id,
    		   title : this.tipTitle,
    		   html : this.getValue(),
    		   trackMouse : true
    	 });
    }
});
Ext.reg('textfield-tip', Ynzc.manage.TextField);
