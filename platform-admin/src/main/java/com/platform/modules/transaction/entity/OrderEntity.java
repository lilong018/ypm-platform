package com.platform.modules.transaction.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 * 
 * @author ll
 * @email 
 * @date 2020-07-28 10:02:19
 */
@TableName("tb_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 标识
	 */
	@TableId
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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
}
