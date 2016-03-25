package Ynzc.YnzcAms.Controller;

import java.io.File;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.StringUtil;
import Ynzc.YnzcAms.Model.LogoutView;
import Ynzc.YnzcAms.Model.Loyout;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Plate;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;
public class LogoutController extends BaseController{
	
	private final static Logger log = Logger.getLogger(LogoutController.class);

	//查询分页数据
	public void getLogoutViewListByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getAllListByPage");
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
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));

		String state = request.getParameter("state");
		String codenum = request.getParameter("codenum");
		String owner = request.getParameter("owner");
		String machinetype = request.getParameter("machinetype");
		String plantType = request.getParameter("plantType");
		String checkexpriydate = request.getParameter("checkexpriydate");
		String regcerno = request.getParameter("regcerno");
		String cardid = request.getParameter("cardid");
		String engineno = request.getParameter("engineno");
		String logouttype = request.getParameter("logouttype");
		User user=(User)request.getSession().getAttribute("user");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String condition = "";//设置查询条件为空
	    condition=TractorInfoSearch.getBusinessCondition(state, codenum, owner, machinetype, plantType, checkexpriydate, regcerno, cardid, engineno, logouttype, "logout");
		List<LogoutView> res = serviceManager.getLoyoutService().getLoyoutList(page, condition,regionid);
		JSONArray jsonItems = new JSONArray();
		for (LogoutView u : res) {
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
	
	
	//添加注销信息
	public void addLogout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("add Logout");
		User user=(User)request.getSession().getAttribute("user");
		int tractorinfoid=Integer.parseInt(request.getParameter("tractorinfoid").trim());
		int logtouttype =Integer.parseInt(request.getParameter("logtouttype").trim());
		String relationinfo =request.getParameter("relationinfo");
		String logoutreasons =request.getParameter("logoutreasons");
		String stopdate =request.getParameter("stopdate");
		String checkinmen =request.getParameter("checkinmen");
		String checkindate =request.getParameter("checkindate");
		String licensemen =request.getParameter("licensemen");
		String licensedate =request.getParameter("licensedate");
		String businessmen =request.getParameter("businessmen");
		String businessdate =request.getParameter("businessdate");
		Loyout logout=new Loyout();
		logout.setTractorinfoid(tractorinfoid);
		logout.setLogoutnum(0);
		logout.setLogtouttype(logtouttype);
		logout.setRelationinfo(relationinfo);
		if(logoutreasons!=null && !logoutreasons.equals("")){
			logout.setLogoutreasons(Integer.parseInt(logoutreasons));
		}
		if(stopdate!=null && !stopdate.equals("")){
			logout.setStopdate(new SimpleDateFormat("yyyy-MM-dd").parse(stopdate.trim()));
		}
		logout.setCheckinmen(checkinmen);
		logout.setCheckindate(new SimpleDateFormat("yyyy-MM-dd").parse(checkindate.trim()));
		logout.setLicensemen(licensemen);
		logout.setLicensedate(new SimpleDateFormat("yyyy-MM-dd").parse(licensedate.trim()));
		logout.setBusinessmen(businessmen);
		logout.setBusinessdate(new SimpleDateFormat("yyyy-MM-dd").parse(businessdate.trim()));
		logout.setCheckstate(0);
		logout.setOpertator(user.getRealname());
		logout.setOperatedate(new Date());
		
		if (serviceManager.getLoyoutService().addLoyout(logout)) {
			TractorInfo tractorInfo=this.serviceManager.getTractorInfoService().findTractorInfoById(tractorinfoid);
			tractorInfo.setStatus(4);
			this.serviceManager.getTractorInfoService().updateTractorInfo(tractorInfo);
			log.info("保存注销信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'保存注销信息失败，请重新尝试!'}");
		}
		
	}
	
	
	//批量上报
	public void ReportedLogOut(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("ReportedLogOut");
		User user=(User)request.getSession().getAttribute("user");
		String reportlogoutids = (String) request.getParameter("reportlogoutids").trim();
        if(!reportlogoutids.equals("")){
        	this.serviceManager.getLoyoutService().updateLoyoutStateByIds(1, reportlogoutids);
        	//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarLogoutTime();
            }
			LogoutOperation operation = new LogoutOperation(audittime,user.getRealname(),request.getRemoteAddr(),reportlogoutids);
			Thread thread = new Thread(operation, "LogOut");
			thread.start();
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on report LogOut");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
        }
	}
	private class LogoutOperation implements Runnable {
		private int time;
		String realname;
		String remoteaddr;
		String auditlogoutids;
		public LogoutOperation(int time,String realname,String remoteaddr,String auditlogoutids){
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditlogoutids=auditlogoutids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,realname,remoteaddr,auditlogoutids);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String remoteaddr;
		String auditlogoutids;
		public EggTimer(int time,String realname,String remoteaddr,String auditlogoutids) {
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditlogoutids=auditlogoutids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditLogout(realname,remoteaddr,auditlogoutids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
	//更新注销信息
	public void updateLogout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("update Logout");
		int id=Integer.parseInt(request.getParameter("id").trim());
		int tractorinfoid=Integer.parseInt(request.getParameter("tractorinfoid").trim());
		int logtouttype =Integer.parseInt(request.getParameter("logtouttype").trim());
		int logoutnum=Integer.parseInt(request.getParameter("logoutnum").trim());
		String relationinfo =request.getParameter("relationinfo");
		String logoutreasons =request.getParameter("logoutreasons");
		String stopdate =request.getParameter("stopdate");
		String checkinmen =request.getParameter("checkinmen");
		String checkindate =request.getParameter("checkindate");
		String licensemen =request.getParameter("licensemen");
		String licensedate =request.getParameter("licensedate");
		String businessmen =request.getParameter("businessmen");
		String businessdate =request.getParameter("businessdate");
		String checkmen =request.getParameter("checkmen");
		int checkstate =Integer.parseInt(request.getParameter("checkstate").trim());
		String checkcontent =request.getParameter("checkcontent");
		String checkdate =request.getParameter("checkdate");
		String checkip =request.getParameter("checkip");
		String opertator =request.getParameter("opertator");
		String operatedate =request.getParameter("operatedate");
		Loyout logout=new Loyout();
		logout.setId(id);
		logout.setTractorinfoid(tractorinfoid);
		logout.setLogtouttype(logtouttype);
		logout.setLogoutnum(logoutnum);		
		logout.setRelationinfo(relationinfo);
		
		if(logoutreasons!=null && !logoutreasons.equals("")){
			logout.setLogoutreasons(Integer.parseInt(logoutreasons));
		}
		if(stopdate!=null && !stopdate.equals("")){
			logout.setStopdate(new SimpleDateFormat("yyyy-MM-dd").parse(stopdate.trim()));
		}
		logout.setCheckinmen(checkinmen);
		logout.setCheckindate(new SimpleDateFormat("yyyy-MM-dd").parse(checkindate.trim()));
		logout.setLicensemen(licensemen);
		logout.setLicensedate(new SimpleDateFormat("yyyy-MM-dd").parse(licensedate.trim()));
		logout.setBusinessmen(businessmen);
		logout.setBusinessdate(new SimpleDateFormat("yyyy-MM-dd").parse(businessdate.trim()));
		logout.setCheckmen(checkmen);
		logout.setCheckstate(checkstate);
		logout.setCheckcontent(checkcontent);
		if(checkdate!=null && !checkdate.equals("")){
			logout.setCheckdate(new SimpleDateFormat("yyyy-MM-dd").parse(checkdate.trim()));
		}
		logout.setCheckip(checkip);
		logout.setOpertator(opertator);
		logout.setOperatedate(new SimpleDateFormat("yyyy-MM-dd").parse(operatedate.trim()));
		
		if (serviceManager.getLoyoutService().updateLoyout(logout)) {
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'保存注销信息失败，请重新尝试!'}");
		}
		
	}
	
	//删除数据
	public void delLogout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del logout");
		String  mydellogoutids =request.getParameter("mydellogoutids");
		String tractorids =request.getParameter("tractorids");
		 if(! mydellogoutids.equals("")){
			 if(this.serviceManager.getLoyoutService().delLoyoutByIds( mydellogoutids)){
				   if(!tractorids.equals("")){
	        			tractorids=tractorids.substring(0,tractorids.length()-1);
	        			this.serviceManager.getTractorInfoService().updateTractorStateByIds(2, tractorids,TractorInfoSearch.GetBusinessOverCondtion());	
	        		}
				   response.getWriter().write("{success: true}");
			 }else{
				 log.info("Err on del logout");
				 response.getWriter().write("{success: false}");
			 }
		 }
	}
	
	//审核注销信息
	public void auditLogout(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Update logoutInfo");

		User user=(User)request.getSession().getAttribute("user");
		String auditmodels = (String) request.getParameter("auditmodels").trim();//得到需要审核的注销信息
		int state =Integer.parseInt(request.getParameter("state").trim());//得到需要审核的状态
		String approvacontext = (String) request.getParameter("approvacontext").trim();//得到需要审核的审核意见
		JSONArray jsonArray = JSONArray.fromObject(auditmodels);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		boolean isSuccess=true;
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			LogoutView viewmodel = (LogoutView)JSONObject.toBean(jsonObject,LogoutView.class);
			Loyout logout=new Loyout();
			logout.setId(viewmodel.getId());
			logout.setTractorinfoid(viewmodel.getTractorinfoId());
			logout.setLogtouttype(viewmodel.getLogtouttype());
			logout.setLogoutnum(viewmodel.getLogoutnum());
			logout.setRelationinfo(viewmodel.getRelationinfo());
			logout.setLogoutreasons(viewmodel.getLogoutreasons());
			logout.setStopdate(viewmodel.getStopdate());
			logout.setCheckinmen(viewmodel.getCheckinmen());
			logout.setCheckindate(viewmodel.getCheckindate());
			logout.setLicensemen(viewmodel.getLicensemen());
			logout.setLicensedate(viewmodel.getLicensedate());
			logout.setBusinessmen(viewmodel.getBusinessmen());
			logout.setBusinessdate(viewmodel.getBusinessdate());
			logout.setCheckmen(user.getRealname());
			logout.setCheckstate(state);
			logout.setCheckcontent(approvacontext);
			logout.setCheckdate(new Date());
			logout.setCheckip(request.getRemoteAddr());
			logout.setOpertator(viewmodel.getOpertator());
			logout.setOperatedate(viewmodel.getOperatedate());
			if(state==2){
				//更新车辆状态
				TractorInfo tractorinfoModel=this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
				if(tractorinfoModel!=null){
					if(viewmodel.getLogtouttype()==0){
						logout.setLogoutnum(this.serviceManager.getLoyoutService().getMaxLoginNumber()+1);
						tractorinfoModel.setStatus(10);
						Plate plate=new Plate();
						String platehead=(String) request.getSession().getAttribute("platecode");
						plate=serviceManager.getPlateService().getPlate(viewmodel.getLicense(), platehead);
						plate.setStatus(5);
						serviceManager.getPlateService().updatePlateInfo(plate);
					}else{
						if(tractorinfoModel.getStatus()==4){
							tractorinfoModel.setStatus(2);
						}	
					}
					this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
				}else{
					response.getWriter().write("{success: false}");
					break;
				}				
			}
			else if(state==3){
				if(viewmodel.getCheckstate()==2){
					TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
					if(tractorinfoModel.getStatus()==2 || tractorinfoModel.getStatus()==10){
						tractorinfoModel.setStatus(4);	
					}
					this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
				}
			}
			this.serviceManager.getLoyoutService().updateLoyout(logout);//更新审核信息
		}
		response.getWriter().write("{success: true}");

	}
	
	public void ThreadAuditLogout(String checkusername,String checkip,String auditcarcheckinfoIds){
		//得到上报注销信息
		List<LogoutView> res = serviceManager.getLoyoutService().getLogoutViewListByIds(auditcarcheckinfoIds);
		for (LogoutView viewmodel : res) {
			if(viewmodel.getCheckstate()==1){
				Loyout logout=new Loyout();
				logout.setId(viewmodel.getId());
				logout.setTractorinfoid(viewmodel.getTractorinfoId());
				logout.setLogtouttype(viewmodel.getLogtouttype());
				logout.setLogoutnum(viewmodel.getLogoutnum());
				logout.setRelationinfo(viewmodel.getRelationinfo());
				logout.setLogoutreasons(viewmodel.getLogoutreasons());
				logout.setStopdate(viewmodel.getStopdate());
				logout.setCheckinmen(viewmodel.getCheckinmen());
				logout.setCheckindate(viewmodel.getCheckindate());
				logout.setLicensemen(viewmodel.getLicensemen());
				logout.setLicensedate(viewmodel.getLicensedate());
				logout.setBusinessmen(viewmodel.getBusinessmen());
				logout.setBusinessdate(viewmodel.getBusinessdate());
				logout.setCheckmen(checkusername);
				logout.setCheckstate(2);
				logout.setCheckcontent("审核通过");
				logout.setCheckdate(new Date());
				logout.setCheckip(checkip);
				logout.setOpertator(viewmodel.getOpertator());
				logout.setOperatedate(viewmodel.getOperatedate());
				
				//更新车辆状态
				TractorInfo tractorinfoModel=this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
				if(tractorinfoModel!=null){
					if(viewmodel.getLogtouttype()==0){
						logout.setLogoutnum(this.serviceManager.getLoyoutService().getMaxLoginNumber()+1);
						tractorinfoModel.setStatus(10);
						Plate plate=new Plate();
						//String platehead=(String) request.getSession().getAttribute("platecode");
						plate=serviceManager.getPlateService().getPlate(viewmodel.getLicense(), viewmodel.getPlatecode());
						plate.setStatus(5);
						serviceManager.getPlateService().updatePlateInfo(plate);
					}else{
						if(tractorinfoModel.getStatus()==4){
							tractorinfoModel.setStatus(2);
						}	
					}
					this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
				}
				this.serviceManager.getLoyoutService().updateLoyout(logout);//更新审核信息
			}
		}
		
	}
	//打印业务流程
	public void logOutInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getLoyoutService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_logoutFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorRegistrationRecordProcess1.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	//打印云南省拖拉机延缓报废申请、审批表
	public void PrintLogoutReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();//拖拉机ID
		String wordType=request.getParameter("wordType");
		List<TractorScrapApplicationSource> list=this.serviceManager.getLoyoutService().PrintLogoutReport(Integer.parseInt(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_LogoutReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		//得到边距设置
		WordSet ws=serviceManager.getWordSetService().findWordSetByWordTypeandUnitid(wordType, user.getUnitid());
		if(ws==null){
			ws = new WordSet();
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("30");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("30");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("40");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("20");
			}
		}else{
			if(!StringUtil.isNotNullEmptyStr(ws.getLeftMargin())){
				ws.setLeftMargin("30");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getRightMargin())){
				ws.setRightMargin("30");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getTopMargin())){
				ws.setTopMargin("40");
			}
			if(!StringUtil.isNotNullEmptyStr(ws.getBottomMargin())){
				ws.setBottomMargin("20");
			}
		}
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorScrapApplication.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));

	}
		
}
