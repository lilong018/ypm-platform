package com.platform.modules.transaction.entity;

import com.platform.modules.bill.entity.BillEntity;
import com.platform.modules.enterprise.entity.EnteroriseInfo;

import java.util.Date;

/**
 * @author ll
 * @description 交易信息实体类
 * @time 2020/7/28 14:23
 */
public class TransactionEntity {

    private String id;
    /**
     * 订单类型（|1|入平台 |2|出平台 |3|财务）
     */
    private Integer category;
    /**
     * 订单状态（|-1|已取消 |2|议价中 |3|议价成功 |4|议价被拒绝 |200|待打款 |201|待背书 |202|待签收 |203|待校验 |204|交易成功 |205|交易失败 |206|校验失敗）
     */
    private Integer status;
    /**
     * 意向价格（每十万扣款）
     */
    private Double feededuction;
    /**
     * 平台服务费
     */
    private Double servicefee;
    /**
     * 订单价格（交易金额？）
     */
    private Double value;
    /**
     * 票据id
     */
    private String billid;
    /**
     * 平台id
     */
    private String platformid;
    /**
     * 买方id
     */
    private String buyerid;
    /**
     * 买方账号？
     */
    private String directbuyeraccount;
    /**
     * 是否定向交易
     */
    private String isdirectsell;
    /**
     * 支付地址（京东返回）
     */
    private String redirectpayurl;
    /**
     * 请求流水号
     */
    private String reqno;
    /**
     * 交易id
     */
    private String transactionid;

    /**
     * 票号
     */
    private String number;
    /**
     * 票据类型
     */
    private Integer type;
    /**
     * 出票人姓名
     */
    private String drawername;
    /**
     * 收票人姓名
     */
    private String draweename;
    /**
     * 承兑银行名称
     */
    private String acceptingbankname;
    /**
     * 承兑银行行号
     */
    private String acceptingbanknumber;
    /**
     * 承兑银行类型
     */
    private String acceptingbanktype;
    /**
     * 票面金额
     */
    private String amount;
    /**
     * 签发日
     */
    private String issuedate;
    /**
     * 到期日
     */
    private String duedate;
    /**
     * 票据正面图URL
     */
    private String coverfrontpictureurl;
    /**
     * 票据背面图URL
     */
    private String coverbackpictures;
    /**
     * 担保渠道
     */
    private String channeltype;
    /**
     * 回款银行账户资讯
     */
    private String transferbank;
    /**
     * 背书户银行资讯
     */
    private String endorsebank;

    private String buyerName;

    private String buyerAccount;

    private String sellerName;

    private String sellerAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getFeededuction() {
        return feededuction;
    }

    public void setFeededuction(Double feededuction) {
        this.feededuction = feededuction;
    }

    public Double getServicefee() {
        return servicefee;
    }

    public void setServicefee(Double servicefee) {
        this.servicefee = servicefee;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getPlatformid() {
        return platformid;
    }

    public void setPlatformid(String platformid) {
        this.platformid = platformid;
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getDirectbuyeraccount() {
        return directbuyeraccount;
    }

    public void setDirectbuyeraccount(String directbuyeraccount) {
        this.directbuyeraccount = directbuyeraccount;
    }

    public String getIsdirectsell() {
        return isdirectsell;
    }

    public void setIsdirectsell(String isdirectsell) {
        this.isdirectsell = isdirectsell;
    }

    public String getRedirectpayurl() {
        return redirectpayurl;
    }

    public void setRedirectpayurl(String redirectpayurl) {
        this.redirectpayurl = redirectpayurl;
    }

    public String getReqno() {
        return reqno;
    }

    public void setReqno(String reqno) {
        this.reqno = reqno;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDrawername() {
        return drawername;
    }

    public void setDrawername(String drawername) {
        this.drawername = drawername;
    }

    public String getDraweename() {
        return draweename;
    }

    public void setDraweename(String draweename) {
        this.draweename = draweename;
    }

    public String getAcceptingbankname() {
        return acceptingbankname;
    }

    public void setAcceptingbankname(String acceptingbankname) {
        this.acceptingbankname = acceptingbankname;
    }

    public String getAcceptingbanknumber() {
        return acceptingbanknumber;
    }

    public void setAcceptingbanknumber(String acceptingbanknumber) {
        this.acceptingbanknumber = acceptingbanknumber;
    }

    public String getAcceptingbanktype() {
        return acceptingbanktype;
    }

    public void setAcceptingbanktype(String acceptingbanktype) {
        this.acceptingbanktype = acceptingbanktype;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getCoverfrontpictureurl() {
        return coverfrontpictureurl;
    }

    public void setCoverfrontpictureurl(String coverfrontpictureurl) {
        this.coverfrontpictureurl = coverfrontpictureurl;
    }

    public String getCoverbackpictures() {
        return coverbackpictures;
    }

    public void setCoverbackpictures(String coverbackpictures) {
        this.coverbackpictures = coverbackpictures;
    }

    public String getChanneltype() {
        return channeltype;
    }

    public void setChanneltype(String channeltype) {
        this.channeltype = channeltype;
    }

    public String getTransferbank() {
        return transferbank;
    }

    public void setTransferbank(String transferbank) {
        this.transferbank = transferbank;
    }

    public String getEndorsebank() {
        return endorsebank;
    }

    public void setEndorsebank(String endorsebank) {
        this.endorsebank = endorsebank;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }
}
