package com.learning.algoithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wcy
 */
@Slf4j
class SortTest {
    Integer[] integers;

    @BeforeEach
    void setUp() {
        integers = new Integer[]{3, 7, 2, 1, 4, 9, 8, 5, 6, 0};
        log.info("排序前: {}", Arrays.toString(integers));
    }

    @Test
    void bubbleSortTest() {
        BubbleSort bubbleSort = new BubbleSort(integers);
        Integer[] sort = bubbleSort.sort();
        assertSort(sort);
    }

    private void assertSort(Integer[] sort) {
        assertAll(
                () -> assertEquals(integers.length, sort.length),
                () -> assertEquals(0, sort[0]),
                () -> assertEquals(9, sort[sort.length - 1])
        );
        log.info("排序后: {}", Arrays.toString(sort));
    }

    @Test
    void insertSortTest() {
        InsertSort insertSort = new InsertSort(integers);
        Integer[] sort = insertSort.sort();
        assertSort(sort);
    }
}