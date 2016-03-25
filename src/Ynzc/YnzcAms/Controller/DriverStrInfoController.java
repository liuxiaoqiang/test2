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
import Ynzc.YnzcAms.Model.DriverClassStrView;
import Ynzc.YnzcAms.Model.DriverClassTeam;
import Ynzc.YnzcAms.Model.DriverStrInfo;
import Ynzc.YnzcAms.Model.DriverStrInfoView;
import Ynzc.YnzcAms.Model.DriverStrParticularView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PeopleInfo;
import Ynzc.YnzcAms.Model.PracticeExam;
import Ynzc.YnzcAms.Model.TheoryExam;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DriverStrInfoController extends BaseController {
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(DriverStrInfoController.class);
	
	public void getDriverStrParticular(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
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
		List<DriverStrParticularView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDriverStrInfoService().getAllDriverStrParticularQuery(page,condition,unit.getRegionid());
		}else{
			res = serviceManager.getDriverStrInfoService().getAllDriverStrParticular(page,condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DriverStrParticularView model : res) {
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

	public void getDriverStrInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
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
		List<DriverStrInfoView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoQuery(page, condition,unit.getRegionid());
		}else{
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfo(page, condition,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DriverStrInfoView model : res) {
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

	public void getAllDriverStrInfoByExaminationUnPass(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String start = null;
		String limit = null;
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
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
		List<DriverStrInfoView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoByExaminationPassQuery(page, condition, 0,unit.getRegionid());
		}else{
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoByExaminationPass(page, condition, 0,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DriverStrInfoView model : res) {
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

	public void getAllDriverStrInfoByExaminationPass(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String start = null;
		String limit = null;
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
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
		List<DriverStrInfoView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoByExaminationPassQuery(page, condition, 1,unit.getRegionid());
		}else{
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoByExaminationPass(page, condition, 1,unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DriverStrInfoView model : res) {
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

	public void addDriverStrInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DriverStrInfo model = new DriverStrInfo();
		DriverClassTeam classTeamModel = new DriverClassTeam();
		DriverClassInfo driverClassInfoModel = new DriverClassInfo();
		User user = (User) request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		try{
			if (request.getParameter("fosterType").trim().equals("新训")) {
				model.setFosterType(1);
			} else {
				model.setFosterType(2);
			}
			model.setPeopleInfoId(Integer.valueOf(request.getParameter("peopleInfoId").trim()));
			model.setDrivingLicenceTypeId(request.getParameter("drivingLicenceTypeId").trim());
			model.setApplicationAddress(request.getParameter("applicationAddress").trim());
			PeopleInfo peopleModel = serviceManager.getPeopleInfoService().findPeopleInfoById(Integer.valueOf(request.getParameter("peopleInfoId").trim()));
			model.setExaminationCode(serviceManager.getDriverStrInfoService().createNo(peopleModel.getIdCard(), 2,unit.getRegionid()));
			model.setApplicationFlag(-1);
			model.setStrState("0");
			model.setTheoryId(0);
			model.setTheoryFlag(-1);
			model.setPracticeId(0);
			model.setPracticeFlag(-1);
			model.setRegionId(unit.getRegionid());
			model.setUnitId(user.getUnitid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			if (serviceManager.getDriverStrInfoService().addDriverStrInfo(model)) {
				classTeamModel.setDriverClassId(Integer.parseInt(request.getParameter("driverClassInfoId").trim()));
				classTeamModel.setDriverStrInfoId(Integer.valueOf(model.getId()));
				classTeamModel.setTheoryPermitFlag(0);
				classTeamModel.setPracticePermitFlag(0);
				classTeamModel.setUnitId(user.getUnitid());
				classTeamModel.setWriteUserId(user.getId());
				classTeamModel.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
				classTeamModel.setRegionId(unit.getRegionid());
				if(serviceManager.getDriverClassTeamService().addDriverClassTeam(classTeamModel)){
					driverClassInfoModel = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.parseInt(request.getParameter("driverClassInfoId").trim()));
					driverClassInfoModel.setClassStrNum(driverClassInfoModel.getClassStrNum()+1);
					if(serviceManager.getDriverClassInfoService().updateDriverClassInfo(driverClassInfoModel)){
						response.getWriter().write("{success: true,reason:'添加学员信息成功'}");
					}else{
						serviceManager.getDriverClassTeamService().delDriverClassTeam(classTeamModel);
						serviceManager.getDriverStrInfoService().delDriverStrInfo(model);
						response.getWriter().write("{success: true,reason:'添加学员信息失败'}");
					}
				}else{
					serviceManager.getDriverStrInfoService().delDriverStrInfo(model);
					response.getWriter().write("{success: true,reason:'添加学员信息失败'}");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			response.getWriter().write("{success: true,reason:'添加学员信息失败'}");
		}
	}
	
	public void createDriverStrArchivesNo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("driverStrId").trim());
		User user = (User) request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		DriverStrInfo model = serviceManager.getDriverStrInfoService().findDriverStrInfoById(id);
		model.setDrivingLicenceTypeId(request.getParameter("drivingLicenceTypeId").trim());
		PeopleInfo peopleModel = serviceManager.getPeopleInfoService().findPeopleInfoById(Integer.valueOf(request.getParameter("peopleInfoId").trim()));
		model.setArchivesNo(serviceManager.getDriverStrInfoService().createNo(peopleModel.getIdCard(), 1,unit.getRegionid()));
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if (!serviceManager.getDriverStrInfoService().updateDriverStrInfo(model)) {
			response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
		} else {
			response.getWriter().write("{success: true,reason:'更新学员信息成功'}");
		}
	}

	public void delDriverStrInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int driverClassInfoId = Integer.valueOf(request.getParameter("driverClassInfoId").trim());
		int driverStrInfoId = Integer.valueOf(request.getParameter("driverStrInfoId").trim());
		int peopleInfoId = Integer.valueOf(request.getParameter("peopleInfoId").trim());
		int bodyInfoId = Integer.valueOf(request.getParameter("bodyInfoId").trim());
		boolean isDelete = true;
		try{
			if (serviceManager.getDriverStrInfoService().delDriverStrCheck(driverStrInfoId)) {
				if (!serviceManager.getDriverStrInfoService().delDriverStrInfo(String.valueOf(driverStrInfoId)) 
						&& !serviceManager.getDriverClassTeamService().delDriverClassTeam(driverClassInfoId, driverStrInfoId) 
						&& !serviceManager.getPeopleInfoService().delPeopleInfo(String.valueOf(peopleInfoId)) 
						&& !serviceManager.getBodyInfoService().delMoreBodyInfo(String.valueOf(bodyInfoId))) {
					isDelete = false;
				}else{
					DriverClassInfo driverClassInfoModel = new DriverClassInfo();
					driverClassInfoModel = serviceManager.getDriverClassInfoService().findDriverClassInfoById(driverClassInfoId);
					driverClassInfoModel.setClassStrNum(driverClassInfoModel.getClassStrNum()-1);
					if(!serviceManager.getDriverClassInfoService().updateDriverClassInfo(driverClassInfoModel)){
						isDelete = false;
					}
				}
			} else {
				if (!serviceManager.getDriverStrInfoService().delDriverStrInfo(String.valueOf(driverStrInfoId)) 
						&& !serviceManager.getDriverClassTeamService().delDriverClassTeam(driverClassInfoId, driverStrInfoId)) {
					isDelete = false;
				}else{
					DriverClassInfo driverClassInfoModel = new DriverClassInfo();
					driverClassInfoModel = serviceManager.getDriverClassInfoService().findDriverClassInfoById(driverClassInfoId);
					driverClassInfoModel.setClassStrNum(driverClassInfoModel.getClassStrNum()-1);
					if(!serviceManager.getDriverClassInfoService().updateDriverClassInfo(driverClassInfoModel)){
						isDelete = false;
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if (isDelete) {
			response.getWriter().write("{success: true,reason:'删除成功'}");
		} else {
			response.getWriter().write("{success: true,reason:'删除失败'}");
		}
	}

	public void updateDriverStrInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id").trim());
		User user = (User) request.getSession().getAttribute("user");
		DriverStrInfo model = serviceManager.getDriverStrInfoService().findDriverStrInfoById(id);
		model.setDrivingLicenceTypeId(request.getParameter("drivingLicenceTypeId").trim());
		model.setYear(GetDate.getNowYear());
		model.setWriteUserId(user.getId());
		model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
		if (!serviceManager.getDriverStrInfoService()
				.updateDriverStrInfo(model)) {
			response.getWriter().write("{success:false,reason:'更新学员信息失败'}");
		} else {
			response.getWriter().write("{success: true,reason:'更新学员信息成功'}");
		}
	}

	public void getDriverStrInfoById(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id").trim().toString());
		DriverStrInfo res = serviceManager.getDriverStrInfoService()
				.findDriverStrInfoById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void getDriverType(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id").trim());
		List<DriverStrInfo> driverStrList = serviceManager.getDriverStrInfoService().findDriverStrInfoByPeopleInfoId(id);
		String str = "";
		if (driverStrList != null && driverStrList.size() > 0) {
			for (DriverStrInfo dsi : driverStrList) {
				if ("".equals(str)) {
					str = dsi.getDrivingLicenceTypeId();
				} else {
					str = str + "/" + dsi.getDrivingLicenceTypeId();
				}
			}
		}
		response.getWriter().write("{success:true,reason:'" + str + "'}");
	}

	@SuppressWarnings("unused")
	public void driverStrExaminationPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String ids = request.getParameter("id").trim().replace("@", ",");
		User user=(User)request.getSession().getAttribute("user");
		try {
			String[] driverStrInfoIds = request.getParameter("id").trim().split("@");
			for(String str : driverStrInfoIds){
				DriverStrInfo driverStr= serviceManager.getDriverStrInfoService().findDriverStrInfoById(Integer.valueOf(str));
				driverStr.setApplicationFlag(1);
				driverStr.setApplicationUserId(user.getId());
				driverStr.setApplicationDate(GetDate.stringToDate(GetDate.getStringDate()));
				if(driverStr.getStrState().indexOf("@")>0){
					driverStr.setStrState(driverStr.getStrState().split("@")[0]);
				}else{
					driverStr.setStrState("1");
				}
				serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStr);
			}
			response.getWriter().write("{success: true,reason:'审查成功'}");
		} catch (Exception ex) {
			response.getWriter().write("{success:false,reason:'审查失败'}");
		}
	}
	
	@SuppressWarnings("unused")
	public void driverStrExaminationUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String ids = request.getParameter("id").trim().replace("@", ",");
		User user=(User)request.getSession().getAttribute("user");
		try {
			String[] driverStrInfoIds = request.getParameter("id").trim().split("@");
			for(String str : driverStrInfoIds){
				DriverStrInfo driverStr= serviceManager.getDriverStrInfoService().findDriverStrInfoById(Integer.valueOf(str));
				driverStr.setApplicationFlag(1);
				driverStr.setApplicationUserId(user.getId());
				driverStr.setApplicationDate(GetDate.stringToDate(GetDate.getStringDate()));
				driverStr.setStrState(driverStr.getStrState().replace("9", "10"));
				serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStr);
			}
			response.getWriter().write("{success: true,reason:'审查成功'}");
		} catch (Exception ex) {
			response.getWriter().write("{success:false,reason:'审查失败'}");
		}
	}
	
	@SuppressWarnings("unused")
	public void driverStrExaminationUnPass(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String ids = request.getParameter("id").trim().replace("@", ",");
		User user=(User)request.getSession().getAttribute("user");
		try {
			String[] driverStrInfoIds = request.getParameter("id").trim().split("@");
			for(String str : driverStrInfoIds){
				DriverStrInfo driverStr= serviceManager.getDriverStrInfoService().findDriverStrInfoById(Integer.valueOf(str));
				driverStr.setStrState(driverStr.getStrState()+"@"+9);
				serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStr);
			}
			response.getWriter().write("{success: true,reason:'审查成功'}");
		} catch (Exception ex) {
			ex.printStackTrace();
			response.getWriter().write("{success:false,reason:'审查失败'}");
		}
	}

	public void getAllDriverStrInfoInTeam(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		List<DriverStrInfoView> res = null;
		if (fields != null && query != null  && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoInTeamQuery(page,condition,Integer.parseInt(request.getParameter("driverClassInfoId").trim()),unit.getRegionid());
		}else{
			res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoInTeam(page,condition,Integer.parseInt(request.getParameter("driverClassInfoId").trim()),unit.getRegionid());
		}
		JSONArray jsonItems = new JSONArray();
		for (DriverStrInfoView model : res) {
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
	
	public void getAllDriverStrInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int classInfoId = Integer.parseInt(request.getParameter("driverClassId").trim());
		List<DriverStrInfoView> res = serviceManager.getDriverStrInfoService().getAllDriverStrInfoInTeam(classInfoId,unit.getRegionid(),"ASC");
		String result="{fieldSet:[";
		String id = "";
		for(int i = 0; i < res.size(); i++){
			DriverStrInfoView model = res.get(i);
			String type = "";
			if(model.getFosterType().equals("1")){
				type = "新训";
			}else{
				type = "增驾";
			}
			if(id.equals("")){
				id += model.getId()+"@"+model.getPeopleName();
			}else{
				id += "#"+model.getId()+"@"+model.getPeopleName();
			}
			result+="{columnWidth:1,labelWidth:60,height:'auto',baseCls:'x-plain',layout:'column',items:[" +
					"{columnWidth:.05,labelWidth:50,height:'auto',baseCls:'x-plain',layout:'form',items:[{xtype:'label',text:'"+type+"'}]}," +
					"{columnWidth:.09,labelWidth:50,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'"+model.getExaminationCode()+"',xtype:'label',text:'"+model.getExaminationCode()+"'}]}," +
					"{columnWidth:.05,labelWidth:50,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'"+model.getId()+"',xtype:'label',html:'"+model.getPeopleName()+"'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'theory@"+model.getId()+"', xtype:'textfield',hideLabel:true,labelSeparator:'',anchor:'98%'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',"+ "items:[{id:'field@"+model.getId()+"',xtype:'textfield',hideLabel:true,labelSeparator:'',value:'合格',anchor:'98%'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'fieldMakeup@"+model.getId()+"',xtype:'textfield',hideLabel:true,labelSeparator:'',anchor:'98%'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'machine@"+model.getId()+"', xtype:'textfield',hideLabel:true,labelSeparator:'',value:'合格',anchor:'98%'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'machineMakeup@"+model.getId()+"',xtype:'textfield', hideLabel:true,labelSeparator:'', anchor:'98%' }]}," +
					"{columnWidth:.1, labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form'," + "items:[{id:'road@"+model.getId()+"',xtype:'textfield',hideLabel:true,labelSeparator:'',anchor:'98%'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'roadMakeup@"+model.getId()+"',xtype:'textfield',hideLabel:true,labelSeparator:'',anchor:'98%'}]}," +
					"{columnWidth:.1,labelWidth:1,height:'auto',baseCls:'x-plain',layout:'form',items:[{id:'result@"+model.getId()+"',xtype:'combo',displayField:'display',valueField:'value',value: 1,labelSeparator:'',typeAhead:true,mode:'local',editable:false,selectOnFoucs:true,triggerAction:'all',store:Ynzc.manage.examResultStore,emptyText:'考试结论',anchor:'99%'}]}]},";
		}
		if("{fieldSet:[".equals(result)){
			result+="],id:''}";
		}else{
			result=result.substring(0,result.length()-1);
			result+="],id:'"+id+"'}";
		}
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	public void getAllDriverClassStr(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		List<DriverClassStrView> res = null;
		if (fields != null && query != null && !"".equals(query)) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
			res = serviceManager.getDriverClassInfoService().getAllDriverClassInfoByDriverClassIdQuery(page,condition,Integer.parseInt(request.getParameter("driverClassInfoId").trim()));
		}else{
			res = serviceManager.getDriverClassInfoService().getAllDriverClassInfoByDriverClassId(page,condition,Integer.parseInt(request.getParameter("driverClassInfoId").trim()));
		}
		JSONArray jsonItems = new JSONArray();
		for (DriverClassStrView model : res) {
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

	public void putOutPermitTheory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int driverClassId = Integer.valueOf(request.getParameter(
				"driverClassId").trim().toString());
		String driverStrId = (String) request.getParameter("driverStrId")
				.trim();
		if (serviceManager.getDriverClassTeamService().putOutPermit(driverClassId, driverStrId, 1)) {
			serviceManager.getDriverClassTeamService().updateDriverStrState(1, 2,driverStrId);
			response.getWriter().write("{success:true,reason:'准考证发放成功'}");
		} else {
			response.getWriter().write("{success:false,reason:'准考证发放失败'}");
		}
	}

	public void putOutPermitPractice(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int driverClassId = Integer.valueOf(request.getParameter("driverClassId").trim().toString());
		String driverStrId = (String) request.getParameter("driverStrId").trim();
		if (serviceManager.getDriverClassTeamService().putOutPermit(driverClassId, driverStrId, 2)) {
			response.getWriter().write("{success:true,reason:'准考证发放成功'}");
		} else {
			response.getWriter().write("{success:false,reason:'准考证发放失败'}");
		}
	}

	public void driverClassStrPigeonhole(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverStrId = (String) request.getParameter("driverStrId").trim();
		String[] driverStrIds = driverStrId.split("@");
		User user = (User) request.getSession().getAttribute("user");
		for(String str : driverStrIds){
			DriverStrInfo driverStr= serviceManager.getDriverStrInfoService().findDriverStrInfoById(Integer.valueOf(str));
			driverStr.setPigeonholeUserId(user.getId());
			serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStr);
		}
		if (serviceManager.getDriverStrInfoService().driverClassStrPigeonhole(driverStrId.replace("@", ","),1)) {
			response.getWriter().write("{success:true,reason:'操作成功'}");
		} else {
			response.getWriter().write("{success:false,reason:'归档失败'}");
		}
	}
	
	public void driverClassStrUnPigeonhole(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String driverStrId = (String) request.getParameter("driverStrId").trim();
		String[] driverStrIds = driverStrId.replace(",", "@").split("@");
		User user = (User) request.getSession().getAttribute("user");
		for(String str : driverStrIds){
			DriverStrInfo driverStr= serviceManager.getDriverStrInfoService().findDriverStrInfoById(Integer.valueOf(str));
			driverStr.setPigeonholeUserId(user.getId());
			serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStr);
		}
		if (serviceManager.getDriverStrInfoService().driverClassStrPigeonhole(driverStrId,0)) {
			response.getWriter().write("{success:true,reason:'操作成功'}");
		} else {
			response.getWriter().write("{success:false,reason:'归档失败'}");
		}
	}
	
	public void writeResult(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String classInfoId = (String) request.getParameter("classInfoId").trim();
		String theorys = (String) request.getParameter("theorys").trim();
		String fields = (String) request.getParameter("fields").trim();
		String machines = (String) request.getParameter("machines").trim();
		String roadsMakeup = (String) request.getParameter("roadsMakeup").trim();
		String fieldsMakeup = (String) request.getParameter("fieldsMakeup").trim();
		String machinesMakeup = (String) request.getParameter("machinesMakeup").trim();
		String roads = (String) request.getParameter("roads").trim();
		String theoryExaminerOne = (String) request.getParameter("theoryExaminerOne").trim();
		String theoryExaminerTwo = (String) request.getParameter("theoryExaminerTwo").trim();
		String theoryDate = (String) request.getParameter("theoryDate").trim();
		String fieldExaminerOne = (String) request.getParameter("fieldExaminerOne").trim();
		String fieldExaminerTwo = (String) request.getParameter("fieldExaminerTwo").trim();
		String fieldDate = (String) request.getParameter("fieldDate").trim();
		String machineExaminerOne = (String) request.getParameter("machineExaminerOne").trim();
		String machineExaminerTwo = (String) request.getParameter("machineExaminerTwo").trim();
		String machineDate = (String) request.getParameter("machineDate").trim();
		String roadExaminerOne = (String) request.getParameter("roadExaminerOne").trim();
		String roadExaminerTwo = (String) request.getParameter("roadExaminerTwo").trim();
		String roadDate = (String) request.getParameter("roadDate").trim();
		String drillMasterId = (String) request.getParameter("drillMasterId").trim();
		String drillMasterCode = (String) request.getParameter("drillMasterCode").trim();
		String drillMasterDate = (String) request.getParameter("drillMasterDate").trim();
		String drillMasterMachine = (String) request.getParameter("drillMasterMachine").trim();
		String drillMasterAuditingIdeaFlag = (String) request.getParameter("drillMasterAuditingIdeaFlag").trim();
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		String[] theoryStr = theorys.split("#");
		int tNum = 0;
		int pNum = 0;
		String[] fieldsResult = fields.split("#");
		String[] machinesResult = machines.split("#");
		String[] roadsResult = roads.split("#");
		String[] fieldsMakeupResult = fieldsMakeup.split("#");
		String[] machinesMakeupResult = machinesMakeup.split("#");
		String[] roadsMakeupResult = roadsMakeup.split("#");
		for(int i = 0; i < theoryStr.length; i++){
			int strId = Integer.valueOf(theoryStr[i].split("@")[0]);
			String result = theoryStr[i].split("@")[1];
			int conclusion = Integer.valueOf(theoryStr[i].split("@")[2]);
			String fieldResult = fieldsResult[i].split("@")[1];
			String machineResult = machinesResult[i].split("@")[1];
			String roadResult = roadsResult[i].split("@")[1];
			String fieldMakeupResult = fieldsMakeupResult[i].split("@")[1];
			String machineMakeupResult = machinesMakeupResult[i].split("@")[1];
			String roadMakeupResult = roadsMakeupResult[i].split("@")[1];
			TheoryExam model=new TheoryExam();
			model.setDriverStrInfoId(strId);
			model.setTheoryResult(result);
			model.setExaminerOne(theoryExaminerOne);
			model.setExaminerTwo(theoryExaminerTwo);
			model.setTheoryDate(Date.valueOf(theoryDate));
			if(conclusion == 1 || conclusion == 3){
				model.setAuditingTheoryResultFlag(1);
				model.setAuditingTheoryIdeaFlag(1);
				model.setUnitTheoryAuditingIdeaFlag(1);
			}else{
				model.setAuditingTheoryResultFlag(0);
				model.setAuditingTheoryIdeaFlag(0);
				model.setUnitTheoryAuditingIdeaFlag(0);
			}
			
			model.setTransactor(user.getUsername());
			model.setUnitTheoryAuditingIdeaDate(DateTimeUtil.getNow());
			model.setUnitId(user.getUnitid());
			model.setRegionId(unit.getRegionid());
			model.setYear(GetDate.getNowYear());
			model.setWriteUserId(user.getId());
			model.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
			if(serviceManager.getTheoryExamService().addTheoryExam(model)){
				DriverStrInfo driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(model.getDriverStrInfoId());
				driverStrModel.setTheoryId(model.getTheoryId());
				driverStrModel.setTheoryFlag(model.getAuditingTheoryResultFlag());
				if(model.getAuditingTheoryResultFlag() == 1){
					driverStrModel.setStrState("4");
				}else{
					driverStrModel.setStrState("5");
				}
				if(serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStrModel)){
					if(model.getAuditingTheoryResultFlag() == 1){
						tNum++;
						serviceManager.getDriverClassTeamService().putOutPermit(Integer.valueOf(classInfoId), String.valueOf(strId), 1);
						PracticeExam modelPractice=new PracticeExam();
						modelPractice.setDriverStrInfoId(strId);
						modelPractice.setDrivingLicenceNo(serviceManager.getPeopleInfoService().findDriverStrInfoByPeopleId(serviceManager.getDriverStrInfoService().findDriverStrInfoById(strId).getPeopleInfoId()).getIdCard());
						
						modelPractice.setDrillMasterId(drillMasterId);
						modelPractice.setDrillMasterCode(drillMasterCode);
						modelPractice.setDrillMasterDate(drillMasterDate);
						modelPractice.setDrillMasterMachine(drillMasterMachine);
						modelPractice.setDrillMasterAuditingIdeaFlag(Integer.valueOf(drillMasterAuditingIdeaFlag));
						
						modelPractice.setFieldResult(fieldResult);
						modelPractice.setExaminerFieldOne(fieldExaminerOne);
						modelPractice.setExaminerFieldTwo(fieldExaminerTwo);
						modelPractice.setFieldDate(Date.valueOf(fieldDate));
						
						modelPractice.setMachineResult(machineResult);
						modelPractice.setExaminerMachineOne(machineExaminerOne);
						modelPractice.setExaminerMachineTwo(machineExaminerTwo);
						modelPractice.setMachineDate(Date.valueOf(machineDate));
						
						modelPractice.setRoadResult(roadResult);
						modelPractice.setExaminerRoadOne(roadExaminerOne);
						modelPractice.setExaminerRoadTwo(roadExaminerTwo);
						modelPractice.setRoadDate(Date.valueOf(roadDate));
						
						if(!"无".equals(fieldMakeupResult)){
							modelPractice.setFieldMakeupResult(fieldMakeupResult);
							modelPractice.setExaminerMakeupFieldOne(fieldExaminerOne);
							modelPractice.setExaminerMakeupFieldTwo(fieldExaminerTwo);
							modelPractice.setFieldMakeupDate(Date.valueOf(fieldDate));
						}
						if(!"无".equals(machineMakeupResult)){
							modelPractice.setMachineMakeupResult(machineMakeupResult);
							modelPractice.setExaminerMakeupMachineOne(machineExaminerOne);
							modelPractice.setExaminerMakeupMachineTwo(machineExaminerTwo);
							modelPractice.setMachineMakeupDate(Date.valueOf(machineDate));
						}
						if(!"无".equals(roadMakeupResult)){
							modelPractice.setRoadMakeupResult(roadMakeupResult);
							modelPractice.setExaminerMakeupRoadOne(roadExaminerOne);
							modelPractice.setExaminerMakeupRoadTwo(roadExaminerTwo);
							modelPractice.setRoadMakeupDate(Date.valueOf(roadDate));
						}
						if(conclusion == 1 || conclusion == 2){
							modelPractice.setAuditingPracticeResultFlag(1);
						}else{
							modelPractice.setAuditingPracticeResultFlag(0);
						}
						modelPractice.setDrillMasterAuditingIdeaFlag(1);
						modelPractice.setUnitAuditingPracticeIdeaFlag(1);
						modelPractice.setDrivingLicenceAuditingIdeaFlag(1);
						modelPractice.setOrgAuditingIdeaFlag(1);
						modelPractice.setUnitId(user.getUnitid());
						modelPractice.setRegionId(unit.getRegionid());
						modelPractice.setYear(GetDate.getNowYear());
						modelPractice.setWriteUserId(user.getId());
						modelPractice.setWriteDate(GetDate.stringToDate(GetDate.getStringDate()));
						if(serviceManager.getPracticeExamService().addPracticeExam(modelPractice)){
							if(modelPractice.getAuditingPracticeResultFlag() == 1){
								pNum++;
							}
							modelPractice = serviceManager.getPracticeExamService().findPracticeExamByStrId(model.getDriverStrInfoId());
							driverStrModel = serviceManager.getDriverStrInfoService().findDriverStrInfoById(modelPractice.getDriverStrInfoId());
							driverStrModel.setPracticeId(modelPractice.getPracticeId());
							driverStrModel.setPracticeFlag(modelPractice.getAuditingPracticeResultFlag());
							if(modelPractice.getAuditingPracticeResultFlag() == 1){
								driverStrModel.setStrState("6");
							}else{
								driverStrModel.setStrState("7");
							}
							serviceManager.getDriverStrInfoService().updateDriverStrInfo(driverStrModel);
						}
					}
				}
			}
		}
		
		DriverClassInfo model = serviceManager.getDriverClassInfoService().findDriverClassInfoById(Integer.valueOf(classInfoId));
		model.setTheoryExamPassStrNum(tNum);
		model.setPracticeExamPassStrNum(pNum);
		serviceManager.getDriverClassInfoService().updateDriverClassInfo(model);
		response.getWriter().write("{success:true,reason:'成绩录入成功'}");
	}
}