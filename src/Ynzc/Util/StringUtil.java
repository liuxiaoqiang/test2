package Ynzc.Util;

import org.apache.log4j.Logger;


public class StringUtil {
	private static Logger log = Logger.getLogger(StringUtil.class);
	/**
	 * 判断传入的参数号码为哪家运营商
	 * @param mobile
	 * @return 运营商名称
	 */
	public static String validateMobile(String mobile){
		String returnString="";
		if(mobile==null){
			return "mobile参数为空";
		}
		//System.out.println(mobile.trim().substring(0,3));
		if(mobile.trim().length()!=11){
			return "0手机号码长度不为11，错误！";
		}
		if(mobile.trim().substring(0,3).equals("134") ||  mobile.trim().substring(0,3).equals("135") || 
				mobile.trim().substring(0,3).equals("136") || mobile.trim().substring(0,3).equals("137")  
				|| mobile.trim().substring(0,3).equals("138")  || mobile.trim().substring(0,3).equals("139") ||  mobile.trim().substring(0,3).equals("150") || 
				mobile.trim().substring(0,3).equals("151") || mobile.trim().substring(0,3).equals("152")  
				|| mobile.trim().substring(0,3).equals("157") || mobile.trim().substring(0,3).equals("158") || mobile.trim().substring(0,3).equals("159") 
				 || mobile.trim().substring(0,3).equals("187") || mobile.trim().substring(0,3).equals("188")){
			returnString="1中国移动";
		}
		if(mobile.trim().substring(0,3).equals("130") ||  mobile.trim().substring(0,3).equals("131") || 
				mobile.trim().substring(0,3).equals("132") || mobile.trim().substring(0,3).equals("156")  
				|| mobile.trim().substring(0,3).equals("185")  || mobile.trim().substring(0,3).equals("186")){
			returnString="2中国联通";
		}
		if(mobile.trim().substring(0,3).equals("133") ||  mobile.trim().substring(0,3).equals("153") || 
				mobile.trim().substring(0,3).equals("180") || mobile.trim().substring(0,3).equals("189")){
			returnString="3中国电信";
		}
		if(returnString.trim().equals("")){
			returnString="0未知的运营商";
		}
		log.info("对比运营商号码为-------：   "+returnString);
		return returnString;
	}
	
	public static final String EMPTY_STRING = "";
	/**
	 * @author zhouyu
	 * 判断是否“不”为空串（null或空字符串）
	 * @param str
	 * @return
	 */
	public static boolean isNotNullEmptyStr(String str) {
		return !StringUtil.isNullOrEmptyStr(str);
	}

	/**
	 * @author zhouyu
	 * 判断是否为空串（null或空字符串）
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmptyStr(String str) {
		return str == null || StringUtil.EMPTY_STRING.equals(str);
	}
	
	/**
	 * @author zhouyu
	 * @param s
	 * @return 
	 */
	public static String getLeftString(String s1, String s2) {
		if(StringUtil.isNullOrEmptyStr(s1) || StringUtil.isNullOrEmptyStr(s2)) {
			return s1;
		}

		int p = s1.indexOf(s2);
		if(p == -1) {
			return StringUtil.EMPTY_STRING;
		}

		return s1.substring(0, p);
	}
	
	/**
	 * @author zhouyu
	 * @param s
	 * @return 
	 */
	public static String getRightString(String s1, String s2) {
		if(StringUtil.isNullOrEmptyStr(s1) || StringUtil.isNullOrEmptyStr(s2)) {
			return s1;
		}

		int p = s1.indexOf(s2);
		int n = s2.length();

		if(p == -1) {
			return StringUtil.EMPTY_STRING;
		}

		return s1.substring(p + n);
	}
	
	/**
	 * @author zhouyu
	 * 将null转换为空字符串,如果是非空字符串则返回原字符串
	 * @param s
	 * @return 
	 */
	public static String null2Empty(String s){
		if(s==null)
			return "";
		return s;
	}
	
	/**
	 * @author zhouyu
	 * @param number
	 * @return 
	 */
	public static boolean isNumber(String number){
		boolean isNumber = false; int index = number.indexOf(",");
		if (index >= 0) {
//			isNumber = number.matches("[\\d-,]+");
			isNumber = number .matches("[+-]?[1-9]+[0-9]+(,[0-9]{3})+(.[0-9]+)?");
		}else{
			isNumber = number.matches("[+-]?[1-9]+[0-9]+(.[0-9]+)?");
		}
		return isNumber;
	}
}
