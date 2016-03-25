package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Model.DrivingLicenceType;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class DrivingLicenceTypeController extends BaseController{
	
	private final static Logger log = Logger.getLogger(DrivingLicenceTypeController.class);
	
	//查询;
	//getAllDrivingLicence;
	public void getAllDrivingLicenceType(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<DrivingLicenceType> res = serviceManager.getDrivingLicenceTypeService().getAllDrivingLicenceType(page,condition);
		JSONArray jsonItems = new JSONArray();
		for (DrivingLicenceType u : res) {
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
	//添加;
	//addDrivingLicence
	public void addDrivingLicenceType(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		DrivingLicenceType model=new DrivingLicenceType();
		model.setDrivingLicenceName(request.getParameter("drivingLicenceName").trim());
		model.setUnitId(Integer.parseInt(request.getParameter("drivingLicenceName").trim()));
		
		if (serviceManager.getDrivingLicenceTypeService().addDrivingLicenceType(model)) {
			log.info("驾照类型添加成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加驾照类型失败，请重新尝试!'}");
			//response.getWriter().write("{success: true,reason:'删除成功'}");
			//response.getWriter().write("{success:false,reason:'删除失败'}");
		}
	}
	//删除;
	//delDrivingLicence
	@SuppressWarnings("rawtypes")
	public void delDrivingLicenceType(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del DrivingLicence");
		String delIds = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			DrivingLicenceType model = (DrivingLicenceType)JSONObject.toBean(jsonObject,DrivingLicenceType.class);
			boolean isDelete = serviceManager.getDrivingLicenceTypeService().delDrivingLicenceType(model);
			if (!isDelete) {
				log.info("Err on delete EngineBrand");
				response.getWriter().write("{failure:true,reason:'删除驾照类型失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}

}
