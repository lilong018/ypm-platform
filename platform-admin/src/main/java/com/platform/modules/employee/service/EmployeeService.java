package com.platform.modules.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.employee.entity.EmployeeEntity;

import java.util.Map;

/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-08-06 15:57:09
 */
public interface EmployeeService extends IService<EmployeeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

