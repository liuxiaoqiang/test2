package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.PlateDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Plate;
import Ynzc.YnzcAms.Model.PlateViewData;
import Ynzc.YnzcAms.Service.PlateService;

public class PlateServiceImpl implements PlateService {

	private PlateDao plateDao;

	public PlateDao getPlateDao() {
		return plateDao;
	}

	public void setPlateDao(PlateDao plateDao) {
		this.plateDao = plateDao;
	}

	public boolean InputLib(int unitid, int psid, String submitman) {
		// TODO Auto-generated method stub
		return plateDao.InputLib(unitid, psid, submitman);
	}

	public List<Plate> getPlateLibList(Page page, String conditions,
			int userid, int plateStatus) {
		// TODO Auto-generated method stub
		return plateDao.getPlateLibList(page, conditions, userid, plateStatus);
	}

	public List<Plate> getPlateLibList(Page page, String conditions,
			String regionid, String mark) {
		// TODO Auto-generated method stub
		return plateDao.getPlateLibList(page, conditions, regionid, mark);
	}

	public boolean updatePlate(String platenum, String platehead) {
		// TODO Auto-generated method stub
		return plateDao.updatePlate(platenum, platehead);
	}

	public boolean updatePlateBatch(String numberStr, String platehead,
			int unitid) {
		// TODO Auto-generated method stub
		return plateDao.updatePlateBatch(numberStr, platehead, unitid);
	}

	public String getMinPlateCode(String regionId) {
		return this.plateDao.getMinPlateCode(regionId);
	}

	public boolean UpdatePlateCodeStateByCode(int state, String platecodes) {
		return this.plateDao.UpdatePlateCodeStateByCode(state, platecodes);
	}

	public boolean UpdatePlateCodeStateByCodeAndHead(int state, String platecode) {
		return this.plateDao
				.UpdatePlateCodeStateByCodeAndHead(state, platecode);
	}

	public List<Plate> getPlateChangeList(Page page, String conditions,String regionId, int type) {
		return this.plateDao.getPlateChangeList(page,conditions,regionId, type);
	}

	public boolean delPlate(Plate plate) {
		return this.plateDao.delPlate(plate);
	}

	public boolean updatePlateStatus(String platenum, String platehead,
			String regionId, int status) {
		return this.plateDao.updatePlateStatus(platenum, platehead, regionId,
				status);
	}

	public boolean isExist(String platenum, String platehead) {
		return this.plateDao.isExist(platenum, platehead);
	}

	public Plate getPlate(String platenum, String platehead) {
		return this.plateDao.getPlate(platenum, platehead);
	}

	public List<Plate> getPlateByPid(Page page, String pid, String conditions) {
		return this.plateDao.getPlateByPid(page, pid, conditions);
	}

	public boolean addPlate(Plate plate) {
		return this.plateDao.addPlate(plate);
	}

	public boolean updatePlateInfo(Plate plate) {
		return this.plateDao.updatePlateInfo(plate);
	}

	public boolean addPlateBat(int start, int end, String platenumhead,String regionId,
			String pid, int status) {
		return this.plateDao.addPlateBat(start,end,platenumhead,regionId,pid,status);
	}

	public List<Plate> getPlateDoList(int type) {
		return this.plateDao.getPlateDoList(type);
	}

	public List<Plate> getPlateDoList(String pid) {
		return this.plateDao.getPlateDoList(pid);
	}

	public int getPlateNum(String platehead, int status) {
		return this.plateDao.getPlateNum(platehead, status);
	}

	public int getPlateNumByRegion(String regionId, int status) {
		return this.plateDao.getPlateNumByRegion(regionId, status);
	}

	public List<Plate> getPlateList(Page page,String start, String end,String regionid) {
		return this.plateDao.getPlateList(page,start,end,regionid);
	}
}
