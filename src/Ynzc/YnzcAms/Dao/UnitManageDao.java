package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.Page;

public interface UnitManageDao {
	public List<UnitManage> getAllModelList(Page page,String conditions,String regionid);
	public List<UnitManage> getAllModelList(Page page,String conditions,int unitid);
	public List<UnitManage> getAllModelList(String regionid);
	public List<UnitManage> getAllModelList();
	public List<UnitManage> getUnitManageByRegionid(String regionid);
	public UnitManage findModelById(int id);
	public UnitManage findUnitManageByUnitName(String unitname);
	public boolean addModel(UnitManage model);
	public boolean delModel(UnitManage model);
	public boolean updateModel(UnitManage model);
	public UnitManage getUnitByCode(String platecode);
	public List<UnitManage> getAreaUnit(int userid);
}
