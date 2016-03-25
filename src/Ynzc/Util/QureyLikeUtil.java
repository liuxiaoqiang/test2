package Ynzc.Util;
/**
 * 
 * TODO:本文件说明或描述
 * <br>
 * <b>Company</b>:
 *             云艺网络
 * <br>
 * <b>Writer</b>: 
 *          <a href="mailto:yinyiyin@126.com"></a><br>
 * <b>CreateTime<b>:
 *          2009-06-22 下午01:24:59
 */
public class QureyLikeUtil {
	public static String getLikeStr(String s) {
		if (s != null && !s.equals("")) {
			s = "%" + s + "%";
		}
		return s;
	}
}
