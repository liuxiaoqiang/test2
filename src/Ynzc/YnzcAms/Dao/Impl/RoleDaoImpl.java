package Ynzc.YnzcAms.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import Ynzc.YnzcAms.Dao.RoleDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Permissions;
import Ynzc.YnzcAms.Model.PermissionsView;
import Ynzc.YnzcAms.Model.PlateViewData;
import Ynzc.YnzcAms.Model.Role;

public class RoleDaoImpl implements RoleDao {

	private HibernateTemplate hibernateTemplate;
	
	public boolean addPermissions(Permissions p) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(p);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean addRole(Role r) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(r);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delPermissions(Permissions p) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.delete(p);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delRole(Role r) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.delete(r);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<Role> getAllRole(Page page,int userid) {
		// TODO Auto-generated method stub
		String sql="select * from ynzc_role where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id))) limit "+page.getFirstResult()+","+page.getPageSize();
		String tsql="select count(*) from ynzc_role where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		page.setTotalCount(Integer.parseInt(hibernateTemplate.getSessionFactory().openSession().createSQLQuery(tsql).uniqueResult().toString()));
		List<Role> res =hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(Role.class).list();
		return res;
	}

	public List<Role> getAllRole(int userid) {
		// TODO Auto-generated method stub
		String sql="select * from ynzc_role where unitid in (select id from ynzc_unitmanage where instr(regionid,(select regionid from ynzc_user,ynzc_unitmanage where ynzc_user.id="+userid+" and ynzc_user.unitid=ynzc_unitmanage.id)))";
		List<Role> res=hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql).addEntity(Role.class).list();
		return res;
	}

	public List<PermissionsView> getPermissionsByRoleID(int roleid) {
		// TODO Auto-generated method stub
		List<PermissionsView> res=hibernateTemplate.find("from PermissionsView where roleid="+roleid);
		return res;
	}

	public Role getRoleByID(int id) {
		// TODO Auto-generated method stub
		List<Role> res=hibernateTemplate.find("from Role where id="+id);
		if(res.size()>0){
			return (Role)res.get(0);
		}else{
			return null;
		}
	}

	public boolean updateRole(Role r) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.update(r);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<Permissions> getRolePermissions(int roleid) {
		// TODO Auto-generated method stub
		List<Permissions> res=hibernateTemplate.find("from Permissions where roleid="+roleid);
		return res;
	}
	
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		List<Role> res=hibernateTemplate.loadAll(Role.class);
		return res;
	}
		
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
