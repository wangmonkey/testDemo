package com.wang.config;

import com.wang.config.rabbitmq.RabbitmqConfig;
import org.junit.jupiter.api.Test;

/**
 * @version ： 1.0.0
 * @package : com.wang.config
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月27日下午2:45
 */
public class Demo {

    @Test
    public void test(){
        RabbitmqConfig rabbitmqConfig = new RabbitmqConfig();
        System.out.printf(rabbitmqConfig.getHost());

    }
}
