package com.orange.ilbun;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		//member
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point, role) " +
				"VALUES ('asd', '$2a$10$X9wa1a5pOcJ7rnkWgDmuceEX8ZYqojJv31qPyA7uRPfVU0C6x.QXm', '테스트01', 'test@naver.com', 100, 'ROLE_ADMIN')");
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point, role) " +
				"VALUES ('asd2', '$2a$10$lLJDifm5WvqkXOSrZlZZ6.NQyqek/ku4RAUf5lzAx/DvyPPoBLgB2', '테스트02', 'test2@naver.com', 200, 'ROLE_USER')");
	}

}
