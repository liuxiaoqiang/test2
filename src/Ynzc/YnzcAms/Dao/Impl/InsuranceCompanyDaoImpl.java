package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.InsuranceCompanyDao;
import Ynzc.YnzcAms.Model.InsuranceCompany;
import Ynzc.YnzcAms.Model.Page;

public class InsuranceCompanyDaoImpl implements InsuranceCompanyDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addInsuranceCompany(InsuranceCompany model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delInsuranceCompany(InsuranceCompany model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public InsuranceCompany findInsuranceCompanyById(int id) {
		// TODO Auto-generated method stub
		List<InsuranceCompany> res = hibernateTemplate.find("from InsuranceCompany where id=" + id);
		if (res.size() > 0) {
			return (InsuranceCompany) res.get(0);
		} else {
			return null;
		}
	}

	public List<InsuranceCompany> getAllInsuranceCompanyList(Page page,String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from InsuranceCompany";
			tsql="select count(*) from InsuranceCompany";
		}else{
			sql="from InsuranceCompany where (" + conditions + ")";
			tsql="select count(*) from InsuranceCompany where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<InsuranceCompany> res = query.list();
		return res;
	}
	public List<InsuranceCompany> getAllModelList() {
		// TODO Auto-generated method stub
		//List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		//return res;
		return this.hibernateTemplate.loadAll(InsuranceCompany.class);
	}
	public boolean updateInsuranceCompany(InsuranceCompany model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
