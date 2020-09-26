package com.platform.modules.employee.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.modules.employee.dao.EmployeeDao;
import com.platform.modules.employee.entity.Employee;
import com.platform.modules.employee.entity.EmployeeEntity;
import com.platform.modules.employee.entity.EmployeeRespond;
import com.platform.modules.employee.entity.EmployeeResults;
import com.platform.modules.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeEntity> page = this.page(
                new Query<EmployeeEntity>().getPage(params),
                new QueryWrapper<EmployeeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        QueryWrapper<EmployeeEntity> queryWrapper = new QueryWrapper<EmployeeEntity>();

        return null;
    }

    @Override
    public boolean saveEmployee(EmployeeEntity employee) {
        Map<String, String> headerMap = new HashMap<String, String>();
        Map<String, Object> params = new HashMap<String, Object>();
        // TODO: 2020/9/22 修改人员增加接口
        headerMap.put("x-auth-token", AuthService.getPlatformManager());
        String address = UrlConstans.BASEURL + UrlConstans.EMPLOYEES;
        Map<String, Object> employeeMap = new HashMap<String, Object>();
        employeeMap.put("name",employee.getName());
        employeeMap.put("department",employee.getDepartment());
        employeeMap.put("phoneNo",employee.getPhoneNo());

        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("account",employee.getPhoneNo());
        userMap.put("password","123456");
        userMap.put("isFirstLoginReset",true);
        userMap.put("isNotAllowReset",false);
        userMap.put("isPlatformAdmin",false);
        List<String> controlPlatform = new ArrayList<String>();
        controlPlatform.add(AuthService.getPlatformId());
        userMap.put("controlPlatform",controlPlatform);
        params.put("employee",employeeMap);
        params.put("platformId",AuthService.getPlatformId());
        params.put("user",userMap);
        String res = "";
        try {
            res =  HttpUtil.post(address, headerMap, JSON.toJSONString(params));
            System.out.println(res);
            // TODO: 2020/9/15 处理返回值 有判断用户重复的情况2001
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public PageUtils selectPage(Map<String, Object> params) {
        Integer pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        Map<String, String> headerMap = new HashMap<String, String>();
        Map<String, String> urlParams = ParamsUtils.convertParams(params);
        // TODO: 2020/9/14 使用authserve获取platformId
        urlParams.put("platformId",AuthService.getPlatformId());
        headerMap.put("x-auth-token", AuthService.getPlatformManager());
        PageUtils page = null;
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.EMPLOYEES, headerMap, urlParams, null);
            System.out.println(res);
            EmployeeRespond employeeRespond = JSON.parseObject(res, EmployeeRespond.class);
            List<EmployeeResults> employeeResults = employeeRespond.getPayload().getResults();
            List<Employee> employees = new ArrayList<Employee>();
            for (EmployeeResults employeeResult : employeeResults) {
                Employee employee = employeeResult.getEmployee();
                employee.setPlatformId(employeeResult.getPlatform().getId());
                employee.setPlatformName(employeeResult.getPlatform().getName());
                employees.add(employee);
            }
            page = new PageUtils(employees, employeeRespond.getPayload().getTotal(), pageSize, pageNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @Override
    public EmployeeEntity selectById(String id) {

        return null;
    }

    @Override
    public boolean deleteById(String id) {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getAuth());
        try {
            String res =  HttpUtil.delete(UrlConstans.BASEURL + UrlConstans.EMPLOYEES+"/"+id,headerMap,null);
            Map<String, Object> respond = JSONObject.parseObject(res, new TypeReference<Map<String, Object>>() {});
            Integer statusCode = (Integer) respond.get("statusCode");
            if (statusCode == 0){
                return true;
            }
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getAuth());
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> employeeMap = new HashMap<String, Object>();
        employeeMap.put("name",employee.getName());
        employeeMap.put("department",employee.getDepartment());
        employeeMap.put("phoneNo",employee.getPhoneNo());

        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("account",employee.getPhoneNo());
//        userMap.put("password","123456");

        List<String> controlPlatform = new ArrayList<String>();
        userMap.put("controlPlatform",controlPlatform);
        params.put("employee",employeeMap);
        params.put("user",userMap);
        try {
            String res = HttpUtil.put(UrlConstans.BASEURL + UrlConstans.EMPLOYEES + "/" + employee.getId(), headerMap, JSON.toJSONString(params));
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
