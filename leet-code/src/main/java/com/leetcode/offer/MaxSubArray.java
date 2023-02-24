package com.leetcode.offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * @author Wu.Chunyang
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int i = nums.length-1;
        /**
         * dp[i] = dp[i-1] + nums[i-1]
         */
        return -1;
    }
}
