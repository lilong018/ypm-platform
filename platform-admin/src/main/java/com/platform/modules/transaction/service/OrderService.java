package com.platform.modules.transaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.transaction.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单表
 *
 * @author ll
 * @email 
 * @date 2020-07-28 10:02:19
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

