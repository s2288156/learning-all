package com.learning.algoithm;

/**
 * @author wcy
 */
public class Bsearch {

    public static void main(String[] args) {
        Integer[] strArrs = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Bsearch bsearch = new Bsearch(strArrs);
        Integer item = 7;

        System.out.println(bsearch.searchIndex(item));

    }

    private Integer[] datas;

    public Bsearch(Integer[] datas) {
        this.datas = datas;
    }

    public int searchIndex(Integer item) {
        return searchForArrays(item, 0, datas.length - 1);
    }

    private int searchForArrays(Integer item, int start, int end) {
        int mid = (start + end) / 2;
        if (item.equals(datas[mid])) {
            return mid;
        } else if (item < datas[mid]) {
            return searchForArrays(item, start, mid - 1);
        } else {
            return searchForArrays(item, mid + 1, end);
        }
    }
}
