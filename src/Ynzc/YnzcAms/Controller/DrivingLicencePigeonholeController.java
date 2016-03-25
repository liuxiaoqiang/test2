 package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.GetDate;
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
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicencePigeonholeController extends BaseController{

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DrivingLicencePigeonholeController.class);
		
	public void getDrivingLicencePigeonhole(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		int type = Integer.valueOf(request.getParameter("type")); 
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
	
	public void pigeonholePass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		int type = Integer.valueOf(request.getParameter("type").trim());
		String id = request.getParameter("id").trim();
		if(type == 1){
			DrivingLicenceChange model = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 2){
			DrivingLicenceTerm model = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceTermService().updateDrivingLicenceTerm(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 3){
			DrivingLicenceDefile model = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileByid(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceDefileService().updateDrivingLicenceDefile(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 4){
			DrivingLicenceRepair model = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceRepairService().updateDrivingLicenceRepair(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 5){
			DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 6){
			DrivingLicenceShiftTo model = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceShiftToService().updateDrivingLicenceShiftTo(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 7){
			DrivingLicenceLogout model = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(1);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(5);
			if(serviceManager.getDrivingLicenceLogoutService().updateDrivingLicenceLogout(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}
	}
	
	public void pigeonholeUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		int type = Integer.valueOf(request.getParameter("type").trim());
		String id = request.getParameter("id").trim();
		if(type == 1){
			DrivingLicenceChange model = serviceManager.getDrivingLicenceChangeService().findDrivingLicenceChangeById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceChangeService().updateDrivingLicenceChange(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 2){
			DrivingLicenceTerm model = serviceManager.getDrivingLicenceTermService().findDrivingLicenceTermById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceTermService().updateDrivingLicenceTerm(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 3){
			DrivingLicenceDefile model = serviceManager.getDrivingLicenceDefileService().findDrivingLicenceDefileByid(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceDefileService().updateDrivingLicenceDefile(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 4){
			DrivingLicenceRepair model = serviceManager.getDrivingLicenceRepairService().findDrivingLicenceRepairById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceRepairService().updateDrivingLicenceRepair(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 5){
			DrivingLicenceGoto model = serviceManager.getDrivingLicenceGotoService().findDrivingLicenceGotoById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceGotoService().updateDrivingLicenceGoto(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 6){
			DrivingLicenceShiftTo model = serviceManager.getDrivingLicenceShiftToService().findDrivingLicenceShiftToById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceShiftToService().updateDrivingLicenceShiftTo(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}else if(type == 7){
			DrivingLicenceLogout model = serviceManager.getDrivingLicenceLogoutService().findDrivingLicenceLogoutById(Integer.valueOf(id));
			model.setPigeonholeTransactor(user.getUsername());
			model.setPigeonholeTransactorDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setPigeonholeFlag(0);
			model.setPigeonholeDate(GetDate.stringToDate(GetDate.getStringDate()));
			model.setState(6);
			if(serviceManager.getDrivingLicenceLogoutService().updateDrivingLicenceLogout(model)){
				response.getWriter().write("{success:true,reason:'操作成功'}");
			}else{
				response.getWriter().write("{success:true,reason:'归档失败'}");
			}
		}
	}
}
