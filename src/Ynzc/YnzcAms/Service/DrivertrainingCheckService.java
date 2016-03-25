package Ynzc.YnzcAms.Service;

import Ynzc.YnzcAms.Model.DrivertrainingCheckInfo;

public interface DrivertrainingCheckService {
	public boolean addDrivertrainingCheckInfo(DrivertrainingCheckInfo drivertrainingCheckInfo);
	public boolean deleteDrivertrainingCheckInfo(DrivertrainingCheckInfo drivertrainingCheckInfo);
	public boolean updateDrivertrainingCheckInfo(DrivertrainingCheckInfo drivertrainingCheckInfo);
	public DrivertrainingCheckInfo fingDrivertrainingCheckInfoById(int id);
}
