package com.leetcode.algoithm.search;

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

        int[] suffix = new int[searchLength];
        boolean[] prefix = new boolean[searchLength];

        // 构建好后缀数组suffix和prefix
        goodSuffix(searchStrChars, searchLength, suffix, prefix);

        // 构建坏字符串哈希表，数组下标为字符ascii，value为字符对应的位置
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
            // 坏字符串规则滑动距离
            int badCharacterRuleMv = j - bc[strChars[i + j]];
            int gsRuleMv = 0;
            // 如果字符串存在好后缀
            if (j < searchLength - 1) {
                gsRuleMv = moveByGs(j, searchLength, suffix, prefix);
            }
            i = i + Math.max(badCharacterRuleMv, gsRuleMv);
        }
        return -1;

    }

    /**
     * @param j            坏字符串位置
     * @param searchLength 模式串
     */
    private int moveByGs(int j, int searchLength, int[] suffix, boolean[] prefix) {
        int goodSuffixLength = searchLength - j - 1;
        // 匹配好后缀
        if (suffix[goodSuffixLength] != -1) {
            return searchLength - suffix[goodSuffixLength] + 1;
        }
        // 匹配好后缀子串
        for (int r = j + 2; r <= searchLength - 1; r++) {
            if (prefix[searchLength - r]) {
                return r;
            }
        }
        // 没有匹配值
        return searchLength;
    }

    /**
     * 前缀子串：abcd的前缀子串有（a / ab / abc）
     * 后缀子串：abcd的后缀子串有（d / cd / bcd）
     * 好后缀滑动规则：
     * 1. 模式串中的匹配的必须是前缀子串
     *
     * @param searchStrChars 模式串字符
     * @param searchLength   模式串长度
     * @param suffix         后缀子集，下标k为好后缀子串的长度，对应的value值为：此长度的后缀子串与模式串中匹配的字符，模式串中的下标，如果没有匹配则为-1
     * @param prefix         前缀子集，好后缀最少也是2个字符，所以可匹配的前缀下标范围为(0,searchLength - 2)，如果suffix[k]=0，则prefix=true
     */
    private void goodSuffix(char[] searchStrChars, int searchLength, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < searchLength; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < searchLength - 1; i++) {
            // 模式串前缀子串的最后一位字符index
            int leftIndex = i;
            // 公共后缀子串的长度
            int suffixLength = 0;
            while (leftIndex >= 0 && searchStrChars[leftIndex] == searchStrChars[searchLength - 1 - suffixLength]) {
                leftIndex--;
                suffixLength++;
                // TODO: 2021/7/2 suffix数据构建有问题，待解决
                suffix[suffixLength] = leftIndex + 1;
            }
            if (leftIndex == -1) {
                prefix[suffixLength] = true;
            }
        }

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
