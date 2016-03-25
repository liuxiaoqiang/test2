package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.NewReaperPlateDao;
import Ynzc.YnzcAms.Model.NewReaperPlate;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.NewReaperPlateService;

public class NewReaperPlateServiceImpl implements NewReaperPlateService {
	private NewReaperPlateDao newPlateDao;

	public NewReaperPlateDao getNewPlateDao() {
		return newPlateDao;
	}

	public void setNewPlateDao(NewReaperPlateDao newPlateDao) {
		this.newPlateDao = newPlateDao;
	}

	public boolean addAPlate(NewReaperPlate np) {
		// TODO Auto-generated method stub
		return newPlateDao.addAPlate(np);
	}

	public boolean addPlateBat(int start, int end, String platenumhead, int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.addPlateBat(start, end, platenumhead, psid);
	}

	public boolean delAPlate(NewReaperPlate np) {
		// TODO Auto-generated method stub
		return newPlateDao.delAPlate(np);
	}

	public List<NewReaperPlate> getAllNewPlate(Page page, int psid, String conditions,int type) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllNewPlate(page, psid, conditions,type);
	}

	public List<NewReaperPlate> getAllMadePlate(Page page, int psid, String conditions) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllMadePlate(page, psid, conditions);
	}

	public boolean delAllPlate(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.delAllPlate(psid);
	}

	public boolean updateNewPlate(NewReaperPlate np) {
		// TODO Auto-generated method stub
		return newPlateDao.updateNewPlate(np);
	}

	public boolean flagAll(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.flagAll(psid);
	}

	public boolean allotAll(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.allotAll(psid);
	}

	public List<NewReaperPlate> getAllNewPlateHandle(Page page, int psid,
			String conditions) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllNewPlateHandle(page, psid, conditions);
	}

	public List<NewReaperPlate> getAllNewPlateInfo(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllNewPlateInfo(psid);
	}

	public boolean laidAll(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.laidAll(psid);
	}
}
