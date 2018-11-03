package com.util;

import com.alibaba.fastjson.JSON;

/**
 * @version ： 1.0.0
 * @package : com.util
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月23日7:26 PM
 */
public class TestDemo {

    public static void main(String[] args) {
        //创建二维数组
        long[][] longs= new long[][]{{1,2},{2,3}};
        System.out.println(JSON.toJSONString(longs));
    }
}
