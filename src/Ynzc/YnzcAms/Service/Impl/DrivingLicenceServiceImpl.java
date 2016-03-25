package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceDao;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceReportSource;
import Ynzc.YnzcAms.Model.DrivingLicenceView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceService;

public class DrivingLicenceServiceImpl implements DrivingLicenceService {
	private DrivingLicenceDao drivingLicenceDao;
	public DrivingLicenceDao getDrivingLicenceDao() {
		return drivingLicenceDao;
	}
	public void setDrivingLicenceDao(DrivingLicenceDao drivingLicenceDao) {
		this.drivingLicenceDao = drivingLicenceDao;
	}
	/**
	 * 分页获得驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceView> getAllDrivingLicence(Page page,String conditions,String regionId){
		return drivingLicenceDao.getAllDrivingLicence(page, conditions,regionId);
	}
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean findDrivingLicenceById(int peopleInfoId,int drivingLicenceType,String drivingLicenceNo){
		return drivingLicenceDao.findDrivingLicenceById(peopleInfoId,drivingLicenceType,drivingLicenceNo);
	}
	/**
	 * 批量打印
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean drivingLicencePutOut(String id){
		return drivingLicenceDao.drivingLicencePutOut(id);
	}
	/**
	 * 获得驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicence> getAllDrivingLicence(){
		return drivingLicenceDao.getAllDrivingLicence();
	}
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicence findDrivingLicenceById(int id){
		return drivingLicenceDao.findDrivingLicenceById(id);
	}
	/**
	 * 添加驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicence(DrivingLicence model){
		return drivingLicenceDao.addDrivingLicence(model);
	}
	/**
	 * 删除驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicence(DrivingLicence model){
		return drivingLicenceDao.delDrivingLicence(model);
	}
	/**
	 * 更改驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicence(DrivingLicence model){
		return drivingLicenceDao.updateDrivingLicence(model);
	}
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceView> findDrivingLicenceViewById(int id){
		return drivingLicenceDao.findDrivingLicenceViewById(id);
	}
	/**
	 * 查找驾照
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicence findDrivingLicenceByDrivingLicenceNo(String drivingLicenceNo){
		return drivingLicenceDao.findDrivingLicenceByDrivingLicenceNo(drivingLicenceNo);
	}
	/**
	 * 批量删除
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicence(String ids){
		return drivingLicenceDao.delDrivingLicence(ids);
	}
	/**
	 * 业务办理检查
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean checkDrivingLicenceOperation(String id){
		return drivingLicenceDao.checkDrivingLicenceOperation(id);
	}
	public List<DrivingLicenceReportSource> drivingLicenceReportSource(
			String id, String peopleInfoId, String drivingLicenceTypeId,int type) {
		// TODO Auto-generated method stub
		return drivingLicenceDao.drivingLicenceReportSource(id, peopleInfoId, drivingLicenceTypeId,type);
	}
	public boolean Expirydate() {
		// TODO Auto-generated method stub
		return drivingLicenceDao.Expirydate();
	}
	public List<DrivingLicenceView> getAllDrivingLicenceQuery(Page page,
			String conditions, String regionId) {
		// TODO Auto-generated method stub
		return drivingLicenceDao.getAllDrivingLicenceQuery(page, conditions, regionId);
	}
}
