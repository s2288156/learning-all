package com.learning.easy;

import java.util.PriorityQueue;

/**
 * @author wcy
 */
public class E1046LastStoneWeight {
    public static void main(String[] args) {
        E1046LastStoneWeight main = new E1046LastStoneWeight();
//        main.run(stones);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        queue.offer(40);
        queue.offer(4);
        queue.offer(1);
        queue.offer(20);
        queue.offer(3);
        queue.offer(5);
        int size = queue.size();
        System.out.println(size);
        for (int i = 0; i < size ; i++) {
            System.out.println(queue);
        }

//        System.out.println(queue);
    }

    public int run(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();

            if (a > b) {
                queue.offer(a - b);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }

}
