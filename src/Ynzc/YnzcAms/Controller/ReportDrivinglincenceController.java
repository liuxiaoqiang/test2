package Ynzc.YnzcAms.Controller;

import java.io.File;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.StringUtil;
import Ynzc.Util.YnzcAmsUtil;
import Ynzc.YnzcAms.Model.DrivingLicenceReportSource;
import Ynzc.YnzcAms.Model.TractorLicenseOutNoticeSource;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;

public class ReportDrivinglincenceController extends BaseController{
	private final static Logger log = Logger.getLogger(ReportDrivinglincenceController.class);
	 
	public void getDrivingLicenceReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String peopleInfoId = request.getParameter("peopleInfoId").trim();
		String drivingLicenceTypeId = request.getParameter("drivingLicenceTypeId").trim();
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
		List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(id,peopleInfoId,drivingLicenceTypeId,1);
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		if(!Ynzc.Util.StringUtil.isNotNullEmptyStr(list.get(0).getStartDate())){
			list.get(0).setStartDate(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
		}
		if(!Ynzc.Util.StringUtil.isNotNullEmptyStr(list.get(0).getEndDate())){
			list.get(0).setEndDate(DateTimeUtil.formatDate(DateTimeUtil.addYear(6)));
		}
		String address = list.get(0).getAddress1();
		if(address.length()>18){
			list.get(0).setAddress1(address.substring(0,18));
			list.get(0).setAddress2(address.substring(18, address.length()));
		}
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_DrivingLicence_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());

		WordSet ws=serviceManager.getWordSetService().findWordSetByWordTypeandUnitid(wordType, user.getUnitid());
		if(ws==null){
			ws = new WordSet();
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("5");
			}
		}else{
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("5");
			}
		}
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/drivingLicence.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void getDrivingLicenceOperation(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String drivingLicenceId = request.getParameter("id").trim();
		String peopleInfoId = request.getParameter("peopleInfoId").trim();
		String drivingLicenceTypeId = request.getParameter("drivingLicenceTypeId").trim();
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
		List<DrivingLicenceReportSource> list = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(drivingLicenceId,peopleInfoId,drivingLicenceTypeId,3);
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String address = list.get(0).getAddress1();
		if(address.length()>18){
			list.get(0).setAddress1(address.substring(0,18));
			list.get(0).setAddress2(address.substring(18, address.length()));
		}
		List<DrivingLicenceReportSource> listStr = serviceManager.getDrivingLicenceService().drivingLicenceReportSource(drivingLicenceId,peopleInfoId,drivingLicenceTypeId,1);
		list.get(0).setApplicationDate(listStr.get(0).getApplicationDate());
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_DrivingLicenceOperation_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		WordSet ws=serviceManager.getWordSetService().findWordSetByWordTypeandUnitid(wordType, user.getUnitid());
		if(ws==null){
			ws = new WordSet();
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("5");
			}
		}else{
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("5");
			}
		}
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/drivingLicence.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void tractorLicenseOutNotice(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
		List<TractorLicenseOutNoticeSource> list = serviceManager.getDrivingLicenceShiftToService().tractorLicenseOutNotice(Integer.valueOf(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getDrivingLicenceNo()+"_TractorLicenseOutNotice_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		WordSet ws=serviceManager.getWordSetService().findWordSetByWordTypeandUnitid(wordType, user.getUnitid());
		if(ws==null){
			ws = new WordSet();
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("5");
			}
		}else{
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("5");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("5");
			}
		}
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorLicenseOutNotice.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
}
