package Ynzc.YnzcAms.Controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.TechnicalInspect;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

import java.util.*;
public class TechnicalInspectController extends  BaseController{
	private final static Logger log = Logger.getLogger(TechnicalInspectController.class);

	//添加拖拉机技术检验
	public void addTechnicalInspect(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");		
		String checkresult = (String) request.getParameter("checkresult").trim();//拖拉机技术检验：检验结论
		Date checkexpirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkexpirydate").trim());//拖拉机技术检验：检验有效期
		String inspector = (String) request.getParameter("inspector").trim();//拖拉机技术检验：检验人
 		Date checkdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkdate").trim());//拖拉机技术检验：检验时间
		int tractorinfoId=Integer.parseInt(request.getSession().getAttribute("tractorInfoId").toString());
		
		log.info("Add new TechnicalInspect:[checkresult:"+checkresult+"、checkexpirydate："+checkexpirydate.toString()+"、inspector："+inspector+"]");
		TechnicalInspect model=new TechnicalInspect();
		
		model.setCheckresult(checkresult);
		model.setCheckexpirydate(checkexpirydate);
		model.setInspector(inspector);
		model.setCheckdate(checkdate);
		model.setTractorinfoId(tractorinfoId);
		
		if (serviceManager.getTechnicalInspectService().addTechnicalInspect(model)) {
			log.info("添加拖拉机技术检验信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			//response.getWriter().write("{success: true}");
		} else {
			//response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	
}
