package com.wang.basejava;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日下午3:28
 */
public class TestCourder {

    public static void main(String[] args) throws ParseException {
        List<Course> arrList = new ArrayList<Course>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        arrList.add(new Course(sdf.parse("2016-11-11"),"第一节课"));
        arrList.add(new Course(sdf.parse("2016-11-13"),"第二节课"));
        arrList.add(new Course(sdf.parse("2016-11-14"),"第三节课"));
        arrList.add(new Course(sdf.parse("2016-11-17"),"第四节课"));
        System.out.println(JSON.toJSON(arrList));
        Date begin = sdf.parse("2016-10-20");
        Date end = sdf.parse("2016-11-20");
        //查询
        for (int i=0; i<arrList.size(); i++){
            if (arrList.get(i).getBeginTime().getTime()<begin.getTime() || arrList.get(i).getBeginTime().getTime()>end.getTime()){
                arrList.remove(i);
            }
        }
        //打印查询结果
        System.out.println(JSON.toJSONString(arrList));
    }

    @Test
    public void test1(){

    }

}
