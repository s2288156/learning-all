package com.leetcode.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu.Chunyang
 */
public class M15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return way1(nums);
    }

    private static List<List<Integer>> way1(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int mid = 1, len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        while (mid < len - 1) {
            for (int i = 0; i < mid; i++) {
                if (i == 0 || nums[i - 1] != nums[i]) {
                    for (int j = mid + 1; j < len; j++) {
                        if (j == mid + 1 || nums[j - 1] != nums[j]) {
                            if (nums[i] + nums[mid] + nums[j] == 0) {
                                list.add(Arrays.asList(nums[i], nums[mid], nums[j]));
                            }
                        }
                    }
                }
            }
            mid++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        way1(nums);
    }

}
