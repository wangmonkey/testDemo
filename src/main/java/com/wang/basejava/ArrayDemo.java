package com.wang.basejava;

import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import java.util.Scanner;

/**
 * @version ： 1.0.0
 * @package : com.wang.basejava
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年09月02日下午5:27
 */
public class ArrayDemo {

    @Test
    public void test1(){
        int size = 10;
        double[] doubles = new double[10];
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请选择要输入的元素位置：");
            int index = scanner.nextInt();
            if (index <= doubles.length){
                System.out.println("输入的位置超出下标。");
                continue;
            }
            System.out.println("您输入的位置正合适，请输入一个数值");
            doubles[index] = scanner.nextDouble();
            arrayScan(doubles);
            continue;

        }
    }

    public static void main(String[] args) {
        int size = 10;
        double[] doubles = new double[10];
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请选择要输入的元素位置：");
            int index = scanner.nextInt();
            if (index >= doubles.length){
                System.out.println("输入的位置超出下标。");
                continue;
            }
            System.out.println("您输入的位置正合适，请输入一个数值");
            doubles[index] = scanner.nextDouble();
            arrayScan(doubles);
            continue;
        }
    }
    private static void arrayScan(double[] arr){
        if (!ObjectUtils.isEmpty(arr) || arr.length == 0){
            System.out.println("当前数组为空");
        }
        for (int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    @Test
    public void test2(){

    }
}
