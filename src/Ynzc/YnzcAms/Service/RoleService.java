package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Permissions;
import Ynzc.YnzcAms.Model.PermissionsView;
import Ynzc.YnzcAms.Model.Role;

public interface RoleService {
	public List<Role> getAllRole(Page page,int userid);
	public List<Role> getAllRole(int userid);
	public List<Role> getAllRole();
	public boolean addRole(Role r);
	public boolean delRole(Role r);
	public boolean updateRole(Role r);
	public Role getRoleByID(int id);
	public List<PermissionsView> getPermissionsByRoleID(int roleid);
	public List<Permissions> getRolePermissions(int roleid);
	public boolean addPermissions(Permissions p);
	public boolean delPermissions(Permissions p);
}
