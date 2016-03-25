package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ChangeOwnerDao;
import Ynzc.YnzcAms.Model.ChangeOwner;
import Ynzc.YnzcAms.Model.Page;

public class ChangeOwnerDaoImpl implements ChangeOwnerDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(ChangeOwner model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(ChangeOwner model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delChangeOwnerByIds(String ids){
		String sql="delete from ChangeOwner where id in ("+ids+")";
		if(this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public ChangeOwner findModelById(int id) {
		// TODO Auto-generated method stub
		List<ChangeOwner> res = hibernateTemplate.find("from ChangeOwner where id=" + id);
		if (res.size() > 0) {
			return (ChangeOwner) res.get(0);
		} else {
			return null;
		}
	}

	public List<ChangeOwner> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from ChangeOwner";
			tsql="select count(*) from ChangeOwner";
		}else{
			sql="from ChangeOwner where (" + conditions + ")";
			tsql="select count(*) from ChangeOwner where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<ChangeOwner> res = query.list();
		return res;
	}

	public List<ChangeOwner> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(ChangeOwner.class);
	}

	public boolean updateModel(ChangeOwner model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
