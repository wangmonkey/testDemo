package com.wang.basejava;

import java.util.Date;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日下午3:51
 */
public class CoursePlus {
    private Date BeginTime;
    private String ItemType;
    private CoursePlus coursePlus;

    CoursePlus(Date BeginTime,String ItemType,CoursePlus coursePlus){
        this.BeginTime = BeginTime;
        this.ItemType = ItemType;
        this.coursePlus = coursePlus;
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

    public CoursePlus getCoursePlus() {
        return coursePlus;
    }

    public void setCoursePlus(CoursePlus coursePlus) {
        this.coursePlus = coursePlus;
    }
}
