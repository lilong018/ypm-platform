package com.platform.modules.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.platform.entity.PlatformEntity;

import java.util.Map;

/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-08-05 11:33:42
 */
public interface PlatformService extends IService<PlatformEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

