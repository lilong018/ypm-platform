package com.platform.modules.bank.entity;

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
 * @date 2020-07-12 15:52:25
 */
@TableName("tb_bank")
public class BankEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 标识
	 */
	@TableId
	private String id;
	/**
	 * 账户类型 （1） 体现户 （2）签收户
	 */
	private Integer type;
	/**
	 * 渠道类型 （1） 京东智票 （2）京东智付
	 */
	private Integer channeltype;
	/**
	 * 银行新增来源 1)企业实名认证, (2)銀行卡管理打款
	 */
	private Integer banksource;
	/**
	 * 银行名称
	 */
	private String name;
	/**
	 * 银行行号
	 */
	private String number;
	/**
	 * 开户行名称-同企业名称
	 */
	private String accountname;
	/**
	 * 开户账户
	 */
	private String accountnumber;
	/**
	 * 银行编码
	 */
	private String occbankcode;
	/**
	 * 银行名称
	 */
	private String occbankname;
	/**
	 * 银行支行银联号
	 */
	private String occbankcnap;
	/**
	 * 
	 */
	private String occbankchildcode;
	/**
	 * 支行银行全称
	 */
	private String occbankchildname;
	/**
	 * 省份id
	 */
	private String provinceid;
	/**
	 * 省份名称
	 */
	private String provincename;
	/**
	 * 城市id
	 */
	private String cityid;
	/**
	 * 城市名称
	 */
	private String cityname;
	/**
	 * 创建时间
	 */
	private Date createtimeinmillis;
	/**
	 * 认证状态 - (0)待鉴权 (1)审核不通过 (2)审核通过
	 */
	private Integer status;
	/**
	 * 企业ID
	 */
	private String enterpriseId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getChanneltype() {
		return channeltype;
	}

	public void setChanneltype(Integer channeltype) {
		this.channeltype = channeltype;
	}

	public Integer getBanksource() {
		return banksource;
	}

	public void setBanksource(Integer banksource) {
		this.banksource = banksource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getOccbankcode() {
		return occbankcode;
	}

	public void setOccbankcode(String occbankcode) {
		this.occbankcode = occbankcode;
	}

	public String getOccbankname() {
		return occbankname;
	}

	public void setOccbankname(String occbankname) {
		this.occbankname = occbankname;
	}

	public String getOccbankcnap() {
		return occbankcnap;
	}

	public void setOccbankcnap(String occbankcnap) {
		this.occbankcnap = occbankcnap;
	}

	public String getOccbankchildcode() {
		return occbankchildcode;
	}

	public void setOccbankchildcode(String occbankchildcode) {
		this.occbankchildcode = occbankchildcode;
	}

	public String getOccbankchildname() {
		return occbankchildname;
	}

	public void setOccbankchildname(String occbankchildname) {
		this.occbankchildname = occbankchildname;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Date getCreatetimeinmillis() {
		return createtimeinmillis;
	}

	public void setCreatetimeinmillis(Date createtimeinmillis) {
		this.createtimeinmillis = createtimeinmillis;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
}
