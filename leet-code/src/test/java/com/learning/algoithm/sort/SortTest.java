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
        integers = new Integer[]{3, 7, 2, 1, 4, 8, 9, 8, 5, 6, 0};
        log.info("排序前: {}", Arrays.toString(integers));
    }

    @Test
    void bubbleSortTest() {
        BubbleSort bubbleSort = new BubbleSort(integers);
        Integer[] sort = bubbleSort.sort();
        assertSort(sort);
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

    @Test
    void insertSortTest() {
        InsertSort insertSort = new InsertSort(integers);
        Integer[] sort = insertSort.sort();
        assertSort(sort);
    }

    @Test
    void mergeSortTest() {
        Sort<Integer> mergeSort = new MergeSort(integers);
        Integer[] sort = mergeSort.sort();
        assertSort(sort);
    }

    @Test
    void selectSortTest() {
        Sort<Integer> selectSort = new SelectSort(integers);
        Integer[] sort = selectSort.sort();
        assertSort(sort);
    }

    @Test
    void quickSortTest() {
        Sort<Integer> quickSort = new QuickSort(integers);
        Integer[] sort = quickSort.sort();
        assertSort(sort);
    }
}