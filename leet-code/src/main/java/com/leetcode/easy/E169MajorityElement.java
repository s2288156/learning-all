package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wu.Chunyang
 */
public class E169MajorityElement {
    public int majorityElement(int[] nums) {
        // return hashTable(nums);
        return vot(nums);
    }

    // 投票算法，由于众数大于n/2，则只会有众数最后会有投票保留
    private int vot(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    private int hashTable(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        AtomicInteger max = new AtomicInteger();
        counter.forEach((k, v) -> {
            if (max.get() == 0) {
                max.set(k);
            } else if (counter.get(max.get()) < v) {
                max.set(k);
            }
        });
        return max.get();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 5, 5, 5, 5};
        E169MajorityElement solution = new E169MajorityElement();
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }
}
