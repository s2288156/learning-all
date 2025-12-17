package com.demo.ads;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Wu.Chunyang
 */
public class PlcAdsDemo {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> queue = new ConcurrentLinkedDeque<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue.pollLast());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        // System.out.println(queue.poll());
        queue.clear();
        System.out.println("size:" + queue.size());
    }
}
