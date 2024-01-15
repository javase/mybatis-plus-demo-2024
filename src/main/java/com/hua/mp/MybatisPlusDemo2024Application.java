package com.hua.mp;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hua.mp.dao.mapper")
public class MybatisPlusDemo2024Application {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusDemo2024Application.class, args);
	}

}
