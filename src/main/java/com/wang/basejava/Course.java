package com.wang.basejava;

import java.util.Date;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日下午3:27
 */
public class Course {

    private Date BeginTime;
    private String ItemType;

    Course(Date BeginTime,String ItemType){
        this.BeginTime = BeginTime;
        this.ItemType = ItemType;

    }
    public Date getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(Date beginTime) {
        BeginTime = beginTime;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }
}
