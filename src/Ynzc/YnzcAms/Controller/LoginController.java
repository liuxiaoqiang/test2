package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.MD5;
 
public class LoginController extends BaseController{
	private final static Logger log = Logger.getLogger(LoginController.class);
	
		public void Login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
 		System.out.println("reach LoginController");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		password = MD5.getMD5Str(password);
		User user=serviceManager.getUserService().getUserByUsername(username);
		HashMap<String,Object> hm=(HashMap<String,Object>)request.getSession().getServletContext().getAttribute("onlineMap");
		HashMap<String,Object> update=(HashMap<String,Object>)request.getSession().getServletContext().getAttribute("updateStatus");
		if(update==null){
			update=new HashMap<String,Object>();
		}
		if(user!=null){
			UnitManage um=serviceManager.getUnitManageService().findUnitManageById(user.getUnitid());
			if(user.getPassword().equals(password)&&user.getUsername().equals(username)){
				if(hm==null){
					hm=new HashMap<String,Object>();
					hm.put(user.getUsername(),request.getSession());
					request.getSession().getServletContext().setAttribute("onlineMap",hm);
					request.getSession().getServletContext().setAttribute("change", true);
				}else{
					boolean check=true;
					for(String str:hm.keySet()){
						if(str.equals(user.getUsername())){
							HttpSession session=(HttpSession)hm.get(str);
							hm.remove(str);						
							session.invalidate();
							if(update.size()>0){
								update.clear();
							}
							update.putAll(hm);
							request.getSession().getServletContext().setAttribute("updateStatus",update);
							hm.put(user.getUsername(),request.getSession());
							request.getSession().getServletContext().setAttribute("onlineMap",hm);
							request.getSession().getServletContext().setAttribute("change", true);
							check=false;
							break;
						}
					}
					if(check){
						if(update.size()>0){
							update.clear();
						}
						update.putAll(hm);
						request.getSession().getServletContext().setAttribute("updateStatus",update);
						hm.put(user.getUsername(),request.getSession());
						request.getSession().getServletContext().setAttribute("onlineMap",hm);
						request.getSession().getServletContext().setAttribute("change", true);
					}
				}
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("userUnit", um);
				request.getSession().setAttribute("username", "<font color=blue>"+user.getUsername()+"</font>[<font color=red>"+um.getUseunit()+"</font>]");
				request.getSession().setAttribute("unitid", user.getUnitid());
				request.getSession().setAttribute("unitAddress", um.getAddress());
				request.getSession().setAttribute("regionid", um.getRegionid());
				request.getSession().setAttribute("platecode",um.getPlatecode());
				request.getSession().setAttribute("unit",um.getUseunit());
				request.getSession().setAttribute("oper", user.getUsername());
				response.getWriter().write("{success:true}");
			}else{
				response.getWriter().write("{success:false,errors:'用户帐号或密码验证不通过.'}");
			}
		}else{
			response.getWriter().write("{success:false,errors:'用户帐号或密码验证不通过.'}");
		}
	}
	
	public ModelAndView Jump(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("desktop");
	}
	
	public void LogOut(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("user");		
		HashMap<String,Object> hm=(HashMap<String,Object>)request.getSession().getServletContext().getAttribute("onlineMap");
		HashMap<String,Object> update=(HashMap<String,Object>)request.getSession().getServletContext().getAttribute("updateStatus");
		if(update==null){
			update=new HashMap<String,Object>();
		}
		hm.remove(user.getUsername().trim());
		if(update.size()>0){
			update.clear();
		}
		update.putAll(hm);
		request.getSession().getServletContext().setAttribute("updateStatus",update);
		log.info("用户:"+user.getRealname()+" 注销于"+new Date().toLocaleString()+",还有"+hm.size()+"个操作员在线.");
		request.getSession().getServletContext().setAttribute("change", true);
		request.getSession().invalidate();
	}
	
	public void CheckSession(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 HttpSession session=request.getSession();
		 String oldSessionID=request.getParameter("sessionID").trim();
		 if(!oldSessionID.equals(session.getId())){
			 response.getWriter().write("{sessionFailue:true,onlineChange:"+request.getSession().getServletContext().getAttribute("change")+"}");
		 }else{
			 response.getWriter().write("{sessionFailue:false,onlineChange:"+request.getSession().getServletContext().getAttribute("change")+"}");
		 }
	}
	
	public void getOlinePeople(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HashMap<String,Object> hm=(HashMap<String,Object>)request.getSession().getServletContext().getAttribute("onlineMap");
		HashMap<String,Object> update=(HashMap<String,Object>)request.getSession().getServletContext().getAttribute("updateStatus");
		User user=(User)request.getSession().getAttribute("user");
		if(update!=null){
			if(update.size()>0){
				update.remove(user.getUsername());
				request.getSession().getServletContext().setAttribute("updateStatus",update);
			}else{
				request.getSession().getServletContext().setAttribute("change", false);
			}
		}else{
			request.getSession().getServletContext().setAttribute("change", false);
		}
		String olineTree="";
		for(String str:hm.keySet()){
			HttpSession session=(HttpSession)hm.get(str);
			User sessionuser=(User)session.getAttribute("user");
			if(sessionuser.getUsername()==user.getUsername()){
				continue;
			}
			olineTree+="{id:'"+session.getId()+"',iconCls:'icon-driverRoot',text:'"+user.getRealname()+"[<font color=blue>"+session.getAttribute("unit").toString().trim()+"</font>]',leaf:true},";
		}
		if(olineTree==""){
			olineTree="{}";
		}else{
			olineTree="["+olineTree.substring(0,olineTree.length()-1)+"]";
		}
		System.out.println(olineTree);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(olineTree);
	}
	
	
	}
