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
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateHandle;
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UniteharvesterController extends  BaseController{
	//根据联合收割机查找信息
	public void findUniteharvesterByCarNum(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");		
		String carnum = (String) request.getParameter("carCode").trim();//需要查找的联合收割机号码
		String unitid=(String) request.getParameter("unitid").trim();//经办人单位
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterView uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterByCarNum(carnum, us.getId());
		if(uniteharvester!=null){
			request.getSession().setAttribute("uniteharvesterid", uniteharvester.getId());
		}
		JSONArray jsonItems = new JSONArray();
		jsonItems.add(JSONObject.fromObject(uniteharvester));
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("UniteHarvester", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	public void findUniteharvesterViewByid(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=request.getParameter("id").trim();
		int id=Integer.parseInt(ids);
		UniteharvesterView res = serviceManager.getUniteharvesterService().findUniteharvesterViewById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
			JSONObject jsonBack = new JSONObject();
			jsonBack.put("uniteharvesterData", jsonItems);
			System.out.println(jsonBack);
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonBack);
		}
	}
	public void findUniteharvesterById(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=request.getParameter("id").trim();
		int id=Integer.parseInt(ids);
		Uniteharvester res = serviceManager.getUniteharvesterService().findUniteharvesterById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
			JSONObject jsonBack = new JSONObject();
			jsonBack.put("uniteharvesterData", jsonItems);
			System.out.println(jsonBack);
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonBack);
		}
	}
	public void getUniteharvesterViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<UniteharvesterView> res = serviceManager.getUniteharvesterService().getUniteharvesterViewAll(page, condition,us.getId());
		JSONArray jsonItems = new JSONArray();
		for (UniteharvesterView u : res) {
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
	public void addUniteharvester(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		Uniteharvester uniteharvester=new Uniteharvester();
		uniteharvester.setApplicationType(Integer.parseInt(request.getParameter("applicationType")));
		uniteharvester.setCertiCode(request.getParameter("certiCode"));
		uniteharvester.setCertitype(Integer.parseInt(request.getParameter("certitype")));
		uniteharvester.setComeProofType(request.getParameter("comeProofType"));
		uniteharvester.setHarvesterBodyCode(request.getParameter("harvesterBodyCode"));
		uniteharvester.setHarvesterBodyColor(request.getParameter("harvesterBodyColor"));
		uniteharvester.setHarvesterChangPaiType(request.getParameter("harvesterChangPaiType"));
		uniteharvester.setHarvesterCode(request.getParameter("harvesterCode"));
		uniteharvester.setHarvesterEngineCode(request.getParameter("harvesterEngineCode"));
		uniteharvester.setHarvesterGetWay(request.getParameter("harvesterGetWay"));
		uniteharvester.setHarvesterGuanXiaDi(request.getParameter("harvesterGuanXiaDi"));
		uniteharvester.setHarvesterOwner(request.getParameter("harvesterOwner"));
		uniteharvester.setHarvesterPhotoUrl(request.getParameter("harvesterPhotoUrl"));
		uniteharvester.setHarvesterQuality(Integer.parseInt(request.getParameter("harvesterQuality")));
		uniteharvester.setHarvesterSitNum(Integer.parseInt(request.getParameter("harvesterSitNum")));
		uniteharvester.setHarvesterState(0);
		uniteharvester.setHarvesterType(Integer.parseInt(request.getParameter("harvesterType")));
		uniteharvester.setImportType(request.getParameter("importType"));
		uniteharvester.setLiveAddress(request.getParameter("liveAddress"));
		uniteharvester.setLiveCode(request.getParameter("liveCode"));
		uniteharvester.setLivePostCode(request.getParameter("livePostCode"));
		uniteharvester.setLiveType(Integer.parseInt(request.getParameter("liveType")));
		uniteharvester.setOtherType(request.getParameter("otherType"));
		uniteharvester.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("registerDate").trim()));
		uniteharvester.setRegisterMan(request.getParameter("registerMan"));
		uniteharvester.setTelephoneNum(request.getParameter("telephoneNum"));
		uniteharvester.setTempAddress(request.getParameter("tempAddress"));
		uniteharvester.setTempPostCode(request.getParameter("tempPostCode"));
		uniteharvester.setUnitid(Integer.parseInt(request.getParameter("unitid")));
		
		if(serviceManager.getReaperPlateService().updateState(request.getParameter("harvesterCode"),request.getSession().getAttribute("platecode").toString(), 3)){
			if(serviceManager.getUniteharvesterService().addUniteharvester(uniteharvester)){
				response.getWriter().write("{success:true,reason:'联合收割机注册登记成功'}");
			}else{
				response.getWriter().write("{success:false,reason:'联合收割机注册登记失败'}");
			}
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机注册登记失败:该号牌号码不存在，或信息有误！'}");
		}
		
	}
	public void updateUniteharvester(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		Uniteharvester uniteharvester=new Uniteharvester();
		uniteharvester.setApplicationType(Integer.parseInt(request.getParameter("applicationType")));
		uniteharvester.setCertiCode(request.getParameter("certiCode"));
		uniteharvester.setCertitype(Integer.parseInt(request.getParameter("certitype")));
		uniteharvester.setComeProofType(request.getParameter("comeProofType"));
		uniteharvester.setHarvesterBodyCode(request.getParameter("harvesterBodyCode"));
		uniteharvester.setHarvesterBodyColor(request.getParameter("harvesterBodyColor"));
		uniteharvester.setHarvesterChangPaiType(request.getParameter("harvesterChangPaiType"));
		uniteharvester.setHarvesterCode(request.getParameter("harvesterCode"));
		uniteharvester.setHarvesterEngineCode(request.getParameter("harvesterEngineCode"));
		uniteharvester.setHarvesterGetWay(request.getParameter("harvesterGetWay"));
		uniteharvester.setHarvesterGuanXiaDi(request.getParameter("harvesterGuanXiaDi"));
		uniteharvester.setHarvesterOwner(request.getParameter("harvesterOwner"));
		uniteharvester.setHarvesterPhotoUrl(request.getParameter("harvesterPhotoUrl"));
		uniteharvester.setHarvesterQuality(Integer.parseInt(request.getParameter("harvesterQuality")));
		uniteharvester.setHarvesterSitNum(Integer.parseInt(request.getParameter("harvesterSitNum")));
		uniteharvester.setHarvesterState(Integer.parseInt(request.getParameter("harvesterState")));
		uniteharvester.setHarvesterType(Integer.parseInt(request.getParameter("harvesterType")));
		uniteharvester.setImportType(request.getParameter("importType"));
		uniteharvester.setLiveAddress(request.getParameter("liveAddress"));
		uniteharvester.setLiveCode(request.getParameter("liveCode"));
		uniteharvester.setLivePostCode(request.getParameter("livePostCode"));
		uniteharvester.setLiveType(Integer.parseInt(request.getParameter("liveType")));
		uniteharvester.setOtherType(request.getParameter("otherType"));
		uniteharvester.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("registerDate").trim()));
		uniteharvester.setRegisterMan(request.getParameter("registerMan"));
		uniteharvester.setTelephoneNum(request.getParameter("telephoneNum"));
		uniteharvester.setTempAddress(request.getParameter("tempAddress"));
		uniteharvester.setTempPostCode(request.getParameter("tempPostCode"));
		uniteharvester.setUnitid(Integer.parseInt(request.getParameter("unitid")));
		uniteharvester.setId(Integer.parseInt(request.getParameter("id")));
		if(serviceManager.getUniteharvesterService().updateUniteharvester(uniteharvester)){
			response.getWriter().write("{success:true,reason:'联合收割机注册登记信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机注册登记信息修改失败'}");
		}
	}
	public void deleteUniteharvester(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String uniteharvesterJson = (String) request.getParameter("uniteharvesterlist").trim();
		JSONArray jsonArray = JSONArray.fromObject(uniteharvesterJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			Uniteharvester uniteharvester=(Uniteharvester)JSONObject.toBean(jsonObject, Uniteharvester.class);
			boolean isDelete = serviceManager.getUniteharvesterService().delUniteharvester(uniteharvester);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'联合收割机注册登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
}
