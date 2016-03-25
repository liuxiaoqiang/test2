package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DriverClassInfoDao;
import Ynzc.YnzcAms.Model.DriverClassInfo;
import Ynzc.YnzcAms.Model.DriverClassStrView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DriverClassInfoService;

public class DriverClassInfoServiceImpl implements DriverClassInfoService {

	private DriverClassInfoDao driverClassInfoDao;
	public DriverClassInfoDao getDriverClassInfoDao() {
		return driverClassInfoDao;
	}
	public void setDriverClassInfoDao(DriverClassInfoDao driverClassInfoDao) {
		this.driverClassInfoDao = driverClassInfoDao;
	}
	/**
	 * 分页获得班级
	 * @author zy
	 * @date 2011-05-05
	 **/
	public List<DriverClassInfo> getAllDriverClassInfo(Page page,String conditions,String regionId){
		return driverClassInfoDao.getAllDriverClassInfo(page, conditions,regionId);
	}
	/**
	 * 获得班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassInfo> getAllDriverClassInfo(){
		return driverClassInfoDao.getAllDriverClassInfo();
	}
	/**
	 * 查找班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverClassInfo findDriverClassInfoById(int id){
		return driverClassInfoDao.findDriverClassInfoById(id);
	}
	/**
	 * 查找班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverClassInfo findDriverClassInfoByName(String name,String regionId){
		return driverClassInfoDao.findDriverClassInfoByName(name,regionId);
	}
	/**
	 * 添加班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverClassInfo(DriverClassInfo model){
		return driverClassInfoDao.addDriverClassInfo(model);
	}
	/**
	 * 删除班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverClassInfo(DriverClassInfo model){
		return driverClassInfoDao.delDriverClassInfo(model);
	}
	/**
	 * 更改班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverClassInfo(DriverClassInfo model){
		return driverClassInfoDao.updateDriverClassInfo(model);
	}
	/**
	 * 班级审核
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean driverClassInfoDeclare(int type,int classState,String driverClassInfoId){
		return driverClassInfoDao.driverClassInfoDeclare(type,classState,driverClassInfoId);
	}
	/**
	 * 班级学员审核check
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean driverClassInfoDeclare(int driverClassInfoId){
		return driverClassInfoDao.driverClassInfoDeclare(driverClassInfoId);
	}
	/**
	 * 分页获得班级
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassInfo> getAllDriverClassInfoPass(Page page,String conditions,String regionId){
		return driverClassInfoDao.getAllDriverClassInfoPass(page,conditions,regionId);
	}
	/**
	 * 分页获得学员信息
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverClassStrView> getAllDriverClassInfoByDriverClassId(Page page,String conditions,int driverClassId){
		return driverClassInfoDao.getAllDriverClassInfoByDriverClassId(page, conditions,driverClassId);
	}
	public List<DriverClassStrView> getAllDriverClassInfoByDriverClassIdQuery(
			Page page, String conditions, int driverClassId) {
		// TODO Auto-generated method stub
		return driverClassInfoDao.getAllDriverClassInfoByDriverClassId(page, conditions,driverClassId);
	}

}
