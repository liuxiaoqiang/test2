package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivingLicenceTypeDao;
import Ynzc.YnzcAms.Model.DrivingLicenceType;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivingLicenceTypeService;

public class DrivingLicenceTypeServiceImpl implements DrivingLicenceTypeService {
	private DrivingLicenceTypeDao drivingLicenceTypeDao;
	public DrivingLicenceTypeDao getDrivingLicenceTypeDao() {
		return drivingLicenceTypeDao;
	}
	public void setDrivingLicenceTypeDao(DrivingLicenceTypeDao drivingLicenceTypeDao) {
		this.drivingLicenceTypeDao = drivingLicenceTypeDao;
	}
	/**
	 * 分页获得驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceType> getAllDrivingLicenceType(Page page,String conditions){
		return drivingLicenceTypeDao.getAllDrivingLicenceType(page, conditions);
	}
	/**
	 * 获得驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DrivingLicenceType> getAllDrivingLicenceType(){
		return drivingLicenceTypeDao.getAllDrivingLicenceType();
	}
	/**
	 * 查找驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DrivingLicenceType findDrivingLicenceTypeById(int id){
		return drivingLicenceTypeDao.findDrivingLicenceTypeById(id);
	}
	/**
	 * 添加驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDrivingLicenceType(DrivingLicenceType model){
		return drivingLicenceTypeDao.addDrivingLicenceType(model);
	}
	/**
	 * 删除驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDrivingLicenceType(DrivingLicenceType model){
		return drivingLicenceTypeDao.delDrivingLicenceType(model);
	}
	/**
	 * 更改驾照类型
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDrivingLicenceType(DrivingLicenceType model){
		return drivingLicenceTypeDao.updateDrivingLicenceType(model);
	}
}
