package Ynzc.Util;

import java.util.Date;
/**
 * 
 * TODO:本文件说明或描述
 * <br>
 * <b>Company</b>:
 * <br>
 * <b>Writer</b>: 
 *          �?�?<a href="mailto:yinyiyin@126.com">尹以�?</a><br>
 * <b>CreateTime<b>:
 *          �?�?2009-06-22 下午01:22:30
 */
public class CreateRandomChar {

	public CreateRandomChar() {
		super();
		// TODO 自动生成构�?�函数存�??
	}

	public static String getRandomChar() {
		Date pathDate = new Date();
		long pathTimestamp = pathDate.getTime();
		// DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		// String id = "";
		// id = dateFormat.format(pathDate);
		return getChar() + getChar() + String.valueOf(pathTimestamp)
				+ getChar() + getChar()+ getChar() + getChar()+ getChar() + getChar();
		

	}

	static String getChar() {
		int select = (int) (Math.random() * 26 + 1);
		String s = "";
		switch (select) {
		case 1:
			s = "a";
			break;
		case 2:
			s = "b";
			break;
		case 3:
			s = "c";
			break;
		case 4:
			s = "d";
			break;
		case 5:
			s = "e";
			break;
		case 6:
			s = "f";
			break;
		case 7:
			s = "g";
			break;
		case 8:
			s = "h";
			break;
		case 9:
			s = "i";
			break;
		case 10:
			s = "j";
			break;
		case 11:
			s = "k";
			break;
		case 12:
			s = "l";
			break;
		case 13:
			s = "m";
			break;
		case 14:
			s = "n";
			break;
		case 15:
			s = "o";
			break;
		case 16:
			s = "p";
			break;
		case 17:
			s = "q";
			break;
		case 18:
			s = "r";
			break;
		case 19:
			s = "s";
			break;
		case 20:
			s = "t";
			break;
		case 21:
			s = "u";
			break;
		case 22:
			s = "v";
			break;
		case 23:
			s = "w";
			break;
		case 24:
			s = "x";
			break;
		case 25:
			s = "y";
			break;
		case 26:
			s = "z";
			break;
		}

		return s;
	}

//	public static void main(String arg[]) {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(new CreateRandomChar().getRandomChar());
//		}
//	}
}
