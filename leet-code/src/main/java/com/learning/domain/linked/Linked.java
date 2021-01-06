package com.learning.domain.linked;

/**
 * @author wcy
 */
public interface Linked<E> {

    /**
     * 链表拼接合并
     *
     * @param linked l
     * @return r
     */
    Linked<E> append(Linked<E> linked);
}
