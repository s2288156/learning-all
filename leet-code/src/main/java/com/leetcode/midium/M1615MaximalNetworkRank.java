package com.leetcode.midium;

/**
 * 1615. 最大网络秩
 *
 * @author Wu.Chunyang
 */
public class M1615MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        return run(n, roads);
    }

    private static int run(int n, int[][] roads) {
        boolean[][] map = new boolean[n][n];
        int[] counter = new int[n];
        for (int[] road : roads) {
            map[road[0]][road[1]] = true;
            map[road[1]][road[0]] = true;
            counter[road[0]]++;
            counter[road[1]]++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = counter[i] + counter[j] - (map[i][j] ? 1 : 0);
                max = Math.max(temp, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        run(8, null);
    }
}
