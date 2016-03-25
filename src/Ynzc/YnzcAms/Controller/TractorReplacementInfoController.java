package Ynzc.YnzcAms.Controller;

import java.io.File;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateOperateRecord;
import Ynzc.YnzcAms.Model.PrintFlag;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorReplacementApplicationSource;
import Ynzc.YnzcAms.Model.TractorReplacementInfo;
import Ynzc.YnzcAms.Model.TractorReplacementInfoView;
import Ynzc.YnzcAms.Model.TractorScrapApplicationSource;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

public class TractorReplacementInfoController extends  BaseController{
	
	private final static Logger log = Logger.getLogger(CertificateController.class);
		//查询分页数据
	public void getAllReplacementInfoListByPage(HttpServletRequest request,
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
		String condition = " 1=1 ";//设置查询条件为空
		String codenum = request.getParameter("codenum");
		String owner = request.getParameter("owner");
		String machinetype = request.getParameter("machinetype");
		String plantType = request.getParameter("plantType");
		String checkexpriydate = request.getParameter("checkexpriydate");
		String regcerno = request.getParameter("regcerno");
		String cardid = request.getParameter("cardid");
		String engineno = request.getParameter("engineno");
		String recplacementinfotype = request.getParameter("recplacementinfotype");
		User user=(User)request.getSession().getAttribute("user");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
	    condition=TractorInfoSearch.getBusinessCondition(state, codenum, owner, machinetype, plantType, checkexpriydate, regcerno, cardid, engineno, recplacementinfotype, "replace");
		List<TractorReplacementInfoView> res = serviceManager.getTractorReplacementInfoService().getTractorReplacementInfoView(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (TractorReplacementInfoView u : res) {
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
	
	//添加
	public void addTractorReplacementInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String flapperNumber = (String) request.getParameter("flapperNumber").trim();
		String certregistrationNumber = (String) request.getParameter("certregistrationNumber").trim();

		String sortsofinsurance = (String) request.getParameter("sortsofinsurance").trim();//登记事项
		String selevanceVoucher = (String) request.getParameter("selevanceVoucher").trim();
		String reason = (String) request.getParameter("reason").trim();
		String flapperFace = (String) request.getParameter("flapperFace").trim();
		String registrantAuditor = (String) request.getParameter("registrantAuditor").trim();
		Date registrantAuditorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("registrantAuditorDate").trim());
		String flapperDirector = (String) request.getParameter("flapperDirector").trim();		
		Date flapperDirectorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("flapperDirectorDate").trim());
		String businessLeadAuditor = (String) request.getParameter("businessLeadAuditor").trim();		
		Date businessLeadAuditorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("businessLeadAuditorDate").trim());		
		int tractorinfoId = Integer.parseInt( request.getParameter("tractorinfoId").trim());		
		User user=(User)request.getSession().getAttribute("user");
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
		log.info("Add new ractorReplacementInfo:[tractorinfoId:"+tractorinfoId+"]");
	
