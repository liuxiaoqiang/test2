package Ynzc.YnzcAms.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Model.TechnicalParameters;
import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class TechnicalParametersController extends  BaseController{
	
	private final static Logger log = Logger.getLogger(TechnicalParametersController.class);
	
	//添加拖拉机技术参数信息
	public void addTechnicalParameters(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		String machinebodycolor = (String) request.getParameter("machinebodycolor").trim();//技术参数信息：机身颜色
		String directcontrol = (String) request.getParameter("directcontrol").trim();//技术参数信息：转向形式
 		int enginebrandid = Integer.parseInt(request.getParameter("enginebrandid").trim());//技术参数信息：发动机品牌ID
		int fueltypeid = Integer.parseInt(request.getParameter("fueltypeid").trim());//技术参数信息：燃料种类ID
		int tiresno = Integer.parseInt(request.getParameter("tiresno").trim());//技术参数信息：轮胎数
		int totalquality = Integer.parseInt(request.getParameter("totalquality").trim());//技术参数信息：总质量
		int allowdragtotalquality = Integer.parseInt(request.getParameter("allowdragtotalquality").trim());//技术参数信息：准牵引总质量
		int vicecartiresno = Integer.parseInt(request.getParameter("vicecartiresno").trim());//技术参数信息：挂车轮胎数
		String outsize=(String)request.getParameter("outsize").trim();//技术参数信息：外轮廓尺寸
		String containersize=(String)request.getParameter("containersize").trim();//技术参数信息：货箱内尺寸
		String power=(String)request.getParameter("power").trim();//技术参数信息：功率
		int cylinderno=Integer.parseInt(request.getParameter("cylinderno").trim());//技术参数信息：缸数
		int wheelno=Integer.parseInt(request.getParameter("wheelno").trim());//技术参数信息：轴数
		String tiressize=(String)request.getParameter("tiressize").trim();//技术参数信息：轮胎规格
		int allquality=Integer.parseInt(request.getParameter("allquality").trim());//技术参数信息：整备质量
		int driverinno=Integer.parseInt(request.getParameter("driverinno").trim());//技术参数信息：驾驶室人数
		String outcarwheeldis=(String)request.getParameter("outcarwheeldis").trim();//技术参数信息：挂车轮距
		String wheelbase=(String)request.getParameter("wheelbase").trim();//技术参数信息：轴距
		String wheeldis=(String)request.getParameter("wheeldis").trim();//技术参数信息：轮距
		int ratifiedload=Integer.parseInt(request.getParameter("ratifiedload").trim());//技术参数信息：核定载质量
		int steelspring=Integer.parseInt(request.getParameter("steelspring").trim());//技术参数信息：钢板弹簧片数
		String outcartiressize=(String)request.getParameter("outcartiressize").trim();//技术参数信息：挂车轮胎规格
		int tractorinfoId=Integer.parseInt(request.getSession().getAttribute("tractorInfoId").toString());
		
		log.info("Add new TechnicalParameters:[machinebodycolor:"+machinebodycolor+"、directcontrol："+directcontrol+"、enginebrandid："+enginebrandid+"]");
		TechnicalParameters model=new TechnicalParameters();
		model.setMachinebodycolor(machinebodycolor);
		model.setDirectcontrol(directcontrol);
		model.setEnginebrandid(enginebrandid);
		model.setFueltypeid(fueltypeid);
		model.setTiresno(tiresno);
		model.setTotalquality(totalquality);
		model.setAllowdragtotalquality(allowdragtotalquality);
		model.setVicecartiresno(vicecartiresno);
		model.setOutsize(outsize);
		model.setContainersize(containersize);
		model.setPower(power);
		model.setCylinderno(cylinderno);
		model.setWheelno(wheelno);
		model.setTiressize(tiressize);
		model.setAllquality(allquality);
		model.setDriverinno(driverinno);
		model.setOutcarwheeldis(outcarwheeldis);
		model.setWheelbase(wheelbase);
		model.setWheeldis(wheeldis);
		model.setRatifiedload(ratifiedload);
		model.setSteelspring(steelspring);
		model.setOutcartiressize(outcartiressize);
		model.setTractorinfoId(tractorinfoId);
		
		if (serviceManager.getTechnicalParametersService().addTechnicalParameters(model)) {
			log.info("添加技术参数信息信息成功");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			//response.getWriter().write("{success: true}");
		} else {
			//response.getWriter().write("{errors:'添加证件类型失败，请重新尝试!'}");
		}
	}
	}
