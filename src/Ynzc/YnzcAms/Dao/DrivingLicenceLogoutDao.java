package Ynzc.YnzcAms.Dao;
/**
 * 驾驶员注销Dao
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceLogoutDao.java
 */
import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceLogout;
import Ynzc.YnzcAms.Model.DrivingLicenceLogoutView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceLogoutDao {
	/**
	 * 分页获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceLogoutView> getAllDrivingLicenceLogout(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceLogoutView> getAllDrivingLicenceLogoutQuery(Page page,String conditions,String regionId);
	/**
	 * 分页获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceLogoutView> findDrivingLicenceLogoutViewById(int id);
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceLogout> getAllDrivingLicenceLogout();
	/**
	 * 查找驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceLogout findDrivingLicenceLogoutById(int id);
	/**
	 * 添加驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceLogout(DrivingLicenceLogout model);
	/**
	 * 删除驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceLogout(DrivingLicenceLogout model);
	/**
	 * 更改驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceLogout(DrivingLicenceLogout model);
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceLogoutState(String ids,int state);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceLogout(String ids);
}
