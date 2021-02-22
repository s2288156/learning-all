package com.learning.algoithm.sort;

/**
 * 选择排序（原地排序算法）：
 * <p>1. 分为已排序和未排序区
 * <p>2. 首先从未排序区第一个元素开始，与后面的所有元素依次比较，找出最小元素
 * <p>3. 如果最小元素就是未排序区的首位，则将此元素作为已排序区的最后一位，进行下一轮比较
 * <p>4. 如果最小元素不是未排序区的首位，则将最小元素与未排序区首位互换，作为已排序区的最后一位，进行下一轮比较，直至未排序区剩余最后一个元素
 *
 * @author wcy
 */
public class SelectSort implements Sort<Integer> {

    private Integer[] elements;

    public SelectSort(Integer[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer[] sort() {
        for (int unSortIndex = 0; unSortIndex < elements.length - 1; unSortIndex++) {
            int min = elements[unSortIndex];
            int minIndex = unSortIndex;
            for (int j = unSortIndex + 1; j < elements.length; j++) {
                if (elements[j] < min) {
                    min = elements[j];
                    minIndex = j;
                }
            }
            // 如果相等，则说明未排序区首位元素已经是最小值，不需要交换位置
            if (minIndex != unSortIndex) {
                elements[minIndex] = elements[unSortIndex];
                elements[unSortIndex] = min;
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        int index = 0;
        int len = 5;
        for (int i = 0; i < len - 1; i++) {
            for (int j = index + 1; j < len; j++) {
                System.out.printf("i = %s, j = %s%n", i, j);
            }
            index++;
        }
    }
}
