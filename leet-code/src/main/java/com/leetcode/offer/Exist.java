package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * <a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=jhszt8h">...</a>
 *
 * @author Wu.Chunyang
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (compareNext(word, 0, i, j, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean compareNext(String word, int index, int m, int n, char[][] board) {
        if (m < 0 || n < 0 || m > board.length - 1 || n > board[0].length - 1 || board[m][n] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        board[m][n] = '\0';
        boolean resp = compareNext(word, index + 1, m + 1, n, board)
                || compareNext(word, index + 1, m - 1, n, board)
                || compareNext(word, index + 1, m, n + 1, board)
                || compareNext(word, index + 1, m, n - 1, board);
        board[m][n] = word.charAt(index);
        return resp;
    }

    /**
     * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
     * "SEE"
     */
    @Test
    void test_case1() {
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        Assertions.assertTrue(new Exist().exist(board, "see"));
    }

}
