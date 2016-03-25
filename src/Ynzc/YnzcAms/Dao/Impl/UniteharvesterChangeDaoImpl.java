package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UniteharvesterChangeDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterChange;
import Ynzc.YnzcAms.Model.UniteharvesterChangeView;

public class UniteharvesterChangeDaoImpl implements UniteharvesterChangeDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addUniteharvesterChange(
			UniteharvesterChange uniteharvesterChange) {
		try {
			hibernateTemplate.save(uniteharvesterChange);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUniteharvesterChange(
			UniteharvesterChange uniteharvesterChange) {
		try {
			hibernateTemplate.delete(uniteharvesterChange);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUniteharvesterChange(
			UniteharvesterChange uniteharvesterChange) {
		try {
			hibernateTemplate.update(uniteharvesterChange);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UniteharvesterChangeView> getUniteharvesterChangeAll(Page page,
			String conditions, int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_uniteharvesterchange_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uniteharvesterchange_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_uniteharvesterchange_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uniteharvesterchange_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UniteharvesterChangeView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterChangeView.class).list();
		return res;
	}

}
