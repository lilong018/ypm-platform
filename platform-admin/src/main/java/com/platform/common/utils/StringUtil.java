package com.platform.common.utils;

public class StringUtil extends org.apache.commons.lang3.StringUtils{

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     *
     * @param s
     * @return
     * @author Robin Chang
     */
    public static boolean isEmpty(String s) {
        if (s != null && !s.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 判断对象是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(Object str) {
        boolean flag = true;
        if (str != null && !str.equals("")) {
            if (str.toString().length() > 0) {
                flag = true;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public static long toLong(String s) {
        try {
            if (s != null && !"".equals(s.trim()))
                return Long.parseLong(s);
        } catch (Exception exception) {
        }
        return 0L;
    }
}
