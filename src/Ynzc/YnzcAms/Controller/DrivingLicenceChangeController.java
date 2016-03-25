 package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.sql.Date;
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
import Ynzc.YnzcAms.Model.DrivingLicenceChange;
import Ynzc.YnzcAms.Model.DrivingLicenceChangeView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicenceChangeController extends BaseController{

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DrivingLicenceChangeController.class);
	
	public void getDrivingLicenceChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceChangeView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceChangeService().getAllDrivingLicenceChangeQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceChangeService().getAllDrivingLicenceChange(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceChangeView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void addDrivingLicenceChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			if(!serviceManager.getDrivingLicenceService().checkDrivingLicenceOperation(request.getParameter("drivingLicenceId").trim())){
				User user=(User)request.getSession().getAttribute("user");
				UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
				DrivingLicenceChange model = new DrivingLicenceChange();
				model.setOperationNameType(1);
				model.setDrivingLicenceId(Integer.parseInt(request.getParameter("drivingLicenceId").trim()));
				model.setChangeName(request.getParameter("changeName").trim());
				model.setChangeBirthday(Date.valueOf(request.getParameter("changeBirthday").trim()));
				model.setChangeIdCard(request.getParameter("changeIdCard").trim());
				model.setChangeAddress(request.getParameter("changeAddress").trim());
				model.setChangeLinkAddress(request.getParameter("changeLinkAddress").trim());
				model.setChangeLinkTel(request.getParameter("changeLinkTel").trim());
				model.setRegisterTransactor(user.getUsername());
				model.setRegisterTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
				model.setAuditingChangeFlag(-1);
				model.setPigeonholeFlag(-1);
				model.setRegionId(unit.getRegionid());
				model.setUnitId(user.getUnitid());
				model.setYear(GetDate.getNowYear());
				model.setWriteUserId(user.getId());
				model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
				model.setState(0);
				if (serviceManager.getDrivingLicenceChangeService().addDrivingLicenceChange(model)) {
					response.getWriter().write("{success:true,reason:'添加成功'}");
				} else {
					response.getWriter().write("{success:false,reason:'添加失败'}");
				}
			}else{
				response.getWriter().write("{success:false,reason:'该驾驶员还在办理其他业务，现在暂时不能办理。'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'添加失败'}");
			ex.printStackTrace();
		}
	}
	
	public void updateDrivingLicenceChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			DrivingLicenceChange model = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(Integer.valueOf(request.getParameter("id").trim()));
			if(model != null){
				model.setOperationNameType(4);
				model.setChangeName(request.getParameter("changeName").trim());
				model.setChangeBirthday(Date.valueOf(request.getParameter("changeBirthday").trim()));
				model.setChangeIdCard(request.getParameter("changeIdCard").trim());
				model.setChangeAddress(request.getParameter("changeAddress").trim());
				model.setChangeLinkAddress(request.getParameter("changeLinkAddress").trim());
				model.setChangeLinkTel(request.getParameter("changeLinkTel").trim());
				model.setAuditingChangeFlag(0);
				model.setPigeonholeFlag(0);
				model.setState(0);
				model.setUnitId(user.getUnitid());
				model.setYear(GetDate.getNowYear());
				model.setWriteUserId(user.getId());
				model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			}
			if (serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(model)) {
				response.getWriter().write("{success:true,reason:'修改成功'}");
			} else {
				response.getWriter().write("{success:false,reason:'修改失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'修改失败'}");
			ex.printStackTrace();
		}
	}
	
//	public void changeState(HttpServletRequest request,HttpServletResponse response) throws Exception {
//		try{
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/json;charset=utf-8");
//			if (serviceManager.getDrivingLicenceChangeService().drivingLicenceChangeState(request.getParameter("id").trim(),1)) {
//				response.getWriter().write("{success:true,reason:'上报成功'}");
//			} else {
//				response.getWriter().write("{success:false,reason:'上报失败'}");
//			}
//		}catch(Exception ex){
//			response.getWriter().write("{success:false,reason:'上报失败'}");
//			ex.printStackTrace();
//		}
//	}
	
	public void delDrivingLicenceChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String ids = (String) request.getParameter("id").trim();
			boolean isDelete = serviceManager.getDrivingLicenceChangeService().delDrivingLicenceChangeState(ids);
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
			serviceManager.getDrivingLicenceChangeService().drivingLicenceChangeState(id,1);
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			if(st == null){
				changeOperation operation = new changeOperation(id,0,user);
				Thread thread = new Thread(operation, "changeOperationPass");
				thread.start();
				response.getWriter().write("{success:true,reason:'信息已经上报'}");
			}else{
				changeOperation operation = new changeOperation(id,st.getLicenseChangeTime(),user);
				Thread thread = new Thread(operation, "changeOperationPass");
				thread.start();
				response.getWriter().write("{success:true,reason:'信息已经上报'}");
			}

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
					for(String str : ids){
						DrivingLicenceChange model = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(Integer.valueOf(str));
						if(model.getState()<2){
							model.setAuditingChangeFlag(1);
							model.setAuditingChangeDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setAuditingTransactor(user.getUsername());
							model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setState(2);
							DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
							drivingLicencemodel.setDrivingLicenceFlag(0);
							PeopleInfo peopleModel = serviceManager.getPeopleInfoService().findPeopleInfoById(drivingLicencemodel.getPeopleInfoId());
							peopleModel.setPeopleName(model.getChangeName());
							peopleModel.setBirthday(model.getChangeBirthday());
							peopleModel.setIdCard(model.getChangeIdCard());
							peopleModel.setAddress(model.getChangeAddress());
							peopleModel.setLinkAddress(model.getChangeLinkAddress());
							peopleModel.setLinkTel(model.getChangeLinkTel());
							serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(model);
							serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel);
							serviceManager.getPeopleInfoService().updatePeopleInfo(peopleModel);
						}
					}
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
}
