package Ynzc.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhouyu
 * 日期处理工具类
 */
public class DateTimeUtil {
	public static long MILLIONSECOND_OF_SECOND = 1000;
	public static long MILLIONSECOND_OF_MINUTE = MILLIONSECOND_OF_SECOND * 60;
	public static long MILLIONSECOND_OF_HOUR = MILLIONSECOND_OF_MINUTE * 60;
	public static long MILLIONSECOND_OF_DAY = MILLIONSECOND_OF_HOUR * 24;

	public static long TIMEZONE_OFFSET = Calendar.getInstance().get(
			Calendar.ZONE_OFFSET)
			+ Calendar.getInstance().get(Calendar.DST_OFFSET);

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			DEFAULT_DATE_FORMAT);
	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(
			DEFAULT_DATETIME_FORMAT);
	private static final String[] MONTHS = {"12","01","02","03","04","05","06","07","08","09","10","11"};
	private DateTimeUtil() {
		// Nothing
	}

	/**
	 * @author zhouyu
	 * 用缺省的时间、日期格式去解析一个字符串
	 * @param datestr String
	 * @return Date
	 */
	public static Date parse(String datestr) {
		if(datestr == null) {
			return null;
		};

		Date date = null;
		try {
			date = DATETIME_FORMAT.parse(datestr);
		} catch(ParseException ex) {
			date = null;
		};

		if(date != null) {
			return date;
		}

		try {
			date = DATE_FORMAT.parse(datestr);
		} catch(ParseException ex) {
			date = null;
		}

		return date;
	}
	
	/**
	 * @author zhouyu
	 * 使用给出的时间格式去解析一个字符串
	 * @param datestr String
	 * @param formatstr String
	 * @return Date
	 */
	public static Date parse(String datestr, String formatstr) {
		if(StringUtil.isNullOrEmptyStr(datestr))return null;
		
		SimpleDateFormat dateformat = new SimpleDateFormat(formatstr);
		Date date = null;
		try {
			date = dateformat.parse(datestr);
		} catch(ParseException ex) {
			date = null;
		};

		dateformat = null;
		return date;
	}

	/**
	 * @author zhouyu
	 * 用缺省的日期格式来将时间转化为字符串，结果字符串中只包含日期部分
	 * @param date Date
	 * @return String 如果传入的日期为null，则返回null
	 */
	public static String formatDate(Date date) {
		if(date == null) {
			return null;
		}

		return DATE_FORMAT.format(date);
	}

	/**
	 * @author zhouyu
	 * 用缺省的日期时间格式来将时间转化为字符串，结果字符串中包含完整的日期、时间格式
	 * @param date Date
	 * @return String 如果传入的日期为null，则返回null
	 */
	public static String formatDateTime(Date date) {
		if(date == null) {
			return null;
		}

		return DATETIME_FORMAT.format(date);
	}

	/**
	 * @author zhouyu
	 * 用诶定日期时间格式来将时间转化为字符串
	 * @param date Date
	 * @param formatstr String
	 * @return String 如果传入的日期或格式字符串为空，则返回空
	 */
	public static String format(Date date, String formatstr) {
		if(date == null || formatstr == null) {
			return null;
		}

		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		String datestr = format.format(date);
		format = null;
		return datestr;
	}

	/**
	 * @author zhouyu
	 * 获取系统当前的时间
	 * @return Date
	 */
	public static Date getNow() {
		Calendar now = Calendar.getInstance();
		return now.getTime();
	}

	public static String getNowDateString() {
		return formatDate(getNow());
	}

	public static String getNowDateTimeString() {
		return formatDateTime(getNow());
	}

	public static String getNowTimeString() {
		return format(getNow(), DEFAULT_TIME_FORMAT);
	}

	/**
	 * @author zhouyu
	 * 得到一个调整的日期
	 * @param date Date
	 * @param day int
	 * @param hour int
	 * @param minute int
	 * @param second int
	 * @param microsecond long
	 * @return Date
	 */
	public static Date getAdjustTime(Date date, int day, int hour, int minute,
			int second, long microsecond) {
		Date d = date == null ? getNow() : date;
		return new Date(d.getTime() + MILLIONSECOND_OF_DAY * day
				+ MILLIONSECOND_OF_HOUR * hour + MILLIONSECOND_OF_MINUTE * minute
				+ MILLIONSECOND_OF_DAY * second + microsecond);
	}

	/**
	 * @author zhouyu
	 * 将时间设置为本日的第一个时间
	 * @param date
	 */
	public static void setDayFirstTime(Date date) {
		if(date == null) {
			return;
		}

		long l = date.getTime();
		l = l - (l + TIMEZONE_OFFSET) % MILLIONSECOND_OF_DAY;
		date.setTime(l);
	}

	/**
	 * @author zhouyu
	 * 将时间设置为本日的最后一个时间
	 * @param date
	 */
	public static void setDayLastTime(Date date) {
		if(date == null) {
			return;
		}

		long l = date.getTime();
		l = l - (l + TIMEZONE_OFFSET) % MILLIONSECOND_OF_DAY + MILLIONSECOND_OF_DAY
				- 1;
		date.setTime(l);
	}

	/**
	 * @author zhouyu
	 * 得到Date的前一天
	 * @param date
	 * @return
	 */
	public static Date getYesterday(Date date) {
		return DateTimeUtil.getAdjustTime(date, -1, 0, 0, 0, 0);
	}

	/**
	 * @author zhouyu
	 * 得到昨天
	 * @return
	 */
	public static Date getYesterday() {
		return getYesterday(null);
	}

	/**
	 * @author zhouyu
	 * 得到Date的后一天
	 * @param date
	 * @return
	 */
	public static Date getTomorrow(Date date) {
		return DateTimeUtil.getAdjustTime(date, 1, 0, 0, 0, 0);
	}

	/**
	 * @author zhouyu
	 * 得到明天
	 * @return
	 */
	public static Date getTomorrow() {
		return getTomorrow(null);
	}

	/**
	 * @author zhouyu
	 * 得到当前的年度（四位数字字符串）
	 * @return String
	 */
	public static String getYearStr(String date) {
		return StringUtil.getLeftString(date, "-");
	}
	
	/**
	 * @author zhouyu
	 * 得到当前的年度（四位数字字符串）
	 * @return String
	 */
	public static String getMonthStr(String date) {
		return date.split("-")[1];
	}
	
	/**
	 * @author zhouyu
	 * 得到当前的年度（四位数字字符串）
	 * @return String
	 */
	public static String getThisYearStr() {
		return StringUtil.getLeftString(DateTimeUtil.getNowDateString(), "-");
	}

	/**
	 * @author zhouyu
	 * 得到当前的年度（整形）
	 * @return int
	 */
	public static int getThisYear() {
		return Integer.valueOf(getThisYearStr()).intValue();
	}
	
	public static String convertZHNum(String str){
		String[] dateZh ={ "一", "二", "三", "四", "五", "六", "七", "八", "九", "○"};
		String[] dateSz ={ "1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
			
		String strZH = str;
		for (int i = 0; i < dateSz.length; i++) {
			strZH = strZH.replaceAll(dateSz[i], dateZh[i]);
		}
		return strZH;
	}
	
	public static String convertZH(String strNew,String splitStr)
	{
		String reValue = "";
		String[] dateZh ={ "一", "二", "三", "四", "五", "六", "七", "八", "九", "○"};
		String[] dateSz ={ "1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
			
		String[] dateItems = strNew.split(splitStr);
		if(dateItems.length==0){
			return null;
		}
		
		String year = dateItems[0];
		for (int i = 0; i < dateSz.length; i++) {
			year = year.replaceAll(dateSz[i], dateZh[i]);
		}
		
		
		reValue = year + "年";
		String itemStr = "";
		for(int y=1;y<dateItems.length;y++){
			String item = dateItems[y];
			if(item.startsWith("0")){
				item = item.substring(1);
			}
			if(item.length()==1){
				for (int i = 0; i < dateSz.length; i++) {
					if(dateSz[i].equals(item)){
						itemStr = dateZh[i];
					}
				}
			}else{
				for (int i = 0; i < item.length(); i++) {
					String temp = item.substring(i, i + 1);
					if(i==0&&temp.equals("1"))continue;
					for (int x = 0; x < dateSz.length; x++) {
						if(temp.equals(dateSz[x])){
							temp = dateZh[x];
							break;
						}
					}
					if("��".equals(temp))temp = "";
					if(i == item.length()-1){
						itemStr += "ʮ" + temp;
					}else{
						itemStr +=  temp;
					}
				}
			}
			if(y==1){
				reValue +=  itemStr + "月";
				itemStr = ""; 
			}else{
				reValue +=  itemStr + "日";
			}
		}
		
		return reValue;
	}
	
	public static Date getStartOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		return getStartOfDay(cal.getTime());
	}
	
	public static Date getEndOfMonth(Date date){
		int year, month;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		if (month > 11) {
			year++;
			month = 0;
		}
		cal.set(year, month, 0);
		return getEndOfDay(cal.getTime());
	}
	
	public static Date getStartOfDay(Date date){
		setDayFirstTime(date);
		return date;
	}
	
	public static Date getEndOfDay(Date date){
		setDayLastTime(date);
		return date;
	}
	
	public static Date getStartOfWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_MONTH, -(dayOfWeek - 2));
		return getStartOfDay(cal.getTime());
	}
	
	public static Date getEndOfWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_MONTH, -(dayOfWeek - 8));
		return getEndOfDay(cal.getTime());
	}
	
	/**
	 * @author zhouyu
	 * 获取近两周的第一天，最后一天由getEndOfWeek(Date date)获取
	 * @param date
	 * @return
	 */
	public static Date getStartOfLastTwoWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_MONTH, -(dayOfWeek + 6));
		return cal.getTime();
	}
	
	/**
	 * @author zhouyu
	 * 获取本季度的第一天
	 * @param date
	 * @return
	 */
	public static Date getStartQuerterDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH)+1;
		int startMonth;
		if(month >=1 &&month<=3){
			startMonth = 1;
		}else if(month >=4 && month <=6){
			startMonth = 4;
		}else if(month >=7 && month <=9){
			startMonth = 7;
		}else{
			startMonth = 10;
		}
		startMonth = startMonth - 1;
		cal.set(Calendar.MONTH, startMonth);
		cal.set(Calendar.DATE, 1);
		Date startQuarterDay = cal.getTime();
		return startQuarterDay;
	}
	
	/**
	 * @author zhouyu
	 * 获取本季度的最后一天
	 * @param date
	 * @return
	 */
	public static Date getEndQuerterDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH)+1;
		int endMonth;
		if(month >=1 &&month<=3){
			endMonth = 3;
		}else if(month >=4 && month <=6){
			endMonth = 6;
		}else if(month >=7 && month <=9){
			endMonth = 9;
		}else{
			endMonth = 12;
		}
		endMonth = endMonth - 1;
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, endMonth);
		Date endQuarterDay = DateTimeUtil.getEndOfMonth(cal.getTime());
		return endQuarterDay;
	}
	
	/**
	 * @author zhouyu
	 * 获取指定日期的数值，精确到日
	 * @param date DEFAULT_DATE_FORMAT格式的日期
	 * @return
	 */
	public static long getDateFormatTime(Date date){
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime().getTime();
	}
	
	public static Date getRollDate(Date date,int rollType,int amount){
		Calendar C = Calendar.getInstance();
		C.setTime(date);
		C.roll(rollType, amount);
		return C.getTime();
	}
	
	public static Date getDate(int year,int month,int day){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		return cal.getTime();
	}
	
	/**
	 * @author zhouyu
	 * 修改当前日期的值
	 * @param date Date
	 * @param day int
	 * @param hour int
	 * @param minute int
	 * @param second int
	 * @param microsecond long
	 * @return Date
	 */
	public static void setAdjustTime(Date date, int day, int hour, int minute,
			int second, long microsecond) {
		if(date == null) return;
		date.setTime(date.getTime() + MILLIONSECOND_OF_DAY * day
				+ MILLIONSECOND_OF_HOUR * hour + MILLIONSECOND_OF_MINUTE * minute
				+ MILLIONSECOND_OF_SECOND * second + microsecond);
	}
	
	/**
	 * 获取给定毫秒数的整数天
	 * @author zhouyu
	 * @param ms long
	 * @return long
	 */
	public static long getDayCountByMs(long ms) {
		long dayMs = 24 * 3600 * 1000;
		return ms / dayMs;
	}
	
	/**
	 * 获取给定毫秒数的整数小时
	 * @author zhouyu
	 * @param ms long
	 * @return long
	 */
	public static long getHourCountByMs(long ms) {
		long hourMs = 3600 * 1000;
		return ms / hourMs;
	}
	
	/**
	 * 获取给定毫秒数的整数分钟
	 * @author zhouyu
	 * @param ms long
	 * @return long
	 */
	public static long getMinuteCountByMs(long ms) {
		long mimuteMs = 60 * 1000;
		return ms / mimuteMs;
	}
	
	/**
	 * 获取给定毫秒数的整数天、小时、分钟
	 * @author zhouyu
	 * @param ms long
	 */
	public static String getDayHourMiCountStr(long ms) {
		long day, h, mi;
		day = getDayCountByMs(ms);
		h   = getHourCountByMs(ms);
		mi  = getMinuteCountByMs(ms);
		
		String str = "";
		str += day + "天";
		str += (h - (day * 24)) + "小时";
		str += (mi - (h * 60)) + "分钟";
		return str;
	}
	public static Date getLastMonthStartDay(Date now){
		String[] dateStrs = DateTimeUtil.format(now, DateTimeUtil.DEFAULT_DATE_FORMAT).split("-");
		String year = Integer.parseInt(dateStrs[1])==1?(Integer.parseInt(dateStrs[0])-1)+"":dateStrs[0];
		String month = Integer.parseInt(dateStrs[1])==1?"12":(Integer.parseInt(dateStrs[1])-1)+"";
		return DateTimeUtil.parse(year+"-"+month+"-01", DateTimeUtil.DEFAULT_DATE_FORMAT);
	}
	public static String getFullMonth(int month) {
		if (month <= 0) return "01";
		else return MONTHS[month % 12];
	}
	
	/**
	 * @author zhouyu
	 * 判断两个日期是否同年同月同日
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		boolean result = false;
		
		if (date1 != null && date2 != null) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			
			if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
				cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) && 
				cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)) {
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * @author zhouyu
	 * 判断两个日期是否非同年同月同日
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isNotSameDate(Date date1, Date date2) {
		return !isSameDate(date1, date2);
	}
	
	
	/**
	 * @author zhouyu
	 * 将指定日期转换为中文模式(如：二〇一〇年九月八日)
	 * @param date
	 * @return
	 */
	public static String convertDateToChineseFormat(Date date) {
		String result = null;
		
		if (date != null) {
			result = "${year}年${month}月${day}日";
			
			String[] chineseDigits = new String[] {"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			/* 年转换 */
			String year = "";
			char[] yearDigitArray = Integer.toString(cal.get(Calendar.YEAR)).toCharArray();
			for (char yearDigit : yearDigitArray) {
				year += chineseDigits[Character.getNumericValue(yearDigit)];
			}
			
			/* 月转换 */
			String month = "";
			char[] monthDigitArray = Integer.toString(cal.get(Calendar.MONTH) + 1).toCharArray();
			for (char monthDigit : monthDigitArray) {
				if (StringUtil.isNotNullEmptyStr(month)) {
					if (month.indexOf(chineseDigits[1]) != -1) {
						month = month.replace(chineseDigits[1], "十");
					} else {
						month += "十";
					}
				}
				
				if (Character.getNumericValue(monthDigit) != 0) {
					month += chineseDigits[Character.getNumericValue(monthDigit)];
				}
			}
			
			/* 日转换 */
			String day = "";
			char[] dayDigitArray = Integer.toString(cal.get(Calendar.DAY_OF_MONTH)).toCharArray();
			for (char dayDigit : dayDigitArray) {
				if (StringUtil.isNotNullEmptyStr(day)) {
					if (day.indexOf(chineseDigits[1]) != -1) {
						day = day.replace(chineseDigits[1], "十");
					} else {
						day += "十";
					}
				}
				if (Character.getNumericValue(dayDigit) != 0) {
					day += chineseDigits[Character.getNumericValue(dayDigit)];
				}
			}
			
			result = result.replace("${year}", year);
			result = result.replace("${month}", month);
			result = result.replace("${day}", day);
		}
		
		return result;
	}
	
	public static Date addYear(int year){
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.YEAR,year); 
		return cal.getTime();
	}
	
	public static Date addDate(int date){
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.DATE,date); 
		return cal.getTime();
	}
	
	public static long getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return 0;
		}
		return day;
	}
	
	public static void main(String[] args) {
		System.out.println(getTwoDay("1999-10-10","2000-10-10"));
	}
}
