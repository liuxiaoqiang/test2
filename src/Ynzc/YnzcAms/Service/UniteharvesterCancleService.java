package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCancle;
import Ynzc.YnzcAms.Model.UniteharvesterCancleView;

public interface UniteharvesterCancleService {
	public boolean addUniteharvesterCancle(UniteharvesterCancle uniteharvesterCancle);
	public boolean delUniteharvesterCancle(UniteharvesterCancle uniteharvesterCancle);
	public boolean updateUniteharvesterCancle(UniteharvesterCancle uniteharvesterCancle);
	public List<UniteharvesterCancleView> getUniteharvesterCancleAll(Page page,String conditions,int userid);
}
