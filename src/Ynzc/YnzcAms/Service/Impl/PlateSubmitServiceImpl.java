package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.PlateSubmitDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateSubmit;
import Ynzc.YnzcAms.Service.PlateSubmitService;

public class PlateSubmitServiceImpl implements PlateSubmitService {
	private PlateSubmitDao plateSubmitDao;

	public PlateSubmitDao getPlateSubmitDao() {
		return plateSubmitDao;
	}

	public void setPlateSubmitDao(PlateSubmitDao plateSubmitDao) {
		this.plateSubmitDao = plateSubmitDao;
	}

	public boolean addNewSubmit(PlateSubmit ps) {
		// TODO Auto-generated method stub
		return plateSubmitDao.addNewSubmit(ps);
	}

	public boolean delSubmit(PlateSubmit ps) {
		// TODO Auto-generated method stub
		return plateSubmitDao.delSubmit(ps);
	}

	public List<PlateSubmit> getAllSubmit(Page page, int unitid,int status) {
		// TODO Auto-generated method stub
		return plateSubmitDao.getAllSubmit(page, unitid,status);
	}

	public boolean updateSubmit(PlateSubmit ps) {
		// TODO Auto-generated method stub
		return plateSubmitDao.updateSubmit(ps);
	}

	public List<PlateSubmit> getAllSubmitWaitMade(Page page) {
		// TODO Auto-generated method stub
		return plateSubmitDao.getAllSubmitWaitMade(page);
	}

	public boolean laidAll(PlateSubmit ps) {
		// TODO Auto-generated method stub
		return plateSubmitDao.laidAll(ps);
	}
	public PlateSubmit findPlateSubmit(int status,int unitid){
		return plateSubmitDao.findPlateSubmit(status, unitid);
	}
	public boolean updateSubmitData(String pid) {
		return this.plateSubmitDao.updateSubmitData(pid);
	}

	public PlateSubmit findPlateSubmit(int id) {
		return this.plateSubmitDao.findPlateSubmit(id);
	}
}
