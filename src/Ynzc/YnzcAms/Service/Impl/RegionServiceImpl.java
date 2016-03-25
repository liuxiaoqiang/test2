package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.RegionDao;
import Ynzc.YnzcAms.Model.Region;
import Ynzc.YnzcAms.Service.RegionService;

public class RegionServiceImpl implements RegionService {

	private RegionDao regionDao;
	
	public RegionDao getRegionDao() {
		return regionDao;
	}

	public void setRegionDao(RegionDao regionDao) {
		this.regionDao = regionDao;
	}

	public boolean addRegion(Region r) {
		// TODO Auto-generated method stub
		return regionDao.addRegion(r);
	}

	public boolean delRegion(Region r) {
		// TODO Auto-generated method stub
		return regionDao.delRegion(r);
	}

	public Region findRegionByID(int id) {
		// TODO Auto-generated method stub
		return regionDao.findRegionByID(id);
	}

	public List<Region> getAllCityRegion() {
		// TODO Auto-generated method stub
		return regionDao.getAllCityRegion();
	}

	public List<Region> getRegionByFatherID(int fatherid) {
		// TODO Auto-generated method stub
		return regionDao.getRegionByFatherID(fatherid);
	}

	public boolean updateRegion(Region r) {
		// TODO Auto-generated method stub
		return regionDao.updateRegion(r);
	}
	public List<Region> getCityRegion(int userid){
		return regionDao.getCityRegion(userid);
	}
}
