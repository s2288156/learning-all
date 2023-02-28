package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * @author Wu.Chunyang
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] sumNums = new int[nums.length];
        sumNums[0] = nums[0];
        int max = sumNums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sumNums[i - 1] > 0) {
                sumNums[i] = sumNums[i - 1] + nums[i];
            } else {
                sumNums[i] = nums[i];
            }
            max = Math.max(max, sumNums[i]);
        }
        return max;
    }

    @Test
    void test_case1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
        Assertions.assertEquals(6, maxSubArray.maxSubArray(nums));
    }

}
