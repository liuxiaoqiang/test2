package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.TractorInfoView;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Service.Manager.*;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

import java.util.*;

public class TractorInfoViewController extends BaseController {
	private final static Logger log = Logger
			.getLogger(TractorInfoViewController.class);

	// 查询登记注册菜单显示的分页数据 查询除通过审核以外的所有数据
	public void getTractorInfoView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getTractorInfoView");
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
		String state = request.getParameter("state");
		String license = request.getParameter("platenum");
		String owner = request.getParameter("owner");
		String realcertificateno = request.getParameter("cardnum");
		String tempaddress = request.getParameter("nowaddress");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));

		String condition = "status<>10";
		condition = new TractorInfoSearch().getTractorInfoSearchCondition(
				state, license, owner, realcertificateno, tempaddress,
				condition);
		User user = (User) request.getSession().getAttribute("user");
		List<TractorInfoView> res = this.serviceManager.getTractorInfoViewService().getTractorInfoViewList(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (TractorInfoView u : res) {
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

	// 得到领导审核岗注册登记的数据
	public void getAuditTractorInfoView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getTractorInfoView");
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
		String state = request.getParameter("state");
		String license = request.getParameter("platenum");
		String owner = request.getParameter("owner");
		String realcertificateno = request.getParameter("cardnum");
		String tempaddress = request.getParameter("nowaddress");
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));

		String condition = " status in (1,2,3,4,5,6,7,8,9,11,12,13) ";
		condition = new TractorInfoSearch().getTractorInfoSearchCondition(
				state, license, owner, realcertificateno, tempaddress,
				condition);
		User user = (User) request.getSession().getAttribute("user");
		List<TractorInfoView> res = this.serviceManager
				.getTractorInfoViewService().getTractorInfoViewList(page,
						condition, user.getId());
		JSONArray jsonItems = new JSONArray();
		for (TractorInfoView u : res) {
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

	// 查询车辆信息库的分页数据 条件为所有通过审核的数据
	public void getTractorInfoLib(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getCarChangeTractorInfoView");
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
		String state = request.getParameter("state");
		String license = request.getParameter("platenum");
		String owner = request.getParameter("owner");
		String realcertificateno = request.getParameter("cardnum");
		String tempaddress = request.getParameter("nowaddress");
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String condition = " status in (2,4,6,7,8,9,11,12,13) ";// 设置默认查询条件为审核通过的数据
		condition = new TractorInfoSearch().getTractorInfoSearchCondition(
				state, license, owner, realcertificateno, tempaddress,
				condition);
		// 得到当前用户
		User user = (User) request.getSession().getAttribute("user");
		List<TractorInfoView> res = serviceManager.getTractorInfoViewService()
				.getTractorInfoViewList(page, condition, user.getId());
		JSONArray jsonItems = new JSONArray();
		for (TractorInfoView u : res) {
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

	// 查询所有可以归档和已经归档的数据
	public void getGuiDangTractorInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getCarChangeTractorInfoView");
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
		String state = request.getParameter("state");
		String license = request.getParameter("platenum");
		String owner = request.getParameter("owner");
		String realcertificateno = request.getParameter("cardnum");
		String tempaddress = request.getParameter("nowaddress");
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String condition = " status in (2,13) ";// 设置默认查询条件为审核通过的数据和已经归档的数据
		condition = new TractorInfoSearch().getTractorInfoSearchCondition(
				state, license, owner, realcertificateno, tempaddress,
				condition);
		// 得到当前用户
		User user = (User) request.getSession().getAttribute("user");
		List<TractorInfoView> res = serviceManager.getTractorInfoViewService()
				.getTractorInfoViewList(page, condition, user.getId());
		JSONArray jsonItems = new JSONArray();
		for (TractorInfoView u : res) {
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

	public void IsExits(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllCarCheck");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String code = request.getParameter("codeNum").trim();
		String plate = (String) request.getSession().getAttribute("platecode");
		TractorInfoView view = this.serviceManager.getTractorInfoViewService().findTractorInfoViewByWhere(plate, code,regionid);
		
		if (view == null) {
			response.getWriter().write(
					"{success: false,reson:'未找到号牌牌照为[" + plate + "." + code
							+ "]的车辆信息'}");
		} else if (view.getFiling() == 0) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息还未进行归档,无法进行业务处理'}");
		} else if (view.getStatus() == 0) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息还未进行审核,无法进行业务处理'}");
		} else if (view.getStatus() == 1) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息为上报状态,无法进行业务处理'}");
		} else if (view.getStatus() == 3) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息为未通过审核,无法进行业务处理'}");
		} else if (view.getStatus() == 4) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[注销业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 5) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息为脱检数据,无法进行业务处理'}");
		} else if (view.getStatus() == 6) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[年检业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 7) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[变更业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 8) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[转移业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 9) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[变更备案]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 10) {
			response.getWriter().write(
					"{success: false,reson:'指定的车辆处于[报废]状态,无法进行操作'}");
		} else if (view.getStatus() == 11) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[补号码牌]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 12) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[抵押登记]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 14) {
			response.getWriter().write(
					"{success: false,reson:'指定的车辆处于[抵押]状态,无法进行操作'}");
		} else if (view.getFiling() == 1 || view.getStatus() == 2
				|| view.getStatus() == 13) {
			Object backdata = JSONObject.fromObject(view);
			System.out.println("{success: true,reson:" + backdata + "}");
			response.getWriter()
					.write("{success: true,reson:" + backdata + "}");
		}
	}

	public void IsExitsCarCheckCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllCarCheck");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String code = request.getParameter("codeNum").trim();
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String plate = (String) request.getSession().getAttribute("platecode");
		TractorInfoView view = this.serviceManager.getTractorInfoViewService()
				.findTractorInfoViewByWhere(plate, code,regionid);
		if (view == null) {
			response.getWriter().write("{success: false,reson:'未找到号牌牌照为[" + plate + "." + code+ "]的车辆信息'}");
		} else if (view.getFiling() == 0) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息还未进行归档,无法进行业务处理'}");
		} else if (view.getStatus() == 0) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息还未进行审核,无法进行业务处理'}");
		} else if (view.getStatus() == 1) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息为上报状态,无法进行业务处理'}");
		} else if (view.getStatus() == 3) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆信息为未通过审核,无法进行业务处理'}");
		} else if (view.getStatus() == 4) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[注销业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 6) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[年检业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 7) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[变更业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 8) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[转移业务]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 9) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[变更备案]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 10) {
			response.getWriter().write(
					"{success: false,reson:'指定的车辆处于[报废]状态,无法进行操作'}");
		} else if (view.getStatus() == 11) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[补号码牌]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getStatus() == 12) {
			response.getWriter().write(
					"{success: false,reson:'指定车辆的[抵押登记]业务流程还未处理完成,无法进行其他业务'}");
		} else if (view.getFiling() == 1 || view.getStatus() == 2
				|| view.getStatus() == 5 || view.getStatus() == 13
				|| view.getStatus() == 14) {
			Date today = new Date();
			// 得到车辆当前的年检有效期
			Date exiprydate = view.getCheckexpirydate();
			if (today.getTime() < exiprydate.getTime()) {
				long day = (exiprydate.getTime() - today.getTime())
						/ (3600 * 24 * 1000);
				if (day > 30) {
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化对象
					 Calendar calendar = Calendar.getInstance();//日历对象
					 calendar.setTime(exiprydate);//设置有效期
					 String expirydateStr=sdf.format(exiprydate);
					 calendar.add(Calendar.MONTH, -1);//月份减一
					 String begindate=sdf.format(calendar.getTime());
					response.getWriter().write(
							"{success: false,reson:'指定车辆的检验有效期为:" + expirydateStr
									+ ",可从"+begindate+"开始进行检验, 现日期未到,暂时不可以年检'}");
					return;
				}
			}
			Object backdata = JSONObject.fromObject(view);
			System.out.println("{success: true,reson:" + backdata + "}");
			response.getWriter()
					.write("{success: true,reson:" + backdata + "}");
		}
	}

}
