package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.GetWay;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class GetWayController extends  BaseController {
	private final static Logger log = Logger.getLogger(GetWayController.class);
	
	
	//查询分页数据
	public void getAllListByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllListByPage");
		if (request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if (request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
			log.info(limit);
		} else {
			log.info("limit is null");
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");//获取查询字段
		String query = request.getParameter("query");//获取查询输入框中输入的查询值
		String condition = "";//设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		List<GetWay> res = serviceManager.getGetWayService().getAllGetWayList(page,condition);
		JSONArray jsonItems = new JSONArray();
		for (GetWay u : res) {
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
	public void getAllGetWay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllGetWay");
		List<GetWay> res = serviceManager.getGetWayService().getAllGetWayList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (GetWay u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("GetWay", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	//添加
	public void addGetWay(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String getway = (String) request.getParameter("getway").trim();
		log.info("Add new GetWay:[getway:"+getway+"]");
		GetWay model=new GetWay();
		model.setGetway(getway);
		
		if (serviceManager.getGetWayService().addGetWay(model)) {
			log.info("添加获取方式成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加获取方式失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateGetWay(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		GetWay model=new GetWay();
		String id = (String) request.getParameter("id").trim();
		String getway = (String) request.getParameter("getway").trim();
		log.info("Update GetWay");
		model.setId(Integer.parseInt(id));
		model.setGetway(getway);
		if (serviceManager.getGetWayService().updateGetWay(model)) {
			log.info("获取方式修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'获取方式修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	public void delGetWay(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del GetWay");
		String delIds = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			GetWay model = (GetWay)JSONObject.toBean(jsonObject,GetWay.class);
			boolean isDelete = serviceManager.getGetWayService().delGetWay(model);
			if (!isDelete) {
				log.info("Err on delete GetWay");
				response.getWriter().write("{failure:true,reason:'删除获取方式失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	}
