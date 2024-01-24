package com.hua.mp.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 标签表
 */
@TableName(value = "ao_tag")
@Data
public class AoTag implements Serializable {
	/**
	 * 标签ID
	 */
    @TableId(type = IdType.INPUT)
	private String id;

	/**
	 * 标签名称
	 */
	private String name;

	/**
	 * 0正常1删除
	 */
	private Integer deleted;

	/**
	 * 排序值，从大到小排序
	 */
	private Integer ordernum;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

}