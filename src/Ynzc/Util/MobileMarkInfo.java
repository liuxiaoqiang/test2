package Ynzc.Util;

import java.io.*;
import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;
import java.util.*;
import java.util.regex.*;

import sun.net.www.protocol.http.*;

public class MobileMarkInfo {
	 private String Mobile7;
	 private String Province;
	 private String City;
	 private String MobileType;
	 private Date DateCreated;
	 private String AreaCode;
	 private String PostCode;
	 
	 public MobileMarkInfo(){}
	 /**
	  * 手机号地区级卡类型
	  * @param mobile7 手机号前七位
	  * @param province 省份
	  * @param city 城市
	  * @param mobileType 卡类型
	  * @param dateCreated 记录创建日期
	  */
	 public MobileMarkInfo(String mobile7, String province, String city, String mobileType, Date dateCreated,String AreaCode,String PostCode){
	  Mobile7 = mobile7;
	  Province = province;
	  City = city;
	  MobileType = mobileType;
	  DateCreated = dateCreated;
	  AreaCode=AreaCode;
	  PostCode=PostCode;
	 }
	 public String getMobile7(){
	  return Mobile7;
	 }
	 public void setMobile7(String mobile7){
	  Mobile7 = mobile7;
	 }
	 public String getProvince(){
	  return Province;
	 }
	 public void setProvince(String province){
	  Province = province;
	 }
	 public String getCity(){
	  return City;
	 }
	 public void setCity(String city){
	  City = city;
	 }
	 public String getMobileType(){
	  return MobileType;
	 }
	 public void setMobileType(String mobileType){
	  MobileType = mobileType;
	 }
	 public Date getDateCreated(){
	  return DateCreated;
	 }
	 public void setDateCreated(Date dateCreated){
	  DateCreated = dateCreated;
	 }
	//调用ip138的查询接口，并使用正则表达式获取对应信息
	public static MobileMarkInfo GetMobileMarkFromIP138(String mobile7){
	  //System.out.println(mobile7);
	   //请求URL   
	     String REQUEST_URL="http://www.ip138.com:8080/search.asp";   
	     //请求方法   
	     String REQUEST_MOTHOD="POST";   
	     //提取手机号码归属地的正则表达式   
	     String REGEX_EXP="^<TD width=\\* align=\"center\" class=tdc2>(.*)</TD>$";   
	     //编译后的正则表达式Pattern对象   
	     Pattern p = Pattern.compile(REGEX_EXP); 
	     
	  MobileMarkInfo mobileMarkInfo = new MobileMarkInfo();
	   
	        BufferedReader br=null;  
	         
	        try  
	        {   
	         HttpURLConnection httpConn=(HttpURLConnection)new URL(REQUEST_URL).openConnection();   
	          
	         httpConn.setRequestMethod(REQUEST_MOTHOD);   
	          
	            httpConn.setDoOutput(true);
	            
	            String requestParameter = "mobile="+mobile7+"&action=mobile";
	            
	            httpConn.getOutputStream().write(requestParameter.getBytes());
	           
	            httpConn.getOutputStream().flush();   
	            
	            httpConn.getOutputStream().close();

	            br = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),"GBK"));
	            
	            String lineStr = null;
	            
	            while((lineStr = br.readLine())!=null)   
	            {                         
	                if("<TD width=\"130\" align=\"center\" noswap>卡号归属地</TD>".equals(lineStr.trim()))   
	                {   
	                    lineStr = br.readLine().trim();
	                    
	                    Matcher m = p.matcher(lineStr);   
	                    if(m.matches())   
	                    {   
	                        String mobileArea = m.group(1);
	                        //System.out.println(mobileArea);
	                        String[] areas = mobileArea.split("&nbsp;", 2);
	                        if(areas.length>1)
	                        {                          
	                         mobileMarkInfo.setProvince(areas[0]);
	                         mobileMarkInfo.setCity(areas[1]);
	                        }
	                        else
	                        {
	                         return null;
	                        }                        
	                    }   
	                }
	                if("<TD width=\"130\" align=\"center\" noswap>卡&nbsp;类&nbsp;型</TD>".equals(lineStr.trim())){
	                 lineStr = br.readLine().trim();   
	                    Matcher m = p.matcher(lineStr);   
	                    if(m.matches())   
	                    {   
	                     String cardType = m.group(1);
	                     //System.out.println(cardType);
	                     mobileMarkInfo.setMobileType(cardType);                          
	                        break;
	                    }  
	                }
	                if("<TD align=\"center\">区&nbsp;号</TD>".equals(lineStr.trim())){
		                 lineStr = br.readLine().trim();
		                    Matcher m = p.matcher(lineStr);
		                    if(m.matches())
		                    { 
		                     String AreaCode = m.group(1);
		                     //System.out.println(cardType);
		                     mobileMarkInfo.setAreaCode(AreaCode);                          
		                        break;
		                    }  
		           }
	                if("<TD align=\"center\">邮&nbsp;编</TD>".equals(lineStr.trim())){
		                 lineStr = br.readLine().trim();
		                    Matcher m = p.matcher(lineStr);
		                    if(m.matches())
		                    { 
		                     String PostCode = m.group(1);
		                     //System.out.println(cardType);
		                     mobileMarkInfo.setPostCode(PostCode);                          
		                        break;
		                    }  
		           }
	            }   
	        }   
	        catch(IOException e) {   
	            e.printStackTrace();
	            //Log.writeLog("MobileUtil.GetMobileMarkFromIP138 " + e.getMessage());
	        }   
	        finally  
	        {   
	            if(br!=null)   
	                try {   
	                    br.close();   
	                } catch (IOException e) { 
	                  e.printStackTrace();
	                 //Log.writeLog("MobileUtil.GetMobileMarkFromIP138 " + e.getMessage());
	                }   
	        }   
	        return mobileMarkInfo;
	 }
	public String getAreaCode() {
		return AreaCode;
	}
	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}
	public String getPostCode() {
		return PostCode;
	}
	public void setPostCode(String postCode) {
		PostCode = postCode;
	}
}

	//文章出处：飞诺网(www.firnow.com):http://dev.firnow.com/course/3_program/java/javajs/20100714/444031.html
