package com.demo.impl.util;

/**
 * Created by Administrator on 2018/8/5.
 */
public class LetterTransferUtil {

    /**
     * 将单词转化成首字母大写，其余字母不变(去除前后空格)
     * @param str
     * @return
     */
    public static String toOnlyFirstUpper(String str) {

        // 非空判断
        if (null == str || "".equals(str.trim())) {
            return null;
        } else if (str.length() == 1) {
            return str.toUpperCase();
        }

        StringBuilder sb = new StringBuilder();

        // 取出单词首字母并转化成大写
        String firstLetter = str.substring(0, 1).toUpperCase();

        // 取出单词首字母以后的单词
        String leftLetter = str.substring(1);

        // 将首字母和首字母后面的字母拼接起来
        sb.append(firstLetter+leftLetter);

        return sb.toString();
    }

    /**
     * 将单词转化成首字母大写，其余字母小写(去除前后空格)
     * @param str
     * @return
     */
    public static String toFirstUpper(String str) {

        // 非空判断
        if (null == str || "".equals(str.trim())) {
            return null;
        } else if (str.length() == 1) {
            return str.toUpperCase();
        }

        StringBuilder sb = new StringBuilder();

        // 去除前后空格后，将单词全部转化成小写
        str = str.trim().toLowerCase();

        // 取出单词首字母并转化成大写
        String firstLetter = str.substring(0, 1).toUpperCase();

        // 取出单词首字母以后的单词
        String leftLetter = str.substring(1);

        // 将首字母和首字母后面的字母拼接起来
        sb.append(firstLetter+leftLetter);

        return sb.toString();
    }
}
