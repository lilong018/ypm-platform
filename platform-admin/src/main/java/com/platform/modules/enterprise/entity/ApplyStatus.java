package com.platform.modules.enterprise.entity;

import java.util.Date;

/**
 * @ClassName ApplyStatus
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/19 11:03
 **/
public class ApplyStatus {
    private Integer applyStatus;
    private Date time;

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
