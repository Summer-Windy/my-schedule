package com.gongfutrip.schedule.mobile.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "mobile/order")
public class OrderController {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(OrderController.class);


	@RequestMapping(value = "test")
	public String test(HttpServletRequest request) {
		logger.info("mobile/order 控制器");
		System.out.println("test");
		return "test";
	}

	
	
}
