package com.learning.algoithm.sort;

/**
 * @author wcy
 */
public class SortTest {

    public static void main(String[] args) {
        testBubbleSort();
    }

    public static void testBubbleSort() {
        Integer[] elements = new Integer[]{4, 2, 6, 2, 1};
        Sort<Integer> bbSort = new BubbleSort<>(elements);
    }
}
