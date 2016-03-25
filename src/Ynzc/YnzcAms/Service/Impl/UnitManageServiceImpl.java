package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UnitManageDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Service.UnitManageService;

public class UnitManageServiceImpl implements UnitManageService {

	private UnitManageDao unitManageDao;
	
	public UnitManageDao getUnitManageDao() {
		return unitManageDao;
	}

	public void setUnitManageDao(UnitManageDao unitManageDao) {
		this.unitManageDao = unitManageDao;
	}

	public List<UnitManage> getAllUnitManageList(Page page, String conditions, String regionid) {
		return this.unitManageDao.getAllModelList(page, conditions, regionid);
	}

	public List<UnitManage> getAllModelList(String regionid) {
		// TODO Auto-generated method stub
		return this.unitManageDao.getAllModelList(regionid);
	}

	public List<UnitManage> getAllModelList(Page page, String conditions,
			int unitid) {
		// TODO Auto-generated method stub
		return this.unitManageDao.getAllModelList(page, conditions, unitid);
	}

	public List<UnitManage> getAllUnitManageList() {
		return this.unitManageDao.getAllModelList();
	}

	public UnitManage findUnitManageById(int id) {
		return this.unitManageDao.findModelById(id);
	}

	public boolean addModel(UnitManage model) {
		return this.unitManageDao.addModel(model);
	}

	public boolean delModel(UnitManage model) {
		return this.unitManageDao.delModel(model);
	}

	public boolean updateModel(UnitManage model) {
		return this.unitManageDao.updateModel(model);
	}

	public List<UnitManage> getUnitManageByRegionid(String regionid) {
		return this.unitManageDao.getUnitManageByRegionid(regionid);
	}

	public UnitManage getUnitByCode(String platecode) {
		return this.unitManageDao.getUnitByCode(platecode);
	}

	public List<UnitManage> getAreaUnit(int userid) {
		return this.unitManageDao.getAreaUnit(userid);
	}
	public UnitManage findUnitManageByUnitName(String unitname){
		return this.unitManageDao.findUnitManageByUnitName(unitname);
	}
}
