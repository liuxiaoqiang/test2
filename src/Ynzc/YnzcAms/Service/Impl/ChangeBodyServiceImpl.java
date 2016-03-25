package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ChangeBodyDao;
import Ynzc.YnzcAms.Model.ChangeBody;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.ChangeBodyService;

public class ChangeBodyServiceImpl implements ChangeBodyService {
	private ChangeBodyDao changeBodyDao;

	public ChangeBodyDao getChangeBodyDao() {
		return changeBodyDao;
	}

	public void setChangeBodyDao(ChangeBodyDao changeBodyDao) {
		this.changeBodyDao = changeBodyDao;
	}

	public List<ChangeBody> getChangeBodyList(Page page, String conditions) {
		return this.changeBodyDao.getAllModelList(page, conditions);
	}

	public List<ChangeBody> getChangeBodyList() {
		return this.changeBodyDao.getAllModelList();
	}

	public ChangeBody findChangeBodyById(int id) {
		return this.changeBodyDao.findModelById(id);
	}

	public boolean addChangeBody(ChangeBody model) {
		return this.changeBodyDao.addModel(model);
	}

	public boolean delChangeBody(ChangeBody model) {
		return this.changeBodyDao.delModel(model);
	}

	public boolean updateChangeBody(ChangeBody model) {
		return this.changeBodyDao.updateModel(model);
	}
	
	public boolean delChangeBodyByIds(String ids){
	    return this.changeBodyDao.delChangeBodyByIds(ids);
	}
}
