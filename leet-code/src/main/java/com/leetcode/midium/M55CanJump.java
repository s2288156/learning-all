package com.leetcode.midium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Wu.Chunyang
 */
public class M55CanJump {

    public static boolean func2(int[] nums) {
        int rightmost = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean func1(int[] nums) {
        int location = 0, stepNum = nums[location], length = nums.length;
        if (length == 1) {
            return true;
        }
        return jump(nums, location, stepNum);
    }

    private static boolean jump(int[] nums, int location, int stepNum) {
        while (stepNum > 0) {
            if (location + stepNum < nums.length - 1 && nums[location] != 0) {
                if (jump(nums, location + stepNum, nums[location + stepNum])) {
                    return true;
                }
            }
            if (location + stepNum >= nums.length - 1) {
                return true;
            }
            stepNum--;
        }
        return false;
    }

    @Test
    void test() {
        Assertions.assertTrue(func2(new int[]{2, 3, 1, 1, 4}));
        Assertions.assertTrue(func2(new int[]{1}));
        Assertions.assertTrue(func2(new int[]{0}));
        Assertions.assertTrue(func2(new int[]{2, 9, 1, 0, 1}));
        Assertions.assertFalse(func2(new int[]{3, 2, 1, 0, 4}));
        Assertions.assertTrue(func2(new int[]{2, 2, 4, 0, 4}));
        Assertions.assertFalse(func2(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0}));
        Assertions.assertTrue(func2(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    @Test
    void test2() {
        int[] nums = new int[10002];
        for (int i = 9999; i > 0; i--) {
            nums[i] = i;
        }
        System.out.println(func2(nums));
    }
}
