package com.platform.modules.platform.entity;

import java.util.List;

/**
 * @ClassName PlatformPayload
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/10 17:06
 **/
public class PlatformPayload {

    private List<PlatformResults> results;

    private int size;

    private int total;

    public List<PlatformResults> getResults() {
        return results;
    }

    public void setResults(List<PlatformResults> results) {
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
