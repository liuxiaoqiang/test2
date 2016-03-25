package Ynzc.Util;
/**
 * 判断是否有中文字符
 * @author yinyiyin
 *
 */
public class CheckChinseChar {
	public static boolean checkChar(String oneChar) {
		if(oneChar==null){
			return false;
		}
		for(int i=0;i<oneChar.length();i++)
	    {
	           String test=oneChar.substring(i,i+1);
	           System.out.println(test);
	           if(test.matches("[\\u4E00-\\u9FA5]+"))
	           {
	                 System.out.println("中文");
	                 return true;
	           }
	    }
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String str = "我是Automan Dytang ,，奥特曼。";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (checkChar(ch)) {
				System.out.println(ch + "是中文");
			} else
				System.out.println(ch + "不是中文");
		}*/
		checkChar("中国人民");
	}
	
}
