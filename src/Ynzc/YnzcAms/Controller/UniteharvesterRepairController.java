package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateHandle;
import Ynzc.YnzcAms.Model.UniteharvesterRepair;
import Ynzc.YnzcAms.Model.UniteharvesterRepairView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UniteharvesterRepairController extends  BaseController{
	public void getUniteharvesterRepairViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<UniteharvesterRepairView> res = serviceManager.getUniteharvesterRepairService().getUniteharvesterRepairAll(page, condition, us.getId());
		JSONArray jsonItems = new JSONArray();
		for (UniteharvesterRepairView u : res) {
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
	public void addUniteharvesterRepair(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterRepair uniteharvesterRepair=new UniteharvesterRepair();
		int ids=Integer.parseInt(request.getSession().getAttribute("uniteharvesterid").toString());
		uniteharvesterRepair.setHarvesterId(ids);
		uniteharvesterRepair.setRepairApplicationtype(Integer.parseInt(request.getParameter("repairApplicationtype")));
		uniteharvesterRepair.setRepairNote(request.getParameter("repairNote"));
		uniteharvesterRepair.setRepairPapes(Integer.parseInt(request.getParameter("repairPapes")));
		uniteharvesterRepair.setRepairRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("repairRegistdate").trim()));
		uniteharvesterRepair.setRepairRegisterman(request.getParameter("repairRegisterman"));
		uniteharvesterRepair.setRepairType(request.getParameter("repairType"));
		uniteharvesterRepair.setRepairWhy(request.getParameter("repairWhy"));
		
		String reaperPlateNum=request.getParameter("reaperPlateNum").trim();
		String reaperPlateHead=request.getParameter("reaperPlateHead").trim();
		String reaperPlateUnitid=request.getParameter("reaperPlateUnitid").trim();
		
		PlateHandle plateHandle=new PlateHandle();
		plateHandle.setHandledate(new Date());
		plateHandle.setPlatehandle(13);
		plateHandle.setPlatenum(reaperPlateNum);
		plateHandle.setTypes(2);
		plateHandle.setUnitid(Integer.parseInt(reaperPlateUnitid));
		plateHandle.setUserid(us.getId());
		
		if(serviceManager.getReaperPlateService().updateState(reaperPlateNum, reaperPlateHead, 4)){
			if(serviceManager.getUniteharvesterRepairService().addUniteharvesterRepair(uniteharvesterRepair)){
				serviceManager.getPlateHandleService().addPlateHandle(plateHandle);
				response.getWriter().write("{success:true,reason:'联合收割机补证、补牌登记成功'}");
			}else{
				response.getWriter().write("{success:false,reason:'联合收割机补证、补牌登记失败'}");
			}
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机补证、补牌登记失败:该号牌号码不存在，或信息有误！'}");
		}
	}
	public void updateUniteharvesterRepair(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterRepair uniteharvesterRepair=new UniteharvesterRepair();
		uniteharvesterRepair.setHarvesterId(Integer.parseInt(request.getParameter("harvesterId")));
		uniteharvesterRepair.setRepairApplicationtype(Integer.parseInt(request.getParameter("repairApplicationtype")));
		uniteharvesterRepair.setRepairNote(request.getParameter("repairNote"));
		uniteharvesterRepair.setRepairPapes(Integer.parseInt(request.getParameter("repairPapes")));
		uniteharvesterRepair.setRepairRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("repairRegistdate").trim()));
		uniteharvesterRepair.setRepairRegisterman(request.getParameter("repairRegisterman"));
		uniteharvesterRepair.setRepairType(request.getParameter("repairType"));
		uniteharvesterRepair.setRepairWhy(request.getParameter("repairWhy"));
		uniteharvesterRepair.setId(Integer.parseInt(request.getParameter("id")));
		if(serviceManager.getUniteharvesterRepairService().updateUniteharvesterRepair(uniteharvesterRepair)){
			response.getWriter().write("{success:true,reason:'联合收割机补证、补牌登记信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机补证、补牌登记信息修改失败'}");
		}
	}
	public void deleteUniteharvester(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String uniteharvesterrepairJson = (String) request.getParameter("uniteharvesterrepairlist").trim();
		JSONArray jsonArray = JSONArray.fromObject(uniteharvesterrepairJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			UniteharvesterRepairView uniteharvesterRepairview=(UniteharvesterRepairView)JSONObject.toBean(jsonObject, UniteharvesterRepairView.class);
			
			UniteharvesterRepair uniteharvesterRepair=new UniteharvesterRepair();
			uniteharvesterRepair.setHarvesterId(uniteharvesterRepairview.getId());
			uniteharvesterRepair.setRepairApplicationtype(uniteharvesterRepairview.getRepairApplicationtype());
			uniteharvesterRepair.setRepairNote(uniteharvesterRepairview.getRepairNote());
			uniteharvesterRepair.setRepairPapes(uniteharvesterRepairview.getRepairPapes());
			uniteharvesterRepair.setRepairRegistdate(uniteharvesterRepairview.getRepairRegistdate());
			uniteharvesterRepair.setRepairRegisterman(uniteharvesterRepairview.getRepairRegisterman());
			uniteharvesterRepair.setRepairType(uniteharvesterRepairview.getRepairType());
			uniteharvesterRepair.setRepairWhy(uniteharvesterRepairview.getRepairWhy());
			uniteharvesterRepair.setId(uniteharvesterRepairview.getRepairid());
			
			boolean isDelete = serviceManager.getUniteharvesterRepairService().delUniteharvesterRepair(uniteharvesterRepair);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'联合收割机补证、补牌登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
}
