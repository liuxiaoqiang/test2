package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.*;

public interface DrivertrainingService {
	public boolean addDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo);
	public boolean deleteDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo);
	public boolean updateDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo);
	public DrivertrainingInfo FindById(int id);
	public List<DrivertrainingView> getDrivertrainingInfoAll(Page page,String conditions,int userid);
	public DrivertraingTractorinfoView getDrivertraingTractorinfoView(String carCode,int userid);
	public DrivertraingTractorinfoView FindDrivertraingTractorinfoViewById(int id);
	public List<DrivertrainingInfoView> getDrivertrainingInfoViewAll(Page page,String conditions,int userid);
	public DrivertrainingInfo findDrivertrainingInfoViewByCarNum(String carnum,int userid);
}
