package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @author Wu.Chunyang
 */
public class Offer_09 {

    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public Offer_09() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.add(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.add(inStack.pop());
            }
        }
        return outStack.pop();
    }


    @Test
    public void test_case1() {
        Offer_09 offer09 = new Offer_09();
        offer09.appendTail(3);
        Assertions.assertEquals(3, offer09.deleteHead());
        Assertions.assertEquals(-1, offer09.deleteHead());
        Assertions.assertEquals(-1, offer09.deleteHead());
    }

    @Test
    public void test_case2() {
        Offer_09 offer09 = new Offer_09();
        Assertions.assertEquals(-1, offer09.deleteHead());
        offer09.appendTail(5);
        offer09.appendTail(2);
        Assertions.assertEquals(5, offer09.deleteHead());
        Assertions.assertEquals(2, offer09.deleteHead());
    }

    @Test
    public void test_case3() {
        Offer_09 offer09 = new Offer_09();
        Assertions.assertEquals(-1, offer09.deleteHead());
        offer09.appendTail(5);
        offer09.appendTail(2);
        Assertions.assertEquals(5, offer09.deleteHead());
        offer09.appendTail(3);
        Assertions.assertEquals(2, offer09.deleteHead());
        Assertions.assertEquals(3, offer09.deleteHead());
    }
}
