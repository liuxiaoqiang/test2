package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.FuelTypeDao;
import Ynzc.YnzcAms.Model.FuelType;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.FuelTypeService;

public class FuelTypeServiceImpl implements FuelTypeService {
	private FuelTypeDao fuelTypeDao;

	public FuelTypeDao getFuelTypeDao() {
		return fuelTypeDao;
	}

	public void setFuelTypeDao(FuelTypeDao fuelTypeDao) {
		this.fuelTypeDao = fuelTypeDao;
	}

	public List<FuelType> getFuelTypeList(Page page, String conditions) {
		return this.fuelTypeDao.getAllModelList(page, conditions);
	}

	public List<FuelType> getFuelTypeList() {
		return this.fuelTypeDao.getAllModelList();
	}

	public FuelType findFuelTypeById(int id) {
		return this.fuelTypeDao.findModelById(id);
	}

	public boolean addFuelType(FuelType model) {
		return this.fuelTypeDao.addModel(model);
	}

	public boolean delFuelType(FuelType model) {
		return this.fuelTypeDao.delModel(model);
	}

	public boolean updateFuelType(FuelType model) {
		return this.fuelTypeDao.updateModel(model);
	}
}
