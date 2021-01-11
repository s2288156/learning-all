package com.learning.datastructure;

import com.learning.domain.linear.MyStack;

/**
 * @author wcy
 */
public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        for (int i = 0; i < 21; i++) {
            intStack.push(i);
        }
        System.out.println(intStack);
    }
}
