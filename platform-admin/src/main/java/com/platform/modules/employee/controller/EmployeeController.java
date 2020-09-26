package com.platform.modules.employee.controller;

import java.util.*;

import com.platform.common.utils.AuthService;
import com.platform.common.utils.SnowFlakeUtils;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.employee.entity.Employee;
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
 * @describe 员工管理controller
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
        PageUtils page = employeeService.selectPage(params);
        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/all")
    @RequiresPermissions("employee:employee:list")
    public R getAll(@RequestParam Map<String, Object> params){
//        List<EmployeeEntity> employeeEntities = employeeService.list();
        return R.ok().put("employeeEntities", null);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("employee:employee:info")
    public R info(@PathVariable("id") String id){
//        EmployeeEntity employee = employeeService.getById(id);

        System.out.println(id);
        EmployeeEntity employee = employeeService.selectById(id);
        return R.ok().put("employee", "");
    }
    /**
     * 信息
     */
    @RequestMapping("/infoData/{id}/{name}/{phoneNo}/{platformId}/{department}")
    @RequiresPermissions("employee:employee:info")
    public R infoData(@PathVariable("id") String id,@PathVariable("name") String name,@PathVariable("phoneNo") String phoneNo,@PathVariable("platformId") String platformId,@PathVariable("department") String department){
        Employee employee = new Employee();
        if (department.equals("管理部门")){
            employee.setDepartment(1);
        }else if (department.equals("客服")){
            employee.setDepartment(2);
        }else if (department.equals("财务")){
            employee.setDepartment(3);
        }else{
            employee.setDepartment(0);
        }
        employee.setId(id);
        employee.setName(name);
        employee.setPhoneNo(phoneNo);
        employee.setPlatformId(platformId);

        return R.ok().put("employee", employee);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("employee:employee:save")
    public R save(@RequestBody EmployeeEntity employee){

        employeeService.saveEmployee(employee);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("employee:employee:update")
    public R update(@RequestBody Employee employee){
        ValidatorUtils.validateEntity(employee);
        boolean flag = employeeService.updateEmployee(employee);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("employee:employee:delete")
    public R delete(@RequestBody String[] ids){
        List<String> idList = (List<String>) Arrays.asList(ids);
        idList.forEach(id->{
           boolean flag =  employeeService.deleteById(id);
        });
        for (String id : idList) {
            
        }
        return R.ok();
    }

}
