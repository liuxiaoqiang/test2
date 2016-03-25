package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾驶员注销DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceTermDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceTermDao;
import Ynzc.YnzcAms.Model.DrivingLicenceTerm;
import Ynzc.YnzcAms.Model.DrivingLicenceTermView;
import Ynzc.YnzcAms.Model.Page;

public class DrivingLicenceTermDaoImpl implements DrivingLicenceTermDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceTerm(DrivingLicenceTerm model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceTerm(DrivingLicenceTerm model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceTerm findDrivingLicenceTermById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceTerm> res = hibernateTemplate.find("from DrivingLicenceTerm where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceTerm) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceTermView> getAllDrivingLicenceTerm(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicenceterm_view tab1,(select id from ynzc_drivinglicenceterm where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicenceterm_view tab1,(select id from ynzc_drivinglicenceterm where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicenceterm_view tab1,(select id from ynzc_drivinglicenceterm where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicenceterm_view tab1,(select id from ynzc_drivinglicenceterm where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceTermView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceTermView.class).list();
		return res;
	}
	
	public List<DrivingLicenceTermView> getAllDrivingLicenceTermQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicenceterm_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicenceterm_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceTermView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceTermView.class).list();
		return res;
	}

	public List<DrivingLicenceTerm> getAllDrivingLicenceTerm() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceTerm.class);
	}

	public boolean updateDrivingLicenceTerm(DrivingLicenceTerm model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean drivingLicenceTermState(String ids, int state) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicenceterm set state = "+state+" where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceTerm(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicenceterm where state=0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceTermView> findDrivingLicenceTermViewById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceTermView> res = hibernateTemplate.find("from DrivingLicenceTermView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}
}
