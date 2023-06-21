package com.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Wu.Chunyang
 */
public class E27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int newIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++newIndex] = nums[i];
            }
        }
        return newIndex + 1;
    }

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 1, 5};
        int val = 1;
        E27RemoveElement solution = new E27RemoveElement();
        int newLength = solution.removeElement(nums, val);
        Assertions.assertEquals(3, newLength);
        Assertions.assertEquals(3, nums[0]);
        Assertions.assertEquals(5, nums[1]);
        Assertions.assertEquals(5, nums[2]);
    }
}
