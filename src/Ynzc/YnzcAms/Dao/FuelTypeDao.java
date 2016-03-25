package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.FuelType;
import Ynzc.YnzcAms.Model.Page;

public interface FuelTypeDao {
	public List<FuelType> getAllModelList(Page page,String conditions);
	public List<FuelType> getAllModelList();
	public FuelType findModelById(int id);
	public boolean addModel(FuelType model);
	public boolean delModel(FuelType model);
	public boolean updateModel(FuelType model);
}
