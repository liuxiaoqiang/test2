package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Ynzc.YnzcAms.Model.DrivertraingTractorinfoView;
import Ynzc.YnzcAms.Model.DrivertrainingCheckInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfo;
import Ynzc.YnzcAms.Model.DrivertrainingInfoView;
import Ynzc.YnzcAms.Model.UniteharvesterView;
import Ynzc.YnzcAms.Model.User;

public class DrivertrainingCheckInfoController  extends  BaseController{
	
	public void addDrivertrainingCheckInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DrivertrainingCheckInfo drivertrainingCheckInfo=new DrivertrainingCheckInfo();
		drivertrainingCheckInfo.setChangeRecord("初次年检");
		drivertrainingCheckInfo.setCheckDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkDate").trim()));
		drivertrainingCheckInfo.setCheckMan(request.getParameter("CheckMan").trim());
		drivertrainingCheckInfo.setCheckResult(request.getParameter("checkResult").trim());
		drivertrainingCheckInfo.setCheckUnitName(request.getParameter("checkUnitName").trim());
		drivertrainingCheckInfo.setDrivertrainingId(Integer.parseInt(request.getSession().getAttribute("DrivertrainingId").toString()));
		drivertrainingCheckInfo.setEnteyMan(request.getParameter("EnteyMan").trim());
		Date dt=new Date();
		drivertrainingCheckInfo.setEntryDate(dt);
		drivertrainingCheckInfo.setInsurceActiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("InsurceActiveDate").trim()));
		drivertrainingCheckInfo.setInsurceCode(request.getParameter("insurceCode").trim());
		drivertrainingCheckInfo.setInsurceDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("InsurceDate").trim()));
		drivertrainingCheckInfo.setInsurceMark(0);
		drivertrainingCheckInfo.setInsurceName(request.getParameter("InsurceNameid").trim());
		drivertrainingCheckInfo.setInsurceType(request.getParameter("insurceType").trim());
		drivertrainingCheckInfo.setCheckLiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkLiveDate").trim()));
		if(serviceManager.getDrivertrainingCheckService().addDrivertrainingCheckInfo(drivertrainingCheckInfo)){
			response.getWriter().write("{success:true,reason:'教练车年检信息登记成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'教练车年检信息登记失败'}");
		}
	}
	@SuppressWarnings("rawtypes")
	public void deleteDrivertrainingCheckInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String userJson = (String) request.getParameter("drivertrainingCheckInfoList").trim();
		JSONArray jsonArray = JSONArray.fromObject(userJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			DrivertrainingInfoView drivertrainingInfoView=(DrivertrainingInfoView)JSONObject.toBean(jsonObject, DrivertrainingInfoView.class);
			DrivertrainingCheckInfo drivertrainingCheckInfo=serviceManager.getDrivertrainingCheckService().fingDrivertrainingCheckInfoById(drivertrainingInfoView.getDrivingcheckid());
			boolean isDelete = serviceManager.getDrivertrainingCheckService().deleteDrivertrainingCheckInfo(drivertrainingCheckInfo);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'教练车年检信息删除成功'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	public void updateDrivertrainingCheckInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DrivertrainingCheckInfo drivertrainingCheckInfo=new DrivertrainingCheckInfo();
		drivertrainingCheckInfo.setChangeRecord("年检修改");
		drivertrainingCheckInfo.setCheckDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkDate").trim()));
		drivertrainingCheckInfo.setCheckMan(request.getParameter("CheckMan").trim());
		drivertrainingCheckInfo.setCheckResult(request.getParameter("checkResult").trim());
		drivertrainingCheckInfo.setCheckUnitName(request.getParameter("checkUnitName").trim());
		drivertrainingCheckInfo.setDrivertrainingId(Integer.parseInt(request.getParameter("drivetraininfoid").toString()));//教练车id
		drivertrainingCheckInfo.setEnteyMan(request.getParameter("EnteyMan").trim());
		Date dt=new Date();
		drivertrainingCheckInfo.setEntryDate(dt);
		drivertrainingCheckInfo.setInsurceActiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("InsurceActiveDate").trim()));
		drivertrainingCheckInfo.setInsurceCode(request.getParameter("insurceCode").trim());
		drivertrainingCheckInfo.setInsurceDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("InsurceDate").trim()));
		drivertrainingCheckInfo.setInsurceMark(1);
		drivertrainingCheckInfo.setInsurceName(request.getParameter("InsurceNameid").trim());
		drivertrainingCheckInfo.setInsurceType(request.getParameter("insurceType").trim());
		drivertrainingCheckInfo.setCheckLiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkLiveDate").trim()));
		drivertrainingCheckInfo.setId(Integer.parseInt(request.getParameter("id")));
		if(serviceManager.getDrivertrainingCheckService().updateDrivertrainingCheckInfo(drivertrainingCheckInfo)){
			response.getWriter().write("{success:true,reason:'教练车年检信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'教练车年检信息修改失败'}");
		}
	}
	public void checkDrivertrainingCardCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		DrivertrainingInfo temp=serviceManager.getDrivertrainingService().findDrivertrainingInfoViewByCarNum(request.getParameter("cardcode").trim(), us.getId());
		if(temp==null){
			response.getWriter().write("{success:false,reason:'该教练车号码尚未注册登记,请核对填写。'}");
			return;
		}
		request.getSession().setAttribute("DrivertrainingId", temp.getId());//设置教练车id
		if(temp.getCarType()==1){
			DrivertraingTractorinfoView res = serviceManager.getDrivertrainingService().FindDrivertraingTractorinfoViewById(temp.getTractorinfoId());
			JSONArray jsonItems = new JSONArray();
			if (res != null) {
				jsonItems.add(JSONObject.fromObject(res));
				String tempJson=jsonItems.toString();
				tempJson=tempJson.substring(0, tempJson.length()-2);
				tempJson+=",carType:1}]";
				JSONObject jsonBack = new JSONObject();
				jsonBack.put("drivertrainingInfoData", tempJson);
				System.out.println(jsonBack);
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(jsonBack);
			}
		}else{
			UniteharvesterView res=serviceManager.getUniteharvesterService().findUniteharvesterViewById(temp.getTractorinfoId());
			JSONArray jsonItems = new JSONArray();
			if (res != null) {
				jsonItems.add(JSONObject.fromObject(res));
				String tempJson=jsonItems.toString();
				tempJson=tempJson.substring(0, tempJson.length()-2);
				tempJson+=",carType:2}]";
				JSONObject jsonBack = new JSONObject();
				jsonBack.put("drivertrainingInfoData", tempJson);
				System.out.println(jsonBack);
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(jsonBack);
			}
		}
	}
}
