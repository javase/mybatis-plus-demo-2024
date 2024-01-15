package com.hua.mp.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class User {
	@TableId(type = IdType.AUTO)
	private Long id;

	private String name;

	private Integer age;

	private String email;
}