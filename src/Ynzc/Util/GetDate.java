package Ynzc.Util;

import java.util.*;
import java.text.*;

/**
 * 
 * TODO:本文件说明或描述
 * <br>
 * <b>Company</b>:
 *             
 * <br>
 * <b>Writer</b>: 
 *          �?�?<a href="mailto:yinyiyin@126.com">尹以�?</a><br>
 * <b>CreateTime<b>:
 *          �?�?2009-06-22 下午12:49:16
 */
public class GetDate {
  public static final long minute = 1000 * 60;

  public GetDate() {
  }

  public static Date getNowDate() {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(currentTime);
    ParsePosition pos = new ParsePosition(8);
    Date currentTime_2 = formatter.parse(dateString, pos);
    return currentTime_2;
  }

  public static Date getNowDateShort() {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = formatter.format(currentTime);
    ParsePosition pos = new ParsePosition(8);
    Date currentTime_2 = formatter.parse(dateString, pos);
    return currentTime_2;
  }

  public static String getStringDate() {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(currentTime);
    return dateString;
  }

  public static String getStringDateShort() {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = formatter.format(currentTime);
    return dateString;
  }

  public static String getStringDateShort(Date date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = formatter.format(date);
    return dateString;
  }

  public static Date strToDate(String strDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ParsePosition pos = new ParsePosition(0);
    Date strtodate = formatter.parse(strDate, pos);
    return strtodate;
  }

  public static String dateToStr(java.util.Date dateDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = "";
    if (dateDate != null) {
      dateString = formatter.format(dateDate);
    }
    return dateString;
  }
  public static String getCurrentlyYearMonth() {
	  Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
	    String dateString = "";
	    if (currentTime != null) {
	      dateString = formatter.format(currentTime);
	    }
	    return dateString;
	  }

  public static Date strToBirthday(String strDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    ParsePosition pos = new ParsePosition(0);
    Date strtodate = formatter.parse(strDate, pos);
    return strtodate;
  }

  public static Date getNow() {
    Date currentTime = new Date();
    return currentTime;
  }

  public static long getS(String strDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    ParsePosition pos = new ParsePosition(0);
    Date strtodate = formatter.parse(strDate, pos);
    return strtodate.getTime();
  }

  public static long getStrToLong(String strDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ParsePosition pos = new ParsePosition(0);
    Date strtodate = formatter.parse(strDate, pos);
    return strtodate.getTime();
  }

  public static long getLongTime() {
    return new Date().getTime();
  }

  public static int getOffMinutes(long btime) {
    return getOffMinutes(btime, System.currentTimeMillis());
  }

  public static int getOffMinutes(long btime, long ltime) {
    return (int) ((ltime - btime) / minute);
  }

  public static String getNowYear() {
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    String dateString = formatter.format(currentTime);
    return dateString;
  }

  public static Date stringToDate(String strDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    ParsePosition pos = new ParsePosition(0);
    Date strtodate = formatter.parse(strDate, pos);
    return strtodate;
  }

  public static String getShortDate(String strDate) {
    if (strDate != null && !strDate.equals("")) {
      int len = strDate.length();
      if (len > 9) {
        strDate = strDate.substring(0, 10);
      }

    }
    return strDate;
  }
  public static int compareDate(String begindate,String enddate){
	  int resum=0;
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  try{
		  Date date1=formatter.parse(begindate);
		  Date date2=formatter.parse(enddate);
		  if(date1.getTime() > date2.getTime()){
			  resum=1;
		  }
	  }catch(Throwable e){
		  e.printStackTrace();
	  }
	  return resum;
  }
  
  public static Date addYear(int year){
	  Calendar cal = Calendar.getInstance(); 
	  cal.add(Calendar.YEAR,year); 
	  return cal.getTime();
  }
}
