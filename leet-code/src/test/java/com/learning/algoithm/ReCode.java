package com.learning.algoithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wcy
 */
@Slf4j
public class ReCode {

    @Test
    void recodeSort() {
        Integer[] integers = new Integer[]{3, 7, 2, 1, 4, 8, 9, 8, 5, 6, 0};
        int length = integers.length;
        mergeSort(integers, 0, length - 1);
        log.info("{}", Arrays.toString(integers));
    }

    private void mergeSort(Integer[] arrays, Integer start, Integer end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(arrays, start, mid);
        mergeSort(arrays, mid + 1, end);
        handleSort(arrays, start, mid, end);
    }

    private void handleSort(Integer[] arrays, Integer start, Integer mid, Integer end) {
        int tempLength = end - start + 1;
        Integer[] temps = new Integer[tempLength];
        int tempIndex = 0;
        // p ~ q 为左半部分待合并数组，可能是单个元素或多个元素数组
        int p = start;
        int q = mid;
        // i ~ j 为右半部分待合并数组，可能是单个元素或多个元素数组
        int i = mid + 1;
        int j = end;
        while (p <= q && i <= j) {
            if (arrays[p] <= arrays[i]) {
                temps[tempIndex++] = arrays[p++];
            } else {
                temps[tempIndex++] = arrays[i++];
            }
        }

        while (p <= q) {
            temps[tempIndex++] = arrays[p++];
        }

        while (i <= j) {
            temps[tempIndex++] = arrays[i++];
        }

        System.arraycopy(temps, 0, arrays, start, tempLength);
    }
}
