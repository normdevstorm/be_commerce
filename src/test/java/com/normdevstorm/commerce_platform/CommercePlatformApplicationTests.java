package com.normdevstorm.commerce_platform;

import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.model.Account;
import com.normdevstorm.commerce_platform.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CommercePlatformApplicationTests {

	@Test
	void contextLoads() {
//		Account newAcc = Account
//	System.out.println(id);
		Account newAcc = new Account(UUID.randomUUID(), "Nguyen nanm", "123234udfs", Role.USER);

		System.out.println(newAcc.toString());
	}
}
