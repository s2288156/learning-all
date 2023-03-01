package com.leetcode.offer;

import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * @author Wu.Chunyang
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                if (m == 0 && n == 0) {
                    continue;
                } else if (m == 0) {
                    grid[m][n] = grid[m][n - 1] + grid[m][n];
                } else if (n == 0) {
                    grid[m][n] = grid[m - 1][n] + grid[m][n];
                } else {
                    grid[m][n] = Math.max(grid[m - 1][n], grid[m][n - 1]) + grid[m][n];
                }
            }
        }
        return grid[i - 1][j - 1];
    }

    @Test
    void test_case1() {
        int[][] grid = {
                {1, 2, 5},
                {3, 2, 1}
        };
        System.out.println(new MaxValue().maxValue(grid));
    }
}
