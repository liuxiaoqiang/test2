package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterChange;
import Ynzc.YnzcAms.Model.UniteharvesterChangeView;

public interface UniteharvesterChangeService {
	public boolean addUniteharvesterChange(UniteharvesterChange uniteharvesterChange);
	public boolean delUniteharvesterChange(UniteharvesterChange uniteharvesterChange);
	public boolean updateUniteharvesterChange(UniteharvesterChange uniteharvesterChange);
	public List<UniteharvesterChangeView> getUniteharvesterChangeAll(Page page,String conditions,int userid);
}
