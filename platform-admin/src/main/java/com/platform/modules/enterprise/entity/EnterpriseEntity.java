package com.platform.modules.enterprise.entity;

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
 * @date 2020-07-19 15:05:02
 */
@TableName("tb_enterprise")
public class EnterpriseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIELD_NAME = "name";
	public static final String FIELD_ACCOUNT = "useraccount";
	public static final String FIELD_STATUS = "status";

	/**
	 * id
	 */
	@TableId
	private String id;
	/**
	 * 企业姓名
	 */
	private String name;
	/**
	 * 统一社会信用代码-营业执照
	 */
	private String uscc;
	/**
	 * 公司详细地址
	 */
	private String address;
	/**
	 * 营业执照图片
	 */
	private String businesslicenseurl;
	/**
	 * 开户许可证图片
	 */
	private String accountopeninglicenseurl;
	/**
	 * 法人姓名
	 */
	private String legalrepname;
	/**
	 * 法人身份证
	 */
	private String legalrepid;
	/**
	 * 法人手机号码
	 */
	private String legalrepphoneno;
	/**
	 * 法人身份证正面照片
	 */
	private String legalrepidpicfronturl;
	/**
	 * 法人身份证背面照片
	 */
	private String legalrepidpicbackurl;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 营业执照到期时间
	 */
	private String businessexpirationdate;
	/**
	 * 法人身份证到期时间
	 */
	private String idcardexpirationdate;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;
	/**
	 * 企业状态
	 */
	private String status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 用户id
	 */
	private String userid;
	/**
	 * 用户账号-注册手机号
	 */
	private String useraccount;
	/**
	 * 操作人员标识
	 */
	private String operatorid;
	/**
	 * 平台ID
	 */
	private String platformid;
	/**
	 * 用户角色 1：买方&卖方 2：卖方
	 */
	private Integer roletype;
	/**
	 * 经办人姓名
	 */
	private String handlername;
	/**
	 * 经办人身份证号
	 */
	private String handlerid;
	/**
	 * 经办人手机号
	 */
	private String handlerphoneno;
	/**
	 * 经办人邮箱地址
	 */
	private String handleremail;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUscc() {
		return uscc;
	}

	public void setUscc(String uscc) {
		this.uscc = uscc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinesslicenseurl() {
		return businesslicenseurl;
	}

	public void setBusinesslicenseurl(String businesslicenseurl) {
		this.businesslicenseurl = businesslicenseurl;
	}

	public String getAccountopeninglicenseurl() {
		return accountopeninglicenseurl;
	}

	public void setAccountopeninglicenseurl(String accountopeninglicenseurl) {
		this.accountopeninglicenseurl = accountopeninglicenseurl;
	}

	public String getLegalrepname() {
		return legalrepname;
	}

	public void setLegalrepname(String legalrepname) {
		this.legalrepname = legalrepname;
	}

	public String getLegalrepid() {
		return legalrepid;
	}

	public void setLegalrepid(String legalrepid) {
		this.legalrepid = legalrepid;
	}

	public String getLegalrepphoneno() {
		return legalrepphoneno;
	}

	public void setLegalrepphoneno(String legalrepphoneno) {
		this.legalrepphoneno = legalrepphoneno;
	}

	public String getLegalrepidpicfronturl() {
		return legalrepidpicfronturl;
	}

	public void setLegalrepidpicfronturl(String legalrepidpicfronturl) {
		this.legalrepidpicfronturl = legalrepidpicfronturl;
	}

	public String getLegalrepidpicbackurl() {
		return legalrepidpicbackurl;
	}

	public void setLegalrepidpicbackurl(String legalrepidpicbackurl) {
		this.legalrepidpicbackurl = legalrepidpicbackurl;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBusinessexpirationdate() {
		return businessexpirationdate;
	}

	public void setBusinessexpirationdate(String businessexpirationdate) {
		this.businessexpirationdate = businessexpirationdate;
	}

	public String getIdcardexpirationdate() {
		return idcardexpirationdate;
	}

	public void setIdcardexpirationdate(String idcardexpirationdate) {
		this.idcardexpirationdate = idcardexpirationdate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public String getPlatformid() {
		return platformid;
	}

	public void setPlatformid(String platformid) {
		this.platformid = platformid;
	}

	public Integer getRoletype() {
		return roletype;
	}

	public void setRoletype(Integer roletype) {
		this.roletype = roletype;
	}

	public String getHandlername() {
		return handlername;
	}

	public void setHandlername(String handlername) {
		this.handlername = handlername;
	}

	public String getHandlerid() {
		return handlerid;
	}

	public void setHandlerid(String handlerid) {
		this.handlerid = handlerid;
	}

	public String getHandlerphoneno() {
		return handlerphoneno;
	}

	public void setHandlerphoneno(String handlerphoneno) {
		this.handlerphoneno = handlerphoneno;
	}

	public String getHandleremail() {
		return handleremail;
	}

	public void setHandleremail(String handleremail) {
		this.handleremail = handleremail;
	}
}
