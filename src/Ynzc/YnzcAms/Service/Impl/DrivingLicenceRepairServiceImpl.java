package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceRepairDao;
import Ynzc.YnzcAms.Model.DrivingLicenceRepair;
import Ynzc.YnzcAms.Model.DrivingLicenceRepairView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceRepairService;

public class DrivingLicenceRepairServiceImpl implements
		DrivingLicenceRepairService {
	private DrivingLicenceRepairDao drivingLicenceRepairDao;
	public DrivingLicenceRepairDao getDrivingLicenceRepairDao() {
		return drivingLicenceRepairDao;
	}
	public void setDrivingLicenceRepairDao(DrivingLicenceRepairDao drivingLicenceRepairDao) {
		this.drivingLicenceRepairDao = drivingLicenceRepairDao;
	}
	/**
	 * 分页获得驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceRepairView> getAllDrivingLicenceRepair(Page page,String conditions,String regionId){
		return drivingLicenceRepairDao.getAllDrivingLicenceRepair(page, conditions,regionId);
	}
	/**
	 * 获得驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceRepair> getAllDrivingLicenceRepair(){
		return drivingLicenceRepairDao.getAllDrivingLicenceRepair();
	}
	/**
	 * 查找驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceRepair findDrivingLicenceRepairById(int id){
		return drivingLicenceRepairDao.findDrivingLicenceRepairById(id);
	}
	/**
	 * 添加驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceRepair(DrivingLicenceRepair model){
		return drivingLicenceRepairDao.addDrivingLicenceRepair(model);
	}
	/**
	 * 删除驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceRepair(DrivingLicenceRepair model){
		return drivingLicenceRepairDao.delDrivingLicenceRepair(model);
	}
	/**
	 * 更改驾驶员补证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceRepair(DrivingLicenceRepair model){
		return drivingLicenceRepairDao.updateDrivingLicenceRepair(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceRepairState(String ids,int state){
		return drivingLicenceRepairDao.drivingLicenceRepairState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceRepair(String ids){
		return drivingLicenceRepairDao.delDrivingLicenceRepair(ids);
	}
	public List<DrivingLicenceRepairView> findDrivingLicenceRepairViewById(
			int id) {
		// TODO Auto-generated method stub
		return drivingLicenceRepairDao.findDrivingLicenceRepairViewById(id);
	}
	public List<DrivingLicenceRepairView> getAllDrivingLicenceRepairQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceRepairDao.getAllDrivingLicenceRepairQuery(page,conditions,regionId);
	}
}
