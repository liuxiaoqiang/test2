package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UniteharvesterDao;
import Ynzc.YnzcAms.Model.DrivertraingTractorinfoView;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterView;

public class UniteharvesterDaoImpl implements UniteharvesterDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(uniteharvester);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean saveUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(uniteharvester);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(uniteharvester);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUniteharvester(Uniteharvester uniteharvester) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(uniteharvester);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UniteharvesterView> getUniteharvesterViewAll(Page page,
			String conditions, int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_uniteharvester_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uniteharvester_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_uniteharvester_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uniteharvester_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UniteharvesterView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterView.class).list();
		return res;
	}

	public Uniteharvester findUniteharvesterById(int id) {
		// TODO Auto-generated method stub
		List<Uniteharvester> res = hibernateTemplate.find("from Uniteharvester where id=" + id);
		if (res.size() > 0) {
			return (Uniteharvester) res.get(0);
		} else {
			return null;
		}
	}

	public UniteharvesterView findUniteharvesterByCarNum(String carnum, int userid) {
		// TODO Auto-generated method stub
		String sql="";
		sql="select * from ynzc_uniteharvester_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and harvesterCode='"+carnum+"'";
		List<UniteharvesterView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterView.class).list();
		if (res.size() > 0) {
			return (UniteharvesterView) res.get(0);
		} else {
			return null;
		}
	}
	public UniteharvesterView findUniteharvesterViewById(int id) {
		// TODO Auto-generated method stub
		List<UniteharvesterView> res = hibernateTemplate.find("from UniteharvesterView where id=" + id);
		if (res.size() > 0) {
			return (UniteharvesterView) res.get(0);
		} else {
			return null;
		}
	}

}
