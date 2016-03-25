package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UnitManageDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;

public class UnitManageDaoImpl implements UnitManageDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addModel(UnitManage model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(UnitManage model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UnitManage findModelById(int id) {
		// TODO Auto-generated method stub
		List<UnitManage> res = hibernateTemplate.find("from UnitManage where id=" + id);
		if (res.size() > 0) {
			return (UnitManage) res.get(0);
		} else {
			return null;
		}
	}

	public List<UnitManage> getAllModelList(Page page,String conditions,String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(","));
		if(conditions==""){
			sql="select * from ynzc_unitmanage where '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from UnitManage where '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		}else{
			sql="select * from ynzc_unitmanage where '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from UnitManage where (" + conditions + ") and '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<UnitManage> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UnitManage.class).list();
		return res;
	}

	public boolean updateModel(UnitManage model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<UnitManage> getAllModelList() {
		// TODO Auto-generated method stub
		List<UnitManage> res=hibernateTemplate.loadAll(UnitManage.class);
		return res;
	}
	public List<UnitManage> getUnitManageByRegionid(String regionid) {
		// TODO Auto-generated method stub
		List<UnitManage> res=hibernateTemplate.find("from UnitManage where regionid='" + regionid+"'");
		if (res.size() > 0) {
			return  res;
		} else {
			return null;
		}
	}
	public List<UnitManage> getAllModelList(Page page, String conditions,
			int unitid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+")";
		}else{
			sql="select * from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+") and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<UnitManage> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UnitManage.class).list();
		return res;
	}
	
	public List<UnitManage> getAllModelList(String regionid) {
		// TODO Auto-generated method stub
		String region[]=regionid.split(",");
		String sql="select * from ynzc_unitmanage where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id asc";
		List<UnitManage> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UnitManage.class).list();
		return res;
	}

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public UnitManage getUnitByCode(String platecode) {
		List<UnitManage> res=hibernateTemplate.find("from UnitManage where platecode='"+platecode+"' order by id asc");
		if(res.size()>0){
			return res.get(0);
		}else{
			return null;
		}
	}

	public List<UnitManage> getAreaUnit(int userid) {
		String sql="select * from ynzc_unitmanage where id in(select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		List<UnitManage> res=hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(UnitManage.class).list();
		return res;
	}
	public UnitManage findUnitManageByUnitName(String unitname){
		List<UnitManage> res = hibernateTemplate.find("from UnitManage where useunit='" + unitname+"'");
		if (res.size() > 0) {
			return (UnitManage) res.get(0);
		} else {
			return null;
		}
	}
	
}
