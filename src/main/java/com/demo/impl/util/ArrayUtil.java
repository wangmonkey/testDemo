package com.demo.impl.util;

import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */
public class ArrayUtil {

    /**
     * 判断List集合是否空集合(null == list || list.size() == 0)
     * @param list
     * @return 如果是空，则返回true；否则返回false
     */
    public static boolean isNullArray(List list) {
        return (null == list || list.size() == 0);
    }

    /**
     * 判断List集合是否非空集合(null != list && list.size() != 0)
     * @param list
     * @return 如果是空，则返回true；否则返回false
     */
    public static boolean isNotNullArray(List list) {
        return !isNullArray(list);
    }

    /**
     * 判断List集合中每一个元素是否为空
     * @param list
     * @return 如果有一个元素是空，则返回true；否则返回false
     */
    public static boolean isEmptyArray(List list) {
        if (null == list || list.size() == 0) {
            return true;
        }

        for (Object obj:list) {
            if (null == obj || "".equals(obj.toString()))
                return true;
        }

        return false;
    }

    /**
     * 判断List集合中每一个元素是否不为空
     * @param list
     * @return 如果没有素是空，则返回true；否则返回false
     */
    public static boolean isNotEmptyArray(List list) {
        return !isEmptyArray(list);
    }
}
