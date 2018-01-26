package com.smart.core.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.smart.consts.AppConfig;

public class PreServerInitListener implements ServletContextListener {
	
	protected static Logger logger = Logger.getLogger(PreServerInitListener.class);
    
	public PreServerInitListener() {}

    @Override
	public void contextInitialized(ServletContextEvent sce) {
    	String path = sce.getServletContext().getRealPath("/");
    	AppConfig.CONTEXT_PATH = path;
    	logger.info("AppConfig: " + AppConfig.getAppConfigString());
    }

    @Override
	public void contextDestroyed(ServletContextEvent sce) { }
    
}
