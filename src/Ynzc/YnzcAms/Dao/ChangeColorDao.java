package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeColor;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeColorDao {
	public List<ChangeColor> getAllModelList(Page page,String conditions);
	public List<ChangeColor> getAllModelList();
	public ChangeColor findModelById(int id);
	public boolean addModel(ChangeColor model);
	public boolean delModel(ChangeColor model);
	public boolean updateModel(ChangeColor model);	
	public boolean delChangeColorByIds(String ids);
}
