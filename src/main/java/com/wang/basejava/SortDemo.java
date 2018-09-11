package com.wang.basejava;

import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import java.util.Scanner;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description : 排序
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月03日上午9:59
 */
public class SortDemo {

    @Test
    public void test(){
        System.out.println(1+1);
    }

    /**
     * 数组遍历
     */
    public void printArray(double[] doubles){
        if (ObjectUtils.isEmpty(doubles) || doubles.length == 0){
            System.out.println("当前数组为空");
            return;
        }
        System.out.printf("[");
        for (int i=0 ; i<doubles.length ; i++){
            System.out.printf(doubles[i]+",");
        }
        System.out.println("]");
        return;
    }

    /**
     * 排序交换
     */
    public void swap(double A[], int i, int j)
    {
        double temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    /**
     * 冒泡
     */
    public double[] bubbleSort(double[] arrDouble){
        System.out.println("传入数组");
        for (int i=0 ; i<arrDouble.length-1 ; i++){
            for (int j=0 ; j<arrDouble.length-1-i ; j++){
                if (arrDouble[j] > arrDouble[j+1]){
                    swap(arrDouble,j,j+1);
                }
            }
        }
        return arrDouble;
    }

    /**
     * 快速排序
     */
    public static void main(String[] args) {
        System.out.println("please enter one number : ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
    }
}
