package com.gongfu.schedule.mobile.order;

import java.net.MalformedURLException;

import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.gongfutrip.api.user.passenger.bean.UserPassenger;
import com.gongfutrip.api.user.passenger.interfaces.IPassengerService;

public class HessianTest {

	@Test
	public void test() {

		String url = "http://localhost:8080/remote/iPassengerService";
		HessianProxyFactory factory = new HessianProxyFactory();
		IPassengerService math = null;
		try {
			math = (IPassengerService) factory.create(IPassengerService.class, url);
		} catch (MalformedURLException e) {
			System.out.println("occur exception: " + e);
		}
		UserPassenger userPassenger =new UserPassenger();
		userPassenger.setPassengerID(12L);
		System.out.println("3 + 2 = " + math.query(userPassenger));
	}

}
