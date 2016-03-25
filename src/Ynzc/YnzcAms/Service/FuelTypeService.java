package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.FuelType;
import Ynzc.YnzcAms.Model.Page;

public interface FuelTypeService {
	public List<FuelType> getFuelTypeList(Page page,String conditions);
	public List<FuelType> getFuelTypeList();
	public FuelType findFuelTypeById(int id);
	public boolean addFuelType(FuelType model);
	public boolean delFuelType(FuelType model);
	public boolean updateFuelType(FuelType model);
}
