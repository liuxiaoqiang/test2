package Ynzc.YnzcAms.Dao.Impl;
/**
 * 理论考试DaoImpl
 * @author zy
 * @date 2011-04-26
 * class TheoryExamDaoImpl.java
 */
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TheoryExamDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TheoryExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExamView;

public class TheoryExamDaoImpl implements TheoryExamDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addTheoryExam(TheoryExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delTheoryExam(TheoryExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TheoryExam findTheoryExamById(int id) {
		// TODO Auto-generated method stub
		List<TheoryExam> res = hibernateTemplate.find("from TheoryExam where id=" + id);
		if (res.size() > 0) {
			return (TheoryExam) res.get(0);
		} else {
			return null;
		}
	}

	public List<TheoryExam> getAllTheoryExam(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from TheoryExam";
			tsql="select count(*) from TheoryExam";
		}else{
			sql="from TheoryExam where (" + conditions + ")";
			tsql="select count(*) from TheoryExam where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<TheoryExam> res = query.list();
		return res;
	}

	public List<TheoryExam> getAllTheoryExam() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(TheoryExam.class);
	}

	public boolean updateTheoryExam(TheoryExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TheoryExam findTheoryExamByStrId(int id) {
		// TODO Auto-generated method stub
		List<TheoryExam> res = hibernateTemplate.find("from TheoryExam where driverStrInfoId=" + id);
		if (res.size() > 0) {
			return (TheoryExam) res.get(0);
		} else {
			return null;
		}
	}
	
	public boolean TheoryExamPass(int driverClassInfoId) {
		// TODO Auto-generated method stub
		String sql="select count(*) from ynzc_driverstrinfo AS t1,ynzc_driverclassteam AS t2 where t1.id = t2.driverStrInfoId and t2.driverClassId = "+driverClassInfoId+" and t1.theoryId < 1 and (theoryFlag = -1 or theoryFlag = 0)";
		int num = Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
		if(num>0){
			return false;
		}else{
			return true;
		}
	}

	public List<TheoryMakeupExamView> getAllTheoryMakeupExam(Page page,
			String conditions, int theoryId) {
		// TODO Auto-generated method stub
		List<TheoryMakeupExamView> res = null;
		try{
			String sql="",tsql="";
			if(conditions==""){
				sql="select * from ynzc_theoryexammakeup_view where theoryId = " + theoryId + " order by theoryId desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_theoryexammakeup_view where theoryId = " + theoryId;
			}else{
				sql="select * from ynzc_theoryexammakeup_view where theoryId ="+theoryId+" and (" + conditions + ") order by theoryId desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_theoryexammakeup_view where theoryId ="+theoryId+" and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TheoryMakeupExamView.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	public List<TheoryMakeupExamView> getAllTheoryMakeupExamQuery(Page page,
			String conditions, int theoryId) {
		// TODO Auto-generated method stub
		List<TheoryMakeupExamView> res = null;
		try{
			String sql="",tsql="";
			sql="select * from ynzc_theoryexammakeup_view where theoryId ="+theoryId+" and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select * from ynzc_theoryexammakeup_view where theoryId ="+theoryId+" and (" + conditions + ")";
			page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TheoryMakeupExamView.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}

	public boolean addTheoryMakeupExam(TheoryMakeupExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateTheoryMakeupExam(TheoryMakeupExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delTheoryMakeupExam(TheoryMakeupExam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TheoryMakeupExam findTheoryMakeupExamById(int id) {
		// TODO Auto-generated method stub
		List<TheoryMakeupExam> res = hibernateTemplate.find("from TheoryMakeupExam where theoryId=" + id);
		if (res.size() > 0) {
			return (TheoryMakeupExam) res.get(0);
		} else {
			return null;
		}
	}

	public List<TheoryMakeupExam> getAllTheoryMakeupExam(int theoryId) {
		// TODO Auto-generated method stub
		List<TheoryMakeupExam> res = null;
		try{
			String sql="";
			sql="select * from ynzc_theorymakeupexam where theoryId = " + theoryId +" order by writeDate Desc limit 0,2";
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TheoryMakeupExam.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}
}
