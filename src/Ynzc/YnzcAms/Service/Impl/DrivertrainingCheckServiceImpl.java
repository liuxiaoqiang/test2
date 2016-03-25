package Ynzc.YnzcAms.Service.Impl;

import Ynzc.YnzcAms.Dao.DrivertrainingCheckInfoDao;
import Ynzc.YnzcAms.Model.DrivertrainingCheckInfo;
import Ynzc.YnzcAms.Service.DrivertrainingCheckService;

public class DrivertrainingCheckServiceImpl implements
		DrivertrainingCheckService {
	private DrivertrainingCheckInfoDao drivertrainingCheckInfoDao;
	
	public DrivertrainingCheckInfoDao getDrivertrainingCheckInfoDao() {
		return drivertrainingCheckInfoDao;
	}

	public void setDrivertrainingCheckInfoDao(
			DrivertrainingCheckInfoDao drivertrainingCheckInfoDao) {
		this.drivertrainingCheckInfoDao = drivertrainingCheckInfoDao;
	}

	public boolean addDrivertrainingCheckInfo(
			DrivertrainingCheckInfo drivertrainingCheckInfo) {
		// TODO Auto-generated method stub
		return drivertrainingCheckInfoDao.addDrivertrainingCheckInfo(drivertrainingCheckInfo);
	}

	public boolean deleteDrivertrainingCheckInfo(
			DrivertrainingCheckInfo drivertrainingCheckInfo) {
		// TODO Auto-generated method stub
		return drivertrainingCheckInfoDao.deleteDrivertrainingCheckInfo(drivertrainingCheckInfo);
	}

	public boolean updateDrivertrainingCheckInfo(
			DrivertrainingCheckInfo drivertrainingCheckInfo) {
		// TODO Auto-generated method stub
		return drivertrainingCheckInfoDao.updateDrivertrainingCheckInfo(drivertrainingCheckInfo);
	}

	public DrivertrainingCheckInfo fingDrivertrainingCheckInfoById(int id) {
		// TODO Auto-generated method stub
		return drivertrainingCheckInfoDao.fingDrivertrainingCheckInfoById(id);
	}

}
