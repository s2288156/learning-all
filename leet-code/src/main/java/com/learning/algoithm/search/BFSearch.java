package com.learning.algoithm.search;

import lombok.extern.slf4j.Slf4j;

/**
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
        int loopNum = strLength - searchStrLength + 1;
        for (int i = 0; i <= loopNum; i++) {
            for (int j = 0; j < searchStrLength; j++) {
                if (strBytes[i + j] != searchStrBytes[j]) {
                    break;
                }
                if (j == (searchStrLength - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 3 && j == 4) {
                    continue;
                }
                log.info("i = {} , j = {}", i, j);
            }
        }
    }

    @Override
    public int count(String str, String searchStr) {
        return 0;
    }

}
