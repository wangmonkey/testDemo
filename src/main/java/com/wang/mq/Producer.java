package com.wang.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq
 * @progect : testDemo
 * @Description : 消息生成者
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月27日下午4:02
 */
public class Producer {

    public static String QUEUE_NAME = "rabbitMQ";

    public static void main(String[] args) throws Exception{
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(15672);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ";
        //发送消息到队列中
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("Producer Send +'" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }

    @Test
    public void test6(){
        System.out.println(null == null);
    }
}
