package com.wang.mq.work;

import com.rabbitmq.client.*;
import com.wang.mq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq.work
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月30日下午2:32
 */
public class Recive {

    private static final String QUENE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //获取channel
        Channel channel = connection.createChannel();
        boolean durable = false;

        /**
         * 消息的持久化
         * 我们将程序中的boolean durable = false; 改成true;是不可以的，尽管代码是正确的
         * 他也不会运行成功！因为我们已经定义了一个叫test_work_queue 这个队列是未持久化，rabbitMQ不准许
         * 重新定义（不同参数）一个已存在的队列
         */

        //声明队列
        channel.queueDeclare(QUENE_NAME,durable,false,false,null);

        //定义一个消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //消息到达触发方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("[1] recive msg : " + msg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[1] done");
                }
            }
        };
        boolean autoAck = true;
        channel.basicConsume(QUENE_NAME,autoAck,consumer);
    }
}
