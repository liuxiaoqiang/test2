package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceLogoutDao;
import Ynzc.YnzcAms.Model.DrivingLicenceLogout;
import Ynzc.YnzcAms.Model.DrivingLicenceLogoutView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceLogoutService;

public class DrivingLicenceLogoutServiceImpl implements
		DrivingLicenceLogoutService {
	private DrivingLicenceLogoutDao drivingLicenceLogoutDao;
	public DrivingLicenceLogoutDao getDrivingLicenceLogoutDao() {
		return drivingLicenceLogoutDao;
	}
	public void setDrivingLicenceLogoutDao(DrivingLicenceLogoutDao drivingLicenceLogoutDao) {
		this.drivingLicenceLogoutDao = drivingLicenceLogoutDao;
	}
	/**
	 * 分页获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceLogoutView> getAllDrivingLicenceLogout(Page page,String conditions,String regionId){
		return drivingLicenceLogoutDao.getAllDrivingLicenceLogout(page, conditions,regionId);
	}
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceLogout> getAllDrivingLicenceLogout(){
		return drivingLicenceLogoutDao.getAllDrivingLicenceLogout();
	}
	/**
	 * 查找驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceLogout findDrivingLicenceLogoutById(int id){
		return drivingLicenceLogoutDao.findDrivingLicenceLogoutById(id);
	}
	/**
	 * 添加驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceLogout(DrivingLicenceLogout model){
		return drivingLicenceLogoutDao.addDrivingLicenceLogout(model);
	}
	/**
	 * 删除驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceLogout(DrivingLicenceLogout model){
		return drivingLicenceLogoutDao.delDrivingLicenceLogout(model);
	}
	/**
	 * 更改驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceLogout(DrivingLicenceLogout model){
		return drivingLicenceLogoutDao.updateDrivingLicenceLogout(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceLogoutState(String ids,int state){
		return drivingLicenceLogoutDao.drivingLicenceLogoutState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceLogout(String ids){
		return drivingLicenceLogoutDao.delDrivingLicenceLogout(ids);
	}
	public List<DrivingLicenceLogoutView> findDrivingLicenceLogoutViewById(
			int id) {
		// TODO Auto-generated method stub
		return drivingLicenceLogoutDao.findDrivingLicenceLogoutViewById(id);
	}
	public List<DrivingLicenceLogoutView> getAllDrivingLicenceLogoutQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceLogoutDao.getAllDrivingLicenceLogoutQuery(page,conditions,regionId);
	}
}
