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
import Ynzc.YnzcAms.Model.CarCheck;
import Ynzc.YnzcAms.Model.CarCheckView;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.RelationInfo;
import Ynzc.YnzcAms.Model.SetTime;
import Ynzc.YnzcAms.Model.TechnicalInspect;
import Ynzc.YnzcAms.Model.TractorInfo;
import Ynzc.YnzcAms.Model.TractorRegistrationRecordProcessSource;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

public class CarCheckController extends BaseController {
	private final static Logger log = Logger
			.getLogger(CarCheckController.class);

	// 查询分页数据
	@SuppressWarnings("unused")
	public void getAllCarCheckListByPage(HttpServletRequest request,
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
		String checktype = request.getParameter("checktype");
		String registeryear=request.getParameter("registeryear");
		User user = (User) request.getSession().getAttribute("user");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String condition = "";// 设置查询条件为空
		condition = TractorInfoSearch.getBusinessCondition(state, codenum,
				owner, machinetype, plantType, checkexpriydate, regcerno, cardid,
				engineno, checktype, "carcheck");
		if(registeryear!=null && !registeryear.equals("")){
			condition+=" and  YEAR(registerdate)='"+registeryear+"'";
		}
			
		List<CarCheckView> res = this.serviceManager.getCarCheckService()
				.getCarCheckViewList(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (CarCheckView u : res) {
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

	// 添加车辆年检信息
	public void addCarCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int tractorinfoId = Integer.parseInt(request.getParameter("tractorinfoId").trim());
		int orgintractorstate=Integer.parseInt(request.getParameter("orgintractorstate").trim());
		String orgincheckresult = request.getParameter("orgincheckresult");
		String orgindisqualification = request.getParameter("orgindisqualification");
		Date orgincheckexpirydate =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("orgincheckexpirydate").trim()); 
		String orgininspector = request.getParameter("orgininspector");
		String orgincheckdate = request.getParameter("orgincheckdate");
		String orginshowinitialinspectionresult = request.getParameter("orginshowinitialinspectionresult");
		String orginshowdisqualification = request.getParameter("orginshowdisqualification");
		String orginshowexaminationresult = request.getParameter("orginshowexaminationresult");
		String orginengineinitialinspectionresult = request.getParameter("orginengineinitialinspectionresult");
		String orginenginedisqualification = request.getParameter("orginenginedisqualification");
		String orginengineexaminationresult = request.getParameter("orginengineexaminationresult");
		String orginconveyorinitialinspectionresult = request.getParameter("orginconveyorinitialinspectionresult");
		String orginconveyordisqualification = request.getParameter("orginconveyordisqualification");
		String orginconveyorexaminationresult = request.getParameter("orginconveyorexaminationresult");
		String orginsteeringinitialinspectionresult = request.getParameter("orginsteeringinitialinspectionresult");
		String orginsteeringdisqualification = request.getParameter("orginsteeringdisqualification");
		String orginsteeringexaminationresult = request.getParameter("orginsteeringexaminationresult");
		String orginflyhostinitialinspectionresult = request.getParameter("orginflyhostinitialinspectionresult");
		String orginflyhostdisqualification = request.getParameter("orginflyhostdisqualification");
		String orginflyhostexaminationresult = request.getParameter("orginflyhostexaminationresult");
		String orginflytrailerinitialinspectionresult = request.getParameter("orginflytrailerinitialinspectionresult");
		String orginflytrailerdisqualification = request.getParameter("orginflytrailerdisqualification");
		String orginflytrailerexaminationresult = request.getParameter("orginflytrailerexaminationresult");
		String orginbrakhostinitialinspectionresult = request.getParameter("orginbrakhostinitialinspectionresult");
		String orginbrakhostdisqualification = request.getParameter("orginbrakhostdisqualification");
		String orginbrakhostexaminationresult = request.getParameter("orginbrakhostexaminationresult");
		String orginbraktrailerinitialinspectionresult = request.getParameter("orginbraktrailerinitialinspectionresult");
		String orginbraktrailerdisqualification = request.getParameter("orginbraktrailerdisqualification");
		String orginbraktrailerexaminationresult = request.getParameter("orginbraktrailerexaminationresult");
		String orginlighthostinitialinspectionresult = request.getParameter("orginlighthostinitialinspectionresult");
		String orginlighthostdisqualification = request.getParameter("orginlighthostdisqualification");
		String orginlighthostexaminationresult = request.getParameter("orginlighthostexaminationresult");
		String orginlighttrailerinitialinspectionresult = request.getParameter("orginlighttrailerinitialinspectionresult");
		String orginlighttrailerdisqualification = request.getParameter("orginlighttrailerdisqualification");
		String orginlighttrailerexaminationresult = request.getParameter("orginlighttrailerexaminationresult");
		String orgintractioninitialinspectionresult = request.getParameter("orgintractioninitialinspectionresult");
		String orgintractiondisqualification = request.getParameter("orgintractiondisqualification");
		String orgintractionexaminationresult = request.getParameter("orgintractionexaminationresult");
		String orgininsurancelistno = request.getParameter("orgininsurancelistno");
		String orgininsurancedate = request.getParameter("orgininsurancedate");
		String orgininsurancecompanyname = request.getParameter("orgininsurancecompanyname");
		String orginexpirydate = request.getParameter("orginexpirydate");

		String inspectorresult = request.getParameter("inspectorresult").trim();
		Date checkexpirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkexpirydate").trim());
		String inspector = (String) request.getParameter("inspector").trim();
		Date inspectordate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("inspectordate").trim());
		String checkcompanyname = (String) request.getParameter("checkcompanyname").trim();

		String currentdisqualification = request.getParameter("currentdisqualification");
		String currentshowinitialinspectionresult = request.getParameter("currentshowinitialinspectionresult");
		String currentshowdisqualification = request.getParameter("currentshowdisqualification");
		String currentshowexaminationresult = request.getParameter("currentshowexaminationresult");
		String currentengineinitialinspectionresult = request.getParameter("currentengineinitialinspectionresult");
		String currentenginedisqualification = request.getParameter("currentenginedisqualification");
		String currentengineexaminationresult = request.getParameter("currentengineexaminationresult");
		String currentconveyorinitialinspectionresult = request.getParameter("currentconveyorinitialinspectionresult");
		String currentconveyordisqualification = request.getParameter("currentconveyordisqualification");

		String currentconveyorexaminationresult = request.getParameter("currentconveyorexaminationresult");
		String currentsteeringinitialinspectionresult = request.getParameter("currentsteeringinitialinspectionresult");
		String currentsteeringdisqualification = request.getParameter("currentsteeringdisqualification");
		String currentsteeringexaminationresult = request.getParameter("currentsteeringexaminationresult");
		String currentflyhostinitialinspectionresult = request.getParameter("currentflyhostinitialinspectionresult");
		String currentflyhostdisqualification = request.getParameter("currentflyhostdisqualification");
		String currentflyhostexaminationresult = request.getParameter("currentflyhostexaminationresult");
		String currentflytrailerinitialinspectionresult = request.getParameter("currentflytrailerinitialinspectionresult");
		String currentflytrailerdisqualification = request.getParameter("currentflytrailerdisqualification");
		String currentflytrailerexaminationresult = request.getParameter("currentflytrailerexaminationresult");
		String currentbrakhostinitialinspectionresult = request.getParameter("currentbrakhostinitialinspectionresult");
		String currentbrakhostdisqualification = request.getParameter("currentbrakhostdisqualification");
		String currentbrakhostexaminationresult = request.getParameter("currentbrakhostexaminationresult");
		String currentbraktrailerinitialinspectionresult = request.getParameter("currentbraktrailerinitialinspectionresult");
		String currentbraktrailerdisqualification = request.getParameter("currentbraktrailerdisqualification");
		String currentbraktrailerexaminationresult = request.getParameter("currentbraktrailerexaminationresult");
		String currentlighthostinitialinspectionresult = request.getParameter("currentlighthostinitialinspectionresult");
		String currentlighthostdisqualification = request.getParameter("currentlighthostdisqualification");
		String currentlighthostexaminationresult = request.getParameter("currentlighthostexaminationresult");
		String currentlighttrailerinitialinspectionresult = request.getParameter("currentlighttrailerinitialinspectionresult");
		String currentlighttrailerdisqualification = request.getParameter("currentlighttrailerdisqualification");
		String currentlighttrailerexaminationresult = request.getParameter("currentlighttrailerexaminationresult");
		String currenttractioninitialinspectionresult = request.getParameter("currenttractioninitialinspectionresult");
		String currenttractiondisqualification = request.getParameter("currenttractiondisqualification");
		String currenttractionexaminationresult = request.getParameter("currenttractionexaminationresult");

		String insurancelistno = (String) request.getParameter("insurancelistno").trim();
		Date insurancedate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insurancedate").trim());
		String insurancecompanyname = (String) request.getParameter("insurancecompanyname").trim();
		Date expirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expirydate").trim());
		String reviewer = (String) request.getParameter("reviewer").trim();
		Date reviewerconductdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("reviewerconductdate").trim());
		String issueadmin = (String) request.getParameter("issueadmin").trim();
		Date issueadmindate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueadmindate").trim());
		String leaderreview = (String) request.getParameter("leaderreview").trim();
		Date leaderreviewdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("leaderreviewdate").trim());
		log.info("Add new CarCheck:[tractorinfoId:" + tractorinfoId + "]");
		TractorInfo tractorInfo = this.serviceManager.getTractorInfoService().findTractorInfoById(tractorinfoId);
		
		CarCheck carcheck = new CarCheck();
		carcheck.setTractorinfoId(tractorinfoId);
		carcheck.setOrgintractorstate(orgintractorstate);
		carcheck.setOrgincheckresult(orgincheckresult);
		carcheck.setOrgindisqualification(orgindisqualification);
		carcheck.setOrgincheckexpirydate(orgincheckexpirydate);
		carcheck.setOrgininspector(orgininspector);
		carcheck.setOrgincheckdate(new SimpleDateFormat("yyyy-MM-dd").parse(orgincheckdate));
		carcheck.setOrginshowinitialinspectionresult(orginshowinitialinspectionresult);
		carcheck.setOrginshowdisqualification(orginshowdisqualification);
		carcheck.setOrginshowexaminationresult(orginshowexaminationresult);
		carcheck.setOrginengineinitialinspectionresult(orginengineinitialinspectionresult);
		carcheck.setOrginenginedisqualification(orginenginedisqualification);
		carcheck.setOrginengineexaminationresult(orginengineexaminationresult);
		carcheck.setOrginconveyorinitialinspectionresult(orginconveyorinitialinspectionresult);
		carcheck.setOrginconveyordisqualification(orginconveyordisqualification);
		carcheck.setOrginconveyorexaminationresult(orginconveyorexaminationresult);
		carcheck.setOrginsteeringinitialinspectionresult(orginsteeringinitialinspectionresult);
		carcheck.setOrginsteeringdisqualification(orginsteeringdisqualification);
		carcheck.setOrginsteeringexaminationresult(orginsteeringexaminationresult);
		carcheck.setOrginflyhostinitialinspectionresult(orginflyhostinitialinspectionresult);
		carcheck.setOrginflyhostdisqualification(orginflyhostdisqualification);
		carcheck.setOrginflyhostexaminationresult(orginflyhostexaminationresult);
		carcheck.setOrginflytrailerinitialinspectionresult(orginflytrailerinitialinspectionresult);
		carcheck.setOrginflytrailerdisqualification(orginflytrailerdisqualification);
		carcheck.setOrginflytrailerexaminationresult(orginflytrailerexaminationresult);
		carcheck.setOrginbrakhostinitialinspectionresult(orginbrakhostinitialinspectionresult);
		carcheck.setOrginbrakhostdisqualification(orginbrakhostdisqualification);
		carcheck.setOrginbrakhostexaminationresult(orginbrakhostexaminationresult);
		carcheck.setOrginbraktrailerinitialinspectionresult(orginbraktrailerinitialinspectionresult);
		carcheck.setOrginbraktrailerdisqualification(orginbraktrailerdisqualification);
		carcheck.setOrginbraktrailerexaminationresult(orginbraktrailerexaminationresult);
		carcheck.setOrginlighthostinitialinspectionresult(orginlighthostinitialinspectionresult);
		carcheck.setOrginlighthostdisqualification(orginlighthostdisqualification);
		carcheck.setOrginlighthostexaminationresult(orginlighthostexaminationresult);
		carcheck.setOrginlighttrailerinitialinspectionresult(orginlighttrailerinitialinspectionresult);
		carcheck.setOrginlighttrailerdisqualification(orginlighttrailerdisqualification);
		carcheck.setOrginlighttrailerexaminationresult(orginlighttrailerexaminationresult);
		carcheck.setOrgintractioninitialinspectionresult(orgintractioninitialinspectionresult);
		carcheck.setOrgintractiondisqualification(orgintractiondisqualification);
		carcheck.setOrgintractionexaminationresult(orgintractionexaminationresult);
		carcheck.setOrgininsurancelistno(orgininsurancelistno);
		carcheck.setOrgininsurancedate(new SimpleDateFormat("yyyy-MM-dd").parse(orgininsurancedate));
		carcheck.setOrgininsurancecompanyname(orgininsurancecompanyname);
		carcheck.setOrginexpirydate(orginexpirydate);
						
		carcheck.setInspectorresult(inspectorresult);
		carcheck.setCheckexpirydate(checkexpirydate);
		carcheck.setInspector(inspector);
		carcheck.setInspectordate(inspectordate);
		carcheck.setCheckcompanyname(checkcompanyname);
		carcheck.setCurrentdisqualification(currentdisqualification);
		carcheck.setCurrentshowinitialinspectionresult(currentshowinitialinspectionresult);
		carcheck.setCurrentshowdisqualification(currentshowdisqualification);
		carcheck.setCurrentshowexaminationresult(currentshowexaminationresult);
		carcheck.setCurrentengineinitialinspectionresult(currentengineinitialinspectionresult);
		carcheck.setCurrentenginedisqualification(currentenginedisqualification);
		carcheck.setCurrentengineexaminationresult(currentengineexaminationresult);
		carcheck.setCurrentconveyorinitialinspectionresult(currentconveyorinitialinspectionresult);
		carcheck.setCurrentconveyordisqualification(currentconveyordisqualification);
		carcheck.setCurrentconveyorexaminationresult(currentconveyorexaminationresult);
		carcheck.setCurrentsteeringinitialinspectionresult(currentsteeringinitialinspectionresult);
		carcheck.setCurrentsteeringdisqualification(currentsteeringdisqualification);
		carcheck.setCurrentsteeringexaminationresult(currentsteeringexaminationresult);
		carcheck.setCurrentflyhostinitialinspectionresult(currentflyhostinitialinspectionresult);
		carcheck.setCurrentflyhostdisqualification(currentflyhostdisqualification);
		carcheck.setCurrentflyhostexaminationresult(currentflyhostexaminationresult);
		carcheck.setCurrentflytrailerinitialinspectionresult(currentflytrailerinitialinspectionresult);
		carcheck.setCurrentflytrailerdisqualification(currentflytrailerdisqualification);
		carcheck.setCurrentflytrailerexaminationresult(currentflytrailerexaminationresult);
		carcheck.setCurrentbrakhostinitialinspectionresult(currentbrakhostinitialinspectionresult);
		carcheck.setCurrentbrakhostdisqualification(currentbrakhostdisqualification);
		carcheck.setCurrentbrakhostexaminationresult(currentbrakhostexaminationresult);
		carcheck.setCurrentbraktrailerinitialinspectionresult(currentbraktrailerinitialinspectionresult);
		carcheck.setCurrentbraktrailerdisqualification(currentbraktrailerdisqualification);
		carcheck.setCurrentbraktrailerexaminationresult(currentbraktrailerexaminationresult);
		carcheck.setCurrentlighthostinitialinspectionresult(currentlighthostinitialinspectionresult);
		carcheck.setCurrentlighthostdisqualification(currentlighthostdisqualification);
		carcheck.setCurrentlighthostexaminationresult(currentlighthostexaminationresult);
		carcheck.setCurrentlighttrailerinitialinspectionresult(currentlighttrailerinitialinspectionresult);
		carcheck.setCurrentlighttrailerdisqualification(currentlighttrailerdisqualification);
		carcheck.setCurrentlighttrailerexaminationresult(currentlighttrailerexaminationresult);
		carcheck.setCurrenttractioninitialinspectionresult(currenttractioninitialinspectionresult);
		carcheck.setCurrenttractiondisqualification(currenttractiondisqualification);
		carcheck.setCurrenttractionexaminationresult(currenttractionexaminationresult);
				
		carcheck.setInsurancelistno(insurancelistno);
		carcheck.setInsurancedate(insurancedate);
		carcheck.setInsurancecompanyname(insurancecompanyname);
		carcheck.setExpirydate(expirydate);
		carcheck.setReviewer(reviewer);
		carcheck.setReviewerconductdate(reviewerconductdate);
		carcheck.setIssueadmin(issueadmin);
		carcheck.setIssueadmindate(issueadmindate);
		carcheck.setLeaderreview(leaderreview);
		carcheck.setLeaderreviewdate(leaderreviewdate);
		User user = (User) request.getSession().getAttribute("user");
		carcheck.setOperateuser(user.getRealname());
		carcheck.setOperatedate(new Date());
		carcheck.setCheckresult(0);
		//得到当前日期
		Date today=new Date();
		long diffday=(orgincheckexpirydate.getTime()-today.getTime())/(3600*24*1000);
		if(diffday>=0){
			carcheck.setChecktype(0);// 表示本此年检的数据为合法数据,视为正常年检
		}
		else{
			long day=(today.getTime()-orgincheckexpirydate.getTime())/(3600*24*1000);
			if(day<=365){
				carcheck.setChecktype(1);// 表示本次年检时间 超过有效期一年以内包括一年，视为逾期年检
			}else{
				carcheck.setChecktype(2);//表示本次年检时间 超过有效期一年以上，视为补检
			}
		}
		if (serviceManager.getCarCheckService().addCarCheck(carcheck)) {
			tractorInfo.setStatus(6);
			this.serviceManager.getTractorInfoService().updateTractorInfo(
					tractorInfo);
			log.info("保存年检信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'保存转移信息失败，请重新尝试!'}");
		}
	}

	// 修改车辆年检信息
	public void updateCarCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id").trim());
		int tractorinfoId = Integer.parseInt(request.getParameter("tractorinfoId").trim());
		int orgintractorstate=Integer.parseInt(request.getParameter("orgintractorstate").trim());
		String orgincheckresult = request.getParameter("orgincheckresult");
		String orgindisqualification = request.getParameter("orgindisqualification");
		Date orgincheckexpirydate =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("orgincheckexpirydate").trim()); 
		String orgininspector = request.getParameter("orgininspector");
		String orgincheckdate = request.getParameter("orgincheckdate");
		String orginshowinitialinspectionresult = request.getParameter("orginshowinitialinspectionresult");
		String orginshowdisqualification = request.getParameter("orginshowdisqualification");
		String orginshowexaminationresult = request.getParameter("orginshowexaminationresult");
		String orginengineinitialinspectionresult = request.getParameter("orginengineinitialinspectionresult");
		String orginenginedisqualification = request.getParameter("orginenginedisqualification");
		String orginengineexaminationresult = request.getParameter("orginengineexaminationresult");
		String orginconveyorinitialinspectionresult = request.getParameter("orginconveyorinitialinspectionresult");
		String orginconveyordisqualification = request.getParameter("orginconveyordisqualification");
		String orginconveyorexaminationresult = request.getParameter("orginconveyorexaminationresult");
		String orginsteeringinitialinspectionresult = request.getParameter("orginsteeringinitialinspectionresult");
		String orginsteeringdisqualification = request.getParameter("orginsteeringdisqualification");
		String orginsteeringexaminationresult = request.getParameter("orginsteeringexaminationresult");
		String orginflyhostinitialinspectionresult = request.getParameter("orginflyhostinitialinspectionresult");
		String orginflyhostdisqualification = request.getParameter("orginflyhostdisqualification");
		String orginflyhostexaminationresult = request.getParameter("orginflyhostexaminationresult");
		String orginflytrailerinitialinspectionresult = request.getParameter("orginflytrailerinitialinspectionresult");
		String orginflytrailerdisqualification = request.getParameter("orginflytrailerdisqualification");
		String orginflytrailerexaminationresult = request.getParameter("orginflytrailerexaminationresult");
		String orginbrakhostinitialinspectionresult = request.getParameter("orginbrakhostinitialinspectionresult");
		String orginbrakhostdisqualification = request.getParameter("orginbrakhostdisqualification");
		String orginbrakhostexaminationresult = request.getParameter("orginbrakhostexaminationresult");
		String orginbraktrailerinitialinspectionresult = request.getParameter("orginbraktrailerinitialinspectionresult");
		String orginbraktrailerdisqualification = request.getParameter("orginbraktrailerdisqualification");
		String orginbraktrailerexaminationresult = request.getParameter("orginbraktrailerexaminationresult");
		String orginlighthostinitialinspectionresult = request.getParameter("orginlighthostinitialinspectionresult");
		String orginlighthostdisqualification = request.getParameter("orginlighthostdisqualification");
		String orginlighthostexaminationresult = request.getParameter("orginlighthostexaminationresult");
		String orginlighttrailerinitialinspectionresult = request.getParameter("orginlighttrailerinitialinspectionresult");
		String orginlighttrailerdisqualification = request.getParameter("orginlighttrailerdisqualification");
		String orginlighttrailerexaminationresult = request.getParameter("orginlighttrailerexaminationresult");
		String orgintractioninitialinspectionresult = request.getParameter("orgintractioninitialinspectionresult");
		String orgintractiondisqualification = request.getParameter("orgintractiondisqualification");
		String orgintractionexaminationresult = request.getParameter("orgintractionexaminationresult");
		String orgininsurancelistno = request.getParameter("orgininsurancelistno");
		String orgininsurancedate = request.getParameter("orgininsurancedate");
		String orgininsurancecompanyname = request.getParameter("orgininsurancecompanyname");
		String orginexpirydate = request.getParameter("orginexpirydate");
		
		String inspectorresult = request.getParameter("inspectorresult").trim();
		Date checkexpirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkexpirydate").trim());
		String inspector = (String) request.getParameter("inspector").trim();
		Date inspectordate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("inspectordate").trim());
		String checkcompanyname = (String) request.getParameter("checkcompanyname").trim();
		
		String currentdisqualification = request.getParameter("currentdisqualification");
		String currentshowinitialinspectionresult = request.getParameter("currentshowinitialinspectionresult");
		String currentshowdisqualification = request.getParameter("currentshowdisqualification");
		String currentshowexaminationresult = request.getParameter("currentshowexaminationresult");
		String currentengineinitialinspectionresult = request.getParameter("currentengineinitialinspectionresult");
		String currentenginedisqualification = request.getParameter("currentenginedisqualification");
		String currentengineexaminationresult = request.getParameter("currentengineexaminationresult");
		String currentconveyorinitialinspectionresult = request.getParameter("currentconveyorinitialinspectionresult");
		String currentconveyordisqualification = request.getParameter("currentconveyordisqualification");
		String currentconveyorexaminationresult = request.getParameter("currentconveyorexaminationresult");
		String currentsteeringinitialinspectionresult = request.getParameter("currentsteeringinitialinspectionresult");
		String currentsteeringdisqualification = request.getParameter("currentsteeringdisqualification");
		String currentsteeringexaminationresult = request.getParameter("currentsteeringexaminationresult");
		String currentflyhostinitialinspectionresult = request.getParameter("currentflyhostinitialinspectionresult");
		String currentflyhostdisqualification = request.getParameter("currentflyhostdisqualification");
		String currentflyhostexaminationresult = request.getParameter("currentflyhostexaminationresult");
		String currentflytrailerinitialinspectionresult = request.getParameter("currentflytrailerinitialinspectionresult");
		String currentflytrailerdisqualification = request.getParameter("currentflytrailerdisqualification");
		String currentflytrailerexaminationresult = request.getParameter("currentflytrailerexaminationresult");
		String currentbrakhostinitialinspectionresult = request.getParameter("currentbrakhostinitialinspectionresult");
		String currentbrakhostdisqualification = request.getParameter("currentbrakhostdisqualification");
		String currentbrakhostexaminationresult = request.getParameter("currentbrakhostexaminationresult");
		String currentbraktrailerinitialinspectionresult = request.getParameter("currentbraktrailerinitialinspectionresult");
		String currentbraktrailerdisqualification = request.getParameter("currentbraktrailerdisqualification");
		String currentbraktrailerexaminationresult = request.getParameter("currentbraktrailerexaminationresult");
		String currentlighthostinitialinspectionresult = request.getParameter("currentlighthostinitialinspectionresult");
		String currentlighthostdisqualification = request.getParameter("currentlighthostdisqualification");
		String currentlighthostexaminationresult = request.getParameter("currentlighthostexaminationresult");
		String currentlighttrailerinitialinspectionresult = request.getParameter("currentlighttrailerinitialinspectionresult");
		String currentlighttrailerdisqualification = request.getParameter("currentlighttrailerdisqualification");
		String currentlighttrailerexaminationresult = request.getParameter("currentlighttrailerexaminationresult");
		String currenttractioninitialinspectionresult = request.getParameter("currenttractioninitialinspectionresult");
		String currenttractiondisqualification = request.getParameter("currenttractiondisqualification");
		String currenttractionexaminationresult = request.getParameter("currenttractionexaminationresult");

		
		String insurancelistno = (String) request.getParameter("insurancelistno").trim();
		Date insurancedate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insurancedate").trim());
		String insurancecompanyname = (String) request.getParameter("insurancecompanyname").trim();
		Date expirydate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expirydate").trim());
		String reviewer = (String) request.getParameter("reviewer").trim();
		Date reviewerconductdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("reviewerconductdate").trim());
		String issueadmin = (String) request.getParameter("issueadmin").trim();
		Date issueadmindate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("issueadmindate").trim());
		String leaderreview = (String) request.getParameter("leaderreview").trim();
		Date leaderreviewdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("leaderreviewdate").trim());
		String operateuser = (String) request.getParameter("operateuser");
		String operatedate = (String) request.getParameter("operatedate");
		String checkuser = (String) request.getParameter("checkuser");
		String checkdate = (String) request.getParameter("checkdate");
		String checkip = (String) request.getParameter("checkip");
		String checkresult = (String) request.getParameter("checkresult");
		String checkcontext = (String) request.getParameter("checkcontext");
		String checktype = (String) request.getParameter("checktype");

		log.info("Add new CarCheck:[tractorinfoId:" + tractorinfoId + "]");
		CarCheck carcheck = new CarCheck();
		carcheck.setId(id);
		carcheck.setTractorinfoId(tractorinfoId);
		carcheck.setOrgintractorstate(orgintractorstate);
		carcheck.setOrgincheckresult(orgincheckresult);
		carcheck.setOrgindisqualification(orgindisqualification);
		carcheck.setOrgincheckexpirydate(orgincheckexpirydate);
		carcheck.setOrgininspector(orgininspector);
		carcheck.setOrgincheckdate(new SimpleDateFormat("yyyy-MM-dd").parse(orgincheckdate));
		carcheck.setOrginshowinitialinspectionresult(orginshowinitialinspectionresult);
		carcheck.setOrginshowdisqualification(orginshowdisqualification);
		carcheck.setOrginshowexaminationresult(orginshowexaminationresult);
		carcheck.setOrginengineinitialinspectionresult(orginengineinitialinspectionresult);
		carcheck.setOrginenginedisqualification(orginenginedisqualification);
		carcheck.setOrginengineexaminationresult(orginengineexaminationresult);
		carcheck.setOrginconveyorinitialinspectionresult(orginconveyorinitialinspectionresult);
		carcheck.setOrginconveyordisqualification(orginconveyordisqualification);
		carcheck.setOrginconveyorexaminationresult(orginconveyorexaminationresult);
		carcheck.setOrginsteeringinitialinspectionresult(orginsteeringinitialinspectionresult);
		carcheck.setOrginsteeringdisqualification(orginsteeringdisqualification);
		carcheck.setOrginsteeringexaminationresult(orginsteeringexaminationresult);
		carcheck.setOrginflyhostinitialinspectionresult(orginflyhostinitialinspectionresult);
		carcheck.setOrginflyhostdisqualification(orginflyhostdisqualification);
		carcheck.setOrginflyhostexaminationresult(orginflyhostexaminationresult);
		carcheck.setOrginflytrailerinitialinspectionresult(orginflytrailerinitialinspectionresult);
		carcheck.setOrginflytrailerdisqualification(orginflytrailerdisqualification);
		carcheck.setOrginflytrailerexaminationresult(orginflytrailerexaminationresult);
		carcheck.setOrginbrakhostinitialinspectionresult(orginbrakhostinitialinspectionresult);
		carcheck.setOrginbrakhostdisqualification(orginbrakhostdisqualification);
		carcheck.setOrginbrakhostexaminationresult(orginbrakhostexaminationresult);
		carcheck.setOrginbraktrailerinitialinspectionresult(orginbraktrailerinitialinspectionresult);
		carcheck.setOrginbraktrailerdisqualification(orginbraktrailerdisqualification);
		carcheck.setOrginbraktrailerexaminationresult(orginbraktrailerexaminationresult);
		carcheck.setOrginlighthostinitialinspectionresult(orginlighthostinitialinspectionresult);
		carcheck.setOrginlighthostdisqualification(orginlighthostdisqualification);
		carcheck.setOrginlighthostexaminationresult(orginlighthostexaminationresult);
		carcheck.setOrginlighttrailerinitialinspectionresult(orginlighttrailerinitialinspectionresult);
		carcheck.setOrginlighttrailerdisqualification(orginlighttrailerdisqualification);
		carcheck.setOrginlighttrailerexaminationresult(orginlighttrailerexaminationresult);
		carcheck.setOrgintractioninitialinspectionresult(orgintractioninitialinspectionresult);
		carcheck.setOrgintractiondisqualification(orgintractiondisqualification);
		carcheck.setOrgintractionexaminationresult(orgintractionexaminationresult);
		carcheck.setOrgininsurancelistno(orgininsurancelistno);
		carcheck.setOrgininsurancedate(new SimpleDateFormat("yyyy-MM-dd").parse(orgininsurancedate));
		carcheck.setOrgininsurancecompanyname(orgininsurancecompanyname);
		carcheck.setOrginexpirydate(orginexpirydate);

		carcheck.setInspectorresult(inspectorresult);
		carcheck.setCheckexpirydate(checkexpirydate);
		carcheck.setInspector(inspector);
		carcheck.setInspectordate(inspectordate);
		carcheck.setCheckcompanyname(checkcompanyname);
		
		carcheck.setCurrentdisqualification(currentdisqualification);
		carcheck.setCurrentshowinitialinspectionresult(currentshowinitialinspectionresult);
		carcheck.setCurrentshowdisqualification(currentshowdisqualification);
		carcheck.setCurrentshowexaminationresult(currentshowexaminationresult);
		carcheck.setCurrentengineinitialinspectionresult(currentengineinitialinspectionresult);
		carcheck.setCurrentenginedisqualification(currentenginedisqualification);
		carcheck.setCurrentengineexaminationresult(currentengineexaminationresult);
		carcheck.setCurrentconveyorinitialinspectionresult(currentconveyorinitialinspectionresult);
		carcheck.setCurrentconveyordisqualification(currentconveyordisqualification);
		carcheck.setCurrentconveyorexaminationresult(currentconveyorexaminationresult);
		carcheck.setCurrentsteeringinitialinspectionresult(currentsteeringinitialinspectionresult);
		carcheck.setCurrentsteeringdisqualification(currentsteeringdisqualification);
		carcheck.setCurrentsteeringexaminationresult(currentsteeringexaminationresult);
		carcheck.setCurrentflyhostinitialinspectionresult(currentflyhostinitialinspectionresult);
		carcheck.setCurrentflyhostdisqualification(currentflyhostdisqualification);
		carcheck.setCurrentflyhostexaminationresult(currentflyhostexaminationresult);
		carcheck.setCurrentflytrailerinitialinspectionresult(currentflytrailerinitialinspectionresult);
		carcheck.setCurrentflytrailerdisqualification(currentflytrailerdisqualification);
		carcheck.setCurrentflytrailerexaminationresult(currentflytrailerexaminationresult);
		carcheck.setCurrentbrakhostinitialinspectionresult(currentbrakhostinitialinspectionresult);
		carcheck.setCurrentbrakhostdisqualification(currentbrakhostdisqualification);
		carcheck.setCurrentbrakhostexaminationresult(currentbrakhostexaminationresult);
		carcheck.setCurrentbraktrailerinitialinspectionresult(currentbraktrailerinitialinspectionresult);
		carcheck.setCurrentbraktrailerdisqualification(currentbraktrailerdisqualification);
		carcheck.setCurrentbraktrailerexaminationresult(currentbraktrailerexaminationresult);
		carcheck.setCurrentlighthostinitialinspectionresult(currentlighthostinitialinspectionresult);
		carcheck.setCurrentlighthostdisqualification(currentlighthostdisqualification);
		carcheck.setCurrentlighthostexaminationresult(currentlighthostexaminationresult);
		carcheck.setCurrentlighttrailerinitialinspectionresult(currentlighttrailerinitialinspectionresult);
		carcheck.setCurrentlighttrailerdisqualification(currentlighttrailerdisqualification);
		carcheck.setCurrentlighttrailerexaminationresult(currentlighttrailerexaminationresult);
		carcheck.setCurrenttractioninitialinspectionresult(currenttractioninitialinspectionresult);
		carcheck.setCurrenttractiondisqualification(currenttractiondisqualification);
		carcheck.setCurrenttractionexaminationresult(currenttractionexaminationresult);
		
		
		carcheck.setInsurancelistno(insurancelistno);
		carcheck.setInsurancedate(insurancedate);
		carcheck.setInsurancecompanyname(insurancecompanyname);
		carcheck.setExpirydate(expirydate);
		carcheck.setReviewer(reviewer);
		carcheck.setReviewerconductdate(reviewerconductdate);
		carcheck.setIssueadmin(issueadmin);
		carcheck.setIssueadmindate(issueadmindate);
		carcheck.setLeaderreview(leaderreview);
		carcheck.setLeaderreviewdate(leaderreviewdate);
		carcheck.setOperateuser(operateuser);
		carcheck.setOperatedate(new SimpleDateFormat("yyyy-MM-dd").parse(operatedate.trim()));
		carcheck.setCheckuser(checkuser);
		if (checkdate != null && !checkdate.equals("")) {
			carcheck.setCheckdate(new SimpleDateFormat("yyyy-MM-dd").parse(checkdate.trim()));
		}
		carcheck.setCheckip(checkip);
		carcheck.setCheckresult(Integer.parseInt(checkresult));
		carcheck.setCheckcontext(checkcontext);
		carcheck.setChecktype(Integer.parseInt(checktype));
		if (this.serviceManager.getCarCheckService().updateCarCheck(carcheck)) {
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{success: false}");
		}
	}

	// 批量上报
	public void ReportedCarCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("Reported CarCheck");
		User user=(User)request.getSession().getAttribute("user");
		String reportcarcheckids = (String) request.getParameter("reportcarcheckids").trim();
		if (!reportcarcheckids.equals("")) {
			this.serviceManager.getCarCheckService().updateCarCheckStateByIds(1, reportcarcheckids);
			//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarCheckTime();
            }
			CarCheckOperation operation = new CarCheckOperation(audittime,user.getRealname(),request.getRemoteAddr(),reportcarcheckids);
			Thread thread = new Thread(operation, "CarCheck");
			thread.start();
        	response.getWriter().write("{success: true}");
		} else {
			log.info("Err on  ReportedCarCheck");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
		}
	}
	private class CarCheckOperation implements Runnable {
		private int time;
		String realname;
		String remoteaddr;
		String auditcarcheckids;
		public CarCheckOperation(int time,String realname,String remoteaddr,String auditcarcheckids){
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditcarcheckids=auditcarcheckids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,realname,remoteaddr,auditcarcheckids);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String remoteaddr;
		String auditcarcheckids;
		public EggTimer(int time,String realname,String remoteaddr,String auditcarcheckids) {
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditcarcheckids=auditcarcheckids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditCarCheck(realname,remoteaddr,auditcarcheckids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
	// 删除数据
	public void delCarCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("Del CarTransfer");
		String delcarcheckids = request.getParameter("mydelcarcheckids");
		String tractorids = request.getParameter("tractorids");
		if (!delcarcheckids.equals("")) {
			if (this.serviceManager.getCarCheckService().delCarCheckByIds(
					delcarcheckids)) {
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
				log.info("Err on del CarCheck");
				response.getWriter().write("{success: false}");
			}
		}
	}

	// 审核年检信息
	@SuppressWarnings({ "unused", "rawtypes" })
	public void AuditCarCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.debug("Check CarCheck");
		boolean success = false;
		User user = (User) request.getSession().getAttribute("user");
		String auditcarcheckinfo = (String) request.getParameter("auditcarcheckinfo").trim();// 得到需要审核的年检信息
		int checkresult = Integer.parseInt(request.getParameter("state").trim());// 得到年检信息的审核结果
		JSONArray jsonArray = JSONArray.fromObject(auditcarcheckinfo);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		if (checkresult == 2) {
			// 如果审核通过，则更新车辆信息，并且将本条申请状态变为审核通过
					while (iterator.hasNext()) {
						jsonObject = JSONObject.fromObject(iterator.next());
						CarCheckView viewmodel = (CarCheckView)JSONObject.toBean(jsonObject,CarCheckView.class);
							// 更新技术检验
							TechnicalInspect inspect = this.serviceManager.getTechnicalInspectService().GetTechnicalInspectByCondition("tractorinfoId=" + viewmodel.getTractorinfoId());
							inspect.setCheckresult(viewmodel.getInspectorresult());
							inspect.setCheckexpirydate(viewmodel.getCheckexpirydate());
							inspect.setInspector(viewmodel.getInspector());
							inspect.setCheckdate(viewmodel.getInspectordate());
							inspect.setDisqualification(viewmodel.getCurrentdisqualification());
							inspect.setShowinitialinspectionresult(viewmodel.getCurrentshowinitialinspectionresult());
							inspect.setShowdisqualification(viewmodel.getCurrentshowdisqualification());
							inspect.setShowexaminationresult(viewmodel.getCurrentshowexaminationresult());
							inspect.setEngineinitialinspectionresult(viewmodel.getCurrentengineinitialinspectionresult());
							inspect.setEnginedisqualification(viewmodel.getCurrentenginedisqualification());
							inspect.setEngineexaminationresult(viewmodel.getCurrentengineexaminationresult());
							inspect.setConveyorinitialinspectionresult(viewmodel.getCurrentconveyorinitialinspectionresult());
							inspect.setConveyordisqualification(viewmodel.getCurrentconveyordisqualification());
							inspect.setConveyorexaminationresult(viewmodel.getCurrentconveyorexaminationresult());
							inspect.setSteeringinitialinspectionresult(viewmodel.getCurrentsteeringinitialinspectionresult());
							inspect.setSteeringdisqualification(viewmodel.getCurrentsteeringdisqualification());
							inspect.setSteeringexaminationresult(viewmodel.getCurrentsteeringexaminationresult());
							inspect.setFlyhostdisqualification(viewmodel.getCurrentflyhostdisqualification());
							inspect.setFlyhostexaminationresult(viewmodel.getCurrentflyhostexaminationresult());
							inspect.setFlyhostinitialinspectionresult(viewmodel.getCurrentflyhostinitialinspectionresult());
							inspect.setFlytrailerdisqualification(viewmodel.getCurrentflytrailerdisqualification());
							inspect.setFlytrailerexaminationresult(viewmodel.getCurrentflytrailerexaminationresult());
							inspect.setFlytrailerinitialinspectionresult(viewmodel.getCurrentflytrailerinitialinspectionresult());
							inspect.setBrakhostdisqualification(viewmodel.getCurrentbrakhostdisqualification());
							inspect.setBrakhostexaminationresult(viewmodel.getCurrentbrakhostexaminationresult());
							inspect.setBrakhostinitialinspectionresult(viewmodel.getCurrentbrakhostinitialinspectionresult());
							inspect.setBraktrailerdisqualification(viewmodel.getCurrentbraktrailerdisqualification());
							inspect.setBraktrailerexaminationresult(viewmodel.getCurrentbraktrailerexaminationresult());
							inspect.setBraktrailerinitialinspectionresult(viewmodel.getCurrentbraktrailerinitialinspectionresult());
							inspect.setLighthostdisqualification(viewmodel.getCurrentlighthostdisqualification());
							inspect.setLighthostexaminationresult(viewmodel.getCurrentlighthostexaminationresult());
							inspect.setLighthostinitialinspectionresult(viewmodel.getCurrentlighthostinitialinspectionresult());
							inspect.setLighttrailerdisqualification(viewmodel.getCurrentlighttrailerdisqualification());
							inspect.setLighttrailerexaminationresult(viewmodel.getCurrentlighttrailerexaminationresult());
							inspect.setLighttrailerinitialinspectionresult(viewmodel.getCurrentlighttrailerinitialinspectionresult());
							inspect.setTractiondisqualification(viewmodel.getCurrenttractiondisqualification());
							inspect.setTractionexaminationresult(viewmodel.getCurrenttractionexaminationresult());
							inspect.setTractioninitialinspectionresult(viewmodel.getCurrenttractioninitialinspectionresult());
							
							
							// 相关资料
							RelationInfo relation = this.serviceManager.getRelationInfoService().GetRelationInfoByCondition("tractorinfoId=" + viewmodel.getTractorinfoId());
							relation.setInsurancelistno(viewmodel.getInsurancelistno());
							relation.setInsurancecompanyname(viewmodel.getInsurancecompanyname());
							relation.setInsurancedate(viewmodel.getInsurancedate());
							relation.setExpirydate(viewmodel.getExpirydate());
							// 经办信息(暂时不更新)
//							HandlingSituation hand = this.serviceManager.getHandlingSituationService().GetHandlingSituationByCondition("tractorinfoId=" + tractorinfoid);
//							hand.setReviewer(jsonObject.get("reviewer").toString());
//							hand.setReviewerconductdate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("reviewerconductdate").toString()));
//							hand.setIssueadmin(jsonObject.get("issueadmin").toString());
//							hand.setIssueadmindate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("issueadmindate").toString()));
//							hand.setLeaderreview(jsonObject.get("leaderreview").toString());
//							hand.setLeaderreviewconductdate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("leaderreviewdate").toString()));

							// 更新拖拉机状态
							TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
							if(tractorinfoModel.getStatus()==6){
								if(viewmodel.getOrgintractorstate()==2 || viewmodel.getOrgintractorstate()==5)
								{
								tractorinfoModel.setStatus(2);
								}
								else{
									tractorinfoModel.setStatus(viewmodel.getOrgintractorstate());
								}
								this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
							}
							if (this.serviceManager.getTechnicalInspectService().updateTechnicalInspect(inspect)) {
								this.serviceManager.getRelationInfoService().updateRelationInfo(relation);
							}
							this.serviceManager.getCarCheckService().auditCarCheck(checkresult, user.getRealname(),request.getRemoteAddr(), "审核通过",viewmodel.getId()+"");
						}
					response.getWriter().write("{success: true}");

		} else if (checkresult == 3) {
			// 如果审核未通过
			String checkcontext = request.getParameter("checkcontext").trim();
			while (iterator.hasNext()) {
				jsonObject = JSONObject.fromObject(iterator.next());
				CarCheckView viewmodel = (CarCheckView)JSONObject.toBean(jsonObject,CarCheckView.class);
				if(viewmodel.getCheckresult()==2){
					//如果当前审核的是已经通过的数据
					// 更新拖拉机状态
					TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
					if(tractorinfoModel.getStatus()==2 || tractorinfoModel.getStatus()==14 || tractorinfoModel.getStatus()==13){
						tractorinfoModel.setStatus(6);
						this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
					}
				}					
				this.serviceManager.getCarCheckService().auditCarCheck(checkresult, user.getRealname(),request.getRemoteAddr(), checkcontext,viewmodel.getId()+"");
			}
			response.getWriter().write("{success: true}");
		}
		response.getWriter().write("{success: true}");
	}
	
	
	//自动审核
	public void ThreadAuditCarCheck(String checkusername,String checkip,String auditcarcheckinfoIds)
	{
		List<CarCheckView> list = this.serviceManager.getCarCheckService().getCarCheckViewListByIds(auditcarcheckinfoIds);
		for (CarCheckView viewmodel: list) 
		{
			if(viewmodel.getCheckresult()==1)
			{
				// 更新技术检验
				TechnicalInspect inspect = this.serviceManager.getTechnicalInspectService().GetTechnicalInspectByCondition("tractorinfoId=" + viewmodel.getTractorinfoId());
				inspect.setCheckresult(viewmodel.getInspectorresult());
				inspect.setCheckexpirydate(viewmodel.getCheckexpirydate());
				inspect.setInspector(viewmodel.getInspector());
				inspect.setCheckdate(viewmodel.getInspectordate());
				inspect.setDisqualification(viewmodel.getCurrentdisqualification());
				inspect.setShowinitialinspectionresult(viewmodel.getCurrentshowinitialinspectionresult());
				inspect.setShowdisqualification(viewmodel.getCurrentshowdisqualification());
				inspect.setShowexaminationresult(viewmodel.getCurrentshowexaminationresult());
				inspect.setEngineinitialinspectionresult(viewmodel.getCurrentengineinitialinspectionresult());
				inspect.setEnginedisqualification(viewmodel.getCurrentenginedisqualification());
				inspect.setEngineexaminationresult(viewmodel.getCurrentengineexaminationresult());
				inspect.setConveyorinitialinspectionresult(viewmodel.getCurrentconveyorinitialinspectionresult());
				inspect.setConveyordisqualification(viewmodel.getCurrentconveyordisqualification());
				inspect.setConveyorexaminationresult(viewmodel.getCurrentconveyorexaminationresult());
				inspect.setSteeringinitialinspectionresult(viewmodel.getCurrentsteeringinitialinspectionresult());
				inspect.setSteeringdisqualification(viewmodel.getCurrentsteeringdisqualification());
				inspect.setSteeringexaminationresult(viewmodel.getCurrentsteeringexaminationresult());
				inspect.setFlyhostdisqualification(viewmodel.getCurrentflyhostdisqualification());
				inspect.setFlyhostexaminationresult(viewmodel.getCurrentflyhostexaminationresult());
				inspect.setFlyhostinitialinspectionresult(viewmodel.getCurrentflyhostinitialinspectionresult());
				inspect.setFlytrailerdisqualification(viewmodel.getCurrentflytrailerdisqualification());
				inspect.setFlytrailerexaminationresult(viewmodel.getCurrentflytrailerexaminationresult());
				inspect.setFlytrailerinitialinspectionresult(viewmodel.getCurrentflytrailerinitialinspectionresult());
				inspect.setBrakhostdisqualification(viewmodel.getCurrentbrakhostdisqualification());
				inspect.setBrakhostexaminationresult(viewmodel.getCurrentbrakhostexaminationresult());
				inspect.setBrakhostinitialinspectionresult(viewmodel.getCurrentbrakhostinitialinspectionresult());
				inspect.setBraktrailerdisqualification(viewmodel.getCurrentbraktrailerdisqualification());
				inspect.setBraktrailerexaminationresult(viewmodel.getCurrentbraktrailerexaminationresult());
				inspect.setBraktrailerinitialinspectionresult(viewmodel.getCurrentbraktrailerinitialinspectionresult());
				inspect.setLighthostdisqualification(viewmodel.getCurrentlighthostdisqualification());
				inspect.setLighthostexaminationresult(viewmodel.getCurrentlighthostexaminationresult());
				inspect.setLighthostinitialinspectionresult(viewmodel.getCurrentlighthostinitialinspectionresult());
				inspect.setLighttrailerdisqualification(viewmodel.getCurrentlighttrailerdisqualification());
				inspect.setLighttrailerexaminationresult(viewmodel.getCurrentlighttrailerexaminationresult());
				inspect.setLighttrailerinitialinspectionresult(viewmodel.getCurrentlighttrailerinitialinspectionresult());
				inspect.setTractiondisqualification(viewmodel.getCurrenttractiondisqualification());
				inspect.setTractionexaminationresult(viewmodel.getCurrenttractionexaminationresult());
				inspect.setTractioninitialinspectionresult(viewmodel.getCurrenttractioninitialinspectionresult());
				
				
				// 相关资料
				RelationInfo relation = this.serviceManager.getRelationInfoService().GetRelationInfoByCondition("tractorinfoId=" + viewmodel.getTractorinfoId());
				relation.setInsurancelistno(viewmodel.getInsurancelistno());
				relation.setInsurancecompanyname(viewmodel.getInsurancecompanyname());
				relation.setInsurancedate(viewmodel.getInsurancedate());
				relation.setExpirydate(viewmodel.getExpirydate());
				// 经办信息(暂时不更新)
//				HandlingSituation hand = this.serviceManager.getHandlingSituationService().GetHandlingSituationByCondition("tractorinfoId=" + tractorinfoid);
//				hand.setReviewer(jsonObject.get("reviewer").toString());
//				hand.setReviewerconductdate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("reviewerconductdate").toString()));
//				hand.setIssueadmin(jsonObject.get("issueadmin").toString());
//				hand.setIssueadmindate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("issueadmindate").toString()));
//				hand.setLeaderreview(jsonObject.get("leaderreview").toString());
//				hand.setLeaderreviewconductdate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("leaderreviewdate").toString()));

				// 更新拖拉机状态
				TractorInfo tractorinfoModel = this.serviceManager.getTractorInfoService().findTractorInfoById(viewmodel.getTractorinfoId());
				if(tractorinfoModel.getStatus()==6){
					if(viewmodel.getOrgintractorstate()==2 || viewmodel.getOrgintractorstate()==5)
					{
					tractorinfoModel.setStatus(2);
					}
					else{
						tractorinfoModel.setStatus(viewmodel.getOrgintractorstate());
					}
					this.serviceManager.getTractorInfoService().updateTractorInfo(tractorinfoModel);
				}
				if (this.serviceManager.getTechnicalInspectService().updateTechnicalInspect(inspect)) {
					this.serviceManager.getRelationInfoService().updateRelationInfo(relation);
				}
				this.serviceManager.getCarCheckService().auditCarCheck(2, checkusername,checkip, "审核通过",viewmodel.getId()+"");
			}
		}
		
	}
	
	//打印业务流程
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void carCheckInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		String id = request.getParameter("id").trim();
		User user=(User)request.getSession().getAttribute("user");
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getCarCheckService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_carCheckFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
