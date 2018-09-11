package com.wang.basejava;

import org.junit.jupiter.api.Test;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description : 测试函数
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日下午2:56
 */
public class TestFunction {

    private void testRundomParams(int ... values){
        System.out.println(values[0]);
    }
    @Test
    public void test1(){
        testRundomParams(1);
    }
}
