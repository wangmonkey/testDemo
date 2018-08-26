package com.wang.sequence;

/**
 * @version ： 1.0.0
 * @package : com.wang.sequence
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月23日下午3:48
 */
public class Parent {

    static {
        System.out.println("static block Parent");
    }

    {
        System.out.println("block Parent");
    }

    Parent(){
        System.out.println("Parent");
    }
}
