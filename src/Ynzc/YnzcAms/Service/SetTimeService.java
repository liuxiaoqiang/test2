
package Ynzc.YnzcAms.Service;

import Ynzc.YnzcAms.Model.SetTime;

public interface SetTimeService {
	public boolean updateSetTime(SetTime settime);
	
	public SetTime findSetTimeByUnitId(int unitId);
	
	public boolean saveSetTime(SetTime model);
}
