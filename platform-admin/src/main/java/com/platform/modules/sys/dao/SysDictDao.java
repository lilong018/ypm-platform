/**
 * Copyright (c) 2016-2019 有票么 All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.platform.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.platform.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
