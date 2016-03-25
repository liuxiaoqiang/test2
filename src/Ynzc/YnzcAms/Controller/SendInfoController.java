package Ynzc.YnzcAms.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.SendInformation;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class SendInfoController extends BaseController{
	private final static Logger log = Logger.getLogger(SendInfoController.class);
	
	public void getSendInforList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action GetAllSendInfo");
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
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		User user=(User)request.getSession().getAttribute("user");
		List<SendInformation> res = serviceManager.getSendInfoService().getSendInfoAll(page, condition,user.getId());
		JSONArray jsonItems = new JSONArray();
		for (SendInformation u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("sendInfo", jsonItems);
		jsonBack.put("InfototalCount", page.getTotalCount());
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	
	public void delSendInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("reach SendInformation");

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String sendInformationJson = (String) request.getParameter("rds").trim();
		JSONArray jsonArray = JSONArray.fromObject(sendInformationJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			SendInformation sendInformation=(SendInformation)JSONObject.toBean(jsonObject, SendInformation.class);
			if(serviceManager.getSendInfoService().delReply(sendInformation.getId())){
				boolean isDelete = serviceManager.getSendInfoService().delSendInfo(sendInformation);
				if (!isDelete) {
					log.info("Err on delete SendInformation");
					response.getWriter().write("{failure:true,reason:'不存在要删除的用户'}");
				}
			}
		}
		response.getWriter().write("{success: true}");

	}
	public void addSendInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addSendInformation");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String type=request.getParameter("type").trim();
		String title=request.getParameter("title").trim();
		String content=request.getParameter("content").trim();
		String replayId=request.getParameter("replayId").trim();
		User user=(User)request.getSession().getAttribute("user");
		SendInformation sif=new SendInformation();
		sif.setReplyId(Integer.parseInt(replayId));
		sif.setSendContent(content);
		sif.setSendUserId(user.getId());
		sif.setSendUserName(user.getRealname());
		sif.setTitle(title);
		sif.setType(type);
		Date date=new Date();
		sif.setSendDate(date);
		if(!serviceManager.getSendInfoService().addSendInfomation(sif)){
			log.info("Err on add SendInformation");
			response.getWriter().write("{failure:true,reason:'添加信息失败'}");
		}
		response.getWriter().write("{success: true}");
		
	}
	public void updateSendInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach addSendInformation");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String type=request.getParameter("type").trim();
		String title=request.getParameter("title").trim();
		String content=request.getParameter("content").trim();
		int id=Integer.parseInt(request.getParameter("id").trim());
		User user=(User)request.getSession().getAttribute("user");
		SendInformation sif=new SendInformation();
		sif.setId(id);
		sif.setReplyId(0);
		sif.setSendContent(content);
		sif.setSendUserId(user.getId());
		sif.setSendUserName(user.getRealname());
		sif.setTitle(title);
		sif.setType(type);
		Date date=new Date();
		sif.setSendDate(date);
		if(!serviceManager.getSendInfoService().updateSendInformation(sif)){
			log.info("Err on update SendInformation");
			response.getWriter().write("{failure:true,reason:'修改信息失败'}");
		}
		response.getWriter().write("{success: true}");
	}
	
	public void getSendInfoNewsAll(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action GetAllSendInfo");
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
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<SendInformation> res = serviceManager.getSendInfoService().getSendInfoNewsAll(page, condition);
		JSONArray jsonItems = new JSONArray();
		for (SendInformation u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("sendInfoNews", jsonItems);
		jsonBack.put("InfototalCountNews", page.getTotalCount());
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getSendInfoMessageAll(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action GetAllSendInfo");
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
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<SendInformation> res = serviceManager.getSendInfoService().getSendInfoMessageAll(page, condition);
		JSONArray jsonItems = new JSONArray();
		for (SendInformation u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("sendInfoMessage", jsonItems);
		jsonBack.put("InfototalCountMessage", page.getTotalCount());
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getSendInfoMessageIdList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int themeid=Integer.parseInt(request.getParameter("themeId"));
		List<SendInformation> res=serviceManager.getSendInfoService().getSendInfoMessageIdList(themeid);
		JSONArray jsonItems = new JSONArray();
		for (SendInformation u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonItems);
	}
	
}