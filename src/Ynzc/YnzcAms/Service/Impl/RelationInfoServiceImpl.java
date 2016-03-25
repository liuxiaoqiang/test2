package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.RelationInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;
import Ynzc.YnzcAms.Service.RelationInfoService;

public class RelationInfoServiceImpl implements RelationInfoService {

	private RelationInfoDao relationInfoDao;

	public RelationInfoDao getRelationInfoDao() {
		return relationInfoDao;
	}

	public void setRelationInfoDao(RelationInfoDao relationInfoDao) {
		this.relationInfoDao = relationInfoDao;
	}

	public List<RelationInfo> getAllRelationInfoList(Page page,
			String conditions) {
		return this.relationInfoDao.getAllRelationInfoList(page, conditions);
	}

	public RelationInfo findRelationInfoById(int id) {
		return this.relationInfoDao.findRelationInfoById(id);
	}

	public boolean addRelationInfo(RelationInfo model) {
		return this.relationInfoDao.addRelationInfo(model);
	}

	public boolean delRelationInfo(RelationInfo model) {
		return this.relationInfoDao.delRelationInfo(model);
	}

	public boolean updateRelationInfo(RelationInfo model) {
		return this.relationInfoDao.updateRelationInfo(model);
	}

	public boolean delRelationInfoByIds(String ids) {
		return this.relationInfoDao.delRelationInfoByIds(ids);
	}

	public RelationInfo GetRelationInfoByCondition(String where) {
		return this.relationInfoDao.GetRelationInfoByCondition(where);
	}

	public RelationInfo findRelationInfoByWhere(String where) {
		return this.relationInfoDao.findRelationInfoByWhere(where);
	}
}
