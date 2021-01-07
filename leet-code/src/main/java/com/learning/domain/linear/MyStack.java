package com.learning.domain.linear;

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

    public void add(E e) {
        if (length < capacity) {
            elements[length++] = e;
        }
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
