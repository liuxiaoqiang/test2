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
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleBodyView;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class BodyInfoController extends BaseController{
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(BodyInfoController.class);
	
	public void getBodyInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<PeopleBodyView> res = serviceManager.getBodyInfoService().getAllBodyInfo(page,condition,user.getId());
		JSONArray jsonItems = new JSONArray();
		for (PeopleBodyView model : res) {
			jsonItems.add(JSONObject.fromObject(model));
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

	public void addBodyInfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		BodyInfo model=new BodyInfo();
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		model.setPeopleInfoId(Integer.valueOf(request.getParameter("peopleInfoId").trim()));
		model.setHight(request.getParameter("hight").trim());
		model.setResolvingPowerFlag(Integer.valueOf(request.getParameter("resolvingPowerFlag").trim()));
		model.setRightEyePwoer(request.getParameter("rightEyePwoer").trim());
		model.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("rightEyeRectificationFlag").trim()));
		model.setLeftEyePwoer(request.getParameter("leftEyePwoer").trim());
		model.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("leftEyeRectificationFlag").trim()));
		model.setRightEarPwoer(request.getParameter("rightEarPwoer").trim());
		model.setLeftEarPwoer(request.getParameter("leftEarPwoer").trim());
		model.setRightHandFlag(Integer.valueOf(request.getParameter("rightHandFlag").trim()));
		model.setLeftHandFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
		model.setRightLagFlag(Integer.valueOf(request.getParameter("rightLagFlag").trim()));
		model.setLeftLagFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
		model.setBodyNeck(Integer.valueOf(request.getParameter("bodyNeck").trim()));
		model.setBodyCheckDate(Date.valueOf(request.getParameter("bodyCheckDate").trim()));
		model.setCheckResultFlag(Integer.valueOf(request.getParameter("checkResultFlag").trim()));
		model.setCheckOrganization(request.getParameter("checkOrganization").trim());
		model.setCheckDoctor(request.getParameter("checkDoctor").trim());
		model.setRegionId(unit.getRegionid());
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(serviceManager.getBodyInfoService().addBodyInfo(model)){
			PeopleInfo peopleInfoModel = serviceManager.getPeopleInfoService().findPeopleInfoById(model.getPeopleInfoId());
			peopleInfoModel.setBodyInfoId(model.getId());
			if(serviceManager.getPeopleInfoService().updatePeopleInfo(peopleInfoModel)){
				response.getWriter().write("{success: true,reason:'添加身体状况信息成功'}");
			}
		}else{
			response.getWriter().write("{success:false,reason:'添加身体状况信息失败'}");
		}
	}
	
	public void delBodyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			String BodyInfoJson = (String) request.getParameter("id").trim();
			boolean isDelete = serviceManager.getBodyInfoService().delMoreBodyInfo(BodyInfoJson);
			if (!isDelete) {
				response.getWriter().write("{success:false,reason:'删除失败'}");
			}else{
				response.getWriter().write("{success: true,reason:'删除成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'删除失败'}");
			ex.printStackTrace();
		}
	}
	
	public void updatePeopleInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id").trim());
		User user=(User)request.getSession().getAttribute("user");
		BodyInfo model = serviceManager.getBodyInfoService().findBodyInfoById(id);
		model.setHight(request.getParameter("hight").trim());
		model.setResolvingPowerFlag(Integer.valueOf(request.getParameter("resolvingPowerFlag").trim()));
		model.setRightEyePwoer(request.getParameter("rightEyePwoer").trim());
		model.setRightEyeRectificationFlag(Integer.valueOf(request.getParameter("rightEyeRectificationFlag").trim()));
		model.setLeftEyePwoer(request.getParameter("leftEyePwoer").trim());
		model.setLeftEyeRectificationFlag(Integer.valueOf(request.getParameter("leftEyeRectificationFlag").trim()));
		model.setRightEarPwoer(request.getParameter("rightEarPwoer").trim());
		model.setLeftEarPwoer(request.getParameter("leftEarPwoer").trim());
		model.setRightHandFlag(Integer.valueOf(request.getParameter("rightHandFlag").trim()));
		model.setLeftHandFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
		model.setRightLagFlag(Integer.valueOf(request.getParameter("rightLagFlag").trim()));
		model.setLeftLagFlag(Integer.valueOf(request.getParameter("leftLagFlag").trim()));
		model.setBodyNeck(Integer.valueOf(request.getParameter("bodyNeck").trim()));
		model.setBodyCheckDate(Date.valueOf(request.getParameter("bodyCheckDate").trim()));
		model.setCheckResultFlag(Integer.valueOf(request.getParameter("checkResultFlag").trim()));
		model.setCheckOrganization(request.getParameter("checkOrganization").trim());
		model.setCheckDoctor(request.getParameter("checkDoctor").trim());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(!serviceManager.getBodyInfoService().updateBodyInfo(model)){
			response.getWriter().write("{success:false,reason:'更新身体状况信息失败'}");
		}else{
			response.getWriter().write("{success: true,reason:'更新身体状况信息成功'}");
		}
	}
	
	public void getBodyInfoById(HttpServletRequest request, HttpServletResponse response)throws Exception{
		int id = Integer.valueOf(request.getParameter("id").trim().toString());
		BodyInfo res = serviceManager.getBodyInfoService().findBodyInfoById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
}
