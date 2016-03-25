package Ynzc.Util;

public class ConvertDBCAndSBC {
    // <summary>半角转成全角    
    // 半角空格32,全角空格12288    
    // 其他字符半角33~126,其他字符全角65281~65374,相差65248    
    // </summary>    
    // <param name="input"></param>    
    // <returns></returns>    
	public static String DBCToSBC(String input){    
		char[] cc = input.toCharArray();    
		for(int i=0;i<cc.length;i++){    
			if(cc[i] == 32){    
				// 表示空格    
				cc[i]=(char)12288;    
				continue;    
			}    
			if(cc[i] < 127 && cc[i] > 32){    
				cc[i]=(char)(cc[i]+65248);                    
			}    
		}    
		return new String(cc);    
	}    
   
    // <summary>全角转半角    
    // 半角空格32,全角空格12288    
    // 其他字符半角33~126,其他字符全角65281~65374,相差65248    
    // </summary>    
    // <param name="input"></param>    
    // <returns></returns>    
	public static String SBCToDBC(String input){    
		char[] cc = input.toCharArray();    
		for (int i = 0; i < cc.length; i++){    
			if(cc[i] == 12288){    
				// 表示空格    
				cc[i] = (char)32;    
				continue;    
			}    
			if (cc[i] > 65280 && cc[i] < 65375){    
				cc[i] = (char)(cc[i] - 65248);                    
			}
		}
		return new String(cc);
	}
}