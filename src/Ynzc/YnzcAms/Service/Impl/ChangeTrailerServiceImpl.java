package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ChangeTrailerDao;
import Ynzc.YnzcAms.Model.ChangeTrailer;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.ChangeTrailerService;

public class ChangeTrailerServiceImpl implements ChangeTrailerService {
	private ChangeTrailerDao changeTrailerDao;

	public ChangeTrailerDao getChangeTrailerDao() {
		return changeTrailerDao;
	}

	public void setChangeTrailerDao(ChangeTrailerDao changeTrailerDao) {
		this.changeTrailerDao = changeTrailerDao;
	}

	public List<ChangeTrailer> getChangeTrailerList(Page page, String conditions) {
		return this.changeTrailerDao.getAllModelList(page, conditions);
	}

	public List<ChangeTrailer> getChangeTrailerList() {
		return this.changeTrailerDao.getAllModelList();
	}

	public ChangeTrailer findChangeTrailerById(int id) {
		return this.changeTrailerDao.findModelById(id);
	}

	public boolean addChangeTrailer(ChangeTrailer model) {
		return this.changeTrailerDao.addModel(model);
	}

	public boolean delChangeTrailer(ChangeTrailer model) {
		return this.changeTrailerDao.delModel(model);
	}

	public boolean updateChangeTrailer(ChangeTrailer model) {
		return this.changeTrailerDao.updateModel(model);
	}

	public boolean delChangeTrailerByIds(String ids) {
		return this.changeTrailerDao.delChangeTrailerByIds(ids);
	}
}
