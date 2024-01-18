package com.hua.mp.dao.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hua.mp.dao.entity.GoodsTag;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity com.hmsf.scaffold.mgr.dao.GoodsTag
 */
public interface GoodsTagMapper extends BaseMapper<GoodsTag> {

	@Select("SELECT ao_goods_tag.goods_id, GROUP_CONCAT(ao_tag.name) as tagName " +
			"FROM ao_goods_tag " +
			"LEFT JOIN ao_tag ON ao_goods_tag.tag_id = ao_tag.id " +
			"WHERE ao_tag.deleted = 0 AND ao_goods_tag.goods_id IN (#{goodsIds}) " +
			"GROUP BY ao_goods_tag.goods_id")
	List<Map<String, Object>> getGoodsTagList(@Param("goodsIds") String goodsIds);
}




