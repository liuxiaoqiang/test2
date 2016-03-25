package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.CarCheckDao;
import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class CarCheckDaoImpl implements CarCheckDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(CarCheck model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(CarCheck model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CarCheck findModelById(int id) {
		// TODO Auto-generated method stub
		List<CarCheck> res = hibernateTemplate.find("from CarCheck where id=" + id);
		if (res.size() > 0) {
			return (CarCheck) res.get(0);
		} else {
			return null;
		}
	}
	public List<CarCheck> findCarCheckingByTractorinfoId(String tractorids){
     String sql="from CarCheck where (checkresult=0 or checkresult=1 or checkresult=3) and tractorinfoId in ("+tractorids+")";
     List<CarCheck> res =this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
     return res;
	}
	public List<CarCheck> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from CarCheck";
			tsql="select count(*) from CarCheck";
		}else{
			sql="from CarCheck where (" + conditions + ")";
			tsql="select count(*) from CarCheck where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<CarCheck> res = query.list();
		return res;
	}
	public List<CarCheckView> getCarCheckViewList(Page page,String conditions,int userid)
	{
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_carcheck_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_carcheck_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_carcheck_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_carcheck_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarCheckView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarCheckView.class).list();
		return res;
	}
	public List<CarCheckView> getCarCheckViewListByIds(String ids){
		String sql="";
		sql="select * from ynzc_carcheck_view where id in ("+ids+")";
		List<CarCheckView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarCheckView.class).list();
		return res;
	}
	public boolean delCarCheckByIds(String ids){
		String sql="delete from ynzc_carcheck where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateCarCheckStateByIds(int state,String ids){
		String sql="update ynzc_carcheck set checkresult="+state+" where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean auditCarCheck(int state,String checkuser,String checkip,String checkcontext,String ids){
		String sql="update ynzc_carcheck set checkresult="+state+",checkuser='"+checkuser+"',checkdate=now(),checkip='"+checkip+"',checkcontext='"+checkcontext+"' where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public List<CarCheck> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(CarCheck.class);
	}

	public boolean updateModel(CarCheck model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<CarCheckView> getFilingList(Page page,String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_carcheck_view tab1,(select ynzc_carcheck.id from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_carcheck.id) from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+")";
		}else{
			sql = "select * from ynzc_carcheck_view tab1,(select ynzc_carcheck.id from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_carcheck.id) from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarCheckView> otm=new ObjectListToModelList<CarCheckView>(CarCheckView.class);
		List<CarCheckView> back=new ArrayList();
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
	
	public List<CarCheckView> getFilingListQuery(Page page,String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_carcheck_view tab1,(select ynzc_carcheck.id from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
		tsql = "select count(ynzc_carcheck.id) from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarCheckView> otm=new ObjectListToModelList<CarCheckView>(CarCheckView.class);
		List<CarCheckView> back=new ArrayList();
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
	//得到当前年检登记的流程记录单
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		// TODO Auto-generated method stub
		//String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		String sql="select \"\" as serialNumber, '年检登记' as name,ynzc_carcheck_view.regcerno,ynzc_carcheck_view.license,ynzc_carcheck_view.owner,ynzc_carcheck_view.tractorinfomachinetype as machinetype,ynzc_carcheck_view.tractorengineBrand as engineBrand,ynzc_carcheck_view.reviewer as reviewer,ynzc_carcheck_view.reviewerconductdate as reviewerDate,ynzc_carcheck_view.issueadmin as plateCodeReviewer,ynzc_carcheck_view.issueadmindate as plateCodeReviewerDate,ynzc_carcheck_view.leaderreview as businessReviewer,ynzc_carcheck_view.leaderreviewdate as businessReviewerDate from ynzc_carcheck_view where id="+id;
		//String sql="select \"\" as serialNumber, '年检登记' as name,ynzc_carcheck_view.regcerno,ynzc_carcheck_view.license,ynzc_carcheck_view.owner,ynzc_carcheck_view.tractorinfomachinetype as machinetype,ynzc_carcheck_view.tractorengineBrand as engineBrand,ynzc_carcheck_view.reviewer as reviewer,ynzc_carcheck_view.reviewerconductdate as reviewerDate,ynzc_carcheck_view.issueadmin as plateCodeReviewer,ynzc_carcheck_view.issueadmindate as plateCodeReviewerDate from ynzc_carcheck_view where id="+id;
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

	public List<CarCheckView> getCarCheckViewList(Page page, String conditions,
			String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(','));
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_carcheck_view a,(select ynzc_carcheck.id from ynzc_carcheck,ynzc_tractorinfo where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by ynzc_carcheck.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_carcheck.id) from ynzc_carcheck,ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ynzc_carcheck.tractorinfoId=ynzc_tractorinfo.id";
		}else{
			sql="select * from ynzc_carcheck_view a,(select ynzc_carcheck.id from ynzc_carcheck,ynzc_tractorinfo_view where ynzc_carcheck.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ("+conditions+") order by ynzc_carcheck.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_carcheck.id) from ynzc_carcheck,ynzc_tractorinfo_view where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ynzc_carcheck.tractorinfoId=ynzc_tractorinfo_view.id and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarCheckView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarCheckView.class).list();
		return res;
	}

}
