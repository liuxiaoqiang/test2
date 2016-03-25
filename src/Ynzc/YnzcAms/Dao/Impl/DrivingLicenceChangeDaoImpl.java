package Ynzc.YnzcAms.Dao.Impl;
/**
 * 信息变化换证DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceChangeDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceChangeDao;
import Ynzc.YnzcAms.Model.DrivingLicenceChange;
import Ynzc.YnzcAms.Model.DrivingLicenceChangeView;
import Ynzc.YnzcAms.Model.Page;

public class DrivingLicenceChangeDaoImpl implements DrivingLicenceChangeDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceChange(DrivingLicenceChange model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceChange(DrivingLicenceChange model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceChange findDrivingLicenceChangeById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceChange> res = hibernateTemplate.find("from DrivingLicenceChange where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceChange) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceChange> getAllDDrivingLicenceChange() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceChange.class);
	}

	public List<DrivingLicenceChangeView> getAllDrivingLicenceChange(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicencechange_view tab1,(select id from ynzc_drivinglicencechange where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencechange_view tab1,(select id from ynzc_drivinglicencechange where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicencechange_view tab1,(select id from ynzc_drivinglicencechange where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencechange_view tab1,(select id from ynzc_drivinglicencechange where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceChangeView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceChangeView.class).list();
		return res;
	}
	
	public List<DrivingLicenceChangeView> getAllDrivingLicenceChangeQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicencechange_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicencechange_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceChangeView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceChangeView.class).list();
		return res;
	}

	public boolean updateDrivingLicenceChange(DrivingLicenceChange model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean drivingLicenceChangeState(String ids, int state) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicencechange set state = "+state+" where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceChangeState(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicencechange where state=0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceChangeView> findDrivingLicenceChangeViewById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceChangeView> res = hibernateTemplate.find("from DrivingLicenceChangeView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}
}
