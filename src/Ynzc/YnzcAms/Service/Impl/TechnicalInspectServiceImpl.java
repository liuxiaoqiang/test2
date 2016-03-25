package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TechnicalInspectDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalInspect;
import Ynzc.YnzcAms.Service.TechnicalInspectService;

public class TechnicalInspectServiceImpl implements TechnicalInspectService {
	private TechnicalInspectDao technicalInspectDao;

	public TechnicalInspectDao getTechnicalInspectDao() {
		return technicalInspectDao;
	}

	public void setTechnicalInspectDao(TechnicalInspectDao technicalInspectDao) {
		this.technicalInspectDao = technicalInspectDao;
	}
	public List<TechnicalInspect> getAllTechnicalInspectList(Page page,String conditions)
	{
		return this.technicalInspectDao.getAllTechnicalInspectList(page, conditions);
	}
	public TechnicalInspect findTechnicalInspectById(int id)
	{
		return this.technicalInspectDao.findTechnicalInspectById(id);
	}
	public boolean addTechnicalInspect(TechnicalInspect model)
	{
		return this.technicalInspectDao.addTechnicalInspect(model);
	}
	public boolean delTechnicalInspect(TechnicalInspect model)
	{
		return this.technicalInspectDao.delTechnicalInspect(model);
	}
	public boolean updateTechnicalInspect(TechnicalInspect model)
	{
		return this.technicalInspectDao.updateTechnicalInspect(model);
	}
	public boolean delTechnicalInspectByIds(String ids){
		return this.technicalInspectDao.delTechnicalInspectByIds(ids);
	}
	public TechnicalInspect GetTechnicalInspectByCondition(String where){
		return this.technicalInspectDao.GetTechnicalInspectByCondition(where);
	}
}
