package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字:
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * @author Jack.Wu
 */
public class Offer_03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            if (cache.contains(num)) {
                return num;
            }else {
                cache.add(num);
            }
        }
        return -1;
    }

    @Test
    public void test_case1() {
        int[] nums = new int[]{1, 3, 4, 2, 3, 2};
        Offer_03 offer03 = new Offer_03();
        Assertions.assertEquals(3, offer03.findRepeatNumber(nums));
    }
}
