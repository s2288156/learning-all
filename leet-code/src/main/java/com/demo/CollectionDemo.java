package com.demo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Wu.Chunyang
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<String> l1 = List.of("a", "b", "c", "d", "e", "f", "g");
        Queue<String> q1 = new ArrayDeque<>();

        System.out.println(q1);
    }
}
