package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterRepair;
import Ynzc.YnzcAms.Model.UniteharvesterRepairView;

public interface UniteharvesterRepairService {
	public boolean addUniteharvesterRepair(UniteharvesterRepair uniteharvesterRepair);
	public boolean delUniteharvesterRepair(UniteharvesterRepair uniteharvesterRepair);
	public boolean updateUniteharvesterRepair(UniteharvesterRepair uniteharvesterRepair);
	public List<UniteharvesterRepairView> getUniteharvesterRepairAll(Page page,String conditions,int userid);
}
