package Ynzc.YnzcAms.Controller;
/**
 * 验证目录
 * @author zy
 * @date 2011-04-18
 * class ValidateListController.java
 */
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.ValidateList;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;
import Ynzc.YnzcAms.Util.FieldsAndQueryToCondition;

public class ValidateListController extends BaseController{

	private final static Logger log = Logger.getLogger(ValidateListController.class);
	
	public void getValidateList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String start = null;
		String limit = null;
		if ((String) request.getParameter("start").trim() != null) {
			start = (String) request.getParameter("start").trim();
		}
		if ((String) request.getParameter("limit").trim() != null) {
			limit = (String) request.getParameter("limit").trim();
		}
		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
		String fields = request.getParameter("fields");
		String query = request.getParameter("query");
		String condition = "";
		if (fields != null && query != null) {
			condition = new FieldsAndQueryToCondition().FieldsAndQueryToCondition(fields, query);
		}
		List<ValidateList> res = serviceManager.getValidateListService().getAllValidateList(page,condition);
		JSONArray jsonItems = new JSONArray();
		for (ValidateList v : res) {
			jsonItems.add(JSONObject.fromObject(v));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		jsonBack.put("totalCount", page.getTotalCount());
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}

	public void addValidateList(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		ValidateList model=new ValidateList();
		model.setDirNo(request.getParameter("dirNo").trim());
		model.setRegisterDate(Date.valueOf(request.getParameter("registerDate").trim()));
		model.setMachineType(request.getParameter("machineTypeId").trim());
		model.setMachineNo(request.getParameter("machineNo").trim());
		model.setProductor(request.getParameter("productor").trim());
		model.setCarColor(request.getParameter("carColor").trim());
		model.setLicense(request.getParameter("license").trim());
		model.setProductorAddress(request.getParameter("productorAddress").trim());
		model.setProductorPost(request.getParameter("productorPost").trim());
		model.setProductorSeller(request.getParameter("productorSeller").trim());
		model.setProductorTel(request.getParameter("productorTel").trim());
		model.setSellerTelephone(request.getParameter("sellerTelephone").trim());
		model.setPhotoDir(request.getParameter("photoDir").trim());
		model.setSetRow(request.getParameter("setRow").trim());
		model.setIsAuto(request.getParameter("isAuto").trim());
		model.setShapeSize(request.getParameter("shapeSize").trim());
		model.setContainerSize(request.getParameter("containerSize").trim());
		model.setAxisSize(request.getParameter("axisSize").trim());
		model.setPower(request.getParameter("power").trim());
		model.setWheelSize(request.getParameter("wheelSize").trim());
		model.setDrivers(request.getParameter("drivers").trim());
		model.setDirectControl(request.getParameter("directControl").trim());
		model.setTopSpeed(request.getParameter("topSpeed").trim());
		model.setFuelTypeId(Integer.valueOf(request.getParameter("fuelTypeId").trim()));
		model.setFuelCost(request.getParameter("fuelCost").trim());
		model.setWheelNo(request.getParameter("wheelNo").trim());
		model.setAllQuality(Integer.valueOf(request.getParameter("allQuality").trim()));
		model.setTiresSize(request.getParameter("tiresSize").trim());
		model.setTotalQuality(Integer.valueOf(request.getParameter("totalQuality").trim()));
		model.setLoadQuality(Integer.valueOf(request.getParameter("loadQuality").trim()));
		model.setDriverInNo(Integer.valueOf(request.getParameter("driverInNo").trim()));
		model.setTilt(request.getParameter("tilt").trim());
		model.setEngineBrandId(Integer.valueOf(request.getParameter("engineBrandId").trim()));
		model.setSteelSpring(Integer.valueOf(request.getParameter("steelSpring").trim()));
		if(serviceManager.getValidateListService().findValidateListByDirNo(model.getDirNo())==null){
			if(!serviceManager.getValidateListService().addValidateList(model)){
				response.getWriter().write("{failure:true,reason:'添加验证目录失败'}");
			}
			response.getWriter().write("{success: true}");
		}else{
			response.getWriter().write("{success:false}");
		}
	}
	
