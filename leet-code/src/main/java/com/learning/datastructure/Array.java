package com.learning.datastructure;

import lombok.val;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author wcy
 */
public class Array {
    public static final Integer nums = 10000000;

    public static void main(String[] args) {
        goodList();
        badList();
    }

    public static void goodList() {
        LocalDateTime start = LocalDateTime.now();
        ArrayList<Integer> objects = new ArrayList<>(nums);
        for (int i = 0; i < nums; i++) {
            objects.add(i);
        }
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(start, end);
        System.out.println("goodList >>>> " + between.getNano());
    }

    public static void badList() {
        LocalDateTime start = LocalDateTime.now();
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            objects.add(i);
        }
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(start, end);
        System.out.println("badList >>>>> " + between.getNano());
    }
}
