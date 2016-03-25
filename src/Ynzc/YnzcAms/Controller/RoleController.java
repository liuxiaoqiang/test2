package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.Menu;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Permissions;
import Ynzc.YnzcAms.Model.PermissionsView;
import Ynzc.YnzcAms.Model.Role;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class RoleController extends BaseController {

	private final static Logger log = Logger.getLogger(RoleController.class);

	public void getRoleList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		System.out.println("Get Role List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		User user=(User)request.getSession().getAttribute("user");
		List<Role> res = serviceManager.getRoleService().getAllRole(page,user.getId());
		JSONArray jsonItems = new JSONArray();
		for (Role r : res) {
			jsonItems.add(JSONObject.fromObject(r));
			
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getAllRole(HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		System.out.println("Get RoleStore");
		User user=(User)request.getSession().getAttribute("user");
		List<Role> res = serviceManager.getRoleService().getAllRole(user.getId());
		JSONArray jsonItems = new JSONArray();
		for (Role r : res) {
			jsonItems.add(JSONObject.fromObject(r));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("Role", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void getAllShowRole(HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		System.out.println("Get ShowRoleStore");
		List<Role> res = serviceManager.getRoleService().getAllRole();
		JSONArray jsonItems = new JSONArray();
		for (Role r : res) {
			jsonItems.add(JSONObject.fromObject(r));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("Role", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void addRole(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String rolename = (String) request.getParameter("rolename").trim();
		log.info("Add new Role:["+rolename+"]");
		User user=(User)request.getSession().getAttribute("user");
		Role role = new Role();
		role.setRolename(rolename);
		role.setUnitid(user.getUnitid());
		if (serviceManager.getRoleService().addRole(role)) {
			log.info("角色创建成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'角色创建失败，请重新尝试!'}");
		}
	}


	public void updateRole(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		Role role=new Role();
		String id = (String) request.getParameter("id").trim();
		String rolename =(String) request.getParameter("rolename").trim();
		User user=(User)request.getSession().getAttribute("user");
		log.info("Update Role");
		role.setId(Integer.parseInt(id));
		role.setRolename(rolename);
		role.setUnitid(user.getUnitid());
		if (serviceManager.getRoleService().updateRole(role)) {
			log.info("角色信息修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'角色信息修改失败，请重新尝试!'}");
		}
	}

	public void delRole(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del Role");
		String roleJson = (String) request.getParameter("rolelist").trim();
		JSONArray jsonArray = JSONArray.fromObject(roleJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			Role role = (Role)JSONObject.toBean(jsonObject,Role.class);
			boolean isDelete = serviceManager.getRoleService().delRole(role);
			if (!isDelete) {
				log.info("Err on delete Role");
				response.getWriter().write("{failure:true,reason:'不存在要删除的角色'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void getAllRolePermissions(HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get AllRolePermissions");
		List<PermissionsView> Per = serviceManager.getRoleService().getPermissionsByRoleID(Integer
				.parseInt(request.getParameter("roleid").trim()));
		List<Menu> Root = serviceManager.getMenuService().getAllRoot();
		List<Menu> Module = serviceManager.getMenuService().getAllModule();
		JSONArray jsonItems = new JSONArray();
		for (PermissionsView p : Per) {
			for (Menu mr : Root) {
				if (p.getFatherid() == mr.getId()) {
					for (Menu mm : Module) {
						if (mr.getFatherid() == mm.getId()) {
							Menu ms=new Menu();
							ms.setId(p.getMenuid());
							ms.setMenu("[" + mm.getMenu() + "][" + mr.getMenu()+ "]" + p.getMenu());
							if (request.getParameter("fatherid") != null) {
								if (mm.getId() != Integer.parseInt(request.getParameter("fatherid").trim())) {
									continue;
								}
							}
							jsonItems.add(JSONObject.fromObject(ms));
							break;
						}
					}
					break;
				}
			}
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("Per", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);

	}

	public void setPermissions(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("user");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.info("Set Permissions By["+user.getUsername()+"]");
		int roleid=Integer.parseInt(request.getParameter("roleid").trim());
		String perlist=request.getParameter("addlist").trim();
		JSONArray jsonArray = JSONArray.fromObject(perlist);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			Menu m=(Menu)JSONObject.toBean(jsonObject, Menu.class);
			Permissions per=new Permissions();
			per.setRoleid(roleid);
			per.setMenuid(m.getId());
			if(!serviceManager.getRoleService().addPermissions(per)){
				log.info("Err on set Permissions");
				response.getWriter().write("{success: false}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void delPermissions(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("user");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int operRoleid=Integer.parseInt(request.getParameter("roleid").trim());
		String dellist=request.getParameter("dellist").trim();
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.info("del ["+operRoleid+"] Permissions By["+user.getUsername()+"]");
		List<Permissions> res=serviceManager.getRoleService().getRolePermissions(operRoleid);
		String perlist=request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(perlist);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while(iterator.hasNext()){
			jsonObject = JSONObject.fromObject(iterator.next());
			Menu m=(Menu)JSONObject.toBean(jsonObject, Menu.class);
			for(Permissions p:res){
				if(m.getId()==p.getMenuid()){
					serviceManager.getRoleService().delPermissions(p);
					break;
				}
			}
		}
		response.getWriter().write("{success: true}");
	}

	}
