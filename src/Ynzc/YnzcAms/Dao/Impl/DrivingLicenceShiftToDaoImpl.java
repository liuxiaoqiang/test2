package Ynzc.YnzcAms.Dao.Impl;
/**
 * 驾驶员转出DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DrivingLicenceShiftToDaoImpl.java
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.DrivingLicenceShiftToDao;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftTo;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftToView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorLicenseOutNoticeSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class DrivingLicenceShiftToDaoImpl implements DrivingLicenceShiftToDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDrivingLicenceShiftTo(DrivingLicenceShiftTo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceShiftTo(DrivingLicenceShiftTo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DrivingLicenceShiftTo findDrivingLicenceShiftToById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceShiftTo> res = hibernateTemplate.find("from DrivingLicenceShiftTo where id=" + id);
		if (res.size() > 0) {
			return (DrivingLicenceShiftTo) res.get(0);
		} else {
			return null;
		}
	}

	public List<DrivingLicenceShiftToView> getAllDrivingLicenceShiftTo(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_drivinglicenceshiftto_view tab1,(select id from ynzc_drivinglicenceshiftto where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicenceshiftto_view tab1,(select id from ynzc_drivinglicenceshiftto where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id=tab2.id";
		}else{
			sql="select * from ynzc_drivinglicenceshiftto_view tab1,(select id from ynzc_drivinglicenceshiftto where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id=tab2.id";
			tsql="select count(*) from ynzc_drivinglicenceshiftto_view tab1,(select id from ynzc_drivinglicenceshiftto where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")) tab2 where tab1.id=tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceShiftToView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceShiftToView.class).list();
		return res;
	}
	
	public List<DrivingLicenceShiftToView> getAllDrivingLicenceShiftToQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_drivinglicenceshiftto_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_drivinglicenceshiftto_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DrivingLicenceShiftToView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DrivingLicenceShiftToView.class).list();
		return res;
	}

	public List<DrivingLicenceShiftTo> getAllDrivingLicenceShiftTo() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DrivingLicenceShiftTo.class);
	}

	public boolean updateDrivingLicenceShiftTo(DrivingLicenceShiftTo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean drivingLicenceShiftToState(String ids, int state) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_drivinglicenceshiftto set state = "+state+" where id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDrivingLicenceShiftTo(String ids) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from ynzc_drivinglicenceshiftto where state=0 and id in ("+ids+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DrivingLicenceShiftToView> findDrivingLicenceShiftToViewById(int id) {
		// TODO Auto-generated method stub
		List<DrivingLicenceShiftToView> res = hibernateTemplate.find("from DrivingLicenceShiftToView where id=" + id);
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}

	public List<TractorLicenseOutNoticeSource> tractorLicenseOutNotice(int id) {
		// TODO Auto-generated method stub
		String sql="select ynzc_drivinglicenceshiftto_view.goToAddress as goToAddress,ynzc_drivinglicenceshiftto_view.drivingLicenceNo as drivingLicenceNo,ynzc_drivinglicenceshiftto_view.peopleName as peopleName,ynzc_drivinglicenceshiftto_view.drivingLicenceTypeId as drivingLicenceTypeId,(select username from ynzc_user where id = ynzc_drivinglicenceshiftto_view.writeUserId) as registerTransactor,ynzc_drivinglicenceshiftto_view.writeDate as registerTransactorDate,(select useunit from ynzc_unitmanage where id = ynzc_drivinglicenceshiftto_view.shiftToAddress) as front_unitId,ynzc_drivinglicenceshiftto_view.postalcode as zipcode,ynzc_drivinglicenceshiftto_view.linkTel as linktel from ynzc_drivinglicenceshiftto_view " +
		"where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorLicenseOutNoticeSource> otm=new ObjectListToModelList<TractorLicenseOutNoticeSource>(TractorLicenseOutNoticeSource.class);
		List<TractorLicenseOutNoticeSource> back=new ArrayList();
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
