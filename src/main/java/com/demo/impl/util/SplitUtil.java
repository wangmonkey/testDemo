package com.demo.impl.util;

/**
 * Created by dell on 2018/7/30.
 */
public class SplitUtil {

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
