package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.RelationInfoDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;

public class RelationInfoDaoImpl implements RelationInfoDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addRelationInfo(RelationInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delRelationInfo(RelationInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delRelationInfoByIds(String ids){
		String sql="delete from RelationInfo where id in ("+ids+")";
		int result=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public RelationInfo findRelationInfoById(int id) {
		// TODO Auto-generated method stub
		List<RelationInfo> res = hibernateTemplate.find("from RelationInfo where id=" + id);
		if (res.size() > 0) {
			return (RelationInfo) res.get(0);
		} else {
			return null;
		}
	}
	public RelationInfo findRelationInfoByWhere(String where){
		List<RelationInfo> res = hibernateTemplate.find("from RelationInfo where " + where);
		if (res.size() > 0) {
			return (RelationInfo) res.get(0);
		} else {
			return null;
		}
	}
	public RelationInfo GetRelationInfoByCondition(String where)
	{
		List<RelationInfo> res = hibernateTemplate.find("from RelationInfo where " + where);
		if (res.size() > 0) {
			return (RelationInfo) res.get(0);
		} else {
			return null;
		}
	}
	public List<RelationInfo> getAllRelationInfoList(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from RelationInfo";
			tsql="select count(*) from RelationInfo";
		}else{
			sql="from RelationInfo where (" + conditions + ")";
			tsql="select count(*) from RelationInfo where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<RelationInfo> res = query.list();
		return res;
	}

	public boolean updateRelationInfo(RelationInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
