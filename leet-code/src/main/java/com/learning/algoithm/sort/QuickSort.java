package com.learning.algoithm.sort;

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
        int i = p;
        for (int j = p; j < r; j++) {
            if (array[j] < pivot) {
                swapArray(array, i, j);
                i++;
            }
        }
        swapArray(array, i, r);
        return i;
    }

    private void swapArray(Integer[] srcArray, int sourceIndex, int targetIndex) {
        int temp = srcArray[targetIndex];
        srcArray[targetIndex] = srcArray[sourceIndex];
        srcArray[sourceIndex] = temp;
    }
}
