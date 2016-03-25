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

import net.sf.ezmorph.object.DateMorpher;
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
import net.sf.json.util.JSONUtils;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.Util.DateTimeUtil;
import Ynzc.Util.StringUtil;
import Ynzc.YnzcAms.Model.*;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;
import Ynzc.YnzcAms.Util.IReportReCompile;
import Ynzc.YnzcAms.Util.TractorInfoSearch;

public class MortgageController extends  BaseController{
	private final static Logger log = Logger.getLogger(MortgageController.class);
	
	//查询分页数据
	public void getMortgageListByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action MortgageListByPage");
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
		String mortgagetype = request.getParameter("mortgagetype");
		
		User user=(User)request.getSession().getAttribute("user");
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		String condition = "";//设置查询条件为空
		condition=TractorInfoSearch.getBusinessCondition(state, codenum, owner, machinetype, plantType, checkexpriydate, regcerno, cardid, engineno, mortgagetype, "mortgage");
		List<MortgageView> res = serviceManager.getMortgageService().getMortgageList(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (MortgageView u : res) {
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
	
	
	//添加抵押信息
	public void addMortgage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("add Mortgage");
		Mortgage model=new Mortgage();
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null){
			//获取参数实体参数
			int tractorinfoid=Integer.parseInt(request.getParameter("tractorinfoid").trim());
			String tractorcode =request.getParameter("tractorcode");
			String tractorno =request.getParameter("tractorno");
			String tractoraddress =request.getParameter("tractoraddress");
			String mortgagetype =request.getParameter("mortgagetype");
			String mortgagementype =request.getParameter("mortgagementype");
			String mortgageownermentype =request.getParameter("mortgageownermentype");
			String mortgageusername =request.getParameter("mortgageusername");
			String mortgageaddress =request.getParameter("mortgageaddress");
			String mortgageistemplive =request.getParameter("mortgageistemplive");
			String mortgagecaridtype =request.getParameter("mortgagecaridtype");//int
			String mortgagecarid =request.getParameter("mortgagecarid");
			String mortgagelinktel =request.getParameter("mortgagelinktel");
			String mortgagezipcode =request.getParameter("mortgagezipcode");
			String mortgagehandledate =request.getParameter("mortgagehandledate");//date
			String mortgageownerusername =request.getParameter("mortgageownerusername");
			String mortgageowneraddress =request.getParameter("mortgageowneraddress");
			String mortgageisownertemplive =request.getParameter("mortgageisownertemplive");		
			String mortgageownercaridtype =request.getParameter("mortgageownercaridtype");//int					
			String mortgageownercarid =request.getParameter("mortgageownercarid");			
			String mortgageownerlinktel =request.getParameter("mortgageownerlinktel");			
			String mortgageownerzipcode =request.getParameter("mortgageownerzipcode");			
			String mortgageownerhandledate =request.getParameter("mortgageownerhandledate");//date			
			String mortgageinformation =request.getParameter("mortgageinformation");		
			String mortgageproxyusername =request.getParameter("mortgageproxyusername");			
			String mortgageproxylinktel =request.getParameter("mortgageproxylinktel");			
			String mortgageproxyaddress =request.getParameter("mortgageproxyaddress");				
			String mortgageproxyidtype =request.getParameter("mortgageproxyidtype");//int			
			String mortgageproxyid =request.getParameter("mortgageproxyid");			
			String mortgageproxyhandlename =request.getParameter("mortgageproxyhandlename");			
			String mortgageproxyhandleidtype =request.getParameter("mortgageproxyhandleidtype");//int			
			String mortgageproxyhandleid =request.getParameter("mortgageproxyhandleid");			
			String mortgageproxyhandleaddress =request.getParameter("mortgageproxyhandleaddress");			
			String mortgageproxyhandledate =request.getParameter("mortgageproxyhandledate");//date			
			String mortgageownerproxyusername =request.getParameter("mortgageownerproxyusername");			
			String mortgageownerproxylinktel =request.getParameter("mortgageownerproxylinktel");			
			String mortgageownerproxyaddress =request.getParameter("mortgageownerproxyaddress");			
			String mortgageownerproxyidtype =request.getParameter("mortgageownerproxyidtype");//int			
			String mortgageownerproxyid =request.getParameter("mortgageownerproxyid");			
			String mortgageownerproxyhandlename =request.getParameter("mortgageownerproxyhandlename");			
			String mortgageownerproxyhandleidtype =request.getParameter("mortgageownerproxyhandleidtype");//int			
			String mortgageownerproxyhandleid =request.getParameter("mortgageownerproxyhandleid");			
			String mortgageownerproxyhandleaddress =request.getParameter("mortgageownerproxyhandleaddress");			
			String mortgageownerproxyhandledate =request.getParameter("mortgageownerproxyhandledate");//date           
						
			model.setTractorinfoid(tractorinfoid);
			model.setTractorcode(tractorcode);
			model.setTractorno(tractorno);
			model.setTractoraddress(tractoraddress);
			model.setMortgagetype(mortgagetype);
			model.setMortgagementype(mortgagementype);
			model.setMortgageownermentype(mortgageownermentype);
			model.setMortgageusername(mortgageusername);
			model.setMortgageaddress(mortgageaddress);
			model.setMortgageistemplive(mortgageistemplive);
	        if(StringUtil.isNotNullEmptyStr(mortgagecaridtype)){
	        	model.setMortgagecaridtype(Integer.parseInt(mortgagecaridtype));
			}			
			model.setMortgagecarid(mortgagecarid);
		    model.setMortgagelinktel(mortgagelinktel);
		    model.setMortgagezipcode(mortgagezipcode);
		    if(StringUtil.isNotNullEmptyStr(mortgagehandledate)){
	        	model.setMortgagehandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgagehandledate.trim()));
			}
		    model.setMortgageownerusername(mortgageownerusername);
		    model.setMortgageowneraddress(mortgageowneraddress);
			model.setMortgageisownertemplive(mortgageisownertemplive);
			if(StringUtil.isNotNullEmptyStr(mortgageownercaridtype)){
				 model.setMortgageownercaridtype(Integer.parseInt(mortgageownercaridtype));
			}
			model.setMortgageownercarid(mortgageownercarid);
			model.setMortgageownerlinktel(mortgageownerlinktel);
			model.setMortgageownerzipcode(mortgageownerzipcode);
			if(StringUtil.isNotNullEmptyStr(mortgageownerhandledate)){
				 model.setMortgageownerhandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgageownerhandledate.trim()));
		    }
			model.setMortgageinformation(mortgageinformation);
			model.setMortgageproxyusername(mortgageproxyusername);
			model.setMortgageproxylinktel(mortgageproxylinktel);
			model.setMortgageproxyaddress(mortgageproxyaddress);
			if(StringUtil.isNotNullEmptyStr(mortgageproxyidtype)){
				model.setMortgageproxyidtype(Integer.parseInt(mortgageproxyidtype));
			}
			model.setMortgageproxyid(mortgageproxyid);
			model.setMortgageproxyhandlename(mortgageproxyhandlename);
			if(StringUtil.isNotNullEmptyStr(mortgageproxyhandleidtype)){
				model.setMortgageproxyhandleidtype(Integer.parseInt(mortgageproxyhandleidtype));
			}
			model.setMortgageproxyhandleid(mortgageproxyhandleid);
			model.setMortgageproxyhandleaddress(mortgageproxyhandleaddress);
			if(StringUtil.isNotNullEmptyStr(mortgageproxyhandledate)){
				model.setMortgageproxyhandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgageproxyhandledate.trim()));
			}
			model.setMortgageownerproxyusername(mortgageownerproxyusername);
			model.setMortgageownerproxylinktel(mortgageownerproxylinktel);
			model.setMortgageownerproxyaddress(mortgageownerproxyaddress);
			if(StringUtil.isNotNullEmptyStr(mortgageownerproxyidtype)){
				model.setMortgageownerproxyidtype(Integer.parseInt(mortgageownerproxyidtype));
			}
			model.setMortgageownerproxyid(mortgageownerproxyid);
			model.setMortgageownerproxyhandlename(mortgageownerproxyhandlename);
			if(StringUtil.isNotNullEmptyStr(mortgageownerproxyhandleidtype)){
				model.setMortgageownerproxyhandleidtype(Integer.parseInt(mortgageownerproxyhandleidtype));
			}
			model.setMortgageownerproxyhandleid(mortgageownerproxyhandleid);
			model.setMortgageownerproxyhandleaddress(mortgageownerproxyhandleaddress);
			if(StringUtil.isNotNullEmptyStr(mortgageownerproxyhandledate)){
				model.setMortgageownerproxyhandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgageownerproxyhandledate.trim()));
			}
			model.setCheckstate(0);
			model.setOpertator(user.getRealname());
			model.setOperatedate(new Date());
			if (serviceManager.getMortgageService().addMortgage(model)) {
				TractorInfo tractorInfo=this.serviceManager.getTractorInfoService().findTractorInfoById(model.getTractorinfoid());
				tractorInfo.setStatus(12);
				this.serviceManager.getTractorInfoService().updateTractorInfo(tractorInfo);
				log.info("抵押成功");
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/json;charset=utf-8");
				response.getWriter().write("{success: true}");
			} else {
				response.getWriter().write("{errors:'抵押失败，请重新尝试!'}");
			}	
		}else{
			response.getWriter().write("{errors:'用户登录失败 !'}");
		}       		
	}
	
	//批量上报
	public void ReportedMortgage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Report Mortgage");
		User user=(User)request.getSession().getAttribute("user");
		String reportmortgageids = (String) request.getParameter("reportmortgageids").trim();
        if(!reportmortgageids.equals("")){
        	this.serviceManager.getMortgageService().updateMortgageStateByIds(1, reportmortgageids);
        	//上报后启动自动审核
			SetTime st = serviceManager.getSetTimeService().findSetTimeByUnitId(user.getUnitid());
			int audittime=0;
            if(st!=null)
            {
            	audittime=st.getCarMortgageTime();
            }
			MortgageOperation operation = new MortgageOperation(audittime,user.getRealname(),request.getRemoteAddr(),reportmortgageids);
			Thread thread = new Thread(operation, "Mortgage");
			thread.start();
        	response.getWriter().write("{success: true}");
        }
        else{
			log.info("Err on Report Mortgage");
			response.getWriter().write("{failure:true,reason:'上报信息失败'}");
        }
	}
	
	private class MortgageOperation implements Runnable {
		private int time;
		String realname;
		String remoteaddr;
		String auditmortgageids;
		public MortgageOperation(int time,String realname,String remoteaddr,String auditmortgageids){
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditmortgageids=auditmortgageids;
		}
		public void run() {
			System.out.println("+++++++++++++线程已抛出+++++++++++++");
			EggTimer eggTimer = new EggTimer(time,realname,remoteaddr,auditmortgageids);
			eggTimer.start();
		}
	}
	
	public class EggTimer {
		private final Timer timer = new Timer();
		private int time;
		String realname;
		String remoteaddr;
		String auditmortgageids;
		public EggTimer(int time,String realname,String remoteaddr,String auditmortgageids) {
			this.time = time;
			this.realname=realname;
			this.remoteaddr=remoteaddr;
			this.auditmortgageids=auditmortgageids;
		}
		public void start() {
			timer.schedule(new TimerTask() {
				public void run() {
					playSound();
					timer.cancel();
				}
				private void playSound() {
					System.out.println("+++++++++++++计时器运行+++++++++++++");
					ThreadAuditMortgage(realname,remoteaddr,auditmortgageids);
				}
			}, time * 60 * 1000);//使用毫秒计数
		}
	}
	
	

	//删除数据
	public void delMortgage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del Mortgage");
		String delmortgageids =request.getParameter("mydelmortgageids");
		String tractorids =request.getParameter("tractorids");
		 if(!delmortgageids.equals("")){
			 if(this.serviceManager.getMortgageService().delMortgageByIds(delmortgageids)){
				   if(!tractorids.equals("")){
	        			tractorids=tractorids.substring(0,tractorids.length()-1);
	        			this.serviceManager.getTractorInfoService().updateTractorStateByIds(2, tractorids,TractorInfoSearch.GetBusinessOverCondtion());	
	        		}
				   response.getWriter().write("{success: true}");
			 }else{
				 log.info("Err on Del Mortgage");
				 response.getWriter().write("{success: false}");
			 }
		 }
	}
	
	//修改 抵押信息
	public void updateMortgage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("update Mortgage");
		//获取参数实体参数
		Mortgage model=new Mortgage();
		int id=Integer.parseInt(request.getParameter("id").trim());
		int tractorinfoid=Integer.parseInt(request.getParameter("tractorinfoid").trim());
		String tractorcode =request.getParameter("tractorcode");
		String tractorno =request.getParameter("tractorno");
		String tractoraddress =request.getParameter("tractoraddress");
		String mortgagetype =request.getParameter("mortgagetype");
		String mortgagementype =request.getParameter("mortgagementype");
		String mortgageownermentype =request.getParameter("mortgageownermentype");
		String mortgageusername =request.getParameter("mortgageusername");
		String mortgageaddress =request.getParameter("mortgageaddress");
		String mortgageistemplive =request.getParameter("mortgageistemplive");
		String mortgagecaridtype =request.getParameter("mortgagecaridtype");//int
		String mortgagecarid =request.getParameter("mortgagecarid");
		String mortgagelinktel =request.getParameter("mortgagelinktel");
		String mortgagezipcode =request.getParameter("mortgagezipcode");
		String mortgagehandledate =request.getParameter("mortgagehandledate");//date
		String mortgageownerusername =request.getParameter("mortgageownerusername");
		String mortgageowneraddress =request.getParameter("mortgageowneraddress");
		String mortgageisownertemplive =request.getParameter("mortgageisownertemplive");		
		String mortgageownercaridtype =request.getParameter("mortgageownercaridtype");//int					
		String mortgageownercarid =request.getParameter("mortgageownercarid");			
		String mortgageownerlinktel =request.getParameter("mortgageownerlinktel");			
		String mortgageownerzipcode =request.getParameter("mortgageownerzipcode");			
		String mortgageownerhandledate =request.getParameter("mortgageownerhandledate");//date			
		String mortgageinformation =request.getParameter("mortgageinformation");		
		String mortgageproxyusername =request.getParameter("mortgageproxyusername");			
		String mortgageproxylinktel =request.getParameter("mortgageproxylinktel");			
		String mortgageproxyaddress =request.getParameter("mortgageproxyaddress");				
		String mortgageproxyidtype =request.getParameter("mortgageproxyidtype");//int			
		String mortgageproxyid =request.getParameter("mortgageproxyid");			
		String mortgageproxyhandlename =request.getParameter("mortgageproxyhandlename");			
		String mortgageproxyhandleidtype =request.getParameter("mortgageproxyhandleidtype");//int			
		String mortgageproxyhandleid =request.getParameter("mortgageproxyhandleid");			
		String mortgageproxyhandleaddress =request.getParameter("mortgageproxyhandleaddress");			
		String mortgageproxyhandledate =request.getParameter("mortgageproxyhandledate");//date			
		String mortgageownerproxyusername =request.getParameter("mortgageownerproxyusername");			
		String mortgageownerproxylinktel =request.getParameter("mortgageownerproxylinktel");			
		String mortgageownerproxyaddress =request.getParameter("mortgageownerproxyaddress");			
		String mortgageownerproxyidtype =request.getParameter("mortgageownerproxyidtype");//int			
		String mortgageownerproxyid =request.getParameter("mortgageownerproxyid");			
		String mortgageownerproxyhandlename =request.getParameter("mortgageownerproxyhandlename");			
		String mortgageownerproxyhandleidtype =request.getParameter("mortgageownerproxyhandleidtype");//int			
		String mortgageownerproxyhandleid =request.getParameter("mortgageownerproxyhandleid");			
		String mortgageownerproxyhandleaddress =request.getParameter("mortgageownerproxyhandleaddress");			
		String mortgageownerproxyhandledate =request.getParameter("mortgageownerproxyhandledate");//date           
		String checkmen =request.getParameter("checkmen");
		String checkstate =request.getParameter("checkstate");
		String checkcontent =request.getParameter("checkcontent"); 
		String checkdate =request.getParameter("checkdate");
		String checkip =request.getParameter("checkip"); 
		String opertator =request.getParameter("opertator");
		String operatedate =request.getParameter("operatedate");
		model.setId(id);
		model.setTractorinfoid(tractorinfoid);
		model.setTractorcode(tractorcode);
		model.setTractorno(tractorno);
		model.setTractoraddress(tractoraddress);
		model.setMortgagetype(mortgagetype);
		model.setMortgagementype(mortgagementype);
		model.setMortgageownermentype(mortgageownermentype);
		model.setMortgageusername(mortgageusername);
		model.setMortgageaddress(mortgageaddress);
		model.setMortgageistemplive(mortgageistemplive);
        if(StringUtil.isNotNullEmptyStr(mortgagecaridtype)){
        	model.setMortgagecaridtype(Integer.parseInt(mortgagecaridtype));
		}			
		model.setMortgagecarid(mortgagecarid);
	    model.setMortgagelinktel(mortgagelinktel);
	    model.setMortgagezipcode(mortgagezipcode);
	    if(StringUtil.isNotNullEmptyStr(mortgagehandledate)){
        	model.setMortgagehandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgagehandledate.trim()));
		}
	    model.setMortgageownerusername(mortgageownerusername);
	    model.setMortgageowneraddress(mortgageowneraddress);
		model.setMortgageisownertemplive(mortgageisownertemplive);
		if(StringUtil.isNotNullEmptyStr(mortgageownercaridtype)){
			 model.setMortgageownercaridtype(Integer.parseInt(mortgageownercaridtype));
		}
		model.setMortgageownercarid(mortgageownercarid);
		model.setMortgageownerlinktel(mortgageownerlinktel);
		model.setMortgageownerzipcode(mortgageownerzipcode);
		if(StringUtil.isNotNullEmptyStr(mortgageownerhandledate)){
			 model.setMortgageownerhandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgageownerhandledate.trim()));
	    }
		model.setMortgageinformation(mortgageinformation);
		model.setMortgageproxyusername(mortgageproxyusername);
		model.setMortgageproxylinktel(mortgageproxylinktel);
		model.setMortgageproxyaddress(mortgageproxyaddress);
		if(StringUtil.isNotNullEmptyStr(mortgageproxyidtype)){
			model.setMortgageproxyidtype(Integer.parseInt(mortgageproxyidtype));
		}
		model.setMortgageproxyid(mortgageproxyid);
		model.setMortgageproxyhandlename(mortgageproxyhandlename);
		if(StringUtil.isNotNullEmptyStr(mortgageproxyhandleidtype)){
			model.setMortgageproxyhandleidtype(Integer.parseInt(mortgageproxyhandleidtype));
		}
		model.setMortgageproxyhandleid(mortgageproxyhandleid);
		model.setMortgageproxyhandleaddress(mortgageproxyhandleaddress);
		if(StringUtil.isNotNullEmptyStr(mortgageproxyhandledate)){
			model.setMortgageproxyhandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgageproxyhandledate.trim()));
		}
		model.setMortgageownerproxyusername(mortgageownerproxyusername);
		model.setMortgageownerproxylinktel(mortgageownerproxylinktel);
		model.setMortgageownerproxyaddress(mortgageownerproxyaddress);
		if(StringUtil.isNotNullEmptyStr(mortgageownerproxyidtype)){
			model.setMortgageownerproxyidtype(Integer.parseInt(mortgageownerproxyidtype));
		}
		model.setMortgageownerproxyid(mortgageownerproxyid);
		model.setMortgageownerproxyhandlename(mortgageownerproxyhandlename);
		if(StringUtil.isNotNullEmptyStr(mortgageownerproxyhandleidtype)){
			model.setMortgageownerproxyhandleidtype(Integer.parseInt(mortgageownerproxyhandleidtype));
		}
		model.setMortgageownerproxyhandleid(mortgageownerproxyhandleid);
		model.setMortgageownerproxyhandleaddress(mortgageownerproxyhandleaddress);
		if(StringUtil.isNotNullEmptyStr(mortgageownerproxyhandledate)){
			model.setMortgageownerproxyhandledate(new SimpleDateFormat("yyyy-MM-dd").parse(mortgageownerproxyhandledate.trim()));
		}
		model.setCheckmen(checkmen);
		if(StringUtil.isNotNullEmptyStr(checkstate)){
			model.setCheckstate(Integer.parseInt(checkstate));
		}
        model.setCheckcontent(checkcontent);
        if(StringUtil.isNotNullEmptyStr(checkdate)){
			model.setCheckdate(new SimpleDateFormat("yyyy-MM-dd").parse(checkdate.trim()));
		}
        model.setCheckip(checkip);
        model.setOpertator(opertator);
        if(StringUtil.isNotNullEmptyStr(operatedate)){
			model.setOperatedate(new SimpleDateFormat("yyyy-MM-dd").parse(operatedate.trim()));
		}
		if (serviceManager.getMortgageService().updateMortgage(model)) {
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'抵押失败，请重新尝试!'}");
		}
      		
	}
	
	
	//审核抵押信息
	public void auditMortgage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("audit Mortgage");
		User user=(User)request.getSession().getAttribute("user");
		String auditmortgageids = (String) request.getParameter("auditmortgageids").trim();//得到需要审核的信息
		int checkstate=Integer.parseInt(request.getParameter("checkstate").trim());//得到审核结果
		String checkcontext = (String) request.getParameter("checkcontext").trim();//得到审核意见
		String tractorinfoids = (String) request.getParameter("tractorinfo").trim();//得到审核通过或者不通过 信息对应的车辆ID
		if(user!=null && auditmortgageids!=null && checkcontext!=null){
			if(this.serviceManager.getMortgageService().auditMortgage(checkstate, user.getRealname(), request.getRemoteAddr(), checkcontext, auditmortgageids)){
				if(checkstate==2){
					if(tractorinfoids!=null && !tractorinfoids.equals("")){
						this.serviceManager.getTractorInfoService().updateTractorStateByIds(14, tractorinfoids, "");
					}
				}else if(checkstate==3){
					if(tractorinfoids!=null && !tractorinfoids.equals("")){
						this.serviceManager.getTractorInfoService().updateTractorStateByIds(12, tractorinfoids, "");
					}
				}
			}
		}

		response.getWriter().write("{success: true}");
	}
	
	//自动审核方法
	public void ThreadAuditMortgage(String checkusername,String checkip,String auditmortgageids){
		String waitAuditmMrtgageIds="";
		String tractorinfoids="";
		List<MortgageView> res = serviceManager.getMortgageService().getMortgageViewListByIds(auditmortgageids);
		for (MortgageView viewModel : res) {
			if(viewModel.getCheckstate()==1){
				 if (waitAuditmMrtgageIds.length() == 0) {
					 waitAuditmMrtgageIds = waitAuditmMrtgageIds + String.valueOf(viewModel.getId());
	             } else {
	            	 waitAuditmMrtgageIds = waitAuditmMrtgageIds + "," + String.valueOf(viewModel.getId());
	             }
	             if (tractorinfoids.length() == 0) {
	             	tractorinfoids = tractorinfoids +  String.valueOf(viewModel.getTractorinfoId());
	             } else {
	             	tractorinfoids = tractorinfoids + "," + String.valueOf(viewModel.getTractorinfoId());
	             }
			}
		}
		if(waitAuditmMrtgageIds!=null && !waitAuditmMrtgageIds.equals(""))
		{
			if(this.serviceManager.getMortgageService().auditMortgage(2, checkusername, checkip, "审核通过", waitAuditmMrtgageIds)){
					if(tractorinfoids!=null && !tractorinfoids.equals("")){
						this.serviceManager.getTractorInfoService().updateTractorStateByIds(14, tractorinfoids, "");
					}
			}
		}
	}
	//打印业务流程
	public void mortgageInfoFlowReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();
		String wordType=request.getParameter("wordType");
		List<TractorRegistrationRecordProcessSource> list = serviceManager.getMortgageService().recordReport(Integer.valueOf(id));
		
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_mortgageFlowReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
	
	//打印抵押登记表
	public void PrintMortgageReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		HashMap map=new HashMap();
		User user=(User)request.getSession().getAttribute("user");
		String id = request.getParameter("id").trim();//申请ID
		String wordType=request.getParameter("wordType");
		List<TractorMortgageApplicationSource> list=this.serviceManager.getMortgageService().PrintMortgageReport(Integer.parseInt(id));
		String FileUrl = request.getRealPath("/")+"drivingLicenceUpload/"+DateTimeUtil.formatDate(DateTimeUtil.getNow())+"/";
		File file = new File(FileUrl);
		if(!file.isDirectory()){
			file.mkdir();
		}
		String fineName = list.get(0).getLicense()+"_MortgageReport_"+DateTimeUtil.formatDate(DateTimeUtil.getNow());
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
		JasperReport report = IReportReCompile.getJasperReport(request.getRealPath("/") + "/Report/tractorMortgageApplication.jrxml", ws.getTopMargin(), ws.getBottomMargin(), ws.getLeftMargin(), ws.getRightMargin());
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, map, dataSource);
		String path = FileUrl + fineName + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        response.getWriter().write("{success:true,url:'"+path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\")+"'}");
        System.out.println(path.replace(request.getRealPath("/"), "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/").replace("\\", "\\\\"));

	}
	
}
