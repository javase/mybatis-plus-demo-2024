package com.hua.mp;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hua.mp.dao.entity.User;
import com.hua.mp.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class QueryDemo {

	@Autowired
	private UserMapper userMapper;

	@Test
	void queryUser() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.like("name", "飞")
				.gt("age", 17)
				.isNotNull("email");
		final List<User> users = userMapper.selectList(wrapper);
		users.forEach(user -> log.info("{}", user));
	}

	/**
	 * 根据年龄升序然后根据id降序
	 */
	@Test
	void sort() {
		QueryWrapper<User> wrapper = new QueryWrapper();
		wrapper.orderByAsc("age").orderByDesc("id");
		final List<User> users = userMapper.selectList(wrapper);
		users.forEach(user -> log.info("{}", user));
	}
}
