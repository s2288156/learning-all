package com.leetcode.midium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Wu.Chunyang
 */
public class M122MaxProfit {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0], sell = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= sell) {
                sell = prices[i];
            } else {
                if (sell - buy > 0) {
                    maxProfit += sell - buy;
                }
                buy = sell = prices[i];
            }
        }
        if (sell - buy <= 0) {
            return maxProfit;
        }
        return maxProfit + sell - buy;
    }

    @Test
    void test_1() {
        int[] prices1 = {2, 6, 4, 9};
        int[] prices2 = {4, 3, 2, 1};
        int[] prices3 = {1, 2, 2, 2, 2};
        int[] prices4 = {2, 6, 9, 4, 6, 3, 2};
        int[] prices5 = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(9, maxProfit(prices1));
        Assertions.assertEquals(0, maxProfit(prices2));
        Assertions.assertEquals(1, maxProfit(prices3));
        Assertions.assertEquals(9, maxProfit(prices4));
        Assertions.assertEquals(7, maxProfit(prices5));
    }
}
