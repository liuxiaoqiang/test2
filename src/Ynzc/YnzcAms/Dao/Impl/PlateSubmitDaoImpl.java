package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.PlateSubmitDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateSubmit;
import Ynzc.YnzcAms.Model.UnitManage;

public class PlateSubmitDaoImpl implements PlateSubmitDao {

	private HibernateTemplate hibernateTemplate;
	
	public boolean addNewSubmit(PlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(ps);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delSubmit(PlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.delete(ps);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<PlateSubmit> getAllSubmit(Page page,int unitid,int status) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		sql="select * from ynzc_platesubmit where unitid="+unitid+" and status="+status+" order by status asc limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from PlateSubmit where unitid="+unitid+" and status="+status;
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<PlateSubmit> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PlateSubmit.class).list();
		return res;
	}
	
	public List<PlateSubmit> getAllSubmitWaitMade(Page page) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		sql="select * from ynzc_platesubmit where status=1 order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from PlateSubmit where status=1";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<PlateSubmit> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PlateSubmit.class).list();
		return res;
	}
	

	public boolean updateSubmit(PlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(ps);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean laidAll(PlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(ps);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public PlateSubmit findPlateSubmit(int status,int unitid){
		String sql="";
		sql="select * from ynzc_platesubmit where status="+status+" and unitid="+unitid;
		List<PlateSubmit> plateSubmit =  hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PlateSubmit.class).list();
		if(plateSubmit.size()!=0){
			return plateSubmit.get(0);
		}else{
			return null;
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean updateSubmitData(String pid) {
		try{
		String sql="";
		sql="update ynzc_plate SET status = status+10 where pid like '%"+pid+"'";
		int res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
		return true;
		}catch(Exception e){
			return false;
		}
	}

	public PlateSubmit findPlateSubmit(int id) {
		List<PlateSubmit> res=hibernateTemplate.find("from PlateSubmit where id="+id);
		if(res.size()>0){
			return res.get(0);
		}else{
		return null;
		}
	}

}
