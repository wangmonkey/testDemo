package com.demo.impl.util;

import java.util.regex.Pattern;

/**
 * Created by dell on 2018/8/1.
 */
public class StrUtil {

    /**
     * 判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[-]?[\\d]+");
        return pattern.matcher(str).matches();
    }

    /**
     * 如果是null则返回“”，否则原样返回
     * @param str
     * @return
     */
    public static final String nullToEmptyString(String str) {
        return str == null?"":str;
    }

    /**
     * 如果是null或者是“null”则返回“”，否则原样返回
     * @param str
     * @return
     */
    public static final String nullStringToEmptyString(String str) {
        return str != null && !"null".equalsIgnoreCase(str)?str:"";
    }

    /**
     * 判断两个字符串是否相等（包含null和“”）
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        str1 = nullToEmptyString(str1);
        str2 = nullToEmptyString(str2);
        return str1.equals(str2);
    }

    /**
     * 判断两个字符串是否相等（忽略大小写，且包含null，“”）
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        str1 = nullToEmptyString(str1);
        str2 = nullToEmptyString(str2);
        return str1.equalsIgnoreCase(str2);
    }

    /**
     * 判断两个字符串是否相等（忽略大小写，且包含null，“”和“null”）
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsNullIgnoreCase(String str1, String str2) {
        str1 = nullStringToEmptyString(str1);
        str2 = nullStringToEmptyString(str2);
        return str1.equals(str2);
    }

    /**
     * 判断字符串是否为null或者（单个或前后包含多个“ ”）“”
     * @param value
     * @return
     */
    public static boolean isNullStr(String value) {
        return value == null || value.trim().equals("");
    }

    /**
     * 判断字符串是否为null、“”和“null”
     * @param value
     * @return
     */
    public static boolean isEquateNullStr(String value) {
        return equalsNullIgnoreCase((String)null, value);
    }


    /**
     * 根据正则表达式拆分字符串
     * @param src
     * @param regx
     * @return
     */
    public String[] splitString(String src, String regx) {

        String[] stringArr = null;

        if (null == src) {
            return stringArr;
        }

        if(null == regx) {
            return new String[]{src};
        }

        return src.split(src);
    }
}
