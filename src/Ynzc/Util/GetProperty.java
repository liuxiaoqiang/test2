package Ynzc.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;


public class GetProperty {
  public static String readValue(String filePath,String key){
    Properties props = new Properties();
    try {
      InputStream ips = new BufferedInputStream(new FileInputStream(filePath));
      props.load(ips);
      String value = props.getProperty(key);
      System.out.println(key+"="+value);
      return value;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
  }
}

//读取全部信息
public static void readProperties(String filePath) {
   Properties props = new Properties();
   try {
     InputStream ips = new BufferedInputStream(new FileInputStream(filePath));
     props.load(ips);
     Enumeration e = props.propertyNames();
     while(e.hasMoreElements()){
     String key = (String)e.nextElement(); 
     String value = props.getProperty(key);
     System.out.println(key+"="+value);
     }
   } catch (FileNotFoundException e) {
       e.printStackTrace();
   } catch (IOException e) {
       e.printStackTrace();
   }
}

public static void writeProperties(String filePath,String paraKey,String paraValue){
Properties props = new Properties();
try {
   OutputStream ops = new FileOutputStream(filePath);
   props.setProperty(paraKey, paraValue);
   props.store(ops, "set");
} catch (IOException e) {
   e.printStackTrace();
}
}

public static void main(String[] args){
   GetProperty.readValue("D:\\eclipse3.3\\workspace\\Test\\src\\sys.properties", "username"); 
   GetProperty.readProperties("D:\\eclipse3.3\\workspace\\Test\\src\\sys.properties");
   GetProperty.writeProperties("D:\\eclipse3.3\\workspace\\Test\\src\\sys.properties", "age", "21");
}
}