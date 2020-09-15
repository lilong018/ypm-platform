package com.platform.modules.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.employee.entity.Employee;
import com.platform.modules.employee.entity.EmployeeEntity;

import java.util.List;
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

    List<EmployeeEntity> getAll();

    boolean saveEmployee(EmployeeEntity employee);

    PageUtils selectPage(Map<String, Object> params);

    EmployeeEntity selectById(String id);

    boolean deleteById(String id);

    boolean updateEmployee(Employee employee);
}

