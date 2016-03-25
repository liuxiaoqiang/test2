package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceDefile;
import Ynzc.YnzcAms.Model.DrivingLicenceDefileView;
import Ynzc.YnzcAms.Model.DrivingLicenceLogout;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicenceDefileController extends BaseController{

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DrivingLicenceDefileController.class);
	
	public void getAllDrivingLicenceDefile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		if (request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if (request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		List<DrivingLicenceDefileView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceDefileService().getAllDrivingLicenceDefileQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceDefileService().getAllDrivingLicenceDefile(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceDefileView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void addDrivingLicenceDefile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
			DrivingLicenceDefile model = new DrivingLicenceDefile();
			model.setOperationNameType(3);
			model.setDrivingLicenceId(Integer.parseInt(request.getParameter("drivingLicenceId").trim()));
			model.setCausation(request.getParameter("causation").trim());
			model.setProveType(Integer.valueOf(request.getParameter("proveType").trim()));
			model.setProveId(request.getParameter("proveId").trim());
			model.setRegisterTransactor(user.getUsername());
			model.setRegisterTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setAuditingDefileFlag(-1);
			model.setPigeonholeFlag(-1);
			model.setUnitId(user.getUnitid());
			model.setRegionId(unit.getRegionid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(0);
			if (serviceManager.getDrivingLicenceDefileService().addDrivingLicenceDefile(model)) {
				response.getWriter().write("{success:true,reason:'添加成功'}");
			} else {
				response.getWriter().write("{success:false,reason:'添加失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'添加失败'}");
			ex.printStackTrace();
		}
	}
	
	public void updateDrivingLicenceDefile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			DrivingLicenceLogout model = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutById(Integer.parseInt(request.getParameter("id").trim()));
			model.setCausation(request.getParameter("causation").trim());			
			model.setProveType(Integer.valueOf(request.getParameter("proveType").trim()));
			model.setProveId(request.getParameter("proveId").trim());
			model.setUnitId(user.getUnitid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(0);
			if (serviceManager.getDrivingLicenceLogoutService().updateDrivingLicenceLogout(model)) {
				response.getWriter().write("{success:true,reason:'修改成功'}");
			} else {
				response.getWriter().write("{success:false,reason:'修改失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'修改失败'}");
			ex.printStackTrace();
		}
	}
	
	public void delDrivingLicenceDefile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String ids = (String) request.getParameter("id").trim();
			boolean isDelete = serviceManager.getDrivingLicenceDefileService().delDrivingLicenceDefile(ids);
			if (!isDelete) {
				response.getWriter().write("{success:false,reason:'删除失败'}");
			}else{
				response.getWriter().write("{success: true,reason:'删除成功'}");
			}	
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'删除失败'}");
			ex.printStackTrace();
		}
	}
	
	public void changeState(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			String id = request.getParameter("id").trim();
			serviceManager.getDrivingLicenceDefileService().drivingLicenceDefileState(id,1);
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			changeOperation operation = new changeOperation(id,st.getLicenseChangeTime(),user);
			Thread thread = new Thread(operation, "changeOperationPass");
			thread.start();
			response.getWriter().write("{success:true,reason:'信息已经上报'}");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private class changeOperation implements Runnable {
		private String id;
		private int time;
		private User user;
		public changeOperation(String id,int time,User user){
			this.id = id;
			this.time = time;
			this.user = user;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(id,time,user);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private String id;
		private int time;
		private User user;
		public EggTimer(String id,int time,User user) {
			this.id = id;
			this.time = time;
			this.user = user;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					String[] ids = id.split(",");
					for(String str :ids){
						DrivingLicenceDefile model = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileByid(Integer.valueOf(str));
						if(model.getState()<2){
							model.setAuditingDefileFlag(1);
							model.setAuditingDefileDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setAuditingTransactor(user.getUsername());
							model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setState(2);
							DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
							drivingLicencemodel.setDrivingLicenceFlag(0);
							serviceManager.getDrivingLicenceDefileService().updateDrivingLicenceDefile(model);
							serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel);
						}
					}
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
}
