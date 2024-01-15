package com.hua.mp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hua.mp.dao.entity.User;
import com.hua.mp.dao.mapper.UserMapper;
import com.hua.mp.service.i.IUserService;
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
	void selectList() {
		List<User> users = userMapper.selectList(null);
		users.forEach(user -> {
			log.info("{}", user);
		});
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

	@Test
	void queryUserById() {
		User user = userMapper.selectById(1);
		log.info("{}", user);
	}

	@Test
	void selectBatchIds() {
		List<User> list = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
		list.forEach(user -> {
			log.info("{}", user);
		});
	}

	@Test
	void selectByMap() {
		Map<String, Object> params = new HashMap<>(4);
		params.put("age", 18);
		params.put("name", "飞流");
		List<User> list = userMapper.selectByMap(params);
		list.forEach(user -> {
			log.info("{}", user);
		});
	}

	@Autowired
	private IUserService iUserService;

	@Test
	void getUserCount() {
		final long count = iUserService.count();
		log.info("统计：{}", count);
	}

	@Test
	void getById() {
		User user = iUserService.getById(1L);
		log.info("查询：{}", user);
	}

	@Test
	void list() {
		List<User> users = iUserService.list(null);
		for (User user : users) {
			log.info("查询：{}", user);
		}
	}

	@Test
	void saveBatch() {
		List<User> list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			User user = User.builder()
					.name("平津" + i)
					.age(10 + i)
					.email("aaa@163.com")
					.build();
			list.add(user);
		}
		// 3个一批进行录入
		boolean result = iUserService.saveBatch(list,3);
		log.info("批量录入结果：{}", result);
	}
}
