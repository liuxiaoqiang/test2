package Ynzc.YnzcAms.Controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.RelationInfo;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class RelationInfoController extends  BaseController{
	private final static Logger log = Logger.getLogger(RelationInfoController.class);

	//添加拖拉机相关资料
	public void addRelationInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
 		
		int getwayfiletypeid = Integer.parseInt(request.getParameter("getwayfiletypeid").trim()) ;//拖拉机相关资料：来历凭证
		int importsfiletypeid = Integer.parseInt(request.getParameter("importsfiletypeid").trim());//拖拉机相关资料：进口凭证类型
		String other =(String)request.getParameter("otherid").trim();//拖拉机相关资料：其他文件ID
		String getwayfileno = (String) request.getParameter("getwayfileno").trim();//拖拉机相关资料：来历凭证编号
		String importsfileno = (String) request.getParameter("importsfileno").trim();//拖拉机相关资料：进口凭证编号
		String insurancelistno = (String) request.getParameter("insurancelistno").trim();//拖拉机相关资料：保单号码
		String insurancecompanyname = (String)request.getParameter("insurancecompanyname").trim();//拖拉机相关资料：保险公司名称
		String insurancedate = (String) request.getParameter("insurancedate").trim();//拖拉机相关资料：保险日期
		String expirydate = (String) request.getParameter("expirydate").trim();//拖拉机相关资料：保险有效期
		int tractorinfoId=Integer.parseInt(request.getSession().getAttribute("tractorInfoId").toString());
		
		log.info("Add new RelationInfo:[getwayfiletypeid:"+getwayfiletypeid+"、importsfiletypeid："+importsfiletypeid+"、other："+other+"]");
		RelationInfo model=new RelationInfo();
		model.setGetwayfiletypeid(getwayfiletypeid);
		model.setImportsfiletypeid(importsfiletypeid);
		model.setOther(other);
		model.setGetwayfileno(getwayfileno);
		model.setImportsfileno(importsfileno);
		model.setInsurancelistno(insurancelistno);
		model.setInsurancecompanyname(insurancecompanyname);
		model.setInsurancedate(new SimpleDateFormat("yyyy-MM-dd").parse(insurancedate));
		model.setExpirydate(new SimpleDateFormat("yyyy-MM-dd").parse(expirydate));
		model.setTractorinfoId(tractorinfoId);
		
		if (serviceManager.getRelationInfoService().addRelationInfo(model)) {
			log.info("添加拖拉机相关资料信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			//response.getWriter().write("{success: true}");
		} else {
			//response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	
	}
