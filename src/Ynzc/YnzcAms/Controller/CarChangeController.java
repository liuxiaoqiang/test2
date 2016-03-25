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
import Ynzc.YnzcAms.Model.CarChange;
import Ynzc.YnzcAms.Model.CarChangeView;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.CarTransferView;
import Ynzc.YnzcAms.Model.ChangeBody;
import Ynzc.YnzcAms.Model.ChangeColor;
import Ynzc.YnzcAms.Model.ChangeEngine;
import Ynzc.YnzcAms.Model.ChangeOwner;
import Ynzc.YnzcAms.Model.ChangeRecordView;
import Ynzc.YnzcAms.Model.ChangeTrailer;
import Ynzc.YnzcAms.Model.LogoutView;
import Ynzc.YnzcAms.Model.MortgageView;
import Ynzc.YnzcAms.Model.OwnerInfo;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TechnicalParameters;
import Ynzc.YnzcAms.Model.TractorAlterApplicationSource;
import Ynzc.YnzcAms.Model.TractorBasicInfo;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorInfoView;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.TractorReplacementInfoView;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

public class CarChangeController extends BaseController {
	private final static Logger log = Logger
			.getLogger(CarTransferController.class);

	// 查询分页数据,此处查询的是所有的变更信息
	@SuppressWarnings("unused")
	public void getAllCarChangeListByPage(HttpServletRequest request,
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
		String changtype = request.getParameter("changtype");
		User user = (User) request.getSession().getAttribute("user");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String condition = "";
		condition = TractorInfoSearch.getBusinessCondition(state, codenum,
				owner, machinetype, plantType, checkexpriydate, regcerno,
				cardid, engineno, changtype, "carchange");
		List<CarChangeView> res = serviceManager.getCarChangeService()
				.getCarChangeViewList(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (CarChangeView u : res) {
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

	// 添加车辆变更信息
	public void addCarChange(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");

		int tractorinfoId = Integer.parseInt(request.getParameter(
				"tractorinfoId").trim());// 变更拖拉机ID
		String changeType = (String) request.getParameter("changeType").trim();// 变更类型
		log.info("Add new CarChange:[tractorinfoId:" + tractorinfoId + "]");
		JSONObject jsonObject;
		ChangeColor changeColor;// 变更机身颜色
		ChangeBody changeBody;// 变更整机
		ChangeEngine changeEngine;// 变更 变更发动机
		ChangeTrailer changeTrailer;// 变更挂车
		ChangeOwner changeOwner;// 变更所有人信息
		User user = (User) request.getSession().getAttribute("user");
		CarChange carChange = new CarChange();
		carChange.setTractorinfoId(tractorinfoId);
		carChange.setChangeType(changeType);
		carChange.setApplicationmen(user.getRealname());
		carChange.setApplicationtime(new Date());
		String applicationip=request.getRemoteAddr();
		carChange.setApplicationip(applicationip);
		carChange.setApprovalstate(0);
		if (this.serviceManager.getCarChangeService().addCarChange(carChange)) {
			if (changeType.equals("共同所有的拖拉机变更拖拉机所有人".trim())) {
				String changeownerJosn = (String) request.getParameter(
						"changeowner").trim();
				jsonObject = JSONObject.fromObject(changeownerJosn);
				changeOwner = (ChangeOwner) JSONObject.toBean(jsonObject,
						ChangeOwner.class);
				changeOwner.setCarchangeid(carChange.getId());
				this.serviceManager.getChangeOwnerService().addChangeOwner(
						changeOwner);
			} else if (changeType.equals("变更机身颜色".trim())) {
				String changecolorJosn = (String) request.getParameter(
						"changecolor").trim();
				jsonObject = JSONObject.fromObject(changecolorJosn);
				changeColor = (ChangeColor) JSONObject.toBean(jsonObject,
						ChangeColor.class);
				changeColor.setCarchangeid(carChange.getId());
				this.serviceManager.getChangeColorService().addChangeColor(
						changeColor);
			} else if (changeType.equals("更换发动机".trim())) {
				String changeengineJosn = (String) request.getParameter(
						"changeengine").trim();
				jsonObject = JSONObject.fromObject(changeengineJosn);
				changeEngine = (ChangeEngine) JSONObject.toBean(jsonObject,
						ChangeEngine.class);
				changeEngine.setCarchangeid(carChange.getId());
				this.serviceManager.getChangeEngineService().addChangeEngine(
						changeEngine);
			} else if (changeType.equals("更换挂车".trim())) {
				String changetrailerJosn = (String) request.getParameter(
						"changetrailer").trim();
				jsonObject = JSONObject.fromObject(changetrailerJosn);
				changeTrailer = (ChangeTrailer) JSONObject.toBean(jsonObject,
						ChangeTrailer.class);
				changeTrailer.setCarchangeid(carChange.getId());
				this.serviceManager.getChangeTrailerService().addChangeTrailer(
						changeTrailer);
			} else {
				String changebodyJosn = (String) request.getParameter(
						"changebody").trim();
				jsonObject = JSONObject.fromObject(changebodyJosn);
				changeBody = (ChangeBody) JSONObject.toBean(jsonObject,
						ChangeBody.class);
				changeBody.setCarchangeid(carChange.getId());
				this.serviceManager.getChangeBodyService().addChangeBody(
						changeBody);
			}
			TractorInfo tractorInfo = this.serviceManager
					.getTractorInfoService().findTractorInfoById(tractorinfoId);
			tractorInfo.setStatus(7);
			this.serviceManager.getTractorInfoService().updateTractorInfo(
					tractorInfo);
			log.info("保存变更信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'保存转移信息失败，请重新尝试!'}");
		}
	}

	// 对变更信息 进行审核
	@SuppressWarnings("rawtypes")
	public void auditCarChange(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("Check CarCheck");
		User user = (User) request.getSession().getAttribute("user");
		String auditmodels = (String) request.getParameter("auditmodels")
				.trim();// 得到需要审核的变更信息
		int state = Integer.parseInt(request.getParameter("state").trim());// 得到需要审核的状态
		String approvacontext = (String) request.getParameter("approvacontext")
				.trim();// 得到需要审核的审核意见

		JSONArray jsonArray = JSONArray.fromObject(auditmodels);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		boolean isSuccess = true;
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			CarChangeView viewmodel = (CarChangeView) JSONObject.toBean(
					jsonObject, CarChangeView.class);
			CarChange carChangeModel = new CarChange();
			carChangeModel.setId(viewmodel.getId());
			carChangeModel.setTractorinfoId(viewmodel.getTractorinfoId());
			carChangeModel.setChangeType(viewmodel.getChangeType());
			carChangeModel.setApplicationmen(viewmodel.getApplicationmen());
			carChangeModel.setApplicationtime(viewmodel.getApplicationtime());
			carChangeModel.setApplicationip(viewmodel.getApplicationip());
			carChangeModel.setApprovalmen(user.getRealname());
			carChangeModel.setApprovaltime(new Date());
			carChangeModel.setApprovalstate(state);
			carChangeModel.setApprovalip(request.getRemoteAddr());
			carChangeModel.setApprovacontext(approvacontext);
			this.serviceManager.getCarChangeService().updateCarChange(
					carChangeModel);// 更新变更信息
			if (state == 2) {
				if (viewmodel.getChangeType().equals("共同所有的拖拉机变更拖拉机所有人")) {
					// 得到拖拉机所有人信息
					OwnerInfo ownerinfo = this.serviceManager
							.getOwnerInfoService().findOwnerInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					ownerinfo.setOwner(viewmodel.getUsername());
					ownerinfo.setTelephone(viewmodel.getLintel());
					ownerinfo.setRealcertificatetype(String.valueOf(viewmodel
							.getCertificateid()));
					ownerinfo.setRealcertificateno(viewmodel
							.getCertificatecode());
					ownerinfo.setIsUnion(Integer.parseInt(viewmodel
							.getUnittype()));
					ownerinfo.setTempaddress(viewmodel.getCurrentaddress());
					ownerinfo.setZipCode(viewmodel.getZipcode());
					ownerinfo.setIstemplived(Integer.parseInt(viewmodel
							.getIstemporary()));
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getTemporaycertificate())) {
						ownerinfo.setTemplivefiletype(Integer
								.parseInt(viewmodel.getTemporaycertificate()));
					} else {
						ownerinfo.setTemplivefiletype(0);
					}
					ownerinfo.setTimplivefileno(viewmodel
							.getTemporaycertificatecode());
					if (this.serviceManager.getOwnerInfoService()
							.updateOwnerInfo(ownerinfo)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
				} else if (viewmodel.getChangeType().equals("变更机身颜色")) {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					TractorBasicInfo tractorBasicInfo = this.serviceManager
							.getTractorBasicInfoService()
							.findTractorBasicInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					technicalParameters.setMachinebodycolor(viewmodel
							.getCuurentcolor());
					tractorBasicInfo.setPhotourl(viewmodel
							.getChangecolorphotourl());
					if (this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
					if (this.serviceManager.getTractorBasicInfoService()
							.updateTractorBasicInfo(tractorBasicInfo)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
				} else if (viewmodel.getChangeType().equals("更换发动机")) {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					TractorBasicInfo tractorBasicInfo = this.serviceManager
							.getTractorBasicInfoService()
							.findTractorBasicInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					tractorBasicInfo.setEngineno(viewmodel.getNewenginecode());
					if (StringUtil
							.isNotNullEmptyStr(viewmodel.getNewfueltype())) {
						technicalParameters.setFueltypeid(Integer
								.parseInt(viewmodel.getNewfueltype()));
					} else {
						technicalParameters.setFueltypeid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getNewenginebrand())) {
						technicalParameters.setEnginebrandid(Integer
								.parseInt(viewmodel.getNewenginebrand()));
					} else {
						technicalParameters.setEnginebrandid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getNewcylindernumber())) {
						technicalParameters.setCylinderno(Integer
								.parseInt(viewmodel.getNewcylindernumber()));
					} else {
						technicalParameters.setCylinderno(0);
					}

					technicalParameters.setPower(viewmodel.getNewpower());
					if (this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
					if (this.serviceManager.getTractorBasicInfoService()
							.updateTractorBasicInfo(tractorBasicInfo)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
				} else if (viewmodel.getChangeType().equals("更换挂车")) {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					technicalParameters.setVicecartiresno(Integer
							.parseInt(viewmodel.getCurrenttires()));
					technicalParameters.setOutcarwheeldis(viewmodel
							.getCurrenttrack());
					technicalParameters.setOutcartiressize(viewmodel
							.getCurrentnorm());
					if (this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
				} else {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					TractorBasicInfo tractorBasicInfo = this.serviceManager
							.getTractorBasicInfoService()
							.findTractorBasicInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					RelationInfo relationInfo = this.serviceManager
							.getRelationInfoService().findRelationInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					if (StringUtil.isNotNullEmptyStr(viewmodel.getGettypeid())) {
						tractorBasicInfo.setGetwayid(Integer.parseInt(viewmodel
								.getGettypeid()));
					} else {
						tractorBasicInfo.setGetwayid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getMachinetypeid())) {
						tractorBasicInfo.setMachinetypeid(Integer
								.parseInt(viewmodel.getMachinetypeid()));
					} else {
						tractorBasicInfo.setMachinetypeid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getEngineid())) {
						tractorBasicInfo.setMachinebrandtypeid(Integer
								.parseInt(viewmodel.getEngineid()));
					} else {
						tractorBasicInfo.setMachinebrandtypeid(0);
					}

					tractorBasicInfo.setMachinebodyno(viewmodel.getBodycode());
					tractorBasicInfo.setEngineno(viewmodel.getEnginecode());
					tractorBasicInfo.setShelfno(viewmodel.getRackcode());
					tractorBasicInfo.setUsedfor(viewmodel.getUsernature());
					tractorBasicInfo
							.setManufacturer(viewmodel.getFactoryname());
					tractorBasicInfo.setSeller(viewmodel.getSaleunit());
					tractorBasicInfo.setManufacturedate(viewmodel
							.getReleasedate());
					tractorBasicInfo.setPrice(viewmodel.getPrice());
					tractorBasicInfo.setPhotourl(viewmodel.getPhotourl());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getGetwayfiletypeid())) {
						relationInfo.setGetwayfiletypeid(Integer
								.parseInt(viewmodel.getGetwayfiletypeid()));
					} else {
						relationInfo.setGetwayfiletypeid(0);
					}

					relationInfo.setGetwayfileno(viewmodel
							.getGetwayfiletypecode());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getImportsfiletypeid())) {
						relationInfo.setImportsfiletypeid(Integer
								.parseInt(viewmodel.getImportsfiletypeid()));
					} else {
						relationInfo.setImportsfiletypeid(0);
					}

					relationInfo.setImportsfileno(viewmodel
							.getImportsfiletypecode());
					relationInfo.setOther(viewmodel.getOther());
					relationInfo.setInsurancelistno(viewmodel
							.getInsurancelistno());
					relationInfo.setInsurancecompanyname(viewmodel
							.getInsurancecompany());
					relationInfo.setInsurancedate(viewmodel.getInsurancedate());
					relationInfo
							.setExpirydate(viewmodel.getInsurancevalidate());
					technicalParameters.setMachinebodycolor(viewmodel
							.getBodycolor());
					technicalParameters.setOutsize(viewmodel.getSize());
					technicalParameters.setDirectcontrol(viewmodel
							.getDirectcontrol());
					technicalParameters.setContainersize(viewmodel
							.getContainersize());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getEnginebrandid())) {
						technicalParameters.setEnginebrandid(Integer
								.parseInt(viewmodel.getEnginebrandid()));
					} else {
						technicalParameters.setEnginebrandid(0);
					}

