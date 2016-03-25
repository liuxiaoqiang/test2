package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Region;

public interface RegionService {
	public List<Region> getAllCityRegion();
	public List<Region> getRegionByFatherID(int fatherid);
	public boolean addRegion(Region r);
	public boolean delRegion(Region r);
	public Region findRegionByID(int id);
	public boolean updateRegion(Region r);
	public List<Region> getCityRegion(int userid);
}
