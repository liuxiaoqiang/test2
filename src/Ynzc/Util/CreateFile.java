package Ynzc.Util;
/**
*
* <p>Title: 文件读写</p>
* <p>Description: </p>
* <p>content: 文件读写</p>
* <p>Copyright: Copyright (c) 2006</p>
* <p>Company: </p>
* <p>author: bhc</p>
* @version 1.0
*/
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFile {
	
	//写入文件
	public static String createFile(String realpath, String filepath, String text)
			throws Exception {
        Date pathDate = new Date();
        long pathTimestamp = pathDate.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String pathYyyymmdd = "";
        pathYyyymmdd = dateFormat.format(pathDate);
		
		String path=filepath+"/"+pathYyyymmdd+"/"+pathTimestamp;
		String fileurl=realpath+"/"+path;
		File f1=new File(realpath+"/"+filepath);
		if(!f1.exists()){
			f1.mkdir();
		}
		File f2=new File(realpath+"/"+filepath+"/"+pathYyyymmdd);
		if(!f2.exists()){
			f2.mkdir();
		}
		File f3=new File(realpath+"/"+filepath+"/"+pathYyyymmdd+"/"+pathTimestamp);
		if(!f3.exists()){
			f3.mkdir();
		}
		File file = new File(fileurl,"0");
		OutputStream os=new FileOutputStream(file);
		byte [] b=text.getBytes();
		InputStream in=new ByteArrayInputStream(b);
		BufferedInputStream bin=new BufferedInputStream (in);
		
		int bytesRead=0;
		byte[]buffer=new byte[8192];
		while((bytesRead=bin.read(buffer,0,8192))!=-1){
			os.write(buffer,0,bytesRead);
		}
		os.close();
		in.close();
		return path; 
	}
	
//	复制文件
	//public static String copyFile(String realpath, String filepath, String urlfile)
		//	throws Exception {
//        Date pathDate = new Date();
//        long pathTimestamp = pathDate.getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String pathYyyymmdd = "";
//        pathYyyymmdd = dateFormat.format(pathDate);
//		
//		String path=filepath+"/"+pathYyyymmdd+"/"+pathTimestamp;
//		String fileurl=realpath+"/"+path;
//		File f1=new File(realpath+"/"+filepath);
//		if(!f1.exists()){
//			f1.mkdir();
//		}
//		File f2=new File(realpath+"/"+filepath+"/"+pathYyyymmdd);
//		if(!f2.exists()){
//			f2.mkdir();
//		}
//		File f3=new File(realpath+"/"+filepath+"/"+pathYyyymmdd+"/"+pathTimestamp);
//		if(!f3.exists()){
//			f3.mkdir();
//		}
//		File file = new File(fileurl,"0");
//		OutputStream os=new FileOutputStream(file);
//		byte [] b=text.getBytes();
//		InputStream in=new ByteArrayInputStream(b);
//		BufferedInputStream bin=new BufferedInputStream (in);
//		
//		int bytesRead=0;
//		byte[]buffer=new byte[8192];
//		while((bytesRead=bin.read(buffer,0,8192))!=-1){
//			os.write(buffer,0,bytesRead);
//		}
//		os.close();
//		in.close();
		//return path; 
	//}
	
	//读取文件
	public static String getFile(String realpath,String path) throws IOException{
		String filepath="",s;
		File f1=new File(realpath+"/"+path+"/0");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		filepath=br.readLine();
		while(( br.readLine()) != null) {
			//System.out.println(s);
			filepath+=br.readLine();
			}
		System.out.println(filepath);
		//byte[] by=filepath.getBytes("UTF-8");
		
		
		return new String(filepath);
	}
}
