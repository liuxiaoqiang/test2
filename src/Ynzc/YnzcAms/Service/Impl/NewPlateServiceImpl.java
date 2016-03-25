package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.NewPlateDao;
import Ynzc.YnzcAms.Model.NewPlate;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.NewPlateService;

public class NewPlateServiceImpl implements NewPlateService {
	private NewPlateDao newPlateDao;

	public NewPlateDao getNewPlateDao() {
		return newPlateDao;
	}

	public void setNewPlateDao(NewPlateDao newPlateDao) {
		this.newPlateDao = newPlateDao;
	}

	public boolean addAPlate(NewPlate np) {
		// TODO Auto-generated method stub
		return newPlateDao.addAPlate(np);
	}

	public boolean addPlateBat(int start, int end, String platenumhead, int psid, int isaddnew) {
		// TODO Auto-generated method stub
		return newPlateDao.addPlateBat(start, end, platenumhead, psid, isaddnew);
	}

	public boolean delAPlate(NewPlate np) {
		// TODO Auto-generated method stub
		return newPlateDao.delAPlate(np);
	}

	public List<NewPlate> getAllNewPlate(Page page, int psid, String conditions,int type) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllNewPlate(page, psid, conditions,type);
	}

	public List<NewPlate> getAllMadePlate(Page page, int psid, String conditions) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllMadePlate(page, psid, conditions);
	}

	public boolean delAllPlate(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.delAllPlate(psid);
	}

	public boolean updateNewPlate(NewPlate np) {
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

	public List<NewPlate> getAllNewPlateHandle(Page page, int psid,
			String conditions) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllNewPlateHandle(page, psid, conditions);
	}

	public List<NewPlate> getAllNewPlateInfo(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.getAllNewPlateInfo(psid);
	}

	public boolean laidAll(int psid) {
		// TODO Auto-generated method stub
		return newPlateDao.laidAll(psid);
	}
}
