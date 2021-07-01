package com.learning.algoithm.search;

import lombok.extern.slf4j.Slf4j;

/**
 * Boyer-Moore: 坏字符规则（bad character rule）、好后缀规则（good suffix shift）
 */
@Slf4j
public class BMSearch implements StringSearch {
    private static final int SIZE = 256;
    @Override
    public int searchIndex(String str, String searchStr) {
        char[] searchStrChars = searchStr.toCharArray();
        char[] strChars = str.toCharArray();
        int strLength = str.length();
        int searchLength = searchStr.length();

        int[] bc = generateBC(searchStrChars);
        // 初始主串对齐点
        int i = 0;
        while (i <= strLength - searchLength) {
            int j;
            for (j = searchLength - 1; j >= 0; j--) {
                if (strChars[i + j] != searchStrChars[j]) {
                    break;
                }
            }
            // 匹配成功，返回字符位置
            if (j < 0) {
                return i;
            }
            i = i + (j - bc[strChars[i+j]]);
        }
        return -1;
    }

    private int[] generateBC(char[] searchStrChars) {
        int[] bc = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < searchStrChars.length; i++) {
            int ascii = searchStrChars[i];
            bc[ascii] = i;
        }
        return bc;
    }

    @Override
    public int count(String str, String searchStr) {
        return 0;
    }
}
