package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.MortgageDao;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Mortgage;
import Ynzc.YnzcAms.Model.MortgageView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorMortgageApplicationSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class MortgageDaoImpl implements MortgageDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(Mortgage model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(Mortgage model) {
		// TODO Auto-generated method stub
		return false;
	}

	public Mortgage findModelById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Mortgage> findMortgageingByTractorinfoId(String tractorids){
		String sql="from Mortgage where (checkstate=0 or checkstate=1 or checkstate=3) and tractorinfoid in ("+tractorids+")";
		List<Mortgage> res =this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
		return res;
	}
	public List<MortgageView> getAllModelList(Page page, String conditions,int userid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_mortgage_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_mortgage_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_mortgage_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_mortgage_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<MortgageView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(MortgageView.class).list();
		return res;
	}
	public List<MortgageView> getAllModelList(Page page,String conditions,String regionid){
		String sql="",tsql="";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(','));
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_mortgage_view a,(select ynzc_mortgage.id from ynzc_mortgage,ynzc_tractorinfo where ynzc_mortgage.tractorinfoId=ynzc_tractorinfo.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by ynzc_mortgage.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_mortgage.id) from ynzc_mortgage,ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ynzc_mortgage.tractorinfoId=ynzc_tractorinfo.id";
		}else{
			sql="select * from ynzc_mortgage_view a,(select ynzc_mortgage.id from ynzc_mortgage,ynzc_tractorinfo_view where ynzc_mortgage.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ("+conditions+") order by ynzc_mortgage.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_mortgage.id) from ynzc_mortgage,ynzc_tractorinfo_view where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ynzc_mortgage.tractorinfoId=ynzc_tractorinfo_view.id and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<MortgageView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(MortgageView.class).list();
		return res;
	}
	public List<MortgageView> getMortgageViewListByIds(String ids){
		String sql="";
		sql="select * from ynzc_mortgage_view where id in ("+ids+")";
		List<MortgageView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(MortgageView.class).list();
		return res;
	}
	public boolean delMortgageByIds(String ids){
		String sql="delete from ynzc_mortgage where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateMortgageStateByIds(int state,String ids){
		String sql="update ynzc_mortgage set checkstate="+state+" where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean auditMortgage(int state,String checkuser,String checkip,String checkcontext,String ids){
		String sql="update ynzc_mortgage set checkstate="+state+",checkmen='"+checkuser+"',checkdate=now(),checkip='"+checkip+"',checkcontent='"+checkcontext+"' where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public List<Mortgage> getAllModelList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateModel(Mortgage model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<MortgageView> getFilingList(Page page,String conditions, String regionid) {		
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_mortgage_view tab1,(select ynzc_mortgage.id from ynzc_mortgage,ynzc_tractorinfo where ynzc_mortgage.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_mortgage.id) from ynzc_mortgage,ynzc_tractorinfo where ynzc_mortgage.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+")";
		}else{
			sql = "select * from ynzc_mortgage_view tab1,(select ynzc_mortgage.id from ynzc_mortgage,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_mortgage.id) from ynzc_mortgage,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<MortgageView> otm=new ObjectListToModelList<MortgageView>(MortgageView.class);
		List<MortgageView> back=new ArrayList();
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
	
	public List<MortgageView> getFilingListQuery(Page page,String conditions, String regionid) {		
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_mortgage_view tab1,(select ynzc_mortgage.id from ynzc_mortgage,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
		tsql = "select count(ynzc_mortgage.id) from ynzc_mortgage,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<MortgageView> otm=new ObjectListToModelList<MortgageView>(MortgageView.class);
		List<MortgageView> back=new ArrayList();
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
	//得到当前抵押登记的流程记录单
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		// TODO Auto-generated method stub
		//String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		String sql="select '' as serialNumber, '抵押登记' as name,ynzc_mortgage_view.regcerno,ynzc_mortgage_view.license,ynzc_mortgage_view.owner,ynzc_mortgage_view.tractorinfomachinetype as machinetype,ynzc_mortgage_view.tractorengineBrand as engineBrand,'' as reviewer,'' as reviewerDate,'' as plateCodeReviewer,'' as plateCodeReviewerDate,'' as businessReviewer,'' as businessReviewerDate from ynzc_mortgage_view where id="+id;
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
	public List<TractorMortgageApplicationSource> PrintMortgageReport(int id){
		String sql="select regcerno,license,mortgageusername,mortgageaddress,mortgageistemplive,mortgagecaridtype,mortgagecarid,mortgagelinktel,mortgagezipcode,mortgageownerusername,mortgageowneraddress,mortgageisownertemplive,mortgageownercaridtype,mortgageownercarid,mortgageownerlinktel,mortgageownerzipcode from ynzc_mortgage_view where id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorMortgageApplicationSource> otm=new ObjectListToModelList<TractorMortgageApplicationSource>(TractorMortgageApplicationSource.class);
		List<TractorMortgageApplicationSource> back=new ArrayList();
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
