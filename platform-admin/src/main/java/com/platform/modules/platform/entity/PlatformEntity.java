package com.platform.modules.platform.entity;

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
 * @date 2020-08-05 11:33:42
 */
@TableName("tb_platform")
public class PlatformEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIELD_NAME = "name";

	/**
	 * 平台id
	 */
	@TableId
	private String id;
	/**
	 * 平台名称
	 */
	private String name;
	/**
	 * 网络名称
	 */
	private String website;
	/**
	 * 负责人
	 */
	private String manager;
	/**
	 * 联络电话
	 */
	private String phoneno;
	/**
	 * 平台状态（1：在线，2：离线）
	 */
	private Integer status;
	/**
	 * 是否为有效平台
	 */
	private String valid;
	/**
	 * 创建时间
	 */
	private Date createtimeinmillis;

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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public Date getCreatetimeinmillis() {
		return createtimeinmillis;
	}

	public void setCreatetimeinmillis(Date createtimeinmillis) {
		this.createtimeinmillis = createtimeinmillis;
	}
}
