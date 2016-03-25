package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceChangeDao;
import Ynzc.YnzcAms.Model.DrivingLicenceChange;
import Ynzc.YnzcAms.Model.DrivingLicenceChangeView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceChangeService;

public class DrivingLicenceChangeServiceImpl implements
		DrivingLicenceChangeService {
	private DrivingLicenceChangeDao drivingLicenceChangeDao;
	public DrivingLicenceChangeDao getDrivingLicenceChangeDao() {
		return drivingLicenceChangeDao;
	}
	public void setDrivingLicenceChangeDao(
			DrivingLicenceChangeDao drivingLicenceChangeDao) {
		this.drivingLicenceChangeDao = drivingLicenceChangeDao;
	}
	/**
	 * 分页获得信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceChangeView> getAllDrivingLicenceChange(Page page,String conditions,String regionId){
		return drivingLicenceChangeDao.getAllDrivingLicenceChange(page, conditions,regionId);
	}
	/**
	 * 获得信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceChange> getAllDDrivingLicenceChange(){
		return drivingLicenceChangeDao.getAllDDrivingLicenceChange();
	}
	/**
	 * 查找信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceChange findDrivingLicenceChangeById(int id){
		return drivingLicenceChangeDao.findDrivingLicenceChangeById(id);
	}
	/**
	 * 添加信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceChange(DrivingLicenceChange model){
		return drivingLicenceChangeDao.addDrivingLicenceChange(model);
	}
	/**
	 * 删除信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceChange(DrivingLicenceChange model){
		return drivingLicenceChangeDao.delDrivingLicenceChange(model);
	}
	/**
	 * 更改信息变化换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceChange(DrivingLicenceChange model){
		return drivingLicenceChangeDao.updateDrivingLicenceChange(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceChangeState(String ids,int state){
		return drivingLicenceChangeDao.drivingLicenceChangeState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceChange(String ids){
		return drivingLicenceChangeDao.delDrivingLicenceChangeState(ids);
	}
	public boolean delDrivingLicenceChangeState(String ids) {
		// TODO Auto-generated method stub
		return drivingLicenceChangeDao.delDrivingLicenceChangeState(ids);
	}
	public List<DrivingLicenceChangeView> findDrivingLicenceChangeViewById(
			int id) {
		// TODO Auto-generated method stub
		return drivingLicenceChangeDao.findDrivingLicenceChangeViewById(id);
	}
	public List<DrivingLicenceChangeView> getAllDrivingLicenceChangeQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceChangeDao.getAllDrivingLicenceChangeQuery(page,conditions,regionId);
	}
}
