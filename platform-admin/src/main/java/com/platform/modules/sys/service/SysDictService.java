/**
 * Copyright (c) 2016-2019 有票么 All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.platform.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.modules.sys.entity.SysDictEntity;
import com.platform.common.utils.PageUtils;

import java.util.Map;

/**
 * 数据字典
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

