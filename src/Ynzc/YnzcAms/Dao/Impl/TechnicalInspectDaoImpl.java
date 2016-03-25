package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalInspect;

public class TechnicalInspectDaoImpl implements
		Ynzc.YnzcAms.Dao.TechnicalInspectDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addTechnicalInspect(TechnicalInspect model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delTechnicalInspect(TechnicalInspect model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delTechnicalInspectByIds(String ids){
		String sql="delete from TechnicalInspect where id in ("+ids+")";
		int result=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public TechnicalInspect findTechnicalInspectById(int id) {
		// TODO Auto-generated method stub
		List<TechnicalInspect> res = hibernateTemplate.find("from TechnicalInspect where id=" + id);
		if (res.size() > 0) {
			return (TechnicalInspect) res.get(0);
		} else {
			return null;
		}
	}
	public TechnicalInspect GetTechnicalInspectByCondition(String where)
	{
		List<TechnicalInspect> res = hibernateTemplate.find("from TechnicalInspect where " + where);
		if (res.size() > 0) {
			return (TechnicalInspect) res.get(0);
		} else {
			return null;
		}
	}
	public List<TechnicalInspect> getAllTechnicalInspectList(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from TechnicalInspect";
			tsql="select count(*) from TechnicalInspect";
		}else{
			sql="from TechnicalInspect where (" + conditions + ")";
			tsql="select count(*) from TechnicalInspect where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<TechnicalInspect> res = query.list();
		return res;
	}

	public boolean updateTechnicalInspect(TechnicalInspect model) {
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
