package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ChangeEngineDao;
import Ynzc.YnzcAms.Model.ChangeEngine;
import Ynzc.YnzcAms.Model.Page;

public class ChangeEngineDaoImpl implements ChangeEngineDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(ChangeEngine model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(ChangeEngine model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delChangeEngineByIds(String ids){
		String sql="delete from ChangeEngine where id in ("+ids+")";
		if(this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public ChangeEngine findModelById(int id) {
		// TODO Auto-generated method stub
		List<ChangeEngine> res = hibernateTemplate.find("from ChangeEngine where id=" + id);
		if (res.size() > 0) {
			return (ChangeEngine) res.get(0);
		} else {
			return null;
		}
	}

	public List<ChangeEngine> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ChangeEngine";
			tsql="select count(*) from ChangeEngine";
		}else{
			sql="from ChangeEngine where (" + conditions + ")";
			tsql="select count(*) from ChangeEngine where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ChangeEngine> res = query.list();
		return res;
	}

	public List<ChangeEngine> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(ChangeEngine.class);
	}

	public boolean updateModel(ChangeEngine model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
