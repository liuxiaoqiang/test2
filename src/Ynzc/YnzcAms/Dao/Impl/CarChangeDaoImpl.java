package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.CarChangeDao;
import Ynzc.YnzcAms.Model.CarChange;
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorAlterApplicationSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorTransferApplicationSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class CarChangeDaoImpl implements CarChangeDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(CarChange model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(CarChange model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CarChange findModelById(int id) {
		// TODO Auto-generated method stub
		List<CarChange> res = hibernateTemplate.find("from CarChange where id=" + id);
		if (res.size() > 0) {
			return (CarChange) res.get(0);
		} else {
			return null;
		}
	}
	public boolean delCarChangeByIds(String ids){
		String sql="delete from ynzc_carchange where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateCarChangeByIds(String ids){
		String sql="update ynzc_carchange set approvalstate=1 where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public List<CarChange> findCarChangeingByTractorinfoId(String tractorids){
		String sql="from CarChange where (approvalstate=0 or approvalstate=1 or approvalstate=3) and tractorinfoId in ("+tractorids+")";
		List<CarChange> res=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
        return res;
	}
	public List<CarChange> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from CarChange";
			tsql="select count(*) from CarChange";
		}else{
			sql="from CarChange where (" + conditions + ")";
			tsql="select count(*) from CarChange where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<CarChange> res = query.list();
		return res;
	}
	public List<CarChangeView> getCarChangeViewList(Page page,String conditions,int userid){
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_carchange_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_carchange_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}else{
			sql="select * from ynzc_carchange_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+") limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from ynzc_carchange_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarChangeView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarChangeView.class).list();
		return res;
	}
	
	public List<CarChangeView> getCarChangeViewList(Page page,String conditions,String regionid){
		String sql="",tsql="";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(','));
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_carchange_view a,(select ynzc_carchange.id from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by ynzc_carchange.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_carchange.id) from ynzc_carchange,ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id";
		}else{
			sql="select * from ynzc_carchange_view a,(select ynzc_carchange.id from ynzc_carchange,ynzc_tractorinfo_view where ynzc_carchange.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ("+conditions+") order by ynzc_carchange.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
			tsql="select count(ynzc_carchange.id) from ynzc_carchange,ynzc_tractorinfo_view where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ynzc_carchange.tractorinfoId=ynzc_tractorinfo_view.id and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarChangeView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarChangeView.class).list();
		return res;
	}
	
	public List<CarChangeView> getCarChangeViewListByIds(String ids){
		String sql="";
		sql="select * from ynzc_carchange_view where id in ("+ids+")";
		List<CarChangeView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarChangeView.class).list();
		return res;
	}
	public List<CarChange> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(CarChange.class);
	}

	public boolean updateModel(CarChange model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<CarChangeView> getFilingList(Page page, String changeType,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_carchange_view tab1,(select ynzc_carchange.id from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_carchange.id) from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+")";
		}else{
			sql = "select * from ynzc_carchange_view tab1,(select ynzc_carchange.id from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_carchange.id) from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));	
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarChangeView> otm=new ObjectListToModelList<CarChangeView>(CarChangeView.class);
		List<CarChangeView> back=new ArrayList();
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
	
	public List<CarChangeView> getFilingListQuery(Page page, String changeType,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_carchange_view tab1,(select ynzc_carchange.id from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
		tsql = "select count(ynzc_carchange.id) from ynzc_carchange,ynzc_tractorinfo where ynzc_carchange.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));	
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarChangeView> otm=new ObjectListToModelList<CarChangeView>(CarChangeView.class);
		List<CarChangeView> back=new ArrayList();
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
	//得到当前变更登记的流程记录单
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		// TODO Auto-generated method stub
		//String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		String sql="select '' as serialNumber, '变更登记' as name,ynzc_carchange_view.regcerno,ynzc_carchange_view.license,ynzc_carchange_view.owner,ynzc_carchange_view.tractorinfomachinetype as machinetype,ynzc_carchange_view.tractorengineBrand as engineBrand,'' as reviewer,'' as reviewerDate,'' as plateCodeReviewer,'' as plateCodeReviewerDate,'' as businessReviewer,'' as businessReviewerDate from ynzc_carchange_view where id="+id;
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
	
	public List<TractorAlterApplicationSource> PrintCarChangeReport(int id){
		String sql="select regcerno,license,owner,telephone,address,zipCode,tempaddress as tempAddress,unitzipcode as tempCode,realcertificatetype,realcertificateno,templivefileType as templivefiletype,timplivefileno from ynzc_tractorinfo_view where id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorAlterApplicationSource> otm=new ObjectListToModelList<TractorAlterApplicationSource>(TractorAlterApplicationSource.class);
		List<TractorAlterApplicationSource> back=new ArrayList();
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