					technicalParameters.setPower(viewmodel.getPower());
					if (StringUtil.isNotNullEmptyStr(viewmodel.getCylinderno())) {
						technicalParameters.setCylinderno(Integer
								.parseInt(viewmodel.getCylinderno()));
					} else {
						technicalParameters.setCylinderno(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getFueltypeid())) {
						technicalParameters.setFueltypeid(Integer
								.parseInt(viewmodel.getFueltypeid()));
					} else {
						technicalParameters.setFueltypeid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getWheelno())) {
						technicalParameters.setWheelno(Integer
								.parseInt(viewmodel.getWheelno()));
					} else {
						technicalParameters.setWheelno(0);
					}
					technicalParameters.setWheelbase(viewmodel.getWheelbase());
					if (StringUtil.isNotNullEmptyStr(viewmodel.getTiresno())) {
						technicalParameters.setTiresno(Integer
								.parseInt(viewmodel.getTiresno()));
					} else {
						technicalParameters.setTiresno(0);
					}

					technicalParameters.setTiressize(viewmodel.getTiressize());
					technicalParameters.setWheeldis(viewmodel.getWheeldis());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getTotalquality())) {
						technicalParameters.setTotalquality(Integer
								.parseInt(viewmodel.getTotalquality()));
					} else {
						technicalParameters.setTotalquality(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getAllquality())) {
						technicalParameters.setAllquality(Integer
								.parseInt(viewmodel.getAllquality()));
					} else {
						technicalParameters.setAllquality(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getRatifiedload())) {
						technicalParameters.setRatifiedload(Integer
								.parseInt(viewmodel.getRatifiedload()));
					} else {
						technicalParameters.setRatifiedload(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getAllowdragtotalquality())) {
						technicalParameters
								.setAllowdragtotalquality(Integer
										.parseInt(viewmodel
												.getAllowdragtotalquality()));
					} else {
						technicalParameters.setAllowdragtotalquality(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getDriverinno())) {
						technicalParameters.setDriverinno(Integer
								.parseInt(viewmodel.getDriverinno()));
					} else {
						technicalParameters.setDriverinno(0);
					}
					if (StringUtil
							.isNotNullEmptyStr(viewmodel.getSteelspring())) {
						technicalParameters.setSteelspring(Integer
								.parseInt(viewmodel.getSteelspring()));
					} else {
						technicalParameters.setSteelspring(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getVicecartiresno())) {
						technicalParameters.setVicecartiresno(Integer
								.parseInt(viewmodel.getVicecartiresno()));
					} else {
						technicalParameters.setVicecartiresno(0);
					}

					technicalParameters.setOutcarwheeldis(viewmodel
							.getOutcarwheeldis());
					technicalParameters.setOutcartiressize(viewmodel
							.getOutcartiressize());
					if (this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
					if (this.serviceManager.getTractorBasicInfoService()
							.updateTractorBasicInfo(tractorBasicInfo)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
					if (this.serviceManager.getRelationInfoService()
							.updateRelationInfo(relationInfo)) {
						isSuccess = true;
					} else {
						isSuccess = false;
						break;
					}
				}
				// 更新车辆状态
				TractorInfo tractorinfoModel = this.serviceManager
						.getTractorInfoService().findTractorInfoById(
								viewmodel.getTractorinfoId());
				if (tractorinfoModel != null) {
					if (tractorinfoModel.getStatus() == 7) {
						tractorinfoModel.setStatus(2);
						this.serviceManager.getTractorInfoService()
								.updateTractorInfo(tractorinfoModel);
					}
				}

			} else if (state == 3) {
				if (viewmodel.getApprovalstate() == 2) {
					// 如果当前审核的是已经通过的数据,则更新拖拉机状态为变更业务中
					TractorInfo tractorinfoModel = this.serviceManager
							.getTractorInfoService().findTractorInfoById(
									viewmodel.getTractorinfoId());
					if (tractorinfoModel.getStatus() == 2) {
						tractorinfoModel.setStatus(7);
						this.serviceManager.getTractorInfoService()
								.updateTractorInfo(tractorinfoModel);
					}
				}
			}
		}
		if (isSuccess) {
			log.info("审核成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'审核失败，请重新尝试!'}");
		}

	}

	// 批量上报
	public void ReportedCarChange(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("ReportedCarChange");
		User user = (User) request.getSession().getAttribute("user");
		String reportcarchangeids = (String) request.getParameter(
				"reportcarchangeids").trim();
		if (!reportcarchangeids.equals("")) {
			serviceManager.getCarChangeService().updateCarChangeByIds(
					reportcarchangeids);
			// 上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService()
					.findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarChangeTime();
            }
			CarChangeOperation operation = new CarChangeOperation(
					audittime, user.getRealname(),
					request.getRemoteAddr(), reportcarchangeids);
			Thread thread = new Thread(operation, "CarChange");
			thread.start();
			response.getWriter().write("{success: true}");
		} else {
			log.info("Err on del TractorInfo");
			response.getWriter().write("{failure:true,reason:'上报失败'}");
		}
	}

	// 批量删除变更信息
	public void DeleteCarChange(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("add TractorInfo");
		String delcarchangeids = (String) request.getParameter(
				"mydelcarchangeids").trim();
		String delchangecolorids = (String) request.getParameter(
				"mydelchangecolorids").trim();
		String delchangeengineids = (String) request.getParameter(
				"mydelchangeengineids").trim();
		String delchangetrailerids = (String) request.getParameter(
				"mydelchangetrailerids").trim();
		String delchangeownerids = (String) request.getParameter(
				"mydelchangeownerids").trim();
		String delchangebodyids = (String) request.getParameter(
				"mydelchangebodyids").trim();
		String tractorids = (String) request.getParameter("tractorids").trim();
		if (!delcarchangeids.equals("")) {
			if (!delchangecolorids.equals("")) {
				delchangecolorids = delchangecolorids.substring(0,
						delchangecolorids.length() - 1);
				this.serviceManager.getChangeColorService()
						.delChangeColorByIds(delchangecolorids);// 批量删除变更颜色信息
			}
			if (!delchangeengineids.equals("")) {
				delchangeengineids = delchangeengineids.substring(0,
						delchangeengineids.length() - 1);
				this.serviceManager.getChangeEngineService()
						.delChangeEngineByIds(delchangeengineids);// 批量删除变更发动机信息
			}
			if (!delchangetrailerids.equals("")) {
				delchangetrailerids = delchangetrailerids.substring(0,
						delchangetrailerids.length() - 1);
				this.serviceManager.getChangeTrailerService()
						.delChangeTrailerByIds(delchangetrailerids);// 批量删除变更挂车信息
			}
			if (!delchangeownerids.equals("")) {
				delchangeownerids = delchangeownerids.substring(0,
						delchangeownerids.length() - 1);
				this.serviceManager.getChangeOwnerService()
						.delChangeOwnerByIds(delchangeownerids);// 批量删除变更所有人信息
			}
			if (!delchangebodyids.equals("")) {
				delchangebodyids = delchangebodyids.substring(0,
						delchangebodyids.length() - 1);
				this.serviceManager.getChangeBodyService().delChangeBodyByIds(
						delchangebodyids);// 批量删除变更整机信息
			}
			delcarchangeids = delcarchangeids.substring(0,
					delcarchangeids.length() - 1);
			if (this.serviceManager.getCarChangeService().delCarChangeByIds(
					delcarchangeids)) {
				if (!tractorids.equals("")) {
					tractorids = tractorids.substring(0,
							tractorids.length() - 1);
					this.serviceManager
							.getTractorInfoService()
							.updateTractorStateByIds(2, tractorids,
									TractorInfoSearch.GetBusinessOverCondtion());
				}
				response.getWriter().write("{success: true}");
			}
		} else {
			log.info("Err on del CarChange");
			response.getWriter().write("{success:false,reason:'删除信息失败'}");
		}
	}

	// 更新变更信息
	public void UpdateCarChange(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("add TractorInfo");
		JSONObject jsonObject;
		String changeType = (String) request.getParameter("type").trim();
		if (changeType.equals("共同所有的拖拉机变更拖拉机所有人".trim())) {
			String changeownerJosn = (String) request.getParameter(
					"updatechangeowner").trim();
			jsonObject = JSONObject.fromObject(changeownerJosn);
			ChangeOwner changeOwner = (ChangeOwner) JSONObject.toBean(
					jsonObject, ChangeOwner.class);
			if (this.serviceManager.getChangeOwnerService().updateChangeOwner(
					changeOwner)) {
				response.getWriter().write("{success: true}");
			} else {
				response.getWriter().write("{success: false}");
			}
		} else if (changeType.equals("变更机身颜色".trim())) {
			String changecolorJosn = (String) request.getParameter(
					"updatechangecolor").trim();
			jsonObject = JSONObject.fromObject(changecolorJosn);
			ChangeColor changeColor = (ChangeColor) JSONObject.toBean(
					jsonObject, ChangeColor.class);
			if (this.serviceManager.getChangeColorService().updateChangeColor(
					changeColor)) {
				response.getWriter().write("{success: true}");
			} else {
				response.getWriter().write("{success: false}");
			}

		} else if (changeType.equals("更换发动机".trim())) {
			String updatechangeengineJosn = (String) request.getParameter(
					"updatechangeengine").trim();
			jsonObject = JSONObject.fromObject(updatechangeengineJosn);
			ChangeEngine changeEngine = (ChangeEngine) JSONObject.toBean(
					jsonObject, ChangeEngine.class);
			if (this.serviceManager.getChangeEngineService()
					.updateChangeEngine(changeEngine)) {
				response.getWriter().write("{success: true}");
			} else {
				response.getWriter().write("{success: false}");
			}
		} else if (changeType.equals("更换挂车".trim())) {
			String changetrailerJosn = (String) request.getParameter(
					"updatechangetrailer").trim();
			jsonObject = JSONObject.fromObject(changetrailerJosn);
			ChangeTrailer changeTrailer = (ChangeTrailer) JSONObject.toBean(
					jsonObject, ChangeTrailer.class);
			if (this.serviceManager.getChangeTrailerService()
					.updateChangeTrailer(changeTrailer)) {
				response.getWriter().write("{success: true}");
			} else {
				response.getWriter().write("{success: false}");
			}
		} else {
			int updatechangebodyid = Integer.parseInt(request.getParameter(
					"updatechangebodyid").trim());
			String gettypeid = request.getParameter("gettypeid").trim();
			String machinetypeid = request.getParameter("machinetypeid").trim();
			String engineid = request.getParameter("engineid").trim();
			String bodycode = request.getParameter("bodycode").trim();
			String enginecode = request.getParameter("enginecode").trim();
			String rackcode = request.getParameter("rackcode").trim();
			String usernature = request.getParameter("usernature").trim();
			String factoryname = request.getParameter("factoryname").trim();
			String saleunit = request.getParameter("saleunit").trim();
			String releasedate = request.getParameter("releasedate").trim();
			String price = request.getParameter("price").trim();
			String photourl = request.getParameter("photourl").trim();
			String getwayfiletypeid = request.getParameter("getwayfiletypeid")
					.trim();
			String getwayfiletypecode = request.getParameter(
					"getwayfiletypecode").trim();
			String importsfiletypeid = request
					.getParameter("importsfiletypeid").trim();
			String importsfiletypecode = request.getParameter(
					"importsfiletypecode").trim();
			String other = request.getParameter("other").trim();
			String insurancelistno = request.getParameter("insurancelistno")
					.trim();
			String insurancecompany = request.getParameter("insurancecompany")
					.trim();
			String insurancedate = request.getParameter("insurancedate").trim();
			String insurancevalidate = request
					.getParameter("insurancevalidate").trim();
			String bodycolor = request.getParameter("bodycolor").trim();
			String size = request.getParameter("size").trim();
			String directcontrol = request.getParameter("directcontrol").trim();
			String containersize = request.getParameter("containersize").trim();
			String enginebrandid = request.getParameter("enginebrandid").trim();
			String power = request.getParameter("power").trim();
			String cylinderno = request.getParameter("cylinderno").trim();
			String fueltypeid = request.getParameter("fueltypeid").trim();
			String wheelno = request.getParameter("wheelno").trim();
			String wheelbase = request.getParameter("wheelbase").trim();
			String tiresno = request.getParameter("tiresno").trim();
			String tiressize = request.getParameter("tiressize").trim();
			String wheeldis = request.getParameter("wheeldis").trim();
			String totalquality = request.getParameter("totalquality").trim();
			String allquality = request.getParameter("allquality").trim();
			String ratifiedload = request.getParameter("ratifiedload").trim();
			String allowdragtotalquality = request.getParameter(
					"allowdragtotalquality").trim();
			String driverinno = request.getParameter("driverinno").trim();
			String steelspring = request.getParameter("steelspring").trim();
			String vicecartiresno = request.getParameter("vicecartiresno")
					.trim();
			String outcarwheeldis = request.getParameter("outcarwheeldis")
					.trim();
			String outcartiressize = request.getParameter("outcartiressize")
					.trim();
			ChangeBody changebody = this.serviceManager.getChangeBodyService()
					.findChangeBodyById(updatechangebodyid);
			if (changebody != null) {
				if (StringUtil.isNotNullEmptyStr(gettypeid)) {
					changebody.setGettypeid(Integer.parseInt(gettypeid));
				} else {
					changebody.setGettypeid(0);
				}
				if (StringUtil.isNotNullEmptyStr(machinetypeid)) {
					changebody
							.setMachinetypeid(Integer.parseInt(machinetypeid));
				} else {
					changebody.setMachinetypeid(0);
				}
				if (StringUtil.isNotNullEmptyStr(engineid)) {
					changebody.setEngineid(Integer.parseInt(engineid));
				} else {
					changebody.setEngineid(0);
				}
				changebody.setBodycode(bodycode);
				changebody.setEnginecode(enginecode);
				changebody.setRackcode(rackcode);
				changebody.setUsernature(usernature);
				changebody.setFactoryname(factoryname);
				changebody.setSaleunit(saleunit);
				if (StringUtil.isNotNullEmptyStr(releasedate)) {
					changebody
							.setReleasedate(new SimpleDateFormat("yyyy-MM-dd")
									.parse(releasedate.trim()));
				}
				changebody.setPrice(price);
				changebody.setPhotourl(photourl);
				if (StringUtil.isNotNullEmptyStr(getwayfiletypeid)) {
					changebody.setGetwayfiletypeid(Integer
							.parseInt(getwayfiletypeid));
				} else {
					changebody.setGetwayfiletypeid(0);
				}
				changebody.setGetwayfiletypecode(getwayfiletypecode);
				if (StringUtil.isNotNullEmptyStr(importsfiletypeid)) {
					changebody.setImportsfiletypeid(Integer
							.parseInt(importsfiletypeid));
				} else {
					changebody.setImportsfiletypeid(0);
				}
				changebody.setImportsfiletypecode(importsfiletypecode);
				changebody.setOther(other);
				changebody.setInsurancelistno(insurancelistno);
				changebody.setInsurancecompany(insurancecompany);
				if (StringUtil.isNotNullEmptyStr(insurancedate)) {
					changebody.setInsurancedate(new SimpleDateFormat(
							"yyyy-MM-dd").parse(insurancedate.trim()));
				}
				if (StringUtil.isNotNullEmptyStr(insurancevalidate)) {
					changebody.setInsurancevalidate(new SimpleDateFormat(
							"yyyy-MM-dd").parse(insurancevalidate.trim()));
				}
				changebody.setBodycolor(bodycolor);
				changebody.setSize(size);
				changebody.setDirectcontrol(directcontrol);
				changebody.setContainersize(containersize);
				if (StringUtil.isNotNullEmptyStr(enginebrandid)) {
					changebody
							.setEnginebrandid(Integer.parseInt(enginebrandid));
				} else {
					changebody.setEnginebrandid(0);
				}
				changebody.setPower(power);
				changebody.setCylinderno(cylinderno);
				if (StringUtil.isNotNullEmptyStr(fueltypeid)) {
					changebody.setFueltypeid(Integer.parseInt(fueltypeid));
				} else {
					changebody.setFueltypeid(0);
				}
				changebody.setWheelno(wheelno);
				changebody.setWheelbase(wheelbase);
				if (StringUtil.isNotNullEmptyStr(tiresno)) {
					changebody.setTiresno(Integer.parseInt(tiresno));
				} else {
					changebody.setTiresno(0);
				}
				changebody.setTiressize(tiressize);
				changebody.setWheeldis(wheeldis);
				changebody.setTotalquality(totalquality);
				changebody.setAllquality(allquality);
				changebody.setRatifiedload(ratifiedload);
				changebody.setAllowdragtotalquality(allowdragtotalquality);
				if (StringUtil.isNotNullEmptyStr(driverinno)) {
					changebody.setDriverinno(Integer.parseInt(driverinno));
				} else {
					changebody.setDriverinno(0);
				}
				changebody.setSteelspring(steelspring);
				if (StringUtil.isNotNullEmptyStr(vicecartiresno)) {
					changebody.setVicecartiresno(Integer
							.parseInt(vicecartiresno));
				} else {
					changebody.setVicecartiresno(0);
				}
				changebody.setOutcartiressize(outcartiressize);
				changebody.setOutcarwheeldis(outcarwheeldis);
				if (this.serviceManager.getChangeBodyService()
						.updateChangeBody(changebody)) {
					response.getWriter().write("{success: true}");
				} else {
					response.getWriter().write("{success: false}");
				}
			}

		}
	}

	private class CarChangeOperation implements Runnable {
		private int time;
		String realname;
		String remoteaddr;
		String auditcarchangeids;

		public CarChangeOperation(int time, String realname, String remoteaddr,
				String auditcarchangeids) {
			this.time = time;
			this.realname = realname;
			this.remoteaddr = remoteaddr;
			this.auditcarchangeids = auditcarchangeids;
		}

		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time, realname, remoteaddr,
					auditcarchangeids);
			eggTimer.start();
		}
	}

	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String remoteaddr;
		String auditcarchangeids;

		public EggTimer(int time, String realname, String remoteaddr,
				String auditcarchangeids) {
			this.time = time;
			this.realname = realname;
			this.remoteaddr = remoteaddr;
			this.auditcarchangeids = auditcarchangeids;
		}

		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}

				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditCarChange(realname, remoteaddr,
							auditcarchangeids);
				}
			}, time * 60 * 1000);// 使用毫秒计数
		}
	}

	public void ThreadAuditCarChange(String checkusername, String checkip,
			String auditcarchangeids) {
		List<CarChangeView> res = serviceManager.getCarChangeService()
				.getCarChangeViewListByIds(auditcarchangeids);
		for (CarChangeView viewmodel : res) {
			if (viewmodel.getApprovalstate() == 1) {
				CarChange carChangeModel = new CarChange();
				carChangeModel.setId(viewmodel.getId());
				carChangeModel.setTractorinfoId(viewmodel.getTractorinfoId());
				carChangeModel.setChangeType(viewmodel.getChangeType());
				carChangeModel.setApplicationmen(viewmodel.getApplicationmen());
				carChangeModel.setApplicationtime(viewmodel
						.getApplicationtime());
				carChangeModel.setApplicationip(viewmodel.getApplicationip());
				carChangeModel.setApprovalmen(checkusername);
				carChangeModel.setApprovaltime(new Date());
				carChangeModel.setApprovalstate(2);
				carChangeModel.setApprovalip(checkip);
				carChangeModel.setApprovacontext("审核通过");
				this.serviceManager.getCarChangeService().updateCarChange(
						carChangeModel);// 更新变更信息
				if (viewmodel.getChangeType().equals("共同所有的拖拉机变更拖拉机所有人")) {
					// 得到拖拉机所有人信息
					OwnerInfo ownerinfo = this.serviceManager
							.getOwnerInfoService().findOwnerInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					ownerinfo.setOwner(viewmodel.getUsername());
					ownerinfo.setTelephone(viewmodel.getLintel());
					ownerinfo.setRealcertificatetype(String.valueOf(viewmodel
							.getCertificateid()));
					ownerinfo.setRealcertificateno(viewmodel
							.getCertificatecode());
					ownerinfo.setIsUnion(Integer.parseInt(viewmodel
							.getUnittype()));
					ownerinfo.setTempaddress(viewmodel.getCurrentaddress());
					ownerinfo.setZipCode(viewmodel.getZipcode());
					ownerinfo.setIstemplived(Integer.parseInt(viewmodel
							.getIstemporary()));
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getTemporaycertificate())) {
						ownerinfo.setTemplivefiletype(Integer
								.parseInt(viewmodel.getTemporaycertificate()));
					} else {
						ownerinfo.setTemplivefiletype(0);
					}
					ownerinfo.setTimplivefileno(viewmodel
							.getTemporaycertificatecode());
					this.serviceManager.getOwnerInfoService().updateOwnerInfo(
							ownerinfo);
				} else if (viewmodel.getChangeType().equals("变更机身颜色")) {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					TractorBasicInfo tractorBasicInfo = this.serviceManager
							.getTractorBasicInfoService()
							.findTractorBasicInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					technicalParameters.setMachinebodycolor(viewmodel
							.getCuurentcolor());
					tractorBasicInfo.setPhotourl(viewmodel
							.getChangecolorphotourl());
					this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters);
					this.serviceManager.getTractorBasicInfoService()
							.updateTractorBasicInfo(tractorBasicInfo);
				} else if (viewmodel.getChangeType().equals("更换发动机")) {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					TractorBasicInfo tractorBasicInfo = this.serviceManager
							.getTractorBasicInfoService()
							.findTractorBasicInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					tractorBasicInfo.setEngineno(viewmodel.getNewenginecode());
					if (StringUtil
							.isNotNullEmptyStr(viewmodel.getNewfueltype())) {
						technicalParameters.setFueltypeid(Integer
								.parseInt(viewmodel.getNewfueltype()));
					} else {
						technicalParameters.setFueltypeid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getNewenginebrand())) {
						technicalParameters.setEnginebrandid(Integer
								.parseInt(viewmodel.getNewenginebrand()));
					} else {
						technicalParameters.setEnginebrandid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getNewcylindernumber())) {
						technicalParameters.setCylinderno(Integer
								.parseInt(viewmodel.getNewcylindernumber()));
					} else {
						technicalParameters.setCylinderno(0);
					}

					technicalParameters.setPower(viewmodel.getNewpower());
					this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters);
					this.serviceManager.getTractorBasicInfoService()
							.updateTractorBasicInfo(tractorBasicInfo);
				} else if (viewmodel.getChangeType().equals("更换挂车")) {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					technicalParameters.setVicecartiresno(Integer
							.parseInt(viewmodel.getCurrenttires()));
					technicalParameters.setOutcarwheeldis(viewmodel
							.getCurrenttrack());
					technicalParameters.setOutcartiressize(viewmodel
							.getCurrentnorm());
					this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters);
				} else {
					TechnicalParameters technicalParameters = this.serviceManager
							.getTechnicalParametersService()
							.findTechnicalParametersByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					TractorBasicInfo tractorBasicInfo = this.serviceManager
							.getTractorBasicInfoService()
							.findTractorBasicInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					RelationInfo relationInfo = this.serviceManager
							.getRelationInfoService().findRelationInfoByWhere(
									"tractorinfoId="
											+ viewmodel.getTractorinfoId());
					if (StringUtil.isNotNullEmptyStr(viewmodel.getGettypeid())) {
						tractorBasicInfo.setGetwayid(Integer.parseInt(viewmodel
								.getGettypeid()));
					} else {
						tractorBasicInfo.setGetwayid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getMachinetypeid())) {
						tractorBasicInfo.setMachinetypeid(Integer
								.parseInt(viewmodel.getMachinetypeid()));
					} else {
						tractorBasicInfo.setMachinetypeid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getEngineid())) {
						tractorBasicInfo.setMachinebrandtypeid(Integer
								.parseInt(viewmodel.getEngineid()));
					} else {
						tractorBasicInfo.setMachinebrandtypeid(0);
					}

					tractorBasicInfo.setMachinebodyno(viewmodel.getBodycode());
					tractorBasicInfo.setEngineno(viewmodel.getEnginecode());
					tractorBasicInfo.setShelfno(viewmodel.getRackcode());
					tractorBasicInfo.setUsedfor(viewmodel.getUsernature());
					tractorBasicInfo
							.setManufacturer(viewmodel.getFactoryname());
					tractorBasicInfo.setSeller(viewmodel.getSaleunit());
					tractorBasicInfo.setManufacturedate(viewmodel
							.getReleasedate());
					tractorBasicInfo.setPrice(viewmodel.getPrice());
					tractorBasicInfo.setPhotourl(viewmodel.getPhotourl());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getGetwayfiletypeid())) {
						relationInfo.setGetwayfiletypeid(Integer
								.parseInt(viewmodel.getGetwayfiletypeid()));
					} else {
						relationInfo.setGetwayfiletypeid(0);
					}

					relationInfo.setGetwayfileno(viewmodel
							.getGetwayfiletypecode());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getImportsfiletypeid())) {
						relationInfo.setImportsfiletypeid(Integer
								.parseInt(viewmodel.getImportsfiletypeid()));
					} else {
						relationInfo.setImportsfiletypeid(0);
					}

					relationInfo.setImportsfileno(viewmodel
							.getImportsfiletypecode());
					relationInfo.setOther(viewmodel.getOther());
					relationInfo.setInsurancelistno(viewmodel
							.getInsurancelistno());
					relationInfo.setInsurancecompanyname(viewmodel
							.getInsurancecompany());
					relationInfo.setInsurancedate(viewmodel.getInsurancedate());
					relationInfo
							.setExpirydate(viewmodel.getInsurancevalidate());
					technicalParameters.setMachinebodycolor(viewmodel
							.getBodycolor());
					technicalParameters.setOutsize(viewmodel.getSize());
					technicalParameters.setDirectcontrol(viewmodel
							.getDirectcontrol());
					technicalParameters.setContainersize(viewmodel
							.getContainersize());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getEnginebrandid())) {
						technicalParameters.setEnginebrandid(Integer
								.parseInt(viewmodel.getEnginebrandid()));
					} else {
						technicalParameters.setEnginebrandid(0);
					}

					technicalParameters.setPower(viewmodel.getPower());
					if (StringUtil.isNotNullEmptyStr(viewmodel.getCylinderno())) {
						technicalParameters.setCylinderno(Integer
								.parseInt(viewmodel.getCylinderno()));
					} else {
						technicalParameters.setCylinderno(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getFueltypeid())) {
						technicalParameters.setFueltypeid(Integer
								.parseInt(viewmodel.getFueltypeid()));
					} else {
						technicalParameters.setFueltypeid(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getWheelno())) {
						technicalParameters.setWheelno(Integer
								.parseInt(viewmodel.getWheelno()));
					} else {
						technicalParameters.setWheelno(0);
					}
					technicalParameters.setWheelbase(viewmodel.getWheelbase());
					if (StringUtil.isNotNullEmptyStr(viewmodel.getTiresno())) {
						technicalParameters.setTiresno(Integer
								.parseInt(viewmodel.getTiresno()));
					} else {
						technicalParameters.setTiresno(0);
					}

					technicalParameters.setTiressize(viewmodel.getTiressize());
					technicalParameters.setWheeldis(viewmodel.getWheeldis());
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getTotalquality())) {
						technicalParameters.setTotalquality(Integer
								.parseInt(viewmodel.getTotalquality()));
					} else {
						technicalParameters.setTotalquality(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getAllquality())) {
						technicalParameters.setAllquality(Integer
								.parseInt(viewmodel.getAllquality()));
					} else {
						technicalParameters.setAllquality(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getRatifiedload())) {
						technicalParameters.setRatifiedload(Integer
								.parseInt(viewmodel.getRatifiedload()));
					} else {
						technicalParameters.setRatifiedload(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getAllowdragtotalquality())) {
						technicalParameters
								.setAllowdragtotalquality(Integer
										.parseInt(viewmodel
												.getAllowdragtotalquality()));
					} else {
						technicalParameters.setAllowdragtotalquality(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel.getDriverinno())) {
						technicalParameters.setDriverinno(Integer
								.parseInt(viewmodel.getDriverinno()));
					} else {
						technicalParameters.setDriverinno(0);
					}
					if (StringUtil
							.isNotNullEmptyStr(viewmodel.getSteelspring())) {
						technicalParameters.setSteelspring(Integer
								.parseInt(viewmodel.getSteelspring()));
					} else {
						technicalParameters.setSteelspring(0);
					}
					if (StringUtil.isNotNullEmptyStr(viewmodel
							.getVicecartiresno())) {
						technicalParameters.setVicecartiresno(Integer
								.parseInt(viewmodel.getVicecartiresno()));
					} else {
						technicalParameters.setVicecartiresno(0);
					}

					technicalParameters.setOutcarwheeldis(viewmodel
							.getOutcarwheeldis());
					technicalParameters.setOutcartiressize(viewmodel
							.getOutcartiressize());
					this.serviceManager.getTechnicalParametersService()
							.updateTechnicalParameters(technicalParameters);
					this.serviceManager.getTractorBasicInfoService()
							.updateTractorBasicInfo(tractorBasicInfo);
					this.serviceManager.getRelationInfoService()
							.updateRelationInfo(relationInfo);
				}
				// 更新车辆状态
				TractorInfo tractorinfoModel = this.serviceManager
						.getTractorInfoService().findTractorInfoById(
								viewmodel.getTractorinfoId());
				if (tractorinfoModel != null) {
					if (tractorinfoModel.getStatus() == 7) {
						tractorinfoModel.setStatus(2);
						this.serviceManager.getTractorInfoService()
								.updateTractorInfo(tractorinfoModel);
					}
				}
			}
		}

	}

	@SuppressWarnings("unused")
	public void getFilingList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getFilingList");
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
		String condition = "1=1";
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String filingType=request.getParameter("filingType").trim();//得到业务类型
		String filling=request.getParameter("filling");//得到查询的归档数据状态
		String license=request.getParameter("license");//号牌号码
		UnitManage unit  = (UnitManage)request.getSession().getAttribute("userUnit");
		if(filling!=null && !filling.equals("")){
			condition+=" and filing="+filling;
		}
		if(license!=null && !license.equals("")){
			condition+=" and instr(license,'"+license.trim()+"')";
		}
		JSONArray jsonItems = new JSONArray();		
		if("注册登记".equals(filingType)){
			List<TractorInfoView> res = null;
//			if (fields != null && query != null && !"".equals(query)) {
//				condition =+"" new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
//			}
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res=serviceManager.getTractorInfoViewService().getFilingListQuery(page,condition,unit.getRegionid());
			}else{
				res=serviceManager.getTractorInfoViewService().getFilingList(page,condition,unit.getRegionid());
			}
			for (TractorInfoView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		if("转移登记".equals(filingType)){
			List<CarTransferView> res = null;
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getCarTransferService().getFilingListQuery(page, condition, unit.getRegionid());
			}else{
				res = serviceManager.getCarTransferService().getFilingList(page, condition, unit.getRegionid());
			}
			for (CarTransferView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		if("车辆年检".equals(filingType)){
			List<CarCheckView> res = null;
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getCarCheckService().getFilingListQuery(page,condition,unit.getRegionid());
			}else{
				res = serviceManager.getCarCheckService().getFilingList(page,condition,unit.getRegionid());
			}
			for (CarCheckView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		if("补领、补换牌证".equals(filingType)){
			List<TractorReplacementInfoView> res = null;
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getTractorReplacementInfoService().getFilingListQuery(page,condition,unit.getRegionid());
			}else{
				res = serviceManager.getTractorReplacementInfoService().getFilingList(page,condition,unit.getRegionid());
			}
			for (TractorReplacementInfoView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		if("变更备案登记".equals(filingType)){
			List<ChangeRecordView> res = null;
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getChangeRecordService().getFilingListQuery(page,condition,unit.getRegionid());
			}else{
				res = serviceManager.getChangeRecordService().getFilingList(page,condition,unit.getRegionid());
			}
			for (ChangeRecordView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}		
		if("抵押登记".equals(filingType)){
			List<MortgageView> res = null;
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getMortgageService().getFilingListQuery(page,condition,unit.getRegionid());
			}else{
				res = serviceManager.getMortgageService().getFilingList(page,condition,unit.getRegionid());
			}
			for (MortgageView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		if("注销登记".equals(filingType)){
			List<LogoutView> res = null;
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getLoyoutService().getFilingListQuery(page,condition,unit.getRegionid());
			}else{
				res = serviceManager.getLoyoutService().getFilingList(page,condition,unit.getRegionid());
			}
			for (LogoutView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
		}
		if("共同所有的拖拉机变更拖拉机所有人".equals(filingType)||"变更机身颜色".equals(filingType)||"更换发动机".equals(filingType)||"更换挂车".equals(filingType)||"更换机身(底盘)".equals(filingType)||"更换整机".equals(filingType)){
			List<CarChangeView> res = null;
			if("共同所有的拖拉机变更拖拉机所有人".equals(filingType)){
				condition+=" and changeType='共同所有的拖拉机变更拖拉机所有人'";
			}else if("变更机身颜色".equals(filingType)){
				condition+=" and changeType='变更机身颜色'";
			}else if("更换发动机".equals(filingType)){
				condition+=" and changeType='更换发动机'";
			}else if("更换挂车".equals(filingType)){
				condition+=" and changeType='更换挂车'";
			}else if("更换机身(底盘)".equals(filingType)){
				condition+=" and changeType='更换机身(底盘'";
			}else if("更换整机".equals(filingType)){
				condition+=" and changeType='更换整机'";
			}
			if (condition != null && !condition.equals("") && !condition.equals("1=1")) {
				res = serviceManager.getCarChangeService().getFilingListQuery(page,filingType,condition,unit.getRegionid());
			}else{
				res = serviceManager.getCarChangeService().getFilingList(page,filingType,condition,unit.getRegionid());
			}
			for (CarChangeView u : res) {
				jsonItems.add(JSONObject.fromObject(u));
			}
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
	//打印业务流程
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void carChangeInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getCarChangeService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_carChangeFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
	//拖拉机变更登记申请表
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void PrintCarChangeReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();//拖拉机ID
		String wordType=request.getParameter("wordType");
		List<TractorAlterApplicationSource> list=this.serviceManager.getCarChangeService().PrintCarChangeReport(Integer.parseInt(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_CarChangeReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorAlterApplication.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));
	}
}
