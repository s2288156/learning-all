package com.learning.algoithm.sort;

/**
 * @author wcy
 */
public class BubbleSort implements Sort<Integer> {

    private final Integer[] elements;

    public BubbleSort(Integer[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer[] sort() {
        int length = elements.length;
        for (int i = 0; i < length - 1; i++) {
            int index = 0;
            for (int j = 0; j < length - i - 1; j++) {
                // 当前大于下一位，则互换位置，继续向后比较
                if (elements[index] > elements[index + 1]) {
                    Integer temp = elements[index];
                    elements[index] = elements[index + 1];
                    elements[index + 1] = temp;
                }
                // 当前小于或等于下一位，从下一位开始往后比较
                index++;
            }
        }
        return elements;
    }
}
