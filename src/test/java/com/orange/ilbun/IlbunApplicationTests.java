package com.orange.ilbun;

import com.orange.ilbun.repository.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IlbunApplicationTests {

	@Autowired
	MemberMapper memberMapper;

	@Test
	@DisplayName("첫 테스트")
	void contextLoads() {
		memberMapper.count();
	}

	@Test
	void test01() {
		memberMapper.findByUserId("asd");
	}

}
