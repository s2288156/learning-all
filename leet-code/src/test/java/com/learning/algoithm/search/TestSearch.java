package com.learning.algoithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        BsearchPro bsearchPro = new BsearchPro();
        int i = bsearchPro.searchFirst(ints, item);
        System.out.println(i);
        assertEquals(i, 7);
    }

    @Test
    void testBsearchLast() {
        BsearchPro bsearchPro = new BsearchPro();
        int i = bsearchPro.searchLast(ints, item);
        System.out.println(i);
        assertEquals(i, 10);
    }
}
