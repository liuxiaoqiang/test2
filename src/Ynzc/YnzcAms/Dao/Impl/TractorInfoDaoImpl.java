package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TractorInfoDao;
import Ynzc.YnzcAms.Model.CarInfomationSource;
import Ynzc.YnzcAms.Model.CarMoveReportSource;
import Ynzc.YnzcAms.Model.CarSafetyRoportSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TechnicalDataSource;
import Ynzc.YnzcAms.Model.TractorEnregisterCertificateReportSource;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorInfoRegisterYear;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class TractorInfoDaoImpl implements TractorInfoDao {
	private HibernateTemplate hibernateTemplate;
	public boolean addTractorInfo(TractorInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delTractorInfo(TractorInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delTractorInfoByIds(String ids)
	{
		String sql="delete from TractorInfo  where id in ( "+ids+" )";
		int result = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
        if(result>0){
        	return true;
        }
        else{
        	return false;
        }
	}
	public boolean updateTractorStateByIds(int state,String ids,String condtion){
		String sql="update TractorInfo set status="+state+" where id in ( "+ids+" )";
		if(condtion!=""){
			sql+=" and "+condtion;
		}
		int result = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
        if(result>0){
        	return true;
        }
        else{
        	return false;
        }
	}
	public TractorInfo findTractorInfoById(int id) {
		// TODO Auto-generated method stub
		List<TractorInfo> res = hibernateTemplate.find("from TractorInfo where id=" + id);
		if (res.size() > 0) {
			return (TractorInfo) res.get(0);
		} else {
			return null;
		}
	}
	
	public List<TractorInfo> getAllTractorInfoList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from TractorInfo";
			tsql="select count(*) from TractorInfo";
		}else{
			sql="from TractorInfo where (" + conditions + ")";
			tsql="select count(*) from TractorInfo where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<TractorInfo> res = query.list();
		return res;
	}
	public List<TractorInfo> getTractorInfoListByIds(String ids){
		String sql="";
		sql="from TractorInfo where id in (" + ids + ")";
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		List<TractorInfo> res = query.list();
		return res;
	}
	public boolean auditTractorInfo(int state,String ids){
		String sql="update ynzc_tractorinfo set status="+state+",checkeddate=now() where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean auditTractorInfoFiling(int filing,String ids){
		String sql="update ynzc_tractorinfo set filing="+filing+",checkeddate=now() where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateLicenseById(String license,int id){
		String sql="update ynzc_tractorinfo set license='"+license+"' where id="+id;	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateTractorInfo(TractorInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean GuiDang(String ids,int type) {
		// TODO Auto-generated method stub
		String sql="update ynzc_tractorinfo set filing="+type+",filingDate=curdate() where id in ("+ids+")";
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<CarInfomationSource> tractorInfoReport(int id) {
		// TODO Auto-generated method stub
		String sql = "select ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.unitid,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.telephone,ynzc_tractorinfo_view.realcertificatetype,ynzc_tractorinfo_view.realcertificateno,ynzc_tractorinfo_view.isUnion,ynzc_tractorinfo_view.address,ynzc_tractorinfo_view.zipCode,ynzc_tractorinfo_view.istemplived,ynzc_tractorinfo_view.templivefileType,ynzc_tractorinfo_view.timplivefileno,ynzc_tractorinfo_view.getway,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.manufacturer,ynzc_tractorinfo_view.manufacturedate,ynzc_tractorinfo_view.seller,ynzc_tractorinfo_view.price,ynzc_tractorinfo_view.getwayfiletypeid,ynzc_tractorinfo_view.getwayfileno,ynzc_tractorinfo_view.importsfiletypeid,ynzc_tractorinfo_view.importsfileno,ynzc_tractorinfo_view.insurancelistno,ynzc_tractorinfo_view.insurancecompanyname,ynzc_tractorinfo_view.insurancedate,ynzc_tractorinfo_view.expirydate,ynzc_tractorinfo_view.registerdate,ynzc_tractorinfo_view.turnindate,ynzc_tractorinfo_view.beforeregion,ynzc_tractorinfo_view.issuedate,ynzc_tractorinfo_view.checkexpirydate,ynzc_tractorinfo_view.issuedate,ynzc_tractorinfo_view.checkexpirydate,ynzc_tractorinfo_view.photourl as photoUrl,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.`status`, \"\" as whetherStop, \"\" as mortgageDate, \"\" as stopDate,(select count(*)from ynzc_changerecord where tractorinfoid=ynzc_tractorinfo_view.id)as registrationCertificatrNum,(select ynzc_changerecord.opertatedate from ynzc_changerecord where tractorinfoId=ynzc_tractorinfo_view.id order by ynzc_changerecord.opertatedate DESC limit 0,1)as registrationCertificatrDate,(select ynzc_tractorreplacementinfo.flapperDirectorDate from ynzc_tractorreplacementinfo where tractorinfoId=ynzc_tractorinfo_view.id order by ynzc_tractorreplacementinfo.flapperDirectorDate DESC limit 0,1)as flapperDirectorDate,(select count(*)from ynzc_carchange where tractorinfoId=ynzc_tractorinfo_view.id)as changeNumber,(select ynzc_carchange.applicationtime from ynzc_carchange where tractorinfoId=ynzc_tractorinfo_view.id order by ynzc_carchange.applicationtime DESC limit 0,1)as applicationtime,(select ynzc_changerecord.opertatedate from ynzc_changerecord where tractorinfoId=ynzc_tractorinfo_view.id order by ynzc_changerecord.opertatedate DESC limit 0,1)as opertatedate,(select count(*)from ynzc_changerecord where tractorinfoid=ynzc_tractorinfo_view.id)as recordnumber,(select ynzc_cartransfer.applydate from ynzc_cartransfer where tractorinfoId=ynzc_tractorinfo_view.id order by ynzc_cartransfer.applydate DESC limit 0,1)as applydate,(select count(*)from ynzc_cartransfer where tractorinfoId=ynzc_tractorinfo_view.id)as transferNum,(select ynzc_tractorreplacementinfo.operatorDate from ynzc_tractorreplacementinfo where tractorinfoId=ynzc_tractorinfo_view.id order by ynzc_tractorreplacementinfo.operatorDate DESC limit 0,1) as operatorDate from ynzc_tractorinfo_view where id="+id;
		//sql = "select * from ynzc_tractorinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarInfomationSource> otm=new ObjectListToModelList<CarInfomationSource>(CarInfomationSource.class);
		List<CarInfomationSource> back=new ArrayList();
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
	
	public List<TractorRegistrationAndTurnInSource> tractorInfoReportTwo(int id) {
		// TODO Auto-generated method stub
		String sql = "select ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.telephone,ynzc_tractorinfo_view.zipCode,ynzc_tractorinfo_view.address,ynzc_tractorinfo_view.realcertificatetype,ynzc_tractorinfo_view.templivefiletype,ynzc_tractorinfo_view.timplivefileno,ynzc_tractorinfo_view.plantType,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.insurancedate,ynzc_tractorinfo_view.insurancecompanyname,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.region as unitid,ynzc_tractorinfo_view.tempaddress,ynzc_tractorinfo_view.realcertificateno,'' as tempCode from ynzc_tractorinfo_view where id="+id;
		//sql = "select * from ynzc_tractorinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorRegistrationAndTurnInSource> otm=new ObjectListToModelList<TractorRegistrationAndTurnInSource>(TractorRegistrationAndTurnInSource.class);
		List<TractorRegistrationAndTurnInSource> back=new ArrayList();
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
	
	public List<TechnicalDataSource> tractorInfoReportThree(int id) {
		// TODO Auto-generated method stub
		String sql = "select ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.telephone,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.plantType,ynzc_tractorinfo_view.machinebodycolor,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.outsize,ynzc_tractorinfo_view.containersize,ynzc_tractorinfo_view.wheelno,ynzc_tractorinfo_view.wheelbase,ynzc_tractorinfo_view.vicecartiresno,ynzc_tractorinfo_view.outcarwheeldis,ynzc_tractorinfo_view.steelspring,ynzc_tractorinfo_view.outcartiressize,ynzc_tractorinfo_view.region as unitid,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.`power`,ynzc_tractorinfo_view.cylinderno,ynzc_tractorinfo_view.tiressize as tiresSize,ynzc_tractorinfo_view.wheeldis,ynzc_tractorinfo_view.allquality,ynzc_tractorinfo_view.allowdragtotalquality,ynzc_tractorinfo_view.driverinno,ynzc_tractorinfo_view.directcontrol,ynzc_tractorinfo_view.tiresno,ynzc_tractorinfo_view.wheelno,ynzc_tractorinfo_view.totalquality,ynzc_tractorinfo_view.fuelname,ynzc_tractorinfo_view.ratifiedload,ynzc_tractorinfo_view.regcerno from ynzc_tractorinfo_view where id="+id;
		//sql = "select * from ynzc_tractorinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TechnicalDataSource> otm=new ObjectListToModelList<TechnicalDataSource>(TechnicalDataSource.class);
		List<TechnicalDataSource> back=new ArrayList();
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
	
	public List<CarSafetyRoportSource> tractorInfoReportFour(int id) {
		// TODO Auto-generated method stub
		String sql = "select ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.address,ynzc_tractorinfo_view.telephone,ynzc_tractorinfo_view.machinetype as machineType,ynzc_tractorinfo_view.plantType,ynzc_tractorinfo_view.machinebodycolor,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.showinitialinspectionresult,ynzc_tractorinfo_view.showdisqualification,ynzc_tractorinfo_view.showexaminationresult,ynzc_tractorinfo_view.engineinitialinspectionresult,ynzc_tractorinfo_view.enginedisqualification,ynzc_tractorinfo_view.engineexaminationresult,ynzc_tractorinfo_view.conveyorinitialinspectionresult,ynzc_tractorinfo_view.conveyordisqualification,ynzc_tractorinfo_view.conveyorexaminationresult,ynzc_tractorinfo_view.steeringinitialinspectionresult,ynzc_tractorinfo_view.steeringdisqualification,ynzc_tractorinfo_view.steeringexaminationresult,ynzc_tractorinfo_view.flyhostinitialinspectionresult,ynzc_tractorinfo_view.flyhostdisqualification,ynzc_tractorinfo_view.flyhostexaminationresult,ynzc_tractorinfo_view.flytrailerinitialinspectionresult,ynzc_tractorinfo_view.flytrailerdisqualification,ynzc_tractorinfo_view.flytrailerexaminationresult,ynzc_tractorinfo_view.brakhostinitialinspectionresult,ynzc_tractorinfo_view.brakhostdisqualification,ynzc_tractorinfo_view.brakhostexaminationresult,ynzc_tractorinfo_view.braktrailerinitialinspectionresult,ynzc_tractorinfo_view.braktrailerdisqualification,ynzc_tractorinfo_view.braktrailerexaminationresult,ynzc_tractorinfo_view.lighthostinitialinspectionresult,ynzc_tractorinfo_view.lighthostdisqualification,ynzc_tractorinfo_view.lighthostexaminationresult,ynzc_tractorinfo_view.lighttrailerinitialinspectionresult,ynzc_tractorinfo_view.lighttrailerdisqualification,ynzc_tractorinfo_view.lighttrailerexaminationresult,ynzc_tractorinfo_view.tractioninitialinspectionresult,ynzc_tractorinfo_view.tractiondisqualification,ynzc_tractorinfo_view.tractionexaminationresult,ynzc_tractorinfo_view.outsize,ynzc_tractorinfo_view.containersize,ynzc_tractorinfo_view.wheelno,ynzc_tractorinfo_view.wheelbase,ynzc_tractorinfo_view.vicecartiresno,ynzc_tractorinfo_view.outcarwheeldis,ynzc_tractorinfo_view.steelspring,ynzc_tractorinfo_view.outcartiressize,ynzc_tractorinfo_view.checkresult,ynzc_tractorinfo_view.inspector,ynzc_tractorinfo_view.checkdate,ynzc_tractorinfo_view.disqualification,\"\" as reviewPerson,\"\" as reviewDate from ynzc_tractorinfo_view where id="+id;
		//sql = "select * from ynzc_tractorinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarSafetyRoportSource> otm=new ObjectListToModelList<CarSafetyRoportSource>(CarSafetyRoportSource.class);
		List<CarSafetyRoportSource> back=new ArrayList();
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
	 
	public List<TractorRegistrationRecordProcessSource> tractorInfoReportFive(int id) {
		// TODO Auto-generated method stub
		String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		//sql = "select * from ynzc_tractorinfo_view where id = " + id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorRegistrationRecordProcessSource> otm=new ObjectListToModelList<TractorRegistrationRecordProcessSource>(TractorRegistrationRecordProcessSource.class);
		List<TractorRegistrationRecordProcessSource> back=new ArrayList();
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

	public List<CarMoveReportSource> tractorSteerReport(int id) {
		// TODO Auto-generated method stub
		String sql = "select ynzc_tractorinfo_view.platecode,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.driverinno,ynzc_tractorinfo_view.totalquality,ynzc_tractorinfo_view.ratifiedload,ynzc_tractorinfo_view.registerdate,curdate() as sendLicenseTime,ynzc_tractorinfo_view.address as address1,'' as address2,ynzc_tractorinfo_view.checkexpirydate from ynzc_tractorinfo_view where id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarMoveReportSource> otm=new ObjectListToModelList<CarMoveReportSource>(CarMoveReportSource.class);
		List<CarMoveReportSource> back=new ArrayList();
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

	public List<TractorEnregisterCertificateReportSource> TractorEnregisterCertificate(
			int id) {
		// TODO Auto-generated method stub
		String outSizeSql = "select outsize from ynzc_tractorinfo_view where id="+id;
		String outSize = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(outSizeSql).uniqueResult().toString();
		String containerSql = "select containerSize from ynzc_tractorinfo_view where id="+id;
		String containerSize = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(containerSql).uniqueResult().toString();
		String wheeldisSql = "select wheeldis from ynzc_tractorinfo_view where id="+id;
		String wheeldis = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(wheeldisSql).uniqueResult().toString();
		String sql = "select ynzc_tractorinfo_view.owner as owner_1,'' as owner_2,'' as owner_3,'' as owner_4,'' as owner_5,'' as owner_6,'' as owner_7," +
				"ynzc_tractorinfo_view.realcertificatetype as realcertificatetype_1,'' as realcertificatetype_2,'' as realcertificatetype_3,'' as realcertificatetype_4,'' as realcertificatetype_5,'' as realcertificatetype_6,'' as realcertificatetype_7," +
				"ynzc_tractorinfo_view.realcertificateno as realcertificateno_1,'' as realcertificateno_2,'' as realcertificateno_3,'' as realcertificateno_4,'' as realcertificateno_5,'' as realcertificateno_6,'' as realcertificateno_7," +
				"ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.`power`,ynzc_tractorinfo_view.manufacturer,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.machinebodycolor,ynzc_tractorinfo_view.directcontrol,ynzc_tractorinfo_view.wheelno,'"+wheeldis.split(",")[0]+"' as wheeldisFront,'"+wheeldis.split(",")[1]+"' as wheeldisBack,ynzc_tractorinfo_view.wheelbase,ynzc_tractorinfo_view.tiresno,ynzc_tractorinfo_view.tiressize,ynzc_tractorinfo_view.steelspring,ynzc_tractorinfo_view.outsize,ynzc_tractorinfo_view.containersize,ynzc_tractorinfo_view.totalquality,ynzc_tractorinfo_view.ratifiedload,ynzc_tractorinfo_view.fuelname,ynzc_tractorinfo_view.driverinno,ynzc_tractorinfo_view.getway,ynzc_tractorinfo_view.manufacturedate,'' as registrationauthority_1,'' as registrationauthority_2,'' as registrationauthority_3,'' as registrationauthority_4,'' as registrationauthority_5,'' as registrationauthority_6,'' as registrationauthority_7,'' as registerdate_1,'' as registerdate_2,'' as registerdate_3,'' as registerdate_4,'' as registerdate_5,'' as registerdate_6,'' as registerdate_7,'' as registrationno_1,'' as registrationno_2,'' as registrationno_3,'' as registrationno_4,'' as registrationno_5,'' as registrationno_6,'' as registrationno_7,(select machinetype from ynzc_machinetype where id = ynzc_tractorinfo_view.machinetypeid) as tractorType,'"+outSize.split(",")[0]+"' as outSizeLong,'"+outSize.split(",")[1]+"' as outSizeWidth,'"+outSize.split(",")[2]+"' as outSizeHigh,'"+containerSize.split(",")[0]+"' as containerLong, '"+containerSize.split(",")[1]+"' as containerWidth, '"+containerSize.split(",")[2]+"' as containerHigh from ynzc_tractorinfo_view where id="+id;
		List<TractorEnregisterCertificateReportSource> back =null;
		try{
			List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			ObjectListToModelList<TractorEnregisterCertificateReportSource> otm=new ObjectListToModelList<TractorEnregisterCertificateReportSource>(TractorEnregisterCertificateReportSource.class);
			back=new ArrayList();
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
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return back;
	}

	public String getRegcerno(String regcerno) {
		List<TractorInfo> res = hibernateTemplate.find("from TractorInfo where '"+regcerno+"'=SUBSTRING(regcerno,1,6) order by id desc");
		if (!res.isEmpty()) {
			TractorInfo trc=res.get(0);
			return trc.getRegcerno();
		} else {
			return "000000000000";
		}
	}
	public List<TractorInfoRegisterYear> getRegisterYear(){
		String sql="SELECT DISTINCT(YEAR(registerdate)) as myyear from ynzc_registerinfo ORDER BY myyear";
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorInfoRegisterYear> otm=new ObjectListToModelList<TractorInfoRegisterYear>(TractorInfoRegisterYear.class);
		List<TractorInfoRegisterYear> back=new ArrayList();
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
	public boolean isExitsTractorInfoByCode(String lincse,String regionId){
		String region[]=regionId.split(",");
		List<TractorInfo> res = hibernateTemplate.find("from TractorInfo where license='"+lincse+"' and SUBSTRING_INDEX(regionid,',',"+region.length+") ='" + regionId.substring(0,regionId.length()-1) + "' and status<>10");
		if (res.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
