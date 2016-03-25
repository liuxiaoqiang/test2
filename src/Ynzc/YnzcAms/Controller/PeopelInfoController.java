package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Model.BodyInfo;
import Ynzc.YnzcAms.Model.DriverClassInfo;
import Ynzc.YnzcAms.Model.DriverClassTeam;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class PeopelInfoController extends BaseController{
	private final static Logger log = Logger.getLogger(PeopelInfoController.class);
	 
	public void getPeopleInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		User user=(User)request.getSession().getAttribute("user");
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<PeopleInfo> res = serviceManager.getPeopleInfoService().getAllPeopleInfo(page,condition,user.getId());
		JSONArray jsonItems = new JSONArray();
		for (PeopleInfo model : res) {
			jsonItems.add(JSONObject.fromObject(model));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());

		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void addPeopleBodyInfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
		PeopleInfo model=new PeopleInfo();
		BodyInfo bodyModel=new BodyInfo();
		DriverStrInfo strModel = new DriverStrInfo();
		DriverClassTeam classTeamModel = new DriverClassTeam();
		try{
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
			model.setPeopleName(request.getParameter("peopleName").trim());
			model.setSex(request.getParameter("sex").trim());
			model.setBirthday(Date.valueOf(request.getParameter("birthday").trim()));
			model.setIdCard(request.getParameter("idCard").trim());
			model.setIdStay(request.getParameter("idStay").trim());
			model.setAddress(request.getParameter("address").trim());
			model.setLinkAddress(request.getParameter("linkAddress").trim());
			model.setLinkTel(request.getParameter("linkTel").trim());
			model.setPostalcode(request.getParameter("postalcode").trim());
			model.setDegree(request.getParameter("degree").trim());
			model.setPicture(request.getParameter("photoDir").trim());
			model.setUnitId(user.getUnitid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setRegionId(unit.getRegionid());
			if(serviceManager.getPeopleInfoService().findPeopleInfoByIdCard(model.getIdCard())){
				if(serviceManager.getPeopleInfoService().addPeopleInfo(model)){
					bodyModel.setPeopleInfoId(model.getId());
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
					bodyModel.setUnitId(user.getUnitid());
					bodyModel.setYear(GetDate.getNowYear());
					bodyModel.setWriteUserId(user.getId());
					bodyModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
					bodyModel.setRegionId(unit.getRegionid());
					if(serviceManager.getBodyInfoService().addBodyInfo(bodyModel)){
						model.setBodyInfoId(bodyModel.getId());
						if(serviceManager.getPeopleInfoService().updatePeopleInfo(model)){
							if (request.getParameter("fosterType").trim().equals("新训")) {
								strModel.setFosterType(1);
							} else {
								strModel.setFosterType(2);
							}
							strModel.setPeopleInfoId(model.getId());
							strModel.setDrivingLicenceTypeId(request.getParameter("drivingLicenceTypeId").trim());
							strModel.setApplicationAddress(request.getParameter("applicationAddress").trim());
//							strModel.setArchivesNo(serviceManager.getDriverStrInfoService().createNo(model.getIdCard(), 1,user.getId()));
							strModel.setExaminationCode(serviceManager.getDriverStrInfoService().createNo(model.getIdCard(), 2,unit.getRegionid()));
							strModel.setApplicationFlag(-1);
							strModel.setStrState("0");
							strModel.setTheoryFlag(-1);
							strModel.setPracticeFlag(-1);
							strModel.setUnitId(user.getUnitid());
							strModel.setYear(GetDate.getNowYear());
							strModel.setWriteUserId(user.getId());
							strModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
							strModel.setRegionId(unit.getRegionid());
							if (serviceManager.getDriverStrInfoService().addDriverStrInfo(strModel)) {
								classTeamModel.setDriverClassId(Integer.parseInt(request.getParameter("driverClassInfoId").trim()));
								classTeamModel.setDriverStrInfoId(Integer.valueOf(strModel.getId()));
								classTeamModel.setTheoryPermitFlag(0);
								classTeamModel.setPracticePermitFlag(0);
								classTeamModel.setUnitId(user.getUnitid());
								classTeamModel.setWriteUserId(user.getId());
								classTeamModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
								classTeamModel.setRegionId(unit.getRegionid());
								if(serviceManager.getDriverClassTeamService().addDriverClassTeam(classTeamModel)){
									DriverClassInfo driverClassInfoModel = new DriverClassInfo();
									driverClassInfoModel = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.parseInt(request.getParameter("driverClassInfoId").trim()));
									driverClassInfoModel.setClassStrNum(driverClassInfoModel.getClassStrNum()+1);
									if(serviceManager.getDriverClassInfoService().updateDriverClassInfo(driverClassInfoModel)){
										response.getWriter().write("{success: true,reason:'添加学员信息成功'}");
									}else{
										serviceManager.getPeopleInfoService().delPeopleInfo(model);
										serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
										serviceManager.getDriverStrInfoService().delDriverStrInfo(strModel);
										serviceManager.getDriverClassTeamService().delDriverClassTeam(classTeamModel);
										response.getWriter().write("{success:false,reason:'添加学员失败'}");
									}
								}else{
									serviceManager.getPeopleInfoService().delPeopleInfo(model);
									serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
									serviceManager.getDriverStrInfoService().delDriverStrInfo(strModel);
									response.getWriter().write("{success:false,reason:'添加学员失败'}");
								}
							}else{
								serviceManager.getPeopleInfoService().delPeopleInfo(model);
								serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
								response.getWriter().write("{success:false,reason:'添加学员失败'}");
							}
						}
					}else{
						serviceManager.getPeopleInfoService().delPeopleInfo(model);
						response.getWriter().write("{success:false,reason:'添加学员失败'}");
					}
				}else{
					response.getWriter().write("{success:false,reason:'添加学员失败'}");
				}
			}else{
				response.getWriter().write("{success:false,reason:'该学员身份证已存在'}");
			}
		}catch(Exception ex){
			serviceManager.getPeopleInfoService().delPeopleInfo(model);
			serviceManager.getBodyInfoService().delBodyInfo(bodyModel);
			serviceManager.getDriverStrInfoService().delDriverStrInfo(strModel);
			serviceManager.getDriverClassTeamService().delDriverClassTeam(classTeamModel);
			ex.printStackTrace();
			response.getWriter().write("{success:false,reason:'添加学员失败'}");
		}
	}
	
	public void delPeopleInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			int driverStrInfoId = Integer.valueOf(request.getParameter("driverStrInfoId").trim());
			int classInfoId = Integer.valueOf(request.getParameter("classInfoId").trim());
			int peopleInfoId = 0;
			int bodyInfoId = 0;
			DriverStrInfo strModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(driverStrInfoId);
			peopleInfoId = strModel.getPeopleInfoId();
			PeopleInfo peopleModel = serviceManager.getPeopleInfoService().findPeopleInfoById(peopleInfoId);
			bodyInfoId = peopleModel.getBodyInfoId();
			if(serviceManager.getDriverClassTeamService().delDriverClassTeam(classInfoId, strModel.getId())){
				if(serviceManager.getDriverStrInfoService().delDriverStrInfo(strModel)){
					if(serviceManager.getPeopleInfoService().delPeopleInfo(peopleModel)){
						if(serviceManager.getBodyInfoService().delMoreBodyInfo(String.valueOf(bodyInfoId))){
							response.getWriter().write("{success:true,reason:'删除 成功'}");
						}
					}
				}
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'删除失败'}");
			ex.printStackTrace();
		}
	}
	
	public void updatePeopleCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String peopleInfoJson = (String) request.getParameter("id").trim();
		JSONObject jsonObject = JSONObject.fromObject(peopleInfoJson);
		PeopleInfo model=(PeopleInfo)JSONObject.toBean(jsonObject, PeopleInfo.class);
		String str = "";
		if(!serviceManager.getPeopleInfoService().delUpdatePeopleCheck(model.getId())){
			if("".equals(str)){
				str += model.getPeopleName();
			}else{
				str += "," + model.getPeopleName();
			}
		}
		if(!str.equals("")){
			response.getWriter().write("{success: false,reason:'以下学员信息不可变更："+str+"'}");
		}else{
			response.getWriter().write("{success: true}");
		}
	}
	
	public void updatePeopleInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		int peopleInfoId = Integer.parseInt(request.getParameter("peopleInfoId").trim());
		User user=(User)request.getSession().getAttribute("user");
		PeopleInfo model = serviceManager.getPeopleInfoService().findPeopleInfoById(peopleInfoId);
		BodyInfo bodyModel=serviceManager.getBodyInfoService().findBodyInfoById(model.getBodyInfoId());
		model.setPeopleName(request.getParameter("peopleName").trim());
		model.setSex(request.getParameter("sex").trim());
		model.setBirthday(Date.valueOf(request.getParameter("birthday").trim()));
		model.setAddress(request.getParameter("address").trim());
		model.setLinkAddress(request.getParameter("linkAddress").trim());
		model.setLinkTel(request.getParameter("linkTel").trim());
		model.setPostalcode(request.getParameter("postalcode").trim());
