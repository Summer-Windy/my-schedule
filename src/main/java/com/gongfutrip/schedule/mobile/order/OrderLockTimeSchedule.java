package com.gongfutrip.schedule.mobile.order;

import java.util.Properties;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gongfutrip.api.order.interfaces.IOrderLockTimeService;
import com.gongfutrip.schedule.mobile.config.ScheduleConfig;

@Component
public class OrderLockTimeSchedule {

	  	private static Logger logger = org.slf4j.LoggerFactory.getLogger(OrderLockTimeSchedule.class);
	  
		@Autowired
		private IOrderLockTimeService iOrderLockTimeService;
		
		@Autowired
		private ScheduleConfig scheduleConfig;
	  
	    @Scheduled(cron = "0/5 * * * * ?")
	    public void scheduleOrderLockTimeHandle() {
	    	orderLockTimeHandle();
	    	System.out.println("orderLockTimeHandle");
	    	logger.info("---------------------------------------------------");
	    	
	    }
	    
	    public String orderLockTimeHandle(){
			if(scheduleConfig == null){
				System.out.println("为空");
			}
			System.out.println(scheduleConfig.getProps().getProperty("mobile.orderLock.count"));
			
			int count = Integer.valueOf(scheduleConfig.getProps().getProperty("mobile.orderLock.count"));
			int waitTime = Integer.valueOf(scheduleConfig.getProps().getProperty("mobile.orderLock.wait"));
			iOrderLockTimeService.orderLockTimeHandle(count,waitTime);
			return "处理队列任务";
		}

}
