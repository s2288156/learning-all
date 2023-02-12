package com.leetcode.offer;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Offer_05 {
    public String replaceSpace(String s) {
        int length = s.length();
        byte[] newStr = new byte[length * 3];
        int index = 0;
        for (byte aByte : s.getBytes(StandardCharsets.UTF_8)) {
            if (aByte == 32) {
                newStr[index++] = 37;
                newStr[index++] = 50;
                newStr[index++] = 48;
            } else {
                newStr[index++] = aByte;
            }
        }
        return new String(newStr, 0, index);
    }

    @Test
    public void test_case1() {
        Offer_05 offer05 = new Offer_05();
        String s = "a b";
        System.out.println(offer05.replaceSpace(s));
    }
}
