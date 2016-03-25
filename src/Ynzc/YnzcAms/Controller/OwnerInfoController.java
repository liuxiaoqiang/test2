package Ynzc.YnzcAms.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class OwnerInfoController extends  BaseController{
	private final static Logger log = Logger.getLogger(OwnerInfoController.class);

	//添加拖拉机所有人信息
	public void addOwnerInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		
		String owner = (String) request.getParameter("owner").trim();//拖拉机所有人信息：所有者
		String realcertificatetype = (String) request.getParameter("realcertificatetype").trim();//拖拉机所有人信息表：有效证件类型
		String realcertificateno = (String) request.getParameter("realcertificateno").trim();//拖拉机所有人信息表：有效证件号码
		String address = (String) request.getParameter("address").trim();//拖拉机所有人信息表：家庭联系地址
		String tempaddress = (String) request.getParameter("tempaddress").trim();//拖拉机所有人信息表：现居住地址
		String istemplived = (String) request.getParameter("istemplived").trim();//拖拉机所有人信息表：是否暂住
		String templivefiletype = (String) request.getParameter("templivefiletype").trim();//拖拉机所有人信息表：暂住证类别
		String timplivefileno = (String) request.getParameter("timplivefileno").trim();//拖拉机所有人信息表：暂住证号码
		String telephone = (String) request.getParameter("telephone").trim();//拖拉机所有人信息表：联系电话
		String isUnion = (String) request.getParameter("isUnion").trim();//拖拉机所有人信息表：单位还是个人
		String zipCode = (String) request.getParameter("zipCode").trim();//拖拉机所有人信息表：邮政编码
		int tractorinfoId=Integer.parseInt(request.getSession().getAttribute("tractorInfoId").toString());
		 
		log.info("Add new OwnerInfo:[owner:"+owner+"、realcertificatetype："+realcertificatetype+"、realcertificateno："+realcertificateno+"]");
		OwnerInfo model=new OwnerInfo();
		model.setOwner(owner);
		model.setRealcertificatetype(realcertificatetype);
		model.setRealcertificateno(realcertificateno);
		model.setAddress(address);
		model.setTempaddress(tempaddress);
		model.setIstemplived(Integer.parseInt(istemplived));
		model.setTemplivefiletype(Integer.parseInt(templivefiletype));
		model.setTimplivefileno(timplivefileno);
		model.setTelephone(telephone);
		model.setIsUnion(Integer.parseInt(isUnion));
		model.setZipCode(zipCode);
		model.setTractorinfoId(tractorinfoId);
		
		if (serviceManager.getOwnerInfoService().addOwnerInfo(model)) {
			log.info("添加拖拉机所有人信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			//response.getWriter().write("{success: true}");
		} else {
			//response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	
}
