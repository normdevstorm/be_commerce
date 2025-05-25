package com.normdevstorm.commerce_platform;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@SpringBootApplication
@EnableCaching
@Log4j2
public class CommercePlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommercePlatformApplication.class, args);
	}
}
