package com.strategy;

/**
 * @version ： 1.0.0
 * @package : com.strategy
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月23日11:11 PM
 */
public class Context {
    /**
     * 构造方法，你要使用哪个妙计
     */
    private IStrategy iStrategy;

    public Context(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }

    /**
     * 使用妙计
     */
    public void operate(){
        this.iStrategy.operate();
    }
}
