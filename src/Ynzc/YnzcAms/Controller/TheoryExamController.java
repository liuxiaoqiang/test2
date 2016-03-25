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
import Ynzc.YnzcAms.Model.TheoryExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExamView;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class TheoryExamController extends BaseController{
	private final static Logger log = Logger.getLogger(TheoryExamController.class);
	
	public void addTheoryExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		TheoryExam model=new TheoryExam();
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		model.setDriverStrInfoId(Integer.valueOf(request.getParameter("driverStrInfoId").trim()));
		model.setTheoryResult(request.getParameter("theoryResult").trim());
		model.setExaminerOne(request.getParameter("examinerOne").trim());
		model.setExaminerTwo(request.getParameter("examinerTwo").trim());
		model.setTheoryDate(Date.valueOf(request.getParameter("theoryDate").trim()));
		if(request.getParameter("theoryMakeupResult").trim() != null && !"".equals(request.getParameter("theoryMakeupResult").trim())){
			model.setTheoryMakeupResult(request.getParameter("theoryMakeupResult").trim());
		}
		if(request.getParameter("examinerMakeupOne").trim() != null && !"".equals(request.getParameter("examinerMakeupOne").trim())){
			model.setExaminerMakeupOne(request.getParameter("examinerMakeupOne").trim());
		}
		if(request.getParameter("examinerMakeupTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupTwo").trim())){
			model.setExaminerMakeupTwo(request.getParameter("examinerMakeupTwo").trim());
		}
		if(request.getParameter("theoryMakeupDate").trim() != null && !"".equals(request.getParameter("theoryMakeupDate").trim())){
			model.setTheoryMakeupDate(Date.valueOf(request.getParameter("theoryMakeupDate").trim()));
		}
		model.setAuditingTheoryIdeaFlag(Integer.valueOf(request.getParameter("auditingTheoryIdeaFlag").trim()));
		model.setAuditingTheoryResultFlag(Integer.valueOf(request.getParameter("auditingTheoryResultFlag").trim()));
		model.setTransactor(request.getParameter("transactor").trim());
		model.setUnitTheoryAuditingIdeaFlag(Integer.valueOf(request.getParameter("unitTheoryAuditingIdeaFlag").trim()));
		model.setUnitTheoryAuditingIdeaDate(Date.valueOf(request.getParameter("unitTheoryAuditingIdeaDate").trim()));
		model.setAuditingTheoryResultFlag(Integer.valueOf(request.getParameter("auditingTheoryResultFlag").trim()));
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setRegionId(unit.getRegionid());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(serviceManager.getTheoryExamService().addTheoryExam(model)){
			DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(model.getDriverStrInfoId());
			driverStrModel.setTheoryId(model.getTheoryId());
			driverStrModel.setTheoryFlag(model.getAuditingTheoryResultFlag());
			if(model.getAuditingTheoryResultFlag() == 1){
				driverStrModel.setStrState("5");
			}else{
				driverStrModel.setStrState("6");
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
	
	public void findTheoryExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("theoryId").trim().toString());
		TheoryExam res = serviceManager.getTheoryExamService().findTheoryExamById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void updateTheoryExam(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		TheoryExam model=serviceManager.getTheoryExamService().findTheoryExamById(Integer.valueOf(request.getParameter("theoryId").trim()));
		model.setTheoryResult(request.getParameter("theoryResult").trim());
		model.setExaminerOne(request.getParameter("examinerOne").trim());
		model.setExaminerTwo(request.getParameter("examinerTwo").trim());
		model.setTheoryDate(Date.valueOf(request.getParameter("theoryDate").trim()));
		if(request.getParameter("theoryMakeupResult").trim() != null && !"".equals(request.getParameter("theoryMakeupResult").trim())){
			model.setTheoryMakeupResult(request.getParameter("theoryMakeupResult").trim());
		}
		if(request.getParameter("examinerMakeupOne").trim() != null && !"".equals(request.getParameter("examinerMakeupOne").trim())){
			model.setExaminerMakeupOne(request.getParameter("examinerMakeupOne").trim());
		}
		if(request.getParameter("examinerMakeupTwo").trim() != null && !"".equals(request.getParameter("examinerMakeupTwo").trim())){
			model.setExaminerMakeupTwo(request.getParameter("examinerMakeupTwo").trim());
		}
		if(request.getParameter("theoryMakeupDate").trim() != null && !"".equals(request.getParameter("theoryMakeupDate").trim())){
			model.setTheoryMakeupDate(Date.valueOf(request.getParameter("theoryMakeupDate").trim()));
		}
		model.setAuditingTheoryIdeaFlag(Integer.valueOf(request.getParameter("auditingTheoryIdeaFlag").trim()));
		model.setAuditingTheoryResultFlag(Integer.valueOf(request.getParameter("auditingTheoryResultFlag").trim()));
		model.setTransactor(request.getParameter("transactor").trim());
		model.setUnitTheoryAuditingIdeaFlag(Integer.valueOf(request.getParameter("unitTheoryAuditingIdeaFlag").trim()));
		model.setUnitTheoryAuditingIdeaDate(Date.valueOf(request.getParameter("unitTheoryAuditingIdeaDate").trim()));
		model.setAuditingTheoryResultFlag(Integer.valueOf(request.getParameter("auditingTheoryResultFlag").trim()));
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(model.getDriverStrInfoId());
		driverStrModel.setTheoryId(model.getTheoryId());
		driverStrModel.setTheoryFlag(model.getAuditingTheoryResultFlag());
		if(model.getAuditingTheoryResultFlag() == 1){
			driverStrModel.setStrState("5");
		}else{
			driverStrModel.setStrState("6");
		}
		if(serviceManager.getTheoryExamService().updateTheoryExam(model)){
			response.getWriter().write("{success: true,reason:'修改成绩成功'}");
		}else{
			response.getWriter().write("{success: false,reason:'修改成绩失败'}");
		}
	}
	
	public void getTheoryExamMakeupInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<TheoryMakeupExamView> res = null;
		int theoryId = Integer.valueOf(request.getParameter("theoryId").trim());
		if (fields != null && query != null && !"".equals(query)) {
			conditions = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getTheoryExamService().getAllTheoryMakeupExamQuery(page, conditions, theoryId);
		}else{
			res = serviceManager.getTheoryExamService().getAllTheoryMakeupExam(page, conditions, theoryId);
		}
		JSONArray jsonItems = new JSONArray();
		for (TheoryMakeupExamView model : res) {
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
	
	public void addTheoryExamMakeup(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		TheoryMakeupExam model=new TheoryMakeupExam();
		model.setTheoryId(Integer.valueOf(request.getParameter("theoryId").trim()));
		model.setTheoryMakeupResult(request.getParameter("makeupResult").trim());
		model.setExaminerTheoryMakeupOne(request.getParameter("examinerMakeupOne").trim());
		model.setExaminerTheoryMakeupTwo(request.getParameter("examinerMakeupTwo").trim());
		model.setTheoryMakeupDate(Date.valueOf(request.getParameter("makeupDate").trim()));
		model.setAuditingIdeaTheoryMakeupFlag(Integer.valueOf(request.getParameter("auditingTheoryIdeaMakeupFlag").trim()));
		model.setTransactorMakeup(request.getParameter("transactorMakeup").trim());
		model.setUnitAuditingIdeaTheoryMakeupFlag(Integer.valueOf(request.getParameter("unitTheoryAuditingIdeaMakeupFlag").trim()));
		model.setUnitAuditingIdeaTheoryMakeupDate(Date.valueOf(request.getParameter("unitTheoryAuditingIdeaMakeupDate").trim()));
		model.setAuditingResultTheoryMakeupFlag(Integer.valueOf(request.getParameter("auditingTheoryResultMakeupFlag").trim()));
		model.setRegionId(unit.getRegionid());
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(serviceManager.getTheoryExamService().addTheoryMakeupExam(model)){
			DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(serviceManager.getTheoryExamService().findTheoryExamById(model.getTheoryId()).getDriverStrInfoId());
			driverStrModel.setTheoryFlag(model.getAuditingResultTheoryMakeupFlag());
			driverStrModel.setTheoryMakeUpNum(driverStrModel.getTheoryMakeUpNum()+1);
			if(model.getAuditingResultTheoryMakeupFlag() == 1){
				driverStrModel.setStrState("4");
				DriverClassInfo modelClass = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.valueOf(Integer.valueOf(request.getParameter("classInfoId").trim())));
				modelClass.setTheoryExamMakeUpPassStrNum(modelClass.getTheoryExamMakeUpPassStrNum()+1);
				serviceManager.getDriverClassInfoService().updateDriverClassInfo(modelClass);
			}else{
				driverStrModel.setStrState("5");
				serviceManager.getDriverClassTeamService().putOutUnPermit(Integer.valueOf(request.getParameter("classInfoId").trim()), String.valueOf(driverStrModel.getId()), 1);
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
	
	public void updateTheoryExamMakeup(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		TheoryMakeupExam model=serviceManager.getTheoryExamService().findTheoryMakeupExamById(Integer.valueOf(request.getParameter("theoryId").trim()));
		model.setTheoryMakeupResult(request.getParameter("makeupResult").trim());
		model.setExaminerTheoryMakeupOne(request.getParameter("examinerMakeupOne").trim());
		model.setExaminerTheoryMakeupTwo(request.getParameter("examinerMakeupTwo").trim());
		model.setTheoryMakeupDate(Date.valueOf(request.getParameter("makeupDate").trim()));
		model.setAuditingIdeaTheoryMakeupFlag(Integer.valueOf(request.getParameter("auditingTheoryIdeaMakeupFlag").trim()));
		model.setTransactorMakeup(request.getParameter("transactorMakeup").trim());
		model.setUnitAuditingIdeaTheoryMakeupFlag(Integer.valueOf(request.getParameter("unitTheoryAuditingIdeaMakeupFlag").trim()));
		model.setUnitAuditingIdeaTheoryMakeupDate(Date.valueOf(request.getParameter("unitTheoryAuditingIdeaMakeupDate").trim()));
		model.setAuditingResultTheoryMakeupFlag(Integer.valueOf(request.getParameter("auditingTheoryResultMakeupFlag").trim()));
		model.setRegionId(unit.getRegionid());
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(serviceManager.getTheoryExamService().addTheoryMakeupExam(model)){
			DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(serviceManager.getTheoryExamService().findTheoryExamByStrId(model.getTheoryId()).getDriverStrInfoId());
			driverStrModel.setTheoryId(model.getTheoryId());
			driverStrModel.setTheoryFlag(model.getAuditingResultTheoryMakeupFlag());
			if(model.getAuditingResultTheoryMakeupFlag() == 1){
				driverStrModel.setStrState("5");
			}else{
				driverStrModel.setStrState("6");
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
