package Ynzc.YnzcAms.Dao.Impl;
/**
 * 人员信息DaoImpl
 * @author zy
 * @date 2011-04-26
 * class PeopleInfoDaoImpl.java
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.PeopleInfoDao;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.PeopleReportSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class PeopleInfoDaoImpl implements PeopleInfoDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addPeopleInfo(PeopleInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delPeopleInfo(PeopleInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public PeopleInfo findPeopleInfoById(int id) {
		// TODO Auto-generated method stub
		List<PeopleInfo> res = hibernateTemplate.find("from PeopleInfo where id=" + id);
		if (res.size() > 0) {
			return (PeopleInfo) res.get(0);
		} else {
			return null;
		}
	}

	public List<PeopleInfo> getAllPeopleInfo(Page page, String conditions,int userId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<PeopleInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PeopleInfo.class).list();
		return res;
	}

	public List<PeopleInfo> getAllPeopleInfo() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(PeopleInfo.class);
	}

	public boolean updatePeopleInfo(PeopleInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean findPeopleInfoByIdCard(String idCard) {
		// TODO Auto-generated method stub
		List<PeopleInfo> res = hibernateTemplate.find("from PeopleInfo where idCard='" + idCard+"'");
		if (res.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean findPeopleInfoByIdStay(String idStay) {
		// TODO Auto-generated method stub
		List<PeopleInfo> res = hibernateTemplate.find("from PeopleInfo where idStay=" + idStay);
		if (res.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<PeopleInfo> getAllPeopleInfoToSelect(Page page,
			String conditions,int userId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and bodyInfoId = 0 order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and bodyInfoId = 0";
		}else{
			sql="select * from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and bodyInfoId = 0 and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_peopleinfo where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and bodyInfoId = 0 and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<PeopleInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PeopleInfo.class).list();
		return res;
	}

	public List<DriverStrInfoView> getAllDriverStrInfoToSelect(Page page,
			String conditions,int userId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_driverstrinfo_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and strState >= 8 order by peopleInfoId desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_driverstrinfo_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and strState >= 8";
		}else{
			sql="select * from ynzc_driverstrinfo_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and strState >= 8 and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_driverstrinfo_view where unitId in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userId+" and ynzc_user.unitid=ynzc_unitmanage.id))) and strState >= 8 and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}

	public PeopleBodyView findDriverStrInfoByPeopleId(int id) {
		// TODO Auto-generated method stub
		String sql="select * from ynzc_peoplebody_view where checkResultFlag = 1 and id = "+id;
		List<PeopleBodyView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(PeopleBodyView.class).list();
		if (res.size() > 0) {
			return (PeopleBodyView) res.get(0);
		} else {
			return null;
		}
	}

	public boolean delUpdatePeopleCheck(int id) {
		// TODO Auto-generated method stub
		String[] str = new String[2];
		int num = 0;
		str[0]="select count(*) from ynzc_driverstrinfo where peopleInfoId = "+id;
		str[1]="select count(*) from ynzc_drivinglicence where peopleInfoId = "+id;
		for(String s : str){
			num += Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(s).uniqueResult().toString());
			if(num>0){
				break;
			}
		}
		if(num>0){
			return false;
		}else{
			return true;
		}
	}

	public boolean delPeopleInfo(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_peopleinfo where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<PeopleReportSource> findPeopleinfo(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT ynzc_driverstrinfo_view.archivesNo,ynzc_driverstrinfo_view.drivingLicenceTypeId,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.birthday,ynzc_driverstrinfo_view.idCard,ynzc_driverstrinfo_view.idStay,ynzc_driverstrinfo_view.address,ynzc_driverstrinfo_view.linkAddress,ynzc_driverstrinfo_view.linkTel,ynzc_driverstrinfo_view.postalcode,ynzc_driverstrinfo_view.picture,ynzc_driverstrinfo_view.peopleName,(select ynzc_driverstrinfo.drivingLicenceTypeId from ynzc_driverstrinfo where ynzc_driverstrinfo.peopleInfoId=ynzc_driverstrinfo_view.peopleInfoId order by ynzc_driverstrinfo.writeDate DESC limit 1,1) ";
		sql += "from ynzc_driverstrinfo_view where ynzc_driverstrinfo_view.id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<PeopleReportSource> otm=new ObjectListToModelList<PeopleReportSource>(PeopleReportSource.class);
		List<PeopleReportSource> back=new ArrayList();
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
	
	public List<PeopleReportSource> findOperationPeopleinfo(int id) {
		// TODO Auto-generated method stub
		String sql="select '' as archivesNo,ynzc_drivinglicence_view.peopleName,ynzc_drivinglicence_view.sex,ynzc_drivinglicence_view.birthday,ynzc_drivinglicence_view.idCard,ynzc_drivinglicence_view.idStay,ynzc_drivinglicence_view.address,ynzc_drivinglicence_view.linkAddress,ynzc_drivinglicence_view.linkTel,ynzc_drivinglicence_view.postalcode,ynzc_drivinglicence_view.picture,ynzc_drivinglicence_view.drivingLicenceTypeId,'' as drivingLicenceTypeId from ynzc_drivinglicence_view where id = "+id+" order by id desc limit 0,1";
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<PeopleReportSource> otm=new ObjectListToModelList<PeopleReportSource>(PeopleReportSource.class);
		List<PeopleReportSource> back=new ArrayList();
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
