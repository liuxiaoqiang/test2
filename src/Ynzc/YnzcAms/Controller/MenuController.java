package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Model.Menu;
import Ynzc.YnzcAms.Model.PermissionsView;
import Ynzc.YnzcAms.Model.User;
 
public class MenuController extends BaseController {
	private final static Logger log = Logger.getLogger(MenuController.class);

	public void getModule(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Menu Module");
		User user = (User) request.getSession().getAttribute("user");
		List<Menu> resOne = serviceManager.getMenuService().getAllModule();
		List<Menu> resTwo = serviceManager.getMenuService().getAllRoot();
		List<PermissionsView> resThree = new ArrayList();
		String roleidList[] = user.getRoleid().split(",");
		for (int i = 0; i < roleidList.length; i++) {
			resThree.addAll(serviceManager.getRoleService()
					.getPermissionsByRoleID(Integer.parseInt(roleidList[i])));
		}
		String tree = "[";
		String script = "[";
		List<Menu> Module = new ArrayList();
		List<Menu> Root = new ArrayList();
		List<PermissionsView> temp = new ArrayList();
		for (Menu m : resTwo) {
			for (PermissionsView p : resThree) {
				if (p.getFatherid() == m.getId()) {
					Root.add(m);
					break;
				}
			}
		}
		for (Menu mm : resOne) {
			for (Menu mr : Root) {
				if (mr.getFatherid() == mm.getId()) {
					Module.add(mm);
					break;
				}
			}
		}
		for (Menu mm : Module) {
			temp.clear();
			String children = "";
			for (Menu mr : Root) {
				if (mm.getId() != mr.getFatherid()) {
					continue;
				}
				String son = "";
				for (PermissionsView p : resThree) {
					if (mr.getId() != p.getFatherid()) {
						continue;
					}
					temp.add(p);
					son += "{id:'" + p.getMenucode() + "',text:'" + p.getMenu()
							+ "',iconCls:'icon-" + p.getMenucode()
							+ "',leaf:true},";
				}
				if (son != "") {
					son = son.substring(0, son.length() - 1);
				}
				children += "{id:'" + mr.getMenucode() + "',text:'"
						+ mr.getMenu() + "',expanded:false,iconCls:'icon-"
						+ mr.getMenucode() + "',children:[" + son + "]},";
			}
			if (children != "") {
				children = children.substring(0, children.length() - 1);
			}
			String listenerEvent = "";
			for (PermissionsView p : temp) {
				if (!p.getJsname().equals("无")) {
					String[] sArray = p.getJsname().split(",");
					for (int i = 0; i < sArray.length; i++) {
						script += "{src:'" + request.getContextPath()
								+ "/Public/Scripts/Main/" + sArray[i]
								+ ".js'},";
						System.out.println("{src:'" + request.getContextPath()
								+ "/Public/Scripts/Main/" + sArray[i]
								+ ".js'},");
					}
					listenerEvent += "if(node.id=='" + p.getMenucode()
							+ "'){tab=tabpanel.add(new Ynzc.manage."
							+ sArray[0] + "({id:node.id,iconCls:'icon-"
							+ p.getMenucode()
							+ "',title:node.text,closable:true}))}else ";
					System.out.println("if(node.id=='" + p.getMenucode()
							+ "'){tab=tabpanel.add(new Ynzc.manage."
							+ sArray[0] + "({id:node.id,iconCls:'icon-"
							+ p.getMenucode()
							+ "',title:node.text,closable:true}))}else ");
				}
			}
			listenerEvent += "{tab=tabpanel.add({id:node.id,title:node.text,html:'功能开发中....',closable:true})}";
			tree += "{title:'"
					+ mm.getMenu()
					+ "',id:'menu"
					+ mm.getId()
					+ "',layout:'fit',items:[{xtype:'treepanel',autoScroll:true,border:false,loader:new Ext.tree.TreeLoader(),root:new Ext.tree.AsyncTreeNode({id:'"
					+ mm.getMenucode()
					+ "',text:'"
					+ mm.getMenu()
					+ "',iconCls:'icon-"
					+ mm.getMenucode()
					+ "',expanded:true,children:["
					+ children
					+ "]}),listeners:{'click':function(node,event){event.stopEvent();var tabpanel=Ext.getCmp('tab');var tab=Ext.getCmp(node.id);var title=node.text;if(node.leaf==true){if(!tab){"
					+ listenerEvent + "}tabpanel.setActiveTab(tab);}}}}]},";
		}
		if (!tree.equals("[")) {
			tree = tree.substring(0, tree.length() - 1) + "]";
		} else {
			tree = tree + "]";
		}
		if (script != "[") {
			script = script.substring(0, script.length() - 1) + "]";
		} else {
			script = script + "]";
		}
		tree = "{tree:" + tree + ",script:" + script + "}";
		System.out.println(tree);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(tree);
	}

	public void getModuleList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Module List");
		List<Menu> res = serviceManager.getMenuService().getAllModule();
		JSONArray jsonItems = new JSONArray();
		for (Menu r : res) {
			jsonItems.add(JSONObject.fromObject(r));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("Module", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void getAllMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		System.out.println("Get Menu For PermissionsWin");
		User user = (User) request.getSession().getAttribute("user");
		JSONArray jsonItems = new JSONArray();
		if (user.getUsername().equals("admin")) {
			List<Menu> Module = serviceManager.getMenuService().getAllModule();
			List<Menu> Root = serviceManager.getMenuService().getAllRoot();
			List<Menu> Leaf = serviceManager.getMenuService().getAllLeaf();
			for (Menu ml : Leaf) {
				for (Menu mr : Root) {
					if (ml.getFatherid() == mr.getId()) {
						for (Menu mm : Module) {
							if (mr.getFatherid() == mm.getId()) {
								ml.setMenu("[" + mm.getMenu() + "]["
										+ mr.getMenu() + "]" + ml.getMenu());
								if (request.getParameter("fatherid") != null) {
									if (mm.getId() != Integer.parseInt(request
											.getParameter("fatherid").trim())) {
										continue;
									}
								}
								jsonItems.add(JSONObject.fromObject(ml));
								break;
							}
						}
						break;
					}
				}
			}
		}else{
			List<PermissionsView> Per = new ArrayList();
			String roleidList[] = user.getRoleid().split(",");
			for (int i = 0; i < roleidList.length; i++) {
				Per.addAll(serviceManager.getRoleService().getPermissionsByRoleID(Integer.parseInt(roleidList[i])));
			}
			List<Menu> Root = serviceManager.getMenuService().getAllRoot();
			List<Menu> Module = serviceManager.getMenuService().getAllModule();
			for (PermissionsView p : Per) {
				for (Menu mr : Root) {
					if (p.getFatherid() == mr.getId()) {
						for (Menu mm : Module) {
							if (mr.getFatherid() == mm.getId()) {
								Menu ms=new Menu();
								ms.setId(p.getMenuid());
								ms.setMenu("[" + mm.getMenu() + "][" + mr.getMenu()+ "]" + p.getMenu());
								if (request.getParameter("fatherid") != null) {
									if (mm.getId() != Integer.parseInt(request.getParameter("fatherid").trim())) {
										continue;
									}
								}
								jsonItems.add(JSONObject.fromObject(ms));
								break;
							}
						}
						break;
					}
				}
			}
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("Menu", jsonItems);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

}
