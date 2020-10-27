package com.platform.modules.response;

import java.util.List;

/**
 * @ClassName CommonPageResults
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/27 14:56
 * @Version 1.0
 **/
public class CommonPageResults<T>  {
    private List<T> results;

    private Integer size;

    private Integer total;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CommonPageResults{" +
                "results=" + results +
                ", size=" + size +
                ", total=" + total +
                '}';
    }
}