		TractorReplacementInfo model=new TractorReplacementInfo();
		model.setFlapperNumber(flapperNumber);
		model.setCertregistrationNumber(certregistrationNumber);
		if(sortsofinsurance.equals("补领拖拉机牌")){
			model.setVenue(flapperNumber);	
		}
		else if(sortsofinsurance.equals("换拖拉机号牌")){	
			String code=serviceManager.getPlateService().getMinPlateCode(um.getRegionid());
			if(code!=null && !code.equals(""))
			{
			model.setVenue(code);	
			}else{
				response.getWriter().write("{success: false,errors:'目前没有可用的号牌，无法进行[换拖拉机号牌]操作!'}");
				return;
			}
		}
		else{
			model.setVenue("");	
		}
		model.setSortsofinsurance(sortsofinsurance);
		model.setSelevanceVoucher(selevanceVoucher);
		model.setReason(reason);
		model.setFlapperFace(flapperFace);
		model.setRegistrantAuditor(registrantAuditor);
		model.setRegistrantAuditorDate(registrantAuditorDate);
		model.setFlapperDirector(flapperDirector);
		model.setFlapperDirectorDate(flapperDirectorDate);
		model.setBusinessLeadAuditor(businessLeadAuditor);
		model.setBusinessLeadAuditorDate(businessLeadAuditorDate);
		model.setExamineStatus(0);
		model.setOperator(user.getRealname());
		model.setOperatorDate(new java.util.Date());
		model.setTractorinfoId(tractorinfoId);
		if (serviceManager.getTractorReplacementInfoService().addTractorReplacementInfo(model)) {
			TractorInfo tractorInfo=this.serviceManager.getTractorInfoService().findTractorInfoById(tractorinfoId);
			tractorInfo.setStatus(11);
			this.serviceManager.getTractorInfoService().updateTractorInfo(tractorInfo);
			log.info("添加补领补换牌证业务成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{success: false,errors:'添加补领补换牌证业务失败，请重新尝试!'}");
		}
	}
	
	//修改信息
	public void updateTractorReplacementInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		String flapperNumber = (String) request.getParameter("flapperNumber").trim();
		String certregistrationNumber = (String) request.getParameter("certregistrationNumber").trim();
		String venue = (String) request.getParameter("venue").trim();
		String sortsofinsurance = (String) request.getParameter("sortsofinsurance").trim();
		String selevanceVoucher = (String) request.getParameter("selevanceVoucher").trim();
		String reason = (String) request.getParameter("reason").trim();
		String flapperFace = (String) request.getParameter("flapperFace").trim();
		String registrantAuditor = (String) request.getParameter("registrantAuditor").trim();
		Date registrantAuditorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("registrantAuditorDate").trim());
		String flapperDirector = (String) request.getParameter("flapperDirector").trim();		
		Date flapperDirectorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("flapperDirectorDate").trim());
		String businessLeadAuditor = (String) request.getParameter("businessLeadAuditor").trim();		
		Date businessLeadAuditorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("businessLeadAuditorDate").trim());	
		int examineStatus=Integer.parseInt(request.getParameter("examineStatus").trim());
		String examineAuditor=request.getParameter("examineStatus");
		String examineStatusIdea=request.getParameter("examineStatusIdea");
		String examineDate=request.getParameter("examineDate");
		String operator=request.getParameter("operator");
		Date operatorDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("operatorDate").trim());			
		int tractorinfoId = Integer.parseInt( request.getParameter("tractorinfoId").trim());		

		
		log.info("Add new ractorReplacementInfo:[tractorinfoId:"+tractorinfoId+"]");
	
		TractorReplacementInfo model=new TractorReplacementInfo();
		model.setId(id);
		model.setFlapperNumber(flapperNumber);
		model.setCertregistrationNumber(certregistrationNumber);
		model.setVenue(venue);
		model.setSortsofinsurance(sortsofinsurance);
		model.setSelevanceVoucher(selevanceVoucher);
		model.setReason(reason);
		model.setFlapperFace(flapperFace);
		model.setRegistrantAuditor(registrantAuditor);
		model.setRegistrantAuditorDate(registrantAuditorDate);
		model.setFlapperDirector(flapperDirector);
		model.setFlapperDirectorDate(flapperDirectorDate);
		model.setBusinessLeadAuditor(businessLeadAuditor);
		model.setBusinessLeadAuditorDate(businessLeadAuditorDate);
		model.setExamineStatus(examineStatus);
		model.setExamineAuditor(examineAuditor);
		model.setExamineStatusIdea(examineStatusIdea);
		if(examineDate!=null && !examineDate.equals("")){
			model.setExamineDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("examineDate").trim()));
		}		
		model.setOperator(operator);
		model.setOperatorDate(operatorDate);
		model.setTractorinfoId(tractorinfoId);
		if(this.serviceManager.getTractorReplacementInfoService().updateTractorReplacementInfo(model)){
			response.getWriter().write("{success: true}");
		}else{
			response.getWriter().write("{success: false}");
		}
	}

	
	//批量上报
	public void ReportedTractorReplacementInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("add TractorInfo");
		User user=(User)request.getSession().getAttribute("user");
		String replacementInfoIds = (String) request.getParameter("replacementInfoIds").trim();
        if(!replacementInfoIds.equals("")){
        	//执行上报
        	serviceManager.getTractorReplacementInfoService().updateTractorReplacementInfoStateByIds(1, replacementInfoIds);
        	//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarReplaceTime();
            }
			ReplaceOperation operation = new ReplaceOperation(audittime,user.getRealname(),replacementInfoIds);
			Thread thread = new Thread(operation, "TractorReplacementInfo");
			thread.start();
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on del TractorInfo");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
        }
	}
	
	private class ReplaceOperation implements Runnable {
		private int time;
		String realname;
		String auditreplaceids;
		public ReplaceOperation(int time,String realname,String auditreplaceids){
			this.time = time;
			this.realname=realname;
			this.auditreplaceids=auditreplaceids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,realname,auditreplaceids);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String auditreplaceids;
		public EggTimer(int time,String realname,String auditreplaceids) {
			this.time = time;
			this.realname=realname;
			this.auditreplaceids=auditreplaceids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditReplacement(realname,auditreplaceids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
	
	//删除数据
	public void delTractorReplacementInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del CarTransfer");
		String replacementInfoIds =request.getParameter("replacementInfoIds");
		String tractorids =request.getParameter("tractorids");
		 if(!replacementInfoIds.equals("")){
			 if(this.serviceManager.getTractorReplacementInfoService().delTractorReplacementInfoByIds(replacementInfoIds)){
				   if(tractorids!=null && !tractorids.equals("")){
	        			tractorids=tractorids.substring(0,tractorids.length()-1);
	        			this.serviceManager.getTractorInfoService().updateTractorStateByIds(2, tractorids,TractorInfoSearch.GetBusinessOverCondtion());	
	        		}
				   response.getWriter().write("{success: true}");
			 }else{
				 log.info("Err on del ReplacementInfo");
				 response.getWriter().write("{success: false}");
			 }
		 }
	}
	
	//提交审核
	public void auditReplacement(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Audit Replacement");
		User user=(User)request.getSession().getAttribute("user");
		String auditreplaceids = (String) request.getParameter("auditreplaceids").trim();//得到需要审核的补领补换申请信息
		int checkstate=Integer.parseInt(request.getParameter("checkstate").trim());//得到审核结果
		String checkcontext = (String) request.getParameter("checkcontext").trim();//得到审核意见
		String tractorinfoids = (String) request.getParameter("tractorinfoids").trim();//得到申请信息对应的拖拉机

		
		//得到需要审核的补领补换业务
		List<TractorReplacementInfoView> res = serviceManager.getTractorReplacementInfoService().getTractorReplacementInfoViewListByIds(auditreplaceids);
		if(res!=null)
		{
			for (TractorReplacementInfoView viewmodel : res)
			{
				if (viewmodel.getExamineStatus() == 1)
				{
					int currentAuditState=viewmodel.getExamineStatus();//得到申请当前的审核状态
					TractorReplacementInfo model=new TractorReplacementInfo();
					model.setId(viewmodel.getId());
					model.setFlapperNumber(viewmodel.getFlapperNumber());
					model.setCertregistrationNumber(viewmodel.getCertregistrationNumber());
					model.setVenue(viewmodel.getVenue());
					model.setSortsofinsurance(viewmodel.getSortsofinsurance());
					model.setSelevanceVoucher(viewmodel.getSelevanceVoucher());
					model.setReason(viewmodel.getReason());
					model.setFlapperFace(viewmodel.getFlapperFace());
					model.setRegistrantAuditor(viewmodel.getRegistrantAuditor());
					model.setRegistrantAuditorDate(viewmodel.getRegistrantAuditorDate());
					model.setFlapperDirector(viewmodel.getFlapperDirector());
					model.setFlapperDirectorDate(viewmodel.getFlapperDirectorDate());
					model.setBusinessLeadAuditor(viewmodel.getBusinessLeadAuditor());
					model.setBusinessLeadAuditorDate(viewmodel.getBusinessLeadAuditorDate());
					model.setExamineStatus(checkstate);//审核结果
					model.setExamineAuditor(user.getRealname());//审核人
					model.setExamineStatusIdea(checkcontext);//审核意见
					model.setExamineDate(new Date());//审核时间
					model.setOperator(viewmodel.getOperator());
					model.setOperatorDate(viewmodel.getOperatorDate());
					model.setTractorinfoId(viewmodel.getTractorinfoId());
					//如果是审核通过
					if(checkstate==2)
					{
						if(model.getSortsofinsurance().equals("补领拖拉机牌"))
						{
							//将指定的号牌全部变为补领状态
							this.serviceManager.getPlateService().UpdatePlateCodeStateByCode(4, "'"+model.getFlapperNumber()+"'");
							//添加一条号牌操作记录
							PlateOperateRecord plateOperateRecord=new PlateOperateRecord();
							plateOperateRecord.setPlateCode(model.getFlapperNumber());
							plateOperateRecord.setOperateDate(new Date());
							plateOperateRecord.setOperateContent("补领拖拉机牌");
							plateOperateRecord.setOperateUserName(user.getRealname());
							plateOperateRecord.setReplaceRequestId(model.getId());
							plateOperateRecord.setFlag(1);
							this.serviceManager.getPlateOperateRecordService().addPlateOperateRecord(plateOperateRecord);
						}
						else if(model.getSortsofinsurance().equals("换拖拉机号牌"))
						{
							//指定的号牌全部变为换牌状态
							this.serviceManager.getPlateService().UpdatePlateCodeStateByCode(6, "'"+model.getFlapperNumber()+"'");
							//添加一条号牌操作记录
							PlateOperateRecord plateOperateRecord=new PlateOperateRecord();
							plateOperateRecord.setPlateCode(model.getFlapperNumber());
							plateOperateRecord.setOperateDate(new Date());
							plateOperateRecord.setOperateContent("换拖拉机号牌");
							plateOperateRecord.setOperateUserName(user.getRealname());
							plateOperateRecord.setReplaceRequestId(model.getId());
							plateOperateRecord.setFlag(1);
							this.serviceManager.getPlateOperateRecordService().addPlateOperateRecord(plateOperateRecord);
						}
						else if(model.getSortsofinsurance().equals("补领行驶证") || model.getSortsofinsurance().equals("换行驶证"))
						{
							//重新增加一条有效的打印行驶证记录
							PrintFlag printFlag=new PrintFlag();
							printFlag.setTractroinfoId(model.getTractorinfoId());
							printFlag.setPrintBegianDate(new Date());
							printFlag.setPrintEndDate(DateTimeUtil.addDate(15));
							printFlag.setFlag(1);
							printFlag.setPrintType(0);
							this.serviceManager.getPrintFlagService().addPrintFlag(printFlag);
						}
						else if(model.getSortsofinsurance().equals("补领登记证书") || model.getSortsofinsurance().equals("换登记证书"))
						{
							//重新增加一条有效的登记证书打印记录
							PrintFlag printFlag=new PrintFlag();
							printFlag.setTractroinfoId(model.getTractorinfoId());
							printFlag.setPrintBegianDate(new Date());
							printFlag.setPrintEndDate(DateTimeUtil.addDate(15));
							printFlag.setFlag(1);
							printFlag.setPrintType(1);
							this.serviceManager.getPrintFlagService().addPrintFlag(printFlag);
						}
					}
					else if(checkstate==3)
					{
						if(currentAuditState==2)
						{
							if(model.getSortsofinsurance().equals("补领拖拉机牌") || model.getSortsofinsurance().equals("换拖拉机号牌"))
							{
								//将指定的号牌变为已使用状态
								this.serviceManager.getPlateService().UpdatePlateCodeStateByCode(3, "'"+model.getFlapperNumber()+"'");
								//将对应的号牌操作信息变为不可用(删除)
								this.serviceManager.getPlateOperateRecordService().DelPlateOperateRecordByReplaceRequestId(model.getId());
							}
							else if(model.getSortsofinsurance().equals("补领行驶证") || model.getSortsofinsurance().equals("换行驶证"))
							{
								//将有效的打印记录删除
								this.serviceManager.getPrintFlagService().DelPrintFlag(model.getTractorinfoId(), 0);
							}
							else if(model.getSortsofinsurance().equals("补领登记证书") || model.getSortsofinsurance().equals("换登记证书"))
							{
								//将有效的打印记录删除
								this.serviceManager.getPrintFlagService().DelPrintFlag(model.getTractorinfoId(), 1);
							}	
						}
					}
					this.serviceManager.getTractorReplacementInfoService().updateTractorReplacementInfo(model);
				}
			}
			if(checkstate==2)
			{
				//将拖拉机状态从业务中变成正常状态，以至于可以进行其他业务操作
				if(tractorinfoids!=null && !tractorinfoids.equals("")){
					this.serviceManager.getTractorInfoService().updateTractorStateByIds(2, tractorinfoids,TractorInfoSearch.GetBusinessOverCondtion());	
				}
			}
			else if(checkstate==3)
			{
				if(tractorinfoids!=null && !tractorinfoids.equals("")){
					//审核不通过之后.将车辆信息变为补领补换业务中
					this.serviceManager.getTractorInfoService().updateTractorStateByIds(11, tractorinfoids,TractorInfoSearch.GetBusinessOverCondtion());	
				}
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void ThreadAuditReplacement(String realname,String auditreplaceids)
	{
		String currentauditreplaceids="";
		String currenttractorinfoids="";//得到申请信息对应的拖拉机
		List<TractorReplacementInfoView> list=serviceManager.getTractorReplacementInfoService().findTractorReplacementInfoByIds(auditreplaceids);
		
		for (TractorReplacementInfoView viewmodel: list) {
			if(viewmodel.examineStatus==1)
			{
				//如果当前申请为上报状态，则可以自动进行审核
				 if(viewmodel.getStatus()==11){
                     if (currenttractorinfoids.length() == 0) {
                    	 currenttractorinfoids = currenttractorinfoids +String.valueOf(viewmodel.getTractorinfoId());
                     }else {
                    	 currenttractorinfoids = currenttractorinfoids + "," + String.valueOf(viewmodel.getTractorinfoId());
                     }
                 }
					TractorReplacementInfo model=new TractorReplacementInfo();
					model.setId(viewmodel.getId());
					model.setFlapperNumber(viewmodel.getFlapperNumber());
					model.setCertregistrationNumber(viewmodel.getCertregistrationNumber());
					model.setVenue(viewmodel.getVenue());
					model.setSortsofinsurance(viewmodel.getSortsofinsurance());
					model.setSelevanceVoucher(viewmodel.getSelevanceVoucher());
					model.setReason(viewmodel.getReason());
					model.setFlapperFace(viewmodel.getFlapperFace());
					model.setRegistrantAuditor(viewmodel.getRegistrantAuditor());
					model.setRegistrantAuditorDate(viewmodel.getRegistrantAuditorDate());
					model.setFlapperDirector(viewmodel.getFlapperDirector());
					model.setFlapperDirectorDate(viewmodel.getFlapperDirectorDate());
					model.setBusinessLeadAuditor(viewmodel.getBusinessLeadAuditor());
					model.setBusinessLeadAuditorDate(viewmodel.getBusinessLeadAuditorDate());
					model.setExamineStatus(2);//审核结果
					model.setExamineAuditor(realname);//审核人
					model.setExamineStatusIdea("审核通过");//审核意见
					model.setExamineDate(new Date());//审核时间
					model.setOperator(viewmodel.getOperator());
					model.setOperatorDate(viewmodel.getOperatorDate());
					model.setTractorinfoId(viewmodel.getTractorinfoId());
					//默认为审核通过
					if(model.getSortsofinsurance().equals("补领拖拉机牌"))
					{
						//将指定的号牌全部变为补领状态
						this.serviceManager.getPlateService().UpdatePlateCodeStateByCode(4, model.getFlapperNumber());
						//添加一条号牌操作记录
						PlateOperateRecord plateOperateRecord=new PlateOperateRecord();
						plateOperateRecord.setPlateCode(model.getFlapperNumber());
						plateOperateRecord.setOperateDate(new Date());
						plateOperateRecord.setOperateContent("补领拖拉机牌");
						plateOperateRecord.setOperateUserName(realname);
						plateOperateRecord.setReplaceRequestId(model.getId());
						plateOperateRecord.setFlag(1);
						this.serviceManager.getPlateOperateRecordService().addPlateOperateRecord(plateOperateRecord);
					}
					else if(model.getSortsofinsurance().equals("换拖拉机号牌"))
					{
						//指定的号牌全部变为换牌状态
						this.serviceManager.getPlateService().UpdatePlateCodeStateByCode(6, model.getFlapperNumber());
						//添加一条号牌操作记录
						PlateOperateRecord plateOperateRecord=new PlateOperateRecord();
						plateOperateRecord.setPlateCode(model.getFlapperNumber());
						plateOperateRecord.setOperateDate(new Date());
						plateOperateRecord.setOperateContent("换拖拉机号牌");
						plateOperateRecord.setOperateUserName(realname);
						plateOperateRecord.setReplaceRequestId(model.getId());
						plateOperateRecord.setFlag(1);
						this.serviceManager.getPlateOperateRecordService().addPlateOperateRecord(plateOperateRecord);
					}
					else if(model.getSortsofinsurance().equals("补领行驶证") || model.getSortsofinsurance().equals("换行驶证"))
					{
						//重新增加一条有效的打印行驶证记录
						PrintFlag printFlag=new PrintFlag();
						printFlag.setTractroinfoId(model.getTractorinfoId());
						printFlag.setPrintBegianDate(new Date());
						printFlag.setPrintEndDate(DateTimeUtil.addDate(15));
						printFlag.setFlag(1);
						printFlag.setPrintType(0);
						this.serviceManager.getPrintFlagService().addPrintFlag(printFlag);
					}
					else if(model.getSortsofinsurance().equals("补领登记证书") || model.getSortsofinsurance().equals("换登记证书"))
					{
						//重新增加一条有效的登记证书打印记录
						PrintFlag printFlag=new PrintFlag();
						printFlag.setTractroinfoId(model.getTractorinfoId());
						printFlag.setPrintBegianDate(new Date());
						printFlag.setPrintEndDate(DateTimeUtil.addDate(15));
						printFlag.setFlag(1);
						printFlag.setPrintType(1);
						this.serviceManager.getPrintFlagService().addPrintFlag(printFlag);
					}
					this.serviceManager.getTractorReplacementInfoService().updateTractorReplacementInfo(model);
			}
		}
		//将拖拉机状态从业务中变成正常状态，以至于可以进行其他业务操作
		if(currenttractorinfoids!=null && !currenttractorinfoids.equals("")){
			this.serviceManager.getTractorInfoService().updateTractorStateByIds(2, currenttractorinfoids,TractorInfoSearch.GetBusinessOverCondtion());	
		}
	}
	//打印业务流程
	public void tractorReplacementInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getTractorReplacementInfoService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_tractorInfoFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
	//打印补领、换领拖拉机牌证申请表
	public void PrintReplacementReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();//拖拉机ID
		String wordType=request.getParameter("wordType");
		List<TractorReplacementApplicationSource> list=this.serviceManager.getTractorReplacementInfoService().PrintReplacementReport(Integer.parseInt(id)); 
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getFlapperNumber()+"_ReplaceReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		//得到边距设置
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorReplacementApplication.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));

	}
}
