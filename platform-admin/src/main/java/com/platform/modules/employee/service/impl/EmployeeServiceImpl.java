package com.platform.modules.employee.service.impl;

import com.alibaba.fastjson.JSON;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.*;
import com.platform.modules.employee.entity.EmployeeRespond;
import com.platform.modules.platform.entity.PlatformRespond;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.platform.modules.employee.dao.EmployeeDao;
import com.platform.modules.employee.entity.EmployeeEntity;
import com.platform.modules.employee.service.EmployeeService;


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
        headerMap.put("x-auth-token", AuthService.getAuth());
        String address = UrlConstans.BASEURL + UrlConstans.EMPLOYEES;
        Map<String, Object> employeeMap = new HashMap<String, Object>();
        employeeMap.put("name",employee.getName());
        employeeMap.put("department",employee.getDepartment());
        employeeMap.put("phoneNo",employee.getPhoneno());

        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("account",employee.getPhoneno());
        userMap.put("password","123456");
        userMap.put("isFirstLoginReset",true);
        userMap.put("isNotAllowReset",false);
        userMap.put("isPlatformAdmin",false);
        List<String> controlPlatform = new ArrayList<String>();
        userMap.put("controlPlatform",controlPlatform);
        params.put("employee",employeeMap);
        params.put("platformId",employee.getPlatformid());
        params.put("user",userMap);
        String res = "";
        try {
            res =  HttpUtil.post(address, headerMap, JSON.toJSONString(params));
            System.out.println(res);
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
        urlParams.put("platformId","5f5b406e6c1b726ef76c15fb");
        headerMap.put("x-auth-token", AuthService.getAuth());
        PageUtils page = null;
        try {
            String res = HttpUtil.get(UrlConstans.BASEURL + UrlConstans.EMPLOYEES, headerMap, urlParams, null);
            System.out.println(res);
            EmployeeRespond employeeRespond = JSON.parseObject(res, EmployeeRespond.class);
            page = new PageUtils(employeeRespond.getPayload().getResults(), employeeRespond.getPayload().getTotal(), pageSize, pageNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

}
