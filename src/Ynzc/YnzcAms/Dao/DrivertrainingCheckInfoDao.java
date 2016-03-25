package Ynzc.YnzcAms.Dao;

import Ynzc.YnzcAms.Model.DrivertrainingCheckInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;

public interface DrivertrainingCheckInfoDao {
	public boolean addDrivertrainingCheckInfo(DrivertrainingCheckInfo drivertrainingCheckInfo);
	public boolean deleteDrivertrainingCheckInfo(DrivertrainingCheckInfo drivertrainingCheckInfo);
	public boolean updateDrivertrainingCheckInfo(DrivertrainingCheckInfo drivertrainingCheckInfo);
	public DrivertrainingCheckInfo fingDrivertrainingCheckInfoById(int id);
}
