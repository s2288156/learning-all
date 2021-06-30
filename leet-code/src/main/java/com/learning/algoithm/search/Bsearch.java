package com.learning.algoithm.search;

/**
 * 二分查找
 *
 * @author wcy
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] strArrs = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9};
        Bsearch bsearch = new Bsearch(strArrs);
        Integer item = 7;

        System.out.println(bsearch.searchIndex(item));

    }

    private int[] datas;

    public Bsearch(int[] datas) {
        this.datas = datas;
    }

    public int searchIndex(int item) {
        return searchForArrays(item, 0, datas.length - 1);
    }

    private int searchForArrays(int item, int start, int end) {
        int mid = (start + end) / 2;
        if (item == datas[mid]) {
            return mid;
        } else if (item < datas[mid]) {
            return searchForArrays(item, start, mid - 1);
        } else {
            return searchForArrays(item, mid + 1, end);
        }
    }
}
