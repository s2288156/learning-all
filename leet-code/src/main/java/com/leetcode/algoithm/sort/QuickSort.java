package com.leetcode.algoithm.sort;

/**
 * @author wcy
 */
public class QuickSort implements Sort<Integer> {

    private Integer[] elements;

    public QuickSort(Integer[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer[] sort() {
        quickSort(elements, 0, elements.length - 1);
        return elements;
    }

    private void quickSort(Integer[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int mid = partition(array, p, r);
        quickSort(array, p, mid - 1);
        quickSort(array, mid + 1, r);
    }

    private int partition(Integer[] array, int p, int r) {
        int pivot = array[r];
        // i 为小于分区点元素的左侧数组index
        // j 为本次待遍历的元素数组index
        int i = p;
        for (int j = p; j < r; j++) {
            if (array[j] < pivot) {
                if (i != j) {
                    swapArray(array, i, j);
                }
                i++;
            }
        }
        swapArray(array, i, r);
        return i;
    }

    private void swapArray(Integer[] srcArray, int srcPos, int destPos) {
        int temp = srcArray[destPos];
        srcArray[destPos] = srcArray[srcPos];
        srcArray[srcPos] = temp;
    }
}
