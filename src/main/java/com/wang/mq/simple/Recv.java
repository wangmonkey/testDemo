package com.wang.mq.simple;

import com.rabbitmq.client.*;
import com.wang.mq.ConnectionUtils;

import java.io.IOException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq.simple
 * @progect : testDemo
 * @Description : 消费获取消息
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月29日下午2:29
 */
public class Recv {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws Exception{
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String stringMsg = new String(body,"utf-8");
                System.out.println(" new api : " + stringMsg);
            }
        };
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }

    private static void testOldMethod() throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //定义队列的消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,queueingConsumer);
        while (true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String msgString = new String(delivery.getBody());
            System.out.println("recv:"+msgString);
        }
    }
}
