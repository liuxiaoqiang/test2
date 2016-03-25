package Ynzc.Util;

import java.io.Serializable;

/** 
 * 单例的计数器 
 */
public class OnlineCounter implements Serializable {
  /* 
   * 在线人数 
   */
  private static int online = 0;

  /** 
   * 获得在线人数 
   * @return 
   * @author chinakite zhang 
   * @version 1.0 
   * <pre> 
   * Created on :Jul 7, 2005 9:22:38 AM 
   * LastModified: 
   * History: 
   * </pre> 
   */
  public static int getOnline() {
    return online;
  }

  /** 
   * 在线人数�?1 
   * 
   * @author chinakite zhang 
   * @version 1.0 
   * <pre> 
   * Created on :Jul 7, 2005 9:22:50 AM 
   * LastModified: 
   * History: 
   * </pre> 
   */
  public static void raise() {
    if (online < 0) {
      online = 0;
    }
    online++;
  }

  /** 
   * 在线人数�?1 
   * 
   * @author chinakite zhang 
   * @version 1.0 
   * <pre> 
   * Created on :Jul 7, 2005 9:23:09 AM 
   * LastModified: 
   * History: 
   * </pre> 
   */
  public static void reduce() {
    online--;
  }
}
