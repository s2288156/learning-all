package com.learning.algoithm.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Brute Force 暴力算法
 *
 * @author wcy
 */
@Slf4j
public class BFSearch implements StringSearch {

    @Override
    public int searchIndex(String str, String searchStr) {
        int strLength = str.length();
        int searchStrLength = searchStr.length();
        if (strLength < searchStrLength) {
            return -1;
        }
        byte[] strBytes = str.getBytes();
        byte[] searchStrBytes = searchStr.getBytes();
        // searchStr字符串滑动次数
        int loopNum = strLength - searchStrLength + 1;

        for (int i = 0; i <= loopNum; i++) {
            for (int j = 0; j < searchStrLength; j++) {
                // 比较str字符是否等于searchStr字符，如果不相等，则跳过此轮比较，searchStr向后滑动一位
                if (strBytes[i + j] != searchStrBytes[j]) {
                    break;
                }
                // 如果 str字符 == searchStr字符，并且此字符串为searchStr的最后一位，则表示匹配成功，返回字符串位置，搜索完成
                if (j == (searchStrLength - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int count(String str, String searchStr) {
        int strLength = str.length();
        int searchStrLength = searchStr.length();
        int count = 0;
        if (strLength < searchStrLength) {
            return count;
        }
        byte[] strBytes = str.getBytes();
        byte[] searchStrBytes = searchStr.getBytes();
        int loopNum = strLength - searchStrLength + 1;

        for (int i = 0; i <= loopNum; i++) {
            for (int j = 0; j < searchStrLength; j++) {
                if (strBytes[i + j] != searchStrBytes[j]) {
                    break;
                }
                if (j == (searchStrLength - 1)) {
                    count++;
                }
            }
        }
        return count;
    }

}
