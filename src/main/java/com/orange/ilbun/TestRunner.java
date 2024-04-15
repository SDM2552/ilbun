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

		//JdbcTemplete
		//item
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REG_DATE) " +
				"VALUES ('과일', '사과', 1000, 10, 0, '맛있다','apple.jpg', '/itemImg/apple.jpg', CURRENT_DATE)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REG_DATE) " +
				"VALUES ('과일', '딸기', 1000, 55, 0, '달콤하다','strawberry.jpg', '/itemImg/strawberry.jpg', CURRENT_DATE)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REG_DATE) " +
				"VALUES ('디저트', '홍삼캔디', 500, 999, 0, '건강에 좋다','hongsam.png', '/itemImg/hongsam.png', 2024-01-01)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REG_DATE) " +
				"VALUES ('야채', '대파', 1500, 20, 0, '신선합니다','greenOnion.png', '/itemImg/greenOnion.png', 2024-01-03)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REG_DATE) " +
				"VALUES ('냉동식품', '쫀득한입감자', 4500, 20, 0, '쫀득해요','potato.png', '/itemImg/potato.png', 2024-01-05)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REG_DATE) " +
				"VALUES ('야채', '고구마', 1000, 20, 0, '쫀득해요','0b472491-49ed-4f08-a42c-1b914db30431_goguma.jpg', '/itemImg/0b472491-49ed-4f08-a42c-1b914db30431_goguma.jpg', 2024-01-05)");

		//member
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point, role) " +
				"VALUES ('asd', '$2a$10$X9wa1a5pOcJ7rnkWgDmuceEX8ZYqojJv31qPyA7uRPfVU0C6x.QXm', '테스트01', 'test@naver.com', 100, 'ROLE_ADMIN')");
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point, role) " +
				"VALUES ('asd2', '$2a$10$lLJDifm5WvqkXOSrZlZZ6.NQyqek/ku4RAUf5lzAx/DvyPPoBLgB2', '테스트02', 'test2@naver.com', 200, 'ROLE_USER')");
	}

}
