package com.hua.mp;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.mp.dao.entity.User;
import com.hua.mp.dao.mapper.AoTagMapper;
import com.hua.mp.dao.mapper.UserMapper;
import com.hua.mp.domain.AoTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class QueryDemo {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AoTagMapper aoTagMapper;

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

	@Test
	void andOr() {
		// 查询出年龄大于20并且姓名中包含的有'o' 或者 邮箱地址为空的记录
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.and(item -> item.gt("age", 20).like("name", "o"))
				.or(item -> item.isNull("email"));
		final List<User> users = userMapper.selectList(wrapper);
		users.forEach(user -> log.info("{}", user));
	}

	/**
	 * 查询指定的字段
	 */
	@Test
	void querySomeColumns() {
		// 查询出年龄大于20并且姓名中包含的有'o' 或者 邮箱地址为空的记录
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.and(item -> item.gt("age", 20).like("name", "o"))
				// 默认是通过and连接 显示加上 or()方法表示or连接
				.or(item -> item.isNull("email"));
		// 指定特定的字段
		wrapper.select("id", "name");
		//selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
		final List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
		maps.forEach(a -> log.info("{}  {}", a, a.getClass()));
	}

	/**
	 * 子查询
	 */
	@Test
	void subQuery() {
		// 子查询
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.inSql("id", "select id from t_user where id < 6");
		// 指定特定的字段
		wrapper.select("id", "name");
		//selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
		final List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
		maps.forEach(a -> log.info("{}  {}", a, a.getClass()));
	}

	/**
	 * 更新用户Tom的姓名和年龄信息
	 */
	@Test
	void updateWrapper() {
		// 子查询
		UpdateWrapper<User> wrapper = new UpdateWrapper<>();
		wrapper.set("name", "TomeJerry")
				.set("age", 10)
				.eq("name", "Tom");
		final int update = userMapper.update(null, wrapper);
		log.info("更新结果：{}", update);
	}

	/**
	 * 动态查询1
	 */
	@Test
	void dynamicQuery1() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();

		String name = "TomeJerry";
		Integer age = null;
		String email = null;
		if (!Objects.isNull(name)) {
			wrapper.eq("name", name);
		}
		if (!Objects.isNull(age)) {
			wrapper.eq("age", age);
		}
		if (!Objects.isNull(email)) {
			wrapper.eq("email", email);
		}
		final List<User> users = userMapper.selectList(wrapper);
		users.forEach(a -> log.info("{}  {}", a, a.getClass()));
	}

	/**
	 * 动态查询2
	 */
	@Test
	void dynamicQuery2() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		String name = "TomeJerry";
		Integer age = null;
		String email = null;

		wrapper.eq(!Objects.isNull(name), "name", name);
		wrapper.eq(!Objects.isNull(age), "age", age);
		wrapper.eq(!Objects.isNull(email), "email", email);

		final List<User> users = userMapper.selectList(wrapper);
		users.forEach(a -> log.info("{}  {}", a, a.getClass()));
	}

	@Test
	void queryPage() {
		Page<User> page = new Page<>(2, 5);
		Page<User> userPage = userMapper.selectPage(page, null);
		System.out.println("userPage.getCurrent() = " + userPage.getCurrent());
		System.out.println("userPage.getSize() = " + userPage.getSize());
		System.out.println("userPage.getTotal() = " + userPage.getTotal());
		System.out.println("userPage.getPages() = " + userPage.getPages());
		System.out.println("userPage.hasPrevious() = " + userPage.hasPrevious());
		System.out.println("userPage.hasNext() = " + userPage.hasNext());
	}

	@Test
	void queryTags() {
		final List<AoTag> aoTags = aoTagMapper.selectList(null);
		aoTags.forEach(t -> log.info("{}", t));
	}
}
