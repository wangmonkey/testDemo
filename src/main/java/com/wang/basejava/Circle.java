package com.wang.basejava;

import org.junit.jupiter.api.Test;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description : 循环
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月02日下午12:56
 */
public class Circle {

    @Test
    public void testLabel(){
        int i = 0,j=0;
        label:while (true){
            //第一层循环
            while (true){
                //第二层循环
                if (j*i == 81){
                    break  label;
                }
                i++;
                j++;
                System.out.println("over : " + i);
            }

        }
    }
}
