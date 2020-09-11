package com.platform.common.model;

/**
 * @author ll
 * @description url地址集合
 * @time 2020/7/2 10:50
 */
public class UrlConstans {
    public static final String BASEURL = "https://192.168.68.129:8889";
    // 获取短信验证码
    public final static String USER_CODE = "/users/code";
    // 用户注册
    public final static String USER_REGISTER = "/users/register";
    //重置密码
    public final static String RESET_PASSWORD = "/users/me";
    //忘记密码
    public final static String FORGET_PASSWORD = "/users/forgotPwd";
    //登录
    public final static String LOGIN = "/users/login";
    //员工
    public final static String EMPLOYEES = "/employees";

    //新增企业认证
    public final static String UPLOAD_ENTERPRISE = "/enterprises";




    //根据支付工具查询渠道发卡机构列表
    public final static String ISSUERS = "/banks/pi";
    //全量查询省份信息
    public final static String MAPI_PROVINCE = "/banks/province";
    //根据省份id查询城市信息
    public final static String MAPI_CITY = "/banks/city";
    //根据城市id、银行编码和银行简码查询联行信息
    public final static String MAPI_BANK = "/banks/bank";


    //票据
    public final static String BILLS = "/bills";
    //我的票据
    public final static String MY_BILL = "/bills/me";

    //消息
    public final static String MESSAGE = "/messages/me";


    //订单
    public final static String ORDER = "/orders";
    //我的订单
    public final static String MYORDER = "/orders/me";

    //平台
    public final static String PLATFORM = "/platforms";

    //获取收银台地址
    public final static String CASHIERURL = "/transactions/cashierUrl";
    //智票通过省ID获取城市
    public final static String PROVINCECITY = "/transactions/provincecity";

    public final static String BANKCNAP = "/transactions/bankcnap";
    public final static String JDZPBANKS = "/transactions/bank";

    // 交易
    public final static String TRANSACTIONS = "/transactions";


}
