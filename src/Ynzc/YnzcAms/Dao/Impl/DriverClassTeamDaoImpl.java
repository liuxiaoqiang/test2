package Ynzc.YnzcAms.Dao.Impl;
/**
 * 班级组DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DriverClassTeamDaoImpl.java
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DriverClassTeamDao;
import Ynzc.YnzcAms.Model.DriverClassTeam;
import Ynzc.YnzcAms.Model.DrivingSkillExamProveSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class DriverClassTeamDaoImpl implements DriverClassTeamDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDriverClassTeam(DriverClassTeam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDriverClassTeam(DriverClassTeam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DriverClassTeam findDriverClassTeamById(int id) {
		// TODO Auto-generated method stub
		List<DriverClassTeam> res = hibernateTemplate.find("from DriverClassTeam where id=" + id);
		if (res.size() > 0) {
			return (DriverClassTeam) res.get(0);
		} else {
			return null;
		}
	}

	public List<DriverClassTeam> getAllDriverClassTeam(Page page,
			String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from DriverClassTeam";
			tsql="select count(*) from DriverClassTeam";
		}else{
			sql="from DriverClassTeam where (" + conditions + ")";
			tsql="select count(*) from DriverClassTeam where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<DriverClassTeam> res = query.list();
		return res;
	}

	public List<DriverClassTeam> getAllDriverClassTeam() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DriverClassTeam.class);
	}

	public boolean updateDriverClassTeam(DriverClassTeam model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDriverClassTeam(int driverClassId,int driverStrInfoId) {
		// TODO Auto-generated method stub
		String sql = "delete from ynzc_driverclassteam where driverClassId = "+driverClassId;
		if(driverStrInfoId == 0){
			sql += " and driverStrInfoId = "+driverStrInfoId;
		}
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean updateDriverStrState(int type,int strState,String driverStrInfoId) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_driverstrinfo set ";
			if(type == 1){
				sql += "strState = "+strState+",applicationFlag =1 ";
			}else{
				sql +="strState = "+strState+" ";
			}
			sql += "where id in ("+driverStrInfoId+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean putOutPermit(int driverClassId, String driverStrId, int type) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_driverclassteam set ";
			if(type == 1){
				sql += "theoryPermitFlag = 1 ";
			}else{
				sql += "practicePermitFlag = 1 ";
			}
			sql += "where driverClassId = "+driverClassId+" and driverStrInfoId in ("+driverStrId+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public String getAllDriverStr(String driverClassId) {
		// TODO Auto-generated method stub
		String sql="";
		sql="select driverStrInfoId from ynzc_driverclassteam where driverClassId in (" + driverClassId + ")";
		Object obj =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).list();
		return obj.toString().replace("[", "").replace("]", "");
	}

	public boolean delDriverClassTeamByDriverStrId(int driverClassId,int driverStrId) {
		// TODO Auto-generated method stub
		String sql = "delete from ynzc_driverclassteam where driverClassId = "+driverClassId+" and driverStrInfoId = "+driverStrId;
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean putOutPermit(int driverClassId) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_driverclassteam set theoryPermitFlag = 1,practicePermitFlag = 1 where driverClassId = "+driverClassId;
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean putOutUnPermit(int driverClassId, String driverStrId,
			int type) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_driverclassteam set ";
			if(type == 1){
				sql += "theoryPermitFlag = 0 ";
			}else{
				sql += "practicePermitFlag = 0 ";
			}
			sql += "where driverClassId = "+driverClassId+" and driverStrInfoId in ("+driverStrId+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingSkillExamProveSource> getStrAllowCertificateInfo(int id,int classInfoId) {
		// TODO Auto-generated method stub
		String sql = "select ynzc_driverstrinfo_view.peopleName,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.birthday,ynzc_driverstrinfo_view.idCard,ynzc_driverstrinfo_view.drivingLicenceTypeId as drivingLicenceName,ynzc_driverstrinfo_view.examinationCode,DATE_FORMAT(now(),'%Y-%m-%d') as startTime,DATE_FORMAT(now()+ INTERVAL 2 YEAR - INTERVAL 1 DAY,'%Y-%m-%d') as endTime,'' as examAddress,'' as write_userId,(select ynzc_driverclassinfo.practiceExamDate from ynzc_driverclassinfo where id = "+classInfoId+") as writeDate" +
		" from ynzc_driverstrinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<DrivingSkillExamProveSource> otm=new ObjectListToModelList<DrivingSkillExamProveSource>(DrivingSkillExamProveSource.class);
		List<DrivingSkillExamProveSource> back=new ArrayList();
		try {
			back = otm.getModelList(res);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return back;
	}
}
