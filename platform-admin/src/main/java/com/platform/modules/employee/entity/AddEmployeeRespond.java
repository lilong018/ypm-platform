package com.platform.modules.employee.entity;

/**
 * @program: ypm-platform
 * @description:
 * @author: LL
 * @create: 2020-09-28 21:24
 **/
public class AddEmployeeRespond {

    private Integer statusCode;
    private AddEmployeePayload payload;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public AddEmployeePayload getPayload() {
        return payload;
    }

    public void setPayload(AddEmployeePayload payload) {
        this.payload = payload;
    }
}
