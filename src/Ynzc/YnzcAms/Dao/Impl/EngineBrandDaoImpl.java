package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.EngineBrandDao;
import Ynzc.YnzcAms.Model.EngineBrand;
import Ynzc.YnzcAms.Model.Page;

public class EngineBrandDaoImpl implements EngineBrandDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addEngineBrand(EngineBrand model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delEngineBrand(EngineBrand model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public EngineBrand findEngineBrandById(int id) {
		// TODO Auto-generated method stub
		List<EngineBrand> res = hibernateTemplate.find("from EngineBrand where id=" + id);
		if (res.size() > 0) {
			return (EngineBrand) res.get(0);
		} else {
			return null;
		}
	}

	public List<EngineBrand> getAllEngineBrandList(Page page,String conditions) {
		// TODO Auto-generated method stub
		
		
		String sql="",tsql="";
		if(conditions==""){
			sql="from EngineBrand";
			tsql="select count(*) from EngineBrand";
		}else{
			sql="from EngineBrand where (" + conditions + ")";
			tsql="select count(*) from EngineBrand where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<EngineBrand> res = query.list();
		return res;
	}
	public List<EngineBrand> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(EngineBrand.class);
	}
	public boolean updateEngineBrand(EngineBrand model) {
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
