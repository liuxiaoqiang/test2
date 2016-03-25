package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class CertificateController extends  BaseController {

	private final static Logger log = Logger.getLogger(CertificateController.class);

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
		List<Certificate> res = serviceManager.getCertificateService().getAllModelList(page,condition);
		JSONArray jsonItems = new JSONArray();
		for (Certificate u : res) {
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
	public void getAllCertificate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllCertificate");
		List<Certificate> res = serviceManager.getCertificateService().getAllCertificateList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (Certificate u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("Certificate", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	//添加
	public void addCertificate(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String realcertificatetype = (String) request.getParameter("certificatetype").trim();
		log.info("Add new Certificate:[realcertificatetype:"+realcertificatetype+"]");
		Certificate model=new Certificate();
		model.setRealcertificatetype(realcertificatetype);
		
		if (serviceManager.getCertificateService().addModel(model)) {
			log.info("添加证件类型成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateCertificate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		Certificate model=new Certificate();
		String id = (String) request.getParameter("id").trim();
		String realcertificatetype = (String) request.getParameter("certificatetype").trim();
		log.info("Update Certificate");
		model.setId(Integer.parseInt(id));
		model.setRealcertificatetype(realcertificatetype);
		if (serviceManager.getCertificateService().updateModel(model)) {
			log.info("证件类型修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'证件类型修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	@SuppressWarnings("rawtypes")
	public void delCertificate(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del Certificate");
		String delIds = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(delIds);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			Certificate model = (Certificate)JSONObject.toBean(jsonObject,Certificate.class);
			boolean isDelete = serviceManager.getCertificateService().delModel(model);
			if (!isDelete) {
				log.info("Err on delete Certificate");
				response.getWriter().write("{failure:true,reason:'删除证件类型失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}

}
