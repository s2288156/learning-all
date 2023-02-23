package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * @author Wu.Chunyang
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        // return defaultExe(prices);
        return dp(prices);
    }

    private int dp(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }

    private static int defaultExe(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int head = 0, tail = 1, max = 0;
        while (head < prices.length -1 ) {
            if (prices[head] <= prices[tail]) {
                // tail++
                max = Math.max(max, prices[tail] - prices[head]);
                tail++;
            } else {
                // 不可能盈利，则head后移1?位，tail复位到head后
                head++;
                tail = head + 1;
            }
            if (tail == prices.length) {
                // 不可能盈利，则head后移1?位，tail复位到head后
                head++;
                tail = head + 1;
            }
        }
        return max;
    }

    @Test
    void test_case1() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, maxProfit.maxProfit(prices));
    }

    @Test
    void test_case2() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{7, 6, 4, 3, 1};
        Assertions.assertEquals(0, maxProfit.maxProfit(prices));
    }
}
