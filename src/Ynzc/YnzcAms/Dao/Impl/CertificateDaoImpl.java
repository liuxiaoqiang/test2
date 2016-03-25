package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.CertificateDao;
import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.Page;

public class CertificateDaoImpl implements CertificateDao {

	private HibernateTemplate hibernateTemplate;
	public boolean addModel(Certificate model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(Certificate model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Certificate findModelById(int id) {
		// TODO Auto-generated method stub
		//Certificate mdoel=hibernateTemplate.get(Certificate.class, id);
		List<Certificate> res = hibernateTemplate.find("from Certificate where id=" + id);
		if (res.size() > 0) {
			return (Certificate) res.get(0);
		} else {
			return null;
		}
	}

	public List<Certificate> getAllModelList(Page page,String conditions) {
		// TODO Auto-generated method stub
		
		
		String sql="",tsql="";
		if(conditions==""){
			sql="from Certificate";
			tsql="select count(*) from Certificate";
		}else{
			sql="from Certificate where (" + conditions + ")";
			tsql="select count(*) from Certificate where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<Certificate> res = query.list();
		return res;
	}
	public List<Certificate> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(Certificate.class);
	}
	public boolean updateModel(Certificate model) {
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
