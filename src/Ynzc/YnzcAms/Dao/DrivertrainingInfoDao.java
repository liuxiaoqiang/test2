package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.DrivertraingTractorinfoView;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;
import Ynzc.YnzcAms.Model.DrivertrainingView;
import Ynzc.YnzcAms.Model.Page;

public interface DrivertrainingInfoDao {
	public boolean addDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo);
	public boolean deleteDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo);
	public boolean updateDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo);
	public DrivertrainingInfo FindById(int id);
	public DrivertraingTractorinfoView FindDrivertraingTractorinfoViewById(int id);
	public List<DrivertrainingView> getDrivertrainingInfoAll(Page page,String conditions,int userid);
	public DrivertraingTractorinfoView getDrivertraingTractorinfoView(String carCode,int userid);
	public List<DrivertrainingInfoView> getDrivertrainingInfoViewAll(Page page,String conditions,int userid);
	public DrivertrainingInfo findDrivertrainingInfoViewByCarNum(String carnum,int userid);
}
