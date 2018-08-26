package com.wang.LinkNode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @version ： 1.0.0
 * @package : com.wang.LinkNode
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月21日下午3:49
 */
public class TestDemo {

    @Test
    public void test1(){
        System.out.println("-----  start  -------");
        StackSingleLink stackSingleLink = new StackSingleLink();
        stackSingleLink.display();
        System.out.println(stackSingleLink.isEmpty());
        stackSingleLink.push(123);
        stackSingleLink.push(34);
        stackSingleLink.display();

        HashMap<String, Object> hashMap = new HashMap<>(16);

        hashMap.put("haha",1223);
    }

}
