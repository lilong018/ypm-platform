package com.platform.modules.employee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ll
 * @email 
 * @date 2020-08-06 15:57:09
 */
@TableName("tb_employee")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 员工ID
	 */
	@TableId(value = "id",type = IdType.INPUT)
	private String id;
	/**
	 * 员工姓名
	 */
	private String name;
	/**
	 * 性别（0：未知，1：男，2：女）
	 */
	private Integer gender;
	/**
	 * 部门（ 0: 未知 1: 管理部门  2: 客服  3:财务）
	 */
	private Integer department;
	/**
	 * 手机号码
	 */
	private String phoneNo;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 职称
	 */
	private String title;
	/**
	 * 照片
	 */
	private String photourl;
	/**
	 * 状态（1：启用，2：停用）
	 */
	private Integer status;
	/**
	 * 平台id
	 */
	private String platformid;
	/**
	 * 到职时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date onboardtimeinmillis;
	/**
	 * 离职时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lefttimeinmillis;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPlatformid() {
		return platformid;
	}

	public void setPlatformid(String platformid) {
		this.platformid = platformid;
	}

	public Date getOnboardtimeinmillis() {
		return onboardtimeinmillis;
	}

	public void setOnboardtimeinmillis(Date onboardtimeinmillis) {
		this.onboardtimeinmillis = onboardtimeinmillis;
	}

	public Date getLefttimeinmillis() {
		return lefttimeinmillis;
	}

	public void setLefttimeinmillis(Date lefttimeinmillis) {
		this.lefttimeinmillis = lefttimeinmillis;
	}

	public Date getCreatetimeinmillis() {
		return createtimeinmillis;
	}

	public void setCreatetimeinmillis(Date createtimeinmillis) {
		this.createtimeinmillis = createtimeinmillis;
	}
}
