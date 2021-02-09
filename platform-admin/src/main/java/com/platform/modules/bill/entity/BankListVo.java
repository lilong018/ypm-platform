package com.platform.modules.bill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.platform.common.utils.ImageUtil;
import com.platform.modules.bank.entity.BankInfoRespond;
import com.platform.modules.enums.ChannelEnum;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BankListVo
 * @Deacription 页面展示
 * @Author lilong
 * @Date 2020/10/27 16:45
 * @Version 1.0
 **/
public class BankListVo {

    public BankListVo() {
        super();
    }

    public BankListVo(BillResults billResults) {
        this.id = billResults.getBill().getId();
        this.number = billResults.getBill().getNumber();
        this.acceptingbankname = billResults.getBill().getAcceptingBankName();
        this.acceptingbanknumber = billResults.getBill().getAcceptingBankNumber();
        this.acceptingbanktype = billResults.getBill().getAcceptingBankType();
        this.drawername = billResults.getBill().getDrawerName();
        this.draweename = billResults.getBill().getDraweeName();
        this.channeltype = billResults.getBill().getChannelType();
        this.duedate = billResults.getBill().getDueDate();
        this.amount = billResults.getBill().getAmount();
        this.feededuction = billResults.getBill().getFeeDeduction();
        this.status = billResults.getAuditResult().getResult();
        //客服信息
        this.customerId = billResults.getHandler().getId();
        this.customerName = billResults.getHandler().getName();
    }

