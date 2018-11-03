package com.wang.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月29日下午2:10
 */
public class ConnectionUtils {

    /**
     * 获取MQ的链接
     */
    public static Connection getConnection() throws IOException, TimeoutException {
         //定一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("http://192.168.40.247");
        factory.setPort(15672);
        factory.setVirtualHost("/");
        //用户名  密码
        factory.setUsername("admin");
        factory.setPassword("admin");
        return factory.newConnection();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println(getConnection());
    }
}
