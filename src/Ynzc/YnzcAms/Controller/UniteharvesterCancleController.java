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
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterCancle;
import Ynzc.YnzcAms.Model.UniteharvesterCancleView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UniteharvesterCancleController extends  BaseController{
	public void getUniteharvesterCancleViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<UniteharvesterCancleView> res = serviceManager.getUniteharvesterCancleService().getUniteharvesterCancleAll(page, condition, us.getId());
		JSONArray jsonItems = new JSONArray();
		for (UniteharvesterCancleView u : res) {
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
	public void addUniteharvesterCancle(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterCancle uniteharvesterCancle=new UniteharvesterCancle();
		uniteharvesterCancle.setCancleApplicationtype(Integer.parseInt(request.getParameter("cancleApplicationtype")));
		uniteharvesterCancle.setCancledateContent(request.getParameter("cancledateContent"));
		uniteharvesterCancle.setCancleNote(request.getParameter("cancleNote"));
		uniteharvesterCancle.setCancleRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("cancleRegistdate").trim()));
		uniteharvesterCancle.setCancleRegisterman(request.getParameter("cancleRegisterman"));
		uniteharvesterCancle.setCancleWhytype(Integer.parseInt(request.getParameter("cancleWhyType")));
		int ids=Integer.parseInt(request.getSession().getAttribute("uniteharvesterid").toString());
		uniteharvesterCancle.setHarvesterId(ids);
		String temp=request.getParameter("cancledateContent");
		temp=temp.substring(0, 1);
		
		String reaperPlateNum=request.getParameter("reaperPlateNum").trim();
		String reaperPlateHead=request.getParameter("reaperPlateHead").trim();
		String reaperPlateUnitid=request.getParameter("reaperPlateUnitid").trim();
		
		PlateHandle plateHandle=new PlateHandle();
		plateHandle.setHandledate(new Date());
		plateHandle.setPlatehandle(10);
		plateHandle.setPlatenum(reaperPlateNum);
		plateHandle.setTypes(2);
		plateHandle.setUnitid(Integer.parseInt(reaperPlateUnitid));
		plateHandle.setUserid(us.getId());
		if(temp.equals("1")){
			Uniteharvester uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterById(ids);
			uniteharvester.setHarvesterState(1);
			if(!serviceManager.getUniteharvesterService().saveUniteharvester(uniteharvester)){
				response.getWriter().write("{success:false,reason:'联合收割机注销登记失败'}");
				return;
			}
		}
		if(serviceManager.getReaperPlateService().updateState(reaperPlateNum, reaperPlateHead, 5)){
			if(serviceManager.getUniteharvesterCancleService().addUniteharvesterCancle(uniteharvesterCancle)){
				serviceManager.getPlateHandleService().addPlateHandle(plateHandle);
				response.getWriter().write("{success:true,reason:'联合收割机注销登记成功'}");
			}else{
				response.getWriter().write("{success:false,reason:'联合收割机注销登记失败'}");
			}
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机注销登记失败:该号牌号码不存在，或信息有误！'}");
		}
		
	}
	public void updateUniteharvesterCancle(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterCancle uniteharvesterCancle=new UniteharvesterCancle();
		uniteharvesterCancle.setCancleApplicationtype(Integer.parseInt(request.getParameter("cancleApplicationtype")));
		uniteharvesterCancle.setCancledateContent(request.getParameter("cancledateContent"));
		uniteharvesterCancle.setCancleNote(request.getParameter("cancleNote"));
		uniteharvesterCancle.setCancleRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("cancleRegistdate").trim()));
		uniteharvesterCancle.setCancleRegisterman(request.getParameter("cancleRegisterman"));
		uniteharvesterCancle.setCancleWhytype(Integer.parseInt(request.getParameter("cancleWhyType")));
		uniteharvesterCancle.setHarvesterId(Integer.parseInt(request.getParameter("harvesterId")));
		uniteharvesterCancle.setId(Integer.parseInt(request.getParameter("id")));
		
		String temp=request.getParameter("cancledateContent");
		temp=temp.substring(0, 1);
		if(temp.equals("1")){
			Uniteharvester uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterById(Integer.parseInt(request.getParameter("harvesterId")));
			uniteharvester.setHarvesterState(1);
			if(!serviceManager.getUniteharvesterService().saveUniteharvester(uniteharvester)){
				response.getWriter().write("{success:false,reason:'联合收割机注销登记失败'}");
				return;
			}
		}
		if(serviceManager.getUniteharvesterCancleService().updateUniteharvesterCancle(uniteharvesterCancle)){
			response.getWriter().write("{success:true,reason:'联合收割机注销登记信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机注销登记信息修改失败'}");
		}
	}
	public void deleteUniteharvesterCancle(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String uniteharvestercancleJson = (String) request.getParameter("uniteharvestercanclelist").trim();
		JSONArray jsonArray = JSONArray.fromObject(uniteharvestercancleJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			UniteharvesterCancleView uniteharvesterCancleView=(UniteharvesterCancleView)JSONObject.toBean(jsonObject, UniteharvesterCancleView.class);
			
			UniteharvesterCancle uniteharvesterCancle=new UniteharvesterCancle();
			uniteharvesterCancle.setCancleApplicationtype(uniteharvesterCancleView.getApplicationType());
			uniteharvesterCancle.setCancledateContent(uniteharvesterCancleView.getCancledateContent());
			uniteharvesterCancle.setCancleNote(uniteharvesterCancleView.getCancleNote());
			uniteharvesterCancle.setCancleRegistdate(uniteharvesterCancleView.getCancleRegistdate());
			uniteharvesterCancle.setCancleRegisterman(uniteharvesterCancleView.getRegisterMan());
			uniteharvesterCancle.setCancleWhytype(uniteharvesterCancleView.getCancleWhytype());
			uniteharvesterCancle.setHarvesterId(uniteharvesterCancleView.getId());
			uniteharvesterCancle.setId(uniteharvesterCancleView.getCancleid());
			
			boolean isDelete = serviceManager.getUniteharvesterCancleService().delUniteharvesterCancle(uniteharvesterCancle);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'联合收割机注销登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
}
