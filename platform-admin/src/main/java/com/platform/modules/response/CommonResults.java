package com.platform.modules.response;

import java.util.List;

/**
 * @program: ypm
 * @description:
 * @author: LL
 * @create: 2020-10-02 23:34
 **/
public class CommonResults<T> {
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
