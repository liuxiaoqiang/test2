package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾驶员补证DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceRepairDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceRepairDao;
import Ynzc.YnzcAms.Model.DrivingLicenceRepair;
import Ynzc.YnzcAms.Model.DrivingLicenceRepairView;
import Ynzc.YnzcAms.Model.Page;

public class DrivingLicenceRepairDaoImpl implements DrivingLicenceRepairDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceRepair(DrivingLicenceRepair model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceRepair(DrivingLicenceRepair model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceRepair findDrivingLicenceRepairById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceRepair> res = hibernateTemplate.find("from DrivingLicenceRepair where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceRepair) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceRepairView> getAllDrivingLicenceRepair(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicencerepair_view tab1,(select id from ynzc_drivinglicencerepair where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencerepair_view tab1,(select id from ynzc_drivinglicencerepair where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicencerepair_view tab1,(select id from ynzc_drivinglicencerepair where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencerepair_view tab1,(select id from ynzc_drivinglicencerepair where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceRepairView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceRepairView.class).list();
		return res;
	}
	
	public List<DrivingLicenceRepairView> getAllDrivingLicenceRepairQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicencerepair_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicencerepair_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceRepairView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceRepairView.class).list();
		return res;
	}

	public List<DrivingLicenceRepair> getAllDrivingLicenceRepair() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceRepair.class);
	}

	public boolean updateDrivingLicenceRepair(DrivingLicenceRepair model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean drivingLicenceRepairState(String ids, int state) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicencerepair set state = "+state+" where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceRepair(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicencerepair where state=0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceRepairView> findDrivingLicenceRepairViewById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceRepairView> res = hibernateTemplate.find("from DrivingLicenceRepairView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}
}
