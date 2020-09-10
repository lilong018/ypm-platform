package com.platform.modules.platform.entity;

import java.util.Date;

/**
 * @ClassName PlatformResults
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/10 17:06
 **/
public class PlatformResults {

    private Date createTimeInMillis;

    private Fee fee;

    private String id;

    private String manager;

    private String name;

    private String phoneNo;

    private int status;

    private boolean valid;

    private String website;


    public Date getCreateTimeInMillis() {
        return createTimeInMillis;
    }

    public void setCreateTimeInMillis(Date createTimeInMillis) {
        this.createTimeInMillis = createTimeInMillis;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
