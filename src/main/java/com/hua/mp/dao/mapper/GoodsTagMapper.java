package com.hua.mp.dao.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.mp.dao.entity.GoodsTag;

/**
 *
 */
public interface GoodsTagMapper extends BaseMapper<GoodsTag> {

	List<Map<String, Object>> getGoodsTagList(List<Long> goodsIds);
}




