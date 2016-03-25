package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.*;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class RegionController extends BaseController {

	private final static Logger log = Logger.getLogger(RegionController.class);

	public void getRegion(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Region City Tree");
		String tree = "";
		String regionid = request.getSession().getAttribute("regionid")
				.toString().trim();
		String region[] = regionid.split(",");
		if (region.length == 1) {
			List<Region> res = serviceManager.getRegionService()
					.getAllCityRegion();
			for (Region r : res) {
				tree += "{id:" + r.getId() + ",text:'" + r.getCityname()
						+ "',children:[]},";
			}
		}else{
			for(int i=1;i<region.length;i++){
				Region res=serviceManager.getRegionService().findRegionByID(Integer.parseInt(region[i].trim()));
				tree += "{id:" + res.getId() + ",text:'" + res.getCityname()
				+ "',children:[";
			}
			for(int i=1;i<region.length;i++){
				tree+="]}";
			}
			tree+=",";
		}
		if (tree == "") {
			tree = "{[]}";
		} else {
			tree = "[" + tree.substring(0, tree.length() - 1) + "]";
		}
		System.out.println(tree);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(tree);
	}

	// //////////////////////////////
	public void getCityRegion(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Region City Tree");
		String tree = "";
		User user = (User) request.getSession().getAttribute("user");
		List<Region> res = serviceManager.getRegionService().getCityRegion(
				user.getId());
		for (Region r : res) {
			tree += "{id:" + r.getId() + ",text:'" + r.getCityname()
					+ "',children:[]},";
		}
		if (tree == "") {
			tree = "{[]}";
		} else {
			tree = "[" + tree.substring(0, tree.length() - 1) + "]";
		}
		System.out.println(tree);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(tree);
	}

	public void getRegionForRegister(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Region City Tree");
		String tree = "";
		List<Region> res = serviceManager.getRegionService().getAllCityRegion();
		for (Region r : res) {
			tree += "{id:" + r.getId() + ",text:'" + r.getCityname()
					+ "',children:[]},";
		}
		if (tree == "") {
			tree = "{[]}";
		} else {
			tree = "[" + tree.substring(0, tree.length() - 1) + "]";
		}
		System.out.println(tree);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(tree);
	}

	public void getChild(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Region City ChildRoot");
		int fatherid = Integer
				.parseInt(request.getParameter("fatherid").trim());
		List<Region> res = serviceManager.getRegionService()
				.getRegionByFatherID(fatherid);
		String tree = "";
		boolean isleaf = false;
		for (Region r : res) {
			if (r.getTreelevel() == 4) {
				isleaf = true;
			}
			tree += "{id:" + r.getId() + ",text:'" + r.getCityname()
					+ "',leaf:" + isleaf + "},";
		}
		if (tree == "") {
			tree = "{[]}";
		} else {
			tree = "{data:[" + tree.substring(0, tree.length() - 1) + "]}";
		}
		System.out.println(tree);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(tree);
	}

	public void addRegionNode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Add a Region Node");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String cityname = request.getParameter("cityname").trim();
		String citycode = request.getParameter("citycode").trim();
		String cityno = request.getParameter("cityno").trim();
		String citypost = request.getParameter("citypost").trim();
		int nodeid = Integer.parseInt(request.getParameter("nodeid").trim());
		Region fr = serviceManager.getRegionService().findRegionByID(nodeid);
		Region r = new Region();
		r.setCityname(cityname);
		r.setCitycode(citycode);
		r.setCityno(cityno);
		r.setCitypost(citypost);
		r.setFatherid(nodeid);
		r.setTreelevel(fr.getTreelevel() + 1);
		boolean isleaf = false;
		if (fr.getTreelevel() + 1 == 4) {
			isleaf = true;
		}
		if (!serviceManager.getRegionService().addRegion(r)) {
			log.info("Add a Region Error");
			response.getWriter().print("{success:false}");
		}
		response.getWriter().print(
				"{success:true,newID:" + r.getId() + ",isleaf:" + isleaf + "}");
	}

	public void delRegionNode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Del Region Node");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		boolean isleaf = Boolean.valueOf(request.getParameter("isleaf").trim());
		int nodeid = Integer.parseInt(request.getParameter("nodeid").trim());
		if (isleaf) {
			serviceManager.getRegionService().delRegion(
					serviceManager.getRegionService().findRegionByID(nodeid));
		} else {
			List<Region> res = serviceManager.getRegionService()
					.getRegionByFatherID(nodeid);
			for (Region r : res) {
				serviceManager.getRegionService().delRegion(r);
			}
			serviceManager.getRegionService().delRegion(
					serviceManager.getRegionService().findRegionByID(nodeid));
		}
		response.getWriter().print("{success:true}");
	}

	public void getRegionStr(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("get Region String");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String nodeidStr = request.getParameter("nodeid").trim();
		int nodeid = Integer.parseInt(nodeidStr);
		Region r = serviceManager.getRegionService().findRegionByID(nodeid);
		String result = r.getCityname();
		String idList = "," + r.getId();
		if (r.getTreelevel() != 1) {
			for (int i = 0; i < r.getTreelevel(); i++) {
				r = serviceManager.getRegionService().findRegionByID(
						r.getFatherid());
				result = r.getCityname() + result;
				idList = "," + r.getId() + idList;
			}
		}
		response.getWriter().print(
				"{success:true,str:'云南省" + result + "',idstr:'0,"
						+ idList.substring(1) + "'}");
	}

}
