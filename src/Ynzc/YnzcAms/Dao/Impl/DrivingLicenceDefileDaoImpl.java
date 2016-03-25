package Ynzc.YnzcAms.Dao.Impl;
/**
 * 污损换证DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceDefileDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceDefileDao;
import Ynzc.YnzcAms.Model.DrivingLicenceDefile;
import Ynzc.YnzcAms.Model.DrivingLicenceDefileView;
import Ynzc.YnzcAms.Model.Page;

public class DrivingLicenceDefileDaoImpl implements DrivingLicenceDefileDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceDefile(DrivingLicenceDefile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceDefile(DrivingLicenceDefile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceDefile findDrivingLicenceDefileByid(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceDefile> res = hibernateTemplate.find("from DrivingLicenceDefile where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceDefile) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceDefileView> getAllDrivingLicenceDefile(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicencedefile_view tab1,(select id from ynzc_drivinglicencedefile where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencedefile_view tab1,(select id from ynzc_drivinglicencedefile where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicencedefile_view tab1,(select id from ynzc_drivinglicencedefile where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicencedefile_view tab1,(select id from ynzc_drivinglicencedefile where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceDefileView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceDefileView.class).list();
		return res;
	}
	
	public List<DrivingLicenceDefileView> getAllDrivingLicenceDefileQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicencedefile_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicencedefile_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceDefileView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceDefileView.class).list();
		return res;
	}

	public List<DrivingLicenceDefile> getAllDrivingLicenceDefile() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceDefile.class);
	}

	public boolean updateDrivingLicenceDefile(DrivingLicenceDefile model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean drivingLicenceDefileState(String ids, int state) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicencedefile set state = "+state+" where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceDefile(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicencedefile where state=0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceDefileView> findDrivingLicenceDefileViewById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceDefileView> res = hibernateTemplate.find("from DrivingLicenceDefileView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}
}
