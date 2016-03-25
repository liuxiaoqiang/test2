package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.GetDate;
import Ynzc.Util.StringUtil;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceChange;
import Ynzc.YnzcAms.Model.DrivingLicenceChangeView;
import Ynzc.YnzcAms.Model.DrivingLicenceDefile;
import Ynzc.YnzcAms.Model.DrivingLicenceDefileView;
import Ynzc.YnzcAms.Model.DrivingLicenceGoto;
import Ynzc.YnzcAms.Model.DrivingLicenceGotoView;
import Ynzc.YnzcAms.Model.DrivingLicenceLogout;
import Ynzc.YnzcAms.Model.DrivingLicenceRepair;
import Ynzc.YnzcAms.Model.DrivingLicenceRepairView;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftTo;
import Ynzc.YnzcAms.Model.DrivingLicenceTerm;
import Ynzc.YnzcAms.Model.DrivingLicenceTermView;
import Ynzc.YnzcAms.Model.DrivingLicenceView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicenceController extends BaseController{

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DrivingLicenceController.class);
	
	public void getDrivingLicencePutOut(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceService().getAllDrivingLicenceQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceService().getAllDrivingLicence(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getDrivingLicenceOperationPutOut(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		int type = 1;
		if(request.getParameter("type") != null && !"".equals(request.getParameter("type").trim())){
			type = Integer.valueOf(request.getParameter("type"));
		}
		JSONArray jsonItems = new JSONArray();
		String condition = "putOutTransactor is null";
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			if(type == 1){
				List<DrivingLicenceChangeView> res = serviceManager.getDrivingLicenceChangeService().getAllDrivingLicenceChangeQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceChangeView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 2){
				List<DrivingLicenceTermView> res = serviceManager.getDrivingLicenceTermService().getAllDrivingLicenceTermQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceTermView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 3){
				List<DrivingLicenceDefileView> res = serviceManager.getDrivingLicenceDefileService().getAllDrivingLicenceDefileQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceDefileView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 4){
				List<DrivingLicenceRepairView> res = serviceManager.getDrivingLicenceRepairService().getAllDrivingLicenceRepairQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceRepairView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 5){
				List<DrivingLicenceGotoView> res = serviceManager.getDrivingLicenceGotoService().getAllDrivingLicenceGotoQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceGotoView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}
		}else{
			if(type == 1){
				List<DrivingLicenceChangeView> res = serviceManager.getDrivingLicenceChangeService().getAllDrivingLicenceChange(page,condition,unit.getRegionid());
				for (DrivingLicenceChangeView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 2){
				List<DrivingLicenceTermView> res = serviceManager.getDrivingLicenceTermService().getAllDrivingLicenceTerm(page,condition,unit.getRegionid());
				for (DrivingLicenceTermView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 3){
				List<DrivingLicenceDefileView> res = serviceManager.getDrivingLicenceDefileService().getAllDrivingLicenceDefile(page,condition,unit.getRegionid());
				for (DrivingLicenceDefileView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 4){
				List<DrivingLicenceRepairView> res = serviceManager.getDrivingLicenceRepairService().getAllDrivingLicenceRepair(page,condition,unit.getRegionid());
				for (DrivingLicenceRepairView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 5){
				List<DrivingLicenceGotoView> res = serviceManager.getDrivingLicenceGotoService().getAllDrivingLicenceGoto(page,condition,unit.getRegionid());
				for (DrivingLicenceGotoView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getDrivingLicence(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		String condition = "drivingLicenceFlag = 1 and userState < 2";
		List<DrivingLicenceView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition += " and "+ new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceService().getAllDrivingLicenceQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceService().getAllDrivingLicence(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void drivingLicencePutOut(HttpServletRequest request, HttpServletResponse response)throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
			String id = request.getParameter("id").trim();
			int operationNameType = Integer.valueOf(request.getParameter("operationNameType").trim());
			int operationId = 0;
			if(StringUtil.isNotNullEmptyStr(request.getParameter("operationId"))){
				operationId = Integer.valueOf(request.getParameter("operationId").trim());
			}
			DrivingLicence model = serviceManager.getDrivingLicenceService().findDrivingLicenceById(Integer.valueOf(id));
			DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfo(model.getPeopleInfoId(), model.getDrivingLicenceTypeId());
			if(driverStrModel != null){
				driverStrModel.setDrivingLicenceFirst(DateTimeUtil.getNow());
			}
			model.setStartDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPutOutDate(DateTimeUtil.getNow());
			model.setEndDate(DateTimeUtil.addYear(6));
			model.setDrivingLicenceFlag(1);
			model.setRegionId(unit.getRegionid());
			if(operationNameType == 1){
				DrivingLicenceChange operationModel = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(operationModel);
			}else if(operationNameType == 2){
				DrivingLicenceTerm operationModel = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermById(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceTermService().updateDrivingLicenceTerm(operationModel);
			}else if(operationNameType == 3){
				DrivingLicenceDefile operationModel = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileByid(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceDefileService().updateDrivingLicenceDefile(operationModel);
			}else if(operationNameType == 4){
				DrivingLicenceRepair operationModel = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairById(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceRepairService().updateDrivingLicenceRepair(operationModel);
			}else if(operationNameType == 5){
				DrivingLicenceGoto operationModel = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(operationModel);
			}else if(operationNameType == 6){
				DrivingLicenceLogout operationModel = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutById(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceLogoutService().updateDrivingLicenceLogout(operationModel);
			}else if(operationNameType == 7){
				DrivingLicenceShiftTo operationModel = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToById(operationId);
				operationModel.setPutOutTransactor(user.getUsername());
				operationModel.setPutOutTransactorDate(DateTimeUtil.getNow());
				serviceManager.getDrivingLicenceShiftToService().updateDrivingLicenceShiftTo(operationModel);
			}
			if (serviceManager.getDrivingLicenceService().updateDrivingLicence(model)){
				if(driverStrModel != null){
					serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStrModel);
					response.getWriter().write("{success:true,reason:'打印成功'}");
				}else{
					response.getWriter().write("{success:true,reason:'打印成功'}");
				}
			} else {
				response.getWriter().write("{success:false,reason:'打印失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'打印失败'}");
			ex.printStackTrace();
		}
	}
	
	public void findDrivingLicenceById(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("drivingLicenceId").trim());
		DrivingLicenceView model = serviceManager.getDrivingLicenceService().findDrivingLicenceViewById(id).get(0);
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("model", JSONObject.fromObject(model));
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void drivingLicenceOperation(HttpServletRequest request, HttpServletResponse response)throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String id = request.getParameter("drivingLicenceId").trim();
			if (serviceManager.getDrivingLicenceService().checkDrivingLicenceOperation(id)){
				response.getWriter().write("{success:true,reason:'该驾驶员正在办理业务，目前不能办理其它业务'}");
			} else {
				response.getWriter().write("{success:false}");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void checkDrivingLicenceOperation(HttpServletRequest request, HttpServletResponse response)throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			int peopleInfoId = Integer.valueOf(request.getParameter("peopleInfoId").trim());
			int drivingLicenceTypeId = Integer.valueOf(request.getParameter("drivingLicenceTypeId").trim());
			DriverStrInfo model = serviceManager.getDriverStrInfoService().findDriverStrInfo(peopleInfoId, drivingLicenceTypeId);
			if (!StringUtil.isNotNullEmptyStr(model.getArchivesNo())){
				response.getWriter().write("{success:true,reason:'该学员还未建档，不能打印驾驶证'}");
			}else{
				response.getWriter().write("{success:false}");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
