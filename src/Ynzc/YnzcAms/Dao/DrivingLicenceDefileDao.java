package Ynzc.YnzcAms.Dao;
/**
 * 污损换证Dao
 * @author zy
 * @date 2011-04-26
 * class DriverStrInfoDao.java
 */
import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceDefile;
import Ynzc.YnzcAms.Model.DrivingLicenceDefileView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceDefileDao {
	/**
	 * 分页获得污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceDefileView> getAllDrivingLicenceDefile(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceDefileView> getAllDrivingLicenceDefileQuery(Page page,String conditions,String regionId);
	/**
	 * 获得污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceDefile> getAllDrivingLicenceDefile();
	/**
	 * 查找污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceDefile findDrivingLicenceDefileByid(int id);
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceDefileView> findDrivingLicenceDefileViewById(int id);
	/**
	 * 添加污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceDefile(DrivingLicenceDefile model);
	/**
	 * 删除污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceDefile(DrivingLicenceDefile model);
	/**
	 * 更改污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceDefile(DrivingLicenceDefile model);
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceDefileState(String ids,int state);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceDefile(String ids);
}
