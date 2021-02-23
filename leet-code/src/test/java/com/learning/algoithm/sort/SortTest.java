package com.learning.algoithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
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

    Sort<Integer> sort;

    @BeforeEach
    void setUp() {
        integers = new Integer[]{3, 7, 2, 1, 4, 8, 9, 8, 5, 6, 0};
        log.info("排序前: {}", Arrays.toString(integers));
    }

    @AfterEach
    void tearDown() {
        assertSort(sort.sort());
    }

    @Test
    void bubbleSortTest() {
        sort = new BubbleSort(integers);
    }

    @Test
    void insertSortTest() {
        sort = new InsertSort(integers);
    }

    @Test
    void mergeSortTest() {
        sort = new MergeSort(integers);
    }

    @Test
    void selectSortTest() {
        sort = new SelectSort(integers);
    }

    @Test
    void quickSortTest() {
        sort = new QuickSort(integers);
    }

    private void assertSort(Integer[] sort) {
        log.info("排序后: {}", Arrays.toString(sort));
        assertAll(
                () -> assertEquals(integers.length, sort.length),
                () -> assertEquals(0, sort[0]),
                () -> assertEquals(9, sort[sort.length - 1]),
                () -> assertEquals(1, sort[1]),
                () -> assertEquals(2, sort[2]),
                () -> assertEquals(3, sort[3]),
                () -> assertEquals(4, sort[4]),
                () -> assertEquals(5, sort[5]),
                () -> assertEquals(6, sort[6]),
                () -> assertEquals(7, sort[7]),
                () -> assertEquals(8, sort[8]),
                () -> assertEquals(8, sort[9])
        );
    }
}