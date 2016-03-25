package Ynzc.Util;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import org.apache.log4j.Logger;
import java.io.PrintStream;
import java.util.Random;
import java.security.*;
import java.security.spec.*;
import com.sun.crypto.provider.SunJCE;
import java.io.Serializable;

/** * 提供算法，可以对输入的字符串进行、解密操作 */
public class EncryptData {
	private static Logger log = Logger.getLogger(EncryptData.class);

	public String uCode(String s) {
		int i = s.length();
		String s2 = "";
		if (i == 0)
			return "";
		for (int k = 0; k < i; k++) {
			String s1 = s.substring(k, k + 1);
			int j = s1.hashCode();
			if (j > 255)
				s2 = s2 + String.valueOf((char) (j >> 8))
						+ String.valueOf((char) (j & 0xff));
			else
				s2 = s2 + String.valueOf('\0') + s1;
		}

		return s2;
	}

	public String uDCode(String s) {
		int i = s.length();
		if (i % 2 != 0)
			return "-1";
		String s1 = "";
		for (int j = 0; j < i / 2; j++)
			s1 = s1
					+ String.valueOf((char) ((s.charAt(j * 2) << 8) + s
							.charAt(j * 2 + 1)));

		return s1;
	}

	/**
	 * 
	 * 
	 * @param s
	 *            需要的String
	 * @return 加过密的String
	 */
	public String encodePWS(String s) {
		if (s == null)
			return null;
		int i = s.length();
		if (i == 0)
			return "";
		s = uCode(s);
		i = s.length();
		String s4 = "";
		String s5 = "";
		Random random = new Random();
		boolean flag = false;
		for (int j = 0; j < i; j++) {
			String s1 = Integer
					.toHexString(s.substring(j, j + 1).hashCode() >> 4);
			String s2 = Integer
					.toHexString(s.substring(j, j + 1).hashCode() & 0xf);
			String s3 = Integer.toString(random.nextInt());
			s3 = s3.substring(s3.length() - 1, s3.length());
			if (j % 3 == 0)
				s4 = s4 + s3 + s1 + s2;
			else if (j % 3 == 1)
				s4 = s4 + s1 + s3 + s2;
			else
				s4 = s4 + s1 + s2 + s3;
		}

		return s4;
	}

	/**
	 * 解密
	 * 
	 * @param s
	 *            已经加过密的String
	 * @return 解密过的String
	 */

	public String decodePWS(String s) {
		if (s == null)
			return null;
		int i = s.length();
		if (i == 0)
			return "";
		String s1 = "";
		String s2 = "";
		String s3 = "";
		s2 = s;
		if (s2.length() % 3 != 0)
			return "-1";
		for (int j = 0; j < s2.length() / 3; j++)
			if (j % 3 == 0)
				s1 = s1 + s2.substring(j * 3 + 1, (j + 1) * 3);
			else if (j % 3 == 1)
				s1 = s1 + s2.substring(j * 3, j * 3 + 1)
						+ s2.substring(j * 3 + 2, (j + 1) * 3);
			else
				s1 = s1 + s2.substring(j * 3, j * 3 + 2);

		for (int k = 0; k < s1.length() / 2; k++)
			s3 = s3
					+ String
							.valueOf((char) ((Char2int(s1.charAt(k * 2)) << 4) + Char2int(s1
									.charAt(k * 2 + 1))));

		s3 = uDCode(s3);
		return s3;
	}

	public int Char2int(char c) {
		if (c >= '0' && c <= '9')
			return c - 48;
		if (c >= 'a' && c <= 'f')
			return (c - 97) + 10;
		else
			return -1;
	}

	public static void main(String args[]) {
		EncryptData encode = new EncryptData();
		System.out.println("原本未的：2010-10-25");
		String s = encode.encodePWS("2010-10-25");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		//*********************************************************
		
		System.out.println("原本未的：00-19-D2-C7-E3-B0");
		s = encode.encodePWS("00-19-D2-C7-E3-B0");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		
		
		System.out.println("原本未的：00-1B-24-0F-4F-14");
		s = encode.encodePWS("00-1B-24-0F-4F-14");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		
		
		
		System.out.println("原本未的：云艺网络");
		s = encode.encodePWS("云艺网络");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		
		
		System.out.println("原本未的：00-19-D2-C7-E3-B0#00-1B-24-0F-4F-14");
		s = encode.encodePWS("00-19-D2-C7-E3-B0#00-1B-24-0F-4F-14");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		System.out.println("原本未的：00-19-D2-C7-E3-B0#00-1B-24-0F-4F-14");
		
		
		
		System.out.println("原本未的：00-1B-24-0F-4F-14#00-19-D2-C7-E3-B0");
		s = encode.encodePWS("00-1B-24-0F-4F-14#00-19-D2-C7-E3-B0");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		System.out.println("原本未的：00-1B-24-0F-4F-14#00-19-D2-C7-E3-B0");
		
		//************************刘小康MAC
		
		System.out.println("原本未的：7A-79-05-7F-53-27#E0-CB-4E-24-F3-60");
		s = encode.encodePWS("7A-79-05-7F-53-27#E0-CB-4E-24-F3-60");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		System.out.println("原本未的：7A-79-05-7F-53-27#E0-CB-4E-24-F3-60");
		
		
		System.out.println("原本未的：E0-CB-4E-24-F3-60#7A-79-05-7F-53-27");
		s = encode.encodePWS("E0-CB-4E-24-F3-60#7A-79-05-7F-53-27");
		System.out.println("加过密的：" + s);
		System.out.println("The   encode   lenth   is   " + s.length());
		System.out.println("放开的：" + encode.decodePWS(s));
		System.out.println("原本未的：E0-CB-4E-24-F3-60#7A-79-05-7F-53-27");
		
		//刘小康 end
		
		//************************刘小康MAC
		
		
		
		
	}

}
