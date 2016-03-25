package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UnitManage;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UnitManageController extends BaseController{
	private final static Logger log = Logger.getLogger(UnitManageController.class);

	public void getUnitManageList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getUnitManageList");//记录日志
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
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
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		List<UnitManage> res = serviceManager.getUnitManageService().getAllUnitManageList(page,condition,regionid);
		JSONArray jsonItems = new JSONArray();
		for (UnitManage u : res) {
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
	
	public void getUnitManageComboList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action getUnitManageList");//记录日志
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
			log.info(start);
		} else {
			log.info("start is null");
		}
		if ((String) request.getParameter("limit").trim() != null) {
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
		int unitid=Integer.parseInt(request.getSession().getAttribute("unitid").toString().trim());
		List<UnitManage> res = serviceManager.getUnitManageService().getAllModelList(page, condition, unitid);
		JSONArray jsonItems = new JSONArray();
		for (UnitManage u : res) {
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
	
	public void getUnitManageComboAllList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");//获取查询字段
		String query = request.getParameter("query");//获取查询输入框中输入的查询值
		String condition = "";//设置查询条件为空
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition()
					.FieldsAndQueryToCondition(fields, query);
		}
		String regionid=request.getSession().getAttribute("regionid").toString().trim();
		List<UnitManage> res = serviceManager.getUnitManageService().getAllUnitManageList(page, condition, regionid);
		JSONArray jsonItems = new JSONArray();
		for (UnitManage u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getAllUnit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action GetAllUnit");
		List<UnitManage> res = serviceManager.getUnitManageService().getAllUnitManageList();//得到所有的集合
		JSONArray jsonItems = new JSONArray();
		for (UnitManage u : res) {
			jsonItems.add(JSONObject.fromObject(u));
		}
		JSONObject jsonBack = new JSONObject();
		
		jsonBack.put("Unit", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	//添加数据
	public void addUnitManage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String region =request.getParameter("region").trim();
		String regionid = request.getParameter("regionid").trim();
		String useunit = (String) request.getParameter("useunit").trim();
		String responsiblemen = (String) request.getParameter("responsiblemen").trim();
		String linktel = (String) request.getParameter("linktel").trim();
		String address = (String) request.getParameter("address").trim();
		String zipcode = (String) request.getParameter("zipcode").trim();
		String chaptercode = (String) request.getParameter("chaptercode").trim();
		String platecode = (String) request.getParameter("platecode").trim();
		String registMan = (String) request.getParameter("registMan").trim();
		String paizhengman = (String) request.getParameter("paizhengman").trim();
		String leaderman = (String) request.getParameter("leaderman").trim();
		int userid = -1;
		log.info("Add new UnitManage:[regionid:"+regionid+"/useunit:"+useunit+"/responsiblemen:"+responsiblemen+"/linktel:"+linktel+"/address:"+address+"/zipcode:"+zipcode+"/chaptercode:"+chaptercode+"/platecode:"+platecode+"/registMan:"+registMan+"/paizhengman:"+paizhengman+"/leaderman:"+leaderman+"/userid:"+userid+"]");
		UnitManage model=new UnitManage();
		model.setRegion(region);
		model.setRegionid(regionid);
		model.setUseunit(useunit);
		model.setResponsiblemen(responsiblemen);
		model.setLinktel(linktel);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setChaptercode(chaptercode);
		model.setPlatecode(platecode);
		model.setRegistman(registMan);
		model.setPaizhengman(paizhengman);
		model.setLeaderman(leaderman);
		model.setUserid(userid);
		
		if (serviceManager.getUnitManageService().addModel(model)) {
			log.info("添加信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'添加信息失败，请重新尝试!'}");
		}
	}
	//更新数据
	public void updateUnitManage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		UnitManage model=new UnitManage();
		String id = (String) request.getParameter("id").trim();
		String region =request.getParameter("region").trim();
		String regionid =request.getParameter("regionid").trim();
		String useunit = (String) request.getParameter("useunit").trim();
		String responsiblemen = (String) request.getParameter("responsiblemen").trim();
		String linktel = (String) request.getParameter("linktel").trim();
		String address = (String) request.getParameter("address").trim();
		String zipcode = (String) request.getParameter("zipcode").trim();
		String chaptercode = (String) request.getParameter("chaptercode").trim();
		String platecode = (String) request.getParameter("platecode").trim();
		String registMan = (String) request.getParameter("registMan").trim();
		String paizhengman = (String) request.getParameter("paizhengman").trim();
		String leaderman = (String) request.getParameter("leaderman").trim();
		int userid = -1;
		log.info("Update UnitManage");
		model.setId(Integer.parseInt(id));
		model.setRegion(region);
		model.setRegionid(regionid);
		model.setUseunit(useunit);
		model.setResponsiblemen(responsiblemen);
		model.setLinktel(linktel);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setChaptercode(chaptercode);
		model.setPlatecode(platecode);
		model.setRegistman(registMan);
		model.setPaizhengman(paizhengman);
		model.setLeaderman(leaderman);
		model.setUserid(userid);
		if (serviceManager.getUnitManageService().updateModel(model)) {
			log.info("单位管理信息修改成功");
			response.getWriter().write("{success: true}");
		} else {
			response.getWriter().write("{errors:'单位管理信息修改失败，请重新尝试!'}");
		}
	}
	//删除数据
	public void delUnitManage(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
		log.debug("Del UnitManage");
		String roleJson = (String) request.getParameter("dellist").trim();
		JSONArray jsonArray = JSONArray.fromObject(roleJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			UnitManage model = (UnitManage)JSONObject.toBean(jsonObject,UnitManage.class);
			boolean isDelete = serviceManager.getUnitManageService().delModel(model);			
			if (!isDelete) {
				log.info("Err on delete UnitManage");
				response.getWriter().write("{failure:true,reason:'删除信息失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void findRecordById(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		UnitManage un=serviceManager.getUnitManageService().findUnitManageById(id);
		if(un!=null){
			response.getWriter().print(JSONObject.fromObject(un));
		}
	}
	
	public void getUnitTree(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int unitid=Integer.parseInt(request.getSession().getAttribute("unitid").toString().trim());
		UnitManage umuser=(UnitManage) request.getSession().getAttribute("userUnit");
		List<UnitManage> res=serviceManager.getUnitManageService().getAllModelList(umuser.getRegionid());
		List<UnitManage> City=new ArrayList();
		for(UnitManage um:res){
//			System.out.println(um.getRegion()+"::"+um.getRegionid());
			String uid[]=um.getRegionid().trim().split(",");
			boolean isc=false;
			for(UnitManage uml:City){
				if(uml.getRegionid().equals(um.getRegionid())){
					isc=true;
					break;
				}
			}
			if(uid.length==2&&(isc==false)){
				City.add(um);
			}
		}
		List<UnitManage> Town=new ArrayList();
		for(UnitManage um:res){
//			System.out.println(um.getRegion()+"::"+um.getRegionid());
			String uid[]=um.getRegionid().trim().split(",");
			boolean isc=false;
			for(UnitManage uml:Town){
				if(uml.getRegionid().equals(um.getRegionid())){
					isc=true;
					break;
				}
			}
			if(uid.length==3&&(isc==false)){
				Town.add(um);
			}
		}
//		List<UnitManage> street=new ArrayList();
//		for(UnitManage um:res){
//			String uid[]=um.getRegionid().trim().split(",");
//			if(uid.length==4){
//				street.add(um);
//			}
//		}
		String fregionid[]=umuser.getRegionid().split(",");
		String faregionid="";
		for(int i=0;i<fregionid.length-1;i++){
			faregionid+=fregionid[i]+",";
		}
		if(City.isEmpty()){
			City.add(serviceManager.getUnitManageService().getUnitManageByRegionid(faregionid).get(0));
		}
		String tree="";
		String townstr="";
		String streetstr="";
		for(UnitManage um:City){
//			tree+="{id:"+um.getId()+",text:'"+um.getUseunit()+"',children:[";
			tree+="{id:"+um.getId()+",text:'"+serviceManager.getRegionService().findRegionByID(Integer.parseInt((um.getRegionid().split(","))[um.getRegionid().split(",").length-1])).getCityname()+"',children:[";
			townstr="";
			int regionid=Integer.parseInt(um.getRegionid().split(",")[1]);
			for(UnitManage tum:Town){
				int tregionid=Integer.parseInt(tum.getRegionid().split(",")[1]);
				int tregionidleaf=Integer.parseInt(tum.getRegionid().split(",")[2]);
				if(regionid==tregionid){
//					townstr+="{id:"+tum.getId()+",text:'"+tum.getUseunit()+"',children:[";
					townstr+="{id:"+tum.getId()+",text:'"+serviceManager.getRegionService().findRegionByID(Integer.parseInt((tum.getRegionid().split(","))[tum.getRegionid().split(",").length-1])).getCityname()+"',children:[";
					streetstr="";
//					for(UnitManage sum:street){
//						int sregionid=Integer.parseInt(sum.getRegionid().split(",")[2]);
//						if(tregionidleaf==sregionid){
//							streetstr+="{id:"+sum.getId()+",text:'"+sum.getUseunit()+"',leaf:true},";
//						}
//					}
					if(!streetstr.equals("")){
						streetstr=streetstr.substring(0,streetstr.length()-1);
					}
					townstr=townstr+streetstr+"]},";
				}
			}
			if(!townstr.equals("")){
				townstr=townstr.substring(0,townstr.length()-1);
			}
			tree=tree+townstr+"]},";
		}
		tree="["+tree.substring(0,tree.length()-1)+"]";
		System.out.println(tree);
		response.getWriter().print(tree);
	}
	
}
