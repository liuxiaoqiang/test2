package Ynzc.YnzcAms.Dao;

import Ynzc.YnzcAms.Model.SetTime;

public interface SetTimeDao {
	public boolean updateSetTime(SetTime settime);
	
	public SetTime findSetTimeByUnitId(int unitId);
	
	public boolean saveSetTime(SetTime model);
}
