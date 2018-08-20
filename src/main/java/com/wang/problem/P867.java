package com.wang.problem;

/**
 * @version ： 1.0.0
 * @package : com.wang.problem
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月20日16:34
 */
public class P867 {
    public static void main(String [] args) {
        int data [][] = new int [] [] { { 1, 2, 3 }, { 4, 5, 6 } } ;
        int[][] transpose = transpose(data);
        print1(transpose);
    }

    // 将矩阵转置
    public static void reverse(int temp [][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp[i].length; j++) {
                int k = temp[i][j] ;
                temp[i][j] = temp[j][i] ;
                temp[j][i] = k ;
            }
        }
    }

    // 将矩阵输出
    public static void print1(int temp [][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + "\t") ;
            }
            System.out.println() ;
        }
    }
    public static int[][] transpose(int[][] A) {
        if (null == A){
            return new int[][]{};
        }
        int[][] temp = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                temp[j][i] = A[i][j];
            }
        }
        return temp;
    }
}
