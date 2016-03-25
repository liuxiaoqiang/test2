package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceDefileDao;
import Ynzc.YnzcAms.Model.DrivingLicenceDefile;
import Ynzc.YnzcAms.Model.DrivingLicenceDefileView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceDefileService;

public class DrivingLicenceDefileServiceImpl implements
		DrivingLicenceDefileService {
	private DrivingLicenceDefileDao drivingLicenceDefileDao;
	public DrivingLicenceDefileDao getDrivingLicenceDefileDao() {
		return drivingLicenceDefileDao;
	}
	public void setDrivingLicenceDefileDao(
			DrivingLicenceDefileDao drivingLicenceDefileDao) {
		this.drivingLicenceDefileDao = drivingLicenceDefileDao;
	}
	/**
	 * 分页获得污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceDefileView> getAllDrivingLicenceDefile(Page page,String conditions,String regionId){
		return drivingLicenceDefileDao.getAllDrivingLicenceDefile(page, conditions,regionId);
	}
	/**
	 * 获得污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceDefile> getAllDrivingLicenceDefile(){
		return drivingLicenceDefileDao.getAllDrivingLicenceDefile();
	}
	/**
	 * 查找污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceDefile findDrivingLicenceDefileByid(int id){
		return drivingLicenceDefileDao.findDrivingLicenceDefileByid(id);
	}
	/**
	 * 添加污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceDefile(DrivingLicenceDefile model){
		return drivingLicenceDefileDao.addDrivingLicenceDefile(model);
	}
	/**
	 * 删除污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceDefile(DrivingLicenceDefile model){
		return drivingLicenceDefileDao.delDrivingLicenceDefile(model);
	}
	/**
	 * 更改污损换证
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceDefile(DrivingLicenceDefile model){
		return drivingLicenceDefileDao.updateDrivingLicenceDefile(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceDefileState(String ids,int state){
		return drivingLicenceDefileDao.drivingLicenceDefileState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceDefile(String ids){
		return drivingLicenceDefileDao.delDrivingLicenceDefile(ids);
	}
	public List<DrivingLicenceDefileView> findDrivingLicenceDefileViewById(
			int id) {
		// TODO Auto-generated method stub
		return drivingLicenceDefileDao.findDrivingLicenceDefileViewById(id);
	}
	public List<DrivingLicenceDefileView> getAllDrivingLicenceDefileQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceDefileDao.getAllDrivingLicenceDefileQuery(page,conditions,regionId);
	}
}
