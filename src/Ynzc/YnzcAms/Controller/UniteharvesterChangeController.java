package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterChange;
import Ynzc.YnzcAms.Model.UniteharvesterChangeView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UniteharvesterChangeController extends  BaseController{
	public void getUniteharvesterChangeViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<UniteharvesterChangeView> res = serviceManager.getUniteharvesterChangeService().getUniteharvesterChangeAll(page, condition, us.getId());
		JSONArray jsonItems = new JSONArray();
		for (UniteharvesterChangeView u : res) {
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
	public void addUniteharvesterChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterChange uniteharvesterChange=new UniteharvesterChange();
		uniteharvesterChange.setChangeApplicationtype(Integer.parseInt(request.getParameter("changeApplicationtype")));
		uniteharvesterChange.setChangeNote(request.getParameter("changeNote"));
		uniteharvesterChange.setChangeRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("changeRegistdate").trim()));
		uniteharvesterChange.setChangeRegisterman(request.getParameter("changeRegisterman"));
		uniteharvesterChange.setChangeType(request.getParameter("changeType"));
		uniteharvesterChange.setChangeUnit(request.getParameter("changeUnit"));
		int ids=Integer.parseInt(request.getSession().getAttribute("uniteharvesterid").toString());
		uniteharvesterChange.setHarvesterId(ids);
		String temp=request.getParameter("changeType");
		if(temp.substring(0, 1).equals("1")){
			Uniteharvester uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterById(ids);
			int unoteid=Integer.parseInt(request.getParameter("unitid"));
			uniteharvester.setUnitid(unoteid);
			if(!serviceManager.getUniteharvesterService().saveUniteharvester(uniteharvester)){
				response.getWriter().write("{success:false,reason:'联合收割机变更登记失败'}");
				return;
			}
		}

		if(serviceManager.getUniteharvesterChangeService().addUniteharvesterChange(uniteharvesterChange)){
			response.getWriter().write("{success:true,reason:'联合收割机变更登记成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机变更登记失败'}");
		}
		
	}
	public void updateUniteharvesterChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterChange uniteharvesterChange=new UniteharvesterChange();
		uniteharvesterChange.setChangeApplicationtype(Integer.parseInt(request.getParameter("changeApplicationtype")));
		uniteharvesterChange.setChangeNote(request.getParameter("changeNote"));
		uniteharvesterChange.setChangeRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("changeRegistdate").trim()));
		uniteharvesterChange.setChangeRegisterman(request.getParameter("changeRegisterman"));
		uniteharvesterChange.setChangeType(request.getParameter("changeType"));
		uniteharvesterChange.setChangeUnit(request.getParameter("changeUnit"));
		uniteharvesterChange.setHarvesterId(Integer.parseInt(request.getParameter("harvesterId")));
		uniteharvesterChange.setId(Integer.parseInt(request.getParameter("id")));
		String temp=request.getParameter("changeType");
		if(temp.substring(0, 1).equals("1")){
			Uniteharvester uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterById(Integer.parseInt(request.getParameter("harvesterId")));
			int unoteid=Integer.parseInt(request.getParameter("unitid"));
			uniteharvester.setUnitid(unoteid);
			if(!serviceManager.getUniteharvesterService().saveUniteharvester(uniteharvester)){
				response.getWriter().write("{success:false,reason:'联合收割机变更登记失败'}");
				return;
			}
		}
		if(serviceManager.getUniteharvesterChangeService().updateUniteharvesterChange(uniteharvesterChange)){
			response.getWriter().write("{success:true,reason:'联合收割机变更登记信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机变更登记信息修改失败'}");
		}
	}
	public void deleteUniteharvesterChange(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String uniteharvesterChangeJson = (String) request.getParameter("uniteharvesterchangelist").trim();
		JSONArray jsonArray = JSONArray.fromObject(uniteharvesterChangeJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			UniteharvesterChangeView uniteharvesterChangeview=(UniteharvesterChangeView)JSONObject.toBean(jsonObject, UniteharvesterChangeView.class);
			
			UniteharvesterChange uniteharvesterChange=new UniteharvesterChange();
			uniteharvesterChange.setChangeApplicationtype(uniteharvesterChangeview.getApplicationType());
			uniteharvesterChange.setChangeNote(uniteharvesterChangeview.getChangeNote());
			uniteharvesterChange.setChangeRegistdate(uniteharvesterChangeview.getChangeRegistdate());
			uniteharvesterChange.setChangeRegisterman(uniteharvesterChangeview.getChangeRegisterman());
			uniteharvesterChange.setChangeType(uniteharvesterChangeview.getChangeType());
			uniteharvesterChange.setChangeUnit(uniteharvesterChangeview.getChangeUnit());
			uniteharvesterChange.setHarvesterId(uniteharvesterChangeview.getId());
			uniteharvesterChange.setId(uniteharvesterChangeview.getChangeid());
			
			boolean isDelete = serviceManager.getUniteharvesterChangeService().delUniteharvesterChange(uniteharvesterChange);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'联合收割机变更登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
}
