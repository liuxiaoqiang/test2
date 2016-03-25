package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalInspect;

public interface TechnicalInspectService {
	public List<TechnicalInspect> getAllTechnicalInspectList(Page page,String conditions);
	public TechnicalInspect findTechnicalInspectById(int id);
	public boolean addTechnicalInspect(TechnicalInspect model);
	public boolean delTechnicalInspect(TechnicalInspect model);
	public boolean updateTechnicalInspect(TechnicalInspect model);	
	public boolean delTechnicalInspectByIds(String ids);
	public TechnicalInspect GetTechnicalInspectByCondition(String where);
}
