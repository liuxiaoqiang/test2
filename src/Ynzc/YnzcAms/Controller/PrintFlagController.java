package Ynzc.YnzcAms.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import Ynzc.Util.DateTimeUtil;
import Ynzc.YnzcAms.Model.Certificate;
import Ynzc.YnzcAms.Model.PrintFlag;

public class PrintFlagController extends  BaseController{
	private final static Logger log = Logger.getLogger(PrintFlagController.class);
	//更新数据
	public void GetPrintFlag(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		int tractorinfoid = Integer.parseInt(request.getParameter("tractorinfoid").trim());
		int printType =  Integer.parseInt(request.getParameter("printType").trim());
		log.info("GetPrintFlag");
		
		PrintFlag printFlag=this.serviceManager.getPrintFlagService().GetPrintFlag(tractorinfoid, printType);
		if(printFlag!=null)
		{
			Date EndDate=printFlag.getPrintEndDate();
			//得到当前日期,查看当前日期是否已经过了设置的打印日期
			Date today=new Date();
			long day=(EndDate.getTime()-today.getTime())/(3600*24*1000);
			if(day>=0)
			{
				//有效
				response.getWriter().write("{success: true}");
			}
			else
			{
				//过期,将本条记录变为无效
				this.serviceManager.getPrintFlagService().DelPrintFlag(tractorinfoid, printType);
				response.getWriter().write("{success: false,reson:'时间已过，不可以进行打印'}");
			}
		}
		else
		{
			response.getWriter().write("{success: false,reson:'不可以进行打印'}");
		} 
	}
}
