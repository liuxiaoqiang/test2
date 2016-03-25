package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UniteharvesterCancleDao;
import Ynzc.YnzcAms.Model.DrivertrainingView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCancle;
import Ynzc.YnzcAms.Model.UniteharvesterCancleView;

public class UniteharvesterCancleDaoImpl implements UniteharvesterCancleDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addUniteharvesterCancle(
			UniteharvesterCancle uniteharvesterCancle) {
		try {
			hibernateTemplate.save(uniteharvesterCancle);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUniteharvesterCancle(
			UniteharvesterCancle uniteharvesterCancle) {
		try {
			hibernateTemplate.delete(uniteharvesterCancle);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUniteharvesterCancle(
			UniteharvesterCancle uniteharvesterCancle) {
		try {
			hibernateTemplate.update(uniteharvesterCancle);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UniteharvesterCancleView> getUniteharvesterCancleAll(Page page,
			String conditions, int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_uiteharvestercancle_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uiteharvestercancle_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_uiteharvestercancle_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uiteharvestercancle_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UniteharvesterCancleView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterCancleView.class).list();
		return res;
	}

}
