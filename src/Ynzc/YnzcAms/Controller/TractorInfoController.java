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

import net.sf.ezmorph.object.DateMorpher;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.StringUtil;
import Ynzc.YnzcAms.Model.CarChange;
import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.CarInfomationSource;
import Ynzc.YnzcAms.Model.CarMoveReportSource;
import Ynzc.YnzcAms.Model.CarSafetyRoportSource;
import Ynzc.YnzcAms.Model.CarTransfer;
import Ynzc.YnzcAms.Model.ChangeRecord;
import Ynzc.YnzcAms.Model.HandlingSituation;
import Ynzc.YnzcAms.Model.Loyout;
import Ynzc.YnzcAms.Model.Mortgage;
import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PrintFlag;
import Ynzc.YnzcAms.Model.RegisterInfo;
import Ynzc.YnzcAms.Model.RelationInfo;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TechnicalDataSource;
import Ynzc.YnzcAms.Model.TechnicalInspect;
import Ynzc.YnzcAms.Model.TechnicalParameters;
import Ynzc.YnzcAms.Model.TractorBasicInfo;
import Ynzc.YnzcAms.Model.TractorEnregisterCertificateReportSource;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorInfoRegisterYear;
import Ynzc.YnzcAms.Model.TractorInfoView;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorReplacementInfo;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;
import Ynzc.YnzcAms.Util.IReportReCompile;
public class TractorInfoController extends  BaseController{
	private final static Logger log = Logger.getLogger(TractorInfoController.class);

	//查询分页数据
	public void getAllListByPage(HttpServletRequest request,
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
		String fields = request.getParameter("fields");//获取查询字段
		String query = request.getParameter("query");//获取查询输入框中输入的查询值
		String condition = "";//设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		List<TractorInfo> res = serviceManager.getTractorInfoService().getAllTractorInfoList(page, condition);
		JSONArray jsonItems = new JSONArray();
		for (TractorInfo u : res) {
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
	//添加拖拉机注册信息
	public void addTractorInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String[] dateFormats = new String[] {"yyyy-MM-dd"}; 
		String currentregionid=request.getSession().getAttribute("regionid").toString().trim();
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats)); 
		
		String ownerjson = request.getParameter("ownerjson").trim();//拖拉机信息：所有人
		ownerjson=ownerjson.substring(1,ownerjson.length()-1);
		
		String tractorjson = (String) request.getParameter("tractorjson").trim();//拖拉机基本信息
		tractorjson=tractorjson.substring(1,tractorjson.length()-1);
		
		String aboutjson = (String) request.getParameter("aboutjson").trim();//拖拉机信息：审核通过时间
		aboutjson=aboutjson.substring(1,aboutjson.length()-1);
		
		String regjson = (String) request.getParameter("regjson").trim();//拖拉机信息：登记人
		regjson=regjson.substring(1,regjson.length()-1);
		
		String tecjson = (String) request.getParameter("tecjson").trim();//拖拉机信息：状态
		tecjson=tecjson.substring(1,tecjson.length()-1);
		
		String checkjson = (String) request.getParameter("checkjson").trim();//拖拉机信息：登记证书编号
		checkjson=checkjson.substring(1,checkjson.length()-1);
		
		String handjson = (String) request.getParameter("handjson").trim();
		handjson=handjson.substring(1,handjson.length()-1);
		
		int unitid = Integer.parseInt(request.getParameter("unitid").trim());
		String regionid = request.getParameter("regionid").trim();
		String license = (String) request.getParameter("license").trim();
		String[] content = license.split("\\.");
		String platenum=content[0];
		if(StringUtil.isNotNullEmptyStr(license)){
			license=license.substring(license.indexOf("."));
		}
		
		String regcerno = (String) request.getParameter("regcerno").trim();
		User user=(User)request.getSession().getAttribute("user");
		license=license.substring(license.indexOf(".")+1);
		log.info("Add new TractorInfo:[unitID:"+ownerjson+"]");
		//判断是否已经存在此车牌号的拖拉机
		if(this.serviceManager.getTractorInfoService().isExitsTractorInfoByCode(license, currentregionid))
		{
			response.getWriter().write("{success: false,errors:'已经存在此号牌的车辆，不能重复添加!'}");
			return;
		}
		JSONObject jsonObject = JSONObject.fromObject(ownerjson);
		OwnerInfo ownerinfo=(OwnerInfo)JSONObject.toBean(jsonObject,OwnerInfo.class);
		
