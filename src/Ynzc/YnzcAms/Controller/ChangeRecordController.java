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
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.StringUtil;
import Ynzc.YnzcAms.Model.ChangeRecord;
import Ynzc.YnzcAms.Model.ChangeRecordView;
import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

public class ChangeRecordController extends  BaseController{
	private final static Logger log = Logger.getLogger(ChangeRecordController.class);

	//查询分页变更备案数据
	@SuppressWarnings("unused")
	public void getAllChangeRecordListByPage(HttpServletRequest request,
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
		User user=(User)request.getSession().getAttribute("user");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String condition = "";//设置查询条件为空
	    condition=TractorInfoSearch.getBusinessCondition(state, codenum, owner, machinetype, plantType, checkexpriydate, regcerno, cardid, engineno, "", "changerecord");		
		List<ChangeRecordView> res = serviceManager.getChangeRecordService().getChangeRecordList(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (ChangeRecordView u : res) {
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
			
	
	//添加变更备案信息
	public void addChangeRecord(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("add ChangeRecord");
		User user=(User)request.getSession().getAttribute("user");
		//依次获取参数 
		int tractorinfoid =Integer.parseInt(request.getParameter("tractorinfoid").trim());
		String changerecordtype=request.getParameter("changerecordtype").trim();
		String changerecordname=request.getParameter("changerecordname").trim();
		String linktel=request.getParameter("linktel").trim();
		int certificateid=Integer.parseInt(request.getParameter("certificateid").trim());
		String certificatecode=request.getParameter("certificatecode").trim();
		int unittype=Integer.parseInt(request.getParameter("unittype").trim());
		String address=request.getParameter("address").trim();
		String zipcode=request.getParameter("zipcode").trim();
		int istemporary=Integer.parseInt(request.getParameter("istemporary").trim());
		String temporaycertificate=request.getParameter("temporaycertificate").trim();
		String temporaycertificatecode=request.getParameter("temporaycertificatecode").trim();
		String checkinmen=request.getParameter("checkinmen").trim();
		Date checkindate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkindate").trim());
		String licensemen=request.getParameter("licensemen").trim();
		Date licensedate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("licensedate").trim());
		String businessmen=request.getParameter("businessmen").trim();
		Date businessdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("businessdate").trim());
		
		ChangeRecord model=new ChangeRecord();
		model.setTractorinfoid(tractorinfoid);
		model.setChangerecordtype(changerecordtype);
		model.setChangerecordname(changerecordname);
		model.setLinktel(linktel);
		model.setCertificateid(certificateid);
		model.setCertificatecode(certificatecode);
		model.setUnittype(unittype);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setIstemporary(istemporary);
		if(temporaycertificate!=null && !temporaycertificate.equals(""))
		{
		 model.setTemporaycertificate(Integer.parseInt(temporaycertificate));
		}
		model.setTemporaycertificatecode(temporaycertificatecode);
		model.setCheckinmen(checkinmen);
		model.setCheckindate(checkindate);
		model.setLicensemen(licensemen);
		model.setLicensedate(licensedate);
		model.setBusinessmen(businessmen);
		model.setBusinessdate(businessdate);
		model.setCheckstate(0);
		model.setOpertator(user.getRealname());
		model.setOpertatedate(new Date());
		if (serviceManager.getChangeRecordService().addChangeRecord(model)) {
			TractorInfo tractorInfo=this.serviceManager.getTractorInfoService().findTractorInfoById(tractorinfoid);
			tractorInfo.setStatus(9);
			this.serviceManager.getTractorInfoService().updateTractorInfo(tractorInfo);
			log.info("变更备案成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'变更备案失败，请重新尝试!'}");
		}

        		
	}

	
	//批量上报
	public void ReportedChangeRecord(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("report ChangeRecord");
		User user=(User)request.getSession().getAttribute("user");
		String reportchangerecordids = (String) request.getParameter("reportchangerecordids").trim();
        if(!reportchangerecordids.equals("")){
        	this.serviceManager.getChangeRecordService().updateChangeRecordStateByIds(1,reportchangerecordids);
        	//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarModifyRecordTime();
            }
			ChangeRecordOperation operation = new ChangeRecordOperation(audittime,user.getRealname(),request.getRemoteAddr(),reportchangerecordids);
			Thread thread = new Thread(operation, "ChangeRecord");
			thread.start();
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on report ChangeRecord");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
        }
	}
	private class ChangeRecordOperation implements Runnable {
		private int time;
		String realname;
		String remoteaddr;
		String auditchangerecordids;
		public ChangeRecordOperation(int time,String realname,String remoteaddr,String auditchangerecordids){
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditchangerecordids=auditchangerecordids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,realname,remoteaddr,auditchangerecordids);
			eggTimer.start();
		}
	}
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String remoteaddr;
		String auditchangerecordids;
		public EggTimer(int time,String realname,String remoteaddr,String auditchangerecordids) {
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditchangerecordids=auditchangerecordids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditChangeRecord(realname,remoteaddr,auditchangerecordids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
	
	
	//更新数据
	@SuppressWarnings("null")
	public void updateChangeRecord(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("update ChangeRecord");
		int id=Integer.parseInt(request.getParameter("id"));
		String tractorinfoIdStr=request.getParameter("tractorinfoid");
		if(tractorinfoIdStr==null && tractorinfoIdStr.equals(""))
		{
			response.getWriter().write("{success: false}");
			return;
		}
		int tractorinfoid=Integer.parseInt(request.getParameter("tractorinfoid"));
		
		String changerecordtype=request.getParameter("changerecordtype");
		String changerecordname=request.getParameter("changerecordname");
		String linktel=request.getParameter("linktel");
		int certificateid=Integer.parseInt(request.getParameter("certificateid"));
		String certificatecode=request.getParameter("certificatecode");
		int unittype=Integer.parseInt(request.getParameter("unittype"));
		String address=request.getParameter("address");
		String zipcode=request.getParameter("zipcode");
		int istemporary=Integer.parseInt(request.getParameter("istemporary"));
		String temporaycertificate=request.getParameter("temporaycertificate");
		String temporaycertificatecode=request.getParameter("temporaycertificatecode");
		String checkinmen=request.getParameter("checkinmen");
		String checkindate=request.getParameter("checkindate");
		String licensemen=request.getParameter("licensemen");
		String licensedate=request.getParameter("licensedate");
		String businessmen=request.getParameter("businessmen");		
		String businessdate=request.getParameter("businessdate");
		String checkmen=request.getParameter("checkmen");
		int checkstate=Integer.parseInt(request.getParameter("checkstate"));
		String checkdate=request.getParameter("checkdate");
		String checkcontent=request.getParameter("checkcontent");
		String checkip=request.getParameter("checkip");
		String opertator=request.getParameter("opertator");
		String opertatedate=request.getParameter("opertatedate");
		
		ChangeRecord model=new ChangeRecord();
        model.setId(id);
        model.setTractorinfoid(tractorinfoid);
        model.setChangerecordtype(changerecordtype);
        model.setChangerecordname(changerecordname);
        model.setLinktel(linktel);
        model.setCertificateid(certificateid);
        model.setCertificatecode(certificatecode);
        model.setUnittype(unittype);
        model.setAddress(address);
        model.setZipcode(zipcode);
        model.setIstemporary(istemporary);
        if(temporaycertificate!=null && !temporaycertificate.equals("")){
        	model.setTemporaycertificate(Integer.parseInt(temporaycertificate));
        }
		model.setTemporaycertificatecode(temporaycertificatecode);
		model.setCheckinmen(checkinmen);
		if(checkindate!=null && !checkindate.equals("")){
			model.setCheckindate(new SimpleDateFormat("yyyy-MM-dd").parse(checkindate.trim()));
		}
		model.setLicensemen(licensemen);
		if(licensedate!=null && !licensedate.equals("")){
			model.setLicensedate(new SimpleDateFormat("yyyy-MM-dd").parse(licensedate.trim()));
		}
        model.setBusinessmen(businessmen);
    	if(businessdate!=null && !businessdate.equals("")){
			model.setBusinessdate(new SimpleDateFormat("yyyy-MM-dd").parse(businessdate.trim()));
		}
        model.setCheckmen(checkmen);
        model.setCheckstate(checkstate);
    	if(checkdate!=null && !checkdate.equals("")){
			model.setCheckdate(new SimpleDateFormat("yyyy-MM-dd").parse(checkdate.trim()));
		}
    	model.setCheckcontent(checkcontent);
    	model.setCheckip(checkip);
    	model.setOpertator(opertator);
    	model.setOpertatedate(new SimpleDateFormat("yyyy-MM-dd").parse(opertatedate.trim()));
    	
		if(this.serviceManager.getChangeRecordService().updateChangeRecord(model)){
			response.getWriter().write("{success: true}");
		}else{
			response.getWriter().write("{success: false}");
		}
	}

	
	//删除数据
	public void delChangeRecord(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del ChangeRecord");
		String delchangerecordids =request.getParameter("mydelchangerecordids");
		String tractorids =request.getParameter("tractorids");
		 if(!delchangerecordids.equals("")){
			 if(this.serviceManager.getChangeRecordService().delChangeRecordByIds(delchangerecordids)){
				   if(!tractorids.equals("")){
	        			tractorids=tractorids.substring(0,tractorids.length()-1);
	        			this.serviceManager.getTractorInfoService().updateTractorStateByIds(2, tractorids,TractorInfoSearch.GetBusinessOverCondtion());	
	        		}
				   response.getWriter().write("{success: true}");
			 }else{
				 log.info("Err on del ChangeRecord");
				 response.getWriter().write("{success: false}");
			 }
		 }
	}
	
	
	//提交审核
	@SuppressWarnings("rawtypes")
	public void auditChangeRecord(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("aduit ChangeRecord");
		User user=(User)request.getSession().getAttribute("user");
		String auditchangerecordids = (String) request.getParameter("auditchangerecordids").trim();//得到需要审核的信息
		int checkstate=Integer.parseInt(request.getParameter("checkstate").trim());//得到审核结果
		String checkcontext = (String) request.getParameter("checkcontext").trim();//得到审核意见
		if(this.serviceManager.getChangeRecordService().auditChangeRecord(checkstate, user.getRealname(), request.getRemoteAddr(), checkcontext, auditchangerecordids)){
			if(checkstate==2){
				String tractorinfo = (String) request.getParameter("tractorinfo").trim();
				if(tractorinfo!=null && !tractorinfo.equals("")){
					JSONArray jsonArray = JSONArray.fromObject(tractorinfo);
					Iterator iterator = jsonArray.iterator();
					JSONObject jsonObject = new JSONObject();
					while (iterator.hasNext()) {
						String str=iterator.next().toString();
						str=str.substring(1,str.length()-1);
						jsonObject =JSONObject.fromObject(str);
						if(jsonObject.get("tractorinfoId")!=null){
							int tractorinfoid=Integer.parseInt(jsonObject.get("tractorinfoId").toString());
							//更新拖拉机所有人信息
							OwnerInfo ownerinfo=this.serviceManager.getOwnerInfoService().findOwnerInfoByWhere("tractorinfoId="+tractorinfoid);
							if(ownerinfo!=null){
								ownerinfo.setOwner(jsonObject.get("changerecordname").toString());
								ownerinfo.setTelephone(jsonObject.get("linktel").toString());
								ownerinfo.setRealcertificatetype(jsonObject.get("certificateid").toString());
								ownerinfo.setRealcertificateno(jsonObject.get("certificatecode").toString());
								ownerinfo.setIsUnion(Integer.parseInt(jsonObject.get("unittype").toString()));
								ownerinfo.setTempaddress(jsonObject.get("address").toString());
								ownerinfo.setZipCode(jsonObject.get("zipcode").toString());
								ownerinfo.setIstemplived(Integer.parseInt(jsonObject.get("istemporary").toString()));
								ownerinfo.setTemplivefiletype(Integer.parseInt(jsonObject.get("temporaycertificate").toString()));
								ownerinfo.setTimplivefileno(jsonObject.get("temporaycertificatecode").toString());
								this.serviceManager.getOwnerInfoService().updateOwnerInfo(ownerinfo);
							}
							
							//更新拖拉机状态
							TractorInfo tractorinfoModel=this.serviceManager.getTractorInfoService().findTractorInfoById(tractorinfoid);
							if(tractorinfoModel.getStatus()==9){
								tractorinfoModel.setStatus(2);
								this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);	
							}
						}
					}
				}
			}
			else if(checkstate==3){
				String updatetractorinfoids = (String) request.getParameter("updatetractorinfoids").trim();
				this.serviceManager.getTractorInfoService().updateTractorStateByIds(9, updatetractorinfoids, "");
			}
		}
	   response.getWriter().write("{success: true}");
	}
	
	//自动审核
	public void ThreadAuditChangeRecord(String checkusername,String checkip,String auditchangerecordids){
		String waitAuditChaneRecordIds="";
		List<ChangeRecordView> list = serviceManager.getChangeRecordService().getChangeRecordViewListByIds(auditchangerecordids);
		for (ChangeRecordView viewmodel: list) {
			if(viewmodel.getCheckstate()==1){
				 if (waitAuditChaneRecordIds.length() == 0) {
					 waitAuditChaneRecordIds = waitAuditChaneRecordIds +String.valueOf(viewmodel.getId());
                 } else {
                	 waitAuditChaneRecordIds = waitAuditChaneRecordIds + "," + String.valueOf(viewmodel.getId());
                 }
				//更新拖拉机所有人信息
				OwnerInfo ownerinfo=this.serviceManager.getOwnerInfoService().findOwnerInfoByWhere("tractorinfoId="+viewmodel.getTractorinfoId());
				if(ownerinfo!=null){
					ownerinfo.setOwner(viewmodel.getChangerecordname());
					ownerinfo.setTelephone(viewmodel.getLinktel());
					ownerinfo.setRealcertificatetype(String.valueOf(viewmodel.getCertificateid()));
					ownerinfo.setRealcertificateno(viewmodel.getCertificatecode());
					ownerinfo.setIsUnion(viewmodel.getUnittype());
					ownerinfo.setTempaddress(viewmodel.getAddress());
					ownerinfo.setZipCode(viewmodel.getZipcode());
					ownerinfo.setIstemplived(viewmodel.getIstemporary());
					ownerinfo.setTemplivefiletype(viewmodel.getTemporaycertificate());
					ownerinfo.setTimplivefileno(viewmodel.getTemporaycertificatecode());
					this.serviceManager.getOwnerInfoService().updateOwnerInfo(ownerinfo);
					}
						
					//更新拖拉机状态
					TractorInfo tractorinfoModel=this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
					if(tractorinfoModel.getStatus()==9){
							tractorinfoModel.setStatus(2);
							this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);	
					}
			}
		}
		if(waitAuditChaneRecordIds!=null && !waitAuditChaneRecordIds.equals("")){
			this.serviceManager.getChangeRecordService().auditChangeRecord(2,checkusername, checkip, "审核通过", waitAuditChaneRecordIds);
		}
	}
	//打印业务流程
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void changeRecordInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getChangeRecordService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_changeRecordFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
}
