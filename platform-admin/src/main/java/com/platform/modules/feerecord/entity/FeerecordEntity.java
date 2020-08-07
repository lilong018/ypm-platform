package com.platform.modules.feerecord.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ll
 * @email 
 * @date 2020-08-07 14:53:36
 */
@TableName("tb_feerecord")
public class FeerecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private String id;
	/**
	 * 费用类型（0 未知、1 票据发布费、2 平台服务费、4 见证服务费 、8 资金结算费）
	 */
	private Integer feetype;
	/**
	 * 平台费用
	 */
	private Double platformFee;
	/**
	 * 渠道费用
	 */
	private Double channelFee;
	/**
	 * 支付方ID
	 */
	private String payerid;
	/**
	 * 支付方姓名
	 */
	private String payername;
	/**
	 * 买方id
	 */
	private String buyerid;
	/**
	 * 买方姓名
	 */
	private String buyername;
	/**
	 * 卖方id
	 */
	private String sellerid;
	/**
	 * 卖方姓名
	 */
	private String sellername;
	/**
	 * 票号
	 */
	private String billnumber;
	/**
	 * 票据id
	 */
	private String billid;
	/**
	 * 订单号
	 */
	private String orderid;
	/**
	 * 发布平台id
	 */
	private String releasePlatformid;
	/**
	 * 发布平台
	 */
	private String releasePlatform;
	/**
	 * 交易平台
	 */
	private String transactionPlatform;
	/**
	 * 交易平台id
	 */
	private String transactionPlatformid;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFeetype() {
		return feetype;
	}

	public void setFeetype(Integer feetype) {
		this.feetype = feetype;
	}

	public Double getPlatformFee() {
		return platformFee;
	}

	public void setPlatformFee(Double platformFee) {
		this.platformFee = platformFee;
	}

	public Double getChannelFee() {
		return channelFee;
	}

	public void setChannelFee(Double channelFee) {
		this.channelFee = channelFee;
	}

	public String getPayerid() {
		return payerid;
	}

	public void setPayerid(String payerid) {
		this.payerid = payerid;
	}

	public String getPayername() {
		return payername;
	}

	public void setPayername(String payername) {
		this.payername = payername;
	}

	public String getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}

	public String getBuyername() {
		return buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	public String getSellerid() {
		return sellerid;
	}

	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getBillnumber() {
		return billnumber;
	}

	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}

	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
		this.billid = billid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getReleasePlatformid() {
		return releasePlatformid;
	}

	public void setReleasePlatformid(String releasePlatformid) {
		this.releasePlatformid = releasePlatformid;
	}

	public String getReleasePlatform() {
		return releasePlatform;
	}

	public void setReleasePlatform(String releasePlatform) {
		this.releasePlatform = releasePlatform;
	}

	public String getTransactionPlatform() {
		return transactionPlatform;
	}

	public void setTransactionPlatform(String transactionPlatform) {
		this.transactionPlatform = transactionPlatform;
	}

	public String getTransactionPlatformid() {
		return transactionPlatformid;
	}

	public void setTransactionPlatformid(String transactionPlatformid) {
		this.transactionPlatformid = transactionPlatformid;
	}
}
