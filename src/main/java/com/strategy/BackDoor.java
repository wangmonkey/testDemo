package com.strategy;

/**
 * @version ： 1.0.0
 * @package : com.strategy
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月23日11:06 PM
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权压力");
    }
}
