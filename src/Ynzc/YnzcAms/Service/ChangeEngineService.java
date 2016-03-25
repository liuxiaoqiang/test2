package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.ChangeEngine;
import Ynzc.YnzcAms.Model.Page;

public interface ChangeEngineService {
	public List<ChangeEngine> getChangeEngineList(Page page,String conditions);
	public List<ChangeEngine> getChangeEngineList();
	public ChangeEngine findChangeEngineById(int id);
	public boolean addChangeEngine(ChangeEngine model);
	public boolean delChangeEngine(ChangeEngine model);
	public boolean updateChangeEngine(ChangeEngine model);	
	public boolean delChangeEngineByIds(String ids);
}
