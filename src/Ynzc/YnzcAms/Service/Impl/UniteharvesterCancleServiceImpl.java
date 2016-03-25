package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UniteharvesterCancleDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCancle;
import Ynzc.YnzcAms.Model.UniteharvesterCancleView;
import Ynzc.YnzcAms.Service.UniteharvesterCancleService;

public class UniteharvesterCancleServiceImpl implements
		UniteharvesterCancleService {
	private UniteharvesterCancleDao uniteharvesterCancleDao;
	public UniteharvesterCancleDao getUniteharvesterCancleDao() {
		return uniteharvesterCancleDao;
	}

	public void setUniteharvesterCancleDao(
			UniteharvesterCancleDao uniteharvesterCancleDao) {
		this.uniteharvesterCancleDao = uniteharvesterCancleDao;
	}

	public boolean addUniteharvesterCancle(
			UniteharvesterCancle uniteharvesterCancle) {
		// TODO Auto-generated method stub
		return uniteharvesterCancleDao.addUniteharvesterCancle(uniteharvesterCancle);
	}

	public boolean delUniteharvesterCancle(
			UniteharvesterCancle uniteharvesterCancle) {
		// TODO Auto-generated method stub
		return uniteharvesterCancleDao.delUniteharvesterCancle(uniteharvesterCancle);
	}

	public boolean updateUniteharvesterCancle(
			UniteharvesterCancle uniteharvesterCancle) {
		// TODO Auto-generated method stub
		return uniteharvesterCancleDao.updateUniteharvesterCancle(uniteharvesterCancle);
	}

	public List<UniteharvesterCancleView> getUniteharvesterCancleAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterCancleDao.getUniteharvesterCancleAll(page, conditions, userid);
	}

}
