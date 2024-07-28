package com.normdevstorm.commerce_platform;

import com.normdevstorm.commerce_platform.enums.Role;
import com.normdevstorm.commerce_platform.model.Account;
import com.normdevstorm.commerce_platform.model.User;
import com.normdevstorm.commerce_platform.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@SpringBootTest
class CommercePlatformApplicationTests {
	@Autowired
	private AccountRepository accountRepository;

	@Test
	void contextLoads() {
//		Account newAcc = Account
//	System.out.println(id);
		Account newAcc = new Account(UUID.randomUUID(), "Nguyen nanm", "123234udfs", Role.USER);
		Account result = accountRepository.findAll().get(0);
		System.out.println(result.getAccountId().toString());
	}
}
