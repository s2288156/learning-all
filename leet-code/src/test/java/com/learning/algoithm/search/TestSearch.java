package com.learning.algoithm.search;

import org.junit.jupiter.api.Test;

/**
 * @author wcy
 */
public class TestSearch {
    int[] ints = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9};
    Integer item = 7;

    @Test
    void testBesearch() {
        Bsearch bsearch = new Bsearch(ints);
        System.out.println(bsearch.searchIndex(item));
    }

    @Test
    void testBsearchFirst() {
        BsearchFirst bsearchFirst = new BsearchFirst();
        int bsearch = bsearchFirst.bsearch(ints, item);
        System.out.println(bsearch);
    }
}
