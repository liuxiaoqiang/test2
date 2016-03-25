package Ynzc.YnzcAms.Dao.Impl;
/**
 * 学员信息DaoImpl
 * @author zy
 * @date 2011-04-26
 * class DriverStrInfoDaoImpl.java
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Dao.DriverStrInfoDao;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.DriverStrParticularView;
import Ynzc.YnzcAms.Model.DrivingLicenceFlowReportSource;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorExamScoreTableSource;
import Ynzc.YnzcAms.Model.TractorLicenseProcessSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class DriverStrInfoDaoImpl implements DriverStrInfoDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean addDriverStrInfo(DriverStrInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delDriverStrInfo(DriverStrInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public DriverStrInfo findDriverStrInfoById(int id) {
		// TODO Auto-generated method stub
		List<DriverStrInfo> res = hibernateTemplate.find("from DriverStrInfo where id=" + id);
		if (res.size() > 0) {
			return (DriverStrInfo) res.get(0);
		} else {
			return null;
		}
	}

	public List<DriverStrInfoView> getAllDriverStrInfo(Page page, String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=0 order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=0) tab2 where tab1.id = tab2.id";
		}else{
			sql="select * from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=0 and (" + conditions + ") order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=0 and (" + conditions + ")) tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}
	
	public List<DriverStrInfoView> getAllDriverStrInfoQuery(Page page, String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select *  from ynzc_driverstrinfo_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*)  from ynzc_driverstrinfo_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}

	public List<DriverStrInfo> getAllDriverStrInfo() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(DriverStrInfo.class);
	}

	public boolean updateDriverStrInfo(DriverStrInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<DriverStrInfo> findDriverStrInfoByPeopleInfoId(int id) {
		// TODO Auto-generated method stub
		List<DriverStrInfo> res = hibernateTemplate.find("from DriverStrInfo where peopleInfoId=" + id + " and strState >= 8");
		if (res.size() > 0) {
			return res;
		} else {
			return null;
		}
	}

	public boolean delDriverStrInfo(String str) {
		// TODO Auto-generated method stub
		String sql = "delete from ynzc_driverstrinfo where id in ("+str+")";
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DriverStrInfoView> getAllDriverStrInfoByExaminationPass(Page page, String conditions,int flag,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applicationFlag ="+flag+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applicationFlag ="+flag+") tab2 where tab1.id = tab2.id";
		}else{
			sql="select * from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applicationFlag ="+flag+" and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applicationFlag ="+flag+") and (" + conditions + ") tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}
	
	public List<DriverStrInfoView> getAllDriverStrInfoByExaminationPassQuery(Page page, String conditions,int flag,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_driverstrinfo_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applicationFlag ="+flag+" and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_driverstrinfo_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applicationFlag ="+flag+") and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}

	public List<DriverStrInfoView> getAllDriverStrInfoInTeam(Page page,String conditions,int driverClassInfoId,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions==""){
			sql="select * from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+") tab4 where tab3.id = tab4.driverStrInfoId  order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+") tab4 where tab3.id = tab4.driverStrInfoId) tab2 where tab1.id = tab2.id";
		}else{
			sql="select * from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+" and (" + conditions + ")) tab4 where tab3.id = tab4.driverStrInfoId order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+" and (" + conditions + ")) tab4 where tab3.id = tab4.driverStrInfoId) tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}
	
	public List<DriverStrInfoView> getAllDriverStrInfoInTeamQuery(Page page,String conditions,int driverClassInfoId,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+") tab4 where tab3.id = tab4.driverStrInfoId  order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id and (" + conditions + ")";
		tsql="select count(*) from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+") tab4 where tab3.id = tab4.driverStrInfoId) tab2 where tab1.id = tab2.id and (" + conditions + ")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}
	
	public List<DriverStrInfoView> getAllDriverStrInfoInTeam(int driverClassInfoId,String regionId,String order) {
		// TODO Auto-generated method stub
		String sql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_driverstrinfo_view tab1,(select id  from ynzc_driverstrinfo tab3,(select driverStrInfoId from ynzc_driverclassteam where driverClassId = "+driverClassInfoId+") tab4 where tab3.id = tab4.driverStrInfoId  order by id "+order+") tab2 where tab1.id = tab2.id";
		List<DriverStrInfoView> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfoView.class).list();
		return res;
	}

	public boolean delDriverClassStrInfo(String str,int driverClassId) {
		// TODO Auto-generated method stub
		String sql = "delete from ynzc_driverclassteam where driverClassId = "+driverClassId+" and driverStrInfoId in ("+str+")";
		try{
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<DriverStrParticularView> getAllDriverStrParticular(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		List<DriverStrParticularView> res = null;
		if(conditions==""){
			sql="select * from ynzc_driverstrparticular_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and theoryFlag = 1 and practiceFlag = 1  order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+")tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_driverstrparticular_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and theoryFlag = 1 and practiceFlag = 1)tab2 where tab1.id = tab2.id";
		}else{
			sql="select * from ynzc_driverstrparticular_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and theoryFlag = 1 and practiceFlag = 1 and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize()+")tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_driverstrparticular_view tab1,(select id  from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") and theoryFlag = 1 and practiceFlag = 1) tab2 where tab1.id = tab2.id";
		}
		try{
			page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrParticularView.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	public List<DriverStrParticularView> getAllDriverStrParticularQuery(Page page,
			String conditions,String regionId) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionId.split(",");
		List<DriverStrParticularView> res = null;
		sql="select * from ynzc_driverstrparticular_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and theoryFlag = 1 and practiceFlag = 1 and (" + conditions + ") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql="select count(*) from ynzc_driverstrparticular_view where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and theoryFlag = 1 and practiceFlag = 1 and (" + conditions + ")";
		try{
			page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
			res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrParticularView.class).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}

	public boolean driverClassStrPigeonhole(String driverStrId,int flag) {
		// TODO Auto-generated method stub
		try{
			String sql = "update ynzc_driverstrinfo set pigeonholeFlag = "+flag+",pigeonholeDate = '"+GetDate.getStringDate()+"' where id in ("+driverStrId+")";
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean delDriverStrCheck(int id) {
		// TODO Auto-generated method stub
		String sql="select count(*) from ynzc_driverstrinfo where id = "+id+" and strState > 0";
		int num = Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
		if(num>0){
			return false;
		}else{
			return true;
		}
	}

	public String createNo(String idCard, int type,String regionId) {
		// TODO Auto-generated method stub
		String id = idCard.substring(0,4);
		String region[]=regionId.split(",");
		String str = "";
		String date = id+DateTimeUtil.format(DateTimeUtil.getNow(), DateTimeUtil.DEFAULT_DATE_FORMAT).replace("-", "");
		String sqlArchivesNo = "select max(right(archivesNo,8)) from ynzc_driverstrinfo where '"+regionId+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and archivesNo like '"+id+"%'";
		String sqlExaminationCode = "select max(right(examinationCode,3)) from ynzc_driverstrinfo where '"+regionId+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and examinationCode like '"+date+"%'";
		Object obj = null;
		if(type == 1){
			obj = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlArchivesNo).uniqueResult();
			if(obj != null){
				str += Integer.parseInt(obj.toString())+1;
			}else{
				str += "1";
			}
			String no = "";
			if(str.length()<8){
				for(int i = 0; i < (8-str.length()); i++){
					no+="0";
				}
			}
			return id+no+str;
		}else{
			obj = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlExaminationCode).uniqueResult();
			if(obj != null){
				str += Integer.parseInt(obj.toString())+1;
			}else{
				str += "1";
			}
			String no = "";
			if(str.length()<3){
				for(int i = 0; i < (3-str.length()); i++){
					no+="0";
				}
			}
			return date+no+str;
		}
	}

	public DriverStrInfo findDriverStrInfo(int peopleInfoId,
			int drivingLicenceTypeId) {
		// TODO Auto-generated method stub
		List<DriverStrInfo> res = hibernateTemplate.find("from DriverStrInfo where peopleInfoId=" + peopleInfoId + " and drivingLicenceTypeId = " + drivingLicenceTypeId);
		if (res.size() > 0) {
			return (DriverStrInfo) res.get(0);
		} else {
			return null;
		}
	}

	public List<DriverStrInfo> getDriverStrInfoInTeam(int driverClassInfoId,
			String regionId) {
		// TODO Auto-generated method stub
		String sql="";
		String region[]=regionId.split(",");
		sql="select * from ynzc_driverstrinfo where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and id in (select driverStrInfoId  from ynzc_driverclassteam where driverClassId="+driverClassInfoId+")";
		List<DriverStrInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(DriverStrInfo.class).list();
		return res;
	}

	public List<DrivingLicenceFlowReportSource> strExam(int driverStrId) {
		// TODO Auto-generated method stub
		String sql="select ynzc_driverstrinfo_view.peopleName,ynzc_driverstrinfo_view.drivingLicenceTypeId,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.birthday,ynzc_driverstrinfo_view.fosterType,ynzc_driverstrinfo_view.linkTel,ynzc_driverstrinfo_view.idCard,ynzc_driverstrinfo_view.examinationCode,ynzc_driverstrinfo_view.archivesNo " +
		"from ynzc_driverstrinfo_view where id = " + driverStrId;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<DrivingLicenceFlowReportSource> otm=new ObjectListToModelList<DrivingLicenceFlowReportSource>(DrivingLicenceFlowReportSource.class);
		List<DrivingLicenceFlowReportSource> back=new ArrayList();
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

	public List<TractorExamScoreTableSource> strExamInfo(int driverStrId) {
		// TODO Auto-generated method stub
		String sql="select ynzc_driverstrinfo_view.peopleName,ynzc_driverstrinfo_view.archivesNo,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.linkTel,ynzc_driverstrinfo_view.examinationCode,ynzc_driverstrinfo_view.birthday,ynzc_driverstrinfo_view.drivingLicenceTypeId,ynzc_driverstrinfo_view.idCard,ynzc_theoryexam.theoryResult,ynzc_theoryexam.examinerOne,ynzc_theoryexam.examinerTwo,ynzc_theoryexam.theoryDate,ynzc_theoryexam.theoryMakeupResult,ynzc_theoryexam.examinerMakeupOne,ynzc_theoryexam.examinerMakeupTwo,ynzc_theoryexam.theoryMakeupDate," +
		"'' as theoryResult_1,'' as examinerOne_1,'' as examinerTwo_1,'' as theoryDate_1,'' as theoryMakeupResult_2,'' as examinerTheoryMakeupOne_2,'' as examinerTheoryMakeupTwo_2,'' as theoryMakeupDate_2," + 
		"ynzc_practiceexam.fieldResult,'' as fieldResult_1,ynzc_practiceexam.examinerFieldOne,'' as examinerFieldOne_1,ynzc_practiceexam.examinerFieldTwo,'' as examinerFieldTwo_1,ynzc_practiceexam.fieldDate," + 
		"'' as fieldDate_1,ynzc_practiceexam.machineResult,'' as machineResult_1,ynzc_practiceexam.examinerMachineOne,'' as examinerMachineOne_1,ynzc_practiceexam.examinerMachineTwo,'' as examinerMachineTwo_1," + 
		"ynzc_practiceexam.machineDate,'' as machineDate_1,ynzc_practiceexam.roadResult,'' as roadResult_1,ynzc_practiceexam.examinerMakeupRoadOne," + 
		"'' as examinerRoadOne_1,ynzc_practiceexam.examinerMakeupRoadTwo,'' as examinerRoadTwo_1,ynzc_practiceexam.roadDate,'' as roadDate_1,ynzc_practiceexam.fieldMakeupResult,'' as fieldResult_2,ynzc_practiceexam.examinerMakeupFieldOne," + 
		"'' as examinerFieldOne_2,ynzc_practiceexam.examinerMakeupFieldTwo,'' as examinerFieldTwo_2,ynzc_practiceexam.fieldMakeupDate,'' as fieldDate_2,ynzc_practiceexam.machineMakeupResult,'' as machineResult_2,ynzc_practiceexam.examinerMakeupMachineOne," + 
		"'' as examinerMachineOne_2,ynzc_practiceexam.examinerMakeupMachineTwo,'' as examinerMachineTwo_2,ynzc_practiceexam.machineMakeupDate,'' as machineDate_2,ynzc_practiceexam.roadMakeupResult,'' as roadResult_2," + 
		"ynzc_practiceexam.examinerMakeupRoadOne,'' as examinerRoadOne_2,ynzc_practiceexam.examinerMakeupRoadTwo,'' as examinerRoadTwo_2,ynzc_practiceexam.roadMakeupDate,'' as roadDate_2 " + 
		"from ynzc_driverstrinfo_view,ynzc_theoryexam,ynzc_practiceexam where ynzc_driverstrinfo_view.id = " + driverStrId + " " +
		"and ynzc_theoryexam.theoryId = (select theoryId from ynzc_driverstrinfo_view where id = " + driverStrId + ") and ynzc_practiceexam.practiceId = (select practiceId from ynzc_driverstrinfo_view where id = " + driverStrId + ") " + 
		"and ynzc_driverstrinfo_view.theoryId = ynzc_theoryexam.theoryId and ynzc_driverstrinfo_view.practiceId = ynzc_practiceexam.practiceId";
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorExamScoreTableSource> otm=new ObjectListToModelList<TractorExamScoreTableSource>(TractorExamScoreTableSource.class);
		List<TractorExamScoreTableSource> back=new ArrayList();
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

	public List<TractorLicenseProcessSource> tractorLicenseProcess(
			int driverStrId,int peopleInfoId) {
		// TODO Auto-generated method stub
		String sql="select ynzc_driverstrinfo_view.peopleName,ynzc_driverstrinfo_view.sex,ynzc_driverstrinfo_view.drivingLicenceTypeId,ynzc_driverstrinfo_view.idCard,ynzc_driverstrinfo_view.examinationCode,ynzc_driverstrinfo_view.archivesNo," +
		"(select username from ynzc_user where id = (select writeUserId from ynzc_driverstrinfo where id = " + driverStrId + ")) as accept_unitId," + 
		"(select writeDate from ynzc_driverstrinfo where id = " + driverStrId + ") as writeDate_1," + 
		"(select username from ynzc_user where id = (select writeUserId from ynzc_theoryexam where driverStrInfoId = " + driverStrId + ")) as examOne_unitId," + 
		"(select writeDate from ynzc_theoryexam where driverStrInfoId = " + driverStrId + ") as writeDate_2," + 
		"(select username from ynzc_user where id = (select writeUserId from ynzc_driverclassteam where driverStrInfoId = " + driverStrId + ")) as drivingSkill_unitId," + 
		"(select writeDate from ynzc_driverclassteam where driverStrInfoId = " + driverStrId + ") as writeDate_3," + 
		"(select username from ynzc_user where id = (select writeUserId from ynzc_practiceexam where driverStrInfoId = " + driverStrId + ")) as examTwo_unitId," + 
		"(select writeDate from ynzc_practiceexam where driverStrInfoId = " + driverStrId + ") as writeDate_4," + 
		"(select username from ynzc_user where id = (select writeUserId from ynzc_practiceexam where driverStrInfoId = " + driverStrId + ")) as examThree_unitId," + 
		"(select writeDate from ynzc_practiceexam where driverStrInfoId = " + driverStrId + ") as writeDate_5," + 
		"(select username from ynzc_user where id = (select writeUserId from ynzc_practiceexam where driverStrInfoId = " + driverStrId + ")) as examFour_unitId," + 
		"(select writeDate from ynzc_practiceexam where driverStrInfoId = " + driverStrId + ") as writeDate_6," + 
		"(select username from ynzc_user where id = (select applicationUserId from ynzc_driverstrinfo where id = " + driverStrId + ")) as business_unitId," + 
		"(select applicationDate from ynzc_driverstrinfo where id = " + driverStrId + ") as writeDate_7," + 
		"(select username from ynzc_user where id = (select writeUserId from ynzc_drivinglicence where peopleInfoId = " + peopleInfoId + ")) as licenseManagement_unitId," + 
		"(select writeDate from ynzc_drivinglicence where peopleInfoId = " + peopleInfoId + ") as writeDate_8," + 
		"(select username from ynzc_user where id = (select pigeonholeUserId from ynzc_driverstrinfo where id = " + driverStrId + ")) as file_unitId," + 
		"(select pigeonholeDate from ynzc_driverstrinfo where id = " + driverStrId + ") as writeDate_9 from ynzc_driverstrinfo_view where id = " + driverStrId;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorLicenseProcessSource> otm=new ObjectListToModelList<TractorLicenseProcessSource>(TractorLicenseProcessSource.class);
		List<TractorLicenseProcessSource> back=new ArrayList();
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

	public List<DriverStrInfoView> getAllDriverStrInfoInTeamQuery(
			int driverClassInfoId, String regionId, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
