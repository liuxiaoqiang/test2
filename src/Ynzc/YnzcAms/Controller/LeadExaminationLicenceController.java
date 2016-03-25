 package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceChange;
import Ynzc.YnzcAms.Model.DrivingLicenceChangeView;
import Ynzc.YnzcAms.Model.DrivingLicenceDefile;
import Ynzc.YnzcAms.Model.DrivingLicenceDefileView;
import Ynzc.YnzcAms.Model.DrivingLicenceGoto;
import Ynzc.YnzcAms.Model.DrivingLicenceGotoView;
import Ynzc.YnzcAms.Model.DrivingLicenceLogout;
import Ynzc.YnzcAms.Model.DrivingLicenceLogoutView;
import Ynzc.YnzcAms.Model.DrivingLicenceRepair;
import Ynzc.YnzcAms.Model.DrivingLicenceRepairView;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftTo;
import Ynzc.YnzcAms.Model.DrivingLicenceShiftToView;
import Ynzc.YnzcAms.Model.DrivingLicenceTerm;
import Ynzc.YnzcAms.Model.DrivingLicenceTermView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class LeadExaminationLicenceController extends BaseController{
	private final static Logger log = Logger.getLogger(LeadExaminationLicenceController.class);
	
	public void getDrivingLicenceOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		int type = Integer.valueOf(request.getParameter("type").trim());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++"+type);
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
		JSONArray jsonItems = new JSONArray();
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
			}else if(type == 6){
				List<DrivingLicenceShiftToView> res = serviceManager.getDrivingLicenceShiftToService().getAllDrivingLicenceShiftToQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceShiftToView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 7){
				List<DrivingLicenceLogoutView> res = serviceManager.getDrivingLicenceLogoutService().getAllDrivingLicenceLogoutQuery(page,condition,unit.getRegionid());
				for (DrivingLicenceLogoutView u : res) {
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
			}else if(type == 6){
				List<DrivingLicenceShiftToView> res = serviceManager.getDrivingLicenceShiftToService().getAllDrivingLicenceShiftTo(page,condition,unit.getRegionid());
				for (DrivingLicenceShiftToView u : res) {
					jsonItems.add(JSONObject.fromObject(u));
				}
			}else if(type == 7){
				List<DrivingLicenceLogoutView> res = serviceManager.getDrivingLicenceLogoutService().getAllDrivingLicenceLogout(page,condition,unit.getRegionid());
				for (DrivingLicenceLogoutView u : res) {
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
	
	public void findDrivingLicenceOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int type = Integer.valueOf(request.getParameter("type")); 
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		if(type == 1){
			List<DrivingLicenceChangeView> res = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeViewById(id);
			for (DrivingLicenceChangeView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}else if(type == 2){
			List<DrivingLicenceTermView> res = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermViewById(id);
			for (DrivingLicenceTermView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}else if(type == 3){
			List<DrivingLicenceDefileView> res = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileViewById(id);
			for (DrivingLicenceDefileView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}else if(type == 4){
			List<DrivingLicenceRepairView> res = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairViewById(id);
			for (DrivingLicenceRepairView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}else if(type == 5){
			List<DrivingLicenceGotoView> res = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoViewById(id);
			for (DrivingLicenceGotoView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}else if(type == 6){
			List<DrivingLicenceShiftToView> res = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToViewById(id);
			for (DrivingLicenceShiftToView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}else if(type == 7){
			List<DrivingLicenceLogoutView> res = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutViewById(id);
			for (DrivingLicenceLogoutView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void getDrivingLicenceChangeOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
	
	public void getDrivingLicenceTermOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
	
	public void getDrivingLicenceDefileOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
	
	public void getDrivingLicenceRepairOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceRepairView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceRepairService().getAllDrivingLicenceRepairQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceRepairService().getAllDrivingLicenceRepair(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceRepairView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getDrivingLicenceGotoOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
	
	public void getDrivingLicenceShiftToOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceShiftToView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceShiftToService().getAllDrivingLicenceShiftToQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceShiftToService().getAllDrivingLicenceShiftTo(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceShiftToView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getDrivingLicenceLogoutOperation(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceLogoutView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDrivingLicenceLogoutService().getAllDrivingLicenceLogoutQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDrivingLicenceLogoutService().getAllDrivingLicenceLogout(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceLogoutView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceChangeOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceChangeView> res = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeViewById(id);
		for (DrivingLicenceChangeView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceTermOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceTermView> res = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermViewById(id);
		for (DrivingLicenceTermView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceDefileOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceDefileView> res = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileViewById(id);
		for (DrivingLicenceDefileView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceRepairOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceRepairView> res = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairViewById(id);
		for (DrivingLicenceRepairView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceGotoOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceGotoView> res = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoViewById(id);
		for (DrivingLicenceGotoView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceShiftToOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceShiftToView> res = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToViewById(id);
		for (DrivingLicenceShiftToView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findDrivingLicenceLogoutOperationInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id")); 
		JSONArray jsonItems = new JSONArray();
		List<DrivingLicenceLogoutView> res = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutViewById(id);
		for (DrivingLicenceLogoutView u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void examinationLicenceChangePass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceChange model = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(Integer.valueOf(id));
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
		if(serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel) && serviceManager.getPeopleInfoService().updatePeopleInfo(peopleModel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceTermPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceTerm model = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermById(Integer.valueOf(id));
		model.setAuditingTermFlag(1);
		model.setAuditingTermDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(2);
		DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
		drivingLicencemodel.setDrivingLicenceFlag(0);
		if(serviceManager.getDrivingLicenceTermService().updateDrivingLicenceTerm(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceDefilePass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceDefile model = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileByid(Integer.valueOf(id));
		model.setAuditingDefileFlag(1);
		model.setAuditingDefileDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(2);
		DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
		drivingLicencemodel.setDrivingLicenceFlag(0);
		if(serviceManager.getDrivingLicenceDefileService().updateDrivingLicenceDefile(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceRepairPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceRepair model = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairById(Integer.valueOf(id));
		model.setAuditingRepairFlag(1);
		model.setAuditingRepairDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(2);
		DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
		drivingLicencemodel.setDrivingLicenceFlag(0);
		if(serviceManager.getDrivingLicenceRepairService().updateDrivingLicenceRepair(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceGotoPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(id));
		model.setAuditingGotoFlag(1);
		model.setAuditingGotoDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(2);
		DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
		drivingLicencemodel.setDrivingLicenceFlag(0);
		if(serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceShiftToPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceShiftTo model = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToById(Integer.valueOf(id));
		model.setAuditingShiftToFlag(1);
		model.setAuditingShiftToDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(2);
		DrivingLicence drivingLicencemodel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
		drivingLicencemodel.setUserState(3);
		if(serviceManager.getDrivingLicenceShiftToService().updateDrivingLicenceShiftTo(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicencemodel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceLogoutPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceLogout model = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutById(Integer.valueOf(id));
		model.setAuditingLogoutFlag(1);
		model.setAuditingLogoutDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(2);
		DrivingLicence drivingLicenceModel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
		drivingLicenceModel.setUserState(4);
		if(serviceManager.getDrivingLicenceLogoutService().updateDrivingLicenceLogout(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(drivingLicenceModel)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceChangeUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceChange model = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(Integer.valueOf(id));
		model.setAuditingChangeFlag(0);
		model.setAuditingChangeDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceTermUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceTerm model = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermById(Integer.valueOf(id));
		model.setAuditingTermFlag(0);
		model.setAuditingTermDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceTermService().updateDrivingLicenceTerm(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceDefileUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceDefile model = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileByid(Integer.valueOf(id));
		model.setAuditingDefileFlag(0);
		model.setAuditingDefileDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceDefileService().updateDrivingLicenceDefile(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceRepairUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceRepair model = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairById(Integer.valueOf(id));
		model.setAuditingRepairFlag(0);
		model.setAuditingRepairDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceRepairService().updateDrivingLicenceRepair(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceGotoUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(id));
		model.setAuditingGotoFlag(0);
		model.setAuditingGotoDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceShiftToUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceShiftTo model = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToById(Integer.valueOf(id));
		model.setAuditingShiftToFlag(0);
		model.setAuditingShiftToDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceShiftToService().updateDrivingLicenceShiftTo(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
	
	public void examinationLicenceLogoutUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		DrivingLicenceLogout model = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutById(Integer.valueOf(id));
		model.setAuditingLogoutFlag(0);
		model.setAuditingLogoutDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setAuditingTransactor(user.getUsername());
		model.setAuditingTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
		model.setState(3);
		if(serviceManager.getDrivingLicenceLogoutService().updateDrivingLicenceLogout(model)){
			response.getWriter().write("{success:true,reason:'操作成功'}");
		}else{
			response.getWriter().write("{success:true,reason:'审核失败'}");
		}
	}
}
