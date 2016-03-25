package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.FuelTypeDao;
import Ynzc.YnzcAms.Model.FuelType;
import Ynzc.YnzcAms.Model.Page;

public class FuelTypeDaoImpl implements FuelTypeDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(FuelType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(FuelType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public FuelType findModelById(int id) {
		// TODO Auto-generated method stub
		List<FuelType> res = hibernateTemplate.find("from FuelType where id=" + id);
		if (res.size() > 0) {
			return (FuelType) res.get(0);
		} else {
			return null;
		}
	}

	public List<FuelType> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from FuelType";
			tsql="select count(*) from FuelType";
		}else{
			sql="from FuelType where (" + conditions + ")";
			tsql="select count(*) from FuelType where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<FuelType> res = query.list();
		return res;
	}

	public List<FuelType> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(FuelType.class);
	}

	public boolean updateModel(FuelType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
