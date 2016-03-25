package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.OwnerInfoDao;
import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.OwnerInfoService;

public class OwnerInfoServiceImpl implements OwnerInfoService {
	private OwnerInfoDao ownerInfoDao;

	public OwnerInfoDao getOwnerInfoDao() {
		return ownerInfoDao;
	}

	public void setOwnerInfoDao(OwnerInfoDao ownerInfoDao) {
		this.ownerInfoDao = ownerInfoDao;
	}

	public List<OwnerInfo> getAllOwnerInfoList(Page page, String conditions) {
		return this.ownerInfoDao.getAllOwnerInfoList(page, conditions);
	}

	public OwnerInfo findOwnerInfoById(int id) {
		return this.ownerInfoDao.findOwnerInfoById(id);
	}

	public boolean addOwnerInfo(OwnerInfo model) {
		return this.ownerInfoDao.addOwnerInfo(model);
	}

	public boolean delOwnerInfo(OwnerInfo model) {
		return this.ownerInfoDao.delOwnerInfo(model);
	}

	public boolean updateOwnerInfo(OwnerInfo model) {
		return this.ownerInfoDao.updateOwnerInfo(model);
	}

	public boolean delOwnerInfoByIds(String ids) {
		return this.ownerInfoDao.delOwnerInfoByIds(ids);
	}
	
	public OwnerInfo findOwnerInfoByWhere(String where){
		return this.ownerInfoDao.findOwnerInfoByWhere(where);
	}
}