	public void delValidateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String validateListJson = (String) request.getParameter("id").trim();
		JSONArray jsonArray = JSONArray.fromObject(validateListJson);
		Iterator iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = JSONObject.fromObject(iterator.next());
			ValidateList model=(ValidateList)JSONObject.toBean(jsonObject, ValidateList.class);
			boolean isDelete = serviceManager.getValidateListService().delValidateList(model);
			if (!isDelete) {
				log.info("Err on delete ValidateList");
				response.getWriter().write("{failure:true,reason:'不存在要删除的验证目录'}");
			}
		}
		response.getWriter().write("{success: true}");
	}
	
	public void updateValidateList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id").trim());
		ValidateList model=serviceManager.getValidateListService().findValidateListById(id);
		model.setDirNo(request.getParameter("dirNo").trim());
		model.setRegisterDate(Date.valueOf(request.getParameter("registerDate").trim()));
		model.setMachineType(request.getParameter("machineTypeId").trim());
		model.setMachineNo(request.getParameter("machineNo").trim());
		model.setProductor(request.getParameter("productor").trim());
		model.setCarColor(request.getParameter("carColor").trim());
		model.setLicense(request.getParameter("license").trim());
		model.setProductorAddress(request.getParameter("productorAddress").trim());
		model.setProductorPost(request.getParameter("productorPost").trim());
		model.setProductorSeller(request.getParameter("productorSeller").trim());
		model.setProductorTel(request.getParameter("productorTel").trim());
		model.setSellerTelephone(request.getParameter("sellerTelephone").trim());
		model.setPhotoDir(request.getParameter("photoDir").trim());
		model.setSetRow(request.getParameter("setRow").trim());
		model.setIsAuto(request.getParameter("isAuto").trim());
		model.setShapeSize(request.getParameter("shapeSize").trim());
		model.setContainerSize(request.getParameter("containerSize").trim());
		model.setAxisSize(request.getParameter("axisSize").trim());
		model.setPower(request.getParameter("power").trim());
		model.setWheelSize(request.getParameter("wheelSize").trim());
		model.setDrivers(request.getParameter("drivers").trim());
		model.setDirectControl(request.getParameter("directControl").trim());
		model.setTopSpeed(request.getParameter("topSpeed").trim());
		model.setFuelTypeId(Integer.valueOf(request.getParameter("fuelTypeId").trim()));
		model.setFuelCost(request.getParameter("fuelCost").trim());
		model.setWheelNo(request.getParameter("wheelNo").trim());
		model.setAllQuality(Integer.valueOf(request.getParameter("allQuality").trim()));
		model.setTiresSize(request.getParameter("tiresSize").trim());
		model.setTotalQuality(Integer.valueOf(request.getParameter("totalQuality").trim()));
		model.setLoadQuality(Integer.valueOf(request.getParameter("loadQuality").trim()));
		model.setDriverInNo(Integer.valueOf(request.getParameter("driverInNo").trim()));
		model.setTilt(request.getParameter("tilt").trim());
		model.setEngineBrandId(Integer.valueOf(request.getParameter("engineBrandId").trim()));
		model.setSteelSpring(Integer.valueOf(request.getParameter("steelSpring").trim()));
		if(!serviceManager.getValidateListService().updateValidateList(model)){
			response.getWriter().write("{failure:true,reason:'更新验证目录失败'}");
		}
		response.getWriter().write("{success: true}");
	}
	
	public void getAllValidateList(HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<ValidateList> res = serviceManager.getValidateListService().getAllModelList();
		JSONArray jsonItems = new JSONArray();
		for (ValidateList r : res) {
			jsonItems.add(JSONObject.fromObject(r));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("ValidateList", jsonItems);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void getValidateListById(HttpServletRequest request, HttpServletResponse response)throws Exception{
		int id = Integer.valueOf(request.getParameter("id").trim().toString());
		ValidateList res = serviceManager.getValidateListService().findValidateListById(id);
		JSONArray jsonItems = new JSONArray();
		if (res != null) {
			jsonItems.add(JSONObject.fromObject(res));
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", jsonItems);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
	
	public void findRecordById(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id").trim());
		ValidateList eb=serviceManager.getValidateListService().findValidateListById(id);
		if(eb!=null){
			response.getWriter().print(JSONObject.fromObject(eb));
		}
	}
	
}
