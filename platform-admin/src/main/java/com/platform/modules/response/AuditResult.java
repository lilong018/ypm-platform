package com.platform.modules.response;

/**
 * @ClassName AuditResult
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/27 15:45
 * @Version 1.0
 **/
public class AuditResult {
    private Integer result;
    private String reason;
    private String comment;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AuditResult{" +
                "result=" + result +
                ", reason='" + reason + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
