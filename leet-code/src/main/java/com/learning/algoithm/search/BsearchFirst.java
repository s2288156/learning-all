package com.learning.algoithm.search;

/**
 * @author wcy
 */
public class BsearchFirst {

    public int bsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

}
