package Ynzc.YnzcAms.Util;

import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class Task extends TimerTask{

	private ServiceManager serviceManager;
	private final static Logger log = Logger.getLogger(Task.class);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(this.serviceManager.getTractorInfoViewService().updateExpirydate()){
			log.info("数据库更新脱检数据成功于:"+new Date().toLocaleString());
		}else{
			log.info("数据库更新脱检数据失败于:"+new Date().toLocaleString());
		}
		if(this.serviceManager.getDrivingLicenceService().Expirydate()){
			log.info("数据库更新脱检数据成功于:"+new Date().toLocaleString());
		}else{
			log.info("数据库更新脱检数据失败于:"+new Date().toLocaleString());
		}
	}
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	public static Logger getLog() {
		return log;
	}

}
