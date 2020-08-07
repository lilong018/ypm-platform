package com.platform.modules.feerecord.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.feerecord.entity.FeerecordEntity;

import java.util.Map;

/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-08-07 14:53:36
 */
public interface FeerecordService extends IService<FeerecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

