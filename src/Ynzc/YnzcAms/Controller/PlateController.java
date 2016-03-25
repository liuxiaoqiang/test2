package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.*;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class PlateController extends BaseController {

	private final static Logger log = Logger.getLogger(PlateController.class);

	public void getSubmitList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Submit List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		User user = (User) request.getSession().getAttribute("user");
		int status=Integer.parseInt(request.getParameter("status"));
		List<PlateSubmit> res = serviceManager.getPlateSubmitService()
				.getAllSubmit(page, user.getUnitid(),status);
		JSONArray jsonItems = new JSONArray();
		for (PlateSubmit ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getSubmitListWaitMade(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Submit List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		List<PlateSubmit> res = serviceManager.getPlateSubmitService()
				.getAllSubmitWaitMade(page);
		JSONArray jsonItems = new JSONArray();
		for (PlateSubmit ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getNewPlateListHandle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get NewPlate List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 鑾峰彇鏌ヨ瀛楁
		String query = request.getParameter("query");// 鑾峰彇鏌ヨ杈撳叆妗嗕腑杈撳叆鐨勬煡璇㈠€?
		String condition = "";// 璁剧疆鏌ヨ鏉′欢涓虹┖
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		// int status = Integer.parseInt(request.getParameter("status").trim());
		List<NewPlate> res = serviceManager.getNewPlateService()
				.getAllNewPlateHandle(page, psid, condition);
		JSONArray jsonItems = new JSONArray();
		for (NewPlate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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
	
	public void getNewChangePlateList(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get NewPlate List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		} 
		User user = (User) request.getSession().getAttribute("user");
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		int type=0;
		List<Plate> plate = serviceManager.getPlateService()
				.getPlateChangeList(page,condition,um.getRegionid(),type);
		if(plate.size()>0){
			int unitid = Integer.parseInt(request.getSession().getAttribute(
			"unitid").toString().trim());
			PlateSubmit plateSubmit = serviceManager
			.getPlateSubmitService().findPlateSubmit(
					4, unitid);// 查出批次id	
			NewPlate newPlateModel = new NewPlate();
			for (Plate plateinfo : plate) {
				newPlateModel.setPlatenum(plateinfo.getPlatenum());
				newPlateModel.setPlatenumhead(plateinfo.getPlatehead());
				newPlateModel.setPsid(plateSubmit.getId());
				newPlateModel.setMadestatus(7);
				serviceManager.getNewPlateService().addAPlate(
						newPlateModel) ;
			    serviceManager.getPlateService().delPlate(
							plateinfo);//删除plate里面的补牌号牌
				}				
		}	
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		int getType =1;
		List<NewPlate> res = serviceManager.getNewPlateService().getAllNewPlate(page, psid, condition,getType);
		JSONArray jsonItems = new JSONArray();
		for (NewPlate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getNewPlateList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get NewPlate List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		String pid = request.getParameter("pid").trim();
		List<Plate> res = serviceManager.getPlateService().getPlateByPid(page, pid, condition);
		JSONArray jsonItems = new JSONArray();
		for (Plate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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
	
	
	
	public void getPlateChangeList(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Plate List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		User user = (User) request.getSession().getAttribute("user");
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
	    int type=Integer.parseInt(request.getParameter("status"));
		List<Plate> res = serviceManager.getPlateService()
		.getPlateChangeList(page,condition,um.getRegionid(),type);
		JSONArray jsonItems = new JSONArray();
		for (Plate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getMadePlateList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get NewPlate List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		List<NewPlate> res = serviceManager.getNewPlateService()
				.getAllMadePlate(page, psid, condition);
		JSONArray jsonItems = new JSONArray();
		for (NewPlate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getPlateLibList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Plate Lib List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		User user = (User) request.getSession().getAttribute("user");
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			fields = fields.replace("useunit", "unitid");
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		int plateStatus = Integer.parseInt(request.getParameter("status")
				.trim());
		List<Plate> res = serviceManager.getPlateService()
				.getPlateLibList(page, condition, user.getId(), plateStatus);
		JSONArray jsonItems = new JSONArray();
		for (Plate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getPlateStatusInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Plate List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		User user = (User) request.getSession().getAttribute("user");
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			fields = fields.replace("useunit", "unitid");
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		System.out.println(user.getUnitid());
		String mark = "1";
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		List<Plate> res = serviceManager.getPlateService()
				.getPlateLibList(page, condition, um.getRegionid(), mark);
		JSONArray jsonItems = new JSONArray();
		for (Plate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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

	public void getPlateLibListInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Plate Lib List");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		User user = (User) request.getSession().getAttribute("user");
		String fields = request.getParameter("fields");// 
		String query = request.getParameter("query");// 
		String condition = "";// 
		if (fields != null && query != null) {
			fields = fields.replace("useunit", "unitid");
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		if (!request.getParameter("untilid").trim().equals("-1")) {
			int untilid = Integer.parseInt(request.getParameter("untilid").trim());
			String mark = "0";
			UnitManage um=serviceManager.getUnitManageService().findUnitManageById(untilid);
			List<Plate> res = serviceManager.getPlateService()
					.getPlateLibList(page, condition, um.getRegionid(), mark);
			JSONArray jsonItems = new JSONArray();
			for (Plate ps : res) {
				jsonItems.add(JSONObject.fromObject(ps));
			}
			JSONObject jsonBack = new JSONObject();
			jsonBack.put("data", jsonItems);
			jsonBack.put("totalCount", page.getTotalCount());
			System.out.println(jsonBack);
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonBack);
		} else {
			PrintWriter out = response.getWriter();
			out.print(" ");
		}
	}

	public void addANewPlate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addANewPlate");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DecimalFormat df = new DecimalFormat("00000");
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		Plate np = new Plate();
		np.setPlatenum(df.format(Integer.parseInt(request.getParameter("platenum").trim())));
		np.setPlatehead(request.getSession().getAttribute("platecode").toString());
		np.setPid(request.getParameter("pid").trim()+",");
		np.setRegionid(um.getRegionid());
		if(request.getParameter("type").equals("1")){
			np.setStatus(19);
			boolean isexist=serviceManager.getPlateService().isExist(np.getPlatenum(), np.getPlatehead());
			if(!isexist){
			if (!serviceManager.getPlateService().addPlate(np)) {
				log.info("Err on add New Plate");
				response.getWriter().write("{success: false,reason:'添加号牌失败'}");
			} else {
					response.getWriter().write("{success:true}");
			}}else{
				response.getWriter().write("{success: false,reason:'该号牌已存在'}");
			}
		}else{
			np=serviceManager.getPlateService().getPlate(np.getPlatenum(), np.getPlatehead());
			np.setStatus(np.getStatus()+10);
			if(np.getPid()!=null){
			np.setPid(np.getPid()+request.getParameter("pid").trim()+",");}
			else{np.setPid(request.getParameter("pid").trim()+",");}
			if(!serviceManager.getPlateService().updatePlateInfo(np)){
				log.info("Err on add New Plate");
				response.getWriter().write("{success: false,reason:'添加号牌失败'}");
			}else{
				//写修改plate表里面对应的信息
//				String delIds = (String) request.getParameter("dellist").trim();
//				JSONArray jsonArray = JSONArray.fromObject(delIds);
//				Iterator iterator = jsonArray.iterator();
//				JSONObject jsonObject = new JSONObject();
//				while (iterator.hasNext()) {
//					String str = iterator.next().toString();
//					jsonObject = JSONObject.fromObject(str);
//					Plate model = (Plate) JSONObject.toBean(jsonObject,
//							Plate.class);
//					model.setStatus(model.getStatus()*10);
//					boolean isDelete = serviceManager.getPlateService().updatePlateInfo(model);
//					if (!isDelete) {
//						log.info("Err on delete NewPlate");
//						response.getWriter().write("{failure:true,reason:'添加号牌失败'}");
//					}
//				}
				response.getWriter().write("{success:true}");
			}
		}
	}
	
	public void AddPlateBat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addPlateBat");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		DecimalFormat df = new DecimalFormat("00000");
		int type=Integer.parseInt(request.getParameter("type").trim());
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		if(type==0){
			int start = Integer.parseInt(request.getParameter("start").trim());
			int end = Integer.parseInt(request.getParameter("end").trim());
			String pid = request.getParameter("pid").trim()+",";
			String platenumhead = request.getSession().getAttribute("platecode").toString();
			int unitid=((User)request.getSession().getAttribute("user")).getUnitid();
			int status=19;
			int isexist=0;
			for(int i=start;i<end;i++){
				if(serviceManager.getPlateService().isExist(df.format(i), platenumhead)){
					isexist=1;
					break;
				}
			}
			if(isexist==0){
			if (!serviceManager.getPlateService().addPlateBat(start, end, platenumhead, um.getRegionid(), pid, status)) {
				log.info("Err on add Plate Bat");
				response.getWriter().write("{success: false,reason:'添加号牌失败'}");
			} else {
				response.getWriter().write("{success:true}");
			}}else{
				response.getWriter().write("{success: false,reason:'该批次中有些号牌已存在，请重新添加'}");
			}
		}
		if(type==1){
			String delIds = (String) request.getParameter("dellist").trim();
			JSONArray jsonArray = JSONArray.fromObject(delIds);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject = new JSONObject();
			while (iterator.hasNext()) {
				String str = iterator.next().toString();
				jsonObject = JSONObject.fromObject(str);
				Plate model = (Plate) JSONObject.toBean(jsonObject,
						Plate.class);
				model.setStatus(model.getStatus()+10);
				if(model.getPid()!=null){
				model.setPid(model.getPid()+request.getParameter("pid").trim()+",");}
				else{
				model.setPid(request.getParameter("pid").trim()+",");
				}
				if(!serviceManager.getPlateService().updatePlateInfo(model)){
					log.info("Err on add New Plate");
					response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
					response.getWriter().write("{success: false}");
				}
			}
			response.getWriter().write("{success:true}");
		}
		if(type==2){
			String pid = request.getParameter("pid").trim()+",";
			int unitid=((User)request.getSession().getAttribute("user")).getUnitid();
			String platenumhead = request.getSession().getAttribute("platecode").toString();
			String delIds = (String) request.getParameter("dellist").trim();
			JSONArray jsonArray = JSONArray.fromObject(delIds);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject = new JSONObject();
			while (iterator.hasNext()) {
				String str = iterator.next().toString();
				jsonObject = JSONObject.fromObject(str);
				Plate model = (Plate) JSONObject.toBean(jsonObject,
						Plate.class);
				model.setStatus(model.getStatus()+10);
				if(model.getPid()!=null){
				model.setPid(model.getPid()+pid);}
				else{
				model.setPid(pid);}	
				if(!serviceManager.getPlateService().updatePlateInfo(model)){
					log.info("Err on add New Plate");
					response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
					response.getWriter().write("{success: false}");
				}
			}
			int start = Integer.parseInt(request.getParameter("start").trim());
			int end = Integer.parseInt(request.getParameter("end").trim());
			int count = Integer.parseInt(request.getParameter("count").trim());
			int status=19;
			end=start+(end-start-count);
			if (!serviceManager.getPlateService().addPlateBat(start, end, platenumhead,um.getRegionid(), pid, status)) {
				log.info("Err on add Plate Bat");
				response.getWriter().write("{failure:true,reason:'添加批次失败'}");
				response.getWriter().write("{success: false}");
			} else {
				response.getWriter().write("{success:true}");
			}
			
		}
	}

	public void addNewBat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addNewBat");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PlateSubmit ps = new PlateSubmit();
		User user = (User) request.getSession().getAttribute("user");
		int status =Integer.parseInt(request.getParameter("status"));
		ps.setStatus(status);
		ps.setSubmitman(user.getRealname());
		ps.setSubmitdate(new Date());
		ps.setUnitid(Integer.parseInt(request.getSession().getAttribute(
				"unitid").toString().trim()));
		if (!serviceManager.getPlateSubmitService().addNewSubmit(ps)) {
			log.info("Err on add New Bat");
			response.getWriter().write("{faFilure:true,reason:'添加批次失败'}");
			response.getWriter().write("{success:false}");
		} else {
			response.getWriter().write("{success:true}");
		}
	}

//	public void addChangeNewBat(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		log.info("someone come from ip address<" + request.getRemoteAddr()
//				+ ">");
//		log.info("reach addChangeNewBat");
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		int unitid = Integer.parseInt(request.getSession().getAttribute(
//				"unitid").toString().trim());
//		PlateSubmit plateJudge = new PlateSubmit();
//		plateJudge = serviceManager.getPlateSubmitService().findPlateSubmit(4,
//				unitid);//查找是否有补牌批次存在
//		if (plateJudge != null) {
//               response.getWriter().write("{failure:true,reason:'补牌批次只能添加一次'}");
//		} else {
//			PlateSubmit ps = new PlateSubmit();
//			User user = (User) request.getSession().getAttribute("user");
//			ps.setStatus(4);// 4是表示补牌的批次
//			ps.setSubmitman(user.getRealname());
//			ps.setSubmitdate(new Date());
//			ps.setUnitid(unitid);
//			if (!serviceManager.getPlateSubmitService().addNewSubmit(ps)) {
//				log.info("Err on add New Bat");
//				response.getWriter().write("{failure:true,reason:'添加批次失败'}");
//			} else {
//				PlateSubmit plateSubmit = serviceManager
//						.getPlateSubmitService().findPlateSubmit(
//								ps.getStatus(), ps.getUnitid());// 查出批次id
//				int type=0;
//				List<Plate> plate = serviceManager.getPlateService()
//						.getPlateChangeList(page,condition,user.getId(),type);
//				NewPlate newPlateModel = new NewPlate();
//				for (Plate plateinfo : plate) {
//					newPlateModel.setPlatenum(plateinfo.getPlatenum());
//					newPlateModel.setPlatenumhead(plateinfo.getPlatehead());
//					newPlateModel.setPsid(plateSubmit.getId());
//					newPlateModel.setMadestatus(7);
//					if (!serviceManager.getNewPlateService().addAPlate(
//							newPlateModel)) {
//						log.info("Err on add New changePlate");
//						response.getWriter().write(
//								"{failure:true,reason:'添加号牌失败'}");
//					} else {
//						boolean isDelete = serviceManager.getPlateService().delPlate(
//								plateinfo);//删除plate里面的补牌号牌
//						if (!isDelete) {
//							log.info("Err on delete NewPlate");
//							response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
//						}
//					}
//				}
//				response.getWriter().write("{success:true}");
//			}
//		}
//	}

	public void delNewPlate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach delNewPlate");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String delIds = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			NewPlate model = (NewPlate) JSONObject.toBean(jsonObject,
					NewPlate.class);
			boolean isDelete = serviceManager.getNewPlateService().delAPlate(
					model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
			}else{
				if(model.getIsaddnew()==0){
			 		Plate plate = (Plate)serviceManager.getPlateService().getPlate(model.getPlatenum(), model.getPlatenumhead());
			 		plate.setStatus(plate.getStatus()/10);
			 		serviceManager.getPlateService().updatePlateInfo(plate);
				}
			}
		}
		response.getWriter().write("{success: true}");
	}

	public void flagMade(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach flagMade");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String delIds = (String) request.getParameter("flaglist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			NewPlate model = (NewPlate) JSONObject.toBean(jsonObject,
					NewPlate.class);
			if (serviceManager.getPlateService().isExist(model.getPlatenum(),
					model.getPlatenumhead())) {
				model.setMadestatus(4);
			} else {
				model.setMadestatus(1);
			}
			boolean update = serviceManager.getNewPlateService()
					.updateNewPlate(model);
			if (!update) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}

	public void flagNotMade(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach flagMade");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String delIds = (String) request.getParameter("flaglist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			NewPlate model = (NewPlate) JSONObject.toBean(jsonObject,
					NewPlate.class);
			model.setMadestatus(2);
			boolean isDelete = serviceManager.getNewPlateService()
					.updateNewPlate(model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}

	public void delAllNewPlate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach delAllNewPlate");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		if (!serviceManager.getNewPlateService().delAllPlate(psid)) {
			log.info("Err on delete NewPlate");
			response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
		}
		response.getWriter().write("{success: true}");
	}

	public void delBat(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach del Bat");
		String deljson = request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(deljson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			PlateSubmit model = (PlateSubmit) JSONObject.toBean(jsonObject,
					PlateSubmit.class);
			serviceManager.getNewPlateService().delAllPlate(model.getId());
			boolean isDelete = serviceManager.getPlateSubmitService()
					.delSubmit(model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}

	public void allotPlate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach del Bat");
		String deljson = request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(deljson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			PlateSubmit model = (PlateSubmit) JSONObject.toBean(jsonObject,
					PlateSubmit.class);
			model.setStatus(2);
			serviceManager.getNewPlateService().allotAll(model.getId());
			boolean isDelete = serviceManager.getPlateSubmitService()
					.updateSubmit(model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'分配号牌失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}

	public void updatePlateStutas(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("updatePlateStutas");
		String type = request.getParameter("type").trim();
		String numberStr = "";
		if (type.equals("0")) {
			String desjson = request.getParameter("dellist").trim();
			int untilId = Integer.parseInt(request.getParameter("unitid")
					.trim());
			JSONArray jsonArray = JSONArray.fromObject(desjson);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject = new JSONObject();
			boolean isUpdate = false;
			while (iterator.hasNext()) {
				String str = iterator.next().toString();
				str = str.substring(1, str.length() - 1);
				jsonObject = JSONObject.fromObject(str);
				Plate model = (Plate) JSONObject
						.toBean(jsonObject, Plate.class);
				model.setStatus(2);
				model.setRegionid(serviceManager.getUnitManageService().findUnitManageById(untilId).getRegionid());
				isUpdate = serviceManager.getPlateService().updatePlateInfo(
						model);
				if (!isUpdate) {
					log.info("Err on update Plate");
					response.getWriter()
							.write("{failure:true,reason:'分配号牌失败'}");
				}

			}
			response.getWriter().write("{success:true}");

		}
		if (type.equals("1")) {
			String startStr = request.getParameter("startNumber").trim();
			String overStr = request.getParameter("overNumber").trim();
			String content = "";
			int startNumber = Integer.parseInt(startStr);
			int overNumber = Integer.parseInt(overStr);
			int untilId = Integer.parseInt(request.getParameter("unitid")
					.trim());
			String plateHead = request.getParameter("numberHead").trim();
			for (int i = startNumber; i <= overNumber; i++) {
				if (i == overNumber) {
					content = Integer.toString(i);
					numberStr += "'";
					for (int j = 1; j <= startStr.length() - content.length(); j++) {
						numberStr += "0";
					}
					numberStr += Integer.toString(i) + "'";
				} else {
					content = Integer.toString(i);
					numberStr += "'";
					for (int j = 1; j <= startStr.length() - content.length(); j++) {
						numberStr += "0";
					}
					numberStr += Integer.toString(i) + "'" + ",";
				}
			}
			boolean isSuccess = serviceManager.getPlateService()
					.updatePlateBatch(numberStr, plateHead, untilId);
			if (!isSuccess) {
				log.info("Err on update Plate");
				response.getWriter().write("{failure:true,reason:'分配号牌失败'}");
			} else {
				response.getWriter().write("{success:true}");
			}
		}
		if (type.equals("2")) {
			int status = Integer
					.parseInt(request.getParameter("status").trim());
			String desjson = request.getParameter("dellist").trim();
			JSONArray jsonArray = JSONArray.fromObject(desjson);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject = new JSONObject();
			boolean isUpdate = false;
			while (iterator.hasNext()) {
				String str = iterator.next().toString();
				str = str.substring(1, str.length() - 1);
				jsonObject = JSONObject.fromObject(str);
				System.out.println(jsonObject);
				Plate model = (Plate) JSONObject
						.toBean(jsonObject, Plate.class);
				model.setStatus(status);
				isUpdate = serviceManager.getPlateService().updatePlateInfo(
						model);
				if (!isUpdate) {
					log.info("Err on update Plate");
					response.getWriter()
							.write("{failure:true,reason:'号牌维护失败'}");
				}
			}
			response.getWriter().write("{success:true}");

		}
	}

	public void congressLaid(HttpServletRequest request,
			HttpServletResponse respnose) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach del Bat");
		String deljson = request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(deljson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		boolean isUpdate = false;
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			PlateSubmit model = (PlateSubmit) JSONObject.toBean(jsonObject,
					PlateSubmit.class);
			model.setStatus(3);
			serviceManager.getNewPlateService().laidAll(model.getId());
			List<NewPlate> res = serviceManager.getNewPlateService()
					.getAllNewPlateInfo(model.getId());
			for (NewPlate plate : res) {
				isUpdate = serviceManager.getPlateService().updatePlate(
						plate.getPlatenum(), plate.getPlatenumhead());
			}
			boolean isDelete = serviceManager.getPlateSubmitService().laidAll(
					model);
			if (!isDelete || !isUpdate) {
				log.info("Err on delete NewPlate");
				respnose.getWriter().write("{failure:true,reason:'号牌入库失败'}");
			}
		}
		respnose.getWriter().write("{success: true}");
	}

	public void Submit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach Submit");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String list = (String) request.getParameter("submitlist").trim();
		JSONArray jsonArray = JSONArray.fromObject(list);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			PlateSubmit model = (PlateSubmit) JSONObject.toBean(jsonObject,
					PlateSubmit.class);
			model.setTrueman(((User)request.getSession().getAttribute("user")).getRealname());
			model.setTruetime(new Date());
			model.setIstrue(1);
			boolean isDelete = serviceManager.getPlateSubmitService()
					.updateSubmit(model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'上报号牌失败'}");
			}else{
				String pid=model.getId()+",";
				serviceManager.getPlateSubmitService().updateSubmitData(pid);
			}
		}
		response.getWriter().write("{success: true}");
	}

	public void flagAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach Submit");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		if (!serviceManager.getNewPlateService().flagAll(psid)) {
			log.info("号牌标记失败");
			response.getWriter().write("{failure:true,reason:'号牌标记失败'}");
		}
		response.getWriter().write("{success: true}");
	}

	public void InputLib(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach Input Plate");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int unitid = Integer.parseInt(request.getParameter("unitid").trim());
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		User user = (User) request.getSession().getAttribute("user");
		if (!serviceManager.getPlateService().InputLib(unitid, psid,
				user.getRealname())) {
			log.info("号牌入库发成错误");
			response.getWriter().write("{failure:true,reason:'号牌入库发生错误'}");
		}
		response.getWriter().write("{success: true}");
	}

	public void getUnitManageInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get UnitManageInfo");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int unitid = Integer.parseInt(request.getParameter("nodeid").trim());
		UnitManage unitMan = serviceManager.getUnitManageService()
				.findUnitManageById(unitid);
		String result = unitMan.getRegion();
		if (unitMan != null) {
			response.getWriter().print("{success:true,str:" + result);
		}
	}
//得到当前登录用户所属地区对应的最小号牌
	public void getMinPlateCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get MinPlateCode");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		//得到当前登录用户
		User user = (User) request.getSession().getAttribute("user");
		//得到当前登录用户所属的单位
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		if (user != null) {
			String code = serviceManager.getPlateService().getMinPlateCode(
					um.getRegionid());
			UnitManage unitManage = serviceManager.getUnitManageService().findUnitManageById(user.getUnitid());
			String regionid[]=unitManage.getRegionid().split(",");
			String citycode="";
			if(regionid.length==3){
				citycode=(serviceManager.getRegionService().findRegionByID(Integer.parseInt(regionid[2].substring(0,regionid[2].length()-1)))).getCitycode();
			}
			if(regionid.length==2){
				citycode=(serviceManager.getRegionService().findRegionByID(Integer.parseInt(regionid[1].substring(0,regionid[1].length()-1)))).getCitycode();
			}
			if(regionid.length==1){
				citycode+="000000";
			}
			String oldre=serviceManager.getTractorInfoService().getRegcerno(citycode);
			citycode+=oldre.substring(6,oldre.length());
			if (code != "") {
				System.out.println("{success: true,code:" + code + "}");
				String registman="";
				String paizhengman="";
				String leaderman="";
				if(unitManage!=null && unitManage.getRegistman()!=null && !unitManage.getRegistman().equals("")){
					registman=unitManage.getRegistman();
				}
				if(unitManage.getPaizhengman()!=null && !unitManage.getPaizhengman().equals("")){
					paizhengman=unitManage.getPaizhengman();
				}
				if(unitManage.getLeaderman()!=null && !unitManage.getLeaderman().equals("")){
					leaderman=unitManage.getLeaderman();
				}
				response.getWriter()
						.print("{success:true,code:'" + code + "',registman:'"+registman+"',paizhengman:'"+paizhengman+"',leaderman:'"+leaderman+"',regcerno:'"+citycode+"'}");
			}
            
		}
	}
	//根据机构ID查询对应地区的最小号牌
	public void getMinPlateCodeByUnitId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get MinPlateCode");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String unitid=(String)request.getParameter("unitid");
		if (!unitid.equals("")) {
			UnitManage unitManage = serviceManager.getUnitManageService().findUnitManageById(Integer.parseInt(unitid));
			String code = serviceManager.getPlateService().getMinPlateCode(unitManage.getRegionid());
			if (code != "") {
				System.out.println("{success: true,code:" + code + "}");
				response.getWriter()
						.print("{success:true,code:'" + code + "',registman:'"+unitManage.getRegistman()+"',paizhengman:'"+unitManage.getPaizhengman()+"',leaderman:'"+unitManage.getLeaderman()+"'}");
			}

		}
	}
	public void updatePlateStatus(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get updatePlateStatus");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		User user = (User) request.getSession().getAttribute("user");
		String auditcartransferid = (String) request.getParameter("auditcartransferid").trim();// 得到需要分配的号牌的转入转移信息
		String tractorinfoId = request.getParameter("tractorinfoId");//转移的车辆
		String plateCode = request.getParameter("plateCode");//新分配的号牌
		String oldlicense = request.getParameter("oldlicense");//旧号牌
		String currentregionid=(String)request.getParameter("currentregionid");//当前转移地区的ID
		String orginregionid=(String)request.getParameter("orginregionid");//转移前的地区ID
		String[] content = plateCode.replace(".", "@").split("@");
		String[] oldLicensecContent = oldlicense.replace(".", "@").split("@");
		if(content.length==2)
		{
			String codehead=content[0];
			String plateNum =content[1];
			//将对应的车辆号牌进行更新
			serviceManager.getTractorInfoService().updateLicenseById(plateNum,Integer.parseInt(tractorinfoId));
			//将新号牌状态变为已使用
			serviceManager.getPlateService().updatePlateStatus(plateNum, codehead, currentregionid, 3);
			//将原号牌变为已转移
			serviceManager.getPlateService().updatePlateStatus(oldLicensecContent[1], oldLicensecContent[0], orginregionid,7);
			//将此请求变为待审核状态
			boolean result=this.serviceManager.getCarTransferService().updateCarTransferStateByIds(1, auditcartransferid);
			if(result==true){
				response.getWriter().print("{success:true}");
			}else{
				response.getWriter().print("{success:false}");
			}
		}
		else
		{
		response.getWriter().print("{success:false}");
		}
	}
    public void getPlateDoList(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get getPlateDoList");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String pid=request.getParameter("pid")+",";
	    int status=Integer.parseInt(request.getParameter("status"));
		List<Plate> resall=serviceManager.getPlateService().getPlateDoList(status);
	    Set<String> set=new TreeSet<String>();
	    if(status==3){
	    	String platecode=request.getParameter("platecode");
	    	for(Plate plate:resall){
	    		if(plate.getPlatehead().equals(platecode)){
	    			set.add(platecode);
	    		}
	    	}
	    }else{
		for(Plate plate:resall){
			set.add(plate.getPlatehead());
		}}
		String result="";
	    if(!set.isEmpty()){
		Object[] res=set.toArray();
		String[] resplate=new String[set.size()];
		for(int i=0;i<set.size();i++){
			for(Plate plate:resall){
				if(plate.getPlatehead().equals(res[i])){
					resplate[i]+="{columnWidth: .10,layout:\"fit\",labelWidth:160,items:[{id:\""+plate.getPlatehead().substring(1,3)+plate.getPlatenum()+"\",boxLabel:\""+plate.getPlatehead()+"."+plate.getPlatenum()+"\",xtype:\"checkbox\"}]},";			
				}
			}
			resplate[i]=resplate[i].substring(4,resplate[i].length()-1);
		}
		for(int i=0;i<set.size();i++){
			result+="{id:\""+res[i]+"\",title:\""+serviceManager.getUnitManageService().getUnitByCode((String) res[i]).getRegion()+"\",xtype:\"fieldset\",height:'auto',collapsible:false,layout:\"column\",items:["+
//			"{columnWidth: .10,layout:\"fit\",labelWidth:160,items:[{boxLabel:\"云03.80030\",xtype:\"checkbox\"}]}"	
			resplate[i]
			+"],anchor:'100%'},";
		}
		result=result.substring(0,result.length()-1);
	    }else{
	    	result="";
	    }
//		result="{id:\"云03\",title:\"曲靖市\",xtype:\"fieldset\",height:'auto',collapsible:false,layout:\"column\",items:["+
//				"{columnWidth: .10,layout:\"fit\",labelWidth:160,items:[{boxLabel:\"云03.80030\",xtype:\"checkbox\"}]}"+
//				"],anchor:'100%'}";
		PrintWriter out = response.getWriter();
		out.print("["+result+"]");
    }
    
    public void savePlateDoList(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get savePlateDoList");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");	
		User user = (User) request.getSession().getAttribute("user");
		String savestr=request.getParameter("savestr");
		String pid=request.getParameter("pid");
		String savelist[]=savestr.split(",");
		boolean isUpdate=true;
		if(pid.equals("市分")){
			for(String str:savelist){
				int unitid=Integer.parseInt(request.getParameter("unitid"));
				Plate plate=serviceManager.getPlateService().getPlate(str.substring(2,7),"云"+str.substring(0,2));
				plate.setStatus(0);
				plate.setPid("");
				plate.setRegionid(serviceManager.getUnitManageService().findUnitManageById(unitid).getRegionid());
				boolean isSave=serviceManager.getPlateService().updatePlateInfo(plate);
				if(!isSave)isUpdate=false;
			}
			if(!isUpdate){
			log.info("Err on savePlateDoList");
			response.getWriter().write("{failure:true,reason:'制作号牌失败'}");
			response.getWriter().write("{success: false}");
			}else{
				response.getWriter().write("{success:true}");
			}
		}else if(pid.equals("省分")){
			for(String str:savelist){
				int unitid=Integer.parseInt(request.getParameter("unitid"));
				Plate plate=serviceManager.getPlateService().getPlate(str.substring(2,7),"云"+str.substring(0,2));
				plate.setStatus(plate.getStatus()+20);
				plate.setPid(plate.getPid()+pid+",");
				plate.setRegionid(serviceManager.getUnitManageService().findUnitManageById(unitid).getRegionid());
				boolean isSave=serviceManager.getPlateService().updatePlateInfo(plate);
				if(!isSave)isUpdate=false;
			}
			if(!isUpdate){
			log.info("Err on savePlateDoList");
			response.getWriter().write("{failure:true,reason:'制作号牌失败'}");
			response.getWriter().write("{success: false}");
			}else{
				response.getWriter().write("{success:true}");
			}
		}else{
			for(String str:savelist){
				Plate plate=serviceManager.getPlateService().getPlate(str.substring(2,7),"云"+str.substring(0,2));
				plate.setStatus(plate.getStatus()+20);
				plate.setPid(plate.getPid()+pid+",");
				boolean isSave=serviceManager.getPlateService().updatePlateInfo(plate);
				if(!isSave)isUpdate=false;
			}
			if(!isUpdate){
			log.info("Err on savePlateDoList");
			response.getWriter().write("{failure:true,reason:'制作号牌失败'}");
			response.getWriter().write("{success: false}");
			}else{
				PlateSubmit platesubmit=serviceManager.getPlateSubmitService().findPlateSubmit(Integer.parseInt(pid));
				platesubmit.setIstrue(1);
				platesubmit.setTrueman(user.getRealname());
				platesubmit.setTruetime(new Date());
				serviceManager.getPlateSubmitService().updateSubmit(platesubmit);
				response.getWriter().write("{success:true}");
			}
		}
    }
    
    public void getUnitPlate(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get getUnitPlate");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		} 
		List<UnitManage> resall=serviceManager.getUnitManageService().getAllUnitManageList();
		List<UnitManage> resnew=new ArrayList();
		Set<String> reginidset=new TreeSet<String>();
		for(UnitManage ug:resall){
			String reginidstr[]=ug.getRegionid().split(",");
			if(reginidstr.length==2)
				reginidset.add(ug.getRegionid());
		}
		resnew.add(serviceManager.getUnitManageService().findUnitManageById(1));
		for(String reginidstr:reginidset){
	        	UnitManage um=new UnitManage();
	        	um=(serviceManager.getUnitManageService().getUnitManageByRegionid(reginidstr)).get(0);
	        	resnew.add(um);
	    }
		List<UnitPlate> outlist =new ArrayList<UnitPlate>();
		for(UnitManage um:resnew){
			    UnitPlate up=new UnitPlate();
			    up.setId(um.getId());
				up.setRegion(um.getRegion());
				up.setPlatecode(um.getPlatecode());
				up.setNotuseplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),0));
				up.setUsedplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),3));
				up.setBfplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),5));
				up.setBpplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),4));
				up.setZjplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),7));
				outlist.add(up);
		}
		JSONArray jsonItems = new JSONArray();
		for (UnitPlate up: outlist) {
			jsonItems.add(JSONObject.fromObject(up));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		System.out.println(jsonBack);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
    }
    
    public void getAreaPlate(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get getUnitPlate");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");// 获取查询字段
		String query = request.getParameter("query");// 获取查询输入框中输入的查询值
		String condition = "";// 设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		User user = (User) request.getSession().getAttribute("user");
		List<UnitManage> areaunit=serviceManager.getUnitManageService().getAreaUnit(user.getId());