		jsonObject = JSONObject.fromObject(tractorjson);
		TractorBasicInfo tractorBasicInfo=(TractorBasicInfo)JSONObject.toBean(jsonObject,TractorBasicInfo.class);
		
		jsonObject = JSONObject.fromObject(regjson);
		RegisterInfo registerInfo=(RegisterInfo)JSONObject.toBean(jsonObject,RegisterInfo.class);
		
		jsonObject = JSONObject.fromObject(aboutjson);
		RelationInfo relationInfo=(RelationInfo)JSONObject.toBean(jsonObject,RelationInfo.class);
		
		jsonObject = JSONObject.fromObject(tecjson);
		TechnicalParameters technicalParameters=(TechnicalParameters)JSONObject.toBean(jsonObject,TechnicalParameters.class);
		
	    jsonObject = JSONObject.fromObject(checkjson);
	    TechnicalInspect technicalInspect=(TechnicalInspect)JSONObject.toBean(jsonObject,TechnicalInspect.class);
		
	    jsonObject = JSONObject.fromObject(handjson);
	    HandlingSituation handlingSituation=(HandlingSituation)JSONObject.toBean(jsonObject,HandlingSituation.class);
		
		
		TractorInfo tractroinfo=new TractorInfo();
		tractroinfo.setCheckeddate(new Date());
		tractroinfo.setLicense(license);
		tractroinfo.setRecorder(user.getRealname());
		tractroinfo.setRegcerno(regcerno);
		tractroinfo.setStatus(0);//待上报为0 已上报为1 审核通过为2 审核不通过为3 
		tractroinfo.setUnitid(unitid);
		tractroinfo.setRegisterdate(new Date());
		tractroinfo.setRegionid(regionid);
		tractroinfo.setChangeType("注册登记");
		tractroinfo.setFiling(0);
		tractroinfo.setFilingDate(new Date());
		if(this.serviceManager.getTractorInfoService().addTractorInfo(tractroinfo)){
			ownerinfo.setTractorinfoId(tractroinfo.getId());
			tractorBasicInfo.setTractorinfoId(tractroinfo.getId());
			registerInfo.setTractorinfoId(tractroinfo.getId());
			relationInfo.setTractorinfoId(tractroinfo.getId());
			technicalParameters.setTractorinfoId(tractroinfo.getId());
			technicalInspect.setTractorinfoId(tractroinfo.getId());
			handlingSituation.setTractorinfoId(tractroinfo.getId());
			this.serviceManager.getOwnerInfoService().addOwnerInfo(ownerinfo);
			this.serviceManager.getTractorBasicInfoService().addTractorBasicInfo(tractorBasicInfo);
			this.serviceManager.getRegisterInfoService().addRegisterInfo(registerInfo);
			this.serviceManager.getRelationInfoService().addRelationInfo(relationInfo);
			this.serviceManager.getTechnicalParametersService().addTechnicalParameters(technicalParameters);
			this.serviceManager.getTechnicalInspectService().addTechnicalInspect(technicalInspect);
			this.serviceManager.getHandlingSituationService().addHandlingSituation(handlingSituation);
			UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
			this.serviceManager.getPlateService().updatePlateStatus(license, platenum,um.getRegionid(), 3);
			log.info("注册登记成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		}
		else {
			response.getWriter().write("{success: false,errors:'添加证件类型注册登记失败，请重新尝试!'}");
		}
	}
	
	//更新数据
	public void updateTractorInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String ownerjson = request.getParameter("ownerjson").trim();//拖拉机信息：所有人
		ownerjson=ownerjson.substring(1,ownerjson.length()-1);
		
		String tractorjson = (String) request.getParameter("tractorjson").trim();//拖拉机信息：基本信息
		tractorjson=tractorjson.substring(1,tractorjson.length()-1);
		
		String aboutjson = (String) request.getParameter("aboutjson").trim();//拖拉机信息：相关信息
		aboutjson=aboutjson.substring(1,aboutjson.length()-1);
		
		String regjson = (String) request.getParameter("regjson").trim();//拖拉机信息：注册信息
		regjson=regjson.substring(1,regjson.length()-1);
		
		String tecjson = (String) request.getParameter("tecjson").trim();//拖拉机信息：技术参数
		tecjson=tecjson.substring(1,tecjson.length()-1);
		
		String checkjson = (String) request.getParameter("checkjson").trim();//拖拉机信息：技术检验
		checkjson=checkjson.substring(1,checkjson.length()-1);
		
		String handjson = (String) request.getParameter("handjson").trim();
		handjson=handjson.substring(1,handjson.length()-1);
		
		int id=Integer.parseInt(request.getParameter("id").trim());
		int unitid = Integer.parseInt(request.getParameter("unitid").trim());
		String license = (String) request.getParameter("license").trim();
		String regcerno = (String) request.getParameter("regcerno").trim();
		String regionid = (String) request.getParameter("regionid").trim();
		
		log.info("Add new TractorInfo:[unitID:"+ownerjson+"]");
		JSONObject jsonObject = JSONObject.fromObject(ownerjson);
		OwnerInfo ownerinfo=(OwnerInfo)JSONObject.toBean(jsonObject,OwnerInfo.class);
		ownerinfo.setTractorinfoId(id);
		jsonObject = JSONObject.fromObject(tractorjson);
		TractorBasicInfo tractorBasicInfo=(TractorBasicInfo)JSONObject.toBean(jsonObject,TractorBasicInfo.class);
		tractorBasicInfo.setTractorinfoId(id);
		jsonObject = JSONObject.fromObject(regjson);
		RegisterInfo registerInfo=(RegisterInfo)JSONObject.toBean(jsonObject,RegisterInfo.class);
		registerInfo.setTractorinfoId(id);
		jsonObject = JSONObject.fromObject(aboutjson);
		RelationInfo relationInfo=(RelationInfo)JSONObject.toBean(jsonObject,RelationInfo.class);
		relationInfo.setTractorinfoId(id);
		jsonObject = JSONObject.fromObject(tecjson);
		TechnicalParameters technicalParameters=(TechnicalParameters)JSONObject.toBean(jsonObject,TechnicalParameters.class);
		technicalParameters.setTractorinfoId(id);
	    jsonObject = JSONObject.fromObject(checkjson);
	    TechnicalInspect technicalInspect=(TechnicalInspect)JSONObject.toBean(jsonObject,TechnicalInspect.class);
	    technicalInspect.setTractorinfoId(id);
	    jsonObject = JSONObject.fromObject(handjson);
	    HandlingSituation handlingSituation=(HandlingSituation)JSONObject.toBean(jsonObject,HandlingSituation.class);
	    handlingSituation.setTractorinfoId(id);
		
		//得到需要修改的拖拉机信息
		TractorInfo tractroinfo=serviceManager.getTractorInfoService().findTractorInfoById(id);
		if(tractroinfo!=null)
		{
			tractroinfo.setUnitid(unitid);
			tractroinfo.setLicense(license);
			tractroinfo.setRegcerno(regcerno);	
			tractroinfo.setRegionid(regionid);

			if (serviceManager.getTractorInfoService().updateTractorInfo(tractroinfo)) {
				
				this.serviceManager.getOwnerInfoService().updateOwnerInfo(ownerinfo);
				this.serviceManager.getTractorBasicInfoService().updateTractorBasicInfo(tractorBasicInfo);
				this.serviceManager.getRegisterInfoService().updateRegisterInfo(registerInfo);
				this.serviceManager.getRelationInfoService().updateRelationInfo(relationInfo);
				this.serviceManager.getTechnicalParametersService().updateTechnicalParameters(technicalParameters);
				this.serviceManager.getTechnicalInspectService().updateTechnicalInspect(technicalInspect);
				this.serviceManager.getHandlingSituationService().updateHandlingSituation(handlingSituation);
				
				log.info("拖拉机注册登记信息修改成功");
				response.getWriter().write("{success: true}");
			} else {
				response.getWriter().write("{errors:'拖拉机注册登记信息修改失败，请重新尝试!'}");
			}
		}
	}
	
