package com.platform.modules.bill.entity;

import com.platform.modules.enterprise.entity.Handler;
import com.platform.modules.response.AuditResult;

/**
 * @ClassName BillResults
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/27 14:58
 * @Version 1.0
 **/
public class BillResults {
    private Handler handler;
    private BillInfo bill;
    private AuditResult auditResult;
    private String comment;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BillInfo getBill() {
        return bill;
    }

    public void setBill(BillInfo bill) {
        this.bill = bill;
    }

    public AuditResult getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(AuditResult auditResult) {
        this.auditResult = auditResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BillResults{" +
                "handler=" + handler +
                ", bill=" + bill +
                ", auditResult=" + auditResult +
                ", comment='" + comment + '\'' +
                '}';
    }
}
