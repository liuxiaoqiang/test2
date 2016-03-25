package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ReaperPlateSubmitDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ReaperPlateSubmit;
import Ynzc.YnzcAms.Service.ReaperPlateSubmitService;

public class ReaperPlateSubmitServiceImpl implements ReaperPlateSubmitService {
	private ReaperPlateSubmitDao reaperPlateSubmitDao;


	public ReaperPlateSubmitDao getReaperPlateSubmitDao() {
		return reaperPlateSubmitDao;
	}

	public void setReaperPlateSubmitDao(ReaperPlateSubmitDao reaperPlateSubmitDao) {
		this.reaperPlateSubmitDao = reaperPlateSubmitDao;
	}

	public boolean addNewSubmit(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		return reaperPlateSubmitDao.addNewSubmit(ps);
	}

	public boolean delSubmit(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		return reaperPlateSubmitDao.delSubmit(ps);
	}

	public List<ReaperPlateSubmit> getAllSubmit(Page page, int unitid) {
		// TODO Auto-generated method stub
		return reaperPlateSubmitDao.getAllSubmit(page, unitid);
	}

	public boolean updateSubmit(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		return reaperPlateSubmitDao.updateSubmit(ps);
	}

	public List<ReaperPlateSubmit> getAllSubmitWaitMade(Page page) {
		// TODO Auto-generated method stub
		return reaperPlateSubmitDao.getAllSubmitWaitMade(page);
	}

	public boolean laidAll(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		return reaperPlateSubmitDao.laidAll(ps);
	}
	public ReaperPlateSubmit findPlateSubmit(int status,int unitid){
		return reaperPlateSubmitDao.findPlateSubmit(status, unitid);
	}
}
