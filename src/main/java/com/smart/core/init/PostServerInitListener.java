package com.smart.core.init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.smart.core.SpringContext;

public class PostServerInitListener implements ServletContextListener {
	
	protected static Logger logger = Logger.getLogger(PostServerInitListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Data Initializing...");
		Map<String, DataInitializeService> serviceMap = SpringContext.getBeans(DataInitializeService.class);
		Collection<DataInitializeService> collection = serviceMap.values();
		List<DataInitializeService> list = new ArrayList<DataInitializeService>();

		for (DataInitializeService service : collection) {
			list.add(service);
		}
		Collections.sort(list);

		try {
			for (DataInitializeService service : list) {
				service.initData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
