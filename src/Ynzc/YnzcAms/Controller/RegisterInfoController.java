package Ynzc.YnzcAms.Controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.RegisterInfo;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class RegisterInfoController extends  BaseController{
	private final static Logger log = Logger.getLogger(RegisterInfoController.class);
 
	//添加拖拉机注册信息
	public void addRegisterInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String registerdate = (String) request.getParameter("registerdate").trim();//拖拉机注册信息：登记/转入日期
		String issuedate = (String) request.getParameter("issuedate").trim();//拖拉机注册信息：发牌证日期
		String beforeregion = (String) request.getParameter("beforeregion").trim();//拖拉机注册信息：转入前管辖地
		int tractorinfoId=Integer.parseInt(request.getSession().getAttribute("tractorInfoId").toString());
		
		log.info("Add new RegisterInfo:[registerdate:"+registerdate+"、issuedate："+issuedate+"、beforeregion："+beforeregion+"]");
		RegisterInfo model=new RegisterInfo();
		model.setRegisterdate(new SimpleDateFormat("yyyy-MM-dd").parse(registerdate));
		model.setIssuedate(new SimpleDateFormat("yyyy-MM-dd").parse(issuedate));
		model.setBeforeregion(beforeregion);
		model.setTractorinfoId(tractorinfoId);
		
		if (serviceManager.getRegisterInfoService().addRegisterInfo(model)) {
			log.info("添加拖拉机注册信息信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			//response.getWriter().write("{success: true}");
		} else {
			//response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	
}
