package com.wang.thread;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * @version ： 1.0.0
 * @package : com.wang.thread
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月22日下午11:18
 */
public class TestCallableAndFuture {

    public static void main(String[] args) throws Exception{
        //需求：两个线程分别计算1-50 和 50-100 的和，最终再进行统计

        ExecutorService es = newFixedThreadPool(2);
        Callable task1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i=0 ; i<=50 ; i++){
                    sum += i;
                }
                return sum;
            }
        };

        Callable task2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i=51 ; i<=100 ; i++){
                    sum += i;
                }
                return sum;
            }
        };

        Future f1 = es.submit(task1);
        Future f2 = es.submit(task2);
        System.out.println("f1 : " + f1.get());
        System.out.println("f2 : " + f2.get());
        System.out.println("f1 + f2:"+ ((int)f1.get() + (int)f2.get()));
    }
}
