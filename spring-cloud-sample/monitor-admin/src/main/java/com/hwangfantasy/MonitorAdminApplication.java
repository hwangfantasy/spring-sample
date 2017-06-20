package com.hwangfantasy;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class MonitorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorAdminApplication.class, args);
	}
}
