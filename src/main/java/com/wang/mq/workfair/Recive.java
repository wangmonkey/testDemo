package com.wang.mq.workfair;

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
        final Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUENE_NAME,false,false,false,null);

        //保证一次只发送一个
        channel.basicQos(1);
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
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        //自动应答
        boolean autoAck = false;
        channel.basicConsume(QUENE_NAME,autoAck,consumer);
    }
}
