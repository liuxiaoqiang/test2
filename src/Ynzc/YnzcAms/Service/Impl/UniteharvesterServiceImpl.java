package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UniteharvesterDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterView;
import Ynzc.YnzcAms.Service.UniteharvesterService;

public class UniteharvesterServiceImpl implements UniteharvesterService {
	private UniteharvesterDao uniteharvesterDao;
	public UniteharvesterDao getUniteharvesterDao() {
		return uniteharvesterDao;
	}

	public void setUniteharvesterDao(UniteharvesterDao uniteharvesterDao) {
		this.uniteharvesterDao = uniteharvesterDao;
	}

	public boolean addUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.addUniteharvester(uniteharvester);
	}

	public boolean delUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.delUniteharvester(uniteharvester);
	}

	public boolean updateUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.updateUniteharvester(uniteharvester);
	}

	public Uniteharvester findUniteharvesterById(int id) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.findUniteharvesterById(id);
	}

	public UniteharvesterView findUniteharvesterByCarNum(String carnum, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.findUniteharvesterByCarNum(carnum, userid);
	}

	public UniteharvesterView findUniteharvesterViewById(int id) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.findUniteharvesterViewById(id);
	}

	public List<UniteharvesterView> getUniteharvesterViewAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.getUniteharvesterViewAll(page, conditions, userid);
	}
	public boolean saveUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		return uniteharvesterDao.saveUniteharvester(uniteharvester);
	}

}
