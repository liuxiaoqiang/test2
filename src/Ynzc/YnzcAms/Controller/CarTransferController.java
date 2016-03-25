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
import Ynzc.YnzcAms.Model.CarTransfer;
import Ynzc.YnzcAms.Model.CarTransferView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.Plate;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorRegistrationAndTurnInSource;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorTransferApplicationSource;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

public class CarTransferController extends BaseController {
	private final static Logger log = Logger
			.getLogger(CarTransferController.class);

	// 查询领导审核岗中的车辆转移的分页数据
	@SuppressWarnings("unused")
	public void getAllCarTransferListByPage(HttpServletRequest request,
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
		String transfertype = request.getParameter("transfertype");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String condition = "";// 设置查询条件为空
		condition = TractorInfoSearch.getBusinessCondition(state, codenum,
				owner, machinetype, plantType, checkexpriydate, regcerno,
				cardid, engineno, transfertype, "cartransfer");
		List<CarTransferView> res = this.serviceManager.getCarTransferService()
				.getCarTransferViewList(page, condition, unit.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (CarTransferView u : res) {
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
	
	//查询当前登记审核岗的 登记的转出车辆数据 1.登记的转出数据(等待上报、已经上报等待审核) 2.已经完成的转出数据(审核通过、审核未通过)
	public void getOutCarTransferListByPage(HttpServletRequest request,
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
		String transfertype = request.getParameter("transfertype");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		String condition = "";// 设置查询条件为空
		condition = TractorInfoSearch.getBusinessCondition(state, codenum,
				owner, machinetype, plantType, checkexpriydate, regcerno,
				cardid, engineno, transfertype, "cartransfer");
		List<CarTransferView> res = this.serviceManager.getCarTransferService().getOutCarTransferViewList(page, condition, unit.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (CarTransferView u : res) {
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
	//查询当前登记审核岗的 等待处理的转入车辆
	public void getIntoCarTransferViewList(HttpServletRequest request,
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
		String transfertype = request.getParameter("transfertype");
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		String condition = "";// 设置查询条件为空
		condition = TractorInfoSearch.getBusinessCondition(state, codenum,
				owner, machinetype, plantType, checkexpriydate, regcerno,
				cardid, engineno, transfertype, "cartransfer");
		List<CarTransferView> res = this.serviceManager.getCarTransferService().getIntoCarTransferViewList(page, condition, unit.getRegionid());
		JSONArray jsonItems = new JSONArray();
		for (CarTransferView u : res) {
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
	// 添加
	public void addCarTransfer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int tractorinfoId = Integer.parseInt(request.getParameter(
				"tractorinfoId").trim());
		String transfertype = (String) request.getParameter("transfertype")
				.trim();

		String orginregionid = (String) request.getParameter("orginregionid")
				.trim();// 原地区ID1,2
		String orginregionname = (String) request
				.getParameter("orginregionname");

		int orginunitid = Integer.parseInt(request.getParameter("orginunitid")
				.trim());// 原单位
		String orginunitname = (String) request.getParameter("orginunitname");

		String regionid = (String) request.getParameter("regionid").trim();// 现地区ID
		String regionname = (String) request.getParameter("regionname");
		String unitValue=request.getParameter("unitid").trim();
		int unitid=0;
		String unitname="";
		if(StringUtil.isNumber(unitValue)){
			//查看是否是数字,如果是数字
			 unitid = Integer.parseInt(request.getParameter("unitid"));// 现单位
			 UnitManage manage = this.serviceManager.getUnitManageService().findUnitManageById(unitid);
			 unitname=manage.getUseunit();
		}else{
			//如果不是数字则根据名称查询对应的单位ID
			UnitManage unitmange=this.serviceManager.getUnitManageService().findUnitManageByUnitName(unitValue);
			unitid=unitmange.getId();
			unitname=unitValue;
		}
		
		// String unitname=request.getParameter("unitname").trim();
		

		log.info("Add new CarTransfer:[orginunitname:" + orginunitname + "]");
		CarTransfer model = new CarTransfer();
		model.setTractorinfoId(tractorinfoId);// 转移的车辆ID
		model.setTransfertype(transfertype);//业务类型
		model.setOrginregionid(orginregionid);//转出地区ID
		model.setOrginregionname(orginregionname);//转出地区名称
		model.setOrginunitid(orginunitid);//转出机构ID
		model.setOrginunitname(orginunitname);//转出机构名称

		model.setRegionid(regionid);//转入地区ID
		model.setRegionname(regionname);//转入地区名称
		model.setUnitid(unitid); //转入机构ID
		model.setUnitname(unitname);//转入机构名称

		model.setApplydate(new Date());// 设置为默认日期
		model.setApplymen(request.getSession().getAttribute("oper")
				.toString());// 设置为当前登录用户
		model.setApplyip(request.getRemoteAddr());// 设置IP地址
		model.setCheckresult(0);// 设置审核状态，默认为待报数据
		model.setApplytype(0);//申请类型为转出

		if (serviceManager.getCarTransferService().addCarTransfer(model)) {
			TractorInfo tractorInfo = this.serviceManager
					.getTractorInfoService().findTractorInfoById(tractorinfoId);
			tractorInfo.setStatus(8);
			this.serviceManager.getTractorInfoService().updateTractorInfo(
					tractorInfo);
			log.info("保存转移信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'保存转移信息失败，请重新尝试!'}");
		}
	}

	// 批量上报
	public void ReportedCarTransfer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("add TractorInfo");
		User user=(User)request.getSession().getAttribute("user");
		String reportcartransferids = (String) request.getParameter(
				"reportcartransferids").trim();
		if (!reportcartransferids.equals("")) {
			this.serviceManager.getCarTransferService().updateCarTransferStateByIds(1, reportcartransferids);
			//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarTransferTime();
            }
			CarTransferOperation operation = new CarTransferOperation(audittime,user.getRealname(),request.getRemoteAddr(),reportcartransferids);
			Thread thread = new Thread(operation, "CarTransfer");
			thread.start();
			response.getWriter().write("{success: true}");
		} else {
			log.info("Err on del TractorInfo");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
		}
	}
	private class CarTransferOperation implements Runnable {
		private int time;
		String realname;
		String remoteaddr;
		String auditcartransferids;
		public CarTransferOperation(int time,String realname,String remoteaddr,String auditcartransferids){
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditcartransferids=auditcartransferids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,realname,remoteaddr,auditcartransferids);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String remoteaddr;
		String auditcartransferids;
		public EggTimer(int time,String realname,String remoteaddr,String auditcartransferids) {
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditcartransferids=auditcartransferids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditCarTransfer(realname,remoteaddr,auditcartransferids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}

	// 更新数据
	public void updateCarTransfer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("update CarTransfer");
		int id = Integer.parseInt(request.getParameter("id"));
		int tractorinfoId = Integer.parseInt(request
				.getParameter("tractorinfoId"));
		String transfertype = request.getParameter("transfertype");
		String orginregionid = request.getParameter("orginregionid");
		String orginregionname = request.getParameter("orginregionname");
		int orginunitid = Integer.parseInt(request.getParameter("orginunitid"));
		String orginunitname = request.getParameter("orginunitname");
		String regionid = request.getParameter("regionid");
		String regionname = request.getParameter("regionname");
		//int unitid = Integer.parseInt(request.getParameter("unitid"));
		String applydate = request.getParameter("applydate");
		String applymen = request.getParameter("applymen");
		String applyip = request.getParameter("applyip");
		String checkmen = request.getParameter("checkmen");
		String checkdate = request.getParameter("checkdate");
		String checkip = request.getParameter("checkip");
		int checkresult = Integer.parseInt(request.getParameter("checkresult"));
		String checkcontext = request.getParameter("checkcontext");
		String unitValue=request.getParameter("unitid").trim();
		int unitid=0;
		String unitname="";
		if(StringUtil.isNumber(unitValue)){
			//查看是否是数字,如果是数字
			 unitid = Integer.parseInt(request.getParameter("unitid"));// 现单位
			 UnitManage manage = this.serviceManager.getUnitManageService().findUnitManageById(unitid);
			 unitname=manage.getUseunit();
		}else{
			//如果不是数字则根据名称查询对应的单位ID
			UnitManage unitmange=this.serviceManager.getUnitManageService().findUnitManageByUnitName(unitValue);
			unitid=unitmange.getId();
			unitname=unitValue;
		}
		//UnitManage manage = this.serviceManager.getUnitManageService().findUnitManageById(unitid);

		CarTransfer model = new CarTransfer();
		model.setId(id);
		model.setTractorinfoId(tractorinfoId);// 转移的车辆ID
		model.setTransfertype(transfertype);
		model.setOrginregionid(orginregionid);
		model.setOrginregionname(orginregionname);
		model.setOrginunitid(orginunitid);
		model.setOrginunitname(orginunitname);

		model.setRegionid(regionid);
		model.setRegionname(regionname);
		model.setUnitid(unitid);
		model.setUnitname(unitname);

		model.setApplydate(new SimpleDateFormat("yyyy-MM-dd").parse(applydate
				.trim()));
		model.setApplymen(applymen);
		model.setApplyip(applyip);
		if (checkmen != null && !checkmen.equals("")) {
			model.setCheckmen(checkmen);
		}
		if (checkdate != null && !checkdate.equals("")) {
			model.setCheckdate(new SimpleDateFormat("yyyy-MM-dd")
					.parse(checkdate.trim()));
		}
		if (checkip != null && !checkip.equals("")) {
			model.setCheckip(checkip);
		}
		model.setCheckresult(checkresult);
		if (checkcontext != null && !checkcontext.equals("")) {
			model.setCheckcontext(checkcontext);
		}
		if (this.serviceManager.getCarTransferService()
				.updateCarTransfer(model)) {
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{success: false}");
		}
	}

	// 删除数据
	public void delCarTransfer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("Del CarTransfer");
		String delcartransferids = request.getParameter("mydelcartransferids");
		String tractorids = request.getParameter("tractorids");
		if (!delcartransferids.equals("")) {
			if (this.serviceManager.getCarTransferService()
					.delCarTransferByIds(delcartransferids)) {
				if (!tractorids.equals("")) {
					tractorids = tractorids.substring(0,
							tractorids.length() - 1);
					this.serviceManager
							.getTractorInfoService()
							.updateTractorStateByIds(2, tractorids,
									TractorInfoSearch.GetBusinessOverCondtion());
				}
				response.getWriter().write("{success: true}");
			} else {
				log.info("Err on del CarTransfer");
				response.getWriter().write("{success: false}");
			}
		}
	}

	// 审核转移信息
	@SuppressWarnings("rawtypes")
	public void AuditCarTransfer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("Check CarTransfer");
		User user = (User) request.getSession().getAttribute("user");
		String auditmodels = (String) request.getParameter("auditCarTransferModels").trim();// 得到需要审核的转移信息
		int state = Integer.parseInt(request.getParameter("state").trim());// 得到需要审核的状态
		String checkContent = (String) request.getParameter("checkContent").trim();// 得到需要审核的审核意见
		//1.将申请业务信息的审核状态进行相应的修改 2.将对应的拖拉机状态修改为正常状态，以便于进行其他业务操作
		JSONArray jsonArray = JSONArray.fromObject(auditmodels);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			CarTransferView viewmodel = (CarTransferView) JSONObject.toBean(jsonObject, CarTransferView.class);
			CarTransfer carTranserModel=new CarTransfer();
			carTranserModel.setId(viewmodel.getId());
			carTranserModel.setTractorinfoId(viewmodel.getTractorinfoId());
			carTranserModel.setTransfertype(viewmodel.getTransfertype());
			carTranserModel.setOrginregionid(viewmodel.getOrginregionid());
			carTranserModel.setOrginregionname(viewmodel.getOrginregionname());
			carTranserModel.setOrginunitid(viewmodel.getOrginunitid());
			carTranserModel.setOrginunitname(viewmodel.getOrginunitname());
			carTranserModel.setRegionid(viewmodel.getCurrentregionid());
			carTranserModel.setRegionname(viewmodel.getRegionname());
			carTranserModel.setUnitid(viewmodel.getCurrentunitid());
			carTranserModel.setUnitname(viewmodel.getUnitname());
			carTranserModel.setApplydate(viewmodel.getApplydate());
			carTranserModel.setApplymen(viewmodel.getApplymen());
			carTranserModel.setApplyip(viewmodel.getApplyip());
			carTranserModel.setCheckmen(user.getRealname());
			carTranserModel.setCheckdate(new Date());
			carTranserModel.setCheckip(request.getRemoteAddr());
			carTranserModel.setCheckresult(state);
			carTranserModel.setCheckcontext(checkContent);
			carTranserModel.setOldlicense(viewmodel.getOldlicense());
			carTranserModel.setApplytype(viewmodel.getApplytype());
			if (state == 2){
				TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
				if (tractorinfoModel != null) {
					//如果是审核通过
					if(viewmodel.getApplytype()==0)
					{
						//如果通过的申请为转出.则将车辆地区进行更新
						tractorinfoModel.setRegionid(viewmodel.getCurrentregionid());
						tractorinfoModel.setUnitid(viewmodel.getCurrentunitid());	
						//记录原号牌
						if(viewmodel.getTransfertype().trim().equals("管辖区外的转移登记")){
							carTranserModel.setOldlicense(viewmodel.getPlatecode()+"."+viewmodel.getLicense());
							//更新号牌信息
							Plate plate=new Plate();
							String platehead=(String) request.getSession().getAttribute("platecode");
							plate=serviceManager.getPlateService().getPlate(viewmodel.getLicense(), platehead);
							plate.setStatus(7);
							serviceManager.getPlateService().updatePlateInfo(plate);
						}
						//更新拖拉机业务状态以及转移地区
						this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
						//更新转移信息的审核信息
						this.serviceManager.getCarTransferService().updateCarTransfer(carTranserModel);
						//审核通过之后，产生一条新的转入记录
						CarTransfer newCarTranserModel=new CarTransfer();
						newCarTranserModel.setTractorinfoId(viewmodel.getTractorinfoId());// 转移的车辆ID
						newCarTranserModel.setTransfertype(viewmodel.getTransfertype());//业务类型
						newCarTranserModel.setOrginregionid(viewmodel.getOrginregionid());//转出地区ID
						newCarTranserModel.setOrginregionname(viewmodel.getOrginregionname());//转出地区名称
						newCarTranserModel.setOrginunitid(viewmodel.getOrginunitid());//转出机构ID
						newCarTranserModel.setOrginunitname(viewmodel.getOrginunitname());//转出机构名称
						newCarTranserModel.setRegionid(viewmodel.getCurrentregionid());//转入地区ID
						newCarTranserModel.setRegionname(viewmodel.getRegionname());//转入地区名称
						newCarTranserModel.setUnitid(viewmodel.getCurrentunitid()); //转入机构ID
						newCarTranserModel.setUnitname(viewmodel.getUnitname());//转入机构名称
						newCarTranserModel.setApplydate(new Date());// 设置为默认日期
						newCarTranserModel.setApplymen(viewmodel.getApplymen());// 设置为转出申请的用户
						newCarTranserModel.setApplyip(request.getRemoteAddr());// 设置IP地址
						newCarTranserModel.setCheckresult(0);// 设置审核状态，默认为待报数据
						newCarTranserModel.setOldlicense(carTranserModel.getOldlicense());
						newCarTranserModel.setApplytype(1);//申请类型为转入
						this.serviceManager.getCarTransferService().addCarTransfer(newCarTranserModel);
					}
					else if(viewmodel.getApplytype()==1)
					{
						//如果通过的申请为转入，则将车辆对应的业务状态修改为完毕，
						if (tractorinfoModel.getStatus() == 8) {
							tractorinfoModel.setStatus(2);
						}
						//毕业完毕之后进行车辆归档
						tractorinfoModel.setFiling(1);
						tractorinfoModel.setFilingDate(new  Date());
						this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
						this.serviceManager.getCarTransferService().updateCarTransfer(carTranserModel);
					}
				}
			}
			else if(state == 3){
				//如果审核未通过
				if(viewmodel.getCheckresult()==2)
				{
					// 如果当前审核的是已经通过的数据,则更新拖拉机状态为变更业务中
					TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
					if (tractorinfoModel.getStatus() == 2) {
						tractorinfoModel.setStatus(8);
						this.serviceManager.getTractorInfoService()
								.updateTractorInfo(tractorinfoModel);
					}
				}
				this.serviceManager.getCarTransferService().updateCarTransfer(carTranserModel);
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	//自动审核,将指定的上报的数据在一定时间内，自动将依然为待审的数据审核为通过
	public void ThreadAuditCarTransfer(String checkusername,String checkip,String auditcartransferIds)
	{
		List<CarTransferView> list = this.serviceManager.getCarTransferService().getCarTransferViewListByIds(auditcartransferIds);
		for (CarTransferView viewmodel: list){
			//只对待审的数据进行审核通过
			if(viewmodel.getCheckresult()==1)
			{
				//得到转移信息
				CarTransfer carTranserModel=new CarTransfer();
				carTranserModel.setId(viewmodel.getId());
				carTranserModel.setTractorinfoId(viewmodel.getTractorinfoId());
				carTranserModel.setTransfertype(viewmodel.getTransfertype());
				carTranserModel.setOrginregionid(viewmodel.getOrginregionid());
				carTranserModel.setOrginregionname(viewmodel.getOrginregionname());
				carTranserModel.setOrginunitid(viewmodel.getOrginunitid());
				carTranserModel.setOrginunitname(viewmodel.getOrginunitname());
				carTranserModel.setRegionid(viewmodel.getCurrentregionid());
				carTranserModel.setRegionname(viewmodel.getRegionname());
				carTranserModel.setUnitid(viewmodel.getCurrentunitid());
				carTranserModel.setUnitname(viewmodel.getUnitname());
				carTranserModel.setApplydate(viewmodel.getApplydate());
				carTranserModel.setApplymen(viewmodel.getApplymen());
				carTranserModel.setApplyip(viewmodel.getApplyip());
				carTranserModel.setCheckmen(checkusername);
				carTranserModel.setCheckdate(new Date());
				carTranserModel.setCheckip(checkip);
				carTranserModel.setCheckresult(2);
				carTranserModel.setCheckcontext("审核通过");
				carTranserModel.setOldlicense(viewmodel.getOldlicense());
				carTranserModel.setApplytype(viewmodel.getApplytype());
				
				TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
				if (tractorinfoModel != null) {
						if(viewmodel.getApplytype()==0)
						{
							//如果通过的申请为转出.则将车辆地区进行更新
							tractorinfoModel.setRegionid(viewmodel.getCurrentregionid());
							tractorinfoModel.setUnitid(viewmodel.getCurrentunitid());	
							//记录原号牌
							if(viewmodel.getTransfertype().trim().equals("管辖区外的转移登记")){
								carTranserModel.setOldlicense(viewmodel.getPlatecode()+"."+viewmodel.getLicense());	
							}
							//更新拖拉机业务状态以及转移地区
							this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
							//更新转移信息的审核信息
							this.serviceManager.getCarTransferService().updateCarTransfer(carTranserModel);
							//审核通过之后，产生一条新的转入记录
							CarTransfer newCarTranserModel=new CarTransfer();
							newCarTranserModel.setTractorinfoId(viewmodel.getTractorinfoId());// 转移的车辆ID
							newCarTranserModel.setTransfertype(viewmodel.getTransfertype());//业务类型
							newCarTranserModel.setOrginregionid(viewmodel.getOrginregionid());//转出地区ID
							newCarTranserModel.setOrginregionname(viewmodel.getOrginregionname());//转出地区名称
							newCarTranserModel.setOrginunitid(viewmodel.getOrginunitid());//转出机构ID
							newCarTranserModel.setOrginunitname(viewmodel.getOrginunitname());//转出机构名称
							newCarTranserModel.setRegionid(viewmodel.getCurrentregionid());//转入地区ID
							newCarTranserModel.setRegionname(viewmodel.getRegionname());//转入地区名称
							newCarTranserModel.setUnitid(viewmodel.getCurrentunitid()); //转入机构ID
							newCarTranserModel.setUnitname(viewmodel.getUnitname());//转入机构名称
							newCarTranserModel.setApplydate(new Date());// 设置为默认日期
							newCarTranserModel.setApplymen(viewmodel.getApplymen());// 设置为转出申请的用户
							newCarTranserModel.setApplyip(checkip);// 设置IP地址
							newCarTranserModel.setCheckresult(0);// 设置审核状态，默认为待报数据
							newCarTranserModel.setOldlicense(carTranserModel.getOldlicense());
							newCarTranserModel.setApplytype(1);//申请类型为转入
							this.serviceManager.getCarTransferService().addCarTransfer(newCarTranserModel);
						}
						else if(viewmodel.getApplytype()==1)
						{
							//如果通过的申请为转入，则将车辆对应的业务状态修改为完毕，
							if (tractorinfoModel.getStatus() == 8) {
								tractorinfoModel.setStatus(2);
							}
							//毕业完毕之后进行车辆归档
							tractorinfoModel.setFiling(1);
							tractorinfoModel.setFilingDate(new  Date());
							this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
							this.serviceManager.getCarTransferService().updateCarTransfer(carTranserModel);
						}

				}
			}
		}
	}
	//打印业务流程
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void carTransferInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getCarTransferService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_carTransferFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
	//打印转入申请表
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void tractorInfoTurnInReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
		String tractorinfoid = request.getParameter("tractorinfoid").trim();
		
		List<TractorRegistrationAndTurnInSource> list = serviceManager.getCarTransferService().tractorInfoTurnInReport(Integer.valueOf(tractorinfoid));
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
	//拖拉机转移登记申请表
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void PrintCarTransferReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();//拖拉机ID
		String wordType=request.getParameter("wordType");
		List<TractorTransferApplicationSource> list=this.serviceManager.getCarTransferService().PrintCarTransferReport(Integer.parseInt(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_CarTransferReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorTransferApplication.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}

}