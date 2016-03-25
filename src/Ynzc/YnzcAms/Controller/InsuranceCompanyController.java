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

import Ynzc.YnzcAms.Model.InsuranceCompany;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class InsuranceCompanyController extends  BaseController {
	private final static Logger log = Logger.getLogger(InsuranceCompanyController.class);

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
		List<InsuranceCompany> res = serviceManager.getInsuranceCompanyService().getAllInsuranceCompanyList(page, condition);
		JSONArray jsonItems = new JSONArray();
		for (InsuranceCompany u : res) {
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
	public void getAllInsuranceCompany(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllInsuranceCompany");
		List<InsuranceCompany> res = serviceManager.getInsuranceCompanyService().getAllInsuranceCompanyList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (InsuranceCompany u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("InsuranceCompany", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	//添加
	public void addInsuranceCompany(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String insurancecompanyName = (String) request.getParameter("insurancecompanyName").trim();
		log.info("Add new InsuranceCompany:[insurancecompanyName:"+insurancecompanyName+"]");
		InsuranceCompany model=new InsuranceCompany();
		model.setInsurancecompanyName(insurancecompanyName);
		
		if (serviceManager.getInsuranceCompanyService().addInsuranceCompany(model)) {
			log.info("添加保险公司成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加保险公司失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateInsuranceCompany(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		InsuranceCompany model=new InsuranceCompany();
		String id = (String) request.getParameter("id").trim();
		String insurancecompanyName = (String) request.getParameter("insurancecompanyName").trim();
		log.info("Update InsuranceCompany");
		model.setId(Integer.parseInt(id));
		model.setInsurancecompanyName(insurancecompanyName);
		if (serviceManager.getInsuranceCompanyService().updateInsuranceCompany(model)) {
			log.info("保险公司修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'保险公司修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	public void delInsuranceCompany(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del InsuranceCompany");
		String delIds = (String) request.getParameter("typelist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			InsuranceCompany model = (InsuranceCompany)JSONObject.toBean(jsonObject,InsuranceCompany.class);
			boolean isDelete = serviceManager.getInsuranceCompanyService().delInsuranceCompany(model);
			if (!isDelete) {
				log.info("Err on delete ImportsFile");
				response.getWriter().write("{failure:true,reason:'删除保险公司失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
}
