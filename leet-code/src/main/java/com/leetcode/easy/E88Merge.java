package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Wu.Chunyang
 */
public class E88Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int i = m; i < m + n; i++) {
            int value = nums2[i - m];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums1[j] > value) {
                    nums1[j + 1] = nums1[j];
                } else {
                    break;
                }
            }
            nums1[j + 1] = value;
        }
    }

    @Test
    void test_case1() {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
        int n = 3;
        E88Merge solution = new E88Merge();
        solution.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
    @Test
    void test_case2() {
        int[] num1 = {0};
        int m = 0;
        int[] num2 = {1};
        int n = 1;
        E88Merge solution = new E88Merge();
        solution.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
}
