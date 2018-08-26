package com.wang.thread;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

/**
 * @version ： 1.0.0
 * @package : com.wang.thread
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月22日下午6:06
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<50 ; i++){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " Task1: "+ i);
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<50 ; i++){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " Task2: "+ i);
                }
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<50 ; i++){
                    System.out.println(Thread.currentThread().getName() + " Task3: "+ i);
                }
            }
        };

        ExecutorService es = newFixedThreadPool(2);
        es.submit(task1);
        es.submit(task2);
        es.submit(task3);
    }
}
