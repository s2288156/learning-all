package com.learning.datastructure;

import com.learning.domain.linear.MyStack;

/**
 * @author wcy
 */
public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        intStack.add(3);
        intStack.add(5);
        intStack.add(7);
        System.out.println(intStack);
        System.out.println(intStack.length());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack);
        System.out.println(intStack.length());
        System.out.println(intStack.pop());
    }
}
