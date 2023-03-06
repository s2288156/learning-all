package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author Wu.Chunyang
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] resp = null;
        int i = 0, j = nums.length - 1;
        while (resp == null) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                resp = new int[]{nums[i], nums[j]};
            }
        }
        return resp;
    }

    @Test
    void test_case1() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 3, 5, 7, 9};
        int[] result = twoSum.twoSum(nums, 12);
        Assertions.assertEquals(3, result[0]);
        Assertions.assertEquals(9, result[1]);
    }
    @Test
    void test_case2() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,9};
        int[] result = twoSum.twoSum(nums, 12);
        Assertions.assertEquals(3, result[0]);
        Assertions.assertEquals(9, result[1]);
    }
}
