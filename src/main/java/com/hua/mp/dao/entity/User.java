package com.hua.mp.dao.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class User {
	private Long id;

	private String name;

	private Integer age;

	private String email;
}