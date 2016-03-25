package Ynzc.YnzcAms.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ReportController extends BaseController{
	private final static Logger log = Logger.getLogger(ReportController.class);
	
	public void getDrivingLicenceReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int type = 1;
		HashMap params=new HashMap();
		if(request.getParameter("type") != null && !"".equals(request.getParameter("type").trim())){
			type = Integer.valueOf(request.getParameter("type"));
		}
		String id = request.getParameter("id").trim();
		String peopleInfoId = request.getParameter("peopleInfoId").trim();
		String drivingLicenceTypeId = request.getParameter("drivingLicenceTypeId").trim();
		String drivingLicenceId = request.getParameter("drivingLicenceId").trim();
//		if(type == 1){
//			if (serviceManager.getDrivingLicenceService().checkDrivingLicenceOperation(id)){
//				response.getWriter().write("{success:false,reason:'请在对应的打印业务中打印'}");
//			} else {
//				List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(id,peopleInfoId,drivingLicenceTypeId,1);
//				list.get(0).setStartDate(DateTimeUtil.getNow());
//				list.get(0).setEndDate(GetDate.addYear(6));
//				JRBeanCollectionDataSource jcds = new JRBeanCollectionDataSource(list);
//				String reportFileName = request.getRealPath("/") + "/Report/drivingLicence.jasper";
//				JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName,params,jcds);
//				request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
//				response.getWriter().write("{success:true}");
//			}
//		}else if(type == 2){
//			List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(drivingLicenceId,peopleInfoId,drivingLicenceTypeId,1);
//			JRBeanCollectionDataSource jcds = new JRBeanCollectionDataSource(list);
//			String reportFileName = request.getRealPath("/") + "/Report/drivingLicence.jasper";
//			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName,params,jcds);
//			request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
//			response.getWriter().write("{success:true}");
//		}else if(type == 3){
//			List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(drivingLicenceId,peopleInfoId,drivingLicenceTypeId,1);
//			JRBeanCollectionDataSource jcds = new JRBeanCollectionDataSource(list);
//			String reportFileName = request.getRealPath("/") + "/Report/drivingLicence.jasper";
//			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName,params,jcds);
//			request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
//			response.getWriter().write("{success:true}");
//		}else if(type == 4){
//			List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(id,peopleInfoId,drivingLicenceTypeId,1);
//			JRBeanCollectionDataSource jcds = new JRBeanCollectionDataSource(list);
//			String reportFileName = request.getRealPath("/") + "/Report/drivingLicence.jasper";
//			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName,params,jcds);
//			request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
//			response.getWriter().write("{success:true}");
//		}else if(type == 5){
//			List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(drivingLicenceId,peopleInfoId,drivingLicenceTypeId,1);
//			JRBeanCollectionDataSource jcds = new JRBeanCollectionDataSource(list);
//			String reportFileName = request.getRealPath("/") + "/Report/drivingLicence.jasper";
//			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName,params,jcds);
//			request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
//			response.getWriter().write("{success:true}");
//		}else if(type == 6){
//			List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(drivingLicenceId,peopleInfoId,drivingLicenceTypeId,2);
//			JRBeanCollectionDataSource jcds = new JRBeanCollectionDataSource(list);
//			String reportFileName = request.getRealPath("/") + "/Report/drivingLicence.jasper";
//			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName,params,jcds);
//			request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
//			response.getWriter().write("{success:true}");
//		}
	}
}
