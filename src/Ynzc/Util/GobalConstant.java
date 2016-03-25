package Ynzc.Util;

import java.util.List;

/**
 * 
 * TODO:本文件说明或描述
 * <br>
 * <b>Company</b>:
 *             云艺网络
 * <br>
 * <b>Writer</b>: 
 *          �?�?<a href="mailto:yinyiyin@126.com">尹以�?</a><br>
 * <b>CreateTime<b>:
 *          �?�?2009-06-22 下午01:23:15
 */
public class GobalConstant {
	public static String realPath;
	public static String localUrl="/";
	public static String netsideStyle;//样式
	public static String sysTitle="";//page title
	public static String copyRight="";//copyRight
	public static String serverRootPath="/";//用来设置临时虚拟路径
	public static String spid="72590";//联通SP产商id号
	public static String mmscid="10620083";//联通SP彩信接入号
	public static String MerId="";//银联商户号
	public static String CuryId="156";//货币代码, 长度为3个字节的数字串，目前只支持人民币，取值为"156"
	public static String TransType1="0001";//交易类型，长度为4个字节的数字串，取值范围为："0001"和"0002"， 其中"0001"表示消费交易，"0002"表示退货交易
	public static String TransType2="0002";//交易类型，长度为4个字节的数字串，取值范围为："0001"和"0002"， 其中"0001"表示消费交易，"0002"表示退货交易
	public static String sysT="yinyiyin4500187954228";//号码产生规则
	public static String employeeSession="employee";//管理员Session
	public static String memberSession="member";//会员Session
	public static String network="http://";//会员Session
	public static String domainname="";
	public static Database base=null;//数据库连接初始
	public static String jqueryEasyUI="<link rel='stylesheet' type='text/css' href='"+GobalConstant.localUrl+"common/jquery-easyui-1.2.2/themes/lynn/easyui.css'>\n"+ 
									 "<link rel='stylesheet' type='text/css' href='"+GobalConstant.localUrl+"common/jquery-easyui-1.2.2/themes/icon.css'>\n"+ 
									 "<script type='text/javascript' src='"+GobalConstant.localUrl+"common/jquery-easyui-1.2.2/locale/easyui-lang-zh_CN.js'></script>\n"+ 
									 "<script type='text/javascript' src='"+GobalConstant.localUrl+"common/jquery-easyui-1.2.2/jquery.easyui.min.js'></script>\n"+ 
									 "<script type='text/javascript' src='"+GobalConstant.localUrl+"common/jquery-easyui-1.2.2/jquery-1.4.2.min.js'></script>\n";
	//ClassInfo classinfo=new ClassInfo();
	public static String serverip="";
	public static String jqueryupload = "<link href='" + GobalConstant.localUrl + "common/jqueryUploadify/uploadify.css' rel='stylesheet' type='text/css' />\n<script type='text/javascript' src='"+GobalConstant.localUrl+"common/jquery-easyui-1.2.2/jquery-1.4.2.min.js'></script>\n" +
    "<script>\n"+
    "var boxH='120'; //附件盒子高度 \n"+
    "var boxW='500px' ; //附件盒子宽度 可以用百分比如 90%\n"+
    "var pathString = '/Upload/Manage';//设置文件上传路径，默认值为/Upload\n"+
    "</script>\n"+
    "<script type='text/javascript' src='" + GobalConstant.localUrl + "common/jqueryUploadify/swfobject.js'></script>\n" +
    "<script type='text/javascript' src='" + GobalConstant.localUrl + "common/jqueryUploadify/jquery.uploadify.v2.1.0.js'></script>\n" +
    "<script type='text/javascript' src='" + GobalConstant.localUrl + "common/jqueryUploadify/uploadSet.js'></script>\n";
	
	public static List IndexScrollPhotoList=null;//首页流动10张图片
	public static String MediaCodercodecs="d:\\flv\\MediaCoder\\codecs";//视频转换插件安装地址
	public static String MediaCoderffmpeg="d:\\flv\\MediaCoder\\codecs\\ffmpeg.exe";//视频转换插件EXE安装地址
	public static String logoPath="/images/logo.jpg";
	public static String jqueryformValidator="<link rel='stylesheet' type='text/css' href='"+GobalConstant.localUrl+"common/formValidator/css/validationEngine.jquery.css'>\n"+ 
									 "<link rel='stylesheet' type='text/css' href='"+GobalConstant.localUrl+"common/formValidator/css/template.css'>\n"+ 
									 "<script type='text/javascript' src='"+GobalConstant.localUrl+"common/formValidator/js/jquery.corner.js'></script>\n"+ 
									 "<script type='text/javascript' src='"+GobalConstant.localUrl+"common/formValidator/js/jquery.validationEngine.js'></script>\n";
}
