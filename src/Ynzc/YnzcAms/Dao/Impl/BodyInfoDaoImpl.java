package Ynzc.YnzcAms.Dao.Impl;
/**
 * 身体状况信息DaoImpl
 * @author zy
 * @date 2011-04-26
 * class BodyInfoDaoImpl.java
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.BodyInfoDao;
import Ynzc.YnzcAms.Model.BodyInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyInfoReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class BodyInfoDaoImpl implements BodyInfoDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean addBodyInfo(BodyInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delBodyInfo(BodyInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delMoreBodyInfo(String str) {
		// TODO Auto-generated method stub
		String sql = "delete from ynzc_bodyinfo where id in ("+str+")";
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public BodyInfo findBodyInfoById(int id) {
		// TODO Auto-generated method stub
		List<BodyInfo> res = hibernateTemplate.find("from BodyInfo where id=" + id);
		if (res.size() > 0) {
			return (BodyInfo) res.get(0);
		} else {
			return null;
		}
	}

	public List<PeopleBodyView> getAllBodyInfo(Page page, String conditions,int userId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_peoplebody_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by peopleInfoId desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_peoplebody_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_peoplebody_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_peoplebody_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<PeopleBodyView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PeopleBodyView.class).list();
		return res;
	}

	public List<BodyInfo> getAllBodyInfo() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(BodyInfo.class);
	}

	public boolean updateBodyInfo(BodyInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public BodyInfo findBodyInfoByPeopleInfoId(int peopleInfoId) {
		// TODO Auto-generated method stub
		List<BodyInfo> res = hibernateTemplate.find("from BodyInfo where peopleInfoId=" + peopleInfoId + "order by writeDate DESC");
		if (res.size() > 0) {
			return (BodyInfo) res.get(0);
		} else {
			return null;
		}
	}

	public boolean delBodyCheck(int id) {
		// TODO Auto-generated method stub
		String sql="select count(*) from ynzc_peopleinfo where bodyInfoId = "+id;
		int num = Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
		if(num>0){
			return false;
		}else{
			return true;
		}
	}

	public List<PeopleBodyReportSource> getAllBodyInfo(int id) {
		// TODO Auto-generated method stub
		String sql="select ynzc_driverstrinfo_view.peopleName,ynzc_driverstrinfo_view.drivingLicenceTypeId as drivingLicenceName,ynzc_driverstrinfo_view.birthday,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.archivesNo,ynzc_driverstrinfo_view.idCard,'' as realcertificatetype,ynzc_driverstrinfo_view.hight,ynzc_driverstrinfo_view.resolvingPowerFlag,ynzc_driverstrinfo_view.rightEyePwoer,ynzc_driverstrinfo_view.rightEyeRectificationFlag,ynzc_driverstrinfo_view.leftEyePwoer,ynzc_driverstrinfo_view.leftEyeRectificationFlag,ynzc_driverstrinfo_view.rightEarPwoer,ynzc_driverstrinfo_view.leftEarPwoer,ynzc_driverstrinfo_view.rightHandFlag,ynzc_driverstrinfo_view.leftHandFlag,ynzc_driverstrinfo_view.bodyCheckDate,ynzc_driverstrinfo_view.picture,ynzc_driverstrinfo_view.rightLagFlag,ynzc_driverstrinfo_view.leftLagFlag,ynzc_driverstrinfo_view.bodyNeck " +
				"from ynzc_driverstrinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<PeopleBodyReportSource> otm=new ObjectListToModelList<PeopleBodyReportSource>(PeopleBodyReportSource.class);
		List<PeopleBodyReportSource> back=new ArrayList();
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

	public List<PeopleBodyInfoReportSource> getBodyInfo(int id) {
		// TODO Auto-generated method stub
		String sql="select ynzc_driverstrinfo_view.peopleName,ynzc_driverstrinfo_view.drivingLicenceTypeId as drivingLicenceName,ynzc_driverstrinfo_view.birthday,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.archivesNo,ynzc_driverstrinfo_view.idCard,'' as realcertificatetype,ynzc_driverstrinfo_view.picture " +
		"from ynzc_driverstrinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<PeopleBodyInfoReportSource> otm=new ObjectListToModelList<PeopleBodyInfoReportSource>(PeopleBodyInfoReportSource.class);
		List<PeopleBodyInfoReportSource> back=new ArrayList();
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
