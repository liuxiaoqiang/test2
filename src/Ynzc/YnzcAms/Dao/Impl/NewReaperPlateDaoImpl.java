package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mysql.jdbc.PreparedStatement;

import Ynzc.YnzcAms.Dao.NewReaperPlateDao;
import Ynzc.YnzcAms.Model.NewReaperPlate;
import Ynzc.YnzcAms.Model.Page;

public class NewReaperPlateDaoImpl implements NewReaperPlateDao{
	
	private HibernateTemplate hibernateTemplate;

	public boolean addAPlate(NewReaperPlate np) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(np);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean addPlateBat(int start, int end, String platenumhead, int psid) {
		// TODO Auto-generated method stub
		try{
			NewReaperPlate np=new NewReaperPlate();
			String insertSQL="";
			Session session=hibernateTemplate.getSessionFactory().openSession();
			for(int i=start;i<=end;i++){		
				insertSQL="INSERT INTO ynzc_newreaperplate VALUES(0,'"+intBit(i)+"','"+platenumhead+"',"+psid+",0);";
				session.createSQLQuery(insertSQL).executeUpdate();
			}
			session.close();
//			Session session=hibernateTemplate.getSessionFactory().openSession();
//			PreparedStatement pst = (PreparedStatement)session.connection().prepareStatement("insert into ynzc_newplate values(0,?,?,?,0);");
//			for(int i=start;i<end;i++){
//				pst.setString(1, intBit(i));
//				pst.setString(2, platenumhead);
//				pst.setInt(3, psid);
//				pst.addBatch();
//			}
//			pst.executeBatch();
//			session.connection().commit();
//			pst.close();
//			session.connection().close();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delAPlate(NewReaperPlate np) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.delete(np);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<NewReaperPlate> getAllNewPlate(Page page,int psid,String conditions ,int type) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(type==0){
			if(conditions==""){
				sql="select * from ynzc_newreaperplate where madestatus=0 and psid="+psid+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from NewReaperPlate where madestatus=0 and psid="+psid;
			}else{
				sql="select * from ynzc_newreaperplate where madestatus=0 and psid="+psid+" and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from NewReaperPlate where madestatus=0 and psid="+psid+" and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
			List<NewReaperPlate> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(NewReaperPlate.class).list();
			return res;
		}else{
			if(conditions==""){
				sql="select * from ynzc_newreaperplate where madestatus=7 and psid="+psid+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from NewReaperPlate where madestatus=7 and psid="+psid;
			}else{
				sql="select * from ynzc_newreaperplate where madestatus=7 and psid="+psid+" and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
				tsql="select count(*) from NewReaperPlate where madestatus=7 and psid="+psid+" and (" + conditions + ")";
			}
			page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
			List<NewReaperPlate> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(NewReaperPlate.class).list();
			return res;
		}
	}
	
	public List<NewReaperPlate> getAllMadePlate(Page page, int psid, String conditions) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions==""){
			sql="select * from ynzc_newreaperplate where madestatus=1 and psid="+psid+" order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from NewReaperPlate where madestatus=1 and psid="+psid;
		}else{
			sql="select * from ynzc_newreaperplate where madestatus=1 and psid="+psid+" and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="select count(*) from NewReaperPlate where madestatus=1 and psid="+psid+" and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		List<NewReaperPlate> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(NewReaperPlate.class).list();
		return res;
	}
	
	public boolean delAllPlate(int psid) {
		// TODO Auto-generated method stub
		try{
			String deleteSQL="delete from ynzc_newreaperplate where psid="+psid;
			hibernateTemplate.getSessionFactory().openSession().createSQLQuery(deleteSQL).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public String intBit(int i){  //41800
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
	
	public boolean flagAll(int psid) {
		// TODO Auto-generated method stub
		try{
			Session session=hibernateTemplate.getSessionFactory().openSession();
			String isExistStr="update ynzc_reaperplate a inner join ynzc_newreaperplate b on a.platenum=b.platenum and a.platehead=b.platenumhead set madestatus=4 where psid="+psid;
			String updateStr="update ynzc_newreaperplate set madestatus=1 where psid="+psid+" and madestatus in('0','7')";
			session.createSQLQuery(isExistStr).executeUpdate();
			session.createSQLQuery(updateStr).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean updateNewPlate(NewReaperPlate np) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(np);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<NewReaperPlate> getAllNewPlateHandle(Page page, int psid,
			String conditions) {
		String sql = "", tsql = "";
		if (conditions == "") {
			sql = "select * from ynzc_newreaperplate where madestatus !=3 and madestatus !=1 and  psid=" + psid
					+ " order by id desc limit " + page.getFirstResult() + ","
					+ page.getPageSize();
			tsql = "select count(*) from NewReaperPlate where madestatus !=3 and madestatus !=1 and psid=" + psid;
		} else {
			sql = "select * from ynzc_newreaperplate where madestatus !=3 and madestatus !=1 and psid=" + psid + " and ("
					+ conditions + ") order by id desc limit "
					+ page.getFirstResult() + "," + page.getPageSize();
			tsql = "select count(*) from NewReaperPlate where madestatus !=3 and madestatus !=1 and psid=" + psid
					+ " and (" + conditions + ")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0)
				.toString()));
		List<NewReaperPlate> res = hibernateTemplate.getSessionFactory()
				.openSession().createSQLQuery(sql).addEntity(NewReaperPlate.class)
				.list();
		return res;
	}
	
	
	public List<NewReaperPlate> getAllNewPlateInfo(int psid){
		String sql="select * from ynzc_newreaperplate where psid="+psid;
		List<NewReaperPlate> res= hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(NewReaperPlate.class).list();
		return res;
	}

	
	public boolean allotAll(int psid){
		try{
			Session session = hibernateTemplate.getSessionFactory().openSession();
			String updateStr = "update ynzc_newreaperplate set madestatus = 5 where psid="+psid+" and madestatus=3";
			session.createSQLQuery(updateStr).executeUpdate();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public  boolean laidAll(int psid){
		try{
			Session session = hibernateTemplate.getSessionFactory().openSession();
			String updateStr = "update ynzc_newreaperplate set madestatus = 6 where psid ="+psid+" and madestatus = 5";
			session.createSQLQuery(updateStr).executeUpdate();
			return true;
		}catch(Exception e){
			return true;
		}
	}
	


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
