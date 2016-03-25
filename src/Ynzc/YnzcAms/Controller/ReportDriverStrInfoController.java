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
import Ynzc.YnzcAms.Model.DrivingLicenceFlowReportSource;
import Ynzc.YnzcAms.Model.DrivingSkillExamProveSource;
import Ynzc.YnzcAms.Model.PictureUrl;
import Ynzc.YnzcAms.Model.PracticeMakeupExam;
import Ynzc.YnzcAms.Model.TheoryMakeupExam;
import Ynzc.YnzcAms.Model.TractorExamScoreTableSource;
import Ynzc.YnzcAms.Model.TractorLicenseProcessSource;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;

public class ReportDriverStrInfoController extends BaseController{
	private final static Logger log = Logger.getLogger(ReportDriverStrInfoController.class);
	 
	public void getDriverStrAllowCertificateReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String classInfoId = request.getParameter("driverClassId").trim();
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		String wordType=request.getParameter("wordType");
		List<DrivingSkillExamProveSource> list = serviceManager.getDriverClassTeamService().getStrAllowCertificateInfo(Integer.valueOf(id),Integer.valueOf(classInfoId));
		
		List<PictureUrl> list2 = new ArrayList<PictureUrl>();
		PictureUrl pu = new PictureUrl();
		pu.setPictureUrl(request.getRealPath("/")+"Report/images/2.jpg");
		list2.add(pu);
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setWrite_userId(user.getUsername());
		list.get(0).setExamAddress(unit.getUseunit());
		list.get(0).setDrivingLicenceName(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceName())));
		String fineName = list.get(0).getIdCard()+"_DriverStrAllowCertificate_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/drivingSkillExamProve.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		
		String reportFilePath = request.getRealPath("/") + "/Report/licenseApplicationReport2.jasper";
		File reportFile = new File(reportFilePath);
		if (!reportFile.exists()){
			throw new JRRuntimeException("没找到打印模板路径");
		}
		JasperReport report2 = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JRDataSource dataSource2 = new JRBeanCollectionDataSource(list2);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		JasperPrint jasperPrint2 = JasperFillManager.fillReport(report2, map, dataSource2);
		String path = FileUrl + fineName + ".pdf";
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
	
	public void strExam(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<DrivingLicenceFlowReportSource> list = serviceManager.getDriverStrInfoService().strExam(Integer.valueOf(id));
		List<PictureUrl> list2 = new ArrayList<PictureUrl>();
		PictureUrl pu = new PictureUrl();
		pu.setPictureUrl(request.getRealPath("/")+"Report/images/1.jpg");
		list2.add(pu);
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_strExam_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorExamScoreTable2.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		
		String reportFilePath = request.getRealPath("/") + "/Report/licenseApplicationReport2.jasper";
		File reportFile = new File(reportFilePath);
		if (!reportFile.exists()){
			throw new JRRuntimeException("没找到打印模板路径");
		}
		JasperReport report2 = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JRDataSource dataSource2 = new JRBeanCollectionDataSource(list2);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		JasperPrint jasperPrint2 = JasperFillManager.fillReport(report2, map, dataSource2);
		String path = FileUrl + fineName + ".pdf";
		List jasperPrintList = new ArrayList();
		jasperPrintList.add(jasperPrint);
		jasperPrintList.add(jasperPrint2);
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,jasperPrintList);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,path);
        exporter.exportReport(); 
		
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void strExamInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String theoryId = request.getParameter("theoryId").trim();
		String practiceId = request.getParameter("practiceId").trim();
		String wordType=request.getParameter("wordType");
		List<TractorExamScoreTableSource> list = serviceManager.getDriverStrInfoService().strExamInfo(Integer.valueOf(id));
		List<TheoryMakeupExam> theoryMakeupExams = serviceManager.getTheoryExamService().getAllTheoryMakeupExam(Integer.valueOf(theoryId));
		List<PracticeMakeupExam> practiceMakeupExams = serviceManager.getPracticeExamService().getAllPracticeMakeupExam(Integer.valueOf(practiceId));
		List<PictureUrl> list2 = new ArrayList<PictureUrl>();
		PictureUrl pu = new PictureUrl();
		pu.setPictureUrl(request.getRealPath("/")+"Report/images/1.jpg");
		list2.add(pu);
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		if(theoryMakeupExams.size() > 0){
			if(theoryMakeupExams.size() >= 1){
				list.get(0).setTheoryResult_1(theoryMakeupExams.get(0).getTheoryMakeupResult());
				list.get(0).setExaminerOne_1(theoryMakeupExams.get(0).getExaminerTheoryMakeupOne());
				list.get(0).setExaminerTwo_1(theoryMakeupExams.get(0).getExaminerTheoryMakeupTwo());
				list.get(0).setTheoryDate_1(theoryMakeupExams.get(0).getTheoryMakeupDate().toString());
			}
			if(theoryMakeupExams.size() > 1){
				list.get(0).setTheoryMakeupResult_2(theoryMakeupExams.get(1).getTheoryMakeupResult());
				list.get(0).setExaminerTheoryMakeupOne_2(theoryMakeupExams.get(1).getExaminerTheoryMakeupOne());
				list.get(0).setExaminerTheoryMakeupTwo_2(theoryMakeupExams.get(1).getExaminerTheoryMakeupTwo());
				list.get(0).setTheoryMakeupDate_2(theoryMakeupExams.get(1).getTheoryMakeupDate().toString());
			}
		}
		if(practiceMakeupExams.size() > 0){
			if(practiceMakeupExams.size() >= 1){
				list.get(0).setFieldResult_1(practiceMakeupExams.get(0).getFieldMakeupResult());
				list.get(0).setExaminerFieldOne_1(practiceMakeupExams.get(0).getExaminerMakeupFieldOne());
				list.get(0).setExaminerFieldTwo_1(practiceMakeupExams.get(0).getExaminerMakeupFieldTwo());
				list.get(0).setFieldDate_1(practiceMakeupExams.get(0).getFieldMakeupDate().toString());
				list.get(0).setMachineResult_1(practiceMakeupExams.get(0).getMachineMakeupResult());
				list.get(0).setExaminerMachineOne_1(practiceMakeupExams.get(0).getExaminerMakeupMachineOne());
				list.get(0).setExaminerMachineTwo_1(practiceMakeupExams.get(0).getExaminerMakeupMachineTwo());
				list.get(0).setMachineResult_1(practiceMakeupExams.get(0).getMachineMakeupDate().toString());
				list.get(0).setRoadResult_1(practiceMakeupExams.get(0).getRoadMakeupResult());
				list.get(0).setExaminerRoadTwo_1(practiceMakeupExams.get(0).getExaminerMakeupRoadOne());
				list.get(0).setExaminerRoadTwo_1(practiceMakeupExams.get(0).getExaminerMakeupRoadTwo());
				list.get(0).setRoadDate_1(practiceMakeupExams.get(0).getRoadMakeupDate().toString());
			}
			if(practiceMakeupExams.size() > 1){
				list.get(0).setFieldMakeupResult_2(practiceMakeupExams.get(1).getFieldMakeupResult());
				list.get(0).setExaminerMakeupFieldOne_2(practiceMakeupExams.get(1).getExaminerMakeupFieldOne());
				list.get(0).setExaminerMakeupFieldTwo_2(practiceMakeupExams.get(1).getExaminerMakeupFieldTwo());
				list.get(0).setFieldMakeupDate_2(practiceMakeupExams.get(0).getFieldMakeupDate().toString());
				list.get(0).setMachineMakeupResult_2(practiceMakeupExams.get(1).getMachineMakeupResult());
				list.get(0).setExaminerMakeupMachineOne_2(practiceMakeupExams.get(1).getExaminerMakeupMachineOne());
				list.get(0).setExaminerMakeupMachineTwo_2(practiceMakeupExams.get(1).getExaminerMakeupMachineTwo());
				list.get(0).setMachineMakeupDate_2(practiceMakeupExams.get(1).getMachineMakeupDate().toString());
				list.get(0).setRoadMakeupResult_2(practiceMakeupExams.get(1).getRoadMakeupResult());
				list.get(0).setExaminerMakeupRoadOne_2(practiceMakeupExams.get(1).getExaminerMakeupRoadOne());
				list.get(0).setExaminerMakeupRoadTwo_2(practiceMakeupExams.get(1).getExaminerMakeupRoadTwo());
				list.get(0).setRoadMakeupDate_2(practiceMakeupExams.get(1).getRoadMakeupDate().toString());
			}
		}
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_strExamInfo_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorExamScoreTable.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		
		String reportFilePath = request.getRealPath("/") + "/Report/licenseApplicationReport2.jasper";
		File reportFile = new File(reportFilePath);
		if (!reportFile.exists()){
			throw new JRRuntimeException("没找到打印模板路径");
		}
		JasperReport report2 = (JasperReport) JRLoader.loadObject(reportFile.getPath());
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JRDataSource dataSource2 = new JRBeanCollectionDataSource(list2);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		JasperPrint jasperPrint2 = JasperFillManager.fillReport(report2, map, dataSource2);
		String path = FileUrl + fineName + ".pdf";
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
	
	public void tractorLicenseProcess(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		String peopleInfoId = request.getParameter("peopleInfoId").trim();
		String wordType=request.getParameter("wordType");
		List<TractorLicenseProcessSource> list = serviceManager.getDriverStrInfoService().tractorLicenseProcess(Integer.valueOf(id),Integer.valueOf(peopleInfoId));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		list.get(0).setDrivingLicenceTypeId(YnzcAmsUtil.findDrivingLicenceType(Integer.valueOf(list.get(0).getDrivingLicenceTypeId())));
		String fineName = list.get(0).getIdCard()+"_tractorLicenseProcess_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorLicenseProcess.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
}
