package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.EngineBrand;
import Ynzc.YnzcAms.Model.Page;

public interface EngineBrandService {
	public List<EngineBrand> getAllEngineBrandList(Page page,String conditions);
	public List<EngineBrand> getAllEngineBrandList();
	public EngineBrand findEngineBrandById(int id);
	public boolean addEngineBrand(EngineBrand model);
	public boolean delEngineBrand(EngineBrand model);
	public boolean updateEngineBrand(EngineBrand model);
}
