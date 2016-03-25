package Ynzc.Util;
import java.io.*;
public class FileUp {

	public FileUp(){}
	public static String up(String serverPath,String filePath,String fileName){
		String []imgname=null;//获取后缀名
		String imgName="";
		String ServerPath=serverPath+filePath;
		if(fileName.length()==0 && fileName.equals(""))
		{
			//System.err.println("没有图片！");
		}else
		{
			File file=new File(fileName);
			 imgname=file.getName().split("\\.");
			 imgName=CreateRandomChar.getRandomChar()+"."+imgname[imgname.length-1];
			//serverPath=serverPath + "upload\\";
			File file2=new File(ServerPath,imgName);
			
			byte by[]=new byte[1024];
			int i;
			try {
				file2.createNewFile();
				FileInputStream in=new FileInputStream(file);
				FileOutputStream ou=new FileOutputStream(file2);
				
				while((i=in.read(by,0,1024))!=-1)
				{
					ou.write(by,0,i);
				}
				in.close();
				ou.flush();
				ou.close();
				return filePath+imgName;
				//out.print("<script>alert('成功了!!');</script>");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
