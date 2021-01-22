package com.learning.algoithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class SortTest {

    @Test
    void bubbleSortTest() {
        Integer[] integers = {3, 7, 2, 1, 4, 9, 8, 6, 0};
        BubbleSort<Integer> bubbleSort = new BubbleSort<>(integers);
        Integer[] sort = bubbleSort.sort();

        assertAll(
                () -> assertEquals(integers.length, sort.length),
                () -> assertEquals(0, sort[0]),
                () -> assertEquals(9, sort[sort.length - 1])
        );

    }
}