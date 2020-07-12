package com.platform.modules.bill.entity;

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
 * @date 2020-07-12 15:51:47
 */
@Data
@TableName("tb_bill")
public class BillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

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
	private String acceptingbanktype;
	/**
	 * 票面金额
	 */
	private String amount;
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
	private String channeltype;
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
	private Integer returnendorsementstatus;
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
	private Integer feededuction;
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

}
