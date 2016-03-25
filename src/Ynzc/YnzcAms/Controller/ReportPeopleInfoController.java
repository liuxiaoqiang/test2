package Ynzc.YnzcAms.Controller;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.StringUtil;
import Ynzc.Util.YnzcAmsUtil;
import Ynzc.YnzcAms.Model.PeopleBodyInfoReportSource;
import Ynzc.YnzcAms.Model.PeopleBodyReportSource;
import Ynzc.YnzcAms.Model.PeopleReportSource;
import Ynzc.YnzcAms.Model.PictureUrl;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;

public class ReportPeopleInfoController extends BaseController{
	private final static Logger log = Logger.getLogger(ReportPeopleInfoController.class);
	 
	public void getPeopleInfoReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<PeopleReportSource> list = serviceManager.getPeopleInfoService().findPeopleinfo(Integer.valueOf(id));
		List<PictureUrl> list2 = new ArrayList<PictureUrl>();
		PictureUrl pu = new PictureUrl();
		pu.setPictureUrl(request.getRealPath("/")+"Report/images/2.jpg");
		list2.add(pu);
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setPicture(request.getSession().getServletContext().getRealPath("/")+list.get(0).getPicture().substring(2));
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_PeopleInfo_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		User user=(User)request.getSession().getAttribute("user");
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/licenseApplicationReport.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		
		String reportFilePath = request.getRealPath("/") + "/Report/licenseApplicationReport2.jasper";
		File reportFile = new File(reportFilePath);
		if (!reportFile.exists()){
			throw new JRRuntimeException("没找到打印模板路径");
		}
		JasperReport report2 = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JRDataSource dataSource2 = new JRBeanCollectionDataSource(list2);
		String path = FileUrl + fineName + ".pdf";
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		JasperPrint jasperPrint2 = JasperFillManager.fillReport(report2, map, dataSource2);
		List jasperPrintList = new ArrayList();
		jasperPrintList.add(jasperPrint);
		jasperPrintList.add(jasperPrint2);
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,jasperPrintList);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,path);
        exporter.exportReport(); 
		
        //JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void getPeopleInfoOperationReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<PeopleReportSource> list = serviceManager.getPeopleInfoService().findOperationPeopleinfo(Integer.valueOf(id));
		List<PictureUrl> list2 = new ArrayList<PictureUrl>();
		PictureUrl pu = new PictureUrl();
		pu.setPictureUrl(request.getRealPath("/")+"Report/images/2.jpg");
		list2.add(pu);
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setPicture(request.getSession().getServletContext().getRealPath("/")+list.get(0).getPicture().substring(2));
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_PeopleInfo_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		User user=(User)request.getSession().getAttribute("user");
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/licenseApplicationReport.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		
		String reportFilePath = request.getRealPath("/") + "/Report/licenseApplicationReport2.jasper";
		File reportFile = new File(reportFilePath);
		if (!reportFile.exists()){
			throw new JRRuntimeException("没找到打印模板路径");
		}
		JasperReport report2 = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JRDataSource dataSource2 = new JRBeanCollectionDataSource(list2);
		String path = FileUrl + fineName + ".pdf";
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		JasperPrint jasperPrint2 = JasperFillManager.fillReport(report2, map, dataSource2);
		List jasperPrintList = new ArrayList();
		jasperPrintList.add(jasperPrint);
		jasperPrintList.add(jasperPrint2);
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,jasperPrintList);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,path);
        exporter.exportReport(); 
		
        //JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void getPeopleHealthInfoReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<PeopleBodyInfoReportSource> list = serviceManager.getBodyInfoService().getBodyInfo(Integer.valueOf(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setPicture(request.getSession().getServletContext().getRealPath("/")+list.get(0).getPicture().substring(2));
		list.get(0).setDrivingLicenceName(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceName())));
		String fineName = list.get(0).getIdCard()+"_PeopleHealthInfo_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		User user=(User)request.getSession().getAttribute("user");
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/peoplePhysicalProve2.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void getPeopleHealthReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<PeopleBodyReportSource> list = serviceManager.getBodyInfoService().getAllBodyInfo(Integer.valueOf(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setPicture(request.getSession().getServletContext().getRealPath("/")+list.get(0).getPicture().substring(2));
		list.get(0).setDrivingLicenceName(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceName())));
		String fineName = list.get(0).getIdCard()+"_PeopleHealth_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		User user=(User)request.getSession().getAttribute("user");
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/peoplePhysicalProve.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
}
