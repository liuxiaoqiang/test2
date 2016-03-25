package Ynzc.YnzcAms.Dao.Impl;
/**
 * 实践考试DaoImpl
 * @author zy
 * @date 2011-04-26
 * class PracticeExamDaoImpl.java
 */
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.PracticeExamDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PracticeExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExamView;

public class PracticeExamDaoImpl implements PracticeExamDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addPracticeExam(PracticeExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delPracticeExam(PracticeExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public PracticeExam findPracticeExamById(int id) {
		// TODO Auto-generated method stub
		List<PracticeExam> res = hibernateTemplate.find("from PracticeExam where id=" + id);
		if (res.size() > 0) {
			return (PracticeExam) res.get(0);
		} else {
			return null;
		}
	}

	public List<PracticeExam> getAllPracticeExam(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from PracticeExam";
			tsql="select count(*) from PracticeExam";
		}else{
			sql="from PracticeExam where (" + conditions + ")";
			tsql="select count(*) from PracticeExam where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<PracticeExam> res = query.list();
		return res;
	}

	public List<PracticeExam> getAllPracticeExam() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(PracticeExam.class);
	}

	public boolean updatePracticeExam(PracticeExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public PracticeExam findPracticeExamByStrId(int id) {
		// TODO Auto-generated method stub
		List<PracticeExam> res = hibernateTemplate.find("from PracticeExam where driverStrInfoId=" + id);
		if (res.size() > 0) {
			return (PracticeExam) res.get(0);
		} else {
			return null;
		}
	}

	public boolean PracticeExamPass(int driverClassId) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from ynzc_driverclassteam AS t1,ynzc_driverstrinfo AS t2 where t1.driverStrInfoId = t2.id and driverClassId = "+driverClassId+" and t2.practiceId < 1 and (t2.practiceFlag = 0 or t2.practiceFlag = -1)";
		int num = Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
		if(num>0){
			return false;
		}else{
			return true;
		}
	}

	public boolean addPracticeMakeupExam(PracticeMakeupExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<PracticeMakeupExamView> getAllPracticeMakeupExam(Page page,
			String conditions,int practiceId) {
		// TODO Auto-generated method stub
		List<PracticeMakeupExamView> res = null;
		try{
			String sql="",tsql="";
			if(conditions==""){
				sql="select * from ynzc_practicecammakeup_view where practiceId ="+practiceId+" order by practiceId desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_practicecammakeup_view where practiceId = "+practiceId;
			}else{
				sql="select * from ynzc_practicecammakeup_view where practiceId ="+practiceId+" and (" + conditions + ") order by practiceId desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_practicecammakeup_view where practiceId ="+practiceId+" and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PracticeMakeupExamView.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	public List<PracticeMakeupExamView> getAllPracticeMakeupExamQuery(Page page,
			String conditions,int practiceId) {
		// TODO Auto-generated method stub
		List<PracticeMakeupExamView> res = null;
		try{
			String sql="",tsql="";
				sql="select * from ynzc_practicecammakeup_view where practiceId ="+practiceId+" and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_practicecammakeup_view where practiceId ="+practiceId+" and (" + conditions + ")";
			page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PracticeMakeupExamView.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}

	public List<PracticeMakeupExam> getAllPracticeMakeupExam(int practiceId) {
		// TODO Auto-generated method stub
		List<PracticeMakeupExam> res = null;
		try{
			String sql="";
			sql="select * from ynzc_practicemakeupexam where practiceId = " + practiceId +" order by writeDate Desc limit 0,2";
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PracticeMakeupExam.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}
}
