package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.ReaperPlateSubmitDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ReaperPlateSubmit;

public class ReaperPlateSubmitDaoImpl implements ReaperPlateSubmitDao {

	private HibernateTemplate hibernateTemplate;
	
	public boolean addNewSubmit(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(ps);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delSubmit(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.delete(ps);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<ReaperPlateSubmit> getAllSubmit(Page page,int unitid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		sql="select * from ynzc_reaperplatesubmit where unitid="+unitid+" order by status asc limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ReaperPlateSubmit where unitid="+unitid;
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<ReaperPlateSubmit> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(ReaperPlateSubmit.class).list();
		return res;
	}
	
	public List<ReaperPlateSubmit> getAllSubmitWaitMade(Page page) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		sql="select * from ynzc_reaperplatesubmit where status=1 order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ReaperPlateSubmit where status=1";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<ReaperPlateSubmit> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(ReaperPlateSubmit.class).list();
		return res;
	}
	

	public boolean updateSubmit(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(ps);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean laidAll(ReaperPlateSubmit ps) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(ps);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public ReaperPlateSubmit findPlateSubmit(int status,int unitid){
		String sql="";
		sql="select * from ynzc_reaperplatesubmit where status="+status+" and unitid="+unitid;
		List<ReaperPlateSubmit> plateSubmit =  hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(ReaperPlateSubmit.class).list();
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

}
