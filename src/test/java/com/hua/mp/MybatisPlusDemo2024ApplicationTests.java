package com.hua.mp;

import java.util.List;

import com.hua.mp.dao.entity.User;
import com.hua.mp.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MybatisPlusDemo2024ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

	@Test
	public void addUser() {
		User user = User.builder()
				.name("飞流")
				.age(18)
				.email("feiliu@gmail.com")
				.build();
		int result = userMapper.insert(user);
		log.info("插入结果：{}", result);
	}

}
