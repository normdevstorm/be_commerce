package com.normdevstorm.commerce_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@SpringBootApplication
@EnableCaching
public class CommercePlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommercePlatformApplication.class, args);
	}
}
