package com.wang.testproblems;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestProblems {

    /**
     *
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {

        int[] temp = new int[2];
        if (nums == null){
            return null;
        }
        int count = 0;
        for (int i=0 ; i<nums.length ; i++){
            for (int j = i; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    temp[count ++ ] = i;
                    temp[count ++ ] = j;
                    return temp;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{};
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        int i = 0;
        for ( ; i<nums.length ; i++){
            int temp = target - nums[i];
            if (cache.containsKey(temp)){
                System.out.println("循环的次数为：" + i);
                return new int[]{i,cache.get(temp)};
            }
            cache.put(nums[i],i);
        }
        System.out.println("循环的次数为：" + i);
        return new int[]{};
    }

    /**
     * 暴力方法
     */
    public int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表
     */
    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     */
    public int[] twoSum5(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    @Test
    public void testTwoSum(){
       int[] a = {2,7,11,15};
       System.out.println(JSON.toJSONString(twoSum5(a,9)));
    }
}
