package com.platform.modules.employee.controller;

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

import com.platform.modules.employee.entity.EmployeeEntity;
import com.platform.modules.employee.service.EmployeeService;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.R;



/**
 * 
 *
 * @author ll
 * @email 
 * @date 2020-08-06 15:57:09
 */
@RestController
@RequestMapping("employee/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("employee:employee:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employeeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("employee:employee:info")
    public R info(@PathVariable("id") String id){
        EmployeeEntity employee = employeeService.getById(id);

        return R.ok().put("employee", employee);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("employee:employee:save")
    public R save(@RequestBody EmployeeEntity employee){
        employeeService.save(employee);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("employee:employee:update")
    public R update(@RequestBody EmployeeEntity employee){
        ValidatorUtils.validateEntity(employee);
        employeeService.updateById(employee);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("employee:employee:delete")
    public R delete(@RequestBody String[] ids){
        employeeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
