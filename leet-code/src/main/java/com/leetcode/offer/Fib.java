package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author Wu.Chunyang
 */
public class Fib {

    private Integer[] cache = new Integer[101];

    public int fib(int n) {
        // return recur(n);
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    int recur(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (cache[n] == null) {
            cache[n] = recur(n - 2) + recur(n - 1);
        }
        return cache[n] % 1000000007;
    }

    @Test
    void test_case1() {
        Fib fib = new Fib();
        Assertions.assertEquals(807526948, fib.fib(48));
        Assertions.assertEquals(2, fib.fib(3));
        Assertions.assertEquals(3, fib.fib(4));
        Assertions.assertEquals(5, fib.fib(5));
    }

}
