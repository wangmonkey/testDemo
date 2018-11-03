package com.wang.redis;


import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @version ： 1.0.0
 * @package : com.wang.redis
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日下午9:52
 */
public class TestRedis {
    @Test
    public void test1(){
        Jedis jedis = new Jedis();
        jedis.set("wang","123","xx","px",10000);
        jedis.set("wang","1234","nx","px",20000);
    }
}
