package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceTermDao;
import Ynzc.YnzcAms.Model.DrivingLicenceTerm;
import Ynzc.YnzcAms.Model.DrivingLicenceTermView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceTermService;

public class DrivingLicenceTermServiceImpl implements DrivingLicenceTermService {
	private DrivingLicenceTermDao drivingLicenceTermDao;
	public DrivingLicenceTermDao getDrivingLicenceTermDao() {
		return drivingLicenceTermDao;
	}
	public void setDrivingLicenceTermDao(DrivingLicenceTermDao drivingLicenceTermDao) {
		this.drivingLicenceTermDao = drivingLicenceTermDao;
	}
	/**
	 * 分页获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceTermView> getAllDrivingLicenceTerm(Page page,String conditions,String regionId){
		return drivingLicenceTermDao.getAllDrivingLicenceTerm(page, conditions,regionId);
	}
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceTerm> getAllDrivingLicenceTerm(){
		return drivingLicenceTermDao.getAllDrivingLicenceTerm();
	}
	/**
	 * 查找驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceTerm findDrivingLicenceTermById(int id){
		return drivingLicenceTermDao.findDrivingLicenceTermById(id);
	}
	/**
	 * 添加驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceTerm(DrivingLicenceTerm model){
		return drivingLicenceTermDao.addDrivingLicenceTerm(model);
	}
	/**
	 * 删除驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceTerm(DrivingLicenceTerm model){
		return drivingLicenceTermDao.delDrivingLicenceTerm(model);
	}
	/**
	 * 更改驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceTerm(DrivingLicenceTerm model){
		return drivingLicenceTermDao.updateDrivingLicenceTerm(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceTermState(String ids,int state){
		return drivingLicenceTermDao.drivingLicenceTermState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceTerm(String ids){
		return drivingLicenceTermDao.delDrivingLicenceTerm(ids);
	}
	public List<DrivingLicenceTermView> findDrivingLicenceTermViewById(int id) {
		// TODO Auto-generated method stub
		return drivingLicenceTermDao.findDrivingLicenceTermViewById(id);
	}
	public List<DrivingLicenceTermView> getAllDrivingLicenceTermQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceTermDao.getAllDrivingLicenceTermQuery(page,conditions,regionId);
	}
}
