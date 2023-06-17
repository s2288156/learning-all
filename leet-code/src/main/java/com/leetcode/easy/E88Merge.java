package com.leetcode.easy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leetcode.utils.JacksonUtils;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu.Chunyang
 */
public class E88Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        run(nums1, m, nums2, n);
    }

    private void run(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums2[j] >= nums1[i]) {
                    nums1[i + j + 1] = nums2[j];
                    n--;
                } else {
                    nums1[i + j + 1] = nums1[i];
                    break;
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{\"num1\":[1,2,3,0,0,0],\"m\":3,\"n\":3,\"num2\":[2,5,6],\"expectedNum\":[1,2,2,3,5,6]}",
            "{\"num1\":[0],\"m\":0,\"n\":1,\"num2\":[1],\"expectedNum\":[1]}",
            "{\"num1\":[1],\"m\":1,\"n\":0,\"num2\":[],\"expectedNum\":[1]}",
    })
    void test_case(String paramObjects) throws JsonProcessingException {
        MergeParam mergeParam = JacksonUtils.getObjectMapper().readValue(paramObjects, MergeParam.class);
        int[] num1 = mergeParam.getNum1();
        int m = mergeParam.getM();
        int[] num2 = mergeParam.getNum2();
        int n = mergeParam.getN();
        int[] expectedNum = mergeParam.getExpectedNum();
        E88Merge solution = new E88Merge();
        solution.merge(num1, m, num2, n);
        Assertions.assertEquals(expectedNum.length, num1.length);
        for (int i = 0; i < expectedNum.length; i++) {
            Assertions.assertEquals(expectedNum[i], num1[i]);
        }
    }

    @Data
    static class MergeParam {
        int[] num1;
        int m;
        int[] num2;
        int n;
        int[] expectedNum;
    }
}
