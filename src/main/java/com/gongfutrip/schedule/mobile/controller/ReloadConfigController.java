package com.gongfutrip.schedule.mobile.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gongfutrip.schedule.mobile.config.ScheduleConfig;
@Controller
public class ReloadConfigController {
    private static Logger logger = LoggerFactory.getLogger(ReloadConfigController.class);

    @Autowired(required=false)
	private ScheduleConfig scheduleConfig;
    
    @ResponseBody
    @RequestMapping(value = "/reload/{count}/{waitTime}")
    public String shopping(HttpServletRequest request,@PathVariable("count") int count ,@PathVariable("waitTime") int waitTime) {
    	
    	scheduleConfig.getProps().setProperty("mobile.orderLock.count", String.valueOf(count));
    	scheduleConfig.getProps().setProperty("mobile.orderLock.wait", String.valueOf(waitTime));
    	logger.info("修改配置成功");
    	return "修改成功";
    }

}
