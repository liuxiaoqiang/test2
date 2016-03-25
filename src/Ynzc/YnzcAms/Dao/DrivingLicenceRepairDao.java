package Ynzc.YnzcAms.Dao;
/**
 * 驾驶员补证Dao
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceRepairDao.java
 */
import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceRepair;
import Ynzc.YnzcAms.Model.DrivingLicenceRepairView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceRepairDao {
	/**
	 * 分页获得驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceRepairView> getAllDrivingLicenceRepair(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceRepairView> getAllDrivingLicenceRepairQuery(Page page,String conditions,String regionId);
	/**
	 * 获得驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceRepair> getAllDrivingLicenceRepair();
	/**
	 * 查找驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceRepair findDrivingLicenceRepairById(int id);
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceRepairView> findDrivingLicenceRepairViewById(int id);
	/**
	 * 添加驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceRepair(DrivingLicenceRepair model);
	/**
	 * 删除驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceRepair(DrivingLicenceRepair model);
	/**
	 * 更改驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceRepair(DrivingLicenceRepair model);
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceRepairState(String ids,int state);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceRepair(String ids);
}
