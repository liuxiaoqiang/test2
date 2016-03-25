package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.*;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class ReaperPlateController extends BaseController {

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
		List<ReaperPlateSubmit> res = serviceManager.getReaperPlateSubmitService().getAllSubmit(page, user.getUnitid());
		JSONArray jsonItems = new JSONArray();
		for (ReaperPlateSubmit ps : res) {
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
		List<ReaperPlateSubmit> res = serviceManager.getReaperPlateSubmitService()
				.getAllSubmitWaitMade(page);
		JSONArray jsonItems = new JSONArray();
		for (ReaperPlateSubmit ps : res) {
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
		List<NewReaperPlate> res = serviceManager.getNewReaperPlateService()
				.getAllNewPlateHandle(page, psid, condition);
		JSONArray jsonItems = new JSONArray();
		for (NewReaperPlate ps : res) {
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
		int type=0;
		List<ReaperPlate> plate = serviceManager.getReaperPlateService()
				.getPlateChangeList(user.getId(),type);
		if(plate.size()>0){
			int unitid = Integer.parseInt(request.getSession().getAttribute(
			"unitid").toString().trim());
			ReaperPlateSubmit plateSubmit = serviceManager
			.getReaperPlateSubmitService().findPlateSubmit(
					4, unitid);// 查出批次id	
			NewReaperPlate newPlateModel = new NewReaperPlate();
			for (ReaperPlate plateinfo : plate) {
				newPlateModel.setPlatenum(plateinfo.getPlatenum());
				newPlateModel.setPlatenumhead(plateinfo.getPlatehead());
				newPlateModel.setPsid(plateSubmit.getId());
				newPlateModel.setMadestatus(7);
				serviceManager.getNewReaperPlateService().addAPlate(
						newPlateModel) ;
			    serviceManager.getReaperPlateService().delPlate(
							plateinfo);//删除plate里面的补牌号牌
				}				
		}	
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		int getType =1;
		List<NewReaperPlate> res = serviceManager.getNewReaperPlateService().getAllNewPlate(page, psid, condition,getType);
		JSONArray jsonItems = new JSONArray();
		for (NewReaperPlate ps : res) {
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
		int psid = Integer.parseInt(request.getParameter("psid").trim());
		int getType=0;
		List<NewReaperPlate> res = serviceManager.getNewReaperPlateService()
				.getAllNewPlate(page, psid, condition,getType);
		JSONArray jsonItems = new JSONArray();
		for (NewReaperPlate ps : res) {
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
	    int type=1;
		List<ReaperPlate> res = serviceManager.getReaperPlateService()
		.getPlateChangeList(user.getId(),type);
		JSONArray jsonItems = new JSONArray();
		for (ReaperPlate ps : res) {
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
		List<NewReaperPlate> res = serviceManager.getNewReaperPlateService()
				.getAllMadePlate(page, psid, condition);
		JSONArray jsonItems = new JSONArray();
		for (NewReaperPlate ps : res) {
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
		List<ReaperPlateViewData> res = serviceManager.getReaperPlateService()
				.getPlateLibList(page, condition, user.getId(), plateStatus);
		JSONArray jsonItems = new JSONArray();
		for (ReaperPlateViewData ps : res) {
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
		List<ReaperPlateViewData> res = serviceManager.getReaperPlateService()
				.getPlateLibList(page, condition, user.getUnitid(), mark);
		JSONArray jsonItems = new JSONArray();
		for (ReaperPlateViewData ps : res) {
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
		String fields = request.getParameter("fields");// 鑾峰彇鏌ヨ瀛楁
		String query = request.getParameter("query");// 鑾峰彇鏌ヨ杈撳叆妗嗕腑杈撳叆鐨勬煡璇㈠€?
		String condition = "";// 璁剧疆鏌ヨ鏉′欢涓虹┖
		if (fields != null && query != null) {
			fields = fields.replace("useunit", "unitid");
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		if (!request.getParameter("untilid").trim().equals("-1")) {
			int untilid = Integer.parseInt(request.getParameter("untilid")
					.trim());
			String mark = "0";
			List<ReaperPlateViewData> res = serviceManager.getReaperPlateService()
					.getPlateLibList(page, condition, untilid, mark);
			JSONArray jsonItems = new JSONArray();
			for (ReaperPlateViewData ps : res) {
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
		NewReaperPlate np = new NewReaperPlate();
		np.setPlatenum(request.getParameter("platenum").trim());
		np.setPlatenumhead(request.getSession().getAttribute("platecode")
				.toString());
		np.setPsid(Integer.parseInt(request.getParameter("psid").trim()));
		np.setMadestatus(0); // 0待上报 1待制作 2待省级入库 3待分配
		if(request.getParameter("type").equals("1")){
			if (!serviceManager.getNewReaperPlateService().addAPlate(np)) {
				log.info("Err on add New Plate");
				response.getWriter().write("{failure:true,reason:'添加号牌失败'}");
				response.getWriter().write("{success: false}");
			} else {
					response.getWriter().write("{success:true}");
			}
		}else{
			if(!serviceManager.getNewReaperPlateService().addAPlate(np)){
				log.info("Err on add New Plate");
				response.getWriter().write("{faliure:true,reason:'添加号牌失败'}");
				response.getWriter().write("{success:false}");
			}else{
				//写删除plate表里面对应的信息
				String delIds = (String) request.getParameter("dellist").trim();
				JSONArray jsonArray = JSONArray.fromObject(delIds);
				Iterator iterator = jsonArray.iterator();
				JSONObject jsonObject = new JSONObject();
				while (iterator.hasNext()) {
					String str = iterator.next().toString();
					jsonObject = JSONObject.fromObject(str);
					ReaperPlate model = (ReaperPlate) JSONObject.toBean(jsonObject,
							ReaperPlate.class);
					boolean isDelete = serviceManager.getReaperPlateService().delPlate(
							model);
					if (!isDelete) {
						log.info("Err on delete NewPlate");
						response.getWriter().write("{failure:true,reason:'添加号牌失败'}");
					}
				}
				response.getWriter().write("{success:true}");
			}
		}
	}
    /////////////////////////////////////////////////////////////
	public void AddPlateBat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addPlateBat");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int type=Integer.parseInt(request.getParameter("type").trim());
		if(type==0){
			int start = Integer.parseInt(request.getParameter("start").trim());
			int end = Integer.parseInt(request.getParameter("end").trim());
			int psid = Integer.parseInt(request.getParameter("psid").trim());
			String platenumhead = request.getSession().getAttribute("platecode").toString();
			if (!serviceManager.getNewReaperPlateService().addPlateBat(start, end,
					platenumhead, psid)) {
				log.info("Err on add Plate Bat");
				response.getWriter().write("{failure:true,reason:'添加批次失败'}");
				response.getWriter().write("{success: false}");
			} else {
				response.getWriter().write("{success:true}");
			}
		}
		if(type==1){
			NewReaperPlate nPlate = new NewReaperPlate();
			nPlate.setPsid(Integer.parseInt(request.getParameter("psid").trim()));
			nPlate.setPlatenumhead(request.getSession().getAttribute("platecode").toString());
			nPlate.setMadestatus(0);
			String delIds = (String) request.getParameter("dellist").trim();
			JSONArray jsonArray = JSONArray.fromObject(delIds);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject = new JSONObject();
			while (iterator.hasNext()) {
				String str = iterator.next().toString();
				jsonObject = JSONObject.fromObject(str);
				ReaperPlate model = (ReaperPlate) JSONObject.toBean(jsonObject,
						ReaperPlate.class);
				nPlate.setPlatenum(model.getPlatenum());
				if(!serviceManager.getNewReaperPlateService().addAPlate(nPlate)){
					log.info("Err on add New Plate");
					response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
					response.getWriter().write("{success: false}");
				}else{
					boolean isDelete = serviceManager.getReaperPlateService().delPlate(
							model);
					if (!isDelete) {
						log.info("Err on delete NewPlate");
						response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
					}
				}
			}
			response.getWriter().write("{success:true}");
		}
		if(type==2){
			NewReaperPlate nPlate = new NewReaperPlate();
			int psid = Integer.parseInt(request.getParameter("psid").trim());
			String platenumhead = request.getSession().getAttribute("platecode").toString();
			nPlate.setPsid(psid);
			nPlate.setPlatenumhead(platenumhead);
			nPlate.setMadestatus(0);
			String delIds = (String) request.getParameter("dellist").trim();
			JSONArray jsonArray = JSONArray.fromObject(delIds);
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject = new JSONObject();
			while (iterator.hasNext()) {
				String str = iterator.next().toString();
				jsonObject = JSONObject.fromObject(str);
				ReaperPlate model = (ReaperPlate) JSONObject.toBean(jsonObject,
						ReaperPlate.class);
				nPlate.setPlatenum(model.getPlatenum());
				if(!serviceManager.getNewReaperPlateService().addAPlate(nPlate)){
					log.info("Err on add New Plate");
					response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
					response.getWriter().write("{success: false}");
				}else{
					boolean isDelete = serviceManager.getReaperPlateService().delPlate(
							model);
					if (!isDelete) {
						log.info("Err on delete NewPlate");
						response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
					}
				}
			}
			int start = Integer.parseInt(request.getParameter("start").trim());
			int end = Integer.parseInt(request.getParameter("end").trim());
			int count = Integer.parseInt(request.getParameter("count").trim());
			end=start+(end-start-count);
			if (!serviceManager.getNewReaperPlateService().addPlateBat(start, end,
					platenumhead, psid)) {
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
		ReaperPlateSubmit ps = new ReaperPlateSubmit();
		User user = (User) request.getSession().getAttribute("user");
		ps.setStatus(0); // 0待上报 1待制作 2已分配3待入库
		ps.setSubmitman(user.getRealname());
		ps.setSubmitdate(new Date());
		ps.setUnitid(Integer.parseInt(request.getSession().getAttribute(
				"unitid").toString().trim()));
		if (!serviceManager.getReaperPlateSubmitService().addNewSubmit(ps)) {
			log.info("Err on add New Bat");
			response.getWriter().write("{failure:true,reason:'添加批次失败'}");
			response.getWriter().write("{success: false}");
		} else {
			response.getWriter().write("{success:true}");
		}
	}

	public void addChangeNewBat(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("someone come from ip address<" + request.getRemoteAddr()
				+ ">");
		log.info("reach addChangeNewBat");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int unitid = Integer.parseInt(request.getSession().getAttribute(
				"unitid").toString().trim());
		ReaperPlateSubmit plateJudge = new ReaperPlateSubmit();
		plateJudge = serviceManager.getReaperPlateSubmitService().findPlateSubmit(4,
				unitid);//查找是否有补牌批次存在
		if (plateJudge != null) {
               response.getWriter().write("{failure:true,reason:'补牌批次只能添加一次'}");
		} else {
			ReaperPlateSubmit ps = new ReaperPlateSubmit();
			User user = (User) request.getSession().getAttribute("user");
			ps.setStatus(4);// 4是表示补牌的批次
			ps.setSubmitman(user.getRealname());
			ps.setSubmitdate(new Date());
			ps.setUnitid(unitid);
			if (!serviceManager.getReaperPlateSubmitService().addNewSubmit(ps)) {
				log.info("Err on add New Bat");
				response.getWriter().write("{failure:true,reason:'添加批次失败'}");
			} else {
				ReaperPlateSubmit plateSubmit = serviceManager
						.getReaperPlateSubmitService().findPlateSubmit(
								ps.getStatus(), ps.getUnitid());// 查出批次id
				int type=0;
				List<ReaperPlate> plate = serviceManager.getReaperPlateService()
						.getPlateChangeList(user.getId(),type);
				NewPlate newPlateModel = new NewPlate();
				for (ReaperPlate plateinfo : plate) {
					newPlateModel.setPlatenum(plateinfo.getPlatenum());
					newPlateModel.setPlatenumhead(plateinfo.getPlatehead());
					newPlateModel.setPsid(plateSubmit.getId());
					newPlateModel.setMadestatus(7);
					if (!serviceManager.getNewPlateService().addAPlate(
							newPlateModel)) {
						log.info("Err on add New changePlate");
						response.getWriter().write(
								"{failure:true,reason:'添加号牌失败'}");
					} else {
						boolean isDelete = serviceManager.getReaperPlateService().delPlate(
								plateinfo);//删除plate里面的补牌号牌
						if (!isDelete) {
							log.info("Err on delete NewPlate");
							response.getWriter().write("{failure:true,reason:'添加批量号牌失败'}");
						}
						response.getWriter().write("{success:true}");
					}

				}
				response.getWriter().write("{success:true}");
			}
		}
	}

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
			NewReaperPlate model = (NewReaperPlate) JSONObject.toBean(jsonObject,
					NewReaperPlate.class);
			boolean isDelete = serviceManager.getNewReaperPlateService().delAPlate(
					model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
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
			NewReaperPlate model = (NewReaperPlate) JSONObject.toBean(jsonObject,
					NewReaperPlate.class);
			if (serviceManager.getReaperPlateService().isExist(model.getPlatenum(),
					model.getPlatenumhead())) {
				model.setMadestatus(4);
			} else {
				model.setMadestatus(1);
			}
			boolean update = serviceManager.getNewReaperPlateService()
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
			NewReaperPlate model = (NewReaperPlate) JSONObject.toBean(jsonObject,
					NewReaperPlate.class);
			model.setMadestatus(2);
			boolean isDelete = serviceManager.getNewReaperPlateService()
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
		if (!serviceManager.getNewReaperPlateService().delAllPlate(psid)) {
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
			ReaperPlateSubmit model = (ReaperPlateSubmit) JSONObject.toBean(jsonObject,
					ReaperPlateSubmit.class);
			serviceManager.getNewReaperPlateService().delAllPlate(model.getId());
			boolean isDelete = serviceManager.getReaperPlateSubmitService()
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
			ReaperPlateSubmit model = (ReaperPlateSubmit) JSONObject.toBean(jsonObject,
					ReaperPlateSubmit.class);
			model.setStatus(2);
			serviceManager.getNewReaperPlateService().allotAll(model.getId());
			boolean isDelete = serviceManager.getReaperPlateSubmitService()
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
				ReaperPlate model = (ReaperPlate) JSONObject
						.toBean(jsonObject, ReaperPlate.class);
				model.setStatus(2);
				model.setUnitid(untilId);
				isUpdate = serviceManager.getReaperPlateService().updatePlateInfo(
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
			boolean isSuccess = serviceManager.getReaperPlateService()
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
				ReaperPlate model = (ReaperPlate) JSONObject
						.toBean(jsonObject, ReaperPlate.class);
				model.setStatus(status);
				isUpdate = serviceManager.getReaperPlateService().updatePlateInfo(
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
			ReaperPlateSubmit model = (ReaperPlateSubmit) JSONObject.toBean(jsonObject,
					ReaperPlateSubmit.class);
			model.setStatus(3);
			serviceManager.getNewReaperPlateService().laidAll(model.getId());// 淇敼鏂板彿鐗岀殑鐘舵€?
			List<NewReaperPlate> res = serviceManager.getNewReaperPlateService()
					.getAllNewPlateInfo(model.getId());
			for (NewReaperPlate plate : res) {
				isUpdate = serviceManager.getPlateService().updatePlate(
						plate.getPlatenum(), plate.getPlatenumhead());
			}
			boolean isDelete = serviceManager.getReaperPlateSubmitService().laidAll(
					model);// 淇敼鎵规鐘舵€?
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
			ReaperPlateSubmit model = (ReaperPlateSubmit) JSONObject.toBean(jsonObject,
					ReaperPlateSubmit.class);
			model.setStatus(1);
			boolean isDelete = serviceManager.getReaperPlateSubmitService()
					.updateSubmit(model);
			if (!isDelete) {
				log.info("Err on delete NewPlate");
				response.getWriter().write("{failure:true,reason:'删除号牌失败'}");
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
		if (!serviceManager.getNewReaperPlateService().flagAll(psid)) {
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
		if (!serviceManager.getReaperPlateService().InputLib(unitid, psid,
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

	public void getMinPlateCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("get MinPlateCode");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			String code = serviceManager.getReaperPlateService().getMinPlateCode(
					user.getUnitid());
			if (code != "") {
				System.out.println("{success: true,code:" + code + "}");
				response.getWriter()
						.print("{success:true,code:'" + code + "'}");
			}

		}
	}
	public void getLowReaperPlate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User us=(User)request.getSession().getAttribute("user");
		ReaperPlate res = serviceManager.getReaperPlateService().getLowNum(us.getId());
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
			JSONObject jsonBack = new JSONObject();
			jsonBack.put("data", jsonItems);
			System.out.println(jsonBack);
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonBack);
		}
	}
}
