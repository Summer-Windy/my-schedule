package com.gongfutrip.schedule.mobile.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ScheduleConfig {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);
	
	private static Properties props = new Properties();
	private Resource[] locations;
	private boolean ignoreResourceNotFound = false;

	
	
//	public static final ScheduleConfig getInstance() throws IOException {
//		if(scheduleConfig == null){
//			synchronized (ScheduleConfig.class) {
//				if(scheduleConfig == null){
//					scheduleConfig = new ScheduleConfig();
//				}
//			}
//		}
//        return scheduleConfig; 
//    }
	
	public void setLocations(Resource... locations) throws IOException {
		this.locations = locations;
		//设置默认值
		ScheduleConfig.props.setProperty("mobile.orderLock.count", "10");
		ScheduleConfig.props.setProperty("mobile.orderLock.wait", "5");
		
		System.out.println("--------------------------------------------------------------------");
		if (this.locations != null) {
			for (Resource location : this.locations) {
				if (logger.isInfoEnabled()) {
					logger.info("Loading properties file from " + location);
				}
				try {
					PropertiesLoaderUtils.fillProperties(
							ScheduleConfig.props, new EncodedResource(location, "UTF-8"));
					System.out.println(ScheduleConfig.props.getProperty("mobile.orderLock.count"));
				}
				catch (IOException ex) {
					if (this.ignoreResourceNotFound) {
						if (logger.isWarnEnabled()) {
							logger.warn("Could not load properties from " + location + ": " + ex.getMessage());
						}
					}
					else {
						throw ex;
					}
				}
			}
		}
	}

	public static Properties getProps() {
		return props;
	}

	public static void setProps(Properties props) {
		ScheduleConfig.props = props;
	}

	public boolean isIgnoreResourceNotFound() {
		return ignoreResourceNotFound;
	}
	public void setIgnoreResourceNotFound(boolean ignoreResourceNotFound) {
		this.ignoreResourceNotFound = ignoreResourceNotFound;
	}
}
