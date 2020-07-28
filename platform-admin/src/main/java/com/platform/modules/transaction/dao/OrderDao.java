package com.platform.modules.transaction.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.platform.modules.transaction.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 * 
 * @author ll
 * @email 
 * @date 2020-07-28 10:02:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
    List<OrderEntity> queryList(IPage<OrderEntity> page, @Param("params") Map<String, Object> params);
}
