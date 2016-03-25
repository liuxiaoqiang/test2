package Ynzc.YnzcAms.Service.Impl;

import Ynzc.YnzcAms.Dao.PlateHandleDao;
import Ynzc.YnzcAms.Model.PlateHandle;
import Ynzc.YnzcAms.Service.PlateHandleService;

public class PlateHandleServiceImpl implements PlateHandleService {
	
	private PlateHandleDao plateHandleDao;
	
	public PlateHandleDao getPlateHandleDao() {
		return plateHandleDao;
	}

	public void setPlateHandleDao(PlateHandleDao plateHandleDao) {
		this.plateHandleDao = plateHandleDao;
	}

	public boolean addPlateHandle(PlateHandle platehandle) {
		// TODO Auto-generated method stub
		return this.plateHandleDao.addPlateHandle(platehandle);
	}

}
