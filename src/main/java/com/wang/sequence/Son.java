package com.wang.sequence;

/**
 * @version ： 1.0.0
 * @package : com.wang.sequence
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月23日下午3:52
 */
public class Son extends Parent{
    static {
        System.out.println("static block Son");
    }

    {
        System.out.println("block Son");
    }

    Son(){
        System.out.println("Son");
    }
}
