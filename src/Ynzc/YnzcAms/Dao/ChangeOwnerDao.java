package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeOwner;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeOwnerDao {
	public List<ChangeOwner> getAllModelList(Page page,String conditions);
	public List<ChangeOwner> getAllModelList();
	public ChangeOwner findModelById(int id);
	public boolean addModel(ChangeOwner model);
	public boolean delModel(ChangeOwner model);
	public boolean updateModel(ChangeOwner model);	
	public boolean delChangeOwnerByIds(String ids);
}
