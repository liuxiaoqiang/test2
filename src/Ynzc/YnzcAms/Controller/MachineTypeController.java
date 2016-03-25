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

import Ynzc.YnzcAms.Model.MachineType;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class MachineTypeController extends  BaseController{

	private final static Logger log = Logger.getLogger(MachineTypeController.class);

	//查询分页数据
	public void getMachineTypeList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getMachineTypeList");
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
		List<MachineType> res = serviceManager.getMachineTypeService().getMachineTypeList(page, condition);
		JSONArray jsonItems = new JSONArray();
		for (MachineType u : res) {
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
	public void getAllMachineType(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllMachineType");
		List<MachineType> res = serviceManager.getMachineTypeService().getMachineTypeList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (MachineType u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("MachineType", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	//添加
	public void addMachineType(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String machinetype = (String) request.getParameter("machinetype").trim();
		log.info("Add new MachineType:[machinetype:"+machinetype+"]");
		MachineType model=new MachineType();
		model.setMachinetype(machinetype);
		
		if (serviceManager.getMachineTypeService().addMachineType(model)) {
			log.info("添加机械类型成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加机械类型失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateMachineType(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		MachineType model=new MachineType();
		String id = (String) request.getParameter("id").trim();
		String machinetype = (String) request.getParameter("machinetype").trim();
		log.info("Update MachineType");
		model.setId(Integer.parseInt(id));
		model.setMachinetype(machinetype);
		if (serviceManager.getMachineTypeService().updateMachineType(model)) {
			log.info("机械类型修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'机械类型修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	public void delMachineType(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del MachineType");
		String delIds = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			MachineType model = (MachineType)JSONObject.toBean(jsonObject,MachineType.class);
			boolean isDelete = serviceManager.getMachineTypeService().delMachineType(model);
			if (!isDelete) {
				log.info("Err on delete MachineType");
				response.getWriter().write("{failure:true,reason:'删除机械类型失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
}
