package com.learning.algoithm.search;

/**
 * @author wcy
 */
public interface StringSearch {
    /**
     * 搜索模式串所在位置，如果不存在，则返回-1
     *
     * @param str 带搜索的斯字符串
     */
    int searchIndex(String str, String searchStr);

    int count(String str, String searchStr);
}
