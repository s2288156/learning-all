package com.leetcode.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author Wu.Chunyang
 */
public class Offer_30 {

    private Deque<Integer> inStack;
    private Deque<Integer> minStack;

    public Offer_30() {
        inStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        inStack.pop();
        minStack.pop();
    }

    public int top() {
        return inStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    @Test
    public void test_case1() {
        Offer_30 offer30 = new Offer_30();
        offer30.push(-10);
        offer30.push(14);
        offer30.min();
        offer30.min();
        offer30.push(-20);
        offer30.min();
        offer30.min();
        offer30.top();
        offer30.min();
        offer30.pop();
        offer30.push(10);
        offer30.push(-7);
        offer30.min();
        offer30.push(-7);
        offer30.pop();
        offer30.top();
        offer30.min();
        offer30.pop();
    }
}
