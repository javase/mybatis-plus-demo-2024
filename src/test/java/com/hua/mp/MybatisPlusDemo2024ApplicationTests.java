package com.hua.mp;

import java.util.List;

import com.hua.mp.dao.entity.User;
import com.hua.mp.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDemo2024ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

}
