package com.wang.kafuka;

import com.wang.mq.Producer;
import org.apache.commons.codec.StringEncoder;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * @version ： 1.0.0
 * @package : com.wang.kafuka
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月10日下午11:01
 */
public class KafkaProducer extends Thread {
    private String topic;

    public KafkaProducer(String topic){
        super();
        this.topic = topic;
    }

    @Override
    public void run() {

    }

    private Producer createProducer(){
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "192.168.205.153:2181");//声明zk
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("metadata.broker.list", "192.168.205.153:9092");// 声明kafka broker
        return null;

    }


    public static void main(String[] args) {
    }
}
