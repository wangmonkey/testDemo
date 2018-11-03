package com.strategy;

/**
 * @version ： 1.0.0
 * @package : com.strategy
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月23日11:09 PM
 */
public class BlockEnemy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("孙小妹放行");
    }
}
