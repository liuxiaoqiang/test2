package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Ynzc.YnzcAms.Model.DrivertraingTractorinfoView;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;
import Ynzc.YnzcAms.Model.DrivertrainingView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivertrainingInfoController extends  BaseController {

	public void getDrivertrainingInfoAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		if (request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if (request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		User us=(User)request.getSession().getAttribute("user");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<DrivertrainingView> res = serviceManager.getDrivertrainingService().getDrivertrainingInfoAll(page, condition,us.getId());
		JSONArray jsonItems = new JSONArray();
		for (DrivertrainingView u : res) {
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
	@SuppressWarnings("unused")
	public void getDrivertraingTractorinfoView(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String carCode=request.getParameter("carCode").trim();
		int unitid=Integer.parseInt(request.getParameter("unitid").trim());
		User us=(User)request.getSession().getAttribute("user");
		DrivertraingTractorinfoView res = serviceManager.getDrivertrainingService().getDrivertraingTractorinfoView(carCode, us.getId());
		JSONArray jsonItems = new JSONArray();
		
		jsonItems.add(JSONObject.fromObject(res));
		
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("drivertrainingInfoData", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	public void getDrivertrainingInfoViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		if (request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if (request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		User us=(User)request.getSession().getAttribute("user");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<DrivertrainingInfoView> res = serviceManager.getDrivertrainingService().getDrivertrainingInfoViewAll(page, condition,us.getId());
		JSONArray jsonItems = new JSONArray();
		for (DrivertrainingInfoView u : res) {
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
	public void addDrivertrainingInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		DrivertrainingInfo temp=serviceManager.getDrivertrainingService().findDrivertrainingInfoViewByCarNum(request.getParameter("CardCode").trim(), us.getId());
		if(temp!=null){
			response.getWriter().write("{success:false,reason:'[<font color=red>申请人信息</font>][<font color=red>教练车号码</font>]已经在使用中,请重新填写。'}");
			return;
		}
		DrivertrainingInfo drivertrainingInfo=new DrivertrainingInfo();
		drivertrainingInfo.setAgentDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("agentDate").trim()));
		drivertrainingInfo.setAgentMan(request.getParameter("agentMan").trim());
		drivertrainingInfo.setApplicationTime(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ApplicationTime").trim()));
		drivertrainingInfo.setAuditDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("auditDate").trim()));
		drivertrainingInfo.setAuditOption(request.getParameter("AuditOption").trim());
		drivertrainingInfo.setCardCode(request.getParameter("CardCode").trim());
		drivertrainingInfo.setLetterCode(request.getParameter("LetterCode").trim());
		drivertrainingInfo.setOwner(request.getParameter("Owner").trim());
		drivertrainingInfo.setPostCode(request.getParameter("postCode").trim());
		drivertrainingInfo.setTelephone(request.getParameter("telephone").trim());
		drivertrainingInfo.setTractorinfoId(Integer.parseInt(request.getParameter("tractorinfoId").trim()));
		drivertrainingInfo.setTractorinfoIdCode(request.getParameter("tractorinfoIdCode").trim());
		drivertrainingInfo.setUnitAddress(request.getParameter("UnitAddress").trim());
		drivertrainingInfo.setUnitCode(request.getParameter("unitCode").trim());
		drivertrainingInfo.setUnitName(request.getParameter("unitname").trim());
		drivertrainingInfo.setCarType(Integer.parseInt(request.getParameter("carType").trim()));
		drivertrainingInfo.setUnitid(Integer.parseInt(request.getParameter("unitid")));
		if(serviceManager.getDrivertrainingService().addDrivertrainingInfo(drivertrainingInfo)){
			response.getWriter().write("{success:true,reason:'教练车注册登记成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'教练车注册登记失败'}");
		}
	}
	public void updateDrivertrainingInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		DrivertrainingInfo drivertrainingInfo=new DrivertrainingInfo();
		drivertrainingInfo.setId(Integer.parseInt(request.getParameter("id")));
		drivertrainingInfo.setAgentDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("agentDate").trim()));
		drivertrainingInfo.setAgentMan(request.getParameter("agentMan").trim());
		drivertrainingInfo.setApplicationTime(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ApplicationTime").trim()));
		drivertrainingInfo.setAuditDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("auditDate").trim()));
		drivertrainingInfo.setAuditOption(request.getParameter("AuditOption").trim());
		drivertrainingInfo.setCardCode(request.getParameter("CardCode").trim());
		drivertrainingInfo.setLetterCode(request.getParameter("LetterCode").trim());
		drivertrainingInfo.setOwner(request.getParameter("Owner").trim());
		drivertrainingInfo.setPostCode(request.getParameter("postCode").trim());
		drivertrainingInfo.setTelephone(request.getParameter("telephone").trim());
		drivertrainingInfo.setTractorinfoId(Integer.parseInt(request.getParameter("tractorinfoId").trim()));
		drivertrainingInfo.setTractorinfoIdCode(request.getParameter("tractorinfoIdCode").trim());
		drivertrainingInfo.setUnitAddress(request.getParameter("UnitAddress").trim());
		drivertrainingInfo.setUnitCode(request.getParameter("unitCode").trim());
		drivertrainingInfo.setUnitName(request.getParameter("unitname").trim());
		drivertrainingInfo.setCarType(Integer.parseInt(request.getParameter("carType").trim()));
		drivertrainingInfo.setUnitid(Integer.parseInt(request.getParameter("unitid")));
		if(serviceManager.getDrivertrainingService().updateDrivertrainingInfo(drivertrainingInfo)){
			response.getWriter().write("{success:true,reason:'教练车注册登记信息更改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'教练车注册登记信息更改失败'}");
		}
		
	}
	@SuppressWarnings("rawtypes")
	public void deleteDrivertrainingInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String userJson = (String) request.getParameter("drivertraininglist").trim();
		JSONArray jsonArray = JSONArray.fromObject(userJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			DrivertrainingInfo drivertrainingInfo=(DrivertrainingInfo)JSONObject.toBean(jsonObject, DrivertrainingInfo.class);
			boolean isDelete = serviceManager.getDrivertrainingService().deleteDrivertrainingInfo(drivertrainingInfo);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'教练车注册登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	public void findDrivertraingTractorinfoViewByid(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=request.getParameter("id").trim();
		String cartype=request.getParameter("carType").trim();
		int id=Integer.parseInt(ids);
		if(Integer.parseInt(cartype)==1){
			DrivertraingTractorinfoView res = serviceManager.getDrivertrainingService().FindDrivertraingTractorinfoViewById(id);
			JSONArray jsonItems = new JSONArray();
			if (res != null) {
				jsonItems.add(JSONObject.fromObject(res));
				JSONObject jsonBack = new JSONObject();
				jsonBack.put("drivertrainingInfoData", jsonItems);
				System.out.println(jsonBack);
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(jsonBack);
			}
		}else{
			UniteharvesterView res=serviceManager.getUniteharvesterService().findUniteharvesterViewById(id);
			JSONArray jsonItems = new JSONArray();
			if (res != null) {
				jsonItems.add(JSONObject.fromObject(res));
				JSONObject jsonBack = new JSONObject();
				jsonBack.put("drivertrainingInfoData", jsonItems);
				System.out.println(jsonBack);
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(jsonBack);
			}
		}
	}
}