package com.learning.algoithm.sort;

/**
 * @author wcy
 */
public class BubbleSort<E> implements Sort<E> {

    private final Object[] elements;

    public BubbleSort(E[] elements) {
        this.elements = elements;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] asc() {
        return (E[]) elements;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] desc() {
        return (E[]) elements;
    }
}
