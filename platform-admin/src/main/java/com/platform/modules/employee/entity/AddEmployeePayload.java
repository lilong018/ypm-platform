package com.platform.modules.employee.entity;

/**
 * @program: ypm-platform
 * @description:
 * @author: LL
 * @create: 2020-09-28 21:24
 **/
public class AddEmployeePayload {

    private String userId;
    private String employeeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
