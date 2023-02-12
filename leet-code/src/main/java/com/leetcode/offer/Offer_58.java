package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author Jack.Wu
 */
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        byte[] newStr = new byte[length];
        byte[] originalStr = s.getBytes();
        for (int i = 0; i < originalStr.length; i++) {
            if (i < n) {
                newStr[length-n+i] = originalStr[i];
            } else {
                newStr[i - n] = originalStr[i];
            }
        }
        return new String(newStr);
    }

    @Test
    public void test_case1() {
        String s1 = "abcdef";
        Offer_58 offer = new Offer_58();
        Assertions.assertEquals("bcdefa", offer.reverseLeftWords(s1, 1));
        Assertions.assertEquals("cdefab", offer.reverseLeftWords(s1, 2));
        Assertions.assertEquals("defabc", offer.reverseLeftWords(s1, 3));
    }
}
