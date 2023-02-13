package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author Wu.Chunyang
 */
public class Offer_53 {
    public int search(int[] nums, int target) {
        int targetIndex = binarySearch(nums, target);
        if (targetIndex < 0) {
            return 0;
        }
        int leftTimes = 0;
        int rightTimes = 0;
        for (int i = targetIndex - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            leftTimes++;
        }
        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            rightTimes++;
        }
        return leftTimes + rightTimes + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test_case1() {
        int[] nums = new int[]{1, 3, 3, 4, 5};
        Offer_53 offer53 = new Offer_53();
        Assertions.assertEquals(2, offer53.search(nums, 3));
        Assertions.assertEquals(1, offer53.search(nums, 1));
        Assertions.assertEquals(1, offer53.search(nums, 4));
        Assertions.assertEquals(1, offer53.search(nums, 5));
    }

    @Test
    public void test_case2() {
        int[] nums = new int[]{3, 3, 3};
        Offer_53 offer53 = new Offer_53();
        Assertions.assertEquals(3, offer53.search(nums, 3));
    }

}
