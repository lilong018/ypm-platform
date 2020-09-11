package com.platform.modules.employee.service.impl;

import com.alibaba.fastjson.JSON;
import com.platform.common.model.UrlConstans;
import com.platform.common.utils.AuthService;
import com.platform.common.utils.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;

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
        headerMap.put("x-auth-token", AuthService.getToken());
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
        String address = UrlConstans.BASEURL + UrlConstans.EMPLOYEES;
        Map<String, String> urlParams = new HashMap<String, String>();
        /*Integer pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));

        Integer start = (pageNumber - 1) * pageSize;
        urlParams.put("start", String.valueOf(start));
        urlParams.put("count", String.valueOf(pageSize));*/
        urlParams.put("platformId", "68686868");

        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getToken());
        String res = "";
        try {
            res =  HttpUtil.get(address, headerMap,urlParams, "");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
