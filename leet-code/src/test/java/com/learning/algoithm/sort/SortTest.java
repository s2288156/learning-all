package com.learning.algoithm.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wcy
 */
class SortTest {
    Integer[] integers;

    @BeforeEach
    void setUp() {
        integers = new Integer[]{3, 7, 2, 1, 4, 9, 8, 5, 6, 0};
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
        System.out.println(Arrays.toString(sort));
    }

    @Test
    void insertSortTest() {
        InsertSort insertSort = new InsertSort(integers);
        Integer[] sort = insertSort.sort();
        assertSort(sort);
    }
}