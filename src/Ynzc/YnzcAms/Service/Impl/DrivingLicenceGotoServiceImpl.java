package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceGotoDao;
import Ynzc.YnzcAms.Model.DrivingLicenceGoto;
import Ynzc.YnzcAms.Model.DrivingLicenceGotoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceGotoService;

public class DrivingLicenceGotoServiceImpl implements DrivingLicenceGotoService {
	private DrivingLicenceGotoDao drivingLicenceGotoDao;
	public DrivingLicenceGotoDao getDrivingLicenceGotoDao() {
		return drivingLicenceGotoDao;
	}
	public void setDrivingLicenceGotoDao(DrivingLicenceGotoDao drivingLicenceGotoDao) {
		this.drivingLicenceGotoDao = drivingLicenceGotoDao;
	}
	/**
	 * 分页获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceGotoView> getAllDrivingLicenceGoto(Page page,String conditions,String regionId){
		return drivingLicenceGotoDao.getAllDrivingLicenceGoto(page, conditions,regionId);
	}
	/**
	 * 获得驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceGoto> getAllDrivingLicenceGoto(){
		return drivingLicenceGotoDao.getAllDrivingLicenceGoto();
	}
	/**
	 * 查找驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceGoto findDrivingLicenceGotoById(int id){
		return drivingLicenceGotoDao.findDrivingLicenceGotoById(id);
	}
	/**
	 * 添加驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceGoto(DrivingLicenceGoto model){
		return drivingLicenceGotoDao.addDrivingLicenceGoto(model);
	}
	/**
	 * 删除驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceGoto(DrivingLicenceGoto model){
		return drivingLicenceGotoDao.delDrivingLicenceGoto(model);
	}
	/**
	 * 更改驾驶员注销
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceGoto(DrivingLicenceGoto model){
		return drivingLicenceGotoDao.updateDrivingLicenceGoto(model);
	}
	/**
	 * 批量修改状态
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicenceGotoState(String ids,int state){
		return drivingLicenceGotoDao.drivingLicenceGotoState(ids,state);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceGoto(String ids){
		return drivingLicenceGotoDao.delDrivingLicenceGoto(ids);
	}
	public List<DrivingLicenceGotoView> findDrivingLicenceGotoViewById(int id) {
		// TODO Auto-generated method stub
		return drivingLicenceGotoDao.findDrivingLicenceGotoViewById(id);
	}
	public List<DrivingLicenceGotoView> getAllDrivingLicenceGotoQuery(
			Page page, String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceGotoDao.getAllDrivingLicenceGotoQuery(page,conditions,regionId);
	}
}
