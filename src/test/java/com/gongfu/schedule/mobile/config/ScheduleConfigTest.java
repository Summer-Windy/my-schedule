package com.gongfu.schedule.mobile.config;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gongfutrip.schedule.mobile.config.ScheduleConfig;

public class ScheduleConfigTest {

	private ApplicationContext applicationContext;

	private ScheduleConfig scheduleConfig = null;
	
	@Before
	public void setUp() throws Exception {
		// 创建spring容器
		applicationContext = new ClassPathXmlApplicationContext("applicationContext-service.xml");
		scheduleConfig = applicationContext.getBean(ScheduleConfig.class);
	}
	
	@Test
	public void testConfig(){
		
//			ScheduleConfig scheduleConfig = ScheduleConfig.getInstance();
			Properties prop = scheduleConfig.getProps();
			if(scheduleConfig == null){
				System.out.println("为空");
			}
			System.out.println(prop.getProperty("mobile.orderLock.count"));
			prop.setProperty("mobile.orderLock.count", "肖兵兵重新设置值");
			System.out.println(prop.getProperty("mobile.orderLock.count"));
		
	}
}
