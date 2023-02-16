package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author Wu.Chunyang
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints.length == 0) {
                return false;
            }
            if (ints[0] == target) {
                return true;
            }
            if (ints[0] < target) {
                int left = 0;
                int right = ints.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (target < ints[mid]) {
                        right = mid - 1;
                    } else if (target > ints[mid]) {
                        left = mid + 1;
                    } else {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    @Test
    public void test_case1() {
        int[][] matrix = new int[][]{
                {}
        };
        FindNumberIn2DArray find = new FindNumberIn2DArray();
        Assertions.assertFalse(find.findNumberIn2DArray(matrix, 20));
    }

    @Test
    public void test_case2() {
        int[][] matrix = new int[][]{
                {1,3,5,19},
                {2,4,7,20},
                {3,6,9,22}
        };
        FindNumberIn2DArray find = new FindNumberIn2DArray();
        Assertions.assertFalse(find.findNumberIn2DArray(matrix, 25));
        Assertions.assertTrue(find.findNumberIn2DArray(matrix, 7));
    }
}
