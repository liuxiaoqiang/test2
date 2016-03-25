package Ynzc.YnzcAms.Dao;
/**
 * 驾驶员转出Dao
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceShiftToDao.java
 */
import java.util.List;

import Ynzc.YnzcAms.Model.DrivingLicenceShiftTo;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftToView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorLicenseOutNoticeSource;

public interface DrivingLicenceShiftToDao {
	/**
	 * 分页获得驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceShiftToView> getAllDrivingLicenceShiftTo(Page page,String conditions,String regionId);
	
	public List<DrivingLicenceShiftToView> getAllDrivingLicenceShiftToQuery(Page page,String conditions,String regionId);
	/**
	 * 分页获得驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceShiftToView> findDrivingLicenceShiftToViewById(int id);
	/**
	 * 获得驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceShiftTo> getAllDrivingLicenceShiftTo();
	/**
	 * 查找驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceShiftTo findDrivingLicenceShiftToById(int id);
	/**
	 * 添加驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceShiftTo(DrivingLicenceShiftTo model);
	/**
	 * 删除驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceShiftTo(DrivingLicenceShiftTo model);
	/**
	 * 更改驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceShiftTo(DrivingLicenceShiftTo model);
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceShiftToState(String ids, int state);
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceShiftTo(String ids);
	
	public List<TractorLicenseOutNoticeSource> tractorLicenseOutNotice(int id);
}
