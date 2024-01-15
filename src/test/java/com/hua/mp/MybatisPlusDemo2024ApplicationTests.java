package com.hua.mp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Test
	public void updateUser() {
		User user = User.builder()
				.id(1746800811943456769L)
				.name("飞流")
				.age(18)
				.email("feiliu@gmail.com")
				.build();
		int result = userMapper.updateById(user);
		log.info("更新结果：{}", result);
	}

	@Test
	void deleteById() {
		User user = User.builder()
				.id(1746800811943456769L)
				.build();
		int result = userMapper.deleteById(user);
		log.info("删除结果：{}", result);
	}

	@Test
	void deleteBatchIds() {
		int result = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3, 4, 5));
		log.info("删除结果：{}", result);
	}

	@Test
	void deleteByMap() {
		Map<String, Object> params = new HashMap<>(4);
		params.put("age", 18);
		params.put("name", "飞流");
		int result = userMapper.deleteByMap(params);
		log.info("删除结果：{}", result);
	}

}
