package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ChangeTrailerDao;
import Ynzc.YnzcAms.Model.ChangeTrailer;
import Ynzc.YnzcAms.Model.Page;

public class ChangeTrailerDaoImpl implements ChangeTrailerDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(ChangeTrailer model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(ChangeTrailer model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delChangeTrailerByIds(String ids){
		String sql="delete from ChangeTrailer where id in ("+ids+")";
		if(this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public ChangeTrailer findModelById(int id) {
		// TODO Auto-generated method stub
		List<ChangeTrailer> res = hibernateTemplate.find("from ChangeTrailer where id=" + id);
		if (res.size() > 0) {
			return (ChangeTrailer) res.get(0);
		} else {
			return null;
		}
	}

	public List<ChangeTrailer> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ChangeTrailer";
			tsql="select count(*) from ChangeTrailer";
		}else{
			sql="from ChangeTrailer where (" + conditions + ")";
			tsql="select count(*) from ChangeTrailer where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ChangeTrailer> res = query.list();
		return res;
	}

	public List<ChangeTrailer> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(ChangeTrailer.class);
	}

	public boolean updateModel(ChangeTrailer model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
