package Ynzc.YnzcAms.Dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

import Ynzc.YnzcAms.Dao.PlateDao;
import Ynzc.YnzcAms.Model.NewPlate;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Plate;
import Ynzc.YnzcAms.Model.PlateViewData;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;

public class PlateDaoImpl implements PlateDao {

	private HibernateTemplate hibernateTemplate;

	public boolean updatePlate(String platenum, String platehead) {
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			String sql = "update ynzc_plate set status = 1 where platenum ='"
					+ platenum + "' and platehead ='" + platehead + "'";
			session.createSQLQuery(sql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updatePlateStatus(String platenum, String platehead,
			String regionId, int status) {
		try {
			String region[]=regionId.split(",");
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			String sql = "update ynzc_plate set status = " + status
					+ " where platenum ='" + platenum + "' and platehead ='"
					+ platehead + "' and SUBSTRING_INDEX(regionid,',',"+region.length+") ='" + regionId.substring(0,regionId.length()-1) + "'";
			session.createSQLQuery(sql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updatePlateBatch(String numberStr, String platehead,
			int unitid) {
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			String sql = "update ynzc_plate set status = 2, unitid=" + unitid
					+ " where platehead ='" + platehead + "' and platenum in("
					+ numberStr + ")";
			session.createSQLQuery(sql).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Plate getPlateCode(String platenum, String platehead, int unitid) {
		List res = hibernateTemplate.find("from Plate where platenum='"
				+ platenum + "' and platehead='" + platehead + "' and unitid="
				+ unitid);
		if (res.size() > 0) {
			return (Plate) res.get(0);
		} else {
			return null;
		}
	}

	public boolean InputLib(int unitid, int psid, String submitman) {
		// TODO Auto-generated method stub
		try {
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			String inputStr = "insert into ynzc_plate(platenum,platehead,status,unitid) select platenum,platenumhead,0,"
					+ unitid
					+ " from ynzc_newplate where madestatus=1 and psid=" + psid;
			session.createSQLQuery(inputStr).executeUpdate();
			String complateStr = "update ynzc_newplate set madestatus=3 where madestatus=1 and psid="
					+ psid;
			session.createSQLQuery(complateStr).executeUpdate();
			String submitRecordUpdateStr = "update ynzc_platesubmit set provinceinputman='"
					+ submitman + "',provinputtime=now() where id=" + psid;
			session.createSQLQuery(submitRecordUpdateStr).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Plate> getPlateLibList(Page page, String conditions,int userid, int plateStatus) {
		// TODO Auto-generated method stub
		String sql = "", tsql = "";
		if (conditions == "") {
			if (plateStatus == 0) {
				sql = "select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_plate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status=0 and a.unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid
						+ ")) order by a.id desc limit "
						+ page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_plate where status=0 and unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid + "))";
			} else {
				sql = "select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_plate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status<>0 and a.unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid
						+ ")) order by a.id desc limit "
						+ page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_plate where status<>0 and unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid + "))";
			}
		} else {
			if (plateStatus == 0) {
				sql = "select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_plate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status=0 and a.unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid
						+ ")) and ("
						+ conditions
						+ ") order by id desc limit "
						+ page.getFirstResult()
						+ "," + page.getPageSize();
				tsql = "select count(*) from ynzc_plate where status=0 and unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid + ")) and (" + conditions + ")";
			} else {
				sql = "select a.id,a.platenum,a.platehead,a.status,a.unitid,b.useunit from ynzc_plate as a left join ynzc_unitmanage as b on a.unitid=b.id where a.status<>0 and a.unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid
						+ ")) and ("
						+ conditions
						+ ") order by id desc limit "
						+ page.getFirstResult()
						+ "," + page.getPageSize();
				tsql = "select count(*) from ynzc_plate where status<>0 and unitid in (select id from ynzc_unitmanage where regionid like (select concat(regionid,'%') from (SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id) c where c.id="
						+ userid + ")) and (" + conditions + ")";
			}
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate
				.getSessionFactory().openSession().createSQLQuery(tsql)
				.uniqueResult().toString()));
		List<Plate> res = hibernateTemplate.getSessionFactory()
				.openSession().createSQLQuery(sql).setResultTransformer(
						Transformers.aliasToBean(PlateViewData.class)).list();
		return res;
	}

	public List<Plate> getPlateChangeList(Page page, String conditions,String regionId, int type) {
		String sql = "", tsql = "";
		String region[]=regionId.split(",");
		if (type == 10) {
			if (conditions == "") {
			sql = "select * from ynzc_plate where status in (4,5,6,7) and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by platenum ASC limit "+page.getFirstResult() + "," + page.getPageSize();
			tsql = "select count(*) from ynzc_plate where status in (5,6,7) and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
			}else{
			sql = "select * from ynzc_plate where status in (4,5,6,7) and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by platenum ASC limit "+page.getFirstResult() + "," + page.getPageSize();
			tsql = "select count(*) from ynzc_plate where status in (5,6,7) and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate
					.getSessionFactory().openSession().createSQLQuery(tsql)
					.uniqueResult().toString()));
			List<Plate> res = hibernateTemplate.getSessionFactory()
					.openSession().createSQLQuery(sql).setResultTransformer(
							Transformers.aliasToBean(Plate.class)).list();
			return res;
		} else {
			if (conditions == "") {
				sql = "select * from ynzc_plate where floor(status/10)="+type*2+" and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by platenum ASC limit "+page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_plate where floor(status/10)="+type*2+" and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
			}else{
				sql = "select * from ynzc_plate where floor(status/10)="+type*2+" and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by platenum ASC limit "+page.getFirstResult() + "," + page.getPageSize();
				tsql = "select count(*) from ynzc_plate where floor(status/10)="+type*2+" and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate
					.getSessionFactory().openSession().createSQLQuery(tsql)
					.uniqueResult().toString()));
			List<Plate> res = hibernateTemplate.getSessionFactory()
					.openSession().createSQLQuery(sql).setResultTransformer(
							Transformers.aliasToBean(Plate.class)).list();
			return res;
		}
	}

	public List<Plate> getPlateLibList(Page page, String conditions,
			String regionid, String mark) {
		String region[]=regionid.split(",");
		if (conditions == ""){
		String tsql = "select count(id) from ynzc_plate where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		if (mark.equals("0")) {
			String sql = "select * from ynzc_plate where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") order by id desc limit " + page.getFirstResult() + ","
					+ page.getPageSize();

			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			page.setTotalCount(Integer.parseInt(hibernateTemplate
					.getSessionFactory().openSession().createSQLQuery(tsql)
					.uniqueResult().toString()));
			List<Plate> res = session.createSQLQuery(sql)
					.setResultTransformer(
							Transformers.aliasToBean(Plate.class))
					.list();
			return res;
		} else {
			String sql = "select * from ynzc_plate where status=3 and regionid='"
					+ regionid + "' order by id desc limit "
					+ page.getFirstResult() + "," + page.getPageSize();
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			page.setTotalCount(Integer.parseInt(hibernateTemplate
					.getSessionFactory().openSession().createSQLQuery(tsql)
					.uniqueResult().toString()));
			List<Plate> res = session.createSQLQuery(sql)
					.setResultTransformer(
							Transformers.aliasToBean(Plate.class))
					.list();
			return res;

		}}
		else{
			String tsql = "select count(id) from ynzc_plate where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ")";
			if (mark.equals("0")) {
			String sql = "select * from ynzc_plate where '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+") and (" + conditions + ") order by id desc limit " + page.getFirstResult() + ","
					+ page.getPageSize();

			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			page.setTotalCount(Integer.parseInt(hibernateTemplate
					.getSessionFactory().openSession().createSQLQuery(tsql)
					.uniqueResult().toString()));
			List<Plate> res = session.createSQLQuery(sql)
					.setResultTransformer(
							Transformers.aliasToBean(Plate.class))
					.list();
			return res;
		} else {
			String sql = "select * from ynzc_plate where status=3 and regionid='"
					+ regionid + "' and (" + conditions + ") order by id desc limit "
					+ page.getFirstResult() + "," + page.getPageSize();
			Session session = hibernateTemplate.getSessionFactory()
					.openSession();
			page.setTotalCount(Integer.parseInt(hibernateTemplate
					.getSessionFactory().openSession().createSQLQuery(tsql)
					.uniqueResult().toString()));
			List<Plate> res = session.createSQLQuery(sql)
					.setResultTransformer(
							Transformers.aliasToBean(Plate.class))
					.list();
			return res;

			}			
		}

	}

	public String getMinPlateCode(String regionId) {
		String region[]=regionId.split(",");
		String sql = "select concat( platehead,'.',min(platenum)) from ynzc_plate where status=0 and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";// 查询的是已分配待使用的号牌
		List<String> res = hibernateTemplate.getSessionFactory().openSession()
				.createSQLQuery(sql).list();
		if (res.get(0) != null) {
			String ob = res.get(0);
			System.out.print(ob);
			return (ob);
		} else {
			// String a =
			// hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).uniqueResult().toString();
			return "无号牌";
		}
	}

	public boolean UpdatePlateCodeStateByCode(int state, String platecodes) {
		String sql = "update ynzc_plate set status=" + state
				+ " where concat( platehead,'.',platenum)  in (" + platecodes
				+ ")";
		if (this.getHibernateTemplate().getSessionFactory().openSession()
				.createSQLQuery(sql).executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean UpdatePlateCodeStateByCodeAndHead(int state, String platecode) {
		String sql = "update ynzc_plate set status=" + state
				+ " where concat( platehead,'.',platenum)='" + platecode + "'";
		if (this.getHibernateTemplate().getSessionFactory().openSession()
				.createSQLQuery(sql).executeUpdate() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delPlate(Plate plate) {
		try {
			hibernateTemplate.update(plate);
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

	public boolean isExist(String platenum, String platehead) {
		List res = hibernateTemplate.find("from Plate where platenum='"
				+ platenum + "' and platehead='" + platehead + "'");
		if (res.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Plate getPlate(String platenum, String platehead) {
		List<Plate> res = hibernateTemplate.find("from Plate where platenum='"
				+ platenum + "' and platehead='" + platehead + "'");
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}

	public List<Plate> getPlateByPid(Page page, String pid, String conditions) {
		String sql="",tsql="";
			if(conditions==""){
				sql="select * from ynzc_plate where pid like '%"+pid+",%' order by platenum ASC limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from Plate where pid like '"+pid+",%'";
			}else{
				sql="select * from ynzc_plate where pid like '%"+pid+",%' and (" + conditions + ") order by platenum ASC limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from Plate where pid like '"+pid+",%' and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
			List<Plate> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(Plate.class).list();
			return res;
	}
	
	public boolean addPlate(Plate plate) {
		try {
			hibernateTemplate.save(plate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updatePlateInfo(Plate plate) {
		try {
			hibernateTemplate.update(plate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String intBit(int i){
		String result="";
		String value=""+i;
		if(value.length()<5){
			for(int j=0;j<5-value.length();j++){
				result+="0";
			}
		}
		result+=i;
		return result;
	}
	public boolean addPlateBat(int start, int end, String platenumhead,String regionid,
			String pid, int status) {
		try{
			Plate np=new Plate();
			String insertSQL="";
			Session session=hibernateTemplate.getSessionFactory().openSession();
			for(int i=start;i<=end;i++){		
				insertSQL="INSERT INTO ynzc_plate VALUES(0,'"+intBit(i)+"','"+platenumhead+"',"+status+",'"+regionid+"','"+pid+"');";
				session.createSQLQuery(insertSQL).executeUpdate();
			}
			session.close();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<Plate> getPlateDoList(int type) {
		List<Plate> res = hibernateTemplate.find("from Plate where floor(status/10)="+type*2);
		return res;
	}

	public List<Plate> getPlateDoList(String pid) {
		List<Plate> res = hibernateTemplate.find("from Plate where pid like '%"+pid+"'");
		return res;
	}
	
	public int getPlateNum(String platehead,int status){
		String tsql="select count(*) from ynzc_plate where status="+status+" and platehead='"+platehead+"'";
		return Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString());
	}
	
	public int getPlateNumByRegion(String regionId, int status) {
		String region[]=regionId.split(",");
		String tsql="select count(*) from ynzc_plate where status="+status+" and '"+regionId.substring(0,regionId.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
		return Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString());
	}

	public List<Plate> getPlateList(Page page,String start, String end,String regionid) {
		String region[]=regionid.split(",");
		List<Plate> result=new ArrayList<Plate>();
		try{
			Plate np=new Plate();
			String sql="";
			Session session=hibernateTemplate.getSessionFactory().openSession();
			for(int i=Integer.parseInt(start);i<=Integer.parseInt(end);i++){		
				sql="select * from ynzc_plate where platenum='"+i+"' and '"+regionid.substring(0,regionid.length()-1)+"'=SUBSTRING_INDEX(regionid,',',"+region.length+")";
				List<Plate> res=session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Plate.class)).list();
				if(res.size()>0){
					result.add(res.get(0));
				}
			}
			session.close();
			return result;
		}catch(Exception e){
			return null;
		}
	}
}