//		for(UnitManage um:areaunit){
//			System.out.println(um.getId()+":"+um.getRegion());
//		}
		List<UnitManage> areaunitnew=new ArrayList();
		Set<String> reginidset=new TreeSet<String>();
		for(UnitManage ug:areaunit){
			String reginidstr[]=ug.getRegionid().split(",");
			if(reginidstr.length==3)
			reginidset.add(ug.getRegionid());
		}
        for(String reginidstr:reginidset){
//        	System.out.println(reginidstr);
        	UnitManage um=new UnitManage();
        	um=(serviceManager.getUnitManageService().getUnitManageByRegionid(reginidstr)).get(0);
        	areaunitnew.add(um);
        }
		List<UnitPlate> outlist =new ArrayList<UnitPlate>();
		for(UnitManage um:areaunitnew){
			    UnitPlate up=new UnitPlate();
			    up.setId(um.getId());
				up.setRegion(um.getRegion());
				up.setPlatecode(um.getPlatecode());
				up.setNotuseplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),0));
				up.setUsedplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),3));
				up.setBfplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),5));
				up.setBpplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),4));
				up.setZjplate(serviceManager.getPlateService().getPlateNumByRegion(um.getRegionid(),7));
				outlist.add(up);
		}
		JSONArray jsonItems = new JSONArray();
		for (UnitPlate up: outlist) {
			jsonItems.add(JSONObject.fromObject(up));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		System.out.println(jsonBack);
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
    }
    
    public void updateCerTransfer(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get updateCerTransfer");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String doid=request.getParameter("doid");
		boolean re=this.serviceManager.getCarTransferService().updateCarTransferStateByIds(1,doid);
		if(re){
			response.getWriter().print("{success:true}");
		}else{
			response.getWriter().print("{success:false}");
		}	
    }
    public void findPlateBat(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get findPlateBat");
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String startnum=request.getParameter("startnum").trim();
		String endnum=request.getParameter("endnum").trim();
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		List<Plate> res=serviceManager.getPlateService().getPlateList(page,startnum, endnum, um.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (Plate ps : res) {
			jsonItems.add(JSONObject.fromObject(ps));
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
}
