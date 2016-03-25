package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.LoyoutDao;

import Ynzc.YnzcAms.Model.LogoutView;

import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Loyout;
import Ynzc.YnzcAms.Model.MortgageView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleReportSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;


public class LoyoutDaoImpl implements LoyoutDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(Loyout model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(Loyout model) {
		// TODO Auto-generated method stub
		return false;
	}

	public Loyout findModelById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Loyout> findLoyoutByTractorinfoId(String tractorids){
		String sql="from Loyout where (checkstate=0 or checkstate=1 or checkstate=3) and tractorinfoid in ("+tractorids+")";
		List<Loyout> res =this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
	     return res;
	}
	public List<LogoutView> getAllModelList(Page page, String conditions,int userid) {
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_logout_view  where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_logout_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_logout_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_logout_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<LogoutView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(LogoutView.class).list();
		return res;
	}
	public List<LogoutView> getAllModelList(Page page,String conditions,String regionid){
		String sql="",tsql="";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(','));
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_logout_view a,(select ynzc_logout.id from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by ynzc_logout.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_logout.id) from ynzc_logout,ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ynzc_logout.tractorinfoId=ynzc_tractorinfo.id";
		}else{
			sql="select * from ynzc_logout_view a,(select ynzc_logout.id from ynzc_logout,ynzc_tractorinfo_view where ynzc_logout.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ("+conditions+") order by ynzc_logout.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_logout.id) from ynzc_logout,ynzc_tractorinfo_view where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ynzc_logout.tractorinfoId=ynzc_tractorinfo_view.id and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<LogoutView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(LogoutView.class).list();
		return res;
	}
	public List<LogoutView> getLogoutViewListByIds(String ids){
		String sql="";
		sql="select * from ynzc_logout_view where id in ("+ids+")";
		List<LogoutView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(LogoutView.class).list();
		return res;
	}
	public boolean updateModel(Loyout model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.merge(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public int getMaxLoginNumber(){
		String sql="select max(logoutnum) from ynzc_logout";
		return Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString());
	}
	public boolean delLoyoutByIds(String ids){
		String sql="delete from ynzc_logout where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateLoyoutStateByIds(int state,String ids){
		String sql="update ynzc_logout set checkstate="+state+" where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}

	public List<LogoutView> getFilingList(Page page,String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_logout_view tab1,(select ynzc_logout.id from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_logout.id) from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+")";
		}else{
			sql = "select * from ynzc_logout_view tab1,(select ynzc_logout.id from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_logout.id) from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));		
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<LogoutView> otm=new ObjectListToModelList<LogoutView>(LogoutView.class);
		List<LogoutView> back=new ArrayList();
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
	
	public List<LogoutView> getFilingListQuery(Page page,String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_logout_view tab1,(select ynzc_logout.id from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
		tsql = "select count(ynzc_logout.id) from ynzc_logout,ynzc_tractorinfo where ynzc_logout.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));		
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<LogoutView> otm=new ObjectListToModelList<LogoutView>(LogoutView.class);
		List<LogoutView> back=new ArrayList();
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
	//得到当前注销登记的流程记录单
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		// TODO Auto-generated method stub
		//String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		String sql="select '' as serialNumber, '注销登记' as name,ynzc_logout_view.regcerno,ynzc_logout_view.license,ynzc_logout_view.owner,ynzc_logout_view.tractorinfomachinetype as machinetype,ynzc_logout_view.tractorengineBrand as engineBrand,ynzc_logout_view.checkinmen as reviewer,ynzc_logout_view.checkindate as reviewerDate,ynzc_logout_view.licensemen as plateCodeReviewer,ynzc_logout_view.licensedate as plateCodeReviewerDate,ynzc_logout_view.businessmen as businessReviewer,ynzc_logout_view.businessdate as businessReviewerDate from ynzc_logout_view where id="+id;
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
	public List<TractorScrapApplicationSource> PrintLogoutReport(int id){
		String sql="select regcerno,license,owner,telephone,address,zipCode,tempaddress as tempAddress,unitzipcode as tempCode,realcertificateno as idCard,timplivefileno,machinetype,plantType from ynzc_tractorinfo_view where id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorScrapApplicationSource> otm=new ObjectListToModelList<TractorScrapApplicationSource>(TractorScrapApplicationSource.class);
		List<TractorScrapApplicationSource> back=new ArrayList();
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
