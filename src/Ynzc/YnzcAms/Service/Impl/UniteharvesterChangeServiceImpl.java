package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UniteharvesterChangeDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterChange;
import Ynzc.YnzcAms.Model.UniteharvesterChangeView;
import Ynzc.YnzcAms.Service.UniteharvesterChangeService;

public class UniteharvesterChangeServiceImpl implements
		UniteharvesterChangeService {
	private UniteharvesterChangeDao  uniteharvesterChangeDao;
	public UniteharvesterChangeDao getUniteharvesterChangeDao() {
		return uniteharvesterChangeDao;
	}

	public void setUniteharvesterChangeDao(
			UniteharvesterChangeDao uniteharvesterChangeDao) {
		this.uniteharvesterChangeDao = uniteharvesterChangeDao;
	}

	public boolean addUniteharvesterChange(
			UniteharvesterChange uniteharvesterChange) {
		// TODO Auto-generated method stub
		return uniteharvesterChangeDao.addUniteharvesterChange(uniteharvesterChange);
	}

	public boolean delUniteharvesterChange(
			UniteharvesterChange uniteharvesterChange) {
		// TODO Auto-generated method stub
		return uniteharvesterChangeDao.delUniteharvesterChange(uniteharvesterChange);
	}

	public boolean updateUniteharvesterChange(
			UniteharvesterChange uniteharvesterChange) {
		// TODO Auto-generated method stub
		return uniteharvesterChangeDao.updateUniteharvesterChange(uniteharvesterChange);
	}

	public List<UniteharvesterChangeView> getUniteharvesterChangeAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterChangeDao.getUniteharvesterChangeAll(page, conditions, userid);
	}

}
