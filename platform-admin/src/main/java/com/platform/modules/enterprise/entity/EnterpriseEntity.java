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
 * @date 2020-07-08 09:03:00
 */
@Data
@TableName("tb_enterprise")
public class EnterpriseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

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

}
