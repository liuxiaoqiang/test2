package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.CarTransferDao;
import Ynzc.YnzcAms.Model.CarTransfer;
import Ynzc.YnzcAms.Model.CarTransferView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;
import Ynzc.YnzcAms.Model.TractorTransferApplicationSource;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class CarTransferDaoImpl implements CarTransferDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean addModel(CarTransfer model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delModel(CarTransfer model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean delCarTransferByIds(String ids){
		String sql="delete from ynzc_cartransfer where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateCarTransferStateByIds(int state,String ids){
		String sql="update ynzc_cartransfer set checkresult="+state+" where id in ("+ids+")";	
		if(this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql).executeUpdate()>0){
			return true;
		}else{
			return false;
		}
	}
	public CarTransfer findModelById(int id) {
		// TODO Auto-generated method stub
		List<CarTransfer> res = hibernateTemplate.find("from CarTransfer where id=" + id);
		if (res.size() > 0) {
			return (CarTransfer) res.get(0);
		} else {
			return null;
		}
	}
	public List<CarTransfer> findCarTransferByTractorinfoId(String tractorids){
    String sql="from CarTransfer where checkresult=0 and tractorinfoId in ("+tractorids+")";
    List<CarTransfer> res=this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
    return res;
	}
	public List<CarTransfer> getAllModelList(Page page, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="from CarTransfer";
			tsql="select count(*) from CarTransfer";
		}else{
			sql="from CarTransfer where (" + conditions + ")";
			tsql="select count(*) from CarTransfer where (" + conditions + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<CarTransfer> res = query.list();
		return res;
	}

	public List<CarTransfer> findCarTransferingByTractorinfoId(String tractorids){
		 String sql="from CarTransfer where (checkresult=0 or checkresult=1 or checkresult=3) and tractorinfoId in ("+tractorids+")";
	     List<CarTransfer> res =this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).list();
	     return res;
	}
	public List<CarTransfer> getAllModelList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.loadAll(CarTransfer.class);
	}

	public boolean updateModel(CarTransfer model) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<CarTransferView> getFilingList(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_cartransfer.id) from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+")";
		}else{
			sql = "select * from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(ynzc_cartransfer.id) from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarTransferView> otm=new ObjectListToModelList<CarTransferView>(CarTransferView.class);
		List<CarTransferView> back=new ArrayList();
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
	
	public List<CarTransferView> getFilingListQuery(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
		tsql = "select count(ynzc_cartransfer.id) from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<CarTransferView> otm=new ObjectListToModelList<CarTransferView>(CarTransferView.class);
		List<CarTransferView> back=new ArrayList();
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

	public boolean auditCarTransfer(int state, String checkuser,
			String checkip, String checkcontext, String oldlicense, String ids) {
		// TODO Auto-generated method stub
		return false;
	}
	//查询当前地区转出的车辆信息
	public List<CarTransferView> getOutCarTransferViewList(Page page,String conditions,String regionId){	
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0 order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0) tab2 where tab1.id = tab2.id";
		}else{
			sql="select * from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0 and (" + conditions + ") order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id and'"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0 and (" + conditions + ")) tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarTransferView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarTransferView.class).list();
		return res;
	}
	
	//查询当前地区转入的车辆信息
	public List<CarTransferView> getIntoCarTransferViewList(Page page,String conditions,String regionId){
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if(conditions=="" || conditions.trim().equals("1=1")){
			sql="select * from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=1 order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=1) tab2 where tab1.id = tab2.id";
		}else{
			sql="select * from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(ynzc_cartransfer.regionid,',',"+region.length+") and applytype=1 and (" + conditions + ") order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql="select count(*) from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(ynzc_cartransfer.regionid,',',"+region.length+") and applytype=1 and (" + conditions + ")) tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarTransferView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarTransferView.class).list();
		return res;
	}
	//查询当前地区领导审核岗中的数据（转入、转出的数据）
	public List<CarTransferView> getCarTransferViewList(Page page,String conditions,String regionId)
	{
		String sql="",tsql="";
		String region[]=regionId.split(",");
		if (conditions == "" || conditions.trim().equals("1=1")) {
			sql = "select * from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=1) or ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0) order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(*) from ynzc_cartransfer_view tab1,(select id from ynzc_cartransfer where ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and applytype=1) or ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0)) tab2 where tab1.id = tab2.id";
		}else{
			sql = "select * from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where (ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id) and ("+conditions+") and (('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(ynzc_cartransfer.regionid,',',"+region.length+") and applytype=1) or ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0)) order by id desc limit "+page.getFirstResult()+", "+page.getPageSize()+" ) tab2 where tab1.id = tab2.id";
			//tsql = "select count(*) from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where (ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id) and ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(ynzc_cartransfer.regionid,',',"+region.length+") and applytype=1 and " + "("+ conditions + ")) or ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0 and " + "("+ conditions + "))) tab2 where tab1.id = tab2.id";
			tsql = "select count(*) from ynzc_cartransfer_view tab1,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where (ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id) and ("+conditions+") and (('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(ynzc_cartransfer.regionid,',',"+region.length+") and applytype=1) or ('"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(orginregionid,',',"+region.length+") and applytype=0))) tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<CarTransferView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarTransferView.class).list();
		return res;
	}
