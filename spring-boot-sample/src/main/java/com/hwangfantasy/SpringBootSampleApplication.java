package com.hwangfantasy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hwangfantasy")
public class SpringBootSampleApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootSampleApplication.class);
	public static void main(String[] args) {
		LOGGER.error(MarkerFactory.getMarker("NOTIFY_ADMIN"),"邮件测试");

		SpringApplication.run(SpringBootSampleApplication.class, args);
	}
}
