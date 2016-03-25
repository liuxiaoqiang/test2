package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UniteharvesterRepairDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterRepair;
import Ynzc.YnzcAms.Model.UniteharvesterRepairView;

public class UniteharvesterRepairDaoImpl implements UniteharvesterRepairDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addUniteharvesterRepair(
			UniteharvesterRepair uniteharvesterRepair) {
		try {
			hibernateTemplate.save(uniteharvesterRepair);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUniteharvesterRepair(
			UniteharvesterRepair uniteharvesterRepair) {
		try {
			hibernateTemplate.delete(uniteharvesterRepair);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUniteharvesterRepair(
			UniteharvesterRepair uniteharvesterRepair) {
		try {
			hibernateTemplate.update(uniteharvesterRepair);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UniteharvesterRepairView> getUniteharvesterRepairAll(Page page,
			String conditions, int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_uiteharvesterrepair_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uiteharvesterrepair_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_uiteharvesterrepair_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uiteharvesterrepair_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UniteharvesterRepairView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterRepairView.class).list();
		return res;
	}

}
