package Ynzc.YnzcAms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.User;

public class SetTimeController extends BaseController{	
	private final static Logger log = Logger.getLogger(SetTimeController.class);

	public void updateCarSetTime(HttpServletRequest request,HttpServletResponse response) throws IOException{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("update setTime");
		try{
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			st.setCarChangeTime(Integer.valueOf(request.getParameter("carChangeTime").trim()));
			st.setCarCheckTime(Integer.valueOf(request.getParameter("carCheckTime").trim()));
			st.setCarLogoutTime(Integer.valueOf(request.getParameter("carLogoutTime").trim()));
			st.setCarModifyRecordTime(Integer.valueOf(request.getParameter("carModifyRecordTime").trim()));
			st.setCarMortgageTime(Integer.valueOf(request.getParameter("carMortgageTime").trim()));
			st.setCarRegisterTime(Integer.valueOf(request.getParameter("carRegisterTime").trim()));
			st.setCarReplaceTime(Integer.valueOf(request.getParameter("carReplaceTime").trim()));
			st.setCarTransferTime(Integer.valueOf(request.getParameter("carTransferTime").trim()));
			if(serviceManager.getSetTimeService().updateSetTime(st)){
				System.out.println("OK");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void updateLincenseSetTime(HttpServletRequest request,HttpServletResponse response) throws IOException{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("update setTime");
		try{
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			User user=(User)request.getSession().getAttribute("user");
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());		
			st.setLicenseChangeTime(Integer.valueOf(request.getParameter("licenseChangeTime").trim()));
			st.setLicenseDefaceTime(Integer.valueOf(request.getParameter("licenseDefaceTime").trim()));
			st.setLicenseEndTime(Integer.valueOf(request.getParameter("licenseEndTime").trim()));
			st.setLicenseInTime(Integer.valueOf(request.getParameter("licenseInTime").trim()));
			st.setLicenseLogoutTime(Integer.valueOf(request.getParameter("licenseLogoutTime").trim()));
			st.setLicenseOutTime(Integer.valueOf(request.getParameter("licenseOutTime").trim()));
			st.setLicenseReplaceTime(Integer.valueOf(request.getParameter("licenseReplaceTime").trim()));
			if(serviceManager.getSetTimeService().updateSetTime(st)){
				System.out.println("OK");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void findSetTime(HttpServletRequest request,HttpServletResponse response) throws IOException{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("update setTime");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
		JSONArray jsonItems = new JSONArray();
		if(st != null){
			if (st != null) {
				jsonItems.add(JSONObject.fromObject(st));
			}
		}else{
			st = new SetTime();
			st.setCarChangeTime(0);
			st.setCarCheckTime(0);
			st.setCarLogoutTime(0);
			st.setCarModifyRecordTime(0);
			st.setCarMortgageTime(0);
			st.setCarRegisterTime(0);
			st.setCarReplaceTime(0);
			st.setCarTransferTime(0);
			st.setUnitid(user.getUnitid());
			st.setLicenseChangeTime(0);
			st.setLicenseDefaceTime(0);
			st.setLicenseEndTime(0);
			st.setLicenseInTime(0);
			st.setLicenseLogoutTime(0);
			st.setLicenseOutTime(0);
			st.setLicenseReplaceTime(0);
			if(serviceManager.getSetTimeService().saveSetTime(st)){
				jsonItems.add(JSONObject.fromObject(st));
			}
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
}
