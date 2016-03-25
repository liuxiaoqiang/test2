package Ynzc.YnzcAms.Dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

import Ynzc.YnzcAms.Dao.ReaperPlateDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ReaperPlate;
import Ynzc.YnzcAms.Model.ReaperPlateViewData;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.UniteharvesterView;
import Ynzc.YnzcAms.Model.User;

public class ReaperPlateDaoImpl implements ReaperPlateDao{

	private HibernateTemplate hibernateTemplate;
	
	public boolean isExist(String platenum, String platehead) {
		// TODO Auto-generated method stub
		List res=hibernateTemplate.find("from ReaperPlate where platenum='"+platenum+"' and platehead='"+platehead+"'");
		if(res.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean updatePlate(String platenum, String platehead) {
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			String sql = "update ynzc_reaperplate set status = 1 where platenum ='"
					+ platenum + "' and platehead ='" + platehead+"'";
			session.createSQLQuery(sql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updatePlateBatch(String numberStr, String platehead,int unitid){
		try{
			Session session = hibernateTemplate.getSessionFactory().openSession();
			String sql = "update ynzc_reaperplate set status = 2, unitid="+unitid+" where platehead ='"+platehead+"' and platenum in("+numberStr+")";
			session.createSQLQuery(sql).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public ReaperPlate getPlateCode(String platenum,String platehead,int unitid){
		List res=hibernateTemplate.find("from ReaperPlate where platenum='"+platenum+"' and platehead='"+platehead+"' and unitid="+unitid);
		if(res.size()>0){
			return (ReaperPlate)res.get(0);
		}else{
			return null;
		}
	}
	public boolean InputLib(int unitid,int psid,String submitman) {
		// TODO Auto-generated method stub
		try{
			Session session=hibernateTemplate.getSessionFactory().openSession();
			String inputStr="insert into ynzc_reaperplate(platenum,platehead,status,unitid) select platenum,platenumhead,0,"+unitid+" from ynzc_newreaperplate where madestatus=1 and psid="+psid;
			session.createSQLQuery(inputStr).executeUpdate();
			String complateStr="update ynzc_newreaperplate set madestatus=3 where madestatus=1 and psid="+psid;
			session.createSQLQuery(complateStr).executeUpdate();
			String submitRecordUpdateStr="update ynzc_reaperplatesubmit set provinceinputman='"+submitman+"',provinputtime=now() where id="+psid;
			session.createSQLQuery(submitRecordUpdateStr).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<ReaperPlateViewData> getPlateLibList(Page page, String conditions, int userid, int plateStatus) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			if(plateStatus==0){
				sql="select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_reaperplate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status=0 and a.unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by a.id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_reaperplate where status=0 and unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
			}else{
				sql="select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_reaperplate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status<>0 and a.unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) order by a.id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_reaperplate where status<>0 and unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
			}
		}else{
			if(plateStatus==0){
				sql="select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_reaperplate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status=0 and a.unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_reaperplate where status=0 and unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ")";
			}else{
				sql="select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_reaperplate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status<>0 and a.unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from ynzc_reaperplate where status<>0 and unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) and (" + conditions + ")";
			}
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<ReaperPlateViewData> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReaperPlateViewData.class)).list();
		return res;
	}
	
	public List<ReaperPlate> getPlateChangeList(int userid, int type){
		String sql="";
		if(type==0){
			sql="select * from ynzc_reaperplate where status=4 and unitid in(select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
			List<ReaperPlate> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReaperPlate.class)).list();
			return res;
		}else{
			sql="select * from ynzc_reaperplate where status in ('5','6','7') and unitid in(select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
			List<ReaperPlate> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReaperPlate.class)).list();
			return res;
		}
	}
	
	public List<ReaperPlateViewData> getPlateLibList(Page page, String conditions,
			int untilid, String mark){
		if(mark.equals("0")){
		String sql ="select * from ynzc_reaperplate where unitid="+untilid;
			Session session = hibernateTemplate.getSessionFactory().openSession();
			List<ReaperPlateViewData> res =session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReaperPlateViewData.class)).list();
			return res;
		}else{
			String sql = "select *from ynzc_reaperplate where status=3 and unitid="+untilid;
			Session session = hibernateTemplate.getSessionFactory().openSession();
			List<ReaperPlateViewData> res =session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ReaperPlateViewData.class)).list();
			return res;
			
		}
		
	}
	public String getMinPlateCode(int unitid){
		String sql ="select concat( platehead,'.',min(platenum)) from ynzc_plate where status=3 and unitid="+unitid;
		return hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString();
	}
	
	public boolean updatePlateInfo(ReaperPlate plate){
		try{
			hibernateTemplate.update(plate);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	public boolean delPlate(ReaperPlate plate){
		try{
			hibernateTemplate.delete(plate);
			return true;
		}catch(Exception e){
			return false;
		}
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public ReaperPlate getLowNum(int userid) {
		// TODO Auto-generated method stub
		String sql="";
		sql="select * from ynzc_reaperplate where status=2 and unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from ynzc_user_view where id="+userid+")) limit 0,1";
		List<ReaperPlate> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(ReaperPlate.class).list();
		if (res.size() > 0) {
			return (ReaperPlate) res.get(0);
		} else {
			return null;
		}
	}

	public boolean updateState(String num, String plateCode, int state) {
		// TODO Auto-generated method stub
		String sql="update ReaperPlate set status="+state+" where platenum ='"+num+"'  and platehead='"+plateCode+"'";
		int result = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql).executeUpdate();
        if(result>0){
        	return true;
        }
        else{
        	return false;
        }
	}

	
}
