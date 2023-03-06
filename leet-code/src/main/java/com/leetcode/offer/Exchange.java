package com.leetcode.offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 *
 * @author Wu.Chunyang
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int i = 0, j = nums.length - 1;
        while (i != j) {
            if (nums[i] % 2 == 1) {
                i++;
            } else {
                if (nums[j] % 2 == 1) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i++] = temp;
                } else {
                    j--;
                }
            }
        }
        return nums;
        // return firstImpl(nums);
    }
    private static int[] firstImpl(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return nums;
        }
        int oddNum = -1, evenNum = -1;
        for (int num : nums) {
            if (num % 2 == 1) {
                // is odd num
                evenNum++;
                oddNum++;
                int temp = nums[oddNum];
                nums[oddNum] = nums[evenNum];
                nums[evenNum] = temp;
            } else {
                // is even num
                evenNum = evenNum == -1 ? oddNum + 1 : evenNum + 1;
            }
        }
        return nums;
    }
}
