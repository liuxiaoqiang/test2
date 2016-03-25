package Ynzc.Util;
import java.io.*;
import java.net.URL;

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
 *          �?�?2009-06-22 下午01:23:00
 */
public class DiskIO {

    private static String resourceFolder = "";

    /** 确保目录�???��存在，如果目录不存在，则会创建一个空目录，包括父目录也一起创�???
     *  ### 此方法可将相对路径的目录名转换为路径 ###
     *  ### 建议指定目录为绝对路径的目录! ####
     * @param path String指定的路�???
     *  @return <b>true</b> if and only if the specified file exists and
     *  is a directory
     */

    public static boolean ensureDirectory(File dir) {
      boolean success = true;
      if (dir == null) {
        throw new IllegalArgumentException("dir = null");
      }
      if (!dir.isAbsolute()) {
        dir = new File(dir.getAbsolutePath());
      }
      if (!dir.isDirectory()) {
        success = !dir.isFile() && dir.mkdirs();
        if (!success) {
          try {
            throw new IOException(
                "failed while trying to create directory: " +
                dir.toString());
          }
          catch (IOException ex) {
            //只做为引发异常，提醒程序员注意，并不影响程序正常运行
            //�???��为：目录已经存在，或相同名称的文件已经存�???
            ex.printStackTrace();
          }
        }
      }
      return success;
    }

    public static boolean fileAlreadyExist(String file) {
      return fileAlreadyExist(new File(file));
    }

    public static boolean fileAlreadyExist(File file) {
      return file.exists();
    }

    public static boolean ensureDirectory(String path) {
      return ensureDirectory(new File(path));
    }

