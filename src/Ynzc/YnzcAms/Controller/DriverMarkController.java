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
import Ynzc.YnzcAms.Model.DriverMark;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.DrivingLicenceView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DriverMarkController extends BaseController{
	
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DriverMarkController.class);
	
	public void getDriverMark(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		String condition = "drivingLicenceId = " + Integer.valueOf(request.getParameter("DrivingLicenceId").trim());
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<DriverMark> res = serviceManager.getDriverMarkService().getAllDriverMark(page,condition,unit.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (DriverMark u : res) {
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
		String condition = "";
		List<DrivingLicenceView> res = null;
		if (fields != null && query != null) {
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
	
	public void addDriverMark(HttpServletRequest request, HttpServletResponse response)throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
			DriverMark model = new DriverMark();
			model.setDrivingLicenceId(Integer.valueOf(request.getParameter("drivingLicenceId").trim()));
			model.setPenaltyNo(request.getParameter("penaltyNo").trim());
			model.setPeccancyDate(Date.valueOf(request.getParameter("peccancyDate").trim()));
			model.setMark(Integer.valueOf(request.getParameter("mark").trim()));
			model.setTipstaff(request.getParameter("tipstaff").trim());
			model.setTransactor(request.getParameter("transactor").trim());
			model.setTransactorDate(Date.valueOf(request.getParameter("transactorDate").trim()));
			model.setUnitId(user.getUnitid());
			model.setRegionId(unit.getRegionid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			DrivingLicence dlModel = serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getDrivingLicenceId());
			dlModel.setMark(dlModel.getMark()-model.getMark());
			if(dlModel.getMark()<0){
				dlModel.setUserState(0);
			}
			if (serviceManager.getDriverMarkService().addDriverMark(model) && serviceManager.getDrivingLicenceService().updateDrivingLicence(dlModel)) {
				response.getWriter().write("{success:true,reason:'添加成功'}");
			} else {
				response.getWriter().write("{success:false,reason:'添加失败'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'添加失败'}");
			ex.printStackTrace();
		}
	}
}
