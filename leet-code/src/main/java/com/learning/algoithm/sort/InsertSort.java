package com.learning.algoithm.sort;

/**
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
            Integer unSort = elements[sortedLength];
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
     * @param sortedLength              已排序区的元素数量
     * @param fromStartMoveElementIndex 开始移动的元素位置
     * @param elements                  待操作的数组
     */
    private void rightMoveOnePlace(int sortedLength, int fromStartMoveElementIndex, Integer[] elements) {
        for (int k = 0; k < sortedLength - fromStartMoveElementIndex; k++) {
            elements[sortedLength - k] = elements[sortedLength - k - 1];
        }
    }

}