    public static void saveStringInFile(File toFile, String insertString) throws
        IOException {
      int lineNumber = 0;
      BufferedWriter out;

      out = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(toFile), "ISO-8859-1"));
      out.write(insertString);
      out.flush();
      out.close();
    }

    public static String readFileInString(File fromFile,String encoding) throws IOException {
      StringBuffer strbuf = new StringBuffer( (int) fromFile.length());

      BufferedReader in = new BufferedReader(new InputStreamReader(
          new FileInputStream(fromFile),encoding));
      String str;
      strbuf = new StringBuffer( (int) fromFile.length());

      while ( (str = in.readLine()) != null) {
        strbuf.append(str + "\n");
      }

      in.close();

      return strbuf.toString();

      /*
                   int lineNumber = 0;
                   byte[] buffer = new byte[1024];
                   int read;
           StringBuffer out = new StringBuffer((int)fromFile.length());
                   FileInputStream in = new FileInputStream( fromFile );
                   read = in.read(buffer);
                   while ( read == 1024 ) {
              out.append(new String(buffer,"ISO-8859-1"));
              read = in.read(buffer);
                   }
                   out.append(new String(buffer,0,read,"ISO-8859-1"));
                   in.close();
                   return out.toString();
       */
    }

    public static boolean deleteDirectory(String path) {
      return delete(new File(path));
    }

    public static boolean deleteDirectory(File dir) {
      return delete(dir);
    }

    /** Deletes the contents of an existing directory. (May be applied to
     *  non-existing files without causing error.)
     * @return <b>true</b> if and only if on termination the directory exists
     * and is empty
     */
    public static boolean emptyDirectory(File dir) {
      boolean success;

      if (dir == null) {
        throw new IllegalArgumentException("dir = null");
      }

      if ( (success = dir.exists() && deleteDirectory(dir))) {
        dir.mkdirs();
      }

      return success && dir.exists();
    }

    /** Delete a single disk file. Function reports errors. */

    public static boolean deleteFile(String path) {
      File f = new File(path);
      boolean success;

      if (! (success = f.delete())) {
        try {
          throw new IOException("");
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
      }

      return success;
    }

    // deleteFile

    /** General use columba resource InputStream getter.
     * @param path the full path and filename of the resource requested. If
     * <code>path</code> begins with "#" it is resolved against the program's
     * standard resource folder after removing "#"
     * @return an InputStream to read the resource data, or <b>null</b> if the resource
     * could not be obtained
     * @throws java.io.IOException if there was an error opening the input stream
     */
    public static InputStream getResourceStream(String path) throws java.io.
        IOException {
      URL url;

      if ( (url = getResourceURL(path)) == null) {
        return null;
      }
      else {
        return url.openStream();
      }
    }

    // getResourceStream

    /** General use columba resource URL getter.
     * @param path the full path and filename of the resource requested. If
     * <code>path</code> begins with "#" it is resolved against the program's
     * standard resource folder after removing "#"
     * @return an URL instance, or <b>null</b> if the resource could not be obtained
     * @throws java.io.IOException if there was an error opening the input stream
     */
    public static URL getResourceURL(String path) { //throws java.io.IOException
      URL url;

      if (path == null) {
        throw new IllegalArgumentException("path = null");
      }

      if (path.startsWith("#")) {
        path = resourceFolder + path.substring(1);
      }

      //url = ClassLoader.getSystemResource(path);
      url = DiskIO.class.getResource("/" + path);

      if (url == null) {
        try {
          throw new IOException("*** failed locating resource: " + path);
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }

        return null;
      }

      return url;
    }

    // getResourceURL

    public static void setResourceRoot(String path) {
      if (path == null) {
        resourceFolder = "";
      }
      else {
        if (!path.endsWith("/")) {
          path += "/";
        }

        resourceFolder = path;
      }
    }

    // setResourceRoot

    public static String getResourceRoot() {
      return resourceFolder;
    }

    /** Copies the contents of any disk file to the specified output file.
     *  The output file will be overridden if it exist.
     *  Function reports errors.
     *  @param inputFile a File object
     *  @param outputFile a File object
     *  @throws java.io.IOException if the function could not be completed
     *  because of an IO error
     */
    public static void copyFile(File inputFile, File outputFile) throws java.io.
        IOException {
      FileInputStream in = null;
      FileOutputStream out = null;

      byte[] buffer = new byte[512];
      int len;

      try {
        out = new FileOutputStream(outputFile);
        in = new FileInputStream(inputFile);

        while ( (len = in.read(buffer)) != -1) {
          out.write(buffer, 0, len);

        }
        in.close();
        out.close();
      }
      catch (IOException e) {
        throw new IOException("*** error during file copy " +
                              outputFile.getAbsolutePath() + ": " +
                              e.getMessage());
      }
      finally {
        if (in != null) {
          in.close();
        }
        if (out != null) {
          out.close();
        }
      }
    }

    // copyFile

    /** Copies a system resource to the specified output file. The output file will
     *  be overridden if it exist, so the calling routine has to take care about
     *  unwanted deletions of content.  Function reports errors.
     *  @param resource a full resource path. If
     *  the value begins with "#", it is resolved against the program's
     *  standard resource folder after removing "#"
     *  @return <b>true</b> if and only if the operation was successful, <b>false</b>
     *  if the resource was not found
     *  @throws java.io.IOException if there was an IO error
     */
    public static boolean copyResource(String resource, File outputFile) throws
        java.io.IOException {
      InputStream in = null;
      FileOutputStream out = null;
      byte[] buffer = new byte[512];
      int len;

      // attempt
      try {
        if ( (in = DiskIO.getResourceStream(resource)) == null) {
          return false;
        }

        out = new FileOutputStream(outputFile);

        while ( (len = in.read(buffer)) != -1) {
          out.write(buffer, 0, len);
        }
        out.close();
        in.close();
      }
      catch (IOException e) {
        throw new IOException("*** error during resource file copy " +
                              outputFile.getAbsolutePath() + ": " +
                              e.getMessage());
      }
      finally {
        if (out != null) {
          out.close();
        }
        if (in != null) {
          in.close();
        }
      }
      return true;
    }

    // copyResource

    public static String readStringFromResource(String resource) throws java.io.
        IOException {
      InputStream in;

      byte[] buffer = new byte[512];
      int len;
      StringBuffer result = new StringBuffer();

      // attempt
      try {
        if ( (in = DiskIO.getResourceStream(resource)) == null) {
          return "";
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String nextLine = reader.readLine();

        while (nextLine != null) {
          result.append(nextLine);
          result.append("\n");
          nextLine = reader.readLine();
        }

        in.close();
      }
      catch (IOException e) {
        e.printStackTrace();
        throw e;
      }

      return result.toString();
    }

    /** Results equal <code>copyResource ( String resource, new File (outputFile) )</code>.
     */
    public static boolean copyResource(String resource, String outputFile) throws
        java.io.IOException {
      return copyResource(resource, new File(outputFile));
    }

    public static void copyFile(String inputFile, String outputFile) throws
        java.io.IOException {
      copyFile(new File(inputFile), new File(outputFile));
    }

    public static void moveFile(String inputFile, String outputFile) throws
        java.io.IOException {
      copyFile(inputFile, outputFile);
      deleteFile(inputFile);
    }

    /**
     * 重命文件�???
     */
    public static void renameTo(String inputFile, String outputFile) throws
        java.io.IOException {
      renameTo(new File(inputFile), new File(outputFile));
    }

    public static void renameTo(File inputFile, File outputFile) throws
        java.io.IOException {
      inputFile.renameTo(outputFile);
    }

    /**
     * 判断目录是否为空，如果为空，则删除空目录
     */
    public static void directory(String path) {
      File dir = new File(path);
      if (dir.isDirectory()) {
        String[] str = dir.list();
        if (str.length > 0) {
          
        }
        else {
          deleteDirectory(dir);
        }
      }
    }

    /**
     * 删除指定目录下所有文�???
     */
    public static boolean delete(File directory) {
      boolean result = false;
      if (directory != null && directory.isDirectory()) {
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
          if (files[i].isDirectory()) {
            delete(files[i]);
          }
          files[i].delete();
        }
        result = directory.delete();
      }
      return result;
    }
}