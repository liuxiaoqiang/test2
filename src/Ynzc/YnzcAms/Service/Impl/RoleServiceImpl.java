package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.RoleDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Permissions;
import Ynzc.YnzcAms.Model.PermissionsView;
import Ynzc.YnzcAms.Model.Role;
import Ynzc.YnzcAms.Service.RoleService;

public class RoleServiceImpl implements RoleService{
	
	private RoleDao roleDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public boolean addPermissions(Permissions p) {
		// TODO Auto-generated method stub
		return roleDao.addPermissions(p);
	}

	public boolean addRole(Role r) {
		// TODO Auto-generated method stub
		return roleDao.addRole(r);
	}

	public boolean delPermissions(Permissions p) {
		// TODO Auto-generated method stub
		return roleDao.delPermissions(p);
	}

	public boolean delRole(Role r) {
		// TODO Auto-generated method stub
		return roleDao.delRole(r);
	}

	public List<Role> getAllRole(Page page,int userid) {
		// TODO Auto-generated method stub
		return roleDao.getAllRole(page,userid);
	}

	public List<Role> getAllRole(int userid) {
		// TODO Auto-generated method stub
		return roleDao.getAllRole(userid);
	}

	public List<PermissionsView> getPermissionsByRoleID(int roleid) {
		// TODO Auto-generated method stub
		return roleDao.getPermissionsByRoleID(roleid);
	}

	public List<Permissions> getRolePermissions(int roleid) {
		// TODO Auto-generated method stub
		return roleDao.getRolePermissions(roleid);
	}
	
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleDao.getAllRole();
	}

	public Role getRoleByID(int id) {
		// TODO Auto-generated method stub
		return roleDao.getRoleByID(id);
	}

	public boolean updateRole(Role r) {
		// TODO Auto-generated method stub
		return roleDao.updateRole(r);
	}
}
