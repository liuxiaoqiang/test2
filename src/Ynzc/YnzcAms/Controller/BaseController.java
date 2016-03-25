package Ynzc.YnzcAms.Controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import Ynzc.YnzcAms.Service.Manager.ServiceManager;

public class BaseController extends MultiActionController{
	
	protected ServiceManager serviceManager;

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
}
