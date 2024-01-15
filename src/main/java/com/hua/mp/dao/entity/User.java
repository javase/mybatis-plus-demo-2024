package com.hua.mp.dao.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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

	@TableLogic
	private Integer delFlag;
}