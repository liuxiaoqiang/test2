package Ynzc.YnzcAms.Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.XmlWebApplicationContext;

public class TimerListener implements ServletContextListener
{
    
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        //TODO Auto-generated method stub
        
    }
    
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {     
    	XmlWebApplicationContext ctx = new XmlWebApplicationContext(); 
    	ctx.setConfigLocations(new String[] {"/WEB-INF/YnzcAms-hibernate.xml","/WEB-INF/YnzcAms-service.xml","/WEB-INF/YnzcAms-servlet.xml"}); 
    	ctx.setServletContext(servletContextEvent.getServletContext()); 
    	ctx.refresh(); 
    }
}
