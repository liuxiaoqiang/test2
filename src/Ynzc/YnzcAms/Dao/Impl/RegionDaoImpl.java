package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.RegionDao;
import Ynzc.YnzcAms.Model.Region;

public class RegionDaoImpl implements RegionDao {

	private HibernateTemplate hibernateTemplate;
	
	public boolean addRegion(Region r) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(r);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delRegion(Region r) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.delete(r);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public Region findRegionByID(int id) {
		// TODO Auto-generated method stub
		List<Region> res=hibernateTemplate.find("from Region where id="+id);
		if(res.size()>0){
			return (Region)res.get(0);
		}else{
			return null;
		}
	}

	public List<Region> getAllCityRegion() {
		// TODO Auto-generated method stub
		List<Region> res=hibernateTemplate.find("from Region where fatherid=0 and treelevel=1");
		return res;
	}

	public List<Region> getCityRegion(int userid){
		String sql="";
		sql="select * from ynzc_region where fatherid =0 and treelevel=1 and id =(select subString(concat(regionid),3,4) from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id='"+userid+"')";
		List<Region> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(Region.class).list();
		return res;	
	}
	public List<Region> getRegionByFatherID(int fatherid) {
		// TODO Auto-generated method stub
		List<Region> res=hibernateTemplate.find("from Region where fatherid="+fatherid);
		return res;
	}

	public boolean updateRegion(Region r) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(r);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
