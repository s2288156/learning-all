package com.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Wu.Chunyang
 */
public class E26RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    @Test
    void test_1() {
        int[] nums = {0, 0, 1, 1, 2, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4};

        int k = removeDuplicates(nums);
        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void test_2() {
        int[] nums = {1, 2};
        int[] expectedNums = {1, 2};

        int k = removeDuplicates(nums);
        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void test_3() {
        int[] nums = {1,1};
        int[] expectedNums = {1};

        int k = removeDuplicates(nums);
        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void test_4() {
        int[] nums = {};

        int k = removeDuplicates(nums);
        Assertions.assertEquals(0, k);
    }
}
