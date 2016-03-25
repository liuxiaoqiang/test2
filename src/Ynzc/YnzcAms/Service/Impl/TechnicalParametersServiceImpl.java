package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.TechnicalParametersDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalParameters;
import Ynzc.YnzcAms.Service.TechnicalParametersService;

public class TechnicalParametersServiceImpl implements
		TechnicalParametersService {

	private TechnicalParametersDao technicalParametersDao;

	public TechnicalParametersDao getTechnicalParametersDao() {
		return technicalParametersDao;
	}

	public void setTechnicalParametersDao(
			TechnicalParametersDao technicalParametersDao) {
		this.technicalParametersDao = technicalParametersDao;
	}

	public List<TechnicalParameters> getAllTechnicalParametersList(Page page,
			String conditions) {
		return this.technicalParametersDao.getAllTechnicalParametersList(page,
				conditions);
	}

	public TechnicalParameters findTechnicalParametersById(int id) {
		return this.technicalParametersDao.findTechnicalParametersById(id);
	}

	public boolean addTechnicalParameters(TechnicalParameters model) {
		return this.technicalParametersDao.addTechnicalParameters(model);
	}

	public boolean delTechnicalParameters(TechnicalParameters model) {
		return this.technicalParametersDao.delTechnicalParameters(model);
	}

	public boolean updateTechnicalParameters(TechnicalParameters model) {
		return this.technicalParametersDao.updateTechnicalParameters(model);
	}

	public boolean delTechnicalParametersByIds(String ids) {
		return this.technicalParametersDao.delTechnicalParametersByIds(ids);
	}

	public TechnicalParameters findTechnicalParametersByWhere(String where) {
		return this.technicalParametersDao
				.findTechnicalParametersByWhere(where);
	}
}
