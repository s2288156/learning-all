package com.learning.algoithm.sort;

/**
 * @author wcy
 */
public class MergeSort implements Sort<Integer> {
    private Integer[] elements;

    public MergeSort(Integer[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer[] sort() {
        int start = 0;
        int end = elements.length - 1;
        mergeSort(elements, start, end);
        return elements;
    }

    public void mergeSort(Integer[] arrays, int start, int end) {
        // 终止条件
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arrays, start, mid);
        mergeSort(arrays, mid + 1, end);
        merge(arrays, start, mid, end);
    }

    public void merge(Integer[] arrays, int start, int mid, int end) {
        Integer[] temp = new Integer[end - start + 1];
        int i = 0;
        int p = start;
        int q = mid + 1;
        while (p <= mid && q <= end) {
            if (arrays[p] < arrays[q]) {
                temp[i++] = arrays[p++];
            } else {
                temp[i++] = arrays[q++];
            }
        }

        while (p <= mid) {
            temp[i++] = arrays[p++];
        }

        while (q <= end) {
            temp[i++] = arrays[q++];
        }

        for (int k = 0; k < i; k++) {
            arrays[start + k] = temp[k];
        }
//        System.arraycopy(temp, 0, arrays, start, temp.length);
    }

}
