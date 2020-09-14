package com.platform.modules.employee.entity;

/**
 * @ClassName EmployeeRespond
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/14 16:45
 **/
public class EmployeeRespond {

    private EmployeePayload payload;

    private int statusCode;

    public EmployeePayload getPayload() {
        return payload;
    }

    public void setPayload(EmployeePayload payload) {
        this.payload = payload;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
