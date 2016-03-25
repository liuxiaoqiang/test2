package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeBody;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeBodyDao {
	public List<ChangeBody> getAllModelList(Page page,String conditions);
	public List<ChangeBody> getAllModelList();
	public ChangeBody findModelById(int id);
	public boolean addModel(ChangeBody model);
	public boolean delModel(ChangeBody model);
	public boolean updateModel(ChangeBody model);	
	public boolean delChangeBodyByIds(String ids);
}
