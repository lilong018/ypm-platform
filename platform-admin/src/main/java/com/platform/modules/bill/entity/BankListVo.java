package com.platform.modules.bill.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.platform.common.utils.StringUtil;
import com.platform.modules.enums.BillType;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
        this.status = billResults.getBill().getStatus();
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
        this.coverfrontpictureurl = billResults.getBill().getFrontPictureUrl();
        List<HashMap<String, String>> backPictures = billResults.getBill().getBackPictures();
        if (backPictures!=null && backPictures.size() > 0){
            this.coverbackpictures = backPictures.get(0).get(billResults.getBill().getNumber());
        }
        System.out.println(this.coverbackpictures);
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
    /**
     * 回款银行账户资讯
     */
    private String transferbank;
    /**
     * 背书户银行资讯
     */
    private String endorsebank;
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
}