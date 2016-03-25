package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.TractorInfoViewDao;
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorInfoView;
import Ynzc.YnzcAms.Util.ObjectListToModelList;

public class TractorInfoViewDaoImpl implements TractorInfoViewDao {
	private HibernateTemplate hibernateTemplate;

	// 查询拖拉机视图
	public List<TractorInfoView> getTractorInfoViewList(Page page,
			String conditions, int userid) {
		// TODO Auto-generated method stub
		String sql = "", tsql = "";
		if (conditions == "") {
			sql = "select * from ynzc_tractorinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize();
			tsql = "select count(*) from ynzc_tractorinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		} else {
			sql = "select * from ynzc_tractorinfo_view where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and ("
					+ conditions
					+ ") order by id desc limit "
					+ page.getFirstResult()
					+ ","
					+ page.getPageSize();
			tsql = "select count(*) from ynzc_tractorinfo_view where (" + conditions + ") and unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorInfoView> otm=new ObjectListToModelList<TractorInfoView>(TractorInfoView.class);
		List<TractorInfoView> back=new ArrayList();
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

	// 查询拖拉机视图
	public List<TractorInfoView> getTractorInfoViewList(Page page,
			String conditions, String regionid) {
		// TODO Auto-generated method stub
		String sql = "", tsql = "";
		String region[]=regionid.split(",");
		regionid=regionid.substring(0,regionid.lastIndexOf(','));
		if (conditions == "") {
			sql = "select * from ynzc_tractorinfo_view a,(select id from ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") b where a.id=b.id";
			tsql = "select count(id) from ynzc_tractorinfo where '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		} else {
			sql = "select * from ynzc_tractorinfo_view a,(select ynzc_tractorinfo.id from ynzc_tractorinfo,ynzc_ownerinfo where ynzc_tractorinfo.id= ynzc_ownerinfo.tractorinfoId  and '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+") order by id desc limit "+ page.getFirstResult() + "," + page.getPageSize()+") b where a.id=b.id";
			tsql = "select count(ynzc_tractorinfo.id) from ynzc_tractorinfo,ynzc_ownerinfo  where ynzc_tractorinfo.id= ynzc_ownerinfo.tractorinfoId  and '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorInfoView> otm=new ObjectListToModelList<TractorInfoView>(TractorInfoView.class);
		List<TractorInfoView> back=new ArrayList();
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
	
	public TractorInfoView findTractorInfoViewByWhere(String plate, String code,String regionid) {
		String sql="";
		if(regionid.equals("")){
			 sql = "select * from ynzc_tractorinfo_view  where license='"+ code + "' and platecode='" + plate + "'";	
		}
		else{
			regionid=regionid.substring(0,regionid.lastIndexOf(','));
			String region[]=regionid.split(",");
			 sql = "select * from ynzc_tractorinfo_view  where license='"+ code + "' and platecode='" + plate + "' and '"+regionid+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";	
		}
		TractorInfoView viewmodel=null;
		List<TractorInfoView> res = hibernateTemplate.getSessionFactory()
				.openSession().createSQLQuery(sql).addEntity(
						TractorInfoView.class).list();
		if (res != null && res.size() > 0) {
			for (TractorInfoView u : res) {
				if(u.getStatus()!=10){
					viewmodel=u;
					break;
				}
			}
			if(viewmodel==null){
				viewmodel=res.get(res.size()-1);
			}
			return viewmodel;
		}
		return null;
	}
	//根据id获得详细信息
	public TractorInfoView findTractorInfoViewById(int id) {
		String sql = "select * from ynzc_tractorinfo_view  where id='"
				+ id + "'";
		List<TractorInfoView> res = hibernateTemplate.getSessionFactory()
				.openSession().createSQLQuery(sql).addEntity(
						TractorInfoView.class).list();
		if (res != null && res.size() > 0) {
			return res.get(0);
		}
		return null;
	}
	//
	public List<TractorInfoView> getCarChangeTractorInfoViewList(Page page,
			String conditions, int userid) {
		String sql = "", tsql = "";
		if (conditions == "") {
			sql = "SELECT ynzc_tractorinfo_view.*  FROM  ynzc_tractorinfo_view left Join ynzc_carchange ON ynzc_tractorinfo_view.id = ynzc_carchange.tractorinfoId where  ynzc_carchange.id is null or ynzc_carchange.approvalstate=1 or ynzc_carchange.approvalstate=2 order by id desc limit "
					+ page.getFirstResult() + "," + page.getPageSize();
			tsql = "SELECT count(*)  FROM  ynzc_tractorinfo_view left Join ynzc_carchange ON ynzc_tractorinfo_view.id = ynzc_carchange.tractorinfoId where ynzc_carchange.id is null or ynzc_carchange.approvalstate=1 or ynzc_carchange.approvalstate=2";
		} else {
			sql = "SELECT ynzc_tractorinfo_view.*  FROM  ynzc_tractorinfo_view left Join ynzc_carchange ON ynzc_tractorinfo_view.id = ynzc_carchange.tractorinfoId where (ynzc_carchange.id is null or ynzc_carchange.approvalstate=1 or ynzc_carchange.approvalstate=2) and "
					+ conditions
					+ " order by id desc limit "
					+ page.getFirstResult() + "," + page.getPageSize();
			tsql = "SELECT count(*)  FROM  ynzc_tractorinfo_view left Join ynzc_carchange ON ynzc_tractorinfo_view.id = ynzc_carchange.tractorinfoId where  (ynzc_carchange.id is null or ynzc_carchange.approvalstate=1 or ynzc_carchange.approvalstate=2) and "
					+ conditions;
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List<TractorInfoView> res = hibernateTemplate.getSessionFactory()
				.openSession().createSQLQuery(sql).addEntity(
						TractorInfoView.class).list();
		return res;
	}

	// 得到可以进行年检得拖拉机信息(审核状态为通过,并且在有效年检时间内,还未进行年检信息 或者 通过年检 或者 未通过年检 的信息)
	public List<TractorInfoView> getCarCheckTractorInfoViewList(Page page,
			String conditions, int userid, int state) {
		String sql = "", tsql = "";
		List<TractorInfoView> list;
		String updateIds = "";
		if (conditions == "") {
			if (state == 0) {
				// 查询可以还未过有效期的信息
				sql = "select ynzc_tractorinfo_view.* from ynzc_tractorinfo_view where id in(SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view left Join ynzc_carcheck ON ynzc_tractorinfo_view.id = ynzc_carcheck.tractorinfoId where  ynzc_tractorinfo_view.status=2 and ynzc_tractorinfo_view.checkexpirydate>=now() and (ynzc_carcheck.id is null or ynzc_carcheck.checkresult=1 or ynzc_carcheck.checkresult=2) and ynzc_tractorinfo_view.id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where  ynzc_carcheck.checkresult=0)) order by id desc limit "
						+ page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_tractorinfo_view where id in(SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view left Join ynzc_carcheck ON ynzc_tractorinfo_view.id = ynzc_carcheck.tractorinfoId where  ynzc_tractorinfo_view.status=2 and ynzc_tractorinfo_view.checkexpirydate>=now() and (ynzc_carcheck.id is null or ynzc_carcheck.checkresult=1 or ynzc_carcheck.checkresult=2) and ynzc_tractorinfo_view.id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where  ynzc_carcheck.checkresult=0))";
			} else if (state == 1) {
				sql = "select ynzc_tractorinfo_view.* from ynzc_tractorinfo_view where id in (SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view where ynzc_tractorinfo_view.status=5 and id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where ynzc_carcheck.checkresult=0)) order by id desc limit "
						+ page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_tractorinfo_view where id in (SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view where   ynzc_tractorinfo_view.status=5 and id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where ynzc_carcheck.checkresult=0))";
			}

		} else {
			if (state == 0) {
				sql = "select ynzc_tractorinfo_view.* from ynzc_tractorinfo_view where id in(SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view left Join ynzc_carcheck ON ynzc_tractorinfo_view.id = ynzc_carcheck.tractorinfoId where ynzc_tractorinfo_view.status=2 and ynzc_tractorinfo_view.checkexpirydate>=now() and (ynzc_carcheck.id is null or ynzc_carcheck.checkresult=1 or ynzc_carcheck.checkresult=2) and ynzc_tractorinfo_view.id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where  ynzc_carcheck.checkresult=0)) and "
						+ conditions
						+ " order by id desc limit "
						+ page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_tractorinfo_view where id in(SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view left Join ynzc_carcheck ON ynzc_tractorinfo_view.id = ynzc_carcheck.tractorinfoId where  ynzc_tractorinfo_view.status=2 and ynzc_tractorinfo_view.checkexpirydate>=now() and (ynzc_carcheck.id is null or ynzc_carcheck.checkresult=1 or ynzc_carcheck.checkresult=2) and ynzc_tractorinfo_view.id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where  ynzc_carcheck.checkresult=0)) and "
						+ conditions;
			} else if (state == 1) {
				sql = "select ynzc_tractorinfo_view.* from ynzc_tractorinfo_view where id in (SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view where ynzc_tractorinfo_view.status=5 and id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where ynzc_carcheck.checkresult=0)) and "
						+ conditions
						+ " order by id desc limit "
						+ page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_tractorinfo_view where id in (SELECT ynzc_tractorinfo_view.id  FROM  ynzc_tractorinfo_view where ynzc_tractorinfo_view.status=5 and id not in (select ynzc_carcheck.tractorinfoId from ynzc_carcheck where ynzc_carcheck.checkresult=0)) and "
						+ conditions;
			}
		}
		// if(page.getFirstResult()==0 && state==0){
		// //查询第一页合法年检数据时，则将已过有效期的数据自动为脱检状态
		// String updatesql="update ynzc_tractorinfo set status=5 where id in
		// (select updateview.updateids from (SELECT
		// distinct(ynzc_tractorinfo_view.id) as updateids FROM
		// ynzc_tractorinfo_view left Join ynzc_carcheck ON
		// ynzc_tractorinfo_view.id = ynzc_carcheck.tractorinfoId where unitid
		// in (select id from ynzc_unitmanage where regionid like (select
		// concat(regionid,'%') from (SELECT a.id,regionid,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="+userid+")) and
		// ynzc_tractorinfo_view.status=2 and
		// ynzc_tractorinfo_view.checkexpirydate<=now() and (ynzc_carcheck.id is
		// null or ynzc_carcheck.checkresult=1 or ynzc_carcheck.checkresult=2))
		// updateview)";
		// hibernateTemplate.getSessionFactory().openSession().createSQLQuery(updatesql).executeUpdate();
		// }
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List<TractorInfoView> res = hibernateTemplate.getSessionFactory()
				.openSession().createSQLQuery(sql).addEntity(
						TractorInfoView.class).list();
		return res;
	}

	public boolean updateExpirydate() {
		String updatesql = "update ynzc_tractorinfo set status=5 where id in  (select updateview.updateids from (SELECT  distinct(ynzc_tractorinfo_view.id)  as updateids  FROM  ynzc_tractorinfo_view  where ynzc_tractorinfo_view.checkexpirydate<now())  updateview)";
		try {
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(
					updatesql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} 
	} 
	  
	public List<TractorInfoView> getFilingList(Page page,
			String conditions, String regionid){
		String sql="",tsql="";
		String region[]=regionid.split(",");
		if (conditions == "") {
			sql = "select * from ynzc_tractorinfo_view tab1,(select id from ynzc_tractorinfo where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(*) from ynzc_tractorinfo_view tab1,(select id from ynzc_tractorinfo where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")) tab2 where tab1.id = tab2.id";
		}else{
			sql = "select * from ynzc_tractorinfo_view tab1,(select id from ynzc_tractorinfo where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+") order by id DESC limit "+page.getFirstResult()+","+page.getPageSize()+") tab2 where tab1.id = tab2.id";
			tsql = "select count(*) from ynzc_tractorinfo_view tab1,(select id from ynzc_tractorinfo where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+")) tab2 where tab1.id = tab2.id";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorInfoView> otm=new ObjectListToModelList<TractorInfoView>(TractorInfoView.class);
		List<TractorInfoView> back=new ArrayList();
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
	
	public List<TractorInfoView> getFilingListQuery(Page page,
			String conditions, String regionid){
		String sql="",tsql="";
		String region[]=regionid.split(",");
		sql = "select * from ynzc_tractorinfo_view where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+") limit "+page.getFirstResult()+","+page.getPageSize();
		tsql = "select count(*) from ynzc_tractorinfo_view where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and ("+conditions+")";
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		ObjectListToModelList<TractorInfoView> otm=new ObjectListToModelList<TractorInfoView>(TractorInfoView.class);
		List<TractorInfoView> back=new ArrayList();
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

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
