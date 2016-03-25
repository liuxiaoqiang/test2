package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UniteharvesterRepairDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterRepair;
import Ynzc.YnzcAms.Model.UniteharvesterRepairView;
import Ynzc.YnzcAms.Service.UniteharvesterRepairService;

public class UniteharvesterRepairServiceImpl implements
		UniteharvesterRepairService {
	private UniteharvesterRepairDao uniteharvesterRepairDao;
	public UniteharvesterRepairDao getUniteharvesterRepairDao() {
		return uniteharvesterRepairDao;
	}

	public void setUniteharvesterRepairDao(
			UniteharvesterRepairDao uniteharvesterRepairDao) {
		this.uniteharvesterRepairDao = uniteharvesterRepairDao;
	}
	public boolean addUniteharvesterRepair(
			UniteharvesterRepair uniteharvesterRepair) {
		// TODO Auto-generated method stub
		return uniteharvesterRepairDao.addUniteharvesterRepair(uniteharvesterRepair);
	}

	public boolean delUniteharvesterRepair(
			UniteharvesterRepair uniteharvesterRepair) {
		// TODO Auto-generated method stub
		return uniteharvesterRepairDao.delUniteharvesterRepair(uniteharvesterRepair);
	}

	public boolean updateUniteharvesterRepair(
			UniteharvesterRepair uniteharvesterRepair) {
		// TODO Auto-generated method stub
		return uniteharvesterRepairDao.updateUniteharvesterRepair(uniteharvesterRepair);
	}

	public List<UniteharvesterRepairView> getUniteharvesterRepairAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterRepairDao.getUniteharvesterRepairAll(page, conditions, userid);
	}

}
