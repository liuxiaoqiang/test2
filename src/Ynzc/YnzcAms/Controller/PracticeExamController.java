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
import Ynzc.YnzcAms.Model.DriverClassInfo;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PracticeExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExam;
import Ynzc.YnzcAms.Model.PracticeMakeupExamView;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class PracticeExamController extends BaseController{
	private final static Logger log = Logger.getLogger(PracticeExamController.class);

	public void addPracticeExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		PracticeExam model=new PracticeExam();
		try{
			model.setDriverStrInfoId(Integer.valueOf(request.getParameter("driverStrInfoId").trim()));
			model.setDrivingLicenceNo(request.getParameter("drivingLicenceNo").trim());
			model.setDrillMasterId(request.getParameter("drillMasterId").trim());
			model.setDrillMasterCode(request.getParameter("drillMasterCode").trim());
			model.setDrillMasterDate(request.getParameter("drillMasterDate").trim());
			model.setDrillMasterMachine(request.getParameter("drillMasterMachine").trim());
			model.setDrillMasterAuditingIdeaFlag(Integer.valueOf(request.getParameter("drillMasterAuditingIdeaFlag").trim()));
			model.setUnitAuditingPracticeIdeaFlag(Integer.valueOf(request.getParameter("unitAuditingPracticeIdeaFlag").trim()));
			model.setDrivingLicenceAuditingIdeaFlag(Integer.valueOf(request.getParameter("drivingLicenceAuditingIdeaFlag").trim()));
			model.setOrgAuditingIdeaFlag(Integer.valueOf(request.getParameter("orgAuditingIdeaFlag").trim()));
			model.setFieldResult(request.getParameter("fieldResult").trim());
			model.setExaminerFieldOne(request.getParameter("examinerFieldOne").trim());
			model.setExaminerFieldTwo(request.getParameter("examinerFieldTwo").trim());
			model.setFieldDate(Date.valueOf(request.getParameter("fieldDate").trim()));
			if(request.getParameter("makeupFieldResult").trim() != null && !"".equals(request.getParameter("makeupFieldResult").trim())){
				model.setFieldMakeupResult(request.getParameter("makeupFieldResult").trim());
			}
			if(request.getParameter("examinerMakeupFieldOne").trim() != null && !"".equals(request.getParameter("examinerMakeupFieldOne").trim())){
				model.setExaminerMakeupFieldOne(request.getParameter("examinerMakeupFieldOne").trim());
			}
			if(request.getParameter("examinerMakeupFieldTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupFieldTwo").trim())){
				model.setExaminerMakeupFieldTwo(request.getParameter("examinerMakeupFieldTwo").trim());
			}
			if(request.getParameter("makeupFieldDate").trim() != null && !"".equals(request.getParameter("makeupFieldDate").trim())){
				model.setFieldMakeupDate(Date.valueOf(request.getParameter("makeupFieldDate").trim()));
			}
			model.setMachineResult(request.getParameter("machineResult").trim());
			model.setExaminerMachineOne(request.getParameter("examinerMachineOne").trim());
			model.setExaminerMachineTwo(request.getParameter("examinerMachineTwo").trim());
			model.setMachineDate(Date.valueOf(request.getParameter("machineDate").trim()));
			if(request.getParameter("makeupMachineResult").trim() != null && !"".equals(request.getParameter("makeupMachineResult").trim())){
				model.setMachineMakeupResult(request.getParameter("makeupMachineResult").trim());
			}
			if(request.getParameter("examinerMakeupMachineOne").trim() != null && !"".equals(request.getParameter("examinerMakeupMachineOne").trim())){
				model.setExaminerMakeupMachineOne(request.getParameter("examinerMakeupMachineOne").trim());
			}
			if(request.getParameter("examinerMakeupMachineTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupMachineTwo").trim())){
				model.setExaminerMakeupMachineTwo(request.getParameter("examinerMakeupMachineTwo").trim());
			}
			if(request.getParameter("makeupMachineDate").trim() != null && !"".equals(request.getParameter("makeupMachineDate").trim())){
				model.setMachineMakeupDate(Date.valueOf(request.getParameter("makeupMachineDate").trim()));
			}
			model.setRoadResult(request.getParameter("roadResult").trim());
			model.setExaminerRoadOne(request.getParameter("examinerRoadOne").trim());
			model.setExaminerRoadTwo(request.getParameter("examinerRoadTwo").trim());
			model.setRoadDate(Date.valueOf(request.getParameter("roadDate").trim()));
			if(request.getParameter("makeupRoadResult").trim() != null && !"".equals(request.getParameter("makeupRoadResult").trim())){
				model.setRoadMakeupResult(request.getParameter("makeupRoadResult").trim());
			}
			if(request.getParameter("examinerMakeupRoadOne").trim() != null && !"".equals(request.getParameter("examinerMakeupRoadOne").trim())){
				model.setExaminerRoadOne(request.getParameter("examinerMakeupRoadOne").trim());
			}
			if(request.getParameter("examinerMakeupRoadTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupRoadTwo").trim())){
				model.setExaminerRoadTwo(request.getParameter("examinerMakeupRoadTwo").trim());
			}
			if(request.getParameter("makeupRoadDate").trim() != null && !"".equals(request.getParameter("makeupRoadDate").trim())){
				model.setRoadMakeupDate(Date.valueOf(request.getParameter("makeupRoadDate").trim()));
			}
			model.setAuditingPracticeResultFlag(Integer.valueOf(request.getParameter("auditingPracticeResultFlag").trim()));
			model.setRegionId(unit.getRegionid());
			model.setUnitId(user.getUnitid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			if(serviceManager.getPracticeExamService().addPracticeExam(model)){
				model = serviceManager.getPracticeExamService().findPracticeExamByStrId(model.getDriverStrInfoId());
				DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(model.getDriverStrInfoId());
				driverStrModel.setPracticeId(model.getPracticeId());
				driverStrModel.setPracticeFlag(model.getAuditingPracticeResultFlag());
				if(model.getAuditingPracticeResultFlag() == 1){
					driverStrModel.setStrState("6");
				}else{
					driverStrModel.setStrState("7");
				}
				if(serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStrModel)){
					DriverClassInfo modelClass = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.valueOf(Integer.valueOf(request.getParameter("classInfoId").trim())));
					if(model.getAuditingPracticeResultFlag() == 1){
						modelClass.setPracticeExamPassStrNum(modelClass.getTheoryExamPassStrNum()+1);
					}
					if(serviceManager.getDriverClassInfoService().updateDriverClassInfo(modelClass)){
						response.getWriter().write("{success: true,reason:'录入成绩成功'}");
					}
				}else{
					response.getWriter().write("{success: false,reason:'录入成绩失败'}");
				}
			}else{
				response.getWriter().write("{success: false,reason:'录入成绩失败'}");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void findPracticeExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("practiceId").trim().toString());
		PracticeExam res = serviceManager.getPracticeExamService().findPracticeExamById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void updatePracticeExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		PracticeExam model=serviceManager.getPracticeExamService().findPracticeExamById(Integer.valueOf(request.getParameter("practiceId").trim()));
		model.setDriverStrInfoId(Integer.valueOf(request.getParameter("driverStrInfoId").trim()));
		model.setDrivingLicenceNo(request.getParameter("drivingLicenceNo").trim());
		model.setDrillMasterId(request.getParameter("drillMasterId").trim());
		model.setDrillMasterCode(request.getParameter("drillMasterCode").trim());
		model.setDrillMasterDate(request.getParameter("drillMasterDate").trim());
		model.setDrillMasterMachine(request.getParameter("drillMasterMachine").trim());
		model.setDrillMasterAuditingIdeaFlag(Integer.valueOf(request.getParameter("drillMasterAuditingIdeaFlag").trim()));
		model.setUnitAuditingPracticeIdeaFlag(Integer.valueOf(request.getParameter("unitAuditingPracticeIdeaFlag").trim()));
		model.setDrivingLicenceAuditingIdeaFlag(Integer.valueOf(request.getParameter("drivingLicenceAuditingIdeaFlag").trim()));
		model.setOrgAuditingIdeaFlag(Integer.valueOf(request.getParameter("orgAuditingIdeaFlag").trim()));
		model.setFieldResult(request.getParameter("fieldResult").trim());
		model.setExaminerFieldOne(request.getParameter("examinerFieldOne").trim());
		model.setExaminerFieldTwo(request.getParameter("examinerFieldTwo").trim());
		model.setFieldDate(Date.valueOf(request.getParameter("fieldDate").trim()));
		if(request.getParameter("makeupFieldResult").trim() != null && !"".equals(request.getParameter("makeupFieldResult").trim())){
			model.setFieldMakeupResult(request.getParameter("makeupFieldResult").trim());
		}
		if(request.getParameter("examinerMakeupFieldOne").trim() != null && !"".equals(request.getParameter("examinerMakeupFieldOne").trim())){
			model.setExaminerMakeupFieldOne(request.getParameter("examinerMakeupFieldOne").trim());
		}
		if(request.getParameter("examinerMakeupFieldTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupFieldTwo").trim())){
			model.setExaminerMakeupFieldTwo(request.getParameter("examinerMakeupFieldTwo").trim());
		}
		if(request.getParameter("makeupFieldDate").trim() != null && !"".equals(request.getParameter("makeupFieldDate").trim())){
			model.setFieldMakeupDate(Date.valueOf(request.getParameter("makeupFieldDate").trim()));
		}
		model.setMachineResult(request.getParameter("machineResult").trim());
		model.setExaminerMachineOne(request.getParameter("examinerMachineOne").trim());
		model.setExaminerMachineTwo(request.getParameter("examinerMachineTwo").trim());
		model.setMachineDate(Date.valueOf(request.getParameter("machineDate").trim()));
		if(request.getParameter("makeupMachineResult").trim() != null && !"".equals(request.getParameter("makeupMachineResult").trim())){
			model.setMachineMakeupResult(request.getParameter("makeupMachineResult").trim());
		}
		if(request.getParameter("examinerMakeupMachineOne").trim() != null && !"".equals(request.getParameter("examinerMakeupMachineOne").trim())){
			model.setExaminerMakeupMachineOne(request.getParameter("examinerMakeupMachineOne").trim());
		}
		if(request.getParameter("examinerMakeupMachineTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupMachineTwo").trim())){
			model.setExaminerMakeupMachineTwo(request.getParameter("examinerMakeupMachineTwo").trim());
		}
		if(request.getParameter("makeupMachineDate").trim() != null && !"".equals(request.getParameter("makeupMachineDate").trim())){
			model.setMachineMakeupDate(Date.valueOf(request.getParameter("makeupMachineDate").trim()));
		}
		model.setRoadResult(request.getParameter("roadResult").trim());
		model.setExaminerRoadOne(request.getParameter("examinerRoadOne").trim());
		model.setExaminerRoadTwo(request.getParameter("examinerRoadTwo").trim());
		model.setRoadDate(Date.valueOf(request.getParameter("roadDate").trim()));
		if(request.getParameter("makeupRoadResult").trim() != null && !"".equals(request.getParameter("makeupRoadResult").trim())){
			model.setRoadMakeupResult(request.getParameter("makeupRoadResult").trim());
		}
		if(request.getParameter("examinerMakeupRoadOne").trim() != null && !"".equals(request.getParameter("examinerMakeupRoadOne").trim())){
			model.setExaminerRoadOne(request.getParameter("examinerMakeupRoadOne").trim());
		}
		if(request.getParameter("examinerMakeupRoadTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupRoadTwo").trim())){
			model.setExaminerRoadTwo(request.getParameter("examinerMakeupRoadTwo").trim());
		}
		if(request.getParameter("makeupRoadDate").trim() != null && !"".equals(request.getParameter("makeupRoadDate").trim())){
			model.setRoadMakeupDate(Date.valueOf(request.getParameter("makeupRoadDate").trim()));
		}
		model.setAuditingPracticeResultFlag(Integer.valueOf(request.getParameter("auditingPracticeResultFlag").trim()));
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(model.getDriverStrInfoId());
		driverStrModel.setPracticeId(model.getPracticeId());
		driverStrModel.setPracticeFlag(model.getAuditingPracticeResultFlag());
		if(model.getAuditingPracticeResultFlag() == 1){
			driverStrModel.setStrState("6");
		}else{
			driverStrModel.setStrState("7");
		}
		if(serviceManager.getPracticeExamService().updatePracticeExam(model)){
			response.getWriter().write("{success: true,reason:'修改成绩成功'}");
		}else{
			response.getWriter().write("{success: false,reason:'修改成绩失败'}");
		}
	}
	
	public void getPracticeExamMakeupInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String conditions = "";
		int practiceId = Integer.valueOf(request.getParameter("practiceId").trim());
		List<PracticeMakeupExamView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			conditions = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getPracticeExamService().getAllPracticeMakeupExamQuery(page, conditions, practiceId);
		}else{
			res = serviceManager.getPracticeExamService().getAllPracticeMakeupExam(page, conditions, practiceId);
		}
		
		JSONArray jsonItems = new JSONArray();
		for (PracticeMakeupExamView model : res) {
			jsonItems.add(JSONObject.fromObject(model));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void addPracticeMakeupExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		PracticeMakeupExam model=new PracticeMakeupExam();
		model.setPracticeId(Integer.valueOf(request.getParameter("practiceId").trim()));
		model.setDrillMasterMakeupId(request.getParameter("drillMasterMakeupId").trim());
		model.setDrillMasterMakeupCode(request.getParameter("drillMasterMakeupCode").trim());
		model.setDrillMasterMakeupDate(request.getParameter("drillMasterMakeupDate").trim());
		model.setDrillMasterMachineMakeup(request.getParameter("drillMasterMachineMakeup").trim());
		model.setDrillMasterAuditingIdeaMakeupFlag(Integer.valueOf(request.getParameter("drillMasterAuditingIdeaMakeupFlag").trim()));
		model.setUnitAuditingPracticeIdeaMakeupFlag(Integer.valueOf(request.getParameter("unitAuditingPracticeIdeaMakeupFlag").trim()));
		model.setDrivingLicenceAuditingIdeaMakeupFlag(Integer.valueOf(request.getParameter("drivingLicenceAuditingIdeaMakeupFlag").trim()));
		model.setOrgAuditingIdeaMakeupFlag(Integer.valueOf(request.getParameter("orgAuditingIdeaMakeupFlag").trim()));
		model.setFieldMakeupResult(request.getParameter("fieldMakeupResult").trim());
		model.setExaminerMakeupFieldOne(request.getParameter("examinerMakeupFieldOne").trim());
		model.setExaminerMakeupFieldTwo(request.getParameter("examinerMakeupFieldTwo").trim());
		model.setFieldMakeupDate(Date.valueOf(request.getParameter("fieldMakeupDate").trim()));
		model.setMachineMakeupResult(request.getParameter("machineMakeupResult").trim());
		model.setExaminerMakeupMachineOne(request.getParameter("examinerMakeupMachineOne").trim());
		model.setExaminerMakeupMachineTwo(request.getParameter("examinerMakeupMachineTwo").trim());
		model.setMachineMakeupDate(Date.valueOf(request.getParameter("machineMakeupDate").trim()));
		model.setRoadMakeupResult(request.getParameter("roadMakeupResult").trim());
		model.setExaminerMakeupRoadOne(request.getParameter("examinerMakeupRoadOne").trim());
		model.setExaminerMakeupRoadTwo(request.getParameter("examinerMakeupRoadTwo").trim());
		model.setRoadMakeupDate(Date.valueOf(request.getParameter("roadMakeupDate").trim()));
		model.setAuditingPracticeResultMakeupFlag(Integer.valueOf(request.getParameter("auditingPracticeResultMakeupFlag").trim()));
		model.setRegionId(unit.getRegionid());
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(serviceManager.getPracticeExamService().addPracticeMakeupExam(model)){
			DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(serviceManager.getPracticeExamService().findPracticeExamById(model.getPracticeId()).getDriverStrInfoId());
			driverStrModel.setPracticeFlag(model.getAuditingPracticeResultMakeupFlag());
			driverStrModel.setPracticeMakeUpNum(driverStrModel.getPracticeMakeUpNum()+1);
			if(model.getAuditingPracticeResultMakeupFlag() == 1){
				driverStrModel.setStrState("6");
				DriverClassInfo modelClass = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.valueOf(Integer.valueOf(request.getParameter("classInfoId").trim())));
				modelClass.setPracticeExamMakeUpPassStrNum(modelClass.getPracticeExamMakeUpPassStrNum()+1);
				serviceManager.getDriverClassInfoService().updateDriverClassInfo(modelClass);
			}else{
				driverStrModel.setStrState("7");
				serviceManager.getDriverClassTeamService().putOutUnPermit(Integer.valueOf(request.getParameter("classInfoId").trim()), String.valueOf(driverStrModel.getId()), 2);
			}
			if(serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStrModel)){
				response.getWriter().write("{success: true,reason:'录入成绩成功'}");
			}else{
				response.getWriter().write("{success: false,reason:'录入成绩失败'}");
			}
		}else{
			response.getWriter().write("{success: false,reason:'录入成绩失败'}");
		}
	}
}
