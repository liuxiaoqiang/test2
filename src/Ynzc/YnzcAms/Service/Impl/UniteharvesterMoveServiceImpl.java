package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UniteharvesterMoveDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterMove;
import Ynzc.YnzcAms.Model.UniteharvesterMoveView;
import Ynzc.YnzcAms.Service.UniteharvesterMoveService;

public class UniteharvesterMoveServiceImpl implements UniteharvesterMoveService {
	private UniteharvesterMoveDao uniteharvesterMoveDao;
	public UniteharvesterMoveDao getUniteharvesterMoveDao() {
		return uniteharvesterMoveDao;
	}

	public void setUniteharvesterMoveDao(UniteharvesterMoveDao uniteharvesterMoveDao) {
		this.uniteharvesterMoveDao = uniteharvesterMoveDao;
	}

	public boolean addUniteharvesterMove(UniteharvesterMove uniteharvesterMove) {
		// TODO Auto-generated method stub
		return uniteharvesterMoveDao.addUniteharvesterMove(uniteharvesterMove);
	}

	public boolean delUniteharvesterMove(UniteharvesterMove uniteharvesterMove) {
		// TODO Auto-generated method stub
		return uniteharvesterMoveDao.delUniteharvesterMove(uniteharvesterMove);
	}

	public boolean updateUniteharvesterMove(
			UniteharvesterMove uniteharvesterMove) {
		// TODO Auto-generated method stub
		return uniteharvesterMoveDao.updateUniteharvesterMove(uniteharvesterMove);
	}

	public List<UniteharvesterMoveView> getUniteharvesterMoveAll(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		return uniteharvesterMoveDao.getUniteharvesterMoveAll(page, conditions, userid);
	}

}
