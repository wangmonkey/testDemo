package com.wang.node;

import lombok.Data;

/**
 * @version ： 1.0.0
 * @package : com.wang.node
 * @progect : quickstart
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月20日上午10:47
 */
@Data
public class ListNode {

    private int val;
    private ListNode next;
    private ListNode(int x){
        val = x;
    }
}