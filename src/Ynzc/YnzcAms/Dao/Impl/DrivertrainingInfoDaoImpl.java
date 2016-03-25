package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivertrainingInfoDao;
import Ynzc.YnzcAms.Model.DrivertraingTractorinfoView;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;
import Ynzc.YnzcAms.Model.DrivertrainingView;
import Ynzc.YnzcAms.Model.Page;

public class DrivertrainingInfoDaoImpl implements DrivertrainingInfoDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 增加教练机
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public boolean addDrivertrainingInfo(DrivertrainingInfo drivertrainingInfo) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(drivertrainingInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 删除教练机
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public boolean deleteDrivertrainingInfo(
			DrivertrainingInfo drivertrainingInfo) {
		try {
			hibernateTemplate.delete(drivertrainingInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 更新教练机
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public boolean updateDrivertrainingInfo(
			DrivertrainingInfo drivertrainingInfo) {
		try {
			hibernateTemplate.update(drivertrainingInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获得所有教练机信息
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public List<DrivertrainingView> getDrivertrainingInfoAll(Page page,
			String conditions,int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_drivertraining_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_drivertraining_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_drivertraining_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_drivertraining_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivertrainingView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivertrainingView.class).list();
		return res;
	}

	/**
	 * 根据传入的拖拉机号牌，获得拖拉机其他信息
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public DrivertraingTractorinfoView getDrivertraingTractorinfoView(
			String carCode,int userid) {
		String sql="";
		sql="select * from ynzc_drivertraing_tractor_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and license='"+carCode+"'";
		List<DrivertraingTractorinfoView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivertraingTractorinfoView.class).list();
		if (res.size() > 0) {
			return (DrivertraingTractorinfoView) res.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 获得教练机信息以及年检信息
	 * @author wyb
	 * @date 2011-05-20
	 **/
	public List<DrivertrainingInfoView> getDrivertrainingInfoViewAll(Page page,
			String conditions,int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_drivertraining_info_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_drivertraining_info_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_drivertraining_info_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_drivertraining_info_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivertrainingInfoView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivertrainingInfoView.class).list();
		return res;
	}

	/**
	 * 根据传入的教练车id，获得该教练车的信息
	 * @author wyb
	 * @date 2011-05-21
	 **/
	public DrivertrainingInfo FindById(int id) {
		List<DrivertrainingInfo> res = hibernateTemplate.find("from DrivertrainingInfo where id=" + id);
		if (res.size() > 0) {
			return (DrivertrainingInfo) res.get(0);
		} else {
			return null;
		}
	}
	/**
	 * 根据传入的拖拉机id，获得该拖拉机的信息
	 * @author wyb
	 * @date 2011-05-23
	 **/
	public DrivertraingTractorinfoView FindDrivertraingTractorinfoViewById(
			int id) {
		List<DrivertraingTractorinfoView> res = hibernateTemplate.find("from DrivertraingTractorinfoView where id=" + id);
		if (res.size() > 0) {
			return (DrivertraingTractorinfoView) res.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 根据传入教练车号码获得教练机信息
	 * @author wyb
	 * @date 2011-05-21
	 **/
	public DrivertrainingInfo findDrivertrainingInfoViewByCarNum(
			String carnum, int userid) {
		String sql="";
		sql="select * from ynzc_drivertraining where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and CardCode='"+carnum+"'";
		List<DrivertrainingInfo> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivertrainingInfo.class).list();
		if (res.size() > 0) {
			return (DrivertrainingInfo) res.get(0);
		} else {
			return null;
		}
	}

}
