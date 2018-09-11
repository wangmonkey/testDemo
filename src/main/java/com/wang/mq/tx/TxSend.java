package com.wang.mq.tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wang.mq.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version ： 1.0.0
 * @package : com.wang.mq.tx
 * @progect : testDemo
 * @Description : 事务发送
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月05日下午4:59
 */
public class TxSend {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg = "hello, txSend";

        try {
            channel.txSelect();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            channel.txCommit();
        } catch (IOException e) {
            channel.txRollback();
            System.out.println("send Msg rollback");
            e.printStackTrace();
        }
        channel.close();
        connection.close();
    }
}
