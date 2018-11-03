package com.strategy;

/**
 * @version ： 1.0.0
 * @package : com.strategy
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月23日11:10 PM
 */
public class TestStrategy {

    public static void main(String[] args) {
        Context context = null;
        //第一个拆开
        context = new Context(new BackDoor());
        context.operate();

        context = new Context(new GivenGreenLight());
        context.operate();

        context = new Context(new BlockEnemy());
        context.operate();
    }
}
