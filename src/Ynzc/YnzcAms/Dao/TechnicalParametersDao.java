package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalParameters;

public interface TechnicalParametersDao {
	public List<TechnicalParameters> getAllTechnicalParametersList(Page page,String conditions);
	public TechnicalParameters findTechnicalParametersById(int id);
	public boolean addTechnicalParameters(TechnicalParameters model);
	public boolean delTechnicalParameters(TechnicalParameters model);
	public boolean updateTechnicalParameters(TechnicalParameters model);
	public TechnicalParameters findTechnicalParametersByWhere(String where);
	public boolean delTechnicalParametersByIds(String ids);
}
