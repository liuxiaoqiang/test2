package Ynzc.YnzcAms.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.HandlingSituation;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class HandlingSituationController extends  BaseController{
	private final static Logger log = Logger.getLogger(HandlingSituationController.class);
	
	//添加拖拉机经办情况
	public void addHandlingSituation(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");		
		String reviewer = (String) request.getParameter("reviewer").trim();//拖拉机经办情况：登记审核人
		Date reviewerconductdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("reviewerconductdate").trim());//拖拉机经办情况：经办时间
		String issueadmin = (String) request.getParameter("issueadmin").trim();//拖拉机经办情况：牌证管理员
		String leaderreview = (String) request.getParameter("leaderreview").trim();//拖拉机经办情况：业务领导审核人
		Date leaderreviewconductdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("leaderreviewconductdate").trim());//拖拉机经办情况：经办时间
		Date issueadmindate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueadmindate").trim());//拖拉机经办情况：牌证管理员经办时间
		int tractorinfoId=Integer.parseInt(request.getSession().getAttribute("tractorInfoId").toString());
		
	 	log.info("Add new HandlingSituation:[reviewer:"+reviewer+"、reviewerconductdate："+reviewerconductdate.toString()+"、issueadmin："+issueadmin+"]");
		HandlingSituation model=new HandlingSituation();
		model.setReviewer(reviewer);
		model.setReviewerconductdate(reviewerconductdate);
		model.setIssueadmin(issueadmin);
		model.setLeaderreview(leaderreview);
		model.setLeaderreviewconductdate(leaderreviewconductdate);
		model.setIssueadmindate(issueadmindate);
		model.setTractorinfoId(tractorinfoId);
		
		if (serviceManager.getHandlingSituationService().addHandlingSituation(model)) {
			log.info("添加拖拉机经办情况信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			//response.getWriter().write("{success: true}");
		} else {
			//response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	
}
