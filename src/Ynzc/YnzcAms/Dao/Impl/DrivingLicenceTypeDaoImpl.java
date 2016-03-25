package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾照类型DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceTypeDaoImpl.java
 */
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceTypeDao;
import Ynzc.YnzcAms.Model.DrivingLicenceType;
import Ynzc.YnzcAms.Model.Page;

public class DrivingLicenceTypeDaoImpl implements DrivingLicenceTypeDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceType(DrivingLicenceType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceType(DrivingLicenceType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceType findDrivingLicenceTypeById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceType> res = hibernateTemplate.find("from DrivingLicenceType where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceType) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceType> getAllDrivingLicenceType(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from DrivingLicenceType";
			tsql="select count(*) from DrivingLicenceType";
		}else{
			sql="from DrivingLicenceType where (" + conditions + ")";
			tsql="select count(*) from DrivingLicenceType where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<DrivingLicenceType> res = query.list();
		return res;
	}

	public List<DrivingLicenceType> getAllDrivingLicenceType() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceType.class);
	}

	public boolean updateDrivingLicenceType(DrivingLicenceType model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
