package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.ChangeOwnerDao;
import Ynzc.YnzcAms.Model.ChangeOwner;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.ChangeOwnerService;

public class ChangeOwnerServiceImpl implements ChangeOwnerService {
	private ChangeOwnerDao changeOwnerDao;

	public ChangeOwnerDao getChangeOwnerDao() {
		return changeOwnerDao;
	}

	public void setChangeOwnerDao(ChangeOwnerDao changeOwnerDao) {
		this.changeOwnerDao = changeOwnerDao;
	}

	public List<ChangeOwner> getChangeOwnerList(Page page, String conditions) {
		return this.changeOwnerDao.getAllModelList(page, conditions);
	}

	public List<ChangeOwner> getChangeOwnerList() {
		return this.changeOwnerDao.getAllModelList();
	}

	public ChangeOwner findChangeOwnerById(int id) {
		return this.changeOwnerDao.findModelById(id);
	}

	public boolean addChangeOwner(ChangeOwner model) {
		return this.changeOwnerDao.addModel(model);
	}

	public boolean delChangeOwner(ChangeOwner model) {
		return this.changeOwnerDao.delModel(model);
	}

	public boolean updateChangeOwner(ChangeOwner model) {
		return this.changeOwnerDao.updateModel(model);
	}

	public boolean delChangeOwnerByIds(String ids) {
		return this.changeOwnerDao.delChangeOwnerByIds(ids);
	}
}
