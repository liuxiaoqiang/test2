package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾照违章记录DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DriverMarkDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DriverMarkDao;
import Ynzc.YnzcAms.Model.DriverMark;
import Ynzc.YnzcAms.Model.Page;

public class DriverMarkDaoImpl implements DriverMarkDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDriverMark(DriverMark model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDriverMark(DriverMark model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DriverMark findDriverMarkById(int id) {
		// TODO Auto-generated method stub
		List<DriverMark> res = hibernateTemplate.find("from DriverMark where id=" + id);
		if (res.size() > 0) {
			return (DriverMark) res.get(0);
		} else {
			return null;
		}
	}

	public List<DriverMark> getAllDriverMark(Page page, String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivermark where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_drivermark where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		}else{
			sql="select * from ynzc_drivermark where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_drivermark where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverMark> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverMark.class).list();
		return res;
	}

	public List<DriverMark> getAllDriverMark() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DriverMark.class);
	}

	public boolean updateDriverMark(DriverMark model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
