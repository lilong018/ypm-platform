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
@Data
@TableName("tb_platform")
public class PlatformEntity implements Serializable {
	private static final long serialVersionUID = 1L;

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

}
