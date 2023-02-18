package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author Jack.Wu
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (!map.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (map.get(c) == 1) {
                    return c;
                }
            }
        }
        return ' ';
    }

    @Test
    public void test_case1() {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        Assertions.assertEquals('b', firstUniqChar.firstUniqChar("abaccdeff"));
        Assertions.assertEquals('l', firstUniqChar.firstUniqChar("leetcode"));
    }

    @Test
    public void test_case2() {
        String s = "aabbcc";
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        Assertions.assertEquals(' ', firstUniqChar.firstUniqChar(s));
    }
}
