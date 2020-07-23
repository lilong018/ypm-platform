package com.platform.modules.enterprise.entity;

import java.util.Arrays;

/**
 * @author ll
 * @description
 * @time 2020/7/20 18:00
 */
public class EnteroriseRejectEntity {
    private String id;
    private String[] reasons;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getReasons() {
        return reasons;
    }

    public void setReasons(String[] reasons) {
        this.reasons = reasons;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EnteroriseRejectEntity{" +
                "id='" + id + '\'' +
                ", reasons=" + Arrays.toString(reasons) +
                ", remark='" + remark + '\'' +
                '}';
    }
}
