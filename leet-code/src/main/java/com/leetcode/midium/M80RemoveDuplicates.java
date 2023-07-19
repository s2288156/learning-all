package com.leetcode.midium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Wu.Chunyang
 */
public class M80RemoveDuplicates {

    /**
     * 1,2,3
     * 1, 1, 1, 2, 2, 3
     * 1,1,2,2,3,3,4
     * 1,1,1,1,1,2,2,3,4
     */
    public static int solution(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int slow = 2, fast = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public int removeDuplicates(int[] nums) {
        return solution(nums);
    }

    @Test
    void test_case1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int len = solution(nums);
        assertEquals(5, len);
        int[] expectedNums = {1, 1, 2, 2, 3};
        for (int i = 0; i < len; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void test_case2() {
        int[] nums = {1, 2, 3};
        int len = solution(nums);
        assertEquals(3, len);
        int[] expectedNums = {1, 2, 3};
        for (int i = 0; i < len; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

}
