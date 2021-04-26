package com.jaktyInfoTech.springbootactuator.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMetric implements HealthIndicator {

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		Health health = null;
		health = checkInternet() == true ? Health.up().withDetail("SUCCESS CODE", "Active Internet").build()
				: Health.down().withDetail("ERROR CODE", "Internet is down").build();
		return health;
	}

	private boolean checkInternet() {
		boolean flag = false;
		try {
			URL url = new URL("https://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
