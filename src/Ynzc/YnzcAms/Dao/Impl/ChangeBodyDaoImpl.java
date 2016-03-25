package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ChangeBodyDao;
import Ynzc.YnzcAms.Model.ChangeBody;
import Ynzc.YnzcAms.Model.Page;

public class ChangeBodyDaoImpl implements ChangeBodyDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(ChangeBody model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(ChangeBody model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delChangeBodyByIds(String ids){
		String sql="delete from ChangeBody where id in ("+ids+")";
		if(this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public ChangeBody findModelById(int id) {
		// TODO Auto-generated method stub
		List<ChangeBody> res = hibernateTemplate.find("from ChangeBody where id=" + id);
		if (res.size() > 0) {
			return (ChangeBody) res.get(0);
		} else {
			return null;
		}
	}

	public List<ChangeBody> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ChangeBody";
			tsql="select count(*) from ChangeBody";
		}else{
			sql="from ChangeBody where (" + conditions + ")";
			tsql="select count(*) from ChangeBody where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ChangeBody> res = query.list();
		return res;
	}

	public List<ChangeBody> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(ChangeBody.class);
	}

	public boolean updateModel(ChangeBody model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
