package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.PlateHandle;
import Ynzc.YnzcAms.Model.Uniteharvester;
import Ynzc.YnzcAms.Model.UniteharvesterMove;
import Ynzc.YnzcAms.Model.UniteharvesterMoveView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UniteharvesterMoveController extends  BaseController{
	public void getUniteharvesterMoveViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		if (request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if (request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		User us=(User)request.getSession().getAttribute("user");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<UniteharvesterMoveView> res = serviceManager.getUniteharvesterMoveService().getUniteharvesterMoveAll(page, condition, us.getId());
		JSONArray jsonItems = new JSONArray();
		for (UniteharvesterMoveView u : res) {
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
	public void addUniteharvesterMove(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterMove uniteharvesterMove=new UniteharvesterMove();
		int ids=Integer.parseInt(request.getSession().getAttribute("uniteharvesterid").toString());
		uniteharvesterMove.setHarvesterId(ids);
		uniteharvesterMove.setMoveAcceptunitName(request.getParameter("moveAcceptunitName"));
		uniteharvesterMove.setMoveApplicationtype(Integer.parseInt(request.getParameter("moveApplicationtype")));
		uniteharvesterMove.setMoveMark(Integer.parseInt(request.getParameter("moveMark")));
		uniteharvesterMove.setMoveNote(request.getParameter("moveNote"));
		uniteharvesterMove.setMoveRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("moveRegistdate").trim()));
		uniteharvesterMove.setMoveRegisterman(request.getParameter("moveRegisterman"));
		uniteharvesterMove.setMoveType(Integer.parseInt(request.getParameter("moveType")));
		uniteharvesterMove.setOldUnitname(request.getParameter("oldUnitname"));
		
		String reaperPlateNum=request.getParameter("reaperPlateNum").trim();
		String reaperPlateHead=request.getParameter("reaperPlateHead").trim();
		String reaperPlateUnitid=request.getParameter("reaperPlateUnitid").trim();
		
		PlateHandle plateHandle=new PlateHandle();
		plateHandle.setHandledate(new Date());
		plateHandle.setPlatehandle(8);
		plateHandle.setPlatenum(reaperPlateNum);
		plateHandle.setTypes(2);
		plateHandle.setUnitid(Integer.parseInt(reaperPlateUnitid));
		plateHandle.setUserid(us.getId());
		
		Uniteharvester uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterById(ids);
		int unoteid=Integer.parseInt(request.getParameter("unitid"));
		uniteharvester.setUnitid(unoteid);
		if(!serviceManager.getUniteharvesterService().saveUniteharvester(uniteharvester)){
			response.getWriter().write("{success:false,reason:'联合收割机变更登记失败'}");
			return;
		}
		if(serviceManager.getReaperPlateService().updateState(reaperPlateNum, reaperPlateHead, 7)){
			if(serviceManager.getUniteharvesterMoveService().addUniteharvesterMove(uniteharvesterMove)){
				serviceManager.getPlateHandleService().addPlateHandle(plateHandle);
				response.getWriter().write("{success:true,reason:'联合收割机转移登记成功'}");
			}else{
				response.getWriter().write("{success:false,reason:'联合收割机转移登记失败'}");
			}
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机转移登记失败:该号牌号码不存在，或信息有误！'}");
		}
	}
	public void updateUniteharvesterMove(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterMove uniteharvesterMove=new UniteharvesterMove();
		uniteharvesterMove.setHarvesterId(Integer.parseInt(request.getParameter("harvesterId")));
		uniteharvesterMove.setMoveAcceptunitName(request.getParameter("moveAcceptunitName"));
		uniteharvesterMove.setMoveApplicationtype(Integer.parseInt(request.getParameter("moveApplicationtype")));
		uniteharvesterMove.setMoveMark(Integer.parseInt(request.getParameter("moveMark")));
		uniteharvesterMove.setMoveNote(request.getParameter("moveNote"));
		uniteharvesterMove.setMoveRegistdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("moveRegistdate").trim()));
		uniteharvesterMove.setMoveRegisterman(request.getParameter("moveRegisterman"));
		uniteharvesterMove.setMoveType(Integer.parseInt(request.getParameter("moveType")));
		uniteharvesterMove.setOldUnitname(request.getParameter("oldUnitname"));
		uniteharvesterMove.setId(Integer.parseInt(request.getParameter("id")));
		
		Uniteharvester uniteharvester=serviceManager.getUniteharvesterService().findUniteharvesterById(Integer.parseInt(request.getParameter("harvesterId")));
		int unoteid=Integer.parseInt(request.getParameter("unitid"));
		uniteharvester.setUnitid(unoteid);
		if(!serviceManager.getUniteharvesterService().saveUniteharvester(uniteharvester)){
			response.getWriter().write("{success:false,reason:'联合收割机变更登记失败'}");
			return;
		}
		
		if(serviceManager.getUniteharvesterMoveService().updateUniteharvesterMove(uniteharvesterMove)){
			response.getWriter().write("{success:true,reason:'联合收割机转移登记信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机转移登记信息修改失败'}");
		}
	}
	public void deleteUniteharvesterMove(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String uniteharvestermoveJson = (String) request.getParameter("uniteharvestermovelist").trim();
		JSONArray jsonArray = JSONArray.fromObject(uniteharvestermoveJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			UniteharvesterMoveView uniteharvesterMoveview=(UniteharvesterMoveView)JSONObject.toBean(jsonObject, UniteharvesterMoveView.class);
			
			UniteharvesterMove uniteharvesterMove=new UniteharvesterMove();
			uniteharvesterMove.setHarvesterId(uniteharvesterMoveview.getId());
			uniteharvesterMove.setMoveAcceptunitName(uniteharvesterMoveview.getMoveAcceptunitName());
			uniteharvesterMove.setMoveApplicationtype(uniteharvesterMoveview.getMoveApplicationtype());
			uniteharvesterMove.setMoveMark(uniteharvesterMoveview.getMoveMark());
			uniteharvesterMove.setMoveNote(uniteharvesterMoveview.getMoveNote());
			uniteharvesterMove.setMoveRegistdate(uniteharvesterMoveview.getMoveRegistdate());
			uniteharvesterMove.setMoveRegisterman(uniteharvesterMoveview.getMoveRegisterman());
			uniteharvesterMove.setMoveType(uniteharvesterMoveview.getMoveType());
			uniteharvesterMove.setOldUnitname(uniteharvesterMoveview.getOldUnitname());
			uniteharvesterMove.setId(uniteharvesterMoveview.getMoveid());
			
			boolean isDelete = serviceManager.getUniteharvesterMoveService().delUniteharvesterMove(uniteharvesterMove);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'联合收割机转移登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
}
