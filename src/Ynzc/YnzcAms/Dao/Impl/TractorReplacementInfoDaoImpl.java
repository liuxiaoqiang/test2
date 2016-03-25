package Ynzc.YnzcAms.Dao.Impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TractorReplacementInfoDao;
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.CarTransfer;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorReplacementApplicationSource;
import Ynzc.YnzcAms.Model.TractorReplacementInfoView;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;

import Ynzc.YnzcAms.Model.TractorReplacementInfo;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class TractorReplacementInfoDaoImpl implements TractorReplacementInfoDao{
	private HibernateTemplate hibernateTemplate;

	//add
	public boolean addTractorReplacementInfo(TractorReplacementInfo model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//select
	public List<TractorReplacementInfo> getTractorReplacementInfoList(Page page, String conditions) {
		// TODO Auto-generated method stub
	   String type="0";
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_tractorreplacementinfo  where examinestatus="+type+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from TractorReplacementInfo";
		}else{
			sql="select * from ynzc_tractorreplacementinfo where (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from TractorReplacementInfo where (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<TractorReplacementInfo> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TractorReplacementInfo.class).list();
		return res;
	}
	public List<TractorReplacementInfo> findTractorReplacementInfoByTractorinfoId(String tractorids){
		String sql="from TractorReplacementInfo where (examineStatus=0 or examineStatus=1 or examineStatus=3) and tractorinfoId in ("+tractorids+")";
	    List<TractorReplacementInfo> res =this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
	    return res;
	}
	public List<TractorReplacementInfoView> findTractorReplacementInfoByIds(String replaceIds){
		String sql="select * from ynzc_tractorreplacementinfo_view where  id in ("+replaceIds+")";
		List<TractorReplacementInfoView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TractorReplacementInfoView.class).list();
		return res;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//update
	public boolean updateTractorReplacementInfo(TractorReplacementInfo model){
//		try{
//			String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
////			Date today1 =today.format(new Date());
//		System.out.println(today);
//		String sql="update ynzc_tractorreplacementinfo set examineauditor='"+examineauditor+"',examinestatusidea='"+examinestatus+"',examinedate=to_date('"+today+"','YYYY-MM-DD'),examinestatus='通过' where id="+id;
//		List<TractorReplacementInfo> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TractorReplacementInfo.class).list();
//		if(res.size()!=0){
//			return true;
//		}		
//			
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		return false;
		
		
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<TractorReplacementInfoView> getTractorReplacementInfoView(
			Page page, String conditions,int userid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_tractorreplacementinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_tractorreplacementinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_tractorreplacementinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_tractorreplacementinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<TractorReplacementInfoView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TractorReplacementInfoView.class).list();
		return res;
	}
	public List<TractorReplacementInfoView> getTractorReplacementInfoView(Page page,String conditions,String regionid){
		String sql="",tsql="";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(','));
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_tractorreplacementinfo_view a,(select ynzc_tractorreplacementinfo.id from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorreplacementinfo.tractorinfoId=ynzc_tractorinfo.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by ynzc_tractorreplacementinfo.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_tractorreplacementinfo.id) from ynzc_tractorreplacementinfo,ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ynzc_tractorreplacementinfo.tractorinfoId=ynzc_tractorinfo.id";
		}else{
			sql="select * from ynzc_tractorreplacementinfo_view a,(select ynzc_tractorreplacementinfo.id from ynzc_tractorreplacementinfo,ynzc_tractorinfo_view where ynzc_tractorreplacementinfo.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ("+conditions+") order by ynzc_tractorreplacementinfo.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_tractorreplacementinfo.id) from ynzc_tractorreplacementinfo,ynzc_tractorinfo_view where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ynzc_tractorreplacementinfo.tractorinfoId=ynzc_tractorinfo_view.id and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<TractorReplacementInfoView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TractorReplacementInfoView.class).list();
		return res;
	}
	public boolean delTractorReplacementInfoByIds(String ids){
		String sql="delete from ynzc_tractorreplacementinfo where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateTractorReplacementInfoStateByIds(int state,String ids){
		String sql="update ynzc_tractorreplacementinfo set examineStatus="+state+" where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean auditReplacementInfo(int state,String checkuser,String checkcontext,String ids){
		String sql="update ynzc_tractorreplacementinfo set examineStatus="+state+",examineAuditor='"+checkuser+"',examineDate=now(),examineStatusIdea='"+checkcontext+"' where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}

	public List<TractorReplacementInfoView> getFilingList(Page page,String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_tractorreplacementinfo_view tab1,(select ynzc_tractorreplacementinfo.id from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorinfo.id = ynzc_tractorreplacementinfo.tractorinfoId and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_tractorreplacementinfo.id) from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorinfo.id = ynzc_tractorreplacementinfo.tractorinfoId and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		}else{
			sql = "select * from ynzc_tractorreplacementinfo_view tab1,(select ynzc_tractorreplacementinfo.id from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorinfo.id = ynzc_tractorreplacementinfo.tractorinfoId and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_tractorreplacementinfo.id) from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorinfo.id = ynzc_tractorreplacementinfo.tractorinfoId and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorReplacementInfoView> otm=new ObjectListToModelList<TractorReplacementInfoView>(TractorReplacementInfoView.class);
		List<TractorReplacementInfoView> back=new ArrayList();
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
	
	public List<TractorReplacementInfoView> getFilingListQuery(Page page,String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_tractorreplacementinfo_view tab1,(select ynzc_tractorreplacementinfo.id from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorinfo.id = ynzc_tractorreplacementinfo.tractorinfoId and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
		tsql = "select count(ynzc_tractorreplacementinfo.id) from ynzc_tractorreplacementinfo,ynzc_tractorinfo where ynzc_tractorinfo.id = ynzc_tractorreplacementinfo.tractorinfoId and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorReplacementInfoView> otm=new ObjectListToModelList<TractorReplacementInfoView>(TractorReplacementInfoView.class);
		List<TractorReplacementInfoView> back=new ArrayList();
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
	//得到当前补领补换登记的流程记录单
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		// TODO Auto-generated method stub
		//String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		String sql="select '' as serialNumber, '补领补换登记' as name,ynzc_tractorreplacementinfo_view.regcerno,ynzc_tractorreplacementinfo_view.license,ynzc_tractorreplacementinfo_view.owner,ynzc_tractorreplacementinfo_view.tractorinfomachinetype as machinetype,ynzc_tractorreplacementinfo_view.tractorengineBrand as engineBrand,ynzc_tractorreplacementinfo_view.registrantAuditor as reviewer,ynzc_tractorreplacementinfo_view.registrantAuditorDate as reviewerDate,ynzc_tractorreplacementinfo_view.flapperDirector as plateCodeReviewer,ynzc_tractorreplacementinfo_view.flapperDirectorDate as plateCodeReviewerDate,ynzc_tractorreplacementinfo_view.businessLeadAuditor as businessReviewer,ynzc_tractorreplacementinfo_view.businessLeadAuditorDate as businessReviewerDate from ynzc_tractorreplacementinfo_view where id="+id;
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
	public List<TractorReplacementInfoView> getTractorReplacementInfoViewListByIds(String ids){
		String sql="";
		sql="select * from ynzc_tractorreplacementinfo_view where id in ("+ids+")";
		List<TractorReplacementInfoView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(TractorReplacementInfoView.class).list();
		return res;
	}
	public List<TractorReplacementApplicationSource> PrintReplacementReport(int id){
		String sql="select regcerno,license as flapperNumber,owner,telephone,address,zipCode,realcertificatetype, realcertificateno,templivefileType as templivefiletype,timplivefileno,plantType,machinebodyno,engineno from ynzc_tractorinfo_view where id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorReplacementApplicationSource> otm=new ObjectListToModelList<TractorReplacementApplicationSource>(TractorReplacementApplicationSource.class);
		List<TractorReplacementApplicationSource> back=new ArrayList();
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
