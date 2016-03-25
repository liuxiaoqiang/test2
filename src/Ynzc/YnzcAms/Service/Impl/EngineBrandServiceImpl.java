package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.EngineBrandDao;
import Ynzc.YnzcAms.Model.EngineBrand;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.EngineBrandService;

public class EngineBrandServiceImpl implements EngineBrandService {
	
	private EngineBrandDao engineBrandDao;
	
	public EngineBrandDao getEngineBrandDao() {
		return engineBrandDao;
	}

	public void setEngineBrandDao(EngineBrandDao engineBrandDao) {
		this.engineBrandDao = engineBrandDao;
	}

	public List<EngineBrand> getAllEngineBrandList(Page page, String conditions) {
		return this.engineBrandDao.getAllEngineBrandList(page, conditions);
	}

	public List<EngineBrand> getAllEngineBrandList() {
		return this.engineBrandDao.getAllModelList();
	}

	public EngineBrand findEngineBrandById(int id) {
		return this.engineBrandDao.findEngineBrandById(id);
	}

	public boolean addEngineBrand(EngineBrand model) {
		return this.engineBrandDao.addEngineBrand(model);
	}

	public boolean delEngineBrand(EngineBrand model) {
		return this.engineBrandDao.delEngineBrand(model);
	}

	public boolean updateEngineBrand(EngineBrand model) {
		return this.engineBrandDao.updateEngineBrand(model);
	}

}
