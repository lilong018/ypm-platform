package com.platform.modules.enterprise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.enterprise.entity.EnterpriseEntity;

import java.util.Map;

/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-07-08 09:03:00
 */
public interface EnterpriseService extends IService<EnterpriseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

