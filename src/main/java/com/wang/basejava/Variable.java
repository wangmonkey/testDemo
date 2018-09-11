package com.wang.basejava;


import com.wang.entity.User;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description : 变量
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月02日下午5:02
 */
public class Variable {
    public static void main(String[] args) {
        String str1 = new String("123");
        String str2 = str1;
        str1 = "2343";
        System.out.println(str2);

        User user = new User();
        user.setName("he");
        User user1 = user;
        user1.setName("hello");
        System.out.println(user.getName());
    }
}
