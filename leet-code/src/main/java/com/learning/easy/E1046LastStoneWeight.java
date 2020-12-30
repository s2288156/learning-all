package com.learning.easy;

import java.util.Arrays;

/**
 * @author wcy
 */
public class E1046LastStoneWeight {
    public static void main(String[] args) {
        E1046LastStoneWeight main = new E1046LastStoneWeight();
        int[] stones = new int[]{1, 2, 3, 4, 5, 6};
//        main.run(stones);
    }

    public void run(int[] stones) {
        Integer first = null;
        Integer second = null;
        for (int i = 0; i < stones.length - 1; i++) {
            for (int stone : stones) {
                if (first == null) {
                    first = stone;
                } else if (second == null) {
                    if (stone > first) {
                        second = first;
                        first = stone;
                    } else {
                        second = stone;
                    }
                }

                if (stone > first) {
                    second = first;
                    first = stone;
                } else {
                    second = stone;
                }
            }
        }
    }
}
