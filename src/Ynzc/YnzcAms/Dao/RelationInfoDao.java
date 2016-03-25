package Ynzc.YnzcAms.Dao;

import java.util.List;

import Ynzc.YnzcAms.Model.HandlingSituation;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;

public interface RelationInfoDao {
	public List<RelationInfo> getAllRelationInfoList(Page page,String conditions);
	public RelationInfo findRelationInfoById(int id);
	public boolean addRelationInfo(RelationInfo model);
	public boolean delRelationInfo(RelationInfo model);
	public boolean updateRelationInfo(RelationInfo model);
	public RelationInfo GetRelationInfoByCondition(String where);
	public RelationInfo findRelationInfoByWhere(String where);
	public boolean delRelationInfoByIds(String ids);
}
