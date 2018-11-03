package com.wang.basejava;

import com.alibaba.fastjson.JSON;
import com.entity.user.User;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月12日下午2:02
 */
public class TestCollection {

    @Test
    public void testSet(){
        System.out.println("test +++++++++ ");
        Collection<Long>  collection = new HashSet<Long>();
        collection.add(12L);
        System.out.println(JSON.toJSON(collection));
        System.out.println(collection.contains(12L));
        collection = new ArrayList<Long>();
        collection = new ArrayBlockingQueue<Long>(12);
        collection.add(13L);
        System.out.println(collection.getClass().getName());
        System.out.println(collection.size());
        System.out.println(collection.getClass().hashCode());
    }

    @Test
    public void test2(){
        HashSet<Long> longs = new HashSet<>();
        longs.add(12L);
        longs.add(13L);
        longs.add(14L);
        longs.add(15L);
        longs.add(16L);
        Long s = 0L;
        longs.forEach(obj -> System.out.println(obj));
    }

    @Test
    public void testIterator(){
        Collection<User> users = new HashSet<User>();

        users.add(new User("zhangsan","男",12,new Date()));
        users.add(new User("zhangsan","男",12,new Date()));
        users.add(new User("zhangsan","男",12,new Date()));
        users.add(new User("zhangsan","男",12,new Date()));
        users.add(new User("zhangsan","男",12,new Date()));
        users.add(new User("zhangsan","男",12,new Date()));
        users.add(new User("zhangsan","男",12,new Date()));

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = (User)iterator.next();
            System.out.println(JSON.toJSONString(user));
        }

        System.out.println();
    }

    @Test
    public void test(){
        double a = 0.7d;
        double b = 0.1d;
        double c = 0.8d;
        double d = 0.2d;
        System.out.println(a+b);
        System.out.println(c+d);
    }

    @Test
    public void test3(){
        System.out.println(2<<3);
        System.out.println(-2>>>3);
        System.out.println(Integer.toBinaryString(121));
    }

    @Test
    public void test4(){
        Course course = new Course(new Date(),"wang");
        Course course1 = course;
        course1.setItemType("hah");
        System.out.println(JSON.toJSONString(course));

    }

    @Test
    public void test5(){
        BaseParent baseParent = new Son();
        System.out.println(baseParent.getSex());
        String s = "21";
        String s1 = s;
        s1 = "1111";
        System.out.println(s);
        String s3 = new String("123");
        String s4 = s3;
        s4.concat("122");
        System.out.println(s3);

    }

    @Test
    public void test6(){
        Set<Integer> s = new HashSet<Integer>();
        s.add(12);
        s.add(1);
        s.add(1);
        for (Integer i : s) {
            System.out.println(i);
        }
    }
}
