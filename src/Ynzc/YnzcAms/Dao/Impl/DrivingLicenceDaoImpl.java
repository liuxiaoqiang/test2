package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾照DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceDaoImpl.java
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Dao.DrivingLicenceDao;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceReportSource;
import Ynzc.YnzcAms.Model.DrivingLicenceView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class DrivingLicenceDaoImpl implements DrivingLicenceDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicence(DrivingLicence model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicence(DrivingLicence model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicence findDrivingLicenceById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicence> res = hibernateTemplate.find("from DrivingLicence where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicence) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceView> getAllDrivingLicence(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicence_view tab1,(select id from ynzc_drivinglicence where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicence_view tab1,(select id from ynzc_drivinglicence where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicence_view tab1,(select id from ynzc_drivinglicence where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicence_view tab1,(select id from ynzc_drivinglicence where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceView.class).list();
		return res;
	}
	
	public List<DrivingLicenceView> getAllDrivingLicenceQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicence_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicence_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceView.class).list();
		return res;
	}
	
	public List<DrivingLicence> getAllDrivingLicence() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicence.class);
	}

	public boolean updateDrivingLicence(DrivingLicence model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean findDrivingLicenceById(int peopleInfoId,int drivingLicenceType,String drivingLicenceNo) {
		// TODO Auto-generated method stub
		List<DrivingLicence> res = hibernateTemplate.find("from DrivingLicence where peopleInfoId=" + peopleInfoId + " and drivingLicenceTypeId = "+drivingLicenceType+" and drivingLicenceNo = '"+drivingLicenceNo+"'");
		if (res.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean drivingLicencePutOut(String id) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicence set drivingLicenceFlag = 1,startDate = '"+GetDate.getStringDate()+"',endDate = '"+GetDate.addYear(6).toString()+"',putOutDate = '"+GetDate.getStringDate()+"' where id in ("+id+") and drivingLicenceFlag = '0'";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceView> findDrivingLicenceViewById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceView> res = hibernateTemplate.find("from DrivingLicenceView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}
	
	public DrivingLicence findDrivingLicenceByDrivingLicenceNo(String drivingLicenceNo) {
		// TODO Auto-generated method stub
		List<DrivingLicence> res = hibernateTemplate.find("from DrivingLicence where drivingLicenceNo=" + drivingLicenceNo);
		if (res.size() > 0) {
			return (DrivingLicence) res.get(0);
		} else {
			return null;
		}
	}

	public boolean delDrivingLicence(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicence where drivingLicenceFlag = 0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean checkDrivingLicenceOperation(String id) {
		// TODO Auto-generated method stub
		String[] sqls = new String[7];
		int num = 0;
		sqls[0] = "select count(*) from ynzc_drivinglicencechange AS dlchange where dlchange.drivingLicenceId = "+id+" and dlchange.state <4";
		sqls[1] = "select count(*) from ynzc_drivinglicencedefile AS dldefile where dldefile.drivingLicenceId = "+id+" and dldefile.state <4";
		sqls[2] = "select count(*) from ynzc_drivinglicencegoto As dlgoto where dlgoto.drivingLicenceId = "+id+" and dlgoto.state <4";
		sqls[3] = "select count(*) from ynzc_drivinglicencelogout AS dllogout where dllogout.drivingLicenceId = "+id+" and dllogout.state <4";
		sqls[4] = "select count(*) from ynzc_drivinglicencerepair AS dlrepair where dlrepair.drivingLicenceId = "+id+" and dlrepair.state <4";
		sqls[5] = "select count(*) from ynzc_drivinglicenceshiftto AS dlshiftto where dlshiftto.drivingLicenceId = "+id+" and dlshiftto.state <4";
		sqls[6] = "select count(*) from ynzc_drivinglicenceterm AS dlterm where dlterm.drivingLicenceId = "+id+" and dlterm.state <4";
		for(String sql : sqls){
			num += Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
			if(num>0 && num<7){
				break;
			}
		}
		if(num > 0){
			return true;
		}else{
			return false;
		}
	}

	public List<DrivingLicenceReportSource> drivingLicenceReportSource(String id,String peopleInfoId,String drivingLicenceTypeId,int type) {
		// TODO Auto-generated method stub
		String sql="SELECT ynzc_peopleinfo.peopleName, ynzc_peopleinfo.sex,ynzc_peopleinfo.birthday,ynzc_peopleinfo.idCard,ynzc_driverstrinfo.archivesNo,ynzc_drivinglicence.startDate,ynzc_drivinglicence.drivingLicenceTypeId,ynzc_driverstrinfo.applicationDate,ynzc_drivinglicence.endDate,ynzc_peopleinfo.address as address1,'' as address2 FROM ynzc_drivinglicence,ynzc_driverstrinfo,ynzc_peopleinfo where";
		String sqlOperation="select ynzc_drivinglicence_view.peopleName,'' as applicationDate,ynzc_drivinglicence_view.sex,ynzc_drivinglicence_view.birthday,ynzc_drivinglicence_view.idCard,ynzc_drivinglicence_view.idStay,ynzc_drivinglicence_view.address as address1,'' as address2,ynzc_drivinglicence_view.linkAddress,ynzc_drivinglicence_view.linkTel,ynzc_drivinglicence_view.postalcode,ynzc_drivinglicence_view.drivingLicenceTypeId,ynzc_drivinglicence_view.picture,ynzc_drivinglicence_view.endDate from ynzc_drivinglicence_view where ";
		List res = null;
		if(type == 1){
			sql += " ynzc_drivinglicence.id = "+id+" and ynzc_driverstrinfo.peopleInfoId = "+peopleInfoId+" and ynzc_drivinglicence.drivingLicenceTypeId = '"+drivingLicenceTypeId+"' and ynzc_peopleinfo.id = "+peopleInfoId+" and ynzc_drivinglicence.userState = 1";
			res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}else if(type == 2){
			sql += " ynzc_drivinglicence.id = "+id+" and ynzc_drivinglicence.drivingLicenceTypeId = "+drivingLicenceTypeId+" and ynzc_peopleinfo.id = "+peopleInfoId+" and ynzc_drivinglicence.userState = 1";
			res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}else if(type == 3){
			sqlOperation += "ynzc_drivinglicence_view.id = "+id+" and ynzc_drivinglicence_view.peopleInfoId = "+peopleInfoId+" and ynzc_drivinglicence_view.drivingLicenceTypeId = "+drivingLicenceTypeId;
			res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlOperation).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		}
		ObjectListToModelList<DrivingLicenceReportSource> otm=new ObjectListToModelList<DrivingLicenceReportSource>(DrivingLicenceReportSource.class);
		List<DrivingLicenceReportSource> back=new ArrayList();

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

	public boolean Expirydate() {
		// TODO Auto-generated method stub
		String updatesql = "update ynzc_drivinglicence set userState=5 where id in (select id from ynzc_drivinglicence where endDate < now())";
		try {
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(
					updatesql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
