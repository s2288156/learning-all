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
        int length = 8, k = 3;
        for (int i = 0; i < length; i++) {
            System.out.println((k + i) % length);
        }
    }

    public static void bubble(int[] nums, int k) {
        int length = nums.length;
        if (length <= 1 || k == 0 || k == length) {
            return;
        }
        k = k % length;
        for (int j = 0; j < length / k - 1; j++) {
            swap(nums, length - 1 - k * j, k);
        }
        for (int i = length % k - 1; i >= 0; i--) {
            int a;
            for (int j = 0; j < k; j++) {
                a = nums[i + j];
                nums[i + j] = nums[i + j + 1];
                nums[i + j + 1] = a;
            }
        }
    }

    public static void swap(int[] nums, int endIndex, int size) {
        int a;
        for (int i = 0; i < size; i++) {
            a = nums[endIndex - i];
            nums[endIndex - i] = nums[endIndex - size - i];
            nums[endIndex - size - i] = a;
        }
    }

    public static void function2(int[] nums, int k) {
        int length = nums.length;
        int[] newArray = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[(k + i) % length] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, length);
    }

    public static void function3(int[] nums, int k) {
        int length = nums.length;
        int pre, next, x;
        int count = 0;
        for (int i = 0; i < k % length; i++) {
            x = i;
            pre = nums[x];
            do {
                if (count == length) {
                    return;
                }
                next = nums[(k + x) % length];
                nums[(k + x) % length] = pre;
                pre = next;
                x = (k + x) % length;
                count++;
            } while (x != i);
        }
    }

    @Test
    void test_1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        function3(nums, 3);
        int[] exceptedNums = {5, 6, 7, 1, 2, 3, 4};
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(exceptedNums[i], nums[i]);
        }
    }

    @Test
    void test_2() {
        int[] nums = {1, 2, 3, 4};
        bubble(nums, 2);
        int[] exceptedNums = {3, 4, 1, 2};
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(exceptedNums[i], nums[i]);
        }
    }

    @Test
    void test_3() {
        int[] nums = {1, 2};
        bubble(nums, 2);
        int[] exceptedNums = {1, 2};
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(exceptedNums[i], nums[i]);
        }
    }
}
