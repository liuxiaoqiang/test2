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

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.UserViewData;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.*;

public class UserController extends BaseController {

	private final static Logger log = Logger.getLogger(UserController.class);

	public void getUserList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action GetAllUser");
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
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		User user=(User)request.getSession().getAttribute("user");
		List<UserViewData> res = serviceManager.getUserService().getAllUserView(page,condition,user.getUnitid());
		JSONArray jsonItems = new JSONArray();
		for (UserViewData u : res) {
			if(u.getUsername().trim().equals(user.getUsername())||u.getUsername().trim().equals("admin")){
				continue;
			}
			jsonItems.add(JSONObject.fromObject(u));
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

	public void addUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addUser");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String username=request.getParameter("username").trim();
		String realname=request.getParameter("realname").trim();
		String telephone=request.getParameter("telephone").trim();
		int unitid=Integer.parseInt(request.getParameter("unitid").trim());
		String roleid=request.getParameter("roleid").trim();
		User u=new User();
		u.setPassword(MD5.getMD5Str("123456"));
		u.setUnitid(unitid);
		u.setUsername(username);
		u.setTelephone(telephone);
		u.setRealname(realname);
		u.setRoleid(roleid);
		if(serviceManager.getUserService().getUserByUsername(username)==null){
			if(!serviceManager.getUserService().addUser(u)){
				log.info("Err on add User");
				response.getWriter().write("{failure:true,reason:'添加用户失败'}");
			}
			response.getWriter().write("{success: true}");
		}else{
			response.getWriter().write("{success:false}");
		}
	}
	
	public void delUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("reach delUser");

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String userJson = (String) request.getParameter("userlist").trim();
		JSONArray jsonArray = JSONArray.fromObject(userJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			User user=(User)JSONObject.toBean(jsonObject, User.class);
			boolean isDelete = serviceManager.getUserService().delUser(user);
			if (!isDelete) {
				log.info("Err on delete User");
				response.getWriter().write("{failure:true,reason:'不存在要删除的用户'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void updatePersonal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		String username=request.getParameter("username").trim();
		String realname=request.getParameter("realname").trim();
		String telephone=request.getParameter("telephone").trim();
		int unitid=Integer.parseInt(request.getParameter("unitid").trim());
		String roleid=request.getParameter("roleid").trim();
		log.info("update Personal");
		User u=(User)request.getSession().getAttribute("user");
		u.setRealname(realname);
		u.setUsername(username);
		u.setTelephone(telephone);
		u.setUnitid(unitid);
		u.setRoleid(roleid);
		if(!serviceManager.getUserService().updateUser(u)){
			log.info("Err on update User");
			response.getWriter().write("{failure:true,reason:'更新用户失败'}");
		}
		response.getWriter().write("{success: true}");
	}
	
	public void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		int id=Integer.parseInt(request.getParameter("id").trim());
		String username=request.getParameter("username").trim();
		String realname=request.getParameter("realname").trim();
		String telephone=request.getParameter("telephone").trim();
		int unitid=Integer.parseInt(request.getParameter("unitid").trim());
		String roleid=request.getParameter("roleid").trim();
		log.info("update User id="+id);
		User u=serviceManager.getUserService().findUserById(id);
		u.setRealname(realname);
		u.setUnitid(unitid);
		u.setRoleid(roleid);
		u.setUsername(username);
		u.setTelephone(telephone);
		if(!serviceManager.getUserService().updateUser(u)){
			log.info("Err on update User");
			response.getWriter().write("{failure:true,reason:'更新用户失败'}");
		}
		response.getWriter().write("{success: true}");
	}
	
	
	//得到所有的用户。不分页
	public void getAllUserList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action GetAllUser");
		List<User> res = serviceManager.getUserService().getAllUserList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (User u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("dataList", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
//	public void getPalteCodeUser(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		log.info("Someone come from ip address <" + request.getRemoteAddr()
//				+ ">");
//		log.info("Action getPalteCodeUser");
//		User user=(User)request.getSession().getAttribute("user");
//		List<UserViewData> res = serviceManager.getUserService().getPalteCodeUser(user.getId());//得到所有的集合
//		JSONArray jsonItems = new JSONArray();
//		for (UserViewData u : res) {
//			jsonItems.add(JSONObject.fromObject(u));
//		}
//		JSONObject jsonBack = new JSONObject();
//		
//		jsonBack.put("PalteCodeUser", jsonItems);
//		System.out.println(jsonBack);
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print(jsonBack);
//	}
//	public void getBusinessUser(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		log.info("Someone come from ip address <" + request.getRemoteAddr()
//				+ ">");
//		log.info("Action getBusinessUser");
//		User user=(User)request.getSession().getAttribute("user");
//		List<UserViewData> res = serviceManager.getUserService().getBusinessUser(user.getId());//得到所有的集合
//		JSONArray jsonItems = new JSONArray();
//		for (UserViewData u : res) {
//			jsonItems.add(JSONObject.fromObject(u));
//		}
//		JSONObject jsonBack = new JSONObject();
//		
//		jsonBack.put("BusinessUser", jsonItems);
//		System.out.println(jsonBack);
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print(jsonBack);
//	}
	public void getUserPlate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getBusinessUser");
		User user=(User)request.getSession().getAttribute("user");
		UserViewData userview = serviceManager.getUserService().getUserViewById(user.getId());//得到所有的集合
		JSONObject jsonBack = new JSONObject();		
		jsonBack.put("userplate", userview.getPlatecode());
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	public void getPersonal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action Get Personal Info");
		User user=(User)request.getSession().getAttribute("user");
		JSONObject jsonObject=JSONObject.fromObject(user);
		System.out.println(jsonObject);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
	}
	
	public void resetPwd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		User user=(User)request.getSession().getAttribute("user");
		String oldpwd=request.getParameter("oldpwd").trim();
		String newpwd=request.getParameter("newpwd").trim();
		if(MD5.getMD5Str(oldpwd).equals(user.getPassword())){
			user.setPassword(MD5.getMD5Str(newpwd));
			if(serviceManager.getUserService().updateUser(user)){
				log.info("User ["+user.getRealname()+"] reset Password");
			}
			response.getWriter().print("{success:true}");
		}else{
			response.getWriter().print("{success:false}");
		}
	}

}
