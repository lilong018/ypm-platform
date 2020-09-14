package com.platform.modules.employee.entity;

import java.util.List;

/**
 * @ClassName EmployeeResults
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/14 16:46
 **/
public class EmployeeResults {
    private Employee employee;

    private Platform platform;

    private User user;

    private List<String> userPrivileges;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(List<String> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }
}
