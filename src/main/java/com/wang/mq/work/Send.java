package com.wang.mq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wang.mq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq.work
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月30日下午2:28
 */
public class Send {

    private static final String QUENE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUENE_NAME,false,false,false,null);

        for (int i = 0 ; i<50; i++){
            String msg = "hello , " + i;
            System.out.println("[WQ] is send" + i);
            channel.basicPublish("",QUENE_NAME,null,msg.getBytes());
            Thread.sleep(i * 20);
        }
        channel.close();
        connection.close();
    }
}
