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
import Ynzc.YnzcAms.Model.DrivingLicenceGoto;
import Ynzc.YnzcAms.Model.DrivingLicenceGotoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicenceGotoController extends BaseController{
	
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DrivingLicenceGotoController.class);
	
	public void getDrivingLicenceGoto(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceGotoView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceGotoService().getAllDrivingLicenceGotoQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceGotoService().getAllDrivingLicenceGoto(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceGotoView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void addDrivingLicenceGoto(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			PeopleInfo peopleModel=new PeopleInfo();
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
			peopleModel.setPeopleName(request.getParameter("peopleName").trim());
			peopleModel.setSex(request.getParameter("sex").trim());
			peopleModel.setBirthday(Date.valueOf(request.getParameter("birthday").trim()));
			peopleModel.setIdCard(request.getParameter("idCard").trim());
			peopleModel.setIdStay(request.getParameter("idStay").trim());
			peopleModel.setAddress(request.getParameter("address").trim());
			peopleModel.setLinkAddress(request.getParameter("linkAddress").trim());
			peopleModel.setLinkTel(request.getParameter("linkTel").trim());
			peopleModel.setPostalcode(request.getParameter("postalcode").trim());
			peopleModel.setDegree(request.getParameter("degree").trim());
			peopleModel.setPicture(request.getParameter("photoDir").trim());
			peopleModel.setUnitId(user.getUnitid());
			peopleModel.setRegionId(unit.getRegionid());
			peopleModel.setYear(GetDate.getNowYear());
			peopleModel.setWriteUserId(user.getId());
			peopleModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			if(serviceManager.getPeopleInfoService().findPeopleInfoByIdCard(peopleModel.getIdCard())){
				if(serviceManager.getPeopleInfoService().addPeopleInfo(peopleModel)){
					BodyInfo bodyModel=new BodyInfo();
					bodyModel.setPeopleInfoId(peopleModel.getId());
					bodyModel.setHight(request.getParameter("hight").trim());
					bodyModel.setResolvingPowerFlag(Integer.valueOf(request.getParameter("resolvingPowerFlag").trim()));
					bodyModel.setRightEyePwoer(request.getParameter("rightEyePwoer").trim());
					bodyModel.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("rightEyeRectificationFlag").trim()));
					bodyModel.setLeftEyePwoer(request.getParameter("leftEyePwoer").trim());
					bodyModel.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("leftEyeRectificationFlag").trim()));
					bodyModel.setRightEarPwoer(request.getParameter("rightEarPwoerId").trim());
					bodyModel.setLeftEarPwoer(request.getParameter("leftEarPwoerId").trim());
					bodyModel.setRightHandFlag(Integer.valueOf(request.getParameter("rightHandFlag").trim()));
					bodyModel.setLeftHandFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
					bodyModel.setRightLagFlag(Integer.valueOf(request.getParameter("rightLagFlag").trim()));
					bodyModel.setLeftLagFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
					bodyModel.setBodyNeck(Integer.valueOf(request.getParameter("bodyNeck").trim()));
					bodyModel.setBodyCheckDate(Date.valueOf(request.getParameter("bodyCheckDate").trim()));
					bodyModel.setCheckResultFlag(Integer.valueOf(request.getParameter("checkResultFlag").trim()));
					bodyModel.setCheckOrganization(request.getParameter("checkOrganization").trim());
					bodyModel.setCheckDoctor(request.getParameter("checkDoctor").trim());
					bodyModel.setRegionId(unit.getRegionid()); 
					bodyModel.setUnitId(user.getUnitid());
					bodyModel.setYear(GetDate.getNowYear());
					bodyModel.setWriteUserId(user.getId());
					bodyModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
					if(serviceManager.getBodyInfoService().addBodyInfo(bodyModel)){
						peopleModel.setBodyInfoId(bodyModel.getId());
						if(serviceManager.getPeopleInfoService().updatePeopleInfo(peopleModel)){
							DrivingLicence drivingLicenceModel = new DrivingLicence();
							drivingLicenceModel.setPeopleInfoId(peopleModel.getId());
							drivingLicenceModel.setDrivingLicenceNo(peopleModel.getIdCard());
							drivingLicenceModel.setDrivingLicenceTypeId(Integer.valueOf(request.getParameter("drivingLicenceTypeId").trim()));
							drivingLicenceModel.setMark(Integer.valueOf(request.getParameter("mark").trim()));
							drivingLicenceModel.setStartDate(Date.valueOf(request.getParameter("startDate").trim()));
							drivingLicenceModel.setEndDate(Date.valueOf(request.getParameter("endDate").trim()));
							drivingLicenceModel.setDrivingLicenceFlag(0);
							drivingLicenceModel.setUnitId(user.getUnitid());
							drivingLicenceModel.setRegionId(unit.getRegionid());
							drivingLicenceModel.setWriteUserId(user.getId());
							drivingLicenceModel.setYear(GetDate.getNowYear());
							drivingLicenceModel.setWriteUserId(user.getId());
							drivingLicenceModel.setUserState(1);
							drivingLicenceModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
							if(serviceManager.getDrivingLicenceService().addDrivingLicence(drivingLicenceModel)){
								DrivingLicenceGoto model = new DrivingLicenceGoto();
								model.setArchivesNo(serviceManager.getDriverStrInfoService().createNo(peopleModel.getIdCard(), 1,unit.getRegionid()));
								model.setOperationNameType(5);
								model.setDrivingLicenceId(drivingLicenceModel.getId());
								model.setApplicationDate(Date.valueOf(request.getParameter("applicationDate").trim()));
								model.setCausation(request.getParameter("causation").trim());
								model.setRegisterTransactor(user.getUsername());
								model.setRegisterTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
								model.setAuditingGotoFlag(-1);
								model.setPigeonholeFlag(-1);
								model.setUnitId(user.getUnitid());
								model.setYear(GetDate.getNowYear());
								model.setWriteUserId(user.getId());
								model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
								model.setState(0);
								model.setRegionId(unit.getRegionid());
								model.setUnitId(user.getUnitid());
								model.setYear(GetDate.getNowYear());
								model.setWriteUserId(user.getId());
								model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
								if(serviceManager.getDrivingLicenceGotoService().addDrivingLicenceGoto(model)){
									response.getWriter().write("{success:true,reason:'添加成功'}");
								}else{
									serviceManager.getDrivingLicenceService().delDrivingLicence(drivingLicenceModel);
									serviceManager.getPeopleInfoService().delPeopleInfo(peopleModel);
									serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
									response.getWriter().write("{success:false,reason:'添加失败'}");
								}
							}else{
								serviceManager.getPeopleInfoService().delPeopleInfo(peopleModel);
								serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
								response.getWriter().write("{success:false,reason:'添加失败'}");
							}
						}else{
							serviceManager.getPeopleInfoService().delPeopleInfo(peopleModel);
							serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
							response.getWriter().write("{success:false,reason:'添加失败'}");
						}
					}else{
						serviceManager.getPeopleInfoService().delPeopleInfo(peopleModel);
						response.getWriter().write("{success:false,reason:'添加失败'}");
					}
				}else{
					response.getWriter().write("{success:false,reason:'添加人员失败'}");
				}
			}else{
				response.getWriter().write("{success:false,reason:'该人员身份证已存在'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'添加失败'}");
			ex.printStackTrace();
		}
	}
	
	public void updateDrivingLicenceGoto(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			PeopleInfo peopleModel=serviceManager.getPeopleInfoService().findPeopleInfoById(Integer.valueOf(request.getParameter("gotoPeopleInfoId").trim()));
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
			if(!peopleModel.getIdCard().equals(request.getParameter("idCard").trim())){
				peopleModel.setIdCard(request.getParameter("idCard").trim());
				if(serviceManager.getPeopleInfoService().findPeopleInfoByIdCard(peopleModel.getIdCard())){
					peopleModel.setPeopleName(request.getParameter("peopleName").trim());
					peopleModel.setSex(request.getParameter("sex").trim());
					peopleModel.setBirthday(Date.valueOf(request.getParameter("birthday").trim()));
					peopleModel.setAddress(request.getParameter("address").trim());
					peopleModel.setLinkAddress(request.getParameter("linkAddress").trim());
					peopleModel.setLinkTel(request.getParameter("linkTel").trim());
					peopleModel.setPostalcode(request.getParameter("postalcode").trim());
					peopleModel.setNativePlace(request.getParameter("nativePlace").trim());
					peopleModel.setDegree(request.getParameter("degree").trim());
					peopleModel.setPicture(request.getParameter("photoDir").trim());
					peopleModel.setRegionId(unit.getRegionid());
					peopleModel.setUnitId(user.getUnitid());
					peopleModel.setYear(GetDate.getNowYear());
					peopleModel.setWriteUserId(user.getId());
					peopleModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
					if(serviceManager.getPeopleInfoService().updatePeopleInfo(peopleModel)){
						BodyInfo bodyModel=serviceManager.getBodyInfoService().findBodyInfoById(Integer.valueOf(request.getParameter("gotoBodyInfoId").trim()));
						bodyModel.setPeopleInfoId(peopleModel.getId());
						bodyModel.setHight(request.getParameter("hight").trim());
						bodyModel.setResolvingPowerFlag(Integer.valueOf(request.getParameter("resolvingPowerFlag").trim()));
						bodyModel.setRightEyePwoer(request.getParameter("rightEyePwoer").trim());
						bodyModel.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("rightEyeRectificationFlag").trim()));
						bodyModel.setLeftEyePwoer(request.getParameter("leftEyePwoer").trim());
						bodyModel.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("leftEyeRectificationFlag").trim()));
						bodyModel.setRightEarPwoer(request.getParameter("rightEarPwoer").trim());
						bodyModel.setLeftEarPwoer(request.getParameter("leftEarPwoer").trim());
						bodyModel.setRightHandFlag(Integer.valueOf(request.getParameter("rightHandFlag").trim()));
						bodyModel.setLeftHandFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
						bodyModel.setRightLagFlag(Integer.valueOf(request.getParameter("rightLagFlag").trim()));
						bodyModel.setLeftLagFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
						bodyModel.setBodyNeck(Integer.valueOf(request.getParameter("bodyNeck").trim()));
						bodyModel.setBodyCheckDate(Date.valueOf(request.getParameter("bodyCheckDate").trim()));
						bodyModel.setCheckResultFlag(Integer.valueOf(request.getParameter("checkResultFlag").trim()));
						bodyModel.setCheckOrganization(request.getParameter("checkOrganization").trim());
						bodyModel.setCheckDoctor(request.getParameter("checkDoctor").trim());
						bodyModel.setRegionId(unit.getRegionid());
						bodyModel.setUnitId(user.getUnitid());
						bodyModel.setYear(GetDate.getNowYear());
						bodyModel.setWriteUserId(user.getId());
						bodyModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
						if(serviceManager.getBodyInfoService().updateBodyInfo(bodyModel)){
							DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(request.getParameter("id").trim()));
							model.setCausation(request.getParameter("causation").trim());
							model.setRegisterTransactor(user.getUsername());
							model.setApplicationDate(Date.valueOf(request.getParameter("applicationDate").trim()));
							model.setRegisterTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setUnitId(user.getUnitid());
							model.setYear(GetDate.getNowYear());
							model.setWriteUserId(user.getId());
							model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setRegionId(unit.getRegionid());
							model.setUnitId(user.getUnitid());
							model.setYear(GetDate.getNowYear());
							model.setWriteUserId(user.getId());
							model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
							if(serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model)){
								DrivingLicence drivingLicenceModel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
								drivingLicenceModel.setDrivingLicenceNo(request.getParameter("drivingLicenceNo").trim());
								drivingLicenceModel.setDrivingLicenceTypeId(Integer.valueOf(request.getParameter("drivingLicenceTypeId").trim()));
								drivingLicenceModel.setUnitId(user.getUnitid());
								drivingLicenceModel.setWriteUserId(user.getId());
								drivingLicenceModel.setYear(GetDate.getNowYear());
								drivingLicenceModel.setWriteUserId(user.getId());
								drivingLicenceModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
								if(serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicenceModel)){
									response.getWriter().write("{success:true,reason:'修改成功'}");
								}else{
									response.getWriter().write("{success:false,reason:'修改失败'}");
								}
							}else{
								response.getWriter().write("{success:false,reason:'修改失败'}");
							}
						}else{
							response.getWriter().write("{success:false,reason:'修改失败'}");
						}
					}
				}else{
					response.getWriter().write("{success:false,reason:'该人员身份证已存在'}");
				}
			}else{
				peopleModel.setPeopleName(request.getParameter("peopleName").trim());
				peopleModel.setSex(request.getParameter("sex").trim());
				peopleModel.setBirthday(Date.valueOf(request.getParameter("birthday").trim()));
				peopleModel.setAddress(request.getParameter("address").trim());
				peopleModel.setLinkAddress(request.getParameter("linkAddress").trim());
				peopleModel.setLinkTel(request.getParameter("linkTel").trim());
				peopleModel.setPostalcode(request.getParameter("postalcode").trim());
				peopleModel.setNativePlace(request.getParameter("nativePlace").trim());
				peopleModel.setDegree(request.getParameter("degree").trim());
				peopleModel.setPicture(request.getParameter("photoDir").trim());
				peopleModel.setRegionId(unit.getRegionid());
				peopleModel.setUnitId(user.getUnitid());
				peopleModel.setYear(GetDate.getNowYear());
				peopleModel.setWriteUserId(user.getId());
				peopleModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
				if(serviceManager.getPeopleInfoService().updatePeopleInfo(peopleModel)){
					BodyInfo bodyModel=serviceManager.getBodyInfoService().findBodyInfoById(Integer.valueOf(request.getParameter("gotoBodyInfoId").trim()));
					bodyModel.setPeopleInfoId(peopleModel.getId());
					bodyModel.setHight(request.getParameter("hight").trim());
					bodyModel.setResolvingPowerFlag(Integer.valueOf(request.getParameter("resolvingPowerFlag").trim()));
					bodyModel.setRightEyePwoer(request.getParameter("rightEyePwoer").trim());
					bodyModel.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("rightEyeRectificationFlag").trim()));
					bodyModel.setLeftEyePwoer(request.getParameter("leftEyePwoer").trim());
					bodyModel.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("leftEyeRectificationFlag").trim()));
					bodyModel.setRightEarPwoer(request.getParameter("rightEarPwoer").trim());
					bodyModel.setLeftEarPwoer(request.getParameter("leftEarPwoer").trim());
					bodyModel.setRightHandFlag(Integer.valueOf(request.getParameter("rightHandFlag").trim()));
					bodyModel.setLeftHandFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
					bodyModel.setRightLagFlag(Integer.valueOf(request.getParameter("rightLagFlag").trim()));
					bodyModel.setLeftLagFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
					bodyModel.setBodyNeck(Integer.valueOf(request.getParameter("bodyNeck").trim()));
					bodyModel.setBodyCheckDate(Date.valueOf(request.getParameter("bodyCheckDate").trim()));
					bodyModel.setCheckResultFlag(Integer.valueOf(request.getParameter("checkResultFlag").trim()));
					bodyModel.setCheckOrganization(request.getParameter("checkOrganization").trim());
					bodyModel.setCheckDoctor(request.getParameter("checkDoctor").trim());
					bodyModel.setRegionId(unit.getRegionid());
					bodyModel.setUnitId(user.getUnitid());
					bodyModel.setYear(GetDate.getNowYear());
					bodyModel.setWriteUserId(user.getId());
					bodyModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
					if(serviceManager.getBodyInfoService().updateBodyInfo(bodyModel)){
						DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(request.getParameter("id").trim()));
						model.setCausation(request.getParameter("causation").trim());
						model.setApplicationDate(Date.valueOf(request.getParameter("applicationDate").trim()));
						model.setUnitId(user.getUnitid());
						model.setYear(GetDate.getNowYear());
						model.setWriteUserId(user.getId());
						model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
						model.setRegionId(unit.getRegionid());
						model.setUnitId(user.getUnitid());
						model.setYear(GetDate.getNowYear());
						model.setWriteUserId(user.getId());
						model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
						if(serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model)){
							DrivingLicence drivingLicenceModel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
							drivingLicenceModel.setDrivingLicenceNo(request.getParameter("drivingLicenceNo").trim());
							drivingLicenceModel.setDrivingLicenceTypeId(Integer.valueOf(request.getParameter("drivingLicenceTypeId").trim()));
							drivingLicenceModel.setUnitId(user.getUnitid());
							drivingLicenceModel.setWriteUserId(user.getId());
							drivingLicenceModel.setYear(GetDate.getNowYear());
							drivingLicenceModel.setWriteUserId(user.getId());
							drivingLicenceModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
							if(serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicenceModel)){
								response.getWriter().write("{success:true,reason:'修改成功'}");
							}else{
								response.getWriter().write("{success:false,reason:'修改失败'}");
							}
						}else{
							response.getWriter().write("{success:false,reason:'修改失败'}");
						}
					}else{
						response.getWriter().write("{success:false,reason:'修改失败'}");
					}
				}
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'修改失败'}");
			ex.printStackTrace();
		}
	}
	
	public void delDrivingLicenceGoto(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String drivingLicenceGotoId = (String) request.getParameter("drivingLicenceGotoId").trim();
			String drivingLicenceId = (String) request.getParameter("drivingLicenceId").trim();
			String peopleInfoId = (String) request.getParameter("peopleInfoId").trim();
			String bodyInfoId = (String) request.getParameter("bodyInfoId").trim();
			if(serviceManager.getPeopleInfoService().delPeopleInfo(peopleInfoId) && serviceManager.getBodyInfoService().delMoreBodyInfo(bodyInfoId)){
				if (serviceManager.getDrivingLicenceGotoService().delDrivingLicenceGoto(drivingLicenceGotoId) && serviceManager.getDrivingLicenceService().delDrivingLicence(drivingLicenceId)) {
					response.getWriter().write("{success: true,reason:'删除成功'}");
				}else{
					response.getWriter().write("{success:false,reason:'删除失败'}");
				}	
			}else{
				response.getWriter().write("{success:false,reason:'删除失败'}");
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
			serviceManager.getDrivingLicenceGotoService().drivingLicenceGotoState(id,1);
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
						DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(str));
						if(model.getState()<2){
							model.setAuditingGotoFlag(1);
							model.setAuditingGotoDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setAuditingTransactor(user.getUsername());
							model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
							model.setState(2);
							DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
							drivingLicencemodel.setDrivingLicenceFlag(0);
							serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model);
							serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel);
						}
					}
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
}
