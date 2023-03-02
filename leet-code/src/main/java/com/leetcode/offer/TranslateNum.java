package com.leetcode.offer;

import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * @author Wu.Chunyang
 */
public class TranslateNum {
    public int translateNum(int num) {
        int[] nums = String.valueOf(num).chars().map(ch -> Character.digit(ch, 10)).toArray();
        int a = 1, b = 1;
        for (int i = 2; i <= nums.length; i++) {
            int temp = isDoubleNum(nums, i-1) ? a + b : a;
            b = a;
            a = temp;
        }
        return a;
        // return implFirst(nums);
    }

    private int implFirst(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                if (isDoubleNum(nums, i)) {
                    dp[i] = 2;
                } else {
                    dp[i] = 1;
                }
            } else {
                if (isDoubleNum(nums, i)) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[nums.length - 1];
    }

    private boolean isDoubleNum(int[] nums, int i) {
        return nums[i - 1] * 10 + nums[i] > 9 && nums[i - 1] * 10 + nums[i] < 26;
    }

    @Test
    void test_case1() {
        System.out.println(new TranslateNum().translateNum(25));
    }
}
