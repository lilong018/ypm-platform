package com.platform.modules.bank.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.bank.entity.BankEntity;

import java.util.Map;

/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-07-12 15:52:25
 */
public interface BankService extends IService<BankEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

