package com.leetcode.midium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/rotate-array/">189. 轮转数组</a>
 *
 * @author Wu.Chunyang
 */
public class M189Rotate {
    public static void main(String[] args) {
        System.out.println(2 % 3);
    }

    public static void bubble(int[] nums, int k) {
        k = k % nums.length;

    }

    public static void function2(int[] nums, int k) {

    }

    public static void function3(int[] nums, int k) {

    }

    @Test
    void test_bubble() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        bubble(nums, 3);
        int[] exceptedNums = {5, 6, 7, 1, 2, 3, 4};
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(exceptedNums[i], nums[i]);
        }
    }
}
