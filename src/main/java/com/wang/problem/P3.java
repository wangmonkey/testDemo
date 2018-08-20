package com.wang.problem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version ： 1.0.0
 * @package : com.wang.problem
 * @progect : quickstart
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年08月20日下午2:31
 */
public class P3 {
    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。   pwwkew   --> wke
     */
    public static int lengthOfLongestSubstring(String s){
        if (null == s || s.length()== 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        int maxLength = 0;
        Map<Integer, Character> map = new LinkedHashMap<>();
        for (int i=0 ; i<s.length() ; i++){
            if (map.containsValue(chars[i])){
                map.clear();
                map.put(count++ , chars[i]);
                s = s.substring(s.indexOf(chars[i])+1);
                i = -1;
                System.out.println(s + "  :  " + maxLength);
                continue;
            } else {
                map.put(++count, chars[i] );
                System.out.println(s + "  :  " + maxLength);
            }
            if (map.size() > maxLength){
                maxLength = map.size();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), count = 0;
        Map<Character, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            count = Math.max(count, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }
}
