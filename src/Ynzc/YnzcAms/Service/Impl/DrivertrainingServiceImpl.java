package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.DrivertrainingInfoDao;
import Ynzc.YnzcAms.Model.DrivertraingTractorinfoView;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;
import Ynzc.YnzcAms.Model.DrivertrainingView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.DrivertrainingService;

public class DrivertrainingServiceImpl implements DrivertrainingService {
	private DrivertrainingInfoDao drivertrainingInfoDao;

	public boolean addDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.addDrivertrainingInfo(drivertrainingInfo);
	}


	public DrivertrainingInfoDao getDrivertrainingInfoDao() {
		return drivertrainingInfoDao;
	}


	public void setDrivertrainingInfoDao(DrivertrainingInfoDao drivertrainingInfoDao) {
		this.drivertrainingInfoDao = drivertrainingInfoDao;
	}


	public boolean deleteDrivertrainingInfo(
			DrivertrainingInfo drivertrainingInfo) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.deleteDrivertrainingInfo(drivertrainingInfo);
	}


	public boolean updateDrivertrainingInfo(
			DrivertrainingInfo drivertrainingInfo) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.updateDrivertrainingInfo(drivertrainingInfo);
	}

	public DrivertrainingInfo FindById(int id) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.FindById(id);
	}

	public List<DrivertrainingView> getDrivertrainingInfoAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.getDrivertrainingInfoAll(page, conditions,userid);
	}

	public DrivertraingTractorinfoView getDrivertraingTractorinfoView(
			String carCode, int userid) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.getDrivertraingTractorinfoView(carCode,userid);
	}

	public DrivertraingTractorinfoView FindDrivertraingTractorinfoViewById(
			int id) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.FindDrivertraingTractorinfoViewById(id);
	}

	public List<DrivertrainingInfoView> getDrivertrainingInfoViewAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.getDrivertrainingInfoViewAll(page, conditions,userid);
	}

	public DrivertrainingInfo findDrivertrainingInfoViewByCarNum(String carnum,
			int userid) {
		// TODO Auto-generated method stub
		return drivertrainingInfoDao.findDrivertrainingInfoViewByCarNum(carnum, userid);
	}

}
