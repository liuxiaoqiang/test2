package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ReaperPlateDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ReaperPlate;
import Ynzc.YnzcAms.Model.ReaperPlateViewData;
import Ynzc.YnzcAms.Service.ReaperPlateService;

public class ReaperPlateServiceImpl implements ReaperPlateService{
	
	private ReaperPlateDao plateDao;
	
	public ReaperPlateDao getPlateDao() {
		return plateDao;
	}

	public void setPlateDao(ReaperPlateDao plateDao) {
		this.plateDao = plateDao;
	}

	public boolean InputLib(int unitid, int psid, String submitman) {
		// TODO Auto-generated method stub
		return plateDao.InputLib(unitid, psid, submitman);
	}

	public boolean isExist(String platenum, String platehead) {
		// TODO Auto-generated method stub
		return plateDao.isExist(platenum, platehead);
	}
	
	public List<ReaperPlateViewData> getPlateLibList(Page page, String conditions, int userid, int plateStatus ) {
		// TODO Auto-generated method stub
		return plateDao.getPlateLibList(page, conditions, userid, plateStatus);
	}

	public List<ReaperPlateViewData> getPlateLibList(Page page, String conditions,
			int untilid,String mark) {
		// TODO Auto-generated method stub
		return plateDao.getPlateLibList(page, conditions, untilid,mark);
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

	public boolean updatePlateInfo(ReaperPlate plate) {
		// TODO Auto-generated method stub
		return plateDao.updatePlateInfo(plate);
	}
	public String getMinPlateCode(int unitid){
		return this.plateDao.getMinPlateCode(unitid);
	}
	public List<ReaperPlate> getPlateChangeList(int userid, int type){
		return this.plateDao.getPlateChangeList(userid,type);
	}
	public boolean delPlate(ReaperPlate plate){
		return this.plateDao.delPlate(plate);
	}
	public ReaperPlate getLowNum(int userid) {
		// TODO Auto-generated method stub
		return plateDao.getLowNum(userid);
	}
	public boolean updateState(String num, String plateCode, int state) {
		// TODO Auto-generated method stub
		return plateDao.updateState(num, plateCode, state);
	}
}
