package Ynzc.Util;

import java.util.*;
import java.io.*;

public class FileOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 读取文件内容
	 * 
	 * @param filePathAndName
	 *            String 如 c:\\1.txt 绝对路径
	 * @return boolean
	 */
	public static String readFile(String filePathAndName) {
		String fileContent = "";
		try {
			File f = new File(filePathAndName);
			if (f.isFile() && f.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(f), "UTF-8");
				BufferedReader reader = new BufferedReader(read);
				String line;
				while ((line = reader.readLine()) != null) {
					fileContent += line;
				}
				read.close(); 
			}
		} catch (Exception e) {
			System.out.println("读取文件内容操作出错");
			e.printStackTrace();
		}
		return fileContent;
	}

	public static void writeFile(String filePathAndName, String fileContent,String encoding) {
		try {
			File f = new File(filePathAndName);
			if (!f.exists()) {
				f.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(f), encoding);
			BufferedWriter writer = new BufferedWriter(write);
			// PrintWriter writer = new PrintWriter(new BufferedWriter(new
			// FileWriter(filePathAndName)));
			// PrintWriter writer = new PrintWriter(new
			// FileWriter(filePathAndName));
			writer.write(fileContent);
			writer.close();
		} catch (Exception e) {
			System.out.println("写文件内容操作出错");
			e.printStackTrace();
		}
	}

}
