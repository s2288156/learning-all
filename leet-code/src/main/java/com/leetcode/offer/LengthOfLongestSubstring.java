package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 *
 * @author Chunyang.Wu
 */
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        int resp = 0, temp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dict.getOrDefault(s.charAt(j), -1);
            dict.put(s.charAt(j), j);
            temp = j - i > temp ? temp + 1 : j - i;
            resp = Math.max(temp, resp);
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abc"));
    }
}
