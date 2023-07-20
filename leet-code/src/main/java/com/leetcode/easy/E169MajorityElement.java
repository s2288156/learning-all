package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wu.Chunyang
 */
public class E169MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        AtomicInteger max = new AtomicInteger();
        counter.forEach((k,v) -> {
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
