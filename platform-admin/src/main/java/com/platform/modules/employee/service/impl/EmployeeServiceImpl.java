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
import com.platform.modules.employee.entity.*;
import com.platform.modules.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("employeeService")
public class EmployeeServiceImpl<main> extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {

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
            AddEmployeeRespond addEmployeeRespond = JSON.parseObject(res, AddEmployeeRespond.class);
            if (addEmployeeRespond.getStatusCode() == 0){
                //添加用户权限
                Map<String, Object> privilegeParams = new HashMap<String, Object>();

                List<Map<String, Object>> userPrivileges = new ArrayList<Map<String, Object>>();

                Map<String, Object> platformMap = new HashMap<String, Object>();

                List<Map<String, Object>> privilegesList = new ArrayList<Map<String, Object>>();
                Map<String, Object> privilegesMap = new HashMap<String, Object>();
                privilegesMap.put("category",1);
                privilegesMap.put("privilege",15);
                privilegesList.add(privilegesMap);
                platformMap.put("platformId",AuthService.getPlatformId());
                platformMap.put("privileges",privilegesList);
                userPrivileges.add(platformMap);

                privilegeParams.put("employeeId",addEmployeeRespond.getPayload().getEmployeeId());

                privilegeParams.put("userPrivileges",userPrivileges);

                String privilegesRes = HttpUtil.post(UrlConstans.BASEURL + UrlConstans.PRIVILEGES, headerMap, JSON.toJSONString(privilegeParams));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 赋予权限
     * @param args
     */

    public static void main(String[] args) {
        {


//        5f6ef1186c1b725440329897
            Map<String, String> headerMap = new HashMap<String, String>();
            Map<String, Object> params = new HashMap<String, Object>();
            // TODO: 2020/9/22 修改人员增加接口
            headerMap.put("x-auth-token", AuthService.getPlatformManager());
//        /添加用户权限
            Map<String, Object> privilegeParams = new HashMap<String, Object>();

            List<Map<String, Object>> userPrivileges = new ArrayList<Map<String, Object>>();

            Map<String, Object> platformMap = new HashMap<String, Object>();

            List<Map<String, Object>> privilegesList = new ArrayList<Map<String, Object>>();
            Map<String, Object> privilegesMap = new HashMap<String, Object>();
            privilegesMap.put("category",1);
            privilegesMap.put("privilege",15);
            privilegesList.add(privilegesMap);
            platformMap.put("platformId",AuthService.getPlatformId());
            platformMap.put("privileges",privilegesList);
            userPrivileges.add(platformMap);

            privilegeParams.put("employeeId","5f6ef1186c1b725440329897");

            privilegeParams.put("userPrivileges",userPrivileges);

            try {
                String privilegesRes = HttpUtil.post(UrlConstans.BASEURL + UrlConstans.PRIVILEGES, headerMap, JSON.toJSONString(privilegeParams));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page",0);
        params.put("limit",10);
        Integer pageNumber = 0;
        Integer pageSize = 10;
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
    }

    private void addPlv(EmployeeEntity employee) throws Exception{
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("x-auth-token", AuthService.getAdminToken());
//        String employeeId = userPayload.get("employeeId");

        Map<String, Object> privilegeParams = new HashMap<String, Object>();

        List<Map<String, Object>> userPrivileges = new ArrayList<Map<String, Object>>();

        Map<String, Object> platformMap = new HashMap<String, Object>();

        List<Map<String, Object>> privilegesList = new ArrayList<Map<String, Object>>();
        Map<String, Object> privilegesMap = new HashMap<String, Object>();
        privilegesMap.put("category",3);
        privilegesMap.put("privilege",15);
        privilegesList.add(privilegesMap);
//        platformMap.put("platformId",platformId);
        platformMap.put("privileges",privilegesList);
        userPrivileges.add(platformMap);

//        privilegeParams.put("employeeId",employeeId);

        privilegeParams.put("userPrivileges",userPrivileges);

        String privilegesRes = HttpUtil.post(UrlConstans.BASEURL + UrlConstans.PRIVILEGES, headerMap, JSON.toJSONString(privilegeParams));
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
