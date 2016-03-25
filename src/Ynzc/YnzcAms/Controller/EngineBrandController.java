package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Model.EngineBrand;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class EngineBrandController extends  BaseController{
	
	private final static Logger log = Logger.getLogger(EngineBrandController.class);
	

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
		List<EngineBrand> res = serviceManager.getEngineBrandService().getAllEngineBrandList(page,condition);
		JSONArray jsonItems = new JSONArray();
		for (EngineBrand u : res) {
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
	public void getAllEngineBrand(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllEngineBrand");
		List<EngineBrand> res = serviceManager.getEngineBrandService().getAllEngineBrandList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (EngineBrand u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("EngineBrand", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	//添加
	public void addEngineBrand(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String engineBrand = (String) request.getParameter("engineBrand").trim();
		log.info("Add new EngineBrand:[engineBrand:"+engineBrand+"]");
		EngineBrand model=new EngineBrand();
		model.setEngineBrand(engineBrand);
		
		if (serviceManager.getEngineBrandService().addEngineBrand(model)) {
			log.info("发动机品牌添加成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加发动机品牌失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateEngineBrand(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		EngineBrand model=new EngineBrand();
		String id = (String) request.getParameter("id").trim();
		String engineBrand = (String) request.getParameter("engineBrand").trim();
		//response.getWriter().write("id="+id+"========name="+engineBrand);
		log.info("Update EngineBrand");
		model.setId(Integer.parseInt(id));
		model.setEngineBrand(engineBrand);
		if (serviceManager.getEngineBrandService().updateEngineBrand(model)) {
			log.info("发动机品牌修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'发动机品牌修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	@SuppressWarnings("rawtypes")
	public void delEngineBrand(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del EngineBrand");
		String delIds = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			EngineBrand model = (EngineBrand)JSONObject.toBean(jsonObject,EngineBrand.class);
			boolean isDelete = serviceManager.getEngineBrandService().delEngineBrand(model);
			if (!isDelete) {
				log.info("Err on delete EngineBrand");
				response.getWriter().write("{failure:true,reason:'删除发动机品牌失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void findRecordById(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		EngineBrand eb=serviceManager.getEngineBrandService().findEngineBrandById(id);
		if(eb!=null){
			response.getWriter().print(JSONObject.fromObject(eb));
		}
	}
	
	}
