package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾驶员注销DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceLogoutDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceLogoutDao;
import Ynzc.YnzcAms.Model.DrivingLicenceLogout;
import Ynzc.YnzcAms.Model.DrivingLicenceLogoutView;
import Ynzc.YnzcAms.Model.Page;

public class DrivingLicenceLogoutDaoImpl implements DrivingLicenceLogoutDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceLogout(DrivingLicenceLogout model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceLogout(DrivingLicenceLogout model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceLogout findDrivingLicenceLogoutById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceLogout> res = hibernateTemplate.find("from DrivingLicenceLogout where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceLogout) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceLogoutView> getAllDrivingLicenceLogout(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicencelogout_view tab1,(select id from ynzc_drivinglicencelogout where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencelogout_view tab1,(select id from ynzc_drivinglicencelogout where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicencelogout_view tab1,(select id from ynzc_drivinglicencelogout where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencelogout_view tab1,(select id from ynzc_drivinglicencelogout where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceLogoutView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceLogoutView.class).list();
		return res;
	}
	
	public List<DrivingLicenceLogoutView> getAllDrivingLicenceLogoutQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicencelogout_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicencelogout_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceLogoutView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceLogoutView.class).list();
		return res;
	}

	public List<DrivingLicenceLogout> getAllDrivingLicenceLogout() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceLogout.class);
	}

	public boolean updateDrivingLicenceLogout(DrivingLicenceLogout model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean drivingLicenceLogoutState(String ids, int state) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicencelogout set state = "+state+" where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceLogout(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicencelogout where state=0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceLogoutView> findDrivingLicenceLogoutViewById(
			int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceLogoutView> res = hibernateTemplate.find("from DrivingLicenceLogoutView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}
}
