package com.platform.modules.transaction.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;

import com.platform.modules.transaction.dao.OrderDao;
import com.platform.modules.transaction.entity.OrderEntity;
import com.platform.modules.transaction.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> selPage = new Query<OrderEntity>().getPage(params);
        List<OrderEntity> orderEntities = this.baseMapper.queryList(selPage, params);
        selPage.setRecords(orderEntities);
     /*   IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );*/
        return new PageUtils(selPage);
    }

}
