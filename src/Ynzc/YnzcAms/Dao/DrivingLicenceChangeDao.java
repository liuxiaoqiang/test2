package Ynzc.YnzcAms.Dao;
/**
 * 信息变化换证Dao
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceChangeDao.java
 */
import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceChange;
import Ynzc.YnzcAms.Model.DrivingLicenceChangeView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivingLicenceChangeDao {
	/**
	 * 分页获得信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceChangeView> getAllDrivingLicenceChange(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceChangeView> getAllDrivingLicenceChangeQuery(Page page,String conditions,String regionId);
	/**
	 * 获得信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceChange> getAllDDrivingLicenceChange();
	/**
	 * 查找信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceChange findDrivingLicenceChangeById(int id);
	/**
	 * 查找信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceChangeView> findDrivingLicenceChangeViewById(int id);
	/**
	 * 添加信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceChange(DrivingLicenceChange model);
	/**
	 * 删除信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceChange(DrivingLicenceChange model);
	/**
	 * 更改信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceChange(DrivingLicenceChange model);
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceChangeState(String ids,int state);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceChangeState(String ids);
}
