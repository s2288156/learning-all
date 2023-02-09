package com.leetcode.algoithm.sort;

/**
 * 将数组分为两个区，已排序区和未排序区。<br>
 * 1. 初始已排序区只有一个元素，即数组的第一个 <br>
 * 2. 从未排序区拿取一个元素，与已排序区元素比较，插入到合适的位置，保证已排序区始终有序 <br>
 * 可以通过程序，保证排序的稳定性
 *
 * @author wcy
 */
public class InsertSort implements Sort<Integer> {

    private Integer[] elements;

    public InsertSort(Integer[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer[] sort() {
        int sortedLength = 1;
        int unSortedLength = elements.length - 1;

        for (int i = 0; i < unSortedLength; i++) {
            // 未排序区的第一个元素
            Integer unSort = elements[sortedLength];
            // 与已排序元素比较
            for (int j = 0; j < sortedLength; j++) {
                // 1. 已排序区：如果unSort比所有的都大，则排在最后一位，直接完成本轮比对即可
                // 2. 已排序区：unSort小于此位数，则排在此位前
                if (unSort < elements[j]) {
                    rightMoveOnePlace(sortedLength, j, elements);
                    elements[j] = unSort;
                    break;
                }
                // 3. 已排序区：unSort大于此位数，则进行下一位数对比
            }
            sortedLength++;
        }

        return elements;
    }

    /**
     * 将数组从指定位置开始，向右移动1位
     *
     * @param endMoveElementIndex   结束移动的元素数量
     * @param startMoveElementIndex 开始移动的元素位置
     * @param elements                  待操作的数组
     */
    private void rightMoveOnePlace(int endMoveElementIndex, int startMoveElementIndex, Integer[] elements) {
        for (int k = 0; k < endMoveElementIndex - startMoveElementIndex; k++) {
            elements[endMoveElementIndex - k] = elements[endMoveElementIndex - k - 1];
        }
    }
}
