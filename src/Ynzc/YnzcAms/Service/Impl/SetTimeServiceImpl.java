package Ynzc.YnzcAms.Service.Impl;

import Ynzc.YnzcAms.Dao.SetTimeDao;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Service.SetTimeService;

public class SetTimeServiceImpl implements SetTimeService {
	private SetTimeDao setTimeDao;

	public SetTimeDao getSetTimeDao() {
		return setTimeDao;
	}
	public void setSetTimeDao(SetTimeDao setTimeDao) {
		this.setTimeDao = setTimeDao;
	}

	public boolean updateSetTime(SetTime settime) {
		// TODO Auto-generated method stub
		return setTimeDao.updateSetTime(settime);
	}
	public SetTime findSetTimeByUnitId(int unitId) {
		// TODO Auto-generated method stub
		return setTimeDao.findSetTimeByUnitId(unitId);
	}
	public boolean saveSetTime(SetTime model) {
		// TODO Auto-generated method stub
		return setTimeDao.saveSetTime(model);
	}

}
