package com.platform.modules.enums;

import java.util.Objects;

/**
 * @ClassName AcceptingBankType
 * @Description 承兑机构类型
 * @Author: lilong
 * @Date: 2020/10/17 10:40
 **/
public enum BillType {
    //-1 未知 0 国股 1 大商 2 城商 3 三农 4 村镇 5 外资 6 民营 7 财务（财票） 8 企业（商品）
    DEFAULT(-1, "未知"),
    GG(0, "国股"),
    DS(1, "大商"),
    CS(2, "城商"),
    SN(3, "三农"),
    CZ(4, "村镇"),
    WZ(5, "外资"),
    MY(6, "民营"),
    CW(7, "财务（财票）"),
    QY(8, "企业（商品）");

    private Integer code;
    private String name;

    private BillType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (BillType billType : BillType.values()) {
            if (Objects.equals(billType.getCode(), code)) {
                return billType.getName();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
