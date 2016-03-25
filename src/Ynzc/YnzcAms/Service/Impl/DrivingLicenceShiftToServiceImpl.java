package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceShiftToDao;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftTo;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftToView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorLicenseOutNoticeSource;
import Ynzc.YnzcAms.Service.DrivingLicenceShiftToService;

public class DrivingLicenceShiftToServiceImpl implements
		DrivingLicenceShiftToService {
	private DrivingLicenceShiftToDao drivingLicenceShiftToDao;
	public DrivingLicenceShiftToDao getDrivingLicenceShiftToDao() {
		return drivingLicenceShiftToDao;
	}
	public void setDrivingLicenceShiftToDao(DrivingLicenceShiftToDao drivingLicenceShiftToDao) {
		this.drivingLicenceShiftToDao = drivingLicenceShiftToDao;
	}
	/**
	 * 分页获得驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceShiftToView> getAllDrivingLicenceShiftTo(Page page,String conditions,String regionId){
		return drivingLicenceShiftToDao.getAllDrivingLicenceShiftTo(page, conditions,regionId);
	}
	/**
	 * 获得驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceShiftTo> getAllDrivingLicenceShiftTo(){
		return drivingLicenceShiftToDao.getAllDrivingLicenceShiftTo();
	}
	/**
	 * 查找驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceShiftTo findDrivingLicenceShiftToById(int id){
		return drivingLicenceShiftToDao.findDrivingLicenceShiftToById(id);
	}
	/**
	 * 添加驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceShiftTo(DrivingLicenceShiftTo model){
		return drivingLicenceShiftToDao.addDrivingLicenceShiftTo(model);
	}
	/**
	 * 删除驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceShiftTo(DrivingLicenceShiftTo model){
		return drivingLicenceShiftToDao.delDrivingLicenceShiftTo(model);
	}
	/**
	 * 更改驾驶员转出
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceShiftTo(DrivingLicenceShiftTo model){
		return drivingLicenceShiftToDao.updateDrivingLicenceShiftTo(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceShiftToState(String ids, int state){
		return drivingLicenceShiftToDao.drivingLicenceShiftToState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceShiftTo(String ids){
		return drivingLicenceShiftToDao.delDrivingLicenceShiftTo(ids);
	}
	public List<DrivingLicenceShiftToView> findDrivingLicenceShiftToViewById(
			int id) {
		// TODO Auto-generated method stub
		return drivingLicenceShiftToDao.findDrivingLicenceShiftToViewById(id);
	}
	public List<TractorLicenseOutNoticeSource> tractorLicenseOutNotice(int id) {
		// TODO Auto-generated method stub
		return drivingLicenceShiftToDao.tractorLicenseOutNotice(id);
	}
	public List<DrivingLicenceShiftToView> getAllDrivingLicenceShiftToQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceShiftToDao.getAllDrivingLicenceShiftToQuery(page,conditions,regionId);
	}
}
