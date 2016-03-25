package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UniteharvesterMoveDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterMove;
import Ynzc.YnzcAms.Model.UniteharvesterMoveView;

public class UniteharvesterMoveDaoImpl implements UniteharvesterMoveDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addUniteharvesterMove(UniteharvesterMove uniteharvesterMove) {
		try {
			hibernateTemplate.save(uniteharvesterMove);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUniteharvesterMove(UniteharvesterMove uniteharvesterMove) {
		try {
			hibernateTemplate.delete(uniteharvesterMove);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUniteharvesterMove(
			UniteharvesterMove uniteharvesterMove) {
		try {
			hibernateTemplate.update(uniteharvesterMove);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UniteharvesterMoveView> getUniteharvesterMoveAll(Page page,
			String conditions, int userid) {
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="select * from ynzc_uiteharvestermove_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uiteharvestermove_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+"))";
		}else{
			sql="select * from ynzc_uiteharvestermove_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_uiteharvestermove_view where unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UniteharvesterMoveView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UniteharvesterMoveView.class).list();
		return res;
	}

}
