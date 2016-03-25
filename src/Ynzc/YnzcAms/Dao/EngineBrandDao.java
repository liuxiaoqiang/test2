package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.EngineBrand;
import Ynzc.YnzcAms.Model.Page;

public interface EngineBrandDao {
	public List<EngineBrand> getAllEngineBrandList(Page page,String conditions);
	public List<EngineBrand> getAllModelList();
	public EngineBrand findEngineBrandById(int id);
	public boolean addEngineBrand(EngineBrand model);
	public boolean delEngineBrand(EngineBrand model);
	public boolean updateEngineBrand(EngineBrand model);	
}
