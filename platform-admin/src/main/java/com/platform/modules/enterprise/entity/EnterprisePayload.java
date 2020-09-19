package com.platform.modules.enterprise.entity;

import java.util.List;

/**
 * @ClassName EnterprisePayload
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:47
 **/
public class EnterprisePayload {
    private List<EnterpriseResults> results;

    private int size;

    private int total;

    public List<EnterpriseResults> getResults() {
        return results;
    }

    public void setResults(List<EnterpriseResults> results) {
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
