package com.learning.algoithm.sort;

/**
 * @author wcy
 */
public class InsertSort implements Sort<Integer>{

    private Integer[] elements;

    public InsertSort(Integer[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer[] sort() {
        return elements;
    }
}
