package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;

public interface UnitManageService {
	public List<UnitManage> getAllUnitManageList(Page page,String conditions,String regionid);
	public List<UnitManage> getAllModelList(Page page,String conditions,int unitid);
	public List<UnitManage> getAllModelList(String regionid);
	public List<UnitManage> getAllUnitManageList();
	public List<UnitManage> getUnitManageByRegionid(String regionid);
	public UnitManage findUnitManageById(int id);
	public boolean addModel(UnitManage model);
	public boolean delModel(UnitManage model);
	public boolean updateModel(UnitManage model);
	public UnitManage getUnitByCode(String platecode);
	public List<UnitManage> getAreaUnit(int userid);
	public UnitManage findUnitManageByUnitName(String unitname);
}
