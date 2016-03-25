package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Model.Page;

public class OwnerInfoDaoImpl implements Ynzc.YnzcAms.Dao.OwnerInfoDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addOwnerInfo(OwnerInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delOwnerInfo(OwnerInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delOwnerInfoByIds(String ids){
		String sql="delete from OwnerInfo where id in ("+ids+")";
		int result=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public OwnerInfo findOwnerInfoById(int id) {
		// TODO Auto-generated method stub
		List<OwnerInfo> res = hibernateTemplate.find("from OwnerInfo where id=" + id);
		if (res.size() > 0) {
			return (OwnerInfo) res.get(0);
		} else {
			return null;
		}
	}
	public OwnerInfo findOwnerInfoByWhere(String where){
		List<OwnerInfo> res = hibernateTemplate.find("from OwnerInfo where " + where);
		if (res.size() > 0) {
			return (OwnerInfo) res.get(0);
		} else {
			return null;
		}	
	}
	public List<OwnerInfo> getAllOwnerInfoList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from OwnerInfo";
			tsql="select count(*) from OwnerInfo";
		}else{
			sql="from OwnerInfo where (" + conditions + ")";
			tsql="select count(*) from OwnerInfo where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<OwnerInfo> res = query.list();
		return res;
	}

	public boolean updateOwnerInfo(OwnerInfo model) {
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
