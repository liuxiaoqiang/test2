package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.UserDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateViewData;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.UserReportSource;
import Ynzc.YnzcAms.Model.UserViewData;

public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delUser(User user) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		List<User> res = hibernateTemplate.find("from User where id=" + id);
		if (res.size() > 0) {
			return (User) res.get(0);
		} else {
			return null;
		}
	}
	public UserViewData getUserViewById(int userId){
		String sql="SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid  FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id where a.id="+userId;
		List<UserViewData> res = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserViewData.class)).list();
		if (res.size() > 0) {
			return (UserViewData) res.get(0);
		} else {
			return null;
		}	
	}
	public List<User> getAllUser(Page page,String condition) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(condition.equals("")){
			sql="from User";
			tsql="select count(*) from User";
		}else{
			sql="from User where (" + condition + ")";
			tsql="select count(*) from User where (" + condition + ")";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		page.setTotalCount(Integer.parseInt(hibernateTemplate.find(tsql).get(0).toString()));
		query.setFirstResult(page.getFirstResult());
		query.setMaxResults(page.getPageSize());
		List<User> res = query.list();
		return res;
	}

	public List<User> getAllUserList() {
		return this.hibernateTemplate.loadAll(User.class);
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		List res = hibernateTemplate.find("from User where username='"
				+ username + "'");
		if (res.size() > 0) {
			return (User) res.get(0);
		} else {
			return null;
		}
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<UserViewData> getAllUserView(Page page, String conditions, int unitid) {
		// TODO Auto-generated method stub
		String sql="",tsql="";
		if(conditions.equals("")){
			sql="SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid  FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="SELECT count(*)  FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+")";
		}else{
			sql="SELECT a.id,username,realname,password,telephone,roleid,region,regionid,useunit,platecode,unitid  FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id where regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+") and (" + conditions + ") order by id desc limit "+page.getFirstResult()+","+page.getPageSize();
			tsql="SELECT count(*) FROM ynzc_user a left join ynzc_unitmanage b on a.unitid=b.id where (" + conditions + ") and regionid like (select concat(regionid,'%') from ynzc_unitmanage where id="+unitid+")";
		}
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString())-1);
		List<UserViewData> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(UserViewData.class)).list();
		return res;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
