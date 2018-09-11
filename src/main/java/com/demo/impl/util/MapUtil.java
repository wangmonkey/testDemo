package com.demo.impl.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/5.
 */
public class MapUtil {

    /**
     * 根据map的Value取出所有的Key(key为字符串，去除所有key为null的键值对)
     *
     * @param map
     * @param value
     * @return
     */
    public static List<String> getKeyByValue(Map map, String value) {

        if (null == map || map.isEmpty()) {
            return null;
        }

        List<String> valueList = new ArrayList<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String obj = (String) entry.getValue();
            if (obj != null && obj.equals(value)) {
                valueList.add((String) entry.getKey());
            }
        }
        return valueList;
    }
}