//		model.setNativePlace(request.getParameter("nativePlace").trim());
		model.setDegree(request.getParameter("degree").trim());
		model.setPicture(request.getParameter("photoDir").trim());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(request.getParameter("idCard").trim().equals(model.getIdCard())){
			if(serviceManager.getPeopleInfoService().updatePeopleInfo(model)){
				bodyModel.setPeopleInfoId(Integer.valueOf(request.getParameter("peopleInfoId").trim()));
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
				bodyModel.setUnitId(user.getUnitid());
				bodyModel.setYear(GetDate.getNowYear());
				bodyModel.setWriteUserId(user.getId());
				bodyModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
				if(serviceManager.getBodyInfoService().updateBodyInfo(bodyModel)){
					model.setBodyInfoId(bodyModel.getId());
					if(serviceManager.getPeopleInfoService().updatePeopleInfo(model)){
						DriverStrInfo strModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(id);
						strModel.setDrivingLicenceTypeId(request.getParameter("drivingLicenceTypeId").trim());
						strModel.setUnitId(user.getUnitid());
						strModel.setYear(GetDate.getNowYear());
						strModel.setWriteUserId(user.getId());
						strModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
						if (serviceManager.getDriverStrInfoService().addDriverStrInfo(strModel)) {
							response.getWriter().write("{success: true,reason:'更新学员信息成功'}");
						}else{
							response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
						}
					}
				}else{
					response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
				}
		}else{
			model.setIdCard(request.getParameter("idCard").trim());
				if(serviceManager.getPeopleInfoService().findPeopleInfoByIdCard(model.getIdCard())){
					if(serviceManager.getPeopleInfoService().addPeopleInfo(model)){
						bodyModel.setPeopleInfoId(Integer.valueOf(request.getParameter("peopleInfoId").trim()));
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
						bodyModel.setUnitId(user.getUnitid());
						bodyModel.setYear(GetDate.getNowYear());
						bodyModel.setWriteUserId(user.getId());
						bodyModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
						if(serviceManager.getBodyInfoService().addBodyInfo(bodyModel)){
							model.setBodyInfoId(bodyModel.getId());
							if(serviceManager.getPeopleInfoService().updatePeopleInfo(model)){
								DriverStrInfo strModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(id);
								strModel.setDrivingLicenceTypeId(request.getParameter("drivingLicenceTypeId").trim());
								strModel.setUnitId(user.getUnitid());
								strModel.setYear(GetDate.getNowYear());
								strModel.setWriteUserId(user.getId());
								strModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
								if (serviceManager.getDriverStrInfoService().addDriverStrInfo(strModel)) {
									response.getWriter().write("{success: true,reason:'更新学员信息成功'}");
								}else{
									response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
								}
							}
						}else{
							response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
						}
					}else{
						response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
					}
				}
			}
		}
	}
	
	public void getPeopleInfoById(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id").trim().toString());
		PeopleInfo res = serviceManager.getPeopleInfoService().findPeopleInfoById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findPeopleInfoById(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		DriverStrInfo model = serviceManager.getDriverStrInfoService().findDriverStrInfoById(id);
		PeopleBodyView driverInfoModel = serviceManager.getPeopleInfoService().findDriverStrInfoByPeopleId(model.getPeopleInfoId());
		List<DriverStrInfo> driverStrList = serviceManager.getDriverStrInfoService().findDriverStrInfoByPeopleInfoId(model.getPeopleInfoId());
		DriverStrInfo driverStrModel = new DriverStrInfo();
		if(driverStrList != null && driverStrList.size()>0){
			String str = "";
			for(DriverStrInfo dsi : driverStrList){
				if("".equals(str)){
					str = dsi.getDrivingLicenceTypeId();
				}else{
					str = str + "/" + dsi.getDrivingLicenceTypeId();
				}
			}
			driverStrModel.setDrivingLicenceTypeId(str);
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("model", JSONObject.fromObject(driverInfoModel));
		jsonBack.put("driverStrModel", JSONObject.fromObject(driverStrModel));
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getPeopleInfoToSelect(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		User user=(User)request.getSession().getAttribute("user");
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<PeopleInfo> res = serviceManager.getPeopleInfoService().getAllPeopleInfoToSelect(page,condition,user.getId());
		JSONArray jsonItems = new JSONArray();
		for (PeopleInfo model : res) {
			jsonItems.add(JSONObject.fromObject(model));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getDriverStrInfoToSelect(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		User user=(User)request.getSession().getAttribute("user");
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "theoryFlag = 1 and practiceFlag = 1";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<DriverStrInfoView> res = serviceManager.getPeopleInfoService().getAllDriverStrInfoToSelect(page,condition,user.getId());
		JSONArray jsonItems = new JSONArray();
		for (DriverStrInfoView model : res) {
			jsonItems.add(JSONObject.fromObject(model));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
}
