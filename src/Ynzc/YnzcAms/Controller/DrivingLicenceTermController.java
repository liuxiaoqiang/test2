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
import Ynzc.YnzcAms.Model.BodyInfo;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceTerm;
import Ynzc.YnzcAms.Model.DrivingLicenceTermView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicenceTermController extends BaseController{
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DrivingLicenceTermController.class);
	
	public void getDrivingLicenceTerm(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceTermView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceTermService().getAllDrivingLicenceTermQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceTermService().getAllDrivingLicenceTerm(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceTermView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void addDrivingLicenceTerm(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			BodyInfo model=new BodyInfo();
			DrivingLicenceTerm termModel = new DrivingLicenceTerm();
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
			termModel.setOperationNameType(2);
			termModel.setDrivingLicenceId(Integer.parseInt(request.getParameter("drivingLicenceId").trim()));
			termModel.setUseYear("6");
			termModel.setAuditingTermFlag(-1);
			termModel.setPigeonholeFlag(-1);
			termModel.setState(0);
			termModel.setRegisterTransactor(user.getUsername());
			termModel.setRegisterTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			termModel.setRegionId(unit.getRegionid());
			termModel.setUnitId(user.getUnitid());
			termModel.setYear(GetDate.getNowYear());
			termModel.setWriteUserId(user.getId());
			termModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPeopleInfoId(Integer.valueOf(serviceManager.getDrivingLicenceService().findDrivingLicenceById(termModel.getDrivingLicenceId()).getPeopleInfoId()));
			model.setHight(request.getParameter("changeHight").trim());
			model.setResolvingPowerFlag(Integer.valueOf(request.getParameter("changeResolvingPowerFlag").trim()));
			model.setRightEyePwoer(request.getParameter("changeRightEyePwoer").trim());
			model.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("changeRightEyeRectificationFlag").trim()));
			model.setLeftEyePwoer(request.getParameter("changeLeftEyePwoer").trim());
			model.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("changeLeftEyeRectificationFlag").trim()));
			model.setRightEarPwoer(request.getParameter("changeRightEarPwoerId").trim());
			model.setLeftEarPwoer(request.getParameter("changeLeftEarPwoerId").trim());
			model.setRightHandFlag(Integer.valueOf(request.getParameter("changeRightHandFlag").trim()));
			model.setLeftHandFlag(Integer.valueOf(request.getParameter("changeLeftHandFlag").trim()));
			model.setRightLagFlag(Integer.valueOf(request.getParameter("changeRightLagFlag").trim()));
			model.setLeftLagFlag(Integer.valueOf(request.getParameter("changeLeftLagFlag").trim()));
			model.setBodyNeck(Integer.valueOf(request.getParameter("changeBodyNeck").trim()));
			model.setBodyCheckDate(Date.valueOf(request.getParameter("changeBodyCheckDate").trim()));
			model.setCheckResultFlag(Integer.valueOf(request.getParameter("changeCheckResultFlag").trim()));
			model.setCheckOrganization(request.getParameter("changeCheckOrganization").trim());
			model.setCheckDoctor(request.getParameter("changeCheckDoctor").trim());
			model.setRegionId(unit.getRegionid());
			model.setUnitId(user.getUnitid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			if(serviceManager.getDrivingLicenceTermService().addDrivingLicenceTerm(termModel) && serviceManager.getBodyInfoService().addBodyInfo(model)){
				PeopleInfo peopleInfoModel = serviceManager.getPeopleInfoService().findPeopleInfoById(model.getPeopleInfoId());
				peopleInfoModel.setBodyInfoId(model.getId());
				if(serviceManager.getPeopleInfoService().updatePeopleInfo(peopleInfoModel)){
					response.getWriter().write("{success: true,reason:'添加成功'}");
				}
			}else{
				response.getWriter().write("{success:false,reason:'添加失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'添加失败'}");
			ex.printStackTrace();
		}
	}
	
	public void updateDrivingLicenceTerm(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			BodyInfo model = serviceManager.getBodyInfoService().findBodyInfoById(Integer.valueOf(request.getParameter("bodyInfoId").trim()));
			User user=(User)request.getSession().getAttribute("user");
			model.setHight(request.getParameter("changeHight").trim());
			model.setResolvingPowerFlag(Integer.valueOf(request.getParameter("changeResolvingPowerFlag").trim()));
			model.setRightEyePwoer(request.getParameter("changeRightEyePwoer").trim());
			model.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("changeRightEyeRectificationFlag").trim()));
			model.setLeftEyePwoer(request.getParameter("changeLeftEyePwoer").trim());
			model.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("changeLeftEyeRectificationFlag").trim()));
			model.setRightEarPwoer(request.getParameter("changeRightEarPwoer").trim());
			model.setLeftEarPwoer(request.getParameter("changeLeftEarPwoer").trim());
			model.setRightHandFlag(Integer.valueOf(request.getParameter("changeRightHandFlag").trim()));
			model.setLeftHandFlag(Integer.valueOf(request.getParameter("changeLeftHandFlag").trim()));
			model.setRightLagFlag(Integer.valueOf(request.getParameter("changeRightLagFlag").trim()));
			model.setLeftLagFlag(Integer.valueOf(request.getParameter("changeLeftLagFlag").trim()));
			model.setBodyNeck(Integer.valueOf(request.getParameter("changeBodyNeck").trim()));
			model.setBodyCheckDate(Date.valueOf(request.getParameter("changeBodyCheckDate").trim()));
			model.setCheckResultFlag(Integer.valueOf(request.getParameter("changeCheckResultFlag").trim()));
			model.setCheckOrganization(request.getParameter("changeCheckOrganization").trim());
			model.setCheckDoctor(request.getParameter("changeCheckDoctor").trim());
			model.setUnitId(user.getUnitid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			if(serviceManager.getBodyInfoService().updateBodyInfo(model)){
				response.getWriter().write("{success: true,reason:'修改成功'}");
			}else{
				response.getWriter().write("{success:false,reason:'修改失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'修改失败'}");
			ex.printStackTrace();
		}
	}
	
	public void delDrivingLicenceTerm(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String ids = (String) request.getParameter("id").trim();
			boolean isDelete = serviceManager.getDrivingLicenceTermService().delDrivingLicenceTerm(ids);
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
	
	public void delDrivingLicenceShiftTo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String ids = (String) request.getParameter("id").trim();
			boolean isDelete = serviceManager.getDrivingLicenceShiftToService().delDrivingLicenceShiftTo(ids);
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
			serviceManager.getDrivingLicenceTermService().drivingLicenceTermState(id,1);
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
					for(String str : ids){
						DrivingLicenceTerm model = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermById(Integer.valueOf(str));
						if(model.getState()<2){
							model.setAuditingTermFlag(1);
							model.setAuditingTermDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setAuditingTransactor(user.getUsername());
							model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setState(2);
							DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
							drivingLicencemodel.setDrivingLicenceFlag(0);
							serviceManager.getDrivingLicenceTermService().updateDrivingLicenceTerm(model);
							serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel);
						}
					}
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
}
