package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DriverMarkDao;
import Ynzc.YnzcAms.Model.DriverMark;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DriverMarkService;

public class DriverMarkServiceImpl implements DriverMarkService {
	private DriverMarkDao driverMarkDao;
	public DriverMarkDao getDriverMarkDao() {
		return driverMarkDao;
	}

	public void setDriverMarkDao(DriverMarkDao driverMarkDao) {
		this.driverMarkDao = driverMarkDao;
	}
	/**
	 * 分页获得驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverMark> getAllDriverMark(Page page,String conditions,String regionId){
		return driverMarkDao.getAllDriverMark(page, conditions,regionId);
	}
	/**
	 * 获得驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public List<DriverMark> getAllDriverMark(){
		return driverMarkDao.getAllDriverMark();
	}
	/**
	 * 查找驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public DriverMark findDriverMarkById(int id){
		return driverMarkDao.findDriverMarkById(id);
	}
	/**
	 * 添加驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean addDriverMark(DriverMark model){
		return driverMarkDao.addDriverMark(model);
	}
	/**
	 * 删除驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean delDriverMark(DriverMark model){
		return driverMarkDao.delDriverMark(model);
	}
	/**
	 * 更改驾照违章记录
	 * @author zy
	 * @date 2011-04-26
	 **/
	public boolean updateDriverMark(DriverMark model){
		return driverMarkDao.updateDriverMark(model);
	}
}