    public BankListVo(BillResults billResults,String billId) {
        this.id = billId;
        this.number = billResults.getBill().getNumber();
        this.acceptingbankname = billResults.getBill().getAcceptingBankName();
        this.acceptingbanknumber = billResults.getBill().getAcceptingBankNumber();
        this.acceptingbanktype = billResults.getBill().getAcceptingBankType();
        this.drawername = billResults.getBill().getDrawerName();
        this.draweename = billResults.getBill().getDraweeName();
        this.channeltype = billResults.getBill().getChannelType();
        this.duedate = billResults.getBill().getDueDate();
        this.amount = billResults.getBill().getAmount();
        this.feededuction = billResults.getBill().getFeeDeduction();
        this.status = billResults.getBill().getStatus();
        if (billResults.getBill().getReturnEndorsementCount() > 0 ) {
            this.returnendorsementstatus = "否";
        } else {
            this.returnendorsementstatus = "是";
        }
        this.type = billResults.getBill().getType();
        try {
            Map<String, String> frontPictureUrlMap = ImageUtil.getImageMap(billResults.getBill().getFrontPictureUrl());
            this.coverfrontpictureurl = frontPictureUrlMap.get("imageData");
            List<HashMap<String, String>> backPictures = billResults.getBill().getBackPictures();
            if (backPictures!=null && backPictures.size() > 0){
                HashMap<String, String> hashMap = backPictures.get(0);
                String backPicture ="";
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    backPicture = entry.getValue();
                }
                Map<String, String> imageMap = ImageUtil.getImageMap(backPicture);
                this.coverbackpictures = imageMap.get("imageData");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //卖方信息
        this.publisherName = billResults.getBill().getPublisher().getCompanyName();
        this.publisherAccount = billResults.getBill().getPublisher().getAccount();
        this.channeltype = billResults.getBill().getChannelType();
        this.channelName = ChannelEnum.getNameByCode(this.channeltype);
        this.platformName = billResults.getBill().getPlatform().getName();
        this.platformId = billResults.getBill().getPlatform().getId();
        //经办人信息
        // TODO: 2020/10/29 经办人和企业绑定不和渠道绑定
        List<HandlerBean> handler = billResults.getBill().getPublisher().getHandler();
        if (handler !=null || handler.size() >0){
            this.handlerName = handler.get(0).getHandlerName();
            this.handlerPhoneNo = handler.get(0).getHandlerPhoneNo();
        }
        this.endorsebankAccount = billResults.getBill().getEndorseBank().getAccountNumber();
        this.endorsebankId = billResults.getBill().getEndorseBank().getId();
        //客服信息
        this.customerId = billResults.getHandler().getId();
        this.customerName = billResults.getHandler().getName();
    }

    /**
     * 票据id
     */
    @TableId
    private String id;
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
    private Integer acceptingbanktype;
    /**
     * 票面金额
     */
    private double amount;
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
    private Integer channeltype;

    private String channelName;
    /**
     * 回款银行账户资讯
     */
    private BankInfoRespond transferbank;
    /**
     * 背书户银行资讯
     */
    private BankInfoRespond endorsebank;

    /**
     * 背书户银行名称
     */
    private String endorsebankAccount;
    /**
     * 背书户银行名称
     */
    private String endorsebankId;
    /**
     * 背书次数
     */
    private Integer endorsecount;
    /**
     * 回出票人状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private Integer returndrawerstatus;
    /**
     * 回收款人状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private Integer returndraweestatus;
    /**
     * 回头背书状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private String returnendorsementstatus;
    /**
     * 重复背书状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private Integer doubleendorsementstatus;
    /**
     * 质押状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private Integer pledgestatus;
    /**
     * 保证状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private Integer guaranteestatus;
    /**
     * 上下不一致状态 |-1|取消/未知 |0|否/无 |1|是/有
     */
    private Integer inconsistentstatus;
    /**
     * 其它瑕疵
     */
    private String customdefect;
    /**
     * 是否定向交易 true定向交易 false 非定向交易
     */
    private Boolean isdirectsell;
    /**
     * 交易对手账号（交易对手的手机号?） 若isDirectSell为true时，该值必填
     */
    private String directbuyeraccount;
    /**
     * 每十万扣款意向价格
     */
    private String feededuction;
    /**
     * 票据状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtimeinmillis;
    /**
     * 卖方用户id
     */
    private String publisherid;
    /**
     * 卖方用户姓名
     */
    private String publisherName;
    /**
     * 卖方用户账号
     */
    private String publisherAccount;
    /**
     * 卖方用户账号
     */
    private String platformId;
    /**
     * 卖方用户账号
     */
    private String platformName;
    /**
     * 经办人姓名
     */
    private String handlerName;
    /**
     * 经办人电话号码
     */
    private String handlerPhoneNo;
    /**
     * 客服id
     */
    private String customerId;
    /**
     * 经客服名称
     */
    private String customerName;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getAcceptingbanktype() {
        return acceptingbanktype;
    }

    public void setAcceptingbanktype(Integer acceptingbanktype) {
        this.acceptingbanktype = acceptingbanktype;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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

    public Integer getChanneltype() {
        return channeltype;
    }

    public void setChanneltype(Integer channeltype) {
        this.channeltype = channeltype;
    }

    public BankInfoRespond getTransferbank() {
        return transferbank;
    }

    public void setTransferbank(BankInfoRespond transferbank) {
        this.transferbank = transferbank;
    }

    public BankInfoRespond getEndorsebank() {
        return endorsebank;
    }

    public void setEndorsebank(BankInfoRespond endorsebank) {
        this.endorsebank = endorsebank;
    }

    public String getEndorsebankAccount() {
        return endorsebankAccount;
    }

    public void setEndorsebankAccount(String endorsebankAccount) {
        this.endorsebankAccount = endorsebankAccount;
    }

    public String getEndorsebankId() {
        return endorsebankId;
    }

    public void setEndorsebankId(String endorsebankId) {
        this.endorsebankId = endorsebankId;
    }

    public Integer getEndorsecount() {
        return endorsecount;
    }

    public void setEndorsecount(Integer endorsecount) {
        this.endorsecount = endorsecount;
    }

    public Integer getReturndrawerstatus() {
        return returndrawerstatus;
    }

    public void setReturndrawerstatus(Integer returndrawerstatus) {
        this.returndrawerstatus = returndrawerstatus;
    }

    public Integer getReturndraweestatus() {
        return returndraweestatus;
    }

    public void setReturndraweestatus(Integer returndraweestatus) {
        this.returndraweestatus = returndraweestatus;
    }

    public String getReturnendorsementstatus() {
        return returnendorsementstatus;
    }

    public void setReturnendorsementstatus(String returnendorsementstatus) {
        this.returnendorsementstatus = returnendorsementstatus;
    }

    public Integer getDoubleendorsementstatus() {
        return doubleendorsementstatus;
    }

    public void setDoubleendorsementstatus(Integer doubleendorsementstatus) {
        this.doubleendorsementstatus = doubleendorsementstatus;
    }

    public Integer getPledgestatus() {
        return pledgestatus;
    }

    public void setPledgestatus(Integer pledgestatus) {
        this.pledgestatus = pledgestatus;
    }

    public Integer getGuaranteestatus() {
        return guaranteestatus;
    }

    public void setGuaranteestatus(Integer guaranteestatus) {
        this.guaranteestatus = guaranteestatus;
    }

    public Integer getInconsistentstatus() {
        return inconsistentstatus;
    }

    public void setInconsistentstatus(Integer inconsistentstatus) {
        this.inconsistentstatus = inconsistentstatus;
    }

    public String getCustomdefect() {
        return customdefect;
    }

    public void setCustomdefect(String customdefect) {
        this.customdefect = customdefect;
    }

    public Boolean getIsdirectsell() {
        return isdirectsell;
    }

    public void setIsdirectsell(Boolean isdirectsell) {
        this.isdirectsell = isdirectsell;
    }

    public String getDirectbuyeraccount() {
        return directbuyeraccount;
    }

    public void setDirectbuyeraccount(String directbuyeraccount) {
        this.directbuyeraccount = directbuyeraccount;
    }

    public String getFeededuction() {
        return feededuction;
    }

    public void setFeededuction(String feededuction) {
        this.feededuction = feededuction;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetimeinmillis() {
        return createtimeinmillis;
    }

    public void setCreatetimeinmillis(Date createtimeinmillis) {
        this.createtimeinmillis = createtimeinmillis;
    }

    public String getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(String publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAccount() {
        return publisherAccount;
    }

    public void setPublisherAccount(String publisherAccount) {
        this.publisherAccount = publisherAccount;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerPhoneNo() {
        return handlerPhoneNo;
    }

    public void setHandlerPhoneNo(String handlerPhoneNo) {
        this.handlerPhoneNo = handlerPhoneNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
