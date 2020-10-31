package com.platform.modules.responseEntity;

import java.util.Date;

/**
 * @ClassName ApplyStatusHistory
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/10/16 17:41
 **/
public class ApplyStatusHistory {

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
