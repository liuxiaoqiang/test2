package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeTrailer;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeTrailerDao {
	public List<ChangeTrailer> getAllModelList(Page page,String conditions);
	public List<ChangeTrailer> getAllModelList();
	public ChangeTrailer findModelById(int id);
	public boolean addModel(ChangeTrailer model);
	public boolean delModel(ChangeTrailer model);
	public boolean updateModel(ChangeTrailer model);
	public boolean delChangeTrailerByIds(String ids);
}