	//删除拖拉机信息
	public void delTractorInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("add TractorInfo");
		String deltractorids = (String) request.getParameter("deltractorids").trim();
		String delownerinfoids = (String) request.getParameter("delownerinfoids").trim();
		String deltechnicalinspectids = (String) request.getParameter("deltechnicalinspectids").trim();
		String delhandlingsituationids = (String) request.getParameter("delhandlingsituationids").trim();
		String deltractorbasicinfoids = (String) request.getParameter("deltractorbasicinfoids").trim();
		String delrelationinfoids = (String) request.getParameter("delrelationinfoids").trim();
		String delregisterinfoids = (String) request.getParameter("delregisterinfoids").trim();
		String deltechnicalparametersids = (String) request.getParameter("deltechnicalparametersids").trim();
		String licenselist=(String)request.getParameter("licenselist").trim();
		UnitManage um=(UnitManage) request.getSession().getAttribute("userUnit");
        if(!deltractorids.equals("") && !delownerinfoids.equals("") && !deltechnicalinspectids.equals("") && !delhandlingsituationids.equals("") && !deltractorbasicinfoids.equals("") && !delrelationinfoids.equals("") && !delregisterinfoids.equals("") && !deltechnicalparametersids.equals("") && !licenselist.equals("")){
        	this.serviceManager.getTechnicalParametersService().delTechnicalParametersByIds(deltechnicalparametersids);
        	this.serviceManager.getRegisterInfoService().delRegisterInfoByIds(delregisterinfoids);
        	this.serviceManager.getRelationInfoService().delRelationInfoByIds(delrelationinfoids);
        	this.serviceManager.getTractorBasicInfoService().delTractorBasicInfoByIds(deltractorbasicinfoids);
        	this.serviceManager.getHandlingSituationService().delHandlingSituationByIds(delhandlingsituationids);
        	this.serviceManager.getTechnicalInspectService().delTechnicalInspectByIds(deltechnicalinspectids);
        	this.serviceManager.getOwnerInfoService().delOwnerInfoByIds(delownerinfoids);
        	this.serviceManager.getTractorInfoService().delTractorInfoByIds(deltractorids);
        	String[] licenseListArray=licenselist.split(".");
        	for(String license : licenseListArray){
        		String code=license.substring(0, license.indexOf("."));
        		String head=license.substring(license.indexOf(".")+1);
        		this.serviceManager.getPlateService().updatePlateStatus(code, head,um.getRegionid(), 0);
        		
        	}
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on del TractorInfo");
			response.getWriter().write("{failure:true,reason:'删除信息失败'}");
        }
	}
	//在删除拖拉机之前，先判断拖拉机是否有正在办理的业务
	public void checkTractorInfoBusiness(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("check TractorInfoBusiness");
		String deltractorids = (String) request.getParameter("deltractorids").trim();
			List<CarChange> carchangeList=this.serviceManager.getCarChangeService().findCarChangeingByTractorinfoId(deltractorids);
	        if(carchangeList.size()>0){
	        	response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[变更业务]业务流程还未处理完成,无法进行删除'}");
	        }else{
	        	List<CarCheck> carcheckList=this.serviceManager.getCarCheckService().findCarCheckingByTractorinfoId(deltractorids);
	        	if(carcheckList.size()>0){
		        	response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[年检业务]业务流程还未处理完成,无法进行删除'}");
		        }else{
		        	List<CarTransfer> cartransferList=this.serviceManager.getCarTransferService().findCarTransferingByTractorinfoId(deltractorids);
		        	if(cartransferList!=null && cartransferList.size()>0){
		        		response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[转移业务]业务流程还未处理完成,无法进行删除'}");
		        	}else{
		        		List<ChangeRecord> changerecordList=this.serviceManager.getChangeRecordService().findChangeRecordingByTractorinfoId(deltractorids);
		    	        if(changerecordList.size()>0){
		    	        	response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[变更备案]业务流程还未处理完成,无法进行删除'}");
		    	        }else{
		    	        	List<Mortgage>  mortgageList=this.serviceManager.getMortgageService().findMortgageingByTractorinfoId(deltractorids);
		    		        if(mortgageList.size()>0){
		    		        	response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[抵押登记]业务流程还未处理完成,无法进行删除'}");
		    		        }else{
		    		        	List<TractorReplacementInfo> TractorReplacementInfoList=this.serviceManager.getTractorReplacementInfoService().findTractorReplacementInfoByTractorinfoId(deltractorids);
		    			        if(TractorReplacementInfoList.size()>0){
		    			        	response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[补号码牌]业务流程还未处理完成,无法进行删除'}");
		    			        }else{
		    			        	List<Loyout> logoutList=this.serviceManager.getLoyoutService().findLoyoutByTractorinfoId(deltractorids);
		    				        if(logoutList.size()>0){
		    				        	response.getWriter().write("{success:false,reason:'选中删除的脱检拖拉机信息的[注销业务]业务流程还未处理完成,无法进行删除'}");
		    				        }else{
		    				        	response.getWriter().write("{success: true}");
		    				        }
		    			        }
		    		        }
		    	        }
		        	}
		        }
	        }
	}
	
	//上传图片
	public void uploadPic(HttpServletRequest request, HttpServletResponse response)throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("reach upload picture");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		FileItem fileItem = items.get(0);
		String fileName = new File(fileItem.getName()).getName();
		String mk = "["+request.getSession().getAttribute("unitid").toString().trim()+"]" + (new Date()).toLocaleString().substring(0, 10).trim();
		String filePath = request.getRealPath("//") + "//Public//Upload//" + mk + "//";
		File dir = new File(filePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File uploadFile = new File(filePath + "//" + fileName);
		fileItem.write(uploadFile);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("{success: true,url:'./Public/Upload/"+mk+"/"+fileName+"'}");
		log.info("上传了拖拉机照片：【" + uploadFile.getName() + "】");
	}
	
	//批量上报
	public void ReportedTractorInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Reported TractorInfo");
		User user=(User)request.getSession().getAttribute("user");
		String reporttractorinfoids = (String) request.getParameter("reporttractorinfoids").trim();
        if(!reporttractorinfoids.equals("")){
        	this.serviceManager.getTractorInfoService().updateTractorStateByIds(1, reporttractorinfoids, "");
        	//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			TractorInfoOperation operation = new TractorInfoOperation(st.getCarRegisterTime(),reporttractorinfoids);
			Thread thread = new Thread(operation, "CarCheck");
			thread.start();
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on del TractorInfo");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
        }
	}
	private class TractorInfoOperation implements Runnable {
		private int time;
		String audittractorinfoids;
		public TractorInfoOperation(int time,String audittractorinfoids){
			this.time = time;
			this.audittractorinfoids=audittractorinfoids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,audittractorinfoids);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String audittractorinfoids;
		public EggTimer(int time,String audittractorinfoids) {
			this.time = time;
			this.audittractorinfoids=audittractorinfoids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditTractorInfo(audittractorinfoids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
	
	//批量归档
	public void guiDangTractorInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Reported TractorInfo");
		String ids = (String) request.getParameter("ids").trim();
		int type=Integer.parseInt(request.getParameter("type").trim());
		ids=ids.substring(0,ids.length()-1);
        if(!ids.equals("")){
        	this.serviceManager.getTractorInfoService().GuiDang(ids,type);
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on del TractorInfo");
			response.getWriter().write("{failure:true,reason:'归档信息失败'}");
        }
	}
	
	//审核拖拉机信息，将拖拉机信息审核为通过或者不通过 //待上报为0 已上报为1  审核通过为2 审核不通过为3 
	public void checkTractorInfo(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Check TractorInfo");
		
		String audittractorinfoids = (String) request.getParameter("audittractorinfoids").trim();//得到需要审核的注册信息
		int state=Integer.parseInt(request.getParameter("state").trim());//得到需要变更的状态		
		log.info("Audit TractorInfo:[TractorInfo:"+audittractorinfoids+"]");		
        if(!audittractorinfoids.equals("")){
        	boolean re=this.serviceManager.getTractorInfoService().auditTractorInfo(state, audittractorinfoids);
        	if(state==2){
        		this.serviceManager.getTractorInfoService().auditTractorInfoFiling(0, audittractorinfoids);
        		String[] tractorinfoidsStr=audittractorinfoids.split(",");
        		for(int i=0;i<tractorinfoidsStr.length;i++)
        		{
        			PrintFlag printFlag=new PrintFlag();
					printFlag.setTractroinfoId(Integer.parseInt(tractorinfoidsStr[i]));
					printFlag.setPrintBegianDate(new Date());
					printFlag.setPrintEndDate(DateTimeUtil.addDate(15));
					printFlag.setFlag(1);
					printFlag.setPrintType(0);
					this.serviceManager.getPrintFlagService().addPrintFlag(printFlag);
					
					printFlag=new PrintFlag();
					printFlag.setTractroinfoId(Integer.parseInt(tractorinfoidsStr[i]));
					printFlag.setPrintBegianDate(new Date());
					printFlag.setPrintEndDate(DateTimeUtil.addDate(15));
					printFlag.setFlag(1);
					printFlag.setPrintType(1);
					this.serviceManager.getPrintFlagService().addPrintFlag(printFlag);
        		}
        	}
        	if(re){
        		response.getWriter().write("{success: true}");	
        	}
        	else{
        		response.getWriter().write("{success: false}");
        	}
        	
        }
        else{
			log.info("Err on audit TractorInfo");
			response.getWriter().write("{failure:true,reason:'审核信息失败'}");
        }
	}
	
	//自动审核
	public void ThreadAuditTractorInfo(String audittractorinfoids){
		String waitAuditTractorIds="";
		List<TractorInfo> list=this.serviceManager.getTractorInfoService().getTractorInfoListByIds(audittractorinfoids);
		for(TractorInfo tractorinfo:list){
			if(tractorinfo.getStatus()==1){
				 if (waitAuditTractorIds.length() == 0) {
					 waitAuditTractorIds = waitAuditTractorIds +String.valueOf(tractorinfo.getId());
                 } else {
                	 waitAuditTractorIds = waitAuditTractorIds + "," +String.valueOf(tractorinfo.getId());
                 }
			}
		}
		if(!waitAuditTractorIds.equals("")){
	        	this.serviceManager.getTractorInfoService().auditTractorInfo(2, waitAuditTractorIds);
	        	this.serviceManager.getTractorInfoService().auditTractorInfoFiling(0, waitAuditTractorIds);
	      }
	}
	
	//信息采集表
	public void tractorInfoReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<CarInfomationSource> list = serviceManager.getTractorInfoService().tractorInfoReport(Integer.valueOf(id));
		list.get(0).setPhotoUrl(request.getSession().getServletContext().getRealPath("/")+list.get(0).getPhotoUrl().substring(2));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_tractorInfoReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/carInfomation.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	//注册登记表
	public void tractorInfoRegisterReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationAndTurnInSource> list = serviceManager.getTractorInfoService().tractorInfoReportTwo(Integer.valueOf(id));
		String fineName = list.get(0).getEngineno()+"_tractorInfoRegisterReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorRegistrationAndTurnIn.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	//技术参数表
	public void tractorInfoTechnicReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TechnicalDataSource> list = serviceManager.getTractorInfoService().tractorInfoReportThree(Integer.valueOf(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_tractorInfoTechnicReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/technicalData.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	//检验报告
	public void tractorInfoCheckReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<CarSafetyRoportSource> list = serviceManager.getTractorInfoService().tractorInfoReportFour(Integer.valueOf(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_tractorInfoCheckReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/carSafetyReport.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void tractorInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getTractorInfoService().tractorInfoReportFive(Integer.valueOf(id));
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
	
	public void tractorSteerReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		List<CarMoveReportSource> list = serviceManager.getTractorInfoService().tractorSteerReport(Integer.valueOf(id));		

		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_tractorSteerReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
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
		}
		String address = list.get(0).getAddress1();
		if(address.length()>10){
			list.get(0).setAddress1(address.substring(0,10));
			list.get(0).setAddress2(address.substring(10, address.length()));
		}
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/carMoveLicence.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	public void tractorEnregisterCertificate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		UnitManage unit = (UnitManage)request.getSession().getAttribute("userUnit");
		String wordType=request.getParameter("wordType");
		String id = request.getParameter("id").trim();
		List<TractorEnregisterCertificateReportSource> list = serviceManager.getTractorInfoService().TractorEnregisterCertificate(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		
		list.get(0).setRegistrationauthority_1(unit.getUseunit());
		list.get(0).setRegisterdate_1(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
		list.get(0).setRegistrationno_1("123456789");
		
//		list.get(0).setOwner_2(list.get(0).getOwner_1());
//		list.get(0).setRealcertificatetype_2(unit.getUseunit());
//		list.get(0).setRealcertificateno_2(unit.getUseunit());
//		list.get(0).setRegistrationauthority_2(unit.getUseunit());
//		list.get(0).setRegisterdate_2(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
//		list.get(0).setRegistrationno_2("2");
//		
//		list.get(0).setOwner_3(list.get(0).getOwner_1());
//		list.get(0).setRealcertificatetype_3(unit.getUseunit());
//		list.get(0).setRealcertificateno_3(unit.getUseunit());
//		list.get(0).setRegistrationauthority_3(unit.getUseunit());
//		list.get(0).setRegisterdate_3(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
//		list.get(0).setRegistrationno_3("3");
//		
//		list.get(0).setOwner_4(list.get(0).getOwner_1());
//		list.get(0).setRealcertificatetype_4(unit.getUseunit());
//		list.get(0).setRealcertificateno_4(unit.getUseunit());
//		list.get(0).setRegistrationauthority_4(unit.getUseunit());
//		list.get(0).setRegisterdate_4(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
//		list.get(0).setRegistrationno_4("4");
//		
//		list.get(0).setOwner_5(list.get(0).getOwner_1());
//		list.get(0).setRealcertificatetype_5(unit.getUseunit());
//		list.get(0).setRealcertificateno_5(unit.getUseunit());
//		list.get(0).setRegistrationauthority_5(unit.getUseunit());
//		list.get(0).setRegisterdate_5(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
//		list.get(0).setRegistrationno_5("5");
//		
//		list.get(0).setOwner_6(list.get(0).getOwner_1());
//		list.get(0).setRealcertificatetype_6(unit.getUseunit());
//		list.get(0).setRealcertificateno_6(unit.getUseunit());
//		list.get(0).setRegistrationauthority_6(unit.getUseunit());
//		list.get(0).setRegisterdate_6(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
//		list.get(0).setRegistrationno_6("6");
//		
//		list.get(0).setOwner_7(list.get(0).getOwner_1());
//		list.get(0).setRealcertificatetype_7(unit.getUseunit());
//		list.get(0).setRealcertificateno_7(unit.getUseunit());
//		list.get(0).setRegistrationauthority_7(unit.getUseunit());
//		list.get(0).setRegisterdate_7(DateTimeUtil.formatDate(DateTimeUtil.getNow()));
//		list.get(0).setRegistrationno_7("7");
		
		
		String fineName = list.get(0).getDriverinno()+"_tractorEnregisterCertificate_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/RegistrationInformation.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
	
	//获得详细信息
	public void GetAllTractorInfo(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String license=request.getParameter("license").trim();
		String[] plateS=license.split("\\.");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String wordType=request.getParameter("wordType");
		TractorInfoView tractorinfoview=serviceManager.getTractorInfoViewService().findTractorInfoViewByWhere(plateS[0], plateS[1],regionid);
		if(plateS[0]!=null&&plateS[1]!=null){
		  tractorinfoview=serviceManager.getTractorInfoViewService().findTractorInfoViewByWhere(plateS[0], plateS[1],regionid);
		}
		if(tractorinfoview!=null){
	      String Manufacturedate="";
	      if(tractorinfoview.getManufacturedate()!=null){
	    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    	  Manufacturedate=df.format(tractorinfoview.getManufacturedate().getTime());
	      }
		  String information = "<table  width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"ynzcTableBlue\"><tr><td colspan=\"6\">所有人信息</td></tr><tr><td>所有人</td><td>"+tractorinfoview.getOwner()+"</td><td>联系电话</td><td>"+tractorinfoview.getTelephone()+"</td><td width=\"\" colspan=\"2\" rowspan=\"6\"><img src=\""+tractorinfoview.getPhotourl()+"\" alt=\"\"name=\"noneimg\"width=\"320\"height=\"150\"id=\"noneimg\"/></td></tr><tr><td>联系地址</td><td colspan=\"3\">"+tractorinfoview.getAddress()+"</td></tr><tr><td>号牌号码</td><td><font color=red>"+tractorinfoview.getPlatecode()+"."+tractorinfoview.getLicense()+"</font></td><td>登记证书编号</td><td>"+tractorinfoview.getRegcerno()+"</td></tr><tr><td>获得方式</td><td>"+tractorinfoview.getGetway()+"</td><td>机械类型</td><td>"+tractorinfoview.getMachinetype()+"</td></tr><tr><td>品牌型号</td><td>"+tractorinfoview.getPlantType()+"</td><td>机身(底盘)号码</td><td>"+tractorinfoview.getMachinebodyno()+"</td></tr><tr><td>挂机架号码</td><td>"+tractorinfoview.getShelfno()+"</td><td>使用性质</td><td>"+tractorinfoview.getUsedfor()+"</td></tr><tr><td>发动机号码</td><td>"+tractorinfoview.getEngineno()+"</td><td>制造厂名称</td><td>"+tractorinfoview.getManufacturer()+"</td><td>出厂日期</td><td>"+Manufacturedate+"</td></tr><tr><td>销售单位/交易市场名称</td><td>"+tractorinfoview.getSeller()+"</td><td>销售交易价格</td><td>"+tractorinfoview.getPrice()+"</td><td>机身颜色</td><td>"+tractorinfoview.getMachinebodycolor()+"</td></tr><tr><td>外廓尺寸</td><td>"+tractorinfoview.getOutsize()+"</td><td>转向形式</td><td>"+tractorinfoview.getDirectcontrol()+"</td><td>货箱内部尺寸</td><td>"+tractorinfoview.getContainersize()+"</td></tr><tr><td>发动机品牌</td><td>"+tractorinfoview.getEngineBrand()+"</td><td>功率</td><td>"+tractorinfoview.getPower()+"</td><td>缸数</td><td>"+tractorinfoview.getCylinderno()+"</td></tr><tr><td>燃料种类</td><td>"+tractorinfoview.getFuelname()+"</td><td>轴数</td><td>"+tractorinfoview.getWheelno()+"</td><td>轴距</td><td>"+tractorinfoview.getWheelbase()+"</td></tr><tr><td>轮胎数</td><td>"+tractorinfoview.getTiresno()+"</td><td>轮胎规格</td><td>"+tractorinfoview.getTiressize()+"</td><td>轮距</td><td>"+tractorinfoview.getWheeldis()+"</td></tr><tr><td>总质量</td><td>"+tractorinfoview.getTotalquality()+"</td><td>整备质量</td><td>"+tractorinfoview.getAllquality()+"</td><td>核定载质量</td><td>"+tractorinfoview.getRatifiedload()+"</td></tr><tr><td>准牵引总质量</td><td>"+tractorinfoview.getAllowdragtotalquality()+"</td><td>驾驶室载人</td><td>"+tractorinfoview.getDriverinno()+"</td><td>钢板弹簧片数</td><td>后轴"+tractorinfoview.getSteelspring()+"片</td></tr><tr><td>挂车轮胎数</td><td>"+tractorinfoview.getVicecartiresno()+"</td><td>挂车轮距</td><td>"+tractorinfoview.getOutcarwheeldis()+"</td><td>挂车轮胎规格</td><td>"+tractorinfoview.getOutcartiressize()+"</td></tr></table>";
		  response.getWriter().write("{success: true,result:'"+information+"'}");
		}else{
		  log.info("Err on getall TractorInfo");
		  response.getWriter().write("{failure:true,reason:'获取详细信息失败'}");
		}
	}
	//得到所有拖拉机的注册日期
	public void getRegisterYear(HttpServletRequest request,HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		System.out.println("Get RegisterYear");
		User user=(User)request.getSession().getAttribute("user");
		List<TractorInfoRegisterYear> res=this.serviceManager.getTractorInfoService().getRegisterYear();
		JSONArray jsonItems = new JSONArray();
		for (TractorInfoRegisterYear r : res) {
			jsonItems.add(JSONObject.fromObject(r));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("RegisterYear", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	

	
}
