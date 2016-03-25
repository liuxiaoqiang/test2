package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ChangeEngineDao;
import Ynzc.YnzcAms.Model.ChangeEngine;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.ChangeEngineService;

public class ChangeEngineServiceImpl implements ChangeEngineService {
	private ChangeEngineDao changeEngineDao;

	public ChangeEngineDao getChangeEngineDao() {
		return changeEngineDao;
	}

	public void setChangeEngineDao(ChangeEngineDao changeEngineDao) {
		this.changeEngineDao = changeEngineDao;
	}

	public List<ChangeEngine> getChangeEngineList(Page page, String conditions) {
		return this.changeEngineDao.getAllModelList(page, conditions);
	}

	public List<ChangeEngine> getChangeEngineList() {
		return this.changeEngineDao.getAllModelList();
	}

	public ChangeEngine findChangeEngineById(int id) {
		return this.changeEngineDao.findModelById(id);
	}

	public boolean addChangeEngine(ChangeEngine model) {
		return this.changeEngineDao.addModel(model);
	}

	public boolean delChangeEngine(ChangeEngine model) {
		return this.changeEngineDao.delModel(model);
	}

	public boolean updateChangeEngine(ChangeEngine model) {
		return this.changeEngineDao.updateModel(model);
	}

	
	public boolean delChangeEngineByIds(String ids){
		return this.changeEngineDao.delChangeEngineByIds(ids);
	}
}
