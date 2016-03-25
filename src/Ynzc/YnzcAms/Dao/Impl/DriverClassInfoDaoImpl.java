package Ynzc.YnzcAms.Dao.Impl;
/**
 * 班级DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DriverClassInfoDaoImpl.java
 */
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Dao.DriverClassInfoDao;
import Ynzc.YnzcAms.Model.DriverClassInfo;
import Ynzc.YnzcAms.Model.DriverClassStrView;
import Ynzc.YnzcAms.Model.Page;

public class DriverClassInfoDaoImpl implements DriverClassInfoDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDriverClassInfo(DriverClassInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDriverClassInfo(DriverClassInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DriverClassInfo findDriverClassInfoById(int id) {
		// TODO Auto-generated method stub
		List<DriverClassInfo> res = hibernateTemplate.find("from DriverClassInfo where id=" + id);
		if (res.size() > 0) {
			return (DriverClassInfo) res.get(0);
		} else {
			return null;
		}
	}

	public List<DriverClassInfo> getAllDriverClassInfo() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DriverClassInfo.class);
	}

	public boolean updateDriverClassInfo(DriverClassInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<DriverClassInfo> getAllDriverClassInfo(Page page,String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_driverclassinfo where '"+regionId+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		}else{
			sql="select * from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverClassInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverClassInfo.class).list();
		return res;
	}

	public DriverClassInfo findDriverClassInfoByName(String name,String regionId) {
		// TODO Auto-generated method stub
		String region[]=regionId.split(",");
		String sql = "select * from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and className='" + name + "'";
		List<DriverClassInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverClassInfo.class).list();
		if (res.size() > 0) {
			return (DriverClassInfo) res.get(0);
		} else {
			return null;
		}
	}

	public boolean driverClassInfoDeclare(int type,int classState,String driverClassInfoId) {
		// TODO Auto-generated method stub
		String sql = "update ynzc_driverclassinfo set ";
		if(type == 1){
			sql += "classState ="+classState+" ";
		}else if(type == 2){
			sql += "classState ="+classState+",declareFlag =1,declareDate = '"+GetDate.getStringDate()+"' ";
		}
		sql += "where id in ("+driverClassInfoId+")";
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean driverClassInfoDeclare(int driverClassInfoId) {
		// TODO Auto-generated method stub
		String sql="select count(*) from ynzc_driverstrinfo where applicationFlag<=0 and id in(select driverStrInfoId from ynzc_driverclassteam where driverClassId="+driverClassInfoId+")";
		int num = Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
		if(num>0){
			return false;
		}else{
			return true;
		}
	}

	public List<DriverClassInfo> getAllDriverClassInfoPass(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and declareFlag = 1 order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and declareFlag = 1";
		}else{
			sql="select * from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and declareFlag = 1 and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_driverclassinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and declareFlag = 1 and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverClassInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverClassInfo.class).list();
		return res;
	}

	public List<DriverClassStrView> getAllDriverClassInfoByDriverClassId(Page page,
			String conditions, int driverClassId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_driverclassstr_view tab1,(select driverStrInfoId  from ynzc_driverclassteam where driverClassId ="+driverClassId+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.driverStrInfoId =tab2.driverStrInfoId";
			tsql="select count(*) from ynzc_driverclassstr_view where driverStrInfoId in (select driverStrInfoId  from ynzc_driverclassteam where driverClassId ="+driverClassId+")";
		}else{
			sql="select * from ynzc_driverclassstr_view tab1,(select driverStrInfoId  from ynzc_driverclassteam where driverClassId ="+driverClassId+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.driverStrInfoId =tab2.driverStrInfoId and (" + conditions + ")";
			tsql="select count(*) from ynzc_driverclassstr_view where driverStrInfoId in (select driverStrInfoId  from ynzc_driverclassteam where driverClassId ="+driverClassId+") and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverClassStrView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverClassStrView.class).list();
		return res;
	}
	
	public List<DriverClassStrView> getAllDriverClassInfoByDriverClassIdQuery(Page page,
			String conditions, int driverClassId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		sql="select * from ynzc_driverclassstr_view where driverClassId ="+driverClassId+" and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_driverclassstr_view where driverClassId ="+driverClassId+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverClassStrView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverClassStrView.class).list();
		return res;
	}
}
