package Ynzc.Util;

import java.math.BigDecimal;
import java.text.NumberFormat;
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
 *          �?�?2009-06-22 下午01:22:43
 */
public class CurrencyUtil {
   public static String convertToThreeForm(String d){
	   NumberFormat nf = NumberFormat.getCurrencyInstance();
	   return nf.format(new BigDecimal(d).doubleValue());
   }
   public static String convertToThreeFormNum(String d){
	   NumberFormat nf = NumberFormat.getNumberInstance();
	   return nf.format(new BigDecimal(d).doubleValue());
   }
   public static BigDecimal convertToNum(String d)throws Exception{
	   
	   NumberFormat nf = NumberFormat.getNumberInstance();
	   
	   return new BigDecimal(nf.parse(d).doubleValue());
   }
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
         System.out.println(CurrencyUtil.convertToThreeForm("2343422341.00"));  
         System.out.println(CurrencyUtil.convertToNum("2,343,422,341.00")); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
