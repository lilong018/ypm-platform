package com.platform.modules.transaction.controller;

import java.util.Arrays;
import java.util.Map;

import com.platform.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.modules.transaction.entity.OrderEntity;
import com.platform.modules.transaction.service.OrderService;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;



/**
 * 订单表
 *
 * @author ll
 * @email 
 * @date 2020-07-28 10:02:19
 */
@RestController
@RequestMapping("transaction/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("transaction:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("transaction:order:info")
    public R info(@PathVariable("id") String id){
        OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("transaction:order:save")
    public R save(@RequestBody OrderEntity order){
        orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("transaction:order:update")
    public R update(@RequestBody OrderEntity order){
        ValidatorUtils.validateEntity(order);
        orderService.updateById(order);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("transaction:order:delete")
    public R delete(@RequestBody String[] ids){
        orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
