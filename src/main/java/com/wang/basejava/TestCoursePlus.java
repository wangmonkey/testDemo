package com.wang.basejava;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日下午3:54
 */
public class TestCoursePlus {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CoursePlus c4 = new CoursePlus(sdf.parse("2016-10-17"), "第一节课", null);
        CoursePlus c3 = new CoursePlus(sdf.parse("2016-10-14"), "第一节课", c4);
        CoursePlus c2 = new CoursePlus(sdf.parse("2016-10-13"), "第一节课", c3);
        CoursePlus c1 = new CoursePlus(sdf.parse("2016-10-11"), "第一节课", c2);
        System.out.println(JSON.toJSONString(c1));
        //补全
        //获取十月份的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("2016-10"));
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i<days ; i++){
            //四个一循环
            
        }

    }
}
