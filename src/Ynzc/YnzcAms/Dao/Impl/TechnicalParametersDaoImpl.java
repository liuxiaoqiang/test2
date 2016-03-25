package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TechnicalParametersDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalParameters;

public class TechnicalParametersDaoImpl implements TechnicalParametersDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addTechnicalParameters(TechnicalParameters model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delTechnicalParameters(TechnicalParameters model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delTechnicalParametersByIds(String ids){
		String sql="delete from TechnicalParameters where id in ("+ids+")";
		int result=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	public TechnicalParameters findTechnicalParametersById(int id) {
		// TODO Auto-generated method stub
		List<TechnicalParameters> res = hibernateTemplate.find("from TechnicalParameters where id=" + id);
		if (res.size() > 0) {
			return (TechnicalParameters) res.get(0);
		} else {
			return null;
		}
	}
	public TechnicalParameters findTechnicalParametersByWhere(String where){
		List<TechnicalParameters> res = hibernateTemplate.find("from TechnicalParameters where " + where);
		if (res.size() > 0) {
			return (TechnicalParameters) res.get(0);
		} else {
			return null;
		}	
	}
	public List<TechnicalParameters> getAllTechnicalParametersList(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from TechnicalParameters";
			tsql="select count(*) from TechnicalParameters";
		}else{
			sql="from TechnicalParameters where (" + conditions + ")";
			tsql="select count(*) from TechnicalParameters where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<TechnicalParameters> res = query.list();
		return res;
	}

	public boolean updateTechnicalParameters(TechnicalParameters model) {
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
