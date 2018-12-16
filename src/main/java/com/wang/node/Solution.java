package com.wang.node;

/**
 * @version ： 1.0.0
 * @package : com.wang.node
 * @progect : quickstart
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月20日上午10:49
 */
public class Solution {

    /**
     * 给定两个非空链表来表示两个非负整数。
     * 位数按照逆序方式存储，它们的每个节点只存储单个数字。
     * 将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null){
            sum /= 10;
            if (c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if ( sum / 10 == 1){
            d.next = new ListNode(1);
        }
        return sentinel.next;

    }
}