//	public List<CarTransferView> getCarTransferViewList(Page page,String conditions,String regionid){
//		String sql="",tsql="";
//		String region[]=regionid.split(",");
//		regionid=regionid.substring(0,regionid.lastIndexOf(','));
//		if(conditions=="" || conditions.trim().equals("1=1")){
//			sql="select * from ynzc_cartransfer_view a,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") order by ynzc_cartransfer.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
//			tsql="select count(ynzc_cartransfer.id) from ynzc_cartransfer,ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo.regionid,',',"+region.length+") and ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo.id";
//		}else{
//			sql="select * from ynzc_cartransfer_view a,(select ynzc_cartransfer.id from ynzc_cartransfer,ynzc_tractorinfo_view where ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id and '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ("+conditions+") order by ynzc_cartransfer.id desc limit "+page.getFirstResult()+","+page.getPageSize()+") b where a.id=b.id";
//			tsql="select count(ynzc_cartransfer.id) from ynzc_cartransfer,ynzc_tractorinfo_view where '"+regionid+"'=SUBSTRING_INDEX(ynzc_tractorinfo_view.regionid,',',"+region.length+") and ynzc_cartransfer.tractorinfoId=ynzc_tractorinfo_view.id and ("+conditions+")";
//		}
//		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
//		List<CarTransferView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarTransferView.class).list();
//		return res;	
//	}
	public List<CarTransferView> getCarTransferViewListByIds(String ids){
		String sql="";
		sql="select * from ynzc_cartransfer_view where id in ("+ids+")";
		List<CarTransferView> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(CarTransferView.class).list();
		return res;
	}
	//得到当前转移登记的流程记录单
	public List<TractorRegistrationRecordProcessSource> recordReport(int id){
		// TODO Auto-generated method stub
		//String sql = "select \"\" as serialNumber, '注册登记' as name,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.license,ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.machinetype,ynzc_tractorinfo_view.engineBrand,ynzc_tractorinfo_view.reviewer,ynzc_tractorinfo_view.reviewerconductdate as reviewerDate,ynzc_tractorinfo_view.issueadmin as plateCodeReviewer,ynzc_tractorinfo_view.issueadmindate as plateCodeReviewerDate,ynzc_tractorinfo_view.leaderreview as businessReviewer,ynzc_tractorinfo_view.leaderreviewconductdate as businessReviewerDate,\"\" as fileReviewer,\"\" as fileReviewerDate from ynzc_tractorinfo_view where id="+id;
		String sql="select '' as serialNumber, '转移登记' as name,ynzc_cartransfer_view.regcerno,ynzc_cartransfer_view.license,ynzc_cartransfer_view.owner,ynzc_cartransfer_view.tractorinfomachinetype as machinetype,ynzc_cartransfer_view.tractorengineBrand as engineBrand,'' as reviewer,'' as reviewerDate,'' as plateCodeReviewer,'' as plateCodeReviewerDate,'' as businessReviewer,'' as businessReviewerDate from ynzc_cartransfer_view where id="+id;
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
	public List<TractorRegistrationAndTurnInSource> tractorInfoTurnInReport(int tractorinfoid){
		// TODO Auto-generated method stub
		String sql = "select ynzc_tractorinfo_view.owner,ynzc_tractorinfo_view.telephone,ynzc_tractorinfo_view.zipCode,ynzc_tractorinfo_view.address,ynzc_tractorinfo_view.realcertificatetype,ynzc_tractorinfo_view.templivefiletype,ynzc_tractorinfo_view.timplivefileno,ynzc_tractorinfo_view.plantType,ynzc_tractorinfo_view.engineno,ynzc_tractorinfo_view.machinebodyno,ynzc_tractorinfo_view.shelfno,ynzc_tractorinfo_view.insurancedate,ynzc_tractorinfo_view.insurancecompanyname,ynzc_tractorinfo_view.regcerno,ynzc_tractorinfo_view.region as unitid,ynzc_tractorinfo_view.tempaddress,ynzc_tractorinfo_view.realcertificateno,'' as tempCode from ynzc_tractorinfo_view where id="+tractorinfoid;
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
	//打印拖拉机转移登记申请表
	public List<TractorTransferApplicationSource> PrintCarTransferReport(int id){
		String sql="select regcerno,license,owner,telephone,address,zipCode,tempaddress as tempAddress,unitzipcode as tempCode,realcertificatetype,realcertificateno,templivefileType as templivefiletype,timplivefileno,plantType,machinebodyno,engineno from ynzc_tractorinfo_view where id="+id;
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorTransferApplicationSource> otm=new ObjectListToModelList<TractorTransferApplicationSource>(TractorTransferApplicationSource.class);
		List<TractorTransferApplicationSource> back=new ArrayList();
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
