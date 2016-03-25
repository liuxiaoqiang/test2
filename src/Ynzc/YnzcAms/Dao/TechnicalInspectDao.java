package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;
import Ynzc.YnzcAms.Model.TechnicalInspect;

public interface TechnicalInspectDao {
	public List<TechnicalInspect> getAllTechnicalInspectList(Page page,String conditions);
	public TechnicalInspect findTechnicalInspectById(int id);
	public boolean addTechnicalInspect(TechnicalInspect model);
	public boolean delTechnicalInspect(TechnicalInspect model);
	public boolean updateTechnicalInspect(TechnicalInspect model);
	public TechnicalInspect GetTechnicalInspectByCondition(String where);
	public boolean delTechnicalInspectByIds(String ids);
}
