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

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TempliveFile;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class TempliveFileController extends BaseController{
	private final static Logger log = Logger.getLogger(TempliveFileController.class);
	
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
		List<TempliveFile> res = serviceManager.getTempliveFileService().getAllTempliveFileList(page, condition);
		JSONArray jsonItems = new JSONArray();
		for (TempliveFile u : res) {
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
	public void getAllTempliveFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllTempliveFile");
		List<TempliveFile> res = serviceManager.getTempliveFileService().getAllTempliveFileList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (TempliveFile u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("TempliveFile", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	//添加
	public void addTempliveFile(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String templivefiletype = (String) request.getParameter("templivefiletype").trim();
		log.info("Add new TempliveFile:[templivefiletype:"+templivefiletype+"]");
		TempliveFile model=new TempliveFile();
		model.setTemplivefileType(templivefiletype);
		
		if (serviceManager.getTempliveFileService().addTempliveFile(model)) {
			log.info("添加暂住证类别成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加暂住证类别失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateTempliveFile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		TempliveFile model=new TempliveFile();
		String id = (String) request.getParameter("id").trim();
		String templivefiletype = (String) request.getParameter("templivefiletype").trim();
		log.info("Update TempliveFile");
		model.setId(Integer.parseInt(id));
		model.setTemplivefileType(templivefiletype);
		if (serviceManager.getTempliveFileService().updateTempliveFile(model)) {
			log.info("暂住证类别修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'暂住证类别修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	public void delTempliveFile(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del TempliveFile");
		String delIds = (String) request.getParameter("typelist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			TempliveFile model = (TempliveFile)JSONObject.toBean(jsonObject,TempliveFile.class);
			boolean isDelete = serviceManager.getTempliveFileService().delTempliveFile(model);
			if (!isDelete) {
				log.info("Err on delete ImportsFile");
				response.getWriter().write("{failure:true,reason:'删除暂住证类别失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	}
