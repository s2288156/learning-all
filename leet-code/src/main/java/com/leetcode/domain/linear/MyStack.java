package com.leetcode.domain.linear;

import java.util.Arrays;

/**
 * @author wcy
 */
public class MyStack<E> {

    private Object[] elements;

    private int length;

    private int capacity;

    public MyStack() {
        this(10);
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.length = 0;
    }

    public void push(E e) {
        if (length < capacity) {
            elements[length++] = e;
            return;
        }
        capacity *= 2;
        elements = Arrays.copyOf(elements, capacity);
        elements[length++] = e;
    }

    public E pop() {
        Object result;
        if (length == 0) {
            return null;
        }
        result = elements[length - 1];
        elements[length - 1] = null;
        length--;
        return (E) result;
    }

    public int length() {
        return this.length;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
