package com.strategy;

/**
 * @version ： 1.0.0
 * @package : com.strategy
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月23日11:08 PM
 */
public class GivenGreenLight implements IStrategy{

    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
}
