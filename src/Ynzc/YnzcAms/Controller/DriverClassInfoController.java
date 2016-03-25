package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.GetDate;
import Ynzc.YnzcAms.Model.DriverClassInfo;
import Ynzc.YnzcAms.Model.DriverClassTeam;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.DrivingLicence;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DriverClassInfoController extends BaseController{
	
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DriverClassInfoController.class);
	
	public void getDriverClassInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
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
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<DriverClassInfo> res = serviceManager.getDriverClassInfoService().getAllDriverClassInfo(page,condition,unit.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (DriverClassInfo model : res) {
			jsonItems.add(JSONObject.fromObject(model));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void addDriverClassInfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DriverClassInfo model=new DriverClassInfo();
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		model.setClassName(request.getParameter("className").trim());
		model.setDeclareFlag(0);
		model.setClassState(0);
		model.setClassStrNum(0);
		model.setUnitId(user.getUnitid());
		model.setRegionId(unit.getRegionid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(serviceManager.getDriverClassInfoService().findDriverClassInfoByName(model.getClassName(),unit.getRegionid()) == null){
			if(serviceManager.getDriverClassInfoService().addDriverClassInfo(model)){
				response.getWriter().write("{success: true,reason:'添加班级信息成功'}");
			}else{
				response.getWriter().write("{success:false,reason:'添加班级信息失败'}");
			}
		}else{
			response.getWriter().write("{success:false,reason:'班级名称重复'}");
		}
	}
	
	public void delDriverClassInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id").trim());
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		List<DriverStrInfo> list = serviceManager.getDriverStrInfoService().getDriverStrInfoInTeam(id, unit.getRegionid());
		DriverClassInfo driverClassInfo = serviceManager.getDriverClassInfoService().findDriverClassInfoById(id);
		try{
			for(DriverStrInfo str : list){
				if(str.getFosterType() == 1){
					serviceManager.getDriverClassTeamService().delDriverClassTeam(id, str.getId());
					serviceManager.getDriverStrInfoService().delDriverStrInfo(String.valueOf(str.getId()));
					serviceManager.getPeopleInfoService().delPeopleInfo(String.valueOf(str.getPeopleInfoId()));
					String bodyInfoId = String.valueOf(serviceManager.getPeopleInfoService().findPeopleInfoById(str.getPeopleInfoId()).getBodyInfoId());
					serviceManager.getBodyInfoService().delMoreBodyInfo(bodyInfoId);
				}else{
					serviceManager.getDriverClassTeamService().delDriverClassTeam(id, str.getId());
					serviceManager.getDriverStrInfoService().delDriverStrInfo(String.valueOf(str.getId()));
				}
			}
			if(serviceManager.getDriverClassInfoService().delDriverClassInfo(driverClassInfo)){
				response.getWriter().write("{success: true,reason:'删除成功'}");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			response.getWriter().write("{success:false,reason:'删除失败'}");
		}
	}
	
	public void updateDriverClassInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		DriverClassInfo model = serviceManager.getDriverClassInfoService().findDriverClassInfoById(id);
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(model.getClassName().equals(request.getParameter("className").trim())){
			if(!serviceManager.getDriverClassInfoService().updateDriverClassInfo(model)){
				response.getWriter().write("{success:false,reason:'更新班级信息失败'}");
			}else{
				response.getWriter().write("{success: true,reason:'更新班级信息成功'}");
			}
		}else{
			model.setClassName(request.getParameter("className").trim());
			if(serviceManager.getDriverClassInfoService().findDriverClassInfoByName(model.getClassName(),unit.getRegionid()) == null){
				if(serviceManager.getDriverClassInfoService().addDriverClassInfo(model)){
					response.getWriter().write("{success: true,reason:'更新班级信息成功'}");
				}else{
					response.getWriter().write("{success:false,reason:'更新班级信息失败'}");
				}
			}else{
				response.getWriter().write("{success:false,reason:'班级名称重复'}");
			}
		}
	}
	
	public void updateLeadDriverClassInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		DriverClassInfo model = serviceManager.getDriverClassInfoService().findDriverClassInfoById(id);
		model.setTheoryExamDate(Date.valueOf(request.getParameter("theoryExamDate").trim()));
		model.setPracticeExamDate(Date.valueOf(request.getParameter("practiceExamDate").trim()));
		model.setClassDate(Date.valueOf(request.getParameter("classDate").trim()));
		model.setUnitId(user.getUnitid());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if(model.getClassName().equals(request.getParameter("className").trim())){
			if(!serviceManager.getDriverClassInfoService().updateDriverClassInfo(model)){
				response.getWriter().write("{success:false,reason:'更新班级信息失败'}");
			}else{
				response.getWriter().write("{success: true,reason:'更新班级信息成功'}");
			}
		}else{
			model.setClassName(request.getParameter("className").trim());
			if(serviceManager.getDriverClassInfoService().findDriverClassInfoByName(model.getClassName(),unit.getRegionid()) == null){
				if(serviceManager.getDriverClassInfoService().addDriverClassInfo(model)){
					response.getWriter().write("{success: true,reason:'更新班级信息成功'}");
				}else{
					response.getWriter().write("{success:false,reason:'更新班级信息失败'}");
				}
			}else{
				response.getWriter().write("{success:false,reason:'班级名称重复'}");
			}
		}
	}
	
	public void addDriverClassStr(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		int driverClassInfoId = Integer.parseInt(request.getParameter("driverClassInfoId").trim());
		String driverStrInfoId = request.getParameter("driverStrInfoId").trim();
		String[] driverStrInfoIds = driverStrInfoId.split("@");
		try{
			for(String str : driverStrInfoIds){
				DriverClassTeam model = new DriverClassTeam();
				model.setDriverClassId(driverClassInfoId);
				model.setDriverStrInfoId(Integer.valueOf(str));
				model.setTheoryPermitFlag(0);
				model.setPracticePermitFlag(0);
				model.setUnitId(user.getUnitid());
				model.setWriteUserId(user.getId());
				model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
				if(serviceManager.getDriverClassTeamService().addDriverClassTeam(model)){
					DriverClassInfo driverClassInfoModel = new DriverClassInfo();
					driverClassInfoModel = serviceManager.getDriverClassInfoService().findDriverClassInfoById(driverClassInfoId);
					driverClassInfoModel.setClassStrNum(driverClassInfoModel.getClassStrNum()+1);
					serviceManager.getDriverClassInfoService().updateDriverClassInfo(driverClassInfoModel);
				}
			}
			response.getWriter().write("{success: true,reason:'班级添加学员成功'}");
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级添加学员失败'}");
			ex.printStackTrace();
		}
	}
	
	public void delDriverClassStr(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int driverClassInfoId = Integer.parseInt(request.getParameter("driverClassInfoId").trim());
		String driverStrInfoId = request.getParameter("driverStrInfoId").trim();
		String[] driverStrInfoIds = driverStrInfoId.split("@");
		try{
			if(serviceManager.getDriverStrInfoService().delDriverClassStrInfo(driverStrInfoId.replace("@", ","),driverClassInfoId)){
				DriverClassInfo driverClassInfoModel = new DriverClassInfo();
				driverClassInfoModel = serviceManager.getDriverClassInfoService().findDriverClassInfoById(driverClassInfoId);
				driverClassInfoModel.setClassStrNum(driverClassInfoModel.getClassStrNum()-driverStrInfoIds.length);
				if(serviceManager.getDriverClassInfoService().updateDriverClassInfo(driverClassInfoModel)){
					response.getWriter().write("{success: true,reason:'班级移除学员成功'}");
				}
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级移除学员失败'}");
			ex.printStackTrace();
		}
	}
	
	public void driverClassDeclare(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		boolean bool = true;
		try{
			String[] driverClassInfoIds = driverClassInfoId.replace(",", "@").split("@");
			for(String str : driverClassInfoIds){
				if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(Integer.valueOf(str))){
					response.getWriter().write("{success: true,reason:'该班级中还有学员未通过审核'}");
					bool = false;
					break;
				}else{
					if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(2,2, str)){
						response.getWriter().write("{success: true,reason:'班级审核失败'}");
						bool = false;
						break;
					}
				}
			}
			if(bool){
				response.getWriter().write("{success: true,reason:'班级审核成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级审核失败'}");
			ex.printStackTrace();
		}
	}
	
	public void driverClassUnDeclare(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		boolean bool = true;
		try{
			String[] driverClassInfoIds = driverClassInfoId.replace(",", "@").split("@");
			for(String str : driverClassInfoIds){
				if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(Integer.valueOf(str))){
					response.getWriter().write("{success: true,reason:'上报班级中还有学员未通过审核'}");
					bool = false;
					break;
				}else{
					if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(2,0, str)){
						response.getWriter().write("{success: true,reason:'班级审核失败'}");
						bool = false;
						break;
					}
				}
			}
			if(bool){
				response.getWriter().write("{success: true,reason:'班级审核成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级审核失败'}");
			ex.printStackTrace();
		}
	}
	
	public void driverClassTheoryExam(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		boolean bool = true;
		try{
			String[] driverClassInfoIds = driverClassInfoId.replace(",", "@").split("@");
			for(String str : driverClassInfoIds){
				if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(1,3, str)){
					response.getWriter().write("{success: true,reason:'班级审核失败'}");
					bool = false;
					break;
				}
			}
			if(bool){
				response.getWriter().write("{success: true,reason:'班级审核成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级审核失败'}");
			ex.printStackTrace();
		}
	}
	
	public void driverClassPracticeExam(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		boolean bool = true;
		try{
			String[] driverClassInfoIds = driverClassInfoId.replace(",", "@").split("@");
			for(String str : driverClassInfoIds){
				if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(1,4, str)){
					response.getWriter().write("{success: true,reason:'班级审核失败'}");
					bool = false;
					break;
				}
			}
			if(bool){
				response.getWriter().write("{success: true,reason:'班级审核成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级审核失败'}");
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public void driverClassPutOut(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		String[] ids =driverClassInfoId.replace(",", "@").split("@");
		try{
			String str = serviceManager.getDriverClassTeamService().getAllDriverStr(driverClassInfoId).replace(" ", "");
			if(serviceManager.getDriverClassInfoService().driverClassInfoDeclare(1,5, driverClassInfoId)){
				for(String s : ids){
					List<DriverStrInfoView> list = serviceManager.getDriverStrInfoService().getAllDriverStrInfoInTeam(Integer.valueOf(s),unit.getRegionid(),"DESC");
					if(list != null && list.size()>0){
						for(int i = 0 ; i < list.size() ; i ++){
							DriverStrInfoView driverStr = list.get(i);
							if(driverStr.getTheoryFlag() == 1 && driverStr.getPracticeFlag() == 1 && "6".equals(driverStr.getStrState())){
								DrivingLicence model = new DrivingLicence();
								model.setPeopleInfoId(driverStr.getPeopleInfoId());
								model.setDrivingLicenceNo(serviceManager.getPracticeExamService().findPracticeExamById(driverStr.getPracticeId()).getDrivingLicenceNo());
								model.setDrivingLicenceTypeId(Integer.valueOf(driverStr.getDrivingLicenceTypeId()));
								model.setMark(12);
								model.setDrivingLicenceFlag(0);
								model.setRegionId(unit.getRegionid());
								model.setUnitId(user.getUnitid());
								model.setWriteUserId(user.getId());
								model.setYear(GetDate.getNowYear());
								model.setWriteUserId(user.getId());
								model.setUserState(1);
								model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
								if(serviceManager.getDrivingLicenceService().findDrivingLicenceById(model.getPeopleInfoId(),model.getDrivingLicenceTypeId(),model.getDrivingLicenceNo())){
									if(serviceManager.getDrivingLicenceService().addDrivingLicence(model)){
										DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(driverStr.getId());
										if(driverStrModel.getDrivingLicenceTypeId().equals("1")){
											driverStrModel.setApplicationDate(GetDate.getNowDate());
										}
										driverStrModel.setStrState("8");
										serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStrModel);
									}else{
										break;
									}
								}
							}else{
								continue;
							}
						}
					}
				}
				response.getWriter().write("{success: true,reason:'班级审核成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级审核失败'}");
			ex.printStackTrace();
		}
	}
	
	public void driverClassPigeonhole(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		boolean bool = true;
		try{
			String[] driverClassInfoIds = driverClassInfoId.replace(",", "@").split("@");
			for(String str : driverClassInfoIds){
				if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(Integer.valueOf(str))){
					response.getWriter().write("{success: true,reason:'上报班级中还有学员未通过审核'}");
					bool = false;
					break;
				}else{
					if(!serviceManager.getDriverClassInfoService().driverClassInfoDeclare(1,6, str)){
						response.getWriter().write("{success: true,reason:'班级审核失败'}");
						bool = false;
						break;
					}
				}
			}
			if(bool){
				response.getWriter().write("{success: true,reason:'班级审核成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级审核失败'}");
			ex.printStackTrace();
		}
	}
	
	public void driverClassDeclareing(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverClassInfoId = request.getParameter("id").trim();
		boolean bool = true;
		try{
			String[] driverClassInfoIds = driverClassInfoId.split("@");
			for(String str : driverClassInfoIds){
				DriverClassInfo model = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.valueOf(str));
				model.setClassDate(DateTimeUtil.getNow());
				model.setTheoryExamDate(DateTimeUtil.addDate(10));
				model.setPracticeExamDate(DateTimeUtil.addDate(20));
				model.setClassState(1);
				if(!serviceManager.getDriverClassInfoService().updateDriverClassInfo(model)){
					response.getWriter().write("{success: true,reason:'班级上报失败'}");
					bool = false;
					break;
				}
			}
			if(bool){
				response.getWriter().write("{success: true,reason:'班级上报成功'}");
			}
		}catch(Exception ex){
			response.getWriter().write("{success:false,reason:'班级上报失败'}");
			ex.printStackTrace();
		}
	}
	
	public void getDriverClassInfoPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
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
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<DriverClassInfo> res = serviceManager.getDriverClassInfoService().getAllDriverClassInfoPass(page,condition,unit.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (DriverClassInfo model : res) {
			jsonItems.add(JSONObject.fromObject(model));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
}
