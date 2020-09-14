package com.platform.modules.employee.entity;

import java.util.List;

/**
 * @ClassName EmployeePayload
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/14 16:45
 **/
public class EmployeePayload {
    private List<EmployeeResults> results;

    private int size;

    private int total;

    public List<EmployeeResults> getResults() {
        return results;
    }

    public void setResults(List<EmployeeResults> results) {
        this.results = results;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
