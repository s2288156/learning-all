package com.demo.multithread;

import lombok.SneakyThrows;

/**
 * @author wuyang
 */
public class ThreadDemoMain {
//     public static void main(String[] args) {
//         ThreadDemoMain main = new ThreadDemoMain();
// //        main.useYield();
// //        main.unSecurityCount();
//
//     }

    private int count = 0;

    @SneakyThrows
    private void unSecurityCount() {
        Runnable runnable = () -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                count++;
            }
        };
        for (int i = 0; i < 2; i++) {
            System.out.println("----" + i);
            new Thread(runnable).start();
        }

        Thread.sleep(2000);
        System.out.println(count);
    }

    private void useYield() {
        Runnable runnable = () -> {
            for (int i = 0; i < 51; i++) {
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        };
        Runnable yield = () -> {
            for (int i = 0; i < 51; i++) {
                if (i % 10 == 0) {
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        };

        new Thread(runnable, "老王").start();
        new Thread(yield, "小张@@@@@@@").start();
    }
}
