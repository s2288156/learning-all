package com.leetcode.easy;

/**
 * @author Wu.Chunyang
 */
public class E121MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit_1(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
