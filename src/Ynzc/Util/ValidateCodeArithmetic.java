package Ynzc.Util;
import java.sql.Date;
import java.util.*;
import java.util.Random;
import java.util.Vector;
import org.apache.log4j.*;
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
 *          �?�?2009-06-22 下午01:25:44
 */
public class ValidateCodeArithmetic {
	  //根据数组生成随机�?
	  public static String getGenerateCodeRadom(){
	  String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	  String b ="";
	  for (int i=0;i<16;i++){
	    int c = (int)Math.floor(Math.random()*10);
	    //
	      b = b + arr[c];
	  }
	  b = "07"+b;
	  return b;
	}
	  public static void main(String[] arg){
		  System.out.println(getGenerateCodeRadom());
		  
	  }
}
