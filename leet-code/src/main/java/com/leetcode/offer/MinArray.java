package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * @author Wu.Chunyang
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == numbers[right]) {
                if (mid == right) {
                    return numbers[mid];
                }
                right--;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                return numbers[mid];
            }
        }
        return -1;
    }

    @Test
    public void test_case1() {
        MinArray minArray = new MinArray();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        Assertions.assertEquals(1, minArray.minArray(nums));
        nums = new int[]{4, 4, 4, 1, 4, 4, 4};
        Assertions.assertEquals(1, minArray.minArray(nums));
    }
}
