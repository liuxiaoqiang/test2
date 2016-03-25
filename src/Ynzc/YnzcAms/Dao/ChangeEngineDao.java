package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeEngine;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeEngineDao {
	public List<ChangeEngine> getAllModelList(Page page,String conditions);
	public List<ChangeEngine> getAllModelList();
	public ChangeEngine findModelById(int id);
	public boolean addModel(ChangeEngine model);
	public boolean delModel(ChangeEngine model);
	public boolean updateModel(ChangeEngine model);	
	public boolean delChangeEngineByIds(String ids);	
}
