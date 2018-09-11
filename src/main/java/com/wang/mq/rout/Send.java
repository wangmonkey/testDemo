package com.wang.mq.rout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wang.mq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq.rout
 * @progect : testDemo
 * @Description : 路由发送者
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月05日下午3:39
 */
public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String msg = "hello,direct";
        String routingKey = "error";
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
