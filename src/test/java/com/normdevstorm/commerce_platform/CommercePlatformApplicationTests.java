package com.normdevstorm.commerce_platform;

import com.normdevstorm.commerce_platform.entity.Account;
import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CommercePlatformApplicationTests {
	@Autowired
	private AccountRepository accountRepository;

	@Test
	void contextLoads() {
		Account newAcc = new Account(UUID.randomUUID(), "Nguyen nanm", "", Role.USER);
		String result = accountRepository.findAll().toString();
		System.out.println(result );
	}
}
