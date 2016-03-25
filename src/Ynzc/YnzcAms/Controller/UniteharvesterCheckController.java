package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.UniteharvesterCheck;
import Ynzc.YnzcAms.Model.UniteharvesterCheckView;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class UniteharvesterCheckController extends  BaseController{
	public void getUniteharvesterCheckViewAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
		List<UniteharvesterCheckView> res = serviceManager.getUniteharvesterCheckService().getUniteharvesterCheckAll(page, condition, us.getId());
		JSONArray jsonItems = new JSONArray();
		for (UniteharvesterCheckView u : res) {
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
	public void addUniteharvesterCheck(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterCheck uniteharvesterCheck=new UniteharvesterCheck();
		uniteharvesterCheck.setCheckDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkDate").trim()));
		uniteharvesterCheck.setCheckLingDaodate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkLingDaodate").trim()));
		uniteharvesterCheck.setCheckLingDaoMan(request.getParameter("checkLingDaoMan"));
		uniteharvesterCheck.setCheckLiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkLiveDate").trim()));
		uniteharvesterCheck.setCheckman(request.getParameter("checkman"));
		uniteharvesterCheck.setCheckPaizhengDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkPaizhengDate").trim()));
		uniteharvesterCheck.setCheckPaizhengMan(request.getParameter("checkPaizhengMan"));
		uniteharvesterCheck.setCheckRegisterdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkRegisterdate").trim()));
		uniteharvesterCheck.setCheckRegisterMan(request.getParameter("checkRegisterMan"));
		uniteharvesterCheck.setCheckResult(request.getParameter("checkResult"));
		uniteharvesterCheck.setCheckUnitName(request.getParameter("checkUnitName"));
		int ids=Integer.parseInt(request.getSession().getAttribute("uniteharvesterid").toString());
		uniteharvesterCheck.setHarvesterId(ids);
		uniteharvesterCheck.setInsuranceType(Integer.parseInt(request.getParameter("insuranceType")));
		uniteharvesterCheck.setInsuranceCode(request.getParameter("insuranceCode"));
		uniteharvesterCheck.setInsurancedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insurancedate").trim()));
		uniteharvesterCheck.setInsuranceLivedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insurceActiveDate").trim()));
		uniteharvesterCheck.setInsuranceName(request.getParameter("insuranceName"));
		if(serviceManager.getUniteharvesterCheckService().addUniteharvesterCheck(uniteharvesterCheck)){
			response.getWriter().write("{success:true,reason:'联合收割机年检登记成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机年检登记失败'}");
		}
	}
	public void updateUniteharvesterCheck(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User us=(User)request.getSession().getAttribute("user");
		UniteharvesterCheck uniteharvesterCheck=new UniteharvesterCheck();
		uniteharvesterCheck.setCheckDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkDate").trim()));
		uniteharvesterCheck.setCheckLingDaodate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkLingDaodate").trim()));
		uniteharvesterCheck.setCheckLingDaoMan(request.getParameter("checkLingDaoMan"));
		uniteharvesterCheck.setCheckLiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkLiveDate").trim()));
		uniteharvesterCheck.setCheckman(request.getParameter("checkman"));
		uniteharvesterCheck.setInsuranceType(Integer.parseInt(request.getParameter("insuranceType")));
		uniteharvesterCheck.setCheckPaizhengDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkPaizhengDate").trim()));
		uniteharvesterCheck.setCheckPaizhengMan(request.getParameter("checkPaizhengMan"));
		uniteharvesterCheck.setCheckRegisterdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("checkRegisterdate").trim()));
		uniteharvesterCheck.setCheckRegisterMan(request.getParameter("checkRegisterMan"));
		uniteharvesterCheck.setCheckResult(request.getParameter("checkResult"));
		uniteharvesterCheck.setCheckUnitName(request.getParameter("checkUnitName"));
		uniteharvesterCheck.setHarvesterId(Integer.parseInt(request.getParameter("harvesterId")));
		uniteharvesterCheck.setInsuranceCode(request.getParameter("insuranceCode"));
		uniteharvesterCheck.setInsurancedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insurancedate").trim()));
		uniteharvesterCheck.setInsuranceLivedate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("insurceActiveDate").trim()));
		uniteharvesterCheck.setInsuranceName(request.getParameter("insuranceName"));
		uniteharvesterCheck.setId(Integer.parseInt(request.getParameter("id")));
		if(serviceManager.getUniteharvesterCheckService().updateUniteharvesterCheck(uniteharvesterCheck)){
			response.getWriter().write("{success:true,reason:'联合收割机年检登记信息修改成功'}");
		}else{
			response.getWriter().write("{success:false,reason:'联合收割机年检登记信息修改失败'}");
		}
	}
	public void deleteUniteharvesterCheck(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String uniteharvestercheckJson = (String) request.getParameter("uniteharvesterchecklist").trim();
		JSONArray jsonArray = JSONArray.fromObject(uniteharvestercheckJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			UniteharvesterCheckView uniteharvesterCheckView=(UniteharvesterCheckView)JSONObject.toBean(jsonObject, UniteharvesterCheckView.class);
			UniteharvesterCheck uniteharvesterCheck=new UniteharvesterCheck();
			
			uniteharvesterCheck.setCheckDate(uniteharvesterCheckView.getCheckDate());
			uniteharvesterCheck.setCheckLingDaodate(uniteharvesterCheckView.getCheckLingDaodate());
			uniteharvesterCheck.setCheckLingDaoMan(uniteharvesterCheckView.getCheckLingDaoMan());
			uniteharvesterCheck.setCheckLiveDate(uniteharvesterCheckView.getCheckLiveDate());
			uniteharvesterCheck.setCheckman(uniteharvesterCheckView.getCheckman());
			uniteharvesterCheck.setInsuranceType(uniteharvesterCheckView.getInsuranceType());
			uniteharvesterCheck.setCheckPaizhengDate(uniteharvesterCheckView.getCheckPaizhengDate());
			uniteharvesterCheck.setCheckPaizhengMan(uniteharvesterCheckView.getCheckPaizhengMan());
			uniteharvesterCheck.setCheckRegisterdate(uniteharvesterCheckView.getCheckRegisterdate());
			uniteharvesterCheck.setCheckRegisterMan(uniteharvesterCheckView.getCheckRegisterMan());
			uniteharvesterCheck.setCheckResult(uniteharvesterCheckView.getCheckResult());
			uniteharvesterCheck.setCheckUnitName(uniteharvesterCheckView.getCheckUnitName());
			uniteharvesterCheck.setHarvesterId(uniteharvesterCheckView.getId());
			uniteharvesterCheck.setInsuranceCode(uniteharvesterCheckView.getInsuranceCode());
			uniteharvesterCheck.setInsurancedate(uniteharvesterCheckView.getInsurancedate());
			uniteharvesterCheck.setInsuranceLivedate(uniteharvesterCheckView.getInsuranceLivedate());
			uniteharvesterCheck.setInsuranceName(uniteharvesterCheckView.getInsuranceName());
			uniteharvesterCheck.setId(uniteharvesterCheckView.getCheckid());
			
			boolean isDelete = serviceManager.getUniteharvesterCheckService().delUniteharvesterCheck(uniteharvesterCheck);
			if (!isDelete) {
				response.getWriter().write("{failure:true,reason:'联合收割机年检登记信息删除失败'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
}
