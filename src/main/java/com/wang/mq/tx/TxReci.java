package com.wang.mq.tx;

import com.rabbitmq.client.*;
import com.wang.mq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq.tx
 * @progect : testDemo
 * @Description : 事务接受
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月05日下午5:06
 */
public class TxReci {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg = "hello tx Msg";


        try {
            channel.txSelect();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            channel.txCommit();
        } catch (IOException e) {
            channel.txRollback();
            System.out.println("rec rollback");
            e.printStackTrace();
        }
        //定义一个消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //消息到达触发方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("[1] recive msg : " + msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[1] done");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
