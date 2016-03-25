package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UniteharvesterCheckDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCheck;
import Ynzc.YnzcAms.Model.UniteharvesterCheckView;
import Ynzc.YnzcAms.Service.UniteharvesterCheckService;

public class UniteharvesterCheckServiceImpl implements
		UniteharvesterCheckService {
	private UniteharvesterCheckDao uniteharvesterCheckDao;
	public UniteharvesterCheckDao getUniteharvesterCheckDao() {
		return uniteharvesterCheckDao;
	}

	public void setUniteharvesterCheckDao(
			UniteharvesterCheckDao uniteharvesterCheckDao) {
		this.uniteharvesterCheckDao = uniteharvesterCheckDao;
	}

	public boolean addUniteharvesterCheck(
			UniteharvesterCheck uniteharvesterCheck) {
		// TODO Auto-generated method stub
		return uniteharvesterCheckDao.addUniteharvesterCheck(uniteharvesterCheck);
	}

	public boolean delUniteharvesterCheck(
			UniteharvesterCheck uniteharvesterCheck) {
		// TODO Auto-generated method stub
		return uniteharvesterCheckDao.delUniteharvesterCheck(uniteharvesterCheck);
	}

	public boolean updateUniteharvesterCheck(
			UniteharvesterCheck uniteharvesterCheck) {
		// TODO Auto-generated method stub
		return uniteharvesterCheckDao.updateUniteharvesterCheck(uniteharvesterCheck);
	}

	public List<UniteharvesterCheckView> getUniteharvesterCheckAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterCheckDao.getUniteharvesterCheckAll(page, conditions, userid);
	}

}
