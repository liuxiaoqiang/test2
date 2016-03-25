package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;

public interface RelationInfoService {
	public List<RelationInfo> getAllRelationInfoList(Page page,String conditions);
	public RelationInfo findRelationInfoById(int id);
	public boolean addRelationInfo(RelationInfo model);
	public boolean delRelationInfo(RelationInfo model);
	public boolean updateRelationInfo(RelationInfo model);
	public boolean delRelationInfoByIds(String ids);
	public RelationInfo GetRelationInfoByCondition(String where);
	public RelationInfo findRelationInfoByWhere(String where);
}
