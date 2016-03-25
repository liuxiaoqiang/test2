package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UniteharvesterCheckDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCheck;
import Ynzc.YnzcAms.Model.UniteharvesterCheckView;

public class UniteharvesterCheckDaoImpl implements UniteharvesterCheckDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addUniteharvesterCheck(
			UniteharvesterCheck uniteharvesterCheck) {
		try {
			hibernateTemplate.save(uniteharvesterCheck);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUniteharvesterCheck(
			UniteharvesterCheck uniteharvesterCheck) {
		try {
			hibernateTemplate.delete(uniteharvesterCheck);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUniteharvesterCheck(
			UniteharvesterCheck uniteharvesterCheck) {
		try {
			hibernateTemplate.update(uniteharvesterCheck);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UniteharvesterCheckView> getUniteharvesterCheckAll(Page page,
			String conditions, int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_uniteharvestercheck_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uniteharvestercheck_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_uniteharvestercheck_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uniteharvestercheck_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UniteharvesterCheckView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterCheckView.class).list();
		return res;
	}

}
