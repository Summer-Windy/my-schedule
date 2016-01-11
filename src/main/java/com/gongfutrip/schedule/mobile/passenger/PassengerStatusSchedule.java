package com.gongfutrip.schedule.mobile.passenger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.gongfutrip.api.common.response.Result;
import com.gongfutrip.api.user.passenger.bean.UserPassenger;
import com.gongfutrip.api.user.passenger.interfaces.IPassengerService;

@Component
public class PassengerStatusSchedule {

	  private static Logger logger = org.slf4j.LoggerFactory.getLogger(PassengerStatusSchedule.class);


	  @Autowired
	  private IPassengerService iPassengerService;
	  
	    /**
	     * 从缓存刷新银行汇率，每3分钟刷新一次
	     */
//	    @Scheduled(cron = "0/2 * * * * ?")
	    public String refleshBankRate() {
	    	UserPassenger userPassenger = new UserPassenger();
			userPassenger.setUserID(12L);
			Result result = iPassengerService.query(userPassenger);
			System.out.println(JSON.toJSONString(result));
			logger.info("---------------------------------------------------");
			return JSON.toJSONString(result);
	    }

}
